package com.example.bankOfNepal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
