
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BPUserActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BPUserViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	TreeMap salesArea = null;
	TreeMap roles=null;
	TreeMap managerList=null;
	String selectedSalesArea="";
	String selectedRole="";
	String selectedManager="";
	String userId="";
	String accessRequired="";
	HashSet errorValues = null;
	ArrayList buttonFlags = null;
	ErrorReport errorReport = null;
	BPUserActionForm actionForm = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	BPUserViewBean viewBean = (BPUserViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		actionForm = viewBean.getBPUserActionForm();
		salesArea = viewBean.getSalesAreas();
		roles = viewBean.getRoles();
		accessRequired = viewBean.getAccessRequiredOptions();
		selectedSalesArea = viewBean.getPrimarySalesArea();	
		managerList = viewBean.getManagers();
		
		if(null == actionForm.getAccessRequired()){
			selectedRole = viewBean.getSelectedRole();
			selectedManager = viewBean.getSelectedManager();
			userId = viewBean.getUserId();
		}
		else{
			selectedRole = actionForm.getRole();
			selectedManager = actionForm.getManager();
			userId = actionForm.getUserId();
		}
		
		errorReport = viewBean.getErrorReport();
		errorValues = errorReport.getErrorFieldNames();
	}
%>


<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				User maintenance</h1>

<p ><em><br>New user</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">

<table summary="layout" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="443">
			<table role="presentation" width="443">
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to add a new user to OPPT. Enter atlease one 
						Enterprise customer list number. If you change the primary sales 
						org, click on the GO button next to the primary sales org field 
						to load the Manager information for selected primary sales 
						org. When you are finished press the Save button. Press the Clear all 
						button to discard your input. Press Cancel button to go back to home page.</p>
						
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
<table summary="RegisterBPUser" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/RegisterBPUserMultipleAction.wss">
			<table summary="layout" align="center" width="600" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td align="left">
					<table summary="RegisterBPUser info" cellspacing="1" cellpadding="1" border="0" width="600">
						<tr>
							<td width="12" height="30" align="center"><span class="ibm-required">*</span></td>
							<td width="132"><label for="userid" ><oppt:label label="User id:" id="userid" errorLables="<%=errorValues%>" /></label></td>
							<td width="447">
								<oppt:text name="userId" maxlength="105" size="20" value="<%=userId%>" styleId="userid" styleClass="iform"/>
							 </td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"><span class="ibm-required">*</span></td>
							<td><label for="roledesc" ><oppt:label label="Role:" id="roledesc" errorLables="<%=errorValues%>" /></label></td>
							<td><oppt:select name="role" id="roledesc" style="iform" options="<%=roles%>" selectedOption="<%=selectedRole%>" title="Select role" /></td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"><span class="ibm-required">*</span></td>
							<th><label for="selectaccess" >Access required: </label></th>
							<td>
								<table>
									<tr>
										<td>
											<select name="accessRequired" id="selectaccess" class="iform">
											<%
												if(null == accessRequired || "C".equalsIgnoreCase(accessRequired)){
											%>
													<option value="C" selected="selected">By customer list number</option>
													<option value="L">By legacy customer number</option>
											<%
												}
												else{
											%>
													<option value="C">By customer list number</option>
													<option value="L" selected="selected">By legacy customer number</option>
											<%
												}
											%>
											</select>
										</td>
										<td>&nbsp;</td>
										<td><span class="button-blue"><input type="submit" class="go" name="multipleButtonManager.go" value="GO" /></span></td>
									</tr>
								</table>			
							</td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"><span class="ibm-required">*</span></td>
							<td><label for="sales" ><oppt:label label="Sales org:" id="salesOrg" errorLables="<%=errorValues%>" /></label></td>
							<td>
								<table>
									<tr>
										<td><oppt:select name="primarySalesOrganization" reverse="true" id="sales" style="iform" options="<%=salesArea%>" selectedOption="<%=selectedSalesArea%>" title="Select sales org" /></td>
										<td>&nbsp;</td>
										<td><span class="button-blue"><input type="submit" class="go" name="multipleButtonManager.goSalesOrg" value="GO" /></span></td>
									</tr>
								</table>							
							</td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"><span class="ibm-required">*</span></td>
							<td><label for="managerId" ><oppt:label label="Manager to approve id:" id="managerId" errorLables="<%=errorValues%>" /></label></td>
							<td><oppt:select name="manager" id="managerId" style="iform" options="<%=managerList%>" selectedOption="<%=selectedManager%>"  title="Select manager to approve id" /></td>
						</tr>
					</table>
					&nbsp;<br />
				<%
					if(null == accessRequired || "C".equalsIgnoreCase(accessRequired)){
				%>
						<%@ include file="customerlist.jsp"%>
				<%
					}
					else{
				%>
						<%@ include file="customerlegacy.jsp"%>
				<%
					}
				%>
					
					&nbsp;<br />
					<table summary="layout" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><oppt:button id="save" name="multipleButtonManager.save" primary="true" alt="Save" value="Save" buttonFlags="<%=buttonFlags %>" /></td>
							<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" primary="true" alt="Clear all" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
							<td><oppt:button id="cancel" name="multipleButtonManager.cancelRegister" primary="true" alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
						</tr>
					</table>
					<table summary="layout" cellspacing="0" cellpadding="0" border="0">
						<tr>
							<td><html:hidden property="source" value="register" /></td>
						</tr>
					</table>
					</td>
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


