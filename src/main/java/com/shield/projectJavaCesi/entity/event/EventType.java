package com.shield.projectJavaCesi.entity.event;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shield.projectJavaCesi.entity.multipleConnection.Comment;

@Entity
@Table(name = "event_type")
public class EventType {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	@OneToMany(mappedBy = "eventType", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Incident> incident;
	@OneToMany(mappedBy = "eventType", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comment;

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

	public List<Incident> getIncident() {
		return incident;
	}

	public void setIncident(List<Incident> incident) {
		this.incident = incident;
	}
}
