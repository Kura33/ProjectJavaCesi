package com.shield.projectJavaCesi.controller.event;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.shield.projectJavaCesi.dto.IncidentDto;
import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.entity.being.Organisation;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
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
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.event.IncidentResource;
import com.shield.projectJavaCesi.service.event.IncidentService;

@RestController
@RequestMapping(path = "/shield/incident")
@Transactional
public class IncidentController {
    @Autowired
    private IncidentService service;

    @Autowired
    private EntityManager em;

    /**
     * Sert à recupérer tous les incidents.
     *
     * @return une liste de tous les incidents.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/")
    public List<IncidentResource> findAllIncidents() {
        List<Incident> incidents = service.getIncidents();
        return Mapper.map(incidents, Mapper.incidentToIncidentResource);
    }

    /**
     * sert à récupérer un incident
     *
     * @param id
     * @return un incident avec sa liste de commentaires, de superbeing, de civils et d'organiation.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @GetMapping("/{id}")
    public Map<String, Object> findIncidentById(@PathVariable int id) {
        Map<String, Object> map = service.getIncidentById(id);

        map.put("incident", Mapper.incidentToIncidentResource.apply((Incident) map.get("incident")));
        map.put("comments", Mapper.map((List<Comment>) map.get("comments"), Mapper.commentToCommentResource));
        map.put("superbeings", Mapper.map((List<Superbeing>) map.get("superbeings"), Mapper.superbeingToSuperbeingResource));
        map.put("civils", Mapper.map((List<Civil>) map.get("civils"), Mapper.civilToCivilResource));
        map.put("organisations", Mapper.map((List<Organisation>) map.get("organisations"), Mapper.organisationToOrganisationResource));
        return map;
    }

    /**
     * sert à créer un ou plusieurs incidents, un ou plusieurs commentaires, un event type
     * et les relations entre incidents/civils/organisations/superbeings
     * @param incidentAndRelation
     * @return une liste d'incidents.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @PostMapping("/create")
    public List<IncidentResource> addIncident(@RequestBody List<IncidentDto> incidentAndRelation) {
    ;
        List<Map<String, Object>> incidentList = Mapper.map(incidentAndRelation, Mapper.incidentDtoToMap);
        List<Incident> saveIncidentList = service.saveIncidentAndRelations(incidentList);
        em.flush();
        for (Incident incident1 : saveIncidentList) {

            em.refresh(incident1);
        }
        return Mapper.map(saveIncidentList, Mapper.incidentToIncidentResource);
    }

    /**
     * Sert à mettre à jour un incident.
     *
     * @param incident
     * @return un incident.
     */
    @PreAuthorize("hasAnyAuthority('Agent_0', 'Agent_1', 'Agent_2', 'Agent_3')")
    @PutMapping("/update")
    public IncidentResource updateIncident(@RequestBody Incident incident) {
        Incident incidents = service.updateIncident(incident);
        em.flush();
        em.refresh(incidents);

        return Mapper.incidentToIncidentResource.apply(incidents);
    }

    /**
     * Sert à supprimer une fiche incident.
     *
     * @param id
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete/{id}")
    public String deleteIncidentById(@PathVariable int id) {
        return service.deleteIncident(id);
    }

    /**
     * Sert à supprimer toutes les fiches incidents.
     *
     * @return "True" si l'oppération s'est bien effetuée.
     */
    @PreAuthorize("hasAuthority('Agent_0')")
    @DeleteMapping("/delete-all")
    public String deleteIncidents() {
        return service.deleteAllIncident();
    }
}
