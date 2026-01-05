package com.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.SkillAnalysis;

@Repository
public interface SkillAnalysisRepository extends JpaRepository<SkillAnalysis, Long>{
	
	List<SkillAnalysis> findByResumeId(Long resumeId);
	
	List<SkillAnalysis> findByJobDescriptionId(Long jobId);
}
