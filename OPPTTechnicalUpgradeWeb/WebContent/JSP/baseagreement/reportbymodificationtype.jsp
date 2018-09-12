<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.*" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SalesOrgActionForm" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ReportByModificationTypeActionForm" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementModificationReportViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants" %>
<%@page import = "com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO" %>
<%
  
  OPPTSession opptSession = new OPPTSession(session);
  BaseAgreementModificationReportViewBean view = (BaseAgreementModificationReportViewBean)opptSession.getCurrentViewBean();
  String checkValue=""; 
  if (view.getActionForm() instanceof SalesOrgActionForm) {
       checkValue="Select one";
  }
  ReportByModificationTypeActionForm actionForm = null;
  String salesOrg = null;
  String status = null;
  String[]  typeCodes = null;
  String modTypeCode = null;
  String allModifications = "N";
  if(null != view.getDefaultSalesOrg() && view.getErrorReport().size() == 0){
      salesOrg = view.getDefaultSalesOrg();
  }
  else{
      salesOrg = view.getSelectedSalesOrg();
      status = view.getSelectedStatus();
  }

  if(null != view.getActionForm() && view.getActionForm() instanceof ReportByModificationTypeActionForm){
          actionForm =(ReportByModificationTypeActionForm)view.getActionForm();
          salesOrg = actionForm.getSalesOrg();
     	  status = actionForm.getStatus();
     	  modTypeCode = actionForm.getModTypeCode();
          typeCodes = actionForm.getTypeCode();
          allModifications = actionForm.getAllModifications();
      }
 
        if(checkValue.equals("Select one")) {
           view.setModTypes(new TreeMap());
           salesOrg  ="Select one";
        }

      ErrorReport errorReport = view.getErrorReport();
      HashSet errorValues = errorReport.getErrorFieldNames();
      ArrayList buttonFlags = view.getButtonFlags();
     if(null == typeCodes){
          typeCodes  = new String[0]; 
     }
     if(null == status){
       status = view.getSelectedStatus();
     }
     
 %>
<div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>

