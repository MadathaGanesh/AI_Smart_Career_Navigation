package com.demo.service;

import java.util.List;

// Used for HuggingFace AI Communication
public interface AiService {
	
	// Extract Technical skills from resume text using AI
	String extractSkills(String text);
	
	public String generateRoadmap(String missingSkills);

}
