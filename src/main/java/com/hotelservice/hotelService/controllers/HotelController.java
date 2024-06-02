package com.hotelservice.hotelService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.hotelService.entities.Hotel;
import com.hotelservice.hotelService.exceptions.customException.HotelAlreadyExisit;
import com.hotelservice.hotelService.exceptions.customException.HotelNotFound;
import com.hotelservice.hotelService.service.IHotelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.saveHotel(hotel);
        return new ResponseEntity<>(savedHotel,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> gethotels() {
        return new ResponseEntity<>(hotelService.getAllHotels(),HttpStatus.OK);
    }
    @GetMapping("/{hotelName}")
    public ResponseEntity<?> getHotel(@PathVariable String hotelName) {
        return new ResponseEntity<>(hotelService.getHotelByName(hotelName),HttpStatus.FOUND);
    }
    
    
    

}
