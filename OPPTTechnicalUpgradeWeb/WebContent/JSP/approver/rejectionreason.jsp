
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.RejectionReasonViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	RejectionReasonViewBean view = (RejectionReasonViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposals for approval</h1>

<p ><em><br>Rejection reason</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">

<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Proposals for approval">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />

						<p>Use this form to enter the reason for rejecting the proposal. When
						you are finished click on the Continue button. Press the Cancel button to go back to proposals for approval page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<html:form action="/protect/RejectionReasonMultipleAction.wss">
	<table cellspacing="1" cellpadding="1" width="600" summary="rejectionReason">
		<tr>
			<td width="1" height="30">&nbsp;</td>
			<td width="142"><label for="rejectionReason"><oppt:label id="rejectionReason" label="Reason for rejection:" errorLables="<%=errorValues %>" /></label></td>
			<td width="437">&nbsp;&nbsp;<oppt:text name="rejectionReason" styleId="rejectionReason" styleClass="iform" size="50" maxlength="200" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table border="0" cellspacing="1" cellpadding="1" role="presentation" align="right">
		<tr>
			<td><oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue" value="Continue" primary="true" /></td>
			<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" value="Cancel" /></td>
		</tr>
	</table>
</html:form>
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
