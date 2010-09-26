<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="searchDoctor" id="searchDoctor" method="post" >
									<table width=900  border="1" class="sample"  >	
										<tr>
											<td>	
												<table width=200 align="left"  border="1" class="sample" style="border-width: 0px 0px 0px 0px;"> 	
													<menu:verticalMenuItemTag></menu:verticalMenuItemTag>
												</table>

												<div id="Search"  style="display:block" align="center">
													<table  border=""  class="sample" width=680 >
														<tr bgcolor="lightblue">
															Search AppMate
														</tr>
														<tr>
															<td>User Name to Search:</td>
																<td>
																	<spring:bind path="doctorSearch.searchCriteria.username">		
																		<input type="text" name="${status.expression}" id="${status.expression}" value="<c:out value="${status.value}"/>"/>
																	</spring:bind>		
															</td>
														</tr>
														<tr>
															<td>
															</td>
															<td><font size="1" color="black" >If you use AppMate Username for search, please leave all fields blank except appointment date</font>  
															</td>
														</tr>
														
														<tr>
															<td >First Name:</td>
															
															<td>
																<spring:bind path="doctorSearch.searchCriteria.doctorFirstName">
																	<input type="text" name="${status.expression}"  value="<c:out value="${status.value}"/>"/>
																</spring:bind>																
															</td>
														</tr>
														<tr>
															<td >Last Name:</td>
															<td>
																<spring:bind path="doctorSearch.searchCriteria.doctorLastName">	
																	<input type="text" name="${status.expression}" value="<c:out value="${status.value}"/>" />
																</spring:bind>	
															</td>
														</tr>
														<tr>
															<td >Middle Initial:</td>
															<td>
																<spring:bind path="doctorSearch.searchCriteria.doctorMiddleInitial">
																	<input type="text" name="${status.expression}" value="<c:out value="${status.value}"/>" />
																</spring:bind>	
															</td>
														</tr>
														<%if (p != null && p.getPersonTypeString() != null && p.getPersonTypeString().equals("Doctor")) {%>
														<tr>
															<td>Speciality:</td>
																<td>
																	<spring:bind path="doctorSearch.searchCriteria.speciality">		
																		<input type="text" name="${status.expression}" id="${status.expression}" value="<c:out value="${status.value}"/>"/>
																	</spring:bind>		
																<script type="text/javascript">
																	new Autocomplete('searchCriteria.speciality', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
																</script>
															</td>
														</tr>
														<%}else if(p != null && p.getPersonTypeString() != null && !p.getPersonTypeString().equals("Doctor")){ %>
														<tr>
															<td>Profession:</td>
															<td>
																<spring:bind path="doctorSearch.searchCriteria.personType">				
																	<select id="${status.expression}" name="${status.expression}" style="WIDTH: 150px">
																		<option value=""></option>
																		<c:forEach items="${personType}" var="data">
																			<option value='${data.codeDecode}' ${doctorSearch.searchCriteria.personType==data.codeDecode ?"selected=\"selected\"":"" }>${data.codeDecode}</option>
																		</c:forEach>
																	</select>
																 </spring:bind>  
															
															</td>
														</tr>
														 
														<%} %>

													<tr>
														<td width="40%">Date: </td>
														<td width="30%">
															<spring:bind path="doctorSearch.searchCriteria.dateOfAppointment">
																<input type="text" name="${status.expression}" id="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${status.value}"/>" onblur="check_date(this)" />
																
																(mm/dd/yyyy)
															</spring:bind>
														</td>
														<td width="20%">
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'searchDoctor',
																			// input name
																			'controlname': 'searchCriteria.dateOfAppointment'
																			});
																	</script>
																	
																
														</td>
													</tr>
													<tr>
														<td >Locality: </td>
														<td >
															<spring:bind path="doctorSearch.searchCriteria.locality">	
																<input type="text" name="${status.expression}" id="${status.expression}" value="<c:out value="${status.value}"/>"/>
															</spring:bind>		
															<script type="text/javascript">
																new Autocomplete('searchCriteria.locality', { serviceUrl:'/appointmentPopUp.htm' },'PERSON_TY');
															</script>
	
														</td>
													</tr>
													<tr>
														<td >City: </td>
														<td >
															<spring:bind path="doctorSearch.searchCriteria.city">	
																<input type="text" name="${status.expression}" id="${status.expression}" value="<c:out value="${status.value}"/>"/>
															</spring:bind>		
															<script type="text/javascript">
																new Autocomplete('searchCriteria.locality', { serviceUrl:'/appointmentPopUp.htm' },'PERSON_TY');
															</script>
	
														</td>
													</tr>
													
														<tr >     
															<td>
															</td>
															<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;height:30;width:33%"  align="center">  
													  			<a href="#" onClick="javascript:fn_searchDoctor();" style="text-decoration:none"> 
													  				<font size="+1" color="yellow" >Search</font> 
													  			</a>
													  		</td>
														</tr>													  	
														
													</table>
												</div>
												<spring:bind path="doctorSearch.searchResult">
													<c:if test='${not empty status.value}'>
   														<table width=900  border="1" class="layout"   style="border-width: 0px 0px 0px 0px;">
   																<tr bgcolor="lightblue" align="center">
																	Search Results
																</tr>
   															<tr>
   																<td class="sansa">
   																
																	<c:forEach var="searchResult" items="${status.value}">
																	<table width=900  border="1" class="layout"  >
																		<tr>
																			<td width="60%">
																				Name: 	<c:out value="${searchResult.doctorFirstName}"/> 
																						<c:out value="${searchResult.doctorMiddleName}"/> 
																						<c:out value="${searchResult.doctorLastName}"/>
																			</td>	
																			<td width=40%><a href="javascript:fn_dayAppointment('${searchResult.idPerson}','${searchResult.doctorUserName}')" > Take Appointment</a>
																			</td>
																		</tr>
																		<tr >																		<tr>
																			<td>
																				Address: 	<c:out value="${searchResult.address1}"/> 
																			</td>
																			<td>
																			</td>
																				
																		</tr>															
																		<tr>																		<tr>
																			<td width=60%>
																							<c:out value="${searchResult.address2}"/> 
																			</td>
																			<td  width=40%>																				
																				<table width=100>
																					<tr>
																						<c:forEach var="num" items="${fn:split(searchResult.workDays, '-')}">
																							<td style="background: url(/images/blankbutton_0.jpg) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;height=100%;"  align="center">
			                        															<c:out value="${num}" /> 
																							</td>
																						</c:forEach>
																					</tr>
																				</table>
																			</td>
																				
																				
																		</tr>															
																		<tr>																		<tr>
																			<td>
																							<c:out value="${searchResult.locality}"/> 
																			</td>	
																		</tr>															
																		<tr>																		<tr>
																			<td>
																							<c:out value="${searchResult.state}"/> 
																			</td>	
																		</tr>
																			</table>															
																	</c:forEach>
																
																</td>
															</tr>
															
														</table>
													</c:if>
												</spring:bind>
												
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