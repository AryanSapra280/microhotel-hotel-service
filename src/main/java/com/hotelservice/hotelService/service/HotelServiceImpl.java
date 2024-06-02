package com.hotelservice.hotelService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.hotelService.entities.Hotel;
import com.hotelservice.hotelService.exceptions.customException.HotelAlreadyExisit;
import com.hotelservice.hotelService.exceptions.customException.HotelNotFound;
import com.hotelservice.hotelService.repositories.IHotelRepository;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelRepository hotelRepository;
    
    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelByName(String name) {
        Hotel hotel = hotelRepository.findByName(name).orElseThrow(()->new HotelNotFound("No hotel exist with this name"));
        return hotel;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String hotel_id = UUID.randomUUID().toString();
        hotel.setHotel_id(hotel_id);
        return hotelRepository.save(hotel);                
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        if(hotel.getName() == null) {
            throw new RuntimeException("Please provide a registered hotelName");
        }
        Hotel foundHotel = hotelRepository.findByName(hotel.getName()).orElseThrow(()->new HotelNotFound("hotel doesn't exist with this name"));
        updateDetails(foundHotel,hotel);
        return hotelRepository.save(foundHotel);
    }
    private void updateDetails(Hotel foundHotel, Hotel hotel) {
        if(hotel.getAbout()!=null) {
            foundHotel.setAbout(hotel.getAbout());
        }
        if(hotel.getLocation()!=null) {
            foundHotel.setName(hotel.getName());
        }
    }
}
