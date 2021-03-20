package com.shield.projectJavaCesi.entity.multipleConnection;

import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.entity.employee.EmployeeDepartment;
import com.shield.projectJavaCesi.entity.event.EventType;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.event.Mission;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import com.shield.projectJavaCesi.entity.being.Being;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;
	private String comments;

	@ManyToOne
	@JoinColumn(name = "superbeing_id", referencedColumnName = "id")
	private Superbeing superbeing;
	
	@ManyToOne
	@JoinColumn(name = "being_id", referencedColumnName = "id")
	private Being being;

//    @ManyToOne
//    @JoinColumn(name = "access_role_id", referencedColumnName = "id")
//    private List<AccessRole> accessRole;

	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

//    @ManyToOne
//    @JoinColumn(name="ability_id", referencedColumnName = "id")
//    private List<Ability> ability;

	@ManyToOne
	@JoinColumn(name = "employee_department_id", referencedColumnName = "id")
	private EmployeeDepartment employeeDepartment;

	@ManyToOne
	@JoinColumn(name = "location_id", referencedColumnName = "id")
	private Location location;

	@ManyToOne
	@JoinColumn(name = "media_id", referencedColumnName = "id")
	private Media media;

//    @ManyToOne
//    @JoinColumn(name = "feedback_id", referencedColumnName = "id")
//    private List<Feedback> feedback;
//    
//    @ManyToOne
//    @JoinColumn(name = "litige_id", referencedColumnName = "id")
//    private List<Litige> litige;
//    
	@ManyToOne
	@JoinColumn(name = "event_type_id", referencedColumnName = "id")
	private EventType eventType;

	@ManyToOne
	@JoinColumn(name = "incident_id", referencedColumnName = "id")
	private Incident incident;

	@ManyToOne
	@JoinColumn(name = "mission_id", referencedColumnName = "id")
	private Mission mission;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Superbeing getSuperbeing() {
		return superbeing;
	}

	public void setSuperbeing(Superbeing superbeing) {
		this.superbeing = superbeing;
	}

	public Being getBeing() {
		return being;
	}

	public void setBeing(Being being) {
		this.being = being;
	}

//	public AccessRole getAccessRole() {
//		return accessRole;
//	}
//
//	public void setAccessRole(AccessRole accessRole) {
//		this.accessRole = accessRole;
//	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

//	public List<Ability> getAbility() {
//		return ability;
//	}
//
//	public void setAbility(List<Ability> ability) {
//		this.ability = ability;
//	}

	public EmployeeDepartment getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(EmployeeDepartment employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

//	public Feedback getFeedback() {
//		return feedback;
//	}
//
//	public void setFeedback(Feedback feedback) {
//		this.feedback = feedback;
//	}
//
//	public Litige getLitige() {
//		return litige;
//	}
//
//	public void setLitige(Litige litige) {
//		this.litige = litige;
//	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}
}
