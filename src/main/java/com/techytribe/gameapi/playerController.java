package com.techytribe.gameapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(path="/api/v1/player")
@CrossOrigin("*")
public class playerController {

   @Autowired
  public PlayerRepository playerRepository;

    @PostMapping
    public player createPlayer(@RequestBody player incomingPlayer){
        playerRepository.save(incomingPlayer);

        return  incomingPlayer;
    }
    @GetMapping
    public List<player> getAllPlayers(){
        return playerRepository.findAll();
    }
    @GetMapping(path="/{id}")
    public Optional<player> getSpecificPlayer(@PathVariable String id){


        return  playerRepository.findById(id);

    }
    @PutMapping(path="/{id}")
    public  player updateSpecificPlayer(@PathVariable String id, @RequestBody player incomingPlayer) {
        player existingPlayer = getSpecificPlayer(id).get();
        existingPlayer.name = incomingPlayer.name;
        playerRepository.save(existingPlayer);
        return existingPlayer;
    }
    @DeleteMapping(path="/{id}")
    public player removePlayer(@PathVariable String id){
        player existingPlayer = getSpecificPlayer(id).get();
        playerRepository.delete(existingPlayer);

        return existingPlayer;
    }





}
