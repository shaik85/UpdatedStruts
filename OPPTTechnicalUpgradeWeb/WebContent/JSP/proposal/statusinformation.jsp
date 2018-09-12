
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/oppt-tags.tld" prefix="oppt" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.StatusViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	StatusViewBean view = (StatusViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Status information</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table border="0" width="600" summary="Proposal maintenance">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td><p>Press Details button to view error history of the proposal.</p></td>
				</tr>
				<tr>
					<td>
						<html:form action="protect/ErrorHistory.wss" method="post">
							<input type="hidden" name="selectedIds" value="<%=view.getProposalId() %>" />
							Status code: <%= view.getStatusCode() %><br /><%= view.getMessage() %><br />
							&nbsp;<br />
							
							<oppt:button id="details" name="multipleButtonManager.details" alt="Details" value="Details" />
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
		<div style="position:absolute; top:0;right:10px;">
 <p class="ibm-ind-link"><a href="javascript:getFormHelp()" title="Page help"  class="ibm-popup-link" >Page Help</a></p>
		</div>	
	</div>

</div>

