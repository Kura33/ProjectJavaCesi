package com.shield.projectJavaCesi.controller.being;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.service.being.BeingService;

@RestController
@RequestMapping(path = "/shield/being")
public class BeingController {

	@Autowired
	private BeingService service;

	/**
	 * sert à créer un ou plusieurs civils ou une ou plusieurs organisations
	 * @param beings liste de civils et d'organisations
	 * @return liste de civils et organisations
	 */
	@PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
	@PostMapping("/create")
	public List<Being> addBeings(@RequestBody List<Being> beings){
		return service.saveBeings(beings);
	}

	/**
	 * sert à recupérer un cilvil ou une organisation
	 * @param id
	 * @return un civil ou une organisation
	 */
	@PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
	@GetMapping("/{id}")
	public Being findBeingById(@PathVariable int id){
		return service.getBeingById(id);
	}

	/**
	 * sert à recupérer l'ensemble des civils ou organisations
	 * @return une liste de civils ou organisations
	 */
	@PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
	@GetMapping("/")
	public List<Being> findAllBeing(){
		return service.getBeings();
	}

}
