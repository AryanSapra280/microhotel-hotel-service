package com.hotelservice.hotelService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotelservice.hotelService.exceptions.customException.HotelAlreadyExisit;
import com.hotelservice.hotelService.exceptions.customException.HotelNotFound;

@RestControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(HotelNotFound.class)
    public ResponseEntity<?>hotelNotFound(HotelNotFound hotelNotFound) {
        return new ResponseEntity<>(hotelNotFound.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(HotelAlreadyExisit.class)
    public ResponseEntity<?>hotelAlreadyExisit(HotelAlreadyExisit hotelAlreadyExisit) {
        return new ResponseEntity<>(hotelAlreadyExisit.getMessage(),HttpStatus.CONFLICT);
    }
}
