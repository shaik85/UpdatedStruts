/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePartnerConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.*;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.UserProfileBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ErrorListBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ContractTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.LicenseConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PartnerTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalContractStatusConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CloseContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorInfoCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PricingInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSEECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SecondaryProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerLocalHome;

/** 
 * Builds the CustomDTOs from DomainDTO or the BOs for ProposalContractManager
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 9, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Arun Nagarajan
 * @version 5.1A 
 */
public class PCMCustomDTOBuilder {
	/** Contsants */
	public static final String CONTRACT_LIST_FOR_USER = "C";
	/** Contsants */
	
	public static final String ARCHIVE_LIST_FOR_USER = "R";
	//DAD-001 BlueHarmony Changed by Anand Sugumaran
	public static final String PROPOSALS_LIST_FOR_USER = "P";
	public static final String PROPOSAL_CONTRACT_LIST_FOR_APPROVER = "A";
	/** Contsants */
	private static final String CLASS_NAME = "PCMCustomDTOBuilder";

	/** 
	 * Populates the Customer's Custom DTO with the Partner Details of the customer
	 * retrieved from DomainDTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customCustomer
	 * @param domainCustomer
	 * @param partnerType
	 * @return ESWCustomerCustomDTO
	 */
	public static ESWCustomerCustomDTO populateCustomDTOForCustomerDetailsFromDomainDTO(ESWCustomerCustomDTO customCustomer, CustomerDomainDTO domainCustomer, int partnerType) {

		customCustomer.setPartnerType(partnerType);
		if (partnerType == UtilityConstants.PARTNER_SOLD_TO_PARTY) {
			customCustomer.setAddressSequenceNumber(domainCustomer.getCustmerASNo());
			customCustomer.setLegacyCustomerNumber(domainCustomer.getLegacyCustomerNo());
			customCustomer.setCustomerName(domainCustomer.getSapCustomerName());
			customCustomer.setSAPCustomerNumber(domainCustomer.getSapCustomerNo());
		} else if (partnerType == UtilityConstants.PARTNER_BILL_TO_PARTY) {
			customCustomer.setAddressSequenceNumber(domainCustomer.getBillToPartyASNo());
			customCustomer.setLegacyCustomerNumber(domainCustomer.getBillToPartyLNo());
			customCustomer.setCustomerName(domainCustomer.getBillToPartyName());
			customCustomer.setSAPCustomerNumber(domainCustomer.getBillToPartyNo());
		} else if (partnerType == UtilityConstants.PARTNER_SHIP_TO_PARTY) {
			customCustomer.setAddressSequenceNumber(domainCustomer.getShipToPartyASNo());
			customCustomer.setLegacyCustomerNumber(domainCustomer.getShipToPartyLNo());
			customCustomer.setCustomerName(domainCustomer.getShipToPartyName());
			customCustomer.setSAPCustomerNumber(domainCustomer.getShipToPartyNo());
		} else if (partnerType == UtilityConstants.PARTNER_PAYER) {
			customCustomer.setAddressSequenceNumber(domainCustomer.getPayerASNo());
			customCustomer.setLegacyCustomerNumber(domainCustomer.getPayerLNo());
			customCustomer.setCustomerName(domainCustomer.getPayerName());
			customCustomer.setSAPCustomerNumber(domainCustomer.getPayerNo());
		}
		return customCustomer;
	}

	/** 
	 * Populates the Customer's Custom DTO with the Partner Details of the
	 * the Proposal 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customCustomer
	 * @param proposal
	 * @param partnerType
	 * @return ESWCustomerCustomDTO
	 */
	public static ESWCustomerCustomDTO populateCustomDTOForCustomerDetailsFromPCBO(ESWCustomerCustomDTO customCustomer, ProposalContractBO proposal, int partnerType) {
		customCustomer.setPartnerType(partnerType);
		if (partnerType == UtilityConstants.PARTNER_SOLD_TO_PARTY) {
			
			customCustomer.setAddressSequenceNumber(proposal.getRegCustomerASNo());
			customCustomer.setLegacyCustomerNumber(proposal.getRegCustomerLegNo());
			customCustomer.setCustomerName(proposal.getRegCustomerName());
			customCustomer.setSAPCustomerNumber(proposal.getRegCustomerNo());
		} else if (partnerType == UtilityConstants.PARTNER_BILL_TO_PARTY) {
			customCustomer.setAddressSequenceNumber(proposal.getRegBillToPartASNo());
			customCustomer.setLegacyCustomerNumber(proposal.getRegBillToPartyLegNo());
			customCustomer.setCustomerName(proposal.getRegBillToPartyName());
			customCustomer.setSAPCustomerNumber(proposal.getRegBillToPartyNo());
		} else if (partnerType == UtilityConstants.PARTNER_SHIP_TO_PARTY) {
			customCustomer.setAddressSequenceNumber(proposal.getRegShipToPartyASNo());
			customCustomer.setLegacyCustomerNumber(proposal.getRegShipToPartyLegNo());
			customCustomer.setCustomerName(proposal.getRegShipToPartyName());
			customCustomer.setSAPCustomerNumber(proposal.getRegShipToPartyNo());
		} else if (partnerType == UtilityConstants.PARTNER_PAYER) {
			customCustomer.setAddressSequenceNumber(proposal.getRegPayerASNo());
			customCustomer.setLegacyCustomerNumber(proposal.getRegPayerLegNo());
			customCustomer.setCustomerName(proposal.getRegPayerName());
			customCustomer.setSAPCustomerNumber(proposal.getRegPayerNo());
		}
		return customCustomer;
	}

	/** 
	 * Populates SWODetailsCustomDTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param domainCustomer
	 * @param domainMachine
	 * @param domainLicense
	 * @param proposal
	 * @param customLicense
	 * @return SWODetailsCustomDTO
	 */
	public static SWODetailsCustomDTO populateSWODetailsCustomDTOFromDomainDTO(
		CustomerDomainDTO domainCustomer,
		DMDomainDTO domainMachine,
		SWODomainDTO domainLicense,
		ProposalContractBO proposal,
		SWODetailsCustomDTO customLicense) {

		customLicense.setSwoContractNumber(domainLicense.getSwoExtContrNo());
		customLicense.setSwoContractStatus(domainLicense.getSwoContrStatus());
		customLicense.setSwoContractType(domainLicense.getSwoContrType());
		customLicense.setSwoReferenceDN(domainLicense.getReferenceSerialNoDM());
		customLicense.setSwoReferenceSN(domainLicense.getReferenceSerialNo());

		customLicense.setDMDescription(domainMachine.getDmDesc());
		customLicense.setDmNumber(domainMachine.getDmNo());
		customLicense.setDMId(String.valueOf(domainMachine.getDmId()));
		customLicense.setDmPlanEndDate(domainMachine.getPlanEndDate());
		customLicense.setDmPlanStartDate(domainLicense.getPlanStartDate());

		ESWCustomerCustomDTO customCustomer = new ESWCustomerCustomDTO();
		customCustomer = populateCustomDTOForCustomerDetailsFromDomainDTO(customCustomer, domainCustomer, UtilityConstants.PARTNER_SOLD_TO_PARTY);
		customLicense.setSoldToParty(customCustomer);
		customCustomer = new ESWCustomerCustomDTO();
		if (domainCustomer.getBillToPartyLNo() != null) {
			customCustomer = populateCustomDTOForCustomerDetailsFromDomainDTO(customCustomer, domainCustomer, UtilityConstants.PARTNER_BILL_TO_PARTY);
		} else {
			customCustomer = populateCustomDTOForCustomerDetailsFromPCBO(customCustomer, proposal, UtilityConstants.PARTNER_BILL_TO_PARTY);
		}
		customLicense.setBillToParty(customCustomer);
		customCustomer = new ESWCustomerCustomDTO();
		if (domainCustomer.getPayerLNo() != null) {
			customCustomer = populateCustomDTOForCustomerDetailsFromDomainDTO(customCustomer, domainCustomer, UtilityConstants.PARTNER_PAYER);
		} else {
			customCustomer = populateCustomDTOForCustomerDetailsFromPCBO(customCustomer, proposal, UtilityConstants.PARTNER_PAYER);
		}
		customLicense.setPayer(customCustomer);
		customLicense.setCustomerPlanStartDate(domainCustomer.getPlanStartDate());
		customLicense.setCustomerPlanEndDate(domainCustomer.getPlanEndDate());

		populateSWOCustomDTOFromDomainDTO(domainLicense, customLicense);
		List eeList = domainLicense.getEEDTOList();
		if (eeList != null) {
			Iterator eeIterate = eeList.iterator();
			while (eeIterate.hasNext()) {
				EEDomainDTO eeDomain = (EEDomainDTO) eeIterate.next();
				EECustomDTO eeCustom = new EECustomDTO();
				eeCustom = populateEECustomDTOFromDomainDTO(eeDomain, eeCustom, domainLicense.isActionAllowed());
				//CR 2031
				if(!customLicense.isSWOEditable()) {
					eeCustom.setEditable(false);
				}
				customLicense.addEE(eeCustom);
			}
		}
		// S and S Change
		if (UtilityConstants.SANDS_IND.equals(OPPTHelper.trimString(domainLicense.getSAndSInd()))) {
			customLicense.setSAndS(true);
		}
		// S and S Change
		return customLicense;
	}

