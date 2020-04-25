package com.example.jpaspringsecurity.springsecurityjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserServiceRepository extends JpaRepository<MyUserDetails, Integer> {

    MyUserDetails findByUserName(String username);
}
