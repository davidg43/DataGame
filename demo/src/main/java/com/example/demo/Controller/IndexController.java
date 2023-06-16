package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.IndexService;
import com.example.demo.model.Objects.Game;

@RestController
@RequestMapping("/")
public class IndexController {

    private ElasticsearchOperations elasticsearchOperations;
    private IndexService    indexService;

    public IndexController(ElasticsearchOperations elasticsearchOperations,
        IndexService indexService){
        this.elasticsearchOperations = elasticsearchOperations;
        this.indexService = indexService;
    }

    @GetMapping
    public List<Game> indexGames() throws IOException{
        elasticsearchOperations.save(indexService.getGames());
        return indexService.getGames();
    }
    
}
