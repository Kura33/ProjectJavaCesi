package com.shield.projectJavaCesi.controller.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.employee.EmployeeResource;
import com.shield.projectJavaCesi.resource.event.IncidentResource;
import com.shield.projectJavaCesi.service.employee.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
@Transactional
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EntityManager em;

	@GetMapping("/")
	public List<EmployeeResource> findAllEmployees() {
		List<Employee> employees = service.getEmployees();
		return Mapper.map(employees, Mapper.employeeToEmployeeResource);
	}
	@GetMapping("/{id}")
	public EmployeeResource findEmployeeById(@PathVariable int id) {
		Employee employee = service.getEmployeeById(id);
		return Mapper.employeeToEmployeeResource.apply(employee);
	}
	@PostMapping("/create")
	public List<EmployeeResource> addEmployee(@RequestBody List<Employee> employee) {
		List<Employee> employees = service.saveEmployee(employee);
		em.flush();
		for (Employee employee1 : employees) {

			em.refresh(employee1);
		}
		return Mapper.map(employees, Mapper.employeeToEmployeeResource);
	}
	@PutMapping("/update")
	public EmployeeResource updateEmployee(@RequestBody Employee employee) {
		Employee employees = service.updateEmployee(employee);
		em.flush();
		em.refresh(employees);

		return Mapper.employeeToEmployeeResource.apply(employees);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		return service.deleteEmployee(id);
	}

	@DeleteMapping("/delete-all")
	public String deleteEmployees() {
		return service.deleteAllEmployee();
	}
	
}
