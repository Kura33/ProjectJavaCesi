package com.shield.projectJavaCesi.repository.event;

import com.shield.projectJavaCesi.entity.event.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventTypeRepository extends JpaRepository<EventType, Integer> {
}
