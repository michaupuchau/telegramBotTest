package com.telegramBotTest.telegramBotTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/api/v1")
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/test")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping(path = "/test-1")
    public String onetCall(){
        String url = "https://www.onet.pl/";
        return restTemplate.getForEntity(url, String.class).toString();
    }

    @GetMapping(path = "/test-2")
    public String externalApiCall(){
        String url = "https://anime-facts-rest-api.herokuapp.com/api/v1";
        return restTemplate.getForEntity(url, String.class).toString();
    }
}
