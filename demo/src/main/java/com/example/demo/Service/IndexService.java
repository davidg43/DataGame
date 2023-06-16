package com.example.demo.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.el.stream.Stream;
import org.springframework.data.elasticsearch.core.Range;
import org.springframework.stereotype.Service;

import com.example.demo.model.Objects.Game;
import com.example.demo.model.Repository.GameRepository;

import co.elastic.clients.util.DateTime;

@Service
public class IndexService {

    private static final String path = "files/dataSet.csv";
    private GameRepository gameRepository;

    public IndexService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public static Game crateNGame(CSVRecord entry){
        Game game = new Game();
        game.setId(Integer.parseInt(entry.get(0)));
        game.setTitle(entry.get(2));
        game.setMetacritic(Integer.parseInt(entry.get(3)));
        game.setReleased(LocalDate.parse(entry.get(4), DateTimeFormatter.ofPattern("yyyy-mm-dd")));
        game.setUpdated(LocalDateTime.parse(entry.get(6), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
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

    private static Collection<String> getCollection(String string) {
        Collection<String> res = new ArrayList<>();
        String[] matrix = string.split("||");
        for(String platform : matrix){
            res.add(platform);
        }
        return res;
    }

    public List<Game> getGames(String path) throws IOException{
        CSVParser csvParser = new CSVParser(new FileReader(path), CSVFormat.DEFAULT);
        List<CSVRecord> records= new ArrayList<>();
        csvParser.getRecords().forEach(records::add);
        csvParser.close();
        records.sort(Comparator.comparingDouble(record->Double.parseDouble(record.get("metacritic"))));
        List<Game> games = records.stream().map(x->crateNGame(x)).collect(Collectors.toList());
        return games;
    }

    public void save(Game game){
        gameRepository.save(game);
    }

    public List<Game> getGames() throws IOException {
        return getGames(path);
    }

}
