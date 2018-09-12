/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerInformationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 13, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class PrintProposalViewBean extends ReportViewBean {
	
	/**
     * PrintProposalViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public PrintProposalViewBean(PrintProposalCustomDTO customDTO){
		convertToDOM(customDTO);
		setView("printproposalview");
	}
	/**
     * PrintProposalViewBean
     * 
     * @author thirumalai
     */
    public PrintProposalViewBean(){
	}
	
	/**
     * convertToDOM
     * 
     * @param customDTO
     * @author thirumalai
     */
    private void convertToDOM(PrintProposalCustomDTO customDTO) {
		Document document = createDocument();
		
		// Insert root element
		Element root = (Element)document.createElement("printproposal");
		
		// Insert child Manifest
		document.appendChild(root);
		
		// Adding basic proposal information
		BasicProposalCustomDTO basicProposalData = customDTO.getBasicProposalCustomDTO();
		
		root.setAttribute("salesOrganization", basicProposalData.getSalesOrganization());
		root.setAttribute("distributionChannel", basicProposalData.getDistributionChannel());
		root.setAttribute("division", basicProposalData.getDivision());
		root.setAttribute("currencyCode", basicProposalData.getCurrencyCode());
		root.setAttribute("proposalName", basicProposalData.getProposalName());
		root.setAttribute("proposalType",  basicProposalData.getProposalType());
		root.setAttribute("reportName",  basicProposalData.getReportName());
		root.setAttribute("externalContractNumber",  basicProposalData.getExternalContractNumber());
		root.setAttribute("contractStartDate",  formatDate(basicProposalData.getContractStartDate()));
		root.setAttribute("contractEndDate",  formatDate(basicProposalData.getContractEndDate()));
		root.setAttribute("contractPeriodBeginning",  formatDate(basicProposalData.getContractPeriodBeginning()));
		root.setAttribute("contractPeriodEnding",  formatDate(basicProposalData.getContractPeriodEnding()));
		root.setAttribute("contractNumber",  customDTO.getContractNumber());
		root.setAttribute("contractType",  customDTO.getContractType());
		root.setAttribute("amendmentEffectiveDate", formatDate(customDTO.getAmendmentEffectiveDate()));
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - Begin
		root.setAttribute("complexContractID", basicProposalData.getCpsID());
		//root.setAttribute("masterContractID", basicProposalData.getMasterContractID());
		root.setAttribute("complexContractType", basicProposalData.getOcpsID());
		root.setAttribute("masterContractType", basicProposalData.getContractType());
		//root.setAttribute("complexContractAmendment", basicProposalData.getComplexContractAmendment());
		//root.setAttribute("masterContractAmendment", basicProposalData.getMasterContractAmendment());
		root.setAttribute("blbIndicator", basicProposalData.getBlbIndicator());
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - End
		
		// Adding pricing information
		PricingInformationCustomDTO pricingData = customDTO.getPricingInformationCustomDTO();
		
		root.setAttribute("plannedGrowthOption", pricingData.getPlannedGrowthOption());
		root.setAttribute("plannedGrowthValue", parseAmount(pricingData.getPlannedGrowthValue()) + " %");
		root.setAttribute("billingFrequency", pricingData.getBillingFrequency());
		root.setAttribute("growthLimitOption", pricingData.getGrowthLimitOption());
		root.setAttribute("growthLimitValue", parseAmount(pricingData.getGrowthLimitValue()) + " %");
		root.setAttribute("tvmRate", parseAmount(pricingData.getTvmRate()) + " %");
		root.setAttribute("additionalGrowthLimit", parseAmount(pricingData.getAdditionalGrowthLimit()));
		root.setAttribute("pakid", pricingData.getPakid());
		System.out.println("PrintProposalViewBean.convertToDOM():Discount:"+pricingData.getDiscount());
		root.setAttribute("discount", parseAmount(pricingData.getDiscount()) + " %");
		root.setAttribute("anniversaryContractAmount", parseAmount(pricingData.getAnniversaryContractAmount()));
		root.setAttribute("ssAnniversaryContractAmount", parseAmount(pricingData.getSAndSAnniversaryContractAmount()));
		/* CR6153 start changes  */
		root.setAttribute("ssAnniversaryContractAmount2",parseAmount(pricingData.getSAndSAnniversaryContractAmountPeriod2()));
		root.setAttribute("ssAnniversaryContractAmount3",parseAmount(pricingData.getSAndSAnniversaryContractAmountPeriod3()));
		root.setAttribute("ssAnniversaryContractAmount4",parseAmount(pricingData.getSAndSAnniversaryContractAmountPeriod4()));
		root.setAttribute("ssAnniversaryContractAmount5",parseAmount(pricingData.getSAndSAnniversaryContractAmountPeriod5()));
		if(pricingData.isExtendPeriod()) {
			root.setAttribute("extendPeriod","Checked");	
		} else {
			root.setAttribute("extendPeriod","Unchecked");
		}
		/* CR6153 ends changes  */
  	
		if(pricingData.isDetailedInvoice()){
			root.setAttribute("detailedInvoice", "Checked");
		}
		else{
			root.setAttribute("detailedInvoice", "Unchecked");
		}
		if(pricingData.isGsa()){
			root.setAttribute("gsa", "Checked");
		}
		else{
			root.setAttribute("gsa", "Unchecked");
		}
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - Begin
	/*	if(pricingData.isPrebillIndicator()){
			root.setAttribute("prebillindicator", "Checked");
		} else {
			root.setAttribute("prebillindicator", "Unchecked");
		}*/
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - End
		root.setAttribute("prebillindicator", pricingData.isPrebillIndicator());
		root.setAttribute("billingBlock", pricingData.getBillingBlock());
		root.setAttribute("deviatingDateRule", pricingData.getDeviatingDateRule());
		root.setAttribute("billingDateRule", pricingData.getBillingDateRule());
		root.setAttribute("freeTextForInvoicePrint", pricingData.getFreeTextForInvoicePrint());
		
		if(pricingData.isAdvance()){
			root.setAttribute("advance", "Checked");
		}
		else{
			root.setAttribute("advance", "Unchecked");
		}
		
		// Adding variance information
		VarianceInformationCustomDTO varianceData = customDTO.getVarianceInformationCustomDTO();
		
		root.setAttribute("capAmount", parseAmount(varianceData.getCapAmount()));
		root.setAttribute("capPlus", parseAmount(varianceData.getCapPlus()) + " %");
		root.setAttribute("capMinus", parseAmount(varianceData.getCapMinus()) + " %");
		
		// Adding secondary information
		SecondaryProposalCustomDTO secondaryData = customDTO.getSecondaryProposalCustomDTO();
		
		root.setAttribute("purchaseOrderNumber", secondaryData.getPurchaseOrderNumber());
		root.setAttribute("paymentTerms", secondaryData.getPaymentTerms());
		root.setAttribute("igfOfferNumber", secondaryData.getIgfOfferNumber());
		root.setAttribute("comments", secondaryData.getComments());
		root.setAttribute("fixedValDate", formatDate(secondaryData.getFixedValDate()));
		root.setAttribute("purchaseOrderDate", formatDate(secondaryData.getPurchaseOrderDate()));
		root.setAttribute("addValueDays",parseAmount(secondaryData.getAddValueDays()));
		root.setAttribute("proposalApprover", customDTO.getProposalApprover());
		
		PartnerInformationViewBean view = new PartnerInformationViewBean(customDTO.getPartnerInformationCustomDTO());
		
		root.setAttribute("soldToPartyNumber", view.getSoldToPartyNumber());
		root.setAttribute("soldToPartyName", view.getSoldToPartyName());
		root.setAttribute("billToPartyNumber", view.getBillToPartyNumber());
		root.setAttribute("billToPartyName", view.getBillToPartyName());
		root.setAttribute("shipToPartyNumber", view.getShipToPartyNumber());
		root.setAttribute("shipToPartyName", view.getShipToPartyName());
		root.setAttribute("payerNumber", view.getPayerNumber());
		root.setAttribute("payerName", view.getPayerName());
		root.setAttribute("nineDPartnerNumber", view.getNineDPartnerNumber());
		root.setAttribute("nineDPartnerName", view.getNineDPartnerName());
		
		Map customers = customDTO.getCustomers();
		if(null != customers && 0 < customers.size()){
			Element mlcProducts = (Element)document.createElement("MLCProducts");
			root.appendChild(mlcProducts);
		
			mlcProducts.setAttribute("invoiceAmount", parseAmount(customDTO.getInvoiceAmount()));
			if(customDTO.isSAndS()){
				mlcProducts.setAttribute("isSAndS", "true");
			}
			else{
				mlcProducts.setAttribute("isSAndS", "false");
			}

			Iterator customerIterator = customers.values().iterator();
			while(customerIterator.hasNext()){
				ProposalCustomerCustomDTO customer = (ProposalCustomerCustomDTO)customerIterator.next();
				if(null != customer){
					Element customerNode = (Element)document.createElement("customer");
					mlcProducts.appendChild(customerNode);
					
					customerNode.setAttribute("planstartdate", formatDate(customer.getPlanStartDate()));
					customerNode.setAttribute("planenddate", formatDate(customer.getPlanEndDate()));
					
					Element soldToPartyNode = (Element)document.createElement("soldtoparty");
					customerNode.appendChild(soldToPartyNode);
					
					/* DADO02 Sateesh Anne soldToPartyNode.setAttribute("number", customer.getLegacyCustomerNumberWithAS());
					soldToPartyNode.setAttribute("sapNumber", customer.getLegacyCustomerNumberWithAS());*/
					
					soldToPartyNode.setAttribute("number", customer.getSoldToPartyNo());
					soldToPartyNode.setAttribute("sapNumber", customer.getSoldToPartyNo());
					// END DADO02
					Element billToPartyNode = (Element)document.createElement("billtoparty");
					customerNode.appendChild(billToPartyNode);
					
					billToPartyNode.setAttribute("number", view.getBillToPartyNumber());

					Element payerNode = (Element)document.createElement("payer");
					customerNode.appendChild(payerNode);
					
					payerNode.setAttribute("number", view.getPayerNumber());

					Map dms = customer.getDMs();
					if(null != dms){
						Iterator dmIterator = dms.values().iterator();
						while(dmIterator.hasNext()){
							DMCustomDTO dm = (DMCustomDTO)dmIterator.next();
							if(null != dm){
								Node dmNode = document.createElement("dm");
								customerNode.appendChild(dmNode);

								addAttributeNode(document, dmNode, "number", checkForNull(dm.getNumber()));
								addAttributeNode(document, dmNode, "description", checkForNull(dm.getDescription()));
								
								addChildNode(document, (Node)dmNode, "planstartdate", formatDate(dm.getPlanStartDate()));
								addChildNode(document, (Node)dmNode, "planenddate", formatDate(dm.getPlanEndDate()));

								Map swos = dm.getSwos();
								if(null != swos){
									Iterator swoIterator = swos.values().iterator();
									while(swoIterator.hasNext()){
										SWOCustomDTO swo = (SWOCustomDTO)swoIterator.next();
										if(null != swo){
											Node swoNode = document.createElement("swo");
											dmNode.appendChild(swoNode);

											addAttributeNode(document, swoNode, "number", getValue(swo.getNumber(), swo.getSerialNumber(), ""));
											addAttributeNode(document, swoNode, "description", checkForNull(swo.getDescription()));
											
											addChildNode(document, swoNode, "planstartdate", formatDate(swo.getPlanStartDate()));
											addChildNode(document, swoNode, "planenddate", formatDate(swo.getPlanEndDate()));
											addChildNode(document, swoNode, "eswprice", parseAmount(swo.getEswPrice()));
											addChildNode(document, swoNode, "alternateprice", parseAmount(swo.getAlternatePrice()));
											addChildNode(document, swoNode, "calculatedprice", parseAmount(swo.getCalculatedPrice()));
											addChildNode(document, swoNode, "referenceSN", checkForNull(swo.getSwoReferenceSN()));
											addChildNode(document, swoNode, "referenceDN", checkForNull(swo.getSwoReferenceDN()));
											addChildNode(document, swoNode, "contractStatus",checkForNull( swo.getSwoContractStatus()));
											addChildNode(document, swoNode, "contractNumber", checkForNull(swo.getSwoContractNumber()));
											addChildNode(document, swoNode, "contractType", checkForNull(swo.getSwoContractType()));
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if(customDTO.isSAndS()){
			Map sAndSCustomers = customDTO.getSAndSCustomers();
			if(null != sAndSCustomers && 0 < sAndSCustomers.size()){
				Element sAndSProducts = document.createElement("SANDSProducts");
				root.appendChild(sAndSProducts);
		
				sAndSProducts.setAttribute("ssDiscountAmt",parseAmount(customDTO.getSandSDiscountAmount()));
				
				Iterator customerIterator = sAndSCustomers.values().iterator();
				while(customerIterator.hasNext()){
					ProposalCustomerCustomDTO customer = (ProposalCustomerCustomDTO)customerIterator.next();
					if(null != customer){
						Element customerNode = document.createElement("customer");
						sAndSProducts.appendChild(customerNode);
						
						customerNode.setAttribute("planstartdate", formatDate(customer.getPlanStartDate()));
						customerNode.setAttribute("planenddate", formatDate(customer.getPlanEndDate()));
					
						Node soldToPartyNode = document.createElement("soldtoparty");
						customerNode.appendChild(soldToPartyNode);
						addAttributeNode(document, soldToPartyNode, "number", customer.getLegacyCustomerNumberWithAS());
						addAttributeNode(document, soldToPartyNode, "sapNumber", checkForNull(customer.getSAPCustomerNumber()));
					
						Node billToPartyNode = document.createElement("billtoparty");
						customerNode.appendChild(billToPartyNode);
						addAttributeNode(document, billToPartyNode, "number", view.getBillToPartyNumber());

						Node payerNode = document.createElement("payer");
						customerNode.appendChild(payerNode);
						addAttributeNode(document, payerNode, "number", view.getPayerNumber());
					
						Map dms = customer.getDMs();
						if(null != dms){
							Iterator dmIterator = dms.values().iterator();
							while(dmIterator.hasNext()){
								DMCustomDTO dm = (DMCustomDTO)dmIterator.next();
								if(null != dm){
									Node dmNode = document.createElement("dm");
									customerNode.appendChild(dmNode);

									addAttributeNode(document, dmNode, "number", checkForNull(dm.getNumber()));
									addAttributeNode(document, dmNode, "description", checkForNull(dm.getDescription()));
								
									addChildNode(document, (Node)dmNode, "planstartdate", formatDate(dm.getPlanStartDate()));
									addChildNode(document, (Node)dmNode, "planenddate", formatDate(dm.getPlanEndDate()));

									Map swos = dm.getSwos();
									if(null != swos){
										Iterator swoIterator = swos.values().iterator();
										while(swoIterator.hasNext()){
											SWOCustomDTO swo = (SWOCustomDTO)swoIterator.next();
											if(null != swo){
												Node swoNode = document.createElement("sandsswo");
												dmNode.appendChild(swoNode);

												addAttributeNode(document, swoNode, "number", getValue(swo.getNumber(), swo.getSerialNumber(), ""));
												addAttributeNode(document, swoNode, "description", checkForNull(swo.getDescription()));
											
												addChildNode(document, swoNode, "planstartdate", formatDate(swo.getPlanStartDate()));
												addChildNode(document, swoNode, "planenddate", formatDate(swo.getPlanEndDate()));
												addChildNode(document, swoNode, "eswprice", parseAmount(swo.getEswPrice()));
												addChildNode(document, swoNode, "alternateprice", parseAmount(swo.getAlternatePrice()));
												addChildNode(document, swoNode, "calculatedprice", parseAmount(swo.getCalculatedPrice()));
												addChildNode(document, swoNode, "referenceSN", checkForNull(swo.getSwoReferenceSN()));
												addChildNode(document, swoNode, "referenceDN", checkForNull(swo.getSwoReferenceDN()));
												addChildNode(document, swoNode, "contractStatus", checkForNull(swo.getSwoContractStatus()));
												addChildNode(document, swoNode, "contractNumber", checkForNull(swo.getSwoContractNumber()));
												addChildNode(document, swoNode, "contractType", checkForNull(swo.getSwoContractType()));
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
		
		setDocument(document);
	}

	/**
     * getValue
     * 
     * @param value1
     * @param value2
     * @param defaultValue
     * @return
     * @author thirumalai
     */
    private String getValue(String value1, String value2, String defaultValue){
		String value = defaultValue;
		if(null == value1){
			value1 = "";
		}
		if(null == value2){
			value2 = "";
		}
		if(0 < value1.length()){
			if(0 < value2.length()){
				value = value1 +" / "+ value2;
			}
			else{
				value = value1;
			}
		}
		else{
			if(0 < value2.length()){
				value = value2;
			}
			else{
				value = defaultValue;
			}
		}
		return value;
	}
}
