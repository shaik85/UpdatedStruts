<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ChangeModificationTypeActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.EditModificationOptionActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants"%>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants" %>


<%

    HashSet errorValues = null;
	OPPTSession opptSession = new OPPTSession(session);
	ModificationTypesViewBean view = (ModificationTypesViewBean) opptSession.getCurrentViewBean();
	
	
	ChangeModificationTypeActionForm actionForm = new ChangeModificationTypeActionForm();
	if(view.getActionForm() != null && view.getActionForm() instanceof ChangeModificationTypeActionForm) {
           actionForm = (ChangeModificationTypeActionForm)view.getChangeModificationTypeActionForm();
         }
	

	ErrorReport errorReport = view.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	HashSet errorLabels = errorReport.getErrorFieldNames();

	String selectedSalesOrg =com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder.getSalesOrgDesc(view.getSelectedSalesOrg())+"-"+view.getSelectedSalesOrg();
	String typeCode = (String)view.getTypeCode();
	TreeMap modificationOptionsMap = null;
	String modificationOption = null;
	
	if(errorReport == null || (errorReport != null && errorReport.size() == 0))  {
        if(session.getAttribute(SessionConstants.SESSION_EDITMODIFICATION_OPTION_ACTIONFORM) != null) {
			EditModificationOptionActionForm modificationOptionActionForm = (EditModificationOptionActionForm) session.getAttribute(SessionConstants.SESSION_EDITMODIFICATION_OPTION_ACTIONFORM);
			modificationOptionActionForm.setModificationOption(null);
			session.setAttribute(SessionConstants.SESSION_EDITMODIFICATION_OPTION_ACTIONFORM,modificationOptionActionForm);
    	}
	}else {
	if(session.getAttribute(SessionConstants.SESSION_EDITMODIFICATION_OPTION_ACTIONFORM) != null) {
			EditModificationOptionActionForm modificationOptionActionForm = (EditModificationOptionActionForm) session.getAttribute(SessionConstants.SESSION_EDITMODIFICATION_OPTION_ACTIONFORM);
			modificationOption = modificationOptionActionForm.getModificationOption();
			session.setAttribute(SessionConstants.SESSION_EDITMODIFICATION_OPTION_ACTIONFORM,modificationOptionActionForm);
		}
		
	}
      
	
	%>
	
	<div id="edit-layout" align="right"><a href="javascript:getFormHelp()">
  <img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>

<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Modification maintenance">
	<tr valign="top">
		<td width="600">
		<table width="600" summary="Modification maintenance info">
			<tr>
				<h1>Modification maintenance</h1>
			</tr>
			<tr>
				<td><p class="ibm-alternate"><em>Edit modification type</p>
				</td>
			</tr>
			<tr>
			 <td><oppt:displayErrorReport errorReport="<%=errorReport%>" />
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
	<table border="0" width="600">
    <html:form action="/protect/EditModificationTypeMultipleAction.wss" method="post"> 
    			<tr>
					<td>
					</td>
				</tr>
				<tr>
				<td height="25" colspan="6" style=background-color:#cccccc;  class="bar-blue-med">Modification types</td>
				</tr>
				 <tr>
				     <td height="25" width="30" align = "right"></td> 
                     <td height="25" width="180"><label for="salesOrg"><oppt:label label="Sales organisation:" id="salesOrg" /></label></td>
                     <td height="25" width="180"><label for="salesOrg"><oppt:label label="<%=selectedSalesOrg%>" id="salesOrg" /></label></td>                      
               </tr>
				<tr>
				     <td height="25" width="40"></td> 
                     <td height="25" width="180"><label for="typeCode"><oppt:label label="Modification type code:" id="typeCode" errorLables="<%=errorValues%>" /></label></td>
                     <td height="25" width="380" align= "left" ><html:text property="typeCode" value="<%=view.getTypeCode()%>" readonly="true" styleId="typeCode" title="typeCode" name="typeCode" ></html:text></td>  
                </tr>
			<tr>
				     <td height="25" width="40"><strong class="black">*</strong></td> 
                     <td height="25" width="180"><label for="description"><oppt:label label="Modification description:" id="description" errorLables="<%=errorValues%>" /></label></td>
                     <td height="25" width="380" align= "left" ><oppt:text name="description" value="<%=actionForm.getDescription()%>" maxlength="30" styleId="description" styleClass="iform" size="20" title="Enter description"/></td>
                             
		        </tr>
				
			<tr>
				     <td ></td> 
				     
				     </tr>
				     
				     <tr>
					<td align= "right" colspan="5">	
						<oppt:button id="saveeditmodificationtype" name="multipleButtonManager.saveeditmodificationtype" alt="Saveeditmodificationtype" primary="true" value="Save modification type" />
                         <% 	if(null == view.getModificationOptionsMap()&& view.getTypeCode().equals(BaseAgreementModificationConstants.ROL) ){%>      
						<oppt:button id="addmodificationoption" name="multipleButtonManager.addmodificationoption" alt="addmodificationoption" primary="true" value="Add modification option" />
				         <%  } %>
						<oppt:button id="cancel" name="multipleButtonManager.cancel" alt="cancel" primary="true" value="Cancel" />
					</td>
				</tr>
	
		</html:form>
		</table>
                <html:form action="/protect/ModificationOptionMultipleAction.wss" method="post"> 
                             
               	<table border="0" width="600">
		
				     
		<% 	if(view.getModificationOptionsMap()!= null && view.getModificationOptionsMap().size()!=0){
	modificationOptionsMap = (TreeMap)view.getModificationOptionsMap().get(typeCode); 
	%>      
			     
		<tr>
            		<td colspan="4"> 
                        <oppt:modificationoptions modificationOptionsMap= "<%= modificationOptionsMap%>" option="modificationOption"/> 
                    </td>
		
		</tr>		     
          
   			<tr>
					<td align= "right" colspan="5">	
					<oppt:button id="addmodificationoption" name="multipleButtonManager.addmodificationoption" alt="addmodificationoption" primary="true" value="Add modification option" />
					<oppt:button id="editmodificationoption" name="multipleButtonManager.editmodificationoption" alt="editmodificationoption" primary="true" value="Edit modification option" />
						<oppt:button id="deletemodificationoption" name="multipleButtonManager.deletemodificationoption" alt="deletemodificationoption" primary="true" value="Delete modification option" />
						
					</td>
				</tr>
 <%  } %>
			</table>
		</html:form>