<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Reports">
	<tr valign="top">
		<td width="450">
			<table width="450" role="presentation">
				<tr valign="top">
					<h1>Reports</h1>
				</tr>
				<tr>
				    <td> 
                      <p class="ibm-alternate"><em>Report for registered Modifications </p>
				</td>
			</tr>
			<tr>
			 <td><oppt:displayErrorReport errorReport="<%=errorReport%>" />
              </td>
              </tr>
				<tr>
					<td height="30"> 
                      <p>Select the sales org and base agreement status. Modification types can be
                      	selected from the list or can be entered manually separated by a comma. 
                        Press the Generate report button to generate the report. Press Cancel button 
                        to go back to Reports page.<br>
                      </p>
	
                    	<p>Required fields are marked with an asterisk (<strong>*</strong>) 
                        and must be filled in to complete the form.</p>
                        </td>
                        </tr>
                        </table>
                      </td>
                        </tr>
                        </table>   
                        
                         <table summary="BaseAgreementReportModification" width="600">
                        <html:form method="post" action="/protect/BaseAgreementReportModificationMultipleAction.wss">
                       
                        <tr>
                          <td width="21" align="right"><span class="ibm-required">*</span></td>
                            <td width="70" height="30"><label for="salesOrganization" > <oppt:label label="Sales&nbsp;organisation:" id="salesOrganization" errorLables="<%=errorValues%>" /></label></td>
                              <td width="493" height="30"> 										
                              <oppt:select  selectedOption="<%=salesOrg%>" name="salesOrganization" onclick="selectedSalesOrg()" id="salesOrganization"  options="<%=view.getSalesOrgDetails()%>" title="select Sales Organisation" />&nbsp;&nbsp;<span class="button-blue"><input type="submit" value="Go" /></span></td>
                       
                            <td height="11" width="10">&nbsp;</td>
                         
                          </tr>
                          </html:form>
                          <html:form method="post" action="/protect/BAReportByModTypesMultipleAction.wss">
                           <input type="hidden" name="salesOrg" value="<%=salesOrg%>"/>
                          <tr> 
                             <td width="21" align="right"><span class="ibm-required">*</span></td>
                            <td width="70" height="30"><label for="status" ><oppt:label label="Status:" id="status" errorLables="<%=errorValues%>" /></label></td>
                            <td width="493" height="30"> 
                            <oppt:select  selectedOption="<%=status%>" name="status" id="status"  options="<%=view.getStatus()%>" title="select status" /></td>
                     
                          </tr>
                         <tr>
                          <td width="21" align="right"><span class="ibm-required">*</span></td>
                          <td width="70" height="30"><label for="typeCode" ><oppt:label label="Modification&nbsptypes:" id="typeCode" errorLables="<%=errorValues%>" /></label></td>
                          <td width="493" height="30"> 
                         <select name="typeCode" class="iform" id="typeCode" title="Select modification types" size="7" multiple onchange="chechBoxValue()">
                         
                          <% 
                            TreeMap optionsMap = new TreeMap();
                            String key = null;
                            String value = null;
                            String option = null;
                             for(Iterator i = view.getModTypes().keySet().iterator();i.hasNext();){
                                key =(String)i.next();
                                ModificationTypeCustomDTO dto = (ModificationTypeCustomDTO)view.getModTypes().get(key);
								 value = dto.getDescription();
								  option = key+"-"+value;
								   
								    if( view.getSelectedFormNumbers(typeCodes,key)) { 
								       
				       %>                  <option  value="<%=key%>" selected="selected"><%=option%></option>  
                       <%                }else{
			                              
                       %>                  <option value="<%=key%>"><%=option%></option>
                        <%               }  
                                   }%>
                      
                  
                        </select>
                         </td>
                         </tr>
                                <tr> 
                           <td></td>
                           <td></td>
                            
                            <%
                           if((""+UtilityConstants.YES).equals(allModifications)){
                         
                           %>
                              <td width="480" height="30" align="left" valign="bottom">
                              <input type="checkbox" name="allModifications" checked value="Y" id="allModifications" onclick="selectAllModification()" title="Select all modification types" /><p style="font-size:0.75em;">(Select all modification types)</p></td>
                               <%}else{%>
                               <td width="480" height="30" align="left" valign="bottom">
                               <input type="checkbox" name="allModifications" value="N" id="allModifications"  onclick="selectAllModification()" title="Select all modification types"/><p style="font-size:0.75em;">(Select all modification types)</p></td>
                               <%} %>
                          </tr>
                          <tr> 
                           <td></td>
                           <td></td>
                            <td width="480" height="30" align="left" valign="bottom">
                              <oppt:text name="modTypeCode" value="<%=modTypeCode%>" maxlength="155" styleId="modTypeCode" styleClass="iform" size="20" title="Enter modification types"/><p style="font-size:0.75em;">(Enter the modification types manually)</p></td>
                              
                          </tr>
                          <tr> 
                            <td colspan="3">&nbsp; </td>
                          </tr>
                     
							
                         
                          <tr> 
                          <table width="600" role="presentation" align="right">
                            <td valign="top" width="386"><div align="right"><span class="button-blue"> 
                             <oppt:button id="report" name="multipleButtonManager.report" alt="Generate report" value="Generate report" primary="true" />
                              </span>
                             </div>
                            </td>
                            <td valign="top" width="202"><span class="button-blue"> 
                             <oppt:button id="bareportcancel" name="multipleButtonManager.bareportcancel" alt="Cancel" value="Cancel" primary="true" />
                           </span></td>
                        </table>
                        </tr>
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





document.onkeyup = KeyCheck; 

  function KeyCheck()
{
   var KeyID = event.keyCode;
   switch(KeyID)
   {
      case 32:
	selectAllModification();
    break;
	 case 38:
     selectedSalesOrg();
	
      break;    
      case 40:        
     
	 selectedSalesOrg();     
	   
      break;  
 }
}
function selectedSalesOrg(){
	var salesOranisation = document.SalesOrgActionForm.salesOrganization.value;
    document.ReportByModificationTypeActionForm.salesOrg.value=salesOranisation;
}

function selectAllModification() {
  var formList = document.ReportByModificationTypeActionForm.typeCode;
  for(var i = 0;i < formList.length;i++){
    if (document.ReportByModificationTypeActionForm.allModifications.checked == true){
	formList.options[i].selected = true;
	}else{
	formList.options[i].selected = false;
	}
  }
  if (document.ReportByModificationTypeActionForm.allModifications.checked == true){
     document.ReportByModificationTypeActionForm.allModifications.value="Y";
  }else{
     document.ReportByModificationTypeActionForm.allModifications.value="N";
     }
}

function chechBoxValue() {
  var formList = document.ReportByModificationTypeActionForm.typeCode;
  var flag = false;
  for(var i = 0;i < formList.length;i++){
    if(formList.options[i].selected != true){
        flag = true;
         break;
      }
   }
   if(flag){
         document.ReportByModificationTypeActionForm.allModifications.checked = false;
   } else {
        document.ReportByModificationTypeActionForm.allModifications.checked = true;
   }
}

</script>
