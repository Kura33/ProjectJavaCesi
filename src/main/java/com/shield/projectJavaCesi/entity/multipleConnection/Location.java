package com.shield.projectJavaCesi.entity.multipleConnection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shield.projectJavaCesi.entity.event.Incident;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "incident_id", referencedColumnName = "id")
	private Incident incident;
}
