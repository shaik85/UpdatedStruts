
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SearchBaseAgreementViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SearchListActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SearchParamActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper"%>

<%  
	HashSet errorValues = null;
	SearchBaseAgreementViewBean view = null;
    OPPTSession opptSession = new OPPTSession(session);
    // Added by Balaji to avoid class cast exception
	if(null != opptSession.getCurrentViewBean() && opptSession.getCurrentViewBean() instanceof SearchBaseAgreementViewBean) {
		view = (SearchBaseAgreementViewBean) opptSession.getCurrentViewBean();
	}else {
		view = new SearchBaseAgreementViewBean();
	}
	if (null == view) {
		return;
	}
	SearchParamActionForm actionForm = new SearchParamActionForm();
	if(view.getActionForm() != null && view.getActionForm() instanceof SearchParamActionForm) {
		actionForm = (SearchParamActionForm) view.getActionForm();
		if(null == OPPTHelper.trimStringToNull(actionForm.getFormNumber()) && 
	   	   null == OPPTHelper.trimStringToNull(actionForm.getCustomerNumber()) && 
	   	   null == OPPTHelper.trimStringToNull(actionForm.getCustomerLegacyNumber()) && 
 	       null == OPPTHelper.trimStringToNull(actionForm.getAgreementNumber()) && 
	       null == OPPTHelper.trimStringToNull(actionForm.getEnterpriseNumber()) &&
		   null == OPPTHelper.trimStringToNull(actionForm.getImageReferenceNumber()) &&
		   null == OPPTHelper.trimStringToNull(actionForm.getCustomerName())&&
		   null == OPPTHelper.trimStringToNull(actionForm.getAccountNumber())
		   ){
		   
			view.setBaseAgreementList(new ArrayList());
		}
	}
	
	String agreementId = "0";
	ErrorReport errorReport = view.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = view.getButtonFlags();
	HashSet errorLabels = errorReport.getErrorFieldNames();
	if(errorReport == null || (errorReport != null && errorReport.size() == 0))  {
		if(session.getAttribute(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM) != null) {
			SearchListActionForm searchListActionForm = (SearchListActionForm) session.getAttribute(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM);
			searchListActionForm.setAgreementId(0);
			session.setAttribute(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM,searchListActionForm);
		}
	}else {
	if(session.getAttribute(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM) != null) {
			SearchListActionForm searchListActionForm = (SearchListActionForm) session.getAttribute(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM);
			agreementId = ""+searchListActionForm.getAgreementId();
			session.setAttribute(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM,searchListActionForm);
		}
		
	}
%>
<div id="edit-layout" align="right"><a href="javascript:getFormHelp()">
  <img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Base agreement maintenance info">
	<tr valign="top">
		<td width="600">
		<table width="600" summary="Base agreement maintenance">
			<tr>
				<h1>Base agreement maintenance</h1>
			</tr>
			<tr>
				<th><p class="ibm-alternate"><em>Search base agreement</p>
				</th>
			</tr>
			<tr>
			<td>
			<oppt:displayErrorReport errorReport="<%=errorReport%>" />
			</td></tr>
			
			<tr>
				<td>
				<p> Use this form to retrieve the base agreement list depending on the search criteria 
				   (Form number,SAP Customer number, Agreement number,Customer name,Image reference number and Enterprise number) provided by the user. 
				    Selection of the search criteria user can enter the data and press the Go button.
				</p>
				</td>
			</tr>
			<tr>
		     <td>
		     		<p> Wild card search is only supported for form numbers, Please use * after the search criteria
                        to retrive the results
				</p>
				</td>
			</tr>
			<%  if (view.getBaseAgreementList() != null && view.getBaseAgreementList().size() > 0) 
					{
				%>
				<tr>
				<td>
				<p>
				  Search Base Agreement,Select the base agreement from the list by clicking the radio button for 
				  particular base agreement.Then press the View details button to view the details of the base
				  agreement.Press Amend button to amend the agreement. Press the Inactivate button to 
				  inactivate the selected base agreement and press the Reactivate button to 
				  reactivate the selected base agreement.
				    </p>
				</td>
				</tr>
			<tr>
              <td>
              <p>Required fields are marked with an asterisk (<strong>*</strong>) 
                        and must be filled in to complete the form.</p>
               </td>
               </tr>
               
              	<% }%>	
		</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
