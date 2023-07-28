package com.example.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.Range;
import org.springframework.stereotype.Service;

import com.example.demo.model.Objects.Game;
import com.example.demo.model.Objects.GameRepresentation;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.GameRepresentationRepository;

@Service
public class GameService {
    	String PATH = "demo/game_info.csv"; 

    private GameRepository gameRepository;
    private ElasticsearchOperations operations;
    private GameRepresentationRepository gameRepresentationRepository;

    public GameService(GameRepository gameRepository,
     ElasticsearchOperations operations,
     GameRepresentationRepository gameRepresentationRepository){
        this.gameRepository = gameRepository;
        this.operations = operations;
        this.gameRepresentationRepository = gameRepresentationRepository;
    }
    public void saveGameRepresentation(Game game){
        GameRepresentation gameRepresentation = new GameRepresentation();
        gameRepresentation.setId(game.getId());
        gameRepresentationRepository.save(gameRepresentation);
    }


    public void save(Game game){
        gameRepository.save(game);
    }


    public List<Game> getGamesByPlatform(String platform) {
        return gameRepository.findByPlatformContaining(platform);
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
    }
    public List<GameRepresentation> getGamesRepresentations() {
        return gameRepresentationRepository.findAll();
    }


     public List<Game> getGamesByTitle(List<String> title, List<Game> games) {
        for(String t : title){
            games = games.stream().filter(g->g.getTitle().contains(t)).collect(Collectors.toList());
        }
        return games;
    }

    public List<Game> getGamesByTitle(List<String> title) {
        String init = title.get(0);
        List<Game> games = gameRepository.findByTitleContaining(init);
        return getGamesByTitle(title.subList(1, title.size()), games);

    }

    public List<Game> getGamesByTitleANDPlatform(String platform, List<String> title) {
        List<Game> res =  getGamesByTitle(title);
       res.removeIf(g->!getGamesByPlatform(platform).contains(g));
       return res;

    }
    public Optional<Game> getGamesById(int id) {
        return gameRepository.findById(id);
    }
    public void updateGame(Integer id, Game game) {
        Game old = gameRepository.findById(id).get();
        old.setTitle(game.getTitle());
        old.setAchievements(game.getAchievements());
        old.setDevelopers(game.getDevelopers());
        old.setGenres(game.getGenres());
        old.setPlatform(game.getPlatform());
        old.setPlayTime(game.getPlayTime());
        old.setRating(game.getRating());
        old.setRatingTop(game.getRatingTop());
        old.setReleased(game.getReleased());
        old.setURL(game.getURL());
        old.setUpdated(game.getUpdated());
        gameRepository.save(old);
    }
    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }
    public void add(Game game) {
        gameRepository.save(game);
    }

    
}