	/** 
	 * Populates EECustomDTO from EEDomainDTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param domainEE
	 * @param eeCustom
	 * @param isActionAllowedAtLicense
	 * @return EECustomDTO
	 */
	public static EECustomDTO populateEECustomDTOFromDomainDTO(EEDomainDTO domainEE, EECustomDTO eeCustom, boolean isActionAllowedAtLicense) {
		eeCustom.setId(String.valueOf(domainEE.getEeId()));
		eeCustom.setNumber(domainEE.getEeNo());
		eeCustom.setAlternatePrice(domainEE.getAlternatePrice());
		/**
		  * 31/05/2004
		  * MN 19387428- Defect 351
		  * For Alternate Price change added by Balaji
		  */
		if(domainEE.getAlternatePrice() == 0 && (!("Y".equals(domainEE.getAlternatePriceUpdateInd())))) {
			eeCustom.setAlternatePrice(-1);
		}
		/**
		 * Change Ends
		 */
		eeCustom.setCalculatedPrice(domainEE.getCalculatedPrice());
		eeCustom.setEswPrice(domainEE.getEswPrice());
		eeCustom.setValueMetric(domainEE.getValueMetric());
		eeCustom.setLicenseType(domainEE.getLicenseType());
		eeCustom.setUseLevel(domainEE.getUseLevel());
		eeCustom.setDescription(domainEE.getEeDesc());
		if (domainEE.getChargeOptionDesc() != null && UtilityConstants.NO_CHARGE.equalsIgnoreCase(domainEE.getChargeOptionDesc())) {
			// EE with NO Charge
			eeCustom.setDiscountEditable(false);
		}

		if (isActionAllowedAtLicense) {
			eeCustom.setEditable(domainEE.isActionAllowed());
		} else {
			eeCustom.setEditable(false);
		}

		// S and s change starts
		eeCustom.setSAndSDiscountPercent(domainEE.getSAndSDiscountPercent());
		// S and s change ends
		return eeCustom;
	}

	/** 
	 * Populates SWOCustomDTO from SWODomainDTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param domainLicense
	 * @param customLicense
	 * @return SWOCustomDTO
	 */
	public static SWOCustomDTO populateSWOCustomDTOFromDomainDTO(SWODomainDTO domainLicense, SWOCustomDTO customLicense) {
		customLicense.setAlternatePrice(domainLicense.getAlternatePrice());
		customLicense.setCalculatedPrice(domainLicense.getCalcPrice());
		customLicense.setEswPrice(domainLicense.getEswPrice());
		customLicense.setDescription(domainLicense.getSwoDesc());
		customLicense.setNumber(domainLicense.getSwoNo());
		customLicense.setPlanEndDate(domainLicense.getPlanEndDate());
		customLicense.setPlanStartDate(domainLicense.getPlanStartDate());
		customLicense.setId(String.valueOf(domainLicense.getSwoId()));
		customLicense.setCustomerId(String.valueOf(domainLicense.getCustomerId()));
		customLicense.setDMId(String.valueOf(domainLicense.getDmId()));
		customLicense.setProposalId(domainLicense.getProposalId());
		customLicense.setSerialNumber(domainLicense.getSerialNo());
		if (LicenseConstants.SVC_LICENSE_FLAG.equals(domainLicense.getItemCategory())) {
			customLicense.setSvcLicense(true);
		}
		if (LicenseConstants.QUOTE_FLAG.equals(domainLicense.getItemCategory())) {
			customLicense.setQuote(true);
		}
		if (LicenseConstants.LICENSE_EXCLUDED.equals(domainLicense.getExclusionId())) {
			customLicense.setExcluded(true);
		}
		if (LicenseConstants.LICENSE_REFETCHED.equals(domainLicense.getRefetchId())) {
			customLicense.setRefetchLicense(true);
		}
		if (LicenseConstants.LICENSE_DELTAFETCH.equals(domainLicense.getDeltaFetchId())) {
			customLicense.setDeltaFetchLicense(true);
		}
		if (LicenseConstants.LICENSE_PLANNED.equals(domainLicense.getPlannedInd())) {
			customLicense.setEditedLicense(true);
		}
		if (domainLicense.getAmendStartDate() != null || domainLicense.getAmendEndDate() != null) {
			customLicense.setAmendedLicense(true);
		}
		return customLicense;
	}

	/** 
	 * Builds CloseContractCustomDTO from BO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customContract
	 * @param contract
	 * @return CloseContractCustomDTO
	 */
	public static CloseContractCustomDTO populateCloseContractCustomDTOFromBO(CloseContractCustomDTO customContract, ProposalContractBO contract) {
		customContract.setContractClosureDate(contract.getContrClsDate());
		customContract.setContractEndDate(contract.getContrEndDate());
		customContract.setContractNumber(contract.getContrNo());
		customContract.setContractPeriodEndDate(contract.getContrEndPeriod());
		customContract.setContractPeriodStartDate(contract.getContrStartPeriod());
		customContract.setContractStartDate(contract.getContrStartDate());
		customContract.setContractType(contract.getContrType());
		customContract.setExternalContractNumber(contract.getExtContrNo());
		customContract.setProposalName(contract.getProposalName());
		customContract.setProposalType(contract.getProposalType());
		/* start change CR6153*/
		customContract.setISandsExtendPeriod(contract.getExtendPeriod());
		/* end change CR6153*/
		customContract.setProposalContent(contract.getProposalContent());
		if (ProposalContractStatusConstants.VARIANCE_CONTRACT.equals(contract.getStatusCode())
			|| (ProposalContractStatusConstants.CONTRACT_CLOSURE_FAILED_RETRY.equals(contract.getStatusCode()) && ContractTypeConstants.VARIANCE.equals(contract.getContrType()))) {
			customContract.setCloseVarianceContract(true);
		}

		return customContract;
	}
	
