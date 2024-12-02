package com.example.sistem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/administrativo")
    public String startMain(){
        return "administrativo/home";
    }
}
