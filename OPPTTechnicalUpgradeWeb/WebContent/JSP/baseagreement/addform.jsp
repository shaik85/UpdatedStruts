
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormDetailViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AddFormActionForm"%>
<%
    HashSet errorValues = null;
	OPPTSession opptSession = new OPPTSession(session);
	FormDetailViewBean view = (FormDetailViewBean) opptSession.getCurrentViewBean();
	AddFormActionForm actionForm = (AddFormActionForm)view.getActionForm();
	
	if(null == view){
		return;
	}
	if(actionForm == null) {
		actionForm = new AddFormActionForm();
		
		
	}
  String typeCode = actionForm.getSalesOrg();
	String selectedSalesOrg =(String) view.getSalesOrg();
	ErrorReport errorReport = view.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	HashSet errorLabels = errorReport.getErrorFieldNames();
	
	%>
<div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
 <table cellpadding="0" cellspacing="0" border="0" width="750" summary="Form maintenance">
            <tr valign="top"> 
              <td width="750"> 
                <table width="750"  role="presentation">
                  <tr valign="top"> 
                    <td> 
                      <h1>Form maintenance</h1>
                    </td>
                  </tr>
                  <tr>
					<td>
						<p class="ibm-alternate"><em>Add form</p>
					</td>
				</tr>
                  <tr> 
                  <td>
  					  <oppt:displayErrorReport errorReport="<%=errorReport%>" />  
  					  <p>Create a new form by selecting the Sales organization to which it should belong and entering the 
  					  	 details as required.Then press the Save form button to save the form.  Press the Clear all
  					     button to discard your input. Press Cancel button to go back to the form maintenance page.
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

  <html:form action="/protect/AddFormMultipleAction" method="post" >

<table width="750">
  <tr> 
    <td width="750" style=background-color:#cccccc;  class="bar-blue-med"><strong>Form details</strong></td>
  </tr>
  <tr> 
    
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
	    <tr>
	          <td width="12" height="20"> </td>
	          <td width="200" height="25"><label for="salesOrg"><oppt:label label="Sales&nbsp;organisation:" id="salesOrg" errorLables="<%=errorValues%>"  /></label></td>
	          <td height="25" width="180"><label for="salesOrg"><oppt:label label="<%=selectedSalesOrg%>" id="salesOrg"  /></label></td>                      

	    </tr>
	    
	    <tr> 
	    
          <td width="12">*</td>
          <td width="170" height="25"><label for="formNumber"><oppt:label label="Form&nbsp;number&nbsp;and&nbsp;version:" id="formNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="150" height="20"><oppt:text name="formNumber" styleClass="iform" styleId="formNumber" value="<%=actionForm.getFormNumber() %>" maxlength="10" /> </td>
          <td width="12">-</td>
          <td width="12">*</td>
          <td width="10" height="20"><oppt:text name="formVersion" styleClass="iform" styleId="formVersion" value="<%=actionForm.getFormVersion() %>" maxlength="3" /> </td>
          
        </tr>
         
        <tr> 
          <td width="12">*</td>
          <td width="170" height="25"><label for="formLongDescription"><oppt:label label="Long&nbsp;description:" id="formLongDescription" errorLables="<%=errorValues%>" /></label></td>
          <td width="175" height="20"><oppt:text name="formLongDescription" styleClass="iform" styleId="formLongDescription" value="<%=actionForm.getFormLongDescription() %>" maxlength="35" /> 
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
          <td width="170" height="25"><label for="language"><oppt:label label="Language:" id="language" errorLables="<%=errorValues%>" /></label></td>
          <td width="175" height="20"><oppt:text name="language" styleClass="iform" styleId="language" value="<%=actionForm.getLanguage() %>" maxlength="40" /> 
          </td>
        </tr>
      </table>
    
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








