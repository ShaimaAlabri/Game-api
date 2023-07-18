package com.techytribe.gameapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(path="/api/v1/player")
public class playerController {
   CopyOnWriteArrayList<player> listOfPlayers = new CopyOnWriteArrayList<>();


    @PostMapping
    public player createPlayer(@RequestBody player incomingPlayer){
        listOfPlayers.add(incomingPlayer);
        return  incomingPlayer;
    }

}
