package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Objects.User;

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
    User user = repository.findByNameOPt(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
     
        return UserDetailsImp.build(user);
    }

}
    

