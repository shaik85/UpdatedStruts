
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.RenewContractViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<!-- start change CR6153 -->
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender"%>
<!-- end change CR6153 -->
<%
	ErrorReport errorReport = null;
	ArrayList buttonFlags = null;
	OPPTSession opptSession = new OPPTSession(session);
	RenewContractViewBean viewBean = (RenewContractViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Contract renewal</em></p>		
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
						<p>To renew a contract, press the Renew button. Press the Cancel button to go
						 back to contract maintenance page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />

<table summary="Renew Contract Details" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/RenewMultipleAction.wss">
			<table summary="isChooseRenewalType" cellpadding="0" cellspacing="0" border="0" width="600">
				<tr align="left">
			<%
				if(viewBean.isChooseRenewalType()){
			%>
					<td><input type="radio" name="anniversaryRenewal" id="anniversaryRenewal" value="true" checked="checked" />&nbsp;<label for="anniversaryRenewal">Anniversary renewal</label></td>
					<td><input type="radio" name="anniversaryRenewal" id="nonAnniversaryRenewal" value="false" />&nbsp;<label for="nonAnniversaryRenewal">Non - Anniversary renewal</label></td>
					
			<%
				}
				else{
			%>	
			<%
					if(viewBean.isAnniversaryRenewal())
					{
			%>
					<td height="18" colspan="2" style="background-color:#cccccc;" class="bar-blue-med"><input type="hidden" name="anniversaryRenewal" value="true" />&nbsp;Anniversary renewal</td>
			<%
					}
					else
					{
			%>
					<td height="18" colspan="2" style="background-color:#cccccc;" class="bar-blue-med"><input type="hidden" name="anniversaryRenewal" value="false" />&nbsp;Non - Anniversary renewal</td>
			<%
					}
				}
			%>
				</tr>
				<tr>
					<td width="200" height="25">&nbsp;&nbsp;Proposal name:</td>
					<td width="223">&nbsp;&nbsp;<oppt:label label="<%=viewBean.getProposalName()%>"/></td>
				</tr>
				<tr>
					<td height="25">&nbsp;&nbsp;Proposal type:</td>
					<td>&nbsp;&nbsp;<oppt:label label="<%=viewBean.getProposalType()%>"/></td>
				</tr>
				<tr>
					<td height="25">&nbsp;&nbsp;Contract type:</td>
					<td>&nbsp;&nbsp;<oppt:label label="<%=viewBean.getContractType()%>"/></td>
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
					<td height="25">&nbsp;&nbsp;Extend Period:</td>
					<td height="25">&nbsp;&nbsp;<oppt:label label="checked" /></td>
				</tr>
				<%
					}
					else
					{
				%>
				<tr>
					<td height="25">&nbsp;&nbsp;Extend Period:</td>
					<td height="25">&nbsp;&nbsp;<oppt:label label="unchecked" /></td>
				</tr>				
				<%
					}
				}
				%>
				<!-- end change CR6153 -->				
				<tr>
					<td height="25">&nbsp;&nbsp;Contract number:</td>
					<td>&nbsp;&nbsp;<oppt:label label="<%=viewBean.getContractNumber()%>"/></td>
				</tr>
				<tr>
					<td height="25">&nbsp;&nbsp;External contract number:</td>
					<td>&nbsp;&nbsp;<oppt:label label="<%=viewBean.getExternalContractNumber()%>"/></td>
				</tr>
				<tr>
					<td height="25">&nbsp;&nbsp;Contract period start date:</td>
					<!-- start change CR6153 -->						
						<%
						
						Date cntrPeriodStrtDate = viewBean.getContractPeriodStartDate();
						Date cntrPeriodEndDate = viewBean.getContractPeriodEndDate();
						Date cntrStrtDate = 	viewBean.getContractStartDate();
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
							cntrStrtDate.setTime(startDateCalender.getTimeInMillis());	
							}
						}
						else
						{
							cntrPeriodStrtDate = viewBean.getContractPeriodStartDate();
							cntrPeriodEndDate = viewBean.getContractPeriodEndDate();	
							cntrStrtDate = 	viewBean.getContractStartDate();				
						}
						%>
						<td>&nbsp;&nbsp;<oppt:date date="<%=cntrPeriodStrtDate%>"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Contract period end date:</td>
						<td>&nbsp;&nbsp;<oppt:date date="<%=cntrPeriodEndDate%>"/></td>
					</tr>
					<!-- end change CR6153 -->	
				<!-- start change CR6153 -->
				<tr>
					<td height="25">&nbsp;&nbsp;Contract start date:</td>
					<td>&nbsp;&nbsp;<oppt:date date="<%=cntrStrtDate%>"/></td>
				</tr>
				<!-- end change CR6153  -->
				<tr>
					<td height="25">&nbsp;&nbsp;Contract end date:</td>
					<td>&nbsp;&nbsp;<oppt:date date="<%=viewBean.getContractEndDate()%>"/></td>
				</tr>
			</table>
			&nbsp;<br />
			<table role="presentation" align="right" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><oppt:button id="renew" name="multipleButtonManager.renew" alt="Renew" primary="true" value="Renew" buttonFlags="<%=buttonFlags %>" /></td>
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

