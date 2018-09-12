
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.commons.GroupUserDataBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalMaintenanceViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ProposalMaintenanceViewBean view = (ProposalMaintenanceViewBean)opptSession.getCurrentViewBean();
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
		</div>
	</div>	

<div id="ibm-content-body">


<table role= "presentation" "cellpadding="0" cellspacing="0" border="0" width="600" >
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						Use the tick box to select a proposal and press the respective button
						for the transaction you wish to perform.

						<br>
						<br>
						Required fields are marked with an asterisk (<strong>*</strong>)
						and must be filled in to complete the form.	
						<br>				
						<br>
						<%
							if(view.isGroupUser()){
								GroupUserDataBean groupUserData = view.getGroupUserData();
								if(null != groupUserData){
						%>
						<br />
							<table width = "600" cellpadding="0" cellspacing="0" border="0" role="presentation">
								<tr>
									<html:form action="/protect/UserProposals.wss">
									<td width="200" nowrap="nowrap" height="30"><label >List of proposals for group: </label></td>
										<input type="hidden" name="groupName" value="<%=groupUserData.getGroupName()%>" /> 
										<input type="hidden" name="selectedUser" value="<%=groupUserData.getSelectedUser()%>" />
										<% if( null != groupUserData.getUserGroups() && groupUserData.getUserGroups().size() == 1) { %>
										<td> <%= groupUserData.getSelectedGroupName() %> </td>
										<% } else { %>
											
										<td>
										<oppt:select name="selectedGroup" id="selectedGroup" style="iform" options="<%=groupUserData.getUserGroups()%>" selectedOption="<%=groupUserData.getSelectedGroupName()%>" title = "Select group" />&nbsp;
										<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.go" value="Go"  primary="true"  alt="Go"/></span>
									 </td>	
									<% } %>
									</html:form>
									</tr>	
									<tr>
									<html:form action="/protect/UserProposals.wss">
										<input type="hidden" name="groupName" value="<%=groupUserData.getGroupName()%>" /> 
										<input type="hidden" name="selectedGroup" value="<%=groupUserData.getSelectedGroupName()%>" /> 
										<td width="200" height="30"><label for="selectedUser">User&nbsp;ID:&nbsp;</label></td>
										<td><oppt:select name="selectedUser" id="selectedUser" style="iform" options="<%=groupUserData.getGroupUsers()%>" selectedOption="<%=groupUserData.getSelectedUser()%>" title = "Select User ID" />&nbsp;
										<span class="button-blue"><input type="submit" id="go1" name="multipleButtonManager.go" value="Go"  primary="true"  alt="Go"/></span>
										</td>
									</html:form>
								</tr>
							</table>
						<%
								}
							}
							else{
						%>
							List of proposals for: <oppt:label label="<%=view.getUserName() %>" />
							
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

<html:form action="/protect/ProposalMaintenanceMultipleAction.wss">
	<table role="presentation" width="600" align="left" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
				<oppt:proposalmaintenance property="selectedIds" message="<%=view.getMessage() %>" proposals="<%=view.getProposals() %>" groupUser="<%=view.isGroupUser() %>" requiredError="<%=view.isRequiredError()%>" />
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
				<oppt:buttons buttonFlags="<%=buttonFlags %>">
					<oppt:opptbutton id="lock" name="multipleButtonManager.lock" value="Lock" alt="Lock" />
					<oppt:opptbutton id="release" name="multipleButtonManager.release" value="Release" alt="Release" />
					<oppt:opptbutton id="share" name="multipleButtonManager.share" value="Share" alt="Share" />
					<oppt:opptbutton id="removeShare" name="multipleButtonManager.removeShare" value="Remove share" alt="Remove share" />
					<oppt:opptbutton id="rename" name="multipleButtonManager.rename" value="Rename" alt="Rename" />
					<oppt:opptbutton id="copy" name="multipleButtonManager.copy" value="Copy" alt="Copy" />
					<oppt:opptbutton id="delete" name="multipleButtonManager.delete" value="Delete" alt="Delete"/>
					<oppt:opptbutton id="changeProposal" name="multipleButtonManager.changeProposal" value="Change proposal" alt="Change proposal" />
					<oppt:opptbutton id="checkStatus" name="multipleButtonManager.checkStatus" value="Check status" alt="Check status" />
					<oppt:opptbutton id="accessHistory" name="multipleButtonManager.accessHistory" value="Activity Log" alt="Access history" />
					<oppt:opptbutton id="errorHistory" name="multipleButtonManager.errorHistory"  value="Error history" alt="Error history" />
				</oppt:buttons>
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


