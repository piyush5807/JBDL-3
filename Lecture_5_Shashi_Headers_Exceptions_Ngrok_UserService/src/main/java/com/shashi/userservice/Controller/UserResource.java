package com.shashi.userservice.Controller;



import com.shashi.userservice.Model.User;
import com.shashi.userservice.Repository.UserRepository;
import com.shashi.userservice.exception.UserBadReq;
import com.shashi.userservice.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserResource {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepository repository;

    @GetMapping("/hi")
    public String hello(){
        return "Hello";
    }
    // Find
    @GetMapping("/users")
    List<User> findAll() {
        return repository.findAll();
    }

    @PostMapping("/users")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) {
        if(newUser.getMobile()=="" ||
         newUser.getMobile()==null)
            throw new UserBadReq();
        return repository.save(newUser);
    }

    // Find a given user
    @GetMapping("/users/{id}")
    User findOne(@PathVariable int id) {
        LOGGER.info("/users/{id} called with id "+ id);
        // Optional<User> user = repository.findById(id);
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // headers and content type
    @PostMapping(path= "/users2", consumes = "application/json", produces = "application/json")
    ResponseEntity<User> addNewUser2(@RequestBody User newUser,
                               @RequestHeader(name = "client", required = true) String headerPersist,
                               @RequestHeader(name = "location", required = false, defaultValue = "ASIA") String headerLocation){
        System.out.println(headerPersist);
        System.out.println(headerLocation);

        MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<>();
        headersMap.add("header_key", "e2e33efb4efb4e5794b48a18578384ee");
        headersMap.add("header_info", "nothing imp");
        ResponseEntity<User> responseEntity = new ResponseEntity<User>(newUser,headersMap,HttpStatus.ACCEPTED);
        return responseEntity;
    }

}
