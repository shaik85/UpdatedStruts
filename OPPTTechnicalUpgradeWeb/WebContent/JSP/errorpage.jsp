
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/oppt-tags.tld" prefix="oppt" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ErrorViewBean view = (ErrorViewBean)opptSession.getCurrentMessageViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				
					<h1><br>BH-OPPT</h1>

<p ><em><br>Error</em></p>		
		</div>
	</div>

<div id="ibm-content-body">


<table border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td>
						<html:form action="/protect/ErrorAction.wss" method="post">
							<input type="hidden" name="initiator" value="<%=view.getInitiator()%>" />
							<input type="hidden" name="forwardInitiator" value="<%=view.isForwardInitiator()%>" />
							<oppt:displayErrorReport errorPage="true" errorReport="<%=errorReport%>" />
							<table cellpadding="0" cellspacing="0" border="0" role="presentation">
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td align="right" width="600"><oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue" value="Continue" primary="true" /></td>
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