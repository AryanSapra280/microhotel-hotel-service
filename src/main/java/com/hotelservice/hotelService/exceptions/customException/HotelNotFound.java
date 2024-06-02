package com.hotelservice.hotelService.exceptions.customException;

public class HotelNotFound extends RuntimeException{
    public HotelNotFound(String msg) {
        super(msg);
    }
}
