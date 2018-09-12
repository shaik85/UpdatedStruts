
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ChangeModificationTypeActionForm"%>
<%
    HashSet errorValues = null;
	OPPTSession opptSession = new OPPTSession(session);
	ModificationTypesViewBean view = (ModificationTypesViewBean) opptSession.getCurrentViewBean();
	ChangeModificationTypeActionForm actionForm = (ChangeModificationTypeActionForm)view.getActionForm();
	if(null == view){
		return;
	}
	if(actionForm == null) {
		actionForm = new ChangeModificationTypeActionForm();
		
		
	}
  String typeCode = actionForm.getSalesOrg();
	String selectedSalesOrg =(String) view.getSelectedSalesOrg();
	ErrorReport errorReport = view.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	HashSet errorLabels = errorReport.getErrorFieldNames();
	
	%>
	
	<div id="edit-layout" align="right"><a href="javascript:getFormHelp()">
  <img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>

<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Modification maintenance">
	<tr valign="top">
		<td width="600">
		<table width="600" role="presentation">
			<tr>
				<h1>Modification maintenance</h1>
			</tr>
			<tr>
				<td><p class="ibm-alternate"><em>Add modification type</p>
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
               
 <table width="600">	
	<tr>
		<td>    
               <html:form action="/protect/AddModificationTypeMultipleAction.wss" method="post"> 
                             
               	<table border="0" width="600">
				<tr>
					<td width="32">
					</td>
				</tr>
				<tr>
				<td height="25" colspan="6" style=background-color:#cccccc;  class="bar-blue-med">Modification types</td>
				</tr>
			    <tr>
				     <td height="25" width="30" align = "right"></td> 
                     <td height="25" width="180"><label for="salesOrg"><oppt:label label="Sales organisation:" id="salesOrg" /></label></td>
                     <td height="25" width="180"><label for="salesOrg"><oppt:label label="<%=selectedSalesOrg%>" id="salesOrg"  /></label></td>                      
                                          
                             
		       </tr>
			   
			    <tr>
				     <td height="25" width="30" align = "right"><strong class="black">*</strong></td> 
                     <td height="25" width="180"><label for="typeCode"><oppt:label label="Modification type code:" id="typeCode" errorLables="<%=errorValues%>" /></label></td>
                     <td height="25" width="390" align = "left"><oppt:text name="typeCode" value="<%=actionForm.getTypeCode() %>" maxlength="4" styleId="typeCode" styleClass="iform" size="20" title="Enter typecode" /></td>
                             
		       </tr>
			   <tr>
				     <td height="25" width="30" align = "right"><strong class="black">*</strong></td> 
                     <td height="25" width="180"><label for="description"><oppt:label label="Modification description:" id="description" errorLables="<%=errorValues%>" /></label></td>
                     <td height="25" width="390" align = "left"><oppt:text name="description" value="<%=actionForm.getDescription() %>" maxlength="30" styleId="description" styleClass="iform" size="20" title="Enter description"/></td>
              </tr>
				
				<tr>
				<td width="600" align = "right" colspan = "3">
						<oppt:button id="savemodificationtype" name="multipleButtonManager.savemodificationtype" alt="Savemodificationtype" primary="true" value="Save modification type" />
						<oppt:button id="cancel" name="multipleButtonManager.cancel" alt="cancel" primary="true" value="Cancel" />
					
					</td>
				</tr>
			</table>
		</html:form>
		</td>
	</tr>
</table>