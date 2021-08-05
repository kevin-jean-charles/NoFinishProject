package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.repository.BookRepo;
import com.nofinish.ldvelh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> findAllBooks() {

        return  bookRepo.findAll();
    }

    @Override
    public Book findByTitle(String title) {

        return bookRepo.findByTitle(title);
    }

    @Override
    public Book updateBook(Book book) {

        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(Book book) {

        bookRepo.delete(book);
    }
}
