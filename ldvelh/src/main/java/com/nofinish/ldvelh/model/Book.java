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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Author", nullable = false)
    private Author author;



    public Book() {
        this("");
    }

    public Book(String title) {
        this.title = title;

    }


}