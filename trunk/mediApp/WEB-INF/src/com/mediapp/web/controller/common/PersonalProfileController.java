package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.domain.common.Address;
import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class PersonalProfileController extends MediAppBaseController  {
	LoginService loginService;
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)throws Exception {
		Person person = (Person) command;
		Map < String , Object > logonMap = new HashMap < String , Object > ();
		System.out.println("Object is null " + (null == person));
		if (null == person.getLastName()) {
			person = loginService.authenticate((Person) request.getSession().getAttribute(CommonWebConstants.USER_ID));
		}
		logonMap.put("person", person );
		return logonMap;
	}
	
	
	
/*protected Object formBackingObject(HttpServletRequest request) throws Exception {
		Person person = (Person) CommonWebUtil.getSessionAttribute(request, CommonWebConstants.USER_ID);
		return person;
	} */
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		Person person = (Person)command;
		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		person.setEmailID(sessionPerson.getEmailID());
		person.setUsername(sessionPerson.getUsername());
		person.setPersonTypeString(sessionPerson.getPersonTypeString());
		boolean updateSuccess = loginService.updateProfile(person);
		return new ModelAndView(getFormView(),CommonWebConstants.USER_ID, person);
	}
		

	protected void onBind(HttpServletRequest request, Object command, BindException errors) throws Exception {
		Person logon = (Person) command;
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");	
		String locality = request.getParameter("locality");	
		String city = request.getParameter("city");	
		String state = request.getParameter("state");	
		String country = request.getParameter("country");
		String birthDate = request.getParameter("dateOOfBirth");
		if(null != birthDate && "" != birthDate) {
			SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
			logon.setDateOfBirth(formatDate.parse(birthDate));
		}
		logon.setAddress(new Address());
		logon.getAddress().setAddress1(address1);
		logon.getAddress().setAddress2(address2);
		logon.getAddress().setLocality(locality);
		logon.getAddress().setCity(city);
		logon.getAddress().setState(state);
		logon.getAddress().setCountry(country);
	}

/*	public void initFormatters(DataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
		}*/

	
}