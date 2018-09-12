<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalDetailsViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DMViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ProposalDetailsViewBean view = (ProposalDetailsViewBean) opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = view.getButtonFlags();
	int pageIndex = view.getPageIndex();
	int totalPages = view.getTotalNoOfPages();
	int mlcTotalPages = view.getMLCTotalNoOfPages();
	int mlcExcess = view.getMLCExcess();
    String proposalTypeDesc =null ;
    String proposalNameType =null ;
    String proposalType =view.getProposalType();
	String proposalContent = view.getProposalContent();
    
    if(proposalType.equalsIgnoreCase(ProposalTypeConstants.ESSO)){
				if(proposalContent.equalsIgnoreCase("M")){
					proposalTypeDesc ="MLC";
					proposalNameType = view.getProposalName()+" ("+proposalTypeDesc+")"; 				
				}
				else{			
					proposalTypeDesc ="SandS";
					proposalNameType = view.getProposalName()+" ("+proposalTypeDesc+")";
				    }
			}
	
	else{
	proposalNameType = view.getProposalName()+"("+OPPTStaticDataHolder.getProposalTypeDesc(proposalType)+")";
	}
	String priceDefaultString = "-";
	if(view.isPriced()){
		priceDefaultString = "0.00";
	}
%>

<style type="text/css">
a.rlinks:link { text-decoration: none; color: #ffffff; }
a.rlinks:visited { text-decoration: none; color: #ffffff; }
a.rlinks:hover { text-decoration: underline; color: #ffffff;}
a.highlight:link { text-decoration: none; color: #FFEE22;}
</style>


<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<%
					if(view.isContract()){
				%>
				
					<h1><br>Contract maintenance</h1>
					<%
					}
					else if(view.isProposalForApproval()){
				%>
				<h1><br>Proposals for approval</h1>
				
				<%
					}
					else{
				%>
				
					<h1><br>Proposal maintenance </h1> 
				
				
				
					<p><em><br><%
					if(view.isDuplicateSerial()) {
					%>
						Duplicate serial numbers
					<% } else { %>
						Proposal details
					<% } %></em></p>
					
					<%} %>
						
		</div>
	</div>
<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="700" role="presentation">
	<tr valign="top">
		<td>
			<table width="700" role="presentation">
				<%
					if(view.isContract()){
				%>
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td class="bar-gray-dark">Contract name: <%=proposalNameType %></td>
				</tr>
				<%
					}
					else if(view.isProposalForApproval()){
				%>
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td class="bar-gray-dark">Proposal name: <%=proposalNameType %></td>
				</tr>
				<%
					}
					else{
				%>
				
				
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td class="bar-gray-dark">Proposal name: <%=proposalNameType %></td>
				</tr>
				
				<%
					}
				%>
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<%
							if(view.isSearchLicenses()){
						%>
						<p>Search results for <oppt:label label="<%=view.getSearchString()%>" /></p>
						<p><a href="ProposalDetails.wss">Proposal details</a></p>
						<%
							}
						%>
					
						<%	
								if(view.isDuplicateSerial()) {
						%>
						<p>This page displays licenses with the same serial number. If a SWO should be removed, use the tick box 
						to select that SWO and press the Delete button. When you are finished click the Continue button. Use the 
						Clear all button to discard your input. Use the Cancel button to go back to the Proposal details screen.</p>
						<% } else { %>
						<p>This page displays the inventory retrieved according to the selections you made for the proposal. 
						All valid licenses for each of the customers you selected are shown. The entries are divided according 
						to Sold-to party, Designated machine and Software Licenses. Use the tick box to select a Sold-to party, 
						Designated machine or SWO and press the respective button for the transaction you wish to perform.</p>
						<% } %>
				
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

&nbsp;<br />
<table role="presentation">
<tr>
<td>
<table class="ibm-alternating" align="left" border="0" cellspacing="0" cellpadding="0" width="700" summary="layout">
	<tr>
		<td>
			<table align="center" border="0" cellspacing="0" cellpadding="0" width="700" role="presentation">
				<tr align="left">
					<td><div class="ibm-alternate-rule">&nbsp;</div></td>
				</tr>
				<tr align="left">
					<td><oppt:pageIterator mlcExcessValue="<%=mlcExcess %>" mlcTotalPages="<%=mlcTotalPages %>" pageIndex="<%=pageIndex%>" searchLicenses="<%=view.isSearchLicenses() %>" totalPages="<%=totalPages%>" url="GoToAction.wss" duplicateSerial = "<%=view.isDuplicateSerial()%>"/></td>
				</tr>
				<tr align="left">
					<td><div class="ibm-alternate-rule">&nbsp;</div></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<%
	if(view.isContractInAmendment()){
%>
<tr>
<td>
<p>Amend effective date:<oppt:date date="<%=view.getAmendmentEffectiveDate() %>" /></p>
<%
	}
%>
</td>
</tr>
<tr>
<td>
<table width="700" cellpadding="1" cellspacing="1" border="0" role="presentation">
	<tr>
	<%	
		if(!view.isDuplicateSerial()) {
	%>
		<td width="197">
			<table border="0" cellspacing="2" cellpadding="0" role="presentation">
				<tr>
					<html:form action="/protect/SearchLicenses.wss">
						<td><label for="strSearch">Search&nbsp;</label></td>
						<td valign="top"><input type="text" name="searchCriteria" maxlength="40" size="10" value="" class="iform" id="strSearch" /></td>
						<td valign="top">&nbsp;
						<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.go"  value="Go"   alt="Go"/></span>
						</td>
					</html:form>
				</tr>
			</table>
		</td> <% } %>
		<td width="205">
			<table border="0" cellspacing="2" cellpadding="0" role="presentation">
				<tr>
					<html:form action="/protect/GoToAction.wss">
						<input type="hidden" name="totalPagesValue" value="<%=String.valueOf(view.getTotalNoOfPages()) %>" /> 
						<input type="hidden" name="mlcTotalPagesValue" value="<%=String.valueOf(view.getMLCTotalNoOfPages()) %>" /> 
						<input type="hidden" name="mlcExcessValue" value="<%=String.valueOf(view.getMLCExcess()) %>" /> 
						<input type="hidden" name="searchLicenses" value="<%=String.valueOf(view.isSearchLicenses()) %>" />
						<input type="hidden" name="duplicateSerial" value="<%=String.valueOf(view.isDuplicateSerial()) %>" />
						<td><label for="strPageNo">Page number&nbsp;</label></td>
						<td valign="top"><input type="text" name="pageNumberValue" maxlength="4" size="4" value="" class="iform" id="strPageNo" /></td>
						<td >&nbsp;&nbsp;&nbsp;</td>
						<td valign="top">&nbsp;
						<span class="button-blue" valign="top"><input type="submit" id="go" name="multipleButtonManager.go" value="Go"   alt="Go"/></span>
</td>
					</html:form>
				</tr>
			</table>
		</td>
		<%
		if((!view.isSAndS()) && (!view.isDuplicateSerial()))
		{
				if(view.isPriced()){
		%>
			<td width="185 valign="middle">Invoice amount: <oppt:double lableStyle="ast" doubleValue="<%=view.getInvoiceAmount() %>" /></td>
		<%
				}
				else{
		%>
			<td width="185" valign="middle">Invoice amount: -</td> 
		<%
				}
			}
			else
			{		
		%>
			<td width="185">&nbsp;&nbsp;&nbsp;</td>
		<%
		}
		%>
	</tr>
</table>
</td>
</tr>
</table>


<form name="ProposalDetails" method="post" action="ProposalDetailsMultipleAction.wss">
	
	<%
		if(view.isSAndS() && null != view.getCustomers())
		{
	%>
	   <table width="700" cellpadding="1" cellspacing="1" border="0" role="presentation">
		<tr>
		<%
			if(view.isProposalEditable()){
		%>
			<td width="20" height="18">&nbsp;&nbsp;</td>
			<td width="357" colspan="5">MLC Products</td>	
		<%
			}
			else{
		%>
			<td width="380" colspan="5" height="18">MLC Products</td>	
		<%
			}
		%>
				
			<td width="84">MLC Invoice amount:</td>
		<%
			if(view.isPriced())
			{
		%>
			<td width="84"><oppt:double lableStyle="ast" doubleValue="<%=view.getInvoiceAmount() %>" /></td>
		<%
			}
			else
			{
		%>
			<td width="84" align="center"> - </td> 
		<%
			}
		%>
			<td width="37">&nbsp;</td>
		</tr></table>
	<%
		}
	
	TreeMap customers = view.getCustomers();
	if (null != customers) 
	{
		Iterator customerIterator = customers.keySet().iterator();
		while(customerIterator.hasNext()) 
		{
			String customerId = customerIterator.next().toString();
			CustomerViewBean customer = (CustomerViewBean)customers.get(customerId);
			if(null != customer) 
			{
%>
		<%if(view.isDuplicateSerial()) { %>
		    <table width="700" cellpadding="1" cellspacing="1" border="0" role="presentation">
			<oppt:customer id="<%=customerId %>" customer="<%=customer %>" proposalEditable="<%=view.isProposalEditable() %>" duplicateSerial ="true" />
			</table>
		<%} else { %>
			<table width="700" cellpadding="1" cellspacing="1" border="0" role="presentation">
			<oppt:customer id="<%=customerId %>" customer="<%=customer %>" proposalEditable="<%=view.isProposalEditable() %>" />
			</table>
		<%}%>
<%
				TreeMap dms = customer.getDMs();
				if(null != dms && 0 < dms.size())
				{
					Iterator dmIterator = dms.keySet().iterator();
					while(dmIterator.hasNext())
					{
						String dmId = dmIterator.next().toString();
						DMViewBean dm = (DMViewBean)dms.get(dmId);
						if(null != dm)
						{
%>
		<%if(view.isDuplicateSerial()) { %>
		<table width="700" cellpadding="1" cellspacing="1" border="0" role="presentation">
		<oppt:dm id="<%=dmId %>" proposalEditable="<%=view.isProposalEditable() %>" dm="<%=dm %>" customerId="<%=customerId %>" duplicateSerial ="true" />
		</table>
		<%} else { %>
		<table width="700" cellpadding="1" cellspacing="1" border="0" role="presentation">
		<oppt:dm id="<%=dmId %>" proposalEditable="<%=view.isProposalEditable() %>" dm="<%=dm %>" customerId="<%=customerId %>"  />
        </table>
		<%}%>
		<table width="700" cellpadding="1" cellspacing="1" border="0" summary="License information">
		<oppt:licenses proposalEditable="<%=view.isProposalEditable() %>" customerId="<%=customerId %>" licenses="<%=dm.getSwos()%>" dmId="<%=dmId %>" copiedDM="<%=dm.isCopiedDM()%>" onlyQuotes="<%=dm.isOnlyQuotes()%>" selectAllLicenses = "<%=view.isSelectAll()%>" clearAllLicenses = "<%=view.isClearAll()%>" />
		<tr>
			<td>&nbsp;</td>
		</tr></table>
<%								
						}
					}	
				}
				else{
%>
        <table width="700" cellpadding="1" cellspacing="1" border="0" summary="ProposalEditable">
		<tr>
<%
					if(view.isProposalEditable()){
%>
			<td valign="bottom" colspan="9" align="left">&nbsp;&nbsp;<%=Constants.NO_DMS_FOR_STP %><br />
<%
					}
					else{
%>
			<td valign="bottom" colspan="8" align="left">&nbsp;&nbsp;<%=Constants.NO_SWOS_FOR_DM %><br />
<%
					}
%>
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr></table>
<%						
				}
%>      <table width="700" cellpadding="1" cellspacing="1" border="0" summary="space">
		<tr>
			<td>&nbsp;</td>
		</tr></table>
<%
			}
		}
	}
		// For S&S 
		if(null != view.getSAndSCustomers())
		{
	%>
	    <table width="700" cellpadding="1" cellspacing="1" border="0" summary="isProposalEditable"> 
		<tr>
		<%
			if(view.isProposalEditable()){
		%>
			<td width="20" height="18">&nbsp;&nbsp;</td>
			<td width="357" colspan="5">S&amp;S Products</td>	
		<%
			}
			else{
		%>
			<td width="380" colspan="5" height="18">S&amp;S Products</td>	
		<%
			}
		%>
				
			<td width="84">Total S&amp;S discounted amount:</td>
		<%
			if(view.isPriced())
			{
		%>
			<td width="84"><oppt:double lableStyle="ast" doubleValue="<%=view.getSAndSDiscountAmount() %>" /></td>
		<%
			}
			else
			{
		%>
			<td width="84" align="center"> - </td> 
		<%
			}
				/* start change CR6153 */	
			double[]  sAndSExtendedDiscountAmount = new double[5];
			
			sAndSExtendedDiscountAmount[0] = view.getSAndSDiscountAmount1();
			sAndSExtendedDiscountAmount[1] = view.getSAndSDiscountAmount2();
			sAndSExtendedDiscountAmount[2] = view.getSAndSDiscountAmount3();
			sAndSExtendedDiscountAmount[3] = view.getSAndSDiscountAmount4();
			sAndSExtendedDiscountAmount[4] = view.getSAndSDiscountAmount5();
			
		
			for(int x=0; x<view.getSAndSExtendedYears();x++){
			%>
			<tr>
			<td width="100" height="18">&nbsp;&nbsp;</td>
			<td width="100" colspan="4">&nbsp;&nbsp;</td>			
			<td width="450" colspan="2">S&amp;S discount for year <%=x+1%>: </td>	
			<%
			if(view.isPriced())
			{
			%>
			<td width="84" align="right"><oppt:double lableStyle="ast" doubleValue="<%=sAndSExtendedDiscountAmount[x] %>" /></td>
			<%
			}
			else
			{
			%>
			<td width="84" align="center"> - </td> 
			<%
			}
			%>
			</tr>
			<%
			}
		/* end change CR6153 */
		%>
		 <tr>
			<td width="37">&nbsp;</td>
		</tr></table>
	<%
		}
	
	TreeMap ssCustomers = view.getSAndSCustomers();
	if (null != ssCustomers) 
	{
		Iterator customerIterator = ssCustomers.keySet().iterator();
		while (customerIterator.hasNext()) 
		{
			String customerId = customerIterator.next().toString();
			CustomerViewBean customer = (CustomerViewBean)ssCustomers.get(customerId);
			if (null != customer) 
			{

%>
		<%if(view.isDuplicateSerial()) { %>
       		<table width="700" cellpadding="1" cellspacing="1" border="0" summary="Display Customer ID">
			<oppt:customer id="<%=customerId %>" customer="<%=customer %>" sands="true" proposalEditable="<%=view.isProposalEditable() %>" duplicateSerial ="true" />
			</table>
		<% } else { %>
    		<table width="700" cellpadding="1" cellspacing="1" border="0" summary="Display Customer ID">
			<oppt:customer id="<%=customerId %>" customer="<%=customer %>" sands="true" proposalEditable="<%=view.isProposalEditable() %>" />
			</table>
		<% }%>
<%
				TreeMap dms = customer.getDMs();
				if(null != dms && 0 < dms.size())
				{
					Iterator dmIterator = dms.keySet().iterator();
					while(dmIterator.hasNext())
					{
						String dmId = dmIterator.next().toString();
						DMViewBean dm = (DMViewBean)dms.get(dmId);
						if(null != dm)
						{
%>
		<%if(view.isDuplicateSerial()) { %>
    		<table width="700" cellpadding="1" cellspacing="1" border="0" role="presentation">
			<oppt:dm proposalEditable="<%=view.isProposalEditable() %>" sands="true" dm="<%=dm %>" customerId="<%=customerId %>" id="<%=dmId %>"  duplicateSerial ="true" />
			</table>
		<% } else { %>	
			<table width="700" cellpadding="1" cellspacing="1" border="0" role="presentation">
			<oppt:dm proposalEditable="<%=view.isProposalEditable() %>" sands="true" dm="<%=dm %>" customerId="<%=customerId %>" id="<%=dmId %>"  />
			</table>
		<% }%>									
		<table width="700" cellpadding="1" cellspacing="1" border="0" summary="License Information">
		<oppt:licenses proposalEditable="<%=view.isProposalEditable() %>" sands="true" customerId="<%=customerId %>" licenses="<%=dm.getSwos()%>" dmId="<%=dmId %>" copiedDM="<%=dm.isCopiedDM()%>" onlyQuotes="<%=dm.isOnlyQuotes()%>" selectAllLicenses = "<%=view.isSelectAll()%>" clearAllLicenses = "<%=view.isClearAll()%>" />
		
		<tr>
			<td>&nbsp;</td>
		</tr></table>
<%								
						}
					}	
				}
				else{
%>     <table width="700" cellpadding="1" cellspacing="1" border="0" summary="ProposalEditable">
		<tr>
<%
					if(view.isProposalEditable()){
%>
			<td valign="bottom" colspan="9" align="left">&nbsp;&nbsp;<%=Constants.NO_SWOS_FOR_DM %><br />
<%
					}
					else{
%>
			<td valign="bottom" colspan="8" align="left">&nbsp;&nbsp;<%=Constants.NO_SWOS_FOR_DM %><br />
<%
					}
%>
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr></table>
<%						
				}
%>      <table width="700" cellpadding="1" cellspacing="1" border="0" summary="space">  
		<tr>
			<td>&nbsp;</td>
		</tr></table>
<%
			}
		}
	}
%>
	
	<table role="presentation" align="left">
		<tr>
			<td>
			<%if(view.isDuplicateSerial()) { %>
				<oppt:buttons buttonFlags="<%=buttonFlags %>" cellCount="5">
					<oppt:opptbutton id="continue" name="multipleButtonManager.confirmDeleteDuplicateSerial" value="Continue" alt="Continue"   />
					<oppt:opptbutton id="deleteDuplicateSerial" name="multipleButtonManager.deleteDuplicateSerial" value="Delete" alt="Delete" />
					<oppt:opptbutton id="selectAll" name="multipleButtonManager.selectAll" alt="Select all" value="Select all" />
					<oppt:opptbutton id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" value="Clear all"  />
					<oppt:opptbutton id="cancelDuplicateSerial" name="multipleButtonManager.cancelDuplicateSerial" alt="Cancel" value="Cancel"  />
				</oppt:buttons>	
				
			<% } else { %>
				<oppt:buttons buttonFlags="<%=buttonFlags %>">
					<oppt:opptbutton id="headerDetails" name="multipleButtonManager.headerDetails" alt="Delete" value="Delete" />
					<!--
					<oppt:opptbutton id="changeProposal" name="multipleButtonManager.changeProposal" value="Change Proposal" alt="Change proposal" />
					-->
					
					<oppt:opptbutton id="fetchPlan" name="multipleButtonManager.fetchPlan" alt="Fetch plan" value="Fetch plan"  />
					<oppt:opptbutton id="fetchIneligible" name="multipleButtonManager.fetchIneligible" alt="Fetch ineligible" value="Fetch ineligible"  />
					<oppt:opptbutton id="refetch" name="multipleButtonManager.refetch" alt="Refetch" value="Refetch"  />
					<oppt:opptbutton id="price" name="multipleButtonManager.price" alt="Price" value="Price"  />
					<oppt:opptbutton id="validateTP" name="multipleButtonManager.validateTP" alt="Validate TP" value="Validate TP" />
					<oppt:opptbutton id="edit" name="multipleButtonManager.edit" alt="Edit" value="Edit" />
					<oppt:opptbutton id="delete" name="multipleButtonManager.delete" alt="Delete" value="Delete" />
					<oppt:opptbutton id="copyNew" name="multipleButtonManager.copyNew" alt="Copy new" value="Copy new"  />
					<oppt:opptbutton id="copyBump" name="multipleButtonManager.copyBump" alt="Copy bump" value="Copy bump " />
					<oppt:opptbutton id="configureDM" name="multipleButtonManager.configureDM" alt="Configure DM" value="Configure DM" />
					<oppt:opptbutton id="incexc" name="multipleButtonManager.incexc" alt="Include/Exclude" value="Inc/Exc"/>
					<%--DADO02 BHWave1 Sateesh Anne <oppt:opptbutton id="addCustomer" name="multipleButtonManager.addCustomer" alt="Add customer" value="Add customer" primary="true"/> --%>
					<oppt:opptbutton id="removeSVCLicenses" name="multipleButtonManager.removeSVCLicenses" alt="Remove SVC" value="Remove SVC"/>
					<oppt:opptbutton id="register" name="multipleButtonManager.register" alt="Register" value="Register"  />
					<oppt:opptbutton id="ssPlanning" name="multipleButtonManager.ssPlanning" alt="S&amp;S planning" value="S&amp;S planning" />
					<oppt:opptbutton id="removeQuotes" name="multipleButtonManager.removeQuotes" alt="Remove quotes" value="Remove quotes" />
					<oppt:opptbutton id="amendSWO" name="multipleButtonManager.amendSWO" alt="Amend swo" value="Amend swo" />
					<oppt:opptbutton id="deltaFetch" name="multipleButtonManager.deltaFetch" alt="Delta fetch" value="Delta fetch" />
					<oppt:opptbutton id="compareTP" name="multipleButtonManager.compareTP" alt="Compare TP" value="Compare TP"  />
					<oppt:opptbutton id="reject" name="multipleButtonManager.reject" alt="Reject proposal" value="Reject proposal" />
					<oppt:opptbutton id="approve" name="multipleButtonManager.approve" alt="Approve proposal" value="Approve proposal" />
					<oppt:opptbutton id="duplicateSerialNumbers" name="multipleButtonManager.duplicateSerialNumbers" alt="Duplicate serial no" value="Duplicate serial no"/>
				</oppt:buttons>
			<%}%>	
			</td>
		</tr>
	<%
		if(view.showPrintProposal()){
	%>
		<tr>
			<td>
				<table summary="printProposal">
					<tr>
						<td valign="top"><oppt:button id="printProposal" name="multipleButtonManager.printProposal" primary="true" alt="View proposal" value="   View proposal   "  buttonFlags="<%=buttonFlags %>" />(20KB)</td>
					</tr>
				</table>
			</td>
		</tr>
	<%
		}
	%>
	</table>
</form>
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


