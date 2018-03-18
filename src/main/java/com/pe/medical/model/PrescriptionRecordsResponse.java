package com.pe.medical.model;

import java.util.List;

public class PrescriptionRecordsResponse extends DefaultResponse{
	
	private List<PrescriptionRecords> prescriptionRecords;
	
	public List<PrescriptionRecords> getPrescriptionRecords() {
		return prescriptionRecords;
	}
	public void setPrescriptionRecords(List<PrescriptionRecords> prescriptionRecords) {
		this.prescriptionRecords = prescriptionRecords;
	}
	

}