	/** 
	 * populatePartnerInformation
	 * Populates the Customer's Custom DTO with the Partner Details of the customer
	 * retrieved from DomainDTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param retrievePartnerConnectorDTOList
	 * @param fetchPartnerInformationCustomDTO
	 * @param changeProposal
	 * @param igfFlag
	 * @return void
	 */
	public static void populatePartnerInformation(List retrievePartnerConnectorDTOList, FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO, boolean changeProposal, boolean igfFlag) {
		TreeMap soldToParty = new TreeMap();
		TreeMap billToParty = new TreeMap();
		TreeMap payer = new TreeMap();
		TreeMap shipToParty = new TreeMap();

		for (int i = 0; i < retrievePartnerConnectorDTOList.size(); i++) {
			RetrievePartnerConnectorDTO retrievePartnerConnectorDTO = (RetrievePartnerConnectorDTO) retrievePartnerConnectorDTOList.get(i);
			ESWCustomerCustomDTO customerInfoCustomDTO = new ESWCustomerCustomDTO();
			customerInfoCustomDTO.setCustomerName(retrievePartnerConnectorDTO.getCustomerName());
			customerInfoCustomDTO.setSAPCustomerNumber(retrievePartnerConnectorDTO.getCustomerNumber());
			/*customerInfoCustomDTO.setLegacyCustomerNumber(retrievePartnerConnectorDTO.getLegacyNumber());
			customerInfoCustomDTO.setAddressSequenceNumber(retrievePartnerConnectorDTO.getSequenceNumber());*/
						
			if (PartnerTypeConstants.SOLD_TO_PARTY.equals(retrievePartnerConnectorDTO.getFlag())) {
				soldToParty.put(customerInfoCustomDTO.getSAPCustomerNumber(), customerInfoCustomDTO);
				fetchPartnerInformationCustomDTO.setCustomer(customerInfoCustomDTO);
				if ((!changeProposal) && soldToParty.size() == 1) {
					fetchPartnerInformationCustomDTO.setSelectedSoldToParty(customerInfoCustomDTO);
				}
			} else if (PartnerTypeConstants.BILL_TO_PARTY.equals(retrievePartnerConnectorDTO.getFlag())) {
				billToParty.put(customerInfoCustomDTO.getSAPCustomerNumber(), customerInfoCustomDTO);
				if ((!changeProposal) && billToParty.size() == 1 && (!igfFlag)) {
					fetchPartnerInformationCustomDTO.setSelectedBillToParty(customerInfoCustomDTO);
				}
			} else if (PartnerTypeConstants.PAYER.equals(retrievePartnerConnectorDTO.getFlag())) {
				payer.put(customerInfoCustomDTO.getSAPCustomerNumber(), customerInfoCustomDTO);
				if ((!changeProposal) && payer.size() == 1 && (!igfFlag)) {
					fetchPartnerInformationCustomDTO.setSelectedPayer(customerInfoCustomDTO);
				}
			} else if (PartnerTypeConstants.SHIP_TO_PARTY.equals(retrievePartnerConnectorDTO.getFlag())) {
				shipToParty.put(customerInfoCustomDTO.getSAPCustomerNumber(), customerInfoCustomDTO);
				if ((!changeProposal) && shipToParty.size() == 1) {
					fetchPartnerInformationCustomDTO.setSelectedShipToParty(customerInfoCustomDTO);
				}
			}
		}

		if (changeProposal) {
			if (null != fetchPartnerInformationCustomDTO.getSelectedShipToParty() && null == shipToParty.get(fetchPartnerInformationCustomDTO.getSelectedShipToParty().getSAPCustomerNumber())) {
				// The data is not in List which is defaulted so add selected one.
				shipToParty.put(fetchPartnerInformationCustomDTO.getSelectedShipToParty().getSAPCustomerNumber(), fetchPartnerInformationCustomDTO.getSelectedShipToParty());
			}
			if (null != fetchPartnerInformationCustomDTO.getSelectedSoldToParty() && null == soldToParty.get(fetchPartnerInformationCustomDTO.getSelectedSoldToParty().getSAPCustomerNumber())) {
				// The data is not in List which is defaulted so add selected one.
				soldToParty.put(fetchPartnerInformationCustomDTO.getSelectedSoldToParty().getSAPCustomerNumber(), fetchPartnerInformationCustomDTO.getSelectedSoldToParty());
			}
			if (!igfFlag) {
				if (null != fetchPartnerInformationCustomDTO.getSelectedPayer() && null == payer.get(fetchPartnerInformationCustomDTO.getSelectedPayer().getSAPCustomerNumber())) {
					// The data is not in List which is defaulted so add selected one.
					payer.put(fetchPartnerInformationCustomDTO.getSelectedPayer().getSAPCustomerNumber(), fetchPartnerInformationCustomDTO.getSelectedPayer());
				}
				if (null != fetchPartnerInformationCustomDTO.getSelectedBillToParty() && null == billToParty.get(fetchPartnerInformationCustomDTO.getSelectedBillToParty().getSAPCustomerNumber())) {
					// The data is not in List which is defaulted so add selected one.
					billToParty.put(fetchPartnerInformationCustomDTO.getSelectedBillToParty().getSAPCustomerNumber(), fetchPartnerInformationCustomDTO.getSelectedBillToParty());
				}
			}

		}

		fetchPartnerInformationCustomDTO.setShipToParty(shipToParty);
		if (!igfFlag) {
			fetchPartnerInformationCustomDTO.setBillToParty(billToParty);
			fetchPartnerInformationCustomDTO.setPayer(payer);
		}

		fetchPartnerInformationCustomDTO.setSoldToParty(soldToParty);

	}

	/** 
	 * populateFetchPartnerInformationCustomDTO
	 * Populates the Customer's Custom DTO with the Partner Details of the customer
	 * retrieved from DomainDTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param fetchPartnerInformationCustomDTO
	 * @param proposalBO
	 * @return void
	 */
	public static void populateFetchPartnerInformationCustomDTO(FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO, ProposalContractBO proposalBO) {
       
		ESWCustomerCustomDTO billToParty = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO shipToParty = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO payer = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO soldToParty = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO nineDPartner = new ESWCustomerCustomDTO();

		billToParty.setCustomerName(proposalBO.getRegBillToPartyName());
		billToParty.setAddressSequenceNumber(proposalBO.getRegBillToPartASNo());
		billToParty.setLegacyCustomerNumber(proposalBO.getRegBillToPartyLegNo());
		billToParty.setSAPCustomerNumber(proposalBO.getRegBillToPartyNo());
		OPPTLogger.debug("Selected Billtoparty =" + billToParty.getCustomerName(), "PCMCustomDTOBuilder", "populateFetchPartnerInformationCustomDTO");
		fetchPartnerInformationCustomDTO.setSelectedBillToParty(billToParty);

		shipToParty.setCustomerName(proposalBO.getRegShipToPartyName());
		shipToParty.setAddressSequenceNumber(proposalBO.getRegShipToPartyASNo());
		shipToParty.setLegacyCustomerNumber(proposalBO.getRegShipToPartyLegNo());
		shipToParty.setSAPCustomerNumber(proposalBO.getRegShipToPartyNo());
		OPPTLogger.debug("Selected shipToParty =" + shipToParty.getCustomerName(), "PCMCustomDTOBuilder", "populateFetchPartnerInformationCustomDTO");
		fetchPartnerInformationCustomDTO.setSelectedShipToParty(shipToParty);

		payer.setCustomerName(proposalBO.getRegPayerName());
		payer.setAddressSequenceNumber(proposalBO.getRegPayerASNo());
		payer.setLegacyCustomerNumber(proposalBO.getRegPayerLegNo());
		payer.setSAPCustomerNumber(proposalBO.getRegPayerNo());
		OPPTLogger.debug("Selected payer =" + payer.getCustomerName(), "PCMCustomDTOBuilder", "populateFetchPartnerInformationCustomDTO");
		fetchPartnerInformationCustomDTO.setSelectedPayer(payer);

		soldToParty.setCustomerName(proposalBO.getRegCustomerName());
		soldToParty.setAddressSequenceNumber(proposalBO.getRegCustomerASNo());
		soldToParty.setLegacyCustomerNumber(proposalBO.getRegCustomerLegNo());
		soldToParty.setSAPCustomerNumber(proposalBO.getRegCustomerNo());
		
		OPPTLogger.debug("Selected soldToParty =" + soldToParty.getCustomerName(), "PCMCustomDTOBuilder", "populateFetchPartnerInformationCustomDTO");
		fetchPartnerInformationCustomDTO.setSelectedSoldToParty(soldToParty);
		
		nineDPartner.setCustomerName(proposalBO.getReg9DPartnerName());
		nineDPartner.setSAPCustomerNumber(proposalBO.getReg9DPartnerNo());
		OPPTLogger.debug("Selected nineDPartner =" + nineDPartner.getCustomerName(), "PCMCustomDTOBuilder", "populateFetchPartnerInformationCustomDTO");
		fetchPartnerInformationCustomDTO.setSelectedNineDPartner(nineDPartner);

	}

