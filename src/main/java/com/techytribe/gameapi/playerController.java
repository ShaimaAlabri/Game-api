package com.techytribe.gameapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/player")
public class playerController {
    public String getHomePageMessage(){
        return "MY HOME PAGE";
    }
    public String yetAnotherMessage(){
        return "Some other message";
    }
    
}
