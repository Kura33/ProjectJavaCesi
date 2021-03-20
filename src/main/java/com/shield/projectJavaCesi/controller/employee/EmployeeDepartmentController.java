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
import com.shield.projectJavaCesi.entity.employee.EmployeeDepartment;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.employee.EmployeeDepartmentResource;
import com.shield.projectJavaCesi.service.employee.EmployeeDepartmentService;

@RestController
@RequestMapping(path = "/employeedepartment")
@Transactional
public class EmployeeDepartmentController {

	@Autowired
	private EmployeeDepartmentService service;

	@Autowired
	private EntityManager em;

	@GetMapping("/")
	public List<EmployeeDepartmentResource> findAllEmployeesDepartment() {
		List<EmployeeDepartment> employeeDepartments = service.getEmployeeDepartments();
		return Mapper.map(employeeDepartments, Mapper.employeeDepartmentToEmployeeDepartmentResource);
	}

	@GetMapping("/{id}")
	public EmployeeDepartmentResource findEmployeeById(@PathVariable int id) {
		EmployeeDepartment employeeDepartments = service.getEmployeeDepartmentById(id);
		return Mapper.employeeDepartmentToEmployeeDepartmentResource.apply(employeeDepartments);
	}

	@PostMapping("/create")
	public List<EmployeeDepartmentResource> addEmployeeDepartment(
			@RequestBody List<EmployeeDepartment> employeeDepartment) {
		List<EmployeeDepartment> employeeDepartments = service.saveEmployeeDepartment(employeeDepartment);
		em.flush();
		for (EmployeeDepartment employeeDepartment1 : employeeDepartments) {
			em.refresh(employeeDepartment1);
		}
		return Mapper.map(employeeDepartments, Mapper.employeeDepartmentToEmployeeDepartmentResource);
	}

	@PutMapping("/update")
	public EmployeeDepartmentResource updateEmployeeDepartment(@RequestBody EmployeeDepartment employeeDepartment) {
		EmployeeDepartment employeeDepartments = service.updateEmployeeDepartment(employeeDepartment);
		em.flush();
		em.refresh(employeeDepartments);
		return Mapper.employeeDepartmentToEmployeeDepartmentResource.apply(employeeDepartments);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeDepartmentById(@PathVariable int id) {
		return service.deleteEmployeeDepartment(id);
	}

	@DeleteMapping("/delete-all")
	public String deleteEmployeeDepartments() {
		return service.deleteAllEmployeeDepartment();
	}
}
