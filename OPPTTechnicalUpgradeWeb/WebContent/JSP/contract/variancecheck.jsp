
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.VarianceHeaderInformationViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	ErrorReport errorReport = null;
	ArrayList buttonFlags = null;
	String headerMessage = "";
	OPPTSession opptSession = new OPPTSession(session);
	VarianceHeaderInformationViewBean viewBean = (VarianceHeaderInformationViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		if(viewBean.isShowOption()){
			headerMessage = "Use this page for viewing and downloading report. Select report type and " +
			"click  on View button for viewing the report and click on Download button for downloading the report." +
			" To exit this page, click the Continue button";
		}
		else if(viewBean.isPositiveCap()){
			headerMessage = "Click on Create variance proposal button for creating variance proposal. " + 
			"To exit this page, click the Continue button";
		}
		else{
			headerMessage = "No action required.  To exit this page, click the Continue button";
		}
		errorReport.getErrorFieldNames();
	}
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Variance header</em></p>		
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
						
						<p><%=headerMessage%></p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="CheckVariance" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr>
		<td>
			<html:form action="protect/CheckVarianceMultipleAction.wss">
				<table role="presentation" cellspacing="0" cellpadding="0" width="600" border="0">
					<tr>
						<td width="300" height="25">&nbsp;&nbsp;External contract number:</td>
						<td width="300">&nbsp;&nbsp;<oppt:label label="<%=viewBean.getExternalContractNumber()%>"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Proposal type:</td>
						<td>&nbsp;&nbsp;<oppt:label label="<%=viewBean.getProposalType()%>"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Sold to customer no:</td>
						<td>&nbsp;&nbsp;<oppt:label label="<%=viewBean.getSoldToCustomerNumber()%>"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Variance date:</td>
						<td>&nbsp;&nbsp;<oppt:date date="<%=viewBean.getVarianceDate()%>"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Contract period start date:</td>
						<td>&nbsp;&nbsp;<oppt:date date="<%=viewBean.getContractPeriodStartDate()%>"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Contract period end date:</td>
						<td>&nbsp;&nbsp;<oppt:date date="<%=viewBean.getContractPeriodEndDate()%>"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Inventory at period start of contract:</td>
						<td>&nbsp;&nbsp;<oppt:double doubleValue="<%=viewBean.getInvAtPeriodStartOfContract()%>" /></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Cumulative actual inventory as of variance date:</td>
						<td>&nbsp;&nbsp;<oppt:double doubleValue="<%=viewBean.getCumulativeActualInvAsOfVarianceDate()%>"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;CAP amount:</td>
						<td>&nbsp;&nbsp;<oppt:double doubleValue="<%=viewBean.getCapAmount()%>" lableStyle="ast"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;CAP variance:</td>
						<td>&nbsp;&nbsp;<oppt:double doubleValue="<%=viewBean.getCapVariance()%>" lableStyle="ast"/></td>
					</tr>
					<tr>
						<td height="25">&nbsp;&nbsp;Currency:</td>
						<td>&nbsp;&nbsp;<oppt:label label="<%=viewBean.getCurrency()%>"/></td>
					</tr>
				</table>
				&nbsp;<br />
				<%
					if(viewBean.isShowOption())
					{
				%>
					<table role="presentation">
						<tr>
							<td><input type="radio" name="reportType" value="reportType9" id="rb11" /><label for="rb11">Variance report (All)</label></td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td>(20KB)</td>
						</tr>
						<tr>
							<td><input type="radio" name="reportType" value="reportType10" id="rb12" /><label for="rb12">Variance report (Price change)</label></td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td>(20KB)</td>
						</tr>
					</table>
					&nbsp;<br />
				<%
					}
				%>
				<table role="presentation" align="right" border="0" cellspacing="0">
					<tr valign="top">
						<td height="50"><oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue"  value="Continue"  buttonFlags="<%=buttonFlags %>" /></td>
			<%
				if(viewBean.showViewDownLoad())
				{
			%>
						<td><oppt:button id="view" name="multipleButtonManager.view" alt="View" value="View"  primary="true" buttonFlags="<%=buttonFlags %>" /><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="small" href="//www.adobe.com/products/acrobat/readstep2.html" target="_new">Get Adobe Reader</a></td>
						<td><oppt:button id="download" name="multipleButtonManager.download" alt="Download"  value="Download"  buttonFlags="<%=buttonFlags %>" /></td>
			<%
				}
				if(viewBean.showVarianceProposal())
				{
			%>
						<td><oppt:button  id="createVarianceProposal" name="multipleButtonManager.createVarianceProposal" primary="true" alt="Create Variance Proposal" value="Create var proposal"  buttonFlags="<%=buttonFlags %>" /></td>
			<%
				}
			%>
					</tr>
				</table>
				&nbsp;<br />						
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
