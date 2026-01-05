package com.demo.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume,Long>{



}
