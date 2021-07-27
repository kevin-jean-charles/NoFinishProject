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
    //Warning, this index should be reseted when changing
    //book that will currently edited
    private static int globalIndex = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caption;
    private String text;

    @ElementCollection(targetClass = Chapter.class)
    @MapKeyColumn(name="Option_Id")
    //private Map<Integer, Chapter> options;
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
        //options = new HashMap<>();
        id = globalIndex++;
    }

}
