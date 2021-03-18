package com.shield.projectJavaCesi.controller.employee;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shield.projectJavaCesi.service.employee.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
@Transactional
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EntityManager em;

}
