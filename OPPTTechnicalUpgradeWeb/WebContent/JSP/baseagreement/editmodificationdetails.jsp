
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="htmlx"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants" %> 
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationActionForm" %>
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
	ModificationActionForm actionForm = (ModificationActionForm)view.getActionForm();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	String modificationType = (String)OPPTStaticDataHolder.modificationTypeMap.get(actionForm.getModificationTypeCode());
		
  %>
  
  <div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
   <table border = "0" width="600">
  <tr><td>
  <table border = "0" width="600">
   <% if(amendFlag) { %>                
                <tr valign="top"> 
                    <th> 
                      <h1> Base agreement maintenance</h1>
                    </th>
                  </tr>
                  <tr> 
                    <td> 
                      <p class="ibm-alternate"><em>Amend base agreement - Edit modification details</p>
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
                      <p class="ibm-alternate"><em>Edit modification details </p>
                    </td>
                  </tr>             
<% } %>                  
      
      
      
</table>
 </td></tr>
 <tr><td>
<table border = "0" width="600" height="33">
<tr> <td>
  	<oppt:displayErrorReport errorReport="<%=errorReport%>" />  </td></tr>
  	
  	 <tr>
                  <td>
                  Edit modification details, Press the Save button to save the edited modification details.
                  Press the cancel button to go back to display modification page.  
                  </td>
                  </tr>   
  <tr>
    <td align = "left"><p>Required fields are marked with an asterisk (<strong>*</strong>)
			and must be filled in to complete the form.</p></td>
      </tr>
</table>
</td></tr>
<tr><td height="38">
   <table border="0" class="ibm-data-table" width="600" cellpadding="1" cellspacing="1">
    <tr style=background-color:#cccccc;  class="bar-blue-med"> 
  	  <td style=background-color:#cccccc;  class="bar-blue-med" width="591" align="left" ><strong><%= modificationType%></strong> </td>	  
  	  
   </tr>
 </table>
</td></tr>
   <html:form action="/protect/EditBaseAgreementMultipleAction.wss" method="post">
	<input type="hidden" name="modificationTypeCode" value="<%=actionForm.getModificationTypeCode() %>" />
	<input type="hidden" name="agreementId" value="<%=actionForm.getAgreementId() %>" />
   <tr><td>
