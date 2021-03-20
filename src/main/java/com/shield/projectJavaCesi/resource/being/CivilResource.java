package com.shield.projectJavaCesi.resource.being;

import com.shield.projectJavaCesi.entity.superbeing.Superbeing;

import java.util.Date;
import java.util.List;

public class CivilResource {
	public int id;
	public String firstname;
	public String lastname;
	public String socialSecurityNumber;
	public String title;
	public String gender;
	public String ref;
//	public Boolean organisation;
	public Boolean malevolant;
	public String email;
	public String password;
	public Date birthdate;
	public Date deathdate;
	public String address;
	public String city;
	public String state;
	public String zipcode;
	public String country;
	public String mobilePhone;
	public Date addedAt;
	public Date updatedAt;
	public int howManyDeclaredIncident;
	public int victimOfHowManyMission;
	public Boolean archive;
	public Boolean active;
	public List<Superbeing> superbeing;
}
