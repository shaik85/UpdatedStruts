
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfirmationViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	ConfirmationViewBean view = (ConfirmationViewBean)opptSession.getCurrentMessageViewBean();
	if (null == view) {
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<a name="main"></a> &nbsp;<br />
					<h1>BH-OPPT</h1>

<p ><em><br>Confirmation</em></p>		
		</div>
	</div>

<div id="ibm-content-body">



<table cellpadding="0" cellspacing="0" border="0" width="450" role="presentation">
	<tr valign="top">
		<td width="450">
			<table width="450" role="presentation">
				
				<tr>
					<td>
						<html:form action="/protect/ConfirmationMultipleAction.wss">
							<input type="hidden" name="initiator" value="<%=view.getInitiator()%>" />
							<oppt:displayConfirmation messages="<%=errorReport%>" />
							&nbsp;<br />
							<table cellpadding="0" cellspacing="0" border="0" role="presentation" align="right">
								<tr>
<!--								<td align="left"> <oppt:button id="yes" name="multipleButtonManager.yes" alt="Yes" value="Yes" primary="true" /></td>
									<td align="left"> <oppt:button id="no" name="multipleButtonManager.no" alt="No" value="No" primary="true" /></td> -->
									<td align="left"> <span class="button-blue"><input  class="ibm-btn-arrow-sec" type="submit" id="yes" name="multipleButtonManager.yes" value="Yes"    alt="Yes" style="width:7em;"/></span> </td> 								 	 
									<td align="left"> &nbsp; <span class="button-blue"><input class="ibm-btn-arrow-sec" type="submit" id="no" name="multipleButtonManager.no" value="No"    alt="No" style="width:7em;"/></span> </td> 								 	 
									
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
