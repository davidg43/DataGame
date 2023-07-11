package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.Objects.Game;

public interface GameRepository extends ElasticsearchRepository<Game, Integer>{
    
    List<Game> findByPlatformContaining(String platform);
    public List<Game> findAll();
    List<Game> findByTitleContaining(String decode);

}
