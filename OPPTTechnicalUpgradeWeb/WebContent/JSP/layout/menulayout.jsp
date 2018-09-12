
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants"%>
<%
	OPPTSession opptSession = new OPPTSession(session);
    UserInfoDataBean userInfoDataBean = opptSession.getUserInfo();
    String userType = "";
    int role = 0;

    if(userInfoDataBean != null)
    {
	    userType = userInfoDataBean.getUserType();
    	role = userInfoDataBean.getBaRole(); 
    }	
 %>
 <div id="ibm-navigation" role="navigation" aria-label="Content navigation" style="margin: 5px 0 0 -100%;">
 <h3 class="ibm-access">Content navigation</h3>
<ul id="ibm-primary-links">	
 
<%-- Push component attributes in page context --%>
<tiles:importAttribute />
<%-- Check if selected exist. --%>
<logic:notPresent name="selected">
	<% pageContext.setAttribute("selected", ""); %>
</logic:notPresent>
 <!--BEGIN SITE NAV-->


	<%-- Prepare the links list to be iterated --%>
	<bean:define id="links" name="links" type="java.util.List" scope="page" />
	<% Iterator itemLink = links.iterator(); 
    %>
	<%-- iterate on items list --%>
	<logic:iterate id="iterateItem" name="items" >
		<bean:define id="item" name="iterateItem" type="java.lang.String" scope="page" />
		<% 
			String link = (String)itemLink.next();
		%>
			<%--Check if selected link is an sublink --%>
			<logic:present name="selectedSubLink">
				<logic:notEqual name="selected" value="<%=item%>">
					<logic:equal name="item" value="BH-OPPT">
					<li id= "ibm-overview">	<a id="site-home" href="<%=link %>"><%=item%></a></li>
					</logic:equal>
					<logic:notEqual name="item" value="BH-OPPT">
						<li><a href="<%=link %>"><%=item%></a></li>
					</logic:notEqual>
				</logic:notEqual>
				<logic:equal name="selected" value="<%=item%>">
					<logic:equal name="item" value="BH-OPPT">
						<li><div class="second-level"><a href="<%=link %>"><%=item%></a></div></li>
					</logic:equal>
					<logic:notEqual name="item" value="BH-OPPT">
						<li><a class="open" href="<%=link %>"><%=item%></a></li>
					</logic:notEqual>
				</logic:equal>
			</logic:present>
			
			<logic:notPresent name="selectedSubLink">
				<%-- check if link selected --%>
				<logic:notEqual name="selected" value="<%=item%>">
					<logic:equal name="item" value="BH-OPPT">
					<li id ="ibm-overview">	<a id="site-home" href="<%=link %>"><%=item%></a></li>
					</logic:equal>
					<logic:notEqual name="item" value="BH-OPPT">
                    <%  if(userType.equals(Constants.BASE_CONTRACT_USER) && role != (Constants.CREATE_UPDATE)  && (item.equals("Base agreement registration") || item.equals("Change history") || item.equals("Reports") || item.equals("CCMS customer selection"))) {
                    %>					
                    <% } else {
                    %>  <li><a href="<%=link %>"><%=item%></a></li>
                    <% }
                    %>                    						
					</logic:notEqual>
				</logic:notEqual>

				<logic:equal name="selected" value="<%=item%>">
					<logic:equal name="item" value="BH-OPPT">
					<li id= "ibm-overview"">	<a id="site-home" href="<%=link %>"><%=item%></a></li>
					</logic:equal>
					<logic:notEqual name="item" value="BH-OPPT">
						<li><a class="active" href="<%=link %>"><%=item%></a></li>
					</logic:notEqual>
				</logic:equal>
			</logic:notPresent>


		<logic:equal name="selected" value="<%=item%>">
			<logic:present name="sublinks">
				<bean:define id="sublinks" name="sublinks" type="java.util.List" scope="page" />
				<% Iterator subItemLink = sublinks.iterator(); %>
				<logic:iterate id="iterateSubItem" name="subitems" >
					<bean:define id="subitem" name="iterateSubItem" type="java.lang.String" scope="page" />
					<% 
						String sublink = (String)subItemLink.next();
					%>
					<logic:present name="selectedSubLink">
					
						<logic:notEqual name="selectedSubLink" value="<%=subitem%>">
								<li><div class="second-level"><a href="<%=sublink%>"><%=subitem%></a></div></li>
						</logic:notEqual>
						<logic:equal name="selectedSubLink" value="<%=subitem%>">
								<li><div class="second-level"><a class="active" href="<%=sublink%>"><%=subitem%></a></div></li>
						</logic:equal>
					</logic:present>
					<logic:notPresent name="selectedSubLink">
							<li><div class="second-level"><a href="<%=sublink%>"><%=subitem%></a></div></li>
					</logic:notPresent>
				</logic:iterate>
			</logic:present>
		</logic:equal>
	</logic:iterate>
</ul>

<div id="ibm-secondary-navigation" aria-label="Related links">
<h2>Site secured by</h2>
<id="ibm-related-links">
<a id="intrapasswd" class="ibm-secure-link" href="http://w3.ibm.com/profile/update/password/">
<h2>IBM intranet password</h2>
</a>



</div>
</div>


