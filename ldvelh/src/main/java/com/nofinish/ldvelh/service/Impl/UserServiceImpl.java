package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws
            UsernameNotFoundException {
        return userRepo.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(
                        String.format(
                                "user with email %s not found", email)));
    }
}
