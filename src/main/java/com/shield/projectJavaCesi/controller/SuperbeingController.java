package com.shield.projectJavaCesi.controller;


import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.service.SuperbeingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/superbeing")
public class SuperbeingController {

    @Autowired
    private SuperbeingService service;

    @PostMapping("/create")
    public List<Superbeing> addSuperbeings(@RequestBody List<Superbeing> superbeings) {
        return service.saveSuperbeings(superbeings);
    }

    @GetMapping("/{id}")
    public Superbeing findSuperbeingById(@PathVariable int id) {
        return service.getSuperbeingById(id);
    }

    @GetMapping("/")
    public List<Superbeing> findAllSuperbeing() {
        return service.getSuperbeings();
    }
}
