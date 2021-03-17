package com.shield.projectJavaCesi.service.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.repository.employee.IEmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private IEmployeeRepository repository;

	public List<Employee> saveEmlpoyees(List<Employee> employees) {
		return repository.saveAll(employees);
	}

	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Employee> getEmployee() {
		return repository.findAll();
	}

	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee " + id + " deleted";
	}
	public String deleteAllEmployee() {
		repository.deleteAll();
		return "All Employees deleted";
	}

	public Employee updateIncident(Employee employee) {
		Employee existingEmployee = (Employee) repository.findById(employee.getId()).orElse(null);
		if (existingEmployee == null) {
			return null;
		}
		existingEmployee.setRef(employee.getRef());
		existingEmployee.setFunction(employee.getFunction());
		existingEmployee.setStartDate(employee.getStartDate());
		existingEmployee.setEndDate(employee.getEndDate());
		existingEmployee.setActive(employee.isActive());
		existingEmployee.setArchive(employee.isArchive());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setPassword(employee.getPassword());
		existingEmployee.setContract(employee.getContract());

		return repository.save(existingEmployee);
	}
}
