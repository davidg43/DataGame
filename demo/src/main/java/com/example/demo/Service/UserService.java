package com.example.demo.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Objects.User;

@Service
public class UserService{
    private UserRepository repository;
    

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    public User getByName(String name){
        return repository.findByName(name);
    }

    public User save(User user){
        List<User> users = repository.findAll();
        if(users.stream().filter(u->u.getUsername()==user.getUsername()).count()==0)
        return repository.save(user);
        else throw new IllegalArgumentException("User already exists");
    }
}
    

