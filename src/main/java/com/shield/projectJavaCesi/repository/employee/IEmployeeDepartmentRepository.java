package com.shield.projectJavaCesi.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shield.projectJavaCesi.entity.employee.EmployeeDepartment;

public interface IEmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, Integer> {

}
