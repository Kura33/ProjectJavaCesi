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

	public EmployeeDepartment saveEmployeeDepartment(EmployeeDepartment employeeDepartment) {
		return repository.save(employeeDepartment);
	}

	public List<EmployeeDepartment> saveEmlpoyeeDepartments(List<EmployeeDepartment> employeeDepartments) {
		return repository.saveAll(employeeDepartments);
	}

	public EmployeeDepartment getEmployeeDepartmentById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<EmployeeDepartment> getEmployeeDepartments() {
		return repository.findAll();
	}

	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee Department " + id + " deleted";
	}

	public EmployeeDepartment updateIncident(EmployeeDepartment employeeDepartment) {
		EmployeeDepartment existingEmployee = (EmployeeDepartment) repository.findById(employeeDepartment.getId())
				.orElse(null);
		if (existingEmployee == null) {
			return null;
		}
		existingEmployee.setDepartement(employeeDepartment.getDepartement());
		existingEmployee.setCity(employeeDepartment.getCity());
		existingEmployee.setCountry(employeeDepartment.getCountry());

		return repository.save(existingEmployee);
	}
}
