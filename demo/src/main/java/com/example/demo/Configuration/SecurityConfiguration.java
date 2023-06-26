package com.example.demo.Configuration;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfiguration {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             GrantedAuthority auth = new SimpleGrantedAuthority(Roles.USER.name());
             String password = "password";

             BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
             String encodedPassword = passwordEncoder.encode(password);
 
             Collection<GrantedAuthority> authorities = Collections.singletonList(auth);
             UserDetails user = new User("nombre", encodedPassword, authorities);
             return user;
            }
            
        };
    }
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());
        http.csrf().disable().authorizeRequests().
        antMatchers("/index").authenticated().and().
        formLogin().usernameParameter("nombre").
        passwordParameter("password");
        //http.authorizeRequests().antMatchers("/index").;
        // http.authorizeRequests().antMatchers("/login").permitAll()
        //         .antMatchers("/users/**", "/settings/**").hasAuthority("Admin")
        //         .hasAnyAuthority("Admin", "Editor", "Salesperson")
        //         .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
        //         .anyRequest().authenticated()
        //         .and().formLogin()
        //         .loginPage("/login")
        //             .usernameParameter("email")
        //             .permitAll()
        //         .and()
        //         .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
        //         .and()
        //         .logout().permitAll();
        http.headers().frameOptions().sameOrigin();
 
        return http.build();
    }
 
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }
 
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
    
    return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
}
}