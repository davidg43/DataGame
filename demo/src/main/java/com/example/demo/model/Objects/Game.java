package com.example.demo.model.Objects;


import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.Range;

import co.elastic.clients.util.DateTime;

import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(indexName = "games")
public class Game {
    @Id
    Integer                     id;

      
    @Field(type = FieldType.Text, name = "title")
    String                      title;  

      
    @Past
    @Field(name = "released",format = DateFormat.year_month_day)
    DateTime                released;

      
    @PastOrPresent
    @Field(name = "updated",format = DateFormat.date_hour_minute_second)
    DateTime                    updated;

      
    @Pattern(regexp = "^https?://[\\wno.-]+(?:/\\S+)?$",
            message = "Debe ser una URL válida")
    @Field(type = FieldType.Text, name = "url")
    String                      URL;

      
    @Field(type = FieldType.Double_Range, name = "rating")
    Range<Double>                     rating = Range.closed(0., 5.); //[0-5]
    
      
    @Field(type = FieldType.Double_Range, name = "ratingTop")
    Range<Double>                      ratingTop= Range.closed(0., 5.); //[0-5]

      
    @Field(type = FieldType.Double, name = "playTime")
    Double                      playTime;

      
    @Field(type = FieldType.Integer, name = "achievements")
    Integer                     achievements;

      
    @Field(name = "platform")
    Collection<String>          platform;

      
    @Field(name = "developers")
    Collection<String>          developers;

      
    @Field(name = "genres")
    Collection<String>          genres;


    
}
