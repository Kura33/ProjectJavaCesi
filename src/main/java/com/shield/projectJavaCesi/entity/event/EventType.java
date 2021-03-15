package com.shield.projectJavaCesi.entity.event;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "event_type")
public class EventType {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy = "event_type")
	private List<Event> event;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}
}
