package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;



public class Person extends MediAppBaseDomain{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

    private String password;
    
    private String emailID;

    private boolean authenticated;
    
    private CodeDecode personType;
    
    private String personTypeString;
    
    private String accountType;
    
    private final String key = "goodLord";
    
    private int idPerson;
    
    private String firstName;
    
    private String middleInitial;
    
    private String lastName;
    
    private Date dateOfBirth;
    
    private String gender;
    
    private String landlinePhoneNumber;
    
    private String cellPhoneNumber;
    
    private String accountStatus;
    
    private Address address = new Address();
    
    private Doctor doctorDetails = new Doctor();

	private List<DoctorWorkTimings> doctorWorkTiming = LazyList.decorate(
				new ArrayList < DoctorWorkTimings > (),
			FactoryUtils.instantiateFactory(DoctorWorkTimings.class)); 
    
	private List<String> packages = LazyList.decorate(
			new ArrayList < String > (),
		FactoryUtils.instantiateFactory(String.class)); 

	
	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

	public String getLandlinePhoneNumber() {
		return landlinePhoneNumber;
	}

	public void setLandlinePhoneNumber(String landlinePhoneNumber) {
		this.landlinePhoneNumber = landlinePhoneNumber;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getKey() {
		return key;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPersonTypeString() {
		return personTypeString;
	}

	public void setPersonTypeString(String personTypeString) {
		this.personTypeString = personTypeString;
	}

	public CodeDecode getPersonType() {
		return personType;
	}
	
	public void setPersonType(CodeDecode personType) {
		this.personType = personType;
	}


	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	/**
	 * @return the authenticated
	 */
	public boolean isAuthenticated() {
		return authenticated;
	}

	/**
	 * @param authenticated the authenticated to set
	 */
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
 
	public List<DoctorWorkTimings> getDoctorWorkTiming() {
		return doctorWorkTiming;
	}

	public void setDoctorWorkTiming(List<DoctorWorkTimings> doctorWorkTiming) {
		this.doctorWorkTiming = doctorWorkTiming;
	}

	public Doctor getDoctorDetails() {
		return doctorDetails;
	}

	public void setDoctorDetails(Doctor doctorDetails) {
		this.doctorDetails = doctorDetails;
	}

	
	
}