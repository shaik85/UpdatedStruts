
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ReverificationViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ReverificationViewBean viewBean = (ReverificationViewBean)opptSession.getCurrentViewBean();
	if(null == viewBean){
		return;
	}
	TreeMap	salesOrgList = viewBean.getSalesAreas();
	ErrorReport errorReport = viewBean.getErrorReport();
	HashSet errorLabels = errorReport.getErrorFieldNames();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Reports</h1>	
				<p ><em><br>User reverification report</em></p>	
		</div>
	</div>	
	<div id="ibm-content-body">
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600" >
	<tr valign="top">
		<td width="450">
			<table width="450" role="presentation">
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Select a sales org and click View or Download button</p>
	
						<p>Required fields are marked with an asterisk (<strong>*</strong>) and must be filled in to complete the form.</p>
						<form name="reverificationSelection" method="post" action="ReverificationMultipleAction.wss">
						    &nbsp;<br />
							<table role="presentation">
								<tr>
									<td width="12" height="20" align="left"></td>
									<td>
										<label for="salesOrg" ><span class="ibm-required">*</span><oppt:label label="Sales org:" id="salesOrg" errorLables="<%=errorLabels%>" /></label>&nbsp;
										<oppt:select name="salesOrg" style="iform" reverse="true" options="<%=salesOrgList%>" title= "Select sales org" />
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><label ><span class="ibm-required">*</span><oppt:label label="Report type:" id="reportType" errorLables="<%=errorLabels%>" /></label></td>
								</tr>
								<tr>
									<td colspan="2">
										<table width="400" role="presentation">
											<tr>
												<td width="23">&nbsp;</td>
												<td>
													<table width="400" role="presentation">
														
														
														<tr>
															<td><input type="radio" name="reportType" value="reverificationreport" id="rb01" /><label for="rb01">User Reverification Report</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="deletionreport" id="rb02" /><label for="rb02">Deleted Users Report</label></td>
															<td>(20KB)</td>
														</tr>
														<tr> <td>&nbsp;
														</td>
														</tr>
														<tr> <td>&nbsp;
														</td>
														</tr>
														
							</table>
							</td>
							</tr>
							</table>
							</td>
							</tr>
							</table>
							
							<table role="presentation" align="right">
								<tr>
									<td valign="top"><oppt:button id="view" name="multipleButtonManager.view" alt="View" primary="true" value="View" /></td>
									<td valign="top"><oppt:button id="download" name="multipleButtonManager.download"  alt="Download" value="Download" /></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
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



