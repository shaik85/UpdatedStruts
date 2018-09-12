/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ContractTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalContractStatusConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 24, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class PCMBOBuilder {
	/** Constant */
	public static final String VALIDATE_PROPOSAL_HEADER = "validateForCreate";
	/** Constant */
	public static final String VALIDATE_PROPOSAL_HEADER_CHANGE = "validateForChange";
	/** Constant */
	public static final String SAVE_PROPOSAL = "saveAfterCreate";
	/** Constant */
	public static final String CHANGE_PROPOSAL = "changeProposal";

	/**
	 * populateProposalBO
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalBO
	 * @param proposalHeaderCustomDTO
	 * @param type
	 * @return void
	 * 
	 * @author balajiv
	 */
	public static void populateProposalBO(ProposalContractBO proposalBO, ProposalHeaderCustomDTO proposalHeaderCustomDTO, String type) {
    
		BasicProposalCustomDTO basicProposalCustomDTO = proposalHeaderCustomDTO.getBasicProposalCustomDTO();
		PricingInformationCustomDTO pricingInformationCustomDTO = proposalHeaderCustomDTO.getPricingInformationCustomDTO();
		SecondaryProposalCustomDTO secondaryProposalCustomDTO = proposalHeaderCustomDTO.getSecondaryProposalCustomDTO();
		VarianceInformationCustomDTO varianceInformationCustomDTO = proposalHeaderCustomDTO.getVarianceInformationCustomDTO();
		PartnerInformationCustomDTO partnerInformationCustomDTO = proposalHeaderCustomDTO.getPartnerInformationCustomDTO();
		String userId = proposalHeaderCustomDTO.getUserId();

		if (SAVE_PROPOSAL.equals(type) || VALIDATE_PROPOSAL_HEADER_CHANGE.equals(type) || VALIDATE_PROPOSAL_HEADER.equals(type)) {
			proposalBO.setSalesOrg(basicProposalCustomDTO.getSalesOrganization());
			proposalBO.setProposalType(basicProposalCustomDTO.getProposalType());
			proposalBO.setContrStartDate((new java.sql.Date(basicProposalCustomDTO.getContractStartDate().getTime())));
			proposalBO.setContrStartPeriod((new java.sql.Date(basicProposalCustomDTO.getContractPeriodBeginning().getTime())));
			proposalBO.setContrEndDate((new java.sql.Date(basicProposalCustomDTO.getContractEndDate().getTime())));
			proposalBO.setContrEndPeriod((new java.sql.Date(basicProposalCustomDTO.getContractPeriodEnding().getTime())));
			proposalBO.setDistrChannel(basicProposalCustomDTO.getDistributionChannel());
			proposalBO.setSalesGroup(basicProposalCustomDTO.getSalesGroup());
			proposalBO.setChannelRole(basicProposalCustomDTO.getChannelRole());
			proposalBO.setSubmitterRole(basicProposalCustomDTO.getSubmitterRole());
			proposalBO.setDivisionCode(basicProposalCustomDTO.getDivision());
			proposalBO.setCurrency(basicProposalCustomDTO.getCurrencyCode());
			proposalBO.setReportName(basicProposalCustomDTO.getReportName());
			proposalBO.setExtContrNo(basicProposalCustomDTO.getExternalContractNumber());
			proposalBO.setProposalContent(basicProposalCustomDTO.getProposalContent());
			// populate Pricing Information			
			double growthFactor = 0.0;
			if (UtilityConstants.NIL.equalsIgnoreCase(pricingInformationCustomDTO.getGrowthLimitOption().trim())) {
			} else if (UtilityConstants.OTHER.equalsIgnoreCase(pricingInformationCustomDTO.getGrowthLimitOption().trim())) {
				growthFactor = pricingInformationCustomDTO.getGrowthLimitValue();
			} else {
				growthFactor = Double.parseDouble(pricingInformationCustomDTO.getGrowthLimitOption().trim());
			}

			double specialRate = 0.0;
			if (UtilityConstants.NIL.equalsIgnoreCase(pricingInformationCustomDTO.getPlannedGrowthOption().trim())) {
			} else if (UtilityConstants.OTHER.equalsIgnoreCase(pricingInformationCustomDTO.getPlannedGrowthOption().trim())) {
				specialRate = pricingInformationCustomDTO.getPlannedGrowthValue();
			} else {
				specialRate = Double.parseDouble(pricingInformationCustomDTO.getPlannedGrowthOption().trim());
			}

			proposalBO.setGrowthFactor(growthFactor);
			proposalBO.setSpecialRate(specialRate);
			proposalBO.setTvmRate(pricingInformationCustomDTO.getTvmRate());
			//System.out.println("PCMBOBuilder.populateProposalBO():DISCOUNT"+pricingInformationCustomDTO.getDiscount());
			proposalBO.setDiscount(pricingInformationCustomDTO.getDiscount());
			proposalBO.setBillingFreqCode(pricingInformationCustomDTO.getBillingFrequency());
			proposalBO.setAnnvAmount(pricingInformationCustomDTO.getAnniversaryContractAmount());
			//<!-- BlueHarmony DAD006  changed by Anand Sugumaran  --> 
		//	proposalBO.setSAndsAnniversaryAmount(pricingInformationCustomDTO.getSAndSAnniversaryContractAmount());
			/*CR6153 start changes  */
			if (pricingInformationCustomDTO.isExtendPeriod()) {
				proposalBO.setExtendPeriod(UtilityConstants.S_S_EXTEND_PERIOD);
			 } else {
				proposalBO.setExtendPeriod(null);
			}
			
			//<!-- BlueHarmony DAD006  changed by Anand Sugumaran  --> 
			/*proposalBO.setSAndsAnniversaryAmt2(pricingInformationCustomDTO.getSAndSAnniversaryContractAmountPeriod2());
			proposalBO.setSAndsAnniversaryAmt3(pricingInformationCustomDTO.getSAndSAnniversaryContractAmountPeriod3());
			proposalBO.setSAndsAnniversaryAmt4(pricingInformationCustomDTO.getSAndSAnniversaryContractAmountPeriod4());
			proposalBO.setSAndsAnniversaryAmt5(pricingInformationCustomDTO.getSAndSAnniversaryContractAmountPeriod5());
			CR6153 end changes 
			*/ 
		//	OPPTLogger.debug("S And S Anniversary Amount from UI " + proposalBO.getSAndsAnniversaryAmount(), "PCMBOBUILDER", "populateProposalBO");
		//<!-- BlueHarmony DAD006  changes End by Anand Sugumaran  --> 	
			// BH Wave1 - DAD003 -Begin - Manoj
			proposalBO.setCpsId(basicProposalCustomDTO.getCpsID());
			proposalBO.setOcpsId(basicProposalCustomDTO.getOcpsID());
			proposalBO.setContractType(basicProposalCustomDTO.getContractType());
			proposalBO.setBlbIndicator(basicProposalCustomDTO.getBlbIndicator());
			proposalBO.setCciInd(basicProposalCustomDTO.getCciInd());
			proposalBO.setPrebillIndicator(pricingInformationCustomDTO.isPrebillIndicator());
			// BH Wave1 - DAD003 -End - Manoj
			proposalBO.setPakId(pricingInformationCustomDTO.getPakid());
			if (pricingInformationCustomDTO.isDetailedInvoice()) {
				proposalBO.setInvoiceInd(UtilityConstants.DETAILED_INVOICE_SELECTED);
			} else {
				proposalBO.setInvoiceInd(null);
			}
			if (pricingInformationCustomDTO.isGsa()) {
				proposalBO.setGsaInd(UtilityConstants.GSA_SELECTED);
			} else {
				proposalBO.setGsaInd(null);
			}

			if (proposalBO.isVarianceProposal()) {
				if (OPPTHelper.trimStringToNull(proposalBO.getSupressInvoice()) != null) {
					if (!pricingInformationCustomDTO.isInvoiceSuppression()) {
						proposalBO.setSupressInvoice(null);
					}

				} else {
					if (pricingInformationCustomDTO.isInvoiceSuppression()) {
						proposalBO.setSupressInvoice(UtilityConstants.INVOICE_SUPPRESSION_SELECTED_NOT_35);
					} else {
						proposalBO.setSupressInvoice(null);
					}
				}
				OPPTLogger.debug("pricingInformationCustomDTO.isInvoiceSuppression() :" + pricingInformationCustomDTO.isInvoiceSuppression(), "PCMBOBUILDER", "populateProposalBO");
				OPPTLogger.debug("proposalBO.getSuppressInvoice() :" + proposalBO.getSupressInvoice(), "PCMBOBUILDER", "populateProposalBO");
				proposalBO.setCapVariance(pricingInformationCustomDTO.getExceedingAmount());
				OPPTLogger.debug("proposalBO.getCapVariance() :" + proposalBO.getCapVariance(), "PCMBOBUILDER", "populateProposalBO");
				// Since Variance date is not editable we are not setting that again.
			}
			proposalBO.setBillingBlock(pricingInformationCustomDTO.getBillingBlock());
			proposalBO.setBillingType(pricingInformationCustomDTO.getBillingDateRule());
			proposalBO.setFreeText(pricingInformationCustomDTO.getFreeTextForInvoicePrint());
			proposalBO.setDeviatingDateRule(pricingInformationCustomDTO.getDeviatingDateRule());
			if (pricingInformationCustomDTO.isAdvance()) {
				proposalBO.setAdvanceBilling(null);
			} else {
				proposalBO.setAdvanceBilling(UtilityConstants.ADVANCED_BILLING_SELECTED);
			}
			// Variance details
			proposalBO.setCapMinus(varianceInformationCustomDTO.getCapMinus());
			proposalBO.setCapPlus(varianceInformationCustomDTO.getCapPlus());
			proposalBO.setCapAmount(varianceInformationCustomDTO.getCapAmount());
			if(proposalBO.isVarianceProposal()) {
				proposalBO.setCapVariance(pricingInformationCustomDTO.getExceedingAmount());
			}
			//	Secondary Information
			if (secondaryProposalCustomDTO.isSandsExcluded()) {
				proposalBO.setSAndSExcluded(UtilityConstants.YES);
			} else {
				proposalBO.setSAndSExcluded(null);
			}
			proposalBO.setIGFNumber(secondaryProposalCustomDTO.getIgfOfferNumber());
			proposalBO.setAddValueDays(secondaryProposalCustomDTO.getAddValueDays());
			if (secondaryProposalCustomDTO.getPurchaseOrderDate() != null) {
				proposalBO.setPoDate((new java.sql.Date(secondaryProposalCustomDTO.getPurchaseOrderDate().getTime())));
			}
			proposalBO.setPoNo(secondaryProposalCustomDTO.getPurchaseOrderNumber());
			proposalBO.setPayementTerm(secondaryProposalCustomDTO.getPaymentTerms());
			proposalBO.setComments(secondaryProposalCustomDTO.getComments());
			if (secondaryProposalCustomDTO.getFixedValDate() != null) {
				proposalBO.setFixedValueDate((new java.sql.Date(secondaryProposalCustomDTO.getFixedValDate().getTime())));
			}
		}

		if (SAVE_PROPOSAL.equals(type)) {
			//	General Details which needs to be set
			proposalBO.setCreatedBy(userId);
			java.util.Date today = new java.util.Date();
			proposalBO.setCreatedDate((new java.sql.Date(today.getTime())));
			if (basicProposalCustomDTO.getReplacementContractNumber() != null) {
				proposalBO.setOldContrNo(basicProposalCustomDTO.getReplacementContractNumber());
				proposalBO.setContrType(ContractTypeConstants.REPLACEMENT);
			} else {
				proposalBO.setContrType(ContractTypeConstants.ORIGINAL);
				proposalBO.setContrRenewNo(1);
			}

			proposalBO.setStatusCode(ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS);
			proposalBO.setLockedBy(userId);
			proposalBO.setLockedOn((new java.sql.Date(today.getTime())));
			proposalBO.setDeletedInd(UtilityConstants.NO);
			
		}

		if (SAVE_PROPOSAL.equals(type) || CHANGE_PROPOSAL.equals(type)) {
			//PartnerInformation
			ESWCustomerCustomDTO billToParty = partnerInformationCustomDTO.getBillToParty();
			ESWCustomerCustomDTO soldToParty = partnerInformationCustomDTO.getSoldToParty();
			ESWCustomerCustomDTO shipToParty = partnerInformationCustomDTO.getShipToParty();
			ESWCustomerCustomDTO payer = partnerInformationCustomDTO.getPayer();
			ESWCustomerCustomDTO nineDPartner = partnerInformationCustomDTO.getNineDPartner();
			if (billToParty != null) {
				proposalBO.setRegBillToPartASNo(billToParty.getAddressSequenceNumber());
				proposalBO.setRegBillToPartyLegNo(billToParty.getLegacyCustomerNumber());
				proposalBO.setRegBillToPartyName(billToParty.getCustomerName());
				proposalBO.setRegBillToPartyNo(billToParty.getSAPCustomerNumber());
				if (CHANGE_PROPOSAL.equals(type) && proposalBO.isVarianceProposal() && null != OPPTHelper.trimStringToNull(proposalBO.getIGFNumber())) {
					if (UtilityConstants.INVOICE_SUPPRESSION_SELECTED_35.equals(proposalBO.getSupressInvoice())
						|| UtilityConstants.INVOICE_SUPPRESSION_SELECTED_NOT_35.equals(proposalBO.getSupressInvoice())) {
						if (PartnerTypeConstants.CLASS_35.equals(billToParty.getCustomerClass())) {
							proposalBO.setSupressInvoice(UtilityConstants.INVOICE_SUPPRESSION_SELECTED_35);
						} else {
							proposalBO.setSupressInvoice(UtilityConstants.INVOICE_SUPPRESSION_SELECTED_NOT_35);
						}
					}
				}
			}
			if (soldToParty != null) {
				proposalBO.setRegCustomerASNo(soldToParty.getAddressSequenceNumber());
				proposalBO.setRegCustomerLegNo(soldToParty.getLegacyCustomerNumber());
				proposalBO.setRegCustomerName(soldToParty.getCustomerName());
				proposalBO.setRegCustomerNo(soldToParty.getSAPCustomerNumber());
			}
			if (shipToParty != null) {
				proposalBO.setRegShipToPartyASNo(shipToParty.getAddressSequenceNumber());
				proposalBO.setRegShipToPartyLegNo(shipToParty.getLegacyCustomerNumber());
				proposalBO.setRegShipToPartyName(shipToParty.getCustomerName());
				proposalBO.setRegShipToPartyNo(shipToParty.getSAPCustomerNumber());
			}
			if (payer != null) {
				proposalBO.setRegPayerASNo(payer.getAddressSequenceNumber());
				proposalBO.setRegPayerLegNo(payer.getLegacyCustomerNumber());
				proposalBO.setRegPayerName(payer.getCustomerName());
				proposalBO.setRegPayerNo(payer.getSAPCustomerNumber());
			}
			if (nineDPartner != null) {
				proposalBO.setReg9DPartnerName(nineDPartner.getCustomerName());
				proposalBO.setReg9DPartnerNo(nineDPartner.getSAPCustomerNumber());
			}
		} // END OF SAVE OR CHANGE

	}

	
	/**
	 * createBOForVarianceProposal
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param varianceContract
	 * @return void
	 * 
	 * @author balajiv
	 */
	public static ProposalContractBO createBOForVarianceProposal(ProposalContractBO varianceContract) {
		/*	Type of the proposal
			Sales Organization
			Distribution channel
			Division
			Contract start date
			Contract end date
			Information of the STP, Payer, BTP and SHP
			Currency
			CAP Amount
			CAP Plus and CAP Minus
			External contract number
			Variance date
			PO number and date
			CAP Variance
			Cumulative price
			IGF number
		*/
		ProposalContractBO proposalBO = new ProposalContractBO();
		proposalBO.setProposalType(varianceContract.getProposalType());
		proposalBO.setSalesOrg(varianceContract.getSalesOrg());
		proposalBO.setDistrChannel(varianceContract.getDistrChannel());
		proposalBO.setSalesGroup(varianceContract.getSalesGroup());
		proposalBO.setChannelRole(varianceContract.getChannelRole());
		proposalBO.setSubmitterRole(varianceContract.getSubmitterRole());
		proposalBO.setDivisionCode(varianceContract.getDivisionCode());
		proposalBO.setCurrency(varianceContract.getCurrency());
		proposalBO.setContrStartDate(varianceContract.getContrStartDate());
		proposalBO.setContrEndDate(varianceContract.getContrEndDate());
		proposalBO.setCapAmount(varianceContract.getCapAmount());
		proposalBO.setCapPlus(varianceContract.getCapPlus());
		proposalBO.setCapMinus(varianceContract.getCapMinus());
		proposalBO.setExtContrNo(varianceContract.getExtContrNo());
		proposalBO.setVarDate(varianceContract.getVarDate());
		proposalBO.setPoNo(varianceContract.getPoNo());
		proposalBO.setPoDate(varianceContract.getPoDate());
		proposalBO.setCapVariance(varianceContract.getCapVariance());
		proposalBO.setCumValue(varianceContract.getCumValue());
		proposalBO.setIGFNumber(varianceContract.getIGFNumber());
		// BH Wave1 - DAD003 Complex Contract Identifiers - Manoj - Begin
		proposalBO.setCpsId(varianceContract.getCpsId());
		proposalBO.setOcpsId(varianceContract.getOcpsId());
		proposalBO.setContractType(varianceContract.getContractType());
		proposalBO.setCciInd(varianceContract.getCciInd());
		proposalBO.setBlbIndicator(varianceContract.getBlbIndicator());
		// BH Wave1 - DAD003 Complex Contract Identifiers - Manoj - End
		copyPartyInfo(proposalBO, varianceContract);
		return proposalBO;
	}

	/**
	 * copyPartyInfo
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalContract
	 * @param oldProposalContract
	 * @return void
	 * @author balajiv
	 */
	
	private static void copyPartyInfo(ProposalContractBO newProposalContract, ProposalContractBO oldProposalContract) {
		newProposalContract.setRegBillToPartASNo(oldProposalContract.getRegBillToPartASNo());
		newProposalContract.setRegBillToPartyLegNo(oldProposalContract.getRegBillToPartyLegNo());
		newProposalContract.setRegBillToPartyName(oldProposalContract.getRegBillToPartyName());
		newProposalContract.setRegBillToPartyNo(oldProposalContract.getRegBillToPartyNo());
		newProposalContract.setRegCustomerASNo(oldProposalContract.getRegCustomerASNo());
		newProposalContract.setRegCustomerLegNo(oldProposalContract.getRegCustomerLegNo());
		newProposalContract.setRegCustomerName(oldProposalContract.getRegCustomerName());
		newProposalContract.setRegCustomerNo(oldProposalContract.getRegCustomerNo());
		newProposalContract.setRegShipToPartyASNo(oldProposalContract.getRegShipToPartyASNo());
		newProposalContract.setRegShipToPartyLegNo(oldProposalContract.getRegShipToPartyLegNo());
		newProposalContract.setRegShipToPartyName(oldProposalContract.getRegShipToPartyName());
		newProposalContract.setRegShipToPartyNo(oldProposalContract.getRegShipToPartyNo());
		newProposalContract.setRegPayerASNo(oldProposalContract.getRegPayerASNo());
		newProposalContract.setRegPayerLegNo(oldProposalContract.getRegPayerLegNo());
		newProposalContract.setRegPayerName(oldProposalContract.getRegPayerName());
		newProposalContract.setRegPayerNo(oldProposalContract.getRegPayerNo());
		newProposalContract.setReg9DPartnerName(oldProposalContract.getReg9DPartnerName());
		newProposalContract.setReg9DPartnerNo(oldProposalContract.getReg9DPartnerNo());
	}
	
	
	/**
	 * createBOForEASIICopy
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldPropsalContract
	 * @return ProposalContractBO
	 * 
	 * @author balajiv
	 */
	public static ProposalContractBO createBOForEASIICopy(ProposalContractBO oldPropsalContract) {
		/*
		 * 	Billing frequency
			Sales organization
			Distribution channel
			Division
			Contract end date
			Contract period end date
			Information of the STP, Payer, BTP and SHP
			Currency
			Name of the report
			CAP Amount
			PAK ID
			Whether Billing should be done in advance or arrears
			Deviating date rule
			Billing Type
		 */

		ProposalContractBO newPropsalContract = new ProposalContractBO();
		newPropsalContract.setSalesOrg(oldPropsalContract.getSalesOrg());
		newPropsalContract.setDistrChannel(oldPropsalContract.getDistrChannel());
		newPropsalContract.setSalesGroup(oldPropsalContract.getSalesGroup());
		newPropsalContract.setChannelRole(oldPropsalContract.getChannelRole());
		newPropsalContract.setSubmitterRole(oldPropsalContract.getSubmitterRole());
		newPropsalContract.setDivisionCode(oldPropsalContract.getDivisionCode());
		newPropsalContract.setCurrency(oldPropsalContract.getCurrency());
		newPropsalContract.setBillingFreqCode(oldPropsalContract.getBillingFreqCode());
		newPropsalContract.setContrEndDate(oldPropsalContract.getContrEndDate());
		newPropsalContract.setContrEndPeriod(oldPropsalContract.getContrEndPeriod());
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Manoj - Begin
		newPropsalContract.setCpsId(oldPropsalContract.getCpsId());
		newPropsalContract.setOcpsId(oldPropsalContract.getOcpsId());
		newPropsalContract.setContractType(oldPropsalContract.getContractType());
		newPropsalContract.setBlbIndicator(oldPropsalContract.getBlbIndicator());
		newPropsalContract.setPrebillIndicator(oldPropsalContract.getPrebillIndicator());
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Manoj - End

		newPropsalContract.setReportName(oldPropsalContract.getReportName());
		newPropsalContract.setCapAmount(oldPropsalContract.getCapAmount());
		newPropsalContract.setPakId(oldPropsalContract.getPakId());
		newPropsalContract.setAdvanceBilling(oldPropsalContract.getAdvanceBilling());
		newPropsalContract.setDeviatingDateRule(oldPropsalContract.getDeviatingDateRule());
		newPropsalContract.setBillingType(oldPropsalContract.getBillingType());
		newPropsalContract.setPayementTerm(oldPropsalContract.getPayementTerm());
		newPropsalContract.setExtContrNo(oldPropsalContract.getExtContrNo());
		
		newPropsalContract.setContrStartPeriod(oldPropsalContract.getContrStartPeriod());
		newPropsalContract.setContrStartDate(oldPropsalContract.getContrStartDate());
		newPropsalContract.setProposalContent(oldPropsalContract.getProposalContent());

		
		copyPartyInfo(newPropsalContract, oldPropsalContract);

		return newPropsalContract;
	}
	
	/**
	 * createBOForCopyProposal
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldPropsalContract
	 * @return ProposalContractBO
	 * 
	 * @author balajiv
	 */
	public static ProposalContractBO createBOForCopyProposal(ProposalContractBO oldPropsalContract) {

		/*
		 * 	Type of the proposal
			Billing frequency
			Sales Organization
			Distribution channel
			Division
			Name of report
			Contract start date
			Contract end date
			Contract period start date
			Contract period end date
			TVM Rate
			Planned Growth
			Growth Limit
			Anniversary Amount
			Information of the STP, Payer, BTP and SHP
			Currency
			Last date on which inventory was fetched
			Whether inventory is fetched after initial fetch
			CAP Amount
			CAP Plus and CAP Minus
			PAK ID
			Whether Billing should be done in advance or arrears
			Whether detailed invoice is required
			Billing Type
			Payment Terms
			Add value days and Fixed Value date
			PO number and date
			Back End time-stamp of last inventory fetch
			Deviating Date rule
			Comments about the proposal
			S&S anniversary amount
			Proposal content
		 */

		ProposalContractBO newPropsalContract = new ProposalContractBO();
		newPropsalContract.setProposalType(oldPropsalContract.getProposalType());
		newPropsalContract.setSalesOrg(oldPropsalContract.getSalesOrg());
		newPropsalContract.setDistrChannel(oldPropsalContract.getDistrChannel());
		newPropsalContract.setSalesGroup(oldPropsalContract.getSalesGroup());
		newPropsalContract.setChannelRole(oldPropsalContract.getChannelRole());
		newPropsalContract.setSubmitterRole(oldPropsalContract.getSubmitterRole());
		newPropsalContract.setDivisionCode(oldPropsalContract.getDivisionCode());
		newPropsalContract.setCurrency(oldPropsalContract.getCurrency());
		newPropsalContract.setBillingFreqCode(oldPropsalContract.getBillingFreqCode());
		newPropsalContract.setContrEndDate(oldPropsalContract.getContrEndDate());
		newPropsalContract.setContrEndPeriod(oldPropsalContract.getContrEndPeriod());
		newPropsalContract.setContrStartDate(oldPropsalContract.getContrStartDate());
		newPropsalContract.setContrStartPeriod(oldPropsalContract.getContrStartPeriod());

		newPropsalContract.setTvmRate(oldPropsalContract.getTvmRate());
		newPropsalContract.setDiscount(oldPropsalContract.getDiscount());
		newPropsalContract.setGrowthFactor(oldPropsalContract.getGrowthFactor());
		newPropsalContract.setSpecialRate(oldPropsalContract.getSpecialRate());

		newPropsalContract.setAnnvAmount(oldPropsalContract.getAnnvAmount());
		newPropsalContract.setEswFetchDate(oldPropsalContract.getEswFetchDate());
		newPropsalContract.setFetchDate(oldPropsalContract.getFetchDate());
		newPropsalContract.setRefetchId(oldPropsalContract.getRefetchId());

		newPropsalContract.setReportName(oldPropsalContract.getReportName());
		newPropsalContract.setCapAmount(oldPropsalContract.getCapAmount());
		newPropsalContract.setCapPlus(oldPropsalContract.getCapPlus());
		newPropsalContract.setCapMinus(oldPropsalContract.getCapMinus());
		newPropsalContract.setPakId(oldPropsalContract.getPakId());
		newPropsalContract.setAdvanceBilling(oldPropsalContract.getAdvanceBilling());
		newPropsalContract.setInvoiceInd(oldPropsalContract.getInvoiceInd());
		newPropsalContract.setBillingType(oldPropsalContract.getBillingType());
		newPropsalContract.setPayementTerm(oldPropsalContract.getPayementTerm());
		newPropsalContract.setAddValueDays(oldPropsalContract.getAddValueDays());
		newPropsalContract.setFixedValueDate(oldPropsalContract.getFixedValueDate());
		newPropsalContract.setPoNo(oldPropsalContract.getPoNo());
		newPropsalContract.setPoDate(oldPropsalContract.getPoDate());
		newPropsalContract.setDeviatingDateRule(oldPropsalContract.getDeviatingDateRule());
		newPropsalContract.setEswFetchTime(oldPropsalContract.getEswFetchTime());
		newPropsalContract.setDeviatingDateRule(oldPropsalContract.getDeviatingDateRule());

		newPropsalContract.setComments(oldPropsalContract.getComments());
		newPropsalContract.setProposalContent(oldPropsalContract.getProposalContent());
		newPropsalContract.setSAndsAnniversaryAmount(oldPropsalContract.getSAndsAnniversaryAmount());

		copyPartyInfo(newPropsalContract, oldPropsalContract);

		return newPropsalContract;
	}
	
	/**
	 * createBOForRenewContract
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldPropsalContract
	 * @return ProposalContractBO
	 * 
	 * @author balajiv
	 */

	public static ProposalContractBO createBOForRenewContract(ProposalContractBO oldPropsalContract) {

		/*
		 * 	Type of the proposal
			Billing frequency
			Sales Organization
			Distribution channel
			Division
			Contract start date
			Contract end date
			TVM Rate
			Planned Growth
			Growth Limit
			Anniversary Amount
			Comments
			Currency
			Name of the Report
			CAP Amount
			CAP PLUS and CAP MINUS
			PAK ID
			Whether Billing should be done in advance or arrears
			Billing Type
			Payment Terms
			Add value days and Fixed Value date
			Whether detailed invoice is required
			Deviating Date rule
			Variance count within the contract duration
			S&S anniversary amount
			Proposal content
		
		 */

		ProposalContractBO newPropsalContract = new ProposalContractBO();
		newPropsalContract.setProposalType(oldPropsalContract.getProposalType());
		newPropsalContract.setSalesOrg(oldPropsalContract.getSalesOrg());
		newPropsalContract.setSalesGroup(oldPropsalContract.getSalesGroup());
		newPropsalContract.setChannelRole(oldPropsalContract.getChannelRole());
		newPropsalContract.setSubmitterRole(oldPropsalContract.getSubmitterRole());
		newPropsalContract.setDistrChannel(oldPropsalContract.getDistrChannel());
		newPropsalContract.setDivisionCode(oldPropsalContract.getDivisionCode());
		newPropsalContract.setCurrency(oldPropsalContract.getCurrency());
		newPropsalContract.setBillingFreqCode(oldPropsalContract.getBillingFreqCode());
		newPropsalContract.setContrEndDate(oldPropsalContract.getContrEndDate());
		newPropsalContract.setContrStartDate(oldPropsalContract.getContrStartDate());

		newPropsalContract.setTvmRate(oldPropsalContract.getTvmRate());
		newPropsalContract.setDiscount(oldPropsalContract.getDiscount());
		newPropsalContract.setGrowthFactor(oldPropsalContract.getGrowthFactor());
		newPropsalContract.setSpecialRate(oldPropsalContract.getSpecialRate());

		newPropsalContract.setAnnvAmount(oldPropsalContract.getAnnvAmount());

		newPropsalContract.setReportName(oldPropsalContract.getReportName());
		newPropsalContract.setCapAmount(oldPropsalContract.getCapAmount());
		newPropsalContract.setCapPlus(oldPropsalContract.getCapPlus());
		newPropsalContract.setCapMinus(oldPropsalContract.getCapMinus());
		newPropsalContract.setPakId(oldPropsalContract.getPakId());
		newPropsalContract.setAdvanceBilling(oldPropsalContract.getAdvanceBilling());
		newPropsalContract.setInvoiceInd(oldPropsalContract.getInvoiceInd());

		newPropsalContract.setBillingType(oldPropsalContract.getBillingType());
		newPropsalContract.setPayementTerm(oldPropsalContract.getPayementTerm());
		newPropsalContract.setAddValueDays(oldPropsalContract.getAddValueDays());
		newPropsalContract.setFixedValueDate(oldPropsalContract.getFixedValueDate());
		newPropsalContract.setDeviatingDateRule(oldPropsalContract.getDeviatingDateRule());
		newPropsalContract.setDeviatingDateRule(oldPropsalContract.getDeviatingDateRule());
		newPropsalContract.setContrPeriodVarNo(oldPropsalContract.getContrPeriodVarNo());

		newPropsalContract.setComments(oldPropsalContract.getComments());
		newPropsalContract.setProposalContent(oldPropsalContract.getProposalContent());
		newPropsalContract.setSAndsAnniversaryAmount(oldPropsalContract.getSAndsAnniversaryAmount());
		return newPropsalContract;
	}
	/**
	 * createBOForCopyReplacement
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldPropsalContract
	 * @return ProposalContractBO
	 * 
	 * @author balajiv
	 */
	public static ProposalContractBO createBOForCopyReplacement(ProposalContractBO oldPropsalContract) {
		/*
		 * 	Type of the proposal
			Billing frequency
			Sales Organization
			Distribution channel
			Division
			Contract end date
			Contract period end date
			TVM Rate
			Planned Growth
			Growth Limit	
			Anniversary Amount
			Comments
			Currency
			Last date on which inventory was fetched
			Whether inventory is fetched after initial fetch
			Name of the report
			CAP Amount
			CAP Plus and CAP Minus
			External contract number
			PAK ID
			Whether Billing should be done in advance or arrears
			Whether detailed invoice is required
			Billing Type
			Payment Terms
			Add value days and Fixed Value date
			PO number and date
			Back End time-stamp of last inventory fetch
			Deviating Date rule
			
			Variance count within the contract duration
			Renewal count within the contract duration
			Amendment count within the contract duration
			S&S anniversary amount
			Proposal content
		
		 */
		ProposalContractBO newPropsalContract = new ProposalContractBO();
		newPropsalContract.setProposalType(oldPropsalContract.getProposalType());
		newPropsalContract.setSalesOrg(oldPropsalContract.getSalesOrg());
		newPropsalContract.setDistrChannel(oldPropsalContract.getDistrChannel());
		newPropsalContract.setSalesGroup(oldPropsalContract.getSalesGroup());
		newPropsalContract.setChannelRole(oldPropsalContract.getChannelRole());
		newPropsalContract.setSubmitterRole(oldPropsalContract.getSubmitterRole());
		newPropsalContract.setDivisionCode(oldPropsalContract.getDivisionCode());
		newPropsalContract.setCurrency(oldPropsalContract.getCurrency());
		newPropsalContract.setBillingFreqCode(oldPropsalContract.getBillingFreqCode());
		newPropsalContract.setContrEndDate(oldPropsalContract.getContrEndDate());
		newPropsalContract.setContrEndPeriod(oldPropsalContract.getContrEndPeriod());
		
		newPropsalContract.setTvmRate(oldPropsalContract.getTvmRate());
		newPropsalContract.setDiscount(oldPropsalContract.getDiscount());
		newPropsalContract.setGrowthFactor(oldPropsalContract.getGrowthFactor());
		newPropsalContract.setSpecialRate(oldPropsalContract.getSpecialRate());

		newPropsalContract.setAnnvAmount(oldPropsalContract.getAnnvAmount());
		newPropsalContract.setComments(oldPropsalContract.getComments());
		newPropsalContract.setEswFetchDate(oldPropsalContract.getEswFetchDate());
		newPropsalContract.setFetchDate(oldPropsalContract.getFetchDate());
		newPropsalContract.setRefetchId(oldPropsalContract.getRefetchId());

		newPropsalContract.setReportName(oldPropsalContract.getReportName());
		newPropsalContract.setCapAmount(oldPropsalContract.getCapAmount());
		newPropsalContract.setCapPlus(oldPropsalContract.getCapPlus());
		newPropsalContract.setCapMinus(oldPropsalContract.getCapMinus());
		newPropsalContract.setExtContrNo(oldPropsalContract.getExtContrNo());
		newPropsalContract.setPakId(oldPropsalContract.getPakId());
		
		newPropsalContract.setAdvanceBilling(oldPropsalContract.getAdvanceBilling());
		newPropsalContract.setInvoiceInd(oldPropsalContract.getInvoiceInd());
		newPropsalContract.setBillingType(oldPropsalContract.getBillingType());
		newPropsalContract.setPayementTerm(oldPropsalContract.getPayementTerm());
		
		newPropsalContract.setAddValueDays(oldPropsalContract.getAddValueDays());
		newPropsalContract.setFixedValueDate(oldPropsalContract.getFixedValueDate());
		newPropsalContract.setPoNo(oldPropsalContract.getPoNo());
		newPropsalContract.setPoDate(oldPropsalContract.getPoDate());
		
		newPropsalContract.setDeviatingDateRule(oldPropsalContract.getDeviatingDateRule());
		newPropsalContract.setEswFetchTime(oldPropsalContract.getEswFetchTime());
		
		newPropsalContract.setContrPeriodVarNo(oldPropsalContract.getContrPeriodVarNo());
		newPropsalContract.setContrRenewNo(oldPropsalContract.getContrRenewNo());
		newPropsalContract.setContrAmendNo(oldPropsalContract.getContrAmendNo());
		
		newPropsalContract.setProposalContent(oldPropsalContract.getProposalContent());
		newPropsalContract.setSAndsAnniversaryAmount(oldPropsalContract.getSAndsAnniversaryAmount());

		copyPartyInfo(newPropsalContract, oldPropsalContract);

		return newPropsalContract;
	}

}
