package com.shield.projectJavaCesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.being.Being;

public interface IBeingRepository extends JpaRepository<Being, Integer> {

}
