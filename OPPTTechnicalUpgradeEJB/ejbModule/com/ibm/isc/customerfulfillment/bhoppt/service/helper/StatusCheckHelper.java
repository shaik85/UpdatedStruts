/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.StatusCheckOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.AccessHistoryBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.AccessHistoryBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.service.invmgr.InventoryManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/** 
 * This class is used for status check
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 15, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Prakash Mall
 * @version 5.1A 
 */
public class StatusCheckHelper {
	/** variance count */
	public int varCount = 0;
	ArrayList proposalBOList = new ArrayList();
	private static final String CLASS_NAME = "StatusCheckHelper";
	private AccessHistoryBOFactory iAccessHistoryBOFactory = new AccessHistoryBOFactory();

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */

	public StatusCheckHelper() {
	}

	/**
	 * Method to get the ProposalContractBO for a given Contract Number. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param String
	 * @throws ServiceException
	 */

	public ProposalContractBO getOriginalContract(String cntrNumber, boolean byExtCntrNum) throws ServiceException {
		OPPTLogger.debug("Inside ", CLASS_NAME, " getOriginalContract");
		ProposalContractBOFactory factory = new ProposalContractBOFactory();
		ProposalContractBO proposalBO = null;
		try {

			if (!byExtCntrNum) {
				OPPTLogger.debug("Not by External Contract Number ", CLASS_NAME, " getOriginalContract");
				proposalBO = (ProposalContractBO) factory.getProposalContractBOForContractNumber(cntrNumber, true);
			} else {
				OPPTLogger.debug("By External Contract Number ", CLASS_NAME, " getOriginalContract");
				proposalBO = (ProposalContractBO) factory.getProposalContractBOForContractNumber(cntrNumber, false);
			}

		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "StatusCheckHelper", "getOriginalContract", null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			//throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return proposalBO;
	}

	/**
	 * Method to get the Original Variance Contract, change the status and the Variance Count 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param renewContractCustomDTO
	 * @param proposalContractBO
	 * @throws ServiceException
	 */

	private void originalCntrRelatedToVariance(ProposalContractBO proposalBO, boolean varianceContract, String increment, String newStatus, String swoExtCntrNum) throws ServiceException {

		OPPTLogger.debug("Inside ", CLASS_NAME, " originalCntrRelatedToVariance");

		ProposalContractBO originalProposalContractBO = null;
		if (varianceContract) {
			OPPTLogger.debug("originalCntrRelatedToVariance - Variance Contract", CLASS_NAME, " originalCntrRelatedToVariance");
			originalProposalContractBO = getOriginalContract(proposalBO.getOrgVarContrNo(), false);

			varCount = originalProposalContractBO.getContrPeriodVarNo();

			//originalProposalContractBO.setStatusCode(ProposalContractStatusConstants.VARIANCE_BILLED);
			originalProposalContractBO.setStatusCode(newStatus);

			OPPTLogger.debug("To increment or decrement the variance counter : " + increment, CLASS_NAME, " originalCntrRelatedToVariance");

			// relation with the variance data is removed since a new variance contract is being created
			updateForVariance(originalProposalContractBO);

			if (UtilityConstants.INCREMENT.equalsIgnoreCase(increment)) {
				int newContrVarNo = varCount + 1;
				originalProposalContractBO.setContrPeriodVarNo(newContrVarNo);
			} else {
				if (UtilityConstants.DECREMENT.equalsIgnoreCase(increment)) {
					int newContrVarNo = varCount - 1;
					originalProposalContractBO.setContrPeriodVarNo(newContrVarNo);
				} else
					if (UtilityConstants.OTHER.equalsIgnoreCase(increment)) {
						// dont do anything. Left purposefully.
					}
			}

		} else {
			OPPTLogger.debug("originalCntrRelatedToVariance - Non-Variance Contract", CLASS_NAME, " originalCntrRelatedToVariance");

			if (null != swoExtCntrNum) {
				originalProposalContractBO = getOriginalContract(swoExtCntrNum, true);
			} else {
				originalProposalContractBO = getOriginalContract(proposalBO.getOldContrNo(), false);
			}

			//originalProposalContractBO.setStatusCode(ProposalContractStatusConstants.CLOSED);
			if (null != originalProposalContractBO) {
				originalProposalContractBO.setStatusCode(newStatus);
				// Defect 41 Balaji Based on defect in production reported by Antonious
				if(ProposalContractStatusConstants.CLOSED.equals(newStatus) && ProposalTypeConstants.EASII.equals(originalProposalContractBO.getProposalType())) {
					originalProposalContractBO.setOldContrNo(null);
				}
			}

			if (ProposalTypeConstants.ESSO.equals(originalProposalContractBO.getProposalType()) && ProposalContractStatusConstants.CLOSED.equalsIgnoreCase(newStatus)) {
				if (originalProposalContractBO.getContrPeriodVarNo() > 1) {
					updateVarianceContract(originalProposalContractBO);
				}
			}
		}

		if (null != originalProposalContractBO) {
			proposalBOList.add(originalProposalContractBO);
		}

		// return originalProposalContractBO;		
	}

	private void originalCntrRelatedToTP(ProposalContractBO proposalBO, String newStatus, String swoExternalCntrNum, boolean makeOrBreak) throws ServiceException {
		OPPTLogger.debug("Inside ", CLASS_NAME, " originalCntrRelatedToTP");
		ProposalContractBO originalProposalContractBO = null;

		ProposalContractBOFactory factory = new ProposalContractBOFactory();

		// find the original TP prop with swoExternalContractNumber

		try {
			originalProposalContractBO = factory.getOriginalProposalContractForTP(swoExternalCntrNum);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}

		if (null != originalProposalContractBO) {
			if (null != newStatus) {
				originalProposalContractBO.setStatusCode(newStatus);
			}

			if (makeOrBreak) {
				originalProposalContractBO.setTpContrNo(swoExternalCntrNum);
			} else {
				originalProposalContractBO.setTpContrNo(null);
			}

			proposalBOList.add(originalProposalContractBO);
		}
	}
	
	/**
	 * populateBOForStatusCheck
	 * Method to get the ProposalContractBO for a given Contract Number. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalBO
	 * @param statusCheckOutputConnectorDTO
	 * @return ArrayList
	 * @throws ServiceException
	 */

	public ArrayList populateBOForStatusCheck(ProposalContractBO proposalBO, StatusCheckOutputConnectorDTO statusCheckOutputConnectorDTO) throws ServiceException {
		OPPTLogger.debug("Inside ", CLASS_NAME, " populateBOForStatusCheck");

		SWODomainDTO swoDomainDTO = new SWODomainDTO();
		swoDomainDTO.setProposalId(proposalBO.getProposalId());

		String messageString = OPPTHelper.getLogString(String.valueOf(proposalBO.getProposalId()));
		OPPTLogger.log("PROPOSAL_ID", OPPTLogger.DEBUG, CLASS_NAME, "populateBOForStatusCheck", messageString);

		double zero = 0;
		ProposalDomainDTO proposalDomainDTO = new ProposalDomainDTO();
		InventoryManagerLocal inventoryManagerLocal;

		ProposalContractBO originalProposalContractBO = null;

		if (proposalBO.isContractType(ContractTypeConstants.VARIANCE)) {
			originalProposalContractBO = getOriginalContract(proposalBO.getOrgVarContrNo(), false);
			varCount = originalProposalContractBO.getContrPeriodVarNo();
			
			proposalDomainDTO.setProposalId(originalProposalContractBO.getProposalId());
		}



		try {
			inventoryManagerLocal = HomeProvider.getInventoryManagerLocal();
		} catch (CreateException e) {
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		String swoExtCntrNumber = inventoryManagerLocal.getSWOExternalCntrNumber(proposalBO.getProposalId());

		// if swoExtCntrNumberExist is FALSE, it means that the license doesnt have external contract number associated. 

		messageString = OPPTHelper.getLogString(swoExtCntrNumber);
		OPPTLogger.log("SWO_EXT_CNTR_NUM_EXIST", OPPTLogger.DEBUG, CLASS_NAME, "populateBOForStatusCheck", messageString);

		boolean swoExtCntrNumberExist = false;

		if (null != swoExtCntrNumber) {
			swoExtCntrNumberExist = true;
		}

		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(statusCheckOutputConnectorDTO.getReturnCodeSAP())) {
			OPPTLogger.debug("Return Code from SAP is 0 ", CLASS_NAME, " populateBOForStatusCheck");

			if (proposalBO.isProposalStatus(ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS)) {

				if (proposalBO.isContractType(ContractTypeConstants.VARIANCE)) {
					OPPTLogger.debug("Contract Type is VARIANCE ", CLASS_NAME, " populateBOForStatusCheck");
					//  BusinessRuleName - Status check for variance proposal with success

					// 1)	Proposal status must be changed to ‘Variance Contract’
					// 2)	Original contract related to the variance proposal status must be changed to ‘Variance {0} Billed’
					// 3)	CAP variance and cumulative price must be set zero. Temporary inventory data used for variance report, if present, must be deleted.

					updateProposalStatus(proposalBO, ProposalContractStatusConstants.VARIANCE_CONTRACT);
					if (proposalBO.getStatusCode()==ProposalContractStatusConstants.VARIANCE_CONTRACT)
					{
						createAccessHistory(proposalBO.getProposalId(),
								proposalBO.getLockedBy(), "Contract created using variance");
					}
					originalCntrRelatedToVariance(proposalBO, true, UtilityConstants.OTHER, ProposalContractStatusConstants.VARIANCE_BILLED, null);
					if(proposalBO.isContractType(ProposalContractStatusConstants.VARIANCE_BILLED))
					{
						createAccessHistory(proposalBO.getProposalId(),
								proposalBO.getLockedBy(), "variance billed ");
					}
					inventoryManagerLocal.deleteVarianceInventory(proposalDomainDTO);

				} else
					if (proposalBO.isContractType(ContractTypeConstants.ORIGINAL)) {
						OPPTLogger.debug("Contract Type is ORIGINAL ", CLASS_NAME, " populateBOForStatusCheck");

						checkAndUpdateLicence(proposalBO.getProposalType(), swoDomainDTO, proposalBO);
						updateProposalStatus(proposalBO, ProposalContractStatusConstants.CONTRACT);
						if(proposalBO.getStatusCode()==ProposalContractStatusConstants.CONTRACT)
						{
						//createAccessHistory(proposalBO.getProposalId(),
						//		proposalBO.getLockedBy(), "Contract creation");
						}
						if (ProposalTypeConstants.TP.equals(proposalBO.getProposalType())) {
							// 4)	Contract, to which licenses of the TP proposal are associated, must be updated so that the overlay relation is with the new TP contract
							if (swoExtCntrNumberExist) {
								//originalCntrRelatedToVariance(proposalBO, false, UtilityConstants.OTHER, ProposalContractStatusConstants.CLOSED, swoExtCntrNumber);
								originalCntrRelatedToTP(proposalBO, null, swoExtCntrNumber, true);
							}
						}
					} else
						if (proposalBO.isContractType(ContractTypeConstants.RENEWAL) || proposalBO.isContractType(ContractTypeConstants.REPLACEMENT)) {
							OPPTLogger.debug("Contract Type is either Renewal or Replacement ", CLASS_NAME, " populateBOForStatusCheck");

							if (!(proposalBO.isProposalType(ProposalTypeConstants.EASII) || proposalBO.isProposalType(ProposalTypeConstants.TP))) {
								OPPTLogger.debug("Proposal Type is not EASII or TP ", CLASS_NAME, " populateBOForStatusCheck");
								// 1)	Proposal status must be changed to ‘Contract’
								// 2)	All licenses of new contract must be marked as locked
								// 3)	Original contract must be changed to ‘Closed’ status
								// 4)	Calculated price used for contract creation must be stored as old calculated price for all licenses
								checkAndUpdateLicence(proposalBO.getProposalType(), swoDomainDTO, proposalBO);
								updateProposalStatus(proposalBO, ProposalContractStatusConstants.CONTRACT);
								createAccessHistory(proposalBO.getProposalId(),
										proposalBO.getLockedBy(),"Contract creation");
								System.out
										.println("StatusCheckHelper.populateBOForStatusCheck()"+proposalBO.getProposalId()+ proposalBO.getLockedBy()+"Contract");
								originalCntrRelatedToVariance(proposalBO, false, UtilityConstants.OTHER, ProposalContractStatusConstants.CLOSED, null);
								originalProposalContractBO = getOriginalContract(proposalBO.getOldContrNo(), false);
								System.out
								.println("StatusCheckHelper.populateBOForStatusCheck()"+originalProposalContractBO.getStatusCode()+"ren or repl");
								
									createAccessHistory(originalProposalContractBO.getProposalId(),
											originalProposalContractBO.getLockedBy(), "Closed because of replace/renew and the new contract is "+proposalBO.getProposalName());
								
								
							} else
								if (proposalBO.isProposalType(ProposalTypeConstants.EASII) && proposalBO.isContractType(ContractTypeConstants.REPLACEMENT)) {
									OPPTLogger.debug("Proposal Type is EASII and Contract Type is REPLACEMENT ", CLASS_NAME, " populateBOForStatusCheck");
									// 1)	Proposal status must be changed to ‘Contract’
									// 2)	All licenses of new contract must be marked as locked
									// 3)	Calculated price used for contract creation must be stored as old calculated price for all licenses
									// 4)	Original EAS II contract, for which replacement is done, must be changed to ‘Closed’ status
									// 5)	Original EAS contract, for which original EAS II contract was made, must be updated so that the overlay relation is with the new EAS II contract

									checkAndUpdateLicence(proposalBO.getProposalType(), swoDomainDTO, proposalBO);
									updateProposalStatus(proposalBO, ProposalContractStatusConstants.CONTRACT);
									originalCntrRelatedToVariance(proposalBO, false, UtilityConstants.OTHER, ProposalContractStatusConstants.CLOSED, null);
									updateOverlayRelation(proposalBO, true, false);
								} else
									if (proposalBO.isContractType(ContractTypeConstants.RENEWAL) && ProposalTypeConstants.TP.equals(proposalBO.getProposalType())) {
										OPPTLogger.debug("Contract Type is RENEWAL and Proposal type is TP ", CLASS_NAME, " populateBOForStatusCheck");
										// 1)	Proposal status must be changed to ‘Contract’
										// 2)	All licenses of new contract must be marked as locked
										// 3)	Calculated price used for contract creation must be stored as old calculated price for all licenses
										// 4)	Contract, to which licenses of the TP proposal are associated, must be updated so that the overlay relation is with the new TP contract
										// 5)	Original contract must be changed to ‘Closed’ status
										checkAndUpdateLicence(proposalBO.getProposalType(), swoDomainDTO, proposalBO);
										updateProposalStatus(proposalBO, ProposalContractStatusConstants.CONTRACT);
										if (swoExtCntrNumberExist) {
											//originalCntrRelatedToVariance(proposalBO, false, UtilityConstants.OTHER, ProposalContractStatusConstants.CLOSED, swoExtCntrNumber);
											originalCntrRelatedToTP(proposalBO, ProposalContractStatusConstants.CLOSED, swoExtCntrNumber, true);
										}
										//updateOverlayRelation(proposalBO, true, false);
									}
						}
			} else
				if (proposalBO.isProposalStatus(ProposalContractStatusConstants.CHECK_AMENDED_CONTRACT_STATUS)) {
					OPPTLogger.debug("Proposal status is CHECK_AMENDED_CONTRACT_STATUS ", CLASS_NAME, " populateBOForStatusCheck");
					updateProposalStatus(proposalBO, ProposalContractStatusConstants.CONTRACT);
					checkAndUpdateLicence(proposalBO.getProposalType(), swoDomainDTO, proposalBO);
					createAccessHistory(proposalBO.getProposalId(),
							proposalBO.getLockedBy(), "Contract amended");
					if (ProposalTypeConstants.TP.equals(proposalBO.getProposalType())) {
						updateOverlayRelation(proposalBO, true, false);
					}
					// delete the original Contract on which the amendment is done.
					// get the old contract number and do the delete 
					deleteOldContract(proposalBO);
				} else
					if (proposalBO.isProposalStatus(ProposalContractStatusConstants.CHECK_EXTENSION_STATUS)) {
						OPPTLogger.debug("Proposal status is CHECK_EXTENSION_STATUS ", CLASS_NAME, " populateBOForStatusCheck");
						updateProposalStatus(proposalBO, ProposalContractStatusConstants.EXTENDED);
						createAccessHistory(proposalBO.getProposalId(),
								proposalBO.getLockedBy(), "Contract extended");
						//nomita
					} else
						if (proposalBO.isProposalStatus(ProposalContractStatusConstants.CHECK_CLOSURE_STATUS)) {
							OPPTLogger.debug("Proposal status is CHECK_CLOSURE_STATUS ", CLASS_NAME, " populateBOForStatusCheck");
							if (proposalBO.isContractType(ContractTypeConstants.VARIANCE)) {
								OPPTLogger.debug("Check Closure STatus - Contract type is VARIANCE", CLASS_NAME, " populateBOForStatusCheck");
								if (varCount > 1) {
									OPPTLogger.debug("Check Closure STatus - Variance count > 0 ", CLASS_NAME, " populateBOForStatusCheck");
									// 1)	Contract status must be changed to ‘Closed’
									// 2)	Original contract’s variance count within the contract period must be updated with a value decremented once. 
									// 3)	CAP variance and cumulative price must be set zero. 
									// Temporary inventory data used for variance report, if present, must be deleted.
									// 4)	Original contract status must be changed to ‘Variance {0} Billed’

									updateProposalStatus(proposalBO, ProposalContractStatusConstants.CLOSED);
									originalCntrRelatedToVariance(proposalBO, true, UtilityConstants.DECREMENT, ProposalContractStatusConstants.VARIANCE_BILLED, null);
									inventoryManagerLocal.deleteVarianceInventory(proposalDomainDTO);

								} else {
									OPPTLogger.debug("Check Closure STatus - Variance count = 1", CLASS_NAME, " populateBOForStatusCheck");

									// If the variance contract is the first variance contract
									// 1)	Contract status must be changed to ‘Closed’
									// 2)	Original contract’s variance count must be reset
									// 3)	CAP variance and cumulative price must be set zero. Temporary inventory data used for variance report, if present, must be deleted.
									// 4)	Original contract status must be changed to ‘Contract’
									updateProposalStatus(proposalBO, ProposalContractStatusConstants.CLOSED);
									originalCntrRelatedToVariance(proposalBO, true, UtilityConstants.DECREMENT, ProposalContractStatusConstants.CONTRACT, null);
									inventoryManagerLocal.deleteVarianceInventory(proposalDomainDTO);

								}
							} else
								if (proposalBO.isProposalType(ProposalTypeConstants.ESSO) && (varCount > 1)) {
									OPPTLogger.debug("Check Closure STatus - Proposal type is ESSO and variance count > 1", CLASS_NAME, " populateBOForStatusCheck");
									// 1)	Contract status must be changed to ‘Closed’
									updateProposalStatus(proposalBO, ProposalContractStatusConstants.CLOSED);
									// 2)	All variance contracts of the original contract except the last variance contract must be changed to status ‘Closed’
									updateVarianceContract(proposalBO);
								} else
									if (proposalBO.isProposalType(ProposalTypeConstants.TP)) {
										OPPTLogger.debug("Check Closure STatus - Proposal type is TP", CLASS_NAME, " populateBOForStatusCheck");
										// 1)	Contract status must be changed to ‘Closed’
										updateProposalStatus(proposalBO, ProposalContractStatusConstants.CLOSED);
										// 2)	Contract, to which licenses of the TP contract are associated, must be updated so that there is no overlay relation with the closed TP contract							
										if (swoExtCntrNumberExist) {
											originalCntrRelatedToTP(proposalBO, null, swoExtCntrNumber, false);
										}
									} else
										if (proposalBO.isProposalType(ProposalTypeConstants.EASII)) {
											OPPTLogger.debug("Check Closure STatus - Proposal type is EASII", CLASS_NAME, " populateBOForStatusCheck");
											// 1)	Contract status must be changed to ‘Closed’
											updateProposalStatus(proposalBO, ProposalContractStatusConstants.CLOSED);
											// 2)	Original EAS contract, to which the EAS II contract is related, must be updated so that there is no overlay relation with the closed EAS II contract
											updateOverlayRelation(proposalBO, false, true);
										} else
											//Status check for contract closure 

											if (!proposalBO.isProposalType(ProposalTypeConstants.EASII) || (proposalBO.isProposalType(ProposalTypeConstants.TP) && !swoExtCntrNumberExist) || (proposalBO.isProposalType(ProposalTypeConstants.ESSO) && varCount <= 1)) {

												OPPTLogger.debug("Check Closure STatus - Proposal type is not EASII OR TP with No External Contract Number Associated OR ESSO with Var count less than or equal to 1", CLASS_NAME, " populateBOForStatusCheck");
												// Contract status must be changed to ‘Closed’
												updateProposalStatus(proposalBO, ProposalContractStatusConstants.CLOSED);
												createAccessHistory(proposalBO.getProposalId(),
														proposalBO.getLockedBy(), "Contract closed");
											}

						}
		} else {

			// if the return code is 80 in the second return code, the status should not be changed.
			if (80 != Integer.valueOf(statusCheckOutputConnectorDTO.getReturnCodeSAP()).intValue()) {
				OPPTLogger.debug("Check Status Failed. SAP RC is not equal to 0", CLASS_NAME, " populateBOForStatusCheck");
				// Status check failure
				if (proposalBO.isProposalStatus(ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS)) {
					OPPTLogger.debug("Check Status failed - Prop status is CP", CLASS_NAME, " populateBOForStatusCheck");
					if (proposalBO.isContractType(ContractTypeConstants.VARIANCE)) {
						OPPTLogger.debug("Check status failed - variance contract", CLASS_NAME, " populateBOForStatusCheck");
						//  1)  Proposal status must be changed to ‘Pending Approval’
						//	2)   Related contract status must be changed to ‘Variance {0} in Progress’
						updateProposalStatus(proposalBO, ProposalContractStatusConstants.PENDING_APPROVAL);
						originalCntrRelatedToVariance(proposalBO, true, UtilityConstants.OTHER, ProposalContractStatusConstants.VARIANCE_IN_PROGRESS, null);

					} else {
						OPPTLogger.debug("Check Status failed - Non-variance contract", CLASS_NAME, " populateBOForStatusCheck");
						// Proposal status must be changed to ‘Pending Approval’

						updateProposalStatus(proposalBO, ProposalContractStatusConstants.PENDING_APPROVAL);

					}
				} else
					if (proposalBO.isProposalStatus(ProposalContractStatusConstants.CHECK_AMENDED_CONTRACT_STATUS)) {
						OPPTLogger.debug("Check Status failed - Prop status is CA", CLASS_NAME, " populateBOForStatusCheck");
						// Contract status must be changed to ‘Amended contract pending approval’
						updateProposalStatus(proposalBO, ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL);

					} else
						if (proposalBO.isProposalStatus(ProposalContractStatusConstants.CHECK_EXTENSION_STATUS)) {
							OPPTLogger.debug("Check Status failed - Prop status is CE", CLASS_NAME, " populateBOForStatusCheck");
							// Proposal status must be changed to ‘Extended contract pending approval'
							updateProposalStatus(proposalBO, ProposalContractStatusConstants.EXTENDED_CONTRACT_PENDING_APPROVAL);

						} else
							if (proposalBO.isProposalStatus(ProposalContractStatusConstants.CHECK_CLOSURE_STATUS)) {
								OPPTLogger.debug("Check Status failed - Prop status is CC", CLASS_NAME, " populateBOForStatusCheck");
								// Contract status must be updated to status ‘Contract closure failed, retry’
								updateProposalStatus(proposalBO, ProposalContractStatusConstants.CONTRACT_CLOSURE_FAILED_RETRY);
							}

			}

		}
		
		// unlock the proposal only if Return Code from SAP is not equal to 80
		if (80 != Integer.valueOf(statusCheckOutputConnectorDTO.getReturnCodeSAP()).intValue()) {
			updateLock(proposalBO);
		}	

		proposalBOList.add(proposalBO);
		return proposalBOList;
	}
	
	/**
	 * checkAndUpdateLicence
	 * Method to get the ProposalContractBO for a given Contract Number. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalType
	 * @param swoDomainDTO
	 * @param proposalBO
	 * @return void
	 * @throws ServiceException
	 */

	public void checkAndUpdateLicence(String proposalType, SWODomainDTO swoDomainDTO, ProposalContractBO proposalBO) throws ServiceException {
		OPPTLogger.debug("Inside ", CLASS_NAME, " checkAndUpdateLicence");
		boolean result = false;
		boolean chkAndUpdateLicense = true;

		HashMap valueMap = new HashMap();
		valueMap.put(UtilityConstants.PROPOSAL_TYPE, proposalType);
		if (!ProposalTypeConstants.TP.equals(proposalType)) {
			OPPTLogger.debug("checkAndUpdateLic - prop type is not TP ", CLASS_NAME, " checkAndUpdateLicence");
			valueMap.put(UtilityConstants.EXTERNAL_CNTR_NUM_ASSOCIATED, UtilityConstants.NO);
		} else {
			OPPTLogger.debug("checkAndUpdateLic - prop type is TP ", CLASS_NAME, " checkAndUpdateLicence");
			valueMap.put(UtilityConstants.EXTERNAL_CNTR_NUM_ASSOCIATED, UtilityConstants.YES);
		}

		swoDomainDTO.setProposalId(proposalBO.getProposalId());
		swoDomainDTO.setValues(valueMap);
		try {
			OPPTLogger.debug("checkAndUpdateLic - calling InventoryManager ", CLASS_NAME, " checkAndUpdateLicence");
			InventoryManagerLocal inventoryManagerLocal = HomeProvider.getInventoryManagerLocal();
			swoDomainDTO = inventoryManagerLocal.validateAndPopulateSWOForStatusCheck(swoDomainDTO);
		} catch (Exception ex) {
			result = false;
			throw new ServiceException();
		}
	}

	/**
	 * To populate for Status Check for a Proposal or a Contract 
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
	 * @param renewContractCustomDTO
	 * @param proposalContractBO
	 * @throws ServiceException
	 */
	private void updateProposalStatus(ProposalContractBO proposalBO, String newStatus) {
		proposalBO.setStatusCode(newStatus);
	}

	private void updateLock(ProposalContractBO proposalBO) {
		proposalBO.setLockedBy(null);
		proposalBO.setLockedOn(null);
	}

	/**
	 * This method is used for maintaing the overlay relation for replaced or renewed contracts,EASII or TP 
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
	 * @param proposalBO
	 * @throws ServiceException
	 */
	private void updateOverlayRelation(ProposalContractBO proposalBO, boolean makeOrBreak, boolean contrNumOROldContrNum) throws ServiceException {
		OPPTLogger.debug("Inside ", CLASS_NAME, " updateOverlayRelation");
		ProposalContractBOFactory factory = new ProposalContractBOFactory();
		ProposalContractBO originalBO = new ProposalContractBO();
		String messageString = null;
		try {

			if (contrNumOROldContrNum) {
				OPPTLogger.debug("Find TpContractNumber by Contract number ", CLASS_NAME, " updateOverlayRelation");
				originalBO = factory.findByTPContractNo(proposalBO.getContrNo());
			} else {
				OPPTLogger.debug("Find TpContractNumber by Old Contract number ", CLASS_NAME, " updateOverlayRelation");
				originalBO = factory.findByTPContractNo(proposalBO.getOldContrNo());
			}

			OPPTLogger.debug("Original Proposal Id is #" + originalBO.getProposalId() + "#", CLASS_NAME, " updateOverlayRelation");

			if (makeOrBreak) {
				// // The Overlay updated 
				OPPTLogger.debug("Updating overlay relation ", CLASS_NAME, " updateOverlayRelation");
				originalBO.setTpContrNo(proposalBO.getContrNo());
			} else {
				// remove overlay relationship
				OPPTLogger.debug("Removing overlay relation ", CLASS_NAME, " updateOverlayRelation");
				originalBO.setTpContrNo(null);
			}

			proposalBOList.add(originalBO);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}

	}

	/**
	 * This method  will close all the variance contract except the last contract. 
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
	 * @param proposalBO
	 * @throws ServiceException
	 */
	private void updateVarianceContract(ProposalContractBO proposalBO) throws ServiceException {
		OPPTLogger.debug("Inside ", CLASS_NAME, " updateVarianceContract");
		ProposalContractBOFactory factory = new ProposalContractBOFactory();
		ProposalContractBO varianceBO = null;
		List varianceContractBOList = new ArrayList();
		try {
			varianceContractBOList = factory.findAllVarianceContract(proposalBO.getContrNo());
			// 
			for (int i = 0, size = varianceContractBOList.size(); i < (size - 1); i++) {
				varianceBO = (ProposalContractBO) varianceContractBOList.get(i);
				varianceBO.setStatusCode(ProposalContractStatusConstants.CLOSED);
				proposalBOList.add(varianceBO);
			}
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}

	}

	private void deleteOldContract(ProposalContractBO proposalBO) throws ServiceException {
		OPPTLogger.debug("Inside ", CLASS_NAME, " deleteOldContract");
		ProposalContractBOFactory factory = new ProposalContractBOFactory();

		try {
			ContractBO origContract = (ContractBO) factory.getProposalContractBOForContractNumber(proposalBO.getOldContrNo(), true);
			factory.deleteProposalContractBO(origContract);
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		}
	}

	private void updateForVariance(ProposalContractBO proposalBO) {
		OPPTLogger.debug("Inside ", CLASS_NAME, " updateForVariance");
		double zero = 0;

		proposalBO.setCapVariance(zero);
		proposalBO.setCumValue(zero);
		proposalBO.setVarDate(null);
		proposalBO.setVarInd(null);
	}
	// Nomita start
	private void createAccessHistory(int proposalID, String userID,
			String operationPerformed) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "createAccessHistory");
		AccessHistoryBO accessHistoryBO = new AccessHistoryBO();
		accessHistoryBO.setProposalId(proposalID);
		accessHistoryBO.setUserId(userID);
		accessHistoryBO.setOperationPerformed(operationPerformed);
		try {
			iAccessHistoryBOFactory.create(accessHistoryBO);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}
 //end
}
