
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.TransferProposalsViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.TransferProposalsActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserInfoViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	TreeMap salesArea = null;
	ArrayList targetUserList=null;
	ArrayList createApproveList=null;
	ArrayList approverList=null;
	String selectedSalesArea="";
	ArrayList buttonFlags = null;
	ErrorReport errorReport = null;
	UserInfoViewBean userInfoBean=null;
	TransferProposalsActionForm actionForm = null;

	OPPTSession opptSession = new OPPTSession(session);
	TransferProposalsViewBean viewBean = (TransferProposalsViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		actionForm = viewBean.getTransferProposalActionForm();
		salesArea = viewBean.getSalesAreas();
		targetUserList = viewBean.getTargetUsers();
		createApproveList = viewBean.getCreateApproveUsers();
		approverList = viewBean.getProposalApproveUsers();
		selectedSalesArea = viewBean.getSelectedSalesArea();
		
		buttonFlags=viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				User maintenance</h1>

<p ><em>Transfer proposals</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">

<table summary="User maintenance" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="443">
			<table role="presentation" width="443">
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use the radio button to select the user id to whom the proposals
						 should be transferred to.  When you are finished, click the Continue button. 
						 Press the Cancel button to go back to user maintenance page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="TransferChangeOrg" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/TransferChangeOrg.wss" method="get">
			<table summary="sales area">
				<tr>
					<th><label for="salesArea">Sales org:</label></th>
					<td><oppt:select name="salesArea" id="salesArea" style="iform" reverse="true" options="<%=salesArea%>" selectedOption="<%=selectedSalesArea%>" title="Select sales org" />
					&nbsp;<span class="button-blue"><input type="submit" value="Go" /></span>&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
			</html:form>
            &nbsp;<br />							
			<html:form action="protect/SubmitTransferMultipleAction.wss">
			<table summary="transferuserproposal" align="left" width="600" border="0" cellspacing="1" cellpadding="1">
				<tr>
					<td colspan="2">
						<oppt:transferuserproposal targetlist="<%=targetUserList%>" createapprovelist="<%=createApproveList%>" approverlist="<%=approverList%>" message="<%=viewBean.getMessage()%>" userrole="<%=viewBean.getSourceUserRole()%>" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<table summary="multipleButton" cellpadding="0" cellspacing="0" border="0" align="right">
							<tr>
								<td><oppt:button id="continue" name="multipleButtonManager.continue" primary="true" alt="Continue" 
									value="Continue" buttonFlags="<%=buttonFlags %>" /></td>
								<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
							</tr>
						</table>
					</td>
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
