package com.shield.projectJavaCesi.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.event.Incident;

public interface IIncidentRepository extends JpaRepository<Incident, Integer> {

}
