
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractExtensionViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	ArrayList yearList = null;
	ErrorReport errorReport = null;
	Date extensionDate=null;
	ArrayList buttonFlags = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	ContractExtensionViewBean viewBean = (ContractExtensionViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		buttonFlags=viewBean.getButtonFlags();
		yearList = viewBean.getYearList();
		extensionDate = viewBean.getContractExtensionDate();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Contract extension</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
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
						
						<p>Use this form to extend a contract. You can modify the system provided 
						contract extension date as long as it is not more than 3 month past the Contract
						period end date. Click the Register button, to send extension request to the approver. 
						Press the Clear all button to discard your input. Press the Cancel button to go back
						to contract maintenance page.</p>
						
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
<table summary="ExtendContract" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/ExtendContractMultipleAction.wss">
			<table summary="ExtendContrac" cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td width="12" height="25" align="center">&nbsp;</td>
					<td width="220">Proposal name:</td>
					<td width="211"><oppt:label label="<%=viewBean.getProposalName()%>" /></td>
				</tr>
				<tr>
					<td align="center">&nbsp;</td>
					<td height="25">Proposal type:</td>
					<td><input type="hidden" name="proposalType" value="<%=viewBean.getProposalType() %>" /><oppt:label label="<%=viewBean.getProposalType()%>" /></td>
				</tr>
				<tr>
					<td align="center">&nbsp;</td>
					<td height="25">Contract type:</td>
					<td><oppt:label label="<%=viewBean.getContractType()%>" /></td>
				</tr>
				<tr>
					<td align="center">&nbsp;</td>
					<td height="25">Contract number:</td>
					<td><oppt:label label="<%=viewBean.getContractNumber()%>" /></td>
				</tr>
				<tr>
					<td align="center">&nbsp;</td>
					<td height="25">External contract number:</td>
					<td><oppt:label label="<%=viewBean.getExternalContractNumber()%>" /></td>
				</tr>
				<tr>
					<td align="center">&nbsp;</td>
					<td height="25">Contract period start date:</td>
					<td><oppt:date date="<%=viewBean.getContractPeriodStartDate()%>" /></td>
				</tr>
				<tr>
					<td align="center">&nbsp;</td>
					<td height="25">Contract period end date:</td>
					<td><oppt:date date="<%=viewBean.getContractPeriodEndDate()%>" /></td>
				</tr>
				<tr>
					<td align="center"></td>
					<td><label ><span class="ibm-required">*</span>Contract extension date</label></td>
					<td height="30"><oppt:dateOptions name="contractExtensionDate" years="<%=yearList%>" date="<%=extensionDate%>" onclick="populateDate" alt= "Contract extension date" mandatory="true"/></td>
				</tr>
			</table>
			&nbsp;<br />
			<table role="presentation" align="right" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><oppt:button id="register" name="multipleButtonManager.register" alt="Register" primary="true" value="Register" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" primary="true" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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




<script language="JavaScript" type="text/javascript">
	
	

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



	
	
	
	function populateDate(month, day, year, currentElement, dateType){
		var proposalType = parent.document.ContractExtensionActionForm.proposalType.value;;
		if((proposalType !="TP")){
		//	lastDay(month, day, year);
		}
	}

	/**
	 * This code is for the contract End dates always be the last day of month
	 */
	function lastDay(month, day, year)
	{
		var yearValue = year.value;
		var monthValue = month.value;
		
		if(monthValue == '04' || monthValue == '06' || monthValue == '09' || monthValue == '11')
		{
			day.options.selectedIndex = 30;
		}
		if(monthValue == '01' || monthValue == '03' || monthValue == '05' || monthValue == '07' || monthValue == '08' || monthValue == '10' || monthValue == '12')
		{
			day.options.selectedIndex = 31;
		}	  	
		if(yearValue%4 == 0 || (yearValue%100 == 0 && yearValue%400 == 0))
		{
			if(monthValue =='02')
			{
				day.options.selectedIndex = 29;
				return false;
			}
		}	
		if(yearValue%4 != 0 || (yearValue%100 != 0 && yearValue%400 != 0))
		{
			if(monthValue == '02')
			{
				day.options.selectedIndex = 28;
				return false;
			}
		}	
	}
</script>
