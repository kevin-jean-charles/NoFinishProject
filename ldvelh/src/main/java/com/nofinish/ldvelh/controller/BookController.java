package com.nofinish.ldvelh.controller;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.Chapter;
import com.nofinish.ldvelh.service.BookService;
import com.nofinish.ldvelh.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@Controller
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    @Autowired
    private final ChapterService chapterService;

    public BookController(BookService bookService, ChapterService chapterService) {
        this.bookService = bookService;
        this.chapterService = chapterService;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> listBooks = bookService.findAllBooks();
        return new ResponseEntity<>(listBooks, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book newBook = bookService.createOrUpdateBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @PostMapping("/{id}/chapters")
    public Book addChapterToBook(@PathVariable Long id, @RequestBody Chapter chapter){
        return bookService.addChapterToBook(id,chapter);
    }

    @GetMapping("/{id}/user")
    public ResponseEntity<List<Book>> getBooksByUserId(@PathVariable("id") Long id) {
        List<Book> listBooks = bookService.findBooksByUserId(id);
        return new ResponseEntity<>(listBooks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Book> getById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id,@RequestBody Book book) {
        Book updatedBook = bookService.createOrUpdateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/user/{userId}")
    public ResponseEntity<Book> deleteBookInUserList(@PathVariable("id") Long id,@PathVariable("userId") Long UserId ){
        bookService.deleteBookById(id, UserId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}/{chapterId}")
    public ResponseEntity<Book> deleteChapterInBook(@PathVariable("id") Long id, @PathVariable("chapterId") Long chapterId){
        bookService.deleteChapterInBook(id,chapterId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
