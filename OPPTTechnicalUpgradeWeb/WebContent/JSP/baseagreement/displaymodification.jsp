
<!-- Copyright (c) 2006 by IBM corporation -->


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants"%>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationContactActionForm" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	DisplayModificationViewBean view = (DisplayModificationViewBean)opptSession.getCurrentViewBean();
	boolean amendFlag = false;
	if(null != opptSession.getObjectFromSession(SessionConstants.SESSION_AMEND_FLAG) 
	   &&((Boolean)opptSession.getObjectFromSession(SessionConstants.SESSION_AMEND_FLAG)).booleanValue()) {
	    amendFlag = true;
		opptSession.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,null);
	}
	
    ArrayList buttonFlags = view.getButtonFlags();
	if(null == view){
		return;
	}
	TreeMap modificationTypes = view.getModificationTypes();
	TreeMap selectedMap = view.getSelectedModifications();
	ErrorReport errorReport = view.getErrorReport(); 
	//Nayanatara L Pai- Changes Start
	HashSet errorValues = errorReport.getErrorFieldNames();
	BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO)opptSession.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
		ModificationContactActionForm actionForm = null;
		if(view.getActionForm()!=null && view.getActionForm() instanceof ModificationContactActionForm){
                 actionForm = (ModificationContactActionForm)view.getActionForm();	
		}else{
		          actionForm = new ModificationContactActionForm();
		}
		
		
	
		
	//Nayanatara L Pai- Changes End
%>
<div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
<table summary="Base agreement maintenance" cellpadding="0" cellspacing="0" border="0" width="800">
            <tr valign="top"> 
              <td width="458"> 
                <table role="presentation" width="116%">	
<% if(amendFlag) { %>                
                <tr valign="top"> 
                    <th> 
                      <h1> Base agreement maintenance</h1>
                    </th>
                  </tr>
                  <tr> 
                    <td> 
                      <p class="ibm-alternate"><em>Amend base agreement - Display modification</p>
                    </td>
                  </tr>
<% } else  { %>     
                <tr valign="top"> 
                    <td> 
                      <h1>Base agreement registration</h1>
                    </td>
                  </tr>
                  <tr> 
                    <td> 
                      <p class="ibm-alternate"><em>Display modification </p>
                    </td>
                  </tr>             
<% } %>     
<tr> <td>
  	<oppt:displayErrorReport errorReport="<%=errorReport%>" />  </td></tr> <!-- nayan -->     
  	
  	<% if(amendFlag) { %>  
  	<tr>
                 <td>
                 
                    To set the common C&N/Legal contact and Accounting contact for all the modifications,
                    enter the values in the fields and press the Apply to All button. Press the Add button for adding the modification details. The C&N/Legal contact and 
                    Accounting contact will be prepopulated. These values can be overridden for individual
                    modifications.Press the Edit button to edit the already added modification details. Press the 
                    View button to display the modification details. Press the Inactivate button to 
                    inactivate the already registered modification details and newly added modification details.Press the Reactivate button to 
                    reactivate the already registered modification details and newly added modification details. Press the Register button to register base agreement. 
                    Press Cancel button to go back to the previous page.
                                    
                 </td>
                 </tr>
   <% } else  { %> 
                 <tr>
                 <td>
                    
                    To set the common C&N/Legal contact and Accounting contact for all the modifications,
                    enter the values in the fields and press the Apply to All button. Press the Add button for adding the modification details. The C&N/Legal contact and 
                    Accounting contact will be prepopulated. These values can be overridden for individual
                    modifications.Press the Edit button to edit the already added modification details. Press the 
                    View button to display the modification details. Press the Inactivate button to 
                    delete the already added modification details. Press the Register button to register base agreement. 
                    Press Cancel button to go back to the previous page.
                                    
                 </td>
                 </tr>
   <% } %>                   
                 <tr>
				<td align="left">
				<p>Required fields are marked with an asterisk (<strong>*</strong>) and must
				be filled in to complete the form.</p>
				</td>
			</tr>
                 <tr>
                 <td>
                 &nbsp;&nbsp;&nbsp;&nbsp;
                 </td>    
                 </tr>
                 </table>
              </td>
              <td width="76">&nbsp;</td>
            </tr>
            
          </table>
        
          
          
          
<!-- Nayanatara L Pai - Changes start -->
   <html:form action="/protect/AddContactAction.wss" method="post">
	
  <table border = "0" width="600">
  <tr>
	<td height="25"  colspan="6" style=background-color:#cccccc;  class="bar-blue-med">Global C&N/Legal contact and Accounting contact</td>
  </tr>
  <tr></tr>
  </table>
  <table border = "0" width="600">
   <tr> 
   	<td height="20" width="10"><strong>*</strong></td>    
    <td height="20" width="130"><label for="legalContact"><oppt:label label="C&N/Legal&nbsp;contact:" id="legalContact" errorLables="<%=errorValues%>" /></label></td>
    <td height="20" width="370"><oppt:text name ="legalContact" value = "<%=actionForm.getLegalContact()%>" maxlength="20" styleClass="iform" size = "20" styleId="legalContact" title="Enter legal contact"/></td>
    <td height="20" width="10"><strong>&nbsp;</strong></td> 
  	<td height="20" width="130"><label for="accountingContact"><oppt:label label="Accounting&nbsp;contact:" id="accountingContact" /></label></td>
    <td height="20" width="370"><oppt:text name ="accountingContact" value = "<%=actionForm.getAccountingContact()%>" maxlength="20" styleClass="iform" size = "20" styleId="accountingContact" title="Enter accounting contact"/></td>
  </tr> 
  </table>
  <table border = "0" width="600">
    
    <tr><td align="right">
 
   <oppt:button id="applytoall" name="applytoall" alt="Apply to all" value="Apply to all" primary="true" />
   
</td></tr>
<tr></tr>
<tr></tr>
<tr></tr>
</table>
              
 </html:form>
<!-- Nayanatara L Pai - Changes end -->
 <oppt:displaymodification modTypes="<%=modificationTypes %>" selectedModTypes= "<%=selectedMap%>" />
<html:form action="/protect/DisplayModificationRegisterMultipleAction.wss" method="post">
<table width="800">
<tr><td width="600" align="right">
 <oppt:buttons buttonFlags="<%= buttonFlags %>">
   <oppt:button id="register" name="multipleButtonManager.register" alt="Register" value="Register" primary="true" />
   <oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" value="Cancel" primary="true" />
</oppt:buttons>
</td></tr>
</table>
</html:form>
 
  
  
  
  