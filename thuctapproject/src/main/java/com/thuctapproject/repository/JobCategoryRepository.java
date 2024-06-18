package com.thuctapproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thuctapproject.entity.JobCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory,Long>{
}
