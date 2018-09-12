
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.GroupMaintenanceViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>


<%
	TreeMap salesArea = null;
	ArrayList groupList = null;
	ArrayList buttonFlags = null;
	ErrorReport errorReport = null;
	OPPTSession opptSession = new OPPTSession(session);
	GroupMaintenanceViewBean viewBean = (GroupMaintenanceViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		salesArea = viewBean.getSalesAreas();
		groupList = viewBean.getGroups();
		
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate" role="main">
		<div id="ibm-leadspace-body" class="ibm-alternate" role="main">

				<h1><br>
				Group maintenance</h1>

		
		</div>
	</div>	

<div id="ibm-content-body" role="main">
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
						<p>Use this page to add or remove a group</p>

						<p>Required fields are marked with an asterisk (<strong>*</strong>)
						and must be filled in to complete the form.</p>

					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table role="main" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td >
			<html:form action="protect/GroupMaintenanceMultipleAction.wss" method="get">
				<table role="presentation">
					<tr>
						<label for="sales">Sales org:</label>
						<td><oppt:select name="salesArea" id="sales" reverse="true" style="iform" options="<%=salesArea%>" selectedOption="<%=viewBean.getSelectedSalesArea()%>" title= "Select sales org" /></td>
						<td>&nbsp;<span class="button-blue"><input type="submit" class="ibm-btn-arrow-sec"  name="multipleButtonManager.findGroup" value="Go" /></span>&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
				</table>
				<%
					int groupSize = 0;
						
					if(groupList != null && (groupSize = groupList.size()) > 0){
				%>
			
                <table border="0" class="ibm-data-table ibm-alternating" width="600" cellpadding="1" cellspacing="1" summary="List of Groups">
					<tr  class="dark">
						<th nowrap="nowrap" width="27"  id="GroupId" ><strong class="black">*</strong>Required</th>
						<th nowrap="nowrap" width="410" id="GroupName" >Group name</th>
					</tr>
					<%
					        int count = 1;
							for(int i=0; i < groupSize; i++){
								String groupName = (String)groupList.get(i);
								String labelValue = "groupId"  + groupName;
								if((count % 2) == 1) {
   				    %>				<tr class="white">
					<%          }
								else {
					%>				<tr class="gray">
                    <%          }
					%>				<td  width="22" headers="GroupId" align="center"><input type="radio" name="groupName"	value="<%=groupName%>" id="<%=labelValue%>" /></td>
									<td headers="GroupName" align="left" ><label for="<%=labelValue%>"><%=groupName.trim()%></label></td>
								</tr>
					<%          count++;
							}
						}
						if(viewBean.getMessage()!= null)
						{
					%>
					<tr>
						<td>
							<oppt:proposalmaintenance property="selectedIds" message="<%=viewBean.getMessage() %>" />
						</td>
					</tr>
					<% } %>
					<tr>
						
					</tr>
					<tr>
						
							<table role="presentation" border="0" cellspacing="0" cellpadding="0" align="right">
								<tr>
									<td align="right"><oppt:button id="addGroup" name="multipleButtonManager.addGroup" alt="Add Group" value="Add group" primary="true" buttonFlags="<%=buttonFlags %>" /></td>
									<td align="right"><oppt:button id="removeGroup" name="multipleButtonManager.removeGroup" alt="Remove Group" value="Remove group" buttonFlags="<%=buttonFlags %>" /></td>
								</tr>
							</table>
						
					</tr>
				</table>
			</html:form>
		</td>
	</tr>
</table>
<!-- start content head -->
		<div id="ibm-content-head">


		</div> 
    	<!-- stop content head -->


	<div id="ibm-content-main" role="main">
		<div style="position:absolute; top:0;right:10px;">
 <p class="ibm-ind-link"><a href="javascript:getFormHelp()" title="Page help"  class="ibm-popup-link" >Page Help</a></p>
		</div>	
	</div>

</div>


