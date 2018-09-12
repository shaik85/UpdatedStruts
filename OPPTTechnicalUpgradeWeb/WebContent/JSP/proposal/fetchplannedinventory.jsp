<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.InventoryDateRangeViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	InventoryDateRangeViewBean view = (InventoryDateRangeViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	ArrayList startYearsList = view.getStartYears();
	ArrayList endYearsList = view.getEndYears();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Planned inventory</em></p>		
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

						<p>Use this page to retrieve quotes for a specific date range or press
						the Continue button to display all the quotes in the customer set.
						Press the Clear all button to discard your input. Press the Cancel 
						button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/FetchPlannedInventoryMultiplAction.wss">
	<table align="center" width="600" cellspacing="0" cellpadding="0" border="0" summary="enter date range to retrieve quotation">
		<tr>
			<td colspan="2">Enter date range to retrieve quotation</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">Range : 2003-09-01 to 2004-08-31</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td height="30" width="75"><label for="fromDateYear"><oppt:label label="From date:" id="fromDate" /></label></td>
			<td height="30" width="525"><oppt:dateOptions name="fromDateYear" alt="From date" years="<%=startYearsList %>" /></td>
		</tr>
		<tr>
			<td height="30"><label for="toDateYear"><oppt:label label="To date:" id="toDate" /></label></td>
			<td height="30"><oppt:dateOptions name="toDateYear" alt="To date" years="<%=endYearsList %>" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="0" role="presentation"  align="right">
		<tr>
			<td><oppt:button value="Continue" primary="true" name="multipleButtonManager.continue" alt="Continue" id="continue" /></td>
			<td><oppt:button value="Clear all" primary="true" name="multipleButtonManager.clearall" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button value="Cancel" primary="true" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
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

