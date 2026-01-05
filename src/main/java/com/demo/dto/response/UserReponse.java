package com.demo.dto.response;

import com.demo.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserReponse {
	private Long id;
	
	private String name;
	
	private String email;
	
	private Role role;
}
