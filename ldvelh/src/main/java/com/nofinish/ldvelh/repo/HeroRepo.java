package com.nofinish.ldvelh.repo;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HeroRepo extends JpaRepository<Hero, Long> {
}
