
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.commons.ProposalHistoryDataBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHistoryViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ProposalHistoryViewBean view = (ProposalHistoryViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">
<%
						if(view.isContract()){
					%>
				<h1><br>Contract maintenance</h1>
				<%
						}
						else if(view.isProposalForApproval()){
					%>
				<h1><br>Proposals for approval</h1>
				<%
						}
						else{
					%>
				<h1><br>Proposal maintenance</h1>
				<%
						}
					%>

<p ><em><br>Proposal history</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="800"
	summary="isContract or proposal">
	<tr valign="top">
		<td width="800">
		<table role="presentation">
			
			<tr>
				<td width="650">
				<b><p class="ibm-confidential">IBM Confidential</p></b>
				</td>
			</tr>
			<tr>
				<td width="650"><oppt:displayErrorReport errorReport="<%=errorReport%>" />

				<p>This page shows what user id has accessed the proposal on
				what date. Press continue to go back to Proposal maintenance.</p>
			<tr>
				<td class="bar-gray-dark" width="800">Proposal name : <%=view.getProposalName() %></td>
			</tr>
			<html:form action="/protect/CancelAction.wss">
				<%
									ArrayList accessHistory = view.getProposalHistory();
									if(null != accessHistory && 0 < accessHistory.size()){
							%>
				<table border="0" class="ibm-data-table" width="800" cellspacing="1"
					cellpadding="1" summary="Access History">
					<tr style="background-color: #69c;" class="dark">

						<th id="userId" width="100">User Id</th>
						<th id="operationPerformed" width="135">Operation Performed</th>
						<th id="additionalInfo" width="150">Additional Info</th>
						<th id="accessDate" width="105">Access Date</th>
						<th id="accessTime" width="80">Access Time</th>
						
					</tr>
					<%
										for(int i=0, size=accessHistory.size(); i<size; i++){
											ProposalHistoryDataBean data = (ProposalHistoryDataBean)accessHistory.get(i);
											if(null != data){
												if((i % 2) == 1) {
							%>
					<tr class="white">
						<%      	 	    }
												else {
							%>
					
					<tr class="gray">
						<%                  }
					        %>
						<td valign="bottom" headers="userId" width="100"><%=data.getUserId()%></td>
						<td valign="bottom" headers="operationPerformed" width="135"><%=data.getOperationPerformed()%></td>
						<% if (data.getAdditionalInfo()== null){
									%>
						<td valign="bottom" headers="additionalInfo" width="150"><%=data.getDescription()%></td>
						<% }
									else {
									%>
						<td valign="bottom" headers="additionalInfo" width="135"><%="The old contract number is "+data.getAdditionalInfo()+" "+data.getDescription() %>
						</td>
						<%}
									 %>



						<td valign="bottom" headers="accessDate" width="105"><%=data.getAccessDate()%></td>
						<td valign="bottom" headers="accessTime" width="80"><%=data.getAccessTime()%></td>
						
					</tr>

					<%				
											}
										}
							%>
				</table>
				<%
									}
									else{
							%>
				<p><%=com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants.NO_ACCESS_HISTORY_FOR_PROPOSAL %></p>
				<%
									}
							%>
							&nbsp;<br />
				<table align="right" border="0" cellspacing="0" cellpadding="0"
					role="presentation">
					<tr>
						<td align="left"><oppt:button id="continue"
							name="multipleButtonManager.continue" alt="Continue"
							primary="true" value="Continue" /></td>
					</tr>
				</table>
			</html:form>
			</td>
			</tr>
		</table>
		</td>
		<td width="13">&nbsp;</td>
		<td width="10">&nbsp;</td>
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

