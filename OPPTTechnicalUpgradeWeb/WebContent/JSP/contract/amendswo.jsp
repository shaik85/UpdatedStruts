
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.AmendSWOViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	ErrorReport errorReport = null;
	ArrayList buttonFlags=null;
	ArrayList yearList = null;
	OPPTSession opptSession = new OPPTSession(session);
	AmendSWOViewBean viewBean = (AmendSWOViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		yearList = viewBean.getYearList();
		
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Amend SWO</em></p>		
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
						
						<p>To amend SWO, change the amendment plan dates.  When you are 
						finished, click the Save button.  Press the Clear all button to 
						discard your input. Press the Cancel button to go back to contract
						details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="AmendSWO" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/AmendSWOMultipleAction.wss">
				<table summary="AmendSWO" align="center" border="0" width="600" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left" width="100"><label >From date:</label></td>
						<td width="500">
							<oppt:dateOptions name="fromDate" years="<%=yearList%>" alt= "From date" />
						</td>
					</tr>
					<tr>
						<td align="left" width="100">
							<label >To date:</label>
						</td>
						<td width="500">
							<oppt:dateOptions name="toDate" years="<%=yearList%>" alt= "To date" />
							 
						</td>
					</tr>
				</table>
				&nbsp;<br />
				<table summary="Default from date" align="left" cellspacing="0" cellpadding="0">
					<tr>
						<td height="20">Default date:&nbsp;<oppt:date date="<%=viewBean.getDefaultFromDate()%>"/></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>Default to date:&nbsp;<oppt:date date="<%=viewBean.getDefaultToDate()%>"/></td>
					</tr>
				</table>
				&nbsp;<br />
				<table role="presentation" border="0" cellspacing="0" cellpadding="0" align="right">
					<tr>
						<td><oppt:button id="save" name="multipleButtonManager.save" alt="Save" primary="true" value="Save" buttonFlags="<%=buttonFlags %>" /></td>
						<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" primary="true" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
						<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
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