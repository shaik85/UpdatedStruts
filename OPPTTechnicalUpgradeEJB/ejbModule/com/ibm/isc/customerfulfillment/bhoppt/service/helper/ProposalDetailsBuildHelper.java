/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.helper;

import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.CustomerListBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.PCMCustomDTOBuilder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.LicenseConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 23, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class ProposalDetailsBuildHelper
{
	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ProposalDetailsBuildHelper()
	{
	}

	/**
	 * To build the partner information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalBO
	 * @param proposalDomainDTO
	 * @param proposalDetailsCustomDTO
	 * @param customerList
	 */
	public void buildPartnerInformation(
		ProposalContractBO proposalContractBO,
		ProposalDomainDTO proposalDomainDTO,
		ProposalDetailsCustomDTO proposalDetailsCustomDTO,
		List customerList)
	{
		proposalDetailsCustomDTO.setPartnerInformation(getPartnerInformation(proposalContractBO, customerList));
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	private PartnerInformationCustomDTO getPartnerInformation(
		ProposalContractBO proposalContractBO,
		List customerList)
	{
		PartnerInformationCustomDTO partnerInformationDTO = new PartnerInformationCustomDTO();
		partnerInformationDTO.setComments(proposalContractBO.getComments());

		FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO = new FetchPartnerInformationCustomDTO();
		PCMCustomDTOBuilder.populateFetchPartnerInformationCustomDTO(
			fetchPartnerInformationCustomDTO,
			proposalContractBO);

		partnerInformationDTO.setBillToParty(fetchPartnerInformationCustomDTO.getSelectedBillToParty());
		partnerInformationDTO.setNineDPartner(fetchPartnerInformationCustomDTO.getSelectedNineDPartner());
		partnerInformationDTO.setPayer(fetchPartnerInformationCustomDTO.getSelectedPayer());
		partnerInformationDTO.setShipToParty(fetchPartnerInformationCustomDTO.getSelectedShipToParty());
		partnerInformationDTO.setSoldToParty(fetchPartnerInformationCustomDTO.getSelectedSoldToParty());

		if (customerList != null)
		{
			Iterator iter = customerList.iterator();

			CustomerListCustomDTO customDTO;
			CustomerListBO customerListBO;

			while (iter.hasNext())
			{
				customerListBO = (CustomerListBO) iter.next();

				CustomerListCustomDTO dto = new CustomerListCustomDTO();
				dto.setListName(customerListBO.getCustomerListDesc());
				dto.setListNumber(customerListBO.getCustomerListNo());

				partnerInformationDTO.addCustomerList(dto);
			}
		}

		return partnerInformationDTO;
	}

	/** 
	 * To build the proposal and customer custom dto
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param domainDTO
	 * @param proposalDetailsCustomDTO 
	 */
	public void buildCustomDTO(
		ProposalDomainDTO proposalDomainDTO,
		ProposalDetailsCustomDTO proposalDetailsCustomDTO,
		boolean isSandS,
		boolean isPriced,
		boolean isDraft,
		Date datePriced,
		boolean isDuplicateSerial)
	{
		// Clean up the tree map if any
		proposalDetailsCustomDTO.setCustomers(null);
		
		if(null != proposalDomainDTO.getValues().get(UtilityConstants.PROPOSAL_DETAILS_PAGE_INDEX)) {
			Integer pageIndex =
						(Integer) proposalDomainDTO.getValues().get(UtilityConstants.PROPOSAL_DETAILS_PAGE_INDEX);
			if(pageIndex.intValue() !=0) {
				proposalDetailsCustomDTO.setPageIndex(pageIndex.intValue());
			}			
		}

		Integer totalPages =
			(Integer) proposalDomainDTO.getValues().get(UtilityConstants.PROPOSAL_DETAILS_TOTAL_PAGE);

		if (totalPages != null)
		{
			proposalDetailsCustomDTO.setTotalNoOfPages(totalPages.intValue());
			OPPTLogger.debug("totalPages :" + totalPages, "ProposalDetailsBuildHelper", "buildCustomDTO");
		}

		Integer totalMLCPages = (Integer) proposalDomainDTO.getValues().get(UtilityConstants.MLC_TOTAL_PAGE);

		if (totalMLCPages != null)
		{
			proposalDetailsCustomDTO.setMLCTotalNoOfPages(totalMLCPages.intValue());
			OPPTLogger.debug("totalMLCPages :" + totalMLCPages, "ProposalDetailsBuildHelper", "buildCustomDTO");
		}

		Integer mlcExcess = (Integer) proposalDomainDTO.getValues().get(UtilityConstants.MLC_EXCESS);

		if (mlcExcess != null)
		{
			proposalDetailsCustomDTO.setMLCExcess(mlcExcess.intValue());
			OPPTLogger.debug("mlcExcess :" + mlcExcess, "ProposalDetailsBuildHelper", "buildCustomDTO");
		}

		List list = new ArrayList();
		buildCustomerCustomDTO(proposalDomainDTO, list, true, isPriced, isDraft, datePriced,isDuplicateSerial);
		Iterator iter = list.iterator();

		while (iter.hasNext())
		{
			proposalDetailsCustomDTO.addCustomer((ProposalCustomerCustomDTO) iter.next());
		}

		if (isSandS)
		{
			proposalDetailsCustomDTO.setSAndS(true);
			list = new ArrayList();
			buildCustomerCustomDTO(proposalDomainDTO, list, false, isPriced, isDraft, datePriced,isDuplicateSerial);
			iter = list.iterator();

			while (iter.hasNext())
			{
				proposalDetailsCustomDTO.addSAndSCustomer((ProposalCustomerCustomDTO) iter.next());
			}
		}
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 * @param map 
	 */
	private void buildCustomerCustomDTO(
		ProposalDomainDTO proposalDomainDTO,
		List list,
		boolean mlcLicenses,
		boolean isPriced,
		boolean isDraft,
		Date datePriced,
		boolean isDuplicateSerial)
	{

		if (mlcLicenses && proposalDomainDTO.getCustomerDTOList() == null)
		{
			return;
		}

		if ((!mlcLicenses) && proposalDomainDTO.getSAndSCustomerList() == null)
		{
			return;
		}

		Iterator iter = null;
		if (mlcLicenses)
		{
			iter = proposalDomainDTO.getCustomerDTOList().iterator();
		}
		else
		{
			iter = proposalDomainDTO.getSAndSCustomerList().iterator();
		}

		CustomerDomainDTO customerDomainDTO;
		while (iter.hasNext())
		{
			customerDomainDTO = (CustomerDomainDTO) iter.next();

			ProposalCustomerCustomDTO customerCustomDTO = new ProposalCustomerCustomDTO();
            
			customerCustomDTO.setCustomerId(customerDomainDTO.getCustomerId());
			customerCustomDTO.setAddressSequenceNumber(customerDomainDTO.getCustmerASNo());
			customerCustomDTO.setCustomerName(customerDomainDTO.getSapCustomerName());
			customerCustomDTO.setLegacyCustomerNumber(customerDomainDTO.getLegacyCustomerNo());
			customerCustomDTO.setPlanEndDate(customerDomainDTO.getPlanEndDate());
			customerCustomDTO.setPlanStartDate(customerDomainDTO.getPlanStartDate());
			customerCustomDTO.setProposalId(customerDomainDTO.getProposalId());
			customerCustomDTO.setSAPCustomerNumber(customerDomainDTO.getSapCustomerNo());
			customerCustomDTO.setSoldToPartyNo(customerDomainDTO.getSoldToPartyNo());//DADO02
			
			if (mlcLicenses)
			{
				customerCustomDTO.setSAndS(false);
			}
			else
			{
				customerCustomDTO.setSAndS(true);
				/* CR6153 start change */ 
				ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
				ProposalContractBO proposalContractBO = new ProposalContractBO();
				try{
					proposalContractBO = proposalContractBOFactory.getProposalContractBO(proposalDomainDTO.getProposalId());
				}
			    catch (DomainException e1) {
			    	try {
						throw ExceptionGenerator.generateServiceException(e1.getErrorReport());
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if((proposalContractBO.getExtendPeriod() != null) && (proposalContractBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					customerCustomDTO.setPlanStartDate(customerDomainDTO.getPlanStartDate());
					customerCustomDTO.setPlanEndDate(customerDomainDTO.getPlanEndDate());
				}
				else
				{
				/* CR6153 end change */
					customerCustomDTO.setPlanStartDate(proposalDomainDTO.getContrStartPeriod());
					customerCustomDTO.setPlanEndDate(proposalDomainDTO.getContrEndPeriod());
				}
			}

			// Add the customer to the collection			
			list.add(customerCustomDTO);

			buildDMCustomDTO(customerCustomDTO, customerDomainDTO, mlcLicenses, isPriced, isDraft, datePriced,isDuplicateSerial);
		}
	}

	/** 
	 * To build the designated machine custom dto
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dto
	 * @param customerDTO 
	 */
	private void buildDMCustomDTO(
		ProposalCustomerCustomDTO customerCustomDTO,
		CustomerDomainDTO customerDTO,
		boolean mlcInd,
		boolean isPriced,
		boolean isDraft,
		Date datePriced,
		boolean isDuplicateSerial)
	{
		boolean noDMAvailable = false;
		if (customerDTO.getDMDTOList() == null)
		{
			return;
		}

		Iterator iter = customerDTO.getDMDTOList().iterator();

		DMDomainDTO dmDomainDTO;

		while (iter.hasNext())
		{
			dmDomainDTO = (DMDomainDTO) iter.next();
			if (dmDomainDTO.getDmNo() == null || dmDomainDTO.getDmNo().trim().length() == 0)
			{
				noDMAvailable = true;
			}

			DMCustomDTO dmCustomDTO = new DMCustomDTO();
			dmCustomDTO.setCustomerId(Integer.toString(dmDomainDTO.getCustomerId()));
			dmCustomDTO.setDescription(dmDomainDTO.getDmDesc());
			dmCustomDTO.setId(Integer.toString(dmDomainDTO.getDmId()));
			dmCustomDTO.setNumber(dmDomainDTO.getDmNo());
			dmCustomDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
			dmCustomDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
			dmCustomDTO.setProposalId(dmDomainDTO.getProposalId());

			if (mlcInd)
			{
				dmCustomDTO.setSAndS(false);
			}
			else
			{
				dmCustomDTO.setSAndS(true);
				dmCustomDTO.setPlanStartDate(customerCustomDTO.getPlanStartDate());
				dmCustomDTO.setPlanEndDate(customerCustomDTO.getPlanEndDate());
			}

			// Add the DM to the collection
			customerCustomDTO.addDM(dmCustomDTO);

			buildSWOCustomDTO(dmCustomDTO, dmDomainDTO, mlcInd, isPriced, isDraft, datePriced,isDuplicateSerial);
		}

		if (noDMAvailable && customerCustomDTO.getDMs().size() == 1)
		{
			customerCustomDTO.setDMs(new TreeMap());
		}
	}

	/** 
	 * To build the software offering custom dto
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dto
	 * @param dmDTO 
	 */
	private void buildSWOCustomDTO(
		DMCustomDTO dmCustomDTO,
		DMDomainDTO dmDomainDTO,
		boolean mlcInd,
		boolean isPriced,
		boolean isDraft,
		Date datePriced,
		boolean isDuplicateSerial)
	{
		boolean noSWOAvailable = false;
		OPPTCalender cal = new OPPTCalender();
		if (dmDomainDTO.getSWODTOList() == null)
		{
			return;
		}

		Iterator iter = dmDomainDTO.getSWODTOList().iterator();

		SWODomainDTO swoDomainDTO;

		while (iter.hasNext())
		{
			swoDomainDTO = (SWODomainDTO) iter.next();

			if (null == swoDomainDTO.getSwoNo() || 0 == swoDomainDTO.getSwoNo().trim().length())
			{
				noSWOAvailable = true;
			}

			SWOCustomDTO swoCustomDTO = new SWOCustomDTO();
			swoCustomDTO.setAlternatePrice(swoDomainDTO.getAlternatePrice());
			swoCustomDTO.setCustomerId(Integer.toString(swoDomainDTO.getCustomerId()));
			swoCustomDTO.setDescription(swoDomainDTO.getSwoDesc());
			swoCustomDTO.setDMId(Integer.toString(swoDomainDTO.getDmId()));
			swoCustomDTO.setId(Integer.toString(swoDomainDTO.getSwoId()));
			swoCustomDTO.setNumber(swoDomainDTO.getSwoNo());
			swoCustomDTO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
			swoCustomDTO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
			swoCustomDTO.setProposalId(swoDomainDTO.getProposalId());
			swoCustomDTO.setSerialNumber(swoDomainDTO.getSerialNo());
			//System.out.println("ProposalDetailsBuildHelper.buildSWOCustomDTO():swoDomainDTO.getCalcPrice():"+swoDomainDTO.getCalcPrice());
			swoCustomDTO.setCalculatedPrice(swoDomainDTO.getCalcPrice());
			swoCustomDTO.setEswPrice(swoDomainDTO.getEswPrice());
			swoCustomDTO.setSwoContractNumber(swoDomainDTO.getSwoExtContrNo());
			swoCustomDTO.setSwoContractStatus(swoDomainDTO.getSwoContrStatus());
			swoCustomDTO.setSwoContractType(swoDomainDTO.getSwoContrType());
			swoCustomDTO.setSwoReferenceSN(swoDomainDTO.getReferenceSerialNo());
			swoCustomDTO.setSwoReferenceDN(swoDomainDTO.getReferenceSerialNoDM());
			if (mlcInd)
			{
				swoCustomDTO.setSAndS(false);
			}
			else
			{
				swoCustomDTO.setSAndS(true);
//				swoCustomDTO.setPlanStartDate(dmCustomDTO.getPlanStartDate());
//				swoCustomDTO.setPlanEndDate(dmCustomDTO.getPlanEndDate());
			}

			Map map = swoDomainDTO.getValues();

			if (map != null)
			{
				swoCustomDTO.setAmendedLicense(
					((Boolean) map.get(UtilityConstants.SWO_AMENDED_INDEX)).booleanValue());

				swoCustomDTO.setDeltaFetchLicense(
					((Boolean) map.get(UtilityConstants.SWO_DELTA_FETCH_INDEX)).booleanValue());

				swoCustomDTO.setEditedLicense(
					((Boolean) map.get(UtilityConstants.SWO_EDITED_LICENSE)).booleanValue());

				swoCustomDTO.setExcluded(((Boolean) map.get(UtilityConstants.SWO_EXCLUDED)).booleanValue());
				swoCustomDTO.setForConract(((Boolean) map.get(UtilityConstants.SWO_FOR_CONTRACT)).booleanValue());
				swoCustomDTO.setQuote(((Boolean) map.get(UtilityConstants.SWO_QUOTE_FLAG)).booleanValue());

				swoCustomDTO.setRefetchLicense(
					((Boolean) map.get(UtilityConstants.SWO_REFETCH_LICENSE)).booleanValue());

				swoCustomDTO.setSvcLicense(((Boolean) map.get(UtilityConstants.SWO_SVC_LICENSE)).booleanValue());
				//CR2031
				/*
				 * This is for Proposal details display if the action is not for duplicate serial numbers then there is no need to display the swo's in diffrent colors
				 */
				
				if(!isDuplicateSerial) {
					swoCustomDTO.setDuplicateDeleted(((Boolean) map.get(UtilityConstants.DUPLICATE_DELETED_IND)).booleanValue());
				}
				swoCustomDTO.setBumped(((Boolean) map.get(UtilityConstants.BUMP_INDICATOR)).booleanValue());
				swoCustomDTO.setFirstBumped(((Boolean) map.get(UtilityConstants.FIRST_BUMP_INDICATOR)).booleanValue());
				
				swoCustomDTO.setLocked(((Boolean) map.get(UtilityConstants.SWO_LOCKED_INDICATOR)).booleanValue());
				if (null != map.get(UtilityConstants.SWO_ALREADY_BILLED))
				{
					swoCustomDTO.setAlreadyBilled(
						((Boolean) map.get(UtilityConstants.SWO_ALREADY_BILLED)).booleanValue());
				}

				if (swoCustomDTO.isQuote())
				{
					dmCustomDTO.setOnlyQuotes(true);
				}
			}

			if (!isPriced)
			{
				//System.out.println("ProposalDetailsBuildHelper.buildSWOCustomDTO()1");
				swoCustomDTO.setShowAlternatePrice(false);
				swoCustomDTO.setShowCalculatedPrice(false);
				swoCustomDTO.setShowESWPrice(false);
			}
			else
			{
				if (isDraft)
				{   
					//System.out.println("ProposalDetailsBuildHelper.buildSWOCustomDTO()2");
					swoCustomDTO.setShowCalculatedPrice(false);
				}
				if (null != swoDomainDTO.getSwoAddedDate() && null != datePriced)
				{
					if (cal.isDateLesser(datePriced, swoDomainDTO.getSwoAddedDate()))
					{
						//System.out.println("ProposalDetailsBuildHelper.buildSWOCustomDTO()3");
						swoCustomDTO.setShowAlternatePrice(false);
						swoCustomDTO.setShowCalculatedPrice(false);
						swoCustomDTO.setShowESWPrice(false);
					}
				}

			}
			/**
			  * 31/05/2004
			  * MN 19387428- Defect 351
			  * For Alternate Price change added by Balaji
			  */
			
			if(0 == swoDomainDTO.getAlternatePrice() && (!UtilityConstants.YES.equals(swoDomainDTO.getAlternatePriceUpdateInd()))) {
				swoCustomDTO.setShowAlternatePrice(false);
			}
			// Add the SWO to the collection
			dmCustomDTO.addSwo(swoCustomDTO);
		}
		if (noSWOAvailable && dmCustomDTO.getSwos().size() == 1)
		{
			dmCustomDTO.setSwos(new TreeMap());
		}
	}

	/**
	 * To build the print proposal custom dto out of domain dto. 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 * @param printProposalCustomDTO
	 */
	public void buildPrintProposalCustomDTO(
		ProposalDomainDTO proposalDomainDTO,
		PrintProposalCustomDTO printProposalCustomDTO,
		ProposalContractBO proposalContractBO,
		List customerList,
		boolean isSandS,
		boolean isPriced,
		boolean isDraft,
		Date datePriced)
	{
		BasicProposalCustomDTO basicProposal = printProposalCustomDTO.getBasicProposalCustomDTO();

		if (basicProposal == null)
		{
			basicProposal = new BasicProposalCustomDTO();
			printProposalCustomDTO.setBasicProposalCustomDTO(basicProposal);
		}

		PartnerInformationCustomDTO partnerInformation = getPartnerInformation(proposalContractBO, customerList);
		printProposalCustomDTO.setPartnerInformationCustomDTO(partnerInformation);

		PricingInformationCustomDTO pricingInformation = printProposalCustomDTO.getPricingInformationCustomDTO();
		if (pricingInformation == null)
		{
			pricingInformation = new PricingInformationCustomDTO();
			printProposalCustomDTO.setPricingInformationCustomDTO(pricingInformation);
		}

		SecondaryProposalCustomDTO secondaryProposal = printProposalCustomDTO.getSecondaryProposalCustomDTO();
		if (secondaryProposal == null)
		{
			secondaryProposal = new SecondaryProposalCustomDTO();
			printProposalCustomDTO.setSecondaryProposalCustomDTO(secondaryProposal);
		}

		VarianceInformationCustomDTO varianceInformation =
			printProposalCustomDTO.getVarianceInformationCustomDTO();
		if (varianceInformation == null)
		{
			varianceInformation = new VarianceInformationCustomDTO();
			printProposalCustomDTO.setVarianceInformationCustomDTO(varianceInformation);
		}

		printProposalCustomDTO.setContractNumber(proposalContractBO.getContrNo());
		printProposalCustomDTO.setContractType(proposalContractBO.getContrType());
		printProposalCustomDTO.setInvoiceAmount(proposalContractBO.getInvoiceAmount());
		printProposalCustomDTO.setProposalApprover(proposalContractBO.getApprovedBy());
		printProposalCustomDTO.setAmendmentEffectiveDate(proposalContractBO.getAmendEffectiveDate());

		basicProposal.setSalesOrganization(proposalContractBO.getSalesOrg());
		basicProposal.setDistributionChannel(proposalContractBO.getDistrChannel());
		basicProposal.setSalesGroup(proposalContractBO.getSalesGroup());
		basicProposal.setChannelRole(proposalContractBO.getChannelRole());
		basicProposal.setSubmitterRole(proposalContractBO.getSubmitterRole());
		basicProposal.setDivision(proposalContractBO.getDivisionCode());
		basicProposal.setCurrencyCode(proposalContractBO.getCurrency());
		/* BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - Begin */
		basicProposal.setCpsID(proposalContractBO.getCpsId());
		basicProposal.setOcpsID(proposalContractBO.getOcpsId());
		//basicProposal.setComplexContractAmendment(proposalContractBO.getComplexContractAmendment());
		//basicProposal.setMasterContractID(proposalContractBO.getMasterContractId());
		basicProposal.setContractType(proposalContractBO.getContractType());
		//basicProposal.setMasterContractAmendment(proposalContractBO.getMasterContractAmendment());
		basicProposal.setBlbIndicator(proposalContractBO.getBlbIndicator());
		/* BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - End */
		basicProposal.setProposalName(proposalContractBO.getProposalName());
		basicProposal.setProposalType(proposalContractBO.getProposalType());
		basicProposal.setReportName(proposalContractBO.getReportName());
		basicProposal.setExternalContractNumber(proposalContractBO.getExtContrNo());
		basicProposal.setContractEndDate(proposalContractBO.getContrEndDate());
		basicProposal.setContractStartDate(proposalContractBO.getContrStartDate());
		basicProposal.setContractPeriodBeginning(proposalContractBO.getContrStartPeriod());
		basicProposal.setContractPeriodEnding(proposalContractBO.getContrEndPeriod());

		secondaryProposal.setPurchaseOrderNumber(proposalContractBO.getPoNo());
		secondaryProposal.setPaymentTerms(proposalContractBO.getPayementTerm());
		secondaryProposal.setIgfOfferNumber(proposalContractBO.getIGFNumber());
		secondaryProposal.setComments(proposalContractBO.getComments());
		secondaryProposal.setFixedValDate(proposalContractBO.getFixedValueDate());
		secondaryProposal.setPurchaseOrderDate(proposalContractBO.getPoDate());
		secondaryProposal.setAddValueDays(proposalContractBO.getAddValueDays());
		secondaryProposal.setSandsExcluded(
			LicenseConstants.LICENSE_EXCLUDED.equals(proposalContractBO.getSandSExcluded()));

		pricingInformation.setPlannedGrowthValue(proposalContractBO.getSpecialRate());
		pricingInformation.setGrowthLimitValue(proposalContractBO.getGrowthFactor());
		pricingInformation.setBillingFrequency(proposalContractBO.getBillingFreqCode());
		pricingInformation.setTvmRate(proposalContractBO.getTvmRate());
		pricingInformation.setPakid(proposalContractBO.getPakId());
		pricingInformation.setAnniversaryContractAmount(proposalContractBO.getAnnvAmount());
		pricingInformation.setBillingBlock(proposalContractBO.getBillingBlock());
		pricingInformation.setDeviatingDateRule(proposalContractBO.getDeviatingDateRule());
		pricingInformation.setBillingDateRule(proposalContractBO.getBillingType());
		pricingInformation.setFreeTextForInvoicePrint(proposalContractBO.getFreeText());
		pricingInformation.setSAndSAnniversaryContractAmount(proposalContractBO.getSAndsAnniversaryAmount());
		/** CR6153 changes starts **/
		boolean extendPeriod = false;
		if((proposalContractBO.getExtendPeriod() != null) && (proposalContractBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
			extendPeriod = true;					
		}
		pricingInformation.setExtendPeriod(extendPeriod);
		pricingInformation.setSAndSAnniversaryContractAmountPeriod2(proposalContractBO.getSAndsAnniversaryAmt2());
		pricingInformation.setSAndSAnniversaryContractAmountPeriod3(proposalContractBO.getSAndsAnniversaryAmt3());
		pricingInformation.setSAndSAnniversaryContractAmountPeriod4(proposalContractBO.getSAndsAnniversaryAmt4());
		pricingInformation.setSAndSAnniversaryContractAmountPeriod5(proposalContractBO.getSAndsAnniversaryAmt5());
		/** CR6153 changes ends **/

		if (UtilityConstants.ADVANCED_BILLING_SELECTED.equals(proposalContractBO.getAdvanceBilling()))
		{
			pricingInformation.setAdvance(false);
		}
		else
		{
			pricingInformation.setAdvance(true);
		}

		if (UtilityConstants.DETAILED_INVOICE_SELECTED.equals(proposalContractBO.getInvoiceInd()))
		{
			pricingInformation.setDetailedInvoice(true);
		}
		else
		{
			pricingInformation.setDetailedInvoice(false);
		}

		if (UtilityConstants.GSA_SELECTED.equals(proposalContractBO.getGsaInd()))
		{
			pricingInformation.setGsa(true);
		}
		else
		{
			pricingInformation.setGsa(false);
		}
		/* BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - Begin */
/*		if (UtilityConstants.YES.equals(proposalContractBO.getPrebillIndicator()))
		{
			pricingInformation.setPrebillIndicator(true);
		}
		else
		{
			pricingInformation.setPrebillIndicator(false);
		}*/
	
		pricingInformation.setPrebillIndicator(proposalContractBO.getPrebillIndicator());
		/* BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - End */
		varianceInformation.setCapAmount(proposalContractBO.getCapAmount());
		varianceInformation.setCapPlus(proposalContractBO.getCapPlus());
		varianceInformation.setCapMinus(proposalContractBO.getCapMinus());

		List list = new ArrayList();

		buildCustomerCustomDTO(proposalDomainDTO, list, true, isPriced, isDraft, datePriced,false);
		Iterator iter = list.iterator();

		while (iter.hasNext())
		{
			printProposalCustomDTO.addCustomer((ProposalCustomerCustomDTO) iter.next());
		}

		if (isSandS)
		{
			list = new ArrayList();
			printProposalCustomDTO.setSAndS(true);
			buildCustomerCustomDTO(proposalDomainDTO, list, false, isPriced, isDraft, datePriced,false);
			iter = list.iterator();

			while (iter.hasNext())
			{
				printProposalCustomDTO.addSAndSCustomer((ProposalCustomerCustomDTO) iter.next());
			}
		}
	}
}