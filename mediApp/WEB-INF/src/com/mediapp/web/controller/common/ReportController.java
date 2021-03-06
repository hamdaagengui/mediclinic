package com.mediapp.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


//import com.mediapp.domain.common.ReportDataBean;
//import com.mediapp.domain.common.SubReportDataBean;

public class ReportController extends MultiActionController {

 public ModelAndView handleSimpleReport(HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  return new ModelAndView("simpleReport", getModel());
 }

 public ModelAndView handleSimpleReportPost(HttpServletRequest request,
   HttpServletResponse response) throws Exception {

  String reportTitle = request.getParameter("reportTitle");
  Map model = getModel();
  model.put("ReportTitle", reportTitle);

  return new ModelAndView("simpleReportCompile", model);
 }

 public ModelAndView handleExporterParameters(HttpServletRequest request,
   HttpServletResponse response) throws Exception {
   return new ModelAndView("htmlReport", getModel());
 }

 public ModelAndView handleSimpleReportMulti(HttpServletRequest request,
   HttpServletResponse response) throws Exception {

  String uri = request.getRequestURI();
  String format = uri.substring(uri.lastIndexOf(".") + 1);

  Map model = getModel();
  model.put("format", format);

  return new ModelAndView("simpleReportMulti", model);
 }

 public ModelAndView handleSimpleReportCompile(HttpServletRequest request,
   HttpServletResponse response) throws Exception {
	String sidAppointment = request.getParameter("AppointmentID");		
	Integer idAppointment = new Integer(sidAppointment);

  return new ModelAndView("simpleReportCompile", getModel(idAppointment));
 }

 public ModelAndView handleGenerateMedicalReport(HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
			String sidAppointment = request.getParameter("AppointmentID");		
			Integer idAppointment = new Integer(sidAppointment);

		  return new ModelAndView("generateMedicalReport", getModelForMedicalReport(idAppointment));
		 }


 public ModelAndView handleGenerateHistory(HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
			String sidPerson = request.getParameter("PatientID");		
			Integer idPerson = new Integer(sidPerson);

		  return new ModelAndView("generateHistory", getModelForHsitory(idPerson));
		 }

 public ModelAndView handleGeneratePatientHistory(HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
			String patientAppmentID = request.getParameter("PatientAppmentID");		

		  return new ModelAndView("generatePatientHistory", getModelForPatientHistory(patientAppmentID));
		 }

 
 public ModelAndView handleGenerateMedicalHistoryForDay(HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
			String sidPerson = request.getParameter("PATIENTID");		
			Integer idPerson = new Integer(sidPerson);
			String apmtDate = request.getParameter("APMTDATE");
			String URI =request.getParameter("URI");
			String rptName =request.getParameter("RPT");
			String rFormat =request.getParameter("Format");
		  return new ModelAndView("generateHistoryForDay", getModelForHistoryForDay(idPerson,apmtDate,URI,rptName,rFormat));
		 }

 
 public ModelAndView handleGenerateAppointmentMonthView(HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
			String sidPerson = request.getParameter("PatientID");		
			Integer idPerson = new Integer(sidPerson);
			String year = request.getParameter("Year");
			String month = request.getParameter("Month");
			String format =request.getParameter("Format");
			String URI =request.getParameter("URI");
		  return new ModelAndView("generateAppointmentMonthView", getModelForAppointmentMonthView(idPerson,month,year,format,URI));
		 }

 public ModelAndView handleGenerateAppointmentYearView(HttpServletRequest request,
		   HttpServletResponse response) throws Exception {
			String sidPerson = request.getParameter("PatientID");		
			Integer idPerson = new Integer(sidPerson);
			String year = request.getParameter("Year");
			String format =request.getParameter("Format");
		  return new ModelAndView("generateAppointmentYearView", getModelForAppointmentYearView(idPerson,year,format));
		 }

 
 public ModelAndView handleSimpleReportHtml(HttpServletRequest request,
   HttpServletResponse response) throws Exception {

  return new ModelAndView("simpleReportHtml", getModel());
 }

