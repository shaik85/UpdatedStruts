  
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerDetailsViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerInformationViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.FetchCustomerListActionForm" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.GetPartnersActionForm" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	PartnerDetailsViewBean view = (PartnerDetailsViewBean) opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	FetchCustomerListActionForm actionForm = view.getFetchCustomerListActionForm();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal creation</h1>

<p ><em><br>Partner details</em></p>		
		</div>
	</div>



<div id="ibm-content-body">

<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600" >
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600" >
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				
				<td>&nbsp;</td><tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />

						<p>You may input enterprise information. If input 
						is enterprise information to retrieve Site Id numbers, click the Fetch customer 
						button. Click the Clear enterprise information input button to discard your input to fetch Site Id.			
						</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/FetchCustomerListMultipleAction.wss">
	<table summary="presentation" width="600" cellpadding="1" cellspacing="1" border="0" >
		<tr>
			<th width="600" colspan="2" style="background-color:#cccccc;" class="ibm-bar-med-blue" scope="col">Enterprise information</th>
		</tr>
		<td>&nbsp;</td>
		<tr>
			<td width="167" valign="bottom">&nbsp;&nbsp;<label for="customerListNumber"><oppt:label label="Site Id:" id="customerListNumber" errorLables="<%=errorValues%>" /></label></td>
		<!-- commented for  DAD02	<td width="427" valign="bottom">&nbsp;&nbsp;<oppt:text name="customerListNumber" styleId="customerListNumber" styleClass="iform" maxlength="10" size="10" value="<%=actionForm.getCustomerListNumber() %>" /></td>--> 
    		<td width="427" valign="bottom">&nbsp;&nbsp;<oppt:text name="siteID" styleId="customerListNumber" styleClass="iform" maxlength="25" size="25" value="<%=actionForm.getCustomerListNumber() %>" /></td><!-- size modified to 25 defect BHALM00076104-->
		</tr>
		<tr>
			<td valign="bottom">&nbsp;&nbsp;<label for="customerListName"><oppt:label label="Site name:" id="customerListName" errorLables="<%=errorValues%>" /></label></td>
			<!-- <td valign="bottom">&nbsp;&nbsp;<oppt:text name="customerListName" styleId="customerListName" maxlength="25" size="25" styleClass="iform" value="<%=actionForm.getCustomerListName() %>" /></td>-->
			<td valign="bottom">&nbsp;&nbsp;<oppt:text name="siteName" styleId="customerListName" maxlength="25" size="25" styleClass="iform" value="<%=actionForm.getCustomerListName() %>" /></td>
		</tr>
<%
	if(!view.isRoleBusinessPartner()){
%>
		<tr>
			<td valign="bottom">&nbsp;&nbsp;<label for="zipCode"><oppt:label label="Zip code:" id="zipCode" errorLables="<%=errorValues%>" /></label></td>
			<td valign="bottom">&nbsp;&nbsp;<oppt:text name="zipCode" styleId="zipCode" maxlength="25" size="25" styleClass="iform" value="<%=actionForm.getZipCode() %>" /></td>
		</tr>
		<tr>
			<td valign="bottom">&nbsp;&nbsp;<label for="city"><oppt:label label="City:" id="city" errorLables="<%=errorValues%>" /></label></td>
			<td valign="bottom">&nbsp;&nbsp;<oppt:text name="city" styleId="city" maxlength="25" size="25" styleClass="iform" value="<%=actionForm.getCity() %>" /></td>
		</tr>
<%
	}
%>
	</table>
	&nbsp;<br />
	<table role="presentation" width="600" align="left" border="0" cellspacing="0" >
		<tr>
			<td width="377"><div align="right"><oppt:button value="Fetch customer" name="multipleButtonManager.fetchCustomerList" alt="Fetch customer list" primary="true" id="fetchCustomerList" /></div></td>
			<td width="219"><div align="right"><span class="button-blue"><input type="submit" id="clearEnterpriseInformationInput" class="ibm-btn-arrow-sec" name="multipleButtonManager.clearAll" value="Clear enterprise information input" style="width:20em;" alt="Clear enterprise information input" /></span></div></td>
		</tr>
	</table>
	<br>
	&nbsp;<br />
	&nbsp;<br />
