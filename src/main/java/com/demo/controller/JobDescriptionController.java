package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.request.JobCreateRequest;
import com.demo.dto.response.JobResponse;
import com.demo.service.JobService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jobs")
public class JobDescriptionController {
	
	private JobService jobService;
	
	@PostMapping()
	public ResponseEntity<JobResponse> createJob(@RequestBody @Valid JobCreateRequest request) {
		JobResponse response = jobService.createJob(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
