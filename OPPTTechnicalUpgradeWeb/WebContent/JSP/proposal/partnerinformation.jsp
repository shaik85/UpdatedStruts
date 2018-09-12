
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerInformationViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO" %>


<%
	OPPTSession opptSession = new OPPTSession(session); 
	PartnerInformationViewBean view = (PartnerInformationViewBean)opptSession.getCurrentViewBean();
	List customers = view.getSelectedCustomers();
	
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	
	
	
	
	//out.println("view.getSelectedCustomerNumber()" +view.getSelectedCustomerNumber());
	%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Partner details</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />

						<p>Press Fetch inventory button to retrieve the inventory for the proposal or press Fetch sel.inventory to retrieve selected SWOs only.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CreateProposalMultipleAction.wss">
	<table border="0" width="600" cellspacing="1" cellpadding="1" role="presentation">
		<tr>
			<td style="background-color:#999999;" class="bar-blue-med-dark" colspan="2" align="left">Enterprise information</td>
		</tr>
		<tr>
			<th align="left" width="207" id="customerListNumber" style="background-color:#cccccc;" class="bar-blue-med">Customer number</th>
			<th align="left" width="387" id="customerListName" style="background-color:#cccccc;" class="bar-blue-med">Customer name</th>
		</tr>
	
            <% if (null!=customers && customers.size()>0){
            Iterator iterator = customers.iterator();
                       
            while(iterator.hasNext()){
            CustomerListCustomDTO customer = (CustomerListCustomDTO)iterator.next();
            
             %>
		<tr>
			<td align="left" headers="customerListNumber">&nbsp;&nbsp;<oppt:label label="<%=customer.getCustomerNumber()%>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td align="left" headers="customerListName">&nbsp;&nbsp;<oppt:label label="<%=customer.getCustomerName()%>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
		</tr>
		<% } } %>
	</table>
	&nbsp;<br />
	
	
	
	
	<table border="0" cellspacing="1" cellpadding="1" width="600" summary="Partner Details">
		<tr>
			<th align="left" width="107" id="partnerType" style="background-color:#cccccc;" class="bar-blue-med">&nbsp;&nbsp;Partners</th>
			<th align="left" width="207" id="legacyNumber" style="background-color:#cccccc;" class="bar-blue-med">&nbsp;&nbsp;Site Id</th>
			<th align="left" width="277" id="name" style="background-color:#cccccc;" class="bar-blue-med">&nbsp;&nbsp;Name</th>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Sold to party:<br /> 
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<oppt:label label="<%=view.getSoldToPartyNumber() %>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=view.getSoldToPartyName() %>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
		</tr>		
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Bill to party:<br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<oppt:label label="<%=view.getBillToPartyNumber() %>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=view.getBillToPartyName() %>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Payer:<br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<oppt:label label="<%=view.getPayerNumber() %>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=view.getPayerName() %>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Ship to party:<br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<oppt:label label="<%=view.getShipToPartyNumber() %>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=view.getShipToPartyName() %>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	
	<table border="0" cellspacing="1" cellpadding="1" width="600" summary="SAP Customer Number">
		<tr>
			<th align="left" width="107" id="partnerType2" style="background-color:#aaaaaa;" class="bar-blue-med">&nbsp;&nbsp;Partners</th>
			<th align="left" width="207" id="sapCustomerNumber" style="background-color:#aaaaaa;" class="bar-blue-med">&nbsp;&nbsp;SAP Customer no.</th>
			<th align="left" width="277" id="name2" style="background-color:#aaaaaa;" class="bar-blue-med">&nbsp;&nbsp;Name</th>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;9E Partner:<br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="sapCustomerNumber">&nbsp;&nbsp;<oppt:label label="<%=view.getNineDPartnerNumber()%>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=view.getNineDPartnerName()%>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
		</tr>
	</table>
	
	 
	&nbsp;<br />
	<table width="600" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td align="left">&nbsp;&nbsp;Comments:</td>
		</tr>
		<tr>
			<td align="left">&nbsp;<oppt:label label="<%=view.getComments()%>" /><br />
			<div class="ibm-alternate-rule"><hr/>&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	<table align="left" border="0" cellspacing="0" cellpadding="0" role="presentation">
	     <tr>
	     <%if(null!=customers && customers.size()!=0 && customers.size()==1){%>
			<td><oppt:button id="fetchselectedinventoryinput" name="multipleButtonManager.fetchselectedinventoryinput" alt="fetchselectedinventoryinput"
				value="Fetch sel.inventory" primary="true" /></td>
		<td>&nbsp;</td>
		<%}%>
			<td><oppt:button id="fetchinventoryaction" name="multipleButtonManager.fetchinventoryaction" alt="fetchinventoryaction"
				value="Fetch inventory" primary="true" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
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

