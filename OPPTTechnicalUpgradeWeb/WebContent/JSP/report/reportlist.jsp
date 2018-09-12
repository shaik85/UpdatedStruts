
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ReportsViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ReportsViewBean viewBean = (ReportsViewBean)opptSession.getCurrentViewBean();
	if(null == viewBean){
		return;
	}
	TreeMap	proposalList = viewBean.getProposals();
	ErrorReport errorReport = viewBean.getErrorReport();
	HashSet errorLabels = errorReport.getErrorFieldNames();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Reports</h1>	
					
		</div>
	</div>	
	<div id="ibm-content-body">
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Reports">
	<tr valign="top">
		<td width="450">
			<table width="450" role="presentation">
				
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Select the proposal name and report which is required to be generated</p>
	
                    	<p>Required fields are marked with an asterisk (<strong>*</strong>)and must be filled in to complete the form.</p>
						<form name="reportSelection" method="post" action="ReportMultipleAction.wss">
							<table summary="reportSelection">
								<tr>
									<td width="2" height="20" align="right"></td>
									<td>
										<label for="proposalName" ><span class="ibm-required">*</span><oppt:label label="Proposal name:" id="proposalName" errorLables="<%=errorLabels%>" /></label>&nbsp;
										<oppt:select name="proposalName" style="iform" reverse="true" options="<%=proposalList%>" title= "Select proposal name" />
									</td>
								</tr>
								<tr>
									<td width="2" height="20" align="right"></td>
									<td><label ><span class="ibm-required">*</span><oppt:label label="Report type:" id="reportType" errorLables="<%=errorLabels%>" /></label></td>
								</tr>
								<tr>
									<td colspan="2">
										<table width="400" summary="reportType">
											<tr>
												<td width="23">&nbsp;</td>
												<td>
													<table width="400" summary="reportType info">
														<tr>
															<td><input type="radio" name="reportType" value="reportType1" id="rb01" /><label for="rb01">Contract attachment report (Draft)</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType2" id="rb02" /><label for="rb02">Contract attachment report (Final)</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType3" id="rb03" /><label for="rb03">Planning report</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType4" id="rb06" /><label for="rb06">Contract amendment report</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType5" id="rb07" /><label for="rb07">Deleted SWOs report</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType6" id="rb08" /><label for="rb08">Sysplex report</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType7" id="rb09" /><label for="rb09">Inventory list report</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType8" id="rb10" /><label for="rb10">List/ Entitled price report</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType9" id="rb11" /><label for="rb11">Variance report (All)</label></td>
															<td>(20KB)</td>
														</tr>
														<tr>
															<td><input type="radio" name="reportType" value="reportType10" id="rb12" /><label for="rb12">Variance report (Price change)</label></td>
															<td>(20KB)</td>
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
									<td valign="top"><oppt:button id="view" name="multipleButtonManager.view"  alt="View" value="View" /></td>
									<td valign="top"><oppt:button id="download" name="multipleButtonManager.download" primary="true" alt="Download" value="Download" /></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
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


