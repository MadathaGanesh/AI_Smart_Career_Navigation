package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.request.ResumeUploadRequest;
import com.demo.dto.response.ResumeResponse;
import com.demo.service.ResumeService;
import com.demo.service.Implementation.ResumeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
	
	private final ResumeService resumeService;
	
	public ResumeController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	 @PostMapping("/upload")
	    public ResponseEntity<ResumeResponse> uploadResume(
	            @RequestBody @Valid ResumeUploadRequest request) {

	        ResumeResponse response = resumeService.uploadResume(request);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ResumeResponse> getResume(@PathVariable Long id) {

	        ResumeResponse response = resumeService.getResume(id);
	        return ResponseEntity.ok(response);

	    }
}
