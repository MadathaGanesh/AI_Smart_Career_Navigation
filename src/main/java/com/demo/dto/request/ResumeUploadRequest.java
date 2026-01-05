package com.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResumeUploadRequest {

	@NotNull
	private Long userId;
	
	@NotBlank
	private String resumeText;
}


