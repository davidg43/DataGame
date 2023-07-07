package com.example.demo.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Objects.User;

@Service
public class UserService{
    @Autowired
    private UserRepository repository;
    

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    public User getByUserName(String name){
        return repository.findByUserName(name);
    }

    public void save(User user){
         repository.save(user);
    }
}
    

