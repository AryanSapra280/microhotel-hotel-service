package com.userservice.UserService.exceptions.customException;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String msg) {
        super(msg);
    }
}
