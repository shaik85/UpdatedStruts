
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.commons.GroupUserDataBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalsForApprovalViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ProposalsForApprovalViewBean view = (ProposalsForApprovalViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = view.getButtonFlags();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposals for approval</h1>

		</div>
	</div>	

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Proposals for approval">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				<tr>
					<h1></h1>
				</tr>
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use the tick box to select a proposal for approval and press the
						button for the specific function you wish to perform.</p>
						<%
							if(view.isGroupUser()){
								GroupUserDataBean groupUserData = view.getGroupUserData();
								if(null != groupUserData){
						%>
						<table width = "650" cellpadding="0" cellspacing="0" border="0" summary="UserProposalsForApproval">
								<tr>
									<html:form action="/protect/UserProposalsForApproval.wss">
									<th width="180" height="30"><label for="selectedGroup">List of proposals for group: </label> </th>
										<input type="hidden" name="groupName" value="<%=groupUserData.getGroupName()%>" /> 
										<input type="hidden" name="selectedUser" value="<%=groupUserData.getSelectedUser()%>" />
										<% if( null != groupUserData.getUserGroups() && groupUserData.getUserGroups().size() == 1) { %>
										<td> <%= groupUserData.getSelectedGroupName() %> </td>
										<% } else { %>
											
										<td><oppt:select name="selectedGroup" style="iform" options="<%=groupUserData.getUserGroups()%>" selectedOption="<%=groupUserData.getSelectedGroupName()%>" title="select List of proposals for group"/> 	&nbsp;
											<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.go" value="Go"  primary="true"  alt="Go"/></span>
										</td>	
									<% } %>
									</html:form>
									</tr>	
									<tr>								
									<html:form action="/protect/UserProposalsForApproval.wss">
										<input type="hidden" name="groupName" value="<%=groupUserData.getGroupName()%>" /> 
										<input type="hidden" name="selectedGroup" value="<%=groupUserData.getSelectedGroupName()%>" /> 
										<th><label for="selectedUser"> User ID: </label> </th> 
										<td><oppt:select name="selectedUser" style="iform" options="<%=groupUserData.getGroupUsers()%>" selectedOption="<%=groupUserData.getSelectedUser()%>" title="select User ID"/> &nbsp;
											<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.go" value="Go"  primary="true"  alt="Go"/></span>
										</td>
									</html:form>
								</tr>
							</table>
						
				
						
						<%
								}
							}
							else{
						%>
							<p>List of proposals for : <oppt:label label="<%=view.getUserName() %>" /></p>
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
<html:form action="/protect/ProposalsForApprovalMultipleAction">
	<table align="left" cellspacing="0" cellpadding="0" summary="proposalsforapproval">
		<tr>
			<td width="650">
				<oppt:proposalsforapproval property="selectedIds" message="<%=view.getMessage() %>" proposals="<%=view.getProposalsForApproval() %>" groupUser="<%=view.isGroupUser() %>"  requiredError="<%=view.isRequiredError()%>"  />
			</td>
		</tr>
		<tr>
			<td width="650">&nbsp;</td>
		</tr>
		<tr>
			<td width="650">
			<table align="right" border="0" cellspacing="0" cellpadding="0" role="presentation">
				<tr>
					<td><oppt:button id="lock" name="multipleButtonManager.lock" alt="Lock" value="Lock" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="release" name="multipleButtonManager.release" alt="Release" value="Release" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="accessHistory" name="multipleButtonManager.accessHistory" alt="Access history" value="Access History" buttonFlags="<%=buttonFlags %>" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="600">&nbsp;</td>
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
