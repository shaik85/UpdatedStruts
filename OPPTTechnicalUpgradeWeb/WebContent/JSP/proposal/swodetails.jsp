
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SWODetailsViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	SWODetailsViewBean view = (SWODetailsViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	boolean isSandS = view.isSAndS();
	ErrorReport errorReport = errorReport = view.getErrorReport();;
	HashSet errorValues = errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = buttonFlags = view.getButtonFlags();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>SWO details</em></p>		
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
						<p>Use this page to alter the EE prices. When you are finished, click the Save button. 
						Press the Cancel button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="protect/SWODetailsMultipleAction.wss">
	<table cellpadding="1" cellspacing="1" width="600" summary="Sold to Party">
		<%
			 CustomerInfoDataBean customerInfo = view.getSoldToParty();
		%>
		<tr align="left">
			<td colspan="2" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">Sold-to-party: <oppt:label labelStyle="bar-blue-med-dark" label="<%=customerInfo.getLegacyCustomerNumberWithAS() %>" /></td>
			<td colspan="2" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">SAP sold-to-party:	<oppt:label  labelStyle="bar-blue-med-dark" label="<%=customerInfo.getCustomerNumber()%>" /></td>
		</tr>
		<%
			customerInfo = view.getBillToParty();
		%>
		<tr>
			<td width="150">Bill-to-party:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="144"><oppt:label label="<%=customerInfo.getLegacyCustomerNumberWithAS() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="150">Plan start date:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="144" align="right"><oppt:date date="<%=view.getCustomerPlanStartDate() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<%
			customerInfo = view.getPayer();
		%>
		<tr>
			<td>Payer:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=customerInfo.getLegacyCustomerNumberWithAS() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td>Plan end date:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="right"><oppt:date date="<%=view.getCustomerPlanEndDate() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="1" cellspacing="1" width="600" summary="Designated machine">
		<tr>
			<td colspan="2" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">Designatedmachine: <oppt:label labelStyle="bar-blue-med-dark" label="<%=view.getDMNumber() %>" /></td>
			<td colspan="2" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">Description: <oppt:label labelStyle="bar-blue-med-dark" label="<%=view.getDMDescription() %>" /></td>
		</tr>
		<tr>
			<td width="150">Plan start date:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="144">&nbsp;&nbsp;<oppt:date date="<%=view.getDMPlanStartDate() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="150">Plan end date:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="right" width="144"><oppt:date date="<%=view.getDMPlanEndDate() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="1" cellspacing="1" width="600" summary="SWO Description">
		<tr>
			<td colspan="2" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">SWO: <oppt:label labelStyle="bar-blue-med-dark" label="<%=view.getSwoNumber() %>" /></td>
			<td colspan="2" height="18" style="background-color:#999999;" class="bar-blue-med-dark">Description: <oppt:label labelStyle="bar-blue-med-dark" label="<%=view.getDescription() %>" /></td>
		</tr>
		<tr>
			<td width="150">Reference S/N:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="144"><oppt:label label="<%=view.getSwoReferenceSN() %>" defaultLabel="-" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		<%
			if(isSandS)
			{
				
		%>
			<td width="150">ESW S&amp;S price:<br />
		<%
			}
			else
			{
		%>
			<td width="150">ESW price:<br />
		<%
			}
		%>
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="right" width="144"><oppt:double lableStyle="orange-med" doubleValue="<%=view.getEswPrice() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td>Reference D/N:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=view.getSwoReferenceDN() %>" defaultLabel="-" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		<%
			if(isSandS)
			{
		%>
			<td width="150">Alternate S&amp;S price: <br />
		<%
			}
			else
			{
		%>
			<td width="150">Alternate price:<br />
		<%
			}
		%>
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="right"><oppt:double lableStyle="orange-med" doubleValue="<%=view.getAlternatePrice() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td>Plan start date:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:date date="<%=view.getPlanStartDate() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		<%
			if(isSandS)
			{
		%>
			<td width="150">Calculated S&amp;S price:<br />
		<%
			}
			else
			{
		%>
			<td width="150">Calculated price:<br />
		<%
			}
		%>
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="right"><oppt:double lableStyle="orange-med" doubleValue="<%=view.getCalculatedPrice() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td>Plan end date:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:date date="<%=view.getPlanEndDate() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td>Contract status:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="right"><oppt:label label="<%=view.getSwoContractStatus()%>" defaultLabel="-" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td>Contract number:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=view.getSwoContractNumber()%>" defaultLabel="-" /> <br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td>Contract type:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="right"><oppt:label label="<%=view.getSwoContractType()%>" defaultLabel="-" /> <br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	<oppt:ees ees="<%=view.getEEs()%>" sands="<%=view.isSAndS()%>" property="alternatePrices" discount="discount"/>
	<table align="right" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td><oppt:button value="Continue" primary="true" name="multipleButtonManager.cancel" alt="Continue" id="continue" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button id="save" primary="true" name="multipleButtonManager.save" alt="Save" value="Save" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button id="clearAll" primary="true" name="multipleButtonManager.clearAll" alt="Clear all" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button id="cancel" primary="true" name="multipleButtonManager.cancel" alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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

