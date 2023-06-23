package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Objects.Game;

@Repository
public interface GameRepository extends ElasticsearchRepository<Game, Integer>{
    
    List<Game> findByPlatformContaining(String platform);

    public List<Game> findAll();

    
    List<Game> findByTitleContaining(String decode);

}
