package com.codewithjay.rating.RatingMicroservice.service;

import com.codewithjay.rating.RatingMicroservice.entities.User;
import com.codewithjay.rating.RatingMicroservice.entities.UserPrincipal;
import com.codewithjay.rating.RatingMicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = userRepo.findByUserName(username);
        if(users==null){
            throw new UsernameNotFoundException(username);
        }
            return new UserPrincipal(users);

    }
}
