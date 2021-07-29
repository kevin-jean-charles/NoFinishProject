package com.nofinish.ldvelh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hero")
@Data
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hero_id")
    private Long id;

    @Column(name = "hero_name")
    private String heroName;

    @Column(name = "livePoint")
    private int livePoint;

    @Column(name = "strength")
    private int strength;

    @Column(name = "agility")
    private int agility;

    @Column(name = "intelligence")
    private int intelligence;
}
