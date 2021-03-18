package com.shield.projectJavaCesi.controller.superbeing;


import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.service.superbeing.SuperbeingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/superbeing")
public class SuperbeingController {

    @Autowired
    private SuperbeingService service;

    @GetMapping("/")
    public List<Superbeing> findAllSuperbeing() {
        return service.getSuperbeings();
    }

    @GetMapping("/{id}")
    public Superbeing findSuperbeingById(@PathVariable int id) {
        return service.getSuperbeingById(id);
    }

    @PostMapping("/create")
    public List<Superbeing> addSuperbeings(@RequestBody List<Superbeing> superbeings) {
        return service.saveSuperbeings(superbeings);
    }

    @PutMapping("/update")
    public Superbeing updateSuperbeing(@RequestBody Superbeing superbeing) {
        return service.updateSuperbeing(superbeing);
    }

    @DeleteMapping("/delete-all")
    public String deleteSuperbeings() {
        return service.deleteAllSuperbeing();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSuperbeingById(@PathVariable int id) {
        return service.deleteSuperbeing(id);
    }


}
