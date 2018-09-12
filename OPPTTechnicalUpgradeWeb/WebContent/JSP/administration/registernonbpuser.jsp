
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.NonBPUserActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.NonBPUserViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants"%>

<%
	TreeMap salesArea = null;
	TreeMap roles = null;
	TreeMap userTypes = null;
	TreeMap managerList = null;
	TreeMap groups = null;
	String [] selectedGroup = null;
	String primarySalesArea = "";
	String primaryAccess = "";
	String selectedRole = "";
	String selectedUserType = "";
	String selectedUserTypeDesc = "";
	String selectedManager ="";
	String userId = "";
	ArrayList buttonFlags = null;
	HashSet errorValues = null;
	ErrorReport errorReport = null;
	NonBPUserActionForm actionForm = null;
	
	TreeMap accessMap = new TreeMap();
	OPPTSession opptSession = new OPPTSession(session);
	NonBPUserViewBean viewBean = (NonBPUserViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean) {
		actionForm = viewBean.getNonBPUserActionForm();
		salesArea = viewBean.getSalesAreas();
		userTypes = viewBean.getUserTypes();
		if(viewBean.getSelectedUserType().equals(Constants.SOFTWARE_USER)) {
			roles = viewBean.getRoles();
			groups = viewBean.getGroups();
		}
		else {
    		roles = viewBean.getBaRoles();
		}
		managerList = viewBean.getManagers();
		primarySalesArea = viewBean.getPrimarySalesArea();
		
		if(null == actionForm.getNonBPUserDataBean().getUserType() && 
			null == actionForm.getNonBPUserDataBean().getPrimarySalesOrganization()){
			
			selectedUserType = viewBean.getSelectedUserType();
			selectedUserTypeDesc = (String) userTypes.get(viewBean.getSelectedUserType());
			if(selectedUserType.equals(Constants.SOFTWARE_USER))
			{
			  selectedRole = viewBean.getSelectedRole();
			} else {
			  selectedRole = viewBean.getSelectedBARole();
			}
			selectedManager = viewBean.getSelectedManager();
			selectedGroup = viewBean.getSelectedGroups();
			userId = viewBean.getUserId();
			primaryAccess = viewBean.getAuthorization();
		}
		else{
            selectedUserType = actionForm.getNonBPUserDataBean().getUserType();
			selectedUserTypeDesc = (String) userTypes.get(actionForm.getNonBPUserDataBean().getUserType());
		    selectedRole = actionForm.getNonBPUserDataBean().getRole();
			selectedManager = actionForm.getNonBPUserDataBean().getManager();
			selectedGroup = actionForm.getNonBPUserDataBean().getGroupName();
			userId = actionForm.getNonBPUserDataBean().getUserId();
			primaryAccess = actionForm.getNonBPUserDataBean().getPrimaryAccessType();
		}
		
		accessMap.put("*","All");
		accessMap.put("N","Non Sensitive");
		accessMap.put("S","Sensitive");
		
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorValues = errorReport.getErrorFieldNames();
	}
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				User maintenance</h1>

