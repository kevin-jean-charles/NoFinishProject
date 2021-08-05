package com.nofinish.ldvelh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data

@Table(name = "author")
public class Author extends Player {

    @Column(name = "total_book_number")
    private Long totalBookNumber;

    @OneToMany
    @JoinColumn(name = "author_book_id")
    private List<Book> bookList;
}
