
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormMaintenanceViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SalesOrgActionForm"%>
<%
	HashSet errorValues = null;
	FormMaintenanceViewBean viewBean = null;
	OPPTSession opptSession = new OPPTSession(session);
	
	
	if(null != opptSession.getCurrentViewBean() && opptSession.getCurrentViewBean() instanceof FormMaintenanceViewBean) {
		viewBean = (FormMaintenanceViewBean) opptSession.getCurrentViewBean();
	}else {
		viewBean = new FormMaintenanceViewBean();
	}
	if (null == viewBean) {
		return;
	}
	
	ErrorReport errorReport = viewBean.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	
	HashSet errorLabels = errorReport.getErrorFieldNames();
	String typeCode = null;
	
	SalesOrgActionForm actionForm = viewBean.getSalesOrgActionForm();
	     String selectedSalesOrg = "Select one";
	       if(null != actionForm.getSalesOrganization() && !"Select one".equals(actionForm.getSalesOrganization())) {
		        	selectedSalesOrg =actionForm.getSalesOrganization();
					}
%>
<div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
 <table cellpadding="0" cellspacing="0" border="0" width="750" summary="Form maintenance">
            <tr valign="top"> 
              <td width="750"> 
                <table width="750"  summary="Form maintenance info">
                  <tr valign="top"> 
                    <th> 
                      <h1>Form maintenance</h1>
                    </th>
                  </tr>
                  <tr> 
                  <td>
  					  <oppt:displayErrorReport errorReport="<%=errorReport%>" />  
  					  <p>Use this form to retrieve the forms list depending on the search criteria 
				   		(Sales organization). Selection the Sales organization from the list and press the Go button.
				   		 Press the Add form button to create a new form. Select the form from the list by clicking the
				   		 radio button for the particular form.Then press the Edit form button to edit the form.
				  		 Press Delete form to delete the form.
  					  </p>
 				 </td>
 				 </tr>
                  <tr> 
                    <td> 
                      <p>Required fields are marked with an asterisk (<strong>*</strong>) 
                        and must be filled in to complete the form.</p>
                    </td>
                  </tr>
                </table>
              </td>
              <td width="76">&nbsp;</td>
            </tr>
          </table>

<table width="750">
<html:form action="/protect/DisplayFormList" method="post" >
  <tr> 
    <td width="750" style=background-color:#cccccc;  class="bar-blue-med"><strong>Sales organization</strong></td>
  </tr>
  
  <tr> 
    <td width="350"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        
        <tr>
          <td width="12" height="20"><span class="ibm-required">*</span></td>
          <td width="200" height="25"><label for="salesOrg"><oppt:label label="Sales&nbsp;organisation:" id="salesOrganization" errorLables="<%=errorValues%>" /></label></td>
          <td width="300" height="20"><oppt:select  selectedOption="<%=selectedSalesOrg %>" name="salesOrganization" id="salesOrganization" options="<%=viewBean.getSalesOrgDetails() %>" title="select Sales Organisation" /></td>  
          <td height="31" width="30"><span class="button-blue"><input	type="submit" value="Go" /></span></td>
        </tr>
        
      </table>
    </td>
  </tr>
 
  </html:form>
  </table>
  <table width="750">
  <html:form action="/protect/FormMaintenanceMultipleAction.wss"> 
  
   <% if(viewBean.getFormDetailsMap()!=null && viewBean.getFormDetailsMap().size()!=0) { %>
		    <tr>
				  <td>
                      <oppt:formdetails formDetailsMap= "<%= viewBean.getFormDetailsMap() %>"  />                           				
									  
				  </td>
			</tr>
 
  			<tr>
    			<td align="right" width="750" colspan="5">
     
			       <oppt:button id="addform" name="multipleButtonManager.addform" alt="Add form" value="Add form" primary="true" />
			       <oppt:button id="editform" name="multipleButtonManager.editform" alt="Edit form" value="Edit form" primary="true" />
			       <oppt:button id="deleteform" name="multipleButtonManager.deleteform" alt="Delete form" value="Delete form" primary="true" />
			     
    			</td>
  			</tr>
  			 <% } %>	

</html:form>
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








