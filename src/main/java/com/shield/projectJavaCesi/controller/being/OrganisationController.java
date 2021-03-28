package com.shield.projectJavaCesi.controller.being;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shield.projectJavaCesi.entity.being.Organisation;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.being.OrganisationResource;
import com.shield.projectJavaCesi.service.being.OrganisationService;

@RestController
@RequestMapping(path = "/shield/organisation")
@Transactional
public class OrganisationController {
    @Autowired
    private OrganisationService service;

    @Autowired
    private EntityManager em;

    /**
     * Sert à recuperer toutes les organisations.
     *
     * @return une liste de toutes les organisations.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/")
    public List<OrganisationResource> findAllOrganisations() {
        List<Organisation> organisations = service.getOrganisations();
        return Mapper.map(organisations, Mapper.organisationToOrganisationResource);
    }

    /**
     * Sert à recupérer une organisation.
     *
     * @param id
     * @return une organisation.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/{id}")
    public OrganisationResource findOrganisationById(@PathVariable int id) {
        Organisation organisation = service.getOrganisationById(id);
        return Mapper.organisationToOrganisationResource.apply(organisation);
    }

    /**
     * Sert à créer une fiche uen ou plusieurs organisations.
     *
     * @param organisation
     * @return une liste d'organisations.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @PostMapping("/create")
    public List<OrganisationResource> addOrganisation(@RequestBody List<Organisation> organisation) {
        List<Organisation> organisations = service.saveOrganisation(organisation);
        em.flush();
        for (Organisation organisation1 : organisations) {
            em.refresh(organisation1);
        }
        return Mapper.map(organisations, Mapper.organisationToOrganisationResource);
    }

    /**
     * Sert à mettre à jours les informations d'une organisation.
     *
     * @param organisation
     * @return une liste d'organisations.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @PutMapping("/update")
    public OrganisationResource updateOrganisation(@RequestBody Organisation organisation) {
        Organisation organisations = service.updateOrganisation(organisation);
        em.flush();
        em.refresh(organisations);

        return Mapper.organisationToOrganisationResource.apply(organisations);
    }

    /**
     * Sert à supprimer une fiche organisation.
     *
     * @param id
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete/{id}")
    public String deleteOrganisationById(@PathVariable int id) {
        return service.deleteOrganisation(id);
    }

    /**
     * Sert à supprimer toutes les fiches organisation.
     *
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete-all")
    public String deleteOrganisations() {
        return service.deleteAllOrganisation();
    }
}
