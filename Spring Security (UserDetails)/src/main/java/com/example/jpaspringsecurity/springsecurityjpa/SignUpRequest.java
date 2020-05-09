package com.example.jpaspringsecurity.springsecurityjpa;

public class SignUpRequest {

    String userName;
    String emailId;
    String password;

    public SignUpRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
