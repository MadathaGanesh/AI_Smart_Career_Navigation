package com.demo.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecommendationResponse {

	 private Long recommendationId;
	 
	 private String recommendedCourses;
	 
	 private String improvementSuggestions;
	 
	 private Double jobReadinessScore;
	    		
	 private LocalDateTime createdAt;
	
}
