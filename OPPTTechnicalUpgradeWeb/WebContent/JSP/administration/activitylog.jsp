<!-- Copyright (c) 2011 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.commons.ActivityLogDataBean" %>
<%@ page import = "com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ActivityLogViewBean" %>

<%
	OPPTSession opptSession = new OPPTSession(session);
	ActivityLogViewBean view = (ActivityLogViewBean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				User Maintenance</h1>	
				
				<p class="ibm-alternate"><br><em>Activity Log</em></p>	
		</div>
	</div>	

<div id="ibm-content-body">

<table cellpadding="0" cellspacing="0" border="0" width="700" role="presentation">
	<tr valign="top">
		<td width="700">
			<table width="700" role="presentation">
				
				
				<tr>
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />

						<p>This page shows what actions have been performed by the geo security officer.  
						Press continue to go back to User maintenance.</p>

						<html:form action="/protect/CancelAction.wss">
							<%
									ArrayList activityLog = view.getActivityLog();
									if(null != activityLog && 0 < activityLog.size()){
							%>
							<table class="ibm-data-table ibm-alternating" border="0" width="700" cellspacing="1" cellpadding="1" summary="Activity Log">
								<tr  class="ibm-data-table ibm-alternating" style="background-color:#cccccc;" class="dark">
									
									<th width="200" id="userId" align="left">User Id</th>
									<th width="200" id="message" align="left">Message</th>
									<th width="150" id="activityDate" align="left">Activity Date</th>
									<th width="150" id="activityTime" align="left">Activity Time</th>
									
									
							 
								</tr>
								
							<%
										for(int i=0, size=activityLog.size(); i<size; i++){
											ActivityLogDataBean data = (ActivityLogDataBean)activityLog.get(i);
											if(null != data){
												if((i % 2) == 1) {
							%>						<tr class="white">
						    <%      	 	    }
												else {
							%>		  		        <tr class="gray">
                            <%                  }
					        %>		
					        		<td valign="bottom" headers="userId"><%=data.getUserId()%></td>
									<td valign="bottom" headers="message"><%=data.getMessage()%></td>
									<td valign="bottom" headers="activityDate"><%=data.getActivityDate()%></td>
									<td valign="bottom" headers="activityTime"><%=data.getActivityTime()%></td>
									
									</tr>
							
							<%				
											}
										}
							%>
							
							</table>
							<%
									}
									else{
							%>
								<p><%=com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants.NO_ACTIVITY_LOG_FOR_USER %></p>
							<%
									}
							%>
							&nbsp;<br />
							<table align="right" border="0" cellspacing="0" cellpadding="0" summary="layout">
								<tr>
									<td align="left"><oppt:button id="continue" name="multipleButtonManager.continue" alt="Continue" primary="true" value="Continue" /></td>
								</tr>
							</table>
						</html:form>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
<!-- start content head -->
		<div id="ibm-content-head">


		</div> 
    	<!-- stop content head -->


	<div id="ibm-content-main">
		
	</div>

</div>


