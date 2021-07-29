package com.nofinish.ldvelh.controller;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200/")
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newBook = bookService.saveBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> listBooks = bookService.findAllBooks();
        return  new ResponseEntity<>(listBooks, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getByTitle(@PathVariable String title){
        Book book = bookService.findByTitle(title);
        return  new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Book> updateBookById(@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Book> deleteBookById(@RequestBody Book book){
        bookService.deleteBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
