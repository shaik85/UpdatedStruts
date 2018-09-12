
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHeaderDetailsViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	ProposalHeaderDetailsViewBean view = (ProposalHeaderDetailsViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ArrayList buttonFlags = view.getButtonFlags();
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				<oppt:label label="<%=view.getPageTitle() %>" /></h1>

<p ><em><br>Proposal details - Header information</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table summary="Proposal details" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="ProposalHeaderAction" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="/protect/ProposalHeaderMultipleAction.wss">
				<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Sales area">
					<tr>
						<th height="18" colspan="4" style=background-color:#cccccc;  class="bar-blue-med">Sales area</th>
					</tr>
					<tr>
						<td width="147" height="20" valign="bottom">Sales organization:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getSalesOrgString() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">Distribution channel:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getDistributionChannelString() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20">Division:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getDivisionString() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">Currency code:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getCurrencyCodeString() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Basic proposal data">
					<tr>
						<th height="18" colspan="4" style=background-color:#cccccc;  class="bar-blue-med">Basic proposal data</th>
					</tr>
					<tr>
						<td width="147" height="20" valign="bottom">Proposal name:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getProposalNameString() %>" wordLength="15" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">Proposal type:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getProposalTypeString() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20">External contract number:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getExternalContractNumberString() %>" defaultLabel="-" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">Contract number:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getContractNumber()%>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20">Contract type:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getContractTypeString() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">&nbsp;<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">&nbsp;<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Contract dates">
					<tr>
						<th height="18" colspan="4" style=background-color:#cccccc;  class="bar-blue-med">Contract dates</th>
					</tr>
					<tr>
						<td width="147" valign="bottom" height="20">Contract start date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:date date="<%=view.getContractStartDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">Contract end date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:date date="<%=view.getContractEndDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20">Contract period beginning:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:date date="<%=view.getContractPeriodBeginning() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">Contract period ending:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:date date="<%=view.getContractPeriodEnding() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<%
						if(view.isDisplayContractClosureDate() || view.isDisplayAmendmentEffectiveDate()){
					%>
					<tr>
						<%
							if(view.isDisplayAmendmentEffectiveDate()){
						%>
						<td valign="bottom">Amendment effective date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="1"><oppt:date date="<%=view.getAmendmentEffectiveDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<%
							if(view.isDisplayContractClosureDate()){
						%>
						<td valign="bottom">Contract closure date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="3"><oppt:date date="<%=view.getContractClosureDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<%
							}
							else{
						%>
						<td colspan="2"><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<%
							}
						%>
						<%
							}
							else if(view.isDisplayContractClosureDate()){
						%>
						<td valign="bottom">Contract closure date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="3"><oppt:date date="<%=view.getContractClosureDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<%
							}
						%>
						
					</tr>
					<%
						}
					%>
				</table>
				&nbsp;<br />
				<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Pricing information">
					<tr>
						<th height="18" colspan="4" style=background-color:#cccccc;  class="bar-blue-med">Pricing information</th>
					</tr>
					<tr>
						<td width="147" valign="bottom" height="20"><oppt:label label="Variance date:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:date date="<%=view.getPricingInformationData().getVarianceDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="PAKID:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getPakid() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20"><oppt:label label="CAP amount:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:double doubleValue="<%=view.getVarianceData().getCapAmount() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="Exceeding amount:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getExceedingAmount() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20"><oppt:label label="GSA:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:checkbox name="strGSAInd" styleId="strGSAInd" checked="<%=view.getPricingInformationData().isGsa() %>" editable="false" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="Invoice suppression:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:checkbox name="pricingInformation.invoiceSuppression" styleId="invoiceSuppression" checked="<%=view.getPricingInformationData().isInvoiceSuppression() %>" editable="false" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20"><oppt:label label="Billing block:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="3" valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getBillingBlock() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20"><oppt:label label="Free text for invoice print:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="3" valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getFreeTextForInvoicePrint() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Purchase order data">
					<tr>
						<th height="18" colspan="4" style=background-color:#cccccc;  class="bar-blue-med">Purchase order data</th>
					</tr>
					<tr>
						<td width="147" valign="bottom" height="20"><oppt:label label="P.O. number:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getSecondaryProposalData().getPurchaseOrderNumber() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="P.O. date:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:date date="<%=view.getSecondaryProposalData().getPurchaseOrderDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Payment terms">
					<tr>
						<th height="18" colspan="4" style=background-color:#cccccc;  class="bar-blue-med">Payment terms</th>
					</tr>
					<tr>
						<td width="147" valign="bottom" height="20"><oppt:label label="Add value days:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:double doubleValue="<%=view.getSecondaryProposalData().getAddValueDays() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="Fixed val. date:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:date date="<%=view.getSecondaryProposalData().getFixedValDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom" height="20"><oppt:label label="Payment terms:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="3" valign="bottom"><oppt:label label="<%=view.getSecondaryProposalData().getPaymentTerms() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Financing data">
					<tr>
						<th height="18" colspan="2" style=background-color:#cccccc;  class="bar-blue-med">Financing data</th>
					</tr>
					<tr>
						<td width="147" valign="bottom" height="20"><oppt:label label="CAL #:" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="447" valign="bottom"><oppt:label label="<%=view.getSecondaryProposalData().getIgfOfferNumber() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<!--<br />
				<table summary="Proposal approver detail" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th height="18" colspan="2" class="bar-blue-med">Proposal approver detail</th>
					</tr>
					<tr>
						<td width="147" valign="bottom">Name<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="447" valign="bottom"><oppt:label label="<%=view.getProposalApprover()%>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;--><br />
				<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Comments">
					<tr>
						<td height="18" colspan="1">Comments:</td>
					</tr>
					<tr>
						<td width="600" valign="bottom" height="20"><oppt:label label="<%=view.getSecondaryProposalData().getComments() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table role="presentation" border="0" cellspacing="0" cellpadding="0" align="right">
					<tr>
						<td><oppt:button id="details" name="multipleButtonManager.details" alt="Details" value="Details" /></td>
						<td><oppt:button id="approve" name="multipleButtonManager.approve" primary="true" alt="Approve" value="Approve" buttonFlags="<%=buttonFlags %>" /></td>
						<td><oppt:button id="reject" name="multipleButtonManager.reject" primary="true" alt="Reject" value="Reject" buttonFlags="<%=buttonFlags %>" /></td>
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

