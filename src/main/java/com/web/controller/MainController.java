package com.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class MainController {
    @GetMapping("/hello")
    public String homePage(){

        //this main part which view resolver add suffix and prefix
        return "home";
    }

}
