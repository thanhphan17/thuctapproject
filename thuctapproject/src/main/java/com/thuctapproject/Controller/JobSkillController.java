package com.thuctapproject.Controller;

import com.thuctapproject.entity.JobSkill;
import com.thuctapproject.service.JobSkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-skills")
public class JobSkillController {
    private final JobSkillService jobSkillService;

    public JobSkillController(JobSkillService jobSkillService) {
        this.jobSkillService = jobSkillService;
    }
    @GetMapping("/{jobSkillId}")
    public ResponseEntity<Optional<JobSkill>> getJobSkillById(@PathVariable Integer jobSkillId) {
        Optional<JobSkill> jobSkill = jobSkillService.getJobSkillById(jobSkillId);
        return ResponseEntity.ok(jobSkill);
    }

    @GetMapping
    public ResponseEntity<List<JobSkill>> getAllJobSkills() {
        List<JobSkill> jobSkills = jobSkillService.getAllJobSkills();
        return ResponseEntity.ok(jobSkills);
    }
    @PostMapping
    public ResponseEntity<JobSkill> createJobSkill(@RequestBody JobSkill jobSkill) {
        JobSkill createdJobSkill = jobSkillService.createJobSkill(jobSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobSkill);
    }

    @PutMapping("/{jobSkillId}")
    public ResponseEntity<JobSkill> updateJobSkill(@PathVariable Long jobSkillId, @RequestBody JobSkill jobSkill) {
        JobSkill updatedJobSkill = jobSkillService.updateJobSkill(jobSkillId, jobSkill);
        return ResponseEntity.ok(updatedJobSkill);
    }
    @DeleteMapping("/{jobSkillId}")
    public ResponseEntity<Void> deleteJobSkill(@PathVariable Integer jobSkillId) {
        jobSkillService.deleteJobSkill(jobSkillId);
        return ResponseEntity.noContent().build();
    }


}
