/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.GenericConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.OrgConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PriceInquiryInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveConfigConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDeltaInventoryInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveIneligDeltaInvenInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveIneligInvenDetailInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenConfigInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenDetailInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSelInvenDetailInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.StatusCheckInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateConfigConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateHeaderDataInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateInvenConfigInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateUserAccessInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ContractTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalContractStatusConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMEECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchSelectedInventoryDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * This connector build helper class helps to create input connector dtos 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 12, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar J
 * @version 5.1A 
 */
public class InputConnectorDTOBuildHelper {

	private static final String CLASS_NAME = "InputConnectorDTOBuildHelper";

	/**
	 *  
	 * This method populates the Inventory detail input connector dto with values
	 * RFC Parameters required
	 * 1. Function module
	 * 2. Session Id					CHARACTER(44)
	 * 3. User Id						CHARACTER(31)
	 * 4. Sales Org					CHARACTER(4)
	 * 5. Dstr channel					CHARACTER(2)
	 * 6. Division						CHARACTER(2)
	 * 7. Proposal type					CHARACTER(2)		
	 * 8. Flag (C)						CHARACTER(1)
	 * 9. Currency						CHARACTER(5)	
	 * 10. Cntr start period				DATE(8)	
	 * 11. Cntr end period				DATE(8)
	 * 12. Last fetch date - Flag (00000000)	DATE(8)
	 * 13. Last fetch time				TIME(6)	
	 * 14. Cntr type					CHARACTER(1)	
	 * 15. Ext cntr number / cntr number of old contract (Amend,Replace,Renew)	CHARACTER(10)
	 * 16. Customer nos				CHARACTER(10)
	 * 17. Sales Group				CHARACTER(2)
	 * 18.Channel Role				CHARACTER(2)
	 * 19.Submitter Role			CHARACTER(2)
	 *   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param inventoryCustomDTO
	 * @return
	 * @throws Exception
	 * @author Ravishankar
	 */
	public static RetrieveInvenDetailInputConnectorDTO buildRetrieveInvenDetailInputConnectorDTO(ProposalDomainDTO proposalDomainDTO, String sessionId, String userId, boolean fetchFlag, boolean fetchPlan, List custList, boolean custChanged, String oldExtrContrNo) throws Exception {
		String methodName = "buildRetrieveInvenDetailInputConnectorDTO";
		ConnectorDTOInterface connectorDTO = null;
		RetrieveInvenDetailInputConnectorDTO retrieveInventoryDetailInputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;
		OrgConnectorDTO orgConnectorDTO = null;

		retrieveInventoryDetailInputConnectorDTO = new RetrieveInvenDetailInputConnectorDTO();
		genericConnectorDTO = new GenericConnectorDTO();
		orgConnectorDTO = new OrgConnectorDTO();

		//set the generic connector values
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_DETAIL_OPPT);
		genericConnectorDTO.setSessionID(sessionId);
		genericConnectorDTO.setUserID(userId);

		// set the organization connector dto values
		orgConnectorDTO.setDistributionChannel(proposalDomainDTO.getDistrChannel());
		//These commented code values not required for this RFC
		//orgConnectorDTO.setSalesGroup(proposalDomainDTO.getSalesGroup());
		//orgConnectorDTO.setChannelRole(proposalDomainDTO.getChannelRole());
		//orgConnectorDTO.setSubmitterRole(proposalDomainDTO.getSubmitterRole());
		orgConnectorDTO.setDivision(proposalDomainDTO.getDivisionCode());
		orgConnectorDTO.setSalesOrg(proposalDomainDTO.getSalesOrg());

		//set the values for input detail connector dto
		retrieveInventoryDetailInputConnectorDTO.setCustomerNumber(custList);
		if (fetchPlan) {
			retrieveInventoryDetailInputConnectorDTO.setFlag("B");
		} else {
			retrieveInventoryDetailInputConnectorDTO.setFlag("C");
		}
		retrieveInventoryDetailInputConnectorDTO.setProposalType(proposalDomainDTO.getProposalType());
		if (!fetchFlag && !custChanged) {

			retrieveInventoryDetailInputConnectorDTO.setLastFetchDate(proposalDomainDTO.getEswFetchDate());
			retrieveInventoryDetailInputConnectorDTO.setLastFetchTime(proposalDomainDTO.getEswFetchTime());
		} else {
			retrieveInventoryDetailInputConnectorDTO.setLastFetchDate(null);
			retrieveInventoryDetailInputConnectorDTO.setLastFetchTime(null);
		}

