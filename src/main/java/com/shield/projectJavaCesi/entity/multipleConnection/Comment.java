package com.shield.projectJavaCesi.entity.multipleConnection;

import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private int id;
    private String comments;

    @ManyToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="superbeing_id", referencedColumnName = "id")
    private Superbeing superbeing;
}
