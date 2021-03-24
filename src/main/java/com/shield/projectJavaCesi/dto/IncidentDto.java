package com.shield.projectJavaCesi.dto;

import java.util.Date;
import java.util.List;

public class IncidentDto {
    public Integer id;
    public String ref;
    public Date startDate;
    public Date endDate;
    public Boolean solved;
    public Double dangerousness;
    public String status;
    public Boolean archive;
    public EventTypeDto eventType;
    public List<CommentDto> comments;
    public List<Integer> civils;
    public List<Integer> organisations;
    public List<Integer> superbeings;
}
