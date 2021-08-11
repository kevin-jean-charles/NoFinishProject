package com.nofinish.ldvelh.controller;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.User;
import com.nofinish.ldvelh.security.service.UserDetailsImpl;
import com.nofinish.ldvelh.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
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
    public ResponseEntity<User> addUserInBook(@PathVariable("id") Long id, @RequestBody Book book) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Long TokenUserId = userDetails.getId();
        if(id == TokenUserId ) {
            userService.addUserInBook(id, book);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


    }

}