package com.jayrajurkar.microservices.service;

import com.jayrajurkar.microservices.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUser(String id);

    List<User> getAllUsers();

    void delete(String id);

    User updateUser(User user);


}
