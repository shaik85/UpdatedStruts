
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.commons.BasicProposalDataBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.commons.PricingInformationDataBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.commons.SecondaryProposalDataBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.commons.VarianceDataBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.AmendContractViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AmendContractActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm" %>
<!-- start change CR6153 -->
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender"%>
<!-- end change CR6153 -->

<%
	BasicProposalDataBean basicBean = null;
	PricingInformationDataBean pricingBean = null;
	SecondaryProposalDataBean secondaryBean = null;
	VarianceDataBean varianceBean = null;
	Date amendmentEffectiveDate = null;
	Date purchaseOrderDate = null;
	TreeMap billingBlock = null;
	TreeMap blbIndicator = null;
	String financeContractNo = "";
	ArrayList yearList = null;
	String advance = null;
	String extendPeriod=null;
	TreeMap specialBillingIndicator = new TreeMap();
			specialBillingIndicator.put("F", "FIA process"); 
			specialBillingIndicator.put("P", "Pre-bill/BRE process");
	ErrorReport errorReport = null;
	HashSet errorValues = null;
	ArrayList buttonFlags = null;
	OPPTSession opptSession = new OPPTSession(session);
	AmendContractActionForm actionForm = null;
	AmendContractViewBean viewBean = (AmendContractViewBean) opptSession.getCurrentViewBean();

	if (null != viewBean) 
	{
		actionForm = (AmendContractActionForm) viewBean.getActionForm();
		basicBean = viewBean.getBasicProposalData();
		pricingBean = viewBean.getPricingInformation();
		secondaryBean = viewBean.getSecondaryProposalData();
		varianceBean = viewBean.getVarianceData();
		billingBlock = viewBean.getBillingBlockList();
		blbIndicator = viewBean.getBlbIndicatorList();
		financeContractNo = viewBean.getFinancingContractNumber();
		yearList = viewBean.getYearList();

		if (null == actionForm.getEffectiveDate()) 
		{
			amendmentEffectiveDate = viewBean
					.getAmendmentEffectiveDate();
		} 
		else 
		{
			amendmentEffectiveDate = actionForm.getEffectiveDate();
		}
		if (null == actionForm.getPurchaseDate()) 
		{
			purchaseOrderDate = secondaryBean.getPurchaseOrderDate();
		} 
		else 
		{
			purchaseOrderDate = actionForm.getPurchaseDate();
		}
		if (pricingBean.isAdvance()) 
		{
			advance = "Checked";
		} 
		else 
		{
			advance = "Unchecked";
		}
		if (pricingBean.isExtendPeriod()) 
		{
			extendPeriod = "Checked";
		} 
		else 
		{
			extendPeriod = "Unchecked";
		}
		/* BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Bhanu */
		pricingBean.setPrebillIndicator(actionForm.isPrebillIndicator());
		/* BH Wave1 - DAD003 - Complex Contract Identifiers - End - Bhanu */
		
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorValues = errorReport.getErrorFieldNames();
	}
	
	/*CR6153 changes starts */
	if((viewBean.getProposalContent().equalsIgnoreCase("S&S contract only")) && ((("ES").equalsIgnoreCase(basicBean.getProposalType()) ) ||("AM".equalsIgnoreCase(basicBean.getProposalType()) )) ){
	Date startDate = basicBean.getContractStartDate();
	Date endDate = basicBean.getContractEndDate();
	Calendar two = Calendar.getInstance();
    Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		two.setTime(endDate);
		actionForm.setContractDuration(((two.get(Calendar.YEAR) - start.get(Calendar.YEAR)) + ((two.get(Calendar.MONTH) - start.get(Calendar.MONTH)+1))/12));
	
    }
    /*CR6153 changes end */
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Amend proposal</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table role="presentation" cellpadding="0" cellspacing="0" border="0"	width="600">
	<tr valign="top">
		<td width="600">
		<table role="presentation" width="700">
			
			<tr>
				<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
			</tr>
			<tr>
				<td><oppt:displayErrorReport errorReport="<%=errorReport%>" />

				<p>Use this form to alter the contract amount of an selected
				contract and specify the Amendment effective date. When you are
				finished, click the Save button. Press the Clear all button to
				discard your input. Press the Cancel button to go back to contract
				maintenance page.</p>

				<p>Required fields are marked with an asterisk (<strong>*</strong>) and must
				be filled in to complete the form.</p>
				</td>
			</tr>
		</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;
