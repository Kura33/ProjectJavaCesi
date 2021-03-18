package com.shield.projectJavaCesi.service.superbeing;

import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.repository.superbeing.ISuperbeingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperbeingService {

    @Autowired
    private ISuperbeingRepository repository;

    public List<Superbeing> getSuperbeings() {
        return repository.findAll();
    }

    public Superbeing getSuperbeingById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Superbeing> saveSuperbeing(List<Superbeing> superbeings) {
        return repository.saveAll(superbeings);
    }


    public Superbeing updateSuperbeing(Superbeing superbeing) {
        Superbeing existingSuperbeing = repository.findById(superbeing.getId()).orElse(null);
        if (existingSuperbeing == null) {
            return null;
        }
        if (superbeing.getRef() != null) {

            existingSuperbeing.setRef(superbeing.getRef());
        }
        existingSuperbeing.setName(superbeing.getName());
        existingSuperbeing.setSuperhero(superbeing.isSuperhero());
        existingSuperbeing.setLikability(superbeing.getLikability());
        if (superbeing.isActive() != null) {
        existingSuperbeing.setActive(superbeing.isActive());
        }
        if (superbeing.getEventParticipatedIn() != 0) {
        existingSuperbeing.setEventParticipatedIn(superbeing.getEventParticipatedIn());
        }
        if (superbeing.getEventSucceeded() != 0) {
        existingSuperbeing.setEventSucceeded(superbeing.getEventSucceeded());
        }
        if (superbeing.getEventFailed() != 0) {
        existingSuperbeing.setEventFailed(superbeing.getEventFailed());
        }
        if (superbeing.getEventCaused() != 0) {
        existingSuperbeing.setEventCaused(superbeing.getEventCaused());
        }
        if (superbeing.getDangerousness() != 0) {
        existingSuperbeing.setDangerousness(superbeing.getDangerousness());
        }
        if (superbeing.getDiscoveredAt() != null) {
        existingSuperbeing.setDiscoveredAt(superbeing.getDiscoveredAt());
        }
        if (superbeing.getTreasonRisk() != 0) {
        existingSuperbeing.setTreasonRisk(superbeing.getTreasonRisk());
        }
        if (superbeing.isAffiliated() != null) {
        existingSuperbeing.setAffiliated(superbeing.isAffiliated());
        }
        if (superbeing.isArchive() != null) {
        existingSuperbeing.setArchive(superbeing.isArchive());
        }

        return repository.save(existingSuperbeing);
    }

    public String deleteSuperbeing(int id) {
        repository.deleteById(id);
        return "Superbeing " + id + " deleted";
    }

    public String deleteAllSuperbeing() {
        repository.deleteAll();
        return "All Superbeings deleted";
    }

}
