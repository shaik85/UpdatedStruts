<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="htmlx"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationActionForm" %>
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
	//Start changes Nayanatara L Pai
	ModificationActionForm actionForm = (ModificationActionForm)view.getActionForm();
	String accountingContact = actionForm.getAccountingContact();
	String legalContact = actionForm.getLegalContact();
	//End changes Nayanatara L Pai
	
	if(null == view){
		return;
	}
	if(actionForm == null) {
		actionForm = new ModificationActionForm();
	}
	ErrorReport errorReport = view.getErrorReport();
		if(errorReport != null && errorReport.size() > 0 ) {
		// Page has vaildation errors use the original action form 
		}else {
			actionForm = new ModificationActionForm();
			actionForm.reset();
		}
	//Start changes Nayanatara L Pai
	actionForm.setAccountingContact(accountingContact);
	actionForm.setLegalContact(legalContact);
	//End changes Nayanatara L Pai
	actionForm.setModificationTypeCode(view.getModificationTypeCode());
	HashSet errorValues = errorReport.getErrorFieldNames();
	String modificationType = null;
	if(null != view.getModificationTypeCode()) {
		modificationType = (String)OPPTStaticDataHolder.modificationTypeMap.get(view.getModificationTypeCode());
		opptSession.storeObjectToSession(com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants.SESSION_MODIFICATION_TYPECODE,view.getModificationTypeCode());
	}else {
		String modificationTypeCode = (String)opptSession.getObjectFromSession(com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants.SESSION_MODIFICATION_TYPECODE);
		actionForm.setModificationTypeCode(modificationTypeCode);
		modificationType = (String)OPPTStaticDataHolder.modificationTypeMap.get(modificationTypeCode);
	}
	if(view.getRolOptions() == null) {
		TreeMap rolOptionsMap = new TreeMap();
        rolOptionsMap.putAll(OPPTStaticDataHolder.rolOptionsMap);
        view.setRolOptions(rolOptionsMap);
	}
	
  %>
  
  <div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
  
  
<table border="0" width="600">

<tr><td>

<table border="0" width="600">
      <% if(amendFlag) { %>                
                <tr valign="top"> 
                    <th> 
                      <h1> Base agreement maintenance</h1>
                    </th>
                  </tr>
                  <tr> 
                    <td> 
                      <p class="ibm-alternate"><em>Amend base agreement - Display modification details</p>
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
                      <p class="ibm-alternate"><em>Display modification details</p>
                    </td>
                  </tr>             
<% } %>        

                
  
 </table>
 </td></tr>

<tr><td height="37">

		<table border="0" width="600" height="25">
		<tr> <td>
  	<oppt:displayErrorReport errorReport="<%=errorReport%>" />  </td></tr>
  
                  <tr>
                  <td>
                  Display modification details,Press the Add button to add  modification details.
                  Press the Cancel button to go back to the display modification page.  
                  </td>
                  </tr>   
  
			<tr>
				<td align="left">
				<p>Required fields are marked with an asterisk (<strong>*</strong>) and must
				be filled in to complete the form.</p>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td></tr>
