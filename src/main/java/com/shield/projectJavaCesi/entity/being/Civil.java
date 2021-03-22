package com.shield.projectJavaCesi.entity.being;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("0")
public class Civil extends Being {

    private String firstname;
    private String lastname;
    private String socialSecurityNumber;
    private String title;
    private String gender;

    public static final String TITLE_MR = "Mr";
    public static final String TITLE_MME = "Mme";

    public enum Title {
        TITLE_MR, TITLE_MME
    }

    public static final String GENDER_MR = "male";
    public static final String GENDER_MME = "femal";
    public static final String GENDER_OTHER = "other";

    public enum Gender {
        GENDER_MR, GENDER_MME
    }

    @ManyToOne
    @JoinColumn(name = "access_role_id", referencedColumnName = "id")
    private AccessRole accessRole;

    @ManyToMany
    @JoinTable(name = "civil_on_organisation", joinColumns = @JoinColumn(name = "organisation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "civil_id", referencedColumnName = "id"))
    private List<Organisation> organisations = new ArrayList<>();

    public void addOrganisation(Organisation organisation) {
        this.organisations.add(organisation);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Organisation> getOrganisation() {
        return organisations;
    }

    public AccessRole getAccessRole() {
        return accessRole;
    }

    public void setAccessRole(AccessRole accessRole) {
        this.accessRole = accessRole;
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(List<Organisation> organisations) {
        this.organisations = organisations;
    }
}