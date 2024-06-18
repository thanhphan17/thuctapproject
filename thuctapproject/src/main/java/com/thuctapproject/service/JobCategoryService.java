package com.thuctapproject.service;

import com.thuctapproject.entity.JobCategory;
import com.thuctapproject.repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobCategoryService {
    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public List<JobCategory> getAllJobCategories() {
        return jobCategoryRepository.findAll();
    }

    public Optional<JobCategory> getJobCategoryById(Long id) {
        return jobCategoryRepository.findById(id);
    }
    public JobCategory saveOrUpdateJobCategory(JobCategory jobCategory) {
        return jobCategoryRepository.save(jobCategory);
    }

    public void deleteJobCategory(Long id) {
        jobCategoryRepository.deleteById(id);
    }

    public JobCategory createJobCategory(JobCategory jobCategory) {
        return null;
    }

    public JobCategory updateJobCategory(Long jobCategoryId, JobCategory jobCategory) {
        return jobCategory;
    }
}
