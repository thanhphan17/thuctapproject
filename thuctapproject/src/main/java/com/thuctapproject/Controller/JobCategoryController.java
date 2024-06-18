package com.thuctapproject.Controller;

import com.thuctapproject.entity.JobCategory;
import com.thuctapproject.service.JobCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-categories")
public class JobCategoryController {
    private final JobCategoryService jobCategoryService;

    public JobCategoryController(JobCategoryService jobCategoryService) {
        this.jobCategoryService = jobCategoryService;
    }

    @PostMapping
    public ResponseEntity<JobCategory> createJobCategory(@RequestBody JobCategory jobCategory) {
        JobCategory createdJobCategory = jobCategoryService.createJobCategory(jobCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobCategory);
    }
    @PutMapping("/{jobCategoryId}")
    public ResponseEntity<JobCategory> updateJobCategory(@PathVariable Long jobCategoryId, @RequestBody JobCategory jobCategory) {
        JobCategory updatedJobCategory = jobCategoryService.updateJobCategory(jobCategoryId, jobCategory);
        return ResponseEntity.ok(updatedJobCategory);
    }
    @DeleteMapping("/{jobCategoryId}")
    public ResponseEntity<Void> deleteJobCategory(@PathVariable Long jobCategoryId) {
        jobCategoryService.deleteJobCategory(jobCategoryId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{jobCategoryId}")
    public ResponseEntity<List<JobCategory>> getAllJobCategories() {
        List<JobCategory> jobCategories = jobCategoryService.getAllJobCategories();
        return ResponseEntity.ok(jobCategories);
    }
}
