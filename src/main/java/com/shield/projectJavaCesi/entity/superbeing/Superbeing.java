package com.shield.projectJavaCesi.entity.superbeing;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.multipleConnection.Media;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "superbeing")
public class Superbeing {

    @Id
    @GeneratedValue
    private int id;
    private String ref;
    private String name;
    private Boolean superhero;
    private Double likability;
    private Boolean active;
    private int event_participated_in;
    private int event_succeeded;
    private int event_failed;
    private int event_caused;
    private int arrest_number;
    private Double collateral_damage_risk;
    private Double dangerousness;
    private Date discovered_at;
    private Double treason_risk;
    private Boolean affiliated;
    private Boolean archive;

    @OneToMany(mappedBy = "superbeing")
    private List<Being> being;

    private int being_id;

    @OneToMany(mappedBy = "superbeing")
    private List<Comment> comment;

    @OneToMany(mappedBy = "superbeing")
    private List<Media> media;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isSuperhero() {
        return superhero;
    }

    public void setSuperhero(Boolean superhero) {
        this.superhero = superhero;
    }

    public Double getLikability() {
        return likability;
    }

    public void setLikability(Double likability) {
        this.likability = likability;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getEvent_participated_in() {
        return event_participated_in;
    }

    public void setEvent_participated_in(int event_participated_in) {
        this.event_participated_in = event_participated_in;
    }

    public int getEvent_succeeded() {
        return event_succeeded;
    }

    public void setEvent_succeeded(int event_succeeded) {
        this.event_succeeded = event_succeeded;
    }

    public int getEvent_failed() {
        return event_failed;
    }

    public void setEvent_failed(int event_failed) {
        this.event_failed = event_failed;
    }

    public int getEvent_caused() {
        return event_caused;
    }

    public void setEvent_caused(int event_caused) {
        this.event_caused = event_caused;
    }

    public int getArrest_number() {
        return arrest_number;
    }

    public void setArrest_number(int arrest_number) {
        this.arrest_number = arrest_number;
    }

    public Double getCollateral_damage_risk() {
        return collateral_damage_risk;
    }

    public void setCollateral_damage_risk(Double collateral_damage_risk) {
        this.collateral_damage_risk = collateral_damage_risk;
    }

    public Double getDangerousness() {
        return dangerousness;
    }

    public void setDangerousness(Double dangerousness) {
        this.dangerousness = dangerousness;
    }

    public Date getDiscovered_at() {
        return discovered_at;
    }

    public void setDiscovered_at(Date discovered_at) {
        this.discovered_at = discovered_at;
    }

    public Double getTreason_risk() {
        return treason_risk;
    }

    public void setTreason_risk(Double treason_risk) {
        this.treason_risk = treason_risk;
    }

    public Boolean isAffiliated() {
        return affiliated;
    }

    public void setAffiliated(Boolean affiliated) {
        this.affiliated = affiliated;
    }

    public Boolean isArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }
}
