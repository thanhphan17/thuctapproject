package com.thuctapproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;
    @Column(name = "UserName",unique = true,nullable = false)
    private String userName;
    @Column(name = "Password",nullable = false)
    private String password;
    @Column(name = "Created")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date created;
    @Column(name = "Email",unique = true,nullable = false)
    private String email;
    @Column(name = "Phone")
    private String phone;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Jobs> listJobs = new HashSet<>();
}