	/** 
	 * Builds ErrorInfoCustomDTO from BO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customContract
	 * @param contract
	 * @return CloseContractCustomDTO
	 */

	public static ErrorInfoCustomDTO populateErrorHistoryCustomDTOFromBO(ErrorListBO errorListBO) {

		ErrorInfoCustomDTO errorInfoCustomDTO = new ErrorInfoCustomDTO();

		errorInfoCustomDTO.setUserId(errorListBO.getUserId());
		errorInfoCustomDTO.setMessageNumber(errorListBO.getMessageNo());
		errorInfoCustomDTO.setMessageDescription(errorListBO.getMessageDesc());
		errorInfoCustomDTO.setDate(errorListBO.getDate());
		errorInfoCustomDTO.setTime(errorListBO.getTime());
		errorInfoCustomDTO.setMessageDescription(errorListBO.getMessageDesc());
		errorInfoCustomDTO.setId(errorListBO.getMessageId());

		ErrorDetailsCustomDTO errorDetailsCustomDTO = new ErrorDetailsCustomDTO();

		// populate ErrorDetailsCustom DTO from the error details string

		if (null != errorListBO.getMessageDetail()) {
			List errorDetailsList = parseErrorDetailsMsgString(errorListBO.getMessageDetail());
			Iterator errorDetailIterator = null;

			errorDetailIterator = errorDetailsList.iterator();
			while (errorDetailIterator.hasNext()) {
				errorInfoCustomDTO.addErrorDetails((ErrorDetailsCustomDTO) errorDetailIterator.next());
			}
		}
		return errorInfoCustomDTO;
	}

	private static List parseErrorDetailsMsgString(String errorDetailsMsgString) {
		List errorDetailCustomDTOList = new ArrayList();
		final String token = "|";

		StringParser errorDetailStringTokenizer = new StringParser(errorDetailsMsgString, token);

		while (errorDetailStringTokenizer.hasMoreTokens()) {
			ErrorDetailsCustomDTO errorDetailsCustomDTO = new ErrorDetailsCustomDTO();
			errorDetailsCustomDTO.setExceptionCode(errorDetailStringTokenizer.nextToken());
			errorDetailsCustomDTO.setSalesDocNumber(errorDetailStringTokenizer.nextToken());
			errorDetailsCustomDTO.setItemPositionNumber(errorDetailStringTokenizer.nextToken());
			errorDetailsCustomDTO.setInternalContractNumber(errorDetailStringTokenizer.nextToken());
			errorDetailsCustomDTO.setMessage(errorDetailStringTokenizer.nextToken());

			errorDetailCustomDTOList.add(errorDetailsCustomDTO);
		}

		return errorDetailCustomDTOList;
	}


	/** 
	 * populatePartnerInformationCustomDTO
	 * Populates the Customer's Custom DTO with the Partner Details of the customer
	 * retrieved from DomainDTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param partnerInformationCustomDTO
	 * @param proposalBO
	 * @return void
	 */
	public static void populatePartnerInformationCustomDTO(PartnerInformationCustomDTO partnerInformationCustomDTO, ProposalContractBO proposalBO) {

		ESWCustomerCustomDTO billToParty = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO shipToParty = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO payer = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO soldToParty = new ESWCustomerCustomDTO();
		ESWCustomerCustomDTO nineDPartner = new ESWCustomerCustomDTO();

		billToParty.setCustomerName(proposalBO.getRegBillToPartyName());
		billToParty.setAddressSequenceNumber(proposalBO.getRegBillToPartASNo());
		billToParty.setLegacyCustomerNumber(proposalBO.getRegBillToPartyLegNo());
		billToParty.setSAPCustomerNumber(proposalBO.getRegBillToPartyNo());
		partnerInformationCustomDTO.setBillToParty(billToParty);

		shipToParty.setCustomerName(proposalBO.getRegShipToPartyName());
		shipToParty.setAddressSequenceNumber(proposalBO.getRegShipToPartyASNo());
		shipToParty.setLegacyCustomerNumber(proposalBO.getRegShipToPartyLegNo());
		shipToParty.setSAPCustomerNumber(proposalBO.getRegShipToPartyNo());
		partnerInformationCustomDTO.setShipToParty(shipToParty);

		payer.setCustomerName(proposalBO.getRegPayerName());
		payer.setAddressSequenceNumber(proposalBO.getRegPayerASNo());
		payer.setLegacyCustomerNumber(proposalBO.getRegPayerLegNo());
		payer.setSAPCustomerNumber(proposalBO.getRegPayerNo());
		partnerInformationCustomDTO.setPayer(payer);

		soldToParty.setCustomerName(proposalBO.getRegCustomerName());
		soldToParty.setAddressSequenceNumber(proposalBO.getRegCustomerASNo());
		soldToParty.setLegacyCustomerNumber(proposalBO.getRegCustomerLegNo());
		soldToParty.setSAPCustomerNumber(proposalBO.getRegCustomerNo());
		partnerInformationCustomDTO.setSoldToParty(soldToParty);

		nineDPartner.setCustomerName(proposalBO.getReg9DPartnerName());
		nineDPartner.setSAPCustomerNumber(proposalBO.getReg9DPartnerNo());
		partnerInformationCustomDTO.setNineDPartner(nineDPartner);

	}

