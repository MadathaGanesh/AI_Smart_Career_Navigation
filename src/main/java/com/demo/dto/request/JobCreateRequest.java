package com.demo.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobCreateRequest {

	@NotNull
	private Long recruiterId;
	
	@NotBlank
	private String jobDescriptionText;

	@NotBlank
	private String jobRole;
}



