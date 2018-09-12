
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
	
<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CreateGroupViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	OPPTSession opptSession = new OPPTSession(session);
	CreateGroupViewBean viewBean = (CreateGroupViewBean)opptSession.getCurrentViewBean();
	ErrorReport errorReport=null;
	TreeMap salesArea=null;
	ArrayList buttonFlags = null;
	if (null != viewBean) {
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
		salesArea = viewBean.getSalesAreas();
		buttonFlags = viewBean.getButtonFlags();
	} 
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Group maintenance</h1>	
				<p><em><br>New Group</em></p>	
		</div>
	</div>	

<div id="ibm-content-body">
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				<tr valign="top">
					<h1></h1>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to create a new group for a specific Sales
						 area.  When you are finished, click the Save button. Press 
						 the Clear all button to discard your input. Press Cancel 
						 button to go back to group maintenance page.</p>
						
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
&nbsp;<br />
<table summary="CreateGroupMultipleAction" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>		
			<html:form action="protect/CreateGroupMultipleAction.wss">
				<table summary="Adding a new Group" align="center" width="600" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left">
							<table role="presentation" cellspacing="1" cellpadding="1" border="0" width="600">
								<tr>
									<td width="12" height="30" align="center"></td>
									<td width="132"><label for="groupName"><span class="ibm-required">*</span>Group name:</label></td>
									<td width="447"><input type="text" name="groupName" id="groupName" size="20" maxlength="31" value="" class="iform" /></td>
								</tr>
								<tr>
									<td width="12" height="30" align="center"></td>
									<td><label for="salesArea"><span class="ibm-required">*</span>Sales org:</label></td>
									<td><oppt:select name="salesArea" id="salesArea" reverse="true" style="iform" options="<%=salesArea%>" selectedOption="<%=viewBean.getSelectedSalesArea()%>" title= "Select sales org" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				&nbsp;<br />
				<table role="presentation" cellpadding="0" cellspacing="0" border="0" align="right">
					<tr>
						<td><oppt:button id="save" name="multipleButtonManager.save" alt="Save" value="Save" buttonFlags="<%=buttonFlags %>"  primary="true" /></td>
						<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td> 
						<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td> 
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


<script type="text/javascript">
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
</script>



