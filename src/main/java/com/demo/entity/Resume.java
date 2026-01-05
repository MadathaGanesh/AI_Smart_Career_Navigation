package com.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	
	@Entity
	@Table(name = "resumes")
	public class Resume {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String fileName;
	    
	    private String fileType;

	    @Lob
	    private String rawText;

	    @Lob
	    private String extractedSkills;

	    @CreationTimestamp
	    private LocalDateTime uploadTime;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public String getRawText() {
			return rawText;
		}

		public void setRawText(String rawText) {
			this.rawText = rawText;
		}

		public String getExtractedSkills() {
			return extractedSkills;
		}

		public void setExtractedSkills(String extractedSkills) {
			this.extractedSkills = extractedSkills;
		}

		public LocalDateTime getUploadTime() {
			return uploadTime;
		}

		public void setUploadTime(LocalDateTime uploadTime) {
			this.uploadTime = uploadTime;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	  
	
	}
	

