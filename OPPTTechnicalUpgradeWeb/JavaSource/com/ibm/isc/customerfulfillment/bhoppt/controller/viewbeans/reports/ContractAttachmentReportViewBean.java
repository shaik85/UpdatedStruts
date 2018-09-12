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

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractAttachmentReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;

/**
 * Holds complete data about contract Attachment report  
 * 
 * <br/><strong>Known Bugs</strong><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Prakash Mall
 * @version 5.1A
 */
public class ContractAttachmentReportViewBean extends ReportViewBean {

	/**
	 * convertToDOM
	 * 
	 * @param contractAttachmentReportCustomDTO
	 */
	private void convertToDOM(ContractAttachmentReportCustomDTO contractAttachmentReportCustomDTO) {
		Document document = null;

		document = createDocument();
		ContractAttchRptDomainDTO contractAttachmentRptDomainDTO = contractAttachmentReportCustomDTO.getReportDTO();
		// Insert Root Order
		Element root = (Element) document.createElement("contractAttachmentreport");
		// Insert child Manifest
		document.appendChild(root);
		root.setAttribute("reportprinteddate", formatDate(contractAttachmentRptDomainDTO.getRptPrintedDate()));
		root.setAttribute("contractstartdate", formatDate(contractAttachmentRptDomainDTO.getContractStartDate()));
		root.setAttribute("contractenddate", formatDate(contractAttachmentRptDomainDTO.getContractEndDate()));
		root.setAttribute("tvmrate", parseAmount(contractAttachmentRptDomainDTO.getTvmRate()));
		root.setAttribute("plannedgrowthrate", parseAmount(contractAttachmentRptDomainDTO.getPlannedGrowthRate()));
		root.setAttribute("contractnumber", checkForNull(contractAttachmentRptDomainDTO.getContractNumber()));
		root.setAttribute("proposalname", checkForNull(contractAttachmentRptDomainDTO.getProposalName()));
		root.setAttribute("totalcalculatedprice", parseAmount(contractAttachmentRptDomainDTO.getCalculatedPrice()));
		root.setAttribute("totaleswprice", parseAmount(contractAttachmentRptDomainDTO.getTotalESWPrice()));
		root.setAttribute("totalalternateprice", parseAmount(contractAttachmentRptDomainDTO.getTotalAlternatePrice()));
		root.setAttribute("billingfrequency", checkForNull(contractAttachmentRptDomainDTO.getBillingFreq()));
		root.setAttribute("annualinvoiceamount", parseAmount(contractAttachmentRptDomainDTO.getAnnualInvoiceFreqAmt()));
		root.setAttribute("semiannualinvoiceamount", parseAmount(contractAttachmentRptDomainDTO.getSemiAnnualInvoiceFreqAmt()));
		root.setAttribute("quarterlyinvoiceamount", parseAmount(contractAttachmentRptDomainDTO.getQurtInvoiceFreqAmt()));
		root.setAttribute("monthlyinvoiceamount", parseAmount(contractAttachmentRptDomainDTO.getMonthlyInvoiceFreqAmt()));

		if (contractAttachmentReportCustomDTO.isDraft()) {
			root.setAttribute("draft", "draft");
		} else {
			root.setAttribute("draft", " ");
		}
		
		/*	For MLC details	*/
		List customerLists = contractAttachmentRptDomainDTO.getCustomerDomainDTOList();
		int custCount = 0;
		
		if(contractAttachmentRptDomainDTO.getProposalContent().equals("M") || contractAttachmentRptDomainDTO.getProposalContent().equals("A")) {
			
			if (null != customerLists) {
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext()) {
					ContractAttchRptCustomerDomainDTO contractAttachmentRptCustomerDomainDTO = new ContractAttchRptCustomerDomainDTO();
					
					contractAttachmentRptCustomerDomainDTO = (ContractAttchRptCustomerDomainDTO) customerListsIterator.next();
					
					List dmLists = contractAttachmentRptCustomerDomainDTO.getDmDomainTO();
	
					if (null != dmLists && dmLists.size() > 0) {
						
						Element customerNode = (Element) document.createElement("customer");
						root.appendChild(customerNode);

						String soldToPartyASNO = checkForNull(contractAttachmentRptCustomerDomainDTO.getSoldToPartyASNO());
						String soldToPartyLegNo = checkForNull(contractAttachmentRptCustomerDomainDTO.getSoldToPartyLegNo());
						String billToPartyASNO = checkForNull(contractAttachmentRptCustomerDomainDTO.getBillToPartyASNO());
						String billToPartyLegNo = checkForNull(contractAttachmentRptCustomerDomainDTO.getBillToPartyLegNo());
						String payerASNO = checkForNull(contractAttachmentRptCustomerDomainDTO.getPayerASNO());
						String payerLegNo = checkForNull(contractAttachmentRptCustomerDomainDTO.getPayerLegNo());
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
							billToPartyLegNo = checkForNull(contractAttachmentRptDomainDTO.getBillToPartyLegNo());
							billToPartyASNO = checkForNull(contractAttachmentRptDomainDTO.getBillToPartySeqNo());
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
									billToParty = billToPartyLegNo; // Changed by Anand sugumaran DAD003 BlueHarmony Reports
						
						if (payerLegNo.equals("-") && payerASNO.equals("-")) {
							payerLegNo = checkForNull(contractAttachmentRptDomainDTO.getPayerLegNo());
							payerASNO = checkForNull(contractAttachmentRptDomainDTO.getPayerSeqNo());
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
		
						Element soldtopartyNode = (Element) document.createElement("soldtoparty");
						customerNode.appendChild(soldtopartyNode);
						soldtopartyNode.setAttribute("id", soldToParty);
						soldtopartyNode.setAttribute("name", checkForNull(contractAttachmentRptCustomerDomainDTO.getSoldToPartyName()));
						if(custCount==0) {
							contractAttachmentRptCustomerDomainDTO.setCustType("M");
							custCount++;
						}
						soldtopartyNode.setAttribute("custtype", checkForNull(contractAttachmentRptCustomerDomainDTO.getCustType()));
		
						Element billtopartyNode = (Element) document.createElement("billtoparty");
						customerNode.appendChild(billtopartyNode);
						billtopartyNode.setAttribute("id", billToParty);
						if(checkForNull(contractAttachmentRptCustomerDomainDTO.getBillToPartyName()).equals("-")) {
							billtopartyNode.setAttribute("name", checkForNull(contractAttachmentRptDomainDTO.getBillToPartyName()));
						}
						else {
							billtopartyNode.setAttribute("name", checkForNull(contractAttachmentRptCustomerDomainDTO.getBillToPartyName()));
						}
	
						Element payerNode = (Element) document.createElement("payer");
						customerNode.appendChild(payerNode);
						payerNode.setAttribute("id", payer);
						if(checkForNull(contractAttachmentRptCustomerDomainDTO.getPayerName()).equals("-")) {
							payerNode.setAttribute("name", checkForNull(contractAttachmentRptDomainDTO.getPayerName()));	
						}
						else {
							payerNode.setAttribute("name", checkForNull(contractAttachmentRptCustomerDomainDTO.getPayerName()));
						}
						
						customerNode.setAttribute("totalcalculatedprice", parseAmount(contractAttachmentRptCustomerDomainDTO.getTotalCalculatedPrice()));
						customerNode.setAttribute("totalalternateprice", parseAmount(contractAttachmentRptCustomerDomainDTO.getTotalAlternatePrice()));
						customerNode.setAttribute("totaleswprice", parseAmount(contractAttachmentRptCustomerDomainDTO.getTotalESWPrice()));
	
						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext()) {
	
							Element dmNode = (Element) document.createElement("dm");
							customerNode.appendChild(dmNode);
	
							ContractAttchRptDMDDomainTO contractAttachmentRptDMDomainDTO = (ContractAttchRptDMDDomainTO) dmListIterator.next();
	
							dmNode.setAttribute("number", checkForNull(contractAttachmentRptDMDomainDTO.getDesgMcNo()));
							dmNode.setAttribute("description", checkForNull(contractAttachmentRptDMDomainDTO.getDescMcDesc()));
	
							List swoLists = contractAttachmentRptDMDomainDTO.getSWODomainDTOList();
							if (null != swoLists) {
								
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext()) {
	
									Element swoNode = (Element) document.createElement("swo");
									dmNode.appendChild(swoNode);
	
									ContractAttchRptSWODomainDTO contractAttachmentRptSWODomainDTO = (ContractAttchRptSWODomainDTO) swoListsIterator.next();
	
									swoNode.setAttribute("number", checkForNull(contractAttachmentRptSWODomainDTO.getSWONo()));
									swoNode.setAttribute("description", checkForNull(contractAttachmentRptSWODomainDTO.getDesc()));
									swoNode.setAttribute("serialnumber", checkForNull(contractAttachmentRptSWODomainDTO.getSerialNo()));
									if(checkForNull(contractAttachmentRptSWODomainDTO.getIndicator()).equals("V")) {
										swoNode.setAttribute("indicator","SVC");
									}
									else {
										swoNode.setAttribute("indicator","-");
									}
									swoNode.setAttribute("plannedstartdate", formatDate(contractAttachmentRptSWODomainDTO.getPlanStartDate()));
									swoNode.setAttribute("plannedenddate", formatDate(contractAttachmentRptSWODomainDTO.getPlanEndDate()));
									swoNode.setAttribute("calculatedprice", parseAmount(contractAttachmentRptSWODomainDTO.getCalculatedPrice()));
									swoNode.setAttribute("alternateprice", parseAmount(contractAttachmentRptSWODomainDTO.getAlternatePrice()));
									swoNode.setAttribute("eswprice", parseAmount(contractAttachmentRptSWODomainDTO.getESWPrice()));
									swoNode.setAttribute("comments", checkForNull(contractAttachmentRptSWODomainDTO.getComments()));
	
									Element eeNode = (Element) document.createElement("ee");
									swoNode.appendChild(eeNode);
									List swoEELists = contractAttachmentRptSWODomainDTO.getSWOEEDomainDTOList();
	
									if (null != swoEELists) {
										Iterator swoEEListsIterator = swoEELists.iterator();
	
										if (swoEEListsIterator.hasNext()) {
											ContractAttchRptSWOEEDomainDTO contractAttachmentRptSWOEEDomainDTO = (ContractAttchRptSWOEEDomainDTO) swoEEListsIterator.next();
	
											swoNode.setAttribute("valuemetricdesc", checkForNull(contractAttachmentRptSWOEEDomainDTO.getValueMetricDesc()));
											swoNode.setAttribute("uselevel", checkForNull(contractAttachmentRptSWOEEDomainDTO.getUseLevel()));
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
		if(contractAttachmentRptDomainDTO.getProposalContent().equals("S") || contractAttachmentRptDomainDTO.getProposalContent().equals("A")) {
			customerLists = contractAttachmentRptDomainDTO.getSSCustomerDomainDTOList();
			custCount = 0;
			
			if (null != customerLists) {
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext()) {

					ContractAttchRptCustomerDomainDTO contractAttachmentRptCustomerDomainDTO = new ContractAttchRptCustomerDomainDTO();
					contractAttachmentRptCustomerDomainDTO = (ContractAttchRptCustomerDomainDTO) customerListsIterator.next();

					List dmLists = contractAttachmentRptCustomerDomainDTO.getSSDmDomainTO();

					if (null != dmLists && dmLists.size() > 0) {
						Element customerNode = (Element) document.createElement("customer");
						root.appendChild(customerNode);
					
						String soldToPartyASNO = checkForNull(contractAttachmentRptCustomerDomainDTO.getSoldToPartyASNO());
						String soldToPartyLegNo = checkForNull(contractAttachmentRptCustomerDomainDTO.getSoldToPartyLegNo());
						String billToPartyASNO = checkForNull(contractAttachmentRptCustomerDomainDTO.getBillToPartyASNO());
						String billToPartyLegNo = checkForNull(contractAttachmentRptCustomerDomainDTO.getBillToPartyLegNo());
						String payerASNO = checkForNull(contractAttachmentRptCustomerDomainDTO.getPayerASNO());
						String payerLegNo = checkForNull(contractAttachmentRptCustomerDomainDTO.getPayerLegNo());
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
							billToPartyLegNo = checkForNull(contractAttachmentRptDomainDTO.getBillToPartyLegNo());
							billToPartyASNO = checkForNull(contractAttachmentRptDomainDTO.getBillToPartySeqNo());
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
							payerLegNo = checkForNull(contractAttachmentRptDomainDTO.getPayerLegNo());
							payerASNO = checkForNull(contractAttachmentRptDomainDTO.getPayerSeqNo());
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
						soldtopartyNode.setAttribute("name", checkForNull(contractAttachmentRptCustomerDomainDTO.getSoldToPartyName()));
					
						if(custCount==0) {
							contractAttachmentRptCustomerDomainDTO.setCustType("S");
							custCount++;
						}
						soldtopartyNode.setAttribute("custtype", checkForNull(contractAttachmentRptCustomerDomainDTO.getCustType()));
						
						Element billtopartyNode = (Element) document.createElement("billtoparty");
						customerNode.appendChild(billtopartyNode);
						billtopartyNode.setAttribute("id", billToParty);
						if(checkForNull(contractAttachmentRptCustomerDomainDTO.getBillToPartyName()).equals("-")) {
							billtopartyNode.setAttribute("name", checkForNull(contractAttachmentRptDomainDTO.getBillToPartyName()));
						}
						else {
							billtopartyNode.setAttribute("name", checkForNull(contractAttachmentRptCustomerDomainDTO.getBillToPartyName()));
						}
						Element payerNode = (Element) document.createElement("payer");
						customerNode.appendChild(payerNode);
						payerNode.setAttribute("id", payer);
						if(checkForNull(contractAttachmentRptCustomerDomainDTO.getPayerName()).equals("-")) {
							payerNode.setAttribute("name", checkForNull(contractAttachmentRptDomainDTO.getPayerName()));	
						}
						else {
							payerNode.setAttribute("name", checkForNull(contractAttachmentRptCustomerDomainDTO.getPayerName()));
						}
				
						customerNode.setAttribute("totalcalculatedprice", parseAmount(contractAttachmentRptCustomerDomainDTO.getTotalCalculatedPrice()));
						customerNode.setAttribute("totalalternateprice", parseAmount(contractAttachmentRptCustomerDomainDTO.getTotalAlternatePrice()));
						customerNode.setAttribute("totaleswprice", parseAmount(contractAttachmentRptCustomerDomainDTO.getTotalESWPrice()));
						
						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext()) {
							Element dmNode = (Element) document.createElement("dm");
							customerNode.appendChild(dmNode);
							ContractAttchRptDMDDomainTO contractAttachmentRptDMDomainDTO = (ContractAttchRptDMDDomainTO) dmListIterator.next();
							dmNode.setAttribute("number", checkForNull(contractAttachmentRptDMDomainDTO.getDesgMcNo()));
							dmNode.setAttribute("description", checkForNull(contractAttachmentRptDMDomainDTO.getDescMcDesc()));
							
							List swoLists = contractAttachmentRptDMDomainDTO.getSSSWODomainDTOList();

							if (null != swoLists) {
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext()) {
									Element swoNode = (Element) document.createElement("swo");
									dmNode.appendChild(swoNode);
									ContractAttchRptSWODomainDTO contractAttachmentRptSWODomainDTO = (ContractAttchRptSWODomainDTO) swoListsIterator.next();
									swoNode.setAttribute("number", checkForNull(contractAttachmentRptSWODomainDTO.getSWONo()));
									swoNode.setAttribute("description", checkForNull(contractAttachmentRptSWODomainDTO.getDesc()));
									swoNode.setAttribute("serialnumber", checkForNull(contractAttachmentRptSWODomainDTO.getSerialNo()));
									if(checkForNull(contractAttachmentRptSWODomainDTO.getIndicator()).equals("V")) {
										swoNode.setAttribute("indicator","SVC");
									}
									else {
										swoNode.setAttribute("indicator","-");
									}
									swoNode.setAttribute("plannedstartdate", formatDate(contractAttachmentRptSWODomainDTO.getPlanStartDate()));
									swoNode.setAttribute("plannedenddate", formatDate(contractAttachmentRptSWODomainDTO.getPlanEndDate()));
									swoNode.setAttribute("calculatedprice", parseAmount(contractAttachmentRptSWODomainDTO.getCalculatedPrice()));
									swoNode.setAttribute("alternateprice", parseAmount(contractAttachmentRptSWODomainDTO.getAlternatePrice()));
									swoNode.setAttribute("eswprice", parseAmount(contractAttachmentRptSWODomainDTO.getESWPrice()));
									swoNode.setAttribute("comments", checkForNull(contractAttachmentRptSWODomainDTO.getComments()));
									Element eeNode = (Element) document.createElement("ee");
									swoNode.appendChild(eeNode);
									List swoEELists = contractAttachmentRptSWODomainDTO.getSWOEEDomainDTOList();
									if (null != swoEELists) {
										Iterator swoEEListsIterator = swoEELists.iterator();
										if (swoEEListsIterator.hasNext()) {
											ContractAttchRptSWOEEDomainDTO contractAttachmentRptSWOEEDomainDTO = (ContractAttchRptSWOEEDomainDTO) swoEEListsIterator.next();
											swoNode.setAttribute("valuemetricdesc", checkForNull(contractAttachmentRptSWOEEDomainDTO.getValueMetricDesc()));
											swoNode.setAttribute("uselevel", checkForNull(contractAttachmentRptSWOEEDomainDTO.getUseLevel()));
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
     * ContractAttachmentReportViewBean
     * 
     * @author thirumalai
     */
    public ContractAttachmentReportViewBean() {
	}

	/**
     * ContractAttachmentReportViewBean
     * 
     * @param contractAttachmentReportCustomDTO
     * @param view
     * @author thirumalai
     */
    public ContractAttachmentReportViewBean(ContractAttachmentReportCustomDTO contractAttachmentReportCustomDTO, String view) {
		convertToDOM(contractAttachmentReportCustomDTO);
		super.setView(view);
	}
	
	/**
     * ContractAttachmentReportViewBean
     * 
     * @param contractAttachmentReportCustomDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public ContractAttachmentReportViewBean(ContractAttachmentReportCustomDTO contractAttachmentReportCustomDTO, String view,boolean viewReport) {
		if(viewReport){
			convertToDOM(contractAttachmentReportCustomDTO);
		}
		else{
			convertToHTML(contractAttachmentReportCustomDTO);
		}
		setView(view);
	}
	
	/**
     * convertToHTML
     * 
     * @param customDTO
     * @author thirumalai
     */
    protected void convertToHTML(ContractAttachmentReportCustomDTO customDTO){
			StringBuffer buffer = new StringBuffer();
		
			buffer.append("<html xml:lang=\"en\" lang=\"en\">\n");
			buffer.append("<head>\n");
			buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\n");
			buffer.append("<meta name=\"Version\" content=\"1.0\" />\n");
			buffer.append("<meta name=\"DC.Rights\" content=\"Copyright (c) 2003 by IBM Corporation\" />\n");
			buffer.append("<title>Contract attachment report</title>\n");
			buffer.append("</head>\n");
			buffer.append("<body>\n");
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
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\"><strong>Contract attachment report</strong></td></tr>\n");

			ContractAttchRptDomainDTO reportDTO = customDTO.getReportDTO();
			boolean isDraft = customDTO.isDraft();
			
			if(null != reportDTO){
				buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><strong>Report printed : "+formatDate(reportDTO.getRptPrintedDate())+" </strong></td></tr>\n");
				buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">Contract period : "+formatDate(reportDTO.getContractStartDate())+" &#160;-&#160; "+formatDate(reportDTO.getContractEndDate())+" </td></tr>\n");
				buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">TVM rate : "+parseAmount(reportDTO.getTvmRate())+" &#160;%&#160;Planned growth : "+parseAmount(reportDTO.getPlannedGrowthRate())+" &#160;%"+" </td></tr>\n");
				buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">"+checkForNull(reportDTO.getProposalName())+" &#160;("+checkForNull(reportDTO.getContractNumber())+")</td></tr>\n");
				buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
			
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"8\" height=\"19\"><strong>Designated Machine</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"8\" height=\"19\"><strong>SWO</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"4\" height=\"19\"><strong>Billing</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>MLC</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Contract</strong></td>\n");
				if(isDraft) {
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"1\" height=\"19\"><strong>Comments</strong></td>\n");
				}
				buffer.append("</tr>\n");

				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Number</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Description</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Value metric description</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Use level</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>SWO number</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Serial number</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Description</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Indicator</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Plan start date</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Plan end date</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>(C1)</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"2\" height=\"19\"><strong>Billing period amount(C2)</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" colspan=\"1\" height=\"19\">&#160;</td>\n");
				buffer.append("</tr>\n");

				if(reportDTO.getProposalContent().equals("M") || reportDTO.getProposalContent().equals("A")) {
					List customers = reportDTO.getCustomerDomainDTOList();
					if(null != customers && 0 < customers.size()){
						for(int i=0, size=customers.size(); i<size; i++){
							ContractAttchRptCustomerDomainDTO customer = (ContractAttchRptCustomerDomainDTO)customers.get(i);
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
							buffer.append(getCustomer(customer,reportDTO, true, isDraft));
						}
					}
				}

				if(reportDTO.getProposalContent().equals("S") || reportDTO.getProposalContent().equals("A")) {
					List customers = reportDTO.getSSCustomerDomainDTOList();
					if(null != customers && 0 < customers.size()){
						for(int i=0, size=customers.size(); i<size; i++){
							ContractAttchRptCustomerDomainDTO customer = (ContractAttchRptCustomerDomainDTO)customers.get(i);
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
							buffer.append(getCustomer(customer,reportDTO, false, isDraft));
						}
					}
				}

				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"20\" height=\"19\"><strong>Total for contract attachment &#160;:</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(reportDTO.getTotalESWPrice())+"</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(reportDTO.getCalculatedPrice())+"</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"1\" height=\"19\">&#160;</td>\n");
				buffer.append("</tr>\n");
			
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"25\" height=\"19\">&#160;</td>\n");
				buffer.append("</tr>\n");
				
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"25\" height=\"19\"><strong>Invoice frequency and amount(Related to MLC products only)</strong></td>\n");
				buffer.append("</tr>\n");
			
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"16\" height=\"19\">&#160;</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"5\" height=\"19\">Annual</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(reportDTO.getAnnualInvoiceFreqAmt())+"</td>\n");
				if(reportDTO.getBillingFreq().equals("A")) {
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">Selected</td>\n");
				}
				buffer.append("</tr>\n");
				
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"16\" height=\"19\">&#160;</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"5\" height=\"19\">Semi Annual</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(reportDTO.getSemiAnnualInvoiceFreqAmt())+"</td>\n");
				if(reportDTO.getBillingFreq().equals("S")) {
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">Selected</td>\n");
				}
				buffer.append("</tr>\n");
								
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"16\" height=\"19\">&#160;</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"5\" height=\"19\">Quarterly</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(reportDTO.getQurtInvoiceFreqAmt())+"</td>\n");
				if(reportDTO.getBillingFreq().equals("Q")) {
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">Selected</td>\n");
				}
				buffer.append("</tr>\n");
								
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"16\" height=\"19\">&#160;</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"5\" height=\"19\">Monthly</td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(reportDTO.getMonthlyInvoiceFreqAmt())+"</td>\n");
				if(reportDTO.getBillingFreq().equals("M")) {
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">Selected</td>\n");
				}
				buffer.append("</tr>\n");
			}
		
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
     * @param isDraft
     * @return
     * @author thirumalai
     */
    private String getCustomer(ContractAttchRptCustomerDomainDTO customer,ContractAttchRptDomainDTO reportDTO, boolean mlcProducts, boolean isDraft){
		StringBuffer buffer = new StringBuffer();
		List dms = null;
		if(mlcProducts) {
			dms = customer.getDmDomainTO();	 
		}
		else {
			dms = customer.getSSDmDomainTO();
		}
		
		if(null != dms && 0 < dms.size()){
					
			String soldToPartyASNO = checkForNull(customer.getSoldToPartyASNO());
			String soldToPartyLegNo = checkForNull(customer.getSoldToPartyLegNo());
			String billToPartyASNO = checkForNull(customer.getBillToPartyASNO());
			String billToPartyLegNo = checkForNull(customer.getBillToPartyLegNo());
			String payerASNO = checkForNull(customer.getPayerASNO());
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
						soldToParty = soldToPartyLegNo;   // Changed by Anand sugumaran DAD003 BlueHarmony Reports
			
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
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"25\" height=\"19\">&#160;</td>\n");
			buffer.append("</tr>\n");

			for(int dmCounter=0, dmSize=dms.size(); dmCounter<dmSize; dmCounter++){
				ContractAttchRptDMDDomainTO dm = (ContractAttchRptDMDDomainTO)dms.get(dmCounter);
				if(null != dm){
					buffer.append("<tr><td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(dm.getDesgMcNo())+"</td>");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(dm.getDescMcDesc())+"</td>");
						
					List swos = null;
					
					if(mlcProducts) {
						swos = dm.getSWODomainDTOList();	 
					}
					else {
						swos = dm.getSSSWODomainDTOList();
					}
						
					if(null != swos && 0 < swos.size()){
						for(int swoCounter=0, swoSize=swos.size(); swoCounter<swoSize; swoCounter++){
							ContractAttchRptSWODomainDTO swo = (ContractAttchRptSWODomainDTO)swos.get(swoCounter);
							if(swoCounter!=0) {
								buffer.append("<tr><td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">&#160;</td>");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">&#160;</td>");
							}
							if(null != swo){
								List ees = swo.getSWOEEDomainDTOList();
								if(null != ees && 0 < ees.size()){
									ContractAttchRptSWOEEDomainDTO ee = (ContractAttchRptSWOEEDomainDTO)ees.get(0);
									if(null != ee){
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(ee.getValueMetricDesc())+"</td>\n");
										buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(ee.getUseLevel())+"</td>\n");
									}
								}
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(swo.getSWONo())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(swo.getSerialNo())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(swo.getDesc())+"</td>\n");
								if(checkForNull(swo.getIndicator()).equals("V")) {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"2\" height=\"19\">SVC</td>\n");	
								}
								else {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"2\" height=\"19\">-</td>\n");
								}
									
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+formatDate(swo.getPlanStartDate())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+formatDate(swo.getPlanEndDate())+"</td>\n");
									
								if(checkForNull(swo.getComments()).equals("A")) {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" colspan=\"2\" width=\"124\" height=\"19\">"+parseAmount(swo.getAlternatePrice())+"</td>\n");
								}
								else {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" colspan=\"2\" width=\"124\" height=\"19\">"+parseAmount(swo.getESWPrice())+"</td>\n");	
								}
									
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+parseAmount(swo.getCalculatedPrice())+"</td>\n");
									
								if(isDraft) {
									buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"2\" height=\"19\">"+checkForNull(swo.getComments())+"</td>\n");
								}
								buffer.append("</tr>\n");
							}
						}
					}
				}
			}
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"20\" height=\"19\"><strong>Total price for customer&#160;("+soldToParty+")&#160;:</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(customer.getTotalESWPrice())+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" colspan=\"2\" height=\"19\"><strong>"+parseAmount(customer.getTotalCalculatedPrice())+"</strong></td>\n");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"1\" height=\"19\">&#160;</td>\n");
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