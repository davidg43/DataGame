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
public class IndexService {
    	String PATH = "demo/game_info.csv"; 

    private GameRepository gameRepository;
    private ElasticsearchOperations operations;
    private GameRepresentationRepository gameRepresentationRepository;

    public IndexService(GameRepository gameRepository,
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

    public Game crateNGame(CSVRecord entry){
        Game game = new Game();
        game.setId(Integer.parseInt(entry.get(0)));
        game.setTitle(entry.get(2));
        if(!entry.get(4).isEmpty())
            // game.setReleased(DateTe.parse(entry.get(4), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        game.setReleased(LocalDate.parse(entry.get(4)));
        game.setUpdated(LocalDateTime.parse(entry.get(6)));
        game.setURL(entry.get(7));

        game.setRating(Range.just(Double.parseDouble(entry.get(8))));
        game.setRatingTop(Range.just(Double.parseDouble(entry.get(9))));

        game.setPlayTime(Double.parseDouble(entry.get(10)));
        game.setAchievements(Integer.parseInt(entry.get(11)));
        game.setPlatform(getCollection(entry.get(16)));
        game.setDevelopers(getCollection(entry.get(17)));
        game.setGenres(getCollection(entry.get(18)));
        return game;
    }

    private Collection<String> getCollection(String string) {
        Collection<String> res = new ArrayList<>();
        String[] matrix = string.split("\\|\\|");
        for(String platform : matrix){
            res.add(platform);
        }
        return res;
    }

    public void indexGames(String path) throws IOException{
        CSVParser csvParser = new CSVParser(new FileReader(path), CSVFormat.DEFAULT);
        List<CSVRecord> records= new ArrayList<>();
        Iterator<CSVRecord> csvRecords = csvParser.iterator();
        csvRecords.next();
        csvRecords.forEachRemaining(records::add);
        csvParser.close();
        //Ordenacion de lineas por metacritic. 
        records.sort(Comparator.comparingDouble(record->Double.parseDouble(record.get(8))));
        List<Game> games = records.stream().filter(r->Double.parseDouble(r.get(8))>4.0).map(x->crateNGame(x)).collect(Collectors.toList());
        games.forEach(g->{
            saveGameRepresentation(g);
        });
        gameRepository.saveAll(games);
        
    }

    public void save(Game game){
        gameRepository.save(game);
    }

    public void indexGames() throws IOException {
        gameRepository.deleteAll();
        indexGames(PATH);
    }
}
