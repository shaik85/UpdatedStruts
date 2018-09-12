<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.EditInventoryViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.EditCustomerViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.EditCustomerDMViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.EditDMViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.EditDMSWOViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.EditSWOViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	EditInventoryViewBean view = (EditInventoryViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Proposal details- Edit</em></p>		
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
			
						<p>Use this page to change the inventory information. When you are finished click 
						the Save button. Press the Clear all button to discard your input. Press the Cancel 
						button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/EditInventoryMultipleAction.wss">
<table border="0" align="left" role="presentation">
<tr>
<td>
<%
	TreeMap customers = view.getCustomers();
	if(null != customers){
		Iterator iterator = customers.keySet().iterator();
		while(iterator.hasNext()){
			String key = iterator.next().toString();
			String keyValue = "customer("+key+")";
			String billToPartyNumber = keyValue+".billToPartyNumber";
			String billToPartyName 	= keyValue+".billToPartyName";
			String payerNumber 		= keyValue+".payerNumber";
			String payerName		= keyValue+".payerName";
			String planStartDate	= keyValue+".planStartDate";
			String planEndDate		= keyValue+".planEndDate";
			EditCustomerViewBean customerView = (EditCustomerViewBean)customers.get(key);
%>
	<table cellpadding="1" cellspacing="1" border="0" align="left" width="700" summary="Sold-to-party no">
		<tr>
			<td width="320" colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;Sold-to-party no.: <oppt:label labelStyle="tdblue" label="<%=customerView.getSoldToParty().getLegacyCustomerNumberWithAS() %>" /></td>
			<td width="380" colspan="2" style=background-color:#cccccc; class="bar-blue-med">&nbsp;Sold-to-party name: <oppt:label labelStyle="tdblue" label="<%=customerView.getSoldToParty().getCustomerName() %>" /></td>
		</tr>
		<tr>
			<td width="145" height="30">&nbsp;<label for="<%=billToPartyNumber%>">Bill-to-party no:</label></td>
			<td width="172"><oppt:select name="<%=billToPartyNumber%>" id="<%=billToPartyNumber%>" options="<%=customerView.getBillToPartyNumber() %>" selectedOption="<%=customerView.getSelectedBillToParty() %>" onchange="populateBillToPartyName()"  title="Select bill-to-party number" /></td>
			<td width="137">&nbsp;<label for="<%=billToPartyName%>">Bill-to-party name:</label></td>
			<td width="247"><oppt:select name="<%=billToPartyName%>" id="<%=billToPartyName%>" options="<%=customerView.getBillToPartyName() %>" selectedOption="<%=customerView.getSelectedBillToParty() %>" onchange="populateBillToPartyNumber()"  title="Select bill-to-party name" /></td>
		</tr>
		<tr>
			<td height="30">&nbsp;<label for="<%=payerNumber%>">Payer no:</label></td>
			<td><oppt:select name="<%=payerNumber%>" id="<%=payerNumber%>" options="<%=customerView.getPayerNumber() %>" selectedOption="<%=customerView.getSelectedPayer() %>" onchange="populatePayerName()"  title="Select payer number" /></td>
			<td>&nbsp;<label for="<%=payerName%>">Payer name:</label></td>
			<td><oppt:select name="<%=payerName%>" id="<%=payerName%>" options="<%=customerView.getPayerName() %>" selectedOption="<%=customerView.getSelectedPayer() %>" onchange="populatePayerNumber()"  title="Select payer name" /></td>
		</tr>
		<%
			if(view.isSandS()){
		%>
		<tr>
			<td height="30">&nbsp;Plan start date:</td>
			<td><oppt:date date="<%=customerView.getSelectedPlanStartDate() %>" hidden="true" name="<%=planStartDate%>" /></td>
			<td>&nbsp;Plan end date:</td>
			<td><oppt:date date="<%=customerView.getSelectedPlanEndDate() %>" hidden="true" name="<%=planEndDate%>" /> </td>
		</tr>
		<%
			}
			else
			{
		%>
		<tr>
			<td height="30">&nbsp;Default start date:</td>
			<td><oppt:date date="<%=customerView.getDefaultStartDate() %>" /></td>
			<td>&nbsp;Default end date:</td>
			<td><oppt:date date="<%=customerView.getDefaultEndDate() %>" /> </td>
		</tr>
		<tr>
			<td height="30">&nbsp;Plan start date:</td>
			<td><oppt:dateOptions date="<%=customerView.getSelectedPlanStartDate()%>" name="<%=planStartDate%>" alt="Plan start date" years="<%=view.getStartYears() %>" /></td>
			<td>&nbsp;Plan end date:</td>
			<td><oppt:dateOptions date="<%=customerView.getSelectedPlanEndDate()  %>" name="<%=planEndDate%>" alt="Plan end date" years="<%=view.getEndYears() %>" /></td>
		</tr>
		<%
			}
		%>
	</table>
<%
		}
	}

	TreeMap customerDMs = view.getCustomerDMs();
	if(null != customerDMs){
		Iterator customerDMsIterator = customerDMs.values().iterator();
		while(customerDMsIterator.hasNext()){
			EditCustomerDMViewBean customerDM = (EditCustomerDMViewBean)customerDMsIterator.next();
			if(null != customerDM){
%>
	<table cellpadding="0" cellspacing="1" border="0" align="center" width="700" summary="Sold-to-party no">
		<tr>
			<th colspan="2" width="350" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">&nbsp;Sold-to-party no.: <oppt:label labelStyle="tdblue" label="<%=customerDM.getSoldToPartyNumber() %>" /></th>
			<th colspan="2" width="350" style="background-color:#999999;"  class="bar-blue-med-dark">&nbsp;Sold-to-party name : <oppt:label labelStyle="tdblue" label="<%=customerDM.getSoldToPartyName() %>" /></th>
		</tr>
<%
				
				TreeMap dms = customerDM.getDMs();
				if(null != dms){
					Iterator iterator = dms.keySet().iterator();
					while(iterator.hasNext()){
						String key = iterator.next().toString();
						String keyValue = "dm("+key+")";
						String planStartDate	= keyValue+".planStartDate";
						String planEndDate		= keyValue+".planEndDate";
						EditDMViewBean dmView = (EditDMViewBean)dms.get(key);
%>
		<tr>
			<td height="18" colspan="2" class="bar-blue-med">&nbsp;Designated machine: <oppt:label labelStyle="tblue" label="<%=dmView.getDMNumber() %>" /></td>
			<td height="18" colspan="2" class="bar-blue-med">&nbsp;Description: <oppt:label labelStyle="tblue" label="<%=dmView.getDMDescription() %>" /></td>
		</tr>
		<%
						if(view.isSandS())
						{
		%>
		<tr>
			<td width="155" height="20">&nbsp;Plan start date:</td>
			<td width="170">&nbsp;<oppt:date date="<%=dmView.getSelectedPlanStartDate() %>" name="<%=planStartDate%>" hidden="true" /></td>
			<td width="145">&nbsp;Plan end date:</td>
			<td width="180">&nbsp;<oppt:date date="<%=dmView.getSelectedPlanEndDate() %>" name="<%=planEndDate%>" hidden="true" /></td>
		</tr>
		<%
						}
						else
						{
		%>
		<tr>
			<td width="155" height="30">&nbsp;Default start date:</td>
			<td width="170">&nbsp;<oppt:date date="<%=dmView.getPlanStartDate() %>" /></td>
			<td width="145">&nbsp;Default end date:</td>
			<td width="180">&nbsp;<oppt:date date="<%=dmView.getPlanEndDate() %>" /></td>
		</tr>
		<tr>
			<td height="20">&nbsp;Plan start date:</td>
			<td>&nbsp;<oppt:dateOptions date="<%=dmView.getSelectedPlanStartDate() %>" name="<%=planStartDate%>" alt="Plan start date" years="<%=view.getStartYears() %>" /></td>
			<td>&nbsp;Plan end date:</td>
			<td>&nbsp;<oppt:dateOptions date="<%=dmView.getSelectedPlanEndDate() %>" name="<%=planEndDate%>" alt="Plan end date" years="<%=view.getEndYears() %>" /></td>
		</tr>
		<%
						}
		%>
		<tr>
			<td colspan="4">&nbsp;<br /></td>
		</tr>
	
<%
					}
%>
	</table>
<%
				}
			}
		}
	}

	TreeMap dmSWOs = view.getDMSWOs();
	if(null != dmSWOs){
		Iterator dmSWOsIterator = dmSWOs.values().iterator();
		while(dmSWOsIterator.hasNext()){
			EditDMSWOViewBean dmSWO = (EditDMSWOViewBean)dmSWOsIterator.next();
			if(null != dmSWO){
%>
	<table cellpadding="0" cellspacing="1" border="0" width="700" summary="Sold-to-party no">
		<tr>
			<th colspan="2" width="350" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">&nbsp;Sold-to-party no.: <oppt:label labelStyle="tbblue" label="<%=dmSWO.getSoldToPartyNumber() %>" /></th>
			<th colspan="2" width="350" style="background-color:#999999;"  class="bar-blue-med-dark">&nbsp;Sold-to-party name: <oppt:label labelStyle="tbblue"  label="<%=dmSWO.getSoldToPartyName() %>" /></th>
		</tr>
		<tr>
			<td height="18" colspan="2" style=background-color:#cccccc; class="bar-blue-med">&nbsp;Designated machine: <oppt:label labelStyle="tbblue" label="<%=dmSWO.getDMNumber() %>" /></td>
			<td height="18" colspan="2" style=background-color:#cccccc; class="bar-blue-med">&nbsp;Description: <oppt:label labelStyle="tbblue" label="<%=dmSWO.getDMDescription() %>" /></td>
		</tr>
<%
				TreeMap swos = dmSWO.getSWOs();
				if(null != swos){
					Iterator iterator = swos.keySet().iterator();
					while(iterator.hasNext()){
						String key = iterator.next().toString();
						String keyValue = "swo("+key+")";
						String alternatePrice	= keyValue+".alternatePrice";
						String planStartDate	= keyValue+".planStartDate";
						String planEndDate		= keyValue+".planEndDate";
						EditSWOViewBean swoView = (EditSWOViewBean)swos.get(key);
%>
		<tr>
			<td colspan="2" height="20" class="bar-gray-light">&nbsp;SWO/SWOSno: <oppt:label labelStyle="tbblue" label="<%=swoView.getSWONumberSerialNumber() %>" /></td>
			<td colspan="2" class="bar-gray-light">&nbsp;Description: <oppt:label label="<%=swoView.getDescription() %>" /></td>
		</tr>
		<tr>
		<%
						if(view.isSandS())
						{
		%>
			<td height="30">&nbsp;&nbsp;<label for="<%=alternatePrice%>"><oppt:label label="Alternate S&amp;S price" id="alternatePrice" /></label></td>
		<%
						}
						else
						{
		%>
			<td height="30">&nbsp;&nbsp;<label for="<%=alternatePrice%>"><oppt:label label="Alternate price:" id="alternatePrice" /></label></td>
		<%
						}
		%>
			<td colspan="3">&nbsp;&nbsp;<oppt:text name="<%=alternatePrice%>" styleId="<%=alternatePrice%>" styleClass="iform" size="16" maxlength="16" value="<%=swoView.getAlternatePriceValue() %>" /></td>
		</tr>
		<%
						if(view.isSandS())
						{
		%>
		<tr>
			<td width="155" height="30">&nbsp;&nbsp;Plan start date:</td>
			<td width="170">&nbsp;&nbsp;<oppt:date date="<%=swoView.getSelectedPlanStartDate() %>" hidden="true" name="<%=planStartDate%>" /></td>
			<td width="145">&nbsp;&nbsp;Plan end date:</td>
			<td width="180">&nbsp;&nbsp;<oppt:date date="<%=swoView.getSelectedPlanEndDate() %>" hidden="true" name="<%=planEndDate%>" /></td>
		</tr>
		<%
						}
						else
						{
		%>
		<tr>
			<td width="155" height="30">&nbsp;&nbsp;Default start date:</td>
			<td width="170">&nbsp;&nbsp;<oppt:date date="<%=swoView.getPlanStartDate() %>" /></td>
			<td width="145">&nbsp;&nbsp;Default end date:</td>
			<td width="180">&nbsp;&nbsp;<oppt:date date="<%=swoView.getPlanEndDate() %>" /></td>
		</tr>
		<tr>
			<td height="30">&nbsp;&nbsp;Plan start date:</td>
			<td>&nbsp;&nbsp;<oppt:dateOptions date="<%=swoView.getSelectedPlanStartDate() %>" name="<%=planStartDate%>" alt="Plan start date" years="<%=view.getStartYears() %>" /></td>
			<td>&nbsp;&nbsp;Plan end date:</td>
			<td>&nbsp;&nbsp;<oppt:dateOptions date="<%=swoView.getSelectedPlanEndDate() %>" name="<%=planEndDate%>" alt="Plan end date" years="<%=view.getEndYears() %>" /></td>
		</tr>
		<%
						}
		%>
		<tr>
			<td colspan="4">&nbsp;<br /></td>
		</tr>
		<%
					}
		%>
	</table>
<%
				}
			}
		}
	}
%>
</td>
</tr>
<tr>
<td>
	<table align="right" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td><oppt:button value="Save"  primary="true" name="multipleButtonManager.save" alt="Save" id="save" /></td>
			<td><oppt:button value="Clear all" name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button value="Cancel"  name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><input type="hidden" name="SandS" value="<%=view.isSandS()%>" /></td>
		</tr>
	</table>
</td>
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
