<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfigureDMViewBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ConfigureDMActionForm" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ConfigureDMViewBean view = (ConfigureDMViewBean)opptSession.getCurrentViewBean();
	if (null == view) {
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	ConfigureDMActionForm actionForm = view.getConfigureDMActionForm();

	OPPTCalender calender = new OPPTCalender();
	calender.setDate(view.getPlanEndDate());
	String year = calender.getYear()+"";
	String month = calender.getMonth()+"";
	String day = calender.getDay()+"";
	calender = null;
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Proposal details - Configure DM</em></p>		
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
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this form to plan future HW upgrades/downgrades.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/ConfigureDMMultipleAction.wss" method="post">
	<table cellpadding="0" cellspacing="0" border="0" width="650" role="presentation">
		<tr>
			<td colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">DM information</td>
		</tr>
		<tr>
			<td width="245" height="20">&nbsp;&nbsp;DM number:</td>
			<td width="355">&nbsp;&nbsp;<oppt:label label="<%=view.getDMNumber() %>" /></td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;DM description:</td>
			<td>&nbsp;&nbsp;<oppt:label label="<%=view.getDMDescription() %>" /> </td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="650" summary="Dates">
		<tr>
			<th colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">Dates</th>
		</tr>
		<tr>
			<td width="245" height="20">&nbsp;&nbsp;Original plan start date:</td>
			<td width="355">&nbsp;&nbsp;<oppt:date date="<%=view.getPlanStartDate() %>" /> </td>
		</tr>
		<tr>
			<td height="20">&nbsp;&nbsp;<label for="originalPlanEndDateYear">Original plan end date:</label></td>
			<td>&nbsp;&nbsp;<oppt:text  name="originalPlanEndDate.year" styleId="originalPlanEndDateYear"
				size="4" value="<%=year %>" maxlength="4" styleClass="iform" />&nbsp;- &nbsp;<oppt:text name="originalPlanEndDate.month"
				styleId="originalPlanEndDateMonth" size="2" title= "orgplnenddatemonth" value="<%=month %>" maxlength="2" styleClass="iform" />&nbsp;-
			&nbsp;<oppt:text 
				name="originalPlanEndDate.day" styleId="originalPlanEndDateMonth1" title="orgplnenddatemonth1" size="2" value="<%=day %>" maxlength="2"
				styleClass="iform" /></td>
		</tr>
	</table>
	&nbsp;<br />
	<table cellpadding="0" cellspacing="0" border="0" width="650" role="presentation">
		<tr>
			<td colspan="2" height="18" style=background-color:#cccccc; class="bar-blue-med">Bump dates</td>
		</tr>
		<tr>
			<td width="245" height="30">&nbsp;&nbsp;<label >Bump plan start date:</label></td>
			<td width="355">&nbsp;&nbsp;<oppt:dateOptions name="bumpPlanStartDate" day="<%=actionForm.getBumpPlanStartDate().getDay() %>" month="<%=actionForm.getBumpPlanStartDate().getMonth() %>" year="<%=actionForm.getBumpPlanStartDate().getYear() %>" years="<%=view.getStartYears() %>" alt="Bump plan start date" /></td>
		</tr>
		<tr>
			<td height="30">&nbsp;&nbsp;<label >Bump plan end date:</label></td>
			<td>&nbsp;&nbsp;<oppt:dateOptions name="bumpPlanEndDate" day="<%=actionForm.getBumpPlanEndDate().getDay() %>" month="<%=actionForm.getBumpPlanEndDate().getMonth() %>" year="<%=actionForm.getBumpPlanEndDate().getYear() %>" years="<%=view.getEndYears() %>" alt="Bump plan end date" /></td>
		</tr>
	</table>
	&nbsp;<br />

	<%
		if(view.isDisplayDefaultValues()){
			if(!view.isDefaultValuesAllText()){
	%>
	<table cellpadding="0" cellspacing="0" width="650" role="presentation">
		<tr>
			<td width="600" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">Default value</td>
		</tr>
	</table>
	<table width="650" cellpadding="4" cellspacing="0" summary="Value metric description">
		<tr>
			<td width="360" height="18" style=background-color:#cccccc; class="bar-blue-med"><label for="valueMetricDescription">Value metric description</label></td>
			<td width="240"><label for="licenseType">License type</label></td>
		</tr>
		<tr>
			<td>
				<table summary="valueMetricDescription">
					<tr>
						<td>
	<%
				if(view.isValueMetricDescriptionText()){
	%>
							<oppt:text name="valueMetricDescription" styleId="valueMetricDescription" value="<%=actionForm.getValueMetricDescription() %>" size="10" />
	<%
				}
				else{
	%>
							<oppt:select name="valueMetricDescription" id="valueMetricDescription" options="<%=view.getValueMetricDescriptions() %>" selectedOption="<%=actionForm.getValueMetricDescription() %>"  title="Select value matric description" />
	<%
				}
	%>
						</td>
						<td>		
						<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.goValueMetricDescription" value="Go" alt="Go"/></span></td>
					</tr>
				</table>
			</td>
			<td>
				<table summary="licenseType">
					<tr>
						<td>
	<%
				if(view.isLicenseTypeText()){
	%>
							<oppt:text name="licenseType" styleId="licenseType" value="<%=actionForm.getLicenseType() %>" size="10" />
	<%
				}
				else{
	%>
							<oppt:select name="licenseType" id="licenseType" options="<%=view.getLicenseTypes() %>" selectedOption="<%=actionForm.getLicenseType() %>"  title="Select license type" />
	<%
				}
	%>
						</td>
						<td>
						<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.goLicenseType" value="Go"   alt="Go"/></span></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<th width="360" height="30"><label for="chargeOption">Charge option</label></th>
			<th width="240" height="30"><label for="useLevel">Use level</label></th>
		</tr>
		<tr>
			<td height="41">
				<table summary="chargeOption">
					<tr>
						<td>
	<%
				if(view.isLicenseTypeText()){
	%>
							<oppt:text name="chargeOption" styleId="chargeOption" value="<%=actionForm.getChargeOption() %>" size="10" />
	<%
				}
				else{
	%>
							<oppt:select name="chargeOption" id="chargeOption" options="<%=view.getChargeOptions() %>" selectedOption="<%=actionForm.getChargeOption() %>"  title="Select charge option" />
	<%
				}
	%>
						</td>
						<td>
						<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.goChargeOption" value="Go"   alt="Go"/></span>
						</td>
					</tr>
				</table>
			</td>
			<td height="41">
				<table summary="useLevel">
					<tr>
						<td>
	<%
				if(view.isLicenseTypeText()){
	%>
							<oppt:text name="useLevel" styleId="useLevel" value="<%=actionForm.getUseLevel() %>" size="10" />
	<%
				}
				else{
	%>
							<oppt:select name="useLevel" id="useLevel" options="<%=view.getUseLevels() %>" selectedOption="<%=actionForm.getUseLevel() %>"  title="Select use level" />
	<%
				}
	%>
						</td>
						<td>
						<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.goUseLevel" value="Go"   alt="Go"/></span>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
			
	<%
			}
			else{
	%>
	<table cellpadding="0" cellspacing="0" border="0" width="650" role="presentation">
		<tr>
			<td colspan="4" height="18" style="background-color:#999999;"  class="bar-blue-med-dark">&nbsp;&nbsp;Default value</td>
		</tr>
		<tr>
			<th width="180" height="18" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;<label for="valueMetricDescription">Value metric description</label></th>
			<th width="120" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;<label for="licenseType">License type</label></th>
			<th width="120" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;<label for="chargeOption">Charge option</label></th>
			<th width="120" style=background-color:#cccccc; class="bar-blue-med">&nbsp;&nbsp;<label for="useLevel">Use level</label></th>
		</tr>
		<tr>
			<td width="180" height="30">
				<oppt:text name="valueMetricDescription" styleId="valueMetricDescription" size="10" styleClass="iform" value="<%=actionForm.getValueMetricDescription() %>" />
				<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.goValueMetricDescription" value="Go"   alt="Go"/></span>
			</td>
			<td width="120">
				<oppt:text name="licenseType" styleId="licenseType" size="10" styleClass="iform" value="<%=actionForm.getLicenseType() %>" />
				<span class="button-blue"><input type="submit" id="go1" name="multipleButtonManager.goValueMetricDescription" value="Go" alt="Go"/></span>
			</td>
			<td width="120">
				<oppt:text name="chargeOption" styleId="chargeOption" size="10" styleClass="iform" value="<%=actionForm.getChargeOption() %>" />
				<span class="button-blue"><input type="submit" id="go3" name="multipleButtonManager.goChargeOption" value="Go"   alt="Go"/></span>
			</td>
			<td width="120">
				<oppt:text name="useLevel" styleId="useLevel" size="10" styleClass="iform" value="<%=actionForm.getUseLevel() %>" />
				<span class="button-blue"><input type="submit" id="go4" name="multipleButtonManager.goUseLevel" value="Go"    alt="Go"/></span>
			</td>
		</tr>
	</table>
	<%
			}
		}
	%>

	&nbsp;<br />
	<oppt:configureDMSwos property="selectedIds" swos="<%=view.getSwoViewBeans() %>" />
	<table border="0" cellpadding="0" cellspacing="0" role="presentation" align="left">
		<tr>
		<td>
    	<oppt:buttons>
			<oppt:opptbutton  value="Exclude" name="multipleButtonManager.exclude" alt="Exclude" id="exclude" />
			<oppt:opptbutton  value="Default" name="multipleButtonManager.default" alt="Default" id="default" />
			<oppt:opptbutton  value="Copy" name="multipleButtonManager.copy" alt="Copy" id="copy" />
			<oppt:opptbutton  value="Select copy" name="multipleButtonManager.selectCopy" alt="Select copy" id="selectCopy" />
			<oppt:opptbutton  value="Validate" name="multipleButtonManager.validate" alt="Validate" id="validate" />
			<oppt:opptbutton  value="Fetch price" name="multipleButtonManager.fetchPrice" alt="Fetch price" id="fetchPrice" />
			<oppt:opptbutton  value="Cancel" name="multipleButtonManager.cancel" alt="Cancel" id="cancel" />
		</oppt:buttons>
		</td>
		</tr>
	</table>
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
