package com.codewithjay.hotelService.controller;

import com.codewithjay.hotelService.entities.Hotel;
import com.codewithjay.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

//    @Autowired
//    private HotelService hotelService;
    @Autowired
    private HotelService hotelService;

    @PostMapping
    private ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotel(hotel));

    }

    @GetMapping("/{hotelId}")
    private ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
            return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
    }

    @GetMapping
    private ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());

    }
}
