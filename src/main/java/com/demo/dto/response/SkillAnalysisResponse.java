package com.demo.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillAnalysisResponse {
	
	private Long analysisId;
	
	private String matchedSkills;
	
	private String missingSkills;
	
	private Double matchPercentage;
	
	private LocalDateTime analyzedAt;

}
