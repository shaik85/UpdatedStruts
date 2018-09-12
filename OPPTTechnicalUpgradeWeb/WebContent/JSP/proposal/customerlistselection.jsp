<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListSelectionViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	CustomerListSelectionViewBean view = (CustomerListSelectionViewBean) opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	ArrayList buttonFlags = view.getButtonFlags();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<%
						if(view.isChangeProposal()){
					%>
					<h1><br>Proposal maintenance: Change proposal</h1> 
					<%
						}
						else{
					%>
					<h1><br>Proposal creation</h1>
					<%
						}
					%>	
					
					<%
						if(view.isChangeProposal()){
					%>
					<p ><em><br>Site Id selection: Change proposal</em></p>
					<%
						}
						else{
					%>
					<p ><em><br>Site Id selection</em></p>
					<%
						}
					%>
		</div>
	</div>	

<div id="ibm-content-body">

<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600" >
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
						
						<p>You can select one or more than one Site Id or you can select all the Site Ids by clicking the Select all button. Press the Clear all button to discard your 
						selection. Press the Cancel button to go back to proposal maintenance page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CustomerListSelectionMultipleAction.wss">
	<table cellspacing="1" cellpadding="1" border="0" width="600" summary="Customer list fetched on">
		<tr>
			<th colspan="4" align="left" style="background-color:#cccccc;" class="bar-blue-med">Customer fetched on</th>
		</tr>
		<tr>
			<td width="177" valign="bottom">&nbsp;&nbsp;Site Id number:<br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
			<td width="117" valign="bottom">&nbsp;&nbsp;<oppt:label label="<%=view.getSiteID()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
			<td width="177" valign="bottom">&nbsp;&nbsp;Site Id name:<br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
			<td width="117">&nbsp;<oppt:label label="<%=view.getSiteName()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
		</tr>
		<tr>
			<td width="177" valign="bottom">&nbsp;&nbsp;Zip code:<br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
			<td width="117" valign="bottom">&nbsp;<oppt:label label="<%=view.getZipCode()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
	
			<td width="177" valign="bottom">&nbsp;&nbsp;City:<br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
			<td width="117">&nbsp;<oppt:label label="<%=view.getCity()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
		</tr>
	</table>
	&nbsp;<br />
	<oppt:customerList changeProposal="<%=view.isChangeProposal() %>" siteIDLists="<%=view.getSiteIDLists()%>" />
	&nbsp;<br />
	<table role="presentation" border="0" cellspacing="0" cellpadding="0" width="600" > 
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" align="left"><label for="comments"><oppt:label label="Comments:"/></label></td>
		</tr>
		<tr>
			<td colspan="3" align="left"><textarea rows="2" name="comments" id="comments" cols="44" class="iform"><%=view.getComments() %></textarea></td>
		</tr>
	</table>
	&nbsp;<br />
	<table role="presentation" align="left" cellspacing="0" cellpadding="0" >
		<tr>
			<td><oppt:button value="Continue" primary="true" name="multipleButtonManager.continue" alt="Continue" id="continue" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button value="Delete"   name="multipleButtonManager.delete" alt="Delete" id="delete" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button value="Select all"  name="multipleButtonManager.selectAll" alt="Select all" id="selectAll" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button value="Clear all"  name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button value="Cancel"  name="multipleButtonManager.cancel" alt="Cancel" id="cancel" buttonFlags="<%=buttonFlags %>" /></td>
		</tr>
		<tr>
			<td>&nbsp;<br /></td>
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
