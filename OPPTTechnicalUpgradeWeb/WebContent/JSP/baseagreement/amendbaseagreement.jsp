
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementDetailViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementActionForm" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	BaseAgreementDetailViewBean view = (BaseAgreementDetailViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	BaseAgreementActionForm actionForm = view.getBaseAgreementActionForm();
	String selectedSalesOrg = "select one";
	if(null != actionForm.getSalesOrg() && !"Select one".equals(actionForm.getSalesOrg())) {
		if(actionForm.getSalesOrg().indexOf('-') > 0) {
			selectedSalesOrg = actionForm.getSalesOrg();
		}else {
			selectedSalesOrg = com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder.getSalesOrgDesc(actionForm.getSalesOrg())+"-"+actionForm.getSalesOrg();
		}
	}
	
	
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = view.getButtonFlags();

   
    TreeMap treeMap = new TreeMap();
    
    

	

%>
<div id="edit-layout" align="right">
   <a href="javascript:getFormHelp()"><img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>
 <table summary="Base agreement maintenance" cellpadding="0" cellspacing="0" border="0" width="750">
            <tr valign="top"> 
              <td width="750"> 
                <table role="presentation" width="750">
                  <tr valign="top"> 
                    <th> 
                      <h1>Base agreement maintenance</h1>
                    </th>
                  </tr>
                  <tr> 
                    <td> 
                      <p class="ibm-alternate"><em>Amend base agreement </p>
                    </td>
                  </tr>
                  <tr> <td>
  					  <oppt:displayErrorReport errorReport="<%=errorReport%>" />  
						<p>Amend a base agreement, by entering the details as required and complete the base 
  					     agreement form.Then press the Register button to register base agreement. Press the Add 
  					     modification button to inculde modification details to the base agreement. Press the Clear all
  					     button to discard your input. Press Cancel button to go back to base agreement maintenance page.
  					  </p>  					  
 					 </td> </tr>
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
<html:form action="/protect/CreateBaseAgreementMultipleAction"  method="post">
	<input type="hidden" name="agreementId" value="<%=actionForm.getAgreementId()%>" />
	<!--changed by tapan malhotra  -->
	<input type="hidden" name="orginalList" value="<%=view.getFormNumbersString()%>"/>
