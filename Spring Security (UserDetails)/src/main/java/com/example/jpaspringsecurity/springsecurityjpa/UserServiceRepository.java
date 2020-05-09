package com.example.jpaspringsecurity.springsecurityjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserServiceRepository extends JpaRepository<MyUserDetails, Integer> {
    List<MyUserDetails> findByUserName(String username);

    @Secured("admin")
    @Override
    <S extends MyUserDetails> S save(S s);
}
