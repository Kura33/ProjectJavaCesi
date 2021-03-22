package com.shield.projectJavaCesi.controller.superbeing;

import com.shield.projectJavaCesi.entity.superbeing.Ability;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.superbeing.AbilityResource;
import com.shield.projectJavaCesi.service.superbeing.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping(path = "/shield/ability")
@Transactional
public class AbilityController {

    @Autowired
    private AbilityService service;

    @Autowired
    private EntityManager em;

    /**
     * Sert à recupérer toutes les abilitées.
     *
     * @return une liste de toutes les abilitées.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/")
    public List<AbilityResource> findAllAbility() {
        List<Ability> ability = service.getAbilities();
        return Mapper.map(ability, Mapper.abilityToAbilityResource);
    }

    /**
     * Sert à recupérer une abilitée.
     *
     * @param id
     * @return une abilitée.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/{id}")
    public Ability findAbilityById(@PathVariable int id) {
        return service.getAbilityById(id);
    }

    /**
     * Sert à créer une fiche une ou plusieurs abilitées.
     *
     * @param ability
     * @return une liste d'abilitées.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2')")
    @PostMapping("/create")
    public List<AbilityResource> addAbility(@RequestBody List<Ability> ability) {
        List<Ability> abilities = service.saveAbility(ability);
        em.flush();
        for (Ability ability1 : abilities) {
            em.refresh(ability1);
        }
        return Mapper.map(abilities, Mapper.abilityToAbilityResource);
    }

    /**
     * Sert à mettre à jour les informations d'une abilitée.
     *
     * @param ability
     * @return une abilitée.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2')")
    @PutMapping("/update")
    public AbilityResource updateAbility(@RequestBody Ability ability) {
        Ability abilities = service.updateAbility(ability);
        em.flush();
        em.refresh(abilities);

        return Mapper.abilityToAbilityResource.apply(abilities);
    }

    /**
     * Sert à supprimer une fiche abilitée.
     *
     * @param id
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete/{id}")
    public String deleteAbilityById(@PathVariable int id) {
        return service.deleteAbility(id);
    }

    /**
     * Sert à supprimer toutes les fiches abilitées.
     *
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete-all")
    public String deleteAbilitys() {
        return service.deleteAllAbility();
    }

}

