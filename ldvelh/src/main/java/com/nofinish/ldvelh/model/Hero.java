package com.nofinish.ldvelh.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private int pv;

    @Column
    private int strength;

    @Column
    private int agility;

    @Column
    private int intelligence;
}
