package com.shield.projectJavaCesi.entity.multipleConnection;

import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;

import javax.persistence.*;
import com.shield.projectJavaCesi.entity.being.Being;

@Entity
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String extension;
    private String media; // save as base64

    @ManyToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="superbeing_id", referencedColumnName = "id")
    private Superbeing superbeing;

    @ManyToOne
    @JoinColumn(name="being_id", referencedColumnName = "id")
    private Being being;
    
    @ManyToOne
    @JoinColumn(name = "incident_id", referencedColumnName = "id")
    private Incident incident;
}
