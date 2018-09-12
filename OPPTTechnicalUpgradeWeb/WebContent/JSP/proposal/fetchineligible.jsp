
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.IneligibleLicencesViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	
	IneligibleLicencesViewBean view = (IneligibleLicencesViewBean)opptSession.getCurrentViewBean();
	if (null == view) {
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
	ArrayList buttonFlags = view.getButtonFlags();
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Ineligible licenses</em></p>		
		</div>
	</div>

<div id="ibm-content-body">

<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<td width="443">
			<table width="443" role="presentation">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use the tick box to select items to be included in the proposal. Some
						of the licenses cannot be included into the proposal unless the
						ineligibility reason has been removed. Click on show to view the details
						of that particular section and click on hide to hide the details of that
						particular section. When you are finished, click the Continue button.
						Press the Clear all button to discard your selection. Press the Cancel 
						button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/FetchIneligibleMultipleAction.wss">
	<table align="left" border="0" cellspacing="0" cellpadding="0" width="600" summary=" Ineligible licenses">
<%
	if(view.isSAndS() && (UtilityConstants.MLC_ONLY.equals(view.getMlcSandSOption()) || UtilityConstants.MLC_AND_SANDS.equals(view.getMlcSandSOption())))
	{
%>
	<tr>
		<th align="left" colspan="2" height="20" style=background-color:#cccccc; class="bar-blue-med">MLC Ineligible</th>
	</tr>
	<tr>
		<td>&nbsp;<br /></td>
	</tr>
<%
	}
	if(!view.isSAndS() || UtilityConstants.MLC_ONLY.equals(view.getMlcSandSOption()) || UtilityConstants.MLC_AND_SANDS.equals(view.getMlcSandSOption()))
	{
%>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp; <oppt:showhide show="<%=view.isShowExistingContractCoverage()%>" block="<%=IneligibleLicencesViewBean.MLC_BLOCK%>" type="<%=IneligibleLicencesViewBean.EXISTING_CONTRACT_COVERAGE%>" url="ShowIneligibleLicenses.wss" link = "Show existing contract coverage"/></th>
        	<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th> 
		</tr>
	<%
		if(view.isShowExistingContractCoverage()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getExistingContractCoverage()%>"/>
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp; <oppt:showhide show="<%=view.isShowLicensesFailingRemovalDateCheck()%>" block="<%=IneligibleLicencesViewBean.MLC_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_REMOVAL_DATE_CHECK%>" url="ShowIneligibleLicenses.wss" link = "Licenses failing removal date check"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isShowLicensesFailingRemovalDateCheck()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getLicensesFailingRemovalDateCheck()%>"/>
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp; <oppt:showhide show="<%=view.isShowLicensesWithRejectionReason()%>" block="<%=IneligibleLicencesViewBean.MLC_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_WITH_REJECTION_REASON%>" url="ShowIneligibleLicenses.wss" link = "Licenses with rejection reason" /></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isShowLicensesWithRejectionReason()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getLicensesWithRejectionReason()%>"/>
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp;<oppt:showhide show="<%=view.isShowLicensesFailingLicenseEffectiveDateCheck()%>" block="<%=IneligibleLicencesViewBean.MLC_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK%>" url="ShowIneligibleLicenses.wss" link = "Licenses failing license effective date check"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isShowLicensesFailingLicenseEffectiveDateCheck()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getLicensesFailingLicenseEffectiveDateCheck()%>" input="true" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK%>" />
			</td>
		</tr>
	<%
		}
		%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp; <oppt:showhide show="<%=view.isShowLicensesFailingDueToDeliveryBlockDate()%>" block="<%=IneligibleLicencesViewBean.MLC_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE%>" url="ShowIneligibleLicenses.wss" link = "Licenses failing due to delivery block check"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isShowLicensesFailingDueToDeliveryBlockDate()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getLicensesFailingDueToDeliveryBlockDate()%>" input="true" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE%>" />
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp; <oppt:showhide show="<%=view.isShowLicensesFailingWithSvc()%>" block="<%=IneligibleLicencesViewBean.MLC_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_WITH_SVC%>" url="ShowIneligibleLicenses.wss" link = "Licenses with SVC"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isShowLicensesFailingWithSvc()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getLicensesFailingWithSvc()%>" input="true" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_WITH_SVC%>" />
			</td>
		</tr>
<%
		}
	}
%>
		
		<tr>
			<td>&nbsp;<br /></td>
		</tr>
		
		
