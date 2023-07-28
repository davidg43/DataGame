package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Objects.User;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
    @Autowired
    private UserRepository repository;

    public UserDetailsServiceImp(UserRepository repository){
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findOPTByName(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
     
        return UserDetailsImp.build(user);
    }

}
    

