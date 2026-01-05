package com.demo.service.Implementation;


import org.springframework.stereotype.Service;

import com.demo.dto.request.JobCreateRequest;
import com.demo.dto.response.JobResponse;
import com.demo.entity.JobDescription;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.exceptionHandling.BadRequest;
import com.demo.exceptionHandling.ResourceNotFoundException;
import com.demo.respository.JobDescriptionRepository;
import com.demo.respository.UserRepository;
import com.demo.service.AiService;
import com.demo.service.JobService;

import lombok.RequiredArgsConstructor;

// Implementation of JobService that handles job creation and AI-based skill extraction from job descriptions.
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{

	private final UserRepository userRepository;
	private final JobDescriptionRepository jobRepository;
	private final AiService aiService;


	@Override
	public JobResponse createJob(JobCreateRequest request) {

		User recruiter = userRepository.findById(request.getRecruiterId()).orElseThrow(()-> new ResourceNotFoundException("Recruiter not found..."));
		
		// Adding Validation : Only Recruiter can post a Job...
		if(recruiter.getRole() !=Role.RECRUITER) {
			throw new BadRequest("Only recruiter can post jobs .... ");
		}
		
	    String extractedSkills = aiService.extractSkills(request.getJobDescriptionText());
	    
	    JobDescription job = new JobDescription();
	    job.setUser(recruiter);
	    job.setExtractedSkills(extractedSkills);
	    job.setDescriptionText(request.getJobDescriptionText());
	    job.setJobTitle(Role.RECRUITER);
	    
	    JobDescription savedJob = jobRepository.save(job);
	    
	    JobResponse response = new JobResponse();
	    response.setJobId(savedJob.getId());
		response.setExtractedSkills(savedJob.getExtractedSkills());
	    response.setCreatedAt(savedJob.getCreatedAt());
	    
		return response;
	}
	
	
	
}


