package com.shield.projectJavaCesi.entity.employee;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.multipleConnection.Media;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;
	private String ref;
	private String function;
	private Date startDate;
	private Date endDate;
	private Boolean active;
	private Boolean archive;
	private String email;
	private String password;
	private String contract;

	public static final String OPEN_ENDED_CONTRACT = "CDI";
	public static final String FIXED_TERM_CONTRACT = "CDD";
	public static final String APPRENTICESHIP = "Alternance";
	public static final String INTERNSHIP = "Internship";
	public static final String NOT_CONCERNED = "N/C";

	public enum Contract {
		OPEN_ENDED_CONTRACT, FIXED_TERM_CONTRACT, APPRENTICESHIP, INTERNSHIP, NOT_CONCERNED;
	}

	@ManyToOne
	@JoinColumn(name = "employee_department_id", referencedColumnName = "id")
	private EmployeeDepartment employeeDepartment;

	@OneToMany(mappedBy = "employee")
	private List<Comment> comment;

	@OneToMany(mappedBy = "employee")
	private List<Media> media;

	@OneToOne(optional = false)
	@JoinColumn(name = "being_id", referencedColumnName = "ID")
	private Being being;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean isArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}
}
