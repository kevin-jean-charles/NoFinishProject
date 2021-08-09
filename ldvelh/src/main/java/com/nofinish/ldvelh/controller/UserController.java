package com.nofinish.ldvelh.controller;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.User;
import com.nofinish.ldvelh.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200/")
@Data
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public Iterable<User> listUser() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User user(@PathVariable long id) { return  userService.getUserById(id);}

    @PostMapping("/{id}/book")
    public User addUserInRecipe(@PathVariable("id") Long id, @RequestBody Book book) {
        return userService.addUserInBook(id, book);
    }

}