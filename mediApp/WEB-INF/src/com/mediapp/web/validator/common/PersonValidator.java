package com.mediapp.web.validator.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.domain.common.Person;

public class PersonValidator implements Validator{
	LoginService loginService;
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	private final Log logger = LogFactory.getLog(getClass());

	public boolean supports(Class clazz) {
		return clazz.equals(Person.class);
	}
	public void validate(Object obj, Errors errors) {
		Person person = (Person) obj;
		if(null == person.getFirstName() || person.getFirstName().trim().length() == 0) {
			errors.rejectValue("firstName", "error.firstName.not-specified", null,
			"Value required.");
			if(logger.isDebugEnabled()) {
				logger.debug("First Name is blank for the user : " + person.getUsername());
			}
		}  
		if(null == person.getLastName() || person.getLastName().trim().length() == 0) {
			errors.rejectValue("lastName", "error.lastName.not-specified", null,
			"Value required.");
		}
		if(null == person.getDateOfBirth() || person.getDateOfBirth().toString().trim().length() == 0) {
			errors.rejectValue("dateOfBirth", "error.dateOfBirth.not-specified", null,
			"Value required.");
		}
		if(null == person.getGender() || person.getGender().toString().trim().length() == 0) {
			errors.rejectValue("gender", "error.required.field", null,
			"Value required.");			
		}
		if(null == person.getCellPhoneNumber() || person.getCellPhoneNumber().toString().trim().length() == 0) {
			errors.rejectValue("cellPhoneNumber", "error.required.field", null,
			"Value required.");
		}
		if(null == person.getEmailID() || person.getEmailID().toString().trim().length() == 0) {
			errors.rejectValue("emailID", "error.required.field", null,
			"Value required.");
		}
		
		if(null != person.getDoctorDetails().getRegistrationNumber() && person.getDoctorDetails().getRegistrationNumber().toString().trim().length() == 0) {
			errors.rejectValue("doctorDetails.registrationNumber", "error.required.field", null,
			"Value required.");			
		}
		if(null != person.getDoctorDetails().getSpecialization() && person.getDoctorDetails().getSpecialization().toString().trim().length() == 0) {
			errors.rejectValue("doctorDetails.specialization", "error.required.field", null,
			"Value required.");
		}
	}
}
