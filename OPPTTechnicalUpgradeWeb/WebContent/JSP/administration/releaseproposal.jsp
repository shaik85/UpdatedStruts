
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ReleaseProposalViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	ErrorReport errorReport = null;
	ArrayList buttonFlags = null;
	OPPTSession opptSession = new OPPTSession(session);
	ReleaseProposalViewBean viewBean = (ReleaseProposalViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		buttonFlags=viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				User maintenance</h1>

<p ><em><br>Release proposal</em></p>		
		</div>
	</div>	

<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Enter proposal name and click on Continue to release the proposal.Press the Cancel 
						button to go back to user maintenance page.</p>
						
						<p>Required fields are marked with an asterisk (<strong>*</strong>)
							and must be filled in to complete the form. </p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="ReleaseProposal" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/ReleaseProposalMultipleAction.wss">
				<table role="presentation" border="0" cellspacing="1" cellpadding="1" width="600">
					<tr>
						<td width="12" height="30"></td>
						<td width="132"><label for="proposalName" ><span class="ibm-required">*</span> Proposal name: </label></td>
						<td width="447">&nbsp;&nbsp;
							<oppt:text name="proposalName" styleId="proposalName" styleClass="iform" size="20" maxlength="38" value=""/>
						</td>
					</tr>
				</table>
				&nbsp;<br />
				<table role="presentation" border="0" cellspacing="1" cellpadding="1" align="right">
					<tr>
						<td><oppt:button id="continue" name="multipleButtonManager.continue" primary="true" 
							alt="Continue" value="Continue" buttonFlags="<%=buttonFlags %>" /></td>
						<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" value="Cancel" primary="true" buttonFlags="<%=buttonFlags %>" /></td>
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


