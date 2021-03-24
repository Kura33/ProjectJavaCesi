package com.shield.projectJavaCesi.controller.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.resource.being.CivilResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.employee.EmployeeResource;
import com.shield.projectJavaCesi.service.employee.EmployeeService;

@RestController
@RequestMapping(path = "/shield/employee")
@Transactional
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private EntityManager em;

    /**
     * Sert à recupérer tous les employées.
     *
     * @return une liste de tous les employées.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/")
    public List<EmployeeResource> findAllEmployees() {
        List<Employee> employees = service.getEmployees();
        return Mapper.map(employees, Mapper.employeeToEmployeeResource);
    }

    /**
     * Sert à recupérer un employée.
     *
     * @param id
     * @return un employée.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/{id}")
    public EmployeeResource findEmployeeById(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);
        return Mapper.employeeToEmployeeResource.apply(employee);
    }

    /**
     * Sert à créer une fiche une ou plusieurs employées.
     *
     * @param employee
     * @return une liste d'employées.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2')")
    @PostMapping("/create")
    public List<EmployeeResource> addEmployee(@RequestBody List<Employee> employee) {
        List<Employee> employees = service.saveEmployee(employee);
        em.flush();
        for (Employee employee1 : employees) {
            em.refresh(employee1);
        }
        return Mapper.map(employees, Mapper.employeeToEmployeeResource);
    }

    /**
     * Sert à mettre à jour les informations d'un employée.
     *
     * @param employee
     * @return une liste d'employées.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @PutMapping("/update")
    public EmployeeResource updateEmployee(@RequestBody Employee employee) {
        Employee employees = service.updateEmployee(employee);
        em.flush();
        em.refresh(employees);
        return Mapper.employeeToEmployeeResource.apply(employees);
    }

    /**
     * Sert à supprimer une fiche employée.
     *
     * @param id
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

    /**
     * Sert à supprimer toutes les fiches employées.
     *
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete-all")
    public String deleteEmployees() {
        return service.deleteAllEmployee();
    }
}
