package com.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "recommendations")
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String learningRoadmap;

    @Lob
    private String recommendedResources;
    
    private Double jobReadiness;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "skill_analysis_id", nullable = false)
    private SkillAnalysis skillAnalysis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setJobReadiness(Double jobReadiness) {
		this.jobReadiness = jobReadiness;
	}
	
	public Double getJobReadiness() {
		return jobReadiness;
	}

	public String getLearningRoadmap() {
		return learningRoadmap;
	}

	public void setLearningRoadmap(String learningRoadmap) {
		this.learningRoadmap = learningRoadmap;
	}

	public String getRecommendedResources() {
		return recommendedResources;
	}

	public void setRecommendedResources(String recommendedResources) {
		this.recommendedResources = recommendedResources;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public SkillAnalysis getSkillAnalysis() {
		return skillAnalysis;
	}

	public void setSkillAnalysis(SkillAnalysis skillAnalysis) {
		this.skillAnalysis = skillAnalysis;
	}
    
    
}

