package com.nofinish.ldvelh.repository;


import com.nofinish.ldvelh.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {
}
