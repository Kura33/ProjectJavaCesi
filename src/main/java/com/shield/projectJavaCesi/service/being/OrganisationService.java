package com.shield.projectJavaCesi.service.being;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.entity.being.Organisation;
import com.shield.projectJavaCesi.repository.being.ICivilRepository;
import com.shield.projectJavaCesi.repository.being.IOrganisationRepository;

@Service
public class OrganisationService {

	@Autowired
	private IOrganisationRepository repository;
	
	public List<Organisation> saveOrganisation(List<Organisation> organisations) {
		return repository.saveAll(organisations);
	}

	public Organisation getOrganisationById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Organisation> getOrganisations() {
		return repository.findAll();
	}

	public String deleteOrganisation(int id) {
		repository.deleteById(id);
		return "Organisation " + id + " deleted";
	}

	public String deleteAllOrganisation() {
		repository.deleteAll();
		return "All Organisations deleted";
	}

	public Organisation updateOrganisation(Organisation organisation) {
		Organisation existingOrganisation = repository.findById(organisation.getId()).orElse(null);
		if (existingOrganisation == null) {
			return null;
		}
		if (organisation.getName() != null) {
			existingOrganisation.setName(organisation.getName());
		}
		if (organisation.getSiret() != null) {
			existingOrganisation.setSiret(organisation.getSiret());
		}
		if (organisation.isOrganisation() != null) {
			existingOrganisation.setOrganisation(organisation.isOrganisation());
		}
		if (organisation.isMalevolant() != null) {
			existingOrganisation.setMalevolant(organisation.isMalevolant());
		}
		if (organisation.getEmail() != null) {
			existingOrganisation.setEmail(organisation.getEmail());
		}
		if (organisation.getPassword() != null) {
			existingOrganisation.setPassword(organisation.getPassword());
		}
		if (organisation.getBirthdate() != null) {
			existingOrganisation.setBirthdate(organisation.getBirthdate());
		}
		if (organisation.getDeathdate() != null) {
			existingOrganisation.setDeathdate(organisation.getDeathdate());
		}
		if (organisation.getAddress() != null) {
			existingOrganisation.setAddress(organisation.getAddress());
		}
		if (organisation.getCity() != null) {
			existingOrganisation.setCity(organisation.getCity());
		}
		if (organisation.getState() != null) {
			existingOrganisation.setState(organisation.getState());
		}
		if (organisation.getZipcode() != null) {
			existingOrganisation.setZipcode(organisation.getZipcode());
		}
		if (organisation.getMobilePhone() != null) {
			existingOrganisation.setMobilePhone(organisation.getMobilePhone());
		}
		if (organisation.getAddedAt() != null) {
			existingOrganisation.setAddedAt(organisation.getAddedAt());
		}
		if (organisation.getUpdateAt() != null) {
			existingOrganisation.setUpdateAt(organisation.getUpdateAt());
		}
		if (organisation.getHowManyDeclaredIncident() != 0) {
			existingOrganisation.setHowManyDeclaredIncident(organisation.getHowManyDeclaredIncident());
		}
		if (organisation.getVictimOfHowManyMission() != 0) {
			existingOrganisation.setVictimOfHowManyMission(organisation.getVictimOfHowManyMission());
		}
		if (organisation.isArchive() != null) {
			existingOrganisation.setArchive(organisation.isArchive());
		}
		if (organisation.getComment() != null) {
			existingOrganisation.setComment(organisation.getComment());
		}
		if (organisation.getMedia() != null) {
			existingOrganisation.setMedia(organisation.getMedia());
		}
		return repository.save(existingOrganisation);
	}

}
