<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerSelectionViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.PartnerSelectionActionForm" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	PartnerSelectionViewBean view = (PartnerSelectionViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	PartnerSelectionActionForm actionForm = view.getPartnerSelectionActionForm();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Partner selection</em></p>		
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

						<p>Use this form to change Partners or input a 9E Partner. When you are 
						finished, click the Save button. Select "other" option in any of the drop 
						down menus and click on Alternate partner button to go to alternate partner 
						screen. Use the alternate partner button to validate the  9E partner number. 
						When CAL number is provided, enter the Bill to party or Payer number and click 
						on Alternate partner button to validate the partner information. Press the 
						Clear all button to discard your input. Press the Cancel button to go back 
						to proposal maintenance page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/PartnerSelectionMultipleAction.wss" method="get">
	<input type="hidden" name="igfNumber" value="<%=String.valueOf(view.isIGFFlag()) %>" />
	<table border="0" width="600" cellspacing="1" cellpadding="1" summary="enterprise info">
		<tr>
			<th colspan="2" scope="col" style="background-color:#999999;">&nbsp;&nbsp;Enterprise information</th>
		</tr>
		<tr>
			<th align="left" width="195" scope="col" id="customerListNumber" style="background-color:#cccccc;">&nbsp;&nbsp;Customer number</th>
			<th align="left" width="399" scope="col" id="customerListName" style="background-color:#cccccc;">&nbsp;&nbsp;Customer name</th>
		</tr>
	<%
		List customers = view.getSelectedCustomers();
		if(null != customers){
			Iterator iterator = customers.iterator();
			while(iterator.hasNext()){
				CustomerListViewBean customer = (CustomerListViewBean)iterator.next();
				if(null != customer){
	%>
	 	
	 
	 <tr>
			<td align="left" headers="customerListNumber">&nbsp;&nbsp;<oppt:label label="<%=customer.getCustomerNumber()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
			<td align="left" headers="customerListName">&nbsp;&nbsp;<oppt:label label="<%=customer.getCustomerName()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
		</tr>
		
		
	   <%
				}
			}
		}
	%>
    	   	</table>
	&nbsp;<br />
	<table border="0" cellspacing="1" cellpadding="1" width="600" summary="Partners information">
		<tr>
			<th align="left" width="117"  style="background-color:#cccccc;">&nbsp;&nbsp;Partners</th>
			<th align="left" width="167" style="background-color:#cccccc;">&nbsp;&nbsp;Site Id</th>
			<th align="left" width="307" style="background-color:#cccccc;">&nbsp;&nbsp;Name</th>
		</tr>
		<tr>
			<td valign="bottom">&nbsp;&nbsp;<label >Sold to party:</label></td>
