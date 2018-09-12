
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CreateProposalViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	CreateProposalViewBean view = (CreateProposalViewBean) opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = view.getButtonFlags();
	ArrayList startYearsList = view.getStartYears();
	ArrayList endYearsList = view.getEndYears();
	ProposalHeaderActionForm actionForm = view.getCreateProposalActionForm();
    TreeMap specialBillingIndicator = new TreeMap();
			specialBillingIndicator.put("F", "FIA process"); 
			specialBillingIndicator.put("P", "Pre-bill/BRE process");  
			%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal creation</h1>		
		</div>
	</div>	

<div id="ibm-content-body">
	

<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="650" >
	<tr valign="top">
		<td width="650">
			
      <table width="700" role="presentation">
        		
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to input the Proposal header data. When you are
						finished, click the Continue button. Press the Clear all button to
						discard your input. Press the Cancel button to go back to proposal 
						maintenance page.</p>
						
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
<html:form action="/protect/CreateProposalMultipleAction.wss" method="post">
	
<table cellpadding="0" cellspacing="0" border="0" width="700"   summary="Sales area&Currency Details">
  <tr >
			<th height="18" colspan="3" scope="col"  style="background-color:#cccccc;" >Sales area &amp; currency</th>
		</tr>
		
		<table cellpadding="0" cellspacing="0" border="0" width="700"  height="2" summary="presentation">
		<tr>
			<th height="2" colspan="3" scope="col" >&nbsp;</th>
			</tr>
		
		<tr>
			<td width="12" valign="middle" height="30"></td>
			
    <td width="150" height="30"><label for="salesOrganization" ><span class="ibm-required">*</span><oppt:label label="Sales&nbsp;organization:" id="salesOrganization" errorLables="<%=errorValues%>" /></label></td>
			<td width="533"><oppt:select onclick="populateCurrency()" options="<%=view.getSalesOrganizationOptions() %>" selectedOption="<%=actionForm.getBasicProposalData().getSalesOrganization()%>" name="basicProposalData.salesOrganization" id="salesOrganization"  reverse="true" title="Select sales organization" /></td>
		</tr>
		<tr>
			<td width="12" height="30"></td>
			
    <td width="150"><label for="distributionChannel" ><span class="ibm-required">*</span><oppt:label label="Distribution channel:" id="distributionChannel" errorLables="<%=errorValues%>" /></label></td>
			<td width="533"><oppt:select selectedOption="<%=actionForm.getBasicProposalData().getDistributionChannel() %>" name="basicProposalData.distributionChannel" id="distributionChannel" options="<%=view.getDistributionChannelOptions() %>" reverse="true" title="Select distribution channel" /></td>
		</tr>
		<tr>
			<td width="12" height="30"></td>
			
    <td width="150"><label for="divisions" ><span class="ibm-required">*</span><oppt:label label="Divisions:" id="divisions" errorLables="<%=errorValues%>" /></label></td>
			<td width="533"><oppt:select selectedOption="<%=actionForm.getBasicProposalData().getDivision() %>" name="basicProposalData.division" id="divisions" options="<%=view.getDivisionOptions() %>"  title="Select division" /></td>
		</tr>
		<tr>
			<td width="12" height="30"></td>
			
    <td width="150"><label for="currencyCode" ><span class="ibm-required">*</span><oppt:label label="Currency code:" id="currencyCode" errorLables="<%=errorValues%>" /></label></td>
			<td width="533"><oppt:select selectedOption="<%=actionForm.getBasicProposalData().getCurrencyCode() %>" name="basicProposalData.currencyCode" id="currencyCode" options="<%=view.getCurrencyCodeOptions() %>" title="Select currency code" /></td>
		</tr>
	</table>
	&nbsp;<br />
<!-- BH Wave1 -DAD003 - Complex Contract Identifiers - Begin - Manoj -->
<table cellpadding="0" cellspacing="0" border="0" width="700" summary="Complex Contract Identifiers">
  <tr >
			<th height="18" colspan="6"  style="background-color:#cccccc;" scope="col" >Complex Contract Identifiers</th>
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
			
     <td width="150"><label for="masterContractType"><oppt:label label="&nbsp;&nbsp;&nbsp;Contract&nbsp;type:" id="masterContractType" errorLables="<%=errorValues%>" /></label></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.contractType" styleClass="iform" styleId="masterContractType" style="background:lightgrey;" value="<%=actionForm.getBasicProposalData().getContractType() %>" maxlength="4" title="Enter the contract type" readonly="true" />
			</td>

    <td width="150"><label><oppt:label label="BLB&nbsp;indicator:" id="masterContractType1" errorLables="<%=errorValues%>" /></label></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.contractType" styleClass="iform" styleId="masterContractType1" style="background:lightgrey;" value="<%=actionForm.getBasicProposalData().getBlbIndicator() %>" maxlength="4" title="Enter BLB Indicator" readonly="true" />
			</td>
		</tr>	
	</table>
	&nbsp;<br />
<!-- BH Wave1 -DAD003 - Complex Contract Identifiers - End - Manoj -->

<table cellpadding="0" cellspacing="0" border="0" width="700" summary="Basic Proposal Details">
  <tr>
			<th height="18" colspan="6" style="background-color:#cccccc;" scope="col" >Basic proposal data</th>
		</tr>
		<tr>
			<td height="2" colspan="6" scope="col" >&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="30"></td>
			
    <td width="150"><label for="proposalName"><strong>&nbsp;</strong><oppt:label label="Proposal name:" id="proposalName" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:text name="basicProposalData.proposalName" styleClass="iform" styleId="proposalName" value="<%=actionForm.getBasicProposalData().getProposalName() %>" maxlength="40" title = "Enter the proposal name"/></td>
	<td width="12"></td>
			
    <td width="150"><label for="proposalType" ><span class="ibm-required">*</span><oppt:label label="Proposal type:" id="proposalType" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188">

    
    <% if(view.getNonEditableFields()!=null && view.getNonEditableFields().contains("contractStartDate")) {%> 
        <oppt:select selectedOption="<%=actionForm.getBasicProposalData().getProposalType() %>" name="basicProposalData.proposalType" id="proposalType" proposalTypeOptions="<%=view.getProposalTypeOptions() %>" nonEditableFields="<%=view.getNonEditableFields() %>"  reverse="true"  onclick="setProposalContent()"    title = "Select proposal type"  dependent = "<%=actionForm.getBasicProposalData().getProposalContentDescription() %>"/>
      <% } else {%> 
           <oppt:select selectedOption="<%=actionForm.getBasicProposalData().getProposalType() %>" name="basicProposalData.proposalType" id="proposalType"  proposalTypeOptions="<%=view.getProposalTypeOptions() %>" nonEditableFields="<%=view.getNonEditableFields() %>" onclick="changeOnProposalType()"  reverse="true"   title = "Select proposal type"  dependent = "<%=actionForm.getBasicProposalData().getProposalContentDescription() %>"/>
   <% } %>
   

		</tr>
		
		<tr> 
			<td width="12" height="30">&nbsp;</td>
			
						
    <td width="150"><label for="reportName"><oppt:label label="&nbsp;Report name:" id="reportName" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:text name="basicProposalData.reportName" styleClass="iform" styleId="reportName" value="<%=actionForm.getBasicProposalData().getReportName() %>" maxlength="40" title = "Enter the report name"/></td>
			
	<td width="12"height="30">&nbsp;</td> 
			
    <td width="150"><label for="externalContractNumber"><oppt:label label="External&nbsp;contract number:" id="externalContractNumber" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:text name="basicProposalData.externalContractNumber" styleClass="iform" styleId="externalContractNumber" value="<%=actionForm.getBasicProposalData().getExternalContractNumber() %>" maxlength="10" title = "Enter the external contract number"/></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
	  		

   <!-- Added By Srinivas-OPPT BH -DAD001 -->
  
  <td width="150"><label for="proposalContent"><oppt:label label="&nbsp;Proposal&nbsp;content:" id="proposalContent" errorLables="<%=errorValues%>"/></label></td>
   
   <td width ="188"> <oppt:text name ="basicProposalData.proposalContent" styleClass="iform" styleId="proposalContent"  value="<%=actionForm.getBasicProposalData().getProposalContentDescription() %>" readonly="true"  title= "proposal content"/>
   
    
    <td width="150">&nbsp;</td>  
			
    <td width="188">&nbsp; 
      <%
				if(null != actionForm.getBasicProposalData().getReplacementContractNumber()){
			%>
      <input type="hidden" id="replacementContractNumber" name="basicProposalData.replacementContractNumber" value="<%=actionForm.getBasicProposalData().getReplacementContractNumber() %>" />
			<%
				}
				else{
			%>
				<input type="hidden" id="replacementContractNumber" name="basicProposalData.replacementContractNumber" value="" />
			<%
				}
			%>
			<%
				if(null != actionForm.getBasicProposalData().getReplacementContractDate()){
			%>
				<input type="hidden" name="replacementDate.day" value="<%=view.getReplacementDay() %>" />
				<input type="hidden" name="replacementDate.month" value="<%=view.getReplacementMonth() %>" />
				<input type="hidden" name="replacementDate.year" value="<%=view.getReplacementYear() %>" />
			<%
				}
			%>
			</td>
		</tr>
	</table>
	&nbsp;<br />
	
