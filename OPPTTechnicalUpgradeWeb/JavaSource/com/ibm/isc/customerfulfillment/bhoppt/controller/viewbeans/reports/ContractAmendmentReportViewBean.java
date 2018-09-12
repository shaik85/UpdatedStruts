/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAmendmentReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;

/**
 * Holds complete date required for contract amendment report view  
 * 
 * <br/><strong>Known Bugs</strong><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ContractAmendmentReportViewBean extends ReportViewBean
{
	/**
     * ContractAmendmentReportViewBean
     * 
     * @param customDTO
     * @param view
     * @author thirumalai
     */
    public ContractAmendmentReportViewBean(ContractAmendmentReportCustomDTO customDTO, String view){
		convertToDOM(customDTO);
		setView(view);
	}

	/**
     * ContractAmendmentReportViewBean
     * 
     * @param customDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public ContractAmendmentReportViewBean(ContractAmendmentReportCustomDTO customDTO, String view, boolean viewReport){
		if(viewReport){
			convertToDOM(customDTO);
		}
		else{
			convertToHTML(customDTO);
		}
		setView(view);
	}
	
	/**
     * convertToDOM
     * 
     * @param customDTO
     * @author thirumalai
     */
    private void convertToDOM(ContractAmendmentReportCustomDTO customDTO)
	{
		
		Document document = null;
		document = createDocument();
		ContractAmendmentRptDomainDTO contractAmendmentRptDomainDTO = customDTO.getReportDTO();
		// Insert Root Order
		Element root = (Element) document.createElement("contractAmendmentreport");
		// Insert child Manifest
		
		document.appendChild(root);
		root.setAttribute("reportprinteddate", formatDate(contractAmendmentRptDomainDTO.getRptPrintedDate()));
		root.setAttribute("contractstartdate", formatDate(contractAmendmentRptDomainDTO.getContractStartDate()));
		root.setAttribute("contractenddate", formatDate(contractAmendmentRptDomainDTO.getContractEndDate()));
		root.setAttribute("amendmenteffectivedate", formatDate(contractAmendmentRptDomainDTO.getAmmendmentEffectiveDate()));
		root.setAttribute("tvmrate", parseAmount(contractAmendmentRptDomainDTO.getTvmRate()));
		root.setAttribute("plannedgrowthrate", parseAmount(contractAmendmentRptDomainDTO.getPlannedGrowthRate()));
		root.setAttribute("proposalname", checkForNull(contractAmendmentRptDomainDTO.getContractName()));
		root.setAttribute("contractnumber", checkForNull(contractAmendmentRptDomainDTO.getContractNo()));
		root.setAttribute("totalmonthprice", parseAmount(contractAmendmentRptDomainDTO.getTotalMonthlyPrice()));
		root.setAttribute("totalcalculatedprice", parseAmount(contractAmendmentRptDomainDTO.getTotalCalculatedPrice()));
		root.setAttribute("billingfrequency", checkForNull(contractAmendmentRptDomainDTO.getBillingFreq()));
		root.setAttribute("totaladjustmentprice", parseAmount(contractAmendmentRptDomainDTO.getAdjustmentAmt()));
		root.setAttribute("amountprevbilled", parseAmount(contractAmendmentRptDomainDTO.getAmendBilledPrev()));
		root.setAttribute("amendtotal", parseAmount(contractAmendmentRptDomainDTO.getAmendTotal()));
		root.setAttribute("orgcontracttotal", parseAmount(contractAmendmentRptDomainDTO.getOriginalContractTotal()));
		
		/*	For MLC details	*/
		List customerLists = contractAmendmentRptDomainDTO.getCustomerDomainDTOList();
		int custCount = 0;
		
		if(contractAmendmentRptDomainDTO.getProposalContent().equals("M") || contractAmendmentRptDomainDTO.getProposalContent().equals("A")) {
		
			if (null != customerLists) {
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext()) {
					
					ContractAmendmentRptCustomerDomainDTO contractAmendmentRptCustomerDomainDTO = new ContractAmendmentRptCustomerDomainDTO();
					contractAmendmentRptCustomerDomainDTO = (ContractAmendmentRptCustomerDomainDTO) customerListsIterator.next();
					
					List dmLists = contractAmendmentRptCustomerDomainDTO.getDMDomainDTOList();
	
					if (null != dmLists && dmLists.size() > 0) {

						Element customerNode = (Element) document.createElement("customer");
						root.appendChild(customerNode);

						String soldToPartyASNO = checkForNull(contractAmendmentRptCustomerDomainDTO.getSoldToPartyAsNo());
						String soldToPartyLegNo = checkForNull(contractAmendmentRptCustomerDomainDTO.getSoldToPartyLegNo());
						String billToPartyASNO = checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyAsNo());
						String billToPartyLegNo = checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyLegNo());
						String payerASNO = checkForNull(contractAmendmentRptCustomerDomainDTO.getPayerAsNO());
						String payerLegNo = checkForNull(contractAmendmentRptCustomerDomainDTO.getPayerLegNo());
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
						
						if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")) {
							billToPartyLegNo = checkForNull(contractAmendmentRptDomainDTO.getBillToPartyLegNo());
							billToPartyASNO = checkForNull(contractAmendmentRptDomainDTO.getBillToPartySeqNo());
						}
						
						if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-"))
							billToParty = "-";
						else
							if (billToPartyLegNo.equals("-") && !(billToPartyASNO.equals("-")))
								billToParty = billToPartyASNO;
							else
								if (!(billToPartyLegNo.equals("-")) && billToPartyASNO.equals("-"))
									billToParty = billToPartyLegNo;
								else
									billToParty = billToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
						
						if (payerLegNo.equals("-") && payerASNO.equals("-")) {
							payerLegNo = checkForNull(contractAmendmentRptDomainDTO.getPayerLegNo());
							payerASNO = checkForNull(contractAmendmentRptDomainDTO.getPayerSeqNo());
						}
						
						if (payerLegNo.equals("-") && payerASNO.equals("-"))
							payer = "-";
						else
							if (payerLegNo.equals("-") && !(payerASNO.equals("-")))
								payer = payerASNO;
							else
								if (!(payerLegNo.equals("-")) && payerASNO.equals("-"))
									payer = payerLegNo;
								else
									payer = payerLegNo;     // Changed by Anand sugumaran DAD003 BlueHarmony Reports

						Element soldtopartyNode = (Element) document.createElement("soldtoparty");
						customerNode.appendChild(soldtopartyNode);
						soldtopartyNode.setAttribute("id", soldToParty);
						soldtopartyNode.setAttribute("name", checkForNull(contractAmendmentRptCustomerDomainDTO.getSoldToPartyName()));
						
						if(custCount==0) {
							contractAmendmentRptCustomerDomainDTO.setCustType("M");
							custCount++;
						}
						soldtopartyNode.setAttribute("custtype", checkForNull(contractAmendmentRptCustomerDomainDTO.getCustType()));
						
						

						Element billtopartyNode = (Element) document.createElement("billtoparty");
						customerNode.appendChild(billtopartyNode);
						billtopartyNode.setAttribute("id", billToParty);
						if(checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyName()).equals("-")) {
							billtopartyNode.setAttribute("name", checkForNull(contractAmendmentRptDomainDTO.getBillToPartyName()));
						}
						else {
							billtopartyNode.setAttribute("name", checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyName()));
						}
						
						Element payerNode = (Element) document.createElement("payer");
						customerNode.appendChild(payerNode);
						payerNode.setAttribute("id", payer);
						if(checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyName()).equals("-")) {
							payerNode.setAttribute("name", checkForNull(contractAmendmentRptDomainDTO.getPayerName()));
						}
						else {
							payerNode.setAttribute("name", checkForNull(contractAmendmentRptCustomerDomainDTO.getPayerName()));
						}
		
						customerNode.setAttribute("totalcalculatedprice", parseAmount(contractAmendmentRptCustomerDomainDTO.getTotalCalculatedPrice()));
						customerNode.setAttribute("totalmonthprice", parseAmount(contractAmendmentRptCustomerDomainDTO.getTotalMonthlyPrice()));

						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext()) {

							Element dmNode = (Element) document.createElement("dm");
							customerNode.appendChild(dmNode);
	
							ContractAmendmentRptDMDomainDTO contractAmendmentRptDMDomainDTO = (ContractAmendmentRptDMDomainDTO) dmListIterator.next();

							dmNode.setAttribute("dmnumber", checkForNull(contractAmendmentRptDMDomainDTO.getDesgMcNo()));
							dmNode.setAttribute("dmdescription", checkForNull(contractAmendmentRptDMDomainDTO.getDesgMcDesc()));

							List swoLists = contractAmendmentRptDMDomainDTO.getSWODomainDTO();
							if (null != swoLists) {
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext()) {

									Element swoNode = (Element) document.createElement("swo");
									dmNode.appendChild(swoNode);

									ContractAmendmentRptSWODomainDTO contractAmendmentRptSWODomainDTO = (ContractAmendmentRptSWODomainDTO) swoListsIterator.next();

									swoNode.setAttribute("swonumber", checkForNull(contractAmendmentRptSWODomainDTO.getSWONo()));
									swoNode.setAttribute("swodescription", checkForNull(contractAmendmentRptSWODomainDTO.getDescription()));
									swoNode.setAttribute("serialnumber", checkForNull(contractAmendmentRptSWODomainDTO.getSerialNo()));
									swoNode.setAttribute("plannedstartdate", formatDate(contractAmendmentRptSWODomainDTO.getPlanStartDate()));
									swoNode.setAttribute("plannedenddate", formatDate(contractAmendmentRptSWODomainDTO.getPlanEndDate()));
									swoNode.setAttribute("calculatedprice", parseAmount(contractAmendmentRptSWODomainDTO.getCalculatedPrice()));
									if(contractAmendmentRptSWODomainDTO.getAlternatePrice()!=0) {
										swoNode.setAttribute("monthprice", parseAmount(contractAmendmentRptSWODomainDTO.getAlternatePrice()));
									}
									else {
										swoNode.setAttribute("monthprice", parseAmount(contractAmendmentRptSWODomainDTO.getESWPrice()));
									}
									
									
									swoNode.setAttribute("eswprice", parseAmount(contractAmendmentRptSWODomainDTO.getESWPrice()));
									swoNode.setAttribute("adjustmentamount", parseAmount(contractAmendmentRptSWODomainDTO.getAdjustmentAmt()));
	
									Element eeNode = (Element) document.createElement("ee");
									swoNode.appendChild(eeNode);
									List swoEELists = contractAmendmentRptSWODomainDTO.getSWOEEDomainDTOList();
	
									if (null != swoEELists) {
										Iterator swoEEListsIterator = swoEELists.iterator();
	
										if (swoEEListsIterator.hasNext()) {
											ContractAmendmentRptSWOEEDomainDTO contractAmendmentRptSWOEEDomainDTO = (ContractAmendmentRptSWOEEDomainDTO) swoEEListsIterator.next();
	
											swoNode.setAttribute("valuemetricdesc", checkForNull(contractAmendmentRptSWOEEDomainDTO.getValueMetricDescription()));
											swoNode.setAttribute("uselevel", checkForNull(contractAmendmentRptSWOEEDomainDTO.getUseLevel()));
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
		if(contractAmendmentRptDomainDTO.getProposalContent().equals("S") || contractAmendmentRptDomainDTO.getProposalContent().equals("A")) {
			customerLists = contractAmendmentRptDomainDTO.getSSCustomerDomainDTOList();
			custCount = 0;
			
			if (null != customerLists) {
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext()) {
					
					ContractAmendmentRptCustomerDomainDTO contractAmendmentRptCustomerDomainDTO = new ContractAmendmentRptCustomerDomainDTO();
					contractAmendmentRptCustomerDomainDTO = (ContractAmendmentRptCustomerDomainDTO) customerListsIterator.next();
					
					List dmLists = contractAmendmentRptCustomerDomainDTO.getSSDmDomainTO();
					
					if (null != dmLists && dmLists.size() > 0) {
						Element customerNode = (Element) document.createElement("customer");
						root.appendChild(customerNode);

						String soldToPartyASNO = checkForNull(contractAmendmentRptCustomerDomainDTO.getSoldToPartyAsNo());
						String soldToPartyLegNo = checkForNull(contractAmendmentRptCustomerDomainDTO.getSoldToPartyLegNo());
						String billToPartyASNO = checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyAsNo());
						String billToPartyLegNo = checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyLegNo());
						String payerASNO = checkForNull(contractAmendmentRptCustomerDomainDTO.getPayerAsNO());
						String payerLegNo = checkForNull(contractAmendmentRptCustomerDomainDTO.getPayerLegNo());
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
						
						if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")) {
							billToPartyLegNo = checkForNull(contractAmendmentRptDomainDTO.getBillToPartyLegNo());
							billToPartyASNO = checkForNull(contractAmendmentRptDomainDTO.getBillToPartySeqNo());
						}
						
						if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-"))
							billToParty = "-";
						else
							if (billToPartyLegNo.equals("-") && !(billToPartyASNO.equals("-")))
								billToParty = billToPartyASNO;
							else
								if (!(billToPartyLegNo.equals("-")) && billToPartyASNO.equals("-"))
									billToParty = billToPartyLegNo;
								else
									billToParty = billToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
						
						if (payerLegNo.equals("-") && payerASNO.equals("-")) {
							payerLegNo = checkForNull(contractAmendmentRptDomainDTO.getPayerLegNo());
							payerASNO = checkForNull(contractAmendmentRptDomainDTO.getPayerSeqNo());
						}
						
						if (payerLegNo.equals("-") && payerASNO.equals("-"))
							payer = "-";
						else
							if (payerLegNo.equals("-") && !(payerASNO.equals("-")))
								payer = payerASNO;
							else
								if (!(payerLegNo.equals("-")) && payerASNO.equals("-"))
									payer = payerLegNo;
								else
									payer = payerLegNo;   // Changed by Anand sugumaran DAD003 BlueHarmony Reports

						Element soldtopartyNode = (Element) document.createElement("soldtoparty");
						customerNode.appendChild(soldtopartyNode);
						soldtopartyNode.setAttribute("id", soldToParty);
						soldtopartyNode.setAttribute("name", checkForNull(contractAmendmentRptCustomerDomainDTO.getSoldToPartyName()));
						
						if(custCount==0) {
							contractAmendmentRptCustomerDomainDTO.setCustType("S");
							custCount++;
						}
						soldtopartyNode.setAttribute("custtype", checkForNull(contractAmendmentRptCustomerDomainDTO.getCustType()));
						
						Element billtopartyNode = (Element) document.createElement("billtoparty");
						customerNode.appendChild(billtopartyNode);
						billtopartyNode.setAttribute("id", billToParty);
						if(checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyName()).equals("-")) {
							billtopartyNode.setAttribute("name", checkForNull(contractAmendmentRptDomainDTO.getBillToPartyName()));
						}
						else {
							billtopartyNode.setAttribute("name", checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyName()));
						}
						
						Element payerNode = (Element) document.createElement("payer");
						customerNode.appendChild(payerNode);
						payerNode.setAttribute("id", payer);
						if(checkForNull(contractAmendmentRptCustomerDomainDTO.getBillToPartyName()).equals("-")) {
							payerNode.setAttribute("name", checkForNull(contractAmendmentRptDomainDTO.getPayerName()));
						}
						else {
							payerNode.setAttribute("name", checkForNull(contractAmendmentRptCustomerDomainDTO.getPayerName()));
						}
		
						customerNode.setAttribute("totalcalculatedprice", parseAmount(contractAmendmentRptCustomerDomainDTO.getTotalCalculatedPrice()));
						customerNode.setAttribute("totalmonthprice", parseAmount(contractAmendmentRptCustomerDomainDTO.getTotalMonthlyPrice()));

						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext()) {

							Element dmNode = (Element) document.createElement("dm");
							customerNode.appendChild(dmNode);
	
							ContractAmendmentRptDMDomainDTO contractAmendmentRptDMDomainDTO = (ContractAmendmentRptDMDomainDTO) dmListIterator.next();

							dmNode.setAttribute("dmnumber", checkForNull(contractAmendmentRptDMDomainDTO.getDesgMcNo()));
							dmNode.setAttribute("dmdescription", checkForNull(contractAmendmentRptDMDomainDTO.getDesgMcDesc()));

							List swoLists = contractAmendmentRptDMDomainDTO.getSSSWODomainDTOList();
							if (null != swoLists) {
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext()) {
									Element swoNode = (Element) document.createElement("swo");
									dmNode.appendChild(swoNode);

									ContractAmendmentRptSWODomainDTO contractAmendmentRptSWODomainDTO = (ContractAmendmentRptSWODomainDTO) swoListsIterator.next();

									swoNode.setAttribute("swonumber", checkForNull(contractAmendmentRptSWODomainDTO.getSWONo()));
									swoNode.setAttribute("swodescription", checkForNull(contractAmendmentRptSWODomainDTO.getDescription()));
									swoNode.setAttribute("serialnumber", checkForNull(contractAmendmentRptSWODomainDTO.getSerialNo()));
									swoNode.setAttribute("plannedstartdate", formatDate(contractAmendmentRptSWODomainDTO.getPlanStartDate()));
									swoNode.setAttribute("plannedenddate", formatDate(contractAmendmentRptSWODomainDTO.getPlanEndDate()));
									swoNode.setAttribute("calculatedprice", parseAmount(contractAmendmentRptSWODomainDTO.getCalculatedPrice()));
									if(contractAmendmentRptSWODomainDTO.getAlternatePrice()!=0) {
										swoNode.setAttribute("monthprice", parseAmount(contractAmendmentRptSWODomainDTO.getAlternatePrice()));
									}
									else {
										swoNode.setAttribute("monthprice", parseAmount(contractAmendmentRptSWODomainDTO.getESWPrice()));
									}
									
									
									swoNode.setAttribute("eswprice", parseAmount(contractAmendmentRptSWODomainDTO.getESWPrice()));
									swoNode.setAttribute("adjustmentamount", parseAmount(contractAmendmentRptSWODomainDTO.getAdjustmentAmt()));
	
									Element eeNode = (Element) document.createElement("ee");
									swoNode.appendChild(eeNode);
									List swoEELists = contractAmendmentRptSWODomainDTO.getSWOEEDomainDTOList();
	
									if (null != swoEELists) {
										Iterator swoEEListsIterator = swoEELists.iterator();
	
										if (swoEEListsIterator.hasNext()) {
											ContractAmendmentRptSWOEEDomainDTO contractAmendmentRptSWOEEDomainDTO = (ContractAmendmentRptSWOEEDomainDTO) swoEEListsIterator.next();
	
											swoNode.setAttribute("valuemetricdesc", checkForNull(contractAmendmentRptSWOEEDomainDTO.getValueMetricDescription()));
											swoNode.setAttribute("uselevel", checkForNull(contractAmendmentRptSWOEEDomainDTO.getUseLevel()));
										}
									}
								}
							}
						}
					}
				}
			}
		}		
		
		super.setDocument(document);
	}
	
	/**
     * convertToHTML
     * 
     * @param customDTO
     * @author thirumalai
     */
    private void convertToHTML(ContractAmendmentReportCustomDTO customDTO){
		StringBuffer buffer = new StringBuffer();

		buffer.append("<html xml:lang=\"en\" lang=\"en\">\n");
		buffer.append("<head>\n");
		buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\n");
		buffer.append("<meta name=\"Version\" content=\"1.0\" />\n");
		buffer.append("<meta name=\"DC.Rights\" content=\"Copyright (c) 2003 by IBM Corporation\" />\n");
		buffer.append("<title>Contract amendment report</title>\n");
		buffer.append("</head>\n");
		buffer.append("<body>\n");
		
		buffer.append("<center>\n");

		buffer.append("<table border=\"0\" lotus_anchor=\"A4..S14\" width=\"1120\">");
		buffer.append("<lotus_global align=\"center\" valign=\"bottom\" lotus_format=\"General\" height=\"19\" width=\"81\" grid=\"OFF\" gridcolor=\"#cccccc\"></lotus_global>");
		buffer.append("<tr>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">&#160;</td>");
		buffer.append("</tr>");
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><p style=\"color:red;\">IBM Confidential</p></td></tr>\n");
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\"><strong>Contract amendment report</strong></td></tr>\n");
		
		
		ContractAmendmentRptDomainDTO reportDTO = customDTO.getReportDTO();
		
		if(null != reportDTO){
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><strong>Report printed : "+formatDate(reportDTO.getRptPrintedDate())+" </strong></td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">Contract period : "+formatDate(reportDTO.getContractStartDate())+" &#160;-&#160; "+formatDate(reportDTO.getContractEndDate())+" </td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">Amend effective date : "+formatDate(reportDTO.getAmmendmentEffectiveDate())+"</td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">TVM rate : "+parseAmount(reportDTO.getTvmRate())+" &#160;%&#160;Planned growth : "+parseAmount(reportDTO.getPlannedGrowthRate())+" &#160;%"+" </td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">"+checkForNull(reportDTO.getContractName())+" &#160;("+checkForNull(reportDTO.getContractNo())+")</td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
			
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"5\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\"><strong>Designated Machine</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"3\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"5\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\"><strong>SWO</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"4\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\"><strong>Billing</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"3\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>MLC</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>Contract</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>Adjustment</strong></td>");
			buffer.append("</tr>\n");
			
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"3\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"><strong>Number</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"><strong>Value metric description</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"><strong>Use Level</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"><strong>SWO number</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"><strong>Serial number</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\"><strong>Plan start date</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\"><strong>Plan end date</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"3\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>Total(C1)</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>Total(C2)</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>Amount</strong></td>");
			buffer.append("</tr>\n");
		
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"8\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"><strong>Description</strong></td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"17\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"><strong>Description</strong></td>");
			buffer.append("</tr>\n");
			
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">&#160;</td>");
			buffer.append("</tr>\n");
						
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">&#160;</td>");
			buffer.append("</tr>\n");
			
			
		
			if(reportDTO.getProposalContent().equals("M") || reportDTO.getProposalContent().equals("A")) {
				List customers = reportDTO.getCustomerDomainDTOList();
				if(null != customers && 0 < customers.size()){
					for(int i=0, size=customers.size(); i<size; i++){
						ContractAmendmentRptCustomerDomainDTO customer = (ContractAmendmentRptCustomerDomainDTO)customers.get(i);
						if(i==0) {
							buffer.append("<tr>\n");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"6\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">\n");
							buffer.append("<strong>MLC products</strong>\n");
							buffer.append("</td>\n");
							buffer.append("</tr>\n");
						}
						if(checkForNull(customer.getBillToPartyName()).equals("-")) {
							customer.setBillToPartyName(reportDTO.getBillToPartyName());
						}
						if(checkForNull(customer.getPayerName()).equals("-")) {
							customer.setPayerName(reportDTO.getPayerName());
						}
						buffer.append(getCustomer(customer,reportDTO, true));
					}
				}
			}

			if(reportDTO.getProposalContent().equals("S") || reportDTO.getProposalContent().equals("A")) {
				List customers = reportDTO.getSSCustomerDomainDTOList();
				if(null != customers && 0 < customers.size()){
					for(int i=0, size=customers.size(); i<size; i++){
						ContractAmendmentRptCustomerDomainDTO customer = (ContractAmendmentRptCustomerDomainDTO)customers.get(i);
						if(i==0) {
							buffer.append("<tr>\n");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"6\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">\n");
							buffer.append("<strong>S&amp;S products</strong>\n");
							buffer.append("</td>\n");
							buffer.append("</tr>\n");
						}
						if(checkForNull(customer.getBillToPartyName()).equals("-")) {
							customer.setBillToPartyName(reportDTO.getBillToPartyName());
						}
						if(checkForNull(customer.getPayerName()).equals("-")) {
							customer.setPayerName(reportDTO.getPayerName());
						}
						buffer.append(getCustomer(customer,reportDTO, false));
					}
				}
			}
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"17\" height=\"19\"><strong>Total for contract attachment &#160;:</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>"+parseAmount(reportDTO.getTotalMonthlyPrice())+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(reportDTO.getTotalCalculatedPrice())+"</strong></td>\n");
			buffer.append("</tr>\n");
		}
		
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"25\" height=\"19\"></td>\n");
		buffer.append("</tr>\n");
		
		buffer.append("<tr>\n");
		if(reportDTO.getBillingFreq().equals("M")) {
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;Monthly amendment :</td>");
		}
		else if(reportDTO.getBillingFreq().equals("Q")) {
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;Quarterly amendment :</td>");
		}
		else if(reportDTO.getBillingFreq().equals("A")) {
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;Annual amendment :</td>");
		}
		else if(reportDTO.getBillingFreq().equals("S")) {
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;Semi-Annual amendment :</td>");
		}
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>"+parseAmount(reportDTO.getTotalCalculatedPrice())+"</strong></td>");
		buffer.append("</tr>\n");
		
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;Adjustment amount :</td>");
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>"+parseAmount(reportDTO.getAdjustmentAmt())+"</strong></td>");
		buffer.append("</tr>\n");
		
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;Amount previously billed :</td>");
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>"+parseAmount(reportDTO.getAmendBilledPrev())+"</strong></td>");
		buffer.append("</tr>\n");
				
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;Amendment total :</td>");
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>"+parseAmount(reportDTO.getAmendTotal())+"</strong></td>");
		buffer.append("</tr>\n");
				
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;Original contract total :</td>");
		buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\"><strong>"+parseAmount(reportDTO.getOriginalContractTotal())+"</strong></td>");
		buffer.append("</tr>\n");
		
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"20\" height=\"19\">&#160;</td>");
		buffer.append("</tr>\n");
						
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"25\" height=\"19\">C1 : MLC(Monthly License Charge) - For each sold to party, designated machine and SWO, shows what MLC charge would be without a contract agreement</td>\n");
		buffer.append("</tr>\n");
		
		buffer.append("<tr>\n");
		buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"25\" height=\"19\">C2 : Contract billing period- The amount the sold to party will pay IBM based on the selected billing frequency- monthly, quarterly, semi-annually,annually. The price includes TVM(Time Value of Money)</td>\n");
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
     * @param reportDTO
     * @param mlcProducts
     * @return
     * @author thirumalai
     */
    private String getCustomer(ContractAmendmentRptCustomerDomainDTO customer,ContractAmendmentRptDomainDTO reportDTO, boolean mlcProducts){
		StringBuffer buffer = new StringBuffer();
		List dms = null;
		if(mlcProducts) {
			dms = customer.getDMDomainDTOList();	 
		}
		else {
			dms = customer.getSSDmDomainTO();
		}
		
		if(null != dms && 0 < dms.size()){
			String soldToPartyASNO = checkForNull(customer.getSoldToPartyAsNo());
			String soldToPartyLegNo = checkForNull(customer.getSoldToPartyLegNo());
			String billToPartyASNO = checkForNull(customer.getBillToPartyAsNo());
			String billToPartyLegNo = checkForNull(customer.getBillToPartyLegNo());
			String payerASNO = checkForNull(customer.getPayerAsNO());
			String payerLegNo = checkForNull(customer.getPayerLegNo());
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
						
			if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")) {
				billToPartyLegNo = checkForNull(reportDTO.getBillToPartyLegNo());
				billToPartyASNO = checkForNull(reportDTO.getBillToPartySeqNo());
			}
						
			if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-"))
				billToParty = "-";
			else
				if (billToPartyLegNo.equals("-") && !(billToPartyASNO.equals("-")))
					billToParty = billToPartyASNO;
				else
					if (!(billToPartyLegNo.equals("-")) && billToPartyASNO.equals("-"))
						billToParty = billToPartyLegNo;
					else
						billToParty = billToPartyLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
				
			if (payerLegNo.equals("-") && payerASNO.equals("-")) {
				payerLegNo = checkForNull(reportDTO.getPayerLegNo());
				payerASNO = checkForNull(reportDTO.getPayerSeqNo());
			}
						
			if (payerLegNo.equals("-") && payerASNO.equals("-"))
				payer = "-";
			else
				if (payerLegNo.equals("-") && !(payerASNO.equals("-")))
					payer = payerASNO;
				else
					if (!(payerLegNo.equals("-")) && payerASNO.equals("-"))
						payer = payerLegNo;
					else
						payer = payerLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports
						
						
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\"><strong>Sold to party&#160;:&#160;"+soldToParty+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\"><strong>Bill to party&#160;:&#160;"+billToParty+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\"><strong>Payer&#160;:&#160;"+payer+"</strong></td>\n");
			buffer.append("</tr>\n");
		
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\">"+checkForNull(customer.getSoldToPartyName())+"</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\">"+checkForNull(customer.getBillToPartyName())+"</td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\">"+checkForNull(customer.getPayerName())+"</td>\n");
			buffer.append("</tr>\n");
			
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"30\" height=\"19\">&#160;</td>\n");
			buffer.append("</tr>\n");
			
			for(int dmCounter=0, dmSize=dms.size(); dmCounter<dmSize; dmCounter++){
				ContractAmendmentRptDMDomainDTO dm = (ContractAmendmentRptDMDomainDTO)dms.get(dmCounter);
				if(null != dm){

					List swos = null;
					
					if(mlcProducts) {
						swos = dm.getSWODomainDTO();	 
					}
					else {
						swos = dm.getSSSWODomainDTOList();
					}
					if(null != swos && 0 < swos.size()){

						buffer.append("<tr>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"3\" height=\"19\">"+checkForNull(dm.getDesgMcNo())+"</td>");

						for(int swoCounter=0, swoSize=swos.size(); swoCounter<swoSize; swoCounter++){
							ContractAmendmentRptSWODomainDTO swo = (ContractAmendmentRptSWODomainDTO)swos.get(swoCounter);
							if(swoCounter!=0) {
								buffer.append("<tr><td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"3\" height=\"19\">&#160;</td>");
							}
							if(null != swo){
								List ees = swo.getSWOEEDomainDTOList();
								if(null != ees && 0 < ees.size()){
									ContractAmendmentRptSWOEEDomainDTO ee = (ContractAmendmentRptSWOEEDomainDTO)ees.get(0);
									if(null != ee){
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(ee.getValueMetricDescription())+"</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(ee.getUseLevel())+"</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"1\" height=\"19\"></td>\n");
									}
								}
								
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(swo.getSWONo())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(swo.getSerialNo())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"1\" height=\"19\"></td>\n");
								
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+formatDate(swo.getPlanStartDate())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+formatDate(swo.getPlanEndDate())+"</td>\n");
								if(swo.getAlternatePrice()!=0) {	
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" colspan=\"3\" width=\"124\" height=\"19\">"+parseAmount(swo.getAlternatePrice())+"</td>\n");
								}
								else {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" colspan=\"3\" width=\"124\" height=\"19\">"+parseAmount(swo.getESWPrice())+"</td>\n");
								}
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(swo.getCalculatedPrice())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(swo.getAdjustmentAmt())+"</td>\n");
								buffer.append("</tr>\n");
								if(swoCounter==0) {		
									buffer.append("<tr>\n");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"8\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">"+checkForNull(dm.getDesgMcDesc())+"</td>");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"17\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">"+checkForNull(swo.getDescription())+"</td>");
									buffer.append("</tr>\n");
								}
								else {
									buffer.append("<tr>\n");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"8\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"></td>");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"17\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\"></td>");
									buffer.append("</tr>\n");
								}
							}
						}
					}
				}
			}
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"17\" height=\"19\"><strong>Total for customer&#160;("+soldToParty+")&#160;:</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"3\" height=\"19\"><strong>"+parseAmount(customer.getTotalMonthlyPrice())+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(customer.getTotalCalculatedPrice())+"</strong></td>\n");
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
}
