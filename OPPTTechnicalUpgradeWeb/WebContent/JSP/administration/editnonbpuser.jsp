
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
	TreeMap managers = null;
	TreeMap groups = null;
	TreeMap userTypes = null;
	String userId = "";
	String selectedRole = "";
	String selectedUserTypeDesc = "";
	String selectedUserType = "";
	String selectedManager = "";
	String primarySalesArea = "";
	String [] selectedGroup = null;
	ArrayList groupsThatCannotBeDeleted = null;
	String primaryAccess = "";
	HashSet errorValues = null;
	ArrayList buttonFlags = null;
	ErrorReport errorReport = null;
	NonBPUserActionForm actionForm = null;
	TreeMap accessMap = new TreeMap();
	
	OPPTSession opptSession = new OPPTSession(session);
	NonBPUserViewBean viewBean = (NonBPUserViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		actionForm = viewBean.getNonBPUserActionForm();
		
		userId = viewBean.getUserId();
		userTypes = viewBean.getUserTypes();
		salesArea = viewBean.getSalesAreas();
		primarySalesArea = viewBean.getPrimarySalesArea();
		managers = viewBean.getManagers();
		if(viewBean.getSelectedUserType().equals(Constants.SOFTWARE_USER)) {
			roles = viewBean.getRoles();
			groups = viewBean.getGroups();
		    groupsThatCannotBeDeleted = viewBean.getNonBPUserData().getGroupsThatCannotBeDeleted();
		}
		else {
    		roles = viewBean.getBaRoles();
		}
		
		if(null == actionForm.getNonBPUserDataBean().getRole() && 
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
			primaryAccess = viewBean.getAuthorization();
			
		}
		else{
			selectedUserType = actionForm.getNonBPUserDataBean().getUserType();
			selectedUserTypeDesc = (String) userTypes.get(actionForm.getNonBPUserDataBean().getUserType());
		    selectedRole = actionForm.getNonBPUserDataBean().getRole();
			selectedManager = actionForm.getNonBPUserDataBean().getManager();
			selectedGroup = actionForm.getNonBPUserDataBean().getGroupName();
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

<p ><em><br>Edit user</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table summary="User maintenance" width="600">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to change access to OPPT for an existing user. 
						If you change the primary sales org, click on the GO button next 
						to the primary sales org field to load the Group and Manager information 
						for selected primary sales org.	When you are finished, press the Save 
						button. Press the Clear all button to discard your input.
						Press Cancel button to go back to user maintenance page.</p>
						
						<p>Required fields are marked with an asterisk (<strong>*</strong>)
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
		<td >
			<html:form action="/protect/EditNonBPUserMultipleAction.wss">
			<table role="presentation" align="center" width="600" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td align="left" >
					<table role="presentation" cellspacing="1" cellpadding="1" border="0" width="600">
						<tr>
							<td width="12" height="30" align="center"></td>
							<td width="70">User ID:</td>
							<td width="437"><%=userId%></td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"></td>
							<td width="70">User type:</td>
							<td width="437"><%=selectedUserTypeDesc%>
							<input type="hidden" name="nonBPUserDataBean.userType" value="<%= selectedUserType%>" /></td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"></td>
							<td><label for="roledesc"><span class="ibm-required">*</span><oppt:label label="Role:" id="roledesc" errorLables="<%=errorValues%>" /></label></td>
							<td><oppt:select name="nonBPUserDataBean.role" style="iform" id="roledesc" options="<%=roles%>" selectedOption="<%=selectedRole%>" title= "Slect role" />
						 <% if(selectedUserType.equals(Constants.SOFTWARE_USER))  {   %>
						       <span class="button-blue"><input class="ibm-btn-arrow-sec" type="submit" class="role" name="multipleButtonManager.role" value="Go" /></span>
      <%                 }      %> 
						</td>
						</tr>
					</table>
					<br />
					<table summary="Selecting the Access Type for the Sales Org" cellspacing="1" cellpadding="1" border="0" width="600">
						<tr align="left">
							<th width="12"  style="background-color:#cccccc;"  scope="col">&nbsp;</th>
							<th width="282" height="18" style="background-color:#cccccc;"  scope="col">Access type:</th>
							<th width="12"  style="background-color:#cccccc;"  scope="col">&nbsp;</th>
							<th width="282" style="background-color:#cccccc;" scope="col">Sales org:</th>
							<th width="50" style="background-color:#cccccc;"  scope="col">&nbsp;</th>
						</tr>
						<tr>
							<td width="12" height="30" align="center" scope="col"><strong><label ><span class="ibm-required">*</span></label></strong></td>
							<td><label class="access" >&nbsp;</label><oppt:select name="nonBPUserDataBean.primaryAccessType" id="accesstype" style="iform" options="<%=accessMap%>" selectedOption="<%=primaryAccess%>" title= "Select access type" /></td>
							<td width="12" height="30" align="center" scope="col"><strong><label ><span class="ibm-required">*</span></label></strong></td>
							<td><label class="access" >&nbsp;</label><oppt:select name="nonBPUserDataBean.primarySalesOrganization" id="salesorg" reverse="true" style="iform" options="<%=salesArea%>" selectedOption="<%=primarySalesArea%>" title= "Select sales org"  /></td>
							<td>&nbsp;</td>
			<% 			           if(selectedUserType.equals(Constants.SOFTWARE_USER))
			   				        {			
		    %>							<td><span class="button-blue"><input class="ibm-btn-arrow-sec"type="submit" class="go" name="multipleButtonManager.go" value="Go" /></span></td>
			<%                      }
			%>			</tr>
			<% 
			           if(selectedUserType.equals(Constants.SOFTWARE_USER))
			           {			
		    %>						
						<oppt:nonbpuser nonbpview="<%=viewBean%>" accessmap="<%=accessMap%>" edituser="true" />
						<tr><td colspan="3">&nbsp;</td></tr>
						</table>
						<table summary="Selecting the Group for the User" cellspacing="1" cellpadding="1" border="0" width="600">
						<tr align="left">
							<th width="12" style="background-color:#cccccc;" scope="col">&nbsp;</th>
							<th width="282" height="18" style="background-color:#cccccc;" scope="col">Group:</th>
							<th width="12" style="background-color:#cccccc;" scope="col">&nbsp;</th>
							<th width="282" style="background-color:#cccccc;" scope="col"></th>
						</tr>						
						<oppt:groupSelect name="nonBPUserDataBean.groupName" id="selectGroup" style="iform" options="<%=groups%>" selectedOption="<%=selectedGroup%>" nonEditableFields = "<%=groupsThatCannotBeDeleted%>"/>
						<tr>
							 <td colspan="4">&nbsp;</td>
						</tr>
			<%
			            }
			%>			
						<tr>
							<td width="12" height="30" align="center"></td>
							<td colspan="3"><label for="managerId" ><span class="ibm-required">*</span><oppt:label label="Manager to approve ID:" id="managerId" errorLables="<%=errorValues%>" /></label>
							<oppt:select name="nonBPUserDataBean.manager" id="managerId" style="iform" options="<%=managers%>" selectedOption="<%=selectedManager%>" /></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			<table summary="edit">
				<tr>
					<td><html:hidden property="source" value="edit"/></td>
				</tr>
			</table>
			&nbsp;<br />
			<table role="presentation" cellpadding="0" cellspacing="0" border="0" align="right">
				<tr>
					<td><oppt:button id="save" name="multipleButtonManager.save" primary="true" alt="Save" value="Save" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll"  alt="Clear all" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="cancel" name="multipleButtonManager.cancel"  alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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
		for(var x=0; x<hiddenElements.length; x++){
			console.log("before "+hiddenElements[x].value);
			console.log("before "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
			hiddenElement = document.getElementById(hiddenElements[x].value)
			if (hiddenElement){hiddenElement.setAttribute("aria-invalid","true")};
			console.log("after "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
		}
	}
</script>


