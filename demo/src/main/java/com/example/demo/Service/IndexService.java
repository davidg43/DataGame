package com.example.demo.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.Range;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.GameRepository;
import com.example.demo.model.Objects.Game;

import co.elastic.clients.util.DateTime;

@Service
public class IndexService {
    	String PATH = "demo/game_info.csv"; 

    private GameRepository gameRepository;
    private ElasticsearchOperations operations;

    public IndexService(GameRepository gameRepository, ElasticsearchOperations operations){
        this.gameRepository = gameRepository;
        this.operations = operations;
    }

    public static Game crateNGame(CSVRecord entry){
        Game game = new Game();
        game.setId(Integer.parseInt(entry.get(0)));
        game.setTitle(entry.get(2));
        if(!entry.get(4).isEmpty())
            // game.setReleased(DateTe.parse(entry.get(4), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            game.setReleased(DateTime.of(entry.get(4), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        game.setUpdated(DateTime.of(entry.get(6), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
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
        gameRepository.saveAll(games);
    }

    public void save(Game game){
        gameRepository.save(game);
    }

    public void indexGames() throws IOException {
        indexGames(PATH);
    }


    public List<Game> getGamesByPlatform(String platform) {
        return gameRepository.findByPlatformContaining(platform);
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
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

//Intentos busqueda por titulo multitermino.

    // public List<Game> getGamesByTitle(String title) {
    //     // return gameRepository.findByTitleLike(title);
    //     Criteria criteria = Criteria.where("title").contains(title);
    //     criteria.and(new Criteria("FieldName").expression("*" + SEARCH_TEXT_WITH_SPACE + "*"));

    //     return gameRepository.findGamesByCriteria(criteria);
    // }
     // public List<Game> getGamesByName(String decode) {
    //     Criteria criteria = new Criteria("title").contains(decode);
    //     Query query = new CriteriaQuery(criteria);
    //     SearchHits<Game> searchHits = operations.search(query, Game.class);
    //     return searchHits.stream().map(x->x.getContent()).collect(Collectors.toList());
   
    
}
