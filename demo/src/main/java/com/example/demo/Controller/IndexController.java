package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Objects.Game;
import com.example.demo.model.Objects.GameRepresentation;
import com.example.demo.service.GameService;
import com.example.demo.service.IndexService;

import org.springframework.web.servlet.view.RedirectView;


@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4000")

public class IndexController {

    private GameService  gameService;

    public IndexController(ElasticsearchOperations elasticsearchOperations, IndexService indexService){
        this.gameService = gameService;
    } 

    // ########################### Index ###########################

    @CrossOrigin(origins = "http://localhost:4000")
    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable int id) throws IOException{
        return gameService.getGamesById(id).get();
    } 

    @CrossOrigin(origins = "http://localhost:4000")
    @GetMapping("/games")
    public List<Game> getGames() throws IOException{
        return gameService.getGames();
    } 

     
    
}
