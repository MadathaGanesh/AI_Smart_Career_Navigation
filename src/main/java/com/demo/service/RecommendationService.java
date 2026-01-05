package com.demo.service;

import com.demo.dto.request.RecommendationRequest;
import com.demo.dto.response.RecommendationResponse;

//  Service interface responsible for generating learning roadmaps based on skill gap analysis.
public interface RecommendationService {
	
	// Generates a learning recommendation roadmap using the results of a skill analysis.
	RecommendationResponse generateRecommendation(RecommendationRequest request);

}
