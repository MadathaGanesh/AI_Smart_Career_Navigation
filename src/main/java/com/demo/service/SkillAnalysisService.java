package com.demo.service;

import com.demo.dto.request.SkillAnalysisRequest;
import com.demo.dto.response.SkillAnalysisResponse;

// Service interface for performing skill analysis between  a resume and a job description.
public interface SkillAnalysisService {
	
	SkillAnalysisResponse analyze(SkillAnalysisRequest request);
}
