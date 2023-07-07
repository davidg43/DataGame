package com.example.demo.Service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Configuration.Roles;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Objects.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
    @Autowired
    private UserRepository repository;

    public UserDetailsServiceImp(UserRepository repository){
        this.repository = repository;
    }


    @Autowired
    public UserDetailsServiceImp() {
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           
            User user = repository.findByUserName(username);
            if(user != null){
                String password = user.getPassword();
                Roles rol = user.getRole();
                GrantedAuthority auth = new SimpleGrantedAuthority(rol.name());
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(password);
                Collection<GrantedAuthority> authorities = Collections.singletonList(auth);
                UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), encodedPassword, authorities);
                return userDetails;
            }
            else
                throw new UsernameNotFoundException("Username not found");
    }
}
    