<table cellpadding="0" cellspacing="0" border="0" width="700"  summary="Contract Date Details">
  <tr>
			<th height="18" colspan="6" style="background-color:#cccccc;" class="bar-blue-med" scope="col">Contract dates</th>
		</tr>
		<tr>
			<td height="2" colspan="6" scope="col">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="30"></td>
			
    <td width="150"><label ><span class="ibm-required">*</span><oppt:label label="Contract start date:" id="contractStartDate" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:dateOptions day="<%=actionForm.getContractStartDate().getDay() %>" month="<%=actionForm.getContractStartDate().getMonth() %>" year="<%=actionForm.getContractStartDate().getYear() %>" name="contractStartDate" alt="Contract start date" years="<%=startYearsList %>" nonEditableFields="<%=view.getNonEditableFields() %>" onclick="populateDate" dateType="1"  mandatory="true"/></td>
			<td width="12"></td>
			
    <td width="150"><label ><span class="ibm-required">*</span><oppt:label label="Contract end date:" id="contractEndDate" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:dateOptions day="<%=actionForm.getContractEndDate().getDay() %>" month="<%=actionForm.getContractEndDate().getMonth() %>" year="<%=actionForm.getContractEndDate().getYear() %>" name="contractEndDate" alt="Contract end date" years="<%=endYearsList %>" nonEditableFields="<%=view.getNonEditableFields() %>" onchange="populateDate"  dateType="2" mandatory="true" /></td>
		</tr>
		<tr>
			<td width="12"></td>
			
    <td width="150"><label ><span class="ibm-required">*</span><oppt:label label="Contract period beginning:" id="contractPeriodBeginning" errorLables="<%=errorValues%>" />&nbsp;</label></td>
			
    <td width="188"><oppt:dateOptions day="<%=actionForm.getContractPeriodStartDate().getDay() %>" month="<%=actionForm.getContractPeriodStartDate().getMonth() %>" year="<%=actionForm.getContractPeriodStartDate().getYear() %>" name="contractPeriodStartDate" alt="Contract period beginning" years="<%=startYearsList %>" nonEditableFields="<%=view.getNonEditableFields() %>" onchange="populateDate"  dateType="3"  mandatory="true"/></td>
			<td width="12"></td>
			
    <td width="150"><label ><span class="ibm-required">*</span><oppt:label label="Contract period ending:" id="contractPeriodEnding" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:dateOptions day="<%=actionForm.getContractPeriodEndDate().getDay() %>" month="<%=actionForm.getContractPeriodEndDate().getMonth() %>" year="<%=actionForm.getContractPeriodEndDate().getYear() %>" name="contractPeriodEndDate" alt="Contract period ending" years="<%=endYearsList %>" nonEditableFields="<%=view.getNonEditableFields() %>" onchange="populateDate"  dateType="4"  mandatory="true"/></td>
		</tr>
	</table>

	&nbsp;<br />
	
<table cellpadding="0" cellspacing="0" border="0" width="700"  summary="Pricing Details ">
  <tr>
			<th height="18" colspan="7" style="background-color:#cccccc;" scope="col" class="bar-blue-med">Pricing information</th>
		</tr>
		<tr>
			<td height="2" colspan="7" scope="col">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="plannedGrowth"><oppt:label label="Planned growth:" id="plannedGrowth" errorLables="<%=errorValues%>" /></label></td>
    <td width="188"><oppt:select name="pricingInformation.plannedGrowthOption" id="plannedGrowth" selectedOption="<%=actionForm.getPricingInformation().getPlannedGrowthOption() %>" options="<%=view.getPlannedGrowthOptions()%>" />
    <oppt:text name="pricingInformation.plannedGrowthValue" size="6" maxlength="6" styleClass="iform" value="<%=actionForm.getPricingInformation().getPlannedGrowthValue() %>" title = "Planned growth in %" />%</td>
    <td width="12"></td>
    <td width="150"><label for="billingFrequency" ><span class="ibm-required">*</span><oppt:label label="Billing&nbsp;frequency:" id="billingFrequency"	errorLables="<%=errorValues%>" /></label></td>
    <td width="188">
    <oppt:select selectedOption="<%=actionForm.getPricingInformation().getBillingFrequency() %>" name="pricingInformation.billingFrequency" id="billingFrequency" options="<%=view.getBillingFrequencyOptions() %>"  onclick="clearContractDates2()" title = "Select the billing frequency" />
    </td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="growthLimit"><oppt:label label="Growth limit:" id="growthLimit" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:select name="pricingInformation.growthLimitOption" id="growthLimit" selectedOption="<%=actionForm.getPricingInformation().getGrowthLimitOption() %>" options="<%=view.getGrowthLimitOptions() %>" /> 
       <oppt:text name="pricingInformation.growthLimitValue" styleClass="iform" size="6" maxlength="6" value="<%=actionForm.getPricingInformation().getGrowthLimitValue() %>"  title = "Growth limit in %" />%</td>
			
    <td width="12">&nbsp;</td>
 			
    <td width="150"><label for="advance"><oppt:label label="Advance:" id="advance" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:checkbox name="pricingInformation.advance" styleId="advance" checked="<%=actionForm.getPricingInformation().isAdvance()%>" title = "Advance option checkbox " /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="pakid"><oppt:label label="PAKID:" id="pakid" errorLables="<%=errorValues%>" /></label></td>
			
    <td colspan="4"><oppt:text name="pricingInformation.pakid" styleClass="iform" styleId="pakid" size="7" maxlength="7" value="<%=actionForm.getPricingInformation().getPakid() %>" title = "Enter PAK ID"/></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="tvmRate"><oppt:label label="TVM rate:" id="tvmRate" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:text name="pricingInformation.tvmRate" styleId="tvmRate" styleClass="iform" size="5" maxlength="5" value="<%=actionForm.getPricingInformation().getTvmRate() %>" title = "Enter TVM rate in %"/>%</td>
			
    <td width="12">&nbsp;</td>
	<!-- CR6153 start changes -->		
    <td width="150"><label ><oppt:label label="Extend period:" id="extendPeriod" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:checkbox name="pricingInformation.extendPeriod" styleId="extendPeriod" checked="<%=actionForm.getPricingInformation().isExtendPeriod()%>" title = "Extend contract option checkbox " nonEditableFields="<%=view.getNonEditableFields() %>" /></td>
    <!-- CR6153 end changes -->
		</tr>
		<tr>
			<td width="12" height="40">&nbsp;</td>
			
 <!-- BlueHarmony DAD007  changed by Anand Sugumaran  -->			
    <td width="150"><label for="anniversaryContractAmount"><oppt:label label="MLC&nbsp;Anniversary/Period contract&nbsp;amount:" id="anniversaryContractAmount" errorLables="<%=errorValues%>" /></label></td>
