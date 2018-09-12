
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.QuotesListViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	QuotesListViewBean view = (QuotesListViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
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
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />

						<%
							if(view.quotesAvailable()){
						%>
						<p>Use this page to pull the quotes into the proposal by clicking
						Continue button. Press the Select all button to select all the quotes.
						Press the Clear all button to discard your input. Press the Cancel 
						button to go back to proposal details page.</p>
						<%
							}
						%>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/QuotesListMultipleAction.wss" method="post">
    <table align="left" border="0" cellspacing="0" cellpadding="0" summary="selectedQuoteIds">
    <tr><td><oppt:quotes quotes="<%=view.getQuotes() %>" property="selectedQuoteIds" /> </td></tr>
    <tr><td>&nbsp;</td></tr>
    <tr><td>
	<table align="left" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td><oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue"  primary="true" value="Continue" /></td>
			<td><oppt:button id="selectAll" name="multipleButtonManager.selectAll" alt="Select all"   value="Select all" /></td>
			<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all"  value="Clear all" /></td>
			<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel"  value="Cancel" /></td>
		</tr>
	</table>
	</td></tr></table>
	
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