	/** 
	 * populatePartnerInformationCustomDTO
	 * Populates the Customer's Custom DTO with the Partner Details of the customer
	 * retrieved from DomainDTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param partnerInformationCustomDTO
	 * @param proposalBO
	 * @return void
	 */
	public static void populateProposalHeaderCustomDTO(ProposalHeaderCustomDTO proposalHeaderCustomDTO, ProposalContractBO proposalBO) {

		BasicProposalCustomDTO basicProposalCustomDTO = new BasicProposalCustomDTO();
		PricingInformationCustomDTO pricingInformationCustomDTO = new PricingInformationCustomDTO();
		SecondaryProposalCustomDTO secondaryProposalCustomDTO = new SecondaryProposalCustomDTO();
		VarianceInformationCustomDTO varianceInformationCustomDTO = new VarianceInformationCustomDTO();

		proposalHeaderCustomDTO.setAmendmentEffectiveDate(proposalBO.getAmendEffectiveDate());
		proposalHeaderCustomDTO.setContractClosureDate(proposalBO.getContrClsDate());

		basicProposalCustomDTO.setSalesOrganization(proposalBO.getSalesOrg());
		basicProposalCustomDTO.setDistributionChannel(proposalBO.getDistrChannel());
		basicProposalCustomDTO.setSalesGroup(proposalBO.getSalesGroup());
		basicProposalCustomDTO.setChannelRole(proposalBO.getChannelRole());
		basicProposalCustomDTO.setSubmitterRole(proposalBO.getSubmitterRole());
		basicProposalCustomDTO.setDivision(proposalBO.getDivisionCode());
		basicProposalCustomDTO.setCurrencyCode(proposalBO.getCurrency());
		basicProposalCustomDTO.setProposalName(proposalBO.getProposalName());
		basicProposalCustomDTO.setProposalType(proposalBO.getProposalType());
		basicProposalCustomDTO.setReportName(proposalBO.getReportName());
		basicProposalCustomDTO.setExternalContractNumber(proposalBO.getExtContrNo());
		basicProposalCustomDTO.setContractStartDate(proposalBO.getContrStartDate());
		basicProposalCustomDTO.setContractEndDate(proposalBO.getContrEndDate());
		basicProposalCustomDTO.setContractPeriodBeginning(proposalBO.getContrStartPeriod());
		basicProposalCustomDTO.setContractPeriodEnding(proposalBO.getContrEndPeriod());
		basicProposalCustomDTO.setProposalContent(proposalBO.getProposalContent());
		// BH Wave 1 - DAD003 - Manoj - Begin
		basicProposalCustomDTO.setCpsID(proposalBO.getCpsId());
		basicProposalCustomDTO.setOcpsID(proposalBO.getOcpsId());
		basicProposalCustomDTO.setContractType(proposalBO.getContractType());
		basicProposalCustomDTO.setBlbIndicator(proposalBO.getBlbIndicator());
		basicProposalCustomDTO.setIsPreBillIndicator(proposalBO.getPrebillIndicator());
		basicProposalCustomDTO.setCciInd(proposalBO.getCciInd());
		//pricingInformationCustomDTO.setPrebillIndicator(UtilityConstants.YES.equals(proposalBO.getPrebillIndicator()));
		pricingInformationCustomDTO.setPrebillIndicator(proposalBO.getPrebillIndicator());
		// BH Wave 1 - DAD003 - Manoj - End

		pricingInformationCustomDTO.setPlannedGrowthValue(proposalBO.getSpecialRate());
		pricingInformationCustomDTO.setGrowthLimitValue(proposalBO.getGrowthFactor());
		pricingInformationCustomDTO.setBillingFrequency(proposalBO.getBillingFreqCode());
		pricingInformationCustomDTO.setTvmRate(proposalBO.getTvmRate());
		pricingInformationCustomDTO.setPakid(proposalBO.getPakId());
		System.out.println("PCMCustomDTOBuilder.populateProposalHeaderCustomDTO():DISCOUNT"+proposalBO.getDiscount());
		pricingInformationCustomDTO.setDiscount(proposalBO.getDiscount());
		pricingInformationCustomDTO.setAnniversaryContractAmount(proposalBO.getAnnvAmount());
		pricingInformationCustomDTO.setBillingBlock(proposalBO.getBillingBlock());
		pricingInformationCustomDTO.setDeviatingDateRule(proposalBO.getDeviatingDateRule());
		pricingInformationCustomDTO.setBillingDateRule(proposalBO.getBillingType());
		pricingInformationCustomDTO.setFreeTextForInvoicePrint(proposalBO.getFreeText());
		pricingInformationCustomDTO.setSAndSAnniversaryContractAmount(proposalBO.getSAndsAnniversaryAmount());
        /*CR6153 start changes  */
		if(UtilityConstants.S_S_EXTEND_PERIOD.equals(proposalBO.getExtendPeriod())){
			pricingInformationCustomDTO.setExtendPeriod(true);
		}else{
			pricingInformationCustomDTO.setExtendPeriod(false);
		}				
		pricingInformationCustomDTO.setSAndSAnniversaryContractAmountPeriod2(proposalBO.getSAndsAnniversaryAmt2());
		pricingInformationCustomDTO.setSAndSAnniversaryContractAmountPeriod3(proposalBO.getSAndsAnniversaryAmt3());
		pricingInformationCustomDTO.setSAndSAnniversaryContractAmountPeriod4(proposalBO.getSAndsAnniversaryAmt4());
		pricingInformationCustomDTO.setSAndSAnniversaryContractAmountPeriod5(proposalBO.getSAndsAnniversaryAmt5());
		/*CR6153 end changes */
		OPPTLogger.debug("S And S Anniversary Amount to UI " + pricingInformationCustomDTO.getSAndSAnniversaryContractAmount(), "PCMCustomDTOBuilder", "populateProposalHeaderCustomDTO");

		if (UtilityConstants.ADVANCED_BILLING_SELECTED.equals(proposalBO.getAdvanceBilling())) {
			pricingInformationCustomDTO.setAdvance(false);
		} else {
			pricingInformationCustomDTO.setAdvance(true);
		}

		if (UtilityConstants.DETAILED_INVOICE_SELECTED.equals(proposalBO.getInvoiceInd())) {
			pricingInformationCustomDTO.setDetailedInvoice(true);
		} else {
			pricingInformationCustomDTO.setDetailedInvoice(false);
		}

		if (UtilityConstants.GSA_SELECTED.equals(proposalBO.getGsaInd())) {
			pricingInformationCustomDTO.setGsa(true);
		} else {
			pricingInformationCustomDTO.setGsa(false);
		}

		if (proposalBO.isVarianceProposal()) {
			if (UtilityConstants.INVOICE_SUPPRESSION_SELECTED_35.equals(proposalBO.getSupressInvoice())
				|| UtilityConstants.INVOICE_SUPPRESSION_SELECTED_NOT_35.equals(proposalBO.getSupressInvoice())) {
				pricingInformationCustomDTO.setInvoiceSuppression(true);
			} else {
				pricingInformationCustomDTO.setInvoiceSuppression(false);
			}
			pricingInformationCustomDTO.setVarianceDate(proposalBO.getVarDate());
			pricingInformationCustomDTO.setExceedingAmount(proposalBO.getCapVariance());
		}

		secondaryProposalCustomDTO.setPurchaseOrderDate(proposalBO.getPoDate());
		secondaryProposalCustomDTO.setPurchaseOrderNumber(proposalBO.getPoNo());
		secondaryProposalCustomDTO.setPaymentTerms(proposalBO.getPayementTerm());
		secondaryProposalCustomDTO.setComments(proposalBO.getComments());
		secondaryProposalCustomDTO.setFixedValDate(proposalBO.getFixedValueDate());
		secondaryProposalCustomDTO.setAddValueDays(proposalBO.getAddValueDays());
		if (UtilityConstants.YES.equals(proposalBO.getSandSExcluded())) {
			secondaryProposalCustomDTO.setSandsExcluded(true);
		} else {
			secondaryProposalCustomDTO.setSandsExcluded(false);
		}
		secondaryProposalCustomDTO.setIgfOfferNumber(proposalBO.getIGFNumber());

		varianceInformationCustomDTO.setCapPlus(proposalBO.getCapPlus());
		varianceInformationCustomDTO.setCapMinus(proposalBO.getCapMinus());
		varianceInformationCustomDTO.setCapAmount(proposalBO.getCapAmount());

		proposalHeaderCustomDTO.setBasicProposalCustomDTO(basicProposalCustomDTO);
		proposalHeaderCustomDTO.setPricingInformationCustomDTO(pricingInformationCustomDTO);
		proposalHeaderCustomDTO.setSecondaryProposalCustomDTO(secondaryProposalCustomDTO);
		proposalHeaderCustomDTO.setVarianceInformationCustomDTO(varianceInformationCustomDTO);
		proposalHeaderCustomDTO.setContractNumber(proposalBO.getContrNo());
		proposalHeaderCustomDTO.setContractType(proposalBO.getContrType());
		proposalHeaderCustomDTO.setProposalApprover(proposalBO.getApprovedBy());

		PartnerInformationCustomDTO partnerInfo = new PartnerInformationCustomDTO();
		populatePartnerInformationCustomDTO(partnerInfo, proposalBO);
		proposalHeaderCustomDTO.setPartnerInformationCustomDTO(partnerInfo);

	}