<table border = "0" width="600">
   <tr>
   <td height="20" width="10"><span class="ibm-required">*</span></td>  
    <td height="20" width="130"><label for="legalContact" ><oppt:label label="C&N/Legal&nbsp;contact:" id="legalContact" errorLables="<%=errorValues%>" /></label></td>
    <td height="20" width="370"><oppt:text name ="legalContact" value = "<%=view.getLegalContact()%>" maxlength="20" styleClass="iform" size = "20" styleId="legalContact" title="Enter legal contact"/></td>
  </tr>
  <tr> 
  <td height="20" width="10"><strong>&nbsp;</strong></td>  
    <td height="20" width="130"><label for="accountingContact">Accounting&nbsp;contact:</label></td>
    <td height="20" width="370"><oppt:text name ="accountingContact" value = "<%=view.getAccountingContact()%>" maxlength="20" styleClass="iform" size = "20" styleId="accountingContact" title="Enter accounting contact"/></td>
  </tr>
  <tr> 
  <td width="10" height="20"><strong>&nbsp;</strong></td>  
    <td width="130" height="20"><label for="modifiedIBMLetterHead">Customer&nbsp;Letterhead:</label></td>
    <%
   if((""+UtilityConstants.TRUE).equals(actionForm.getModifiedIBMLetterHead()) ||
       UtilityConstants.YES.equals(actionForm.getModifiedIBMLetterHead())) { %>
	    <td width="370" height="20"><oppt:checkbox name="modifiedIBMLetterHead"  checked="true" style="iform" styleId="modifiedIBMLetterHead" title="Check modified IBM letter head" /></td>
	<% }else { %>
	    <td width="370" height="20"><oppt:checkbox name="modifiedIBMLetterHead"  checked="false" style="iform" styleId="modifiedIBMLetterHead" title="Check modified IBM letter head"/></td>
	<% }%>
    
  </tr>
  <tr> 
  <td width="10" height="20"><strong>&nbsp;</strong></td>  
    <td width="130" height="20"><label for="revenueRecognition">Revenue&nbsp;recognition:</label></td>
    <% if((""+UtilityConstants.TRUE).equals(actionForm.getRevenueRecognition()) ||
			UtilityConstants.YES.equals(actionForm.getRevenueRecognition())) { %>
    <td width="370" height="20"><oppt:checkbox name="revenueRecognition" checked="true" style="iform" styleId="revenueRecognition" title="Check revenue recognition"/></td>
   <% }else { %>
    <td width="370" height="20"><oppt:checkbox name="revenueRecognition" checked="false" style="iform" styleId="revenueRecognition" title="Check revenue recognition"/></td>
   <% }%>
  </tr>
  <%  if(BaseAgreementModificationConstants.ROL.equals(actionForm.getModificationTypeCode())) {
   //  String rolOptions = null;
    // if(null != view.getRolOptions() && null != view.getSelectedRolOption()){
    // 	rolOptions = (String)view.getRolOptions().get(view.getSelectedRolOption());  
     //}
  %>
  <tr> 
  <td width="10" height="20"><span class="ibm-required">*</span></td>  
    <td width="130" height="20"><label for="rolStartDate" ><label for="rolStartDate"><oppt:label label="ROL&nbsp;start&nbsp;date:" id="rolStartDate" errorLables="<%=errorValues%>" /></label></td>
    <td width="370" height="20"><input type="text" name="rolStartDate" id="rolStartDate" value="<%=actionForm.getRolStartDate() %>" readonly="true" />&nbsp;<label for="rolStartDate"><a href="javascript:openCalendar('document.ModificationActionForm.rolStartDate',null,null,true,500,250)"><img src="//w3.ibm.com/ui/v8/images/icon-select-date.gif" width="13" height="14" alt="select date icon" /> </a></label> </td>
    <td height="20"></td>
  </tr>
  <tr> 

  <tr> 
  <td width="10" height="20"><strong>&nbsp;</strong></td>  
    <td width="130" height="20"><label for="rolEndDate">ROL&nbsp;end&nbsp;date:</label></td>
    <td width="370" height="20"><input type="text" name="rolEndDate" id="rolEndDate" value="<%=actionForm.getRolEndDate()== null ? "" :actionForm.getRolEndDate() %>" readonly="true" title="Enter ROL start date"/>&nbsp;<label for="rolEndDate"><a href="javascript:openCalendar('document.ModificationActionForm.rolEndDate',null,null,true,500,250)"><img src="//w3.ibm.com/ui/v8/images/icon-select-date.gif" width="13" height="14" alt="select date icon" /></a></label></td>
    <td height="20"></td>
  </tr>
  <tr> 
     <td height="20" width="10"><strong>&nbsp;</strong></td>  
    <td height="20" width="130"><label for="rolOptions"><oppt:label label="ROL&nbsp;transfer&nbsp;event:" id="rolOptions" errorLables="<%=errorValues%>" /></label></td>
    <td height="20" width="370"><oppt:select name="rolOptions" id="rolOptions" options="<%= view.getRolOptions() %>" selectedOption="<%=actionForm.getRolOptions()%>" onchange="" title="select Rol transfer event"/> </td>
  </tr>
  
  <% } %>
  
  <tr>
        <td height="20" width="10"><span class="ibm-required">*</span></td>  
		<td height="20" width="130"><label for="details" ><oppt:label label="Details:" id="details" errorLables="<%=errorValues%>" /></label></td>
		<td height="20" width="370"><html:textarea property="details" styleId="details" value="<%= actionForm.getDetails()%>" cols="60" rows="3" title="Enter details"> </html:textarea></td>
	</tr>
  </table>
 </td></tr>
 
<tr><td height="20">
    <table border = "0" width ="600">
    <tr >
    <td align = "right" colspan="4" width ="600" >
                <oppt:button id="save" name="multipleButtonManager.save" alt="Save" primary="true" value="Save" /><oppt:button
			id="cancel" name="multipleButtonManager.cancel" alt="Cancel"
			primary="true" value="Cancel" /></td></tr>
 
 </table>
</td></tr>
              
 </html:form>
 </table>  
 <script language="JavaScript" type="text/javascript">
 
 

	window.onload = function() {
		var hiddenElements = document.getElementsByName("validationErrorElements");
		//read the identifier of the error fields, from the hiddenElements 
		//and set the aria-invalid attribute for those ids
		var hiddenElement = null;
		for(var x=0; x<hiddenElements.length; x++){
			console.log("before "+hiddenElements[x].value);
			console.log("before "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
			hiddenElement = document.getElementById(hiddenElements[x].value)
			if (hiddenElement){hiddenElement.setAttribute("aria-invalid","true")};
			console.log("after "+document.getElementById(hiddenElements[x].value).getAttribute('aria-invalid'));
		}
	}


 
function openCalendar(strDateObj, strValidStart, strValidEnd, boolAllowPast,x,y)
{
  var strURL = "/isc/customerfulfillment/bhoppt/JSP/common/calendar.jsp?sourceObj=" + escape(strDateObj) + 
               "&amp;validStart=" + escape(strValidStart) + 
               "&amp;validEnd=" + escape(strValidEnd) +
               "&amp;allowPast=" + escape(boolAllowPast);
  wCal = window.open(strURL,"cal","height=245,width=450,resizable");
  wCal.moveTo(x,y);
  wCal.opener = self;
}
</script>
<noscript>To use this function please enable java script in your browser</noscript>