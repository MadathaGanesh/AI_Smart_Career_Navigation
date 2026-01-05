package com.demo.service;

import com.demo.dto.request.ResumeUploadRequest;
import com.demo.dto.response.ResumeResponse;

// Service interface for handling resume-related operations.
public interface ResumeService {
	
	// Uploads a resume for a specific user and processes its content.
	ResumeResponse uploadResume(ResumeUploadRequest request);
	
	ResumeResponse getResume(Long id);
	

}