<!-- BlueHarmony DAD007  changes End by Anand Sugumaran  -->			
    <td width="188"><oppt:text name="pricingInformation.anniversaryContractAmount" styleId="anniversaryContractAmount" styleClass="iform" size="12" value="<%=actionForm.getPricingInformation().getAnniversaryContractAmount() %>" maxlength="14" title = "Enter anniversary contract amount"/></td>
			
    <td width="12">&nbsp;</td>
			
			<!-- BlueHarmony DAD006  changed by Anand Sugumaran  

    <td width="150"><label for="ssAnniversaryContractAmount"><oppt:label label="S&amp;S&nbsp;Anniversary contract&nbsp;amount:" id="ssAnniversaryContractAmount" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:text name="pricingInformation.ssAnninversaryContractAmount" styleId="ssAnniversaryContractAmount" styleClass="iform" size="12" value="<%=actionForm.getPricingInformation().getSsAnninversaryContractAmount() %>" maxlength="14" title = "Enter S&amp;S&nbsp; anniversary contract amount"/></td>
        
		</tr>

		<tr id="ssAnninversaryAmountPeriod2">
			<td width="0" height="40" id="mandatoryAmtPeriod2">&nbsp;</td>
			
            <td width="150"><label for="ssAnninversaryAmountPeriod2"><oppt:label label="S&amp;S&nbsp;Anniversary amount&nbsp;period&nbsp;2:" id="ssAnninversaryAmountPeriod2" errorLables="<%=errorValues%>" /></label></td>
			
            <td width="188"><oppt:text name="pricingInformation.ssAnninversaryAmountPeriod2" styleId="ssAnninversaryAmountPeriod2" styleClass="iform" size="12" value="<%=actionForm.getPricingInformation().getSsAnninversaryAmountPeriod2() %>" maxlength="14" title = "Enter S&amp;S&nbsp; anniversary contract amount for Period 2" disabled="true" /></td>
            <td width="5" height="40"></td>
	   </tr>
	    <tr id="ssAnninversaryAmountPeriod3">
            <td width="12" height="40" id="mandatoryAmtPeriod3">&nbsp;</td>	
            <td width="150"><label for="ssAnninversaryAmountPeriod3"><oppt:label label="S&amp;S&nbsp;Anniversary amount&nbsp;period&nbsp;3:" id="ssAnninversaryAmountPeriod3" errorLables="<%=errorValues%>" /></label></td>
            <td width="188"><oppt:text name="pricingInformation.ssAnninversaryAmountPeriod3" styleId="ssAnninversaryAmountPeriod3" styleClass="iform" size="12" value="<%=actionForm.getPricingInformation().getSsAnninversaryAmountPeriod3() %>" maxlength="14" title = "Enter S&amp;S&nbsp; anniversary contract amount for Period 3" disabled="true" /></td>
            <td width="5" height="40"></td>
        </tr>
         <tr id="ssAnninversaryAmountPeriod4">	
           <td width="12" height="40" id="mandatoryAmtPeriod4">&nbsp;</td>		
           <td width="150"><label for="ssAnninversaryAmountPeriod4"><oppt:label label="S&amp;S&nbsp;Anniversary amount&nbsp;period&nbsp;4:" id="ssAnninversaryAmountPeriod4" errorLables="<%=errorValues%>" /></label></td>
           <td width="188"><oppt:text name="pricingInformation.ssAnninversaryAmountPeriod4" styleId="ssAnninversaryAmountPeriod4" styleClass="iform" size="12" value="<%=actionForm.getPricingInformation().getSsAnninversaryAmountPeriod4() %>" maxlength="14" title = "Enter S&amp;S&nbsp; anniversary contract amount for Period 4" disabled="true" /></td>
		   <td width="12">&nbsp;</td>
		</tr>   
	    <tr id="ssAnninversaryAmountPeriod5">	
	       <td width="12" height="40" id="mandatoryAmtPeriod5">&nbsp;</td>	
           <td width="150"><label for="ssAnninversaryAmountPeriod5"><oppt:label label="S&amp;S&nbsp;Anniversary amount&nbsp;period&nbsp;5:" id="ssAnninversaryAmountPeriod5" errorLables="<%=errorValues%>" /></label></td>
		   <td width="188"><oppt:text name="pricingInformation.ssAnninversaryAmountPeriod5" styleId="ssAnninversaryAmountPeriod5" styleClass="iform" size="12" value="<%=actionForm.getPricingInformation().getSsAnninversaryAmountPeriod5() %>" maxlength="14" title = "Enter S&amp;S&nbsp; anniversary contract amount for Period 5" disabled="true" /></td>
		   <td width="12">&nbsp;</td>
     </tr>   

				BlueHarmony DAD006  changes End by Anand Sugumaran  -->
			<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="discount"><oppt:label label="Discount:" id="discount"  errorLables="<%=errorValues%>" /></label></td>
			
    <td colspan="4"><oppt:text name="pricingInformation.discount" styleClass="iform" styleId="discount" size="5" maxlength="5" value="<%=actionForm.getPricingInformation().getDiscount() %>"  title = "Enter Discount in %"/>%</td>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="detailedInvoice"><oppt:label label="Detailed invoice:" id="detailedInvoice" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"> 
      <table role="presentation" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td width="80"><oppt:checkbox name="pricingInformation.detailedInvoice" styleId="detailedInvoice" checked="<%=actionForm.getPricingInformation().isDetailedInvoice() %>" title = "Detailed invoice checkbox" />&nbsp;</td>
					<td width="50"><label for="gsaInd">&nbsp;&nbsp;<oppt:label label="GSA:" id="gsaInd" errorLables="<%=errorValues%>" /></label></td>
					<td width="50"><oppt:checkbox name="pricingInformation.gsa" styleId="gsaInd" checked="<%=actionForm.getPricingInformation().isGsa() %>" title = "GSAID checkbox"/></td>
				</tr>
			</table>
			</td>
			
    <td width="12">&nbsp;</td>
			
    <td width="150"><label for="billingBlock"><oppt:label label="Billing block:" id="billingBlock" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:select selectedOption="<%=actionForm.getPricingInformation().getBillingBlock() %>" name="pricingInformation.billingBlock" id="billingBlock" options="<%=view.getBillingBlockOptions() %>" title = "Select billing block"/></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="deviatingDateRule"><oppt:label label="Deviating&nbsp;date&nbsp;rule:" id="deviatingDateRule" errorLables="<%=errorValues%>" /></label></td>
			
    <td colspan="4"><oppt:select selectedOption="<%=actionForm.getPricingInformation().getDeviatingDateRule() %>" name="pricingInformation.deviatingDateRule" id="deviatingDateRule" options="<%=view.getBillingDateRuleOptions() %>" title = "Select deviating date rule"/></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="billingDateRule"><oppt:label label="Billing&nbsp;date&nbsp;rule:" id="billingDateRule" errorLables="<%=errorValues%>" /></label></td>
			
    <td colspan="4"><oppt:select selectedOption="<%=actionForm.getPricingInformation().getBillingDateRule() %>" name="pricingInformation.billingDateRule" id="billingDateRule" options="<%=view.getBillingDateRuleOptions() %>" title = "Select billing date rule"/></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="freeTextForInvoicePrint"><oppt:label label="Free text for invoice print:" id="freeTextForInvoicePrint" errorLables="<%=errorValues%>" /></label></td>
			
    <td colspan="4"><html:textarea property="pricingInformation.freeTextForInvoicePrint" rows="2" styleId="freeTextForInvoicePrint" cols="44" value="<%=actionForm.getPricingInformation().getFreeTextForInvoicePrint() %>" styleClass="iform" title="Enter free text for invoice print"></html:textarea></td>
		</tr>
	</table>
	&nbsp;<br />
		
<table cellpadding="0" cellspacing="0" border="0" width="700"  summary="Purchase order data">
  <tr>
			<th height="18" colspan="6" style="background-color:#cccccc;" scope="col" class="bar-blue-med">Purchase order data</th>
		</tr>
		<tr>
			<td height="2" colspan="6" scope="col">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="poNumber"><oppt:label label="P.O. number:" id="poNumber" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:text name="secondaryProposalData.purchaseOrderNumber" styleId="poNumber" size="8" maxlength="35" styleClass="iform" value="<%=actionForm.getSecondaryProposalData().getPurchaseOrderNumber() %>" title="Enter purchase order number"/></td>
			<td width="12">&nbsp;</td>
			
    <td width="150"><label ><oppt:label label="P.O. date:" id="purchaseOrderDateLbl" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:dateOptions day="<%=actionForm.getPurchaseOrderDate().getDay() %>" month="<%=actionForm.getPurchaseOrderDate().getMonth() %>" year="<%=actionForm.getPurchaseOrderDate().getYear() %>" name="purchaseOrderDate" alt="Purchase order date" years="<%=endYearsList %>" /></td>
		</tr>
	</table>
		&nbsp;<br />
		
