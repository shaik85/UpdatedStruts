<!-- Copyright (c) 2006 by IBM corporation -->
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession" %>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerInformationViewBean" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO" %>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>

<%
	OPPTSession opptSession = new OPPTSession(session); 
	PartnerInformationViewBean view = (PartnerInformationViewBean)opptSession.getCurrentViewBean();
	//FetchCustomersCustomDTO customers = (FetchCustomersCustomDTO)opptSession.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_CUSTOMERS);
	InventoryCustomDTO inventoryCustomDTO = (InventoryCustomDTO)view.getInventoryCustomDTO();
	Map desigMachList=new HashMap();
	Map materialList=new HashMap();
	Map serialNumList =new HashMap();
	List customers = view.getSelectedCustomers();
	opptSession.storeObjectToSession(SessionConstants.SELECTED_INVENTORY,customers);
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
				
					<td><b><p class="ibm-confidential">IBM Confidential</p></b></td>
				</tr>
				<tr>
					<td>
						<oppt:displayErrorReport errorReport="<%=errorReport%>" />

						<p>Press Fetch inventory button to retrieve the inventory for the proposal or press Fetch sel.inventory to retrieve selected SWOs only.</p>
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
    	
	         int noOfCustomers=customers.size();
	         Integer cnt= new Integer(noOfCustomers);
	      //   request.setAttribute("CNT",cnt);
	         session.setAttribute("CNT",cnt);
	         if(null != customers){
				String desgRow[][] = new String[noOfCustomers][5];
				String matRow[][]  =  new String[noOfCustomers][5];
				String serRow[][]  = new String[noOfCustomers][5];
				ArrayList desgtemp = new ArrayList();
				ArrayList mattemp = new ArrayList();
				ArrayList sertemp = new ArrayList();
				
	         	if(inventoryCustomDTO!=null){
					desigMachList = inventoryCustomDTO.getDesignatedMachineID();
					materialList = inventoryCustomDTO.getMaterialID();
					serialNumList = inventoryCustomDTO.getSerialNumber();
					
					for (int count = 0;count < noOfCustomers; count++) {
						desgtemp =  (ArrayList) desigMachList.get(new Integer(count));
						mattemp =  (ArrayList) materialList.get(new Integer(count));
						sertemp =  (ArrayList) serialNumList.get(new Integer(count));
						
						for (int col = 0; col < desgtemp.size();col++) {
							desgRow[count][col] =  (String)desgtemp.get(col);
							matRow[count][col]  = (String)mattemp.get(col);
							serRow[count][col] = (String)sertemp.get(col);
						}
					}
	         }
			 Iterator iterator = customers.iterator();
			 int row =0;
			 while(iterator.hasNext()){
			 CustomerListCustomDTO customer = (CustomerListCustomDTO)iterator.next();
	
				if(null != customers){%>
	   <input type="hidden" name="cnt" value="<%=cnt%>">  
	
	     <table  border="0" width="790" cellspacing="1" cellpadding="1" summary="Enterprise information">
		<tr>
			<th align="left" width="250" style=background-color:#cccccc;  class="bar-blue-med">Customer number</th>
			<th align="left" width="250" style=background-color:#cccccc;   class="bar-blue-med">Customer name</th>
			
		</tr>

		<tr>
			<td align="left" headers="customerListNumber">&nbsp;&nbsp;<%=customer.getCustomerNumber()%><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td align="left" headers="customerListName">&nbsp;&nbsp;<%=customer.getCustomerName() %><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
				</tr>
				<br><br>
			</table>
			
			<table border="0" width="400" cellspacing="1" cellpadding="1" role="presentation">
			<tr>
				<td style=background-color:#cccccc;  class="bar-blue-med" colspan="2" align="left"></td>
					<td style=background-color:#cccccc;  class="bar-blue-med" colspan="1" align="left">Material #1</td>
						<td style=background-color:#cccccc;  class="bar-blue-med" colspan="1" align="left">Material #2</td>
							<td style=background-color:#cccccc;  class="bar-blue-med" colspan="1" align="left">Material #3</td>
								<td style=background-color:#cccccc;  class="bar-blue-med" colspan="1" align="left">Material #4</td>
									<td style=background-color:#cccccc;  class="bar-blue-med" colspan="1" align="left">Material #5</td>
			</tr>
			<tr>
				<td style=background-color:#cccccc;  class="bar-blue-med" colspan="2" align="left">Desg.mach</td>
<% 				for (int col=0; col < 5;col++){	%>
				<td>
					<oppt:text name="DesignatedMachineID" styleClass="iform"  value="<%=desgRow[row][col]%>" maxlength="20" title = "DesignatedMachineID"/>
				</td>
<% 				}	%>			
			</tr>
			<tr>
				<td style=background-color:#cccccc;  class="bar-blue-med" colspan="2" align="left">SWO no</td>
<% 				for (int col=0; col < 5;col++){	%>
				<td>
					<oppt:text name="MaterialID" styleClass="iform"  value="<%=matRow[row][col]%>" maxlength="20" title = "DesignatedMachineID"/>
				</td>
<% 				}	%>			
			</tr>
			<tr>
				<td style=background-color:#cccccc;  class="bar-blue-med" colspan="2" align="left">SWO Sl no</td>
<% 				for (int col=0; col < 5;col++){	%>
				<td>
					<oppt:text name="SerialNumber" styleClass="iform"  value="<%=serRow[row][col]%>" maxlength="20" title = "DesignatedMachineID"/>
				</td>
<% 				}	%>	
			</tr>
</table>
	<% row++;
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

	&nbsp;<br />
	&nbsp;<br />
	<table border="0" cellspacing="1" cellpadding="1" width="800" summary="SAP Customer Number">
		<tr>
			<th align="left" width="107" id="partnerType" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;Partners</th>
			<th align="left" width="207" id="sapCustomerNumber" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;SAP Customer no.</th>
			<th align="left" width="277" id="name" style=background-color:#cccccc;  class="bar-blue-med">&nbsp;&nbsp;Name</th>
		</tr>
		<tr>
			<td valign="bottom" headers="partnerType">&nbsp;&nbsp;9E Partner:<br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="sapCustomerNumber">&nbsp;&nbsp;<oppt:label label="<%=view.getNineDPartnerNumber()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
			<td valign="bottom" headers="name">&nbsp;&nbsp;<oppt:label label="<%=view.getNineDPartnerName()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />
	<table width="800" border="0" cellspacing="0" cellpadding="0" role="presentation">
		<tr>
			<td align="left">&nbsp;&nbsp;Comments:</td>
		</tr>
		<tr>
			<td align="left">&nbsp;<oppt:label label="<%=view.getComments()%>" /><br />
			<div class="ibm-alternate-rule">&nbsp;</div></td>
		</tr>
	</table>
	&nbsp;<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<table align="right" border="0" cellspacing="0" cellpadding="0" role="presentation">
	     <tr>
			<td><oppt:button id="fetchselectedinventory" name="multipleButtonManager.fetchselectedinventory" alt="fetchselectedinventory"
				value="Fetch sel.inventory" primary="true" /></td>
		<td>&nbsp;</td>
		
			<td><oppt:button id="fetchinventoryaction" name="multipleButtonManager.fetchinventoryaction" alt="fetchinventoryaction"
				value="Fetch inventory" primary="true" /></td>
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

