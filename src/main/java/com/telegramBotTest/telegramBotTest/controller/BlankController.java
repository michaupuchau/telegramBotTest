package com.telegramBotTest.telegramBotTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlankController {
    
    @GetMapping(path = "/")
    public String helloWorld(){
        return "Halo halo";
    }
}
