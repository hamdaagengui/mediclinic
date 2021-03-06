package com.mediapp.domain.common;

import java.sql.Time;
import java.util.Date;

public class AppointmentTO extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 3213L;
	
	private int appointmentID;
	
	private Date dateOfAppointment;
	
	private Time timeOfAppointment;
	
	private Time appointmentDuration;
	
	private String comments;
	
	private int patientID;
	
	private int doctorPersonID;
	
	private int doctorID;
	
	private String confirmedIndicator;
	
	private Date followUpDate;
	
	private int referenceDoctorID;
	
	private String headline;	
	
	private int diagnosisID;
	
	private String codeICD;
	
	private String prescription;
	

	private String diagnosisTest;
	
	private String diagnosisTestResultUnit;
	
	private String diagnosisTestResultValue;
	
	private String lNotes;
	
	private String diagnosis;
	
	private String allergy;
	
	private int testID;

	private String dosage;
	
	private String confirmationIndicator;
	
    private String patientLastName;
	
	private String previousHistory;

	private String presentingComplain;
	
	private String bP;
	
	private String temperature;
	
	private String pulse;	

    private String doctorFirstName;
    
	private String doctorMiddleInitial;
    
    private String doctorLastName;

	
	public String getConfirmationIndicator() {
		return confirmationIndicator;
	}

	public void setConfirmationIndicator(String confirmationIndicator) {
		this.confirmationIndicator = confirmationIndicator;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public Time getTimeOfAppointment() {
		return timeOfAppointment;
	}

	public void setTimeOfAppointment(Time timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public Time getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(Time appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getDoctorPersonID() {
		return doctorPersonID;
	}

	public void setDoctorPersonID(int doctorPersonID) {
		this.doctorPersonID = doctorPersonID;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getConfirmedIndicator() {
		return confirmedIndicator;
	}

	public void setConfirmedIndicator(String confirmedIndicator) {
		this.confirmedIndicator = confirmedIndicator;
	}

	public Date getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public int getReferenceDoctorID() {
		return referenceDoctorID;
	}

	public void setReferenceDoctorID(int referenceDoctorID) {
		this.referenceDoctorID = referenceDoctorID;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public int getDiagnosisID() {
		return diagnosisID;
	}

	public void setDiagnosisID(int diagnosisID) {
		this.diagnosisID = diagnosisID;
	}

	public String getCodeICD() {
		return codeICD;
	}

	public void setCodeICD(String codeICD) {
		this.codeICD = codeICD;
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

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPreviousHistory() {
		return previousHistory;
	}

	public void setPreviousHistory(String previousHistory) {
		this.previousHistory = previousHistory;
	}

	public String getPresentingComplain() {
		return presentingComplain;
	}

	public void setPresentingComplain(String presentingComplain) {
		this.presentingComplain = presentingComplain;
	}

	public String getbP() {
		return bP;
	}

	public void setbP(String bP) {
		this.bP = bP;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

    public String getDoctorFirstName() {
		return doctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}

	public String getDoctorMiddleInitial() {
		return doctorMiddleInitial;
	}

	public void setDoctorMiddleInitial(String doctorMiddleInitial) {
		this.doctorMiddleInitial = doctorMiddleInitial;
	}

	public String getDoctorLastName() {
		return doctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}

}