<tr><td height="63">
   <table border = "0" width="600">
    <tr> 
  	  <td  style=background-color:#cccccc;  class="bar-blue-med" width="591" align="left" ><strong><%= modificationType%></strong> </td>	  
   </tr>
 </table>
 </td></tr>
  
 <tr><td>
 
  <html:form action="/protect/AddBaseAgreementMultipleAction.wss" method="post">
  <input type="hidden" name="modificationTypeCode" value="<%=actionForm.getModificationTypeCode()%>" />
  <table border="0" width="600">
   <tr>
   <td height="20" width="10"><strong>*</strong></td>  
    <td height="20" width="130"><label for="legalContact"><oppt:label label="C&N/Legal&nbsp;contact:" id="legalContact" errorLables="<%=errorValues%>" /></label></td>
    <td height="20" width="370"><oppt:text name ="legalContact" value = "<%=actionForm.getLegalContact()%>" maxlength="20" styleClass="iform" size = "20" styleId="legalContact" title="Enter legal contact"/></td>
  </tr>
  
  <tr>
  <td height="20" width="10"><strong>&nbsp;</strong></td>   
    <td height="20" width="130"><label for="accountingContact">Accounting&nbsp;contact:</label></td>
    <td height="20" width="370"><oppt:text name ="accountingContact" value = "<%=actionForm.getAccountingContact()%>" maxlength="20" styleClass="iform" size = "20" styleId="accountingContact" title="Enter accounting contact"/></td>
  </tr>
  <!-- 
  <tr> 
  <td height="20" width="10"><strong>&nbsp;</strong></td>  
    <td height="20" width="130"><label for="modifiedIBMLetterHead">Modified&nbsp;IBM&nbsp;letterhead:</label></td>
    <td height="20" width="370"><oppt:checkbox name="modifiedIBMLetterHead"  checked="<%=UtilityConstants.YES.equals(view.getModifiedIBMLetterHead())? true :false %>" style="iform" styleId="modifiedIBMLetterHead" /></td>
  </tr>
  <tr> 
  <td height="20" width="10"><strong>&nbsp;</strong></td>  
    <td height="20" width="130"><label for="revenueRecognition">Revenue&nbsp;recognition</label></td>
    <td height="20" width="370"><oppt:checkbox name="revenueRecognition" checked="<%=UtilityConstants.YES.equals(view.getRevenueRecognition())? true :false %>" style="iform" styleId="revenueRecognition"/></td>
  </tr>
  -->
  <tr> 
  <td width="10" height="20"><strong>&nbsp;</strong></td>  
    <td width="130" height="20"><label for="modifiedIBMLetterHead">Customer&nbsp;Letterhead:</label></td>
    <%
   if((""+UtilityConstants.TRUE).equals(actionForm.getModifiedIBMLetterHead())) { %>
	    <td width="370" height="20"><oppt:checkbox name="modifiedIBMLetterHead"  checked="true" style="iform" styleId="modifiedIBMLetterHead" title="Check modifiedIBM letter head"/></td>
	<% }else { %>
	    <td width="370" height="20"><oppt:checkbox name="modifiedIBMLetterHead"  checked="false" style="iform" styleId="modifiedIBMLetterHead" title="Check modifiedIBM letter head" /></td>
	<% }%>
    
  </tr>
  <tr> 
  <td width="10" height="20"><strong>&nbsp;</strong></td>  
    <td width="130" height="20"><label for="revenueRecognition">Revenue&nbsp;recognition:</label></td>
    <% if((""+UtilityConstants.TRUE).equals(actionForm.getRevenueRecognition())) { %>
    <td width="370" height="20"><oppt:checkbox name="revenueRecognition" checked="true" style="iform" styleId="revenueRecognition" title="Check revenue recognition"/></td>
   <% }else { %>
    <td width="370" height="20"><oppt:checkbox name="revenueRecognition" checked="false" style="iform" styleId="revenueRecognition" title="Check revenue recognition"/></td>
   <% }%>
  </tr>
  <% if(BaseAgreementModificationConstants.ROL.equals(actionForm.getModificationTypeCode())) { %>
 <tr>
 <td height="20" width="10"><strong>*</strong></td>  
 <td height="20" width="130"><label for="rolStartDate"><oppt:label label="ROL&nbsp;start&nbsp;date:" id="rolStartDate" errorLables="<%=errorValues%>" /></label></td>
 <td><input type="text" name="rolStartDate" id="rolStartDate" value="<%=actionForm.getRolStartDate() %>" readonly="true" title="Enter ROL start date"/> <label for="rolStartDate"><a href="javascript:openCalendar('document.ModificationActionForm.rolStartDate',null,null,true,500,250)"><img src="//w3.ibm.com/ui/v8/images/icon-select-date.gif" width="13" height="14" alt="select date icon" /> </a></label></td>
 <td></td>
 </tr>
 <tr>
 <td height="20" width="10"><strong>&nbsp;</strong></td>  
 <td height="20" width="130"><label for="rolEndDate">ROL&nbsp;end&nbsp;date:</label></td>
  <td><input type="text" name="rolEndDate" id="rolEndDate" value="<%=actionForm.getRolEndDate()%>" readonly="true" title="Enter ROL end date" /> <label for="rolEndDate"><a href="javascript:openCalendar('document.ModificationActionForm.rolEndDate',null,null,true,500,250)"><img src="//w3.ibm.com/ui/v8/images/icon-select-date.gif" width="13" height="14" alt="select date icon" /> </a></label>
 </td>
 <td></td>
 
 </tr>
 
  <tr> 
   <td height="20" width="10"><strong>*</strong></td>  
    <td height="20" width="130"><label for="rolOptions"><oppt:label label="ROL&nbsp;transfer&nbsp;event:" id="rolOptions" errorLables="<%=errorValues%>" /></label></td>
    <td height="20" width="370"><oppt:select name="rolOptions" id="rolOptions" options="<%=view.getRolOptions()%>" selectedOption="<%=actionForm.getRolOptions()%>" title="select Rol transfer event"/> </td>
  </tr>
  
  <% } %>
  
  <tr>
  <td height="20" width="10"><strong>*</strong></td>  
		<td height="20" width="130"><label for="details"><oppt:label label="Details:" id="details" errorLables="<%=errorValues%>" /></label></td>
		<td height="20" width="370"><html:textarea property="details" styleId="details" value="<%=actionForm.getDetails()%>" cols="60" rows="3" title="Enter details"> </html:textarea></td>
	</tr>
  </table>
 </td></tr>
<tr><td height="20">
    <table border="0" width ="600">
    <tr ><td align = "right" colspan="4" width ="600" >
            
              <oppt:button id="add" name="multipleButtonManager.add" alt="Add" primary="true" value="Add" />
        
              <oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" primary="true" value="Cancel" />
            </td></tr>
 </table>
 </td></tr>
 </html:form>
 </table>  
 <script language="JavaScript" type="text/javascript">
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