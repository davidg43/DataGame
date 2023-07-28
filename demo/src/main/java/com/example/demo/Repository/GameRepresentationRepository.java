package com.example.demo.repository;


import com.example.demo.model.Objects.GameRepresentation;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepresentationRepository extends JpaRepository<GameRepresentation, Integer> {
    
}
