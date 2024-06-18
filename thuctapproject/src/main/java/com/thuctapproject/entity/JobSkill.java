package com.thuctapproject.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "job_skills")
public class JobSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JobSkillId")
    private int jobSkillId;

    private String skillName;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Jobs job;

}
