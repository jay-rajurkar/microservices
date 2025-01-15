package com.codewithjay.rating.RatingMicroservice.service.Impl;

import com.codewithjay.rating.RatingMicroservice.entities.Rating;
import com.codewithjay.rating.RatingMicroservice.exceptions.ResousrceNotFoundException;
import com.codewithjay.rating.RatingMicroservice.repository.RatingRepository;
import com.codewithjay.rating.RatingMicroservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

   @Autowired
   private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
       String randomId = UUID.randomUUID().toString();
       rating.setRatingId(randomId);
        return ratingRepository.save(rating);

    }

    @Override
    public Rating getRating(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()-> new ResousrceNotFoundException("Resource not found at server"));
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
