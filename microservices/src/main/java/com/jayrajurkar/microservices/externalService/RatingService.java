package com.jayrajurkar.microservices.externalService;

import com.jayrajurkar.microservices.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATINGMICROSERVICE")
public interface RatingService {

    @GetMapping("/rating/user/{userId}")
    List<Rating> getRatingByUser(@PathVariable("userId") String userId);
}
