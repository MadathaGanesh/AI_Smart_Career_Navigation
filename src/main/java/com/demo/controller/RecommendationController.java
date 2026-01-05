	package com.demo.controller;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import com.demo.dto.request.RecommendationRequest;
	import com.demo.dto.response.RecommendationResponse;
	import com.demo.service.RecommendationService;

	import jakarta.validation.Valid;
	import lombok.RequiredArgsConstructor;

	@RestController
	@RequestMapping("/api/recommendations")
	@RequiredArgsConstructor
	public class RecommendationController {

	    private final RecommendationService recommendationService;

	    @PostMapping
	    public ResponseEntity<RecommendationResponse> generateRecommendation(
	            @RequestBody @Valid RecommendationRequest request) {

	        RecommendationResponse response =
	                recommendationService.generateRecommendation(request);

	        return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body(response);
	    }

}
