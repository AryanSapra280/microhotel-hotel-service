package com.hotelservice.hotelService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelservice.hotelService.entities.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel,String>{
    
    Optional<Hotel> findByName(String name);
}
