package com.shield.projectJavaCesi.entity.multipleConnection;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shield.projectJavaCesi.entity.event.Incident;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "location", referencedColumnName = "id")
	private Incident incident;
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comment;
}
