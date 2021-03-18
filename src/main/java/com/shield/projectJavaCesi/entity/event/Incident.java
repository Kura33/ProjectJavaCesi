package com.shield.projectJavaCesi.entity.event;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String status;

	public static final String TAKE_IN_CHARGE = "À prendre en charge";
	public static final String WORK_IN_PROGRESS = "Traitement en cours";
	public static final String INTERVENTION_CALLED = "Intervention demandée";
	public static final String REFUSED = "Refusée";

	public enum Status {
		TAKE_IN_CHARGE, WORK_IN_PROGRESS, INTERVENTION_CALLED, REFUSED;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_type_id", referencedColumnName = "id")
	private EventType eventType;

	@OneToMany(mappedBy = "incident")
	private List<Comment> comment;

	@OneToMany(mappedBy = "incident")
	private List<Media> media;

	@OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, orphanRemoval = true)
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
