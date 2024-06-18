package com.thuctapproject.Controller;

import com.thuctapproject.entity.Jobs;
import com.thuctapproject.service.JobService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/jobs")
@Data
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Jobs>> getAllJobs() {
        List<Jobs> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Jobs> getJobById(@PathVariable Integer id) {
        return jobService.getJobById(id)
                .map(job -> new ResponseEntity<>(job, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Jobs> createJob(@RequestBody Jobs job) {
        Jobs createdJob = jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<Jobs> updateJob(@PathVariable Integer jobId, @RequestBody Jobs job) {
        Jobs updatedJob = jobService.updateJob(jobId, job);
        return ResponseEntity.ok(updatedJob);
    }
    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob( Integer jobId) {
        jobService.deleteJob(jobId);
        return ResponseEntity.noContent().build();
    }


}