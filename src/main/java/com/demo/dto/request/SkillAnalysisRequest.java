package com.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkillAnalysisRequest {

	@NotNull(message = "ResumeId cannot be an empty value...")
	private Long resumeId;
	
	@NotNull(message = "JobID cannot be an empty value ...")
	private Long jobId;
}
