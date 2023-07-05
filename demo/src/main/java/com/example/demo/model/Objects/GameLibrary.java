package com.example.demo.model.Objects;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="GameLibrary")
public class GameLibrary {   

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // @OneToMany(mappedBy = "library")
    // Collection<Game> games;
    @OneToOne(mappedBy = "library")
    User user;


   


}