	/**
	 * This method is used to build custom dto map.
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalContractBOList
	 * @param type
	 * @return
	 * @throws ServiceException
	 */
	public static TreeMap buildCustomDTOMap(List proposalContractBOList, String type) throws ServiceException {
		String methodName = "buildCustomDTOMap";

		ProposalDataManagerLocalHome proposalDataManagerLocalHome = (ProposalDataManagerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("ProposalDataManagerLocalHome");
		ProposalDataManagerLocal proposalDataManagerLocal = null;

		try {
			proposalDataManagerLocal = proposalDataManagerLocalHome.create();
		} catch (CreateException e3) {
			// TODO Auto-generated catch block
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e3);
		}

		TreeMap proposalsContractMap = new TreeMap();

		for (int i = 0, size = proposalContractBOList.size(); i < size; i++) {

			ProposalContractBO proposalContractBO = (ProposalContractBO) proposalContractBOList.get(i);
			if (PROPOSALS_LIST_FOR_USER.equals(type)) {

				if (proposalContractBO.isProposal()) {
					ProposalCustomDTO proposalCustomDTO = new ProposalCustomDTO();
					proposalCustomDTO.setId(proposalContractBO.getProposalId());
					proposalCustomDTO.setName(proposalContractBO.getProposalName().trim());
					proposalCustomDTO.setType(proposalContractBO.getProposalType());
					proposalCustomDTO.setContent(proposalContractBO.getProposalContent()); //Added by Ramesh for the DAD003
					proposalCustomDTO.setStatus(proposalContractBO.getStatusCode());
					
					
					proposalCustomDTO.setContractPeriodStartDate(proposalContractBO.getContrStartPeriod());//OPPT BH 1.0-DAD001-Srinivas
					proposalCustomDTO.setContractPeriodEndDate(proposalContractBO.getContrEndPeriod());//OPPT BH 1.0-DAD001-Srinivas
					
					if (proposalContractBO.getOldContrNo() != null) {
						proposalCustomDTO.setOldContractNumber(proposalContractBO.getOldContrNo().trim());
					}
					if (proposalContractBO.getLockedBy() != null) {
						proposalCustomDTO.setLockedBy(proposalContractBO.getLockedBy().trim());
					}
					if (proposalContractBO.getProposalSharing() != null) {
						if (UtilityConstants.SHARED_FULL_MODE.equals(proposalContractBO.getProposalSharing().trim())) {
							proposalCustomDTO.setAccess(UtilityConstants.SHARED_FULL_MODE); // defect BHALM00073391 (interchanged with read mode)
						} else {
							proposalCustomDTO.setAccess(UtilityConstants.SHARED_READ_MODE); // defect BHALM00073391 (interchanged with full mode )
						}
					}

					proposalsContractMap.put(new Integer(proposalCustomDTO.getId()), proposalCustomDTO);
				}
			} else if (PROPOSAL_CONTRACT_LIST_FOR_APPROVER.equals(type)) {

				ProposalForApprovalCustomDTO proposalForApprovalCustomDTO = new ProposalForApprovalCustomDTO();
				proposalForApprovalCustomDTO.setId(proposalContractBO.getProposalId());

				proposalForApprovalCustomDTO.setName(proposalContractBO.getProposalName());
				proposalForApprovalCustomDTO.setCreatedBy(proposalContractBO.getCreatedBy());

				proposalForApprovalCustomDTO.setType(proposalContractBO.getProposalType());
				proposalForApprovalCustomDTO.setStatus(proposalContractBO.getStatusCode());

				if (proposalContractBO.getOldContrNo() != null) {
					proposalForApprovalCustomDTO.setOldContractNumber(proposalContractBO.getOldContrNo().trim());
				}
				if (proposalContractBO.getLockedBy() != null) {
					proposalForApprovalCustomDTO.setLockedBy(proposalContractBO.getLockedBy().trim());
				}
				if (proposalContractBO.getProposalSharing() != null) {
					proposalForApprovalCustomDTO.setAccess(proposalContractBO.getProposalSharing().trim());
				}
				proposalsContractMap.put(new Integer(proposalForApprovalCustomDTO.getId()), proposalForApprovalCustomDTO);

			} else if (CONTRACT_LIST_FOR_USER.equals(type)) {
				if (!proposalContractBO.isProposal()) {
					if (ProposalContractStatusConstants.AMEND_PROPOSAL_TO_REVERT.equals(proposalContractBO.getStatusCode())) {
						continue;
					}
					ContractCustomDTO contractCustomDTO = new ContractCustomDTO();
					//					The following snipplet will be 
					//					if(ProposalContractStatusConstants.AMEND_PROPOSAL_TO_REVERT.equals(proposalContractBO.getStatusCode())) {
					//						
					//						ProposalContractBOFactory factory = new ProposalContractBOFactory();
					//						// This shold be changed Will be changed
					//						try{
					//							ProposalContractBO origBO = factory.getProposalContractBO(proposalContractBO.getProposalName()+ProposalContractStatusConstants.AMEND_PROPOSAL_TO_REVERT);
					//							if(null != origBO) {
					//								contractCustomDTO.setId(origBO.getProposalId());
					//							}
					//						}catch(DomainException de) {
					//							throw ExceptionGenerator.generateServiceException(de.getErrorReport());
					//						}
					//						
					//					}else {
					//						contractCustomDTO.setId(proposalContractBO.getProposalId());
					//					}
					
						
					contractCustomDTO.setId(proposalContractBO.getProposalId());
					contractCustomDTO.setName(proposalContractBO.getProposalName().trim());
					contractCustomDTO.setVarianceCount(proposalContractBO.getContrPeriodVarNo());
					contractCustomDTO.setType(proposalContractBO.getProposalType());
					contractCustomDTO.setContent(proposalContractBO.getProposalContent()); //Added by Ramesh for the DAD003
					contractCustomDTO.setStatus(proposalContractBO.getStatusCode());
					
					contractCustomDTO.setContractPeriodStartDate(proposalContractBO.getContrStartPeriod());//OPPT BH 1.0-DAD001-Srinivas
					contractCustomDTO.setContractPeriodEndDate(proposalContractBO.getContrEndPeriod());//OPPT BH 1.0-DAD001-Srinivas
                    
					/* start change CR6153 */
                    contractCustomDTO.setExtendPeriod(proposalContractBO.getExtendPeriod());
					/* end change CR6153 */
					if (proposalContractBO.getOldContrNo() != null) {
						contractCustomDTO.setOldContractNumber(proposalContractBO.getOldContrNo());
					}
					if (proposalContractBO.getLockedBy() != null) {
						contractCustomDTO.setLockedBy(proposalContractBO.getLockedBy());
					}
					if (proposalContractBO.getProposalSharing() != null) {
						contractCustomDTO.setAccess(proposalContractBO.getProposalSharing());
					}
					contractCustomDTO.setContractNumber(proposalContractBO.getContrNo().trim());
					OPPTCalender calender = new OPPTCalender();
					java.util.Date  date =new Date();
                     //OOPT BH 1.0 -DAD001-Srinivas
					Date sixMonthsEarlier = new Date();
					sixMonthsEarlier = new java.util.Date(sixMonthsEarlier.getYear(),sixMonthsEarlier.getMonth()-6,sixMonthsEarlier.getDay());
					if(!(proposalContractBO.getStatusCode().equalsIgnoreCase("CL") 
							&& null != proposalContractBO.getContrClsDate()
							&& proposalContractBO.getContrClsDate().before(sixMonthsEarlier)))	{
						proposalsContractMap.put(String.valueOf(contractCustomDTO.getId()), contractCustomDTO);
					} else if (!(proposalContractBO.getStatusCode().equalsIgnoreCase("CL") 
							&& null != proposalContractBO.getContrClsDate())){
						// Added By Bhanu- Here the replaced contract parent contract get displayed in normal Contract maintainence page
						proposalsContractMap.put(String.valueOf(contractCustomDTO.getId()), contractCustomDTO);
					}
				}
					
				}
			//DAD-001 BlueHarmony Changed by Anand Sugumaran
			else if (ARCHIVE_LIST_FOR_USER.equals(type)) {
				if (!proposalContractBO.isProposal()) {
					if (ProposalContractStatusConstants.AMEND_PROPOSAL_TO_REVERT.equals(proposalContractBO.getStatusCode())) {
						continue;
					}
					ContractCustomDTO contractCustomDTO = new ContractCustomDTO();
					contractCustomDTO.setId(proposalContractBO.getProposalId());
					contractCustomDTO.setName(proposalContractBO.getProposalName().trim());
					contractCustomDTO.setVarianceCount(proposalContractBO.getContrPeriodVarNo());
					contractCustomDTO.setType(proposalContractBO.getProposalType());
					contractCustomDTO.setContent(proposalContractBO.getProposalContent()); //Added by Ramesh for the DAD003
					contractCustomDTO.setStatus(proposalContractBO.getStatusCode());
					contractCustomDTO.setContractPeriodStartDate(proposalContractBO.getContrStartPeriod());//OPPT BH 1.0-DAD001-Srinivas
                    contractCustomDTO.setContractPeriodEndDate(proposalContractBO.getContrEndPeriod());//OPPT BH 1.0-DAD001-Srinivas
					
					/* start change CR6153 */
					contractCustomDTO.setExtendPeriod(proposalContractBO.getExtendPeriod());
					/* end change CR6153 */
					if (proposalContractBO.getOldContrNo() != null) {
						contractCustomDTO.setOldContractNumber(proposalContractBO.getOldContrNo());
					}
					if (proposalContractBO.getLockedBy() != null) {
						contractCustomDTO.setLockedBy(proposalContractBO.getLockedBy());
					}
					if (proposalContractBO.getProposalSharing() != null) {
						contractCustomDTO.setAccess(proposalContractBO.getProposalSharing());
					}
					contractCustomDTO.setContractNumber(proposalContractBO.getContrNo().trim());
					
					OPPTCalender calender = new OPPTCalender();
					java.util.Date  date =new Date();
                 	Date sixMonthsEarlier = new Date();
					sixMonthsEarlier = new java.util.Date(sixMonthsEarlier.getYear(),sixMonthsEarlier.getMonth()-6,sixMonthsEarlier.getDay());					 
					if(proposalContractBO.getStatusCode().equalsIgnoreCase("CL")
							&& null != proposalContractBO.getContrClsDate()
							&& proposalContractBO.getContrClsDate().before(sixMonthsEarlier))	
						proposalsContractMap.put(String.valueOf(contractCustomDTO.getId()), contractCustomDTO);
			    	}					
				}
		}	
		return proposalsContractMap;
	}

