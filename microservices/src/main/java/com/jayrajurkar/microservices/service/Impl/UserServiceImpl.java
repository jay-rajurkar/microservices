package com.jayrajurkar.microservices.service.Impl;

import com.jayrajurkar.microservices.entities.Hotel;
import com.jayrajurkar.microservices.entities.Rating;
import com.jayrajurkar.microservices.exceptions.ResourceNotFoundException;
import com.jayrajurkar.microservices.externalService.HotelService;
import com.jayrajurkar.microservices.externalService.RatingService;
import com.jayrajurkar.microservices.repository.UserRepository;
import com.jayrajurkar.microservices.service.UserService;
import com.jayrajurkar.microservices.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

    @Autowired
    RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        //        user.setUserId(randomUserId);
        return userRepository.save(user);

    }

    @Override
    public User getUser(String userid) {
       User user = userRepository.findById(userid).orElseThrow(()-> new ResourceNotFoundException("Resource cannnot be found in server!!:"+userid));

//        Rating[] ratingOfUser =restTemplate.getForObject("http://RATINGMICROSERVICE/rating/user/"+userid, Rating[].class);
//        logger.info("{}",ratingOfUser);
//        List<Rating> ratingList = Arrays.stream(ratingOfUser).toList();
//        user.setRatings(ratingList);
        List<Rating> ratingList = ratingService.getRatingByUser(userid);
        ratingList.forEach((Rating rating)-> {
            String hotelId =rating.getHotelId();
//            ResponseEntity<Hotel> response= restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+hotelId, Hotel.class);
//            Hotel hotel= response.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
        });
        user.setRatings(ratingList);

        return user;//.orElseThrow(()-> new ResourceNotFoundException("Resource cannnot be found in server!!:"+userid));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userRepository.findAll();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
