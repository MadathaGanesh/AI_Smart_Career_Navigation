package com.demo.service.Implementation;


import org.springframework.stereotype.Service;
import com.demo.dto.request.ResumeUploadRequest;
import com.demo.dto.response.ResumeResponse;
import com.demo.entity.Resume;
import com.demo.entity.User;
import com.demo.exceptionHandling.ResourceNotFoundException;
import com.demo.respository.ResumeRepository;
import com.demo.respository.UserRepository;
import com.demo.service.AiService;
import com.demo.service.ResumeService;

import lombok.RequiredArgsConstructor;


// Implementation of ResumeService that handles resume upload and AI-based skill extraction.
@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService{
	
	private final UserRepository userRepository;
	
	private final ResumeRepository resumeRepository;
	
	private final AiService aiService;



	//  Uploads a resume for a user, extracts skills using AI, and saves the resume to the database.
	@Override
	public ResumeResponse uploadResume(ResumeUploadRequest request) {
		
		User user =  userRepository.findById(request.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User ID not found..."));
		
		String extractedSkills =  aiService.extractSkills(request.getResumeText());
		
		Resume resume = new Resume();
		resume.setUser(user);
		resume.setRawText(request.getResumeText());
		resume.setExtractedSkills(extractedSkills);
		resume.setUploadTime(resume.getUploadTime());
		
		Resume savedResume = resumeRepository.save(resume);
		
		return mapToResponse(savedResume);
	}



	@Override
	public ResumeResponse getResume(Long id) {
			Resume response = resumeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Resume not found..."));
		return mapToResponse(response);
	}
	
	private ResumeResponse mapToResponse(Resume resume) {
		ResumeResponse response = new ResumeResponse();
		response.setResumeId(resume.getId());
		response.setExtractedSkills(resume.getExtractedSkills());
		response.setUploadedAt(resume.getUploadTime());
		return response;
	}


	
}
