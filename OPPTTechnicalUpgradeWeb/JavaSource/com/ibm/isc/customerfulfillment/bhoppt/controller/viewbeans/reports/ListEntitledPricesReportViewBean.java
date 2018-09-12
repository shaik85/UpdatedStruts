/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.*;

import org.w3c.dom.*;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;

/**
 * Holds complete data required for list entitled prices report  
 * 
 * <br/><strong>Known Bugs</strong><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ListEntitledPricesReportViewBean extends ReportViewBean
{
	/**
     * convertToDOM
     * 
     * @param listEntitledPricesReportCustomDTO
     * @author thirumalai
     */
    private void convertToDOM(ListEntitledPricesReportCustomDTO listEntitledPricesReportCustomDTO)
	{

		Document document = createDocument();

		Element root = (Element) document.createElement("listentitledpricesreport");

		document.appendChild(root);

		ListEntitledPricesRptDomainDTO listEntitledPricesRptDomainDTO =
			listEntitledPricesReportCustomDTO.getReportDTO();

		addChildNode(
			document,
			root,
			"reportprinteddate",
			formatDate(listEntitledPricesRptDomainDTO.getRptPrintedDate()));
		addChildNode(document, root, "pricedasof", formatDate(listEntitledPricesRptDomainDTO.getPricesAsOf()));
		addChildNode(
			document,
			root,
			"contractstartdate",
			formatDate(listEntitledPricesRptDomainDTO.getContractStartDate()));
		addChildNode(
			document,
			root,
			"contractenddate",
			formatDate(listEntitledPricesRptDomainDTO.getContractEndDate()));
		if(checkForNull(listEntitledPricesRptDomainDTO.getExternalContractNumber()).equals("-")) {
			addChildNode(document,root,"externalcontractnumber",checkForNull(listEntitledPricesRptDomainDTO.getContractNumber()));
		}
		else {
			addChildNode(document,root,"externalcontractnumber",checkForNull(listEntitledPricesRptDomainDTO.getExternalContractNumber()));
		}
		
		addChildNode(document, root, "currency", checkForNull(listEntitledPricesRptDomainDTO.getCurrency()));

		addChildNode(
			document,
			root,
			"totallistprice",
			parseAmount(listEntitledPricesRptDomainDTO.getTotalListPrice()));
			
		addChildNode(
			document,
			root,
			"totalentitledprice",
			parseAmount(listEntitledPricesRptDomainDTO.getTotalEntitledPrice()));
					

		/*	For MLC details	*/
		List customerLists = listEntitledPricesRptDomainDTO.getCustomerDomainDTOList();
		int custCount = 0;
		
		if(listEntitledPricesRptDomainDTO.getProposalContent().equals("M") || listEntitledPricesRptDomainDTO.getProposalContent().equals("A")) {

			if (null != customerLists)
			{
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext())
				{
					ListEntitledPricesRptCustomerDomainDTO customerDomainDTO = new ListEntitledPricesRptCustomerDomainDTO();
					customerDomainDTO = (ListEntitledPricesRptCustomerDomainDTO) customerListsIterator.next();
					
					List dmLists = customerDomainDTO.getDMDomainDTOList();
					
					if (null != dmLists && dmLists.size() > 0)
					{
						Node customerNode = document.createElement("customer");
						root.appendChild(customerNode);
						String soldToPartyASNO = checkForNull(customerDomainDTO.getAsNo());
						String soldToPartyLegNo = checkForNull(customerDomainDTO.getLegNo());
						String soldToParty = null;
						if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-"))
							soldToParty = "-";
						else if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-")))
							soldToParty = soldToPartyASNO;
						else if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-"))
							soldToParty = soldToPartyLegNo;
						else
							soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
			
						addChildNode(
							document,
							customerNode,
							"legacycustomernumber",
						    soldToParty);
						    
						if(custCount==0) {
							customerDomainDTO.setCustType("M");
							custCount++;
						}
						addChildNode(
							document,
							customerNode,
							"custtype",
						checkForNull(customerDomainDTO.getCustType()));
		
						addChildNode(
							document,
							customerNode,
							"totalentitledprice",
							parseAmount(customerDomainDTO.getTotalEntitledPrice()));
		
						addChildNode(
							document,
							customerNode,
							"totallistprice",
							parseAmount(customerDomainDTO.getTotalListPrice()));

				
						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext())
						{
							Node dmNode = document.createElement("dm");
							customerNode.appendChild(dmNode);

							ListEntitledPricesRptDMDomainDTO dmDomainDTO = (ListEntitledPricesRptDMDomainDTO) dmListIterator.next();

							addChildNode(document, dmNode, "dmnumber", checkForNull(dmDomainDTO.getDesgMcNo()));

							addChildNode(
								document,
								dmNode,
								"totalentitledprice",
								parseAmount(dmDomainDTO.getTotalEntitledPrice()));

							addChildNode(
								document,
								dmNode,
								"totallistprice",
								parseAmount(dmDomainDTO.getTotalListPrice()));
	
							List swoLists = dmDomainDTO.getSWODomainDTOList();
							if (null != swoLists)
							{
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext())
								{
									Node swoNode = document.createElement("swo");
									dmNode.appendChild(swoNode);
	
									ListEntitledPricesRptSWODomainDTO swoDomainDTO = (ListEntitledPricesRptSWODomainDTO) swoListsIterator.next();
	
									addChildNode(
										document,
										swoNode,
										"swonumber",
										checkForNull(swoDomainDTO.getSWONo()));
									addChildNode(
										document,
										swoNode,
										"swodescription",
										checkForNull(swoDomainDTO.getDescription()));
									addChildNode(
										document,
										swoNode,
										"serialnumber",
										checkForNull(swoDomainDTO.getSerialNo()));
	
									List swoEELists = swoDomainDTO.getSWOEEDomainDTOList();
									if (null != swoEELists)
									{
										Iterator swoEEListsIterator = swoEELists.iterator();
										while (swoEEListsIterator.hasNext())
										{
											Node eeNode = document.createElement("ee");
											swoNode.appendChild(eeNode);

											ListEntitledPricesRptSWOEEDomainDTO swoEEDomainDTO = (ListEntitledPricesRptSWOEEDomainDTO) swoEEListsIterator.next();
	
											addChildNode(
												document,
												eeNode,
												"quantity",
												checkForNull(swoEEDomainDTO.getUseLevel()));
											addChildNode(
												document,
												eeNode,
												"valuemetric",
												checkForNull(swoEEDomainDTO.getValueMetric()));
											addChildNode(
												document,
												eeNode,
												"eenumber",
												checkForNull(swoEEDomainDTO.getEENo()));
											addChildNode(
												document,
												eeNode,
												"eedescription",
												checkForNull(swoEEDomainDTO.getDescription()));
	
											addChildNode(
												document,
												eeNode,
												"listprice",
												parseAmount(swoEEDomainDTO.getListPrice()));
											addChildNode(
												document,
												eeNode,
												"entitledprice",
												parseAmount(swoEEDomainDTO.getESWPrice()));
											addChildNode(
												document,
												eeNode,
												"alternateprice",
												parseAmount(swoEEDomainDTO.getAlternatePrice()));
											addChildNode(
												document,
												eeNode,
												"deltalist",
												parseAmount(swoEEDomainDTO.getDeltaList()));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		/*	Set for S&S details	*/
		if(listEntitledPricesRptDomainDTO.getProposalContent().equals("S") || listEntitledPricesRptDomainDTO.getProposalContent().equals("A")) {
			customerLists = listEntitledPricesRptDomainDTO.getSSCustomerDomainDTOList();
			custCount = 0;
			
			if (null != customerLists)
			{
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext())
				{
					ListEntitledPricesRptCustomerDomainDTO customerDomainDTO = new ListEntitledPricesRptCustomerDomainDTO();
					customerDomainDTO = (ListEntitledPricesRptCustomerDomainDTO) customerListsIterator.next();
					
					List dmLists = customerDomainDTO.getSSDmDomainTO();
					
					if (null != dmLists && dmLists.size() > 0)
					{
						Node customerNode = document.createElement("customer");
						root.appendChild(customerNode);
						
						String soldToPartyASNO = checkForNull(customerDomainDTO.getAsNo());
						String soldToPartyLegNo = checkForNull(customerDomainDTO.getLegNo());
						String soldToParty = null;
						if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-"))
							soldToParty = "-";
						else if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-")))
							soldToParty = soldToPartyASNO;
						else if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-"))
							soldToParty = soldToPartyLegNo;
						else
							soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
			
						addChildNode(
							document,
							customerNode,
							"legacycustomernumber",
							soldToParty);
						    
						if(custCount==0) {
							customerDomainDTO.setCustType("S");
							custCount++;
						}
						addChildNode(
							document,
							customerNode,
							"custtype",
						checkForNull(customerDomainDTO.getCustType()));
		
						addChildNode(
							document,
							customerNode,
							"totalentitledprice",
							parseAmount(customerDomainDTO.getTotalEntitledPrice()));
		
						addChildNode(
							document,
							customerNode,
							"totallistprice",
							parseAmount(customerDomainDTO.getTotalListPrice()));

				
						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext())
						{
							Node dmNode = document.createElement("dm");
							customerNode.appendChild(dmNode);

							ListEntitledPricesRptDMDomainDTO dmDomainDTO = (ListEntitledPricesRptDMDomainDTO) dmListIterator.next();

							addChildNode(document, dmNode, "dmnumber", checkForNull(dmDomainDTO.getDesgMcNo()));

							addChildNode(
								document,
								dmNode,
								"totalentitledprice",
								parseAmount(dmDomainDTO.getTotalEntitledPrice()));

							addChildNode(
								document,
								dmNode,
								"totallistprice",
								parseAmount(dmDomainDTO.getTotalListPrice()));
	
							List swoLists = dmDomainDTO.getSSSWODomainDTOList();
							if (null != swoLists)
							{
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext())
								{
									Node swoNode = document.createElement("swo");
									dmNode.appendChild(swoNode);
	
									ListEntitledPricesRptSWODomainDTO swoDomainDTO = (ListEntitledPricesRptSWODomainDTO) swoListsIterator.next();
	
									addChildNode(
										document,
										swoNode,
										"swonumber",
										checkForNull(swoDomainDTO.getSWONo()));
									addChildNode(
										document,
										swoNode,
										"swodescription",
										checkForNull(swoDomainDTO.getDescription()));
									addChildNode(
										document,
										swoNode,
										"serialnumber",
										checkForNull(swoDomainDTO.getSerialNo()));
	
									List swoEELists = swoDomainDTO.getSWOEEDomainDTOList();
									if (null != swoEELists)
									{
										Iterator swoEEListsIterator = swoEELists.iterator();
										while (swoEEListsIterator.hasNext())
										{
											Node eeNode = document.createElement("ee");
											swoNode.appendChild(eeNode);

											ListEntitledPricesRptSWOEEDomainDTO swoEEDomainDTO = (ListEntitledPricesRptSWOEEDomainDTO) swoEEListsIterator.next();
	
											addChildNode(
												document,
												eeNode,
												"quantity",
												checkForNull(swoEEDomainDTO.getUseLevel()));
											addChildNode(
												document,
												eeNode,
												"valuemetric",
												checkForNull(swoEEDomainDTO.getValueMetric()));
											addChildNode(
												document,
												eeNode,
												"eenumber",
												checkForNull(swoEEDomainDTO.getEENo()));
											addChildNode(
												document,
												eeNode,
												"eedescription",
												checkForNull(swoEEDomainDTO.getDescription()));
	
											addChildNode(
												document,
												eeNode,
												"listprice",
												parseAmount(swoEEDomainDTO.getListPrice()));
											addChildNode(
												document,
												eeNode,
												"entitledprice",
												parseAmount(swoEEDomainDTO.getESWPrice()));
											addChildNode(
												document,
												eeNode,
												"alternateprice",
												parseAmount(swoEEDomainDTO.getAlternatePrice()));
											addChildNode(
												document,
												eeNode,
												"deltalist",
												parseAmount(swoEEDomainDTO.getDeltaList()));
										}
									}
								}
							}
						}
					}
				}
			}
		}			
	}
	
	/**
     * convertToHTML
     * 
     * @param listEntitledPricesReportCustomDTO
     * @author thirumalai
     */
    public void convertToHTML(ListEntitledPricesReportCustomDTO listEntitledPricesReportCustomDTO){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<style>\n");
		buffer.append(".heading.content\n");
		buffer.append(".cellHeading {background-color:#ffffff;vertical-align:top;height:19px}\n");
		buffer.append(".cellContent {background-color:#ffffff;vertical-align:bottom;height:19px}\n");
		buffer.append("</style>\n");
		
		ListEntitledPricesRptDomainDTO listEntitledPricesReportDomainDTO = listEntitledPricesReportCustomDTO.getReportDTO();

		buffer.append("<table width=\"1280\" border=\"0\">");
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><p style=\"color:red;\">IBM Confidential</p></td></tr>\n");
		buffer.append("<tr rowspan=\"2\"><td  colspan=\"36\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td></tr>");
		buffer.append("<tr><td  colspan=\"36\"  align=\"center\" valign=\"top\" height=\"29\"><strong>List / Entitled Prices report</strong></td></tr>");
		buffer.append("<tr><td  colspan=\"36\"  align=\"left\" class=\"cellContent\"><strong>  Report printed : "+formatDate(listEntitledPricesReportDomainDTO.getRptPrintedDate())+" </strong></td></tr>");
		buffer.append("<tr><td  colspan=\"36\"  align=\"left\" class=\"cellContent\"><strong>	Prices as of : "+formatDate(listEntitledPricesReportDomainDTO.getPricesAsOf())+" </strong></td></tr>");
		buffer.append("<tr><td  colspan=\"36\"  align=\"center\" class=\"cellContent\">Contract period : "+formatDate(listEntitledPricesReportDomainDTO.getContractStartDate())+" - "+formatDate(listEntitledPricesReportDomainDTO.getContractEndDate())+" </td></tr>");

		String value = null;
		if(checkForNull(listEntitledPricesReportDomainDTO.getExternalContractNumber()).equals("-")) {
			value = checkForNull(listEntitledPricesReportDomainDTO.getContractNumber());
		}
		else {
			value = checkForNull(listEntitledPricesReportDomainDTO.getExternalContractNumber());
		}

		buffer.append("<tr><td  colspan=\"36\"  align=\"center\" class=\"cellContent\">External contract number : "+value+" </td></tr>");
		buffer.append("<tr><td  colspan=\"36\"  align=\"center\" class=\"cellContent\">Currency : "+checkForNull(listEntitledPricesReportDomainDTO.getCurrency())+" </td></tr>");
		buffer.append("<tr><td  colspan=\"36\"  align=\"center\" class=\"cellContent\">&#160;</td></tr>");

		buffer.append("<tr><td  colspan=\"24\"  align=\"center\" class=\"cellContent\">&#160;</td>");
		buffer.append("<td  colspan=\"12\"  align=\"center\" class=\"cellContent\"><strong>Prices</strong></td></tr>");
				
		buffer.append("<tr>");
		buffer.append("<td colspan=\"5\" align=\"left\" class=\"cellHeading\"><strong>SAP Customer Nr</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Design. machine</strong></td>");
		buffer.append("<td colspan=\"3\" align=\"left\" class=\"cellHeading\"><strong>SW offering</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>SWO description</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Quantity/PG</strong></td>");
		buffer.append("<td colspan=\"3\" align=\"left\" class=\"cellHeading\"><strong>Value metric</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Entitlement entity</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Serial Nr.</strong></td>");
		buffer.append("<td colspan=\"3\" align=\"left\" class=\"cellHeading\"><strong>Description</strong></td>");
		buffer.append("<td colspan=\"3\" align=\"right\" class=\"cellHeading\"><strong>List</strong></td>");
		buffer.append("<td colspan=\"3\" align=\"right\" class=\"cellHeading\"><strong>Entitled</strong></td>");
		buffer.append("<td colspan=\"3\" align=\"right\" class=\"cellHeading\"><strong>Alternate</strong></td>");
		buffer.append("<td colspan=\"3\" align=\"right\" class=\"cellHeading\"><strong>Delta List / Entitled</strong></td>");
		buffer.append("</tr>");
		
	
		int custCount = 0;
		
		if(listEntitledPricesReportDomainDTO.getProposalContent().equals("M") || listEntitledPricesReportDomainDTO.getProposalContent().equals("A")) {
			List customerLists = listEntitledPricesReportDomainDTO.getCustomerDomainDTOList();
			if(null != customerLists && 0 < customerLists.size()){
				for(int i=0, size=customerLists.size(); i<size; i++){
					ListEntitledPricesRptCustomerDomainDTO customer = (ListEntitledPricesRptCustomerDomainDTO)customerLists.get(i);
					if(i==0) {
						buffer.append("<tr>\n");
						buffer.append("<td lotus_celltype=\"label\" colspan=\"6\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">\n");
						buffer.append("<strong>MLC products</strong>\n");
						buffer.append("</td>\n");
						buffer.append("</tr>\n");
					}
					buffer.append(getCustomer(customer,true));
				}
			}
		}

		if(listEntitledPricesReportDomainDTO.getProposalContent().equals("S") || listEntitledPricesReportDomainDTO.getProposalContent().equals("A")) {
			List customers = listEntitledPricesReportDomainDTO.getSSCustomerDomainDTOList();
			if(null != customers && 0 < customers.size()){
				for(int i=0, size=customers.size(); i<size; i++){
					ListEntitledPricesRptCustomerDomainDTO customer = (ListEntitledPricesRptCustomerDomainDTO)customers.get(i);
					if(i==0) {
						buffer.append("<tr>\n");
						buffer.append("<td lotus_celltype=\"label\" colspan=\"6\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">\n");
						buffer.append("<strong>S&amp;S products</strong>\n");
						buffer.append("</td>\n");
						buffer.append("</tr>\n");
					}
					buffer.append(getCustomer(customer,false));
				}
			}
		}

		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"24\" height=\"19\"><strong>Total price for contract attachment &#160;:</strong></td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>"+parseAmount(listEntitledPricesReportDomainDTO.getTotalListPrice())+"</strong></td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>"+parseAmount(listEntitledPricesReportDomainDTO.getTotalEntitledPrice())+"</strong></td>\n");
		buffer.append("</tr>\n");
			
		buffer.append("</table>\n");
		buffer.append("</table>\n");
				
		buffer.append("</center>\n");
		buffer.append("</body>\n");
		buffer.append("</html>\n");
	
		setDownloadContent(buffer.toString());
	}

	/**
     * getCustomer
     * 
     * @param customer
     * @param mlcProducts
     * @return
     * @author thirumalai
     */
    private String getCustomer(ListEntitledPricesRptCustomerDomainDTO customer, boolean mlcProducts){
		StringBuffer buffer = new StringBuffer();
		List dms = null;
		if(mlcProducts) {
			dms = customer.getDMDomainDTOList();	 
		}
		else {
			dms = customer.getSSDmDomainTO();
		}
	
		if(null != dms && 0 < dms.size()){
				
			String soldToPartyASNO = checkForNull(customer.getAsNo());
			String soldToPartyLegNo = checkForNull(customer.getLegNo());
			String soldToParty = null;
			String billToParty = null;
			String payer = null;
		
			if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-")) 
				soldToParty = "-";
			else
				if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-")))
					soldToParty = soldToPartyASNO;
				else
					if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-"))
						soldToParty = soldToPartyLegNo;
					else
						soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
			
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"5\" height=\"19\">"+soldToParty+"</td>\n");
			
			for(int dmCounter=0, dmSize=dms.size(); dmCounter<dmSize; dmCounter++){
				ListEntitledPricesRptDMDomainDTO listEntitledPricesRptDMDomainDTO = (ListEntitledPricesRptDMDomainDTO) dms.get(dmCounter);
			
				List swoLists = null;
			
				if(mlcProducts) {
					swoLists = listEntitledPricesRptDMDomainDTO.getSWODomainDTOList();
				}
				else {
					swoLists = listEntitledPricesRptDMDomainDTO.getSSSWODomainDTOList();
				}
				
				if(dmCounter != 0) {
					buffer.append("<tr>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"5\" height=\"19\"></td>\n");	
				}
			
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(listEntitledPricesRptDMDomainDTO.getDesgMcNo())+"</td>\n");
			
				if(null != swoLists && 0 < swoLists.size()){
					for(int swoCounter=0, swoSize=swoLists.size(); swoCounter<swoSize; swoCounter++){
						ListEntitledPricesRptSWODomainDTO listEntitledPricesRptSWODomainDTO = (ListEntitledPricesRptSWODomainDTO) swoLists.get(swoCounter);
					
						if(swoCounter != 0) {
							buffer.append("<tr>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"7\" height=\"19\"></td>\n");
						}
					
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(listEntitledPricesRptSWODomainDTO.getSWONo())+"</td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(listEntitledPricesRptSWODomainDTO.getDescription())+"</td>\n");
					
						List swoEELists = listEntitledPricesRptSWODomainDTO.getSWOEEDomainDTOList();
						if(null != swoEELists && 0 < swoEELists.size()){
							for(int swoEECounter=0, swoEESize=swoEELists.size(); swoEECounter<swoEESize; swoEECounter++){
								ListEntitledPricesRptSWOEEDomainDTO listEntitledPricesRptSWOEEDomainDTO = (ListEntitledPricesRptSWOEEDomainDTO) swoEELists.get(swoEECounter);
							
								if(swoEECounter != 0) {
									buffer.append("<tr>\n");
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"12\" height=\"19\"></td>\n");		
								}
								
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(listEntitledPricesRptSWOEEDomainDTO.getUseLevel())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(listEntitledPricesRptSWOEEDomainDTO.getValueMetric())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(listEntitledPricesRptSWOEEDomainDTO.getEENo())+"</td>\n");
								if(swoEECounter == 0) {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(listEntitledPricesRptSWODomainDTO.getSerialNo())+"</td>\n");	
								}
								else {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\"></td>\n");
								}
								
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(listEntitledPricesRptSWOEEDomainDTO.getDescription())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+parseAmount(listEntitledPricesRptSWOEEDomainDTO.getListPrice())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+parseAmount(listEntitledPricesRptSWOEEDomainDTO.getESWPrice())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+parseAmount(listEntitledPricesRptSWOEEDomainDTO.getAlternatePrice())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+parseAmount(listEntitledPricesRptSWOEEDomainDTO.getDeltaList())+"</td>\n");
							}
						}
					}
				}
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"24\" height=\"19\"><strong>Total price for designated machine&#160;:</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>"+parseAmount(listEntitledPricesRptDMDomainDTO.getTotalListPrice())+"</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>"+parseAmount(listEntitledPricesRptDMDomainDTO.getTotalEntitledPrice())+"</strong></td>\n");
				buffer.append("</tr>\n");
			}
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"24\" height=\"19\"><strong>Total price for customer no.&#160;:</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>"+parseAmount(customer.getTotalListPrice())+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>"+parseAmount(customer.getTotalEntitledPrice())+"</strong></td>\n");
			buffer.append("</tr>\n");
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"28\" height=\"19\">&#160;</td>\n");
			buffer.append("</tr>\n");
		}
		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");
		
		return buffer.toString();
	}	

	/**
     * ListEntitledPricesReportViewBean
     * 
     * @author thirumalai
     */
    public ListEntitledPricesReportViewBean()
	{
	}

	/**
     * ListEntitledPricesReportViewBean
     * 
     * @param listEntitledPricesReportCustomDTO
     * @param view
     * @author thirumalai
     */
    public ListEntitledPricesReportViewBean(
		ListEntitledPricesReportCustomDTO listEntitledPricesReportCustomDTO,
		String view)
	{
		convertToDOM(listEntitledPricesReportCustomDTO);
		super.setView(view);
	}
	
	/**
     * ListEntitledPricesReportViewBean
     * 
     * @param listEntitledPricesReportCustomDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public ListEntitledPricesReportViewBean(ListEntitledPricesReportCustomDTO listEntitledPricesReportCustomDTO, String view, boolean viewReport) {
		if(viewReport){
			convertToDOM(listEntitledPricesReportCustomDTO);
		}
		else{
			convertToHTML(listEntitledPricesReportCustomDTO);
		}
		super.setView(view);
	}
}