<table cellpadding="0" cellspacing="0" border="0" width="700"  summary="Payment Terms" >
  <tr>
			<th height="18" colspan="6" style="background-color:#cccccc;" scope="col" class="bar-blue-med">Payment terms</th>
		</tr>
		<tr>
			<td height="2" colspan="7"scope="col">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="addValueDays"><oppt:label label="Add value days:" id="addValueDays" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:text name="secondaryProposalData.addValueDays" styleId="addValueDays" size="2" value="<%=String.valueOf(actionForm.getSecondaryProposalData().getAddValueDays()) %>" maxlength="2" styleClass="iform" title="Enter add value days"/></td>
			<td width="12">&nbsp;</td>
			
    <td width="150"><label > <oppt:label label="Fixed val. date:" id="fixedValueDateLbl" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="188"><oppt:dateOptions day="<%=actionForm.getFixedValueDate().getDay() %>" month="<%=actionForm.getFixedValueDate().getMonth() %>" year="<%=actionForm.getFixedValueDate().getYear() %>" name="fixedValueDate" alt="Fixed value date" years="<%=startYearsList %>" /></td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="paymentTerms"><oppt:label label="Payment terms:" id="paymentTerms" errorLables="<%=errorValues%>" /></label></td>
			<td width="498" colspan="4"><oppt:select selectedOption="<%=actionForm.getSecondaryProposalData().getPaymentTerms() %>" name="secondaryProposalData.paymentTerms" id="paymentTerms" options="<%=view.getPaymentTermsOptions() %>" title="Select payment terms"/></td>
		</tr>
	</table>
		&nbsp;<br />
		
<table cellpadding="0" cellspacing="0" border="0" width="700"  summary="Variance">
  <tr>
			<th height="18" colspan="5" style="background-color:#cccccc;" scope="col" class="bar-blue-med">Variance</th>
		</tr>
		<tr>
			<td height="2" colspan="6" scope="col">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="capAmount"><oppt:label label="CAP amount:" id="capAmount" errorLables="<%=errorValues%>" /></label></td>
    <td width="188"><oppt:text name="capAmount" styleId="capAmount" value="<%=actionForm.getCapAmount() %>" size="9" maxlength="14" styleClass="iform" title="Enter CAP amount" /></td>
    <td width="150" nowrap="nowrap">- <label class="access"> CAP amount minus in %</label> <oppt:text name="capMinus" styleId="capMinus" size="5" maxlength="5" value="<%=actionForm.getCapMinus() %>" styleClass="iform" title="Enter CAP amount minus in %" /><label >%</label></td>
    <td width="188" nowrap="nowrap">+ <label class="access"> CAP amount plus in %</label> <oppt:text name="capPlus" styleId="capPlus" size="5" maxlength="5" value="<%=actionForm.getCapPlus() %>" styleClass="iform" title="Enter CAP amount plus in %" /><label >%</label></td>
		</tr>
	</table>
		&nbsp;<br />
		
<table cellpadding="0" cellspacing="0" border="0" width="700" summary="Financing data">
  <tr>
			<th height="18" colspan="5" style="background-color:#cccccc;" scope="col" class="bar-blue-med">Financing data</th>
		</tr>
		<tr>
			<td height="2" colspan="3" scope="col">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			
    <td width="150"><label for="igfOfferNumber"><oppt:label label="CAL #:" id="igfOfferNumber" errorLables="<%=errorValues%>" /></label></td>
			
    <td width="550"><oppt:text name="secondaryProposalData.igfOfferNumber" size="15" styleId="igfOfferNumber" maxlength="30" value="<%=actionForm.getSecondaryProposalData().getIgfOfferNumber() %>" styleClass="iform" title="Enter CAL #"/></td>
    <!-- BH Wave1 -DAD003 - Complex Contract Identifiers - Begin - Manoj -->
    <td width="150"><label ><oppt:label label="Special&nbsp;billing&nbsp;indicator:" id="preBillIndicator" errorLables="<%=errorValues%>" /></label></td>
	<td width="188"><oppt:select selectedOption="<%=actionForm.getPricingInformation().isPrebillIndicator() %>" 
   			name="pricingInformation.prebillIndicator" id="prebillIndicator" options="<%=specialBillingIndicator%>"  title="Select Special Billing Indicator" />
	    <!-- BH Wave1 -DAD003 - Complex Contract Identifiers - End - Manoj -->
		</tr>
	</table>
		&nbsp;<br />
	   
	    <!-- BH Wave1 -DAD003 - Complex Contract Identifiers - End - Manoj -->
		
	
	<!--
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="layout">
		<tr>
			<td height="18" colspan="3">&nbsp;&nbsp;Inventory fetch option</td>
		</tr>
		<tr>
			<td width="12" height="30">&nbsp;</td>
			<td width="108"><label for="sandsExcluded"><oppt:label label="S&amp;S excluded" id="sandsExcluded" errorLables="<%=errorValues%>" /></label></td>
			<td width="480"><oppt:checkbox name="secondaryProposalData.sandsExcluded" styleId="sandsExcluded" checked="<%=actionForm.getSecondaryProposalData().isSandsExcluded() %>" /></td>
		</tr>
	</table>
-->
	&nbsp;<br />
	
<table cellpadding="0" cellspacing="0" border="0" width="700" 
		summary="comments">
  <tr>
			<th height="18" colspan="6" style="background-color:#cccccc;" scope="col" class="bar-blue-med"><label for="comments">Comments
			</label></th>
		</tr>
		<tr>
			<td height="2" colspan="3"scope="col">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" height="50">&nbsp;</td>
			<td width="150">Comments:</td>
    <td width="550"><html:textarea rows="2"
				property="secondaryProposalData.comments" styleId="comments"
				cols="44" styleClass="iform" title="Enter your comments for this proposal"
				value="<%=actionForm.getSecondaryProposalData().getComments() %>">&nbsp;</html:textarea></td>
		</tr>
	</table>
	&nbsp;<br />
	<table role="presentation" border="0" cellspacing="0"  align="center">
		<tr>
			<td align="left"><oppt:button id="multipleButtonManager"
				name="multipleButtonManager.continue" alt="Continue"
				value="Continue" primary="true" buttonFlags="<%=buttonFlags %>" onclick="setProposalContentValue()"/></td>
			<td align="left"><oppt:button id="clearall"
				name="multipleButtonManager.clearAll" alt="Clear all"
				value="Clear all"  /></td>
			<td align="left"><oppt:button id="cancel"
				name="multipleButtonManager.cancel" alt="Cancel" value="Cancel"
				 /></td>
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

