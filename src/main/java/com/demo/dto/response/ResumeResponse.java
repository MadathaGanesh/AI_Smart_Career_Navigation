package com.demo.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResumeResponse {
	
	private Long resumeId;
	private String extractedSkills;
	private LocalDateTime uploadedAt;

}


