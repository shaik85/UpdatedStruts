<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.*" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ReportInfoActionForm" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementReportViewBean" %>
<%
  OPPTSession opptSession = new OPPTSession(session);
  BaseAgreementReportViewBean view = (BaseAgreementReportViewBean)opptSession.getCurrentViewBean();
  
  
  ReportInfoActionForm actionForm =(ReportInfoActionForm)view.getActionForm();
  if(null == actionForm){
     actionForm = new ReportInfoActionForm();
  }
  ErrorReport errorReport = view.getErrorReport();
  HashSet errorValues = errorReport.getErrorFieldNames();
  ArrayList buttonFlags = view.getButtonFlags();
  
  
 %>


<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Reports">
	<tr valign="top">
		<td width="450">
			<table width="450" summary="Reports">
				<tr valign="top">
					<h1>Reports</h1>
				</tr>
				<tr>
				<td>
                      <p class="ibm-alternate"><em>Report of all registered base agreements</p>
				</td>
			</tr>
			<tr>
			 <td><oppt:displayErrorReport errorReport="<%=errorReport%>" />
              </td>
              </tr>
				<tr>
					<td height="30"> 
                      <p>Select the sales org, base agreement status and then press 
                        Generate report button. Press Cancel button to go back 
                        to Reports page.<br>
                      </p>
	
                    	<p>Required fields are marked with an asterisk (<strong>*</strong>) 
                        and must be filled in to complete the form.</p>
						<html:form method="post" action="/protect/BAReportMultipleAction.wss">
						
                        <table summary="salesOrg" width="600">
                          <tr> 
                            <td width="21" align="right"><span class="ibm-required">*</span></td>
                            <td width="70" height="30"><label for="salesOrg" > <oppt:label label="Sales&nbsp;organisation:" id="salesOrganization" errorLables="<%=errorValues%>" /></label></td>
                              <td width="493" height="30"> 
                              <oppt:select selectedOption="<%=actionForm.getSalesOrg()%>" name="salesOrg" id="salesOrg"  options="<%=view.getSalesOrgDetails()%>" title="select Sales Organisation" /></td>
                          </tr>
                          <tr> 
                            <td width="21" align="right"><span class="ibm-required">*</span></td>
                            <td width="70" height="30"><label for="status" ><oppt:label label="Status:" id="status" errorLables="<%=errorValues%>" /></label></td>
                            <td width="493" height="30"> 
                            <oppt:select  selectedOption="<%=actionForm.getStatus()%>" name="status" id="status"  options="<%=view.getStatus()%>" title="select status" /></td>
                          </tr>
                          <tr> 
                            <td colspan="3">&nbsp; </td>
                          </tr>
                        </table>
							
                        <table width="600" summary="Generate report" align="right">
                          <tr> 
                            <td valign="top" width="386"><div align="right"><span class="button-blue"> 
                             <oppt:button id="report" name="multipleButtonManager.report" alt="Generate report" value="Generate report" primary="true" />
                              </span><label for="Generate report">&nbsp;</label> 
                              </div>
                            </td>
                            <td valign="top" width="202"><span class="button-blue"> 
                             <oppt:button id="bareportcancel" name="multipleButtonManager.bareportcancel" alt="bareportcancel" value="Cancel" primary="true" />
                          </tr>
                        </table>
						</html:form>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

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


