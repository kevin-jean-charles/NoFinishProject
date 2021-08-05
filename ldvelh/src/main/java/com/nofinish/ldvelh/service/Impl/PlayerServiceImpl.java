package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.model.Player;
import com.nofinish.ldvelh.repository.PlayerRepo;
import com.nofinish.ldvelh.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public Player savePlayer(Player player) {
        return playerRepo.save(player);
    }


    @Override
    public Player findPlayerById(Long id) {
        Optional<Player> playerOptional = playerRepo.findById(id);
        if (playerOptional.isPresent())
            return playerOptional.get();
        return null;
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepo.deleteById(id);
    }
}
