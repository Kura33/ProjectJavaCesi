package com.shield.projectJavaCesi.entity.being;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CIVIL")
public class Civil extends Being {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private String gender;
	
	public static final String MR = "M";
	public static final String MME = "Mme";

	public enum Gender {
		MR, MME;
	}
	
}