package com.shield.projectJavaCesi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @GetMapping(value = "/shield")
    public String index() {
        return "home page";
    }

//    @GetMapping("/index")
//    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
}


