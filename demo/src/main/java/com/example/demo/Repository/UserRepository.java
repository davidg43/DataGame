package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Objects.User;

public interface UserRepository extends JpaRepository<User, Integer>{
   // @Query("SELECT u FROM User u WHERE u.username = :name")
   User findByName(String name);
   // @Query("SELECT u FROM User u")
   List<User> findAll();
   // @Query("SELECT u FROM User u WHERE u.username = :name")
   Optional<User>findOPTByName(String name);
   
}
