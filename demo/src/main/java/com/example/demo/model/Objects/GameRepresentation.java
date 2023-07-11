package com.example.demo.model.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "Games")
public class GameRepresentation{
    @Id
    Integer id;
}
