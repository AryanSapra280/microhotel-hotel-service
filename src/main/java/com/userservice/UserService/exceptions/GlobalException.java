package com.userservice.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userservice.UserService.exceptions.apiResponses.ApiResponse;
import com.userservice.UserService.exceptions.customException.DuplicateEmail;
import com.userservice.UserService.exceptions.customException.UserNotFound;

@RestControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> userNotFound(UserNotFound userNotFound) {
        String message = userNotFound.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEmail.class)
    public ResponseEntity<?> duplicateEmail(DuplicateEmail duplicateEmail) {
        String message = duplicateEmail.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.CONFLICT);
    }
}
