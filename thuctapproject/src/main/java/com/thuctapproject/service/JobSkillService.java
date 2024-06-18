package com.thuctapproject.service;

import com.thuctapproject.entity.JobSkill;
import com.thuctapproject.repository.JobSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobSkillService {
    @Autowired
    private JobSkillRepository jobSkillRepository;

    public List<JobSkill> getAllJobSkills() {
        return jobSkillRepository.findAll();
    }

    public Optional<JobSkill> getJobSkillById(Integer id) {
        return jobSkillRepository.findById(id);
    }
    public JobSkill saveOrUpdateJobSkill(JobSkill jobSkill) {
        return jobSkillRepository.save(jobSkill);
    }

    public void deleteJobSkill(Integer id) {
        jobSkillRepository.deleteById(id);
    }

    public JobSkill createJobSkill(JobSkill jobSkill) {
        return jobSkill;
    }

    public JobSkill updateJobSkill(Long jobSkillId, JobSkill jobSkill) {
        return jobSkill;
    }
}
