package com.jayrajurkar.microservices.controller;

import com.jayrajurkar.microservices.entities.User;
import com.jayrajurkar.microservices.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.common.util.internal.logging.InternalLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }
    int retryCount=1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name="ratingHotelBreaker  ",fallbackMethod = "ratingHotelFallbackMethod")
//    @Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallbackMethod")
    @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallbackMethod")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        logger.info("retry count is {}",retryCount);
        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);

    }

    public ResponseEntity<User> ratingHotelFallbackMethod(String userId,Exception ex){
        logger.info("Fallback is executed because service is down: ",ex.getMessage());
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("this user is created because service is down")
                .userId("1234556").build();
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUsers();
        return ResponseEntity.ok(allUser);
    }


}
