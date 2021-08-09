package com.nofinish.ldvelh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
//@NamedEntityGraph(name = "book.author", attributeNodes = @NamedAttributeNode("author"))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String resume;

    @OneToMany
    private List<Chapter> listChapters;

    @ManyToOne
    private User user;




}