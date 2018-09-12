<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.InventoryDateRangeViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	OPPTSession opptSession = new OPPTSession(session);
	InventoryDateRangeViewBean view = (InventoryDateRangeViewBean)opptSession.getCurrentViewBean();

	if(null == view){
		return;
	}

	ArrayList startYears = view.getStartYears();
	ArrayList endYears = view.getEndYears();
	ErrorReport errorReport = view.getErrorReport();
	
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

<html:form action="/protect/FetchPlannedInventoryMultipleAction.wss">
	<table width="600" role="presentation">
		<tr>
			<td colspan="2">Enter date range to retrieve quotation:</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
		<td height="30" width="75"> Range: </td>
		<td width="525"> <oppt:date date="<%=view.getDefaultStartDate()%>" /> to <oppt:date date="<%=view.getDefaultEndDate() %>" /> </td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td height="30" width="75"><label >From date:</label></td>
			<td width="525"><oppt:dateOptions name="strFromYear" years="<%=startYears %>" alt= "From date" /></td>
		</tr>
		<tr>
			<td height="30"><label >To date:</label></td>
			<td> <oppt:dateOptions name="toDateYear" years="<%=endYears %>" alt= "To date" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="0" role="presentation" align="left">
	<tr>
		
		<td><span class="ibm-btn-arrow-pri"><input type="submit" id="continue" name="multipleButtonManager.continue" value="Continue"  class="ibm-btn-arrow-pri" primary="true"  alt="Continue" style="width:7em;"/></span> &nbsp;</td>
		<td><span class="ibm-btn-arrow-sec"><input type="submit" id="clearAll" name="multipleButtonManager.clearAll" value="Clear all"  class="ibm-btn-arrow-sec"  alt="Clear all" style="width:7em;"/></span> &nbsp;</td>	 								 
		<td><span class="ibm-btn-arrow-sec"><input type="submit" id="cancel" name="multipleButtonManager.cancel" value="Cancel"   class="ibm-btn-arrow-sec" alt="Cancel" style="width:7em;"/></span></td>	 								 
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

