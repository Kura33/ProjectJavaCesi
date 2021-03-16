package com.shield.projectJavaCesi.entity.multipleConnection;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.employee.Employee;

import javax.persistence.*;

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
    @JoinColumn(name="being_id", referencedColumnName = "id")
    private Being being;
}