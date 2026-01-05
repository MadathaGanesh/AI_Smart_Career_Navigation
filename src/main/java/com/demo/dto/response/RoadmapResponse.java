package com.demo.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoadmapResponse {
	
	private Long recommendationId;
	
	private String learningRoadmap;
	
	private	LocalDateTime createdAt;
	
	

}
