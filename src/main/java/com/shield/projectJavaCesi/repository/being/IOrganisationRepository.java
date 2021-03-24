package com.shield.projectJavaCesi.repository.being;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.being.Organisation;

import java.util.List;

public interface IOrganisationRepository extends JpaRepository<Organisation, Integer> {

    List<Organisation> findOrganisationsByIncidentId(int id);

}
