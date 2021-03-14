package com.shield.projectJavaCesi.entity.event;

public class Incident extends Event {
	private Double dangerousness;

	public enum Status {

		TAKE_IN_CHARGE("À prendre en charge"),
		WORK_IN_PROGRESS("Traitement en cours"),
		INTERVENTION_CALLED("Intervention demandée"),
		REFUSED("Refusée");

		
		
		
		private String status;

		Status(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}
	}

	public Double getDangerousness() {
		return dangerousness;
	}

	public void setDangerousness(Double dangerousness) {
		this.dangerousness = dangerousness;
	}
	
	
}