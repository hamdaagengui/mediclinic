package com.mediapp.domain.common;

public class Diagnosis extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 4L;
	
	private int diagnosisID;
	
	private int appointmentID;
	
	private String codeICD;
	
	private String prescription;
	

	private String diagnosisTest;
	
	private String diagnosisTestResultUnit;
	
	private String diagnosisTestResultValue;
	
	private String lNotes;
	
	private String diagnosis;
	
	private String allergy;
	
	private int testID;

	public int getDiagnosisID() {
		return diagnosisID;
	}

	public void setDiagnosisID(int diagnosisID) {
		this.diagnosisID = diagnosisID;
	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getCodeICD() {
		return codeICD;
	}

	public void setCodeICD(String codeICD) {
		this.codeICD = codeICD;
	}



	public String getLNotes() {
		return lNotes;
	}

	public void setLNotes(String notes) {
		lNotes = notes;
	}

	public String getlNotes() {
		return lNotes;
	}

	public void setlNotes(String lNotes) {
		this.lNotes = lNotes;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getDiagnosisTest() {
		return diagnosisTest;
	}

	public void setDiagnosisTest(String diagnosisTest) {
		this.diagnosisTest = diagnosisTest;
	}

	public String getDiagnosisTestResultUnit() {
		return diagnosisTestResultUnit;
	}

	public void setDiagnosisTestResultUnit(String diagnosisTestResultUnit) {
		this.diagnosisTestResultUnit = diagnosisTestResultUnit;
	}

	public String getDiagnosisTestResultValue() {
		return diagnosisTestResultValue;
	}

	public void setDiagnosisTestResultValue(String diagnosisTestResultValue) {
		this.diagnosisTestResultValue = diagnosisTestResultValue;
	}

}