package com.shield.projectJavaCesi.service.superbeing;

import com.shield.projectJavaCesi.entity.superbeing.Ability;
import com.shield.projectJavaCesi.repository.superbeing.IAbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityService {
    @Autowired
    private IAbilityRepository repository;

    public List<Ability> getAbilities() {
        return repository.findAll();
    }

    public Ability getAbilityById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Ability> saveAbility(List<Ability> abilitys) {
        return repository.saveAll(abilitys);
    }


    public Ability updateAbility(Ability ability) {
        Ability existingAbility = repository.findById(ability.getId()).orElse(null);
        if (existingAbility == null) {
            return null;
        }
        if (ability.getName() != null) {
            existingAbility.setName(ability.getName());
        }
        if (ability.isWeakness() != null) {
            existingAbility.setWeakness(ability.isWeakness());
        }

        return repository.save(existingAbility);
    }

    public String deleteAbility(int id) {
        repository.deleteById(id);
        return "Ability " + id + " deleted";
    }

    public String deleteAllAbility() {
        repository.deleteAll();
        return "All Abilities deleted";
    }


}
