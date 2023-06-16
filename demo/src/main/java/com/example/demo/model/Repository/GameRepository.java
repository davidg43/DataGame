package com.example.demo.model.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.Objects.Game;

public interface GameRepository extends ElasticsearchRepository<Game, String>{
    
}