</html:form>
&nbsp;<br />
<%
	if(view.isChangeProposal()){
		PartnerInformationViewBean partnerInformationView = view.getPartnerInformation();
		if(null != partnerInformationView){
		
%>
<html:form action="/protect/GetPartnersMultipleAction.wss">
	<table border="0" width="600" cellspacing="1" cellpadding="1" role="presentation">
		<tr>
			<td colspan="2" align="left" style=background-color:#999999;  class="bar-blue-med-dark">&nbsp;&nbsp;Enterprise information</td>
		</tr>
		<tr>
			<th align="left" width="207" id="customerListNumber1" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;Customer  number</th>
			<th align="left" width="387" id="customerListName1" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;Customer  name</th>
		</tr>
<%
			List customers = partnerInformationView.getSelectedCustomers();
			if(null != customers){
				Iterator iterator = customers.iterator();
				while(iterator.hasNext()){
					CustomerListCustomDTO customer = (CustomerListCustomDTO)iterator.next();
					if(null != customer){
%>
		<tr>
			<td align="left" headers="customerListNumber">&nbsp;&nbsp;<oppt:label label="<%=customer.getCustomerNumber()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="left" headers="customerListName">&nbsp;&nbsp;<oppt:label label="<%=customer.getCustomerName()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
<%
					}
				}
			}
%>
	</table>
	&nbsp;<br />
	<table border="0" cellspacing="1" cellpadding="1" width="600" summary="Partners information">
		<tr>
			<th align="left" width="107" id="partnerType1" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;Partners</th>
			<th align="left" width="207" id="legacyNumber" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;Legacy no.</th>
			<th align="left" width="277" id="name1" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;Name</th>
		</tr>
<%
			CustomerInfoDataBean partner = partnerInformationView.getSoldToParty();
			if(null != partner){
%>
		<html:hidden property="legacyNumber" value="<%=partner.getLegacyCustomerNumber() %>" />
		<html:hidden property="sequenceNumber" value="<%=partner.getAddressSequenceNumber() %>" />
		<html:hidden property="countryCode" value="<%=partner.getCountryCode() %>" />
<%
			}
%>
		 <tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Sold to party:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getSoldToPartyNumber() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getSoldToPartyName() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Bill to party:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getBillToPartyNumber() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getBillToPartyName() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Payer:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getPayerNumber() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getPayerName() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Ship to party:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getShipToPartyNumber() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getShipToPartyName() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr> 
	</table>
	&nbsp;<br />
	<table border="0" cellspacing="1" cellpadding="1" width="600" summary="SAP Customer no Details">
		<tr>
			<th align="left" width="107" id="partnerType2" style=background-color:#cccccc;  class="bar-blue-med" height="15">&nbsp;&nbsp;Partners</th>
			<th align="left" width="207" id="sapCustomerNumber" style=background-color:#cccccc;  class="bar-blue-med" height="15">&nbsp;&nbsp;SAP Customer no.</th>
			<th align="left" width="277" id="name2" style=background-color:#cccccc;  class="bar-blue-med" height="15">&nbsp;&nbsp;Name</th>
		</tr>
		<tr>
			<td headers="partnerType" height="72">&nbsp;&nbsp; 9E Partner:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td headers="sapCustomerNumber" height="72">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getNineDPartnerNumber() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td headers="name" height="72">&nbsp;&nbsp;<oppt:label label="<%=partnerInformationView.getNineDPartnerName() %>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	<table width="600" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td align="left">&nbsp;&nbsp;Comments:</td>
		</tr>
		<tr>
			<td align="left">&nbsp;<oppt:label label="<%=view.getComments()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	<table width="600" align="left" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td width="377"><div align="right"><oppt:button value="Continue" name="multipleButtonManager.continue" alt="Continue" id="continue" primary="true" /></div></td>
			<td width="219"><div align="right"><oppt:button value="Cancel" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></div></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</html:form>





<%
		}
	}
	else{
		GetPartnersActionForm getPartnersActionForm = view.getGetPartnersActionForm();
%> <%-- //sateesh
          DAD02
<html:form action="/protect/GetPartnersMultipleAction.wss">
   &nbsp;<br />
	<table border="0" cellspacing="1" cellpadding="1" width="600" summary="Partners information">
		<tr>
			<th width="147" align="left" id="partnerType" class="bar-blue-med">&nbsp;&nbsp;Partners</th>
			<th width="117" align="left" id="legacyNumber" class="bar-blue-med">&nbsp;&nbsp;<label for="legacyNumber">Legacy no.</label></th>
			<th width="197" align="left" id="sequenceNumber" class="bar-blue-med">&nbsp;&nbsp;<label for="sequenceNumber">Seq. no.</label></th>
			<th width="127" align="left" id="name" class="bar-blue-med">&nbsp;&nbsp;<label for="systemCode">System code</label></th>
		</tr>
		<tr>
			<td  valign="bottom" headers="partnerType" height="20">&nbsp;&nbsp;Sold to party:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td  valign="bottom" headers="legacyNumber" height="20">&nbsp;&nbsp;<oppt:text name="legacyNumber" styleId="legacyNumber" size="12" maxlength="10" styleClass="iform" value="<%=getPartnersActionForm.getLegacyNumber() %>" /> <br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td  valign="bottom" headers="sequenceNumber" height="20">&nbsp;&nbsp;<oppt:text name="sequenceNumber" styleId="sequenceNumber" size="10" maxlength="15" styleClass="iform" value="<%=getPartnersActionForm.getSequenceNumber() %>" /> <br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td  valign="bottom" headers="name" height="20">&nbsp;&nbsp;<oppt:text name="countryCode" styleId="systemCode" size="10" maxlength="4" styleClass="iform" value="<%=getPartnersActionForm.getCountryCode() %>" /> <br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Bill to party:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="sequenceNumber">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Payer:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="sequenceNumber">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;Ship to party:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="legacyNumber">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="sequenceNumber">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	<table width="600" align="left" border="0" cellspacing="0" summary="layout">
		<tr>
			<td width="283"><div align="right"><oppt:button value="Get partner" name="multipleButtonManager.getPartners" alt="Get partner" primary="true" id="getPartner" /></div></td>
			<td width="157"><div align="right"><oppt:button	value="Clear partner input" name="multipleButtonManager.clearAll" alt="Clear partner input" primary="true" id="clearPartnerInput" /></div></td>
			<td width="160"><div align="right"><oppt:button value="Cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" id="cancel" /></div></td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><label for="comments">Comments:</label></td>
		</tr>
		<tr>
			<td colspan="3"><textarea rows="2" name="comments" id="comments" cols="44" class="iform"><%=view.getComments() %></textarea></td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
	</table>
</html:form> --%>
<%
	}
%>
<!-- start content head -->
		<div id="ibm-content-head">


		</div> 
    	<!-- stop content head -->


	<div id="ibm-content-main">
		<div style="position:absolute; top:0;right:10px;">
 <p class="ibm-ind-link"><a href="javascript:getFormHelp()" title="Page help"  class="ibm-popup-link" >Page Help</a></p>
		</div>	
	</div>

</div>


