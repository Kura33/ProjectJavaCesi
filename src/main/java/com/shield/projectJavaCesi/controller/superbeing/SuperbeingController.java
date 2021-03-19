package com.shield.projectJavaCesi.controller.superbeing;


import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.superbeing.SuperbeingResource;
import com.shield.projectJavaCesi.service.superbeing.SuperbeingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/shield/superbeing")
@Transactional
public class SuperbeingController {

    @Autowired
    private SuperbeingService service;

    @Autowired
    private EntityManager em;

    @GetMapping("/")
    public List<SuperbeingResource> findAllSuperbeing() {
        List<Superbeing> superbeing = service.getSuperbeings();
        return Mapper.map(superbeing, Mapper.superbeingToSuperbeingResource);
    }

    @GetMapping("/{id}")
    public Superbeing findSuperbeingById(@PathVariable int id) {
        return service.getSuperbeingById(id);
    }

    @PostMapping("/create")
    public List<SuperbeingResource> addSuperbeing(@RequestBody List<Superbeing> superbeing) {
        List<Superbeing> superbeings = service.saveSuperbeing(superbeing);
        em.flush();
        for (Superbeing superbeing1 : superbeings) {

            em.refresh(superbeing1);
        }
        return Mapper.map(superbeings, Mapper.superbeingToSuperbeingResource);
    }


    @PutMapping("/update")
    public SuperbeingResource updateSuperbeing(@RequestBody Superbeing superbeing) {
        Superbeing superbeings = service.updateSuperbeing(superbeing);
        em.flush();
        em.refresh(superbeings);

        return Mapper.superbeingToSuperbeingResource.apply(superbeings);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSuperbeingById(@PathVariable int id) {
        return service.deleteSuperbeing(id);
    }

    @DeleteMapping("/delete-all")
    public String deleteSuperbeings() {
        return service.deleteAllSuperbeing();
    }

}
