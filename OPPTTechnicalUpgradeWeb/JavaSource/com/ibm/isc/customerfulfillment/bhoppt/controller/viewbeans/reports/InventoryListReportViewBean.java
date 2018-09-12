/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryListReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * Holds complete data required for inventory list report  
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

public class InventoryListReportViewBean extends ReportViewBean {

	private static final String CLASS_NAME="InventoryListReportViewBean";
	private void convertToDOM(InventoryListReportCustomDTO inventoryListReportCustomDTO) {
		String methodName="convertToDOM";
		Document document = null;
		DocumentBuilder builder = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
		}

		// Insert Root Order
		Element root = (Element) document.createElement("report");
		// Insert child Manifest
		document.appendChild(root);

		InventoryListRptDomainDTO inventoryListRptDomainDTO = inventoryListReportCustomDTO.getReportDTO();
		addChildNode(document, (Node) root, "reportprinteddate", formatDate(inventoryListRptDomainDTO.getRptPrintedDate()));
		addChildNode(document, (Node) root, "pricedasof", formatDate(inventoryListRptDomainDTO.getPriceAsOf()));
		addChildNode(document, (Node) root, "contractstartdate", formatDate(inventoryListRptDomainDTO.getContractStartDate()));
		addChildNode(document, (Node) root, "contractenddate", formatDate(inventoryListRptDomainDTO.getContractEndDate()));
		addChildNode(document, (Node) root, "tvmrate", "");
		addChildNode(document, (Node) root, "plannedgrowthrate", "");
		addChildNode(document, (Node) root, "proposalname", "");
		if(checkForNull(inventoryListRptDomainDTO.getExternalContractNumber()).equals("-")) {
			addChildNode(document, (Node) root, "contractnumber", checkForNull(inventoryListRptDomainDTO.getContractNumber()));
		}
		else {
			addChildNode(document, (Node) root, "contractnumber", checkForNull(inventoryListRptDomainDTO.getExternalContractNumber()));
		}
				
		addChildNode(document, (Node) root, "currency", checkForNull(inventoryListRptDomainDTO.getCurrency()));

		addChildNode(document, (Node) root, "totalprice", parseAmount(inventoryListRptDomainDTO.getTotalListPrice()));
		addChildNode(document, (Node) root, "billingfrequency", "");
		addChildNode(document, (Node) root, "annualinvoiceamount", "");
		addChildNode(document, (Node) root, "semiannualinvoiceamount", "");
		addChildNode(document, (Node) root, "quarterlyinvoiceamount", "");
		addChildNode(document, (Node) root, "monthlyinvoiceamount", "");
		
		/*	For MLC details	*/
		List customerLists = inventoryListRptDomainDTO.getCustomerDomainDTOList();
		
		int custCount = 0;
		
