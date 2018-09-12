
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHeaderDetailsViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerInformationViewBean" %>


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
				<%=view.getPageTitle()%></h1>

<p ><em><br>Proposal details - Header information</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				<tr valign="top">
					<td nowrap="nowrap"><h1></h1></td>
				</tr>
				<tr>
					<td><p class="ibm-alternate"><em></em></p></td>
				</tr>
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="ProposalHeader" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="/protect/ProposalHeaderMultipleAction.wss">
				<table summary="Basic Proposal Details" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th style=background-color:#cccccc;  class="bar-blue-med" colspan="4" height="18" width="600">Basic proposal data</th>
					</tr>
					<tr>
						<td width="147" valign="bottom">Proposal name:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getProposalNameString() %>" wordLength="15" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">Proposal type:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getProposalTypeString() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td width="147" valign="bottom">Contract number:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getContractNumber()%>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">Contract type:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getContractType() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td width="147" valign="bottom">External contract number:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><br /><oppt:label label="<%=view.getExternalContractNumberString() %>" defaultLabel="-" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><br />Report name:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><br /><oppt:label label="<%=view.getReportNameString() %>" defaultLabel="-" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				<%
					//if(view.getBasicProposalData().isShowProposalContent())
					//{
				%>
					<tr>
						<td width="147" valign="bottom">Proposal content<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getProposalContentDetail() %>" defaultLabel="-" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">&nbsp;<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">&nbsp;<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				<%
					//}
				%>
				</table>
				<!-- BH Wave1 DAD003 - Complex Contract Identifiers - Manoj - Begin -->
				&nbsp;<br />
				<table summary="Contract Date Details" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th style=background-color:#cccccc;  class="bar-blue-med" colspan="4" height="18" width="600">Complex Contract Identifiers</th>
					</tr>
					<tr>
						<td width="147" valign="bottom">CPS id:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getBasicProposalData().getCpsID() %>" wordLength="15" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">Original CPS id:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getBasicProposalData().getOcpsID() %>" wordLength="15" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td width="147" valign="bottom">Contract type:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getBasicProposalData().getContractType() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom">BLB indicator:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="147" valign="bottom"><oppt:label label="<%=view.getBasicProposalData().getBlbIndicator() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
									
				</table>
				<!-- BH Wave1 DAD003 - Complex Contract Identifiers - Manoj - End -->
				&nbsp;<br />
				<table role="presentation" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th scope="col" width="150" height="18" style=background-color:#cccccc;  class="bar-blue-med">Contract dates</th>
						<th scope="col" width="146" height="18" style=background-color:#cccccc;  class="bar-blue-med">dd-MMM-yyyy</th>
						<th scope="col" width="146" height="18" style=background-color:#cccccc;  class="bar-blue-med"></th>
						<th scope="col" width="146" height="18" style=background-color:#cccccc;  class="bar-blue-med">dd-MMM-yyyy</th>
					</tr>
					<tr>
						<td width="150" valign="bottom">Contract start date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:date date="<%=view.getContractStartDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom">Contract end date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:date date="<%=view.getContractEndDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td width="150" valign="bottom">Contract period start:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:date date="<%=view.getContractPeriodBeginning() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom">Contract period end:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:date date="<%=view.getContractPeriodEnding() %>" /><br />
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
						<td colspan="2"><br />&nbsp;</td>
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
				<table role="presentation" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<td class="bar-blue-med" height="18" colspan="5">Pricing information</td>
					</tr>
					<tr>
						<td width="195" valign="bottom">Planned growth:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="120" valign="bottom"><oppt:label label="<%=view.getPlannedGrowthValue() %>" />&nbsp;%<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="195" valign="bottom">Growth limit:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="88" valign="bottom"><oppt:label label="<%=view.getGrowthLimitValue() %>" />&nbsp;%<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
					 <!-- BlueHarmony DAD007  changed by Anand Sugumaran  -->
						<td valign="bottom">MLC Anniversary/Period contract amount:<br />
					 <!-- BlueHarmony DAD007  changes End by Anand Sugumaran  -->
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><br /><oppt:label label="<%=view.getPricingInformationData().getAnniversaryContractAmount() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">S&amp;S Anniversary contract amount:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><br /><oppt:label label="<%=view.getPricingInformationData().getSsAnninversaryContractAmount() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<!-- CR6153 start changes -->
					<%if(view.getPricingInformationData().isExtendPeriod()){ %>
					<tr>
						<td valign="bottom">S&amp;S Anniversary amount period 2:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><br /><oppt:label label="<%=view.getPricingInformationData().getSsAnninversaryAmountPeriod2() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">S&amp;S Anniversary amount period 3:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><br /><oppt:label label="<%=view.getPricingInformationData().getSsAnninversaryAmountPeriod3() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom">S&amp;S Anniversary amount period 4:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><br /><oppt:label label="<%=view.getPricingInformationData().getSsAnninversaryAmountPeriod4() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">S&amp;S Anniversary amount period 5:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><br /><oppt:label label="<%=view.getPricingInformationData().getSsAnninversaryAmountPeriod5() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<% } %>
					<!-- CR6153 end changes -->
					<tr>
						<td valign="bottom">Billing frequency:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getBillingFrequency() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<!-- CR6153 start changes -->
						<td valign="bottom">Extended period<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:checkbox checked="<%=view.getPricingInformationData().isExtendPeriod() %>" name="isExtendPeriod" styleId="isExtendPeriod" editable="false" /><br />
						<!-- CR6153 end changes -->
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<%
						if(view.isDisplayAdditionalGrowthLimit()){
					%>
					<tr>
						<td valign="bottom">Additional growth limit:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getAdditionalGrowthLimit() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">TVM rate:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getTvmRate() %>" />&nbsp;%<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<%
						}
						else{
					%>
					<tr>
						<td valign="bottom">TVM rate:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getTvmRate() %>" />&nbsp;%<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom" colspan="2">&nbsp;<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<%
						}
					%>
					<tr>
						<td valign="bottom">Pak id:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getPakid() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">Advance:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:checkbox checked="<%=view.getPricingInformationData().isAdvance() %>" name="strAdvanceBilling" styleId="strAdvanceBilling" editable="false" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom">Discount:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom" colspan="3"><oppt:label label="<%=view.getPricingInformationData().getDiscount() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom">Detail invoice:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:checkbox name="strDetailInvoice" styleId="strDetailInvoice" checked="<%=view.getPricingInformationData().isDetailedInvoice() %>" editable="false" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">GSA:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:checkbox name="strGSAInd" styleId="strGSAInd" checked="<%=view.getPricingInformationData().isGsa() %>" editable="false" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom">Billing date rule:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom" colspan="3"><oppt:label label="<%=view.getPricingInformationData().getBillingDateRule() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom">Deviating date rule:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getDeviatingDateRule() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">Billing block:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getBillingBlock() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom">Free text for invoice print:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="3" valign="bottom"><oppt:label label="<%=view.getPricingInformationData().getFreeTextForInvoicePrint() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table summary="Purchase order data" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th style=background-color:#cccccc;  class="bar-blue-med" height="18" colspan="5">Purchase order data</th>
					</tr>
					<tr class="tbwhite">
						<td width="150" valign="bottom">P.O. number:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:label label="<%=view.getSecondaryProposalData().getPurchaseOrderNumber() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom">P.O. date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:date date="<%=view.getSecondaryProposalData().getPurchaseOrderDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table summary="Payment Terms Details" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th style=background-color:#cccccc;  class="bar-blue-med" height="18" colspan="4">Payment terms</th>
					</tr>
					<tr>
						<td width="150" valign="bottom">Add value days:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:double doubleValue="<%=view.getSecondaryProposalData().getAddValueDays() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom">Fixed val date:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:date date="<%=view.getSecondaryProposalData().getFixedValDate() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td valign="bottom">Payment terms:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="3" valign="bottom"><oppt:label label="<%=view.getSecondaryProposalData().getPaymentTerms() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table summary="Sales area" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th style=background-color:#cccccc;  class="bar-blue-med" height="18" colspan="4">Sales area</th>
					</tr>
					<tr>
						<td width="150" valign="bottom" height="20">Sales organization:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:label label="<%=view.getBasicProposalData().getSalesOrganization() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom">Distribution channel:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:label label="<%=view.getBasicProposalData().getDistributionChannel() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td width="150" valign="bottom" height="20">Division:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:label label="<%=view.getBasicProposalData().getDivision() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom">Currency:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:label label="<%=view.getBasicProposalData().getCurrencyCode() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;
				<!--<br />
				<table summary="Proposal approver detail" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th class="bar-blue-med" height="18" colspan="2">Proposal approver detail</th>
					</tr>
					<tr>
						<td width="150" valign="bottom">Name:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="444" valign="bottom"><oppt:label label="<%=view.getProposalApprover()%>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;--><br />
				<table summary="Variance" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th style=background-color:#cccccc;  class="bar-blue-med" height="18" colspan="4">Variance</th>
					</tr>
					<tr>
						<td width="150" valign="bottom">CAP amount:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td colspan="3" valign="bottom"><oppt:double doubleValue="<%=view.getVarianceData().getCapAmount() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<td width="150" valign="bottom">CAP plus:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:double doubleValue="<%=view.getVarianceData().getCapPlus() %>" />&nbsp;%<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom">CAP minus:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="146" valign="bottom"><oppt:double doubleValue="<%=view.getVarianceData().getCapMinus() %>" />&nbsp;%<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<table summary="Financing data" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th style=background-color:#cccccc;  class="bar-blue-med" height="18" colspan="4">Financing data</th>
					</tr>
					<tr>
						<td width="150" valign="bottom">Financial contract number:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td width="444" valign="bottom"><br /><oppt:label label="<%=view.getSecondaryProposalData().getIgfOfferNumber() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<!-- BH Wave1 DAD003 - Complex Contract Identifiers - Manoj - Begin -->
						<td width="150" valign="bottom">Special billing indicator:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom">
						<oppt:label label="<%=view.getPricingInformationData().isPrebillIndicator()%>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<!-- BH Wave1 DAD003 - Complex Contract Identifiers - Manoj - End -->
					</tr>
				</table>
				&nbsp;<br />
				<%
					PartnerInformationViewBean partnerInformation = view.getPartnerInformation();
					if(null != partnerInformation){
				%>
				<table summary="Partner function details" border="0" width="600" cellspacing="1" cellpadding="1">
					<tr>
						<th style=background-color:#cccccc;  class="bar-blue-med" height="18" colspan="3">Partner function details</th>
					</tr>
					<tr class="gray">
						<td width="150">&nbsp;</td>
						<th width="100" align="left">Number</th>
						<th width="341" align="left">Name</th>
					</tr>
					<tr>
						<th valign="bottom">Sold to party:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getSoldToPartyNumber() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></th>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getSoldToPartyName() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<th valign="bottom">Bill to party:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></th>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getBillToPartyNumber() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getBillToPartyName() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<th valign="bottom">Payer:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></th>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getPayerNumber() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getPayerName() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<th valign="bottom">Ship to party:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></th>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getShipToPartyNumber() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getShipToPartyName() %>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
					<tr>
						<th valign="bottom">9E Partner:<br />
						<div class="ibm-alternate-rule">&nbsp;</div></th>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getNineDPartnerNumber()%>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
						<td valign="bottom"><oppt:label label="<%=partnerInformation.getNineDPartnerName()%>" /><br />
						<div class="ibm-alternate-rule">&nbsp;</div></td>
					</tr>
				</table>
				&nbsp;<br />
				<%
					}
				%>
				<table align="right" role="presentation" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><oppt:button id="details" name="multipleButtonManager.details" alt="Details" primary="true" value="Details" /></td>
						<td><oppt:button id="approve" name="multipleButtonManager.approve" alt="Approve" primary="true" value="Approve" buttonFlags="<%=buttonFlags %>" /></td>
						<td><oppt:button id="reject" name="multipleButtonManager.reject" alt="Reject" primary="true" value="Reject" buttonFlags="<%=buttonFlags %>" /></td>
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

