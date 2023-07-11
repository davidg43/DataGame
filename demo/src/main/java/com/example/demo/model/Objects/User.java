package com.example.demo.model.Objects;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.Configuration.Roles;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="User")
public class User {   

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String username; 

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private Roles role;

    @OneToOne(cascade = CascadeType.ALL)
    GameLibrary library;

   


}
