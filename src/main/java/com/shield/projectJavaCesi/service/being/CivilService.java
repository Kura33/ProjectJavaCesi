package com.shield.projectJavaCesi.service.being;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.repository.being.ICivilRepository;

@Service
public class CivilService {

	@Autowired
	private ICivilRepository repository;
	
	public List<Civil> saveCivil(List<Civil> civils) {
		return repository.saveAll(civils);
	}

	public Civil getCivilById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Civil> getCivils() {
		return repository.findAll();
	}

	public String deleteCivil(int id) {
		repository.deleteById(id);
		return "Civil " + id + " deleted";
	}

	public String deleteAllCivil() {
		repository.deleteAll();
		return "All Civils deleted";
	}

	public Civil updateCivil(Civil civil) {
		Civil existingCivil = repository.findById(civil.getId()).orElse(null);
		if (existingCivil == null) {
			return null;
		}
		if (civil.getFirstname() != null) {
			existingCivil.setFirstName(civil.getFirstname());
		}
		if (civil.getLastName() != null) {
			existingCivil.setLastName(civil.getLastName());
		}
		if (civil.getSocialSecurityNumber() != null) {
			existingCivil.setSocialSecurityNumber(civil.getSocialSecurityNumber());
		}
		if (civil.getGender() != null) {
			existingCivil.setGender(civil.getGender());
		}
//		if (civil.isOrganisation() != null) {
//			existingCivil.setOrganisation(civil.isOrganisation());
//		}
		if (civil.isMalevolant() != null) {
			existingCivil.setMalevolant(civil.isMalevolant());
		}
		if (civil.getEmail() != null) {
			existingCivil.setEmail(civil.getEmail());
		}
		if (civil.getPassword() != null) {
			existingCivil.setPassword(civil.getPassword());
		}
		if (civil.getBirthdate() != null) {
			existingCivil.setBirthdate(civil.getBirthdate());
		}
		if (civil.getDeathdate() != null) {
			existingCivil.setDeathdate(civil.getDeathdate());
		}
		if (civil.getAddress() != null) {
			existingCivil.setAddress(civil.getAddress());
		}
		if (civil.getCity() != null) {
			existingCivil.setCity(civil.getCity());
		}
		if (civil.getState() != null) {
			existingCivil.setState(civil.getState());
		}
		if (civil.getZipcode() != null) {
			existingCivil.setZipcode(civil.getZipcode());
		}
		if (civil.getMobilePhone() != null) {
			existingCivil.setMobilePhone(civil.getMobilePhone());
		}
		if (civil.getAddedAt() != null) {
			existingCivil.setAddedAt(civil.getAddedAt());
		}
		if (civil.getUpdatedAt() != null) {
			existingCivil.setUpdatedAt(civil.getUpdatedAt());
		}
		if (civil.getHowManyDeclaredIncident() != 0) {
			existingCivil.setHowManyDeclaredIncident(civil.getHowManyDeclaredIncident());
		}
		if (civil.getVictimOfHowManyMission() != 0) {
			existingCivil.setVictimOfHowManyMission(civil.getVictimOfHowManyMission());
		}
		if (civil.isArchive() != null) {
			existingCivil.setArchive(civil.isArchive());
		}
		if (civil.getComment() != null) {
			existingCivil.setComment(civil.getComment());
		}
		if (civil.getMedia() != null) {
			existingCivil.setMedia(civil.getMedia());
		}
		return repository.save(existingCivil);
	}

}
