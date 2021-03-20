package com.shield.projectJavaCesi.entity.being;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "access_role")
public class AccessRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String name;
    private int accredition;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAccredition() { return accredition; }

    public void setAccredition(int accredition) { this.accredition = accredition; }

}
