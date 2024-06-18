package com.thuctapproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thuctapproject.entity.JobSkill;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill,Integer>{
}