<table width="600">	
	<tr>
		<td><html:form action="/protect/SearchBaseAgreement.wss" method="post">
			
      <table border="0" width="600" summary="Providing Details for Search">
        <tr>
			<th height="25" colspan="6" style=background-color:#cccccc;  class="bar-blue-med">Search by:</th>
		</tr>
		<tr>
          <td height="25" width="180"><label for="customerNumber"><oppt:label label="SAP&nbsp;customer&nbsp;number:" id="customerNumber" errorLables="<%=errorValues%>" /></label></td>
          <td height="25" width="80"><oppt:text name="customerNumber" value="<%= actionForm.getCustomerNumber()%>" maxlength="10" styleId="customerNumber" styleClass="iform" size="20" title="Enter customer number"/></td>
          <td height="25" width="30"></td>
          <td height="25" width="190"><label for="enterpriseNumber"><oppt:label label="Enterprise&nbsp;number:" id="enterpriseNumber" errorLables="<%=errorValues%>" /></label></td>
          <td height="25" width="80"><oppt:text name="enterpriseNumber" value="<%= actionForm.getEnterpriseNumber()%>" maxlength="10" styleId="enterpriseNumber" styleClass="iform" size="20" title="Enter enterprise number"/></td>
          <td height="31" width="30"></td>
		</tr>
  	<!--<td width="190" height="25"><label for="customerLegacyNumber"><oppt:label label="Customer&nbsp;legacy&nbsp;number:" id="customerLegacyNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="175" height="20"><oppt:text name="customerLegacyNumber" styleClass="iform" styleId="customerlegacyNumber"value="<%= actionForm.getCustomerLegacyNumber()%>"  size="20"  maxlength="35" /> 
          <td width="30" height="25"></td>
          <td width="190" height="25"><label for="iNACNumber"><oppt:label label="INAC:" id="iNACNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="80" height="25"><oppt:text name="accountNumber" styleClass="iform" styleId="iNACNumber" value="<%=actionForm.getAccountNumber() %>"  maxlength="35" /> </td>
        </td></tr> 
          -->
		  
		 <tr>
		<td width="190" height="25"><label for="customerName"><oppt:label label="Customer&nbsp;name:" id="customerName" errorLables="<%=errorValues%>" /></label></td>
          <td width="175" height="20"><oppt:text name="customerName" styleClass="iform" styleId="customerName" size="20" value="<%=actionForm.getCustomerName() %>" maxlength="35" title="Enter customer name" /> 
          </td>
          <td width="30" height="25"></td>
          <td width="190" height="25"><label for="imageReferenceNumber"><oppt:label label="Image&nbsp;reference&nbsp;number:" id="imageReferenceNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="80" height="25"><oppt:text name="imageReferenceNumber" styleClass="iform" styleId="imageReferenceNumber" value="<%=actionForm.getImageReferenceNumber() %>" maxlength="35" title="Enter imagereference number"/> 
          </td>
			
		</tr> 
		<tr>
          <td height="25" width="180"><label for="formNumber"><oppt:label label="Form number:" id="formNumber" errorLables="<%=errorValues%>" /></label></td>
          <td height="25" width="80"><oppt:text name="formNumber" value="<%= actionForm.getFormNumber()%>" maxlength="35"	styleId="formNumber" styleClass="iform" size="20" title="Enter form number"/></td>
          <td width="30" height="25"></td>
          <td height="25" width="190"><label for="agreementNumber"><oppt:label label="Agreement&nbsp;number:" id="agreementNumber" errorLables="<%=errorValues%>" /></label></td>
          <td height="25" width="80"><oppt:text name="agreementNumber" value="<%= actionForm.getAgreementNumber()%>" maxlength="15" styleId="agreementNumber" styleClass="iform" size="20" title="Enter agreement number" /></td>
          <td height="31" width="30"><span class="button-blue"><input	type="submit" value="Go" /></span></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		</table>
		</html:form></td>
	</tr>
	<tr>
		<td><html:form action="/protect/SearchBaseAgreementMultipleAction.wss">
			<table border="0" width="600">
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="right">
					<oppt:searchlist baseAgreementList="<%= view.getBaseAgreementList() %>" agreementId="<%=agreementId%>" /> 
				</td></tr>
				
				<tr>
					<td align="right">
				<%  if (view.getBaseAgreementList() != null && view.getBaseAgreementList().size() > 0) 
					{
				%>
					<oppt:buttons buttonFlags="<%=buttonFlags %>">
						<oppt:opptbutton id="viewdetails"
							name="multipleButtonManager.viewdetails" alt="Viewdetails"
							primary="true" value="View details" />
						<oppt:opptbutton id="inactivate"
							name="multipleButtonManager.inactivate" alt="Inactivate"
							primary="true" value="Inactivate" />
						<oppt:opptbutton id="amend" name="multipleButtonManager.amend"
							alt="Amend" primary="true" value="Amend" />
						<oppt:opptbutton id="reactivate" name="multipleButtonManager.reactivate"
							alt="Reactivate" primary="true" value="Reactivate" />
						
					</oppt:buttons> <%}
			%></td>
				</tr>
			</table>
		</html:form>
		</td>
	</tr>
</table>
