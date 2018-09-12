
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerDetailsViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	CustomerDetailsViewBean view = (CustomerDetailsViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = errorReport = view.getErrorReport();;
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Customer details</em></p>		
		</div>
	</div>

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="layout">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Press the Continue button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CancelAction.wss">
	<table border="0" width="600" cellspacing="1" cellpadding="1" summary="Partner Details">
		<tr>
			<th colspan="4" style=background-color:#cccccc; class="bar-blue-med">Partner details</th>
		</tr>
		<tr valign="bottom">
			<td width="130" height="20">Sold-to-party no: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="130"><oppt:label label="<%=view.getSoldToPartyNumber() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="150">Sold-to-party name: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td width="190"><oppt:label label="<%=view.getSoldToPartyName() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<%-- CR0531074816 - CBS OPPT accessibility issues --%>
		<%--  <tr valign="bottom"> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>
		<tr valign="bottom">
			<td height="20">Bill-to-party no: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=view.getBillToPartyNumber() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td>Bill-to-party name: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=view.getBillToPartyName() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
        <%--  <tr valign="bottom"> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>
		<tr valign="bottom">
			<td height="20">Payer no: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=view.getPayerNumber() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td>Payer name: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=view.getPayerName() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
        <%--  <tr valign="bottom"> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>
		<tr valign="bottom">
			<td height="20">Ship-to-party no: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=view.getShipToPartyNumber() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td>Ship-to-party name: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:label label="<%=view.getShipToPartyName() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
        <%--  <tr valign="bottom"> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>
		<tr valign="bottom">
			<td height="20">Plan start date: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:date date="<%=view.getPlanStartDate() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td>Plan end date: <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
			<td><oppt:date date="<%=view.getPlanEndDate() %>" /> <br /><div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
        <%--  <tr valign="bottom"> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>
	</table>
	&nbsp;<br />
	<table width="600" align="right" cellspacing="0" cellpadding="0" summary="layout">
		<tr>
			<td align="right"><oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue" primary="true" value="Continue" /></td>
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
