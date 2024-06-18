package com.thuctapproject.service;
import com.thuctapproject.entity.Jobs;
import com.thuctapproject.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    private int jobId;

    public List<Jobs> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Jobs> getJobById(Integer id) {
        return jobRepository.findById(id);
    }

    public Jobs saveOrUpdateJob(Jobs job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }

    public Jobs createJob(Jobs job) {
        return job;
    }

    public Jobs updateJob(Integer jobId, Jobs job) {
        this.jobId = jobId;
        return job;
    }
}
