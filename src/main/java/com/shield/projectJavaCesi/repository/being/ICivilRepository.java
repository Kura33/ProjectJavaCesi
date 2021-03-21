package com.shield.projectJavaCesi.repository.being;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.being.Civil;

import java.util.List;

public interface ICivilRepository extends JpaRepository<Civil, Integer> {

    List<Civil> findCivilsByIncidentId(int id);
}
