
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorHistoryViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	ErrorHistoryViewBean view = (ErrorHistoryViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	ArrayList buttonFlags = view.getButtonFlags();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<%
						if(view.isContract()){
					%>
					<h1><br>Contract maintenance</h1>
					<%
						}
						else{
					%>
					<h1><br>Proposal maintenance</h1>
					<%
						}
					%>

<p ><em><br>Error history</em></p>		
		</div>
	</div>

<div id="ibm-content-body">


<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td class="bar-gray-dark">Proposal name : <%=view.getProposalName() %></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<%
							if(view.isErrorHistoryAvailable()){
						%>
						<p>Use the tick box to select a message you wish to delete and press
						the Delete button or press the Continue button to exit this page</p>
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

<html:form action="protect/ErrorHistoryMultipleAction.wss" method="post">
	<oppt:errorHistory property="selectedIds" url="ErrorDetails.wss" editable="<%=view.isEditable() %>" errorHistory="<%=view.getErrorInfos()%>" />
	&nbsp;<br />
	<table align="right" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td><oppt:button value="Continue" primary="true" name="multipleButtonManager.continue" alt="Continue" id="continue" /></td>
			<td><oppt:button id="delete" name="multipleButtonManager.delete" alt="Delete" value="Delete" buttonFlags="<%=buttonFlags %>" /></td>
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
