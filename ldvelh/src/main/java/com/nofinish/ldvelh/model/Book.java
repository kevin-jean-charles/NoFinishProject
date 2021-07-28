package com.nofinish.ldvelh.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */

@Entity
@Data
//@NamedEntityGraph(name = "book.author", attributeNodes = @NamedAttributeNode("author"))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String title;

    @Column
    private String resume;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_author", nullable = false)
//    private Author author;



    public Book() {
        this("");
    }

    public Book(String title) {
        this.title = title;
//        this.author = author;
        this.resume = resume;

    }


}