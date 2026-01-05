package com.demo.service;

import com.demo.dto.request.LoginRequest;
import com.demo.dto.request.RegisterRequest;
import com.demo.dto.response.UserReponse;
import com.demo.entity.User;

// For User Registration and Login
public interface AuthService {
	
	
	UserReponse register(RegisterRequest request);
	
	UserReponse login(LoginRequest request);

}