<%
	if(view.isSAndS() && (UtilityConstants.SANDS_ONLY.equals(view.getMlcSandSOption()) || UtilityConstants.MLC_AND_SANDS.equals(view.getMlcSandSOption())))
	{
%>
		<tr>
			<th align="left" colspan="2" height="20" style=background-color:#cccccc; class="bar-blue-med">S&amp;S Ineligible</th>
		</tr>
		
		<tr>
			<td>&nbsp;<br /></td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp;<oppt:showhide show="<%=view.isSandSShowExistingContractCoverage()%>" block="<%=IneligibleLicencesViewBean.SANDS_BLOCK%>" type="<%=IneligibleLicencesViewBean.EXISTING_CONTRACT_COVERAGE%>" url="ShowIneligibleLicenses.wss" link = "Show existing contract coverage"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isSandSShowExistingContractCoverage()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getSAndSExistingContractCoverage()%>"/>
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp;<oppt:showhide show="<%=view.isSandSShowLicensesFailingRemovalDateCheck()%>" block="<%=IneligibleLicencesViewBean.SANDS_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_REMOVAL_DATE_CHECK%>" url="ShowIneligibleLicenses.wss" link = "Licenses failing removal date check" /></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isSandSShowLicensesFailingRemovalDateCheck()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getSAndSLicensesFailingRemovalDateCheck()%>"/>
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp;<oppt:showhide show="<%=view.isSandSShowLicensesWithRejectionReason()%>" block="<%=IneligibleLicencesViewBean.SANDS_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_WITH_REJECTION_REASON%>" url="ShowIneligibleLicenses.wss" link = "Licenses with rejection reason"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isSandSShowLicensesWithRejectionReason()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getSAndSLicensesWithRejectionReason()%>"/>
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp; <oppt:showhide show="<%=view.isSandSShowLicensesFailingLicenseEffectiveDateCheck()%>" block="<%=IneligibleLicencesViewBean.SANDS_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK%>" url="ShowIneligibleLicenses.wss" link = "Licenses failing license effective date check"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isSandSShowLicensesFailingLicenseEffectiveDateCheck()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getSAndSLicensesFailingLicenseEffectiveDateCheck()%>" input="true" type="<%=IneligibleLicencesViewBean.S_AND_S_LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK%>" />
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp;<oppt:showhide show="<%=view.isSandSShowLicensesFailingDueToDeliveryBlockDate()%>" block="<%=IneligibleLicencesViewBean.SANDS_BLOCK%>" type="<%=IneligibleLicencesViewBean.LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE%>" url="ShowIneligibleLicenses.wss" link = "Licenses failing due to delivery block check"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
		<%
		if(view.isSandSShowLicensesFailingDueToDeliveryBlockDate()){
	%>
		<tr>
			<td colspan="2">
			<oppt:ineligiblelicenses licenses="<%=view.getSAndSLicensesFailingDueToDeleveryBlockDate()%>" input="true" type="<%=IneligibleLicencesViewBean.S_AND_S_LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE%>" />	
			</td>
		</tr>
	<%
		}
	%>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th width="400" align="left" height="20" style=background-color:#eeeeee; class="bar-gray-med-light">&nbsp;<oppt:showhide show="<%=view.isSandSShowLicensesFailingWithSvc()%>" block="<%=IneligibleLicencesViewBean.SANDS_BLOCK%>" type="<%=IneligibleLicencesViewBean.S_AND_S_LICENSES_FAILING_WITH_SVC%>" url="ShowIneligibleLicenses.wss" link = "Licenses with SVC"/></th>
			<th width="200" align="right" style=background-color:#eeeeee; class="bar-gray-med-light"></th>
		</tr>
	<%
		if(view.isSandSShowLicensesFailingWithSvc()){
	%>
		<tr>
			<td colspan="2">
				<oppt:ineligiblelicenses licenses="<%=view.getSAndSLicensesFailingWithSvc()%>" input="true" type="<%=IneligibleLicencesViewBean.S_AND_S_LICENSES_FAILING_WITH_SVC%>" />
			</td>
		</tr>
<%
		}
	}
%>
		<tr>
			<td>&nbsp;<br /></td>
		</tr>
		<tr>
			<td colspan="2">
				<table align="left" role="presentation">
					<tr>
						<td align="left"><oppt:button value="Continue" primary="true" name="multipleButtonManager.continue" alt="Continue" id="continue" buttonFlags="<%=buttonFlags %>" /></td>
						<td align="left"><oppt:button value="Select all" name="multipleButtonManager.selectAll" alt="Select all" id="selectAll" buttonFlags="<%=buttonFlags %>" /></td>
						<td align="left"><oppt:button id="clearAll" name="multipleButtonManager.clearAll" alt="Clear all" value="Clear all" buttonFlags="<%=buttonFlags %>" /></td>
						<td align="left"><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" value="Cancel" buttonFlags="<%=buttonFlags %>" /></td>
					</tr>
				</table>
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
