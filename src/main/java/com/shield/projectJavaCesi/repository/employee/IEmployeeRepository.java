package com.shield.projectJavaCesi.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.employee.Employee;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
