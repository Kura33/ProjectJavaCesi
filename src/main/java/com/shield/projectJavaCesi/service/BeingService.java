package com.shield.projectJavaCesi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.employee.EmployeeDepartment;
import com.shield.projectJavaCesi.repository.IBeingRepository;

@Service
public class BeingService {
	@Autowired
	private IBeingRepository repository;
	
	public Being saveBeing(Being being) {
		return repository.save(being);
	}
		
	public List<Being> saveBeings(List<Being> beings) {
		return repository.saveAll(beings);
	}
	
	public Being getBeingById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Being> getBeings() {
		return repository.findAll();
	}
	
	public String deleteBeing(int id) {
		repository.deleteById(id);
		return "Being " + id + " deleted";
	}
	
	public Being updateBeing(Being being) {
		Being existingBeing=repository.findById(being.getId()).orElse(null);
		existingBeing.setId(being.getId());
		existingBeing.setOrganisation(being.isOrganisation());
		existingBeing.setMalevolant(being.isMalevolant());
		existingBeing.setEmail(being.getEmail());
		existingBeing.setPassword(being.getPassword());
		existingBeing.setBirthdate(being.getBirthdate());
		existingBeing.setDeathdate(being.getDeathdate());
		existingBeing.setAddress(being.getAddress());
		existingBeing.setCity(being.getCity());
		existingBeing.setState(being.getState());
		existingBeing.setZipcode(being.getZipcode());
		existingBeing.setMobilePhone(being.getMobilePhone());
		existingBeing.setAddedAt(being.getAddedAt());
		existingBeing.setUpdateAt(being.getUpdateAt());
		existingBeing.setHowManyDeclaredIncident(being.getHowManyDeclaredIncident());
		existingBeing.setVictimOfHowManyMission(being.getVictimOfHowManyMission());
		existingBeing.setArchive(being.isArchive());
		existingBeing.setComment(being.getComment());
		existingBeing.setMedia(being.getMedia());
		return repository.save(existingBeing);
	}
}
