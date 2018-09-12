
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.AlternatePartnerViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AlternatePartnerActionForm" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	AlternatePartnerViewBean view = (AlternatePartnerViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	AlternatePartnerActionForm actionForm = view.getAlternatePartnerActionForm();
%>



<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal creation</h1>

<p ><em><br>Partner function</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" summary="layout">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to enter an alternate sold-to party. When you are finished, click the Continue button. 
						Press the Cancel button to go back to partner selection page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/AlternatePartnerMultipleAction.wss">
	<input type="hidden" name="partnerType" value="<%=view.getPartnerTypeString() %>" />
	<table border="0" cellspacing="1" cellpadding="1" width="600" summary="Enter alternate partner">
		<tr>
			<td colspan="3" align="left">Enter alternate partner<br />
			&nbsp;<br />
			</td>
		</tr>
		<tr>
			<th width="147" align="left">&nbsp;&nbsp;Partners</th>
			<!-- DADO02 BlueHarmony wave1 Sateesh Anne -->
			<%-- <th width="117" align="left">&nbsp;&nbsp;<label for="legacyNumber">Legacy no.</label></th>
			<th width="197" align="left">&nbsp;&nbsp;<label for="sequenceNumber">Seq. no.</label></th>
			<th width="127" align="left">&nbsp;&nbsp;<label for="systemCode">System code</lable></th>
			--%>
			<th width="175" align="left">&nbsp;&nbsp;<label for="systemCode">SiteID</lable></th>
			<!-- DADO02 BlueHarmony wave1 Sateesh Anne -->
		</tr>
		<tr>
			<td valign="bottom">&nbsp;&nbsp;<oppt:label label="<%=view.getPartnerName() %>" /></td>
			<!-- DADO02 BlueHarmony wave1 Sateesh Anne -->
			<%-- <td valign="bottom">&nbsp;&nbsp;<oppt:text name="legacyNumber" styleId="strSoldToParty" size="12" maxlength="10" styleClass="iform" value="<%=actionForm.getLegacyNumber() %>" /></td>
			<td valign="bottom">&nbsp;&nbsp;<oppt:text name="sequenceNumber" styleId="strSeqNo" size="15" maxlength="15" styleClass="iform" value="<%=actionForm.getSequenceNumber() %>" /></td>
			<td valign="bottom">&nbsp;&nbsp;<oppt:text name="countryCode" styleId="systemCode" size="15" maxlength="4" styleClass="iform" value="<%=actionForm.getCountryCode() %>" /></td>
			--%>
			<td valign="bottom">&nbsp;&nbsp;<oppt:text name="sapCustomerNumber" styleId="strSeqNo" size="25" maxlength="15" styleClass="iform" value="<%=actionForm.getSapCustomerNumber() %>" /></td>
		<!-- DADO02 BlueHarmony wave1 Sateesh Anne -->
		</tr>
	</table>
	&nbsp;<br />
	<table border="0" align="right" cellspacing="1" cellpadding="1" role="presentation">
		<tr>
			<td><oppt:button value="Continue" primary="true" name="multipleButtonManager.continue" alt="Continue" id="continue" /></td>
			<td><oppt:button value="Clear all" primary="true" name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button value="Cancel" primary="true" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
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

