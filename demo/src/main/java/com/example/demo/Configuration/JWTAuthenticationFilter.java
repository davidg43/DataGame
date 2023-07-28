package com.example.demo.configuration;

import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.service.UserDetailsImp;
import com.example.demo.utils.TokenUtils;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.io.IOException;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
    public Authentication attempAuthentication(HttpServletRequest request,      HttpServletResponse response) throws AuthenticationException, StreamReadException, DatabindException, java.io.IOException{
        AuthCredentials credentials = new AuthCredentials();
        try{
            credentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
            credentials.getUsername(),
            credentials.getPassword());

            return getAuthenticationManager().authenticate(usernamePAT);
    }


    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws java.io.IOException, javax.servlet.ServletException{
       UserDetailsImp userDetails = (UserDetailsImp) authResult.getPrincipal();
       String token = TokenUtils.CreateToken(userDetails.getUsername(), userDetails.getEmail());

       response.addHeader("Authoritatio", "Bearer " + token);

       response.getWriter().flush();

       super.successfulAuthentication(request, response, chain, authResult);
    }   


}
