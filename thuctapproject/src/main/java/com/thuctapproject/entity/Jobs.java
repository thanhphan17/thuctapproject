package com.thuctapproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "Jobs")
@Data
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JobId")
    private int jobId;
    @Column(name = "JobName")
    @Enumerated
    private ERole jobName;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private Set<JobSkill> jobSkills;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private JobCategory jobCategoryId;

    public void setId(Long id) {
    }
}
