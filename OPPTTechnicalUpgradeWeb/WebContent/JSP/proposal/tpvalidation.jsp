
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.TPValidationReportViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	OPPTSession opptSession = new OPPTSession(session);
	TPValidationReportViewBean view = (TPValidationReportViewBean)opptSession.getCurrentViewBean();

	if(null == view){
		return;
	}

	ErrorReport errorReport = view.getErrorReport();
	
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Proposal details - TP Validation</em></p>		
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
						
						<p>This page shows under which contract number and contract type the
						SWO is covered.</p>
						<p>1. Some licenses in the TP proposal are covered by a non-TP
						contract; some licenses are not covered by a non-TP contract.<br />
						2. Some licenses in the TP proposal are covered by a non-TP contract;
						some licenses are covered by another non-TP contract<br />
						3. All licenses in the TP proposal are covered by TP contract</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CancelAction.wss">
	<table align="center" width="600" cellpadding="1" cellspacing="1" summary="Swo Info">
		<tr>
			<th height="18" width="147" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;SWO no</th>
			<th width="147" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;SWO Sl no</th>
			<th width="147" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;SWO contract no</th>
			<th width="147" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;SWO contract type</th>
		</tr>
		<oppt:swotp swos="<%=view.getSwoTPs() %>" />
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" role="presentation" align="right">
		<tr>
			<td><oppt:button id="continue" name="multipleButtonManager.continue"  alt="Continue" value="Continue" primary="true" /></td>
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