<table width="750">
  <tr> 
    <th width="750" style=background-color:#cccccc;  class="bar-blue-med"><strong>Customer details</strong></th>
  </tr>
  <tr> 
    <td width="750"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="12">*</td>
          <td width="170" height="25"><label for="customerNumber"><oppt:label label="SAP&nbsp;customer&nbsp;number:" id="customerNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="175"> <oppt:text name="customerNumber" styleClass="iform" styleId="customerNumber" value="<%=actionForm.getCustomerNumber() %>" maxlength="10" title="Enter customer number"/> 
          </td>
          <td width="12">&nbsp;</td>
          <td width="175"><label for="enterpriseNumber"><oppt:label label="Enterprise&nbsp;number:" id="enterpriseNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="162">
            <oppt:text name="enterpriseNumber" styleClass="iform" styleId="enterpriseNumber" value="<%=actionForm.getEnterpriseNumber() %>" maxlength="10" title="Enter enterprise number"/></td>
        <!--  </tr>
          <tr> 
          <td width="12">*</td>
          <td width="170" height="25"><label for="legacyCustomerNumber"><oppt:label label="Legacy&nbsp;customer&nbsp;number:" id="legacyCustomerNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="175" height="20"><oppt:text name="legacyCustomerNumber" styleClass="iform" styleId="legacyCustomerNumber" value="<%=actionForm.getLegacyCustomerNumber() %>" maxlength="35" /> 
          </td>
          <td width="12" height="20">&nbsp;</td>
          <td width="175" height="25"><label for="inac"><oppt:label label="INAC:" id="inac" errorLables="<%=errorValues%>" /></label></td>
          <td width="162" height="20"><oppt:text name="inac" styleClass="iform" styleId="inac" value="<%=actionForm.getInac() %>" maxlength="35" /></td>
        </tr>-->
        <tr> 
          <td width="12">*</td>
          <td width="170" height="25"><label for="customerName"><oppt:label label="Customer&nbsp;name:" id="customerName" errorLables="<%=errorValues%>" /></label></td>
          <td width="175"> <oppt:text name="customerName" styleClass="iform" styleId="customerName" value="<%=actionForm.getCustomerName() %>" maxlength="35" title="Enter customer name"/> 
          </td>
          </tr>
          <tr>
          <td width="12">&nbsp;</td>
          <td width="175"><label for="enterpriseName"><oppt:label label="Enterprise&nbsp;name:" id="enterpriseName" errorLables="<%=errorValues%>" /></label></td>
          <td width="162">
              <oppt:text name="enterpriseName" styleClass="iform" styleId="enterpriseName" value="<%=actionForm.getEnterpriseName() %>" maxlength="35" title="Enter enterprise name"/>
          </td>
        </tr>
        <tr> 
          <td width="12">*</td>
          <td width="170" height="25"><label for="customerRepresentive"><oppt:label label="Customer&nbsp;representative:" id="customerRepresentive" errorLables="<%=errorValues%>" /></label></td>
          <td width="175"> <oppt:text name="customerRepresentive" styleClass="iform" styleId="customerRepresentive" value="<%=actionForm.getCustomerRepresentive() %>" maxlength="40" title="Enter customer representative"/> 
          </td>
          <td width="12">*</td>
          <td width="175"><label for="salesOrg"><oppt:label label="Sales&nbsp;organisation:" id="salesOrg" errorLables="<%=errorValues%>" /></label></td>
          <td width="162"><oppt:select  selectedOption="<%=selectedSalesOrg%>" name="salesOrg" id="salesOrg" onclick ="populateFormListBasedOnSalesOrg()" options="<%=view.getSalesOrgDetails() %>" title="select Sales organisation" /></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr> 
    <th width="750" style=background-color:#cccccc;  class="bar-blue-med"><strong>Form details</strong></th>
  </tr>
  <tr> 
    <td width="750">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="12">*</td>
       
        <!--form number changed by tapan malhotra -->  
        
        <td width="170" height="25"><label for="formNo"><oppt:label label="Form&nbsp;number:" id="formNo" errorLables="<%=errorValues%>" /></label></td>
          <td width="162"> 
         <!--   <oppt:select onchange="populateFormDetails()" selectedOption="<%=actionForm.getFormNo()%>" name="formNo" id="formNo" options="<%=view.getFormNumberDetails()%>" title="select Form number" /> -->
         <select id="formNo" name="formNo" onclick="populateFormDetails()">
         <option value="Select one">Select one</option>
         </select>
          </td>
          <td width="11">*</td>
          <td width="161"><label for="agreementNumber"><oppt:label label="Agreement&nbsp;number:" id="agreementNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="225"> <oppt:text name="agreementNumber" styleClass="iform" styleId="agreementNumber" value="<%=actionForm.getAgreementNumber() %>" maxlength="15" title="Enter agreement number" /> 
          </td>
        </tr>
        <tr> 
          <td width="12">&nbsp;</td>
          <td width="170" height="40">
            <label for="formLongDescripton">Form long  description:</label>
          </td>
          <td width="162">
           <html:textarea rows="2"	property="formLongDescription" styleId="formLongDescription" cols="20" styleClass="iform" value="<%=view. getFormLongDescripton()%>" readonly="true" title="Form long description">&nbsp;</html:textarea> 
          </td>
          <td width="11">&nbsp;</td>
          <td width="161">
             <label for="formShortDescripton">Form short description:</label>
          </td>
          <td width="225"> 
              <html:textarea rows="2" property="formShortDescription" styleId="formShortDescription" cols="20" styleClass="iform" value="<%=view. getFormShortDescripton()%>" readonly="true" title="Form short description">&nbsp;</html:textarea> 
          </td>
        </tr>
        <tr> 
          <td width="12">*</td>
          <td width="170" height="30"><label for="acceptedDate"><oppt:label label="Accepted&nbsp;date:" id="acceptedDate" errorLables="<%=errorValues%>" /></label></td>
          <td width="162"> 
            <input type="text" name="acceptedDate" id="acceptedDate" value="<%=actionForm.getAcceptedDate() %>" readonly="true" maxlength="10" size="15" title="Enter accepted date"/>
            &nbsp;<a href="javascript:openCalendar('document.BaseAgreementActionForm.acceptedDate',null,null,true,500,250)"><img src="//w3.ibm.com/ui/v8/images/icon-select-date.gif" width="13" height="14" alt="select date icon" /></a></td>
          <td width="11" height="20">&nbsp;</td>
          <td width="161"><label for="branchOffice"><oppt:label label="Branch&nbsp;office:" id="branchOffice" errorLables="<%=errorValues%>" /></label></td>
          <td width="225"> <oppt:text name="branchOffice" styleClass="iform" styleId="branchOffice" value="<%=actionForm.getBranchOffice() %>" maxlength="40" title="Enter branch office" /> 
          </td>
        </tr>
        <tr>
          <td width="12">*</td>
          <td width="170" height="25"><label for="coverageType"><oppt:label label="Coverage&nbsp;type:" id="coverageType" errorLables="<%=errorValues%>" /></label></td>
          <td width="162"> <oppt:select selectedOption="<%=actionForm.getCoverageType()%>" name="coverageType" id="coverageType" options="<%=view.getCoverageTypeMap() %>" title="select Coverage Type"/> 
          </td>
          <td width="11">&nbsp;</td>
          <td width="161"><label for="imageReferenceNumber"><oppt:label label="Image&nbsp;reference&nbsp;number:" id="imageReferenceNumber" errorLables="<%=errorValues%>" /></label></td>
          <td width="225"> <oppt:text name="imageReferenceNumber" styleClass="iform" styleId="imageReferenceNumber" value="<%=actionForm.getImageReferenceNumber() %>" maxlength="40" title="Enter imagerefrence number"/> </td>
        </tr>
        <tr>
          <td width="12">&nbsp;</td>
          <td width="170" height="25"><label for="oneWay"><oppt:label label="One way:" id="oneWay" errorLables="<%=errorValues%>" /></label></td>
          <td width="162">  
          <%      
         if (("Y").equals(actionForm.getOneWay()))
          {
%>        
		    <label for="Yes"><input type="radio" name="oneWay" value="Y" id="oneWay" title="select One way" checked="true"/>Yes</label>
            <label for="No"><input type="radio" name="oneWay" value="N" id="oneWay" title="select One way" />No</label>
<%        } else {
%>        
 			  <label for="Yes"><input type="radio" name="oneWay" value="Y" id="oneWay" title="select One way" />Yes</label>
              <label for="No"><input type="radio" name="oneWay" value="N" id="oneWay" title="select One way" checked="true"/>No</label>
<%        } %>
          </td>
          <td width="11"height="20"> </td>
          <td width="161"> <label for="expirationDate"><oppt:label label="Expiration date:" id="expirationDate" errorLables="<%=errorValues%>" /></label> 
          </td>
          <td width="225"> 
            <input type="text" name="expirationDate" id="expirationDate" value="<%=actionForm.getExpirationDate()== null ? "" : actionForm.getExpirationDate()%>" readonly="true" maxlength="10" size="15" title="Enter expiration date"/>
            &nbsp;<a href="javascript:openCalendar('document.BaseAgreementActionForm.expirationDate',null,null,true,530,300)"><img src="//w3.ibm.com/ui/v8/images/icon-select-date.gif" width="13" height="14" alt="select date icon" /> 
            </a></td>
          
        </tr>
        <tr>
          <td width="12"> </td>
          <td width="170" height="25"> <label for="isElectronicSubmitter"><oppt:label label="Is electronic submitter:" id="isElectronicSubmitter" errorLables="<%=errorValues%>" /></label> </td>
          <td width="162"> 
