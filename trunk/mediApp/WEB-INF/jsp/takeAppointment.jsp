<%@ include file="/WEB-INF/jsp/include.jsp" %>


		
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="takeAppointment" id="takeAppointment" method="post" >
									<table width=900  border="1" class="layout"  >	
										<tr>
											<td>	
												<table width=100 align="left"  border="1" class="layout" >	
													<menu:verticalMenuItemTag></menu:verticalMenuItemTag>
												</table>
											<div id="dayAppointments"  style="display:block" align="center">
												<table  border=""  class="appointment" width=680>
													<tr>
														<td align="center">
															<table border="0" cellpadding="3" cellspacing="0" width="100%">																	
																	<tr>
																		<td align="left" width="33%" bgcolor="#eeeeee">
																			<a href="#" onclick="" style="text-decoration:none" >
																				<font color="#ff0000"><b>&lt;</b></font>
																			</a>
																		
																		</td>
																		<td align="center" bgcolor="#eeeeee" valign="middle" width="33%" >
																			<font size="3" color="#ff0000" face="verdana,arial,helvetica">
																				<input type="hidden" name="AppointmentMonth" value="<fmt:formatDate pattern="MM" value="${AppointmentDate}"/>">
																				<input type="hidden" name="AppointmentYear" value="<fmt:formatDate pattern="yyyy" value="${AppointmentDate}"/>">
																				<b><fmt:formatDate pattern="yyyy" value="${AppointmentDate}"/></b>
																				
																			</font>
																		</td>
																		<td align="right" width="33%" bgcolor="#eeeeee" >
																			<a href="#" onclick="" style="text-decoration:none">
																				<font color="#ff0000"><b>&gt;</b></font>
																			</a>
																		
																		</td>

																	</tr>
															

																	<tr>
																		<td align="left" width="33%" bgcolor="#eeeeee">
																			<a href="#" onclick="" style="text-decoration:none">
																				<font color="#ff0000"><b>&lt;&lt;</b></font>
																			</a>
																		
																		</td>
																	
																		<td align="center" bgcolor="#eeeeee" valign="middle" >
																			<font size="3" color="#ff0000" face="verdana,arial,helvetica">
																				<input type="hidden" name="AppointmentMonth" value="<fmt:formatDate pattern="MM" value="${AppointmentDate}"/>">
																				<input type="hidden" name="AppointmentYear" value="<fmt:formatDate pattern="yyyy" value="${AppointmentDate}"/>">
																				<b><fmt:formatDate pattern="MMMMMMMMM" value="${AppointmentDate}"/></b>
																				
																			</font>
																		</td>
																		<td align="right" width="33%" bgcolor="#eeeeee">
																			<a href="#" onclick="" style="text-decoration:none" >
																				<font color="#ff0000"><b>&gt;&gt;</b></font>
																			</a>
																		
																		</td>
																		
																	</tr>
															
															</table>
															<table border="0" cellpadding="3" cellspacing="0" width="100%">
																<tbody>
																	<tr>
																		<td align="center" bgcolor="#eeeeee" valign="middle" width="14%">
																			<font size="1" color="#ff0000" face="verdana,arial,helvetica">
																				<b>Sunday</b>
																			</font>
																		</td>
																		<td align="center" bgcolor="#eeeeee" valign="middle" width="14%">
																			<font size="1" color="#ff0000" face="verdana,arial,helvetica">
																				<b>Monday</b>
																			</font>
																		</td>
																		<td align="center" bgcolor="#eeeeee" valign="middle" width="14%">
																			<font size="1" color="#ff0000" face="verdana,arial,helvetica">
																				<b>Tuesday</b>
																			</font>
																		</td>
																		<td align="center" bgcolor="#eeeeee" valign="middle" width="14%">
																			<font size="1" color="#ff0000" face="verdana,arial,helvetica">
																				<b>Wednesday</b>
																			</font>
																		</td>
																		<td align="center" bgcolor="#eeeeee" valign="middle" width="14%">
																			<font size="1" color="#ff0000" face="verdana,arial,helvetica">
																				<b>Thursday</b>
																			</font>
																		</td>
																		<td align="center" bgcolor="#eeeeee" valign="middle" width="14%">
																			<font size="1" color="#ff0000" face="verdana,arial,helvetica">
																				<b>Friday</b>
																			</font>
																		</td>
																		<td align="center" bgcolor="#eeeeee" valign="middle" width="14%">
																			<font size="1" color="#ff0000" face="verdana,arial,helvetica">
																				<b>Saturday</b>
																			</font>
																		</td>
																	</tr>
																</tbody>
															</table>
														</td>
													</tr>
													<tr>
														<td align="center">
															<input type="hidden" name="PersonID" value="${personID}">
															<table border="0" cellpadding="2" cellspacing="1" width="100%">
																<tbody>
																	<c:set var="counter" value="1" scope="page" />
																	<c:forEach items="${appointment}" var="appointments">
																		<c:if  test='${counter mod 7 == 1}'>
																			<c:if  test='${counter == 1 }'>
																				<tr>
																			</c:if>
																			<c:if  test='${counter >  1 }'>
																				</tr>
																				<tr>
																			</c:if>
																		</c:if>
																		<c:choose>																																							
																			<c:when test='${empty appointments.dateOfAppointment}'>
																				<td height="70" width="14%">&nbsp;</td>
																			</c:when>																			
																			<c:otherwise>
																				<c:choose>
																					<c:when  test='${appointments.appointmentCount > 0}'>
																						<td align="right" bgcolor="#669933" height="70" valign="top" width="14%">
																					</c:when>
																					<c:otherwise>
																					<td align="right" bgcolor="#CCCCFF" height="70" valign="top" width="14%">
																					</c:otherwise>
																				</c:choose>
																					<font size="1" face="verdana,arial,helvetica">
																						<a href="#" onclick="javascript:getAppointment('<c:out value="${personID}"/>','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointments.dateOfAppointment}"/>');">
																							<b><font color="#000000"><fmt:formatDate pattern="dd" value="${appointments.dateOfAppointment}"/></font></b>
																						</a>
																						<c:if  test='${appointments.appointmentCount > 0}'>
																							<font color="#000000"><br><br><br>${appointments.appointmentCount}</font>
																						</c:if>
																					</font>
																				</td>
																			</c:otherwise>																			
																		</c:choose>
																		<c:set var="counter" value="${counter+1 }"/>																		
																	</c:forEach>
																	</tr>
																	</tbody>
																</table>
															</table>
														</div>
													</td>
												</tr>
											</table>
										</form>
									</div>
								</div>
								<div id="column">
								</div>
							</div>
						</div>
					</div>
				</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>