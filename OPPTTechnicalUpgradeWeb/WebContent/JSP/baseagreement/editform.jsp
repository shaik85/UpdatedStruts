
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormDetailViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.EditFormActionForm" %>
<%

    HashSet errorValues = null;
	OPPTSession opptSession = new OPPTSession(session);
	FormDetailViewBean view = (FormDetailViewBean) opptSession.getCurrentViewBean();
	
	//FormDetailsActionForm actionForm = (FormDetailsActionForm)view.getActionForm();
	
	EditFormActionForm actionForm = (EditFormActionForm)view.getActionForm();
	if(null == view){
		return;
	}
	if(actionForm == null) {
		actionForm = new EditFormActionForm();
		
		
	}
	
	ErrorReport errorReport = view.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	HashSet errorLabels = errorReport.getErrorFieldNames();
	String selectedSalesOrg =com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder.getSalesOrgDesc(view.getSalesOrg())+"-"+view.getSalesOrg();
	
	
	String formNumber = (String)view.getFormNumber();
	
	TreeMap modificationOptionsMap = null;
	
	%>
<div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
 <table cellpadding="0" cellspacing="0" border="0" width="750" summary="Form maintenance">
            <tr valign="top"> 
              <td width="750"> 
                <table width="750"  role="presentation">
                  <tr valign="top">
                    <th> 
                       <h1>Form maintenance</h1>
                    </th>
                </tr>
				<tr>
                    <td> 
                      <p class="ibm-alternate"><em>Edit form </p>
                    </td>
				</tr>
                  <tr> 
                  <td>
  					  <oppt:displayErrorReport errorReport="<%=errorReport%>" />  
  					  <p>Edit the selected form by entering the details as required.Then press the  
  					  	 Save form button to save the form.  Press the Clear all button to discard 
  					     your input. Press Cancel button to go back to the form maintenance page.
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
<html:form action="/protect/EditFormMultipleAction" method="post" >

<table width="750">
  <tr> 
    <th width="750" style=background-color:#cccccc;  class="bar-blue-med"><strong>Form details</strong></th>
  </tr>
  <tr> 
    <td width="750"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
	    
	    
	    <tr> 
          <td height="25" width="30" align = "right"></td> 
          <td height="25" width="180"><label for="salesOrg"><oppt:label label="Sales organisation:" id="salesOrg" /></label></td>
          <td height="25" width="180"><label for="salesOrg"><oppt:label label="<%=selectedSalesOrg%>" id="salesOrg"  /></label></td>                      
        </tr>
         
        <tr> 
          <td height="25" width="30" align = "right"></td> 
          <td height="25" width="180"><label for="formNumber"><oppt:label label="Form number:" id="formNumber" /></label></td>
          <td height="25" width="180"><label for="formNumber"><oppt:label label="<%=formNumber%>" id="formNumber"  /></label></td>                      
        </tr>
         
        <tr> 
          <td width="12">*</td>
          <td width="170" height="25"><label for="formLongDescription"><oppt:label label="Long&nbsp;description:" id="formLongDescription" errorLables="<%=errorValues%>" /></label></td>
          <td width="250" height="20"><oppt:text name="formLongDescription" styleClass="iform" styleId="formLongDescription" value="<%=actionForm.getFormLongDescription() %>" maxlength="35" /> 
          </td>
        </tr>
        <tr> 
          <td width="12">*</td>
          <td width="170" height="25"><label for="formShortDescription"><oppt:label label="Short&nbsp;description:" id="formShortDescription" errorLables="<%=errorValues%>" /></label></td>
          <td width="175" height="20"><oppt:text name="formShortDescription" styleClass="iform" styleId="formShortDescription"  value="<%=actionForm.getFormShortDescription() %>" maxlength="35" /> 
          </td>
        </tr>
        <tr>
         <td width="12">*</td>
          <td width="170" height="25"><label for="language"><oppt:label label="language:" id="Language" errorLables="<%=errorValues%>" /></label></td>
          <td width="175" height="20"><oppt:text name="language" styleClass="iform" styleId="language" value="<%=actionForm.getLanguage() %>" maxlength="40" /> 
          </td>
        </tr>
      </table>
    </td>
  </tr>
  
  
  <tr>
    <td width="750" align="right">

       <oppt:button id="saveform" name="multipleButtonManager.saveform" alt="Save form" value="Save form" primary="true" />
       <oppt:button id="clearall" name="multipleButtonManager.clearall" alt="ClearAll" value="Clear all" primary="true" />
       <oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" value="Cancel" primary="true" />

    </td>
  </tr>
</table>
</html:form>