<br />

<table summary="AmendContract" cellpadding="0" cellspacing="0" border="0"	width="600">
	<tr valign="top">
		<tr scope="col"><html:form action="/protect/AmendContractMultipleAction.wss">
			<table summary="Basic Proposal Details" cellpadding="0" cellspacing="0" border="0" width="700">
				<tr align="left">
					<th colspan="6" height="18" class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Basic proposal	data</th>
				</tr>
				<tr>
					<td height="2" colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td width="12" height="30">&nbsp;</td>
					<td width="150">Proposal name:</td>
					<td width="188"><oppt:label	label="<%=basicBean.getProposalName()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="140">Proposal type:</td>
					<td width="188">
						<input type="hidden" name="proposalType" value="<%=basicBean.getProposalType() %>" />
						<oppt:label	label="<%=basicBean.getProposalType()%>" />
					</td>
				</tr>
				<tr>
					<td height="30" width="12">&nbsp;</td>
					<td width="150">Report name:</td>
					<td width="188"><oppt:label label="<%=basicBean.getReportName()%>" /></td>
					<td width="12">&nbsp;</td>
					<td><label for="extContNumber">External contract number:</label></td>
					<td width="188">
					<%
					if (null != actionForm.getExternalContractNumber()) 
					{
					%> 
						<oppt:text name="externalContractNumber" styleId="extContNumber"
						value="<%=actionForm.getExternalContractNumber()%>" maxlength="10" size="7" styleClass="iform" /> 
					<%
					} 
					else 
					{
					%> 
						<oppt:text name="externalContractNumber" styleId="extContNumber"
						value="" maxlength="10" size="7" styleClass="iform" /> 
					<%
					}
					%>
					</td>
				</tr>
					<%
					if (basicBean.isShowProposalContent()) 
					{
					%>
				<tr>
					<td width="12" height="20">&nbsp;</td>
					<td width="150">Proposal content:</td>
					<td width="188">
          <input type="hidden" name="proposalContent" value="<%=viewBean.getProposalContent() %>" /><oppt:label label="<%=viewBean.getProposalContent()%>"/></td>
					<td width="12">&nbsp;</td>
					<td width="140">&nbsp;</td>
					<td width="188">&nbsp;</td>
				</tr>
				<%
				}
				%>
			</table>
			&nbsp;<br />
			
		<!-- BH Wave1 -DAD003 - Complex Contract Identifiers - Begin - Manoj -->
		<table cellpadding="0" cellspacing="0" border="0" width="700" summary="Complex Contract Identifiers">
  <tr>
			<th height="18" colspan="6" class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Complex Contract Identifiers</th>
		</tr>
		<tr>
			<td height="2" colspan="6">&nbsp;</td>
		</tr>
		<tr>
			<td width="12" valign="middle" height="30"></td>
			
    <td width="150" height="30"><label for="complexContractID"><oppt:label label="&nbsp;&nbsp;&nbsp;CPS&nbsp;id:" id="cpsID" errorLables="<%=errorValues%>" /></label></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.cpsID" styleClass="iform" styleId="complexContractID" value="<%=basicBean.getCpsID()%>" maxlength="15" title = "Enter the CPS id"/></td>

    <td width="150"><label for="complexContractType"><oppt:label label="Original&nbsp;CPS id:" id="ocpsID" errorLables="<%=errorValues%>" /></label></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.ocpsID" styleClass="iform" styleId="complexContractType" style="background:lightgrey;" value="<%=basicBean.getOcpsID() %>" maxlength="25" title="OCPS ID" readonly="true" />
			</td>    
    		</tr>
		<tr>
			<td width="16" height="30"></td>
			
     <td width="150"><oppt:label label="&nbsp;&nbsp;&nbsp;Contract&nbsp;type:" id="contractType" errorLables="<%=errorValues%>" /></label></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.contractType" styleClass="iform" styleId="contractType" style="background:lightgrey;" value="<%=basicBean.getContractType() %>" maxlength="4" title="Contract type" readonly="true" />
			</td>

    <td width="150"><oppt:label label="BLB&nbsp;indicator:" id="blbIndicator" errorLables="<%=errorValues%>" /></label></td>
			<td width="533">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<oppt:text name="basicProposalData.blbIndicator" styleClass="iform" styleId="masterContractType" style="background:lightgrey;" value="<%=basicBean.getBlbIndicator() %>" maxlength="4" title="BLB indicator" readonly="true" />
			</td>
		</tr>	
	</table>
	&nbsp;<br />
    <!-- BH Wave1 -DAD003 - Complex Contract Identifiers - End - Manoj -->

			<table summary="Contract Date Details" cellpadding="0" cellspacing="0" border="0"	width="700">
				<tr align="left">
					<th colspan="6" height="18"  class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Contract dates</th>
				</tr>
				<tr>
					<td height="2" colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td width="12" height="30">&nbsp;</td>
					<td width="150">Contract start date:</td>
          <td width="188">  <input type="hidden" name="contractStartDate" value ="<%=basicBean.getContractStartDate()%>" />
          <oppt:date date="<%=basicBean.getContractStartDate()%>"/></td>
					<td width="12">&nbsp;</td>
					<td width="150">Contract end date:</td>
			<td width="188"> <input type="hidden" name="contractEndDate" value = "<%=basicBean.getContractEndDate()%>" />	
			<oppt:date date="<%=basicBean.getContractEndDate()%>" /></td>
				</tr>
				<!-- start change CR6153 -->	
				<tr>
					<td height="35" width="12">&nbsp;</td>
					<td width="150">Contract period beginning:</td>
					<%
						Date cntrPeriodStrtDate = basicBean.getContractPeriodBeginning();
						Date cntrPeriodEndDate = basicBean.getContractPeriodEnding();
						OPPTCalender startDateCalender = new OPPTCalender();
						OPPTCalender endDateCalender = new OPPTCalender();
		 				if (basicBean.isExtendPeriod()!= null && basicBean.isExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD)) 
		 				{
							Date date = new Date();
							while(cntrPeriodEndDate.getTime()< date.getTime() && cntrPeriodEndDate.getTime() < basicBean.getContractEndDate().getTime())
							{
								startDateCalender.setTime(OPPTCalender.addDate(OPPTCalender.YEAR, 1, cntrPeriodStrtDate));
								endDateCalender.setTime(OPPTCalender.addDate(OPPTCalender.YEAR, 1, cntrPeriodEndDate));
								if(endDateCalender.getYear()%4 == 0 &&(endDateCalender.getYear()%100 != 0 || endDateCalender.getYear()%400 == 0))  
								{
									if(startDateCalender.getMonth() == 3 && startDateCalender.getDay()== 1 && (basicBean.getContractEndDate().getTime() > cntrPeriodEndDate.getTime()))
									{
										endDateCalender.set(endDateCalender.getYear(),endDateCalender.getMonth()-1,endDateCalender.getDay()+1 );
										// since month is 0 based in the set method, and starts from 1 in the get method, we subtract 1
									}
								}
							cntrPeriodStrtDate.setTime(startDateCalender.getTimeInMillis());									
							cntrPeriodEndDate.setTime(endDateCalender.getTimeInMillis());
							}
						} 
						else 
						{
							cntrPeriodStrtDate = basicBean.getContractPeriodBeginning();
							cntrPeriodEndDate = basicBean.getContractPeriodEnding();
						}
					%>
					<td width="188"><oppt:date	date="<%=basicBean.getContractPeriodBeginning()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="150">Contract period ending:</td>
					<td width="188"><oppt:date	date="<%=cntrPeriodEndDate%>" /></td>
				</tr>
				<!-- end change CR6153 -->
				<tr>
					<td height="30" width="12"></td>
					<td width="150"><label ><strong>*</strong>
						<oppt:label	label="Amendment effective date:" id="amendmentEffectiveDateLbl"
							errorLables="<%=errorValues%>" /></label>
					</td>
					<td colspan="4"><oppt:dateOptions name="amendmentEffectiveDate"
						years="<%=yearList%>" date="<%=amendmentEffectiveDate%>"
						onclick="populateDate" alt="Amend effective Date" />
					</td>
				</tr>
			</table>
			&nbsp;<br />

			<table summary="Pricing Details" cellpadding="0" cellspacing="0" border="0"	width="700">
				<tr align="left">
					<th colspan="6" height="18" class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Pricing information</th>
				</tr>
				<tr>
					<td height="2" colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td width="12" height="30">&nbsp;</td>
					<td width="150">Planned growth:</td>
					<td width="188"><oppt:label	label="<%=pricingBean.getPlannedGrowthValue()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="150">Billing frequency:</td>
					<td width="188"><oppt:label	label="<%=pricingBean.getBillingFrequency()%>" /></td>
				</tr>
				<tr>
					<td height="30" width="12">&nbsp;</td>
					<td width="150">Growth limit:</td>
					<td width="188"><oppt:label	label="<%=pricingBean.getGrowthLimitValue()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="150">TVM rate:</td>
					<td width="188"><oppt:label label="<%=pricingBean.getTvmRate()%>" /></td>
				</tr>
				<tr>
					<td height="30" width="12">&nbsp;</td>
					<td width="150">Discount:</td>
					<td width="188"><oppt:label	label="<%=pricingBean.getDiscount()%>" /></td>
				</tr>
				<tr>
				 <!-- BlueHarmony DAD007  changed by Anand Sugumaran  -->
					<td height="40" width="12">&nbsp;</td>
					<td width="150"><label for="anniversaryContractAmount">
						<oppt:label label="MLC Anniversary/Period contract amount:"
						id="anniversaryContractAmount" errorLables="<%=errorValues%>" /></label>
					</td>
				 <!-- BlueHarmony DAD007  changes End by Anand Sugumaran  -->
					<td width="188"><oppt:text name="anniversaryContractAmount"
						styleId="anniversaryContractAmount"
						value="<%=actionForm.getAnniversaryContractAmount()%>"
						maxlength="12" size="12" styleClass="iform" />
					</td>
			
		
		
			<!-- BlueHarmony-DAD006  changed by Anand Sugumaran 
					<td width="12">&nbsp;</td>
					<td width="150"><label for="ssAnniversaryContractAmount"><oppt:label
						label="S&amp;S Anniversary contract amount:"
						id="ssAnniversaryContractAmount" errorLables="<%=errorValues%>" /></label>
					</td>
 
					<td width="188"><oppt:text name="ssAnniversaryContractAmount"
						styleId="ssAnniversaryContractAmount"
						value="<%=actionForm.getSsAnniversaryContractAmount()%>"
						maxlength="12" size="12" styleClass="iform" /></td>
					
          		</tr>
				
				
				<tr id="ssAnninversaryAmountPeriod2">
			   <td width="0" height="40">&nbsp;</td>
			
            <td width="150"><label for="ssAnninversaryAmountPeriod2"><oppt:label label="S&amp;S&nbsp;Anniversary amount&nbsp;period&nbsp;2:" id="ssAnninversaryAmountPeriod2" errorLables="<%=errorValues%>" /></label></td>
			<td width="188"><oppt:text name="ssAnninversaryAmountPeriod2"  styleId="ssAnninversaryAmountPeriod2" value="<%=actionForm.getSsAnninversaryAmountPeriod2()%>" maxlength="12" size="12" styleClass="iform" disabled="true"/></td>
            
            <td width="5" height="40"> </td>
	   </tr>
	   	   <tr id="ssAnninversaryAmountPeriod3">
			<td width="0" height="40">&nbsp;</td>
			
            <td width="150"><label for="ssAnninversaryAmountPeriod3"><oppt:label label="S&amp;S&nbsp;Anniversary amount&nbsp;period&nbsp;3:" id="ssAnninversaryAmountPeriod3" errorLables="<%=errorValues%>" /></label></td>
			
            <td width="188"><oppt:text name="ssAnninversaryAmountPeriod3" styleId="ssAnninversaryAmountPeriod3" styleClass="iform" size="12" value="<%=actionForm.getSsAnninversaryAmountPeriod3() %>" maxlength="12"  disabled="true"/></td>
            <td width="5" height="40"></td>
	   </tr>
	   	   <tr id="ssAnninversaryAmountPeriod4">
			<td width="0" height="40">&nbsp;</td>
			
            <td width="150"><label for="ssAnninversaryAmountPeriod4"><oppt:label label="S&amp;S&nbsp;Anniversary amount&nbsp;period&nbsp;4:" id="ssAnninversaryAmountPeriod4" errorLables="<%=errorValues%>" /></label></td>
			
            <td width="188"><oppt:text name="ssAnninversaryAmountPeriod4" styleId="ssAnninversaryAmountPeriod4" styleClass="iform" size="12" value="<%=actionForm.getSsAnninversaryAmountPeriod4() %>" maxlength="12" disabled="true" /></td>
            <td width="5" height="40"></td>
	   </tr>
	   	   <tr id="ssAnninversaryAmountPeriod5">
			<td width="0" height="40">&nbsp;</td>
			
            <td width="150"><label for="ssAnninversaryAmountPeriod5"><oppt:label label="S&amp;S&nbsp;Anniversary amount&nbsp;period&nbsp;5:" id="ssAnninversaryAmountPeriod5" errorLables="<%=errorValues%>" /></label></td>
			<td width="188"><oppt:text name="ssAnninversaryAmountPeriod5" styleId="ssAnninversaryAmountPeriod5" styleClass="iform" size="12" value="<%=actionForm.getSsAnninversaryAmountPeriod5() %>" maxlength="12" disabled="true" /></td>
            <td width="5" height="40"></td>
	   </tr>
		<tr>
		<td width="12" height="40">&nbsp;</td>
			<td width="150"><label for="extendPeriod"><oppt:label label="Extend period:" id="extendPeriod" /></label></td>
	        <td width="188"><oppt:label label="<%=extendPeriod%>"/></td>
    	</tr>
		BlueHarmony-DAD006  changes End by Anand Sugumaran-->
				<tr>	
          <td height="30" width="12">&nbsp;</td>
					<td width="150">Currency code:</td>
					<td width="188"><oppt:label	label="<%= basicBean.getCurrencyCode()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="150">Billing date rule:</td>
					<td width="188"><oppt:label	label="<%=pricingBean.getBillingDateRule()%>" /></td>
				</tr>
				<tr>
					<td height="30" width="12">&nbsp;</td>
					<td width="150">Deviating date rule:</td>
					<td width="188"><oppt:label	label="<%=pricingBean.getDeviatingDateRule()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="150"><label for="strGSAIndChangeBasicProposal">GSA:</label></td>
					<%
					if (actionForm.isGsa()) 
					{
					%>
					<td width="188"><input type="checkbox" name="gsa"
						id="strGSAIndChangeBasicProposal" checked />
					</td>
					<%
					} 
					else 
					{
					%>
					<td><input type="checkbox" name="gsa" id="strGSAIndChangeBasicProposal" /></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td height="30" width="12">&nbsp;</td>
					<td width="150"><label for="strBillingBlock">Billing block:</label></td>
					<td width="188"><oppt:select name="billingBlock"
						id="strBillingBlock" options="<%=billingBlock%>"
						selectedOption="<%=actionForm.getBillingBlock()%>"
						title="select Billing block" />
					</td>
					<td width="12">&nbsp;</td>
					<td width="150">Advance:</td>
					<td width="188"><oppt:label label="<%=advance%>" /></td>
				</tr>
				<tr>
					<td height="30" width="12">&nbsp;</td>
					<td width="150"><label for="strFreeText">Free text for invoice print:</label></td>
					<td colspan="4"><html:textarea property="freeTextForInvoicePrint"
						rows="2" cols="44" styleId="strFreeText" styleClass="iform">
						<%=actionForm.getFreeTextForInvoicePrint()%></html:textarea>
					</td>
				</tr>
			</table>
			&nbsp;<br />

			<table summary="Purchase Order Data" cellpadding="0" cellspacing="0" border="0"	width="700">
				<tr align="left">
					<th colspan="6" height="18" class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Purchase order	data</th>
				</tr>
				<tr>
					<td height="2" colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td width="12" height="30">&nbsp;</td>
					<td width="150"><label for="strPOnumber">P.O. number:</label></td>
					<td width="188">
					<%
					if (null != actionForm.getPurchaseOrderNumber()) 
					{
					%> 
						<oppt:text name="purchaseOrderNumber" styleId="strPOnumber"
							value="<%=actionForm.getPurchaseOrderNumber()%>" maxlength="35"
							size="8" styleClass="iform" /> 
					<%
					} 
					else 
					{
					%> 
						<oppt:text name="purchaseOrderNumber" styleId="strPOnumber"
						value="" maxlength="35" size="8" styleClass="iform" /> 
					<%
					}
					%>
					</td>
					<td width="12">&nbsp;</td>
					<td width="150"><label ><oppt:label
						label="P.O. date:" id="purchaseOrderDateLbl"
						errorLables="<%=errorValues%>" /></label>
					</td>
					<td width="188"><oppt:dateOptions name="purchaseOrderDate"
						years="<%=yearList%>" date="<%=purchaseOrderDate%>"
						alt="Purchase order date" />
					</td>
				</tr>
			</table>
			&nbsp;<br />

			<table summary="Variance" cellpadding="0" cellspacing="0" border="0"	width="700">
				<tr align="left">
					<th colspan="6" height="18" class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Variance</th>
				</tr>
				<tr>
					<td height="2" colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td width="12" height="20">&nbsp;</td>
					<td width="150">CAP amount:</td>
					<td width="188"><oppt:double doubleValue="<%=varianceBean.getCapAmount()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="150">-<oppt:double doubleValue="<%=varianceBean.getCapMinus()%>" />%</td>
					<td width="188">+<oppt:double doubleValue="<%=varianceBean.getCapPlus()%>" />%</td>
				</tr>
			</table>
			&nbsp;<br />

			<table summary="Sales org" cellpadding="0" cellspacing="0" border="0"	width="700">
				<tr align="left">
					<th colspan="6" height="18" class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Sales org</th>
				</tr>
				<tr>
					<td height="2" colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td width="12" height="30">&nbsp;</td>
					<td width="150">Sales organization:</td>
					<td width="188"><oppt:label	label="<%=basicBean.getSalesOrganization()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="150">Distribution channel:</td>
					<td width="188"><oppt:label	label="<%=basicBean.getDistributionChannel()%>" /></td>
				</tr>
				<tr>
					<td height="20" width="12">&nbsp;</td>
					<td width="150">Division:</td>
					<td width="188"><oppt:label label="<%=basicBean.getDivision()%>" /></td>
					<td width="12">&nbsp;</td>
					<td width="150">&nbsp;</td>
					<td width="188">&nbsp;</td>
				</tr>
			</table>
			&nbsp;<br />

			<table summary="Financing data" cellpadding="0" cellspacing="0" border="0"	width="700">
				<tr align="left">
					<th colspan="5" height="18" class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Financing data</th>
				</tr>
				<tr>
					<td height="2" colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td width="12" height="20">&nbsp;</td>
					<td width="150">CAL #:</td>
					<td width="538"><oppt:label label="<%=financeContractNo%>" /></td>
					<!-- BH Wave1 -DAD003 - Complex Contract Identifiers - Begin - Manoj -->
					<td width="150"><label><oppt:label label="Special&nbsp;billing&nbsp;indicator:" id="preBillIndicator" errorLables="<%=errorValues%>" /></label></td>
	<td width="188"><oppt:select selectedOption="<%=pricingBean.isPrebillIndicator()%>" 
   			name="pricingInformation.prebillIndicator" id="prebillIndicator" options="<%=specialBillingIndicator%>"  title="Select Special Billing Indicator" />
	    <!-- BH Wave1 -DAD003 - Complex Contract Identifiers - End - Manoj -->
				</tr>
			</table>

			<table summary="comments" cellpadding="0" cellspacing="0" border="0"	width="700">
				<tr>
					<th height="2" colspan="3" scope="col">&nbsp;</th>
				</tr>
				<tr align="left">
					<th colspan="3" height="18" class="bar-blue-med" scope="col" style="background-color:#cccccc;" >Comments</th>
				</tr>
				<tr>
					<td width="12" height="20"></td>
					<td width="150">Comments:</td>
					<td width="638">&nbsp;</td>
				</tr>
			</table>
			&nbsp;<br />
			<table role="presentation" border="0" cellspacing="0" cellpadding="0"	align="left">
				<tr>
					<td><oppt:button id="save" name="multipleButtonManager.save"
						alt="Save" value="Save" primary="true"
						buttonFlags="<%=buttonFlags %>" />
					</td>
					<td><oppt:button id="clearAll"
						name="multipleButtonManager.clearAll" alt="Clear all"
						 value="Clear all" buttonFlags="<%=buttonFlags %>" />
					</td>
					<td><oppt:button id="cancel" name="multipleButtonManager.cancel"
						alt="Cancel"  value="Cancel"
						buttonFlags="<%=buttonFlags %>" />
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

<script language="JavaScript" type="text/javascript">
	function populateDate(month, day, year, currentElement, dateType){
		var form = parent.document.AmendContractActionForm;
		var proposalType = form.proposalType.value;
			
		if((proposalType !="TP")){
			day.options.selectedIndex = 1;
		}
	}
	//CR6153 changes starts
	
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
  // CR6153 changes ends	
</script>
