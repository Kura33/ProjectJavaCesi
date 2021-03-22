package com.shield.projectJavaCesi.controller.being;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.being.CivilResource;
import com.shield.projectJavaCesi.service.being.CivilService;

@RestController
@RequestMapping(path = "/shield/civil")
@Transactional
public class CivilController {
    @Autowired
    private CivilService service;

    @Autowired
    private EntityManager em;

    /**
     * Sert à recupérer tous les civils.
     *
     * @return une liste de tous les civils.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/")
    public List<CivilResource> findAllCivils() {
        List<Civil> civils = service.getCivils();
        return Mapper.map(civils, Mapper.civilToCivilResource);
    }

    /**
     * Sert à recupérer un civil.
     *
     * @param id
     * @return un civil.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/{id}")
    public CivilResource findCivilById(@PathVariable int id) {
        Civil civil = service.getCivilById(id);
        return Mapper.civilToCivilResource.apply(civil);
    }

    /**
     * Sert à créer une ou plusieurs fiches civil.
     *
     * @param civil
     * @return une liste de civils.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2')")
    @PostMapping("/create")
    public List<CivilResource> addCivil(@RequestBody List<Civil> civil) {
        List<Civil> civils = service.saveCivil(civil);
        em.flush();
        for (Civil civil1 : civils) {
            em.refresh(civil1);
        }
        return Mapper.map(civils, Mapper.civilToCivilResource);
    }

    /**
     * Sert à mettre à jour les informations d'un civil.
     *
     * @param civil
     * @return une liste de civils.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2')")
    @PutMapping("/update")
    public CivilResource updateCivil(@RequestBody Civil civil) {
        Civil civils = service.updateCivil(civil);
        em.flush();
        em.refresh(civils);
        return Mapper.civilToCivilResource.apply(civils);
    }

    /**
     * Sert à supprimer une fiche civil.
     *
     * @param id
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete/{id}")
    public String deleteCivilById(@PathVariable int id) {
        return service.deleteCivil(id);
    }

    /**
     * Sert à supprimer toutes les fiches civil.
     *
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete-all")
    public String deleteCivils() {
        return service.deleteAllCivil();
    }
}
