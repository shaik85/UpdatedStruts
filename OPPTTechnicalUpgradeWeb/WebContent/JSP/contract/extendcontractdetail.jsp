
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractExtensionViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	ArrayList yearList = null;
	ErrorReport errorReport = null;
	TreeMap approverList=null;
	Date extensionDate = null;
	
	ArrayList buttonFlags = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	ContractExtensionViewBean viewBean = (ContractExtensionViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		buttonFlags=viewBean.getButtonFlags();
		approverList = viewBean.getApprover();
		yearList = viewBean.getYearList();
		extensionDate = viewBean.getContractExtensionDate();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>




<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract registration</h1>

	
		</div>
	</div>	

<div id="ibm-content-body">
<table summary="Contract registration" cellpadding="0" cellspacing="0" border="0" width="600">
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
						
						<p>To register the contract, select the pertinent Approver ID 
						from the pull-down box and click the Send for approval button. 
						Press the Clear all button to discard your input. Press the Cancel button 
						to go back to contract maintenance page.</p>
						
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
<table summary="SubmitExtendContract" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/SubmitExtendContractMultipleAction.wss">
			<table summary="SubmitExtendContract Info" cellspacing="0" cellpadding="0" width="600" border="0">
				<tr>
					<td width="12" align="center">&nbsp;</td>
					<td width="200" height="25">Proposal name:</td>
					<td width="388"><oppt:label label="<%=viewBean.getProposalName()%>" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">Proposal type:</td>
					<td><oppt:label label="<%=viewBean.getProposalType()%>" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">Contract type:</td>
					<td><oppt:label label="<%=viewBean.getContractType()%>" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">Contract number:</td>
					<td><oppt:label label="<%=viewBean.getContractNumber()%>" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">External contract number:</td>
					<td><oppt:label label="<%=viewBean.getExternalContractNumber()%>" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="25">Billing frequency:</td>
					<td><oppt:label label="<%=viewBean.getProposalType()%>" /></td>
				</tr>
				<tr>
					<td></td>
					<td height="30"><label for="ApproverId" ><span class="ibm-required">*</span>Approver ID:</label></td>
					<td>
						<oppt:select name="approverId"  id="ApproverId" options="<%=approverList%>" selectedOption="<%=viewBean.getSelectedApprover()%>" title="select Approver ID" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="30"><label for="Alt_ApproverMailId">Send contract to: </label></td>
					<td><input type="text" name="approverMailId" id="Alt_ApproverMailId" size="30" maxlength="90" class="iform" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td height="30"><label for="Alt_ReplyMailId">Send reply notes to: </label></td>
					<td><input type="text" name="replyMailId" id="Alt_ReplyMailId" size="30" maxlength="90" class="iform" /></td>
				</tr>
			</table>
			&nbsp;<br />
			<table role="presentation" align="left" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><oppt:button id="sendForApproval" name="multipleButtonManager.send" alt="Send for approval" primary="true" value="Send for approval" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" primary="true" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
					<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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


	<div id="ibm-content-main">
		<div style="position:absolute; top:0;right:10px;">
 <p class="ibm-ind-link"><a href="javascript:getFormHelp()" title="Page help"  class="ibm-popup-link" >Page Help</a></p>
		</div>	
	</div>

</div>

<script type="text/javascript">
	window.onload = function() {
		var hiddenElements = document.getElementsByName("validationErrorElements");
		//read the identifier of the error fields, from the hiddenElements 
		//and set the aria-invalid attribute for those ids
		var hiddenElement = null;
		for(var x=0; x<hiddenElements.length; x++){
			console.log("before "+hiddenElements[x].value);
			console.log("before "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
			hiddenElement = document.getElementById(hiddenElements[x].value)
			if (hiddenElement){hiddenElement.setAttribute("aria-invalid","true")};
			console.log("after "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
		}
	}
</script>





