package com.codewithjay.rating.RatingMicroservice.controllers;

import com.codewithjay.rating.RatingMicroservice.entities.Rating;
import com.codewithjay.rating.RatingMicroservice.service.RatingService;
//import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

//    @GetMapping("/csrf")
//    public CsrfToken csrfToken(HttpServletRequest request){
//        return (CsrfToken)request.getAttribute("_csrf");
//    }
    @PostMapping
    private ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping
    private ResponseEntity<List<Rating>> getAllRating(HttpServletRequest request){
        System.out.println("session"+request.getSession().getId()+" _csrf"+request.getAttribute("_csrf") );
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRating());
    }

    @GetMapping(value="/user/{userId}")
    private ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable  String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllByUserId(userId));
    }

    @GetMapping(value="/hotel/{hotelId}")
    private ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable  String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllByHotelId(hotelId));
    }


}
