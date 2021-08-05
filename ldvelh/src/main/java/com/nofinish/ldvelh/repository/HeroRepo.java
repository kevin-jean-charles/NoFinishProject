package com.nofinish.ldvelh.repository;

import com.nofinish.ldvelh.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepo extends JpaRepository<Hero, Long> {
}
