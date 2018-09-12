<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UnfetchdSelectedInvViewbean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO" %>
<%@page import="java.util.List"%>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	UnfetchdSelectedInvViewbean view = (UnfetchdSelectedInvViewbean)opptSession.getCurrentViewBean();
	if(null == view){
		return;
	}
	ErrorReport errorReport = view.getErrorReport();
%>

<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				Proposal maintenance</h1>

<p ><em><br>Inventory Selection</em></p>		
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

						<p>These are the un matched search details.
						   Press Cancel button to go back to selected customers search page.
						   Press Continue button to retrieve the inventory for the proposal.
						</p>
					</td>
				</tr>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

<html:form action="/protect/CreateProposalMultipleAction.wss">
	<%
    	InventoryCustomDTO InventoryCustomDTO1 = (InventoryCustomDTO)view.getCustomDTOdata();
    	List errcustomers = InventoryCustomDTO1.getErrListData();
	         int noOfCustomers=errcustomers.size();
	         Integer cnt= new Integer(noOfCustomers);
	         //out.println("num of customers unmatched"+noOfCustomers);
	      //   request.setAttribute("CNT",cnt);
	        // session.setAttribute("CNT",cnt);
	         if(null != errcustomers){
			 Iterator iterator = errcustomers.iterator();
			  //out.println("&&&&&&customers::::"+errcustomers);
			 while(iterator.hasNext()){
			 InventoryCustomDTO errcustomer = (InventoryCustomDTO)iterator.next();
			 	 String strdesgmachId = new String();
			 	 String strMaterialId = new String();
			 	 String strSerialId = new String();
			 	 Iterator commonIter = null;
				if(null != errcustomer){
				String errcustomernumber =errcustomer.getErrCustomersList();
				//out.println("customernumber ::"+errcustomernumber);
				List errDesigMachineId = errcustomer.getErrDesignatedMachineID(); /*list 1*/
				List errMaterialId = errcustomer.getErrMaterialID();             /*list 2*/
				List errSerialNumber = errcustomer.getErrSerialNumber();        /*list 3*/
				if(errDesigMachineId.size() >0)
				{
			 		commonIter = errDesigMachineId.iterator();
			 		
			 		while(commonIter.hasNext()){
			 			strdesgmachId+=",";
			 			strdesgmachId+=(String)commonIter.next();
			 		}
			 		strdesgmachId = strdesgmachId.substring(1);
			 	}
			 	
			 	if(errMaterialId.size() >0)
				{
			 		commonIter = errMaterialId.iterator();
			 		
			 		while(commonIter.hasNext()){
			 			strMaterialId+=",";
			 			strMaterialId+=(String)commonIter.next();
			 		}
			 		strMaterialId = strMaterialId.substring(1);
			 	}
			 	
			 	if(errSerialNumber.size()>0)
				{
			 		commonIter = errSerialNumber.iterator();
			 		
			 		while(commonIter.hasNext()){
			 			strSerialId+=",";
			 			strSerialId+=(String)commonIter.next();
			 		}
			 		strSerialId = strSerialId.substring(1);
			 	}	
	%>
	   <input type="hidden" name="cnt" value="<%=cnt%>">  
		<table border="0" width="400" cellspacing="1" cellpadding="1" summary="Enterprise information">
		<tr>
			<th align="left" width="250"  >Customer number</th>
			<th align="left" width="250" ><%=errcustomer.getErrCustomersList()%></th>
		</tr>
		<%if(!"".equalsIgnoreCase(strdesgmachId) && strdesgmachId!=null){ %>
		<tr><td align="left">Desg.mach</td><td><%= strdesgmachId %></td></tr>
		<%}if(!"".equalsIgnoreCase(strMaterialId) && strMaterialId!=null){ %>
        <tr><td align="left">SWO no</td><td><%= strMaterialId %></td></tr>
        <%}if(!"".equalsIgnoreCase(strSerialId) && strSerialId!=null){ %>
        <tr><td align="left">SWO Sl no</td><td><%= strSerialId %></td></tr>
        <%}%>
</table>
<br/>
	<%
				}
			}
			%>
			
		
				</br>
				</br>
				<%
		}
		else
		{
//out.println("Hai Dara Control Not in  IF");
		}
	%>
	&nbsp;<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<table align="right" border="0" cellspacing="0" cellpadding="0" role="presentation">
	     <tr>
		<td><oppt:button id="unselectcancel" name="multipleButtonManager.unselectcancel" alt="unselectcancel"
				value="Cancel" primary="true" /></td>
		<td>&nbsp;</td>
		
			<td><oppt:button id="unselectcontinue" name="multipleButtonManager.unselectcontinue" alt="unselectcontinue"
				value="Continue" primary="true" /></td>
				
		</tr>
		<tr>
			<td>&nbsp;</td>
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

