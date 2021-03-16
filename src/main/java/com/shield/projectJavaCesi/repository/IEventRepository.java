package com.shield.projectJavaCesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shield.projectJavaCesi.entity.event.Event;

public interface IEventRepository extends JpaRepository<Event, Integer>{

}
