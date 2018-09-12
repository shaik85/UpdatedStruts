
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.HashSet" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SignInViewBean" %>


<%
	OPPTSession opptSession = new OPPTSession(session);
	SignInViewBean viewBean = (SignInViewBean)opptSession.getCurrentViewBean();
	if (null == viewBean) {
		return;
	}
	ErrorReport	errorReport = viewBean.getErrorReport();
	HashSet errorValues = errorReport.getErrorFieldNames();
%>
<table cellpadding="0" cellspacing="0" border="0" width="600" role="presentation">
	<tr valign="top">
		<h1>Sign in</h1>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<oppt:displayErrorReport errorReport="<%=errorReport%>" />

			<table width="600" border="0" cellspacing="0" cellpadding="0" summary="Sign in login">
				<tr>
					<td width="600" valign="top" align="left">
						<html:form action="protect/SubmitSignIn.wss">
							<table width="600" border="0" cellspacing="0" cellpadding="0" summary="user info">
								<tr>
									<td colspan="3">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="3">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="3">You must be signed in to use this area of the
									site. Please enter your IBM intranet id and password in the sign in area below. </td>
								</tr>
								<tr>
									<td colspan="3">&nbsp;</td>
								</tr>
								<tr>
									<th colspan="3" style=background-color:#cccccc; class="bar-blue-med">Sign in </th>
								</tr>
								<tr>
									<td colspan="3">&nbsp;</td>
								</tr>
					
								<tr>
									<td width="55"><label for="userId"><oppt:label label="IBM ID:" id="userId" errorLables="<%=errorValues %>" /></label></td>
									<td width="461"><oppt:text name="userId" maxlength="105" styleId="userId" value="<%=viewBean.getUserId()%>" /></td>
								</tr>
								<tr>
									<td colspan="3">&nbsp;</td>
								</tr>
								<tr>
									<td width="55"><label for="password"><oppt:label label="Password:" id="password" errorLables="<%=errorValues %>" /></label></td>
									<td width="461" valign="top"><input type="password" maxlength="105" name="password" class="iform" id="password" /></td>
								</tr>
								<tr>
									<td colspan="3">&nbsp;</td>
								</tr>
					            <tr><td colspan="3"><div class="ibm-alternate-rule">&nbsp;</div></td> </tr>
						      <tr>
						          <td colspan="3">
						             <div class="button-bar">        
				                         <div class="buttons">
				                          <span class="button-blue" ><input type="submit" name ="submit" value="Submit" /></span>  </div>
                                     </div>                                 </td>
                           </tr>
                          </table>
						</html:form>
					</td>
					<td width="7">&nbsp;</td>
					<td width="150" align="left" valign="top">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
