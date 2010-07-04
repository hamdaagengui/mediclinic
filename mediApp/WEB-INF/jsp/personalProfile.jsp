<%@ include file="/WEB-INF/jsp/include.jsp" %>

  
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
   <div id="contentBodyRight">
    <div id="contentBodyCenter">
     <div id="contentSingleEntry" style="">
      <div id="entries">
       <div class="entryAlone">
        <form name="personalProfile" id="personalProfile" method="post" >
        <spring:hasBindErrors name="command">
         <c:if test="${not empty errors.globalErrors}">
          <div align="center" id="redmsg">
           <ul>
            <c:forEach items="${errors.globalErrors}" var="error">
            <li> <c:out value="${error}"/> </li>
            </c:forEach>
           </ul>
          </div>
         </c:if>
        </spring:hasBindErrors>
        <c:set var="PersonType" value=""/>
        <c:set var="PersonID" value=""/>
        <%  pageContext.setAttribute("PersonType",p.getPersonTypeString());
        pageContext.setAttribute("PersonID",p.getIdPerson()); 
        %>       
         <table width=900  border="1" class="layout"  > 
          <tr>
           <td> 
            <table width=100 align="left"  border="1" class="layout" >
                        <menu:verticalMenuItemTag></menu:verticalMenuItemTag>                          
            </table>

            <div id="Personal Details"  style="display:block" align="center">
            <table  border=""  class="login" width=670 cellpadding="200">
             <tr bgcolor="lightblue" >
              Personal Details
             </tr>
            
             <tr>
              <td >First Name: <font color="red">*</font></td> 
              <td >
               <spring:bind path="person.firstName">                               
                <input type="text"  name="${status.expression}" id="${status.expression}"  value="${person.firstName}"/>
                <font color="red"><c:out value="${status.errorMessage}" /></font>
               </spring:bind>
               
              </td>
             </tr>
             <tr>
              <td >Middle Initials: </td>
              <td >
               <spring:bind path="person.middleInitial">
                <input type="text"  name="${status.expression}" id="${status.expression}"  value="${person.middleInitial}"/>
               </spring:bind>  
              </td>
             </tr>
             <tr>
              <td >Last Name: <font color="red">*</font></td>
              <td >
               <spring:bind path="person.lastName">
                <input type="text"  name="${status.expression}" id="${status.expression}"  value="${person.lastName}"/>
               </spring:bind>  
              </td>
             </tr>
             <tr>
              <td >Date of Birth: <font color="red">*</font></td>
              <td >
              	<spring:bind path="person.dateOfBirth">
                	<input type="text" name="${status.expression}" id="${status.expression}" value='<fmt:formatDate pattern="MM/dd/yyyy" value="${person.dateOfBirth}" />' style="WIDTH: 130px"/>
                </spring:bind>
                 <script language="JavaScript">
                  new tcal ({
                   // form name
                   'formname': 'personalProfile',
                   // input name
                   'controlname': 'dateOOfBirth'
                   });
                 </script>
              </td>
             </tr>
             <tr>
              <td >Gender: <font color="red">*</font></td>
              <td >
               <spring:bind path="person.gender">
                <input type="radio" name="${status.expression}" id="${status.expression}"  value="M"  <c:if test="${person.gender == 'M'}">checked</c:if> /> Male  
                <input type="radio" name="${status.expression}" id="${status.expression}"  value="F" <c:if test="${person.gender == 'F'}">checked</c:if>/> Female
               </spring:bind> 
              </td>
              <spring:bind path="person.idPerson">
               <input type="hidden" name="${status.expression}" value="${person.idPerson}"/>
              </spring:bind>
              <spring:bind path="person.doctorDetails.idDoctor">
               <input type="hidden" name="${status.expression}" value="${person.doctorDetails.idDoctor}"/>
              </spring:bind>
              <spring:bind path="person.doctorDetails.mondayWorking">
               <input type="hidden" name="${status.expression}" value="${person.doctorDetails.mondayWorking}"/>
              </spring:bind>
              <spring:bind path="person.doctorDetails.tuesdayWorking">
               <input type="hidden" name="${status.expression}" value="${person.doctorDetails.tuesdayWorking}"/>
              </spring:bind>
              <spring:bind path="person.doctorDetails.wednesdayWorking">
               <input type="hidden" name="${status.expression}" value="${person.doctorDetails.wednesdayWorking}"/>
              </spring:bind>
              <spring:bind path="person.doctorDetails.thursdayWorking">
               <input type="hidden" name="${status.expression}" value="${person.doctorDetails.thursdayWorking}"/>
              </spring:bind>
              <spring:bind path="person.doctorDetails.fridayWorking">
               <input type="hidden" name="${status.expression}" value="${person.doctorDetails.fridayWorking}"/>
              </spring:bind>
              <spring:bind path="person.doctorDetails.saturdayWorking">
               <input type="hidden" name="${status.expression}" value="${person.doctorDetails.saturdayWorking}"/>
              </spring:bind>
              <spring:bind path="person.doctorDetails.sundayWorking">
               <input type="hidden" name="${status.expression}" value="${person.doctorDetails.sundayWorking}"/>
              </spring:bind>

             </tr>
             <tr>
              <td>Address 1:</td>
              <td>
              	<spring:bind path="person.address.address1">
                <input type="text" name="${status.expression}" id="${status.expression}"  value="${person.address.address1}" style="WIDTH: 400px"/>
                </spring:bind>
              </td>
             </tr>
             <tr>
              <td>Address 2:</td>
              <td>
              	<spring:bind path="person.address.address2">
                	<input type="text" name="${status.expression}" id="${status.expression}"  value="${person.address.address2}" style="WIDTH: 400px"/>
                </spring:bind>
              </td>
             </tr>
             <tr>
              <td>Locality:</td>
              <td>
              	<spring:bind path="person.address.locality">
                	<input type="text" name="${status.expression}" id="${status.expression}"  value="${person.address.locality}" style="WIDTH: 300px"/>
                </spring:bind>
              </td>
             </tr>
             <tr>
              <td>City:</td>
              <td>
              	<spring:bind path="person.address.city">
                	<input type="text" name="${status.expression}" id="${status.expression}"  value="${person.address.city}"/>
                </spring:bind>
              </td>
             </tr>
             <tr>
              <td>State:</td>
              <td>
              	<spring:bind path="person.address.state">
                	<input type="text" name="${status.expression}" id="${status.expression}"  value="${person.address.state}"/>
                </spring:bind>
              </td>
             </tr>
             <tr>
              <td>Country:</td>
              <td>
              	<spring:bind path="person.address.country">
                	<input type="text" name="${status.expression}" id="${status.expression}"  value="${person.address.country}"/>
                </spring:bind>
              </td>
             </tr>
             <tr>
              <td >Phone Number(Landline): </td>
              <td >
              <spring:bind path="person.landlinePhoneNumber">
               <input type="text" name="${status.expression}" id="${status.expression}"  value="${person.landlinePhoneNumber}"/>
              </spring:bind>  
              </td>
             </tr>
             <tr>
              <td >Cell Number: <font color="red">*</font></td>
              <td >
              <spring:bind path="person.cellPhoneNumber">
               <input type="text" name="${status.expression}" id="${status.expression}"  value="${person.cellPhoneNumber}"/>
              </spring:bind>  
              </td>
             </tr>
           </div>
           <c:if test="${'Doctor' == person.personTypeString}">
           <div id="Personal Details"  style="display:block" align="right">
            <table  border=""  class="login" width=670 cellpadding="100" align="right">
             <tr bgcolor="lightblue" >
              Other Details
             </tr>
             <tr>
               <td>Registration Number:<font color="red">*</font></td>
               <td>
               		<spring:bind path="person.registrationNumber">
               			<input type="text" name="${status.expression}" id="${status.expression}"  value="${person.registrationNumber}"  style="WIDTH: 200px"/>
               		</spring:bind>
               	</td>
               		
               
             </tr>             
             
             <tr>
               <td>Specialization:<font color="red">*</font></td>
               <td>
					<spring:bind path="person.specialization">
                	<input type="text" name="${status.expression}" id="${status.expression}"  value="${person.specialization}" style="WIDTH: 300px"/>
                	</spring:bind>  
                <script type="text/javascript">
                 new Autocomplete('specialization', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALITY');
                </script>
               </td>
              </tr>
             
            
              <tr>
               <td>Availability:<font color="red">*</font></td>
               <td>
               <table border="0" width="">
	                <tr>
		                <td>
			                <div style="overflow:auto;width:150px;height:150px;border:1px solid #336699;padding-left:5px;background-color:white;">
			                 <input type="checkbox" name="sundayWorking" id="sundayWorking" value="Y" >Sunday</input><br>
			                 <input type="checkbox" name="mondayWorking" id="mondayWorking" value="Y" >Monday</input><br>
			                 <input type="checkbox" name="tuesdayWorking" id="tuesdayWorking" value="Y" >Tuesday</input><br>
			                 <input type="checkbox" name="wednesdayWorking" id="wednesdayWorking" value="Y" >Wednesday<br>
			                 <input type="checkbox" name="thursdayWorking" id="thursdayWorking" value="Y" >Thursday</input><br>
			                 <input type="checkbox" name="fridayWorking" id="fridayWorking" value="Y" >Friday</input><br> 
			                 <input type="checkbox" name="saturdayWorking" id="saturdayWorking" value="Y" >Saturday</input><br>
			                </div>
		                </td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                <td>Start Time:<font color="red" >*</font></td>
		                <td>
			                <input type="text" name="startTime" id="startTime"  style="WIDTH: 80px"/>  
	        	        </td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;               
	                	<td>End Time:<font color="red" >*</font></td>
	                	<td>
	    	            	<input type="text" name="endTime" id="endTime"  style="WIDTH: 80px" />  
	                	</td>                
	                </tr>
	                <tr>
	                	<td align="center" colspan="2">
	                  		<input id="addWorkHours" name ="addWorkHours" type="button"  onclick="javascript:fn_addRowForWorkHours();" alignment="center" value="Add" class="bsubmit"  width="75"/>
	                 	</td>
	                </tr>
               </table>
               <table border="1" width="600" id="tblWorkHours" style="display:none">
                	<input type="hidden" value="1" id="counter"/>               
                    <tr>
   			        	<td> Work Day:
               			</td>
               			<td> From Time:
               			</td>
               			<td> To Time:
               			</td>
                	</tr>
               </table>
             </td>
           </tr>
        </table>
      </div>
    </c:if>
             <tr>
              <td align="center" colspan="2">
               <input id="saveProfile" name ="saveProfile" type="submit"  alignment="center" value="Save" class="bsubmit"  width="75"/>
              </td>
             </tr>
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