package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.request.SkillAnalysisRequest;
import com.demo.dto.response.SkillAnalysisResponse;
import com.demo.service.SkillAnalysisService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/analysis")
@RequiredArgsConstructor
public class SkillAnalysisController {
	
	private SkillAnalysisService skillAnalysisService;
	
	@PostMapping
	public ResponseEntity<SkillAnalysisResponse> analyze( @RequestBody @Valid SkillAnalysisRequest request) {
			SkillAnalysisResponse response = skillAnalysisService.analyze(request);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}

}
