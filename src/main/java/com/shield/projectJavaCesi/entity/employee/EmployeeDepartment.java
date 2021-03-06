package com.shield.projectJavaCesi.entity.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;

@Entity
@Table(name = "employee_department")
public class EmployeeDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;
	private String department;
	private String city;
	private String country;

	@OneToMany(mappedBy = "employeeDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employee;

	@OneToMany(mappedBy = "employeeDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartement() {
		return department;
	}

	public void setDepartement(String department) {
		this.department = department;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
