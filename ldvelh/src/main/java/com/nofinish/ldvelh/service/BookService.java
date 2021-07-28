package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public BookService(BookRepo bookrepo) {
        this.bookRepo = bookrepo;
    }

    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

}
