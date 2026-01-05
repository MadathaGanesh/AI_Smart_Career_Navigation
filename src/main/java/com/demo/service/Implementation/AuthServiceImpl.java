package com.demo.service.Implementation;

import org.springframework.stereotype.Service;
import com.demo.dto.request.LoginRequest;
import com.demo.dto.request.RegisterRequest;
import com.demo.dto.response.UserReponse;
import com.demo.entity.User;
import com.demo.exceptionHandling.BadRequest;
import com.demo.respository.UserRepository;
import com.demo.service.AuthService;

//Service implementation for authentication-related operations such as user registration and login.
@Service
public class AuthServiceImpl implements AuthService{


	private final UserRepository userRepository;
	
	public AuthServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	// Registers a new user in the system.
	@Override
	public UserReponse register(RegisterRequest request) {
		
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new BadRequest("Email already exists...");
		}
		
		User user = new User();
		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setRole(request.getRole());
		user.setPassword(request.getPassword());
		
		User savedUser = userRepository.save(user);
		
		return mapToReponse(savedUser);  // Save and return the new user
	}

	
	
	// Authenticates a user using email and password.
	@Override
	public UserReponse login(LoginRequest request) {

		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new BadRequest("invalid Credentials.."));
		
		if(!user.getPassword().equals(request.getPassword())) {
			throw new BadRequest("Invalid Credentials...");
		}
		
		return mapToReponse(user);  // Return authenticated user
	}
	
	
	private UserReponse mapToReponse(User user) {
		UserReponse response = new UserReponse();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setRole(user.getRole());
		return response;
	}
	

}
