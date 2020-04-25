package com.example.jpaspringsecurity.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyAuthService implements UserDetailsService {

    @Autowired
    UserServiceRepository userServiceRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return userServiceRepository.findByUserName(s);
    }
}
