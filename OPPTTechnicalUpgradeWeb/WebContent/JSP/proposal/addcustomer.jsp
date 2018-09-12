<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.AddCustomerViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	AddCustomerViewBean view = (AddCustomerViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = view.getButtonFlags();
%>



<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Add customer Proposal name: <%=view.getProposalName() %></em></p>		
	<p ><em><br>	view.getProposalName()</em></p>
	</div>
	</div>	

<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="650" role="presentation">
	<tr valign="top">
		<td width="650">
			<table width="650" role="presentation">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>All customers belonging to the specific Customer list are
						displayed. Customer's that are already included in the proposal are
						marked with an asterisk (*). Use the tick box to select additional
						customers and their inventory to be included in the proposal. Press
						the Fetch Inventory button to retrieve the inventory/and/or the Fetch
						plan button to include quotes for the selected customers. Press the
						Clear all button to discard your selection. Press the Cancel button to 
						go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/AddCustomerMultipleAction.wss" method="post">
	<oppt:customerLists customerLists="<%=view.getCustomerLists()%>" property="selectedCustomerIds" />
	
	&nbsp;<br />
	<table align="right" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td><oppt:button id="fetchInventory" name="multipleButtonManager.fetchInventory" alt="Fetch inventory" primary="true" value="Fetch inventory" buttonFlags="<%=buttonFlags %>" /></td>
			<td><span class="button-blue"><label for="fetchPlannedInventory"><input type="submit" id="fetchPlannedInventory" name="multipleButtonManager.fetchPlannedInventory" value="Fetch actual/planned inventory" style="width:20em;" alt="Fetch actual/planned inventory" /></label></span></td>
			<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" primary="true" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
			<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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

