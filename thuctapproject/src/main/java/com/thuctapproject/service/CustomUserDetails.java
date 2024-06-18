package com.thuctapproject.service;

import com.thuctapproject.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private int userId;
    private String userName;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
//map
    public static CustomUserDetails mapUsertoUserDetail(Users user){
        List<GrantedAuthority> listAuthoerities = user.getListJobs().stream()
                .map(jobs -> new SimpleGrantedAuthority(jobs.getJobName().name()))
                .collect(Collectors.toList());
        //tra ve doi tuong userDetailsService
        return new CustomUserDetails(
                user.getUserId(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getUserName(),
                listAuthoerities
        );
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
