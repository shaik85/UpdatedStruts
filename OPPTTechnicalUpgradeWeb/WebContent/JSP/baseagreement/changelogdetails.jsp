<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementChangeLogDetailsViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementChangeLogActionForm"%>

<%  
	HashSet errorValues = null;
	BaseAgreementChangeLogDetailsViewBean viewBean = null;
	OPPTSession opptSession = new OPPTSession(session);
	BaseAgreementChangeLogActionForm actionForm = null;
	if(null != opptSession.getCurrentViewBean() && opptSession.getCurrentViewBean() instanceof BaseAgreementChangeLogDetailsViewBean) {
		viewBean = (BaseAgreementChangeLogDetailsViewBean) opptSession.getCurrentViewBean();
		actionForm = (BaseAgreementChangeLogActionForm)viewBean.getBaseAgreementChangeLogActionForm();
	}else {
		viewBean = new BaseAgreementChangeLogDetailsViewBean();
	}
	if (null == viewBean) {
		return;
	}

	String selectedSalesOrg = "Select one";
	if(null != actionForm.getSalesOrganization() && !"Select one".equals(actionForm.getSalesOrganization())) {
	  	selectedSalesOrg =actionForm.getSalesOrganization();
		}
 
	ErrorReport errorReport = viewBean.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
if(errorReport != null && errorReport.size()!= 0){
viewBean.setChangedDetailsList(new ArrayList());
}

	%>
	
<div id="edit-layout" align="right"><a href="javascript:getFormHelp()">
  <img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>

<table summary="Change history" cellpadding="0" cellspacing="0" border="0" width="800">
            <tr valign="top"> 
              <td width="458"> 
                <table role="presentation" width="116%">	
              
                <tr valign="top"> 
                    <td> 
                      <h1> Change history</h1>
                    </td>
                  </tr>
                  
            
               <tr>
                 <td><oppt:displayErrorReport errorReport="<%=errorReport%>" /></td>
                 </tr>
                 <tr>
                 <td>
                    <p>This screen helps to listing all the changes made to this Base agreement.
                    It shows what changed, when did it change and who changed it.</p>
                                    
                 </td>
                 </tr>
                 <tr>
                    <td>
                    <p>user should enter one optional field either customer number or 
                    enterprise number along with the mandatory fields.When user clicks on Create button based on 
                    user input it will show the change details about that particular base agreement</p>
                                    
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
        <table summary="layout" cellpadding="0" cellspacing="0" border="0" width="800">
        <html:form action="/protect/ChangeLogAction.wss">
            <tr valign="top"> 
              <td width="458">
			<table summary="changehistory" width="100%">

				<tr>
				    <td height="25" width="40"><strong class="black">*</strong></td> 
				    <td width="150" height="25" ><label for="salesOrganization"><oppt:label label="Sales&nbsp;organisation:" id="salesOrganization" errorLables="<%=errorValues%>" /></label></td>
                    <td width="125" height="25" ><oppt:select  selectedOption="<%=selectedSalesOrg%>" name="salesOrganization" id="salesOrganization" options="<%=viewBean.getSalesOrgDetails()%>" title="select Sales Organisation" /></td>
                   
                    <td height="25" width="40"><strong class="black">*</strong></td> 
					<td height="25" width="180"><label for="agreementNumber"><oppt:label label="Agreement&nbsp;number:" id="agreementNumber" errorLables="<%=errorValues%>"/></label></td>
 					<td height="25" width="180"><oppt:text name="agreementNumber" value="<%=actionForm.getAgreementNumber()%>" maxlength="30" styleId="agreementNumber" styleClass="iform" size="20" title="Enter agreement number"/></td>
                </tr>
                <tr>
                    <td height="25" width="40"></td> 
					<td height="25" width="180"><label for="customerNumber"><oppt:label label="Customer&nbsp;number:" id="customerNumber" errorLables="<%=errorValues%>"/></label></td>
					<td height="25" width="108"><oppt:text name="customerNumber" value="<%=actionForm.getCustomerNumber()%>" maxlength="30" styleId="customerNumber" styleClass="iform" size="20" title="enter customer number"/></td>
					<td height="25" width="40"></td> 
					<td height="25" width="180"><label for="enterpriseNumber"><oppt:label label="Enterprise&nbsp;number:" id="enterpriseNumber" errorLables="<%=errorValues%>"/></label></td>
					<td height="25" width="108"><oppt:text name="enterpriseNumber" value="<%=actionForm.getEnterpriseNumber()%>" maxlength="30" styleId="enterpriseNumber" styleClass="iform" size="20" title="Enter enterprise number" /></td>
				</tr>
                <tr> <td colspan="6">&nbsp;</td></tr>
                <tr>

	         <td width="600" align="right" colspan="6"><oppt:button id="continue"	name="multipleButtonManager.continue" alt="Create" primary="true"	value="Create" /></td>

	         </tr>
                
			</table>
			</td></tr>
      <% 
      if(viewBean.getChangedDetailsList()!=null && viewBean.getChangedDetailsList().size()!=0){        %>
	         
	         <tr>
	         <td>
	         <oppt:changelog changeLogDetailsList = "<%=viewBean.getChangedDetailsList()%>"/>
	         </td>
	         </tr>
	         	         <% }%>
	        <% if(viewBean.getIsModified()!=null && !viewBean.getIsModified().equals("No"))
	         {
	         %>
	         <tr>
	         <td>
	         &nbsp;&nbsp;&nbsp;&nbsp;
	         </td>
	         </tr>
	         
	         
	         <tr>
	         <td>
	             &nbsp;&nbsp;&nbsp;&nbsp;No changes made on this slected Base Agreement
	         </td>
	         </tr>
	         <% }  %>
	         
	         <tr>
	         <td>
	         &nbsp;&nbsp;&nbsp;&nbsp;
	         </td>
	         </tr>
	         
	         	         
	         </html:form>
	         </table>
	