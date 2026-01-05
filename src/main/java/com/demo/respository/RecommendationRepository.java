package com.demo.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long>{

	Optional<Recommendation> findBySkillAnalysisId(Long analysisId);
}