<td valign="bottom">&nbsp;&nbsp;<oppt:select name="soldToPartyNumber" id="soldToPartyNumber" displayValue="true" editable="<%=view.isSoldToPartyEditable() %>" options="<%=view.getSoldToPartyNumber() %>" selectedOption="<%=actionForm.getSoldToPartyNumber() %>" onclick="populateSoldToPartyName()"  onkeyup="populateSoldToPartyName()" title="Select sold to party number" /></td>
			<td valign="bottom">&nbsp;<oppt:select name="soldToPartyName" id="soldToPartyName" displayValue="true" editable="<%=view.isSoldToPartyEditable() %>" options="<%=view.getSoldToPartyName() %>" selectedOption="<%=actionForm.getSoldToPartyName() %>" onclick="populateSoldToPartyNumber()"  onkeyup="populateSoldToPartyNumber()" title="Select sold to party name" /></td>
		</tr>
		<%-- CR0531074816 - CBS OPPT accessibility issues --%>
		<%--  <tr valign="bottom"> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>
		<tr>
			<td valign="bottom">&nbsp;&nbsp;<label for="billToPartyNumber">Bill to party:</label></td>
		<%
			if(view.isIGFFlag()){
		%>
			<td valign="bottom">&nbsp;&nbsp;<oppt:text name="billToPartyNumber" styleId="billToPartyNumber" styleClass="iform" value="<%=actionForm.getBillToPartyNumber() %>" readonly="<%=view.isBillToPartyEditable() %>" maxlength="10" size="13" />
			
		<%
			}
			else{
		%>
			<td valign="bottom">&nbsp;&nbsp;<oppt:select name="billToPartyNumber" id="billToPartyNumber" options="<%=view.getBillToPartyNumber() %>" selectedOption="<%=actionForm.getBillToPartyNumber() %>" onclick="populateBillToPartyName()"  onkeyup="populateBillToPartyName()" title="Select bill to party number" /></td>
		<%
			}
			if(view.isIGFFlag()){
		%>
			<td valign="bottom">&nbsp;<label for="billToPartyName">&nbsp;</label><oppt:text name="billToPartyName" styleId="billToPartyName" styleClass="iform" value="<%=actionForm.getBillToPartyName() %>" readonly="<%=view.isBillToPartyEditable() %>" /></td>
		<%
			}
			else{
		%>
			<td valign="bottom">&nbsp;<oppt:select name="billToPartyName" id="billToPartyName" options="<%=view.getBillToPartyName() %>" selectedOption="<%=actionForm.getBillToPartyName() %>" onclick="populateBillToPartyNumber()"  onkeyup="populateBillToPartyNumber()" title="Select bill to party name" /></td>
		<%
			}
		%>
		</tr>
        <%-- CR0531074816 - CBS OPPT accessibility issues --%>
		<%--  <tr valign="bottom"> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>
		<tr>
			<td valign="bottom">&nbsp;&nbsp;<label for="payerNumber">Payer:</label></td>
		<%
			if(view.isIGFFlag()){
		%>
			<td valign="bottom">&nbsp;&nbsp;<oppt:text name="payerNumber" styleId="payerNumber" styleClass="iform" value="<%=actionForm.getPayerNumber() %>" maxlength="10" size="13" />
			
		<%
			}
			else{
		%>
			<td valign="bottom">&nbsp;&nbsp;<oppt:select name="payerNumber" id="payerNumber" options="<%=view.getPayerNumber() %>" selectedOption="<%=actionForm.getPayerNumber() %>" onclick="populatePayerName()"  onkeyup="populatePayerName()" title="Select payer number" /></td>
		<%
			}
			if(view.isIGFFlag()){
		%>
			<td valign="bottom">&nbsp;<oppt:text name="payerName" styleId="payerName" styleClass="iform" value="<%=actionForm.getPayerName() %>" /></td>
		<%
			}
			else{
		%>
			<td valign="bottom">&nbsp;<oppt:select name="payerName" id="payerName" options="<%=view.getPayerName() %>" selectedOption="<%=actionForm.getPayerName() %>" onclick="populatePayerNumber()"  onkeyup="populatePayerNumber()" title="Select payer name" /></td>
		<%
			}
		%>
		</tr>
		<%-- CR0531074816 - CBS OPPT accessibility issues --%>
		<%--  <tr valign="bottom"> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>
		<tr>
			<td valign="bottom">&nbsp;&nbsp;<label for="shipToPartyNumber">Ship to party:</label></td>
			<td valign="bottom">&nbsp;&nbsp;<oppt:select name="shipToPartyNumber" id="shipToPartyNumber" options="<%=view.getShipToPartyNumber() %>" selectedOption="<%=actionForm.getShipToPartyNumber() %>" onclick="populateShipToPartyName()"  onkeyup="populateShipToPartyName()" title="Select ship to party number" /></td>
			<td valign="bottom">&nbsp;<oppt:select name="shipToPartyName" id="shipToPartyName" options="<%=view.getShipToPartyName() %>" selectedOption="<%=actionForm.getShipToPartyName() %>" onclick="populateShipToPartyNumber()"  onkeyup="populateShipToPartyNumber()" title="Select ship to party name" /></td>
		</tr>
		<%-- CR0531074816 - CBS OPPT accessibility issues --%>
		<%--  <tr valign="bottom"> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>		
	</table>
	&nbsp;<br />
	<table border="0" cellspacing="1" cellpadding="1" width="600" summary="SAP Customer no Details">
		<tr>
			<th align="left" width="97" style="background-color:#cccccc;">&nbsp;&nbsp;Partners</th>
			<th align="left" width="187" style="background-color:#cccccc;">&nbsp;&nbsp;SAP customer no.</th>
			<th align="left" width="307" style="background-color:#cccccc;">&nbsp;&nbsp;Name</th>
		</tr>
		<tr>
			<td align="left" valign="bottom">&nbsp;&nbsp;<label for="SAPCustNo">9E Partner:</label></td>
			<td align="left" valign="bottom">&nbsp;&nbsp;<oppt:text name="nineDPartnerNumber" styleId="SAPCustNo" value="<%=actionForm.getNineDPartnerNumber() %>" maxlength="10" size="10" styleClass="iform" /></td>
			<td align="left" valign="bottom">&nbsp;<oppt:text name="nineDPartnerName" styleId="SAPCustName" title = "SAPCustName" value="<%=actionForm.getNineDPartnerName() %>" maxlength="35" size="10" styleClass="iform" /></td>
		</tr>
       <%-- CR0531074816 - CBS OPPT accessibility issues --%>
		<%--  <tr valign="bottom"> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td> --%>
		<%--	<td valign="bottom"><div class="ibm-alternate-rule">&nbsp;</div></td>	--%>					
		<%-- </tr> --%>		
	</table>
	&nbsp;<br />
	<table border="0" cellspacing="0" cellpadding="0" width="600" role="presentation">
		<tr>
			<td colspan="3" align="left"><label for="comments">Comments: </label></td>
		</tr>
		<tr>
			<td colspan="3" align="left"><textarea rows="2" name="comments" id="comments" cols="44" class="iform"><%=actionForm.getComments() %></textarea></td>
		</tr>
	</table>
	<table align="left" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><oppt:button value="Save" name="multipleButtonManager.save" alt="Save" primary="true" id="save" /></td>
			<td><oppt:button value="Alternate partner" name="multipleButtonManager.alternatePartner"  alt="Alternate partner" id="alternatePartner" /></td>
			<td><oppt:button value="Clear all" name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button value="Cancel" name="multipleButtonManager.cancel" alt="Cancel"  id="cancel" /></td>
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


