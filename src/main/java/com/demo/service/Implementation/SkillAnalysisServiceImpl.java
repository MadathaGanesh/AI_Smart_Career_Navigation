package com.demo.service.Implementation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.dto.request.SkillAnalysisRequest;
import com.demo.dto.response.SkillAnalysisResponse;
import com.demo.entity.JobDescription;
import com.demo.entity.Resume;
import com.demo.entity.SkillAnalysis;
import com.demo.exceptionHandling.ResourceNotFoundException;
import com.demo.respository.JobDescriptionRepository;
import com.demo.respository.ResumeRepository;
import com.demo.respository.SkillAnalysisRepository;
import com.demo.service.SkillAnalysisService;

import lombok.RequiredArgsConstructor;

//  Service implementation that analyzes skills by comparing  extracted skills from a Resume with required skills from a Job Description.

@Service
@RequiredArgsConstructor
public class SkillAnalysisServiceImpl implements SkillAnalysisService{
	
    // Repository to fetch Resume data from the database
	private final ResumeRepository resumeRepository;
	
    // Repository to fetch JobDescription data from the database
	private final JobDescriptionRepository jobRepository;
	
    // Repository to fetch SkillAnalysis data from the database
	private final SkillAnalysisRepository skillAnalysisRepository;

	// Analyzes resume skills against job description skills and calculates matching skills, missing skills, and match percentage.
	@Override
	public SkillAnalysisResponse analyze(SkillAnalysisRequest request) {
		
        // Fetch resume by ID or throw exception if not found
		Resume resume = resumeRepository.findById(request.getResumeId()).orElseThrow(()-> new ResourceNotFoundException("ResumeId not found..." + request.getResumeId()));
		
		JobDescription job = jobRepository.findById(request.getJobId()).orElseThrow(()-> new ResourceNotFoundException("JobId not found .... "+ request.getJobId()));
		
		
	    // Convert extracted skills to sets (lowercase for consistency)
		Set<String> resumeSkills = extractSkillSet(resume.getExtractedSkills());
		
		
		Set<String> jobSkills = extractSkillSet(job.getExtractedSkills());
		
		
		// Finding the Matching skills by comparing Resume Skills with Job_Description_Skills using "retainAll() method".
		Set<String>  matchedSkills = new HashSet<String>(resumeSkills);
		matchedSkills.retainAll(jobSkills);
		
		
		// Finding Missing Skills ( Required and Based on Job JD not based on resume)
		Set<String> missingSkills = new HashSet<String>(jobSkills);
		missingSkills.removeAll(resumeSkills);
		
		 // Calculate match percentage
		 // If jobSkills is empty, avoid division by zero
		double matchPercentage = jobSkills.isEmpty() ? 0.0 : ((double)matchedSkills.size() / jobSkills.size())*100;
		
		// Create and populate SkillAnalysis entity
		SkillAnalysis analysis = new SkillAnalysis();
		analysis.setResume(resume);
		analysis.setJobDescription(job);
		analysis.setMissingSkills(String.join(", ", missingSkills));
		analysis.setMatchedSkills(String.join(", ", matchedSkills));
		analysis.setMatchPercentage(matchPercentage);
		
        // Save analysis result in the database
		 SkillAnalysis savedAnalysis= skillAnalysisRepository.save(analysis);
		 
	     // Prepare response DTO
		 SkillAnalysisResponse response = new SkillAnalysisResponse();
		 response.setMatchedSkills(savedAnalysis.getMatchedSkills());
		 response.setMissingSkills(savedAnalysis.getMissingSkills());
		 response.setMatchPercentage(savedAnalysis.getMatchPercentage());
		 response.setAnalyzedAt(savedAnalysis.getAnalysisTime());
		 response.setAnalysisId(savedAnalysis.getId());
		 
		return response;  //returning final response
	}
	
	private Set<String> extractSkillSet(String skillsText){
		Set<String> skills = new HashSet<>();
		
		if(skillsText != null) {
			for(String skill : skillsText.split(",")) {
				skills.add(skill.trim().toLowerCase());
			}
		}
		
		return skills;
	}

}
