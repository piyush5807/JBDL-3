package com.shashi.userservice.exception;

public class UserBadReq extends RuntimeException {

    public UserBadReq(){
        super("mobile no is missing in the request");
    }
}
