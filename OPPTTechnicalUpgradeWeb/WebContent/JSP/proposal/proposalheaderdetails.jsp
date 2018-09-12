
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.ArrayList"%>
<%@ page
	import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page
	import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page
	import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHeaderDetailsViewBean"%>

<%
	OPPTSession opptSession = new OPPTSession(session);

	ProposalHeaderDetailsViewBean view = (ProposalHeaderDetailsViewBean) opptSession
			.getCurrentViewBean();
	if (null == view) {
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList startYearsList = view.getStartYears();
	ArrayList endYearsList = view.getEndYears();
	ArrayList buttonFlags = view.getButtonFlags();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
<div id="ibm-leadspace-body" class="ibm-alternate">

<h1><br>
Proposal maintenance</h1>

<p><em><br>
Change proposal</em></p>
</div>
</div>

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="700"
	role="presentation">
	<tr valign="top">
		<td width="700">
		<table width="700" role="presentation">

			<tr>
				<td class="bar-gray-dark">
				<p>Proposal name : <oppt:label
					label="<%=view.getProposalNameTypeString() %>" /></em></p>
				</td>
			</tr>
			<tr>
				<td><oppt:displayErrorReport errorReport="<%=errorReport%>" />

				<p>Use this form to change the header data for this proposal.
				When you are finished, click the Save button. Press the Clear all
				button to discard your changes. Press the Cancel button to go back
				to proposal maintenance page.</p>

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

<html:form action="/protect/ChangeProposalHeaderMultipleAction.wss"
	method="post">
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Sales Area Details">
		<tr>
			<th height="18" colspan="6">&nbsp;&nbsp;Sales area</th>
		</tr>
		<tr>
			<td width="12" height="20">&nbsp;</td>

			<td width="150">Sales organization:</td>
			<td width="188"><oppt:label
				label="<%=view.getSalesOrgString() %>" /></td>
			<td width="12">&nbsp;</td>

			<td width="150">Distribution channel:</td>
			<td width="188"><oppt:label
				label="<%=view.getDistributionChannelString() %>" /></td>
		</tr>
		<tr>
			<td width="12" height="20">&nbsp;</td>

			<td width="150">Division:</td>
			<td width="188"><oppt:label
				label="<%=view.getDivisionString() %>" /></td>
			<td width="12">&nbsp;</td>

			<td width="150">Currency code:</td>
			<td width="188"><oppt:label
				label="<%=view.getCurrencyCodeString() %>" /></td>
		</tr>
	</table>
&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Basic Proposal Details">
		<tr>
			<th height="18" colspan="6">&nbsp;&nbsp;Basic proposal data</th>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150">Proposal name:</td>
			<td width="188"><oppt:label
				label="<%=view.getProposalNameString() %>" /></td>
			<td width="12">&nbsp;</td>

			<td width="150"><label for="proposalType">Proposal type:</label></td>
			<td width="188"><oppt:label
				label="<%=view.getProposalTypeString() %>" /> <input type="hidden"
				name="basicProposalData.proposalType"
				value="<%=view.getProposalTypeString()%>" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="reportName">Report name:</label></td>
			<td width="188"><oppt:text name="basicProposalData.reportName"
				styleId="reportName" value="<%=view.getReportNameString() %>"
				maxlength="40" size="15" styleClass="iform" /></td>
			<td width="12">&nbsp;</td>

			<td width="150"><label for="externalContractNumber">External
			contract number:</label></td>
			<td width="188"><oppt:text
				name="basicProposalData.externalContractNumber"
				styleId="externalContractNumber"
				value="<%=view.getExternalContractNumberString() %>" maxlength="10"
				size="10" styleClass="iform" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150">Contract number:</td>
			<td width="188"><oppt:label
				label="<%=view.getContractNumber() %>" /></td>
			<td width="12">&nbsp;</td>

			<td width="150">Contract type:</td>
			<td width="188"><oppt:label
				label="<%=view.getContractTypeString() %>" /></td>
		</tr>
		<%
			if (view.getBasicProposalData().isShowProposalContent()) {
					if (view.getBasicProposalData().isProposalContentEditable()) {
		%>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="proposalContent"><oppt:label
				label="Proposal content" id="proposalContent"
				errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:select name="proposalContent"
				id="proposalContent"
				selectedOption="<%=view.getBasicProposalData().getProposalContent()%>"
				options="<%=view.getProposalContentOptions()%>"
				title="Select proposal content" title="Select proposal content" /></td>
			<td width="12">&nbsp;</td>

			<td width="150">&nbsp;</td>

			<td width="188">&nbsp;</td>
		</tr>
		<%
			} else {
		%>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150">Proposal content:</td>
			<td width="188"><%=view.getProposalContentDetail()%></td>
			<td width="12">&nbsp;</td>

			<td width="150">&nbsp;</td>

			<td width="188">&nbsp;</td>
		</tr>
		<%
			}
				}
		%>
	</table>
&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Contract Date Details">
		<tr>
			<th height="18" colspan="6">&nbsp;&nbsp;Contract dates</th>
		</tr>
		<tr>
			<td width="12" height="30"></td>

			<td width="150"><label for="contractStartDate" ><span class="ibm-required">*</span>Contract
			start date:</label></td>
			<td width="188"><oppt:dateOptions name="contractStartDate"
				date="<%=view.getContractStartDate()%>"
				years="<%=view.getStartYears() %>" alt="Contract start date"
				mandatory="true" /></td>
			<td width="12"></td>

			<td width="150"><label for="contractEndDate" ><span class="ibm-required">*</span>Contract
			end date:</label></td>
			<td width="188"><oppt:dateOptions name="contractEndDate"
				date="<%=view.getContractEndDate()%>"
				years="<%=view.getEndYears() %>" alt="Contract end date"
				mandatory="true" /></td>
		</tr>
		<tr>
			<td width="12"></td>

			<td width="150"><label for="contractPeriodStartDate" ><span class="ibm-required">*</span>Contract
			period beginning:</label></td>
			<td width="188"><oppt:dateOptions name="contractPeriodStartDate"
				date="<%=view.getContractPeriodBeginning()%>"
				years="<%=view.getStartYears() %>" alt="Contract period beginning"
				mandatory="true" /></td>
			<td width="12"></td>

			<td width="150"><label for="contractPeriodEndDate" ><span class="ibm-required">*</span>Contract
			period ending:</label></td>
			<td width="188"><oppt:dateOptions name="contractPeriodEndDate"
				date="<%=view.getContractPeriodEnding()%>"
				years="<%=view.getEndYears() %>" alt="Contract period ending"
				mandatory="true" /></td>
		</tr>
	</table>
&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Pricing Details">
		<tr>
			<th height="18" colspan="6">&nbsp;&nbsp;Pricing information</th>
		</tr>
		<%
			String value = view.getPricingInformationData()
						.getPlannedGrowthValue()
						+ "";
		%>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="plannedGrowth"><oppt:label
				label="Planned growth:" id="plannedGrowth"
				errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:select
				name="pricingInformation.plannedGrowthOption" id="plannedGrowth"
				selectedOption="<%=view.getPricingInformationData().getPlannedGrowthOption() %>"
				options="<%=view.getPlannedGrowthOptions() %>"
				title="Select planned growth" /> <label for="plannedGrowthText">&nbsp;</label>
			<oppt:text name="pricingInformation.plannedGrowthValue" size="6"
				maxlength="6" styleId="plannedGrowthText" value="<%=value %>"
				styleClass="iform" />%</td>
			<td width="12"></td>

			<td width="150"><label for="billingFrequency" ><span class="ibm-required">*</span><oppt:label
				label="Billing frequency:" id="billingFrequency"
				errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:select
				name="pricingInformation.billingFrequency" id="billingFrequency"
				selectedOption="<%=view.getPricingInformationData().getBillingFrequency() %>"
				options="<%=view.getBillingFrequencyOptions() %>"
				title="Select billing frequency" /></td>
		</tr>
		<%
			value = view.getPricingInformationData().getGrowthLimitValue()
						+ "";
		%>
		<tr>
			<td width="12">&nbsp;</td>

			<td width="150"><label for="growthLimit"><oppt:label
				label="Growth limit:" id="growthLimit"
				errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:select
				name="pricingInformation.growthLimitOption" id="growthLimit"
				selectedOption="<%=view.getPricingInformationData().getGrowthLimitOption() %>"
				options="<%=view.getGrowthLimitOptions() %>"
				title="Select growth limit" /> <label for="growthLimitText">
			&nbsp;</label> <oppt:text name="pricingInformation.growthLimitValue"
				styleClass="iform" styleId="growthLimitText" value="<%=value %>"
				size="6" maxlength="6" />%</td>
			<td width="12">&nbsp;</td>

			<td width="150"><label for="advance"><oppt:label
				label="Advance:" id="advance" errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:checkbox name="pricingInformation.advance"
				styleId="advance"
				checked="<%=view.getPricingInformationData().isAdvance() %>"
				style="iform" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="pakid"><oppt:label
				label="PAKID:" id="pakid" errorLables="<%=errorValues%>" /></label></td>
			<td width="480" colspan="4"><oppt:text
				name="pricingInformation.pakid" styleClass="iform" styleId="pakid"
				size="7" value="<%=view.getPricingInformationData().getPakid() %>"
				maxlength="7" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="discount"><oppt:label
				label="Discount:" id="discount" errorLables="<%=errorValues%>" /></label></td>
			<td width="188"><oppt:text name="pricingInformation.discount" styleClass="iform" styleId="discount"
				size="5" maxlength="5" value="<%=view.getPricingInformationData().getDiscount() %>"/>%</td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="tvmRate"><oppt:label
				label="TVM rate:" id="tvmRate" errorLables="<%=errorValues%>" /></label></td>
			<%
				value = view.getPricingInformationData().getTvmRate() + "";
			%>

			<td width="188"><oppt:text name="pricingInformation.tvmRate"
				styleId="tvmRate" styleClass="iform" size="5" maxlength="5"
				value="<%=value %>" />%</td>
			<td width="12">&nbsp;</td>

			<td width="150">&nbsp;</td>

			<td width="188">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			<!-- BlueHarmony DAD007  changed by Anand Sugumaran  -->
			<td width="150"><label for="anniversaryContractAmount"><oppt:label
				label="MLC Anniversary/Period contract amount:"
				id="anniversaryContractAmount" errorLables="<%=errorValues%>" /></label></td>
			<!-- BlueHarmony DAD007  changes End by Anand Sugumaran  -->
			<%
				value = view.getPricingInformationData()
							.getAnniversaryContractAmount()
							+ "";
			%>

			<td width="188"><oppt:text name="anniversaryContractAmount"
				styleId="anniversaryContractAmount" styleClass="iform" size="12"
				value="<%=value %>" maxlength="12" /></td>
			<td width="12">&nbsp;</td>

			<td width="150"><label for="ssAnniversaryContractAmount"><oppt:label
				label="S&S Anniversary contract amount:"
				id="ssAnniversaryContractAmount" errorLables="<%=errorValues%>" /></label></td>
			<%
				value = view.getPricingInformationData()
							.getSsAnninversaryContractAmount()
							+ "";
			%>

			<td width="188"><oppt:text name="ssAnniversaryContractAmount"
				styleId="ssAnniversaryContractAmount" styleClass="iform" size="12"
				value="<%=value %>" maxlength="12" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="detailedInvoice"><oppt:label
				label="Detailed invoice:" id="detailedInvoice"
				errorLables="<%=errorValues%>" /></label></td>

			<td width="188">
			<table cellpadding="0" cellspacing="0" border="0"
				summary="pricingInformation">
				<tr>
					<td width="80"><oppt:checkbox
						name="pricingInformation.detailedInvoice"
						styleId="detailedInvoice"
						checked="<%=view.getPricingInformationData().isDetailedInvoice() %>"
						style="iform" />&nbsp;</td>
					<td width="50"><label for="gsaInd">&nbsp;&nbsp;<oppt:label
						label="GSA:" id="gsaInd" errorLables="<%=errorValues%>" /></label></td>
					<td width="50"><oppt:checkbox name="pricingInformation.gsa"
						styleId="gsaInd"
						checked="<%=view.getPricingInformationData().isGsa() %>"
						style="iform" /></td>
				</tr>
			</table>

			</td>
			<td width="12">&nbsp;</td>

			<td width="150"><label for="billingBlock"><oppt:label
				label="Billing block:" id="billingBlock"
				errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:select
				name="pricingInformation.billingBlock" id="billingBlock"
				selectedOption="<%=view.getPricingInformationData().getBillingBlock() %>"
				options="<%=view.getBillingBlockOptions() %>"
				title="Select billing block" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="deviatingDateRule"><oppt:label
				label="Deviating date rule:" id="deviatingDateRule"
				errorLables="<%=errorValues%>" /></label></td>
			<td width="480" colspan="4"><oppt:select
				name="pricingInformation.deviatingDateRule" id="deviatingDateRule"
				selectedOption="<%=view.getPricingInformationData().getDeviatingDateRule() %>"
				options="<%=view.getBillingDateRuleOptions() %>"
				title="Select deviating date role" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="billingDateRule"><oppt:label
				label="Billing date rule:" id="billingDateRule"
				errorLables="<%=errorValues%>" /></label></td>
			<td width="480" colspan="4"><oppt:select
				name="pricingInformation.billingDateRule" id="billingDateRule"
				selectedOption="<%=view.getPricingInformationData().getBillingDateRule() %>"
				options="<%=view.getBillingDateRuleOptions() %>"
				title="Select billing date role" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="freeTextForInvoicePrint"><oppt:label
				label="Free text for invoice print:" id="freeTextForInvoicePrint"
				errorLables="<%=errorValues%>" /></label></td>
			<td width="480" colspan="4"><html:textarea
				property="pricingInformation.freeTextForInvoicePrint" rows="2"
				styleId="freeTextForInvoicePrint"
				value="<%=view.getPricingInformationData().getFreeTextForInvoicePrint() %>"
				cols="44" styleClass="iform"></html:textarea></td>
		</tr>
	</table>
&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Purchase order data">
		<tr>
			<th height="18" colspan="6">&nbsp;&nbsp;Purchase order data</th>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="poNumber"><oppt:label
				label="P.O. number:" id="poNumber" errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:text
				name="secondaryProposalData.purchaseOrderNumber" styleId="poNumber"
				value="<%=view.getSecondaryProposalData().getPurchaseOrderNumber() %>"
				size="8" maxlength="35" styleClass="iform" /></td>
			<td width="12">&nbsp;</td>

			<td width="150"><label for="purchaseOrderDate"><oppt:label
				label="P.O. date:" id="poDate" errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:dateOptions name="purchaseOrderDate"
				alt="Purchase order date"
				date="<%=view.getSecondaryProposalData().getPurchaseOrderDate() %>"
				years="<%=endYearsList %>" /></td>
		</tr>
	</table>
&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Payment Terms Details">
		<tr>
			<th height="18" colspan="6">&nbsp;&nbsp;Payment terms</th>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="addValueDays"><oppt:label
				label="Add value days:" id="addValueDays"
				errorLables="<%=errorValues%>" /></label></td>
			<%
				value = view.getSecondaryProposalData().getAddValueDays() + "";
			%>

			<td width="188"><oppt:text
				name="secondaryProposalData.addValueDays" styleId="addValueDays"
				size="2" value="<%=value %>" maxlength="2" styleClass="iform" /></td>
			<td width="12">&nbsp;</td>

			<td width="150"><label for="fixedValueDate"><oppt:label
				label="Fixed val. date:" id="fixedValueDate"
				errorLables="<%=errorValues%>" /></label></td>

			<td width="188"><oppt:dateOptions name="fixedValueDate"
				alt="Fixed value date"
				date="<%=view.getSecondaryProposalData().getFixedValDate() %>"
				years="<%=startYearsList %>" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="paymentTerms"><oppt:label
				label="Payment terms:" id="paymentTerms"
				errorLables="<%=errorValues%>" /></label></td>
			<td width="480" colspan="4"><oppt:select
				name="secondaryProposalData.paymentTerms" id="paymentTerms"
				selectedOption="<%=view.getSecondaryProposalData().getPaymentTerms() %>"
				options="<%=view.getPaymentTermsOptions() %>"
				title="Select payment terms" /></td>
		</tr>
	</table>
&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Variance">
		<tr>
			<th height="18" colspan="5">&nbsp;&nbsp;Variance</th>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="capAmount"><oppt:label
				label="CAP amount:" id="capAmount" errorLables="<%=errorValues%>" /></label></td>
			<%
				value = view.getVarianceData().getCapAmount() + "";
			%>

			<td width="188"><oppt:text name="varianceData.capAmount"
				styleId="capAmount" value="<%=value %>" size="9" maxlength="12"
				styleClass="iform" /></td>
			<%
				value = view.getVarianceData().getCapPlus() + "";
			%>
			<td width="150" nowrap><label for="capMinus">&nbsp;- </label> <oppt:text
				name="varianceData.capMinus" styleId="capMinus" size="5"
				maxlength="5" value="<%=value %>" styleClass="iform" /> %</td>
			<%
				value = view.getVarianceData().getCapMinus() + "";
			%>

			<td width="188" nowrap><label for="capPlus">+ </label> <oppt:text
				name="varianceData.capPlus" styleId="capPlus" size="5" maxlength="5"
				value="<%=value %>" styleClass="iform" /> %</td>
		</tr>
	</table>
&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Financing data">
		<tr>
			<th height="18" colspan="3">&nbsp;&nbsp;Financing data</th>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>

			<td width="150"><label for="igfOfferNumber"><oppt:label
				label="CAL #:" id="igfOfferNumber" errorLables="<%=errorValues%>" /></label></td>

			<td width="550"><oppt:text
				name="secondaryProposalData.igfOfferNumber" size="15"
				styleId="igfOfferNumber" maxlength="30"
				value="<%=view.getSecondaryProposalData().getIgfOfferNumber() %>"
				styleClass="iform" /></td>
		</tr>
	</table>
&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="700"
		summary="Comments">
		<tr>
			<td height="18" colspan="2"><label for="strComnts">&nbsp;&nbsp;Comments</label></td>
		</tr>
		<tr>
			<td width="12" height="50">&nbsp;</td>
			<td width="150">Comments:</td>

			<td width="550"><html:textarea rows="2"
				property="secondaryProposalData.comments" styleId="comments"
				value="<%=view.getSecondaryProposalData().getComments() %>"
				cols="44" styleClass="iform">&nbsp;</html:textarea></td>
		</tr>
	</table>
&nbsp;<br />
	<table align="right" border="0" cellspacing="0" role="presentation">
		<tr>
			<td><oppt:button id="save" name="multipleButtonManager.save"
				alt="Save" value="Save" primary="true"
				buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button id="clearAll"
				name="multipleButtonManager.clearAll" alt="Clear all"
				value="Clear all" primary="true" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button id="cancel" name="multipleButtonManager.cancel"
				alt="Cancel" value="Cancel" primary="true"
				buttonFlags="<%=buttonFlags %>" /></td>
		</tr>
	</table>
</html:form> <!-- start content head -->
<div id="ibm-content-head"></div>
<!-- stop content head -->


<div id="ibm-content-main">
<div style="position: absolute; top: 0; right: 10px;">
<p class="ibm-ind-link"><a href="javascript:getFormHelp()"
	title="Page help" class="ibm-popup-link">Page Help</a></p>
</div>
</div>

</div>

<script language="JavaScript" type="text/javascript" >

window.onload = function() {
		var hiddenElements = document.getElementsByName("validationErrorElements");
		//read the identifier of the error fields, from the hiddenElements 
		//and set the aria-invalid attribute for those ids
		var hiddenElement = null;
		var dayElem = null;
		var monthElem = null;
		var yearElem = null;
		for(var x=0; x<hiddenElements.length; x++){
			
			//check if the hiddenElements are one of the special fields and 
			//override the target field

			console.log("before "+hiddenElements[x].value);
			//console.log("before "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
			console.log("the value is"+hiddenElements[x].value);
			switch (hiddenElements[x].value)
			{	
				
				case  "contractStartDate":
					dayElem = document.getElementById("contractStartDateDay");
					monthElem = document.getElementById("contractStartDateMonth");
					yearElem = document.getElementById("contractStartDateYear");

					if (dayElem && dayElem.options.selectedIndex == 0) {
					//console.log("Cs1");
						dayElem.setAttribute("aria-invalid","true");
					}  if (monthElem && monthElem.options.selectedIndex == 0) {
					//console.log("Cs2");
						monthElem.setAttribute("aria-invalid","true");
					} if (yearElem && yearElem.options.selectedIndex == 0) {
					//console.log("Cs3");
						yearElem.setAttribute("aria-invalid","true");
					}
					break;
				
				case "contractEndDate":
				dayElem = document.getElementById("contractEndDateDay");
					monthElem = document.getElementById("contractEndDateMonth");
					yearElem = document.getElementById("contractEndDateYear");

					if (dayElem && dayElem.options.selectedIndex == 0) {
					//console.log("Cs4");
						dayElem.setAttribute("aria-invalid","true");
						}
					  if (monthElem && monthElem.options.selectedIndex == 0) {
					//console.log("Cs5");
						monthElem.setAttribute("aria-invalid","true");
						}
					 	 if (yearElem && yearElem.options.selectedIndex == 0) {
					//console.log("Cs6");
						yearElem.setAttribute("aria-invalid","true");
						}
					
					break;
				case "contractPeriodBeginning":
				dayElem = document.getElementById("contractPeriodStartDateDay");
					monthElem = document.getElementById("contractPeriodStartDateMonth");
					yearElem = document.getElementById("contractPeriodStartDateYear");

					if (dayElem && dayElem.options.selectedIndex == 0) {
				//	console.log("Cs7");
						dayElem.setAttribute("aria-invalid","true");
					} if (monthElem && monthElem.options.selectedIndex == 0) {
					//console.log("Cs8");
						monthElem.setAttribute("aria-invalid","true");
					} if (yearElem && yearElem.options.selectedIndex == 0) {
					//console.log("Cs9");
						yearElem.setAttribute("aria-invalid","true");
					}
					break;
				case "contractPeriodEnding":
				dayElem = document.getElementById("contractPeriodEndDateDay");
					monthElem = document.getElementById("contractPeriodEndDateMonth");
					yearElem = document.getElementById("contractPeriodEndDateYear");

					if (dayElem && dayElem.options.selectedIndex == 0) {
					//console.log("Cs10");
						dayElem.setAttribute("aria-invalid","true");
					}  if (monthElem && monthElem.options.selectedIndex == 0) {
					//console.log("Cs11");
						monthElem.setAttribute("aria-invalid","true");
					}  if (yearElem && yearElem.options.selectedIndex == 0) {
					//console.log("Cs12");
						yearElem.setAttribute("aria-invalid","true");
					}
					break;
				//add case statements here to cover additional fields having this issue

				default:
					hiddenElement = document.getElementById(hiddenElements[x].value)
					if (hiddenElement) {
						hiddenElement.setAttribute("aria-invalid","true");
					}
					break;

		}	
			//if (hiddenElement){hiddenElement.setAttribute("aria-invalid","true")};
		//	console.log("after "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
		}
	}



</script>



