
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementDetailViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean"%>

<%
	OPPTSession opptSession = new OPPTSession(session);
    int baUserRole = opptSession.getUserInfo().getBaRole(); 
	BaseAgreementDetailViewBean view = (BaseAgreementDetailViewBean) opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	TreeMap modDetailMap = view.getModificatioDetailsMap();
 %>
<div id="edit-layout" align="right">
  <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Base agreement maintenance">
<html:form action="/protect/CancelViewAction.wss">
			<tr valign="top">
			<td width="600">
			<table width="600" summary="Base agreement maintenance">
				<tr valign="top">
                    <th> 
                       <h1>Base agreement maintenance</h1>
                    </th>
                </tr>
				<tr>
                    <th> 
                      <p class="ibm-alternate"><em>View base agreement </p>
                    </th>
				</tr>
				<tr>
					<td>
					   <p> Press Continue button to go back to base agreement maintenance page.
  					   </p> 
  					 </td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td>
		      <table border="0" width="600">
		        <tr>
		          <td height="20" width="200"><label for="customerNumber">SAP&nbsp;customer&nbsp;number:</label></td>
		          <td height="20" width="400"><oppt:label label="<%=view.getCustomerNumber()%>" /></td>
				</tr>
				<tr>
			      <td height="20" width="200"><label for="enterpriseNumber">Enterprise&nbsp;number:</label></td>
			      <td height="20" width="400"><oppt:label	label="<%=view.getEnterpriseNumber()%>" /></td>
				</tr>
				<tr>
			      <td height="20" width="200"><label for="customerName">Customer&nbsp;name:</label></td>
			      <td height="20" width="400"><oppt:label	label="<%=view.getCustomerName()%>" /></td>
				</tr>
				<tr>
			      <td height="20" width="200"><label for="enterpriseName">Enterprise&nbsp;name:</label></td>
			      <td height="20" width="400"><oppt:label	label="<%=view.getEnterpriseName()%>" /></td>
				</tr>
				
				<tr>
		          <td height="20" width="200"><label for="customerRepresentative">Customer&nbsp;representative:</label></td>
		          <td height="20" width="400"><oppt:label label="<%=view.getCustomerRepresentative()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="salesOrganisation">Sales&nbsp;organisation:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=view.getSalesOrganisation()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="formNo">Form&nbsp;number:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=view.getFormNo()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="formShortDescripton">Form&nbsp;short&nbsp;description:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=view.getFormShortDescripton()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="formlongDescription">Form&nbsp;long&nbsp;description:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=view.getFormLongDescripton()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="acceptedDate">Accepted&nbsp;date:</label></td>
		          <td height="20" width="400"><oppt:date	date="<%=view.getAcceptedDate() %>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="agreementNumber">Agreement&nbsp;number:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=view.getAgreementNumber()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="imageReferenceNumber">Image&nbsp;reference&nbsp;number:</label></td>
		          <td height="20" width="400"><oppt:label label="<%=view.getImageReferenceNumber()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="branchOffice">Branch&nbsp;office:</label></td>
		          <td height="20" width="400"><oppt:label label="<%=view.getBranchOffice()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="coverageType">Coverage&nbsp;type:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=view.getCoverageType()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="178"><label for="agreementStatus">Agreement&nbsp;status:</label></td>
		          <td height="20" width="412"><oppt:label	label="<%=view.getAgreementStatus()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="178"><label for="oneWay">One&nbsp;way:</label></td>
		          <td height="20" width="412"><oppt:label	label="<%=view.getOneWay()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="178"><label for="oneWay">Is&nbsp;electronic&nbsp;submitter:</label></td>
		          <td height="20" width="412"><oppt:label	label="<%=view.getIsElectronicSubmitter()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="178"><label for="isModified">Is&nbsp;modified:</label></td>
		          <td height="20" width="412"><oppt:label label="<%=view.getIsModified()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="createdDate">Created&nbsp;date:</label></td>
		          <td height="20" width="400"><oppt:date	date="<%=view.getCreatedDate() %>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="createdBy">Created&nbsp;by:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=view.getCreatedBy()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="178"><label for="changedDate">Changed&nbsp;date:</label></td>
		          <td height="20" width="412"><oppt:date	date="<%=view.getChangedOn() %>" /></td>
				</tr>
				<tr>
		          <td height="20" width="178"><label for="changedBy">Changed&nbsp;by:</label></td>
		          <td height="20" width="412"><oppt:label	label="<%=view.getChangedBy()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="178"><label for="documentExpiryDate">Expiry date:</label></td>
		          <td height="20" width="412"><oppt:date	date="<%=view.getExpiryDate() %>" /></td>
				</tr>
			</table>
			</td>
		</tr>
