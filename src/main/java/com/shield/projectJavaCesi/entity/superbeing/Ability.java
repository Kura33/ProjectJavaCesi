package com.shield.projectJavaCesi.entity.superbeing;


import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.multipleConnection.Media;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ability")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String name;
    private Boolean weakness;

    @OneToMany(mappedBy = "ability")
    private List<Comment> comment;

    @OneToMany(mappedBy = "ability")
    private List<Media> media;


    @ManyToMany
    @JoinTable(name = "superbeing_ability", joinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "superbeing_id", referencedColumnName = "id"))
    private List<Superbeing> superbeing = new ArrayList<>();

    public void addSuperbeing(Superbeing superbeing) {
        this.superbeing.add(superbeing);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isWeakness() {
        return weakness;
    }

    public void setWeakness(Boolean weakness) {
        this.weakness = weakness;
    }
}
