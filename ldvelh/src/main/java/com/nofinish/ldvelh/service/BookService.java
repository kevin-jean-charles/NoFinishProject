package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> findAllBooks();

    Book findByTitle(String title);

    //Find Book By Author ??

    Book updateBook(Book book);

    void deleteBook(Book book);
}
