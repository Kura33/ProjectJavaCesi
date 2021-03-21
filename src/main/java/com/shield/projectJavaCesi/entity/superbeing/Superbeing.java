package com.shield.projectJavaCesi.entity.superbeing;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.multipleConnection.Media;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "superbeing")
public class Superbeing {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String ref;
    private String name;
    private Boolean superhero;
    private Double likability;
    private Boolean active;
    private int eventParticipatedIn;
    private int eventSucceeded;
    private int eventFailed;
    private int eventCaused;
    private int arrestNumber;
    private Double collateralDamageRisk;
    private Double dangerousness;
    private Date discoveredAt;
    private Double treasonRisk;
    private Boolean affiliated;
    private Boolean archive;

    @OneToMany(mappedBy = "superbeing")
    private List<Being> being;

    @OneToMany(mappedBy = "superbeing")
    private List<Comment> comment;

    @OneToMany(mappedBy = "superbeing")
    private List<Media> media;

    @ManyToMany
    @JoinTable(name = "superbeing_ability", joinColumns = @JoinColumn(name = "superbeing_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "id"))
    private List<Ability> ability = new ArrayList<>();

    public void addAbility(Ability ability) {
        this.ability.add(ability);
    }

    @ManyToMany(mappedBy = "superbeing")
    private List<Incident> incident = new ArrayList<>();

    public void addIncident(Incident incident) {
        this.incident.add(incident);
    }

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

    public int getEventParticipatedIn() {
        return eventParticipatedIn;
    }

    public void setEventParticipatedIn(int event_participated_in) {
        this.eventParticipatedIn = event_participated_in;
    }

    public int getEventSucceeded() {
        return eventSucceeded;
    }

    public void setEventSucceeded(int event_succeeded) {
        this.eventSucceeded = event_succeeded;
    }

    public int getEventFailed() {
        return eventFailed;
    }

    public void setEventFailed(int event_failed) {
        this.eventFailed = event_failed;
    }

    public int getEventCaused() {
        return eventCaused;
    }

    public void setEventCaused(int event_caused) {
        this.eventCaused = event_caused;
    }

    public int getArrestNumber() {
        return arrestNumber;
    }

    public void setArrestNumber(int arrest_number) {
        this.arrestNumber = arrest_number;
    }

    public Double getCollateralDamageRisk() {
        return collateralDamageRisk;
    }

    public void setCollateralDamageRisk(Double collateral_damage_risk) {
        this.collateralDamageRisk = collateral_damage_risk;
    }

    public Double getDangerousness() {
        return dangerousness;
    }

    public void setDangerousness(Double dangerousness) {
        this.dangerousness = dangerousness;
    }

    public Date getDiscoveredAt() {
        return discoveredAt;
    }

    public void setDiscoveredAt(Date discovered_at) {
        this.discoveredAt = discovered_at;
    }

    public Double getTreasonRisk() {
        return treasonRisk;
    }

    public void setTreasonRisk(Double treason_risk) {
        this.treasonRisk = treason_risk;
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
