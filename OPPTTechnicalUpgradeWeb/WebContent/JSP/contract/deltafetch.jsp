
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>


<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Contract maintenance</h1>

<p ><em><br>Delta fetch</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">

<table summary="layout" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<p>Delta Fetch is done for those items that have been changed or newly 
						added in ESW. To ensure that any inventory that is added in ESW is also 
						pulled into the Frontend and the two systems are synchronous, Delta fetch 
						is done. Delta Fetch is a mandatory Function and the User will have to execute 
						this Function before Contract Registration. Press the Cancel button to go back
						to contract details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp;<br />
<table summary="DeltaFetch" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/DeltaFetchMultipleAction.wss" method="post">
			<table summary="DeltaFetch Info" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><input type="radio" name="deltaFetchType" id="deltaRadio1" value="skip" checked="checked" /></td>
					<td><label for="deltaRadio1">Skip</label></td>
				</tr>
				<tr>
					<td align="left"><input type="radio" name="deltaFetchType" id="deltaRadio2" value="replace" /></td>
					<td align="left"><label for="deltaRadio2">Replace</label></td>
				</tr>
			</table>
			&nbsp;<br />
			<table role="presentation" align="right" cellspacing="0" cellpadding="0">
				<tr>
					<td><oppt:button id="continue" name="multipleButtonManager.continue" primary="true" alt="Continue" 
					value="Continue" /></td>
					<td><oppt:button id="cancel" name="multipleButtonManager.cancel" alt="Cancel" value="Cancel" /></td>
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



