package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Objects.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;

public class UserDetailsImp implements UserDetails{

    private Integer id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;

    private Collection <? extends GrantedAuthority> authorities;


    public static UserDetailsImp build(User user){
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
         return new UserDetailsImp(user.getId(),
         user.getUsername(),
         user.getEmail(),
         user.getPassword(),
         authorities);
    }

    public Integer getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
       return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserDetailsImp(Integer id, String username,      String   email, String password,
        Collection<GrantedAuthority> authorities2) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.authorities = authorities2;
                
    }
    


}
