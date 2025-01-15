package com.codewithjay.rating.RatingMicroservice.repository;

import com.codewithjay.rating.RatingMicroservice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User,String> {

    public User findByUserName(String username);
}


