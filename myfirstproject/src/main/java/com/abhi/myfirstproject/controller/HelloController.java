package com.abhi.myfirstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
      @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/about")
    public String about(){
        return "this is about me";
    }
    
}
