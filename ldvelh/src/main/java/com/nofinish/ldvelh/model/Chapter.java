package com.nofinish.ldvelh.model;


import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


/**
 *
 */
@Data
@Entity
public class Chapter {

    private static int globalIndex = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caption;
    private String text;

//    @ManyToMany
//    @MapKeyColumn(name = "options_id")
//    private Map<Integer, Chapter> options;


    private boolean intro;
    private boolean end;

    /**
     * Default constructor
     */
    public Chapter() {
        this("","");
    }

    public Chapter(String text, String caption) {
        this.text = text;
        this.caption = caption;
//        options = new HashMap<>();
        id = globalIndex++;
    }

}
