package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Player;

import java.util.List;


public interface PlayerService {

    Player savePlayer(Player player);

    Player findPlayerById(Long id);

    List<Player> findAllPlayers();

    void deletePlayerById(Long id);
}
