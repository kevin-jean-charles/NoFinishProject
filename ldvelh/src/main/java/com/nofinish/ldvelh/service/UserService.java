package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.User;

import java.util.List;

public interface UserService {
    Iterable<User>getUsers();
    User getUserById(Long id);
    User addUserInBook(Long id, Book book);
}
