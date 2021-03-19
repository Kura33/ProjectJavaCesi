package com.shield.projectJavaCesi.entity.being;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Embeddable
public class CivilOnOrganisationId implements Serializable {
	
	static final Long TEST = 1;
	
	@Column(name="civil_id")
	private int civilId;
	
	@Column(name="organisation_id")
	private int organisationId;
	
	private CivilOnOrganisationId() {}
	
	public CivilOnOrganisationId(
			int civilId,
			int OrganisationId) {
		this.civilId = civilId;
		this.organisationId = organisationId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        CivilOnOrganisation that = (CivilOnOrganisation) o;
        return Objects.equals(civilId, that.civilId) &&
               Objects.equals(organisationId, that.organisationId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(civilId, organisationId);
    }
}

@Entity
@Table(name = "civil_on_organisation")

public class CivilOnOrganisation {

	//@Column(name="civil_id")
	@Id
	@ManyToOne
	@JoinColumn(name="civil_id",referencedColumnName="id")
	private Civil civil;
	//@Column(name="organisation_id")
	@Id
	@ManyToOne()
	@JoinColumn(name="organisation_id",referencedColumnName="id")
	private Organisation organisation;
	
	
	
	
	
}
