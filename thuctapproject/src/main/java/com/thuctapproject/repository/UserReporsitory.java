package com.thuctapproject.repository;

import com.thuctapproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporsitory extends JpaRepository<Users,Integer>{
    Users findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
