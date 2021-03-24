package com.shield.projectJavaCesi.repository.superbeing;

import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISuperbeingRepository extends JpaRepository<Superbeing, Integer> {

    List<Superbeing> findSuperbeingsByIncidentId(int id);
}

