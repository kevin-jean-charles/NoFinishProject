package com.nofinish.ldvelh.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
