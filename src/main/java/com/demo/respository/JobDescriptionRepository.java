package com.demo.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.JobDescription;

@Repository
public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long> {
	

}



