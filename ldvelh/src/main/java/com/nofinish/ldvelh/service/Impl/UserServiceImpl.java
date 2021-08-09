package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.User;
import com.nofinish.ldvelh.repo.BookRepo;
import com.nofinish.ldvelh.repo.UserRepo;
import com.nofinish.ldvelh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    BookRepo bookRepo;

    public Iterable<User>getUsers(){
        return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User addUserInBook(Long id, Book book) {
        Optional<User> userOptional = userRepo.findById(id);
        Optional<Book> recipeOptional = bookRepo.findById(id);
        User user =null;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            user.getBookList().add(book);
            userRepo.save(user);
        }
        return user;
    }
}
