package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.model.User;
import com.nofinish.ldvelh.repo.UserRepo;
import com.nofinish.ldvelh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepo userRepo;



    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return  userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
