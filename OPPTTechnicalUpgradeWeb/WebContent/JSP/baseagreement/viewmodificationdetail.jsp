
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="htmlx"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants"%>
 <%
	OPPTSession opptSession = new OPPTSession(session);
	boolean amendFlag = false;
	if(null != opptSession.getObjectFromSession(SessionConstants.SESSION_AMEND_FLAG) 
	   &&((Boolean)opptSession.getObjectFromSession(SessionConstants.SESSION_AMEND_FLAG)).booleanValue()) {
	    amendFlag = true;
		opptSession.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,null);
	}

	DisplayModificationDetailViewBean view = (DisplayModificationDetailViewBean) opptSession.getCurrentViewBean();

	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
    String modificationType = (String)OPPTStaticDataHolder.modificationTypeMap.get(view.getModificationTypeCode());
  %>

  <div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
<table border = "0" width="600">
<tr><td>
  <table border = "0" width="600" >
   <% if(amendFlag) { %>                
                <tr valign="top"> 
                    <th> 
                      <h1> Base agreement maintenance</h1>
                    </th>
                  </tr>
                  <tr> 
                    <td> 
                      <p class="ibm-alternate"><em>Amend base agreement - View modification details</p>
                    </td>
                  </tr>
<% } else  { %>     
                <tr valign="top"> 
                    <th> 
                      <h1>Base agreement registration</h1>
                    </th>
                  </tr>
                  <tr> 
                    <td> 
                      <p class="ibm-alternate"><em>View modification details</p>
                    </td>
                  </tr>             
<% } %>        
                       <tr>
					<td>
					   <p> Press Continue button to go back to display modification page.
  					   </p> 
  					 </td>
				</tr>


</table>
</td></tr>
  <html:form action="/protect/CancelAction.wss">
 
 <tr><td height="20">&nbsp</td></tr>
 
 <tr><td height="20">
    <table border = "0" width="600">
    <tr> 
  	  <td  style=background-color:#cccccc;  class="bar-blue-med" width="591" align="left"><strong><%= modificationType%></strong> </td>	  
   </tr>
 </table>
 </td></tr>
  
 <tr><td>
  <table border = "0" width="500">
	   
	   
	  <tr> 
	    <td height="18" width="130"><label for="legalContact">C&N/Legal&nbsp;contact:</label></td>
	    <td height="18" width="130"><oppt:label label="<%=view.getLegalContact()%>"/></td>
	  </tr>
	  <tr> 
	    <td height="18" width="130"><label for="accountingContact">Accounting&nbsp;contact:</label></td>
	    <td height="18" width="130"><oppt:label label="<%=view.getAccountingContact()%>"/></td>
	  </tr>
	  <tr> 
	    <td height="18" width="130"><label for="modifiedIBMLetterHead">Customer&nbsp;Letterhead:</label></td>
	    <% if(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants.YES.equals(view.getModifiedIBMLetterHead())) { %>
	    	<td height="18" width="130"><oppt:label label="Checked"/></td>
	    <% } else { %>
	    	<td height="18" width="130"><oppt:label label="Unchecked"/></td>
	    <% }  %>
	  </tr>
	  
	  <tr> 
	    <td height="18" width="130"><label for="revenueRecognition">Revenue&nbsp;recognition</label></td>
	    <% if(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants.YES.equals(view.getRevenueRecognition())) { %>
	    	<td height="18" width="130"><oppt:label label="Checked"/></td>
	    <% } else { %>
	    	<td height="18" width="130"><oppt:label label="Unchecked"/></td>
	    <% }  %>
	  </tr>
	     <% if(view.getModificationTypeCode().equals(BaseAgreementModificationConstants.ROL)) {
	     	TreeMap rolOptions = new TreeMap();
		    rolOptions = view.getRolOptions();
	     	String roloption  = (String)rolOptions.get(view.getSelectedRolOption());
        %>
	  <tr> 
	    <td height="18" width="130"><label for="rolStartDate">ROL&nbsp;start&nbsp;date:</label></td>
	    <td height="18" width="130"><oppt:date date="<%=view.getRolStartDateView()%>" /></td>
	  </tr>
	  <tr> 
	    <td height="18" width="130"><label for="rolEndDate">ROL&nbsp;end&nbsp;date:</label></td>
	    <td height="18" width="130"><oppt:date date="<%=view.getRolEndDateView()%>" /></td>
	  </tr>  
	  <tr> 
	    <td height="18" width="130"><label for="rolOptions">ROL&nbsp;transfer&nbsp;event :</label></td>
	    <td height="18" width="130"><oppt:label label="<%= roloption%>"/> </td>
	  </tr>
	  <%} %>
	  
	  <tr>
	   		<td height="18" width="130"><label for="details">Details:</label></td>
			<td height="18" width="130"><oppt:label label="<%=view.getDetails()%>"/> </td>
		</tr>
		</table>
		</td></tr>
		<tr><td height="20">
    <table border = "0" width ="600">
    <tr >
    <td align = "right" colspan="4" width ="600" >
		 <oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Continue" primary="true" value="Continue" />
		</td></tr>
 </table>
 </td></tr>
 </html:form>
 </table>

