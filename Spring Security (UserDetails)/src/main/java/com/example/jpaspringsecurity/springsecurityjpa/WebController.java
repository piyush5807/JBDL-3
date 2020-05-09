package com.example.jpaspringsecurity.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Autowired
    UserServiceRepository userServiceRepository;


    @GetMapping(value = "/")
    public String greetEveryone(){
        return "Hello Everyone";
    }

    @PreAuthorize(value = "hasRole()")
    @GetMapping(value = "/user")
    public String greetUsers(){
        return "Hello users";
    }

    @Secured("admin")
    @GetMapping(value = "/admin")
    public String greetAdmin(){
        return "Hello Admin";
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest request){

        MyUserDetails obj = new MyUserDetails(request.userName, request.password);

        // Check for Valid username
        if(userServiceRepository.findByUserName(request.userName) != null){
            return;
        }
        userServiceRepository.save(obj);
    }

}
