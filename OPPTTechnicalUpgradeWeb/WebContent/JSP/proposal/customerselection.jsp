<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerSelectionViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	CustomerSelectionViewBean view = (CustomerSelectionViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();;
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal creation</h1>

<p ><em><br>Customer selection</em></p>		
		</div>
	</div>

<div id="ibm-content-body">




<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use the radio button to select one sold to party (STP) to retrieve
						partner function for the proposal or select the Fetch Add Site Id if you want to use a sold to party that is not part of the
						Site Id. Use the tick box (INV) to retrieve the inventory for
						additional customers. When you are finished, click the Continue button.
						Press the Clear all button to discard your input. Press the Cancel button 
						to go back to proposal maintenance page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CustomerSelectionMultipleAction.wss">
	<oppt:customerListCustomer customerLists="<%=view.getSelectedCustomerLists() %>" />
	<table cellpadding="1" cellspacing="1" border="0" width="700" summary="Comments">
		<tr>
			<%-- <td width="650" height="18" align="left" class="bar-blue-med-dark">&nbsp;&nbsp;Alternate legacy sold to party number</td> --%>
		</tr>
	</table>
	<%--DADO02
	<oppt:alternatecustomers alternateCustomers="<%=view.getAlternateCustomers() %>" />
	
	<table cellpadding="1" cellspacing="1" border="0" width="700" summary="Alternate legacy sold to party number">
		<tr>
			<th width="32" height="18" align="left"  class="bar-blue-med">&nbsp;&nbsp;<label for="alternateSTP">STP</label></th>
			<th width="32" height="18" align="left"  class="bar-blue-med">&nbsp;&nbsp;<label for="alternateINV">INV</label></th>
			<th width="140" height="18" align="left" class="bar-blue-med">&nbsp;&nbsp;<label for="alternateLegacyCustomerNumber">Legacy cust. no.</label></th>
			<th width="130" height="18" align="left" class="bar-blue-med">&nbsp;&nbsp;<label for="alternateSequenceNumber">Sequence no.</label></th>
			<th width="360" height="18" align="left" class="bar-blue-med">&nbsp;&nbsp;<label for="alternateSystemCode">System code</label></th>
		</tr>
		<tr>
			<td align="center" valign="bottom">&nbsp;<oppt:radio property="selectedSTP" styleId="alternateSTP" value="alternateCustomer" checked="<%=view.isAlternatePartnerSTP() %>" onclick="selectINV(document.CustomerSelectionActionForm.alternateINV)" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="center" valign="bottom">&nbsp;<oppt:checkbox name="alternatePartnerINV" styleId="alternateINV" value="alternateCustomer" checked="<%=view.isAlternatePartnerINV() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="left" valign="bottom">&nbsp;&nbsp;<oppt:text name="legacyCustomerNumber" styleId="alternateLegacyCustomerNumber" size="7" maxlength="7" styleClass="iform" value="<%=view.getLegacyCustomerNumber() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="left" valign="bottom">&nbsp;&nbsp;<oppt:text name="sequenceNumber" styleId="alternateSequenceNumber" size="10" maxlength="15" styleClass="iform" value="<%=view.getSequenceNumber() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="left" valign="bottom">&nbsp;&nbsp;<oppt:text name="countryCode" styleId="alternateSystemCode" size="10" maxlength="3" styleClass="iform" value="<%=view.getCountryCode() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td align="center" valign="bottom">&nbsp;<oppt:radio property="selectedSTP" styleId="alternateSTP" value="alternateCustomer" checked="<%=view.isAlternatePartnerSTP() %>" onclick="selectINV(document.CustomerSelectionActionForm.alternateINV)" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="center" valign="bottom">&nbsp;<oppt:checkbox name="alternatePartnerINV" styleId="alternateINV" value="alternateCustomer" checked="<%=view.isAlternatePartnerINV() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="left" valign="bottom">&nbsp;&nbsp;<oppt:text name="legacyCustomerNumber" styleId="alternateLegacyCustomerNumber" size="7" maxlength="7" styleClass="iform" value="<%=view.getLegacyCustomerNumber() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="left" valign="bottom">&nbsp;&nbsp;<oppt:text name="sequenceNumber" styleId="alternateSequenceNumber" size="10" maxlength="15" styleClass="iform" value="<%=view.getSequenceNumber() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="left" valign="bottom">&nbsp;&nbsp;<oppt:text name="countryCode" styleId="alternateSystemCode" size="10" maxlength="3" styleClass="iform" value="<%=view.getCountryCode() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		%-->				
		
		<%-- CR0531074816 - CBS OPPT accessibility issues --%>
		<%--  <tr valign="bottom"> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
        <%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%-- </tr> --%>
	<%--	
	</table>
	--%>
	&nbsp;<br />
	<table role="presentation" width="600" cellspacing="0" cellpadding="0" >
		<tr>
			<td align="left"><label for="comments">Comments:</label></td>
		</tr>
		<tr>
			<td align="left"><textarea rows="2" name="comments" id="comments" cols="44" class="iform"><%=view.getComments() %></textarea></td>
		</tr>
	</table>
	&nbsp;<br />
	<table role="presentation" align="left" cellspacing="0" cellpadding="0" >
		<tr>
		    <td><oppt:button value="Fetch Add Site Id"  name="multipleButtonManager.fetchAddSiteID" alt="fetchAddSiteID" id="fetchAddSiteID" /></td>
			<td><oppt:button value="Continue" primary="true" name="multipleButtonManager.continue" alt="Continue" id="continue" /></td>
			<td><oppt:button value="Select all"  name="multipleButtonManager.selectAll" alt="Select all" id="selectAll" /></td>
			<td><oppt:button value="Clear all"  name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button value="Cancel" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
		</tr>
		<tr>
			<td>&nbsp;<br /></td>
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


<script language="JavaScript" type="text/javascript">
	function selectINV(customerINV){
		customerINV.checked = true;
	}	
	
</script>