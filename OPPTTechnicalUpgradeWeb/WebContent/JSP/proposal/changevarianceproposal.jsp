
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHeaderDetailsViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm" %>
<%@ page import="java.util.*" %>
<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	ProposalHeaderDetailsViewBean view = (ProposalHeaderDetailsViewBean)opptSession.getCurrentViewBean();
	if (null == view) {
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList startYearsList = view.getStartYears();
	ArrayList endYearsList = view.getEndYears();
	ArrayList buttonFlags = view.getButtonFlags();
	ProposalHeaderActionForm actionForm = view.getChangeProposalActionForm();
	TreeMap specialBillingIndicator = new TreeMap();
			specialBillingIndicator.put("F", "FIA process"); 
			specialBillingIndicator.put("P", "Pre-bill/BRE process");  
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Change proposal</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
								
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />		
				
						<p>Use this form to change the header data for this proposal. When you
						are finished, click the Save button. Press the Clear all button to
						discard your changes. Press the cancel button to terminate change proposal.</p>
				
						<p>Required fields are marked with an asterisk (<strong>&nbsp;*&nbsp;</strong>)
						and must be filled in to complete the form.</p>
					</td>
				</tr>
				<tr>
					<td class="bar-gray-dark">Proposal name : <%=view.getProposalNameTypeString() %></td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/ChangeProposalHeaderMultipleAction.wss" method="post">

<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Sales area">
	<tr>
		<th height="18" colspan="6">&nbsp;&nbsp;Sales area</th>
	</tr>
	<tr>
		<td width="12" height="20">&nbsp;</td>
		<td width="140"><label >Sales organization</label></td>
		<td width="148"><input type="hidden" name="basicProposalData.salesOrganization" id="salesOrganization" value="<%=view.getBasicProposalData().getSalesOrganization()+"|"+view.getBasicProposalData().getCurrencyCode() %>" /><oppt:label label="<%=view.getSalesOrgString() %>" /></td>
		<td width="12">&nbsp;
			<input type="hidden" name="varianceProposal" value="true" />
			<input type="hidden" name="proposalStatus" value="<%=actionForm.getProposalStatus() %>" />
			<input type="hidden" name="basicProposalData.proposalContent" value="<%=actionForm.getBasicProposalData().getProposalContent() %>" />
			<input type="hidden" name="basicProposalData.reportName" value="<%=actionForm.getBasicProposalData().getReportName() %>" />
			<input type="hidden" name="pricingInformation.plannedGrowthOption" value="<%=actionForm.getPricingInformation().getPlannedGrowthOption() %>" />
			<input type="hidden" name="pricingInformation.plannedGrowthValue" value="<%=actionForm.getPricingInformation().getPlannedGrowthValue() %>" />
			<input type="hidden" name="pricingInformation.billingFrequency" value="<%=actionForm.getPricingInformation().getBillingFrequency() %>" />
			<input type="hidden" name="pricingInformation.growthLimitOption" value="<%=actionForm.getPricingInformation().getGrowthLimitOption() %>"  />
			<input type="hidden" name="pricingInformation.growthLimitValue" value="<%=actionForm.getPricingInformation().getGrowthLimitValue() %>" />
			<input type="hidden" name="pricingInformation.advance" value="<%=String.valueOf(actionForm.getPricingInformation().isAdvance()) %>" />
			<input type="hidden" name="pricingInformation.tvmRate" value="<%=actionForm.getPricingInformation().getTvmRate() %>" />
			<input type="hidden" name="pricingInformation.discount" value="<%=actionForm.getPricingInformation().getDiscount() %>" />
			<input type="hidden" name="pricingInformation.anniversaryContractAmount" value="<%=String.valueOf(actionForm.getPricingInformation().getAnniversaryContractAmount()) %>" />
			<input type="hidden" name="pricingInformation.ssAnninversaryContractAmount" value="<%=String.valueOf(actionForm.getPricingInformation().getSsAnninversaryContractAmount()) %>" />
			<input type="hidden" name="pricingInformation.detailedInvoice" value="<%=String.valueOf(actionForm.getPricingInformation().isDetailedInvoice()) %>" />
			<input type="hidden" name="pricingInformation.deviatingDateRule" value="<%=actionForm.getPricingInformation().getDeviatingDateRule() %>" />
			<input type="hidden" name="pricingInformation.billingDateRule" value="<%=actionForm.getPricingInformation().getBillingDateRule() %>" />
			<input type="hidden" name="varianceData.capMinus" value="<%=actionForm.getCapPlus() %>" />
			<input type="hidden" name="varianceData.capPlus" value="<%=actionForm.getCapMinus() %>" />
		</td>
		<td width="140">Distribution channel</td>
		<td width="148"><input type="hidden" name="basicProposalData.distributionChannel" value="<%=view.getBasicProposalData().getDistributionChannel() %>" /><oppt:label label="<%=view.getDistributionChannelString() %>" /></td>
	</tr>
	<tr>
		<td width="12" height="20">&nbsp;</td>
		<td width="140">Division</td>
		<td width="148"><input type="hidden" name="basicProposalData.division" value="<%=view.getBasicProposalData().getDivision() %>" /><oppt:label label="<%=view.getDivisionString() %>" /></td>
		<td width="12">&nbsp;</td>
		<td width="140">Currency code</td>
		<td width="148"><input type="hidden" name="basicProposalData.currencyCode" value="<%=view.getBasicProposalData().getCurrencyCode() %>" /><oppt:label label="<%=view.getCurrencyCodeString() %>" /></td>
	</tr>
</table>
&nbsp;<br />
<!-- BH Wave1 -DAD003 - Complex Contract Identifiers - Begin - Manoj -->
<table cellpadding="0" cellspacing="0" border="0" width="700" summary="Complex Contract Identifiers">
  <tr>
			<th height="18" colspan="6" style=background-color:#cccccc; class="bar-blue-med">Complex Contract Identifiers</th>
		</tr>
		<tr>
			<td height="2" colspan="6">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" valign="middle" height="30"></td>
			
    <td width="150" height="30"><label for="complexContractID"><oppt:label label="&nbsp;&nbsp;&nbsp;CPS&nbsp;id:" id="complexContractID" errorLables="<%=errorValues%>" /></label></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.cpsID" styleClass="iform" styleId="complexContractID" value="<%=actionForm.getBasicProposalData().getCpsID() %>" maxlength="15" title = "Enter the CPS ID"/></td>

    <td width="150"><label for="complexContractType"><oppt:label label="Original&nbsp;CPS id:" id="complexContractType" errorLables="<%=errorValues%>" /></label></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.ocpsID" styleClass="iform" styleId="complexContractType" style="background:lightgrey;" value="<%=actionForm.getBasicProposalData().getOcpsID() %>" maxlength="25" title="Enter the OCPS ID" readonly="true" />
			</td>    
    		</tr>
		<tr>
			<td width="16" height="30"></td>
			
     <td width="150"><oppt:label label="&nbsp;&nbsp;&nbsp;Contract&nbsp;type:" id="masterContractType" errorLables="<%=errorValues%>" /></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.contractType" styleClass="iform" styleId="masterContractType" style="background:lightgrey;" value="<%=actionForm.getBasicProposalData().getContractType() %>" maxlength="4" title="Enter the contract type" readonly="true" />
			</td>

    <td width="150"><label for="masterContractType"><oppt:label label="BLB&nbsp;indicator:"  id="masterContractType" errorLables="<%=errorValues%>" /></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.contractType" styleClass="iform" styleId="masterContractType1" style="background:lightgrey;" value="<%=actionForm.getBasicProposalData().getBlbIndicator() %>" maxlength="4" title="Enter BLB Indicator" readonly="true" />
			</td>
		</tr>	
	</table>
	&nbsp;<br />
<!-- BH Wave1 -DAD003 - Complex Contract Identifiers - End - Manoj -->
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Basic proposal data">
	<tr>
		<th height="18" colspan="6">&nbsp;&nbsp;Basic proposal data</th>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="140"><label >Proposal name</label></td>
		<td width="148"><oppt:text name="basicProposalData.proposalName" styleId="proposalName" wordLength="16" value="<%=view.getBasicProposalData().getProposalName() %>" nonEditableFields="<%=view.getNonEditableFields() %>" maxlength="40" /></td>
		<td width="12">&nbsp;</td>
		<td width="140"><label >Proposal type</label></td>
		<td width="148"><oppt:text name="basicProposalData.proposalType" styleId="proposalType" value="<%=view.getBasicProposalData().getProposalType() %>" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="140"><label >External contract number</label></td>
		<td width="148"><oppt:text name="basicProposalData.externalContractNumber" styleId="externalContractNumber" value="<%=actionForm.getBasicProposalData().getExternalContractNumber() %>" maxlength="10" size="10" styleClass="iform" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
		<td width="12">&nbsp;</td>
		<td width="140"><label >Contract number</label></td>
		<td width="148"><oppt:label label="<%=view.getContractNumber() %>" /></td>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="140">Contract type</td>
		<td width="148"><oppt:label label="<%=view.getContractTypeString() %>" /></td>
		<td width="12">&nbsp;</td>
		<td width="140">&nbsp;</td>
		<td width="148">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Contract dates">
	<tr>
		<th height="18" colspan="6">&nbsp;&nbsp;Contract dates</th>
	</tr>
	<tr>
		<td width="12" height="30"></td>
		<td width="108"><label ><span class="ibm-required">*</span>Contract start date</label></td>
		<td width="180"><oppt:dateOptions name="contractStartDate" date="<%=actionForm.getContractStartDate().getDate() %>" years="<%=view.getStartYears() %>"  alt="Contract start date" nonEditableFields="<%=view.getNonEditableFields() %>" onchange="populateDate" dateType="1" mandatory="true" /></td>
		<td width="12"></td>
		<td width="108"><label><span class="ibm-required">*</span>Contract end date</label></td>
		<td width="180"><oppt:dateOptions name="contractEndDate" date="<%=actionForm.getContractEndDate().getDate() %>" years="<%=view.getEndYears() %>"  alt="Contract end date" nonEditableFields="<%=view.getNonEditableFields() %>" onchange="populateDate" dateType="2" mandatory="true" /></td>
	</tr>
	<tr>
		<td width="12"></td>
		<td width="108"><label><span class="ibm-required">*</span>Contract period beginning&nbsp;</label></td>
		<td width="180"><oppt:dateOptions name="contractPeriodStartDate" date="<%=actionForm.getContractPeriodStartDate().getDate() %>" years="<%=view.getStartYears() %>"  alt="Contract period beginning" nonEditableFields="<%=view.getNonEditableFields() %>" onchange="populateDate" dateType="3"  mandatory="true"/></td>
		<td width="12"></td>
		<td width="108"><label ><span class="ibm-required">*</span>Contract period ending</label></td>
		<td width="180"><oppt:dateOptions name="contractPeriodEndDate" date="<%=actionForm.getContractPeriodEndDate().getDate() %>" years="<%=view.getEndYears() %>"  alt="Contract period ending" nonEditableFields="<%=view.getNonEditableFields() %>" onchange="populateDate" dateType="4" mandatory="true" /></td>
	</tr>
</table>
&nbsp;<br />
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Pricing information">
	<tr>
		<th height="18" colspan="6">&nbsp;&nbsp;Pricing information</th>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="108"><label ><oppt:label label="Variance date" id="varianceDate" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:dateOptions name="varianceDate" date="<%=actionForm.getVarianceDate().getDate() %>" years="<%=view.getEndYears() %>" alt="Variance date" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
		<td width="12" height="30">&nbsp;</td>
		<td width="108"><label for="pakid"><oppt:label label="PAKID" id="pakid" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:text name="pricingInformation.pakid" styleClass="iform" styleId="pakid" size="7" value="<%=actionForm.getPricingInformation().getPakid() %>" maxlength="7" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="108"><label ><oppt:label label="CAP amount" id="capAmount" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:text name="varianceData.capAmount" styleId="capAmount" styleClass="iform" size="9" maxlength="12" value="<%=actionForm.getCapAmount() %>" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
		<td width="12"></td>
		<td width="108"><label for="exceedingAmount" ><span class="ibm-required">*</span><oppt:label label="Exceeding amount" id="exceedingAmount" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:text name="pricingInformation.exceedingAmount" styleId="exceedingAmount" styleClass="iform" size="12" maxlength="12" value="<%=actionForm.getPricingInformation().getExceedingAmount() %>" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="108"><label for="gsaInd"><oppt:label label="GSA" id="GSA" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:checkbox name="pricingInformation.gsa" styleId="gsaInd" checked="<%=actionForm.getPricingInformation().isGsa() %>" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
		<td width="12">&nbsp;</td>
		<td width="108"><label for="invoiceSuppression"><oppt:label label="Invoice suppression" id="invoiceSuppression" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:checkbox name="pricingInformation.invoiceSuppression" styleId="invoiceSuppression" checked="<%=actionForm.getPricingInformation().isInvoiceSuppression() %>" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
	</tr>
	<tr>
		<td width="12">&nbsp;</td>
		<td width="108"><label for="billingBlock"><oppt:label label="Billing block" id="billingBlock" errorLables="<%=errorValues%>" /></label></td>
		<td width="480" colspan="4"><oppt:select name="pricingInformation.billingBlock" id="billingBlock" selectedOption="<%=actionForm.getPricingInformation().getBillingBlock() %>" options="<%=view.getBillingBlockOptions() %>" nonEditableFields="<%=view.getNonEditableFields() %>"  title="Select billing block" /></td>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="100"><label for="freeTextForInvoicePrint"><oppt:label label="Free text for invoice print" id="freeTextForInvoicePrint" errorLables="<%=errorValues%>" /></label></td>
		<td width="480" colspan="4"><html:textarea property="pricingInformation.freeTextForInvoicePrint" rows="2" styleId="freeTextForInvoicePrint" value="<%=actionForm.getPricingInformation().getFreeTextForInvoicePrint() %>" cols="44" styleClass="iform"></html:textarea></td>
	</tr>
</table>
&nbsp;<br />
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Purchase order data">
	<tr>
		<th height="18" colspan="6">&nbsp;&nbsp;Purchase order data</th>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="108"><label for="poNumber"><oppt:label label="P.O. number" id="poNumber" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:text name="secondaryProposalData.purchaseOrderNumber" styleId="poNumber" value="<%=actionForm.getSecondaryProposalData().getPurchaseOrderNumber() %>" size="8" maxlength="35" styleClass="iform" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
		<td width="12">&nbsp;</td>
		<td width="108"><label for="purchaseOrderDateYear"><oppt:label label="P.O. date" id="poDate" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:dateOptions name="purchaseOrderDate" alt="Purchase order date" date="<%=actionForm.getSecondaryProposalData().getPurchaseOrderDate() %>" years="<%=endYearsList %>" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
	</tr>
</table>
&nbsp;<br />
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Payment terms">
	<tr>
		<th height="18" colspan="6">&nbsp;&nbsp;Payment terms</th>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="108"><label for="addValueDays"><oppt:label label="Add value days" id="addValueDays" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:text name="secondaryProposalData.addValueDays" styleId="addValueDays" size="2" value="<%=String.valueOf(actionForm.getSecondaryProposalData().getAddValueDays()) %>" maxlength="2" styleClass="iform" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
		<td width="12">&nbsp;</td>
		<td width="108"><label for="fixedValueDateYear"><oppt:label label="Fixed val. date" id="fixedValueDate" errorLables="<%=errorValues%>" /></label></td>
		<td width="180"><oppt:dateOptions name="fixedValueDate" alt="Fixed value date" date="<%=actionForm.getSecondaryProposalData().getFixedValDate() %>" years="<%=startYearsList %>" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="108"><label for="paymentTerms"><oppt:label label="Payment terms" id="paymentTerms" errorLables="<%=errorValues%>" /></label></td>
		<td width="480" colspan="4"><oppt:select name="secondaryProposalData.paymentTerms" id="paymentTerms" selectedOption="<%=actionForm.getSecondaryProposalData().getPaymentTerms() %>" options="<%=view.getPaymentTermsOptions() %>" nonEditableFields="<%=view.getNonEditableFields() %>"  title="Select payment terms" /></td>
	</tr>
</table>
&nbsp;<br />
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Financing data">
	<tr>
		<th height="18" colspan="5">&nbsp;&nbsp;Financing data</th>
	</tr>
	<tr>
		<td width="12" height="30">&nbsp;</td>
		<td width="108"><label for="igfOfferNumber"><oppt:label label="CAL #" id="igfOfferNumber" errorLables="<%=errorValues%>" /></label></td>
		<td width="480"><oppt:text name="secondaryProposalData.igfOfferNumber" size="15" styleId="igfOfferNumber" maxlength="30" value="<%=actionForm.getSecondaryProposalData().getIgfOfferNumber() %>" styleClass="iform" nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
		<!-- BH Wave1 - Manoj - DAD003 -Begin -->
     <td width="150"><label for="preBillIndicator"><oppt:label label="Special&nbsp;billing&nbsp;indicator:" id="preBillIndicator" errorLables="<%=errorValues%>" /></label></td>
	<td width="188"><oppt:select selectedOption="<%=actionForm.getPricingInformation().isPrebillIndicator() %>" 
   			name="pricingInformation.prebillIndicator" id="prebillIndicator" options="<%=specialBillingIndicator%>"  title="Select Special Billing Indicator" />
	    <!-- BH Wave1 -DAD003 - Complex Contract Identifiers - End - Manoj -->
	</tr>
</table>
&nbsp;<br />
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Comments">
	<tr>
		<th height="18" colspan="2"><label >&nbsp;&nbsp;Comments</label></th>
	</tr>
	<tr>
		<td width="12" height="50">&nbsp;</td>
		<td width="588"><html:textarea rows="2" property="secondaryProposalData.comments" styleId="comments" title="comments " value="<%=actionForm.getSecondaryProposalData().getComments() %>" cols="44" styleClass="iform">&nbsp;</html:textarea></td>
	</tr>
</table>
&nbsp;<br />
<table border="0" cellspacing="0" role="presentation" align="right">
	<tr>
		<td><oppt:button id="save" name="multipleButtonManager.save" alt="Save" primary="true" value="Save" buttonFlags="<%=buttonFlags %>" /></td>
		<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" primary="true" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
		<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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


<script type="text/javascript">
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



