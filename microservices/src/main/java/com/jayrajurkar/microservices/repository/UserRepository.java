package com.jayrajurkar.microservices.repository;

import com.jayrajurkar.microservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User,String> {

}