		retrieveInventoryDetailInputConnectorDTO.setCurrency(proposalDomainDTO.getCurrency());
		retrieveInventoryDetailInputConnectorDTO.setContractEndPeriod(proposalDomainDTO.getContrEndPeriod());
		/* Only for Replaced / Renewed proposals excon needs to be sent
		if (proposalDomainDTO.getExtContrNo() != null && !(proposalDomainDTO.getExtContrNo().equals(""))) {
			retrieveInventoryDetailInputConnectorDTO.setContractNumber(proposalDomainDTO.getExtContrNo());
			OPPTLogger.debug("External Contr No" + proposalDomainDTO.getExtContrNo(), CLASS_NAME, methodName);
		} else {
			retrieveInventoryDetailInputConnectorDTO.setContractNumber(proposalDomainDTO.getContrNo());
			OPPTLogger.debug("Contr No" + proposalDomainDTO.getContrNo(), CLASS_NAME, methodName);
		}
		*/
		if (oldExtrContrNo != null && !oldExtrContrNo.equals("")) {
			retrieveInventoryDetailInputConnectorDTO.setContractNumber(oldExtrContrNo);
		}
		retrieveInventoryDetailInputConnectorDTO.setContractStartPeriod(proposalDomainDTO.getContrStartPeriod());
		retrieveInventoryDetailInputConnectorDTO.setContractType(proposalDomainDTO.getContrType());
		retrieveInventoryDetailInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		retrieveInventoryDetailInputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);

		// SAND S
		retrieveInventoryDetailInputConnectorDTO.setProposalContent(proposalDomainDTO.getProposalContent());
		// Added by Jagadeesh
		if(proposalDomainDTO.isSelectedinventory())
		{
		retrieveInventoryDetailInputConnectorDTO.setSelectedInventory(proposalDomainDTO.isSelectedinventory());
		retrieveInventoryDetailInputConnectorDTO.setDesignatedMaterialID(proposalDomainDTO.getDesignatedMachineID());
		retrieveInventoryDetailInputConnectorDTO.setMaterialID(proposalDomainDTO.getMaterialID());
		retrieveInventoryDetailInputConnectorDTO.setSerialNumber(proposalDomainDTO.getSerialNumber());
		}
		retrieveInventoryDetailInputConnectorDTO.setSelCustomerList(proposalDomainDTO.getSelCustomersList());
		
		return retrieveInventoryDetailInputConnectorDTO;
	}
	
	/**
	 * 
	 * @param proposalDomainDTO
	 * @param sessionId
	 * @param userId
	 * @param custList
	 * @param oldExtrContrNo
	 * @return
	 * @throws Exception
	 * 
	 * This method is used to build DTO for fetching selected inventory
	 */
	public static RetrieveSelInvenDetailInputConnectorDTO  buildRetrieveSelInvenDetailInputConnectorDTO(ProposalDomainDTO proposalDomainDTO,String sessionId, String userId, boolean fetchFlag, boolean fetchPlan, List custList, boolean custChanged, String oldExtrContrNo,FetchSelectedInventoryDTO dto) throws Exception {
		String methodName = "buildRetrieveInvenDetailInputConnectorDTO";
		ConnectorDTOInterface connectorDTO = null;
		RetrieveSelInvenDetailInputConnectorDTO retrieveSelInventoryDetailInputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;
		OrgConnectorDTO orgConnectorDTO = null;

		retrieveSelInventoryDetailInputConnectorDTO = new RetrieveSelInvenDetailInputConnectorDTO();
		genericConnectorDTO = new GenericConnectorDTO();
		orgConnectorDTO = new OrgConnectorDTO();

		//set the generic connector values
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_DETAIL_OPPT);
		genericConnectorDTO.setSessionID(sessionId);
		genericConnectorDTO.setUserID(userId);

		// set the organization connector dto values
		orgConnectorDTO.setDistributionChannel(proposalDomainDTO.getDistrChannel());
		//These commented code values not required for this RFC
		//orgConnectorDTO.setSalesGroup(proposalDomainDTO.getSalesGroup());
		//orgConnectorDTO.setChannelRole(proposalDomainDTO.getChannelRole());
		//orgConnectorDTO.setSubmitterRole(proposalDomainDTO.getSubmitterRole());
		orgConnectorDTO.setDivision(proposalDomainDTO.getDivisionCode());
		orgConnectorDTO.setSalesOrg(proposalDomainDTO.getSalesOrg());

		//set the values for input detail connector dto
		retrieveSelInventoryDetailInputConnectorDTO.setCustomerNumber(custList);
		if (fetchPlan) {
			retrieveSelInventoryDetailInputConnectorDTO.setFlag("B");
		} else {
			retrieveSelInventoryDetailInputConnectorDTO.setFlag("C");
		}
		retrieveSelInventoryDetailInputConnectorDTO.setProposalType(proposalDomainDTO.getProposalType());
		if (!fetchFlag && !custChanged) {

			retrieveSelInventoryDetailInputConnectorDTO.setLastFetchDate(proposalDomainDTO.getEswFetchDate());
			retrieveSelInventoryDetailInputConnectorDTO.setLastFetchTime(proposalDomainDTO.getEswFetchTime());
		} else {
			retrieveSelInventoryDetailInputConnectorDTO.setLastFetchDate(null);
			retrieveSelInventoryDetailInputConnectorDTO.setLastFetchTime(null);
			
		}

		retrieveSelInventoryDetailInputConnectorDTO.setCurrency(proposalDomainDTO.getCurrency());
		retrieveSelInventoryDetailInputConnectorDTO.setContractEndPeriod(proposalDomainDTO.getContrEndPeriod());
		/* Only for Replaced / Renewed proposals excon needs to be sent
		if (proposalDomainDTO.getExtContrNo() != null && !(proposalDomainDTO.getExtContrNo().equals(""))) {
			retrieveInventoryDetailInputConnectorDTO.setContractNumber(proposalDomainDTO.getExtContrNo());
			OPPTLogger.debug("External Contr No" + proposalDomainDTO.getExtContrNo(), CLASS_NAME, methodName);
		} else {
			retrieveInventoryDetailInputConnectorDTO.setContractNumber(proposalDomainDTO.getContrNo());
			OPPTLogger.debug("Contr No" + proposalDomainDTO.getContrNo(), CLASS_NAME, methodName);
		}
		*/
		if (oldExtrContrNo != null && !oldExtrContrNo.equals("")) {
			retrieveSelInventoryDetailInputConnectorDTO.setContractNumber(oldExtrContrNo);
		}
		retrieveSelInventoryDetailInputConnectorDTO.setContractStartPeriod(proposalDomainDTO.getContrStartPeriod());
		retrieveSelInventoryDetailInputConnectorDTO.setContractType(proposalDomainDTO.getContrType());
		retrieveSelInventoryDetailInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		retrieveSelInventoryDetailInputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);

		// SAND S
		retrieveSelInventoryDetailInputConnectorDTO.setProposalContent(proposalDomainDTO.getProposalContent());
		retrieveSelInventoryDetailInputConnectorDTO.setDesignatedMachineID(dto.getDesignatedMachineID());
		retrieveSelInventoryDetailInputConnectorDTO.setMaterialID(dto.getMaterialID());
		
		return retrieveSelInventoryDetailInputConnectorDTO;
		
		
	}
	

	/**
	 *  
	 * This method populates the Ineligible inventory detail input connector dto
	 * Required parameter  
	 *
	 * 	1. Function module
	 * 	2. Flag (C)
	 * 	3. Session Id					CHARACTER(44)
	 *	4. User Id						CHARACTER(31)
	 *	5. Sales org					CHARACTER(4)
	 *	6. Distr channel					CHARACTER(2)
	 *	7. Division						CHARACTER(2)
	 * 	8. Proposal type					CHARACTER(2)
	 * 	9. Document category				CHARACTER(1)
	 *	10. Currency code				CURR(5)
	 *	11. Contract start date				DATE(8)
	 *	12. Contract end date				DATE(8)
	 *	13. Last fetch date - Flag (00000000)	CHARACTER(8)
	 *	14. Last fetch time - Flag (000000)	CHARACTER(6)	
	 *	15. Cntr type					CHARACTER(1)
	 *	16. Old ext cntr number / cntr number 
	 *	(For replace and renew)			CHARACTER(10)
	 *	17. Customer nos				CHARACTER(10) 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ineligibleLicensesCustomDTO
	 * @param proposalDomainDTO
	 * @return
	 * @throws Exception
	 * @author Ravishankar
	 */
	public static RetrieveIneligInvenDetailInputConnectorDTO buildRetrieveIneligInvenDetailInputConnectorDTO(ProposalDomainDTO proposalDomainDTO, String sessionId, String userId, List custList, String oldExtrContrNo) throws Exception {
		String methodName = "RetrieveIneligInvenDetailInputConnectorDTO";
		RetrieveIneligInvenDetailInputConnectorDTO retrieveIneligbInventoryDetailInputConnectorDTO = null;
		RetrieveInvenConnectorDTO retrieveInvenConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;
		OrgConnectorDTO orgConnectorDTO = null;

		retrieveIneligbInventoryDetailInputConnectorDTO = new RetrieveIneligInvenDetailInputConnectorDTO();
		genericConnectorDTO = new GenericConnectorDTO();
		orgConnectorDTO = new OrgConnectorDTO();
		retrieveInvenConnectorDTO = new RetrieveInvenConnectorDTO();

		//set the generic values "Z_WV_INELIG_DETAIL_OPPT"
		if (proposalDomainDTO.getStatusCode() != null && ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT.equals(proposalDomainDTO.getStatusCode())) {
			genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_INELIG_DELTA_OPPT);
		} else {
			genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_INELIG_DETAIL_OPPT);
		}
		genericConnectorDTO.setSessionID(sessionId);
		genericConnectorDTO.setUserID(userId);

		// set the values for Organization connector
		orgConnectorDTO.setDistributionChannel(proposalDomainDTO.getDistrChannel());
		//These commented code values not required for this RFC
		//orgConnectorDTO.setSalesGroup(proposalDomainDTO.getSalesGroup());
		//orgConnectorDTO.setChannelRole(proposalDomainDTO.getChannelRole());
		//orgConnectorDTO.setSubmitterRole(proposalDomainDTO.getSubmitterRole());
		orgConnectorDTO.setDivision(proposalDomainDTO.getDivisionCode());
		orgConnectorDTO.setSalesOrg(proposalDomainDTO.getSalesOrg());

		// set the retrieve inventory connector dto
		retrieveInvenConnectorDTO.setContractStartDate(proposalDomainDTO.getContrStartPeriod());
		retrieveInvenConnectorDTO.setContractEndDate(proposalDomainDTO.getContrEndPeriod());
		retrieveInvenConnectorDTO.setCurrency(proposalDomainDTO.getCurrency());
		retrieveInvenConnectorDTO.setProposalType(proposalDomainDTO.getProposalType());

		//set the values for retrieve ineligible connector dto
		/* Only for Replaced / Renewed / Amended proposals excon needs to be sent 
		if (proposalDomainDTO.getExtContrNo() != null && !(proposalDomainDTO.getExtContrNo().equals(""))) {
			retrieveIneligbInventoryDetailInputConnectorDTO.setContractNumber(proposalDomainDTO.getExtContrNo());
			OPPTLogger.debug("External Contr No" + proposalDomainDTO.getExtContrNo(), CLASS_NAME, methodName);
		} else {
			retrieveIneligbInventoryDetailInputConnectorDTO.setContractNumber(proposalDomainDTO.getContrNo());
			OPPTLogger.debug("Contr No" + proposalDomainDTO.getContrNo(), CLASS_NAME, methodName);
		}
		*/
		if (oldExtrContrNo != null && !oldExtrContrNo.equals("")) {
			retrieveIneligbInventoryDetailInputConnectorDTO.setContractNumber(oldExtrContrNo);
		}
		retrieveIneligbInventoryDetailInputConnectorDTO.setContractType(proposalDomainDTO.getContrType());
		if (proposalDomainDTO.getStatusCode() != null && ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT.equals(proposalDomainDTO.getStatusCode())) {
			retrieveInvenConnectorDTO.setDocumentCategory("D");
		} else {
			retrieveInvenConnectorDTO.setDocumentCategory("C");
		}
		retrieveIneligbInventoryDetailInputConnectorDTO.setLastFetchDate(null);
		retrieveIneligbInventoryDetailInputConnectorDTO.setLastFetchTime(null);

		retrieveIneligbInventoryDetailInputConnectorDTO.setCustomerNumber(custList);
		retrieveIneligbInventoryDetailInputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
		retrieveIneligbInventoryDetailInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		retrieveIneligbInventoryDetailInputConnectorDTO.setRetrieveInvenConnectorDTO(retrieveInvenConnectorDTO);
		retrieveIneligbInventoryDetailInputConnectorDTO.setProposalContent(proposalDomainDTO.getProposalContent());

		return retrieveIneligbInventoryDetailInputConnectorDTO;
	}

	/**
	 *  
	 * This method populates the Ineligible inventory detail input connector dto
	 * Required parameter  
	 *
	 * 	1. Function module
	 * 	2. Flag (C)
	 * 	3. Session Id					CHARACTER(44)
	 *	4. User Id						CHARACTER(31)
	 *	5. Sales org					CHARACTER(4)
	 *	6. Distr channel					CHARACTER(2)
	 *	7. Division						CHARACTER(2)
	 * 	8. Proposal type					CHARACTER(2)
	 * 	9. Document category				CHARACTER(1)
	 *	10. Currency code				CURR(5)
	 *	11. Contract start date				DATE(8)
	 *	12. Contract end date				DATE(8)
	 *	13. Old ext cntr number / cntr number	CHARACTER(10)
	 *	14. Customer nos				CHARACTER(10) 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ineligibleLicensesCustomDTO
	 * @param proposalDomainDTO
	 * @return
	 * @throws Exception
	 * @author Ravishankar
	 */
	public static RetrieveIneligDeltaInvenInputConnectorDTO buildRetrieveIneligDeltaInvenInputConnectorDTO(ProposalDomainDTO proposalDomainDTO, String sessionId, String userId, List custList, String oldExtrContrNo) throws Exception {

		String methodName = "buildRetrieveIneligDeltaInvenInputConnectorDTO";
		RetrieveIneligDeltaInvenInputConnectorDTO retrieveIneligDeltaInvenInputConnectorDTO = null;
		RetrieveInvenConnectorDTO retrieveInvenConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;
		OrgConnectorDTO orgConnectorDTO = null;

		retrieveIneligDeltaInvenInputConnectorDTO = new RetrieveIneligDeltaInvenInputConnectorDTO();
		genericConnectorDTO = new GenericConnectorDTO();
		orgConnectorDTO = new OrgConnectorDTO();
		retrieveInvenConnectorDTO = new RetrieveInvenConnectorDTO();

		//set the generic values "Z_WV_INELIG_DELTA_OPPT"
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_INELIG_DELTA_OPPT);
		genericConnectorDTO.setSessionID(sessionId);
		genericConnectorDTO.setUserID(userId);

		// set the values for Organization connector
		orgConnectorDTO.setDistributionChannel(proposalDomainDTO.getDistrChannel());
		//These commented code values not required for this RFC
		//orgConnectorDTO.setSalesGroup(proposalDomainDTO.getSalesGroup());
		//orgConnectorDTO.setChannelRole(proposalDomainDTO.getChannelRole());
		//orgConnectorDTO.setSubmitterRole(proposalDomainDTO.getSubmitterRole());
		orgConnectorDTO.setDivision(proposalDomainDTO.getDivisionCode());
		orgConnectorDTO.setSalesOrg(proposalDomainDTO.getSalesOrg());

		// set the retrieve inventory connector dto
		retrieveInvenConnectorDTO.setContractStartDate(proposalDomainDTO.getContrStartDate());
		retrieveInvenConnectorDTO.setContractEndDate(proposalDomainDTO.getContrEndDate());
		retrieveInvenConnectorDTO.setCurrency(proposalDomainDTO.getCurrency());
		retrieveInvenConnectorDTO.setProposalType(proposalDomainDTO.getProposalType());

		//set the values for retrieve ineligible connector dto
		if (proposalDomainDTO.getExtContrNo() != null && !(proposalDomainDTO.getExtContrNo().equals(""))) {
			retrieveIneligDeltaInvenInputConnectorDTO.setContractNumber(proposalDomainDTO.getExtContrNo());
			OPPTLogger.debug("External Contr No" + proposalDomainDTO.getExtContrNo(), CLASS_NAME, methodName);
		} else {
			retrieveIneligDeltaInvenInputConnectorDTO.setContractNumber(proposalDomainDTO.getContrNo());
			OPPTLogger.debug("Contr No" + proposalDomainDTO.getContrNo(), CLASS_NAME, methodName);
		}
		if (oldExtrContrNo != null && !oldExtrContrNo.equals("")) {
			retrieveIneligDeltaInvenInputConnectorDTO.setContractNumber(oldExtrContrNo);
		}

		retrieveInvenConnectorDTO.setDocumentCategory("D");
		retrieveIneligDeltaInvenInputConnectorDTO.setCustomerNumber(custList);
		retrieveIneligDeltaInvenInputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
		retrieveIneligDeltaInvenInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		retrieveIneligDeltaInvenInputConnectorDTO.setRetrieveInvenConnectorDTO(retrieveInvenConnectorDTO);
		retrieveIneligDeltaInvenInputConnectorDTO.setProposalContent(proposalDomainDTO.getProposalContent());

		return retrieveIneligDeltaInvenInputConnectorDTO;
	}

	/**
	 *  
	 * This method populates the delta fetch inventory input connector dtos 
	 * Required parameter 
	 * 
	 *	1. Function module
	 *	2. Session Id						CHARACTER(44)
	 *	3. User Id							CHARACTER(31)
	 *	4. Sales org						CHARACTER(4)
	 *	5. Distr channel						CHARACTER(2)
	 *	6. Division code						CHARACTER(2)
	 *	7. Proposal type						CHARACTER(2)
	 *	8. Sales document category - D			CHARACTER(1)	
	 *	9. Currency							CHARACTER(5)
	 *	10. Cntr start period					DATE(8)
	 *	11. Cntr end period					DATE(8)
	 *	12. External cntr Number / Cntr number		CHARACTER(10)
	 *	13. Old cntr number					CHARACTER(10)
	 *	14. All customer no's for the proposal from 
	 *	Sold to party table 
	 *	(Field : SAP_Sold_To_P_No)*			CHARACTER(10) 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 * @param sessionId
	 * @param userId
	 * @param customerNoList
	 * @return
	 * @throws Exception
	 * @author Ravishankar
	 */
	public static RetrieveDeltaInventoryInputConnectorDTO buildRetrieveDeltaInventoryInputConnectorDTO(ProposalDomainDTO proposalDomainDTO, String sessionId, String userId, List customerNoList) throws Exception {
		RetrieveDeltaInventoryInputConnectorDTO retrieveDeltaInventoryInputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;
		OrgConnectorDTO orgConnectorDTO = null;
		RetrieveInvenConnectorDTO retrieveInvenConnectorDTO = null;

		genericConnectorDTO = new GenericConnectorDTO();
		orgConnectorDTO = new OrgConnectorDTO();
		retrieveInvenConnectorDTO = new RetrieveInvenConnectorDTO();
		retrieveDeltaInventoryInputConnectorDTO = new RetrieveDeltaInventoryInputConnectorDTO();

		//set the generic connector values
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_DELTA_OPPT);
		genericConnectorDTO.setSessionID(sessionId);
		genericConnectorDTO.setUserID(userId);

		// set the organization connector dto values
		orgConnectorDTO.setDistributionChannel(proposalDomainDTO.getDistrChannel());
		//These commented code values not required for this RFC
		//orgConnectorDTO.setSalesGroup(proposalDomainDTO.getSalesGroup());
		//orgConnectorDTO.setChannelRole(proposalDomainDTO.getChannelRole());
		//orgConnectorDTO.setSubmitterRole(proposalDomainDTO.getSubmitterRole());
		orgConnectorDTO.setDivision(proposalDomainDTO.getDivisionCode());
		orgConnectorDTO.setSalesOrg(proposalDomainDTO.getSalesOrg());

		retrieveInvenConnectorDTO.setContractStartDate(proposalDomainDTO.getContrStartPeriod());
		retrieveInvenConnectorDTO.setContractEndDate(proposalDomainDTO.getContrEndPeriod());
		retrieveInvenConnectorDTO.setCurrency(proposalDomainDTO.getCurrency());
		retrieveInvenConnectorDTO.setProposalType(proposalDomainDTO.getProposalType());
		retrieveInvenConnectorDTO.setDocumentCategory("D");
		retrieveDeltaInventoryInputConnectorDTO.setContractNumber(proposalDomainDTO.getContrNo());
		retrieveDeltaInventoryInputConnectorDTO.setCustomerNumberList(customerNoList);
		retrieveDeltaInventoryInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		retrieveDeltaInventoryInputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
		retrieveDeltaInventoryInputConnectorDTO.setRetrieveInvenConnectorDTO(retrieveInvenConnectorDTO);
		// S and S
		retrieveDeltaInventoryInputConnectorDTO.setProposalContent(proposalDomainDTO.getProposalContent());

		return retrieveDeltaInventoryInputConnectorDTO;
	}

	/**
	 * To get the ValidateHeaderDataInputConnectorDTO 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 14, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param amendContractCustomDTO
	 * @return ValidateHeaderDataInputConnectorDTO
	 * @author Muruganantham Mani
	 */
	public static ValidateHeaderDataInputConnectorDTO buildValidateHeaderDataInputConnectorDTO(AmendContractCustomDTO amendContractCustomDTO) {
		BasicProposalCustomDTO basicProposalDTO = amendContractCustomDTO.getBasicProposalCustomDTO();
		ContractCustomDTO contractDTO = amendContractCustomDTO.getContract();

		ValidateHeaderDataInputConnectorDTO dto = new ValidateHeaderDataInputConnectorDTO();

		GenericConnectorDTO genericConnectorDTO = getGenericConnectorDTO(ConnectorConstants.RFC_VALIDATE_HEADER_DATA_OPPT, amendContractCustomDTO.getSessionId(), amendContractCustomDTO.getUserId());
		dto.setGenericConnectorDTO(genericConnectorDTO);

		OrgConnectorDTO orgConnectorDTO = getOrgConnectorDTO(amendContractCustomDTO.getPrimarySalesOrg(), basicProposalDTO.getDistributionChannel(), basicProposalDTO.getSalesGroup(),  basicProposalDTO.getDivision());
		dto.setOrgConnectorDTO(orgConnectorDTO);
		dto.setProposalType(basicProposalDTO.getProposalType());
		dto.setContractNumber(contractDTO.getContractNumber());

		return dto;
	}

	/** 
	 * To get the Org ConnectorDTO
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 14, 2004 
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
	private static OrgConnectorDTO getOrgConnectorDTO(String salesOrg, String distributionChannel, String salesGroup,  String division) {
		OrgConnectorDTO dto = new OrgConnectorDTO();
		dto.setDistributionChannel(distributionChannel);
		dto.setSalesGroup(salesGroup);
		//dto.setChannelRole(channelRole);
		//dto.setSubmitterRole(submitterRole);
		dto.setDivision(division);
		dto.setSalesOrg(salesOrg);

		return dto;
	}

	/** 
	 * To get the generic ConnectorDTO
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 14, 2004 
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
	 *  
	 * This method populates the delta fetch inventory input connector dtos 
	 * Required parameter 
	 * 
	 *Input Parameters :-
	 *	1. Function Module													CHARACTER(30)
	 *	2. Session Id														CHARACTER(26)
	 *	3. User Id															CHARACTER(31)
	 *	4. External Contract number											CHARACTER(10)
	 *	5. Flag (RUN/REPL/RENW/RECL/CLSD/EXTN)								CHARACTER(4)
	 *	6. Counter (Amendment -	Amendment counter, Replacement -
	 *		Replace counter, Renewal - RenewalCounter).						CHARACTER(2)
	 *	7. Variance counter													CHARACTER(2) 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 * @param proposalBO
	 * @param oldExternalContractNumber	 
	 * @return StatusCheckInputCOnnectorDTO
	 * @throws Exception
	 * @author Prakash
	 */

	public static StatusCheckInputConnectorDTO buildStatusCheckInputConnectorDTO(ProposalDomainDTO proposalDTO, ProposalCustomDTO proposalCustomDTO, String oldExternalContractNumber) {

		String counter = null;
		StatusCheckInputConnectorDTO statusCheckInputConnectorDTO = new StatusCheckInputConnectorDTO();
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();

		// building GenericConnectorDTO
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_STATUS_CHECK_OPPT);
		genericConnectorDTO.setSessionID(proposalCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(proposalCustomDTO.getUserId());

		statusCheckInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);

		OPPTLogger.debug("Proposal Contract Status is #" + proposalDTO.getStatusCode() + "#", CLASS_NAME, "buildStatusCheckInputConnectorDTO");
		OPPTLogger.debug("Contract Type is #" + proposalDTO.getContrType() + "#", CLASS_NAME, "buildStatusCheckInputConnectorDTO");
		OPPTLogger.debug("Old External Contract Number is #" + oldExternalContractNumber + "#", CLASS_NAME, "buildStatusCheckInputConnectorDTO");
		OPPTLogger.debug("[ProposalDTO] External Contract Number is #" + proposalDTO.getExtContrNo() + "#", CLASS_NAME, "buildStatusCheckInputConnectorDTO");
		OPPTLogger.debug("[ProposalDTO] Old Contract Number is #" + proposalDTO.getOldContrNo() + "#", CLASS_NAME, "buildStatusCheckInputConnectorDTO");

		if (ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS.equals(proposalDTO.getStatusCode().trim())) {
			if (ContractTypeConstants.ORIGINAL.equals(proposalDTO.getContrType().trim()) || ContractTypeConstants.VARIANCE.equals(proposalDTO.getContrType().trim())) {
				statusCheckInputConnectorDTO.setFlag(UtilityConstants.ESW_STATUS_RUN);
				if (null != proposalDTO.getExtContrNo() && proposalDTO.getExtContrNo().length() > 0) {
					statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getExtContrNo());
				} else {
					statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getContrNo());
				}
				statusCheckInputConnectorDTO.setCounter(counter);
				if (ContractTypeConstants.VARIANCE.equals(proposalDTO.getContrType().trim())) {
					//statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getOrgVarContrNo());
					statusCheckInputConnectorDTO.setVarianceCounter(String.valueOf(proposalDTO.getContrPeriodVarNo()));

				}
			} else {
				if (ContractTypeConstants.REPLACEMENT.equals(proposalDTO.getContrType().trim())) {
					statusCheckInputConnectorDTO.setFlag(UtilityConstants.ESW_STATUS_REPL);
					if (null == oldExternalContractNumber) {
						statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getOldContrNo());
						statusCheckInputConnectorDTO.setCounter(counter);
					} else {
						//MN 22282768 - Balaji - Defect 62
						if (!oldExternalContractNumber.equalsIgnoreCase(OPPTHelper.trimString(proposalDTO.getExtContrNo()))) {
							// If ext_cntr_number != old ext_cntr_number, Assign counter as empty string and old ext_cntr_number as ext_cntr_number
							statusCheckInputConnectorDTO.setExternalContractNumber(oldExternalContractNumber);
							statusCheckInputConnectorDTO.setCounter(counter);
						} else {
							// ext_cntr_number = old ext_cntr_number, so assign Repl no count as counter 
							statusCheckInputConnectorDTO.setExternalContractNumber(oldExternalContractNumber);
							statusCheckInputConnectorDTO.setCounter(String.valueOf((int) proposalDTO.getContrReplNo()));
						}
					}
				} else {
					if (ContractTypeConstants.RENEWAL.equals(proposalDTO.getContrType().trim())) {
						statusCheckInputConnectorDTO.setFlag(UtilityConstants.ESW_STATUS_RENW);
						// Old ext_cntr_number is not null, Assign old ext_cntr_number as ext_cntr_number and counter as empty string

						if (null != oldExternalContractNumber) {
							statusCheckInputConnectorDTO.setExternalContractNumber(oldExternalContractNumber);
							if (null != proposalDTO.getExtContrNo()) {
								if (!proposalDTO.getExtContrNo().trim().equalsIgnoreCase(oldExternalContractNumber)) {
									statusCheckInputConnectorDTO.setCounter(counter);
								} else {
									statusCheckInputConnectorDTO.setCounter(String.valueOf((int) proposalDTO.getContrRenewNo()));
								}
							}
						} else {
							// old ext_cntr_number is null, assign old cntr number as ext cntr number and counter as empty string
							statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getOldContrNo());
							statusCheckInputConnectorDTO.setCounter(counter);
						}
					}
				}
			}

		} else {
			if (ProposalContractStatusConstants.CHECK_AMENDED_CONTRACT_STATUS.equals(proposalDTO.getStatusCode().trim())) {
				statusCheckInputConnectorDTO.setFlag(UtilityConstants.ESW_STATUS_RECL);
				if (null == oldExternalContractNumber) {
					// old ext_cntr_number is null, assign old cntr number as ext cntr number and counter as empty string
					statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getOldContrNo());
					statusCheckInputConnectorDTO.setCounter(null);
				} else {
					// If ext_cntr_number != old ext_cntr_number
					//	MN 22282768 - Balaji - Defect 62
					if (!oldExternalContractNumber.equalsIgnoreCase(OPPTHelper.trimString(proposalDTO.getExtContrNo()))) {
						statusCheckInputConnectorDTO.setExternalContractNumber(oldExternalContractNumber);
						statusCheckInputConnectorDTO.setCounter(null);
					} else {
						statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getExtContrNo());
						statusCheckInputConnectorDTO.setCounter(String.valueOf((int) proposalDTO.getContrAmendNo()));
					}
				}
			} else {
				if (ProposalContractStatusConstants.CHECK_CLOSURE_STATUS.equals(proposalDTO.getStatusCode().trim())) {
					statusCheckInputConnectorDTO.setFlag(UtilityConstants.ESW_STATUS_CLSD);
					statusCheckInputConnectorDTO.setCounter(counter);

					// If ext_cntr_number is null, assign cntr number as ext_cntr_number
					if (null != proposalDTO.getExtContrNo() && proposalDTO.getExtContrNo().length() > 0) {
						statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getExtContrNo());
					} else {
						statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getContrNo());
					}

					if (ContractTypeConstants.VARIANCE.equals(proposalDTO.getContrType().trim())) {
						//statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getOrgVarContrNo());
						statusCheckInputConnectorDTO.setVarianceCounter(String.valueOf(proposalDTO.getContrPeriodVarNo()));

					}
				} else {
					if (ProposalContractStatusConstants.CHECK_EXTENSION_STATUS.equals(proposalDTO.getStatusCode().trim())) {
						statusCheckInputConnectorDTO.setFlag(UtilityConstants.ESW_STATUS_EXTN);
						statusCheckInputConnectorDTO.setCounter(counter);

						// If ext_cntr_number is null, assign cntr number as ext_cntr_number
						if (null != proposalDTO.getExtContrNo() && proposalDTO.getExtContrNo().length() > 0) {
							statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getExtContrNo());
						} else {
							statusCheckInputConnectorDTO.setExternalContractNumber(proposalDTO.getContrNo());
						}
					}
				}
			}
		}

		OPPTLogger.debug("[StatusCheckInputConnectorDTO] External Contract Number is #" + statusCheckInputConnectorDTO.getExternalContractNumber() + "#", CLASS_NAME, "buildStatusCheckInputConnectorDTO");
		OPPTLogger.debug("[StatusCheckInputConnectorDTO] Counter value is #" + statusCheckInputConnectorDTO.getCounter() + "#", CLASS_NAME, "buildStatusCheckInputConnectorDTO");

		return statusCheckInputConnectorDTO;
	}

	/**
	 *  
	 * This method builds the  RetrieveInvenConfigInputConnectorDTO
	 * During the configure dm process
	 * 
	 * Required parameters are
	 *1. Function module						CHARACTER(30)
	 *2. Session Id							CHARACTER(26)
	 *3. User Id								CHARACTER(31)
	 *4. Flag (A)								CHARACTER(1)
	 *5. Length of the data (Length of all data below)
	 *6. Sales doc no*							CHARACTER(10)
	 *7. SWO Item no*							CHARACTER(6)
	 *8. EE Item no*							CHARACTER(6)
	 *9. Value metric*							CHARACTER(6)
	 *10. License type*							CHARACTER(12)
	 *11. Charge option*						CHARACTER(12) 
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
	 * @param sessionId
	 * @param userId
	 * @param eeCustomDTOList
	 * @return
	 * @throws Exception
	 */
	public static RetrieveInvenConfigInputConnectorDTO buildRetrieveInvenConfigInputConnectorDTO(ConfigureDMCustomDTO configureDMCustomDTO, String swoItemNo, ConfigureDMEECustomDTO configureDMEECustomDTO) {
		RetrieveInvenConfigInputConnectorDTO retrieveInvenConfigInputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;
		RetrieveConfigConnectorDTO retrieveConfigConnectorDTO = null;
		List retrieveConfigConnectorDTOList = null;

		retrieveInvenConfigInputConnectorDTO = new RetrieveInvenConfigInputConnectorDTO();
		genericConnectorDTO = new GenericConnectorDTO();
		retrieveConfigConnectorDTOList = new ArrayList();

		//set the generic connector values
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_CONFIG_OPPT);
		genericConnectorDTO.setSessionID(configureDMCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(configureDMCustomDTO.getUserId());
		// retrieve the values and set it to connector dtos
		if (configureDMEECustomDTO != null) {
			retrieveConfigConnectorDTO = new RetrieveConfigConnectorDTO();
			retrieveConfigConnectorDTO.setSalesDocNo(configureDMEECustomDTO.getSalesDocNumber());
			retrieveConfigConnectorDTO.setEeItemNo(configureDMEECustomDTO.getEeItemNumber());
			retrieveConfigConnectorDTO.setSwoItemNo(swoItemNo);
			retrieveInvenConfigInputConnectorDTO.setFlag('A');
			if (configureDMCustomDTO.isConfigChange()) {
				if (configureDMCustomDTO.isVmChanged()) {
					retrieveInvenConfigInputConnectorDTO.setFlag('B');
					retrieveConfigConnectorDTO.setValueMetric(configureDMCustomDTO.getSelectedValueMetricDescription());
				}
				if (configureDMCustomDTO.isLicenseTypeChaged()) {
					retrieveInvenConfigInputConnectorDTO.setFlag('C');
					retrieveConfigConnectorDTO.setLicenseType(configureDMCustomDTO.getSelectedLicenseType());		
				}
				if (configureDMCustomDTO.isChoChanged()) {
					retrieveInvenConfigInputConnectorDTO.setFlag('D');
					retrieveConfigConnectorDTO.setChargeOption(configureDMCustomDTO.getSelectedChargeOption());
				}
			
			} else {
				retrieveConfigConnectorDTO.setChargeOption(configureDMEECustomDTO.getChargeOption());
				retrieveConfigConnectorDTO.setValueMetric(configureDMEECustomDTO.getValueMetricDescription());
				retrieveConfigConnectorDTO.setLicenseType(configureDMEECustomDTO.getLicenseType());
			}
			retrieveConfigConnectorDTOList.add(retrieveConfigConnectorDTO);
		}
		retrieveInvenConfigInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		retrieveInvenConfigInputConnectorDTO.setRetrieveConfigConnectorDTOList(retrieveConfigConnectorDTOList);

	return retrieveInvenConfigInputConnectorDTO;
	}

	/**
	 *  
	 * This method builds validate config input connector dtos
	 * Required parameters are
	 * 
	 *1. Function module						CHARACTER(30)
	 *2. Session Id							CHARACTER(26)
	 *3. User Id								CHARACTER(31)
	 *4. Length of the data (Length of all data below)
	 *5. EE Sales doc no*						CHARACTER(10)	
	 *6. SWO Item no*							CHARACTER(6)
	 *7. EE Item no*							CHARACTER(6)
	 *8 VM*								CHARACTER(6)
	 *9. LCS*								CHARACTER(12)
	 *10. CHO*								CHARACTER(12)
	 *11. Valuemetric_type*						CHARACTER(1)
	 *12. UL*								CHARACTER(12) 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionId
	 * @param userId
	 * @param configureDMSWOCustomDTO
	 * @return
	 * @throws Exception
	 */
	public static ValidateInvenConfigInputConnectorDTO buildValidateInvenConfigInputConnectorDTO(ConfigureDMCustomDTO configureDMCustomDTO,TempEEDomainDTO tempEEDomainDTO)throws ServiceException{
		GenericConnectorDTO genericConnectorDTO = null;
		ValidateInvenConfigInputConnectorDTO validateInvenConfigInputConnectorDTO = null;
		ValidateConfigConnectorDTO validateConfigConnectorDTO = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO=null;
		List validateConfigConnectorDTOList = null;
		boolean isCopy=false;

		validateInvenConfigInputConnectorDTO = new ValidateInvenConfigInputConnectorDTO();
		genericConnectorDTO = new GenericConnectorDTO();
		validateConfigConnectorDTOList = new ArrayList();

		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_VALIDATE_CONFIG_OPPT);
		genericConnectorDTO.setSessionID(configureDMCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(configureDMCustomDTO.getUserId());

	for(int j=0;j<configureDMCustomDTO.getSwos().size();j++){ 	
		  configureDMSWOCustomDTO=(ConfigureDMSWOCustomDTO)configureDMCustomDTO.getSwos().get(j);			
		for (int i = 0; i < configureDMSWOCustomDTO.getEes().size(); i++) {
			configureDMEECustomDTO = (ConfigureDMEECustomDTO) configureDMSWOCustomDTO.getEes().get(i);
			// retrieve the values and set it to connector dtos
			if(configureDMEECustomDTO.isCopiedEE()){
				validateConfigConnectorDTO = new ValidateConfigConnectorDTO();
				isCopy=true;
				validateConfigConnectorDTO.setEeSalesDocNo(configureDMEECustomDTO.getSalesDocNumber());
				//validateConfigConnectorDTO.setChargeOption(configureDMEECustomDTO.getChargeOption());
				validateConfigConnectorDTO.setEeItemNo(configureDMEECustomDTO.getEeItemNumber());
				validateConfigConnectorDTO.setSwoItemNo(configureDMSWOCustomDTO.getSwoItemNumber());
				//validateConfigConnectorDTO.setValueMetric(configureDMEECustomDTO.getValueMetricDescription());
				//validateConfigConnectorDTO.setValueMetricType(configureDMEECustomDTO.getValueMetric());
				//validateConfigConnectorDTO.setLicenseType(configureDMEECustomDTO.getLicenseType());
				//validateConfigConnectorDTO.setUseLevel(configureDMEECustomDTO.getUseLevel());
				validateConfigConnectorDTO.setValueMetric(tempEEDomainDTO.getVm());
				validateConfigConnectorDTO.setValueMetricType(tempEEDomainDTO.getValueMetricType());
				validateConfigConnectorDTO.setLicenseType(tempEEDomainDTO.getLcs());
				validateConfigConnectorDTO.setUseLevel(tempEEDomainDTO.getUl());
				validateConfigConnectorDTO.setChargeOption(tempEEDomainDTO.getCho());
				validateConfigConnectorDTOList.add(validateConfigConnectorDTO);
			}	
		 }
	    }
	    
		validateInvenConfigInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		validateInvenConfigInputConnectorDTO.setValidateConfigConnectorDTOList(validateConfigConnectorDTOList);
		if(!isCopy){
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0136);
		}
			
		return validateInvenConfigInputConnectorDTO;
	}

	/**
	 *  
	 * This method builds the Price Inquiry Input connector dtos 
	 * Required parameters are 
	 *1. Function module.
	 *2. Session Id						CHARACTER(44)
	 *3. User Id							CHARACTER(31)	
	 *4. Sales Org 						CHARACTER(4)	
	 *5. Dstr channel						CHARACTER(2)
	 *6. Division							CHARACTER(2)
	 *7. Customer number					CHARACTER(10)
	 *8. Bump date						DATE(8)
	 *Datatype and length same as above RFC
	 *9. Length of the data (Length of all data below)
	 *10. Sales Doc no
	 *11. SWO Item no
	 *12. EE Item No	
	 *13. VM
	 *14. UL
	 *15. LCS
	 *16. CHO 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 * @param TempEEDomainDTO
	 * @param customerNo
	 * @param configureDMCustomDTO
	 * @return
	 * @throws Exception
	 */
	public static PriceInquiryInputConnectorDTO buildPriceInquiryInputConnectorDTO(TempEEDomainDTO tempEEDomainDTO, ProposalDomainDTO proposalDomainDTO, ConfigureDMCustomDTO configureDMCustomDTO) throws Exception {
		PriceInquiryInputConnectorDTO priceInquiryInputConnectorDTO = null;
		OrgConnectorDTO orgConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = null;

		priceInquiryInputConnectorDTO = new PriceInquiryInputConnectorDTO();
		orgConnectorDTO = new OrgConnectorDTO();
		genericConnectorDTO = new GenericConnectorDTO();

		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_PRICE_INQUIRY_OPPT);
		genericConnectorDTO.setSessionID(configureDMCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(configureDMCustomDTO.getUserId());

		orgConnectorDTO.setDistributionChannel(proposalDomainDTO.getDistrChannel());
		//These commented code values not required for this RFC
		//orgConnectorDTO.setSalesGroup(proposalDomainDTO.getSalesGroup());
		//orgConnectorDTO.setChannelRole(proposalDomainDTO.getChannelRole());
		//orgConnectorDTO.setSubmitterRole(proposalDomainDTO.getSubmitterRole());
		orgConnectorDTO.setDivision(proposalDomainDTO.getDivisionCode());
		orgConnectorDTO.setSalesOrg(proposalDomainDTO.getSalesOrg());

		priceInquiryInputConnectorDTO.setBumpDate(configureDMCustomDTO.getBumpPlanStartDate());
		priceInquiryInputConnectorDTO.setCustomerNumber(proposalDomainDTO.getRegCustomerNo());
		priceInquiryInputConnectorDTO.setSalesDocNo(tempEEDomainDTO.getSalesDocNo());
		priceInquiryInputConnectorDTO.setSwoItemNo(tempEEDomainDTO.getSwoItemNo());
		priceInquiryInputConnectorDTO.setEeItemNo(tempEEDomainDTO.getEeItemNo());
		priceInquiryInputConnectorDTO.setValueMetric(tempEEDomainDTO.getVm());
		priceInquiryInputConnectorDTO.setUseLevel(tempEEDomainDTO.getUl());
		priceInquiryInputConnectorDTO.setLicenseType(tempEEDomainDTO.getLcs());
		priceInquiryInputConnectorDTO.setChargeOption(tempEEDomainDTO.getCho());
		priceInquiryInputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
		priceInquiryInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);

		return priceInquiryInputConnectorDTO;
	}

	/**
	 *  
	 * This method populates the delta fetch inventory input connector dtos 
	 * Required parameter 
	 * 
	 *Z_WV_VALIDATE_USER_ACCESS_OPPT
	 *Input Parameters :
	 *1. Function module					CHARACTER(30)
	 *2. Session Id						CHARACTER(26)
	 *3. Created by						CHARACTER(31)
	 *4. User Id							CHARACTER(31)
	 *5. Sales org						CHARACTER(4)
	 *6. Dstr channel						CHARACTER(2)
	 *7. Division							CHARACTER(2)
	 *8. Proposal type						CHARACTER(2)
	 *9. BTP No							CHARACTER(10)
	 *10. Payer No						CHARACTER(10)
	 *11. Ship To Party No					CHARACTER(10)
	 *12. Sap Sold To P No (From Soldtoparty Table)*							CHARACTER(10)
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 * @param proposalBO
	 * @param oldExternalContractNumber	 
	 * @return StatusCheckInputCOnnectorDTO
	 * @throws Exception
	 * @author Prakash
	 */

	public static ValidateUserAccessInputConnectorDTO buildValidateUserAccessInputConnectorDTO(ProposalDomainDTO proposalDomainDTO, RegistrationCustomDTO registrationCustomDTO, List customerDomainDTOList) {
		return buildValidateUserAccessInputConnectorDTO(proposalDomainDTO, registrationCustomDTO.getSessionId(), registrationCustomDTO.getSelectedApproverId(), customerDomainDTOList);
	}
	
	/**
	 *  buildValidateUserAccessInputConnectorDTO
	 * This method populates the delta fetch inventory input connector dtos 
	 * Required parameter 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 * @param sessionId
	 * @param userId
	 * @param customerDomainDTOList	 
	 * @return ValidateUserAccessInputConnectorDTO
	 * @author Prakash
	 */
	public static ValidateUserAccessInputConnectorDTO buildValidateUserAccessInputConnectorDTO(ProposalDomainDTO proposalDomainDTO, String sessionID, String userID, List customerDomainDTOList) {
		ValidateUserAccessInputConnectorDTO validateUserAccessInputConnectorDTO = new ValidateUserAccessInputConnectorDTO();

		validateUserAccessInputConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_VALIDATE_USER_ACCESS_OPPT);
		validateUserAccessInputConnectorDTO.setSessionID(sessionID);
		validateUserAccessInputConnectorDTO.setCreatedBy(OPPTHelper.trimString(proposalDomainDTO.getCreatedBy()));
		validateUserAccessInputConnectorDTO.setUserID(userID);

		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		orgConnectorDTO.setSalesOrg(proposalDomainDTO.getSalesOrg());
		orgConnectorDTO.setDistributionChannel(proposalDomainDTO.getDistrChannel());
		//These commented code values not required for this RFC
		//orgConnectorDTO.setSalesGroup(proposalDomainDTO.getSalesGroup());
		//orgConnectorDTO.setChannelRole(proposalDomainDTO.getChannelRole());
		//orgConnectorDTO.setSubmitterRole(proposalDomainDTO.getSubmitterRole());
		orgConnectorDTO.setDivision(proposalDomainDTO.getDivisionCode());
		validateUserAccessInputConnectorDTO.setOrgConnectorDTO(orgConnectorDTO);
		validateUserAccessInputConnectorDTO.setProposalType(proposalDomainDTO.getProposalType());
		validateUserAccessInputConnectorDTO.setBTPNo(proposalDomainDTO.getRegBillToPartyNo());
		validateUserAccessInputConnectorDTO.setPayerNo(proposalDomainDTO.getRegPayerNo());
		validateUserAccessInputConnectorDTO.setShipToPartyNo(proposalDomainDTO.getRegShipToPartyNo());

		List sapSoldToParty = new ArrayList();

		if (customerDomainDTOList != null) {
			Iterator customerDomainDTOListIterator = customerDomainDTOList.iterator();

			while (customerDomainDTOListIterator.hasNext()) {
				CustomerDomainDTO customerDomainDTO = (CustomerDomainDTO) customerDomainDTOListIterator.next();
				sapSoldToParty.add(customerDomainDTO.getSapCustomerNo());
			}
		}

		validateUserAccessInputConnectorDTO.setSapSoldToParty(sapSoldToParty);

		return validateUserAccessInputConnectorDTO;
	}
}
