
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CreateUserActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	TreeMap salesArea = null;
	TreeMap userTypes = null;
	String userId = "";
	String userType = "";
	String salesOrg = "";
	ErrorReport errorReport = null;
	ArrayList buttonFlags = null;
	HashSet errorValues=null;
	CreateUserActionForm actionForm = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	UserViewBean viewBean = (UserViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		salesArea = viewBean.getSalesAreas();
		userTypes = viewBean.getUserTypes();
		actionForm = viewBean.getCreateUserActionForm();
		
		if(null != actionForm.getUserDataBean()){
			userId = actionForm.getUserDataBean().getUserId();
			userType = actionForm.getUserDataBean().getUserType();
			salesOrg = actionForm.getUserDataBean().getPrimarySalesOrganization();
		}
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorValues = errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				User maintenance</h1>

<p ><em><br>New User</em></p>		
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
						
						<p>Use this form to add a new user to OPPT. When you are finished 
						press the Continue button. Press the Clear all button to discard your 
						input. Press Cancel button to go back to home page.</p>
						
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
		<td>
			<html:form action="/protect/RegisterUserMultipleAction.wss">
				<table role="presentation" align="center" width="600" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td align="left">
							<table role="presentation" cellspacing="1" cellpadding="1" border="0" width="600">
								<tr>
									<td width="12" height="30" align="center"></td>
									<td width="132"><label   for="userid" ><span class="ibm-required">*</span><oppt:label label="User ID:" id="userid"  errorLables="<%=errorValues%>" /></label></td>
									<td width="447">
										<oppt:text name="userDataBean.userId" maxlength="105" size="20" value="<%=userId%>" styleId="userid" styleClass="iform"/>
									</td>
								</tr>
								<tr>
									<td width="12" height="30" align="center"></td>
									<td><label for="usertype" ><span class="ibm-required">*</span><oppt:label label="User type:" id="usertype"   errorLables="<%=errorValues%>" /></label></td>
									<td><oppt:select name="userDataBean.userType" style="iform" id="usertype" selectedOption="<%=userType%>" options="<%=userTypes%>"  title="Select user type" /></td>
								</tr>
								<tr>
									<td width="12" height="30" align="center"></td>
									<td><label for="sales" ><span class="ibm-required">*</span><oppt:label label="Primary sales org:" id="sales" errorLables="<%=errorValues%>" /></label></td>
									<td><oppt:select name="userDataBean.primarySalesOrganization" reverse="true" selectedOption="<%=salesOrg%>" id="sales" style="iform" options="<%=salesArea%>" title="Select sales org" /></td>
								</tr>
							</table>
							&nbsp;<br />
							<table  role ="presentation" cellpadding="0" cellspacing="0" border="0" align="right">
								<tr>
									<td><oppt:button id="continue" name="multipleButtonManager.continue" primary="true" alt="Continue" 	value="Continue" buttonFlags="<%=buttonFlags %>" /></td>
									<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll"  alt="Clear all" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
									<td><oppt:button id="cancel" name="multipleButtonManager.cancelRegister"  alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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


