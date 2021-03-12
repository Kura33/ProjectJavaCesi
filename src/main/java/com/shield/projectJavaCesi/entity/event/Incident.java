package com.shield.projectJavaCesi.entity.event;

public class Incident extends Event {
	private Double dangerousness;

	public enum Status {

		STATUS_A("À prendre en charge"),
		STATUS_B("Traitement en cours"),
		STATUS_C("Intervention demandée"),
		STATUS_D("Refusée");

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