<%       if (("Y").equals(actionForm.getIsElectronicSubmitter()))
          {
%>           <label for="Yes"><input type="radio" name="isElectronicSubmitter" value="Y" id="isElectronicSubmitter" title="select Is electronic submitter" checked="true" />Yes</label>
             <label for="No"><input type="radio" name="isElectronicSubmitter" value="N" id="isElectronicSubmitter" title="select Is electronic submitter" />No</label>
<%        } else {
%>            <label for="Yes"><input type="radio" name="isElectronicSubmitter" value="Y" id="isElectronicSubmitter" title="select Is electronic submitter" />Yes</label>
              <label for="No"><input type="radio" name="isElectronicSubmitter" value="N" id="isElectronicSubmitter" title="select Is electronic submitter" checked="true"/>No</label>
<%        } %>
        </td>
        </tr>
        <tr>
          <td width="12">&nbsp; </td>
          <td nowrap width="171"> 
           
           <!--  <input type="hidden" name="formNo" value="<%=view.getFormDetailKey()%>" /> -->
           
          </td>
          <td width="162">&nbsp;</td>
          <td width="11">&nbsp;</td>
          <td width="161">&nbsp;</td>
          <td width="225">&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td width="750" align="right">
	 <oppt:buttons buttonFlags="<%=buttonFlags %>">
	   <oppt:button id="register" name="multipleButtonManager.register" alt="Register" value="Register" primary="true" />
	   <oppt:button id="addmodification" name="multipleButtonManager.addmodification" alt="Add modification" value="Add modification" primary="true" />
	   <oppt:button id="clearall" name="multipleButtonManager.clearall" alt="ClearAll" value="Clear all" primary="true" />
	   <oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" value="Cancel" primary="true" />
	 </oppt:buttons>
    </td>
  </tr>
