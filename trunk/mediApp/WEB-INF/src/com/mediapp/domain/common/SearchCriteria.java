package com.mediapp.domain.common;

import java.util.Date;


public class SearchCriteria  extends MediAppBaseDomain{

	private static final long serialVersionUID = 10L;

	private String doctorFirstName;
	
	private String doctorLastName;
	
	private String doctorMiddleInitial;
	
	private String speciality;
	
	private Date dateOfAppointment;
	
	private String locality;

	
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getDoctorFirstName() {
		return doctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}

	public String getDoctorLastName() {
		return doctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}

	public String getDoctorMiddleInitial() {
		return doctorMiddleInitial;
	}

	public void setDoctorMiddleInitial(String doctorMiddleInitial) {
		this.doctorMiddleInitial = doctorMiddleInitial;
	}

}
