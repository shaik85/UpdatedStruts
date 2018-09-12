<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CopySWOViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopySWOActionForm" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	CopySWOViewBean view = (CopySWOViewBean)opptSession.getCurrentViewBean();
	if (null == view) {
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	CopySWOActionForm actionForm = view.getCopySWOActionForm();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Proposal details - Copy SWO</em></p>		
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
						
						<p>To copy the SWO, identify the Sold-to customer and the designated
						machine where it should be copied to. Select a Sold-to-party and click
						on Go button to get DMs for the selected customer. When you are
						finished, click the Save button. Press the Clear all button to discard
						your input. Press the Cancel button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CopySWOMultipleAction.wss">
	<table cellpadding="1" cellspacing="1" border="0" width="600" summary="SWO information">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;SWO information</th>
		</tr>
		<tr>
			<td width="252" height="20">&nbsp;&nbsp;SWO number:</td>
			<td width="342">&nbsp;&nbsp;<oppt:label label="<%=view.getSwoNumber() %>" /></td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;SWO serial number:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getSerialNumber() %>" /></td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;SWO description:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getDescription() %>" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Source information">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Source information</th>
		</tr>
		<tr>
			<td width="252" height="20">&nbsp;&nbsp;Sold-to-party:</td>
			<td width="342">&nbsp;&nbsp;<oppt:label label="<%=view.getSourceSoldToParty() %>" /></td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;Designated machine number:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getSourceDMNumber() %>" /></td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;Designated machine description:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getSourceDMDescription() %>" /></td>
		</tr>
	</table>
    &nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Target information">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Target information</th>
		</tr>
		<tr>
			<td colspan="2">
			<table summary="soldToParty">
				<tr>
					<td width="257" height="30"><label for="soldToParty">&nbsp;&nbsp;<oppt:label label="Sold-to-party:" errorLables="<%=errorValues %>" /></label></td>
					<td width="70"><oppt:select name="soldToParty" options="<%=view.getTargetSoldToParty() %>" selectedOption="<%=actionForm.getSoldToParty() %>"  title="Select sold-to-party" /></td>
					<td width="30"><span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.go" value="Go"  primary="true"  alt="Go"/></span></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="252" height="30"><label for="dmNumber">&nbsp;&nbsp;<oppt:label label="Designated machine number:" id="dmNumber" errorLables="<%=errorValues %>" /></label></td>
			<td width="342">&nbsp;&nbsp;<oppt:select selectedOption="<%=actionForm.getDmNumber() %>" name="dmNumber" options="<%=view.getTargetDMNumber() %>" onclick="populateDMDescription()"  title="Select designated mechine number" /></td>
		</tr>
		<tr>
			<td width="252" height="30"><label for="dmDescription">&nbsp;&nbsp;<oppt:label label="Designated machine description:" id="dmDescription" errorLables="<%=errorValues %>" /></label></td>
			<td width="342">&nbsp;&nbsp;<oppt:select selectedOption="<%=actionForm.getDmDescription() %>" name="dmDescription" options="<%=view.getTargetDMDescription() %>" onclick="populateDMNumber()"  title="Select designated mechine description" /></td>
		</tr>
		<tr>
			<th width="252" height="30">&nbsp;&nbsp;Default range (dd/Mmm/yyyy):</th>
			<td>&nbsp;&nbsp;<label for="defaultPlanStartDate">Start from:</label>
			<oppt:date date="<%= view.getPlanStartDate() %>" hidden="true" name="defaultPlanStartDate" />
			<label for="defaultPlanEndDate">End to:</label>
			<oppt:date date="<%= view.getPlanEndDate() %>" hidden="true" name="defaultPlanEndDate" />
			</td>
		</tr>
		<tr>
			<td width="252" height="30"><label for="planStartDate">&nbsp;&nbsp;Plan start date:</label></td>
			<td width="342">&nbsp;<oppt:dateOptions date="<%=actionForm.getPlanStartDate().getDate() %>" name="planStartDate" alt="Plan start date" years="<%=view.getStartYears() %>" /></td>
		</tr>
		<tr>
			<td width="252" height="30"><label for="planEndDate">&nbsp;&nbsp;Plan end date:</label></td>
			<td width="342">&nbsp;<oppt:dateOptions date="<%=actionForm.getPlanEndDate().getDate() %>" name="planEndDate" alt="Plan end date" years="<%=view.getEndYears() %>" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table align="right" cellspacing="0" cellpadding="0" role="presentation" align="right">
		<tr>
			<td><oppt:button primary="true" value="Copy" name="multipleButtonManager.copy" alt="Copy" id="copy" /></td>
			<td><oppt:button primary="true" value="Clear all" name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button primary="true" value="Cancel" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
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
<script language="JavaScript" type="text/javascript">

 document.onkeyup = KeyCheck; 

  function KeyCheck()
{
   var KeyID = event.keyCode;
   switch(KeyID)
   {  
      case 38:
    populateDMDescription();
	populateDMNumber();
      
       
       break;    
      case 40:        
	populateDMDescription();
	populateDMNumber();
       
	   
      break;  
 }
}
	function populateDMDescription()
	{
 		var form = parent.document.CopySWOActionForm;
 		form.dmDescription.options.selectedIndex = form.dmNumber.options.selectedIndex;
	}
	function populateDMNumber()
	{
 		var form = parent.document.CopySWOActionForm;
 		form.dmNumber.options.selectedIndex = form.dmDescription.options.selectedIndex;
	}
</script>