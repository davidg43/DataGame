package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Objects.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService{
    @Autowired
    private UserRepository repository;
    

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    public User getByName(String name){
        return repository.findByName(name);
    }

    public void save(User user){
         repository.save(user);
    }
}
    

