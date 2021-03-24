package com.shield.projectJavaCesi.controller.superbeing;


import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.superbeing.SuperbeingResource;
import com.shield.projectJavaCesi.service.superbeing.SuperbeingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    /**
     * Sert à recupérer tous les Superbeings.
     *
     * @return une liste de tous les Superbeings.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/")
    public List<SuperbeingResource> findAllSuperbeing() {
        List<Superbeing> superbeing = service.getSuperbeings();
        return Mapper.map(superbeing, Mapper.superbeingToSuperbeingResource);
    }

    /**
     * Sert à recupérer un superbeing.
     *
     * @param id
     * @return un superbeing.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/{id}")
    public Superbeing findSuperbeingById(@PathVariable int id) {
        return service.getSuperbeingById(id);
    }

    /**
     * Sert à créer une fiche de un ou plusieurs superbeings.
     *
     * @param superbeing
     * @return une liste de superbeings.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2')")
    @PostMapping("/create")
    public List<SuperbeingResource> addSuperbeing(@RequestBody List<Superbeing> superbeing) {
        List<Superbeing> superbeings = service.saveSuperbeing(superbeing);
        em.flush();
        for (Superbeing superbeing1 : superbeings) {

            em.refresh(superbeing1);
        }
        return Mapper.map(superbeings, Mapper.superbeingToSuperbeingResource);
    }

    /**
     * Sert à mettre à jour les informations d'un superbeing.
     *
     * @param superbeing
     * @return un superbeing.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2')")
    @PutMapping("/update")
    public SuperbeingResource updateSuperbeing(@RequestBody Superbeing superbeing) {
        Superbeing superbeings = service.updateSuperbeing(superbeing);
        em.flush();
        em.refresh(superbeings);

        return Mapper.superbeingToSuperbeingResource.apply(superbeings);
    }

    /**
     * Sert à supprimer une fiche superbeing.
     *
     * @param id
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete/{id}")
    public String deleteSuperbeingById(@PathVariable int id) {
        return service.deleteSuperbeing(id);
    }

    /**
     * Sert à supprimer toutes les fiches superbeings.
     *
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete-all")
    public String deleteSuperbeings() {
        return service.deleteAllSuperbeing();
    }

}
