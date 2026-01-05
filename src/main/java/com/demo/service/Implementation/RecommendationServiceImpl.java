package com.demo.service.Implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dto.request.RecommendationRequest;
import com.demo.dto.response.RecommendationResponse;
import com.demo.entity.Recommendation;
import com.demo.entity.SkillAnalysis;
import com.demo.exceptionHandling.ResourceNotFoundException;
import com.demo.respository.RecommendationRepository;
import com.demo.respository.SkillAnalysisRepository;
import com.demo.service.AiService;
import com.demo.service.RecommendationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final AiService aiService;
    private final SkillAnalysisRepository analysisRepository;
    private final RecommendationRepository recommendationRepository;

    @Override
    public RecommendationResponse generateRecommendation(RecommendationRequest request) {

        SkillAnalysis analysis = analysisRepository
                .findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Skill analysis not found"));

        List<String> missingSkills =
                Arrays.asList(analysis.getMissingSkills().split(","));

        // AI-based roadmap generation
        String roadmap = aiService.generateRoadmap(String.join(",", missingSkills));

        // Fallback (if AI fails or returns empty)
        if (roadmap == null || roadmap.isBlank()) {
            roadmap = generateSuggestions(missingSkills);
        }

        Recommendation recommendation = new Recommendation();
        recommendation.setSkillAnalysis(analysis);
        recommendation.setLearningRoadmap(roadmap);
        recommendation.setJobReadiness(analysis.getMatchPercentage());

        Recommendation saved = recommendationRepository.save(recommendation);

        RecommendationResponse response = new RecommendationResponse();
        response.setRecommendationId(saved.getId());
        response.setImprovementSuggestions(saved.getLearningRoadmap());
        response.setJobReadinessScore(saved.getJobReadiness());
        response.setCreatedAt(saved.getCreatedAt());

        return response;
    }

    private String generateSuggestions(List<String> missingSkills) {
        return missingSkills.stream()
                .map(skill -> "Practice projects and improve " + skill.trim())
                .reduce((a, b) -> a + "; " + b)
                .orElse("You are job ready");
    }
}

