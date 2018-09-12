<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.HashSet" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SWOCopyBumpViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SWOCopyBumpActionForm" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	SWOCopyBumpViewBean view = (SWOCopyBumpViewBean)opptSession.getCurrentViewBean();
	if (null == view) {
		return;
	}
	 
	SWOCopyBumpActionForm actionForm = view.getCopyBumpSWOActionForm();
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorFields = errorReport.getErrorFieldNames();
	
	OPPTCalender calender = new OPPTCalender();
	calender.setDate(view.getPlanEndDate());
	String year = calender.getYear()+"";
	String month = calender.getMonth()+"";
	String day = calender.getDay()+"";
	calender = null;
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Proposal details - SWO copy bump</em></p>		
		</div>
	</div>

<div id="ibm-content-body">






<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to alter the ESW price for a selected SWO for a
						certain time frame within the contract period. When you are finished,
						click the Copy button. Press the Clear all button to discard your
						input. Press the Cancel button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CopyBumpSWOMultipleAction.wss">
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="SWO information">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;SWO information</th>
		</tr>
		<tr valign="bottom">
			<td width="220" height="20">&nbsp;&nbsp;SWO number:</td>
			<td width="380">&nbsp;&nbsp;<oppt:label label="<%=view.getSwoNumber() %>" /></td>
		</tr>
		<tr valign="bottom">
			<td height="20">&nbsp;&nbsp;SWO serial number:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getSwoSerialNumber() %>" /></td>
		</tr>
		<tr valign="bottom">
			<td height="20">&nbsp;&nbsp;SWO description:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getSwoDescription() %>" /> </td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Source information">
		<tr>
			<th width="220" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Source information</th>
			<th width="380" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;(dd-MMM-yyyy)</th>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;Original plan start date:</td>
			<td>&nbsp;&nbsp;<oppt:date date="<%=view.getPlanStartDate() %>" /> </td>
		</tr>
		<tr>
			<td height="30"><label for="originalPlanEndDateYear">&nbsp;&nbsp;<oppt:label label="Original plan end date:" id="originalPlanEndDate" errorLables="<%=errorFields %>" /></label></td>
			<td>&nbsp;&nbsp;<oppt:text readonly="true" name="originalPlanEndDate.year" 
				size="4" value="<%=actionForm.getOriginalPlanEndDate().getYear() %>" maxlength="4" styleClass="iform" />&nbsp;- <label
				for="originalPlanEndDateMonth">&nbsp;</label><oppt:text readonly="true" name="originalPlanEndDate.month"
				size="2" value="<%=actionForm.getOriginalPlanEndDate().getMonth() %>" maxlength="2" styleClass="iform" />&nbsp;-
			<label for="originalPlanEndDateDay">&nbsp;</label><oppt:text readonly="true" 
				name="originalPlanEndDate.day" size="2" value="<%=actionForm.getOriginalPlanEndDate().getDay() %>" maxlength="2"
				styleClass="iform" /></td>
		</tr>
		<tr>
			<td height="30"><label for="sourceAlternatePrice">&nbsp;&nbsp;Alternate price:</label></td>
			<td>&nbsp;&nbsp;<oppt:text name="sourceAlternatePrice" styleId="sourceAlternatePrice" value="<%=String.valueOf(actionForm.getSourceAlternatePrice()) %>" maxlength="16" size="16" styleClass="iform" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Target information">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Target information</th>
		</tr>
		<tr>
			<td width="220" height="30">&nbsp;&nbsp;<label for="bumpPlanStartDate"><oppt:label label="Bump plan start date:" id="bumpPlanStartDate" errorLables="<%=errorFields %>" /></label></td>
			<td width="380">&nbsp;&nbsp;<oppt:dateOptions name="bumpPlanStartDate" date="<%=actionForm.getBumpPlanStartDate().getDate() %>" years="<%=view.getStartYears() %>" alt="Bump plan start date" /></td>
		</tr>
		<tr>
			<td height="30">&nbsp;&nbsp;<label for="bumpPlanEndDate"><oppt:label label="Bump plan end date:" id="bumpPlanEndDate" errorLables="<%=errorFields %>" /></label></td>
			<td>&nbsp;&nbsp;<oppt:dateOptions name="bumpPlanEndDate" date="<%=actionForm.getBumpPlanEndDate().getDate() %>" years="<%=view.getEndYears() %>" alt="Bump plan end date" /></td>
		</tr>
		<tr>
			<td height="30">&nbsp;&nbsp;<label for="targetAlternatePrice">Alternate price:</label></td>
			<td>&nbsp;&nbsp;&nbsp;<oppt:text name="targetAlternatePrice" styleId="targetAlternatePrice" size="16" value="<%=String.valueOf(actionForm.getTargetAlternatePrice()) %>" maxlength="16" styleClass="iform" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellspacing="0" cellpadding="0" role="presentation" align="left">
		<tr>
			<td><oppt:button primary="true" value="Copy" name="multipleButtonManager.copy" alt="Copy" id="copy" /></td>
			<td><oppt:button  value="Clear all" name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button  value="Cancel" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
		</tr>
	</table>
	&nbsp;<br />
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