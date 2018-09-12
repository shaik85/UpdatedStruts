
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.RegistrationViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	RegistrationViewBean view = (RegistrationViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = view.getButtonFlags();
%>


<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Contract registration</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>To register the contract, select the pertinent Approver ID from the pull-down 
						box and click the Send for approval button. Press the Clear all button to discard 
						your input. Press the Cancel button to go back to proposal details page.</p>
						
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

<html:form action="/protect/RegistrationMultipleAction.wss">
	<input type="hidden" name="initiator" value="<%=view.getInitiator() %>" />
	<table cellspacing="0" cellpadding="0" width="600" border="0" summary="Contract registration">
		<tr>
			<td width="12" align="center">&nbsp;</td>
			<td width="200" height="20">Proposal name:</td>
			<td width="388"><oppt:label label="<%=view.getProposalName()%>" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td height="20">Proposal type:</td>
			<td><oppt:label label="<%=view.getProposalType()%>" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td height="20">Contract type:</td>
			<td><oppt:label label="<%=view.getContractType()%>" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td height="20">Contract number:</td>
			<td><oppt:label label="<%=view.getContractNumber()%>" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td height="20">External contract number:</td>
			<td><oppt:label label="<%=view.getExternalContractNumber()%>" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td height="20">Variance date:</td>
			<td><oppt:date date="<%=view.getVarianceDate() %>" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td height="20">Contract closure date:</td>
			<td><oppt:date date="<%=view.getConractClosureDate() %>" /></td>
		</tr>
		<tr>
			<td></td>
			<td height="30"><label for="approverId" ><span class="ibm-required">*</span>Approver ID:</label></td>
			<td><oppt:select name="approverId" id="approverId" reverse="true" style="iform" options="<%=view.getApproverIds()%>" title="select Approver ID"/></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td height="30"><label for="sendContractTo">Send contract to: </label></td>
			<td><oppt:text name="sendContractTo" styleId="sendContractTo" styleClass="iform" size="30" maxlength="90" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td height="30"><label for="sendReplyNotesTo">Send reply notes to: </label></td>
			<td><oppt:text name="sendReplyNotesTo" styleId="sendReplyNotesTo" size="30" maxlength="90" styleClass="iform" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table align="left" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td align="left"><oppt:button id="sendForApproval" name="multipleButtonManager.sendForApproval" alt="Send for approval" primary="true" value="Send for approval" buttonFlags="<%=buttonFlags %>" /></td>
			<td align="left"><oppt:button value="Clear all" name="multipleButtonManager.clearAll" primary="true" alt="Clear all" id="clearAll" /></td>
			<td align="left"><oppt:button value="Cancel" name="multipleButtonManager.cancel" primary="true" alt="Cancel" id="cancel" /></td>
		</tr>
	</table>
	&nbsp;<br />
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


