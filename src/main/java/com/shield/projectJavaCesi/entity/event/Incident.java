package com.shield.projectJavaCesi.entity.event;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.multipleConnection.Location;
import com.shield.projectJavaCesi.entity.multipleConnection.Media;

@Entity
@Table(name = "incident")
public class Incident extends Event {
	private Double dangerousness;
	private Status status;

	public enum Status {
		TAKE_IN_CHARGE, WORK_IN_PROGRESS, INTERVENTION_CALLED, REFUSED;
	}

	@OneToMany(mappedBy = "incident")
	private List<Comment> comment;

	@OneToMany(mappedBy = "incident")
	private List<Media> media;

	@OneToMany(mappedBy = "incident")
	private List<Location> location;

	@ManyToMany
	@JoinTable(name = "mission_incident", joinColumns = @JoinColumn(name = "mission_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "incident_id", referencedColumnName = "id"))
	private List<Mission> mission;
	
	@ManyToMany
	@JoinTable(name = "incident_linked_entity", joinColumns = @JoinColumn(name = "being_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "incident_id", referencedColumnName = "id"))
	private List<Being> being;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getDangerousness() {
		return dangerousness;
	}

	public void setDangerousness(Double dangerousness) {
		this.dangerousness = dangerousness;
	}

}
