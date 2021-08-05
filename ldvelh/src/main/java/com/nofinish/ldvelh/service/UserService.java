package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> findAllUsers();

    User updateUser(User user);
}
