<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalSharingViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ProposalSharingViewBean view = (ProposalSharingViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}

	ErrorReport errorReport = view.getErrorReport();
	ArrayList buttonFlags = view.getButtonFlags();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Remove proposal sharing</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<%
							if(null == view.getMessage()){
						%>
						<p>Use this form to remove share on a proposal. Use the checkbox to select
						the user id, for whom you wish to remove share on the proposal. When you are 
						finished, click the Save button. Press the Clear all button to discard your input. 
						Press the Cancel button to go back to proposal maintenance page.</p>
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

&nbsp;<br />
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="/protect/RemoveProposalSharingMultipleAction.wss" method="post">
				<table align="left" border="0" width="600" cellspacing="1" cellpadding="1" role="presentation">
					<oppt:removeshare message="<%=view.getMessage() %>" users="<%=view.getUsers() %>" id="users" /> 
					<tr>
						<td colspan="2">
							&nbsp;<br />
							<table role="presentation" align="right" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><oppt:button id="save" name="multipleButtonManager.save" primary="true" alt="Save" value="Save" buttonFlags="<%=buttonFlags %>" /></td>
									<td><oppt:button id="cancel" name="multipleButtonManager.cancel" primary="true" alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</html:form>
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
		<div style="position:absolute; top:0;right:10px;">
 <p class="ibm-ind-link"><a href="javascript:getFormHelp()" title="Page help"  class="ibm-popup-link" >Page Help</a></p>
		</div>	
	</div>

</div>

