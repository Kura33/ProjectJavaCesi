package com.shield.projectJavaCesi.service.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shield.projectJavaCesi.entity.employee.EmployeeDepartment;
import com.shield.projectJavaCesi.repository.employee.IEmployeeDepartmentRepository;

@Service
public class EmployeeDepartmentService {
	@Autowired
	private IEmployeeDepartmentRepository repository;

	public List<EmployeeDepartment> saveEmployeeDepartment(List<EmployeeDepartment> employeeDepartments) {
		return repository.saveAll(employeeDepartments);
	}

	public EmployeeDepartment getEmployeeDepartmentById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<EmployeeDepartment> getEmployeeDepartments() {
		return repository.findAll();
	}

	public String deleteEmployeeDepartment(int id) {
		repository.deleteById(id);
		return "Employee Department " + id + " deleted";
	}

	public String deleteAllEmployeeDepartment() {
		repository.deleteAll();
		return "All Employee Departments deleted";
	}

	public EmployeeDepartment updateEmployeeDepartment(EmployeeDepartment employeeDepartment) {
		EmployeeDepartment existingEmployeeDepartment = (EmployeeDepartment) repository.findById(employeeDepartment.getId()).orElse(null);
		if (existingEmployeeDepartment == null) {
			return null;
		}
		if (employeeDepartment.getDepartement() != null) {
			existingEmployeeDepartment.setDepartement(employeeDepartment.getDepartement());
		}
		if (employeeDepartment.getCity() != null) {
			existingEmployeeDepartment.setCity(employeeDepartment.getCity());
		}
		if (employeeDepartment.getCountry() != null) {
			existingEmployeeDepartment.setCountry(employeeDepartment.getCountry());
		}
		return repository.save(existingEmployeeDepartment);
	}
}
