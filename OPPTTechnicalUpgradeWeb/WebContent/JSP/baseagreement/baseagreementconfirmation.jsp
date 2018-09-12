
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementConfirmationViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	BaseAgreementConfirmationViewBean view = (BaseAgreementConfirmationViewBean)opptSession.getCurrentMessageViewBean();
	if (null == view) {
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	
%>

<table cellpadding="0" cellspacing="0" border="0" width="450" summary="layout">
	<tr valign="top">
		<td width="450">
			<table width="450" role="presentation">
				<tr valign="top">
					<a name="main"></a> &nbsp;<br />
					<h1>BH-OPPT</h1>
				</tr>
				<tr>
					<td><p class="ibm-alternate"><em>Confirmation</em></p></td>
				</tr>
				<tr>
					<td>
						<html:form action="/protect/ConfirmationMultipleAction.wss">
							<input type="hidden" name="initiator" value="<%=view.getInitiator()%>" />
							<oppt:displayBaseAgreementConfirmation messages="<%=errorReport%>" footer="<%=view.getFooter()%>" />
							&nbsp;<br />
							<table cellpadding="0" cellspacing="0" border="0" summary="button" align="right">
								<tr>
<!--								<td align="left"> <oppt:button id="yes" name="multipleButtonManager.yes" alt="Yes" value="Yes" primary="true" /></td>
									<td align="left"> <oppt:button id="no" name="multipleButtonManager.no" alt="No" value="No" primary="true" /></td> -->
									<td align="left"> <span class="button-blue"><input type="submit" id="yes" name="multipleButtonManager.yes" value="Yes"  primary="true"  alt="Yes" style="width:7em;"/></span> </td> 								 	 
									<td align="left"> &nbsp; <span class="button-blue"><input type="submit" id="no" name="multipleButtonManager.no" value="No"  primary="true"  alt="No" style="width:7em;"/></span> </td> 								 	 
									
								</tr>
							</table>
						</html:form>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>