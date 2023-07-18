package com.techytribe.gameapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/player")
public class playerController {


    @GetMapping
    public String getHomePageMessage(){
        return "MY HOME PAGE";
    }
    @PostMapping
    public String yetAnotherMessage(){
        return "Some other message";
    }

}
