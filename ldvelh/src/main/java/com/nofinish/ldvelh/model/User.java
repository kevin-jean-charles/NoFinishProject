package com.nofinish.ldvelh.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    private int id;

    private String user_name;
    private String email;
    private String password;

//    useBook(Book) {
//        play -> player
//    edit -> author
//
//    }
//    CRUD Book -> author
//    sauf read -> player


}
