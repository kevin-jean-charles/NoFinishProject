package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.Chapter;

import java.util.List;

public interface BookService {
    Book createOrUpdateBook(Book book);

    List<Book> findAllBooks();

   Book findById(Long id);

    Book addChapterToBook(Long id, Chapter chapter);

    void deleteBookById(Long id);

    Book deleteChapterInBook(Long id, Long chapterId);

    List<Book> findBooksByUserId(Long id);
}
