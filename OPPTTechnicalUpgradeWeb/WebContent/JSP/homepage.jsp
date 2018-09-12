
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/oppt-tags.tld" prefix="oppt" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="javax.servlet.http.Cookie" %>


<%
	Enumeration headerNames = request.getHeaderNames();
	while(headerNames.hasMoreElements()) {
		String headerName = (String)headerNames.nextElement();
		String headerValue = (String)request.getHeader(headerName);
	}
	Cookie cookie [] = request.getCookies();
	if(cookie != null) {
		for(int k = 0;k<cookie.length;k++) {
		}
	}
 %>

 <div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body">
				<h1><br>
				BH-OPPT</h1>		
		</div>
	</div>	
	
<div id="ibm-content-body">
		<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="660" >
	<tr valign="top">
		<td width="660">
			<html:form action="/protect/SubmitSignIn.wss">
			<table width="660" role="presentation">
				<tr>
				
 					
					
				</tr>
				

				<tr>
					<td>
							<strong>Blue Harmony Offering Proposal &amp; Planning Tool</strong> (BH-OPPT) is IBM's intranet application used to support the recurring
							 portion (MLC and/or S&S) of System-z software offerings. Within BH-OPPT, a user may prepare, create and manage system
							  proposals/contracts for the recurring System-z software. 
							  &nbsp;
							  <br>
                           <br>
							OPPT supports recurring System-z software in IBM offerings, such as: 
                           
							<ul>
								<li><strong>EAS</strong> (Enterprise Agreement for S/390 Software)</li>
								<li><strong>ELA</strong> (Enterprise License Agreement)</li>
								<li><strong>OIO</strong> (Open Infrastructure Offering)</li>
								<li><strong>EGO</strong> (Enterprise Growth Offering)</li>
								<li><strong>NUEV</strong> (Nutzungs UEberlassungs Vertrag).</li>
							</ul>
							
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
				        <td><div class="ibm-alternate-rule">&nbsp;<hr/></div></td>
			    </tr>
		        <tr>
		             <td> <div class="button-bar">        
				             <div class="buttons" align="right">
								<oppt:button id="continue"  onclick="alert('DISCLAIMER--By accessing this tool, you agree that your personal information as available in the Enterprise Directory, will be used in the processing of contracts in \n OPPT iERP application. The use of this information is limited to the processing of OPPT iERP contracts. Access to this information is limited to authorized people, including IBM employees and Contractors, who work with this application and its infrastructure.')" name="multipleButtonManager.continue" alt="continue" value="Continue" primary="true" />
				             </div>
                           </div>
                    </td>
               </tr>
			</table>
			</html:form>
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
		<!-- LEADSPACE_BEGIN -->
		
		<!-- LEADSPACE_END -->
		
		
		
		
	</div>

</div>



