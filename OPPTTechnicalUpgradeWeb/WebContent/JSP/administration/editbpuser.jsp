
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BPUserActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BPUserViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	TreeMap salesArea = null;
	TreeMap roles=null;
	TreeMap managers=null;
	ArrayList customerList=null;
	HashMap legacyList=null;
	String userId="";
	String role="";
	String selectedManager="";
	String primarySalesArea="";
	ArrayList buttonFlags = null;
	HashSet errorValues = null;
	ErrorReport errorReport = null;
	BPUserActionForm actionForm = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	BPUserViewBean viewBean = (BPUserViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		actionForm = viewBean.getBPUserActionForm();
		salesArea = viewBean.getSalesAreas();
		roles = viewBean.getRoles();
		primarySalesArea = viewBean.getPrimarySalesArea();	
		managers = viewBean.getManagers();
		role = viewBean.getSelectedRole();
		userId = viewBean.getUserId();
		
		if(null == actionForm.getRole() && null == actionForm.getManager()){
			role = viewBean.getSelectedRole();
			customerList = viewBean.getCustomerNumbers();
			legacyList = viewBean.getLegacyNos();
			selectedManager = viewBean.getSelectedManager();
		}
		else{
			role = actionForm.getRole();
			legacyList = viewBean.getUserLegacy();
			customerList = viewBean.getListNumberArrayList();
			selectedManager = actionForm.getManager();
		}
		
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorValues =  errorReport.getErrorFieldNames();
	}
%>


<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				User maintenance</h1>