</table>
</html:form>
<script language="JavaScript" type="text/javascript">
<!--setformNumberOnFormLoad() created by tapan malhotra-->
var test = document.BaseAgreementActionForm.orginalList.value.split("$");

var allFornNumbers = "<%= view.getFormNumbersString() %>";
var selectedSalesOrg = "<%= view.getSaleOrgCode(view.getSalesOrganisation()) %>";
var selectedFormNumber = "<%= view.getFormNo() %>";
//alert(selectedFormNumber);
setformNumberOnFormLoad();

document.onkeyup = KeyCheck; 

  function KeyCheck()
{
   var KeyID = event.keyCode;
   switch(KeyID)
   {
      case 38:
      populateFormListBasedOnSalesOrg();
	  populateFormDetails();
      break;    
      case 40:        
     
	 populateFormListBasedOnSalesOrg();
	 populateFormDetails();
       
	   
      break;  
 }
}
function setformNumberOnFormLoad()
{
	var array= new Array();
	var formNumber1 = allFornNumbers.split("$");
    for (n=0;n<formNumber1.length;n++){
      var temparray=formNumber1[n].split("|");
      array[array.length] = new Array(formNumber1[n], temparray[0]);
	}
	
    match = new Array();
	for (n=0;n<array.length;n++){
		var splitted = array[n][0].split("|");
		var splitted1 = splitted[3];
		if(selectedSalesOrg == splitted1){
     		match[match.length] = new Array(array[n][0], array[n][1]);
     	}
    }
   var form = parent.document.BaseAgreementActionForm;
   form.formNo.options.length = 0;
   form.formNo.options[0]=new Option("Select one","Select one");
   if(selectedSalesOrg != "Select one"){
	 	for (n=0;n<match.length;n++){
 	   		if(match[n][1] == selectedFormNumber) {
		  		form.formNo.options[n+1]= new Option(match[n][1],match[n][0]);
		  		form.formNo.options[n+1].selected=true;
		  	} else {
   		  	   form.formNo.options[n+1]= new Option(match[n][1],match[n][0]);
		  	}
		  		
  		}
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
function populateFormDetails(){
var form = parent.document.BaseAgreementActionForm;
var formNumber = form.formNo.value;
var formInfo = formNumber.split("|");
   // form.formNo.value = formInfo[0];
	if(formNumber == "Select one"){
	form.formLongDescription.value= "";
	form.formShortDescription.value = "";
	}else {
	form.formLongDescription.value= formInfo[1];
	form.formShortDescription.value = formInfo[2];
	}
	
}
<!--function populateFormListBasedOnSalesOrg() created by tapan malhotra-->
function populateFormListBasedOnSalesOrg(){
var form = parent.document.BaseAgreementActionForm;
var salesOrgSelected = form.salesOrg.value;
var salesOrg = salesOrgSelected.split("-");
var salesOrgId = salesOrg[1];
var formNumber1 = test;

var array= new Array();

    for (n=0;n<formNumber1.length;n++){
      var temparray=formNumber1[n].split("|");
      array[array.length] = new Array(formNumber1[n], temparray[0]);

	}
      
	 match = new Array();
	for (n=0;n<array.length;n++){
	var splitted = array[n][0].split("|");
	var splitted1 = splitted[3];
	
	if(salesOrgId == splitted1){
     		match[match.length] = new Array(array[n][0], array[n][1]);
    }
     }
       form.formNo.options.length = 0;
	   form.formNo.options[0]=new Option("Select one","Select one");
        if(salesOrgSelected != "Select one"){
		 	for (n=0;n<match.length;n++){
		  		form.formNo.options[n+1]= new Option(match[n][1],match[n][0]);
	  		}
	  	}else {
	   	form.formLongDescripton.value= "";
		form.formShortDescripton.value = "";
	   }		
}

</script>
<noscript>To use this function please enable java script in your browser</noscript>



