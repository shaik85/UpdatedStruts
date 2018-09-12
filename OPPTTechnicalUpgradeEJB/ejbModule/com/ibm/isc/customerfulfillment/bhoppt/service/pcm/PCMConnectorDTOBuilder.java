/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.MailConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.MailMessageConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CreateContractEEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.CustomerListBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.PricingComponentHelper;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Builds the connector DTOs 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 20, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Arun Nagarajan
 * @version 5.1A 
 */
public class PCMConnectorDTOBuilder {
	
	/**Constant */
	private static final String DOT = ".";
	/**Constant */
	private static final String ZERO = "0";
	/** 
	 * Builds the Connector DTO for refresh variance
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param originalContract
	 * @param relatedProposal
	 * @param sessionID
	 * @param userID
	 * @return RefreshVarianceInputConnectorDTO
	 */
	public static RefreshVarianceInputConnectorDTO buildRevertVarianceInputConnectorDTO(ContractBO originalContract, ProposalBO relatedProposal, String sessionID, String userID) {
		RefreshVarianceInputConnectorDTO inputDTO = new RefreshVarianceInputConnectorDTO();

		GenericConnectorDTO genericDTO = getGenericConnectorDTO(ConnectorConstants.RFC_REFRESH_VARIANCE_OPPT, sessionID, userID);
		inputDTO.setGenericConnectorDTO(genericDTO);
		inputDTO.setSalesOrg(relatedProposal.getSalesOrg());
		inputDTO.setIndicatorVarType(UtilityConstants.CREATE_VARIANCE);
		inputDTO.setVarianceDate(relatedProposal.getVarDate());
		if (originalContract.getExtContrNo() != null && !originalContract.getExtContrNo().equals("")) {
			inputDTO.setExternalContractNumber(originalContract.getExtContrNo());
		} else {
			inputDTO.setExternalContractNumber(originalContract.getContrNo());
		}
		return inputDTO;
	}

	/** 
	 * Builds OrgConnectorDTO
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesOrg
	 * @param distributionChannel
	 * @param division
	 * @return OrgConnectorDTO
	 * @author Muruganantham Mani 
	 */
	private static OrgConnectorDTO getOrgConnectorDTO(String salesOrg, String distributionChannel, String salesGroup, String channelRole, String submitterRole, String division) {
		OrgConnectorDTO dto = new OrgConnectorDTO();
		dto.setDistributionChannel(distributionChannel);
		dto.setSalesGroup(salesGroup);
		dto.setChannelRole(channelRole);
		dto.setSubmitterRole(submitterRole);
		dto.setDivision(division);
		dto.setSalesOrg(salesOrg);

		return dto;
	}

	/** 
	 * Builds GenericConnectorDTO
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param functionModuleName
	 * @param sessionID
	 * @param userID
	 * @return GenericConnectorDTO
	 * @author Muruganantham Mani
	 */
	private static GenericConnectorDTO getGenericConnectorDTO(String functionModuleName, String sessionID, String userID) {
		GenericConnectorDTO dto = new GenericConnectorDTO();
		dto.setFunctionModuleName(functionModuleName);
		dto.setSessionID(sessionID);
		dto.setUserID(userID);

		return dto;
	}

	/** 
	 * Builds ChangeContractInputConnectorDTO for changing contract status in ESW
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
	 * @param contract
	 * @param count
	 * @param sessionID
	 * @param userID
	 * @param closureDate
	 * @param eswStatus
	 * @return ChangeContractInputConnectorDTO
	 */
	public static ChangeContractInputConnectorDTO buildChangeContractInputConnectorDTO(ProposalContractBO contract, int count, String sessionID, String userID, Date changeDate, String eswStatus) {
		ChangeContractInputConnectorDTO input = new ChangeContractInputConnectorDTO();
		OPPTLogger.debug("Count = " + count, "PCMConnectorDTOBuilder", "buildChangeContractInputConnectorDTO");
		GenericConnectorDTO genericDTO = getGenericConnectorDTO(ConnectorConstants.RFC_CHANGE_CONTRACT_OPPT, sessionID, userID);
		input.setIGenericConnectorDTO(genericDTO);
		input.setIContractStatus(eswStatus);
		input.setIContractClosureDate(changeDate);
		if (contract.getExtContrNo() != null && !contract.getExtContrNo().equals("")) {
			input.setIContractNumber(contract.getExtContrNo());
		} else {
			input.setIContractNumber(contract.getContrNo());
		}

		if (UtilityConstants.ESW_STATUS_RECL.equals(eswStatus) || UtilityConstants.ESW_STATUS_RENW.equals(eswStatus) || UtilityConstants.ESW_STATUS_REPL.equals(eswStatus)) {
			if (count != 0) {
				input.setIAmendmentReplacementCounter(String.valueOf(count));
			}
		} else if (UtilityConstants.ESW_STATUS_CLSD.equals(eswStatus)) {
			if (count != 0) {
				input.setIVarianceCounter(String.valueOf(count));
			}
		}
		return input;
	}
	
