package com.example.demo.controller;

import java.util.List;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Objects.Game;
import com.example.demo.service.GameService;
import com.example.demo.service.IndexService;

import org.springframework.web.servlet.view.RedirectView;


@RestController
@CrossOrigin(origins = "http://localhost:4000")

public class GameController {

    private GameService    gameService;

    public GameController(ElasticsearchOperations elasticsearchOperations, IndexService indexService){
        this.gameService = gameService;
    } 

    // ########################### Edit ###########################
    @PutMapping("/edit/{id}")
    public RedirectView updateGame(@PathVariable(name = "id") Integer id, @RequestBody Game game){
        gameService.updateGame(id, game);
        return new RedirectView("/games");

    }

    // ########################### Delete ###########################
    @GetMapping("/delete/{id}")
    public void deleteGame(@PathVariable Integer id){
        gameService.deleteGame(id);
    }


     // ########################### Create ###########################
     @PostMapping("/create")
     public void createGame(@RequestBody Game game){
        gameService.add(game);
    }

    
    // ########################### Filter ###########################
    @CrossOrigin(origins = "http://localhost:4000")
    @GetMapping("/games/{query}")
    public List<Game> getGamesByQuery(
        @PathVariable(name = "query") String query,
        @RequestParam(name = "platform", required = false) String platform,
        @RequestParam(name = "ttitle", required = false) List<String> title
    ){
        switch (query) {
            case "platform":
                return gameService.getGamesByPlatform(platform);
            case "title":
                return gameService.getGamesByTitle(title);
            case "platform&title":
                return gameService.getGamesByTitleANDPlatform(platform,title);
            default:
                throw new IllegalArgumentException("Invalid query: " + query);
        }
    }



    

     
    
}
