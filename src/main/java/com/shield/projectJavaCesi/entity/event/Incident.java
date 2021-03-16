package com.shield.projectJavaCesi.entity.event;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "incident")
public class Incident extends Event {
	private Double dangerousness;

	public enum Status {

		TAKE_IN_CHARGE, WORK_IN_PROGRESS, INTERVENTION_CALLED, REFUSED;

	}

	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getDangerousness() {
		return dangerousness;
	}

	public void setDangerousness(Double dangerousness) {
		this.dangerousness = dangerousness;
	}

}
