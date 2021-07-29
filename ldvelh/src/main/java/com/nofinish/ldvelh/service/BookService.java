package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> findAllBooks();

    Book findByTitle(String title);

    Book updateBook(Book book);

    void deleteBook(Book book);
}
