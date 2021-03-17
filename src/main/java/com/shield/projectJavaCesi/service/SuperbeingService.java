package com.shield.projectJavaCesi.service;

import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.repository.ISuperbeingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperbeingService {

    @Autowired
    private ISuperbeingRepository repository;


    public Superbeing saveSuperbeing(Superbeing superbeing) {
        return repository.save(superbeing);
    }

    public List<Superbeing> saveSuperbeings(List<Superbeing> superbeings) {
        return repository.saveAll(superbeings);
    }

    public Superbeing getSuperbeingById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Superbeing> getSuperbeings() {
        return repository.findAll();
    }

    public String deleteSuperbeing(int id) {
        repository.deleteById(id);
        return "Superbeing " + id + " deleted";
    }

    public Superbeing updateSuperbeing(Superbeing superbeing) {
        Superbeing existingSuperbeing = (Superbeing) repository.findById(superbeing.getId()).orElse(null);
        if (existingSuperbeing == null) {
            return null;
        }
        existingSuperbeing.setRef(superbeing.getRef());
        existingSuperbeing.setName(superbeing.getName());
        existingSuperbeing.setSuperhero(superbeing.isSuperhero());
        existingSuperbeing.setLikability(superbeing.getLikability());
        existingSuperbeing.setActive(superbeing.isActive());
        existingSuperbeing.setEvent_participated_in(superbeing.getEvent_participated_in());
        existingSuperbeing.setEvent_succeeded(superbeing.getEvent_succeeded());
        existingSuperbeing.setEvent_failed(superbeing.getEvent_failed());
        existingSuperbeing.setEvent_caused(superbeing.getEvent_caused());
        existingSuperbeing.setDangerousness(superbeing.getDangerousness());
        existingSuperbeing.setDiscovered_at(superbeing.getDiscovered_at());
        existingSuperbeing.setTreason_risk(superbeing.getTreason_risk());
        existingSuperbeing.setAffiliated(superbeing.isAffiliated());
        existingSuperbeing.setArchive(superbeing.isArchive());

        return repository.save(existingSuperbeing);
    }

}
