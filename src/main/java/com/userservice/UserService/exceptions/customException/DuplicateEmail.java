package com.userservice.UserService.exceptions.customException;

public class DuplicateEmail extends RuntimeException{
    public DuplicateEmail(String msg) {
        super(msg);
    }
}
