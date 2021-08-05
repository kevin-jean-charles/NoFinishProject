package com.nofinish.ldvelh.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hero_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "resume")
    private String resume;

    @OneToOne
    @JoinColumn(name = "book_hero_id")
    private Hero hero;
}