<script language="JavaScript" type="text/javascript">

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
				//	console.log("Cs4");
						dayElem.setAttribute("aria-invalid","true");
						}
					  if (monthElem && monthElem.options.selectedIndex == 0) {
				//	console.log("Cs5");
						monthElem.setAttribute("aria-invalid","true");
						}
					 	 if (yearElem && yearElem.options.selectedIndex == 0) {
				//	console.log("Cs6");
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
				//	console.log("Cs8");
						monthElem.setAttribute("aria-invalid","true");
					} if (yearElem && yearElem.options.selectedIndex == 0) {
				//	console.log("Cs9");
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
	


<!-- Added By Srinivas-OPPT BH-DAD001-->
var MLC_DESC = "MLC contract only";
var SNS_DESC = "S&S contract only";
<!-- Added By Srinivas-OPPT BH-DAD001-->
  document.onkeyup = KeyCheck; 

  function KeyCheck()
{
  
   var KeyID = event.keyCode;
   switch(KeyID)
   {
      case 38:
       setProposalContent();
       populateCurrency();
       clearContractDates2();
	   populateDate1(month, day, year, currentElement, dateType);
      
       
       break;    
      case 40:        
     
	   setProposalContent();
       populateCurrency();	   
	   clearContractDates2();
       populateDate1(month, day, year, currentElement, dateType);
       
	   
      break;  
 }
}
function changeOnProposalType(){
	setProposalContent();
	clearContractDates();
	clearContractDates1();
		
}
<!-- Added By Srinivas-OPPT BH-DAD001-->
 function setProposalContent(){ 
 
 	var index=document.getElementById("proposalType").selectedIndex;
	var selectmenu=document.getElementById("proposalType");

<!--    var v = document.getElementbyId("proposalContent");-->
    if(selectmenu.value=="Select one" && index==0)
 { 
	parent.document.CreateProposalActionForm.proposalContent.value=""
 }   
   if(selectmenu.value=="ES" && index==1)
 {
     parent.document.CreateProposalActionForm.proposalContent.value=MLC_DESC
 }   
   if(selectmenu.value=="EA" && index==2) 
 {
   parent.document.CreateProposalActionForm.proposalContent.value=MLC_DESC
 }
  if(selectmenu.value=="ES" && index==3)
 {
  parent.document.CreateProposalActionForm.proposalContent.value=SNS_DESC
 }
  if(selectmenu.value=="EG" && index==4)
 {
  parent.document.CreateProposalActionForm.proposalContent.value=MLC_DESC
 }
   
 }
 

  var contractnumber = document.getElementById("replacementContractNumber");
   if(contractnumber.value == null || contractnumber.value == ''){
      disableExtendContract();
    }
	function populateCurrency()
	{
 		var form = parent.document.CreateProposalActionForm;
 		var salesOrg = form.salesOrganization.value;
		var defaultCurrencyCode = salesOrg.split("|");
		var found = "false";
		
		for (var i=0; i < form.currencyCode.options.length; i++)
		{
			if (form.currencyCode.options[i].value ==  defaultCurrencyCode[1])
			{
				form.currencyCode.options.selectedIndex = i;
				found = "true";
			}   
		}
		if (found == "false"){
			form.currencyCode.options.selectedIndex = 0;
		}
	}
	
	function populateDate(month, day, year, currentElement, dateType){
	
	
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;
		var replacementContractNumber = form.replacementContractNumber.value;
		//CR6153 start changes
		if(contractnumber.value == null || contractnumber.value == ''){
		//var proposalContent=form.elements['basicProposalData.proposalContent'].value;
		var proposalContent =proposalContentKeyValue();
	
		var isChecked = document.getElementById("extendPeriod");
		if((('ES' == proposalType) ||('AM' == proposalType)) && ('S' == proposalContent)){
	   	    maxSscontractPeriod();
	   	    if(isChecked.checked){

		    
		    }
		}
	 }	
		//CR6153 end changes
		if(replacementContractNumber == "")
		{
			if(proposalType.value != "TP")
			{
				form.contractStartDateDay.options.selectedIndex = 1;		
				form.contractPeriodStartDateDay.options.selectedIndex = 1;
				lastDay();
				lastDayCPED();
			}
	
			if(validateDate(month, day, year, currentElement))
			{
				switch(dateType)
				{
					case 1:
					{	
						contractStart();
						break;
					}
					case 2:
					{
						contractEnd();
						break;
					}
					case 3:
					{
						contractPeriodBeginning();
						break;
					}
					case 4:
					{
						contractPeriodEnding();
						break;
					}
					default:
					{
						break;
					}
				}
			}
		}
	}	

	/**
	 * This code is for the contract End dates always be the last day of month
	 */
	function lastDay()
	{
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;

		var contractEndDay = form.contractEndDateDay.value;
		var contractEndYear = form.contractEndDateYear.value;
		var contractEndMonth = form.contractEndDateMonth.value;
		var contractPeriodEndDay = form.contractPeriodEndDateDay.value;
		var contractPeriodEndYear = form.contractPeriodEndDateYear.value;
		var contractPeriodEndMonth = form.contractPeriodEndDateMonth.value;
		
		/**
		 * Setting contract end day and contract period end day index depending on the month selected.
		 * 	End day is last day of the month.
		 */
		if(contractEndMonth == '04' || contractEndMonth == '06' || contractEndMonth == '09' || contractEndMonth == '11')
		{
			form.contractEndDateDay.options.selectedIndex = 30;
		}
		if(contractEndMonth == '01' || contractEndMonth == '03' || contractEndMonth == '05' || contractEndMonth == '07' || contractEndMonth == '08' || contractEndMonth == '10' || contractEndMonth == '12')
		{
			form.contractEndDateDay.options.selectedIndex = 31;
		}	  	
		if(contractPeriodEndMonth == '04' || contractPeriodEndMonth == '06' || contractPeriodEndMonth == '09' || contractPeriodEndMonth == '11')
		{	
			form.contractPeriodEndDateDay.options.selectedIndex = 30;
		}	
		if(contractPeriodEndMonth == '01' || contractPeriodEndMonth == '03' || contractPeriodEndMonth == '05' || contractPeriodEndMonth == '07' || contractPeriodEndMonth == '08' || contractPeriodEndMonth == '10' || contractPeriodEndMonth == '12')
		{
			form.contractPeriodEndDateDay.options.selectedIndex = 31;
		}	 
		if(contractEndYear%4 == 0 || (contractEndYear%100 == 0 && contractEndYear%400 == 0))
		{
			if(contractEndMonth =='02')
			{
				form.contractEndDateDay.options.selectedIndex = 29;
				return false;
			}
		}	
		if(contractEndYear%4 != 0 || (contractEndYear%100 != 0 && contractEndYear%400 != 0))
		{
			if(contractEndMonth == '02')
			{
				form.contractEndDateDay.options.selectedIndex = 28;
				return false;
			}
		}	
	}

	function lastDayCPED()
	{
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;

		var contractPeriodEndDay = form.contractPeriodEndDateDay.value;
		var contractPeriodEndYear = form.contractPeriodEndDateYear.value;
		var contractPeriodEndMonth = form.contractPeriodEndDateMonth.value;

		if(contractPeriodEndYear%4 == 0 || ( contractPeriodEndYear%100 == 0 && contractPeriodEndYear%400 == 0))
		{
			if(contractPeriodEndMonth == '02')
			{
				form.contractPeriodEndDateDay.options.selectedIndex = 29;
				return false;
			}
		}
		if(contractPeriodEndYear%4 != 0 || (contractPeriodEndYear%100 != 0 && contractPeriodEndYear%400 != 0))
		{
			if(contractPeriodEndMonth == '02')
			{
				form.contractPeriodEndDateDay.options.selectedIndex = 28;
				return false;
			}
		}
	}

	/**
	 * Checks whether the end of month is valid day or not
	 */
	function validateDate(month, day, year, currentElement) {
		var daysinMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];	
		var monthValue= parseInt(month.value);
		var dayValue = parseInt(day.value);
		var yearValue = parseInt(year.value);
		
		if(isValidValue(year, month, day, currentElement)){	
			if(monthValue == 2 && isLeap(yearValue)){
				if(dayValue > 29){
					day.options.selectedIndex=29;
					return true;
				}
				else{
					return true;
				}
			}
			else{
				return true;
			}
		}
		else if(dayValue > daysinMonth[monthValue-1]){ 
			day.options.selectedIndex = daysinMonth[monthValue - 1];
			return true;
		}
		else{
			return true;
		}
	}
	
	/**
	 * Checks the value of year combo,month combo,Day Combo.
	 * If any one of the combo value is null it resets all the values of combo's to Null value.
	 */
	function isValidValue(year, month, day, currentElement){
		if(year.options.selectedIndex > 0 && month.options.selectedIndex > 0 && day.options.selectedIndex > 0){
			return true;
		}
		else{
			switch(currentElement){
				case 1:
					if(year.options.selectedIndex == 0){
					   month.options.selectedIndex = 0;
					   day.options.selectedIndex = 0;
					}
					break;
				case 2:
					if(month.options.selectedIndex == 0){
					   year.options.selectedIndex = 0;
					   day.options.selectedIndex = 0;
					}
					break;
				case 3:
					if(day.options.selectedIndex == 0){
					   month.options.selectedIndex = 0;
					   year.options.selectedIndex = 0;
					}
					break;
			}
			return false;
		}
	} 
	/**
	 * Checks whether the year is Leap year
	 */
	function isLeap(yearValue){
		if(yearValue%4 == 0 && (yearValue%100 != 0 || yearValue%400 == 0)){
			return true;
		}
		else{
			return false;
		}
	}
	
	function contractStart()
	{
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;
		var salesOrg = form.salesOrganization.value;
	
		if(proposalType == "AB" || proposalType == "S1" || proposalType == "EN"){
			incrementBy(1);
		}
		else if(proposalType=="EA" || proposalType=="ES" || proposalType=="S3" || proposalType=="SG"){
			incrementBy(3);
		}
		else if(proposalType=="PA" || proposalType=="PE"){
			incrementBy(5);
		}
		else if(proposalType=="EL"){
			incrementBy(5);
		}
		else if(proposalType=="TP"){	
			incrementBy(3);
		}	
		else if(proposalType=="AM"){
			if(salesOrg=="0147|USD"){
				incrementBy(5);
			}
			else{
				incrementBy(3);
			}
		}
		else if(proposalType=="EG"){
			if(salesOrg=="0147|USD"){
				incrementBy(3);
			}
			else{
				incrementBy(2);
			}
		}
	}
	
	function incrementBy(increment)
	{  
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;
	
		var contractStartDateYear = form.contractStartDateYear;
		var contractStartDateDay = form.contractStartDateDay;
	    var contractStartDateMonth = form.contractStartDateMonth;
		var contractEndDateYear = form.contractEndDateYear;
		var contractEndDateDay = form.contractEndDateDay;
		var contractEndDateMonth = form.contractEndDateMonth;
		var contractPeriodBeginningYear = form.contractPeriodStartDateYear;
		var contractPeriodBeginningDay = form.contractPeriodStartDateDay;
		var contractPeriodBeginningMonth = form.contractPeriodStartDateMonth;
		var contractPeriodEndingYear = form.contractPeriodEndDateYear;
		var contractPeriodEndingDay = form.contractPeriodEndDateDay;
		var contractPeriodEndingMonth = form.contractPeriodEndDateMonth;
	
		if(contractStartDateYear.value == "yyyy" || contractStartDateMonth.value == "mm" || contractStartDateDay.value == "dd"){
			return false;
		}
		else {
			addYears(0, contractStartDateYear, contractStartDateDay, contractStartDateMonth, contractPeriodBeginningYear, contractPeriodBeginningDay, contractPeriodBeginningMonth);
			//if(proposalType != "ES" && proposalType != "AM"){
				addYears(increment, contractStartDateYear, contractStartDateDay, contractStartDateMonth, contractEndDateYear, contractEndDateDay, contractEndDateMonth);
			//}
			
			if(proposalType == "TP"){
				addMonths(3, contractPeriodBeginningYear, contractPeriodBeginningDay, contractPeriodBeginningMonth, contractPeriodEndingYear, contractPeriodEndingDay, contractPeriodEndingMonth);
			}
			else{
				addYears(1, contractPeriodBeginningYear, contractPeriodBeginningDay, contractPeriodBeginningMonth, contractPeriodEndingYear, contractPeriodEndingDay, contractPeriodEndingMonth);
				billingDateRule();
			}
		}
	}
	
	function addMonths(incrementValue, startYear, startDay, startMonth, endYear, endDay, endMonth)
	{  
		var daysinMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	
		var startYearValue = parseFloat(startYear.value);
		var startDayValue = parseFloat(startDay.value);
		var startMonthValue = parseFloat(startMonth.value);
		var endYearValue = parseFloat(endYear.value);
		var endDayValue = parseFloat(endDay.value);
		var endMonthValue = parseFloat(endMonth.value);
	
		if(startDayValue == 1){
			endMonthValue = startMonthValue + 2;
		}
		else{
			endMonthValue = startMonthValue + 3;
		}
	
		// Comparing and setting dates
		if(endMonthValue > 12)
		{
			endMonthValue = endMonthValue - 12
			endYearValue = startYearValue + 1;
		}
		else{
		     endYearValue = startYearValue;
		}	
	
		if(endMonthValue == 2 && isLeap(endYearValue)){
			endDayValue = 29;
		}
		else{
			endDayValue = daysinMonth[endMonthValue - 1]
		}
	
		if(startDayValue > 1)
		{
			if(endMonthValue > 12){
				endMonthValue = endMonthValue - 12;
				endYearValue = startYearValue + 1;
			}
			endDayValue = startDayValue - 1;
		}
	
		// Setting index for year, month and day element passed
		endYear.options.selectedIndex = endYearValue - endYear.options[1].value + 1;
		endMonth.options.selectedIndex = endMonthValue;
		endDay.options.selectedIndex = endDayValue;
	}
	
	function addYears(incrementValue, startYear, startDay, startMonth, endYear, endDay, endMonth){
		var daysinMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
		var proposalType = parent.document.CreateProposalActionForm.proposalType.value;
	
		var startYearValue = parseFloat(startYear.value);
		var startDayValue = parseFloat(startDay.value);
		var startMonthValue = parseFloat(startMonth.value);
		var endYearValue = 0; 
		var endDayValue = 0;
		var endMonthValue = 0;
	
		// If increment value passed is 0, set end date same as start date	
		if (incrementValue == 0)
		{
			endYearValue = startYearValue;
			endDayValue = startDayValue;
			endMonthValue = startMonthValue;
		}
		// Setting values for end month,day and year
		else
		{
			if(startMonthValue == 1)
			{
				if(startDayValue == 1)
				{
					endYearValue = startYearValue + (incrementValue - 1);
				  	endMonthValue = 12;
					endDayValue = 31;
				}
				else
				{
					if(proposalType == "TP")
					{
						endYearValue = startYearValue + incrementValue;
						endMonthValue = startMonthValue;
						endDayValue = startDayValue - 1;	
					}
					else
					{
						endYearValue=startYearValue + (incrementValue-1);
						endMonthValue = 12;
						endDayValue = 31;
						startDayValue = 1;
						startDay.options.selectedIndex = startDayValue;
					}
				}
			}
			else
			{
				endYearValue = startYearValue + incrementValue;
				endMonthValue = startMonthValue - 1;
				if(startDayValue==1){
					endMonthValue = startMonthValue -1;
				}
				else{
					endMonthValue = startMonthValue;
				}
	
				if(proposalType != "TP")
				{
					startDayValue=1;
					startDay.options.selectedIndex = startDayValue;
	
					if(endMonthValue == 2 && isLeap(endYearValue)){
						endDayValue = 29;
					}
					else{
						endDayValue = daysinMonth[endMonthValue - 1];
					}
				}
				else {
					if(startDayValue == 1)
					{
						if(endMonthValue == "04" || endMonthValue == "06" || endMonthValue == "9" || endMonthValue == "11"){
							endDayValue=30;
						}
						if(endMonthValue == "01" || endMonthValue == "03" || endMonthValue == "05" || endMonthValue == "07" || endMonthValue == "8" || endMonthValue == "10" || endMonthValue == "12"){
							endDayValue = 31;
						}	  	
						if(endMonthValue == "02" && isLeap(endYearValue)){
							endDayValue = 29;
						}
						else
						{
							endDayValue = 28;
						}	
					}
					else
					{
						endDayValue = startDayValue - 1;	
					}
				}
			}
		}
	 
		// Setting index for year, month and day element passed
		endYear.options.selectedIndex = endYearValue - endYear.options[1].value + 1;
		endMonth.options.selectedIndex = endMonthValue;
		endDay.options.selectedIndex = endDayValue;
	}

	function contractEnd(){
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;
	
		var contractStartDateYear = form.contractStartDateYear;
		var contractStartDateDay = form.contractStartDateDay;
	    var contractStartDateMonth = form.contractStartDateMonth;
		var contractEndDateYear = form.contractEndDateYear;
		var contractEndDateDay = form.contractEndDateDay;
		var contractEndDateMonth = form.contractEndDateMonth;
	
		var count = 0;
	
		/*	Proposal type not selected	*/
		if(proposalType == "")
		{
			contractEndDateYear.options.selectedIndex = 0;
			contractEndDateMonth.options.selectedIndex = 0;
			contractEndDateDay.options.selectedIndex=0;
	        proposalType.focus();
			return false;
		}
	
		/**
		 * Set count depending on proposal type selected	
		 */
		if(proposalType=="AB" || proposalType=="S1" || proposalType=="EN"){
			count=1;          
		}
		if (proposalType=="EA" || proposalType=="EG" || proposalType=="S3" || proposalType=="SG" || proposalType=="TP"){
			count=3;
		}
		if(proposalType=="PA" || proposalType=="PE") {
			count=5;
		}
		if (proposalType=="EL") {
			count=5;
		}
		if (proposalType=="ES" || proposalType=="AM") {
			count=10;
		}
	
		/*	Contract end year less than contract start year		*/
		if(contractEndDateYear.options.selectedIndex < contractStartDateYear.options.selectedIndex)
		{
			contractEndDateYear.options.selectedIndex = contractStartDateYear.options.selectedIndex;
			if (contractEndDateMonth.options.selectedIndex < contractStartDateMonth.options.selectedIndex) 
			{
				contractEndDateMonth.options.selectedIndex = contractStartDateMonth.options.selectedIndex;
			}
			validateDate(contractEndDateMonth.options, contractEndDateDay.options, contractEndDateYear.options);
			contractEndDateYear.focus();
			return false;
		}
		
		/**
		 * Contract end year equals contract start year and
		 * Contract end month less than contract start month
		 */
		if((contractEndDateYear.options.selectedIndex == contractStartDateYear.options.selectedIndex) && 
		   (contractEndDateMonth.options.selectedIndex < contractStartDateMonth.options.selectedIndex))
		{		
			contractEndDateMonth.options.selectedIndex = contractStartDateMonth.options.selectedIndex;
			validateDate(contractEndDateMonth.options,contractEndDateDay.options,contractEndDateYear.options);
			contractEndDateMonth.focus();
			return;
		}
	
		/** 
		 * Contract end year equals contract start year and
		 * Contract end month equals contract start month and
		 * Contract end date less than contract start date
		 */
		if((contractEndDateYear.options.selectedIndex == contractStartDateYear.options.selectedIndex) && 
		   (contractEndDateMonth.options.selectedIndex == contractStartDateMonth.options.selectedIndex) && 
		   (contractEndDateDay.options.selectedIndex < contractStartDateDay.options.selectedIndex))
		{
			contractEndDateDay.options.selectedIndex = contractStartDateDay.options.selectedIndex;
			contractEndDateDay.focus();
			return;
		}
		
		if (proposalType=="ES" || proposalType=="AM") {
			if(contractEndDateYear.selectedIndex == contractStartDateYear.selectedIndex + count)
			{
				if(contractEndDateMonth.selectedIndex >= contractStartDateMonth.selectedIndex)
				{	
					contractEndDateYear.selectedIndex = 0;
					contractEndDateMonth.selectedIndex = 0;
					contractEndDateDay.selectedIndex = 0;
					contractEndDateYear.focus();
					return false;
				}
			}
			else if(contractEndDateYear.selectedIndex > contractStartDateYear.selectedIndex + count)
			{
				contractEndDateYear.selectedIndex = 0;
				contractEndDateMonth.selectedIndex = 0;
				contractEndDateDay.selectedIndex = 0;
				contractEndDateYear.focus();
				return false;	
			}
		}
		else {
			if(contractEndDateYear.selectedIndex == contractStartDateYear.selectedIndex + count)
			{
				if(contractEndDateMonth.selectedIndex >= contractStartDateMonth.selectedIndex)
				{	
					contractEndDateYear.focus();
				}
			}
			else if(contractEndDateYear.selectedIndex > contractStartDateYear.selectedIndex + count)
			{
				contractEndDateYear.focus();
				return false;
			}
		}
	}
	
	function contractPeriodBeginning()
	{
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;
	
		var contractStartYear = form.contractStartDateYear;
		var contractStartDay = form.contractStartDateDay;
	    var contractStartMonth = form.contractStartDateMonth;
		var contractEndYear = form.contractEndDateYear;
		var contractEndDay = form.contractEndDateDay;
		var contractEndMonth = form.contractEndDateMonth;
		var contractPeriodStartYear = form.contractPeriodStartDateYear;
		var contractPeriodStartDay = form.contractPeriodStartDateDay;
		var contractPeriodStartMonth = form.contractPeriodStartDateMonth;
		var contractPeriodEndYear = form.contractPeriodEndDateYear;
		var contractPeriodEndDay = form.contractPeriodEndDateDay;
		var contractPeriodEndMonth = form.contractPeriodEndDateMonth;
	
		/*	Get contract period beginning dates 
		 	and contract end dates into javascript variables	
		*/
		var CPBY = contractPeriodStartYear.value;
		var CPBM = contractPeriodStartMonth.value;
		var CEDY = contractEndYear.value;
		var CEDM = contractEndMonth.options.selectedIndex;
		var CPEY = contractPeriodEndYear.value;
		var CEDMNext = contractPeriodEndMonth.options.selectedIndex + 1;
		var CPEMB = contractPeriodStartMonth.options.selectedIndex;
		
		/**
		 * Proposal type is not selected	
		 */
		if(proposalType == "")
		{
			contractPeriodStartYear.options.selectedIndex=0;
			contractPeriodStartMonth.options.selectedIndex=0;
			contractPeriodStartDay.options.selectedIndex=0;
			contractStartYear.options.selectedIndex=0;
			contractStartMonth.options.selectedIndex=0;
			contractStartDay.options.selectedIndex=0;
	        proposalType.focus();		
			billingDateRule()
			return false;
		}
	
		if((proposalType !="TP")){
			contractPeriodStartDay.options.selectedIndex=1;
		}
	
		/**
		 * Contract period beginning date is less than contract start date
		 */
		if(contractPeriodStartYear.value < contractStartYear.value)
		{
			contractPeriodStartYear.options.selectedIndex = contractStartYear.options.selectedIndex;
			contractPeriodStartYear.options.selectedIndex = contractPeriodStartYear.options.selectedIndex+1;
			contractPeriodStartYear.focus();
			billingDateRule()
			return false;
		}
	
		/**
		 * Contract period beginning year is equal to contract start year and
		 * Contract period beginning month is less than contract start month
		 */
		if((contractPeriodStartYear.value == contractStartYear.value) && (contractPeriodStartMonth.options.selectedIndex < contractStartMonth.options.selectedIndex))
		{		
			contractPeriodStartMonth.options.selectedIndex = contractStartMonth.options.selectedIndex;
			contractPeriodStartMonth.focus();
			billingDateRule()
	    	return false;
		}
	
		/**
		 * Contract period beginning year > contract end year	
		 */
		if(CPBY > CEDY){
			billingDateRule()
			return false;
		}
	
		/**
		 * Contract period beginning year equals contract end year and
		 * Contract period beginning month greater than contract end month
		 */
		if ((CPBY == CEDY) && (CPBM > CEDM))
		{
			contractPeriodStartMonth.focus();
			billingDateRule()
			return false;
		}
	
		/* Contract period end year equals contract end year and
		 * Contract period begin month greater than contract end month+1
		 */
		if(CPEY == CEDY &&  CPEMB > CEDMNext)
		{
			billingDateRule()
			return false;
		}	
	
		/**
		 * Contract period end year+1 equals contract end year and
		 * Contract period begin month greater than contract end month+1
		 */
		if(CPEY +1 == CEDY && CPEMB > CEDMNext)
		{
			billingDateRule()
			return false;
		}
	
		/**
		 * Contract period begin year equals contract start year and
		 * Contract period begin month equals contract start month and
		 * Contract period begin date less than contract start date
		 */
		if((contractPeriodStartYear.value == contractStartYear.value) && (contractPeriodStartMonth.options.selectedIndex == contractStartMonth.options.selectedIndex) && (contractPeriodStartDay.options.selectedIndex < contractStartDay.options.selectedIndex))/* EF0228036119 */
		{
			contractPeriodStartDay.options.selectedIndex = contractStartDay.options.selectedIndex;
			contractPeriodStartDay.focus();
			billingDateRule()
			return false;
		}
		else
		{
			if((proposalType != "TP")) {
				contractPeriodStartDay.options.selectedIndex = 1;
			}
			
			if(proposalType == "TP"){
				addMonths(3, contractPeriodStartYear, contractPeriodStartDay, contractPeriodStartMonth, contractPeriodEndYear, contractPeriodEndDay, contractPeriodEndMonth);
			}
			else {
				addYears(1, contractPeriodStartYear, contractPeriodStartDay, contractPeriodStartMonth, contractPeriodEndYear, contractPeriodEndDay, contractPeriodEndMonth);
				billingDateRule();
			}
		}	
	}	

	function contractPeriodEnding(){
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;
	
		var contractPeriodStartYear = form.contractPeriodStartDateYear;
		var contractPeriodStartDay = form.contractPeriodStartDateDay;
		var contractPeriodStartMonth = form.contractPeriodStartDateMonth;
		var contractPeriodEndYear = form.contractPeriodEndDateYear;
		var contractPeriodEndDay = form.contractPeriodEndDateDay;
		var contractPeriodEndMonth = form.contractPeriodEndDateMonth;
	
		var contractPeriodStartYearValue = parseFloat(contractPeriodStartYear.value);
	    var contractPeriodStartMonthValue = parseFloat(contractPeriodStartMonth.value);
		var contractPeriodStartDayValue = parseFloat(contractPeriodStartDay.value);
	          
		/**
		 * Proposal type is not selected	
		 */
		if(proposalType.value =="")
		{
			contractPeriodEndYear.options.selectedIndex = 0;
			contractPeriodEndMonth.options.selectedIndex = 0;
			contractPeriodEndDay.options.selectedIndex = 0;
			proposalType.focus();		 
			return false;
		}
	
		/**
		 * Contract period end year less than contract period begin year	
		 */
		if(contractPeriodEndYear.options.selectedIndex < contractPeriodStartYear.options.selectedIndex)
		{
			contractPeriodBeginning();
			contractPeriodEndYear.focus();
			return false;
		}
	
		/**
		 * Contract period end year equals contract period begin year and
		 * Contract period end month less than contract period begin month
		 */	
		if((contractPeriodEndYear.options.selectedIndex == contractPeriodStartYear.options.selectedIndex) && 
		   (contractPeriodEndMonth.options.selectedIndex < contractPeriodStartMonth.options.selectedIndex))
		{		
			contractPeriodBeginning();
			contractPeriodEndMonth.focus();
			return false;
		}
	
		/**
		 * Contract period end year equals contract period begin year and
		 * Contract period end month equals contract period begin month
		 * Contract period end date less than contract period begin date 
		 */	
		if((contractPeriodEndYear.options.selectedIndex == contractPeriodStartYear.options.selectedIndex) && 
		   (contractPeriodEndMonth.options.selectedIndex == contractPeriodStartMonth.options.selectedIndex) && 
		   (contractPeriodEndDay.options.selectedIndex < contractPeriodStartDay.options.selectedIndex))
		{		
			contractPeriodBeginning();
			contractPeriodEndDay.focus();
			return false;
		}
	}
	
	function clearContractDates(){
		var form = parent.document.CreateProposalActionForm;
		var proposalType = form.proposalType.value;
		
		form.contractStartDateYear.options.selectedIndex = 0;
		form.contractStartDateDay.options.selectedIndex = 0;
	    form.contractStartDateMonth.options.selectedIndex = 0;
		form.contractEndDateYear.options.selectedIndex = 0;
		form.contractEndDateDay.options.selectedIndex = 0;
		form.contractEndDateMonth.options.selectedIndex = 0;
		form.contractPeriodStartDateYear.options.selectedIndex = 0;
		form.contractPeriodStartDateDay.options.selectedIndex = 0;
		form.contractPeriodStartDateMonth.options.selectedIndex = 0;
		form.contractPeriodEndDateYear.options.selectedIndex = 0;
		form.contractPeriodEndDateDay.options.selectedIndex = 0;
		form.contractPeriodEndDateMonth.options.selectedIndex = 0;
		// Since PA and PE types are no longer in user, commenting this code - Srinivasa Dirisala BH1.0 Changes DAD O01
		//if(proposalType=="PA" || proposalType=="PE")
		//{
		//	form.proposalContent.options.selectedIndex = 2;
	//	} else {
		//	form.proposalContent.options.selectedIndex = 0;
		//}
		if(contractnumber.value == null || contractnumber.value == ''){

		  disableExtendContract();
		}
		
		
	}
	
	
	function billingDateRule(){
		var form = parent.document.CreateProposalActionForm;
		var contractPeriodStartMonth = form.contractPeriodStartDateMonth.value;
		var billingFrequency = form.billingFrequency.value;
		
		if('Select one' != billingFrequency){
			if('Q' == billingFrequency){
				if(contractPeriodStartMonth == '02' || contractPeriodStartMonth == '03' || 
					contractPeriodStartMonth == '05' || contractPeriodStartMonth == '06' || 
					contractPeriodStartMonth == '08' || contractPeriodStartMonth == '09' || 
					contractPeriodStartMonth == '11' || contractPeriodStartMonth == '12')
				{
					form.billingDateRule.value = "9Q";
				}
				else
				{
					form.billingDateRule.value = "YE";
				}

			}
			else{
					form.billingDateRule.selectedIndex = 0;
			}
		}
		else{
			form.billingDateRule.selectedIndex = 0;
		}
	}

	function clearContractDates2(){
		var form = parent.document.CreateProposalActionForm;
		var contractPeriodStartMonth = form.contractPeriodStartDateMonth.value;
		var billingFrequency = form.billingFrequency.value;
				
		if('Select one' != billingFrequency){
			if('Q' == billingFrequency){
				if(contractPeriodStartMonth == '02' || contractPeriodStartMonth == '03' || 
					contractPeriodStartMonth == '05' || contractPeriodStartMonth == '06' || 
					contractPeriodStartMonth == '08' || contractPeriodStartMonth == '09' || 
					contractPeriodStartMonth == '11' || contractPeriodStartMonth == '12')
				{
					form.billingDateRule.value = "9Q";
				}
				else
				{
					form.billingDateRule.value = "YE";
				}

			}
			else{
					form.billingDateRule.selectedIndex = 0;
			}
		}
		else{
			form.billingDateRule.selectedIndex = 0;
		}
	}
	
	function clearContractDates1(){
		var form = parent.document.CreateProposalActionForm;
		var proposalContent = proposalContentKeyValue();
		//var proposalContent = form.proposalContent.value;
		
		if(contractnumber.value == null || contractnumber.value == ''){
		    form.extendPeriod.checked = false;

		}
		if('S' == proposalContent){
			form.billingFrequency.value = 'A';
		}
		else{
			form.billingFrequency.value = 'Q';
		}
		clearContractDates2();
		if(contractnumber.value == null || contractnumber.value == ''){
		    form.extendPeriod.checked = false;
		    disableExtendContract();
		}
	}

	function billingFrequency(){
		var form = parent.document.CreateProposalActionForm;
		//var proposalContent = form.proposalContent.value;
		var proposalContent = proposalContentKeyValue();
		if('S' == proposalContent){
			form.billingFrequency.value = 'A';
		}
		else{
			form.billingFrequency.value = 'Q';
		}
		
		billingDateRule();
		
	}
	function disableExtendContract(){
	

		var form = parent.document.CreateProposalActionForm;
         // var proposalContent = form.proposalContent.value;
         var proposalContent = proposalContentKeyValue();
		  
		var proposalType = form.proposalType.value;
		//CR6153 start changes
		if((('ES' == proposalType) ||('AM' == proposalType)) && ('S' == proposalContent)){
			form.extendPeriod.disabled = false;
		}
		else{
			form.extendPeriod.disabled = true;
			form.extendPeriod.checked = false;
		}
		
	}
  function MonthText (MonthNumber) {
     var Month = new Array();
       Month[1]="Jan";
       Month[2]="Feb";
       Month[3]="Mar";
       Month[4]="Apr";
       Month[5]="May";
       Month[6]="Jun";
       Month[7]="Jul";
       Month[8]="Aug";
       Month[9]="Sep";
       Month[10]="Oct";
       Month[11]="Nov";
       Month[12]="Dec";
   return Month[MonthNumber];
  }	
  if(contractnumber.value == null || contractnumber.value == ''){
    var isChecked = document.getElementById("extendPeriod");

   }
   
     
  function maxSscontractPeriod(){
	    var form = parent.document.CreateProposalActionForm;
        var count = 0;
        var years = 4;
        var contractStartdate = parseFloat(form.contractPeriodStartDateYear.value);
		var contractEnddate = parseFloat(form.contractEndDateYear.value);
		var contractStartDateMonth = form.contractPeriodStartDateMonth;
		var startDateMonth = parseFloat(contractStartDateMonth.value);
		var endDateMonth = parseFloat(form.contractPeriodEndDateMonth.value);
		   if(endDateMonth == 12){
		        count = 1;
		    }
		    if(startDateMonth != 1){
		       years = 5;
		    }
		 var contrctPeriod = (contractEnddate - contractStartdate) + count;
		   if(contrctPeriod > 5){
		        var contractStratyear=form.contractStartDateYear.options.selectedIndex + years;
		        form.contractEndDateYear.options.selectedIndex  = contractStratyear;
          }
          }
	<!-- Added By Srinivas-OPPT BH-DAD001-->	
		function setProposalContentValue()
		{
			var proposalContent = parent.document.CreateProposalActionForm.proposalContent.value;

			if(proposalContent==MLC_DESC)
			{
				parent.document.CreateProposalActionForm.proposalContent.value ='M';
				
				
			}
			if(proposalContent==SNS_DESC)
			{
				parent.document.CreateProposalActionForm.proposalContent.value ='S'
			}
			if(proposalContent=="")
			{ 
				parent.document.CreateProposalActionForm.proposalContent.value =''
			}
			

	    
  }
  <!-- Added By Srinivas-OPPT BH-DAD001-->
  function proposalContentKeyValue()
{
	var proposalContent = parent.document.CreateProposalActionForm.proposalContent.value;
	
	if(proposalContent == MLC_DESC)
	{
		return "M"; 
	}  
	else
	if(proposalContent == SNS_DESC)
	{
		return "S"; 
	}else{
		return ""; 
	}
	
}

 //CR6153 end changes
document.onselect = sync;
 function sync()
{
  //alert('Hello'); 
  var n1 = document.getElementById("discount").value;
  var n2 = document.getElementById("freeTextForInvoicePrint").value;

  if (document.getElementById("discount").value > 0 && document.getElementById("discount").value < 100  )
  {
    document.getElementById("freeTextForInvoicePrint").value=n1+"% discount applied";
  }
 else
 {
 document.getElementById("freeTextForInvoicePrint").value=n2; 
 }
 }  
 
</script>
<noscript>To use this function please enable java script in your browser</noscript>