	/** 
	 * updateProposalsContractMap
	 * Populates the Customer's Custom DTO with the Partner Details of the customer
	 * retrieved from DomainDTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalsContractMap
	 * @param proposalContractBO
	 * @return void
	 */
	public static void updateProposalsContractMap(TreeMap proposalsContractMap, ProposalContractBO proposalContractBO) throws ServiceException {

		String methodName = "updateProposalsContractMap";
		ProposalDataManagerLocalHome proposalDataManagerLocalHome = (ProposalDataManagerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("ProposalDataManagerLocalHome");
		ProposalDataManagerLocal proposalDataManagerLocal = null;
		if (proposalContractBO == null) {
			return;
		}
		try {
			proposalDataManagerLocal = proposalDataManagerLocalHome.create();
		} catch (CreateException e3) {
			// TODO Auto-generated catch block
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e3);
		}

		if (proposalContractBO.isProposal()) {
			ProposalCustomDTO proposalCustomDTO = new ProposalCustomDTO();
			proposalCustomDTO.setId(proposalContractBO.getProposalId());
			proposalCustomDTO.setName(proposalContractBO.getProposalName().trim());

			proposalCustomDTO.setType(proposalContractBO.getProposalType());
			proposalCustomDTO.setStatus(proposalContractBO.getStatusCode());
	proposalCustomDTO.setContractPeriodStartDate(proposalContractBO.getContrStartPeriod());
			proposalCustomDTO.setContractPeriodEndDate(proposalContractBO.getContrEndPeriod());

			if (proposalContractBO.getOldContrNo() != null) {
				proposalCustomDTO.setOldContractNumber(proposalContractBO.getOldContrNo().trim());
			}
			if (proposalContractBO.getLockedBy() != null) {
				proposalCustomDTO.setLockedBy(proposalContractBO.getLockedBy().trim());
			}
			if (proposalContractBO.getProposalSharing() != null) {
				proposalCustomDTO.setAccess(proposalContractBO.getProposalSharing().trim());
			}
			proposalCustomDTO.setFullAccess(true);
			proposalsContractMap.put(new Integer(proposalCustomDTO.getId()), proposalCustomDTO);
		}
	}

	/** 
	 * buildGroupUserCustomDTOMap
	 * Populates the Customer's Custom DTO with the Partner Details of the customer
	 * retrieved from DomainDTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param users
	 * @param role
	 * @return TreeMap
	 */
	public static TreeMap buildGroupUserCustomDTOMap(List users, int role) {
		TreeMap usersMap = new TreeMap();
		for (int i = 0, size = users.size(); i < size; i++) {
			UserProfileBO userProfileBO = (UserProfileBO) users.get(i);
			// similar responsibility
			boolean add = false;
			if (role == userProfileBO.getRole()) {
				add = true;
			}

			if (RoleConstants.CREATE_APPROVE == userProfileBO.getRole() || RoleConstants.CSO == userProfileBO.getRole() || RoleConstants.MARKETING_REP == userProfileBO.getRole()) {

				if (RoleConstants.CREATE_APPROVE == role || RoleConstants.CSO == role || RoleConstants.MARKETING_REP == role) {
					add = true;
				}
			}

			if (add) {
				usersMap.put(userProfileBO.getUserId().trim(), userProfileBO.getUserId().trim());
			}
		}

		return usersMap;
	}