<p ><em><br>Register user</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to add a new user to OPPT. If you change the primary sales 
						org, click on the GO button next to the primary sales org field to load the 
						Group and Manager information for selected primary sales org. When you are 
						finished press the Save button. Press the Clear all button to discard your input.
						Press Cancel button to go back to home page.</p>
						
						<p>Required fields are marked with an asterisk (<b>*</b>)
							and must be filled in to complete the form.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="/protect/RegisterNonBPUserMultipleAction.wss">
			<table role="presentation" align="center" width="600" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td align="left">
					<table role="presentation" cellspacing="1" cellpadding="1" border="0" width="600">
						<tr>
							<td width="12" height="30" align="center"></td>
							<td width="70"><span class="ibm-required">*</span><label ><oppt:label label="User ID:" id="userid" errorLables="<%=errorValues%>" /></label></td>
							<td width="437">
								<oppt:text name="nonBPUserDataBean.userId" maxlength="105" size="20" value="<%=userId%>" styleId="userid" styleClass="iform" title= "User ID"/>
							</td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"></td>
							<td><label ><span class="ibm-required">*</span><oppt:label label="Role:" id="roledesc" errorLables="<%=errorValues%>" /></label></td>
							<td><oppt:select name="nonBPUserDataBean.role" id="roledesc" style="iform" options="<%=roles%>" selectedOption="<%=selectedRole%>" title= "Select role" />
						 <% if(selectedUserType.equals(Constants.SOFTWARE_USER))  {   %>
						       <span class="button-blue"><input type="submit" class="ibm-btn-arrow-sec" name="multipleButtonManager.role" value="Go" /></span>
      <%                 }      %> 
        </td>
						
						</tr>
						<tr>
							<td width="12" height="30" align="center"></td>
							<td width="70"><label><oppt:label label="User type:" id="usertype" errorLables="<%=errorValues%>" /></label></td>
							<td width="437">
								<oppt:text name="nonBPUserDataBean.userTypeDesc" maxlength="105" size="25" value="<%= selectedUserTypeDesc %>" styleId="usertypeDesc" styleClass="iform" readonly="true"  title= "userTypeDesc"/>
								<input type="hidden" id="usertype" name="nonBPUserDataBean.userType" value="<%= selectedUserType %>"  ></input>
							</td>
						</tr>
					</table>
					&nbsp;<br />
					<table summary="Selecting the Access Type for the Sales Org" cellspacing="1" cellpadding="1" border="0" width="600">
						<tr align="left">
							<th width="12" class="bar-blue-med" style="background-color:#cccccc;" scope="col">&nbsp;</th>
							<th width="282" height="18" class="bar-blue-med" style="background-color:#cccccc;" scope="col">Access type:</th>
							<th width="12" class="bar-blue-med" style="background-color:#cccccc;" scope="col">&nbsp;</th>
							<th width="282" class="bar-blue-med" style="background-color:#cccccc;" scope="col">Sales org:</th>
							<th width="50" class="bar-blue-med" style="background-color:#cccccc;" scope="col">&nbsp;</th>
						</tr>
						<tr>
							<td width="12" height="30" align="center"><b><label for="access1"><span class="ibm-required">*</span></label></b></td>
							<td><label class="access" >&nbsp;</label><oppt:select name="nonBPUserDataBean.primaryAccessType" id="accesstype" style="iform" options="<%=accessMap%>" selectedOption="<%=primaryAccess%>" title= "Select access type" /></td>
							<td width="12" height="30" align="center"><b><label for="salesarea1"><span class="ibm-required">*</span></label></b></td>
							<td><label class="access" >&nbsp;</label><oppt:select name="nonBPUserDataBean.primarySalesOrganization" id="salesorg" reverse="true" style="iform" options="<%=salesArea%>" selectedOption="<%=primarySalesArea%>" title= "Select sales org" /></td>
                                                        <td>&nbsp;</td>
		 <% 
					           if(selectedUserType.equals(Constants.SOFTWARE_USER))
			        		   {			
            
	     %>					<th scope="col"><span class="button-blue"><input class="ibm-btn-arrow-sec" type="submit" class="go" name="multipleButtonManager.go" value="Go" /></span></th>
             			
             <%                } 
              %> 
									</tr>
						
			<% 
			           if(selectedUserType.equals(Constants.SOFTWARE_USER))
			           {			
		    %>
						<oppt:nonbpuser nonbpview="<%=viewBean%>" accessmap="<%=accessMap%>" edituser="true" />
						<tr><td colspan="3">&nbsp;</td></tr>
						</table>
						<table summary="Selecting the Group for the User" cellspacing="1" cellpadding="1" border="0" width="600">
						<tr align="left">
							<th width="12" class="bar-blue-med" style="background-color:#cccccc;" scope="col">&nbsp;</th>
							<th width="282" height="18" class="bar-blue-med" style="background-color:#cccccc;" scope="col">Group:</th>
							<th width="12" class="bar-blue-med" style="background-color:#cccccc;" scope="col">&nbsp;</th>
							<th width="282" class="bar-blue-med" style="background-color:#cccccc;" scope="col"></th>
						</tr>						
						<oppt:groupSelect name="nonBPUserDataBean.groupName" id="selectGroup" style="iform" options="<%=groups%>" selectedOption="<%=selectedGroup%>"/>
						<tr>
						 <td colspan="4">&nbsp;</td>
						</tr>
					
			<% 
			            }
			%> 
						<tr>
							<td width="12" height="30" align="center"></td>
							<td colspan="3"><label for="managerId" ><span class="ibm-required">*</span><oppt:label label="Manager to approve ID:" id="managerId" errorLables="<%=errorValues%>" /></label>
							<oppt:select name="nonBPUserDataBean.manager" id="managerId" style="iform" options="<%=managerList%>" selectedOption="<%=selectedManager%>"  /></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			<table role="presentation">
				<tr>
					<td><html:hidden property="source" value="edit"/></td>
				</tr>
			</table>
			&nbsp;<br />
			<table role="presentation" cellpadding="0" cellspacing="0" border="0" align="left">
				<tr>
					<td><oppt:button id="save" name="multipleButtonManager.save" primary="true" alt="Save" value="Save" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="cancel" name="multipleButtonManager.cancelRegister"  alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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

