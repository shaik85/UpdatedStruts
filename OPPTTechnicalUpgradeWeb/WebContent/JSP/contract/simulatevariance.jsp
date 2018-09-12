
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SimulateVarianceViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	ArrayList yearList = null;
	ArrayList buttonFlags = null;
	ErrorReport errorReport = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	SimulateVarianceViewBean viewBean = (SimulateVarianceViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		yearList = viewBean.getYearList();
		
		buttonFlags=viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Simulate variance</em></p>		
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
						
						<p>Use this form to check an ESSO contract for a potential CAP variance for
						 a specific date. When you are finished, click Simulate. Press the Clear all
						 button to discard your input. Press the Cancel button to go back to contract
						  maintenance page.</p>
						
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
<table summary="SimulateVariance" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/SimulateVarianceMultipleAction.wss">
			<table role="presentation" cellspacing="0" cellpadding="0" width="443" border="0">
				<tr>
					<td width="12">&nbsp;</td>
					<td width="200" height="25">Proposal name:</td>
					<td width="231"><oppt:label label="<%=viewBean.getProposalName()%>"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">Proposal type:</td>
					<td><oppt:label label="<%=viewBean.getProposalType()%>"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">Contract type:</td>
					<td><oppt:label label="<%=viewBean.getContractType()%>"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">Contract number:</td>
					<td><oppt:label label="<%=viewBean.getContractNumber()%>"/></td>
				</tr>
			
				<tr>
					<td>&nbsp;</td>
					<td height="25">External contract number:</td>
					<td><oppt:label label="<%=viewBean.getExternalContractNumber()%>"/></td>
				</tr>
			
				<tr>
					<td>&nbsp;</td>
					<td height="25">Contract period start date:</td>
					<td><oppt:date date="<%=viewBean.getContractPeriodStartDate()%>"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">Contract period end date:</td>
					<td><oppt:date date="<%=viewBean.getContractPeriodEndDate()%>"/></td>
				</tr>
				<tr>
					<td></td>
					<td height="30"><label ><span class="ibm-required">*</span><oppt:label label= "Variance date:" id= "varianceDateLbl" /></label></td>
					<td height="30"><oppt:dateOptions  name="varianceDate" years="<%=yearList%>" date="<%=viewBean.getVarianceDate()%>" alt= " Variance date" mandatory="true"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="30"><label for="includequote">Include Quotes:</label></td>
				<%
					if(viewBean.isIncludeQuotes())
					{
				%>
						<td><input type="checkbox" checked="checked" name="includeQuotes" id="includequote" value="true" /></td>
				<%
					}
					else
					{
				%>
						<td><input type="checkbox" name="includeQuotes" id="includequote" value="true"/></td>
				<%
					}
				%>
				</tr>
			</table>
			&nbsp;<br />
			<table role="presentation" align="right" cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td><oppt:button id="simulateVariance" name="multipleButtonManager.simulate" alt="Simulate" primary="true" value="Simulate" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all"  value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel"  value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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