		if(inventoryListRptDomainDTO.getProposalContent().equals("M") || inventoryListRptDomainDTO.getProposalContent().equals("A")) {
			if (null != customerLists) {
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext()) {
				
					InventoryListRptCustomerDomainDTO inventoryListRptCustomerDomainDTO = new InventoryListRptCustomerDomainDTO(); 
					inventoryListRptCustomerDomainDTO = (InventoryListRptCustomerDomainDTO) customerListsIterator.next();
				
					List dmLists = inventoryListRptCustomerDomainDTO.getDMDomainDTOList();
					if (null != dmLists && dmLists.size() > 0) {
					
						Node customerNode = document.createElement("customer");
						root.appendChild(customerNode);
	
						String soldToPartyASNO = checkForNull(inventoryListRptCustomerDomainDTO.getASNO());
						String soldToPartyLegNo = checkForNull(inventoryListRptCustomerDomainDTO.getLegNo());
						String soldToParty = null;
						if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-"))
							soldToParty = "-";
						else if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-")))
							soldToParty = soldToPartyASNO;
						else if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-"))
							soldToParty = soldToPartyLegNo;
						else
							soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
	
	
						Node soldtopartyNode = document.createElement("soldtoparty");
						customerNode.appendChild(soldtopartyNode);
						addAttributeNode(document, soldtopartyNode, "id", soldToParty);
						addAttributeNode(document, soldtopartyNode, "name", "");
						
						if(custCount==0) {
							inventoryListRptCustomerDomainDTO.setCustType("M");
							custCount++;
						}
						addAttributeNode(document, soldtopartyNode, "custtype", checkForNull(inventoryListRptCustomerDomainDTO.getCustType()));
						
						
						addChildNode(document, customerNode, "billtoparty", "");
						addChildNode(document, customerNode, "payer", "");
		
						addChildNode(document, customerNode, "totalprice", parseAmount(inventoryListRptCustomerDomainDTO.getTotalListPrice()));
	
						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext()) {
							Node dmNode = document.createElement("dm");
							customerNode.appendChild(dmNode);
	
							InventoryListRptDMDomainDTO inventoryListRptDMDomainDTO = (InventoryListRptDMDomainDTO) dmListIterator.next();
	
							addAttributeNode(document, dmNode, "number", checkForNull(inventoryListRptDMDomainDTO.getDesgMcNo()));
							addChildNode(document, dmNode, "totalprice", parseAmount(inventoryListRptDMDomainDTO.getTotalListPrice()));
	
							List swoLists = inventoryListRptDMDomainDTO.getSWODomainDTOList();
							if (null != swoLists) {
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext()) {
									Node swoNode = document.createElement("swo");
									dmNode.appendChild(swoNode);
	
									InventoryListRptSWODomainDTO inventoryListRptSWODomainDTO = (InventoryListRptSWODomainDTO) swoListsIterator.next();
	
									addChildNode(document, swoNode, "number", checkForNull(inventoryListRptSWODomainDTO.getSWoNumber()));
									addChildNode(document, swoNode, "serialnumber", checkForNull(inventoryListRptSWODomainDTO.getSerialNumber()));
									if(checkForNull(inventoryListRptSWODomainDTO.getIndicator()).equals("V")) {
										addChildNode(document, swoNode, "indicator", "SVC");
									}
									else {
										addChildNode(document, swoNode, "indicator", "-");
									}
									
									addChildNode(document, swoNode, "plannedstartdate", "");
									addChildNode(document, swoNode, "plannedenddate", "");
									addChildNode(document, swoNode, "eswprice", "");
									addChildNode(document, swoNode, "alternateprice", "");
									addChildNode(document, swoNode, "calculatedprice", "");
	
									List swoEELists = inventoryListRptSWODomainDTO.getSWOEEDomainDTOList();
									if (null != swoEELists) {
										Iterator swoEEListsIterator = swoEELists.iterator();
										while (swoEEListsIterator.hasNext()) {
											Node eeNode = document.createElement("ee");
											swoNode.appendChild(eeNode);
	
											InventoryListRptSWOEEDomainDTO inventoryListRptSWOEEDomainDTO = (InventoryListRptSWOEEDomainDTO) swoEEListsIterator.next();
	
											addChildNode(document, eeNode, "desc", checkForNull(inventoryListRptSWOEEDomainDTO.getDescription()));
											addChildNode(document, eeNode, "valuemetricdesc", checkForNull(inventoryListRptSWOEEDomainDTO.getValueMetricDescription()));
											addChildNode(document, eeNode, "uselevel", checkForNull(inventoryListRptSWOEEDomainDTO.getUseLevel()));
											addChildNode(document, eeNode, "number", checkForNull(inventoryListRptSWOEEDomainDTO.getEENo()));
											addChildNode(document, eeNode, "eswprice", parseAmount(inventoryListRptSWOEEDomainDTO.getListPrice()));
											addChildNode(document, eeNode, "alternateprice", parseAmount(inventoryListRptSWOEEDomainDTO.getAlternatePrice()));
											addChildNode(document, eeNode, "calculatedprice", "");
											addChildNode(document, eeNode, "pletno", checkForNull(inventoryListRptSWOEEDomainDTO.getPletNo()));										
				  										
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
		
		if(inventoryListRptDomainDTO.getProposalContent().equals("S") || inventoryListRptDomainDTO.getProposalContent().equals("A")) {
			customerLists = inventoryListRptDomainDTO.getSSCustomerDomainDTOList();
			custCount = 0;
			
			if (null != customerLists) {
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext()) {
				
					InventoryListRptCustomerDomainDTO inventoryListRptCustomerDomainDTO = new InventoryListRptCustomerDomainDTO(); 
					inventoryListRptCustomerDomainDTO = (InventoryListRptCustomerDomainDTO) customerListsIterator.next();
				
					List dmLists = inventoryListRptCustomerDomainDTO.getSSDmDomainTO();
					if (null != dmLists && dmLists.size() > 0) {
					
						Node customerNode = document.createElement("customer");
						root.appendChild(customerNode);
	
						String soldToPartyASNO = checkForNull(inventoryListRptCustomerDomainDTO.getASNO());
						String soldToPartyLegNo = checkForNull(inventoryListRptCustomerDomainDTO.getLegNo());
						String soldToParty = null;
						if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-"))
							soldToParty = "-";
						else if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-")))
							soldToParty = soldToPartyASNO;
						else if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-"))
							soldToParty = soldToPartyLegNo;
						else
							soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
	
	
						Node soldtopartyNode = document.createElement("soldtoparty");
						customerNode.appendChild(soldtopartyNode);
						addAttributeNode(document, soldtopartyNode, "id", soldToParty);
						addAttributeNode(document, soldtopartyNode, "name", "");
						
						if(custCount==0) {
							inventoryListRptCustomerDomainDTO.setCustType("S");
							custCount++;
						}
						addAttributeNode(document, soldtopartyNode, "custtype", checkForNull(inventoryListRptCustomerDomainDTO.getCustType()));
						
						
						addChildNode(document, customerNode, "billtoparty", "");
						addChildNode(document, customerNode, "payer", "");
		
						addChildNode(document, customerNode, "totalprice", parseAmount(inventoryListRptCustomerDomainDTO.getTotalListPrice()));
	
						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext()) {
							Node dmNode = document.createElement("dm");
							customerNode.appendChild(dmNode);
	
							InventoryListRptDMDomainDTO inventoryListRptDMDomainDTO = (InventoryListRptDMDomainDTO) dmListIterator.next();
	
							addAttributeNode(document, dmNode, "number", checkForNull(inventoryListRptDMDomainDTO.getDesgMcNo()));
							addChildNode(document, dmNode, "totalprice", parseAmount(inventoryListRptDMDomainDTO.getTotalListPrice()));
	
							List swoLists = inventoryListRptDMDomainDTO.getSSSWODomainDTOList();
							if (null != swoLists) {
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext()) {
									Node swoNode = document.createElement("swo");
									dmNode.appendChild(swoNode);
	
									InventoryListRptSWODomainDTO inventoryListRptSWODomainDTO = (InventoryListRptSWODomainDTO) swoListsIterator.next();
	
									addChildNode(document, swoNode, "number", checkForNull(inventoryListRptSWODomainDTO.getSWoNumber()));
									addChildNode(document, swoNode, "serialnumber", checkForNull(inventoryListRptSWODomainDTO.getSerialNumber()));
									if(checkForNull(inventoryListRptSWODomainDTO.getIndicator()).equals("V")) {
										addChildNode(document, swoNode, "indicator", "SVC");
									}
									else {
										addChildNode(document, swoNode, "indicator", "-");
									}
									addChildNode(document, swoNode, "plannedstartdate", "");
									addChildNode(document, swoNode, "plannedenddate", "");
									addChildNode(document, swoNode, "eswprice", "");
									addChildNode(document, swoNode, "alternateprice", "");
									addChildNode(document, swoNode, "calculatedprice", "");
	
									List swoEELists = inventoryListRptSWODomainDTO.getSWOEEDomainDTOList();
									if (null != swoEELists) {
										Iterator swoEEListsIterator = swoEELists.iterator();
										while (swoEEListsIterator.hasNext()) {
											Node eeNode = document.createElement("ee");
											swoNode.appendChild(eeNode);
	
											InventoryListRptSWOEEDomainDTO inventoryListRptSWOEEDomainDTO = (InventoryListRptSWOEEDomainDTO) swoEEListsIterator.next();
	
											addChildNode(document, eeNode, "desc", checkForNull(inventoryListRptSWOEEDomainDTO.getDescription()));
											addChildNode(document, eeNode, "valuemetricdesc", checkForNull(inventoryListRptSWOEEDomainDTO.getValueMetricDescription()));
											addChildNode(document, eeNode, "uselevel", checkForNull(inventoryListRptSWOEEDomainDTO.getUseLevel()));
											addChildNode(document, eeNode, "number", checkForNull(inventoryListRptSWOEEDomainDTO.getEENo()));
											addChildNode(document, eeNode, "eswprice", parseAmount(inventoryListRptSWOEEDomainDTO.getListPrice()));
											addChildNode(document, eeNode, "alternateprice", parseAmount(inventoryListRptSWOEEDomainDTO.getAlternatePrice()));
											addChildNode(document, eeNode, "calculatedprice", "");
											addChildNode(document, eeNode, "pletno", checkForNull(inventoryListRptSWOEEDomainDTO.getPletNo()));										
				  										
										}
									}
								}
							}
						}
					}
				}
			}
		}			
		
		// inventoryListReportCustomDTO.reset();
		inventoryListReportCustomDTO = null;
		// System.runFinalization();

		super.setDocument(document);
	}
	
	public void convertToHTML(InventoryListReportCustomDTO inventoryListReportCustomDTO){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<style>\n");
		buffer.append(".heading  .content \n");
		buffer.append(".cellHeading {background-color:#ffffff;vertical-align:top;height:19px}\n");
		buffer.append(".cellContent {background-color:#ffffff;vertical-align:bottom;height:19px}\n");
		buffer.append("</style>\n");
		
		InventoryListRptDomainDTO inventoryListRptDomainDTO = inventoryListReportCustomDTO.getReportDTO();

		buffer.append("<table width=\"1280\">");
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><p style=\"color:red;\">IBM Confidential</p></td></tr>\n");
		buffer.append("<tr rowspan=\"2\"><td  colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td></tr>");
		buffer.append("<tr><td  colspan=\"25\"  align=\"center\" valign=\"top\" height=\"29\"><strong>Inventory list report</strong></td></tr>");
		buffer.append("<tr><td  colspan=\"25\"  align=\"left\" class=\"cellContent\"><strong>  Report printed : "+formatDate(inventoryListRptDomainDTO.getRptPrintedDate())+" </strong></td></tr>");
		buffer.append("<tr><td  colspan=\"25\"  align=\"left\" class=\"cellContent\"><strong>	Prices as of : "+formatDate(inventoryListRptDomainDTO.getPriceAsOf())+" </strong></td></tr>");
		buffer.append("<tr><td  colspan=\"25\"  align=\"center\" class=\"cellContent\">Contract period : "+formatDate(inventoryListRptDomainDTO.getContractStartDate())+" - "+formatDate(inventoryListRptDomainDTO.getContractEndDate())+" </td></tr>");

		String value = null;
		if(checkForNull(inventoryListRptDomainDTO.getExternalContractNumber()).equals("-")) {
			value = checkForNull(inventoryListRptDomainDTO.getContractNumber());
		}
		else {
			value = checkForNull(inventoryListRptDomainDTO.getExternalContractNumber());
		}

		buffer.append("<tr><td  colspan=\"25\"  align=\"center\" class=\"cellContent\">External contract number : "+value+" </td></tr>");
		buffer.append("<tr><td  colspan=\"25\"  align=\"center\" class=\"cellContent\">Currency : "+checkForNull(inventoryListRptDomainDTO.getCurrency())+" </td></tr>");
		buffer.append("<tr><td  colspan=\"25\"  align=\"center\" class=\"cellContent\">&#160;</td></tr>");

		buffer.append("<tr>");
		buffer.append("<td colspan=\"4\" align=\"left\" class=\"cellHeading\"><strong>SAP customer no.</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Design. machine</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"center\" class=\"cellHeading\"><strong>SW offering</strong></td>");
		buffer.append("<td			     align=\"left\" class=\"cellHeading\"><strong>Indicator</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Quantity/PG</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Value metric</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Entitlement entity</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Serial no.</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"left\" class=\"cellHeading\"><strong>Description</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"right\" class=\"cellHeading\"><strong>Price</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"right\" class=\"cellHeading\"><strong>Alternate price</strong></td>");
		buffer.append("<td colspan=\"2\" align=\"center\" class=\"cellHeading\"><strong>PLET no.</strong></td>");
		buffer.append("</tr>");

		
		
		int custCount = 0;
		
		if(inventoryListRptDomainDTO.getProposalContent().equals("M") || inventoryListRptDomainDTO.getProposalContent().equals("A")) {
			List customerLists = inventoryListRptDomainDTO.getCustomerDomainDTOList();
			if(null != customerLists && 0 < customerLists.size()){
				for(int i=0, size=customerLists.size(); i<size; i++){
					InventoryListRptCustomerDomainDTO customer = (InventoryListRptCustomerDomainDTO)customerLists.get(i);
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

		if(inventoryListRptDomainDTO.getProposalContent().equals("S") || inventoryListRptDomainDTO.getProposalContent().equals("A")) {
			List customers = inventoryListRptDomainDTO.getSSCustomerDomainDTOList();
			if(null != customers && 0 < customers.size()){
				for(int i=0, size=customers.size(); i<size; i++){
					InventoryListRptCustomerDomainDTO customer = (InventoryListRptCustomerDomainDTO)customers.get(i);
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
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"19\" height=\"19\"><strong>Total price for contract attachment &#160;:</strong></td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(inventoryListRptDomainDTO.getTotalListPrice())+"</strong></td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">&#160;</td>\n");
		buffer.append("</tr>\n");
			
		buffer.append("</table>\n");
		buffer.append("</table>\n");
					
		buffer.append("</center>\n");
		buffer.append("</body>\n");
		buffer.append("</html>\n");
		
		setDownloadContent(buffer.toString());
	}
	private String getCustomer(InventoryListRptCustomerDomainDTO customer, boolean mlcProducts){
		StringBuffer buffer = new StringBuffer();
		List dms = null;
		if(mlcProducts) {
			dms = customer.getDMDomainDTOList();	 
		}
		else {
			dms = customer.getSSDmDomainTO();
		}
		
		if(null != dms && 0 < dms.size()){
					
			String soldToPartyASNO = checkForNull(customer.getASNO());
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
						soldToParty = soldToPartyLegNo;     // Changed by Anand sugumaran DAD003 BlueHarmony Reports   
			

			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"4\" height=\"19\">"+soldToParty+"</td>\n");
			
			for(int dmCounter=0, dmSize=dms.size(); dmCounter<dmSize; dmCounter++){
				InventoryListRptDMDomainDTO inventoryListRptDMDomainDTO = (InventoryListRptDMDomainDTO) dms.get(dmCounter);
				
				List swoLists = null;
				
				if(mlcProducts) {
					swoLists = inventoryListRptDMDomainDTO.getSWODomainDTOList();
				}
				else {
					swoLists = inventoryListRptDMDomainDTO.getSSSWODomainDTOList();
				}
				
				if(dmCounter != 0) {
					buffer.append("<tr>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"4\" height=\"19\"></td>\n");	
				}
				
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(inventoryListRptDMDomainDTO.getDesgMcNo())+"</td>\n");
				
				if(null != swoLists && 0 < swoLists.size()){
					for(int swoCounter=0, swoSize=swoLists.size(); swoCounter<swoSize; swoCounter++){
						InventoryListRptSWODomainDTO inventoryListRptSWODomainDTO = (InventoryListRptSWODomainDTO) swoLists.get(swoCounter);
						
						if(swoCounter != 0) {
							buffer.append("<tr>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\"></td>\n");
						}
						
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(inventoryListRptSWODomainDTO.getSWoNumber())+"</td>\n");
						if(checkForNull(inventoryListRptSWODomainDTO.getIndicator()).equals("V")) {
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">SVC</td>\n");
						}
						else {
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">-</td>\n");
						}
						
						List swoEELists = inventoryListRptSWODomainDTO.getSWOEEDomainDTOList();

						if(null != swoEELists && 0 < swoEELists.size()){
							for(int swoEECounter=0, swoEESize=swoEELists.size(); swoEECounter<swoEESize; swoEECounter++){
								InventoryListRptSWOEEDomainDTO inventoryListRptSWOEEDomainDTO = (InventoryListRptSWOEEDomainDTO) swoEELists.get(swoEECounter);
								
								if(swoEECounter != 0) {
									buffer.append("<tr>\n");
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"9\" height=\"19\"></td>\n");		
								}
								
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(inventoryListRptSWOEEDomainDTO.getUseLevel())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(inventoryListRptSWOEEDomainDTO.getValueMetricDescription())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(inventoryListRptSWOEEDomainDTO.getEENo())+"</td>\n");
								if(swoEECounter == 0) {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(inventoryListRptSWODomainDTO.getSerialNumber())+"</td>\n");	
								}
								else {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\"></td>\n");
								}
								
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(inventoryListRptSWOEEDomainDTO.getDescription())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(inventoryListRptSWOEEDomainDTO.getListPrice())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(inventoryListRptSWOEEDomainDTO.getAlternatePrice())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(inventoryListRptSWOEEDomainDTO.getPletNo())+"</td></tr>\n");
							}
						}
					}
				}
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"19\" height=\"19\"><strong>Total price for designated machine&#160;:</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(inventoryListRptDMDomainDTO.getTotalListPrice())+"</strong></td>\n");
				buffer.append("</tr>\n");
			}
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"19\" height=\"19\"><strong>Total price for customer no.&#160;:</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(customer.getTotalListPrice())+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">&#160;</td>\n");
			buffer.append("</tr>\n");

			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"25\" height=\"19\">&#160;</td>\n");
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
     * InventoryListReportViewBean
     * 
     * @author thirumalai
     */
    public InventoryListReportViewBean() {
	}
	
	/**
     * InventoryListReportViewBean
     * 
     * @param inventoryListReportCustomDTO
     * @param view
     * @author thirumalai
     */
    public InventoryListReportViewBean(InventoryListReportCustomDTO inventoryListReportCustomDTO, String view) {
		convertToDOM(inventoryListReportCustomDTO);
		super.setView(view);
	}	

	/**
     * InventoryListReportViewBean
     * 
     * @param inventoryListReportCustomDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public InventoryListReportViewBean(InventoryListReportCustomDTO inventoryListReportCustomDTO, String view, boolean viewReport) {
		if(viewReport){
			convertToDOM(inventoryListReportCustomDTO);
		}
		else{
			convertToHTML(inventoryListReportCustomDTO);
		}
		super.setView(view);
	}	
}