<p ><em><br>Edit user</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table summary="User maintenance" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="443">
			<table summary="edit user" width="443">
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to change access to OPPT for an existing user. 
						If you change the primary sales org, click on the GO button next
						to the primary sales org field to load the Manager information for
						selected primary sales org. When you are finished,  press the Save 
						button. Press the Clear all button to discard your input.
						Press Cancel button to go back to user maintenance page.</p>
						
						<p>Required fields are marked with an asterisk (<strong>*</strong>)
							and must be filled in to complete the form.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="EditBPUser" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/EditBPUserMultipleAction.wss" >
			<table summary="editbp" align="center" width="600" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td align="left">
					<table summary="EditBPUser info" cellspacing="1" cellpadding="1" border="0" width="600">
						<tr>
							<td width="12" height="30" align="center">&nbsp;</td>
							<td width="132">User ID:</td>
							<td width="447"><%=userId%></td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"><span class="ibm-required">*</span></td>
							<td><label for="roledesc"><oppt:label label="Role:" id="roledesc" errorLables="<%=errorValues%>" /></label></td>
							<td><oppt:select name="role" style="iform" id="roledesc" options="<%=roles%>" selectedOption="<%=role%>" title= "Select role" /></td>
						</tr>
						<tr>
							<td width="12" height="30" align="center">&nbsp;</td>
							<th>Access required:</th>
						<%
							if("C".equalsIgnoreCase(viewBean.getAccessRequiredOptions()))
							{
						%>
								<th>By customer list number</th>
						<%
							}
							else
							{
						%>
								<th>By legacy customer number</th>
						<%
							}
						%>
						</tr>
						<tr>
							<td width="12" height="30" align="center"><span class="ibm-required">*</span></td>
							<td><label for="sales" ><oppt:label label="Sales org:" id="salesOrg" errorLables="<%=errorValues%>" /></label></td>
							<td>
								<table>
									<tr>
										<td><oppt:select name="primarySalesOrganization" style="iform" id="sales" reverse="true" selectedOption="<%=primarySalesArea%>" options="<%=salesArea%>" title= "Select sales org" /></td>
										<td>&nbsp;</td>
										<td><span class="button-blue"><input type="submit" class="go" name="multipleButtonManager.go" value="Go" /></span></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="12" height="30" align="center"><span class="ibm-required">*</span></td>
							<td><label for="managerId" ><oppt:label label="Manager to approve id:" id="managerId" errorLables="<%=errorValues%>" /></label></td>
							<td><oppt:select name="manager" style="iform" id="managerId" options="<%=managers%>" selectedOption="<%=selectedManager%>" title= "Slect manager to approve id" /></td>
						</tr>
					</table>
					&nbsp;<br />
				<%
					if(null == viewBean.getAccessRequiredOptions() || "C".equalsIgnoreCase(viewBean.getAccessRequiredOptions()))
					{
				%>
						<table summary="enter customerlist" class="ibm-data-table" align="center" border="0" width="600" cellspacing="0"
						cellpadding="0">
							<tr style="background-color:#cccccc;" align="left">
								<th height="18" colspan="5">Enter customer list
								numbers:</th>
							</tr>
							<%
								int count = 0;
								String customerName = "";
								int customerSize = 0;
								if(null != customerList){
									customerSize = customerList.size();
								}
								for(int i=0; i < 10; i++)
								{
							%>
									<tr>
							<%
									for(int j=0; j < 5; j++)
									{	
										if(count < customerSize){
											customerName = (String)customerList.get(count);
										}
										else{
											customerName = "";
										}
									
							%>
										<td width="117" height="30"><label for="<%="customerlist" + count%>">&nbsp;&nbsp;</label>
											<input type="text" name="listNumbers" id="<%="customerlist" + count%>" value="<%=customerName%>" maxlength="10" size="8" class="iform"/>
										</td>
							<%	
										count++;
									}
							%>
									</tr>
							<%
								}
							%>
						</table>
				<%
					}
					else{
				%>
						<table summary="enter legacy" align="center" border="0" width="600" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left">
										Enter legacy customer numbers, click on save button to submit your request
								</td>
							</tr>
						</table>
						&nbsp;<br />
						<table summary="legacy info" class="ibm-data-table" align="center" width="600" border="0" cellspacing="0" cellpadding="0">	
							<tr>
								<th height="18">Legacy no.</th>
								<th height="18">Sequence no.</th>
								<th height="18">Legacy no.</th>
								<th height="18">Sequence no.</th>
						
							</tr>
							<%
								int count = 1;
								String legacyNo="";
								String sequenceNo="";
								Iterator itr = legacyList.keySet().iterator();
								for(int i=0; i < 50; i++)
								{
									if(itr.hasNext()){
										legacyNo = (String)itr.next();
										sequenceNo = (String)legacyList.get(legacyNo);
									}
									else{
										legacyNo = "";
										sequenceNo = "";
									}
							%>
									<tr>
										<td align="left"><label for="<%="legacynumber" + count%>">&nbsp;</label>
											<input type="text" name="legacyNumber" id="<%="legacynumber" + count%>" value="<%=legacyNo%>" maxlength="10" size="8"/>
										</td>
										<td align="left"><label for="<%="sequencenumber" + count%>">&nbsp;</label>
											<input type="text" name="sequenceNumber" id="<%="sequencenumber" + count%>" value="<%=sequenceNo%>" maxlength="15" size="13"/>
										</td>
							<%
										count++;
										if(itr.hasNext()){
											legacyNo = (String)itr.next();
											sequenceNo = (String)legacyList.get(legacyNo);
										}
										else{
											legacyNo = "";
											sequenceNo = "";
										}
							%>
										<td align="left"><label for="<%="legacynumber" + count%>">&nbsp;</label>
											<input type="text" name="legacyNumber" id="<%="legacynumber" + count%>" value="<%=legacyNo%>" maxlength="10" size="8"/>
										</td>
										<td align="left"><label for="<%="sequencenumber" + count%>">&nbsp;</label>
											<input type="text" name="sequenceNumber" id="<%="sequencenumber" + count%>" value="<%=sequenceNo%>" maxlength="15" size="13"/>
										</td>
									</tr>
							<%
									count++;
								}
							%>
						</table>
				<%
					}
				%>
					&nbsp;<br />
					<table role="presentation" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><oppt:button id="save" name="multipleButtonManager.save" primary="true" alt="Save" value="Save" buttonFlags="<%=buttonFlags %>" /></td>
							<td><oppt:button id="clearAll" name="multipleButtonManager.clearAll" primary="true" alt="Clear all" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
							<td><oppt:button id="cancel" name="multipleButtonManager.cancel" primary="true" alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
						</tr>
					</table>
					<table summary="source" cellspacing="0" cellpadding="0" border="0">
						<tr>
							<td><html:hidden property="source" value="edit" /></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</html:form>
		</td>
	</tr>
</table>
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

<script type="text/javascript">
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
</script>


