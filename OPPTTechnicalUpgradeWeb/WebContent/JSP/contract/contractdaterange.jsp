
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractMaintenanceDateRangeViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>


<%
	ArrayList yearList = null;
	ErrorReport errorReport = null;
	OPPTSession opptSession = new OPPTSession(session);
	ContractMaintenanceDateRangeViewBean viewBean = (ContractMaintenanceDateRangeViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		yearList = viewBean.getYearRange();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

	
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
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to retrieve contracts for a specific  date range 
						or press the Continue button to display all the contracts. 
						Use the Archive button to see the Closed Contracts which are older than 6 months.
						Press the Clear all button to discard your input.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="ContractDateRange" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/ContractDateRangeMultipleAction.wss">
				<table role="presentation" align="center" border="0" width="600" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left" width="100" height="30"><label ><oppt:label label="From date:" id="fromDateLbl"  /></label></td>
						<td width="500"><oppt:dateOptions name="fromDate" years="<%=yearList%>" alt="From date" /></td>
					</tr>
					<tr>
						<td align="left" width="100" height="30">
						<label ><oppt:label label="To date:" id="toDateLbl"  /></label></td>
						<td width="500"><oppt:dateOptions name="toDate" years="<%=yearList%>" alt= "To date" /></td>
					</tr>
				</table>
				&nbsp;<br />
				<table role="presentation" align="right" cellspacing="0" cellpadding="0">
					<tr>
						<td><oppt:button id="continue" name="multipleButtonManager.continue" primary="true" alt="Continue"
							 value="Continue"  /></td>						
						<td><oppt:button id="archive" name="multipleButtonManager.archive"  alt="Archive"
							 value="Archive"  /></td>						
						<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll"  alt="Clear all" value="Clear all"  /></td>

					</tr>
				</table>
				&nbsp;<br />
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
