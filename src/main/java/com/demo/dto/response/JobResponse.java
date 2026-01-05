package com.demo.dto.response;


import java.time.LocalDateTime;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobResponse {
	
	private Long jobId;
	private String extractedSkills;
	private LocalDateTime createdAt;

}


