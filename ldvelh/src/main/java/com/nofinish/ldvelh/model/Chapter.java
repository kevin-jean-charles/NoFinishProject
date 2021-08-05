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
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private Long id;

    @Column(name = "caption")
    private String caption;

    @Transient
    private String text;

    @Transient
    private boolean intro;

    @Transient
    private boolean end;

    @Column(name = "global_chapter_index")
    private static Long globalIndex;

    public void setId(Long id) {
        globalIndex++;
        this.id = globalIndex;
    }
}
