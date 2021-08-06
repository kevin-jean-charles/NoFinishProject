//package com.nofinish.ldvelh.controller;
//
//import com.nofinish.ldvelh.model.User;
//import com.nofinish.ldvelh.service.BookService;
//import com.nofinish.ldvelh.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:4200/")
//@Controller
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private BookService bookService;
//
//
//    public UserController(UserService userService, BookService bookService) {
//        this.userService = userService;
//        this.bookService = bookService;
//    }
//
//    @PostMapping("")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User newUser = userService.createOrUpdateUser(user);
//        return  new ResponseEntity<>(newUser, HttpStatus.OK);
//    }
//
//    @GetMapping("")
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> listUsers = userService.findAllUsers();
//        return new ResponseEntity<>(listUsers, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getById(@PathVariable Long id) {
//        User user = userService.findById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//}
