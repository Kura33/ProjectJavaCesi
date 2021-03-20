package com.shield.projectJavaCesi.repository.being;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.being.Organisation;

public interface IOrganisationRepository extends JpaRepository<Organisation, Integer> {

}
