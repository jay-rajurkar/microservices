//package com.codewithjay.apigateway.ApiGateway.config.controller;
//
//import com.codewithjay.apigateway.ApiGateway.config.model.User;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class UserController {
//
//    private List<User> userList = new ArrayList<>(List.of(new User(1,"Jay",50),
//        new User(2,"ANiket",100)));
//
//
//    @GetMapping("/user")
//    public List<User> getUser(){
////        String session = request.getSession().getId();
////        return "welcome to spring security"+session;
//        return userList;
//
//    }
//
//    @GetMapping("/csrf")
//    public CsrfToken getToken(HttpServletRequest http){
//        return (CsrfToken)http.getAttribute("_csrf");
//    }
//    @PostMapping("/adduser")
//    public User addUser(@RequestBody User user){
//         userList.add(user);
//         return user;
//    }
//
//}