<script language="JavaScript" type="text/javascript">
	function populateSoldToPartyName()
	{
        
 		var form = parent.document.PartnerSelectionActionForm;
 		form.soldToPartyName.options.selectedIndex = form.soldToPartyNumber.options.selectedIndex;
	}
	function populateSoldToPartyNumber()
	{
 		var form = parent.document.PartnerSelectionActionForm;
 		form.soldToPartyNumber.options.selectedIndex = form.soldToPartyName.options.selectedIndex;
	}

	function populateShipToPartyName()
	{
 		var form = parent.document.PartnerSelectionActionForm;
 		form.shipToPartyName.options.selectedIndex = form.shipToPartyNumber.options.selectedIndex;
	}
	function populateShipToPartyNumber()
	{
 		var form = parent.document.PartnerSelectionActionForm;
 		form.shipToPartyNumber.options.selectedIndex = form.shipToPartyName.options.selectedIndex;
	}

	function populateBillToPartyName()
	{
 		var form = parent.document.PartnerSelectionActionForm;
 		form.billToPartyName.options.selectedIndex = form.billToPartyNumber.options.selectedIndex;
	}
	function populateBillToPartyNumber()
	{
 		var form = parent.document.PartnerSelectionActionForm;
 		form.billToPartyNumber.options.selectedIndex = form.billToPartyName.options.selectedIndex;
	}

	function populatePayerName()
	{
 		var form = parent.document.PartnerSelectionActionForm;
 		form.payerName.options.selectedIndex = form.payerNumber.options.selectedIndex;
	}
	function populatePayerNumber()
	{
 		var form = parent.document.PartnerSelectionActionForm;
 		form.payerNumber.options.selectedIndex = form.payerName.options.selectedIndex;
	}
	
	
</script>

