package com.codewithjay.rating.RatingMicroservice.service;

import com.codewithjay.rating.RatingMicroservice.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating rating);

    public Rating getRating(String ratingId);
    public List<Rating> getAllRating();

    public List<Rating> getAllByUserId(String userId);
    public List<Rating> getAllByHotelId(String hotelId);

}
