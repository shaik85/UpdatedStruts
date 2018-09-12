
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CopyDMViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopyDMActionForm" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	CopyDMViewBean view = (CopyDMViewBean)opptSession.getCurrentViewBean();
	ErrorReport errorReport = null;
	HashSet errorValues = null;
	if (null == view) {
		return;
	}
	errorReport = view.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	CopyDMActionForm actionForm = view.getCopyDMActionForm();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Proposal details - Copy DM</em></p>		
		</div>
	</div>

<div id="ibm-content-body">



<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				<tr>
					
					<h1></h1>
				</tr>
				<tr>
					<td><p class="ibm-alternate"><em> </em></p></td>
				</tr>
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to copy all the SWOs from the selected source
						designated machine to a specified target designated machine. When you
						are finished click the Copy button. Press the Clear all button to
						discard your input. Press the Cancel button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CopyDMMultipleAction.wss">
	<table cellpadding="1" cellspacing="1" border="0" width="600" summary="Source information">
		<tr>
			<th colspan="2" height="20" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Source information</th>
		</tr>
		<tr>
			<td width="237" height="20">&nbsp;&nbsp;Sold-to-party:</td>
			<td width="357">&nbsp;&nbsp;<oppt:label label="<%=view.getSoldToPartyNumber() %>" /></td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;Designated machine number:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getDMNumber() %>" /></td>
		</tr>
		<tr class="hil">
			<td height="20">&nbsp;&nbsp;Designated machine description:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getDMDescription() %>" /></td>
		</tr>
	</table>
	&nbsp; <br />
	<table cellpadding="1" cellspacing="1" border="0" width="600" summary="Target information">
		<tr>
			<th colspan="2" height="20" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Target information</th>
		</tr>
		<tr>
			<td width="237" height="30"><label for="soldToParty">&nbsp;&nbsp;Sold-to-party:</label></td>
			<td width="357">&nbsp;&nbsp;<oppt:select selectedOption="<%=actionForm.getSoldToParty() %>" name="soldToParty" id="soldToParty" options="<%=view.getTargetSoldToParty() %>"  title="Select sold-to-party" /></td>
		</tr>
		<tr>
			<td height="30"><label for="dmNumber">&nbsp;&nbsp;<oppt:label id="dmNumber" label="Designated machine number:" /></label></td>
			<td>&nbsp;&nbsp;<oppt:text name="dmNumber" styleId="dmNumber" maxlength="16" size="17" styleClass="iform" value="<%=actionForm.getDmNumber() %>" /></td>
		</tr>
		<tr>
			<td height="30"><label for="dmDescription">&nbsp;&nbsp;<oppt:label id="dmDescription" label="Designated machine description:" /></label></td>
			<td>&nbsp;&nbsp;<oppt:text name="dmDescription" styleId="dmDescription" maxlength="40" size="20" styleClass="iform" value="<%=actionForm.getDmDescription() %>" /></td>
		</tr>
		<tr>
			<th height="30" >&nbsp;&nbsp;Default range (dd/Mmm/yyyy):</th>
			<td>&nbsp;&nbsp;Start from: 
			<oppt:date date="<%=view.getPlanStartDate() %>" hidden="true" name="defaultPlanStartDate" />
			End to: 
			<oppt:date date="<%= view.getPlanEndDate() %>" hidden="true" name="defaultPlanEndDate" />
			</td>
		</tr>
		<tr>
			<td height="30">&nbsp;&nbsp;Plan start date:</td>
			<td>&nbsp;<oppt:dateOptions date="<%=actionForm.getPlanStartDate().getDate() %>" name="planStartDate" alt="Plan start date" years="<%=view.getStartYears() %>" /></td>
		</tr>
		<tr>
			<td height="30">&nbsp;&nbsp;Plan end date:</td>
			<td>&nbsp;<oppt:dateOptions date="<%=actionForm.getPlanEndDate().getDate() %>" name="planEndDate" alt="Plan end date" years="<%=view.getEndYears() %>" /></td>
		</tr>
	</table>
	&nbsp; <br />
	<table align="right" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td><oppt:button value="Copy" primary="true" name="multipleButtonManager.copy" alt="Copy" id="copy" /></td>
			<td><oppt:button value="Clear all" primary="true" name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button value="Cancel" primary="true" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
		</tr>
	</table>
	&nbsp; <br />
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
