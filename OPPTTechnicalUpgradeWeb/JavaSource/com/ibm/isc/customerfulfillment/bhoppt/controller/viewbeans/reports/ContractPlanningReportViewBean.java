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
import org.w3c.dom.Node;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.ReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractPlanningReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractPlanningRptCustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractPlanningRptDMDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractPlanningRptDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractPlanningRptSWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractPlanningRptSWOEEDomainDTO;

/**
 * Holds complete data about contract planning report  
 * 
 * <br/><strong>Known Bugs</strong><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kishore Namballa
 * @version 5.1A
 */
public class ContractPlanningReportViewBean extends ReportViewBean {

	/**
	 * convertToDOM
	 * 
	 * @param contractPlanningReportCustomDTO
	 */
	private void convertToDOM(ContractPlanningReportCustomDTO contractPlanningReportCustomDTO) {
		Document document = null;

		document = createDocument();
		// Insert Root Order
		Element root = (Element) document.createElement("contractplanningreport");
		// Insert child Manifest
		document.appendChild(root);

		ContractPlanningRptDomainDTO contractPlanningRptDomainDTO = contractPlanningReportCustomDTO.getReportDTO();

		addChildNode(document, (Node) root, "reportprinteddate", formatDate(contractPlanningRptDomainDTO.getRptPrintedDate()));
		addChildNode(document, (Node) root, "pricedasof", formatDate(contractPlanningRptDomainDTO.getPriceAsOf()));
		addChildNode(document, (Node) root, "contractstartdate", formatDate(contractPlanningRptDomainDTO.getContractStartDate()));
		addChildNode(document, (Node) root, "contractenddate", formatDate(contractPlanningRptDomainDTO.getContractEndDate()));
		addChildNode(document, (Node) root, "tvmrate", parseAmount(contractPlanningRptDomainDTO.getTvmRate()));
		addChildNode(document, (Node) root, "plannedgrowthrate", parseAmount(contractPlanningRptDomainDTO.getPlannedGrowthRate()));
		addChildNode(document, (Node) root, "proposalname", checkForNull(contractPlanningRptDomainDTO.getProposalName()));
		addChildNode(document, (Node) root, "contractnumber", checkForNull(contractPlanningRptDomainDTO.getContractNumber()));

		addChildNode(document, (Node) root, "totalcalculatedprice", parseAmount(contractPlanningRptDomainDTO.getTotalCalculatedPrice()));
		addChildNode(document, (Node) root, "billingfrequency", checkForNull(contractPlanningRptDomainDTO.getBillingFreq()));
		addChildNode(document, (Node) root, "annualinvoiceamount", parseAmount(contractPlanningRptDomainDTO.getAnnualInvoiceFreqAmt()));
		addChildNode(document, (Node) root, "semiannualinvoiceamount", parseAmount(contractPlanningRptDomainDTO.getSemiAnnualFreqAmt()));
		addChildNode(document, (Node) root, "quarterlyinvoiceamount", parseAmount(contractPlanningRptDomainDTO.getQurtInvoiceFreqAmt()));
		addChildNode(document, (Node) root, "monthlyinvoiceamount", parseAmount(contractPlanningRptDomainDTO.getMonthlyInvoiceFreqAmt()));

		List customerLists = contractPlanningRptDomainDTO.getCustomerDomainDTOList();
		int custCount = 0;

		if (contractPlanningRptDomainDTO.getProposalContent().equals("M") || contractPlanningRptDomainDTO.getProposalContent().equals("A")) {
			if (null != customerLists) {
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext()) {

					ContractPlanningRptCustomerDomainDTO contractPlanningRptCustomerDomainDTO = new ContractPlanningRptCustomerDomainDTO();
					contractPlanningRptCustomerDomainDTO = (ContractPlanningRptCustomerDomainDTO) customerListsIterator.next();

					List dmLists = contractPlanningRptCustomerDomainDTO.getIDMDomainDTOListO();
					if (null != dmLists && dmLists.size() > 0) {

						Node customerNode = document.createElement("customer");
						root.appendChild(customerNode);

						String soldToPartyASNO = checkForNull(contractPlanningRptCustomerDomainDTO.getSoldToPartyASNO());
						String soldToPartyLegNo = checkForNull(contractPlanningRptCustomerDomainDTO.getSoldToPartyLegNo());
						String billToPartyASNO = checkForNull(contractPlanningRptCustomerDomainDTO.getBillToPartyASNO());
						String billToPartyLegNo = checkForNull(contractPlanningRptCustomerDomainDTO.getBillToPartyLegNo());
						String payerASNO = checkForNull(contractPlanningRptCustomerDomainDTO.getPayerASNO());
						String payerLegNo = checkForNull(contractPlanningRptCustomerDomainDTO.getPayerLegNo());
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
							soldToParty = soldToPartyLegNo; // Changed by Anand sugumaran DAD003 BlueHarmony Reports

						if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-")) {
							billToPartyLegNo = checkForNull(contractPlanningRptDomainDTO.getBillToPartyLegNo());
							billToPartyASNO = checkForNull(contractPlanningRptDomainDTO.getBillToPartySeqNo());
						}

						if (billToPartyLegNo.equals("-") && billToPartyASNO.equals("-"))
							billToParty = "-";
						else if (billToPartyLegNo.equals("-") && !(billToPartyASNO.equals("-")))
							billToParty = billToPartyASNO;
						else if (!(billToPartyLegNo.equals("-")) && billToPartyASNO.equals("-"))
							billToParty = billToPartyLegNo;
						else
							billToParty = billToPartyLegNo;// Changed by Anand sugumaran DAD003 BlueHarmony Reports

						if (payerLegNo.equals("-") && payerASNO.equals("-")) {
							payerLegNo = checkForNull(contractPlanningRptDomainDTO.getPayerLegNo());
							payerASNO = checkForNull(contractPlanningRptDomainDTO.getPayerSeqNo());
						}

						if (payerLegNo.equals("-") && payerASNO.equals("-"))
							payer = "-";
						else if (payerLegNo.equals("-") && !(payerASNO.equals("-")))
							payer = payerASNO;
						else if (!(payerLegNo.equals("-")) && payerASNO.equals("-"))
							payer = payerLegNo;
						else
							payer = payerLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports

						Node soldtopartyNode = document.createElement("soldtoparty");
						customerNode.appendChild(soldtopartyNode);
						addAttributeNode(document, soldtopartyNode, "id", soldToParty);
						addAttributeNode(document, soldtopartyNode, "name", checkForNull(contractPlanningRptCustomerDomainDTO.getSoldToPartyName()));
						if (custCount == 0) {
							contractPlanningRptCustomerDomainDTO.setCustType("M");
							custCount++;
						}
						addAttributeNode(document, soldtopartyNode, "custtype", checkForNull(contractPlanningRptCustomerDomainDTO.getCustType()));

						Node billtopartyNode = document.createElement("billtoparty");
						customerNode.appendChild(billtopartyNode);
						addAttributeNode(document, billtopartyNode, "id", billToParty);
						if (checkForNull(contractPlanningRptCustomerDomainDTO.getBillToPartyName()).equals("-")) {
							addAttributeNode(document, billtopartyNode, "name", checkForNull(contractPlanningRptDomainDTO.getBillToPartyName()));
						} else {
							addAttributeNode(document, billtopartyNode, "name", checkForNull(contractPlanningRptCustomerDomainDTO.getBillToPartyName()));
						}

						Node payerNode = document.createElement("payer");
						customerNode.appendChild(payerNode);
						addAttributeNode(document, payerNode, "id", payer);
						if (checkForNull(contractPlanningRptCustomerDomainDTO.getPayerName()).equals("-")) {
							addAttributeNode(document, payerNode, "name", checkForNull(contractPlanningRptDomainDTO.getPayerName()));
						} else {
							addAttributeNode(document, payerNode, "name", checkForNull(contractPlanningRptCustomerDomainDTO.getPayerName()));
						}

						addChildNode(document, customerNode, "totalcalculatedprice", parseAmount(contractPlanningRptCustomerDomainDTO.getTotalCalculatedPrice()));

						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext()) {

							Node dmNode = document.createElement("dm");
							customerNode.appendChild(dmNode);

							ContractPlanningRptDMDomainDTO contractPlanningRptDMDomainDTO = (ContractPlanningRptDMDomainDTO) dmListIterator.next();

							addAttributeNode(document, dmNode, "number", checkForNull(contractPlanningRptDMDomainDTO.getDesgMcNo()));
							addChildNode(document, dmNode, "totalcalculatedprice", parseAmount(contractPlanningRptDMDomainDTO.getTotalCalculatedPrice()));

							List swoLists = contractPlanningRptDMDomainDTO.getSWODomainDTOList();
							if (null != swoLists) {
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext()) {

									Node swoNode = document.createElement("swo");
									dmNode.appendChild(swoNode);

									ContractPlanningRptSWODomainDTO contractPlanningRptSWODomainDTO = (ContractPlanningRptSWODomainDTO) swoListsIterator.next();

									addChildNode(document, swoNode, "number", checkForNull(contractPlanningRptSWODomainDTO.getSWONumber()));
									addChildNode(document, swoNode, "serialnumber", checkForNull(contractPlanningRptSWODomainDTO.getSerialNo()));
									if (checkForNull(contractPlanningRptSWODomainDTO.getIndicator()).equals("V")) {
										addChildNode(document, swoNode, "indicator", "SVC");
									} else {
										addChildNode(document, swoNode, "indicator", "-");
									}

									addChildNode(document, swoNode, "plannedstartdate", formatDate(contractPlanningRptSWODomainDTO.getPlanStartDate()));
									addChildNode(document, swoNode, "plannedenddate", formatDate(contractPlanningRptSWODomainDTO.getPlanEndDate()));
									addChildNode(document, swoNode, "eswprice", parseAmount(contractPlanningRptSWODomainDTO.getESWPrice()));
									addChildNode(document, swoNode, "alternateprice", parseAmount(contractPlanningRptSWODomainDTO.getAlternatePrice()));
									addChildNode(document, swoNode, "calculatedprice", parseAmount(contractPlanningRptSWODomainDTO.getCalculatedPrice()));

									List swoEELists = contractPlanningRptSWODomainDTO.getSWOEEDomainDTOList();
									if (null != swoEELists) {
										Iterator swoEEListsIterator = swoEELists.iterator();
										while (swoEEListsIterator.hasNext()) {

											Node eeNode = document.createElement("ee");
											swoNode.appendChild(eeNode);

											ContractPlanningRptSWOEEDomainDTO contractPlanningRptSWOEEDomainDTO = (ContractPlanningRptSWOEEDomainDTO) swoEEListsIterator.next();

											addChildNode(document, eeNode, "valuemetricdesc", checkForNull(contractPlanningRptSWOEEDomainDTO.getValueMetricDescription()));
											addChildNode(document, eeNode, "uselevel", checkForNull(contractPlanningRptSWOEEDomainDTO.getUseLevel()));
											addChildNode(document, eeNode, "number", checkForNull(contractPlanningRptSWOEEDomainDTO.getEENo()));
											addChildNode(document, eeNode, "eswprice", parseAmount(contractPlanningRptSWOEEDomainDTO.getESWPrice()));
											addChildNode(document, eeNode, "alternateprice", parseAmount(contractPlanningRptSWOEEDomainDTO.getAlternatePrice()));
											addChildNode(document, eeNode, "calculatedprice", parseAmount(contractPlanningRptSWOEEDomainDTO.getCalculatedPrice()));

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
		if (contractPlanningRptDomainDTO.getProposalContent().equals("S") || contractPlanningRptDomainDTO.getProposalContent().equals("A")) {
			customerLists = contractPlanningRptDomainDTO.getSSCustomerDomainDTOList();
			custCount = 0;
			if (null != customerLists) {
				Iterator customerListsIterator = customerLists.iterator();
				while (customerListsIterator.hasNext()) {

					ContractPlanningRptCustomerDomainDTO contractPlanningRptCustomerDomainDTO = new ContractPlanningRptCustomerDomainDTO();
					contractPlanningRptCustomerDomainDTO = (ContractPlanningRptCustomerDomainDTO) customerListsIterator.next();

					List dmLists = contractPlanningRptCustomerDomainDTO.getSSDmDomainTO();
					if (null != dmLists && dmLists.size() > 0) {
						Node customerNode = document.createElement("customer");
						root.appendChild(customerNode);

						String soldToPartyASNO = checkForNull(contractPlanningRptCustomerDomainDTO.getSoldToPartyASNO());
						String soldToPartyLegNo = checkForNull(contractPlanningRptCustomerDomainDTO.getSoldToPartyLegNo());
						String billToPartyASNO = checkForNull(contractPlanningRptCustomerDomainDTO.getBillToPartyASNO());
						String billToPartyLegNo = checkForNull(contractPlanningRptCustomerDomainDTO.getBillToPartyLegNo());
						String payerASNO = checkForNull(contractPlanningRptCustomerDomainDTO.getPayerASNO());
						String payerLegNo = checkForNull(contractPlanningRptCustomerDomainDTO.getPayerLegNo());
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
							billToPartyLegNo = checkForNull(contractPlanningRptDomainDTO.getBillToPartyLegNo());
							billToPartyASNO = checkForNull(contractPlanningRptDomainDTO.getBillToPartySeqNo());
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
							payerLegNo = checkForNull(contractPlanningRptDomainDTO.getPayerLegNo());
							payerASNO = checkForNull(contractPlanningRptDomainDTO.getPayerSeqNo());
						}

						if (payerLegNo.equals("-") && payerASNO.equals("-"))
							payer = "-";
						else if (payerLegNo.equals("-") && !(payerASNO.equals("-")))
							payer = payerASNO;
						else if (!(payerLegNo.equals("-")) && payerASNO.equals("-"))
							payer = payerLegNo;
						else
							payer = payerLegNo;  // Changed by Anand sugumaran DAD003 BlueHarmony Reports

						Node soldtopartyNode = document.createElement("soldtoparty");
						customerNode.appendChild(soldtopartyNode);
						addAttributeNode(document, soldtopartyNode, "id", soldToParty);
						addAttributeNode(document, soldtopartyNode, "name", checkForNull(contractPlanningRptCustomerDomainDTO.getSoldToPartyName()));
						if (custCount == 0) {
							contractPlanningRptCustomerDomainDTO.setCustType("S");
							custCount++;
						}
						addAttributeNode(document, soldtopartyNode, "custtype", checkForNull(contractPlanningRptCustomerDomainDTO.getCustType()));

						Node billtopartyNode = document.createElement("billtoparty");
						customerNode.appendChild(billtopartyNode);
						addAttributeNode(document, billtopartyNode, "id", billToParty);
						if (checkForNull(contractPlanningRptCustomerDomainDTO.getBillToPartyName()).equals("-")) {
							addAttributeNode(document, billtopartyNode, "name", checkForNull(contractPlanningRptDomainDTO.getBillToPartyName()));
						} else {
							addAttributeNode(document, billtopartyNode, "name", checkForNull(contractPlanningRptCustomerDomainDTO.getBillToPartyName()));
						}

						Node payerNode = document.createElement("payer");
						customerNode.appendChild(payerNode);
						addAttributeNode(document, payerNode, "id", payer);
						if (checkForNull(contractPlanningRptCustomerDomainDTO.getPayerName()).equals("-")) {
							addAttributeNode(document, payerNode, "name", checkForNull(contractPlanningRptDomainDTO.getPayerName()));
						} else {
							addAttributeNode(document, payerNode, "name", checkForNull(contractPlanningRptCustomerDomainDTO.getPayerName()));
						}

						addChildNode(document, customerNode, "totalcalculatedprice", parseAmount(contractPlanningRptCustomerDomainDTO.getTotalCalculatedPrice()));

						Iterator dmListIterator = dmLists.iterator();
						while (dmListIterator.hasNext()) {

							Node dmNode = document.createElement("dm");
							customerNode.appendChild(dmNode);

							ContractPlanningRptDMDomainDTO contractPlanningRptDMDomainDTO = (ContractPlanningRptDMDomainDTO) dmListIterator.next();

							addAttributeNode(document, dmNode, "number", checkForNull(contractPlanningRptDMDomainDTO.getDesgMcNo()));
							addChildNode(document, dmNode, "totalcalculatedprice", parseAmount(contractPlanningRptDMDomainDTO.getTotalCalculatedPrice()));

							List swoLists = contractPlanningRptDMDomainDTO.getSSSWODomainDTOList();
							if (null != swoLists) {
								Iterator swoListsIterator = swoLists.iterator();
								while (swoListsIterator.hasNext()) {

									Node swoNode = document.createElement("swo");
									dmNode.appendChild(swoNode);

									ContractPlanningRptSWODomainDTO contractPlanningRptSWODomainDTO = (ContractPlanningRptSWODomainDTO) swoListsIterator.next();

									addChildNode(document, swoNode, "number", checkForNull(contractPlanningRptSWODomainDTO.getSWONumber()));
									addChildNode(document, swoNode, "serialnumber", checkForNull(contractPlanningRptSWODomainDTO.getSerialNo()));
									if (checkForNull(contractPlanningRptSWODomainDTO.getIndicator()).equals("V")) {
										addChildNode(document, swoNode, "indicator", "SVC");
									} else {
										addChildNode(document, swoNode, "indicator", "-");
									}
									addChildNode(document, swoNode, "plannedstartdate", formatDate(contractPlanningRptSWODomainDTO.getPlanStartDate()));
									addChildNode(document, swoNode, "plannedenddate", formatDate(contractPlanningRptSWODomainDTO.getPlanEndDate()));
									addChildNode(document, swoNode, "eswprice", parseAmount(contractPlanningRptSWODomainDTO.getESWPrice()));
									addChildNode(document, swoNode, "alternateprice", parseAmount(contractPlanningRptSWODomainDTO.getAlternatePrice()));
									addChildNode(document, swoNode, "calculatedprice", parseAmount(contractPlanningRptSWODomainDTO.getCalculatedPrice()));

									List swoEELists = contractPlanningRptSWODomainDTO.getSWOEEDomainDTOList();
									if (null != swoEELists) {
										Iterator swoEEListsIterator = swoEELists.iterator();
										while (swoEEListsIterator.hasNext()) {

											Node eeNode = document.createElement("ee");
											swoNode.appendChild(eeNode);

											ContractPlanningRptSWOEEDomainDTO contractPlanningRptSWOEEDomainDTO = (ContractPlanningRptSWOEEDomainDTO) swoEEListsIterator.next();

											addChildNode(document, eeNode, "valuemetricdesc", checkForNull(contractPlanningRptSWOEEDomainDTO.getValueMetricDescription()));
											addChildNode(document, eeNode, "uselevel", checkForNull(contractPlanningRptSWOEEDomainDTO.getUseLevel()));
											addChildNode(document, eeNode, "number", checkForNull(contractPlanningRptSWOEEDomainDTO.getEENo()));
											addChildNode(document, eeNode, "eswprice", parseAmount(contractPlanningRptSWOEEDomainDTO.getESWPrice()));
											addChildNode(document, eeNode, "alternateprice", parseAmount(contractPlanningRptSWOEEDomainDTO.getAlternatePrice()));
											addChildNode(document, eeNode, "calculatedprice", parseAmount(contractPlanningRptSWOEEDomainDTO.getCalculatedPrice()));

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
     * ContractPlanningReportViewBean
     * 
     * @author thirumalai
     */
    public ContractPlanningReportViewBean() {
	}

	/**
     * ContractPlanningReportViewBean
     * 
     * @param contractPlanningReportCustomDTO
     * @param view
     * @author thirumalai
     */
    public ContractPlanningReportViewBean(ContractPlanningReportCustomDTO contractPlanningReportCustomDTO, String view) {
		convertToDOM(contractPlanningReportCustomDTO);
		super.setView(view);
	}

	/**
     * ContractPlanningReportViewBean
     * 
     * @param contractPlanningReportCustomDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public ContractPlanningReportViewBean(ContractPlanningReportCustomDTO contractPlanningReportCustomDTO, String view, boolean viewReport) {
		if (viewReport) {
			convertToDOM(contractPlanningReportCustomDTO);
		} else {
			convertToHTML(contractPlanningReportCustomDTO);
		}
		setView(view);
	}

	/**
     * convertToHTML
     * 
     * @param customDTO
     * @author thirumalai
     */
    protected void convertToHTML(ContractPlanningReportCustomDTO customDTO) {
		StringBuffer buffer = new StringBuffer();
		ContractPlanningRptDomainDTO reportDTO = customDTO.getReportDTO();
		buffer.append("<html xml:lang=\"en\" lang=\"en\">");
		buffer.append("<head>");
		buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">");
		buffer.append("</meta>");
				buffer.append("</meta>");
		buffer.append("<meta name=\"Version\" content=\"1.0\">");
		buffer.append("</meta>");
		buffer.append("<meta name=\"DC.Rights\" content=\"Copyright (c) 2003 by IBM Corporation\" />");
		buffer.append("<title> Contract planning report </title>");
		buffer.append("</head>");
		buffer.append("<body>");
			
		buffer.append("<center>");
		buffer.append("<table border=\"0\" lotus_anchor=\"A4..S14\" width=\"1120\">");
		buffer.append("<lotus_global align=\"center\" valign=\"bottom\" lotus_format=\"General\" height=\"19\" width=\"81\" grid=\"OFF\" gridcolor=\"#cccccc\">");
		buffer.append("</lotus_global>");
		buffer.append("<tr>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
		buffer.append("&#160;");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("</tr> \n");

		buffer.append("<tr>");
		buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"18\" height=\"19\">");
		buffer.append("");
		buffer.append("<a href=\"#main\">");
		buffer.append(" &nbsp;");
		buffer.append("</a> &#160;");

		buffer.append("");
		buffer.append("</td>");
		buffer.append("</tr> \n");
		buffer.append("<tr>");
		buffer.append("<a name=\"main\">");
		buffer.append("</a>");
		buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><p style=\"color:red;\">IBM Confidential</p></td></tr>\n");
		buffer.append("<td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\">");
		buffer.append("<strong> Contract planning report </strong>");
		buffer.append("");
		buffer.append("</td>");
		buffer.append("</tr> \n");
		buffer.append("<tr>");
		if (null != reportDTO) {
			buffer.append("<td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\">");
			buffer.append("");
			buffer.append("<strong> Report printed : " + formatDate(reportDTO.getRptPrintedDate()));
			buffer.append("</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");
			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Prices as of : " + formatDate(reportDTO.getPriceAsOf()));
			buffer.append("</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");
			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");
			buffer.append(" Contract period : " + formatDate(reportDTO.getContractStartDate()) + "-");
			buffer.append(formatDate(reportDTO.getContractEndDate()));
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");
			buffer.append(" TVM rate : ");
			buffer.append(parseAmount(reportDTO.getTvmRate()));
			buffer.append("% Planned growth : " + parseAmount(reportDTO.getPlannedGrowthRate()) + "% ");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");
			buffer.append("");

			buffer.append(checkForNull(reportDTO.getProposalName()) + "(" + checkForNull(reportDTO.getContractNumber()) + ")");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"18\" height=\"19\">");
			buffer.append("&#160;");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"6\" height=\"19\">");
			buffer.append("&#160;");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"4\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Billing</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"2\" height=\"19\">");
			buffer.append("&#160;");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"6\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Price </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" width=\"81\" height=\"19\">");
			buffer.append("&#160;");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" width=\"81\" height=\"19\">");
			buffer.append("&#160;");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> SWO number </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"1\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Serial number</strong>");
			buffer.append("");
			buffer.append("</td>");

			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Indicator </strong>");
			buffer.append("");
			buffer.append("</td>");

			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Plan start date </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Plan end date </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong>&#160;");
			buffer.append("</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> ESW </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Alternate </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Calculated </strong>");
			buffer.append("");
			buffer.append("</td>");

			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
			buffer.append("&#160;");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
			buffer.append("&#160;");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"4\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Value metric description </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"4\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> Use level </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong> EE </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong>&#160;");
			buffer.append("</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong>&#160;");
			buffer.append("</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"top\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong>&#160;");
			buffer.append("</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"18\" height=\"19\">");
			buffer.append("&#160;");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			// Call Customer Method

			if (customDTO.getReportDTO().getProposalContent().equals("M") || customDTO.getReportDTO().getProposalContent().equals("A")) {
				List customers = customDTO.getReportDTO().getCustomerDomainDTOList();
				if (null != customers && 0 < customers.size()) {
					for (int i = 0, size = customers.size(); i < size; i++) {
						ContractPlanningRptCustomerDomainDTO customer = (ContractPlanningRptCustomerDomainDTO) customers.get(i);
						if (i == 0) {
							buffer.append("<tr>");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"6\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
							buffer.append("<strong>MLC products</strong>");
							buffer.append("</td>");
							buffer.append("</tr> \n");
						}
						if (checkForNull(customer.getBillToPartyName()).equals("-")) {
							customer.setBillToPartyName(reportDTO.getBillToPartyName());
						}
						if (checkForNull(customer.getPayerName()).equals("-")) {
							customer.setPayerName(reportDTO.getPayerName());
						}
						buffer.append(getCustomer(customer, customDTO.getReportDTO(), true));
					}
				}
			}

			if (customDTO.getReportDTO().getProposalContent().equals("S") || customDTO.getReportDTO().getProposalContent().equals("A")) {
				List customers = customDTO.getReportDTO().getSSCustomerDomainDTOList();
				if (null != customers && 0 < customers.size()) {
					for (int i = 0, size = customers.size(); i < size; i++) {
						ContractPlanningRptCustomerDomainDTO customer = (ContractPlanningRptCustomerDomainDTO) customers.get(i);
						if (i == 0) {
							buffer.append("<tr>\n");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"6\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">\n");
							buffer.append("<strong>S&amp;S products</strong>\n");
							buffer.append("</td>\n");
							buffer.append("</tr>\n");
						}
						if (checkForNull(customer.getBillToPartyName()).equals("-")) {
							customer.setBillToPartyName(reportDTO.getBillToPartyName());
						}
						if (checkForNull(customer.getPayerName()).equals("-")) {
							customer.setPayerName(reportDTO.getPayerName());
						}
						buffer.append(getCustomer(customer, customDTO.getReportDTO(), false));
					}
				}
			}

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"16\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("Total price for contract attachment : ");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong>");
			buffer.append(parseAmount(reportDTO.getTotalCalculatedPrice()));

			buffer.append("</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong>");
			buffer.append("Invoice frequency &amp; amount(Related to MLC products only) </strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"15\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("Annual ");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append(parseAmount(reportDTO.getAnnualInvoiceFreqAmt()));
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"1\" height=\"19\">");
			buffer.append(" &#160;");
			if ("A".equals(reportDTO.getBillingFreq())) {
				buffer.append("Selected");
			}
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"15\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append(" Semi - annual ");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append(parseAmount(reportDTO.getSemiAnnualFreqAmt()));
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"1\" height=\"19\">");
			buffer.append(" &#160;");
			if ("S".equals(reportDTO.getBillingFreq())) {
				buffer.append("Selected");
			}
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"15\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append(" Quarterly");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append(parseAmount(reportDTO.getQurtInvoiceFreqAmt()));
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"1\" height=\"19\">");
			buffer.append(" &#160;");
			if ("Q".equals(reportDTO.getBillingFreq())) {
				buffer.append("Selected");
			}
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

			buffer.append("<tr>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"15\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append(" Monthly");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append(parseAmount(reportDTO.getMonthlyInvoiceFreqAmt()));
			buffer.append("");
			buffer.append("</td>");
			buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"1\" height=\"19\">");
			buffer.append(" &#160;");
			if ("M".equals(reportDTO.getBillingFreq())) {
				buffer.append("Selected");
			}
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");

		}

		buffer.append("</table>");
		buffer.append("</center>");
		buffer.append("</body>");
		buffer.append("</html>");

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
    private String getCustomer(ContractPlanningRptCustomerDomainDTO customer, ContractPlanningRptDomainDTO reportDTO, boolean mlcProducts) {
		StringBuffer buffer = new StringBuffer();
		List dms = null;
		if (mlcProducts) {
			dms = customer.getIDMDomainDTOListO();
		} else {
			dms = customer.getSSDmDomainTO();
		}

		if (null != dms && 0 < dms.size()) {

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

			buffer.append("<tr>\n");
			buffer.append(
				"<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\"><strong>Sold to party&#160;:&#160;"
					+ soldToParty
					+ "</strong></td>\n");
			buffer.append(
				"<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\"><strong>Bill to party&#160;:&#160;"
					+ billToParty
					+ "</strong></td>\n");
			buffer.append(
				"<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\"><strong>Payer&#160;:&#160;"
					+ payer
					+ "</strong></td>\n");
			buffer.append("</tr>\n");

			buffer.append("<tr>\n");
			buffer.append(
				"<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\">"
					+ checkForNull(customer.getSoldToPartyName())
					+ "</td>\n");
			buffer.append(
				"<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\">"
					+ checkForNull(customer.getBillToPartyName())
					+ "</td>\n");
			buffer.append(
				"<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" colspan=\"6\" height=\"19\">"
					+ checkForNull(customer.getPayerName())
					+ "</td>\n");
			buffer.append("</tr>\n");

			for (int dmCounter = 0, dmSize = dms.size(); dmCounter < dmSize; dmCounter++) {
				ContractPlanningRptDMDomainDTO dm = (ContractPlanningRptDMDomainDTO) dms.get(dmCounter);
				if (null != dm) {
					buffer.append("<tr> <td lotus_celltype=\"label\" colspan=\"18\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
					buffer.append("");
					buffer.append("Designated machine:" + dm.getDesgMcNo() + " </td> </tr>");

					List swos = null;

					if (mlcProducts) {
						swos = dm.getSWODomainDTOList();
					} else {
						swos = dm.getSSSWODomainDTOList();
					}

					if (null != swos && 0 < swos.size()) {
						for (int swoCounter = 0, swoSize = swos.size(); swoCounter < swoSize; swoCounter++) {
							ContractPlanningRptSWODomainDTO swo = (ContractPlanningRptSWODomainDTO) swos.get(swoCounter);

							buffer.append("<tr>");
							buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
							buffer.append("&#160;");
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
							buffer.append("&#160;");
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
							buffer.append("");
							buffer.append(checkForNull(swo.getSWONumber()));
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
							buffer.append("");
							buffer.append(checkForNull(swo.getSerialNo()));
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");
							buffer.append("");
							if ("V".equals(swo.getIndicator())) {
								buffer.append("SVC");
							} else {
								buffer.append("-");
							}

							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
							buffer.append("");
							buffer.append(formatDate(swo.getPlanStartDate()));
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
							buffer.append("");
							buffer.append(formatDate(swo.getPlanEndDate()));
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"blank\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");
							buffer.append("&#160;");
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
							buffer.append("");
							buffer.append(parseAmount(swo.getESWPrice()));
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
							buffer.append("");
							buffer.append(parseAmount(swo.getAlternatePrice()));
							buffer.append("");
							buffer.append("</td>");
							buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
							buffer.append("");
							buffer.append(parseAmount(swo.getCalculatedPrice()));
							buffer.append("");
							buffer.append("</td>");
							buffer.append("</tr> \n");

							List ees = swo.getSWOEEDomainDTOList();
							if (null != ees) {
								for (int k = 0; k < ees.size(); k++) {
									ContractPlanningRptSWOEEDomainDTO ee = (ContractPlanningRptSWOEEDomainDTO) ees.get(k);
									buffer.append("<tr>");
									buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
									buffer.append("&#160;");
									buffer.append("");
									buffer.append("</td>");
									buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" width=\"81\" height=\"19\">");
									buffer.append("&#160;");
									buffer.append("");
									buffer.append("</td>");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"4\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
									buffer.append("");
									buffer.append(checkForNull(ee.getValueMetricDescription()));
									buffer.append("");
									buffer.append("</td>");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"4\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"19\">");
									buffer.append("");
									buffer.append(checkForNull(ee.getUseLevel()));
									buffer.append("");
									buffer.append("</td>");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">");
									buffer.append("");
									buffer.append(checkForNull(ee.getEENo()));
									buffer.append("");
									buffer.append("</td>");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
									buffer.append("");
									buffer.append(parseAmount(ee.getESWPrice()));
									buffer.append("");
									buffer.append("</td>");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
									buffer.append("");
									buffer.append(parseAmount(ee.getAlternatePrice()));
									buffer.append("");
									buffer.append("</td>");
									buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
									buffer.append("");
									buffer.append(parseAmount(ee.getCalculatedPrice()));
									buffer.append("");
									buffer.append("</td>");
									buffer.append("</tr> \n");
								}
							}

						}
					}

					buffer.append("<tr>");

					buffer.append("<td lotus_celltype=\"label\" colspan=\"16\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
					buffer.append(" Total price for designated machine (" + dm.getDesgMcNo() + ") :");
					buffer.append("");
					buffer.append("</td>");
					buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
					buffer.append("");
					buffer.append("<strong>");
					buffer.append(parseAmount(dm.getTotalCalculatedPrice()));
					buffer.append("</strong>");
					buffer.append("");
					buffer.append("</td>");
					buffer.append("</tr> \n");

				}
			}

			buffer.append("<tr>");

			buffer.append("<td lotus_celltype=\"label\" colspan=\"16\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("	Total price for sold to party (" + soldToParty + ") :");
			buffer.append("");
			buffer.append("</td>");

			buffer.append("<td lotus_celltype=\"label\" colspan=\"2\" bgcolor=\"#ffffff\" align=\"right\" valign=\"bottom\" height=\"19\">");
			buffer.append("");
			buffer.append("<strong>");
			buffer.append(parseAmount(customer.getTotalCalculatedPrice()));
			buffer.append("</strong>");
			buffer.append("");
			buffer.append("</td>");
			buffer.append("</tr> \n");
		}

		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");
		buffer.append("\n");

		return buffer.toString();
	}

}