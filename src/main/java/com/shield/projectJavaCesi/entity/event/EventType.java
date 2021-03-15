package com.shield.projectJavaCesi.entity.event;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class EventType {
	@Id
	@GeneratedValue
	private int id;
	private String name;
}
