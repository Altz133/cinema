package com.example.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/registerForm")
    public String register(){
        return "registerForm";
    }

    @GetMapping("/repertuar")
    public String repertuar(){
        return "repertuar";
    }

    @GetMapping("/forbidden-access")
    public String accessDenited(){
        return "accessDenied";
    }


}
