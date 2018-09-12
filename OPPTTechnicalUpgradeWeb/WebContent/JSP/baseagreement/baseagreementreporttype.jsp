<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants" %>

<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ReportTypeActionForm" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%
  OPPTSession opptSession = new OPPTSession(session);
  OPPTViewBean view =  opptSession.getCurrentViewBean();
   ReportTypeActionForm actionForm = null;
 // ReportTypeActionForm actionForm =(ReportTypeActionForm)view.getActionForm();
  //if(null == actionForm){
      actionForm = new ReportTypeActionForm();
  //  }
  ErrorReport errorReport = view.getErrorReport();
	
 %>
<div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Reports">
	<tr valign="top">
		<td width="450">
			<table width="450" role="presentation">
				<tr valign="top">
					<h1>Reports</h1>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
			<td>
			<oppt:displayErrorReport errorReport="<%=errorReport%>" />
			</td></tr>
				<tr>
					<td>
                      <p>Select the report type which is required to be generated 
                        the report.</p>
	
                    	
                      <p>Required fields are marked with an asterisk (<strong>*</strong>) and must be filled in to complete the form.</p>
					 <html:form  action="/protect/BaseAgreementReportChoice.wss" method="post">
                        <table summary="reportType" width="600">
                          <tr> 
                            <td width="20" height="20" align="right"></td>><span class="ibm-required">*</span>
                            <td width="532" height="25"><label for="reportType" <span style="color: #000000">Report 
                              type:</span> </label></td>
                          </tr>
                          <tr> 
                            <td colspan="2"> 
                              <table width="600" summary="reportType info">
                                <tr> 
                                  <td width="13">&nbsp;</td>
                                  <td width="573"> 
                                    <table width="100%" summary="reportType">
                                      
                                      <tr> 
                                        <td> 
                                          <input type="radio" name="reportType" value="<%=Constants.BA_REPORT_FORMNUMBER%>" id="rb02" title="Select report type" />
                                          <label for="rb02">Report for registered Base Agreement</label></td>
                                      </tr>
                                       <tr> 
                                        <td> 
                                          <input type="radio" name="reportType" value="<%=Constants.BA_REPORT_MODTYPE%>" id="rb03" title="Select report type" />
                                          <label for="rb03"></label>Report for registered Modifications                                          
                                          </td>
                                      </tr>
                                    </table>
                                  </td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
							
                        <table width="600" summary="continue button" align="right">
                          <tr> 
                            <td valign="top" width="386"> </td>
                            <td valign="top" width="202"><span class="button-blue"> 
                             <!-- <input type="submit" id="continue" name="multipleButtonManager.continue" value="Continue" style="width:13em;" alt="Continue" />-->
                               <oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue" primary="true" value="Continue" />
                              </span><label for="download">&nbsp;</label> </td>
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



