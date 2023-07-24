package com.techytribe.gameapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(path="/api/v1/player")
@CrossOrigin("*")
public class playerController {
   CopyOnWriteArrayList<player> listOfPlayers = new CopyOnWriteArrayList<>();


    @PostMapping
    public player createPlayer(@RequestBody player incomingPlayer){
        listOfPlayers.add(incomingPlayer);
        return  incomingPlayer;
    }
    @GetMapping
    public List<player> getAllPlayers(){
        return listOfPlayers;
    }
    @GetMapping(path="/{id}")
    public player getSpecificPlayer( @PathVariable String id){
        player existingPlayer= listOfPlayers.stream().filter(
                (currPlayer)->{
         return currPlayer.id.equals(id);
     }).findFirst().get();

        return existingPlayer;

    }
    @PutMapping(path="/{id}")
    public  player updateSpecificPlayer(@PathVariable String id, @RequestBody player incomingPlayer) {
        player existingPlayer = getSpecificPlayer(id);
        existingPlayer.name = incomingPlayer.name;
        return existingPlayer;
    }
    @DeleteMapping(path="/{id}")
    public player removePlayer(@PathVariable String id){
        player existingPlayer = getSpecificPlayer(id);
        listOfPlayers.remove(existingPlayer);
        return existingPlayer;
    }





}
