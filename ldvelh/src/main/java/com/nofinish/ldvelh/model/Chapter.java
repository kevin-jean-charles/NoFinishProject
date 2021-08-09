package com.nofinish.ldvelh.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String caption;
    private String text;
    private boolean intro;
    private boolean end;
    private  String optionName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Chapter> listOptions;




}

