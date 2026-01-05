package com.demo.service;

import com.demo.dto.request.JobCreateRequest;
import com.demo.dto.response.JobResponse;

//  Service interface for handling job description operations. 
public interface JobService {
	
	// Creates a new job description for a recruiter.
	JobResponse createJob(JobCreateRequest request);

}



