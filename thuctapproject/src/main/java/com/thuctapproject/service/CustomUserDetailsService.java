package com.thuctapproject.service;

import com.thuctapproject.entity.Users;
import com.thuctapproject.repository.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserReporsitory userReporsitory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userReporsitory.findByUserName(username);
        if (user ==null){
            throw new UsernameNotFoundException("User not found");
        }
        return CustomUserDetails.mapUsertoUserDetail(user);
    }
}
