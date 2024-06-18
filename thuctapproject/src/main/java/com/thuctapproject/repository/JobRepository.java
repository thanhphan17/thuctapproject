package com.thuctapproject.repository;
import com.thuctapproject.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Jobs,Integer> {
    Optional<Jobs> findByJobName(String jobName);
}
