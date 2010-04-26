<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="com.mediapp.domain.common.Person"%>
<html>
	<head>
	    <title>mediApp</title>    
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" type="image/x-icon" />
	    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
	    <link href="<%=request.getContextPath()%>/css/autocomplete.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>    
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">
	</head>
	<body>
		<form name="createAppointment" id="createAppointment" method="post" >
			<div id="createApt"  style="display:block" align="center">
				<table  border=""  class="login" width=450>
					<tr bgcolor="lightblue">
						New Appointment
					</tr>
					<tr>
						<td >Headline :</td>
						<td>
							<spring:bind path="appointment.headline">
								<input type="text" name="${status.expression}"  value="<c:out value="${status.value}"/>"/>					
							</spring:bind>
						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td >Date :</td>
						<td>
							<spring:bind path="appointment.dateOfAppointment">
								<input type="text" name="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>" disabled="disabled" />
							</spring:bind>
						</td>
						<td></td>
						<td></td>
					</tr>

					<tr>
						<td >Time :</td>
						<td>
							<spring:bind path="appointment.timeOfAppointment">
								<input type="text" name="${status.expression}"  value="<c:out value="${appointment.timeOfAppointment}"/>" disabled="disabled" />
							</spring:bind>
						</td>
						<td>Duration :</td>
						<td>
							<spring:bind path="appointment.appointmentDuration">
								<select id="${status.expression}" name="${status.expression}" style="WIDTH: 150px">
									<c:forEach items="${appointmentDuration}" var="data">
										<option value='${data.codeDecode}' >${data.codeDecode}</option>
									</c:forEach>
								</select>
							</spring:bind>
						</td>
					</tr>
					
					<tr>
						<td >Comments:</td>
						<td >
							<spring:bind path="appointment.comments">
								<textarea name="${status.expression}"  value="${fn:trim(status.value)}"  rows="6" cols="25" >
								</textarea>													
							</spring:bind>
						</td>
					</tr>
						<spring:bind path="appointment.doctorID">
							<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorID}"/>"/>					
						</spring:bind>
						<spring:bind path="appointment.doctorPersonID">
							<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorPersonID}"/>"/>					
						</spring:bind>
						
					<tr>
						<td align="center" colspan="2">															
						<input type="button"  onClick="javascript:fn_addAppointment();" alignment="center" value="Add" class="bsubmit"  width="75"/>
						</td>
					</tr>
	
				</table>
			</div>
		</form>
	</body>
</html>
