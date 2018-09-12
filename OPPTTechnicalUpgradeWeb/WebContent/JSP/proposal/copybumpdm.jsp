<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.HashSet" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DMCopyBumpViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.DMCopyBumpActionForm" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.Set" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.Iterator" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	DMCopyBumpViewBean view = (DMCopyBumpViewBean)opptSession.getCurrentViewBean();
	if (null == view) {
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	DMCopyBumpActionForm actionForm = view.getCopyBumpDMActionForm();
	HashSet errorFields = errorReport.getErrorFieldNames();
	
	HashMap hm=new HashMap();
	hm.put(new Integer(1),"Jan");
	hm.put(new Integer(2),"Feb");
	hm.put(new Integer(3),"Mar");
	hm.put(new Integer(4),"Apr");
	hm.put(new Integer(5),"May");
	hm.put(new Integer(6),"Jun");
	hm.put(new Integer(7),"Jul");
	hm.put(new Integer(8),"Aug");
	hm.put(new Integer(9),"Sep");
	hm.put(new Integer(10),"Oct");
	hm.put(new Integer(11),"Nov");	
	hm.put(new Integer(12),"Dec");	

	String yr=actionForm.getOriginalPlanEndDate().getYear();
	String mm=actionForm.getOriginalPlanEndDate().getMonth();
	String dd=actionForm.getOriginalPlanEndDate().getDay();


	Set set=hm.entrySet();
	Iterator i=set.iterator();	
	while (i.hasNext())
	{
	Map.Entry me=(Map.Entry)i.next();	

		if (mm.equalsIgnoreCase(me.getKey().toString())){             
				mm=me.getValue().toString();				
				break;
		}
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Proposal details - DM copy bump</em></p>		
		</div>
	</div>

<div id="ibm-content-body">

<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Press the Clear all button to discard your input. Press the Cancel button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CopyBumpDMMultipleAction.wss" method="post">
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="DM information">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;DM information</th>
		</tr>
		<tr>
			<td width="220" height="20">&nbsp;&nbsp;DM number:</td>
			<td width="380">&nbsp;&nbsp;<oppt:label label="<%=view.getDMNumber() %>" /></td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;DM description:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getDMDescription() %>" /> </td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Source information">
		<tr>
			<th width="220" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Source information</th>
			<th width="380" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;(dd-Mmm-yyyy)</th>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;Original plan start date:</td>
			<td>&nbsp;&nbsp;<oppt:date date="<%=view.getPlanStartDate() %>" /> </td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;<label ><oppt:label label="Original plan end date:" id="originalPlanEndDate" errorLables="<%=errorFields %>" /></label></td>
			<td>&nbsp;&nbsp;<%=dd+"-"+mm+"-"+yr%> </td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="600" summary="Target information">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;Target information</th>
		</tr>
		<tr>
			<td width="220" height="30">&nbsp;&nbsp;<label ><oppt:label label="Bump plan start date:" id="bumpPlanStartDate" errorLables="<%=errorFields %>" /></label></td>
			<td width="380">&nbsp;&nbsp;<oppt:dateOptions name="bumpPlanStartDate" date="<%=actionForm.getBumpPlanStartDate().getDate() %>" years="<%=view.getStartYears() %>" alt="Bump plan start date" /></td>
		</tr>
		<tr>
			<td height="30">&nbsp;&nbsp;<label ><oppt:label label="Bump plan end date:" id="bumpPlanEndDate" errorLables="<%=errorFields %>" /></label></td>
			<td>&nbsp;&nbsp;<oppt:dateOptions name="bumpPlanEndDate" date="<%=actionForm.getBumpPlanEndDate().getDate() %>" years="<%=view.getEndYears() %>" alt="Bump plan end date" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table align="left" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td><oppt:button value="Copy" primary="true" name="multipleButtonManager.copy" alt="Copy" id="copy" /></td>
			<td><oppt:button value="Clear all"  name="multipleButtonManager.clearAll" alt="Clear all" id="clearAll" /></td>
			<td><oppt:button value="Cancel"  name="multipleButtonManager.cancel" alt="Cancel" id="cancel" /></td>
		</tr>
	</table>
	&nbsp;<br />
</html:form>
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
