package com.shield.projectJavaCesi.repository.being;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.being.Civil;

public interface ICivilRepository extends JpaRepository<Civil, Integer> {

}
