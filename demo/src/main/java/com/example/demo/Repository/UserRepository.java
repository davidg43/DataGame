package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Objects.User;

public interface UserRepository extends JpaRepository<User, Integer>{
   @Query("SELECT u FROM User u WHERE u.username = :name")
   User findByUserName(String name);
   @Query("SELECT u FROM User u")
   List<User> findAll();
}
