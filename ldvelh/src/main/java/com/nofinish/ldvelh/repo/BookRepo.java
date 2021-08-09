package com.nofinish.ldvelh.repo;

import com.nofinish.ldvelh.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
