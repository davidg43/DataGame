package com.example.demo.model.Objects;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.elasticsearch.index.search.ESToParentBlockJoinQuery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.Range;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;


import co.elastic.clients.util.DateTime;
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
    @Field(type = FieldType.Date, name = "released")
    LocalDate                   released;
    
    @Field()
    Integer                     metacritic;

    @PastOrPresent
    @Field(type = FieldType.Date, name = "updated")
    LocalDateTime                    updated;
    @Pattern(regexp = "^https?://[\\w.-]+(?:/\\S+)?$",
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
