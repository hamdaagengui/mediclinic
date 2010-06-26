package com.mediapp.core.common.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.AppointmentForMonth;
import com.mediapp.domain.common.AppointmentTO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Diagnosis;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;


public class CommonDAOImpl extends MediAppBaseDAOImpl implements CommonDAO {

	public Person getPersonDetails(Person person) throws DataAccessException {
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Key", person.getKey());
		criteria.put("Username", person.getUsername());
		criteria.put("PersonType", person.getPersonTypeString());
		return (Person) getObject("common.authenticateUser", criteria);
	}

	public List <CodeDecode> getPersonType() throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", "PERSON_TY");
		List <CodeDecode> CodeValueList =  new ArrayList() ;
		try{
			List <String>codeValuesString= (ArrayList<String>) getList("common.getPersonType",criteria );
			for(String eachCodeValue : codeValuesString){
				CodeDecode codeValue = new CodeDecode();
				codeValue.setCodeDecode(eachCodeValue);
				CodeValueList.add(codeValue);
			}
		}catch(DataAccessException se){
			System.out.println(se.toString());
			System.err.println("stacktrace"+se);
		}
		return CodeValueList;
	}

	public int checkIfeMailExists(Person person)  throws DataAccessException {

		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("emailID", person.getEmailID());
		Integer countOfeMail = null;
		countOfeMail = (Integer) getObject("common.checkeMailExists",criteria );
		
		return countOfeMail.intValue();
	}
	
	public boolean addNewMember(Person person) throws DataAccessException {
			person.setPersonTypeString(person.getPersonType().getCodeDecode());
			person.setPassword("mediApp");			
			insertObject("common.insertNewPerson",person );
			return true;
	}
	
	public int getMaxPersonId() throws DataAccessException {
		return (Integer) getObject("common.maxPersonId", null);
	}
	
	public boolean updateProfile(Person person)throws DataAccessException{
 		updateObject("common.updateProfile", person);
		return true;
	}
	
	public boolean insertAddress(Person person)throws DataAccessException{
		updateObject("common.insertAddress", person);
		return true;
	}

	public List <CodeDecode> getCodeValue(String codeCategory) throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", codeCategory);
		List <CodeDecode> CodeValueList =  new ArrayList() ;
		try{
			List <String>codeValuesString= (ArrayList<String>) getList("common.getPersonType",criteria );
			for(String eachCodeValue : codeValuesString){
				CodeDecode codeValue = new CodeDecode();
				codeValue.setCodeDecode(eachCodeValue);
				CodeValueList.add(codeValue);
			}
		}catch(DataAccessException se){
			System.out.println(se.toString());
			System.err.println("stacktrace"+se);
		}
		return CodeValueList;
	}

	public List <SearchResult> getDoctors(SearchCriteria searchCriteria) throws DataAccessException{
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;		
		criteria.put("FirstName", searchCriteria.getDoctorFirstName());
		criteria.put("LastName", searchCriteria.getDoctorLastName());
		criteria.put("MiddleInitial", searchCriteria.getDoctorMiddleInitial());
		criteria.put("Speciality", searchCriteria.getSpeciality());
		criteria.put("Locality", searchCriteria.getLocality());		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(searchCriteria.getDateOfAppointment());
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		
		if(CommonCoreConstants.DAY_IS_MONDAY == dayOfWeek){
			criteria.put("MondayWorking", "Y");
		}else {
			criteria.put("MondayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_TUESDAY == dayOfWeek){
			criteria.put("TuesdayWorking", "Y");
		}else{
			criteria.put("TuesdayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_WEDNESDAY == dayOfWeek){
			criteria.put("WednesdayWorking", "Y");
		}else{
			criteria.put("WednesdayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_THURSDAY == dayOfWeek){
			criteria.put("ThursdayWorking", "Y");
		}else{
			criteria.put("ThursdayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_FRIDAY == dayOfWeek){
			criteria.put("FridayWorking", "Y");
		}else{
			criteria.put("FridayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_SATURDAY == dayOfWeek){
						criteria.put("SaturdayWorking", "Y");
		}else{
			criteria.put("SaturdayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_SUNDAY == dayOfWeek){
			criteria.put("SundayWorking", "Y");
		}else{
			criteria.put("SundayWorking", null);
		}
	
		List <SearchResult> searchResultList =  new ArrayList() ;
		try{
			searchResultList= (ArrayList<SearchResult>) getList("common.searchDoctor",criteria );
		}catch(DataAccessException se){
			System.out.println(se.toString());
			System.err.println("stacktrace"+se);
		}
		return searchResultList;
	}
	
	public List <CodeDecode> getAutoComplete(String codeCategory,String code) throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", codeCategory);
		String codeLike = "%"+code+"%";
		criteria.put("Code", codeLike);
		List <CodeDecode> codeValueList= (ArrayList<CodeDecode>) getList("common.autoComplete",criteria );	
		return codeValueList;
	}

	public List <Appointment> getDayAppointment(int idPerson,Date dateOfAppointment) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		criteria.put("DateOfAppointment", dateOfAppointment);
		List <Appointment> appointmentList = (ArrayList<Appointment>) getList("common.dayAppointment",criteria );	
		return appointmentList;
		
		
	}	
	public boolean insertNewAppointment(Appointment appointment) throws DataAccessException{		
		insertObject("common.insertNewAppointment",appointment );
		return true;		
	}	

	public Person getPersonalProfile(int idPerson) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		Person completeDetails = (Person) getObject("common.getPersonalProfile",criteria );
		return completeDetails;		
	}
	
	public Appointment getAppointment(int idPerson,Date dateOfAppointment, int idAppointment) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		criteria.put("AppointmentID", idAppointment);		
		List<AppointmentTO> appointment = (ArrayList<AppointmentTO>) getList("common.getAppointment",criteria );
		Appointment appointmentLast = new Appointment();
		appointmentLast.setAppointmentID(appointment.get(0).getAppointmentID());
		appointmentLast.setDateOfAppointment(appointment.get(0).getDateOfAppointment());
		appointmentLast.setTimeOfAppointment(appointment.get(0).getTimeOfAppointment());
		List <Diagnosis> diagnosis = new ArrayList();
		for(AppointmentTO  eachAppointment: appointment){
			Diagnosis eachDiagnosis = new Diagnosis();
			eachDiagnosis.setCodeICD(eachAppointment.getCodeICD());
			eachDiagnosis.setDiagnosis(eachAppointment.getDiagnosis());
			eachDiagnosis.setDiagnosisTest(eachAppointment.getDiagnosisTest());
			eachDiagnosis.setPrescription(eachAppointment.getPrescription());
			diagnosis.add(eachDiagnosis);
		}
		appointmentLast.setDiagnosis(diagnosis);
		return appointmentLast;
		
	}

	@Override
	public List<AppointmentForMonth> getMonthAppointment(int idPerson,
			Date dateOfAppointment) throws DataAccessException {
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		criteria.put("DateOfAppointment", dateOfAppointment);
		List<AppointmentForMonth>  appointmentForMonth = (ArrayList<AppointmentForMonth>) getList("common.getMonthAppointment",criteria );	
		return appointmentForMonth;
	}

	public boolean updateDiagnosisAndTests(Appointment appointment) throws DataAccessException,DataIntegrityViolationException{
		int count = appointment.getDiagnosis().size();
		Integer countInteger = new Integer(count);
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		criteria.put("SequenceName","s_diagnosis_id" );
		criteria.put("HowMuch",countInteger );
		Integer maxDianosisID =  (Integer)getObject("common.bulkNextVal",criteria );
		int minDiagnosisID = maxDianosisID.intValue() - count;
		int whileCounter = 0;
		while(minDiagnosisID <maxDianosisID){
			appointment.getDiagnosis().get(whileCounter).setDiagnosisID(minDiagnosisID);
			whileCounter = whileCounter+1;
			minDiagnosisID = minDiagnosisID+1;
		}
		try { 
			this.getSqlMapClient().startBatch(); 
			for (int i = 0; i < appointment.getDiagnosis().size(); i++) { 
				criteria =  new HashMap < String, Object > () ;
				Integer appointmentID = new Integer(appointment.getAppointmentID() );
				criteria.put("AppointmentID",appointmentID);
				Integer diagnosisID = new Integer(appointment.getDiagnosis().get(i).getDiagnosisID() );				
				criteria.put("DiagnosisID", diagnosisID);
				criteria.put("Prescription", appointment.getDiagnosis().get(i).getPrescription());
				criteria.put("ICDCode", appointment.getDiagnosis().get(i).getCodeICD());
				getSqlMapClient().insert("common.insertNewDiagnosis",
						criteria);
			} 
			int insertCount = this.getSqlMapClient().executeBatch();
			System.out.println("count "+insertCount);
			this.getSqlMapClient().startBatch(); 
			for (int i = 0; i < appointment.getDiagnosis().size(); i++) {
				criteria =  new HashMap < String, Object > () ;
				Integer diagnosisID = new Integer(appointment.getDiagnosis().get(i).getDiagnosisID() );				
				criteria.put("DiagnosisID", diagnosisID);
				criteria.put("diagnosisTest", appointment.getDiagnosis().get(i).getDiagnosisTest());
				criteria.put("diagnosisTestResultValue", appointment.getDiagnosis().get(i).getDiagnosisTestResultValue());
				criteria.put("diagnosisTestResultUnit", appointment.getDiagnosis().get(i).getDiagnosisTestResultUnit());
				getSqlMapClient().insert("common.insertNewTests",
						criteria);
			} 
			insertCount = this.getSqlMapClient().executeBatch();

			} catch (SQLException e) { 
			throw new DataIntegrityViolationException(e.getMessage()); 
			} 

		
		return true;
	}
	
	public boolean scheduleJob(String action, Map<String, String> parms, String comments) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		criteria.put("SequenceName","s_schedule_job" );
		criteria.put("HowMuch",1 );
		Integer scheduleID =  (Integer)getObject("common.bulkNextVal",criteria );
		criteria =  new HashMap < String, Object > () ;
		criteria.put("Action", action);
		criteria.put("Comments", comments);
		criteria.put("ScheduleID", scheduleID);
		insertObject("common.insertScheduleJob",criteria );
		try
		{
			this.getSqlMapClient().startBatch(); 
			Iterator it = parms.entrySet().iterator();
		    while (it.hasNext()) { 
		        Map.Entry pairs = (Map.Entry)it.next(); 
				criteria =  new HashMap < String, Object > () ;
				criteria.put("InputParmName", pairs.getKey());
				criteria.put("InputParmValue", pairs.getValue());
				criteria.put("ScheduleID", scheduleID);				
				getSqlMapClient().insert("common.insertJobInputs",
						criteria);
	//	        System.out.println(pairs.getKey() + " = " + pairs.getValue()); 
		    } 			
			int insertCount = this.getSqlMapClient().executeBatch();

		}catch (SQLException e) { 
			throw new DataIntegrityViolationException(e.getMessage()); 
		} 
		
		return true;
		
	}

}
