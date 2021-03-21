package com.shield.projectJavaCesi.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.shield.projectJavaCesi.entity.being.AccessRole;
import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.entity.being.Organisation;
import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.entity.employee.EmployeeDepartment;
import com.shield.projectJavaCesi.entity.event.EventType;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.superbeing.Ability;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.resource.being.*;
import com.shield.projectJavaCesi.resource.event.EventTypeResource;
import com.shield.projectJavaCesi.resource.event.IncidentResource;
import com.shield.projectJavaCesi.resource.multipleConnection.CommentResource;
import com.shield.projectJavaCesi.resource.superbeing.AbilityResource;
import com.shield.projectJavaCesi.resource.superbeing.SuperbeingForCommentResource;
import com.shield.projectJavaCesi.resource.superbeing.SuperbeingResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeDepartmentResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeResource;
import org.thymeleaf.expression.Strings;

public class Mapper {


    public static <T, R> List<R> map(List<T> list, Function<T, R> func) {

        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(func.apply(t));
        }
        return result;
    }

    public static Function<EventType, EventTypeResource> eventTypeToEventTypeResource = (eventType) -> {
        EventTypeResource res = new EventTypeResource();
        if (eventType == null) {
            return null;
        }
        res.id = eventType.getId();
        res.name = eventType.getName();
        return res;
    };

    public static Function<Incident, IncidentResource> incidentToIncidentResource = (incident) -> {
        if (incident == null) {
            return null;
        }
        IncidentResource res = new IncidentResource();
        res.id = incident.getId();
        res.ref = incident.getRef();
        res.startDate = incident.getStartDate();
        if (incident.getEndDate() != null) {
            res.endDate = incident.getEndDate();
        }
        res.solved = incident.isSolved();
        res.dangerousness = incident.getDangerousness();
        res.status = incident.getStatus();
        res.eventType = incident.getEventType().getName();
        return res;
    };

    public static Function<Ability, AbilityResource> abilityToAbilityResource = (ability) -> {
        if (ability == null) {
            return null;
        }
        AbilityResource res = new AbilityResource();
        res.id = ability.getId();
        res.name = ability.getName();
        res.weakness = ability.isWeakness();
        return res;

    };


    public static Function<Superbeing, SuperbeingResource> superbeingToSuperbeingResource = (superbeing) -> {
        if (superbeing == null) {
            return null;
        }
        SuperbeingResource res = new SuperbeingResource();
        res.id = superbeing.getId();
        res.ref = superbeing.getRef();
        res.name = superbeing.getName();
        res.superhero = superbeing.isSuperhero();
        res.likability = superbeing.getLikability();
        res.active = superbeing.isActive();
        res.eventParticipatedIn = superbeing.getEventParticipatedIn();
        res.eventSucceeded = superbeing.getEventSucceeded();
        res.eventFailed = superbeing.getEventFailed();
        res.eventCaused = superbeing.getEventCaused();
        res.arrestNumber = superbeing.getArrestNumber();
        res.collateralDamageRisk = superbeing.getCollateralDamageRisk();
        res.dangerousness = superbeing.getDangerousness();
        res.discoveredAt = superbeing.getDiscoveredAt();
        res.treasonRisk = superbeing.getTreasonRisk();
        res.affiliated = superbeing.isAffiliated();
        res.archive = superbeing.isArchive();
        return res;
    };
    public static Function<Superbeing, SuperbeingForCommentResource> superbeingForCommentToSuperbeingForCommentResource = (superbeing) -> {
        if (superbeing == null) {
            return null;
        }
        SuperbeingForCommentResource res = new SuperbeingForCommentResource();
        res.id = superbeing.getId();
        res.name = superbeing.getName();
        return res;
    };

    public static Function<Civil, CivilResource> civilToCivilResource = (civil) -> {
        if (civil == null) {
            return null;
        }
        CivilResource res = new CivilResource();
        res.id = civil.getId();
        res.ref = civil.getRef();
        res.malevolant = civil.isMalevolant();
        if (civil.getTitle() != null) {
            res.title = civil.getTitle();
        }
        if (civil.getFirstname() != null) {
            res.firstname = civil.getFirstname();
        }
        if (civil.getLastname() != null) {
            res.lastname = civil.getLastname();
        }
        if (civil.getGender() != null) {
            res.gender = civil.getGender();
        }
        if (civil.getBirthdate() != null) {
            res.birthdate = civil.getBirthdate();
        }
        if (civil.getDeathdate() != null) {
            res.deathdate = civil.getDeathdate();
        }
        if (civil.getSocialSecurityNumber() != null) {
            res.socialSecurityNumber = civil.getSocialSecurityNumber();
        }
        if (civil.getAddress() != null) {
            res.address = civil.getAddress();
        }
        if (civil.getCity() != null) {
            res.city = civil.getCity();
        }
        if (civil.getState() != null) {
            res.state = civil.getState();
        }
        if (civil.getZipcode() != null) {
            res.zipcode = civil.getZipcode();
        }
        if (civil.getCountry() != null) {
            res.country = civil.getCountry();
        }
        if (civil.getMobilePhone() != null) {
            res.mobilePhone = civil.getMobilePhone();
        }
        res.addedAt = civil.getAddedAt();
        res.updatedAt = civil.getUpdatedAt();
        res.howManyDeclaredIncident = civil.getHowManyDeclaredIncident();
        res.victimOfHowManyMission = civil.getVictimOfHowManyMission();
        if (civil.getEmail() != null) {
            res.email = civil.getEmail();
        }
        res.active = civil.isActive();
        if (civil.getAccessRole() != null) {
            res.accessRole = civil.getAccessRole().getName();
        }
        if (civil.getSuperbeing() != null) {
            res.superbeing = civil.getSuperbeing().getName();
        }
        return res;
    };
    public static Function<Civil, CivilForCommentResource> civilForCommentToCivilForCommentResource = (civil) -> {
        if (civil == null) {
            return null;
        }
        CivilForCommentResource res = new CivilForCommentResource();
        res.id = civil.getId();
        res.firstname = civil.getFirstname();
        res.lastname = civil.getLastname();
        return res;
    };
    public static Function<Civil, CivilForEmployeeResource> civilForEmployeeToCivilForEmployeeResource = (civil) -> {
        if (civil == null) {
            return null;
        }
        CivilForEmployeeResource res = new CivilForEmployeeResource();
        res.id = civil.getId();
        res.firstName = civil.getFirstname();
        res.lastName = civil.getLastname();
        return res;
    };

    public static Function<Organisation, OrganisationResource> organisationToOrganisationResource = (organisation) -> {
        OrganisationResource res = new OrganisationResource();
        res.id = organisation.getId();
        if (organisation.getName() != null) {
            res.name = organisation.getName();
        }
        res.ref = organisation.getRef();
        res.malevolant = organisation.isMalevolant();
        res.email = organisation.getEmail();
        if (organisation.getBirthdate() != null) {
            res.birthdate = organisation.getBirthdate();
        }
        if (organisation.getDeathdate() != null) {
            res.deathdate = organisation.getDeathdate();
        }
        if (organisation.getAddress() != null) {
            res.address = organisation.getAddress();
        }
        if (organisation.getCity() != null) {
            res.city = organisation.getCity();
        }
        if (organisation.getState() != null) {
            res.state = organisation.getState();
        }
        if (organisation.getZipcode() != null) {
            res.zipcode = organisation.getZipcode();
        }
        if (organisation.getCountry() != null) {
            res.country = organisation.getCountry();
        }
        if (organisation.getMobilePhone() != null) {
            res.mobilePhone = organisation.getMobilePhone();
        }
        res.addedAt = organisation.getAddedAt();
        res.updatedAt = organisation.getUpdatedAt();
        res.howManyDeclaredIncident = organisation.getHowManyDeclaredIncident();
        res.victimOfHowManyMission = organisation.getVictimOfHowManyMission();
        res.active = organisation.isActive();
        return res;
    };
    public static Function<Organisation, OrganisationForCommentResource> organisationForCommentToOrganisationForCommentResource = (organisation) -> {
        if (organisation == null) {
            return null;
        }
        OrganisationForCommentResource res = new OrganisationForCommentResource();
        res.id = organisation.getId();
        res.name = organisation.getName();
        return res;
    };


    public static Function<EmployeeDepartment, EmployeeDepartmentResource> employeeDepartmentToEmployeeDepartmentResource = (
            employeeDepartment) -> {
        if (employeeDepartment == null) {
            return null;
        }
        EmployeeDepartmentResource res = new EmployeeDepartmentResource();
        res.id = employeeDepartment.getId();
        res.department = employeeDepartment.getDepartement();
        res.city = employeeDepartment.getCity();
        res.country = employeeDepartment.getCountry();
        return res;
    };

    public static Function<Employee, EmployeeResource> employeeToEmployeeResource = (employee) -> {
        if (employee == null) {
            return null;
        }
        EmployeeResource res = new EmployeeResource();
        res.id = employee.getId();
        res.ref = employee.getRef();
        res.function = employee.getFunction();
        res.startDate = employee.getStartDate();
        if (employee.getEndDate() != null) {
            res.endDate = employee.getEndDate();
        }
        if (employee.getEmail() != null) {
            res.email = employee.getEmail();
        }
        res.contract = employee.getContract();
        res.civil = Mapper.civilForEmployeeToCivilForEmployeeResource.apply((Civil) employee.getBeing());
        res.department = Mapper.employeeDepartmentToEmployeeDepartmentResource.apply(employee.getEmployeeDepartment());
        return res;
    };

    public static Function<AccessRole, AccessRoleResource> accessRoleToAccessRoleResource = (accessRole) -> {
        if (accessRole == null) {
            return null;
        }
        AccessRoleResource res = new AccessRoleResource();
        res.id = accessRole.getId();
        res.name = accessRole.getName();
        res.accreditation = accessRole.getAccreditation();
        return res;
    };
    public static Function<Comment, CommentResource> commentToCommentResource = (comment) -> {
        if (comment == null) {
            return null;
        }
        CommentResource res = new CommentResource();
        res.id = comment.getId();
        res.comments = comment.getComments();
        if (comment.getBeing() != null) {
            res.superbeing = Mapper.superbeingForCommentToSuperbeingForCommentResource.apply(comment.getSuperbeing());
        }
        if (comment.getBeing() != null) {
            // check classname is either Civil or Organisation to display the right Being
            if (comment.getBeing().getClass().getName().equals(Civil.class.getName())){

                res.civil = Mapper.civilForCommentToCivilForCommentResource.apply((Civil) comment.getBeing());
            } else {
                res.organisation = Mapper.organisationForCommentToOrganisationForCommentResource.apply((Organisation) comment.getBeing());
            }
        }
        if (comment.getAccessRole() != null) {
            res.accessRole = Mapper.accessRoleToAccessRoleResource.apply(comment.getAccessRole());
        }
        if (comment.getEmployee() != null) {
            res.employee = Mapper.employeeToEmployeeResource.apply(comment.getEmployee());
        }
        res.ability = Mapper.abilityToAbilityResource.apply(comment.getAbility());
        if (comment.getEmployeeDepartment() != null) {
            res.employeeDepartment = Mapper.employeeDepartmentToEmployeeDepartmentResource.apply(comment.getEmployeeDepartment());
        }
        //if (comment.getLocation() != null) {
        // res.location = Mapper.locationToLocationResource.apply(comment.getLocation());}
        // if (comment.getMedia() != null) {
        // res.media = Mapper.mediaToMediaResource.apply(comment.getMedia());}
        // if (comment.getFeedback() != null) {
        // res.feedback = Mapper.feedbackToFeedbackResource.apply(comment.getFeedback());}
        // if (comment.getLitige() != null) {
        // res.litige = Mapper.litigeToLitigeResource.apply(comment.getLitige());}
        if (comment.getEventType() != null) {
            res.eventType = Mapper.eventTypeToEventTypeResource.apply(comment.getEventType());
        }
        if (comment.getIncident() != null) {
            res.incident = Mapper.incidentToIncidentResource.apply(comment.getIncident());
        }
        // if (comment.getMission() != null) {
        // res.mission = Mapper.missionToMissionResource.apply(comment.getMission());}
        return res;
    };

}
