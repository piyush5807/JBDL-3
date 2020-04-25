package com.example.jpaspringsecurity.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    UserServiceRepository userServiceRepository;

    @GetMapping(value = "/")
    public String greetEveryone(){
        return "Hello Everyone";
    }

    @GetMapping(value = "/user")
    public String greetUsers(){
        return "Hello users";
    }

    @GetMapping(value = "/admin")
    public String greetAdmin(){
        return "Hello Admin";
    }

}
