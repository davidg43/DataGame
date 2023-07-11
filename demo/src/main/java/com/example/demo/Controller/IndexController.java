package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.IndexService;
import com.example.demo.model.Objects.Game;
import com.example.demo.model.Objects.GameRepresentation;

import org.springframework.web.servlet.view.RedirectView;


@RestController
@ResponseBody

public class IndexController {

    private IndexService    indexService;

    public IndexController(ElasticsearchOperations elasticsearchOperations, IndexService indexService){
        this.indexService = indexService;
    } 

    @GetMapping("/index")
    public RedirectView index() throws IOException{
        indexService.indexGames(); 
        return new RedirectView("/games");
    }

    @GetMapping("/games")
    public List<Game> indexGames() throws IOException{
        return indexService.getGames();
    } 
    @GetMapping("/gamesRepresentation")
    public List<GameRepresentation> indexGamesR() throws IOException{
        return indexService.getGamesRepresentations();
    } 
    


    @GetMapping("/games/{query}")
    public List<Game> getGamesByQuery(
        @PathVariable(name = "query") String query,
        @RequestParam(name = "p", required = false) String platform,
        @RequestParam(name = "t", required = false) List<String> title
    ) throws IOException{
        switch (query) {
            case "p":
                return indexService.getGamesByPlatform(platform);
            case "t":
                return indexService.getGamesByTitle(title);
            case "pt":
                return indexService.getGamesByTitleANDPlatform(platform,title);
            default:
                throw new IllegalArgumentException("Invalid query: " + query);
        }
    }



    // @GetMapping("/filter")
    // public List<Game> getGamesByPlatfotm(@RequestParam(name = "p") String platform) throws IOException{
    //     return indexService.getGamesByPlatform(platform);
    // }
    // @GetMapping("/filter")
    // public List<Game> getGamesByTitle(@RequestParam(name = "t", required = false) List<String> title) throws IOException{
    //     return indexService.getGamesByTitle(title);
    // }

    // @GetMapping("/filter")
    // public List<Game> getGamesByTitleANDPlatform(@RequestParam(name = "p") String platform,@RequestParam(name = "t", required = false) List<String> title){
    //     return indexService.getGamesByTitleANDPlatform(platform,title);
    // }

     
    
}
