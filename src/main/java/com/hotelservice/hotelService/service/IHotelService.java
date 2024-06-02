package com.hotelservice.hotelService.service;

import java.util.List;

import com.hotelservice.hotelService.entities.Hotel;

public interface IHotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelByName(String name);
    Hotel saveHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
}
