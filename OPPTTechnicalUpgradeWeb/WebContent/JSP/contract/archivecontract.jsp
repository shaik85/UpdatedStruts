
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractMaintenanceViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	TreeMap groupUsers = null;
	TreeMap contractList=null;
	ArrayList buttonFlags = null;
	
	String groupName = "";
	String selectedUser="";
	String selectedGroupName="";
	
	ErrorReport errorReport = null;

	OPPTSession opptSession = new OPPTSession(session);
	ContractMaintenanceViewBean viewBean = (ContractMaintenanceViewBean)opptSession.getCurrentViewBean();
	if(null != viewBean){
		groupUsers = viewBean.getGroupUsers();
		contractList = viewBean.getContracts();
		groupName = viewBean.getGroupName();
		selectedUser = viewBean.getUserName();
		selectedGroupName = viewBean.getSelectedGroupName();
		
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Archive maintenance</h1>

	
		</div>
	</div>	

<div id="ibm-content-body">
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use the tick box to select a contract and press the respective  
						button for the transaction you wish to perform. </p>
						
						<p>Required fields are marked with an asterisk (<strong>*</strong>)
						and must be filled in to complete the form.</p>							
						<%
							if(viewBean.isGroupUser()){
							
						%>
						
							<table width = "600" cellpadding="0" cellspacing="0" border="0" role="presentation">
								<tr>
									<html:form action="/protect/ArchiveChangeGroup.wss">
									<td height="30" width="200"><label >List of contracts for group:  </label></td>
										<input type="hidden" name="groupUser" value="<%=selectedUser%>" />
										<% if( null != viewBean.getUserGroups() && viewBean.getUserGroups().size() == 1) { %>
										<td><%= viewBean.getSelectedGroupName()%> </td>
										<% } else { %>  <td>
											<oppt:select name="selectedGroup" style="iform" id="selectedUser" options="<%=viewBean.getUserGroups()%>" selectedOption="<%=selectedGroupName%>" title="Select list of contracts for group" />&nbsp;																	
											<span class="button-blue"><input class="ibm-btn-arrow-sec" type="submit" name="multipleButtonManager.go" value="Go" alt="Go" value="Go" id="go"  /></span>
											</td>											
									<% } %>
									</html:form>
									</tr> <tr>									
									<html:form action="/protect/ArchiveDetail.wss">
										<input type="hidden" name="selectedGroup" value="<%=selectedGroupName%>" /> 
										<td height="30" width="200"><label for="ContractList">User ID:&nbsp; </label></td> <td> <oppt:select name="groupUser" id="ContractList" style="iform" options="<%=groupUsers%>" selectedOption="<%=selectedUser%>" title= "Select user ID" /> 	&nbsp;
										<span class="button-blue"><input class="ibm-btn-arrow-pri" type="submit" name="multipleButtonManager.go" value="Go" alt="Go" value="Go" id="go" primary="true" /></span>
										</td>
									</html:form>
								</tr>
							</table>
						<%	
							}
							else{
						%>
							<p>List of contracts for : <oppt:label label="<%=viewBean.getUserName() %>" /></p>
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
<html:form action="protect/ArchiveMaintenanceMultipleAction.wss">
	<table align="left" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td width="600">
				<oppt:contractmaintenance property="selectedContractIds" message="<%=viewBean.getMessage() %>" contracts="<%=viewBean.getContracts() %>" groupUser="<%=viewBean.isGroupUser() %>" requiredError="<%=viewBean.isRequiredError()%>" />
			</td>
		</tr>
		<tr>
			<td width="600">&nbsp;</td>
		</tr>
		<tr align="left">
			<td width="600" >
				<oppt:buttons buttonFlags="<%=buttonFlags %>">
				<oppt:opptbutton id="lock" name="multipleButtonManager.lock" alt="Lock" value="Lock" />
				<oppt:opptbutton id="release" name="multipleButtonManager.release" alt="Release" value="Release" />
				</oppt:buttons>
			</td>						
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