<script type="text/javascript">
	window.onload = function() {
		var hiddenElements = document.getElementsByName("validationErrorElements");
		//read the identifier of the error fields, from the hiddenElements 
		//and set the aria-invalid attribute for those ids
		var hiddenElement = null;
		var dayElem = null;
		var monthElem = null;
		var yearElem = null;
		for(var x=0; x<hiddenElements.length; x++){
			
			//check if the hiddenElements are one of the special fields and 
			//override the target field

			console.log("before "+hiddenElements[x].value);
			//console.log("before "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
			console.log("the value is"+hiddenElements[x].value);
			switch (hiddenElements[x].value)
			{	
				
				case  "":
					dayElem = document.getElementById("contractStartDateDay");
					monthElem = document.getElementById("contractStartDateMonth");
					yearElem = document.getElementById("contractStartDateYear");

					if (dayElem && dayElem.options.selectedIndex == 0) {
					//console.log("Cs1");
						dayElem.setAttribute("aria-invalid","true");
					}  if (monthElem && monthElem.options.selectedIndex == 0) {
					//console.log("Cs2");
						monthElem.setAttribute("aria-invalid","true");
					} if (yearElem && yearElem.options.selectedIndex == 0) {
					//console.log("Cs3");
						yearElem.setAttribute("aria-invalid","true");
					}
					break;
				
				case "contractEndDate":
				dayElem = document.getElementById("contractEndDateDay");
					monthElem = document.getElementById("contractEndDateMonth");
					yearElem = document.getElementById("contractEndDateYear");

					if (dayElem && dayElem.options.selectedIndex == 0) {
				//	console.log("Cs4");
						dayElem.setAttribute("aria-invalid","true");
						}
					  if (monthElem && monthElem.options.selectedIndex == 0) {
				//	console.log("Cs5");
						monthElem.setAttribute("aria-invalid","true");
						}
					 	 if (yearElem && yearElem.options.selectedIndex == 0) {
				//	console.log("Cs6");
						yearElem.setAttribute("aria-invalid","true");
						}
					
					break;
				case "contractPeriodBeginning":
				dayElem = document.getElementById("contractPeriodStartDateDay");
					monthElem = document.getElementById("contractPeriodStartDateMonth");
					yearElem = document.getElementById("contractPeriodStartDateYear");

					if (dayElem && dayElem.options.selectedIndex == 0) {
				//	console.log("Cs7");
						dayElem.setAttribute("aria-invalid","true");
					} if (monthElem && monthElem.options.selectedIndex == 0) {
				//	console.log("Cs8");
						monthElem.setAttribute("aria-invalid","true");
					} if (yearElem && yearElem.options.selectedIndex == 0) {
				//	console.log("Cs9");
						yearElem.setAttribute("aria-invalid","true");
					}
					break;
				case "contractPeriodEnding":
				dayElem = document.getElementById("contractPeriodEndDateDay");
					monthElem = document.getElementById("contractPeriodEndDateMonth");
					yearElem = document.getElementById("contractPeriodEndDateYear");

					if (dayElem && dayElem.options.selectedIndex == 0) {
					//console.log("Cs10");
						dayElem.setAttribute("aria-invalid","true");
					}  if (monthElem && monthElem.options.selectedIndex == 0) {
					//console.log("Cs11");
						monthElem.setAttribute("aria-invalid","true");
					}  if (yearElem && yearElem.options.selectedIndex == 0) {
					//console.log("Cs12");
						yearElem.setAttribute("aria-invalid","true");
					}
					break;
				//add case statements here to cover additional fields having this issue

				default:
					hiddenElement = document.getElementById(hiddenElements[x].value)
					if (hiddenElement) {
						hiddenElement.setAttribute("aria-invalid","true");
					}
					break;

		}	
}
}
</script>



