package com.nofinish.ldvelh.repo;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {




}
