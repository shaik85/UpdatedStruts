<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationOptionsViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationOptionActionForm"%>
<%

    HashSet errorValues = null;
	OPPTSession opptSession = new OPPTSession(session);
	ModificationOptionsViewBean view = (ModificationOptionsViewBean) opptSession.getCurrentViewBean();
	ModificationOptionActionForm actionForm = (ModificationOptionActionForm)view.getActionForm();
	if(null == view){
		return;
	}
	if(actionForm == null) {
		actionForm = new ModificationOptionActionForm();
	}
	ErrorReport errorReport = view.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	HashSet errorLabels = errorReport.getErrorFieldNames();
	
	%>
	
	<div id="edit-layout" align="right"><a href="javascript:getFormHelp()">
  <img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>

<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Modification maintenance">
	<tr valign="top">
		<td width="600">
		<table width="600" role="presentation">
			<tr>
				<h1>Modification maintenance</h1>
			</tr>
			<tr>
				<td><p class="ibm-alternate"><em>Add modification options</p>
				</td>
			</tr>
			<tr>
			 <td><oppt:displayErrorReport errorReport="<%=errorReport%>" />
              </td>
              </tr>
                                       
              <tr>
              <td>
              <p>Required fields are marked with an asterisk (<strong>*</strong>) 
                        and must be filled in to complete the form.</p>
               </td>
               </tr>
               
               </table>

   
               <html:form action="/protect/AddModificationOptionMultipleAction.wss" method="post"> 
                             
               	<table border="0" width="600">
				<tr>
					<td>
					</td>
				</tr>
				<tr>
				<th height="25" colspan="6" style=background-color:#cccccc;  class="bar-blue-med">Modification options</th>
				</tr>
				
				<tr>
				     <td height="25" width="40"></td> 
                     <td height="25" width="200"><label for="typeCode"><oppt:label label="Modification type code:" id="typeCode" errorLables="<%=errorValues%>" /></label></td>
                     <td height="25" width="360"><label for="typeCode"><oppt:label label="<%=view.getTypeCode() %>" id="typeCode" errorLables="<%=errorValues%>" /></label></td>
                             
		        </tr>
		        <tr>
				     <td height="25" width="40"><strong class="black">*</strong></td> 
                     <td height="25" width="200"><label for="modificationOption"><oppt:label label="Modification option:" id="modificationOption" errorLables="<%=errorValues%>" /></label></td>
                     <td height="25" width="360"><oppt:text name="modificationOption" value="<%=actionForm.getModificationOption() %>" maxlength="3" styleId="modificationOption" styleClass="iform" size="20" /></td>
                             
		        </tr>
		        
			<tr>
				     <td height="25" width="40"><strong class="black">*</strong></td> 
                     <td height="25" width="180"><label for="modificationDescription"><oppt:label label="Modification option description:" id="modificationDescription" errorLables="<%=errorValues%>" /></label></td>
                     <td height="25" width="180"><oppt:text name="modificationDescription" value="<%=actionForm.getModificationDescription()%>" maxlength="30" styleId="modificationDescription" styleClass="iform" size="20" /></td>
                             
		        </tr>
				
				<tr>
					<td width="600" align="right" colspan="3">	
						<oppt:button id="saveaddmodificationoption"
							name="multipleButtonManager.saveaddmodificationoption" alt="Save modification option"
							primary="true" value="Save modification option" />
						<oppt:button id="cancel" 
							name="multipleButtonManager.cancel" alt="cancel"
							primary="true" value="Cancel" />
											
					</td>
				</tr>
			</table>
		</html:form>
		