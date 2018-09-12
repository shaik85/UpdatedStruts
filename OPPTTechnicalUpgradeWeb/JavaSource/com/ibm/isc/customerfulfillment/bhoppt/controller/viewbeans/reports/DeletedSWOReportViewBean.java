/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedSWOReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><strong>Known Bugs</strong><br/> 
 * 
 * <br/><PRE> 
 * date Feb 18, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class DeletedSWOReportViewBean extends ReportViewBean {
	/**
     * @param customDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public DeletedSWOReportViewBean(DeletedSWOReportCustomDTO customDTO, String view, boolean viewReport){
		if(viewReport){
			convertToDOM(customDTO);
		}
		else{
			convertToHTML(customDTO);
		}
		setView(view);
	}
	/**
     * DeletedSWOReportViewBean
     * 
     * @param customDTO
     * @param view
     * @author thirumalai
     */
    public DeletedSWOReportViewBean(DeletedSWOReportCustomDTO customDTO, String view){
		convertToDOM(customDTO);
		setView(view);
	}
	/**
     * DeletedSWOReportViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public DeletedSWOReportViewBean(DeletedSWOReportCustomDTO customDTO){
		convertToDOM(customDTO);
		setView("deletedSwoReportView");
	}

	/**
     * convertToDOM
     * 
     * @param customDTO
     * @author thirumalai
     */
    protected void convertToDOM(DeletedSWOReportCustomDTO customDTO){
		Document document = createDocument();
		Element root = (Element) document.createElement("deletedSwoReport");
		document.appendChild(root);

		DeletedSWORptDomainDTO reportDTO = customDTO.getReportDTO();
		if(null != reportDTO){
			addChildNode(document, (Node)root, "reportPrintedDate", formatDate(reportDTO.getRptPrintedDate()));
			addChildNode(document, (Node)root, "pricesAsOf", formatDate(reportDTO.getPricesAsOf()));
			addChildNode(document, (Node)root, "contractStartDate", formatDate(reportDTO.getContractStartDate()));
			addChildNode(document, (Node)root, "contractEndDate", formatDate(reportDTO.getContractEndDate()));
			addChildNode(document, (Node)root, "tvmRate", parseAmount(reportDTO.getTvmRate()));
			addChildNode(document, (Node)root, "plannedGrowth", parseAmount(reportDTO.getPlannedGrowthRate()));
			addChildNode(document, (Node)root, "proposalName", checkForNull(customDTO.getProposalDTO().getName()));
			addChildNode(document, (Node)root, "contractNumber", checkForNull(reportDTO.getContractNumer()));

			/*	For MLC details	*/
			List customers = reportDTO.getCustomerDomainDTOList();
			
			int custCount = 0;
		
			if(reportDTO.getProposalContent().equals("M") || reportDTO.getProposalContent().equals("A")) {

				if(null != customers && 0 < customers.size()){
					addAttributeNode(document, root, "hasData", "true");
					for(int i=0, size=customers.size(); i<size; i++){
						DeletedSWORptCustomerDomainDTO customer = new DeletedSWORptCustomerDomainDTO();
						
						customer = (DeletedSWORptCustomerDomainDTO)customers.get(i);
						
						List dms = customer.getDMDomainDTOList();
					
						if(null != dms && 0 < dms.size()){
							
							Node customerNode = document.createElement("customer");
							root.appendChild(customerNode);
						
							String soldToPartyASNO = checkForNull(customer.getSoldToPartyAsNo());
							String soldToPartyLegNo = checkForNull(customer.getSoldToPartyLegNo());
							String billToPartyASNO = checkForNull(customer.getBillToPartyAsNo());
							String billToPartyLegNo = checkForNull(customer.getBillToPartyLegNo());
							String payerASNO = checkForNull(customer.getPayerAsNo());
							String payerLegNo = checkForNull(customer.getPayerLegNo());
							String soldToParty = null;
							String billToParty = null;
							String payer = null;
							if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-")) {  //$NON-NLS-1$  //$NON-NLS-2$
								soldToParty = "-";  //$NON-NLS-1$
							
							} else if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-"))) {  //$NON-NLS-1$  //$NON-NLS-2$
								soldToParty = soldToPartyASNO;
							
							} else if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-")) {  //$NON-NLS-1$  //$NON-NLS-2$
								soldToParty = soldToPartyLegNo;
							
							} else {
								soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
							}
					
							if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")) {  //$NON-NLS-2$
								billToPartyLegNo = checkForNull(reportDTO.getBillToPartyLegNo());
								billToPartyASNO = checkForNull(reportDTO.getBillToPartySeqNo());
							}
					
							if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")) {  //$NON-NLS-1$  //$NON-NLS-2$
								billToParty = "-";  //$NON-NLS-1$
							
							} else if (billToPartyLegNo.equals("-") && !(billToPartyASNO.equals("-"))) {
								billToParty = billToPartyASNO;
							
							} else if (!(billToPartyLegNo.equals("-")) && billToPartyASNO.equals("-"))
								billToParty = billToPartyLegNo;
							else
								billToParty = billToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
					
							if (payerLegNo.equals("-") && payerASNO.equals("-")) {
								payerLegNo = checkForNull(reportDTO.getPayerLegNo());
								payerASNO = checkForNull(reportDTO.getPayerSeqNo());
							}
					
							if (payerLegNo.equals("-") && payerASNO.equals("-"))
								payer = "-";
							else if (payerLegNo.equals("-") && !(payerASNO.equals("-")))
								payer = payerASNO;
							else if (!(payerLegNo.equals("-")) && payerASNO.equals("-"))
								payer = payerLegNo;
							else
								payer = payerLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
						
							Node soldToPartyNode = document.createElement("soldToParty");
							customerNode.appendChild(soldToPartyNode);
							addAttributeNode(document, soldToPartyNode, "number", soldToParty);
							addAttributeNode(document, soldToPartyNode, "name", checkForNull(customer.getSoldToPartyName()));
							
							if(custCount==0) {
								customer.setCustType("M");
								custCount++;
							}
							addAttributeNode(document, soldToPartyNode, "custtype", checkForNull(customer.getCustType()));


							Node billtoPartyNode = document.createElement("billToParty");
							customerNode.appendChild(billtoPartyNode);
							addAttributeNode(document, billtoPartyNode, "number", billToParty);
							if(checkForNull(customer.getBillToPartyName()).equals("-")) {
								addAttributeNode(document, billtoPartyNode, "name", checkForNull(reportDTO.getBillToPartyName()));
							}
							else {
								addAttributeNode(document, billtoPartyNode, "name", checkForNull(customer.getBillToPartyName()));
							}
	
							Node payerNode = document.createElement("payer");
							customerNode.appendChild(payerNode);
							addAttributeNode(document, payerNode, "number", payer);
							if(checkForNull(customer.getPayerName()).equals("-")) {
								addAttributeNode(document, payerNode, "name", checkForNull(reportDTO.getPayerName()));	
							}
							else {
								addAttributeNode(document, payerNode, "name", checkForNull(customer.getPayerName()));
							}
							
							for(int dmCounter=0, dmSize=dms.size(); dmCounter<dmSize; dmCounter++){
								
								DeletedSWORptDMDomainDTO dm = (DeletedSWORptDMDomainDTO)dms.get(dmCounter);
								
								if(null != dm){
									Node dmNode = document.createElement("dm");
									customerNode.appendChild(dmNode);
									addAttributeNode(document, dmNode, "number", checkForNull(dm.getDesgMcNo()));
									
									List swos = dm.getSWODomainDTOList();
									if(null != swos && 0 < swos.size()){
										for(int swoCounter=0, swoSize=swos.size(); swoCounter<swoSize; swoCounter++){
											DeletedSWORptSWODomainDTO swo = (DeletedSWORptSWODomainDTO)swos.get(swoCounter);
										
											if(null != swo){
												Node swoNode = document.createElement("swo");
												dmNode.appendChild(swoNode);
												addAttributeNode(document, swoNode, "number", checkForNull(swo.getSWONo()));
												addAttributeNode(document, swoNode, "serialNumber", checkForNull(swo.getSerialNumber()));
											
												addChildNode(document, swoNode, "planStartDate", formatDate(swo.getPlanStartDate()));
												addChildNode(document, swoNode, "planEndDate", formatDate(swo.getPlanEndDate()));
												addChildNode(document, swoNode, "eswPrice", parseAmount(swo.getESWPrice()));
												addChildNode(document, swoNode, "alternatePrice", parseAmount(swo.getAlternatePrice()));
												addChildNode(document, swoNode, "calculatedPrice", parseAmount(swo.getCalculatedPrice()));
												
												List ees = swo.getSWOEEDomainDTOList();
												if(null != ees && 0 < ees.size()){
													for(int eeCounter=0, eeSize=ees.size(); eeCounter<eeSize; eeCounter++){
														DeletedSWORptSWOEEDomainDTO ee = (DeletedSWORptSWOEEDomainDTO)ees.get(eeCounter);
														
														if(null != ee){
															Node eeNode = document.createElement("ee");
															swoNode.appendChild(eeNode);
															addAttributeNode(document, eeNode, "number", checkForNull(ee.getEENo()));
															
															addChildNode(document, eeNode, "valueMetricDescription", checkForNull(ee.getValueMetricDesc()));
															addChildNode(document, eeNode, "useLevel", checkForNull(ee.getUseLevel()));
															addChildNode(document, eeNode, "eswPrice", parseAmount(ee.getEswPrice()));
															addChildNode(document, eeNode, "alternatePrice", parseAmount(ee.getAlternatePrice()));
															addChildNode(document, eeNode, "calculatedPrice", parseAmount(ee.getCalculatedPrice()));
														}
													}
												}
											}
										}
									}
									addChildNode(document, dmNode, "totalPrice", parseAmount(dm.getTotalCalculatedPrice()));
								}
							}
							addChildNode(document, customerNode, "totalPrice", parseAmount(customer.getTotalCalculatedPrice()));
						}
					}
					addChildNode(document, root, "totalPrice", parseAmount(reportDTO.getTotalCalculatedPrice()));
				}
				else{
					addChildNode(document, root, "hasData", "false");
				}
			}
			
			/*	Set for S&S details	*/
			if(reportDTO.getProposalContent().equals("S") || reportDTO.getProposalContent().equals("A")) {
				customers = reportDTO.getSSCustomerDomainDTOList();
				custCount = 0;
			
				if(null != customers && 0 < customers.size()){
					addAttributeNode(document, root, "hasData", "true");
					for(int i=0, size=customers.size(); i<size; i++){
						DeletedSWORptCustomerDomainDTO customer = new DeletedSWORptCustomerDomainDTO();
						
						customer = (DeletedSWORptCustomerDomainDTO)customers.get(i);
						
						List dms1 = customer.getSSDmDomainTO();
					
						if(null != dms1 && 0 < dms1.size()){
							Node customerNode = document.createElement("customer");
							root.appendChild(customerNode);
						
							String soldToPartyASNO = checkForNull(customer.getSoldToPartyAsNo());
							String soldToPartyLegNo = checkForNull(customer.getSoldToPartyLegNo());
							String billToPartyASNO = checkForNull(customer.getBillToPartyAsNo());
							String billToPartyLegNo = checkForNull(customer.getBillToPartyLegNo());
							String payerASNO = checkForNull(customer.getPayerAsNo());
							String payerLegNo = checkForNull(customer.getPayerLegNo());
							String soldToParty = null;
							String billToParty = null;
							String payer = null;
							if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-"))
								soldToParty = "-";
							else if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-")))
								soldToParty = soldToPartyASNO;
							else if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-"))
								soldToParty = soldToPartyLegNo;
							else
								soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
					
							if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")) {
								billToPartyLegNo = checkForNull(reportDTO.getBillToPartyLegNo());
								billToPartyASNO = checkForNull(reportDTO.getBillToPartySeqNo());
							}
					
							if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-"))
								billToParty = "-";
							else if (billToPartyLegNo.equals("-") && !(billToPartyASNO.equals("-")))
								billToParty = billToPartyASNO;
							else if (!(billToPartyLegNo.equals("-")) && billToPartyASNO.equals("-"))
								billToParty = billToPartyLegNo;
							else
								billToParty = billToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
					
							if (payerLegNo.equals("-") && payerASNO.equals("-")) {
								payerLegNo = checkForNull(reportDTO.getPayerLegNo());
								payerASNO = checkForNull(reportDTO.getPayerSeqNo());
							}
					
							if (payerLegNo.equals("-") && payerASNO.equals("-"))
								payer = "-";
							else if (payerLegNo.equals("-") && !(payerASNO.equals("-")))
								payer = payerASNO;
							else if (!(payerLegNo.equals("-")) && payerASNO.equals("-"))
								payer = payerLegNo;
							else
								payer = payerLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
						
							Node soldToPartyNode = document.createElement("soldToParty");
							customerNode.appendChild(soldToPartyNode);
							addAttributeNode(document, soldToPartyNode, "number", soldToParty);
							addAttributeNode(document, soldToPartyNode, "name", checkForNull(customer.getSoldToPartyName()));
							
							if(custCount==0) {
								customer.setCustType("S");
								custCount++;
							}
							addAttributeNode(document, soldToPartyNode, "custtype", checkForNull(customer.getCustType()));


							Node billtoPartyNode = document.createElement("billToParty");
							customerNode.appendChild(billtoPartyNode);
							addAttributeNode(document, billtoPartyNode, "number", billToParty);
							if(checkForNull(customer.getBillToPartyName()).equals("-")) {
								addAttributeNode(document, billtoPartyNode, "name", checkForNull(reportDTO.getBillToPartyName()));
							}
							else {
								addAttributeNode(document, billtoPartyNode, "name", checkForNull(customer.getBillToPartyName()));
							}
	
							Node payerNode = document.createElement("payer");
							customerNode.appendChild(payerNode);
							addAttributeNode(document, payerNode, "number", payer);
							if(checkForNull(customer.getPayerName()).equals("-")) {
								addAttributeNode(document, payerNode, "name", checkForNull(reportDTO.getPayerName()));	
							}
							else {
								addAttributeNode(document, payerNode, "name", checkForNull(customer.getPayerName()));
							}

							for(int dmCounter=0, dmSize=dms1.size(); dmCounter<dmSize; dmCounter++){
								DeletedSWORptDMDomainDTO dm = (DeletedSWORptDMDomainDTO)dms1.get(dmCounter);
								
								if(null != dm){
									Node dmNode = document.createElement("dm");
									customerNode.appendChild(dmNode);
									addAttributeNode(document, dmNode, "number", checkForNull(dm.getDesgMcNo()));
								
									List swos = dm.getSSSWODomainDTOList();
									if(null != swos && 0 < swos.size()){
										for(int swoCounter=0, swoSize=swos.size(); swoCounter<swoSize; swoCounter++){
											DeletedSWORptSWODomainDTO swo = (DeletedSWORptSWODomainDTO)swos.get(swoCounter);
										
											if(null != swo){
												Node swoNode = document.createElement("swo");
												dmNode.appendChild(swoNode);
												addAttributeNode(document, swoNode, "number", checkForNull(swo.getSWONo()));
												addAttributeNode(document, swoNode, "serialNumber", checkForNull(swo.getSerialNumber()));
											
												addChildNode(document, swoNode, "planStartDate", formatDate(swo.getPlanStartDate()));
												addChildNode(document, swoNode, "planEndDate", formatDate(swo.getPlanEndDate()));
												addChildNode(document, swoNode, "eswPrice", parseAmount(swo.getESWPrice()));
												addChildNode(document, swoNode, "alternatePrice", parseAmount(swo.getAlternatePrice()));
												addChildNode(document, swoNode, "calculatedPrice", parseAmount(swo.getCalculatedPrice()));
												
												List ees = swo.getSWOEEDomainDTOList();
												if(null != ees && 0 < ees.size()){
													for(int eeCounter=0, eeSize=ees.size(); eeCounter<eeSize; eeCounter++){
														DeletedSWORptSWOEEDomainDTO ee = (DeletedSWORptSWOEEDomainDTO)ees.get(eeCounter);
														
														if(null != ee){
															Node eeNode = document.createElement("ee");
															swoNode.appendChild(eeNode);
															addAttributeNode(document, eeNode, "number", checkForNull(ee.getEENo()));
															
															addChildNode(document, eeNode, "valueMetricDescription", checkForNull(ee.getValueMetricDesc()));
															addChildNode(document, eeNode, "useLevel", checkForNull(ee.getUseLevel()));
															addChildNode(document, eeNode, "eswPrice", parseAmount(ee.getEswPrice()));
															addChildNode(document, eeNode, "alternatePrice", parseAmount(ee.getAlternatePrice()));
															addChildNode(document, eeNode, "calculatedPrice", parseAmount(ee.getCalculatedPrice()));
														}
													}
												}
											}
										}
									}
									addChildNode(document, dmNode, "totalPrice", parseAmount(dm.getTotalCalculatedPrice()));
								}
							}
							addChildNode(document, customerNode, "totalPrice", parseAmount(customer.getTotalCalculatedPrice()));
						}
					}
					addChildNode(document, root, "totalPrice", parseAmount(reportDTO.getTotalCalculatedPrice()));
				}
				else{
					addChildNode(document, root, "hasData", "false");
				}
			}
			else{
				addChildNode(document, root, "hasData", "false");
			}
		}				
	}
	
	private String getCustomerId(String legacyCustomerNumber, String addressSequenceNumber){
		StringBuffer buffer = new StringBuffer();
		
		if(null != legacyCustomerNumber){
			buffer.append(legacyCustomerNumber);
		}
		if(null != addressSequenceNumber){
			buffer.append(" "+addressSequenceNumber);
		}
		
		return buffer.toString();
	}

	protected void convertToHTML(DeletedSWOReportCustomDTO customDTO){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<html xml:lang=\"en\" lang=\"en\">\n");
		buffer.append("<head>\n");
		buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\n");
		buffer.append("<meta name=\"Version\" content=\"1.0\" />\n");
		buffer.append("<meta name=\"DC.Rights\" content=\"Copyright (c) 2003 by IBM Corporation\" />\n");
		buffer.append("<title>Deleted swo report</title>\n");
		buffer.append("</head>\n");
		buffer.append("<body>\n");

		buffer.append("<basefont face=\"Arial\" lotus_size=\"12\" size=\"3\" color=\"#000000\" />\n");
		buffer.append("<center>\n");
		
		buffer.append("<table border=\"0\" lotus_anchor=\"A4..S14\" width=\"1120\">\n");
		buffer.append("<lotus_global align=\"center\" valign=\"bottom\" lotus_format=\"General\" height=\"19\" width=\"124\" grid=\"OFF\" gridcolor=\"#cccccc\"></lotus_global>\n");
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
		buffer.append("</tr>\n");
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><p style=\"color:red;\">IBM Confidential</p></td></tr>\n");
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"9\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\"><strong>Report of deleted SWOs</strong></td></tr>\n");

		DeletedSWORptDomainDTO reportDTO = customDTO.getReportDTO();
		
		if(null != reportDTO){
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"9\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><strong>Report printed : "+formatDate(reportDTO.getRptPrintedDate())+" </strong></td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"9\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"><strong>Prices as of : "+formatDate(reportDTO.getPricesAsOf())+" </strong></td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"9\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">Contract period : "+formatDate(reportDTO.getContractStartDate())+" &#160;-&#160; "+formatDate(reportDTO.getContractEndDate())+" </td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"9\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">TVM rate : "+parseAmount(reportDTO.getTvmRate())+" &#160;%&#160;Planned growth : "+parseAmount(reportDTO.getPlannedGrowthRate())+"&#160;% </td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"9\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">"+checkForNull(customDTO.getProposalDTO().getName())+" &#160;("+checkForNull(reportDTO.getContractNumer())+")</td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"9\" height=\"19\">&#160;</td></tr>\n");
			
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"3\" height=\"19\">&#160;</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Billing</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"1\" height=\"19\">&#160;</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"3\" height=\"19\"><strong>Price</strong></td>\n");
			buffer.append("</tr>\n");

			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>SWO number</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>Serial number</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>Plan start date</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>Plan end date</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>ESW</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>Alternate</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>Calculated</strong></td>\n");
			buffer.append("</tr>\n");

			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>Value metric description</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>Use level</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>EE</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">&#160;</td>\n");
			buffer.append("</tr>\n");
			
			if(reportHasData(reportDTO)){
				if(reportDTO.getProposalContent().equals("M") || reportDTO.getProposalContent().equals("A")) {
					List customers = reportDTO.getCustomerDomainDTOList();
					if(null != customers && 0 < customers.size()){
						for(int i=0, size=customers.size(); i<size; i++){
							DeletedSWORptCustomerDomainDTO customer = (DeletedSWORptCustomerDomainDTO)customers.get(i);
							if(checkForNull(customer.getBillToPartyName()).equals("-")) {
								customer.setBillToPartyName(reportDTO.getBillToPartyName());
							}
							if(checkForNull(customer.getPayerName()).equals("-")) {
								customer.setPayerName(reportDTO.getPayerName());
							}
							buffer.append(getCustomer(customer, true));
						}
					}
				}

				if(reportDTO.getProposalContent().equals("S") || reportDTO.getProposalContent().equals("A")) {
					
					List customers = reportDTO.getSSCustomerDomainDTOList();
					if(null != customers && 0 < customers.size()){
						for(int i=0, size=customers.size(); i<size; i++){
							DeletedSWORptCustomerDomainDTO customer = (DeletedSWORptCustomerDomainDTO)customers.get(i);
							if(checkForNull(customer.getBillToPartyName()).equals("-")) {
								customer.setBillToPartyName(reportDTO.getBillToPartyName());
							}
							if(checkForNull(customer.getPayerName()).equals("-")) {
								customer.setPayerName(reportDTO.getPayerName());
							}
							buffer.append(getCustomer(customer, false));
						}
					}
				}

				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"5\" height=\"19\">&#160;</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">Total price for contract attachment&#160;:</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>"+parseAmount(reportDTO.getTotalCalculatedPrice())+"</strong></td>\n");
				buffer.append("</tr>\n");
			}
			else{
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"8\" height=\"19\">No SWO has been deleted.</td>\n");
				buffer.append("</tr>\n");
			}
		}

		buffer.append("</table>\n");
				
		buffer.append("</center>\n");
		buffer.append("</body>\n");
		buffer.append("</html>\n");
		
		setDownloadContent(buffer.toString());
	}
	
	private String getCustomer(DeletedSWORptCustomerDomainDTO customer, boolean mlcProducts){
		StringBuffer buffer = new StringBuffer();
		List dms = customer.getDMDomainDTOList();
		if(null != dms && 0 < dms.size()){
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"6\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">\n");
			if(mlcProducts){
				buffer.append("<strong>MLC products</strong>\n");
			}
			else{
				buffer.append("<strong>S&amp;S products</strong>\n");
			}
			buffer.append("</td>\n");
			buffer.append("</tr>\n");
			
			String soldToPartyASNO = checkForNull(customer.getSoldToPartyAsNo());
			String soldToPartyLegNo = checkForNull(customer.getSoldToPartyLegNo());
			String billToPartyASNO = checkForNull(customer.getBillToPartyAsNo());
			String billToPartyLegNo = checkForNull(customer.getBillToPartyLegNo());
			String payerASNO = checkForNull(customer.getPayerAsNo());
			String payerLegNo = checkForNull(customer.getPayerLegNo());
	
			String soldToParty = null;
			String billToParty = null;
			String payer = null;
			
			if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-")){
				soldToParty = "-";
			}
			else if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-"))){
				soldToParty = soldToPartyASNO;
			}
			else if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-")){
				soldToParty = soldToPartyLegNo;
			}
			else{
				soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
			}
						
			if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")){
				billToParty = "-";
			}
			else if (billToPartyLegNo.equals("-") && !(billToPartyASNO.equals("-"))){
				billToParty = billToPartyASNO;
			}
			else if (!(billToPartyLegNo.equals("-")) && billToPartyASNO.equals("-")){
				billToParty = billToPartyLegNo;
			}
			else{
				billToParty = billToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
			}
						
			if (payerLegNo.equals("-") && payerASNO.equals("-")){
				payer = "-";
			}
			else if (payerLegNo.equals("-") && !(payerASNO.equals("-"))){
				payer = payerASNO;
			}
			else if (!(payerLegNo.equals("-")) && payerASNO.equals("-")){
				payer = payerLegNo;
			}
			else{
				payer = payerLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
			}
	
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>Sold to party&#160;:&#160;"+soldToParty+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>Bill to party&#160;:&#160;"+billToParty+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>Payer&#160;:&#160;"+payer+"</strong></td>\n");
			buffer.append("</tr>\n");
		
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(customer.getSoldToPartyName())+"</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(customer.getBillToPartyName())+"</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(customer.getPayerName())+"</td>\n");
			buffer.append("</tr>\n");

			for(int dmCounter=0, dmSize=dms.size(); dmCounter<dmSize; dmCounter++){
				DeletedSWORptDMDomainDTO dm = (DeletedSWORptDMDomainDTO)dms.get(dmCounter);
				if(null != dm){
					buffer.append("<tr><td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"9\" height=\"19\">Designated machine&#160;:&#160;"+checkForNull(dm.getDesgMcNo())+"</td></tr>\n");

					List swos = dm.getSWODomainDTOList();
					if(null != swos && 0 < swos.size()){
						for(int swoCounter=0, swoSize=swos.size(); swoCounter<swoSize; swoCounter++){
							DeletedSWORptSWODomainDTO swo = (DeletedSWORptSWODomainDTO)swos.get(swoCounter);
							if(null != swo){
								buffer.append("<tr>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+checkForNull(swo.getSWONo())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+checkForNull(swo.getSerialNumber())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+formatDate(swo.getPlanStartDate())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+formatDate(swo.getPlanEndDate())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(swo.getESWPrice())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(swo.getAlternatePrice())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(swo.getCalculatedPrice())+"</td>\n");
								buffer.append("</tr>\n");
								
								List ees = swo.getSWOEEDomainDTOList();
								if(null != ees && 0 < ees.size()){
									for(int eeCounter=0, eeSize=ees.size(); eeCounter<eeSize; eeCounter++){
										DeletedSWORptSWOEEDomainDTO ee = (DeletedSWORptSWOEEDomainDTO)ees.get(eeCounter);
										if(null != ee){
											buffer.append("<tr>\n");
											buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
											buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(ee.getValueMetricDesc())+"</td>\n");
											buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(ee.getUseLevel())+"</td>\n");
											buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+checkForNull(ee.getEENo())+"</td>\n");
											buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(ee.getEswPrice())+"</td>\n");
											buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(ee.getAlternatePrice())+"</td>\n");
											buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(ee.getCalculatedPrice())+"</td>\n");
											buffer.append("</tr>\n");
										}
									}
								}
							}
						}
					}
					buffer.append("<tr>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"5\" height=\"19\">&#160;</td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">Total price for designated machine&#160;("+checkForNull(dm.getDesgMcNo())+")&#160;:</td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>"+parseAmount(dm.getTotalCalculatedPrice())+"</strong></td>\n");
					buffer.append("</tr>\n");
				}
			}
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"5\" height=\"19\">&#160;</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">Total price for sold to party&#160;("+soldToParty+")&#160;:</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>"+parseAmount(customer.getTotalCalculatedPrice())+"</strong></td>\n");
			buffer.append("</tr>\n");
		}
		List dms1 = customer.getSSDmDomainTO();
		if(null != dms1 && 0 < dms1.size()){
                    buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" colspan=\"6\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">\n");
		if(mlcProducts){
			buffer.append("<strong>MLC products</strong>\n");
		}
		else{
			buffer.append("<strong>S&amp;S products</strong>\n");
		}
		buffer.append("</td>\n");
		buffer.append("</tr>\n");
		String soldToPartyASNO = checkForNull(customer.getSoldToPartyAsNo());
		String soldToPartyLegNo = checkForNull(customer.getSoldToPartyLegNo());
		String billToPartyASNO = checkForNull(customer.getBillToPartyAsNo());
		String billToPartyLegNo = checkForNull(customer.getBillToPartyLegNo());
		String payerASNO = checkForNull(customer.getPayerAsNo());
		String payerLegNo = checkForNull(customer.getPayerLegNo());

		String soldToParty = null;
		String billToParty = null;
		String payer = null;
		
		if (soldToPartyLegNo.equals("-") && soldToPartyASNO.equals("-")){
			soldToParty = "-";
		}
		else if (soldToPartyLegNo.equals("-") && !(soldToPartyASNO.equals("-"))){
			soldToParty = soldToPartyASNO;
		}
		else if (!(soldToPartyLegNo.equals("-")) && soldToPartyASNO.equals("-")){
			soldToParty = soldToPartyLegNo;
		}
		else{
			soldToParty = soldToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
		}
					
		if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")){
			billToParty = "-";
		}
		else if (billToPartyLegNo.equals("-") && !(billToPartyASNO.equals("-"))){
			billToParty = billToPartyASNO;
		}
		else if (!(billToPartyLegNo.equals("-")) && billToPartyASNO.equals("-")){
			billToParty = billToPartyLegNo;
		}
		else{
			billToParty = billToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
		}
					
		if (payerLegNo.equals("-") && payerASNO.equals("-")){
			payer = "-";
		}
		else if (payerLegNo.equals("-") && !(payerASNO.equals("-"))){
			payer = payerASNO;
		}
		else if (!(payerLegNo.equals("-")) && payerASNO.equals("-")){
			payer = payerLegNo;
		}
		else{
			payer = payerLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
		}

		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>Sold to party&#160;:&#160;"+soldToParty+"</strong></td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>Bill to party&#160;:&#160;"+billToParty+"</strong></td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>Payer&#160;:&#160;"+payer+"</strong></td>\n");
		buffer.append("</tr>\n");
	
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(customer.getSoldToPartyName())+"</td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(customer.getBillToPartyName())+"</td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">"+checkForNull(customer.getPayerName())+"</td>\n");
		buffer.append("</tr>\n");

		for(int dmCounter=0, dmSize=dms1.size(); dmCounter<dmSize; dmCounter++){
			DeletedSWORptDMDomainDTO dm = (DeletedSWORptDMDomainDTO)dms1.get(dmCounter);
			if(null != dm){
				buffer.append("<tr><td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"9\" height=\"19\">Designated machine&#160;:&#160;"+checkForNull(dm.getDesgMcNo())+"</td></tr>\n");

				//List swos = dm.getSWODomainDTOList();
				List swos = dm.getSSSWODomainDTOList();
				if(null != swos && 0 < swos.size()){
					
					for(int swoCounter=0, swoSize=swos.size(); swoCounter<swoSize; swoCounter++){
						DeletedSWORptSWODomainDTO swo = (DeletedSWORptSWODomainDTO)swos.get(swoCounter);
						if(null != swo){
							buffer.append("<tr>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+checkForNull(swo.getSWONo())+"</td>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+checkForNull(swo.getSerialNumber())+"</td>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+formatDate(swo.getPlanStartDate())+"</td>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+formatDate(swo.getPlanEndDate())+"</td>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(swo.getESWPrice())+"</td>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(swo.getAlternatePrice())+"</td>\n");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(swo.getCalculatedPrice())+"</td>\n");
							buffer.append("</tr>\n");
							
							List ees = swo.getSWOEEDomainDTOList();
							if(null != ees && 0 < ees.size()){
								for(int eeCounter=0, eeSize=ees.size(); eeCounter<eeSize; eeCounter++){
									DeletedSWORptSWOEEDomainDTO ee = (DeletedSWORptSWOEEDomainDTO)ees.get(eeCounter);
									if(null != ee){
										buffer.append("<tr>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">&#160;</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(ee.getValueMetricDesc())+"</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(ee.getUseLevel())+"</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" width=\"124\" height=\"19\">"+checkForNull(ee.getEENo())+"</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(ee.getEswPrice())+"</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(ee.getAlternatePrice())+"</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\">"+parseAmount(ee.getCalculatedPrice())+"</td>\n");
										buffer.append("</tr>\n");
									}
								}
							}
						}
					}
				}
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"5\" height=\"19\">&#160;</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">Total price for designated machine&#160;("+checkForNull(dm.getDesgMcNo())+")&#160;:</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>"+parseAmount(dm.getTotalCalculatedPrice())+"</strong></td>\n");
				buffer.append("</tr>\n");
			}
		}
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"5\" height=\"19\">&#160;</td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\">Total price for sold to party&#160;("+soldToParty+")&#160;:</td>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" width=\"124\" height=\"19\"><strong>"+parseAmount(customer.getTotalCalculatedPrice())+"</strong></td>\n");
		buffer.append("</tr>\n");
}
	

		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");
		
		return buffer.toString();
	}
	
	private boolean reportHasData(DeletedSWORptDomainDTO reportDTO){
		boolean hasData = false;

		List customers = reportDTO.getCustomerDomainDTOList();
		if(null != customers && 0 < customers.size()){
			hasData = true;
		}
		else{
			customers = reportDTO.getSSCustomerDomainDTOList();
			if(null != customers && 0 < customers.size()){
				hasData = true;
			}
			else{
				hasData = false;
			}
		}

		return hasData;
	}
}
