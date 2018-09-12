
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/oppt-tags.tld" prefix="oppt" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	MessageViewBean view = (MessageViewBean)opptSession.getCurrentMessageViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				
					<h1><br>BH-OPPT</h1>

<p ><em><br>Message</em></p>		
		</div>
	</div>

<div id="ibm-content-body">
<table role="presentation" border="0" width="600" >
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
					<td>
						<html:form action="protect/MessageMultipleAction.wss" method="post">
							<input type="hidden" name="initiator" value="<%=view.getInitiator()%>" />
							<input type="hidden" name="forwardInitiator" value="<%=view.isForwardInitiator()%>" />
							<oppt:displayErrorReport messagePage="true" errorReport="<%=errorReport%>" />
							&nbsp;<br />
						<table>
						<tr>
							<td width="600" align="right">
						<%
							if(view.isRedirectTohomePage())
							{
						%>
							<oppt:button id="continue" name="multipleButtonManager.cancelRegister" alt="Continue" primary="true" value="Continue" />
						<%
							}
							else
							{
						%>
							<oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue" primary="true" value="Continue" />
						<%
							}
						%>
						   </td>
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

<!-- start content head -->
		<div id="ibm-content-head">


		</div> 
    	<!-- stop content head -->


	<div id="ibm-content-main">
		
	</div>

</div>
			