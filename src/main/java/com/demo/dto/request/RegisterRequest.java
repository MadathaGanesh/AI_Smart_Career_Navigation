package com.demo.dto.request;

import com.demo.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RegisterRequest {
	
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	private Role role;

}
