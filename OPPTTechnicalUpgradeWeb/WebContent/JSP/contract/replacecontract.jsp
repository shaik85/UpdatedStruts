
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>


<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractReplacementViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<!-- start change CR6153 -->
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender"%>
<!-- end change CR6153 -->
<%
	ErrorReport errorReport = null;
	ArrayList yearList = null;
	ArrayList buttonFlags = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	ContractReplacementViewBean viewBean = (ContractReplacementViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		buttonFlags=viewBean.getButtonFlags();
		yearList = viewBean.getYearList();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Contract replacement</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">

<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use the radio button to select Copy proposal if you want to copy
						the header details and inventory from the contract into the new proposal 
						or select Create new proposal if you want to create a new proposal with a 
						new contract type and new inventory.  When you are finished click the Replace 
						button. Press the Clear all button to discard your input. Press the Cancel 
						button to go back to contract maintenance page.</p>
						
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
<table summary="SubmitReplaceContract" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/SubmitReplaceContractMultipleAction.wss">
				<table role="presentation" cellspacing="1" cellpadding="1"  border="0">
					<tr>
						<td width="12" height="25" align="center">&nbsp;</td>
						<td width="197" height="25">Proposal name:</td>
						<td width="225"><oppt:label label="<%=viewBean.getProposalName()%>"/></td>
					</tr>
					<tr>
						<td align="center">&nbsp;</td>
						<td height="25">Proposal type:</td>
						<td><input type="hidden" name="proposalType" value="<%=viewBean.getProposalType() %>" /><oppt:label label="<%=viewBean.getProposalType()%>" /></td>
					</tr>
					<tr>
						<td align="center">&nbsp;</td>
						<td height="25">Contract type:</td>
						<td><oppt:label label="<%=viewBean.getContractType()%>"/></td>
					</tr>
					<!-- start change CR6153 -->
					<%
	 				if ((viewBean.getProposalContent()!=null && viewBean.getProposalContent().equals(UtilityConstants.SANDS_ONLY))
	 				    && ((viewBean.getProposalType()!=null && viewBean.getProposalType().equals("ES"))
	 				    || (viewBean.getProposalType()!= null && viewBean.getProposalType().equals("AM"))))
					{
						if (viewBean.isExtendPeriod()!= null && viewBean.isExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD)) 
						{
					%>
					<tr>
						<td align="center">&nbsp;</td>
						<td height="25">Extend Period:</td>
						<td height="25"><oppt:label label="checked" /></td>
					</tr>
					<%
						}
						else
						{
					%>
					<tr>
						<td align="center">&nbsp;</td>
						<td height="25">Extend Period:</td>
						<td height="25"><oppt:label label="unchecked" /></td>
					</tr>				
					<%
						}
					}
					%>
					<!-- end change CR6153 -->		
					<tr>
						<td align="center">&nbsp;</td>
						<td height="25">Contract number:</td>
						<td><oppt:label label="<%=viewBean.getContractNumber()%>"/></td>
					</tr>
					<tr>
						<td align="center">&nbsp;</td>
						<td height="25">External contract number:</td>
						<td><oppt:label label="<%=viewBean.getExternalContractNumber()%>"/></td>
					</tr>
					<tr>
						<td align="center">&nbsp;</td>
						<td height="25">Contract period start date:</td>
					<!-- start change CR6153 -->						
						<%
						Date cntrPeriodStrtDate = viewBean.getContractPeriodStartDate();
						Date cntrPeriodEndDate = viewBean.getContractPeriodEndDate();
						OPPTCalender startDateCalender = new OPPTCalender();
						OPPTCalender endDateCalender = new OPPTCalender();

		 				if (viewBean.isExtendPeriod()!= null && viewBean.isExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD)) 
						{
							Date date = new Date();
							while(cntrPeriodEndDate.getTime()< date.getTime() && cntrPeriodEndDate.getTime() < viewBean.getContractEndDate().getTime())
							{
								startDateCalender.setTime(OPPTCalender.addDate(OPPTCalender.YEAR, 1, cntrPeriodStrtDate));
								endDateCalender.setTime(OPPTCalender.addDate(OPPTCalender.YEAR, 1, cntrPeriodEndDate));
								if(endDateCalender.getYear()%4 == 0 &&(endDateCalender.getYear()%100 != 0 || endDateCalender.getYear()%400 == 0))  
								{
									if(startDateCalender.getMonth() == 3 && startDateCalender.getDay()== 1 && (viewBean.getContractEndDate().getTime() > cntrPeriodEndDate.getTime()))
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
							cntrPeriodStrtDate = viewBean.getContractPeriodStartDate();
							cntrPeriodEndDate = viewBean.getContractPeriodEndDate();						
						}
						%>
						 <td><oppt:date date="<%=cntrPeriodStrtDate%>"/></td>
					</tr>
					<tr>
						<td align="center">&nbsp;</td>
						<td height="25">Contract period end date:</td>
						<td><oppt:date date="<%=cntrPeriodEndDate%>"/></td>
					</tr>
					<!-- end change CR6153 -->							
					<tr>
						<td align="center"></td>
						<td height="30"><label ><span class="ibm-required">*</span><oppt:label label="Contract replacement date:" id="replacementDateLbl"  /></label></td>
						<td>
							<oppt:dateOptions name="replacementDate" years="<%=yearList%>" date="<%=viewBean.getReplacementDate()%>"  onclick="populateDate" alt= "Contract replacement date " mandatory="true"/>
						</td>
					</tr>
					<tr align="left">
						<td align="center">&nbsp;</td>
									
						<td><input type="radio" name="copyCreate" id="radRepl" value="Copy" />&nbsp;<label for="radRepl">Copy proposal</label></td>
						<!--Added by srinivas-OPPTBH-DAD013  -->
						
						<td><input type="radio" name="copyCreate" id="radRep2" value="Create" checked="checked" />&nbsp;<label for="radRep2">Create new proposal</label></td>
					</tr>
				</table>
				&nbsp;<br />
				<table role="presentation" align="right" cellspacing="0" cellpadding="0" border="0">
					<tr>
						<td><oppt:button id="replace" name="multipleButtonManager.replace" alt="Replace" primary="true" value="Replace" buttonFlags="<%=buttonFlags %>" /></td>
						<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all"  value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
						<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel"  value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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



	
	function populateDate(month, day, year, currentElement, dateType){
		var proposalType = parent.document.ContractReplacementActionForm.proposalType.value;;
		if((proposalType !="TP")){
			day.options.selectedIndex = 1;
		}
	}
</script>