<% 
  if(view.isShowModificationDetail())
  {
	  if (null != view.getModificatioDetailsMap() && view.getModificatioDetailsMap().size() > 0 ) {   
%>    <tr>
	      <th style=background-color:#cccccc;  class="bar-blue-med" width="499" align="left" height="13"><strong> Modification terms</strong></th>
		</tr>
<%
	  Iterator modDetailKeySetIterator = view.getModificatioDetailsMap().keySet().iterator();
	  while(modDetailKeySetIterator.hasNext()){ 
		  String key= (String)modDetailKeySetIterator.next();
		  DisplayModificationDetailViewBean modDetailView = (DisplayModificationDetailViewBean) modDetailMap.get(key);
	  	  String roloption = null;
	  	 String status = modDetailView.getStatus().equals("A")? "Active":"Inactive";
	  	  if(com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants.ROL.equals(key)) {
	  	  	roloption = (String)modDetailView.getRolOptions().get(modDetailView.getSelectedRolOption());
	  	  }
 %> 	<tr>
			<td height="490">
		      <table border="0" width="600">
        		<tr class="gray">
					<td height="18" width="499" colspan="2"><oppt:label	label="<%=modDetailView.getModificationTypeCode()%>" /></td>
				</tr>
				<tr>
			      <td height="20" width="200"><label for="legalContact">C&N/Legal&nbsp;contact:</label></td>
			      <td height="20" width="400"><oppt:label	label="<%=modDetailView.getLegalContact()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="accountingContact">Accounting contact:</label></td>
			      <td height="20" width="400"><oppt:label	label="<%=modDetailView.getAccountingContact()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="modifiedIBMLetterHead">Customer&nbsp;Letterhead:</label></td>
		          <% if(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants.YES.equals(modDetailView.getModifiedIBMLetterHead())) { %>
			    		<td height="20" width="400"><oppt:label label="Checked"/></td>
				  <% } else { %>
				    	<td height="20" width="400"><oppt:label label="Unchecked"/></td>
				  <% }  %>
				</tr>
				<tr>
	               <td height="20" width="200"><label for="revenueRecognition">Revenue recognition:</label></td>
		          <% if(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants.YES.equals(modDetailView.getRevenueRecognition())) { %>
			    		<td height="20" width="400"><oppt:label label="Checked"/></td>
				  <% } else { %>
				    	<td height="20" width="400"><oppt:label label="Unchecked"/></td>
				  <% }  %>
				</tr>
				<% if(null!= roloption) {%>				
				<tr>
		          <td height="20" width="200"><label for="rolMoveDate">ROL start date:</label></td>
		          <td height="20" width="400"><oppt:date	date="<%=modDetailView.getRolStartDateView()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="rolMoveDate">ROL end date:</label></td>
		          <td height="20" width="400"><oppt:date date="<%=modDetailView.getRolEndDateView()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="rolOptions">ROL transfer event:</label></td>
		          <td height="20" width="400"><oppt:label label="<%= roloption%>" /> </td>
				</tr>
<%				} 
%>				<tr>
		          <td height="20" width="200"><label for="details">Details:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=modDetailView.getDetails()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="details">Status:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%= status %>" /></td>
				</tr>
					<tr>
		          <td height="20" width="200"><label for="details">Cretaed&nbsp;by:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=modDetailView.getCreatedBy()%>" /></td>
				</tr>
					<tr>
		          <td height="20" width="200"><label for="details">Created&nbsp;date:</label></td>
		          <td height="20" width="400"><oppt:date	date="<%=modDetailView.getCreatedDate()%>" /></td>
				</tr>
			<% if(modDetailView.getChangedBy() != null && modDetailView.getChangedBy().length()!=0){%>
					<tr>
		          <td height="20" width="200"><label for="details">Changed&nbsp;by:</label></td>
		          <td height="20" width="400"><oppt:label	label="<%=modDetailView.getChangedBy()%>" /></td>
				</tr>
				<tr>
		          <td height="20" width="200"><label for="details">Changed&nbsp;date:</label></td>
		          <td height="20" width="400"><oppt:date	date="<%=modDetailView.getChangedDate()%>" /></td>
				</tr>
				<% }%>
			</table>
			</td>
		</tr>
<%    }
		} 
    }
%>		<tr>
			<td width="600" align="right"><oppt:button id="cancel"	name="multipleButtonManager.cancel" alt="Continue" primary="true"	value="Continue" /></td>
		</tr>
	</table>
</html:form>
