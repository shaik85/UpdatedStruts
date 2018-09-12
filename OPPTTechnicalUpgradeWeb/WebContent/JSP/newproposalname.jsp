
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.NewProposalNameViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	NewProposalNameViewBean view = (NewProposalNameViewBean)opptSession.getCurrentMessageViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				BH-OPPT</h1>

<p ><em><br><%=view.getTitle()%></em></p>		
		</div>
	</div>

<div id="ibm-content-body">



<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" summary="copyproposal">
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Enter new proposal name and click on Continue to submit the newly entered proposal name. 
						Press the Cancel button to terminate the process.</p>
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

<html:form action="/protect/NewProposalNameMultipleAction.wss" method="post" >
	<input type="hidden" name="initiator" value="<%=view.getInitiator()%>" />
	<table border="0" cellspacing="1" cellpadding="1" width="600" role="presentation">
		<tr>
			<td class="bar-blue-med" align="left" colspan="3" style="background-color:#cccccc;">Proposal name information</td>
		</tr>
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td width="12" height="30"></td>
			<td width="110"><span><label
				for="newProposalName"><strong></strong><oppt:label label="Proposal name:" id="newProposalName" errorLables="<%=errorValues%>" /></label></span></td>
			<td width="297"><oppt:text name="newProposalName" styleId="newProposalName" size="20" maxlength="38" value="" styleClass="iform" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table border="0" cellspacing="1" cellpadding="1" role="presentation" align="left" >
		<tr>
			<td><oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue" primary="true" value="Continue" /></td>
			<td><oppt:button id="cancel" name="multipleButtonManager.cancel"  alt="Cancel" value="Cancel" /></td>
		</tr>
	</table>
</html:form>

<!-- start content head -->
		<div id="ibm-content-head">


		</div> 
    	<!-- stop content head -->


	<div id="ibm-content-main">
		
	</div>

</div>
			