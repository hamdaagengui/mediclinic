package com.mediapp.core.common.business;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import com.mediapp.domain.common.Admin;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.AppointmentForMonth;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.HolidayCalendarList;
import com.mediapp.domain.common.MultiPartFileUploadBean;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.PatientDetails;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;

public interface CommonService {

	public List <CodeDecode> getAutoComplete(String codeCategory,String code) ;
	
	public List <SearchResult> getDoctors(SearchCriteria searchCriteria);
	
	public List <Appointment> getDayAppointment(int idPerson,Date dateOfAppointment,String personType, int doctorID) ;
	
	public boolean insertNewAppointment(Appointment appointment);
	
	public Person getPersonalProfile(int personID);
	
	public Appointment getAppointment( int idAppointment) ;
	
	public List <CodeDecode> getCodeValue(String codeCategory) ;
	
	public List <AppointmentForMonth> getMonthAppointment(int idPerson, Date dateOfAppointment);
	
	public boolean updateDiagnosisAndTests(Appointment appointment) ;

	public PatientDetails getPatientDetails(int idPerson);	

	public boolean updatePatientDetails(PatientDetails patientDetails) ;

	public List <CodeDecode> getCodeDecode(String codeCategory);

	public HolidayCalendarList getHolidays(int idPerson);

	public boolean insertHolidays(HolidayCalendarList holidayList);
	
	public boolean insertPatientDocumentDetials(MultiPartFileUploadBean fileDetails);
	
	public boolean updateAppointmentConfirmation (int appointmentID, String confirmationIndicator) ;

	public List <CodeDecode> getDiagnosis(String code) ;
	
	public List <CodeDecode> getPrescription(String code);
	
	public List <CodeDecode> getTests(String code) ;
	
	public boolean rescheduleAppointment(Appointment appointment);
	
	public Person getPersonDetails(Person person);
	
	public NotificationDetails getNotificationDetails(Integer appointmentID);
	
	public List<List<Appointment>> getInbox(int  idPerson ) ;
	
	public List <String> getAppMates() ;
	
	public boolean updatePackage(Admin admin) ;
	
	public List <String> getPackagesForPerson(Admin admin);
	
	public boolean updateStorageFilePath(Admin admin) ;
	
	public boolean updateAppointment(Appointment appointment);

	public List<Appointment> getAppointments(int  idPerson,Date dateOfAppointment ) ;
}
