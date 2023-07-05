package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Objects.GameLibrary;
import com.example.demo.model.Objects.User;


public interface LibraryRepository extends JpaRepository<GameLibrary, Integer>{
   @Query("SELECT l FROM GameLibrary l WHERE l.id = :id")
   User findById(int id);  
}
