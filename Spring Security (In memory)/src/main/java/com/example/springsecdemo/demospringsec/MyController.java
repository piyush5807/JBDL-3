package com.example.springsecdemo.demospringsec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping(value = "/foo")
    public String helloFoo(){
        return "hello foo";
    }

    @GetMapping(value = "/bar")
    public String helloBar(){
        return "hello bar";
    }

    @GetMapping("/")
    public String helloVisitors(){
        return "hello visitors";
    }

}
