
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorInfoViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	
	ErrorInfoViewBean view = (ErrorInfoViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<%
						if(view.isContract()){
					%>
					<h1><br>Contract maintenance: </h1>
					<%
						}
						else{
					%>
					<h1><br>Proposal maintenance: </h1>
					<%
						}
					%>
					

<p ><em><br>Error history: Error details</em></p>		
		</div>
	</div>

<div id="ibm-content-body">




<table cellpadding="0" cellspacing="0" border="0" width="600" summary="isContract">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation">
				
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/ActionErrorHistory.wss" method="post">
	<table cellpadding="1" cellspacing="1" border="0" width="600" summary="errorDetails">
		<oppt:errorDetails errorDetails="<%=view.getErrorDetails() %>" />
	</table>
	&nbsp;<br />
	<table align="right" cellspacing="0" cellpadding="0" border="0" role="presentation">
		<tr>
		<td align="left"><span class="button-blue"><input type="submit" id="continue" name="multipleButtonManager.continue" value="Continue"  alt="Continue" /></span><label for="continue">&nbsp;</label></td>
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
