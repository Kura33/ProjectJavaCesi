package com.shield.projectJavaCesi.controller.superbeing;

import com.shield.projectJavaCesi.entity.superbeing.Ability;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.superbeing.AbilityResource;
import com.shield.projectJavaCesi.service.superbeing.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
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

        @GetMapping("/")
        public List<AbilityResource> findAllAbility() {
            List<Ability> ability = service.getAbilities();
            return Mapper.map(ability, Mapper.abilityToAbilityResource);
        }

        @GetMapping("/{id}")
        public Ability findAbilityById(@PathVariable int id) {
            return service.getAbilityById(id);
        }

        @PostMapping("/create")
        public List<AbilityResource> addAbility(@RequestBody List<Ability> ability) {
            List<Ability> abilities = service.saveAbility(ability);
            em.flush();
            for (Ability ability1 : abilities) {
                em.refresh(ability1);
            }
            return Mapper.map(abilities, Mapper.abilityToAbilityResource);
        }


        @PutMapping("/update")
        public AbilityResource updateAbility(@RequestBody Ability ability) {
            Ability abilities = service.updateAbility(ability);
            em.flush();
            em.refresh(abilities);

            return Mapper.abilityToAbilityResource.apply(abilities);
        }

        @DeleteMapping("/delete/{id}")
        public String deleteAbilityById(@PathVariable int id) {
            return service.deleteAbility(id);
        }

        @DeleteMapping("/delete-all")
        public String deleteAbilitys() {
            return service.deleteAllAbility();
        }

    }

