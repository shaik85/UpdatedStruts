
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesListViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SalesOrgActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationTypeCodeActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants"%>

<%  
	HashSet errorValues = null;
	ModificationTypesListViewBean viewBean = null;
	OPPTSession opptSession = new OPPTSession(session);
	
	if(null != opptSession.getCurrentViewBean() && opptSession.getCurrentViewBean() instanceof ModificationTypesListViewBean) {
		viewBean = (ModificationTypesListViewBean) opptSession.getCurrentViewBean();
	}else {
		viewBean = new ModificationTypesListViewBean();
	}
	if (null == viewBean) {
		return;
	}
	
	ErrorReport errorReport = viewBean.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
      String modificationTypeCode = null;
	HashSet errorLabels = errorReport.getErrorFieldNames();
	SalesOrgActionForm actionForm = new SalesOrgActionForm();
	if(viewBean.getActionForm() != null && viewBean.getActionForm() instanceof SalesOrgActionForm) {
           actionForm = (SalesOrgActionForm)viewBean.getSalesOrgActionForm();
         }
    String selectedSalesOrg = "Select one";
	if(null != actionForm.getSalesOrganization() && !"Select one".equals(actionForm.getSalesOrganization())) {
	  	selectedSalesOrg =actionForm.getSalesOrganization();
		}
	
    if(errorReport == null || (errorReport != null && errorReport.size() == 0))  {
        if(session.getAttribute(SessionConstants.SESSION_MODIFICATION_TYPECODE_ACTIONFORM) != null) {
			ModificationTypeCodeActionForm modificationTypeCodeActionForm = (ModificationTypeCodeActionForm) session.getAttribute(SessionConstants.SESSION_MODIFICATION_TYPECODE_ACTIONFORM);
			modificationTypeCodeActionForm.setModificationTypeCode(null);
			session.setAttribute(SessionConstants.SESSION_MODIFICATION_TYPECODE_ACTIONFORM,modificationTypeCodeActionForm);
    	}
	}else {
	if(session.getAttribute(SessionConstants.SESSION_MODIFICATION_TYPECODE_ACTIONFORM) != null) {
			ModificationTypeCodeActionForm modificationTypeCodeActionForm = (ModificationTypeCodeActionForm) session.getAttribute(SessionConstants.SESSION_MODIFICATION_TYPECODE_ACTIONFORM);
			modificationTypeCode = modificationTypeCodeActionForm.getModificationTypeCode();
			session.setAttribute(SessionConstants.SESSION_MODIFICATION_TYPECODE_ACTIONFORM,modificationTypeCodeActionForm);
		}
		
	}
      
  
	%>
	
	<div id="edit-layout" align="right"><a href="javascript:getFormHelp()">
  <img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>

<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Modification maintenance">
	<tr valign="top">
		<td width="600">
		<table width="600" summary="Modification maintenance error report">
			<tr>
				<h1>Modification maintenance</h1>
			</tr>
			
			
			
			<tr>
			 <td><oppt:displayErrorReport errorReport="<%=errorReport%>" />
              </td>
              </tr>
              
              <tr>
				<td>
				<p>
				
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
               </tr>
               </table>
               
          <table width="600">	    
          <html:form action="/protect/BaseAgreementModificationMaintenance.wss" method="post"> 
           <tr>
          
           <td width="150" height="25" ><label for="salesOrganization"><oppt:label label="Sales&nbsp;organisation:" id="salesOrganization" errorLables="<%=errorValues%>" /></label></td>
           <td width="125" height="25" ><oppt:select  selectedOption="<%=selectedSalesOrg%>" name="salesOrganization" id="salesOrganization" options="<%=viewBean.getSalesOrgDetails() %>" title="select Sales Organisation" /></td>
           <td width="325" height="25" align="left" ><span class="button-blue"><input	type="submit" value="Go" /></span></td>
           </tr>
           
           <tr>           <td>           </td>           </tr>

         
           </html:form>
            </table>
          
           <table width="600">	
          <html:form action="/protect/ModificationMaintenanceMultipleAction.wss" method="post">  
          
          
           <% if(viewBean.getModificationTypesMap()!=null && viewBean.getModificationTypesMap().size()>0) { %>
				
				<tr>
				  <td colspan = "2" >
                     <oppt:modificationtypes modificationTypesMap= "<%= viewBean.getModificationTypesMap() %>" modificationType = "<%=modificationTypeCode%>" />                 				
									  
				  		</td>
				  </tr>
           <%  } %>		
				<tr>
					<td align="right" width="600" colspan="4">
					<oppt:button id="addmodificationtype" name="multipleButtonManager.addmodificationtype" alt="Addmodificationtype" primary="true" value="Add modification type" />
					 <% if(viewBean.getModificationTypesMap()!=null && viewBean.getModificationTypesMap().size()>0) { %>
					<oppt:button id="editmodificationtype" name="multipleButtonManager.editmodificationtype" alt="Editmodificationtype"	primary="true" value="Edit modification type" />
					<oppt:button id="deletemodificationtype" name="multipleButtonManager.deletemodificationtype" alt="Delete modification type" primary="true" value="Delete modification type" />
         			<%  } %>		
					
				</td>
				</tr>
				 
			</html:form>
			</table>							
		
