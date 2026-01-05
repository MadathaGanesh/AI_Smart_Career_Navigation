package com.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "skill_analysis")
	public class SkillAnalysis {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Lob
	    private String matchedSkills;

	    @Lob
	    private String missingSkills;

	    private Double matchPercentage;

	    @UpdateTimestamp
	    private LocalDateTime analysisTime;

	    @ManyToOne
	    @JoinColumn(name = "resume_id", nullable = false)
	    private Resume resume;

	    @ManyToOne
	    @JoinColumn(name = "job_id", nullable = false)
	    private JobDescription jobDescription;

	    @OneToOne(mappedBy = "skillAnalysis", cascade = CascadeType.ALL)
	    private Recommendation recommendation;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMatchedSkills() {
			return matchedSkills;
		}

		public void setMatchedSkills(String matchedSkills) {
			this.matchedSkills = matchedSkills;
		}

		public String getMissingSkills() {
			return missingSkills;
		}

		public void setMissingSkills(String missingSkills) {
			this.missingSkills = missingSkills;
		}

		public Double getMatchPercentage() {
			return matchPercentage;
		}

		public void setMatchPercentage(Double matchPercentage) {
			this.matchPercentage = matchPercentage;
		}

		public LocalDateTime getAnalysisTime() {
			return analysisTime;
		}

		public void setAnalysisTime(LocalDateTime analysisTime) {
			this.analysisTime = analysisTime;
		}

		public Resume getResume() {
			return resume;
		}

		public void setResume(Resume resume) {
			this.resume = resume;
		}

		public JobDescription getJobDescription() {
			return jobDescription;
		}

		public void setJobDescription(JobDescription jobDescription) {
			this.jobDescription = jobDescription;
		}

		public Recommendation getRecommendation() {
			return recommendation;
		}

		public void setRecommendation(Recommendation recommendation) {
			this.recommendation = recommendation;
		}
	
	    
}

