package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Objects.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok("User created");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        return ResponseEntity.ok(userService.getToken(user.getName()) + "User Logged");
    }

    // @GetMapping(value="/prueba")
    // public List<User> getMethodName(@RequestParam String param) {
    //     System.out.println(userService.getAll());
    //     return userService.getAll();
    // }
    
}
