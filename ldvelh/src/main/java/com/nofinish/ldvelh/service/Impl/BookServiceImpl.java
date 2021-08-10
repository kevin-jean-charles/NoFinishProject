package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.Chapter;
import com.nofinish.ldvelh.model.User;
import com.nofinish.ldvelh.repo.BookRepo;
import com.nofinish.ldvelh.repo.ChapterRepo;
import com.nofinish.ldvelh.repo.UserRepo;
import com.nofinish.ldvelh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private  BookRepo bookRepo;
    @Autowired
    private ChapterRepo chapterRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Book createOrUpdateBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Long id) {
       Optional<Book> book = bookRepo.findById(id);
       if (book.isPresent()) {
           return book.get();
       }
        return null;
    }


    @Override
    public Book addChapterToBook(Long id, Chapter chapter) {
        Optional<Book> currentBook = bookRepo.findById(id);
        Book updatedBook = null;
        if(currentBook.isPresent()) {
            updatedBook = currentBook.get();
            updatedBook.getListChapters().add(chapter);
            chapterRepo.save(chapter);
            bookRepo.save(updatedBook);
        }
        return updatedBook;
    }

    @Override
    public void deleteBookById(Long id, Long UserId) {
        Optional<Book> currentBook = bookRepo.findById(id);
        Optional<User> userOptional = userRepo.findById(UserId);
        Book deletedBook = null;
        User user = null;
        if(currentBook.isPresent()&&userOptional.isPresent()) {
            deletedBook = currentBook.get();
            user = userOptional.get();
            user.getBookList().remove(deletedBook);
            bookRepo.delete(deletedBook);
            userRepo.save(user);
        }
    }

    @Override
    public Book deleteChapterInBook(Long id, Long chapterId) {
        Optional<Book> currentBook = bookRepo.findById(id);
        Optional<Chapter> currentChapter = chapterRepo.findById(chapterId);
        Book updatedBook = null;
        Chapter updatedChapter = null;
        if(currentBook.isPresent() && currentChapter.isPresent()) {
            updatedBook = currentBook.get();
            updatedChapter = currentChapter.get();
            updatedBook.getListChapters().remove(updatedChapter);
            chapterRepo.delete(updatedChapter);
            bookRepo.save(updatedBook);
            }
        return updatedBook;
  }

    @Override
    public List<Book> findBooksByUserId(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.get().getBookList();
    }

}
