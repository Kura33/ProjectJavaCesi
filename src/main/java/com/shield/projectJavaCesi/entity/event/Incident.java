package com.shield.projectJavaCesi.entity.event;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.multipleConnection.Location;
import com.shield.projectJavaCesi.entity.multipleConnection.Media;

@Entity
@Table(name = "incident")
public class Incident extends Event {
	private Double dangerousness;

	// @Enumerated(EnumType.STRING)
	private String status;

//	public enum Status {
//		TAKE_IN_CHARGE("À prendre en charge"), WORK_IN_PROGRESS("Traitement en cours"), INTERVENTION_CALLED("Intervention demandée"), REFUSED("Refusée");
//
//		Status(Status status) {
//			this.status
//		}
//	}
	@ManyToOne
	@JoinColumn(name = "event_type_id", referencedColumnName = "id")
	private EventType eventType;

	@OneToMany(mappedBy = "incident")
	private List<Comment> comment;

	@OneToMany(mappedBy = "incident")
	private List<Media> media;

	@OneToMany(mappedBy = "incident")
	private List<Location> location;

	@ManyToMany
	@JoinTable(name = "mission_incident", joinColumns = @JoinColumn(name = "mission_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "incident_id", referencedColumnName = "id"))
	private List<Mission> mission = new ArrayList<>();

	public void addMission(Mission mission) {
		this.mission.add(mission);
	}

	@ManyToMany

	@JoinTable(name = "incident_linked_entity", joinColumns = @JoinColumn(name = "incident_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "being_id", referencedColumnName = "id"))
	private List<Being> being = new ArrayList<>();

	public void addBeing(Being being) {
		this.being.add(being);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getDangerousness() {
		return dangerousness;
	}

	public void setDangerousness(Double dangerousness) {
		this.dangerousness = dangerousness;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

}