	/** 
	 * buildValidateComplexDataInputConnectorDTO
	 * validates complex contract identifiers fields from CBS to retrieve complex contract type and master contract type
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
	 * @param proposalHeaderCustomDTO
	 * @return ValidateComplexDataInputConnectorDTO
	 */
	public static ValidateComplexDataInputConnectorDTO buildValidateComplexDataInputConnectorDTO(BasicProposalCustomDTO basicProposalCustomDTO) {
		//BasicProposalCustomDTO basicProposalCustomDTO = proposalHeaderCustomDTO.getBasicProposalCustomDTO();
		ValidateComplexDataInputConnectorDTO validateComplexDataInputConnectorDTO = new ValidateComplexDataInputConnectorDTO();
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_COMP_CONTR_IDNT_VALD);
		//genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_VALIDATE_COMPLEX_DATA_OPPT);
		genericConnectorDTO.setUserID(basicProposalCustomDTO.getUserId());
		genericConnectorDTO.setSessionID(basicProposalCustomDTO.getSessionId());
		validateComplexDataInputConnectorDTO.setIGenericConnectorDTO(genericConnectorDTO);
		
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		orgConnectorDTO.setDistributionChannel(basicProposalCustomDTO.getDistributionChannel());
		orgConnectorDTO.setDivision(basicProposalCustomDTO.getDivision());
		orgConnectorDTO.setSalesOrg(basicProposalCustomDTO.getSalesOrganization());
		validateComplexDataInputConnectorDTO.setIOrgConnectorDTO(orgConnectorDTO);
		
		validateComplexDataInputConnectorDTO.setICpsID(basicProposalCustomDTO.getCpsID());
		//validateComplexDataInputConnectorDTO.setIMasterContractID(basicProposalCustomDTO.getMasterContractID());
		//validateComplexDataInputConnectorDTO.setIComplexContractAmendment(basicProposalCustomDTO.getComplexContractAmendment());
		//validateComplexDataInputConnectorDTO.setIMasterContractAmendment(basicProposalCustomDTO.getMasterContractAmendment());
		//validateComplexDataInputConnectorDTO.setIBLBIndicator(basicProposalCustomDTO.getBlbIndicator());
		validateComplexDataInputConnectorDTO.setIContractStartDate(basicProposalCustomDTO.getContractStartDate());
		validateComplexDataInputConnectorDTO.setIContractEndDate(basicProposalCustomDTO.getContractEndDate());
		
