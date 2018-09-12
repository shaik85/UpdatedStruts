
<!--(C) Copyright IBM Corp. 2004, 2005  All Rights Reserved  -->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserMaintenanceViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserInfoViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	TreeMap salesArea = null;
	TreeMap userDetail=null;
	ArrayList buttonFlags = null;
	ErrorReport errorReport = null;

	OPPTSession opptSession = new OPPTSession(session);
	UserMaintenanceViewBean viewBean = (UserMaintenanceViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		salesArea = viewBean.getSalesAreas();
		userDetail = viewBean.getUserInfos();
		
		buttonFlags=viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				User maintenance</h1>		
		</div>
	</div>	

<div id="ibm-content-body">

<table role="presentation" cellpadding="0" cellspacing="0" border="0" >
	<tr valign="top">
		<td width="650">
			<table role="presentation" width="650">
					
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						Use this page to process specific user id maintenance 
						transactions and to synchronize the Sales area,  Currency,
						 Payment terms, Billingblock tables with the ones existing in ESW.
						<br>
						Required fields are marked with an asterisk (<strong>*</strong>)
						and must be filled in to complete the form.
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="650">
	
	<tr valign="top">	
		<td >
			<html:form action="protect/ListUser.wss">
				<table role="presentation">
					<tr>
						<td><label for="sales"> Sales org:</label> </td>
						<td><oppt:select name="salesArea" id="sales" style="iform" options="<%=salesArea%>" reverse="true" selectedOption="<%=viewBean.getSelectedSalesArea()%>" title="Select Salesorg"/></td>
						<td>&nbsp;<span  class="button-blue"><input class="ibm-btn-arrow-sec" type="submit" value="Go" /></span>&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
				</table>
			</html:form>
			<html:form action="protect/UserMaintenanceMultipleAction.wss">
				<table border="0" class="ibm-data-table ibm-alternating"  width="650" cellpadding="1" cellspacing="1" summary="List of Users" >
				<%
					if(userDetail != null && userDetail.size() > 0){
				%>	
				
					<tr style="background-color:#cccccc;" class="dark">
						<th nowrap="nowrap" width="30"  id="SelectId"><strong class="black">*</strong>Required</th>
						<th nowrap="nowrap" width="130" id="UserId">&nbsp;&nbsp;User ID</th>
						<th nowrap="nowrap" width="120" id="Role">&nbsp;&nbsp;Role</th>
						<th nowrap="nowrap" width="130" id="ApprovedBy">&nbsp;&nbsp;Approved by</th>
						<th nowrap="nowrap" width="120" id="Group">&nbsp;&nbsp;Group</th>
						<th nowrap="nowrap" width="120" id="userType">&nbsp;&nbsp;User Type</th>
					</tr>
					
					<%
					        int count = 1;
							Iterator keyIterator = userDetail.keySet().iterator();
							while(keyIterator.hasNext()){
								Object keyObject = keyIterator.next();
								UserInfoViewBean userData = (UserInfoViewBean)userDetail.get(keyObject);
								String userId = userData.getUserId();
								String labelValue = "user" + userId;
								if((count % 2) == 1) {
   				    %>				<tr class="white">
					<%          }
								else {
					%>				<tr class="gray">
                    <%          }
					%>			<td width="30"  headers="SelectId" ><input type="radio" name="userId" id="<%=labelValue%>" value="<%=userId%>"/></td>
								<td width="130" headers="UserId"><label for="<%=labelValue%>"><%=userData.getUserIdValue(15) %></label></td>
								<td width="120" headers="Role"><%=userData.getRoleDescription()%></td>
								<td width="130" headers="ApprovedBy"><%=userData.getApprovedBy()%></td>
								<td width="120" headers="Group"><%=userData.getGroup()%></td>
								<td width="120" headers="userType"><%= userData.getUserTypDesc() %></td>								
								</tr>
					<%
							count++;
							}
						}
					%>
						<tr>
						
							<oppt:proposalmaintenance message="<%=viewBean.getMessage() %>" />
						
					</tr>
						<tr>
							<th colspan="6" scope="col">&nbsp;</div>
						</tr>
				</table>
							
				<table role="presentation" width="600" border="0" cellspacing="0" cellpadding="0" align="right">
					<tr>
						<td width="150"><oppt:button id="addUser" name="multipleButtonManager.createUser" alt="Add User" value="Add user" buttonFlags="<%=buttonFlags %>" /></td>
						<td width="150"><oppt:button id="removeUser" name="multipleButtonManager.removeUser" alt="Remove user" value="Remove user" buttonFlags="<%=buttonFlags %>" /></td>
						<td width="150"><oppt:button id="edit" name="multipleButtonManager.editUser" alt="Edit" value="Edit" buttonFlags="<%=buttonFlags %>" /></td>
						<td width="150"><oppt:button id="transfer" name="multipleButtonManager.transfer" alt="Transfer" value="Transfer" buttonFlags="<%=buttonFlags %>" /></td>
						<td width="150"><oppt:button id="release" name="multipleButtonManager.release" alt="Release" value="Release"  buttonFlags="<%=buttonFlags %>" /></td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;<br /></td>
					</tr>
					<tr>
						<td width="150"><oppt:button id="updateSalesArea" name="multipleButtonManager.updateSalesOrg" alt="Update sales area" value="Update sales area"  buttonFlags="<%=buttonFlags %>" /></td>
						<td width="150"><div><oppt:button id="updateCurrency" name="multipleButtonManager.updateCurrency" alt="Update currency" value="Update currency"  buttonFlags="<%=buttonFlags %>" /></div></td>
						
						<td width="150"><oppt:button id="updatePayment" name="multipleButtonManager.updatePayment" alt="Update payment" value="Update payment"  buttonFlags="<%=buttonFlags %>" /></td>	
						<!-- OPPT BH -Payment method CR 6B --Nomita -->
						<td width="150"><oppt:button id="updatePaymentMethod" name="multipleButtonManager.updatePaymentMethod" alt="Update payment method" value="Update payment method"  buttonFlags="<%=buttonFlags %>" /></td>
						<td width="150"><oppt:button id="updateBilling" name="multipleButtonManager.updateBilling" alt="Update billing" value="Update billing"  buttonFlags="<%=buttonFlags %>" /></td>
						</tr>
					<tr>
						<td colspan="4">&nbsp;<br /></td>
					</tr>
					<tr>
					<!-- OPPT BH -DAD001 SRINIVAS -->
					<td width="150"><oppt:button id="updateBillingBlock" name="multipleButtonManager.updateBillingBlock" alt="Update billing block" value="Update billing block"  buttonFlags="<%=buttonFlags %>" /></td>
					<td width="150"><oppt:button id="updateBlbIndicator" name="multipleButtonManager.updateBlbIndicator" alt="Update blb indicator" value="Update BLB indicator"  buttonFlags="<%=buttonFlags %>" /></td>
					<td width="150"><oppt:button id="activityLog" name="multipleButtonManager.activityLog" alt="Activity Log" value="Activity log"  buttonFlags="<%=buttonFlags %>" /></td>
					</tr>
					<tr>
						<td width="150">&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width="150">&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>
			</html:form>			
		</td>
	</tr>
	
</table>
<!-- start content head -->
		<div id="ibm-content-head">


		</div> 
    	<!-- stop content head -->


	<div id="ibm-content-main">
		<div style="position:absolute; top:0;right:10px;">
 <p class="ibm-ind-link"><a href="javascript:getFormHelp()" title="Page help"  class="ibm-popup-link" >Page Help</a></p>
		</div>	
	</div>

</div>