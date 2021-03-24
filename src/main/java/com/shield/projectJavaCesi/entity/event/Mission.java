package com.shield.projectJavaCesi.entity.event;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shield.projectJavaCesi.entity.multipleConnection.Comment;

@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue
    private int id;
    
	@ManyToMany
	@JoinTable(name = "mission_incident", joinColumns = @JoinColumn(name = "incident_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "mission_id", referencedColumnName = "id"))
	private List<Incident> incident = new ArrayList<>();
	
	@OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comment;
	
}
