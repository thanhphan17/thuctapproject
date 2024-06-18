package com.thuctapproject.entity;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "job_categoryId")
public class JobCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobCategoryId;

    private String jobCategoryName;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Jobs> jobs;
}
