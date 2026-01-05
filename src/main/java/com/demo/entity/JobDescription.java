package com.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

	
	@Entity
	@Setter
	@Getter
	@Table(name = "job_descriptions")
	public class JobDescription {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    private Role jobTitle;

	    @Lob
	    @Column(name = "description_text")
	    private String descriptionText;

	    @Lob
	    @Column(name = "extracted_skills")
	    private String extractedSkills;

	    @CreationTimestamp
	    @Column(updatable = false)
	    private LocalDateTime createdAt;

	    @ManyToOne
	    @JoinColumn(name = "recruiter_id", nullable = false)
	    private User user;

		public void setJobTitle(Role jobTitle) {
			this.jobTitle = jobTitle;
		}

		
	}	
	
	
	
	
