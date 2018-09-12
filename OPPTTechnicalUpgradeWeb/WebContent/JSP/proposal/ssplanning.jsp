
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SSPlanningViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	TreeMap mainList = null;
	TreeMap leftList=null;
	TreeMap rightList=null;
	
	String eswPrice="";
	String calculatedPrice="";
	String discountPercent="";
	String altPrice="";
	String selectedId="";
	ArrayList buttonFlags = null;
	ErrorReport errorReport = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	SSPlanningViewBean viewBean = (SSPlanningViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		mainList = viewBean.getSAndSEEMap();
		leftList = viewBean.getLeftDataTree();
		rightList = viewBean.getRightDataTree();
		eswPrice = viewBean.getESWPrice();
		calculatedPrice = viewBean.getCalculatedPrice();
		discountPercent = viewBean.getDiscountPercent();
		altPrice = viewBean.getAlternatePrice();
		selectedId = viewBean.getSelectedId();
		
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>S&amp;S planning</em></p>		
		</div>
	</div>	

<div id="ibm-content-body">
<table role="presentation" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td width="600">
			<table role="presentation" width="600">
				
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />
						
						<p>Use this page to update discount amount for s&amp;s licenses. When you are 
						finished, click the Apply button. Press the Clear all button to discard your 
						changes. Press the Cancel button to go back to proposal details page.</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
&nbsp; <br />
<table summary="SSPlanning" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr valign="top">
		<td>
			<html:form action="protect/SSPlanningMultipleAction.wss">
				<table cellspacing="0" cellpadding="0" border="0" width="600">
					<tr>
						<td style=background-color:#cccccc;  class="bar-blue-med" width="200" height="18">&nbsp;&nbsp; S&amp;S planner</td>
						<td style=background-color:#cccccc;  class="bar-blue-med" width="225" height="18">&nbsp;&nbsp; </td>
						<td style=background-color:#cccccc;  class="bar-blue-med" width="175" height="18">&nbsp;&nbsp; </td>
					</tr>
				</table>
				&nbsp; <br />
				<table role="presentation" cellspacing="0" cellpadding="0" border="0" width="600">
					<tr>
						<td align="left">
							<label for="SwoEeNo">&nbsp;&nbsp;SWO no/SWO Sl no - EE no</label> &nbsp;&nbsp; 
						<oppt:select name="swoList" id="SwoEeNo" style="iform" options="<%=mainList%>" selectedOption="<%=selectedId%>"  title="Select SWO no/SWO Sl no - EE no" />&nbsp;&nbsp; 
						<span class="button-blue"><input type="submit" id="go" name="multipleButtonManager.go" value="Go"  primary="true"  alt="Go"/></span>
						</td>						
					</tr>
				</table>
				&nbsp; <br />
				<table cellspacing="1" cellpadding="1" border="0" width="600" summary="S&S Planner">
					<tr>
						<th width="170" height="18" align="left"><label for="eswPrice">&nbsp;&nbsp;ESW price (Annual)</label></th>
						<th width="170" height="18" align="left"><label for="altPrice">Alt Price (Annual)</label></th>
						<th width="90" height="18" align="left"><label for="discount">Discount</label></th>
						<th width="170" height="18" align="left"><label for="calculatedSAndSPrice">Calculated S&amp;S price</label></th>
					</tr>
					<tr>
						<td width="170" height="18">&nbsp;&nbsp;<oppt:text styleId="eswPrice" name="eswprice" readonly="true"  value="<%=eswPrice%>" size="20" /></td>
						<td width="170" height="18"><oppt:text styleId="altPrice" size="20" name="altprice" value="<%=altPrice%>" readonly="true"/></td>
						<td width="90" height="18"><oppt:text styleId="discount" size="5" maxlength="5" name="discount" value="<%=discountPercent%>" readonly="false"/> %</td>
						<td width="170" height="18"><oppt:text styleId="calculatedSAndSPrice" size="20" name="calcprice" value="<%=calculatedPrice%>" readonly="true"/></td>
					</tr>
					
				</table>
				&nbsp; <br />
				<table summary="leftSelectData" cellspacing="0" cellpadding="0" border="0" width="600">
					<tr>
						<td width="280" align="left" rowspan="2"><label for="leftSelectData">&nbsp;&nbsp;SWO no/SWO Sl no - EE no</label>
							<select name="leftSelectData" size="7" id="leftSelectData" multiple="multiple" style="width:95%">
					<%
						if(null != leftList)
						{
							Iterator itr = leftList.keySet().iterator();
							while(itr.hasNext())
							{
								String key = (String)itr.next();
								String value = (String)leftList.get(key);
					%>
								<option value="<%=key%>"><%=value%></option>
					<%
							}
						}
					%>
							</select>
						</td>
						<td width="40" align = "center">&nbsp;&nbsp;
							<span class="button-blue"><input type="submit" id="leftToRight" name="multipleButtonManager.leftToRight" value="Move right"  primary="true"  alt="Move right" style="width:7em;"/></span>	 								 
						</td>
						<td width="280" align="left" rowspan="2"> <label for="rightSelectData">&nbsp;&nbsp;SWO no/SWO Sl no - EE no</label>
						
						<select name="rightSelectData" size="7" id="rightSelectData" multiple="multiple" style="width:95%">
					<%
						if(null != rightList)
						{
							Iterator itr = rightList.keySet().iterator();
							while(itr.hasNext())
							{
								String key = (String)itr.next();
								String value = (String)rightList.get(key);
					%>
								<option value="<%=key%>"><%=value%></option>
					<%
							}
						}
					%>
						</select>
						</td>
					</tr>
					<tr>
						<td width="40" align = "center">&nbsp;&nbsp;
						 
							<span class="button-blue"><input type="submit" id="rightToLeft" name="multipleButtonManager.rightToLeft" value="Move left"  primary="true"  alt="Move left" style="width:7em;"/></span>	 								 	 
						</td>
					</tr>
				</table>
				&nbsp; <br />
				<table align="right">
					<tr>
						<td>					
							<oppt:button id="apply" name="multipleButtonManager.apply" primary="true" alt="Apply" value="Apply" />
							<oppt:button id="clearAll" name="multipleButtonManager.clearAll" primary="true" alt="Clear all" value="Clear all" />
							<oppt:button id="cancel" name="multipleButtonManager.cancel" primary="true" alt="Cancel" value="Cancel" />
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