	/** 
	 * populateProposalContractForPricing
	 * Populates the Customer's Custom DTO with the Partner Details of the customer
	 * retrieved from DomainDTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceProposalDomainDTO
	 * @param proposalContractBO
	 * @return void
	 */
	public static void populateProposalContractForPricing(ProposalContractBO proposalContractBO, PriceProposalDomainDTO priceProposalDomainDTO) {
		if (proposalContractBO.isVarianceProposal()) {
			// Variance    	
			proposalContractBO.setStatusCode(priceProposalDomainDTO.getStatusCode());
			proposalContractBO.setDatePriced(priceProposalDomainDTO.getDatePriced());
			proposalContractBO.setInvoiceAmount(priceProposalDomainDTO.getInvoiceAmt());

		} else if (UtilityConstants.MLC_ONLY.equals(proposalContractBO.getProposalContent())) {
			proposalContractBO.setStatusCode(priceProposalDomainDTO.getStatusCode());
			proposalContractBO.setDatePriced(priceProposalDomainDTO.getDatePriced());
			proposalContractBO.setInvoiceAmount(priceProposalDomainDTO.getInvoiceAmt());
			proposalContractBO.setAnnvInvoiceAmount(priceProposalDomainDTO.getAnnualInvoiceAmt());
			proposalContractBO.setQuarterInvoiceAmount(priceProposalDomainDTO.getQurtInvoiceAmt());
			proposalContractBO.setMonthlyInvoiceAmount(priceProposalDomainDTO.getMonthlyInvoiceAmt());
			proposalContractBO.setSemiAnnInvoiceAmount(priceProposalDomainDTO.getSemiAnnualInvoiceAmt());
			proposalContractBO.setPreTVMInvoiceAmount(priceProposalDomainDTO.getPreTVMInvoiceAmt());
		} else if (UtilityConstants.SANDS_ONLY.equals(proposalContractBO.getProposalContent())) {
			proposalContractBO.setStatusCode(priceProposalDomainDTO.getStatusCode());
			proposalContractBO.setDatePriced(priceProposalDomainDTO.getDatePriced());
			proposalContractBO.setSAndsDiscount(priceProposalDomainDTO.getSAndsDiscount());
			proposalContractBO.setPreTVMInvoiceAmount(priceProposalDomainDTO.getPreTVMInvoiceAmt());
		} else if (UtilityConstants.MLC_AND_SANDS.equals(proposalContractBO.getProposalContent())) {
			proposalContractBO.setStatusCode(priceProposalDomainDTO.getStatusCode());
			proposalContractBO.setDatePriced(priceProposalDomainDTO.getDatePriced());
			proposalContractBO.setInvoiceAmount(priceProposalDomainDTO.getInvoiceAmt());
			proposalContractBO.setAnnvInvoiceAmount(priceProposalDomainDTO.getAnnualInvoiceAmt());
			proposalContractBO.setQuarterInvoiceAmount(priceProposalDomainDTO.getQurtInvoiceAmt());
			proposalContractBO.setMonthlyInvoiceAmount(priceProposalDomainDTO.getMonthlyInvoiceAmt());
			proposalContractBO.setSemiAnnInvoiceAmount(priceProposalDomainDTO.getSemiAnnualInvoiceAmt());
			proposalContractBO.setSAndsDiscount(priceProposalDomainDTO.getSAndsDiscount());
			//<!-- BlueHarmony DAD006  changed by Anand Sugumaran  --> 
			proposalContractBO.setSAndsAnniversaryAmount(priceProposalDomainDTO.getSAndsDiscount());
			//<!-- BlueHarmony DAD006  changes End by Anand Sugumaran  --> 
			proposalContractBO.setPreTVMInvoiceAmount(priceProposalDomainDTO.getPreTVMInvoiceAmt());

		}
		
		/* CR6153 start change */
		if((proposalContractBO.getExtendPeriod() != null) && (proposalContractBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
			proposalContractBO.setSAndSDiscountAmount1(priceProposalDomainDTO.getSAndSDiscountAmount1());
			proposalContractBO.setSAndSDiscountAmount2(priceProposalDomainDTO.getSAndSDiscountAmount2());
			proposalContractBO.setSAndSDiscountAmount3(priceProposalDomainDTO.getSAndSDiscountAmount3());
			proposalContractBO.setSAndSDiscountAmount4(priceProposalDomainDTO.getSAndSDiscountAmount4());
			proposalContractBO.setSAndSDiscountAmount5(priceProposalDomainDTO.getSAndSDiscountAmount5());
		}
		/* CR6153 end change */
	}

	/** 
	 * Populates SAndSEECustomDTO from SWODomainDTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @return SAndSEECustomDTO
	 * @author Saravanan Viswanathan
	 */
	public static SAndSDetailsCustomDTO populateSAndSEECustomDTOFromSWODomainDTO(List swoDomainDTOList, SAndSDetailsCustomDTO sAndSDetailsCustomDTO) {
		TreeMap sAndSEEMap = new TreeMap();
		List eeDomainDTOList = null;
		SWODomainDTO[] swoDomainDTOArray = new SWODomainDTO[0];
		sAndSDetailsCustomDTO = new SAndSDetailsCustomDTO();
		swoDomainDTOArray = (SWODomainDTO[]) swoDomainDTOList.toArray(swoDomainDTOArray);

		int swosize = swoDomainDTOArray.length;

		for (int i = 0; i < swosize; i++) {
			eeDomainDTOList = swoDomainDTOArray[i].getEEDTOList();
			EEDomainDTO[] eeDomainDTO = new EEDomainDTO[0];
			eeDomainDTO = (EEDomainDTO[]) eeDomainDTOList.toArray(eeDomainDTO);
			String swoNo = swoDomainDTOArray[i].getSwoNo();
			String swoSerialNo = swoDomainDTOArray[i].getSerialNo();

			int eesize = eeDomainDTO.length;

			for (int x = 0; x < eesize; x++) {
				SAndSEECustomDTO sAndSEECustomDTO = new SAndSEECustomDTO();
				sAndSEECustomDTO.setSoldToPartyId(eeDomainDTO[x].getCustomerId());
				sAndSEECustomDTO.setDMId(eeDomainDTO[x].getDmId());
				sAndSEECustomDTO.setSWOId(eeDomainDTO[x].getSwoId());
				sAndSEECustomDTO.setId(eeDomainDTO[x].getEeId());
				sAndSEECustomDTO.setESWPrice(eeDomainDTO[x].getEswPrice());
				sAndSEECustomDTO.setAlternatePrice(eeDomainDTO[x].getAlternatePrice());
				sAndSEECustomDTO.setSAndSDiscountPercent(eeDomainDTO[x].getSAndSDiscountPercent());
				sAndSEECustomDTO.setCalculatedPrice(eeDomainDTO[x].getCalculatedPrice());
				String eeNo = eeDomainDTO[x].getEeNo();
				sAndSEECustomDTO.setDescription(swoNo.concat(" - ").concat(swoSerialNo).concat(" - ").concat(eeNo));
				sAndSEEMap.put(new Integer(sAndSEECustomDTO.getId()), sAndSEECustomDTO);
				if (i == 0 && x == 0) {
					sAndSDetailsCustomDTO.setSelected(sAndSEECustomDTO);
				}
			}
		}
		sAndSDetailsCustomDTO.setSAndSEEMap(sAndSEEMap);
		return sAndSDetailsCustomDTO;
	}

}