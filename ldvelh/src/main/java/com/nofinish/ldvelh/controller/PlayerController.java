package com.nofinish.ldvelh.controller;

import com.nofinish.ldvelh.model.Player;
import com.nofinish.ldvelh.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player){
        Player newPlayer = playerService.savePlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> playerList = playerService.findAllPlayers();
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayersById(@PathVariable Long id) {
        Player player = playerService.findPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatePlayer = playerService.savePlayer(player);
        return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(Long id) {
        playerService.deletePlayerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