		return validateComplexDataInputConnectorDTO;		
	}
	

	/** 
	 * buildValidateHeaderDataInputConnectorDTO
	 * Builds ChangeContractInputConnectorDTO for changing contract status in ESW
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
	 * @param proposalHeaderCustomDTO
	 * @return ValidateHeaderDataInputConnectorDTO
	 */
	public static ValidateHeaderDataInputConnectorDTO buildValidateHeaderDataInputConnectorDTO(ProposalHeaderCustomDTO proposalHeaderCustomDTO) {
		BasicProposalCustomDTO basicProposalCustomDTO = proposalHeaderCustomDTO.getBasicProposalCustomDTO();
		ValidateHeaderDataInputConnectorDTO connectorInputDTO = new ValidateHeaderDataInputConnectorDTO();
		connectorInputDTO.setContractNumber(basicProposalCustomDTO.getExternalContractNumber());
		connectorInputDTO.setProposalType(basicProposalCustomDTO.getProposalType());
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_VALIDATE_HEADER_DATA_OPPT);
		genericConnectorDTO.setUserID(proposalHeaderCustomDTO.getUserId());
		genericConnectorDTO.setSessionID(proposalHeaderCustomDTO.getSessionId());
		connectorInputDTO.setGenericConnectorDTO(genericConnectorDTO);
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		orgConnectorDTO.setDistributionChannel(basicProposalCustomDTO.getDistributionChannel());
		orgConnectorDTO.setSalesGroup(basicProposalCustomDTO.getSalesGroup());
		//orgConnectorDTO.setChannelRole(basicProposalCustomDTO.getChannelRole());
		//orgConnectorDTO.setSubmitterRole(basicProposalCustomDTO.getSubmitterRole());
		orgConnectorDTO.setDivision(basicProposalCustomDTO.getDivision());
		orgConnectorDTO.setSalesOrg(basicProposalCustomDTO.getSalesOrganization());
		connectorInputDTO.setOrgConnectorDTO(orgConnectorDTO);

		return connectorInputDTO;

	}
	
	/** 
	 * buildRetrievePartnerInputConnectorDTO
	 * Builds ChangeContractInputConnectorDTO for changing contract status in ESW
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
	 * @param fetchPartnerInformationCustomDTO
	 * @param proposalContractBO
	 * @return RetrievePartnerInputConnectorDTO
	 */
	public static RetrievePartnerInputConnectorDTO buildRetrievePartnerInputConnectorDTO(FetchPartnerInformationCustomDTO fetchPartnerInformationCustomDTO, ProposalContractBO proposalContractBO) {

		RetrievePartnerInputConnectorDTO inputConnectorDTO = new RetrievePartnerInputConnectorDTO();
		ESWCustomerCustomDTO customer = fetchPartnerInformationCustomDTO.getCustomer();
		
		//inputConnectorDTO.setAddressSequenceNo(customer.getAddressSequenceNumber()); DADO02&DADO09
	
	//	inputConnectorDTO.setLegacyNo(customer.getLegacyCustomerNumber());
		inputConnectorDTO.setCustomerNumber(customer.getCustomerNumber()); //DADO02&DADO09
		
	//	DADO02&DADO09 inputConnectorDTO.setCountryCode(customer.getCountryCode());/* Changed for EF0607044559	by Sara on June 16,2004 */
	
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_PARTNER_OPPT);
		genericConnectorDTO.setUserID(fetchPartnerInformationCustomDTO.getUserId());
		genericConnectorDTO.setSessionID(fetchPartnerInformationCustomDTO.getSessionId());
		inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		if (null != proposalContractBO) {
			orgConnectorDTO.setDistributionChannel(proposalContractBO.getDistrChannel());
			//These value is not requires to this RFC. so commented this values & checking the null condition in the OrgConnectorDTOSerializer class and stopping the values to append into input RFC
			//orgConnectorDTO.setSalesGroup( proposalContractBO.getSalesGroup());
			//orgConnectorDTO.setChannelRole(proposalContractBO.getChannelRole());
			//orgConnectorDTO.setSubmitterRole(proposalContractBO.getSubmitterRole());
			orgConnectorDTO.setDivision(proposalContractBO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(proposalContractBO.getSalesOrg());

		} else {
			orgConnectorDTO.setDistributionChannel(fetchPartnerInformationCustomDTO.getDistributionChannel());
			//orgConnectorDTO.setSalesGroup(fetchPartnerInformationCustomDTO.getSalesGroup());
			//orgConnectorDTO.setChannelRole(fetchPartnerInformationCustomDTO.getChannelRole());
			//orgConnectorDTO.setSubmitterRole(fetchPartnerInformationCustomDTO.getSubmitterRole());
			orgConnectorDTO.setDivision(fetchPartnerInformationCustomDTO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(fetchPartnerInformationCustomDTO.getSelectedSalesOrg());

		}

		inputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);

		return inputConnectorDTO;

	}

	/** 
	 * buildRetrieveCustListInputConnectorDTO
	 * Builds ChangeContractInputConnectorDTO for changing contract status in ESW
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
	 * @param fetchCustomerListCustomDTO
	 * @param proposalContractBO
	 * @return RetrieveCustListInputConnectorDTO
	 */
	public static RetrieveCustListInputConnectorDTO buildRetrieveCustListInputConnectorDTO(FetchCustomerListCustomDTO fetchCustomerListCustomDTO, ProposalContractBO proposalContractBO) {

		RetrieveCustListInputConnectorDTO inputConnectorDTO = new RetrieveCustListInputConnectorDTO();
		inputConnectorDTO.setCity(fetchCustomerListCustomDTO.getCity());
		inputConnectorDTO.setCustomerListName(OPPTHelper.toUpperCase(fetchCustomerListCustomDTO.getCustomerListName()));
		inputConnectorDTO.setCustomerListNumber(OPPTHelper.toUpperCase(fetchCustomerListCustomDTO.getCustomerListNumber()));
		inputConnectorDTO.setZipCode(fetchCustomerListCustomDTO.getZipCode());
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_CUSTLIST_OPPT);
		genericConnectorDTO.setUserID(fetchCustomerListCustomDTO.getUserId());
		genericConnectorDTO.setSessionID(fetchCustomerListCustomDTO.getSessionId());
		inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		if (null != proposalContractBO) {
			orgConnectorDTO.setDistributionChannel(proposalContractBO.getDistrChannel());
			//orgConnectorDTO.setSalesGroup(proposalContractBO.getSalesGroup());
			//orgConnectorDTO.setChannelRole(proposalContractBO.getChannelRole());
			//orgConnectorDTO.setSubmitterRole(proposalContractBO.getSubmitterRole());
			orgConnectorDTO.setDivision(proposalContractBO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(proposalContractBO.getSalesOrg());

		} else {
			orgConnectorDTO.setDistributionChannel(fetchCustomerListCustomDTO.getDistributionChannel());
			//orgConnectorDTO.setSalesGroup(fetchCustomerListCustomDTO.getSalesGroup());
			//orgConnectorDTO.setChannelRole(fetchCustomerListCustomDTO.getChannelRole());
			//orgConnectorDTO.setSubmitterRole(fetchCustomerListCustomDTO.getSubmitterRole());
			orgConnectorDTO.setDivision(fetchCustomerListCustomDTO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(fetchCustomerListCustomDTO.getSelectedSalesOrg());
		}
		inputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);

		return inputConnectorDTO;
	}
	
	/*DAD O02
	 * Sateesh
	 * 
	 */
	/** 
	 * buildRetrieveCustListInputConnectorDTO
	 * Builds ChangeContractInputConnectorDTO for changing contract status in ESW
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
	 * @param fetchCustomerListCustomDTO
	 * @param proposalContractBO
	 * @return RetrieveSiteIDListInputConnectorDTO
	 */
	public static RetrieveSiteIDListInputConnectorDTO buildRetrieveSiteIDListInputConnectorDTO(FetchCustomerListCustomDTO fetchCustomerListCustomDTO, ProposalContractBO proposalContractBO) {

		RetrieveSiteIDListInputConnectorDTO inputConnectorDTO = new RetrieveSiteIDListInputConnectorDTO();
		inputConnectorDTO.setCity(fetchCustomerListCustomDTO.getCity());
		inputConnectorDTO.setZipCode(fetchCustomerListCustomDTO.getZipCode());
		inputConnectorDTO.setSiteName(OPPTHelper.toUpperCase(fetchCustomerListCustomDTO.getSiteName()));
		inputConnectorDTO.setSiteID(OPPTHelper.toUpperCase(fetchCustomerListCustomDTO.getSiteID()));
		
		
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_CUSTLIST_OPPT);
		genericConnectorDTO.setUserID(fetchCustomerListCustomDTO.getUserId());
		genericConnectorDTO.setSessionID(fetchCustomerListCustomDTO.getSessionId());
		inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		if (null != proposalContractBO) {
			orgConnectorDTO.setDistributionChannel(proposalContractBO.getDistrChannel());
			//orgConnectorDTO.setSalesGroup(proposalContractBO.getSalesGroup());
			//orgConnectorDTO.setChannelRole(proposalContractBO.getChannelRole());
			//orgConnectorDTO.setSubmitterRole(proposalContractBO.getSubmitterRole());
			orgConnectorDTO.setDivision(proposalContractBO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(proposalContractBO.getSalesOrg());

		} else {
			orgConnectorDTO.setDistributionChannel(fetchCustomerListCustomDTO.getDistributionChannel());
			//orgConnectorDTO.setSalesGroup(fetchCustomerListCustomDTO.getSalesGroup());
			//orgConnectorDTO.setChannelRole(fetchCustomerListCustomDTO.getChannelRole());
			//orgConnectorDTO.setSubmitterRole(fetchCustomerListCustomDTO.getSubmitterRole());
			orgConnectorDTO.setDivision(fetchCustomerListCustomDTO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(fetchCustomerListCustomDTO.getSelectedSalesOrg());
		}
		inputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);

		return inputConnectorDTO;
	}
	
	/** 
	 * buildRetrieveCustInputConnectorDTO
	 * Builds ChangeContractInputConnectorDTO for changing contract status in ESW
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
	 * @param selectedCustomerListNumbers
	 * @param fetchCustomersCustomDTO
	 * @param proposalContractBO
	 * @param proposalContractBO
	 * @return RetrieveCustInputConnectorDTO
	 */
	public static RetrieveCustInputConnectorDTO buildRetrieveCustInputConnectorDTO(
		List selectedCustomerListNumbers,
		FetchCustomersCustomDTO fetchCustomersCustomDTO,
		ProposalContractBO proposalContractBO) {
		RetrieveCustInputConnectorDTO inputConnectorDTO = new RetrieveCustInputConnectorDTO();
		inputConnectorDTO.setCustomerListNumber(selectedCustomerListNumbers);
		// populate org generic data
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_CUSTOMER_OPPT);
		genericConnectorDTO.setUserID(fetchCustomersCustomDTO.getUserId());
		genericConnectorDTO.setSessionID(fetchCustomersCustomDTO.getSessionId());
		inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		// populate org specific data
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		if (null != proposalContractBO) {
			orgConnectorDTO.setDistributionChannel(proposalContractBO.getDistrChannel());
			//orgConnectorDTO.setSalesGroup(proposalContractBO.getSalesGroup());
			//orgConnectorDTO.setChannelRole(proposalContractBO.getChannelRole());
			//orgConnectorDTO.setSubmitterRole(proposalContractBO.getSubmitterRole());
			orgConnectorDTO.setDivision(proposalContractBO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(proposalContractBO.getSalesOrg());

		} else {
			orgConnectorDTO.setDistributionChannel(fetchCustomersCustomDTO.getDistributionChannel());
			//orgConnectorDTO.setSalesGroup(fetchCustomersCustomDTO.getSalesGroup());
			//orgConnectorDTO.setChannelRole(fetchCustomersCustomDTO.getChannelRole());
			//orgConnectorDTO.setSubmitterRole(fetchCustomersCustomDTO.getSubmitterRole());
			orgConnectorDTO.setDivision(fetchCustomersCustomDTO.getDivisionCode());
			orgConnectorDTO.setSalesOrg(fetchCustomersCustomDTO.getSelectedSalesOrg());
		}
		inputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);

		return inputConnectorDTO;
	}

	/** 
	 * Builds the ConnectorDTO for contract creation
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal
	 * @param customerLists
	 * @param eeDomains
	 * @param sessionID
	 * @param userID
	 * @return CreateContractInputConnectorDTO
	 */
	public static CreateContractInputConnectorDTO buildCreateContractInputConnectorDTO(
		ProposalContractBO proposal,
		List customerLists,
		CreateContractEEDomainDTO[] eeDomains,
		String sessionID,
		String userID) {
		CreateContractInputConnectorDTO input = new CreateContractInputConnectorDTO();
		int decimalAllowed = eeDomains[0].getDecimalAllowed();

		GenericConnectorDTO genericDTO = getGenericConnectorDTO(ConnectorConstants.RFC_CREATE_CONTRACT_OPPT, sessionID, proposal.getCreatedBy());
		input.setIGenericConnectorDTO(genericDTO);

		OrgConnectorDTO orgDTO = getOrgConnectorDTO(proposal.getSalesOrg(), proposal.getDistrChannel(),proposal.getSalesGroup(), proposal.getChannelRole(), proposal.getSubmitterRole(), proposal.getDivisionCode());
		input.setIOrgConnectorDTO(orgDTO);

		List partners = new ArrayList();
		PartnerInfoConnectorDTO partnerInfo = null;
		if (customerLists != null) {
			Iterator iterate = customerLists.iterator();
			CustomerListBO custList = null;
			while (iterate.hasNext()) {
				custList = (CustomerListBO) iterate.next();
				partnerInfo = buildPartnerInfoConnectorDTO(custList.getCustomerListNo(), UtilityConstants.CUSTOMER_LIST_TYPE);
				partners.add(partnerInfo);
			}
		}

		partnerInfo = buildPartnerInfoConnectorDTO(proposal.getRegBillToPartyNo(), PartnerTypeConstants.BILL_TO_PARTY);
		partners.add(partnerInfo);
		partnerInfo = buildPartnerInfoConnectorDTO(proposal.getRegCustomerNo(), PartnerTypeConstants.SOLD_TO_PARTY);
		partners.add(partnerInfo);
		partnerInfo = buildPartnerInfoConnectorDTO(proposal.getRegShipToPartyNo(), PartnerTypeConstants.SHIP_TO_PARTY);
		partners.add(partnerInfo);
		partnerInfo = buildPartnerInfoConnectorDTO(proposal.getRegPayerNo(), PartnerTypeConstants.PAYER);
		partners.add(partnerInfo);
		if (proposal.getReg9DPartnerNo() != null) {
			partnerInfo = buildPartnerInfoConnectorDTO(proposal.getReg9DPartnerNo(), PartnerTypeConstants.PARTNER_9D);
			partners.add(partnerInfo);
		}
		input.setIPartnerInfoConnectorDTO(partners);

		EEDetailsConnectorDTO eeDetail = null;
		List eeList = new ArrayList();
		for (int i = 0; i < eeDomains.length; i++) {
			eeDetail = buildEEDetailsConnectorDTO(eeDomains[i],proposal);
			eeList.add(eeDetail);
		}
		input.setIEEDetailsConnectorDTO(eeList);

		String proposalType = proposal.getProposalType();
		if (ContractTypeConstants.VARIANCE.equals(proposal.getContrType())) {
			proposalType = ProposalTypeConstants.VARIANCE;
			input.setIVarianceCount(String.valueOf(proposal.getContrPeriodVarNo()));
			input.setIBillingSupressIndicator(proposal.getSupressInvoice());
		}
		input.setIProposalType(proposalType);
		input.setIApproverUserId(userID);

		if (proposal.getExtContrNo() != null && !proposal.getExtContrNo().equals("")) {
			input.setIExternalContractNumber(proposal.getExtContrNo());
			input.setIContractNumber(proposal.getExtContrNo());
		} else {
			input.setIContractNumber(proposal.getContrNo());
			input.setIExternalContractNumber(proposal.getContrNo());
			proposal.setExtContrNo(proposal.getContrNo());
		}
		input.setIFinancingContractNumber(proposal.getIGFNumber());
		input.setIContractStartDate(proposal.getContrStartDate());
		input.setIContractStartPeriod(proposal.getContrStartPeriod());
		input.setIContractEndDate(proposal.getContrEndDate());
		input.setIContractEndPeriod(proposal.getContrEndPeriod());
		input.setIBillingFrequencyNumber(String.valueOf(getBillingFreqNumber(proposal.getBillingFreqCode())));
		input.setISpecialRate(proposal.getSpecialRate());
		input.setIAnniversaryAmount(convertPriceAsPerDecimalAllowed(proposal.getAnnvAmount(), decimalAllowed));
		input.setIGrowthFactor(proposal.getGrowthFactor());
		input.setICapAmount(convertPriceAsPerDecimalAllowed(proposal.getCapAmount(), decimalAllowed));
		input.setICapPlus(proposal.getCapPlus());
		input.setICapMinus(proposal.getCapMinus());
		input.setIPreTVMInvoiceAmount(convertPriceAsPerDecimalAllowed(proposal.getPreTVMInvoiceAmount(), decimalAllowed));
		input.setICurrency(proposal.getCurrency());
		input.setIFlag(proposal.getContrCreateFlag());
		input.setIPakId(proposal.getPakId());
		input.setIPaymentTerm(proposal.getPayementTerm());
		input.setIFixedValDate(proposal.getFixedValueDate());
		input.setIAddValueDays(String.valueOf(proposal.getAddValueDays()));
		input.setIBillingType(proposal.getBillingType());
		input.setIAdvanceBilling(proposal.getAdvanceBilling());
		input.setIInvoiceIndicator(proposal.getInvoiceInd());
		input.setIDeviatingRule(proposal.getDeviatingDateRule());
		input.setIBillingBlock(proposal.getBillingBlock());
		input.setIPoNumber(proposal.getPoNo());
		input.setIPoDate(proposal.getPoDate());
		input.setIGsaIndicator(proposal.getGsaInd());
		/** CR6153 Start changes **/ 
		input.setISAndASExtendInd(proposal.getExtendPeriod());
		/** CR6153 End changes **/
		input.setIFreeText(proposal.getFreeText());
		// Blue Harmony Wave 1 DAD003 - Begin - Manoj
		input.setCpsID(proposal.getCpsId());
		input.setOcpsID(proposal.getOcpsId());
		input.setContractType(proposal.getContractType());
		input.setBLBIndicator(proposal.getBlbIndicator());
		input.setPrebillIndicator(proposal.getPrebillIndicator());
		//input.setPaymentMethod(proposal.getPaymentMethod());
		// Blue Harmony Wave 1 DAD003 - End - Manoj
		return input;
	}

	/** 
	 * Builds connector dto for partner information 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sapNo
	 * @param partnerType
	 * @return PartnerInfoConnectorDTO
	 */
	private static PartnerInfoConnectorDTO buildPartnerInfoConnectorDTO(String sapNo, String partnerType) {
		PartnerInfoConnectorDTO partnerInfo = new PartnerInfoConnectorDTO();
		partnerInfo.setIPartnerFunction(partnerType);
		partnerInfo.setIPartnerNo(sapNo);
		return partnerInfo;
	}

	/** 
	 * Builds Connector DTO for EE Details 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeDomain
	 * @return EEDetailsConnectorDTO
	 */
	private static EEDetailsConnectorDTO buildEEDetailsConnectorDTO(CreateContractEEDomainDTO eeDomain,ProposalContractBO proposal) {
		EEDetailsConnectorDTO eeDetail = new EEDetailsConnectorDTO();
		eeDetail.setIAmount(convertPriceAsPerDecimalAllowed(eeDomain.getCalculatedPriceForApproval(), eeDomain.getDecimalAllowed()));
		eeDetail.setIBillToParty(eeDomain.getBillToPartySAPNo());
		eeDetail.setIConditionType(eeDomain.getPriceConditionType());
		eeDetail.setICurrency(eeDomain.getCurrency());
		eeDetail.setIEeItemNumber(eeDomain.getEeItemNo());
		eeDetail.setIPayer(eeDomain.getPayerSAPNo());
		eeDetail.setISalesDocNo(eeDomain.getSalesDocNo());
		eeDetail.setISequenceItem(String.valueOf(eeDomain.getSequenceNo()));
		eeDetail.setSSBilledUptoDate(eeDomain.getSAndSUptoDate());
		/** CR6153 starts **/
		eeDetail.setIContractPeriodStartDate(eeDomain.getPlanStartDate());
		eeDetail.setIContractPeriodEndDate(eeDomain.getPlanEndDate());
		/** CR6153 ends **/
		eeDetail.setCpsID(proposal.getCpsId());
		eeDetail.setOcpsID(proposal.getOcpsId());
		eeDetail.setBLBIndicator(proposal.getBlbIndicator());
		eeDetail.setPrebillIndicator(proposal.getPrebillIndicator());
		return eeDetail;
	}

	/** 
	 * Gets the billing frequency number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingFreqCode
	 * @return int
	 */
	private static int getBillingFreqNumber(String billingFreqCode) {
		int billingNumber = 1;
		if (UtilityConstants.BILLING_FREQ_ANNUAL.equals(billingFreqCode)) {
			billingNumber = 4;
		} else if (UtilityConstants.BILLING_FREQ_SEMIANNUAL.equals(billingFreqCode)) {
			billingNumber = 3;
		} else if (UtilityConstants.BILLING_FREQ_QUARTERLY.equals(billingFreqCode)) {
			billingNumber = 2;
		}
		return billingNumber;
	}

	/**
	 * Converts the price as per decimal allowed and also removes the DOT in the price as per the specifications of 
	 * BE (ESW) RFC. This case of conversion of data is an exceptional case. This conversion is done in service layer 
	 * rather than in connector because of some input in OPPT, which is not passed, is required.
	 * 
	 * The input decimalAllowed is considered to be insync with the data in the BE.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param price
	 * @param decimalAllowed
	 * @return String
	 */
	/*
	private static String convertPriceAsPerDecimalAllowed(double price, int decimalAllowed){
		String newPrice = null;
		if(decimalAllowed <= 0){
			String roundedPrice = String.valueOf(Math.floor(price));
			int index = roundedPrice.indexOf(DOT);
			if(index != -1){
				newPrice = roundedPrice.substring(0,index);
			}else{
				newPrice = roundedPrice;
			}			
		}else{
			String priceStringValue = String.valueOf(price);
			int length = priceStringValue.length();
			int index = priceStringValue.indexOf(DOT);
			if(index != -1){
				StringBuffer buffer = new StringBuffer();
				if(length < index+1+decimalAllowed){
					buffer.append(priceStringValue.substring(0,index));
					buffer.append(priceStringValue.substring(index+1));
					int remainLength = decimalAllowed - (length - index - 1);
					for(int i=0;i<remainLength;i++){
						buffer.append(ZERO);
					}
				}else{
					buffer.append(priceStringValue.substring(0,index));
					buffer.append(priceStringValue.substring(index+1,index+decimalAllowed+1));
				}
				newPrice = buffer.toString();
			}else{
				newPrice = String.valueOf(Math.floor(price));
			}
		}
		return newPrice;
	} */
	
	/*
	 * Added by Balaji for EF0527042420, EF0702045441
	 * Defect 13 
	 *  
	 */
	
	/** 
	 * convertPriceAsPerDecimalAllowed
	 * Builds ChangeContractInputConnectorDTO for changing contract status in ESW
	 *  changes for decimal problem starts 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	* date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param price
	 * @param decimalAllowed
	 * @return String
	 */
	 
	
	
	 public static String convertPriceAsPerDecimalAllowed(double price, int decimalAllowed) {
		 String newPrice = null;
		 if (decimalAllowed < 0) {
			 decimalAllowed = 0;
		 }
		 if (price == 0) {
			 newPrice = "";
		 } else {
			 if (decimalAllowed < 0) {
				 decimalAllowed = 0;
			 }
			 BigDecimal priceBigDecimal = PricingComponentHelper.convertToBigDecimal(price);
			 BigDecimal ten = PricingComponentHelper.convertToBigDecimal(10);
			 for (int i = 0; i < decimalAllowed; i++) {
				 priceBigDecimal = priceBigDecimal.multiply(ten);
			 }
			 priceBigDecimal = priceBigDecimal.setScale(0, BigDecimal.ROUND_DOWN);
			 newPrice = priceBigDecimal.toString();
		 }

		 return newPrice;
	 }
	
	 /** 
	 * convertPriceAsPerDecimalAllowed
	 * Builds ChangeContractInputConnectorDTO for changing contract status in ESW
	 *  changes for decimal problem starts 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	* date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceBigDecimal
	 * @param decimalAllowed
	 * @return String
	 */
	 
	  private static String convertPriceAsPerDecimalAllowed(BigDecimal priceBigDecimal, int decimalAllowed) {
		  String newPrice = null;
		  if (decimalAllowed < 0) {
			  decimalAllowed = 0;
		  }
		  if (priceBigDecimal.doubleValue() == 0) {
			  newPrice = "";
		  } else {
			  if (decimalAllowed < 0) {
				  decimalAllowed = 0;
			  }
			  BigDecimal ten = PricingComponentHelper.convertToBigDecimal(10);
			  for (int i = 0; i < decimalAllowed; i++) {
				  priceBigDecimal = priceBigDecimal.multiply(ten);
			  }

			//priceBigDecimal = priceBigDecimal.setScale(0, BigDecimal.ROUND_DOWN);
			/*
			 * This is a fix for display issue of rounding
			 * Balaji 
			 */
			priceBigDecimal = priceBigDecimal.setScale(0, BigDecimal.ROUND_HALF_EVEN);

			  newPrice = priceBigDecimal.toString();
		  }

		  return newPrice;
	  }
	  //	changes for decimal problem ends 

	/** 
	 * Builds the mail connector DTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param propCntrBO
	 * @param senderEmail
	 * @param receiverID
	 * @param type
	 * @return MailConnectorDTO
	 */
	public static MailConnectorDTO buildMailConnectorDTO(ProposalContractBO propCntrBO, String senderEmail, String receiverID, int type) {
		MailConnectorDTO mailCarrier = null;
		PreparedString prepareForMail = null;

		if (type == UtilityConstants.MAIL_CNTR_REJECT || type == UtilityConstants.MAIL_PROP_REJECT) {
			mailCarrier = new MailConnectorDTO();
			if (type == UtilityConstants.MAIL_PROP_REJECT) {
				prepareForMail = new PreparedString(MailMessageConstants.PROP_REJECT_MAIL_SUBJ);
			} else {
				prepareForMail = new PreparedString(MailMessageConstants.CNTR_REJECT_MAIL_SUBJ);
			}
			prepareForMail.setString(1, propCntrBO.getProposalName());
			mailCarrier.setSubject(prepareForMail.toString());
			if (type == UtilityConstants.MAIL_PROP_REJECT) {
				prepareForMail.clear(MailMessageConstants.PROP_REJECT_MAIL_TEXT);
			} else {
				prepareForMail.clear(MailMessageConstants.CNTR_REJECT_MAIL_TEXT);
			}
			prepareForMail.setString(1, propCntrBO.getProposalName());
			prepareForMail.setString(4, OPPTPropertiesReader.getOpptUrl());
			mailCarrier.setMsgText(prepareForMail.toString());
		} else if (type == UtilityConstants.MAIL_CLS_CNTR_APPV || type == UtilityConstants.MAIL_CNTR_APPV || type == UtilityConstants.MAIL_PROP_APPV) {
			mailCarrier = new MailConnectorDTO();
			if (type == UtilityConstants.MAIL_PROP_APPV) {
				prepareForMail = new PreparedString(MailMessageConstants.PROP_APPROVE_MAIL_SUBJ);
			} else {
				prepareForMail = new PreparedString(MailMessageConstants.CNTR_APPROVE_MAIL_SUBJ);
			}
			prepareForMail.setString(1, propCntrBO.getProposalName());
			mailCarrier.setSubject(prepareForMail.toString());
			if (type == UtilityConstants.MAIL_PROP_APPV || type == UtilityConstants.MAIL_CNTR_APPV) {
				prepareForMail.clear(MailMessageConstants.CNTR_CREATE_APPROVE_MAIL_TEXT);
				prepareForMail.setString(1, propCntrBO.getProposalName());
				prepareForMail.setString(2, propCntrBO.getContrNo());
				prepareForMail.setString(3, propCntrBO.getRegCustomerNo());
				prepareForMail.setString(4, propCntrBO.getRegCustomerName());
				prepareForMail.setString(5, propCntrBO.getContrStartPeriod().toString());
				prepareForMail.setString(6, propCntrBO.getContrEndPeriod().toString());
				prepareForMail.setString(7, propCntrBO.getBillingFreqCode());
				prepareForMail.setString(8, String.valueOf(propCntrBO.getInvoiceAmount()));
				prepareForMail.setString(9, OPPTPropertiesReader.getOpptUrl());
			} else {
				prepareForMail.clear(MailMessageConstants.CNTR_CLS_APPROVE_MAIL_TEXT);
				prepareForMail.setString(2, OPPTPropertiesReader.getOpptUrl());
			}
			mailCarrier.setMsgText(prepareForMail.toString());
		}
		mailCarrier.setFromAddress(senderEmail);
		mailCarrier.setToAddressID(receiverID);
		return mailCarrier;
	}
}