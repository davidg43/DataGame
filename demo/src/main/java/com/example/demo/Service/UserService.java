package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Objects.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.TokenUtils;

import antlr.Token;

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

    public String getToken(String name){
        User user = repository.findByName(name);

        String token = TokenUtils.CreateToken(user.getName(), user.getEmail());

        return token;

    }

    public void save(User user){
         repository.save(user);
    }

    public List<User> getAll(){
        return repository.findAll();
    }



}
    