 public ModelAndView handleSimpleReportCsv(HttpServletRequest request,
   HttpServletResponse response) throws Exception {

  return new ModelAndView("simpleReportCsv", getModel());
 }

 public ModelAndView handleSimpleReportExcel(HttpServletRequest request,
   HttpServletResponse response) throws Exception {

  return new ModelAndView("simpleReportExcel", getModel());
 }

 /**
  * Here two instances of <code>List</code> are added to the
  * model. The second instance, <code>SubReportData</code> is
  * configured to be passed into the engine as a parameter
  * which is subsequently passed into a sub-report by the
  * master report file. Behind the scenes this <code>List</code> is
  * transformed into an instance of <code>JRDataSource</code>.
  */
 public ModelAndView handleSubReport(HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  Map model = getModel();
  //model.put("SubReportData", getProductData());
  return new ModelAndView("subReport", model);
 }

 private Map getModel() {
  Map model = new HashMap();
  model.put("ReportTitle", "Dear Lord!");
  model.put("dataSource", "JasperJdbcDataSource");
  model.put("fundID",585);


  return model;
 }

 private Map getModel(Integer appointmentID) {
	  Map model = new HashMap();
	  model.put("ReportTitle", "Dear Lord!");
	  model.put("dataSource", "JasperJdbcDataSource");
	  model.put("AppointmentID",appointmentID);


	  return model;
	 }
 
 private Map getModelForMedicalReport(Integer appointmentID) {
	  Map model = new HashMap();
	  model.put("ReportTitle", "Medical Report");
	  model.put("dataSource", "JasperJdbcDataSource");
	  model.put("AppointmentID",appointmentID);


	  return model;
}
 private Map getModelForHsitory(Integer personID) {
	  Map model = new HashMap();
	  model.put("ReportTitle", "History");
	  model.put("dataSource", "JasperJdbcDataSource");
	  model.put("PatientID",personID);
	  return model;
	 }
 private Map getModelForPatientHistory(String patientAppmentID) {
	  Map model = new HashMap();
	  model.put("ReportTitle", "History");
	  model.put("dataSource", "JasperJdbcDataSource");
	  model.put("PatientAppmentID",patientAppmentID);
	  return model;
	 }

 private Map  getModelForHistoryForDay(Integer idPerson,String apmtDate,String URI,String rptName,String rFormat){
	  Map model = new HashMap();
	  model.put("ReportTitle", "History");
	  model.put("dataSource", "JasperJdbcDataSource");
	  model.put("PatientID",idPerson);
	  model.put("URI",URI);
	  model.put("RPT",rptName);
	  model.put("APMTDATE",apmtDate);
	  model.put("Format",rFormat);
	  return model;
	 }

 private Map getModelForAppointmentMonthView(Integer personID, String month, String year,String format,String URI) {
	  Map model = new HashMap();
	  model.put("ReportTitle", "Appointments");
	  model.put("dataSource", "JasperJdbcDataSource");
	  model.put("month",month);
	  model.put("year",year);
	  model.put("patient_id",personID);
	  model.put("format",format);
	  model.put("Format",format);
	  model.put("URI",URI);
	  return model;
	 }

 private Map getModelForAppointmentYearView(Integer personID, String year,String format) {
	  Map model = new HashMap();
	  model.put("ReportTitle", "Appointments");
	  model.put("dataSource", "JasperJdbcDataSource");
	  model.put("year",year);
	  model.put("patient_id",personID);
	  model.put("format",format);
	  model.put("Format",format);
	  return model;
	 }

 private List getData() {
  List list = new ArrayList();
  return list;
 }
/*
 private List getProductData() {
  List list = new ArrayList();
  for (int x = 0; x < 10; x++) {
   SubReportDataBean bean = new SubReportDataBean();
   bean.setId(x);
   bean.setName("Foo Bar");
   bean.setPrice(1.9f);
   bean.setQuantity(1.0f);

   list.add(bean);
  }
  return list;
 }
*/
}

