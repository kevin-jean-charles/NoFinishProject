package com.nofinish.ldvelh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String caption;
    private String text;
    private boolean intro;
    private boolean end;

 /*   @ManyToMany(fetch = FetchType.EAGER)
//    private Map<Long, Chapter> listOptions = new HashMap<>();
    private Set<Option> listOptions;
*/




}

