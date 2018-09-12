
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CopyCustomerViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopyCustomerActionForm" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	CopyCustomerViewBean view = (CopyCustomerViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	CopyCustomerActionForm actionForm = view.getCopyCustomerActionForm();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance: </h1>

<p ><em><br>Proposal details - Copy customer</em></p>		
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
					<td><p class="ibm-alternate"><em></em></p></td>
				</tr>
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to copy all designated machines and SWOs from the
						source sold-to party to the target Sold-to party and specify the plan
						start date and plan end date. When you are finished, click the Copy
						button. Press the Clear all button to discard your input. 
						Press the Cancel button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CopyCustomerMultipleAction.wss" method="post">
	<table cellpadding="1" cellspacing="1" border="0" width="600" summary="Source information"> 
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Source information</th>
		</tr>
		<tr valign="bottom">
			<td width="237" height="20">&nbsp;&nbsp;Sold-to-party:</td>
			<td width="357" height="20">&nbsp;&nbsp;<oppt:label label="<%=view.getLegacyCustomerNumberWithAS() %>" /></td>
		</tr>
		<tr valign="bottom">
			<td>&nbsp;&nbsp;Description:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getCustomerName() %>" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Target information">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Target information</th>
		</tr>
		<tr>
			<td width="240" height="30"><label for="targetSoldToParty">&nbsp;&nbsp;Sold-to-party:</label></td>
			<td width="360">&nbsp;&nbsp;<oppt:select name="targetSoldToParty" id="targetSoldToParty" options="<%=view.getTargetCustomerNumber() %>" selectedOption="<%=actionForm.getTargetSoldToParty() %>"  title="Select sold-to-party" /></td>
		</tr>
		<tr>
			<td height="30"><label for="targetDescription">&nbsp;&nbsp;Description:</label></td>
			<td align="left">&nbsp;&nbsp;<oppt:select name="targetDescription" id="targetDescription" options="<%=view.getTargetCustomerName() %>" selectedOption="<%=actionForm.getTargetDescription() %>"  title="Select description" /></td>
		</tr>
		<tr>
			<th height="30">&nbsp;&nbsp;Default range (yyyy/mm/dd):</th>
			<td>
			    <label for="defaultPlanStartDate">&nbsp;&nbsp;Start: &nbsp;&nbsp;</label>
			    <input type="text" name="defaultPlanStartDate" readonly="readonly" id="defaultPlanStartDate" maxlength="10" value="<%=view.getStartDate() %>" size="10" class="iform" />
			    <label for="defaultPlanEndDate">&nbsp;&nbsp;End: &nbsp;&nbsp;</label>
			    <input type="text" name="defaultPlanEndDate" readonly="readonly" id="defaultPlanEndDate" maxlength="10"	value="<%=view.getEndDate() %>" size="10" class="iform" />
		   </td>
		</tr>
		<tr>
			<td height="30"><label for="planStartDate">&nbsp;&nbsp;Plan start date:</label></td>
			<td>&nbsp;&nbsp;<oppt:dateOptions name="planStartDate" alt="Plan start date" years="<%=view.getStartYears() %>" date="<%=actionForm.getPlanStartDate().getDate() %>" /></td>
		</tr>
		<tr>
			<td height="30"><label for="planEndDate">&nbsp;&nbsp;Plan end date:</label></td>
			<td>&nbsp;&nbsp;<oppt:dateOptions name="planEndDate" alt="Plan end date" years="<%=view.getEndYears() %>" date="<%=actionForm.getPlanEndDate().getDate() %>" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table align="right" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td><oppt:button primary="true" value="Copy" name="multipleButtonManager.copy" alt="Copy" id="copy" /></td>
			<td><oppt:button primary="true" value="Clear all" name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button primary="true" value="Cancel" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
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