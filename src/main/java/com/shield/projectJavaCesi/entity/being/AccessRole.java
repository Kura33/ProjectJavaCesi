package com.shield.projectJavaCesi.entity.being;

import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "access_role")
public class AccessRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String name;
    private int accreditation;

    @OneToMany(mappedBy = "accessRole", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Civil> civil;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAccreditation() { return accreditation; }

    public void setAccreditation(int accreditation) { this.accreditation = accreditation; }

}
