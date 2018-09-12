/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/** 
 * This class checks the business condition against ProposalBDO attributes. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class ContractBO extends ProposalContractBO {

	/**
	 *  
	 * This method validates the delta fetch pre-condition 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param user
	 * @return
	 * @throws DomainException
	 */
	public void validateDeltaFetch(int type, HashMap values) throws DomainException {
		boolean deltaFetch = false;

		boolean result = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT.equalsIgnoreCase(getStatusCode()) || ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT.equalsIgnoreCase(getStatusCode())) {
			if (values != null && validateUserAuthorityForChange(values)) {
				deltaFetch = true;
			}
		}

		if (postCondition) {
			if (deltaFetch == false) {
				postConditionResult.put(ButtonConstants.DELTA_FETCH, ButtonConstants.DELTA_FETCH);
			}
		} else if (deltaFetch == false) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0108, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

	}

	/**
	 * This method verifies the conditions Proposal Type is ESSO and Status is either
	 * Contract or Variance Billed. 
	 * <br><b>Known Bugs</b><br> 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * Venkat
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */

	public boolean isAllowedForVariance(int type, HashMap values) throws DomainException {

		boolean isVarianceAllowed = false;

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (values != null && validateUserAuthorityForChange(values)) {
			if ((ProposalTypeConstants.ESSO.equals(getProposalType()))
				&& (ProposalContractStatusConstants.VARIANCE_BILLED.equals(getStatusCode()) || ProposalContractStatusConstants.CONTRACT.equals(getStatusCode()))) {

				isVarianceAllowed = true;

			}
		} else {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0001);
		}

		if (postCondition) {
			if (isVarianceAllowed == false) {
				postConditionResult.put(ButtonConstants.SIMULATE_VARIANCE, ButtonConstants.SIMULATE_VARIANCE);
				postConditionResult.put(ButtonConstants.CREATE_VARIANCE, ButtonConstants.CREATE_VARIANCE);
			}
		}

		return isVarianceAllowed;
	} //end of isAllowedForVariance

	/**
	 * This method verifies the conditions Proposal Type is ESSO 
	 * <br><b>Known Bugs</b><br> 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * Venkat
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */

	public boolean isContractForVariance() throws DomainException {
		boolean isContractForVariance = false;

		if (ProposalTypeConstants.ESSO.equals(getProposalType())) {
			isContractForVariance = true;
		}

		return isContractForVariance;
	} //end of isContractForVariance
	/**
	 *  
	 * This method is used to verify the preconditions for initiating the 
	 * Check Variance 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * Venkat
	 * 
	 * </PRE><br> 
	 * 
	 * @param VarianceType
	 * @return boolean
	 */
	public boolean isVarianceCheckAllowed(int type, HashMap values) throws DomainException {
		boolean isVarianceCheckAllowed = false;
		String CREATE_VARIANCE = "C";
		String SIMULATE_VARIANCE = "S";
		if (isAllowedForVariance(type, values)) {
			// To check whether request is already made either for Create or Simulate Variance  

			if ((CREATE_VARIANCE.equalsIgnoreCase(getVarInd())) || (SIMULATE_VARIANCE.equalsIgnoreCase(getVarInd()))) {
				isVarianceCheckAllowed = true;
			}
		}
		return isVarianceCheckAllowed;
	} //end of isVarianceCheckAllowed

	/**
	 * To check whether variance check is done or not.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * Venkat 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isVarianceCheckDone() throws DomainException {

		boolean isVarianceCheckDone = false;

		// To check whether Cap Variance is empty or not.if Cap Variance amount is empty then variance check is not done.   

		if (getVarInd() != null && (getVarInd().equals(UtilityConstants.CREATE_VARIANCE) || getVarInd().equals(UtilityConstants.SIMULATE_VARIANCE))) {

			isVarianceCheckDone = true;
		}

		return isVarianceCheckDone;

	} //end of isVarianceCheckDone

	/**
			 *  
			 * This method validates if the Contract can be deleted or not
			 * 
			 * <br><b>Known Bugs</b><br> 
			 * 
			 * <br><PRE> 
			 * date Dec 26, 2003 
			 * 
			 * revision date author reason 
			 * 
			 * </PRE><br> 
			 * 
			 * @param 
			 * @return
			 * @throws ServiceException
			 */
	public boolean validateForDeletion(int type, HashMap compareValues) throws DomainException {

		boolean deleteContract = false;
		String[] validStatus = { ProposalContractStatusConstants.CLOSED };

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (validateProposalStatus(validStatus)) {
					deleteContract = true;
				}
			}
		} else {
			boolean result1 = validateUserAuthorityForChange(compareValues);
			boolean result2 = validateProposalStatus(validStatus);

			if (!result2) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0415, OPPTMessageCatalog.TYPE_DOMAIN);
			}

			if (result1 && result2) {
				deleteContract = true;
			}
		}

		if (!postCondition && !deleteContract) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return deleteContract;

	}

	/** 
	 * Checks whether the SWO can be amended at proposal level
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
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException 
	 */
	public boolean validateForAmendSWO(int type, HashMap compareValues) throws DomainException {
		boolean result = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (checkStatusForChangeByPropAdmin(INVENTORY)) {
					result = true;
				}
			}

			if (result == false) {
				postConditionResult.put(ButtonConstants.AMEND_SWO, ButtonConstants.AMEND_SWO);
			}
		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = checkStatusForChangeByPropAdmin(INVENTORY);
			result = firstResult & secondResult;
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return result;
	}

	/**
	 * This method is used for performing precondition check Pricing  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param type
	 * @param compareValues
	 * @return
	 * @throws DomainException
	 */
	public boolean validateForPricing(int type, HashMap compareValues) throws DomainException {

		boolean result = false;
		String[] validPricingStatus = { ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT, ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT };

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}
		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (validateProposalStatus(validPricingStatus)) {
					result = true;

				}
			}

			if (!result) {
				postConditionResult.put(ButtonConstants.PRICEPROPOSAL_BUTTON, ButtonConstants.PRICEPROPOSAL_BUTTON);
			}
		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = validateProposalStatus(validPricingStatus);
			if (!secondResult) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0002, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			result = firstResult & secondResult;
		}
		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return true;
	}

	/**
	 * This method is to validate precondition and business rule conditions for Registering a Contract  
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
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 */

	public boolean validateForRegistration(int type, HashMap compareValues) throws DomainException {
		OPPTCalender opptCal = new OPPTCalender();

		boolean registerContract = false;

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		} else {
			preCondition = (type == UtilityConstants.BUSINESSRULE_PRE_COND_TYPE);
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				registerContract = true;
				//postCondition = false;
			}

			if (registerContract == false) {
				postConditionResult.put(ButtonConstants.REGISTER, ButtonConstants.REGISTER);
			}
		} else {
			if (preCondition) {
				Date contractExtendDate = (Date) compareValues.get(UtilityConstants.CONTRACT_EXTEND_DATE);

				if (null == contractExtendDate) {
					registerContract = validateUserAuthorityForChange(compareValues);
				}

				OPPTCalender calendar = new OPPTCalender();

				if (null != contractExtendDate) {
					
					OPPTCalender calendar1 = new OPPTCalender();
					calendar1.setTime(OPPTCalender.addDate(Calendar.MONTH, 3, getContrEndPeriod()));
					calendar1.set(Calendar.DAY_OF_MONTH, calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));
					Date contrPeriodEndDate = calendar1.getTime();
					
					//Date contrPeriodEndDate = OPPTCalender.addDate(Calendar.MONTH, 3, getContrEndPeriod());
					// validate for preconditions for Registration for Contract Extension
					// Contract extension date for other proposals

					boolean result1 = (calendar.isDateEqual(contractExtendDate, contrPeriodEndDate) || calendar.isDateLesser(contractExtendDate, contrPeriodEndDate));
					boolean result2 = (calendar.isDateEqual(contractExtendDate, getContrEndPeriod()) || calendar.isDateGreater(contractExtendDate, getContrEndPeriod()));
					boolean result3 = (OPPTCalender.isFirstDayOfTheMonth(contractExtendDate) || OPPTCalender.isLastDayOfTheMonth(contractExtendDate));

					String[] validPropTypeForOthers = { ProposalTypeConstants.EAS,ProposalTypeConstants.PLA, ProposalTypeConstants.NUEV, ProposalTypeConstants.EGO, ProposalTypeConstants.ELITE, ProposalTypeConstants.SGO };

					if (validateProposalType(validPropTypeForOthers)) {

						// Contr Extn date must be less than or equal to Contract period end date + 3 mths (result1)
						// contract extension date is greater than or equal to the contract period end date (result2)
						// must be first day of the month or last day of the mth  (result3)

						if (result1 && result2 && result3) {
							registerContract = true;
						} else {
							if (!result1) {
								ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0429, OPPTMessageCatalog.TYPE_DOMAIN);
							} else if (!result2) {
								ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0434, OPPTMessageCatalog.TYPE_DOMAIN);
							} else if (!result3) {
								ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0428, OPPTMessageCatalog.TYPE_DOMAIN);
							}
						}
					}

					// Contract extension date for TP
					String[] validPropType = { ProposalTypeConstants.TP };
					if (validateProposalType(validPropType)) {
						// Contr Extn date must be less than or equal to Contract period end date + 3 mths
						// May be any day of the month

						if (result1 && result2) {
							registerContract = true;
						} else if (!result1) {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0429, OPPTMessageCatalog.TYPE_DOMAIN);
						} else if (!result2) {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0434, OPPTMessageCatalog.TYPE_DOMAIN);
						}
					}
				}

				preCondition = false;

			} else {
				Integer contractVariancePeriodNo = (Integer) compareValues.get(UtilityConstants.CONTRPERIOD_VARNO);
				String orgCntrStatus = (String) compareValues.get(UtilityConstants.STATUS);

				// Business Rule - Register for contract amendment
				Boolean svcLicenseExist = (Boolean) compareValues.get(UtilityConstants.SVCLICENSE_EXIST);
				if (isContractStatus(ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT)) {
					if (opptCal.isDateEqual(getFetchDate())) {
						if (opptCal.isDateEqual(getDatePriced())) {
							if (UtilityConstants.YES.equalsIgnoreCase(getIneligibleInd().trim())) {
								if (!svcLicenseExist.booleanValue()) {
									registerContract = true;
								} else {
									ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0405, OPPTMessageCatalog.TYPE_DOMAIN);
								}
							} else {
								ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0407, OPPTMessageCatalog.TYPE_DOMAIN);
							}
						} else {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0402, OPPTMessageCatalog.TYPE_DOMAIN);
						}
					} else {
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0403, OPPTMessageCatalog.TYPE_DOMAIN);
					}
				} else {
					// Business Rule - Register contract closure
					if ((isContractStatus(ProposalContractStatusConstants.CONTRACT)
						|| isContractStatus(ProposalContractStatusConstants.VARIANCE_BILLED)
						|| isContractStatus(ProposalContractStatusConstants.CONTRACT_CLOSURE_FAILED_RETRY))) {
						registerContract = true;
					}
					if (isProposalType(ProposalTypeConstants.TP) && isContractStatus(ProposalContractStatusConstants.EXTENDED)) {
						registerContract = true;
					}

					if (isContractType(ContractTypeConstants.VARIANCE)) {
						if (contractVariancePeriodNo.intValue() == getContrPeriodVarNo()) {
							if (!ProposalContractStatusConstants.VARIANCE_IN_PROGRESS.equalsIgnoreCase(orgCntrStatus)
								|| !ProposalContractStatusConstants.CHECK_VARIANCE_STATUS.equalsIgnoreCase(orgCntrStatus)) {
								registerContract = true;
							} else {
								if (ProposalContractStatusConstants.VARIANCE_IN_PROGRESS.equalsIgnoreCase(orgCntrStatus)) {
									ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0409, OPPTMessageCatalog.TYPE_DOMAIN);
								} else {
									ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0408, OPPTMessageCatalog.TYPE_DOMAIN);
								}
							}
						} else {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0410, OPPTMessageCatalog.TYPE_DOMAIN);
						}
					}

					if (isContractStatus(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT)) {
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0433, OPPTMessageCatalog.TYPE_DOMAIN);
					}
				}
			}
			// BH Wave1 - DAD003 - Bhanu - Begin 
			if( null != getCciInd() && getCciInd().equals("N")){
				registerContract = false;
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0436, OPPTMessageCatalog.TYPE_DOMAIN);			
			}
			// BH Wave1 - DAD003 - Bhanu - End
		}
		if (!postCondition && !registerContract) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return registerContract;
	}

	private boolean isContractStatus(String status) {
		return getStatusCode().trim().equalsIgnoreCase(status) ? true : false;
	}

	public boolean isContractType(String contrType) {
		return getContrType().trim().equalsIgnoreCase(contrType) ? true : false;
	}

	public boolean isProposalType(String propType) {
		return getProposalType().trim().equalsIgnoreCase(propType) ? true : false;
	}

	/** 
	 * Checks whether the contract changes can be reverted
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException 
	 */
	public boolean validateForRevert(int type, HashMap compareValues) throws DomainException {
		boolean result = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (isRevertPossibleForContractStatus()) {
					return true;
				}
			}
		} else {
			result = validateUserAuthorityForChange(compareValues) & isRevertPossibleForContractStatus();
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return result;
	}

	/* 
	 * Checks whether revert possible for the contract from its status
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
	 * @return boolean
	 */
	private boolean isRevertPossibleForContractStatus() {
		boolean result = false;
		String[] validStatus =
			{
				ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT,
				ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT,
				ProposalContractStatusConstants.RENEWAL_IN_PROGRESS,
				ProposalContractStatusConstants.REPLACEMENT_IN_PROGRESS,
				ProposalContractStatusConstants.VARIANCE_IN_PROGRESS };

		if (postCondition) {
			Boolean resultValue = (Boolean) postConditionResult.get(PC_CONTRACT_REVERT_STATE);
			if (resultValue != null) {
				return resultValue.booleanValue();
			}
		}
		String status = getStatusCode();
		for (int i = 0; i < validStatus.length; i++) {
			if (validStatus[i].equals(status)) {
				result = true;
				break;
			}
		}

		if (postCondition) {
			postConditionResult.put(PC_CONTRACT_REVERT_STATE, new Boolean(result));
		} else if (!result) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0602, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		return result;
	}

	/** 
	 * Checks whether variance is in progress for the contract
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
	 * @return boolean
	 */
	public boolean isContractInVariance() {
		boolean result = false;
		String status = getStatusCode();
		if (ProposalContractStatusConstants.VARIANCE_IN_PROGRESS.equals(status) || ProposalContractStatusConstants.CHECK_VARIANCE_STATUS.equals(status)) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether amendment is in progress for the contract
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
	 * @return boolean
	 */
	public boolean isContractInAmendment() {
		boolean result = false;
		String[] validStatus =
			{
				ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT,
				ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT,
				ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL,
				ProposalContractStatusConstants.CHECK_AMENDED_CONTRACT_STATUS };

		String status = getStatusCode();
		for (int i = 0; i < validStatus.length; i++) {
			if (validStatus[i].equals(status)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/** 
	 * Checks whether renewal is in progress for the contract
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
	 * @return boolean
	 */
	public boolean isContractInRenewal() {
		boolean result = false;
		String status = getStatusCode();

		if (ProposalContractStatusConstants.RENEWAL_IN_PROGRESS.equals(status) || ProposalContractStatusConstants.CHECK_RENEW_STATUS.equals(status)) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether replacement is in progress for the contract
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
	 * @return boolean
	 */
	public boolean isContractInReplacement() {
		boolean result = false;
		String status = getStatusCode();

		if (ProposalContractStatusConstants.REPLACEMENT_IN_PROGRESS.equals(status) || ProposalContractStatusConstants.CHECK_REPLACEMENT_STATUS.equals(status)) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether closure is in progress for the contract
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
	 * @return boolean
	 */
	public boolean isContractInClosure() {
		boolean result = false;
		String status = getStatusCode();

		if (ProposalContractStatusConstants.CHECK_CLOSURE_STATUS.equals(status)
			|| ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL.equals(status)
			|| ProposalContractStatusConstants.CONTRACT_CLOSURE_FAILED_RETRY.equals(status)) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether extension is in progress for the contract
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
	 * @return boolean
	 */
	public boolean isContractInExtension() {
		boolean result = false;
		String status = getStatusCode();

		if (ProposalContractStatusConstants.EXTENDED_CONTRACT_PENDING_APPROVAL.equals(status) || ProposalContractStatusConstants.CHECK_EXTENSION_STATUS.equals(status)) {
			result = true;
		}
		return result;
	}

	/** 
	 * Validates the request for contract closure
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
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException 
	 */
	public boolean validateForContractClosure(int type, HashMap compareValues) throws DomainException {
		boolean result = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (isClosurePossibleForStatus()) {
					if (compareValues.get(UtilityConstants.RELATED_PNAME_FOR_OVERLAY) == null) {
						return true;
					}
				}
			}
		} else {
			result = validateUserAuthorityForChange(compareValues) & isClosurePossibleForStatus();
			String propName = (String) compareValues.get(UtilityConstants.RELATED_PNAME_FOR_OVERLAY);
			if (propName != null && checkProposalType(ProposalTypeConstants.EAS)) {
				result = result & false;
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0637, OPPTMessageCatalog.TYPE_DOMAIN);
			} else {
				result = result & true;
			}
		}

		if (type == UtilityConstants.BUSINESSRULE_OTHER_TYPE && result && !ProposalContractStatusConstants.CONTRACT_CLOSURE_FAILED_RETRY.equals(getStatusCode())) {
			result = result & validateClosureDate(compareValues);
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return result;
	}

	/* 
	 * Checks the status of the contract and responds whether closure is possible 
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
	 * @return boolean
	 */
	private boolean isClosurePossibleForStatus() {
		boolean result = false;
		String[] validStatus =
			{
				ProposalContractStatusConstants.CONTRACT,
				ProposalContractStatusConstants.EXTENDED,
				ProposalContractStatusConstants.VARIANCE_BILLED,
				ProposalContractStatusConstants.VARIANCE_CONTRACT,
				ProposalContractStatusConstants.CONTRACT_CLOSURE_FAILED_RETRY };

		if (postCondition) {
			Boolean resultValue = (Boolean) postConditionResult.get(PC_CONTRACT_CLOSURE_STATE);
			if (resultValue != null) {
				return resultValue.booleanValue();
			}
		}
		String status = getStatusCode();
		for (int i = 0; i < validStatus.length; i++) {
			if (validStatus[i].equals(status)) {
				result = true;
				break;
			}
		}

		if (postCondition) {
			postConditionResult.put(PC_CONTRACT_CLOSURE_STATE, new Boolean(result));
		} else if (!result) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0602, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		return result;
	}

	/* 
	 * Validates the closure date provided by the user 
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
	 * @param compareValues
	 * @return boolean
	 */
	private boolean validateClosureDate(HashMap compareValues) {
		boolean result = true;

		Date closureDate = (Date) compareValues.get(UtilityConstants.CONTRACT_CLS_DATE);
		Date relatedTPCPED = (Date) compareValues.get(UtilityConstants.CONTRACT_PERIOD_END);
		Date cntrCPSD = getContrStartPeriod();
		Date cntrCPED = getContrEndPeriod();
		Date amendEffDate = getAmendEffectiveDate();

		if (closureDate != null) {
			OPPTCalender calendar = new OPPTCalender();
			if (checkProposalType(ProposalTypeConstants.TP)) {
				if (!calendar.isDateGreater(closureDate, cntrCPSD)) {
					result = false;
					ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0609, OPPTMessageCatalog.TYPE_DOMAIN);
				}
				if (calendar.isDateGreater(closureDate, cntrCPED)) {
					result = false;
					ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0611, OPPTMessageCatalog.TYPE_DOMAIN);
				}
			} else {
				if (ContractTypeConstants.AMENDMENT.equals(getContrType()) && !calendar.isDateGreater(closureDate, amendEffDate)) {
					result = false;
					ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0612, OPPTMessageCatalog.TYPE_DOMAIN);
				} else if (calendar.isDateLesser(closureDate, OPPTCalender.getDayMinusOneSqlDate(cntrCPSD))) {
					result = false;
					ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0610, OPPTMessageCatalog.TYPE_DOMAIN);
				}
				if (relatedTPCPED != null && calendar.isDateGreater(relatedTPCPED, closureDate)) {
					String propName = (String) compareValues.get(UtilityConstants.RELATED_PNAME_FOR_OVERLAY);
					result = false;
					ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0613, OPPTMessageCatalog.TYPE_DOMAIN);
				}
				
				
				/* CR6153 start changes */
				if ( getExtendPeriod()!= null && getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD)) 
				{
					Date cntrPeriodStrtDate = getContrStartPeriod();
					Date cntrPeriodEndDate = getContrEndPeriod();
					Date cntrStrtDate = 	getContrStartDate();
					OPPTCalender startDateCalender = new OPPTCalender();
					OPPTCalender endDateCalender = new OPPTCalender();
					Date date = new Date();
					while(cntrPeriodEndDate.getTime()< date.getTime() && cntrPeriodEndDate.getTime() < getContrEndDate().getTime())
					{
						startDateCalender.setTime(OPPTCalender.addDate(OPPTCalender.YEAR, 1, cntrPeriodStrtDate));
						endDateCalender.setTime(OPPTCalender.addDate(OPPTCalender.YEAR, 1, cntrPeriodEndDate));
						if(endDateCalender.getYear()%4 == 0 &&(endDateCalender.getYear()%100 != 0 || endDateCalender.getYear()%400 == 0))  
						{
							if(startDateCalender.getMonth() == 3 && startDateCalender.getDay()== 1 && (getContrEndDate().getTime() > cntrPeriodEndDate.getTime()))
							{
								endDateCalender.set(endDateCalender.getYear(),endDateCalender.getMonth()-1,endDateCalender.getDay()+1 );
								// since month is 0 based in the set method, and starts from 1 in the get method, we subtract 1
							}
						}
					cntrPeriodStrtDate.setTime(startDateCalender.getTimeInMillis());									
					cntrPeriodEndDate.setTime(endDateCalender.getTimeInMillis());
					cntrStrtDate.setTime(startDateCalender.getTimeInMillis());	
					}
					cntrCPED = cntrPeriodEndDate;
				}
				
				/* CR6153 end changes */
				
				if (calendar.isDateGreater(closureDate, cntrCPED)) {
					result = false;
					ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0611, OPPTMessageCatalog.TYPE_DOMAIN);
					
				}
			}
		} else {
			result = false;
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0614, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		return result;
	}

	/** 
	 * Checks whether the user has authority to change the contract 
	 * 
	 * <br/><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO#validateUserAuthorityForChange(java.util.HashMap) 
	 * @param compareValues
	 * @return 
	 * 
	 */
	public boolean validateUserAuthorityForChange(HashMap compareValues) {
		boolean result = false;
		if (postCondition) {
			Boolean resultValue = (Boolean) postConditionResult.get(PC_USER_AUTH_FORCHANGE);
			if (resultValue != null) {
				return resultValue.booleanValue();
			}
		}

		String loggedUser = (String) compareValues.get(UtilityConstants.BO_USERID);
		String groupName = (String) compareValues.get(UtilityConstants.BO_GROUPNAME);
		if (loggedUser != null) {
			if (groupName == null && isLoggedUserCreatorOfProposal(loggedUser)) {
				result = true;
			} else if (groupName != null && isLockedByLoggedUser(loggedUser)) {
				result = true;
			}
		}

		if (postCondition) {
			postConditionResult.put(PC_USER_AUTH_FORCHANGE, new Boolean(result));
		} else if (!result) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0001, OPPTMessageCatalog.TYPE_DOMAIN);

		}
		return result;
	}

	/** 
	 * Checks whether the contract header/inventory can be changed
	 * 
	 * <br/><PRE> 
	 * date Jan 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO#checkStatusForChangeByPropAdmin(int) 
	 * @param typeOfChange
	 * @return boolean
	 * 
	 */
	protected boolean checkStatusForChangeByPropAdmin(int typeOfChange) {
		boolean result = false;
		String statusCode = null;
		if (postCondition) {
			Boolean resultValue = (Boolean) postConditionResult.get(PC_CONTRACT_CHANGE_PROPADMIN);
			if (resultValue != null) {
				return resultValue.booleanValue();
			}
		}
		statusCode = getStatusCode();
		if (ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT.equals(statusCode) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT.equals(statusCode)) {
			result = true;
		}

		if (postCondition) {
			postConditionResult.put(PC_CONTRACT_CHANGE_PROPADMIN, new Boolean(result));
		} else if (!result) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0602, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		return result;
	}

	/** 
	 * Checks for business rules and sets the contract data for revert
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
	 *  
	 */
	public void checkAndSetOldContractAfterRevert() {
		String statusCode = null;
		
		if (ContractTypeConstants.EXTENDED.equals(getContrType())) {
			statusCode = ProposalContractStatusConstants.EXTENDED;
		} else if (isContractInVariance()) {
		
			if (getContrPeriodVarNo() == 1) {
				statusCode = ProposalContractStatusConstants.CONTRACT;
			} else {
				statusCode = ProposalContractStatusConstants.VARIANCE_BILLED;
			}

			// Added by Balaji  
			setContrPeriodVarNo(getContrPeriodVarNo() - 1);
			if (null != getContrVarNo()) {
				setContrVarNo(String.valueOf(Integer.parseInt(getContrVarNo()) - 1));
			}
			setVarDate(null);
			setCapVariance(0);
			setCumValue(0);
			setVarInd(null);
			// changes ends


		} else {
			if (ProposalTypeConstants.ESSO.equals(getProposalType()) && getContrPeriodVarNo() != 0) {
				statusCode = ProposalContractStatusConstants.VARIANCE_BILLED;
			} else {
				statusCode = ProposalContractStatusConstants.CONTRACT;
			}
		}
		if (ProposalTypeConstants.EASII.equals(getProposalType())) {
			setTpContrNo(null);
		}
		setStatusCode(statusCode);
	}

	/** 
	 * Checks and sets the contract data after approver rejects request. 
	 * 
	 * <br/><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO#checkAndSetAfterRequestRejection() 
	 *  
	 * 
	 */
	public void checkAndSetAfterRequestRejection() {
		String cntrType = getContrType();
		String currentStatus = getStatusCode();
		String statusCode = null;

		if (ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL.equals(currentStatus)) {
			statusCode = ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT;
		} else if (ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL.equals(currentStatus)) {
			statusCode = ProposalContractStatusConstants.VARIANCE_CONTRACT;
			setContrClsDate(null);
		} else if (ProposalContractStatusConstants.EXTENDED_CONTRACT_PENDING_APPROVAL.equals(currentStatus)) {
			if (ProposalTypeConstants.ESSO.equals(getProposalType()) && getContrPeriodVarNo() != 0) {
				statusCode = ProposalContractStatusConstants.VARIANCE_BILLED;
			} else {
				statusCode = ProposalContractStatusConstants.CONTRACT;
			}

			setContractTypeForExtensionRejection();
			setContrEndPeriod(getContrRetrDate());
			setContrExtDate(null);
			setContrRetrDate(null);
		}
		setStatusCode(statusCode);
		// below code commented for defect BHALM00075905 related to pending approval(modified by Ramesh)
		//setLockedBy(null);
		//setLockedOn(null);
	}

	private void setContractTypeForExtensionRejection() {
		int renewCount = (new Double(getContrRenewNo())).intValue();
		String cntrTypeFromCntrNumber = getContrNo().substring(7, 8);

		if (cntrTypeFromCntrNumber.equals(ContractTypeConstants.REPLACEMENT)) {
			setContrType(ContractTypeConstants.REPLACEMENT);
		} else if (cntrTypeFromCntrNumber.equals(ContractTypeConstants.AMENDMENT)) {
			setContrType(ContractTypeConstants.AMENDMENT);
		} else {
			if (renewCount > 1) {
				setContrType(ContractTypeConstants.RENEWAL);
			} else {
				setContrType(ContractTypeConstants.ORIGINAL);
			}
		}
	}

	public boolean validateForCreateVarianceProposal(int type, HashMap compareValues) throws DomainException {
		boolean result = false;
		String[] validCreateVarianceProposalStatus = { ProposalContractStatusConstants.VARIANCE_BILLED, ProposalContractStatusConstants.CONTRACT };

		boolean validProposalType = ProposalTypeConstants.ESSO.equals(getProposalType()) ? true : false;
		boolean positiveCapVariance = 0 < getCapVariance() ? true : false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
			if (validateUserAuthorityForChange(compareValues)) {
				if (validateProposalStatus(validCreateVarianceProposalStatus)) {
					if (validProposalType) {
						if (positiveCapVariance) {
							result = true;
						}
					}
				}
			}

			if (!result) {
				// add for buttons
				//postConditionResult
			}
		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = validateProposalStatus(validCreateVarianceProposalStatus);

			boolean notValidLastContract = false;

			if (null != compareValues.get(UtilityConstants.BO_STATUS_OF_LAST_CONTRACT)) {
				String status = (String) compareValues.get(UtilityConstants.BO_STATUS_OF_LAST_CONTRACT);
				if (ProposalContractStatusConstants.CHECK_CLOSURE_STATUS.equals(status) || ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL.equals(status)) {
					ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0013, OPPTMessageCatalog.TYPE_SERVICE);
					notValidLastContract = true;
				}
			}

			if (!secondResult) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0002, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			if (!validProposalType) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0045, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			if (!positiveCapVariance) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0046, OPPTMessageCatalog.TYPE_DOMAIN);
			}

			result = firstResult && secondResult && validProposalType && positiveCapVariance && (!notValidLastContract);
		}
		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return result;
	}

	/** 
	 * Checks and sets the contract data after approval 
	 * 
	 * <br/><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO#checkAndSetAfterRequestApproval() 
	 *  
	 * 
	 */
	public void checkAndSetAfterRequestApproval() {
		String cntrType = getContrType();
		String statusCode = null;
		boolean unLock = true;
		if (ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT.equals(getStatusCode())) {
		//if (ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL.equals(getStatusCode())) {// commented by ramesh
			statusCode = ProposalContractStatusConstants.CHECK_AMENDED_CONTRACT_STATUS;
		} else if (isContractinClosure()) {
			statusCode = ProposalContractStatusConstants.CHECK_CLOSURE_STATUS;
		} else if (isContractInExtension()) {
			statusCode = ProposalContractStatusConstants.CHECK_EXTENSION_STATUS;
		} else if (isContractInRenewal()) {
			statusCode = ProposalContractStatusConstants.CHECK_RENEW_STATUS;
			unLock = false;
		} else if (isContractInReplacement()) {
			statusCode = ProposalContractStatusConstants.CHECK_REPLACEMENT_STATUS;
			unLock = false;
		} else if (isContractInVariance()) {
			statusCode = ProposalContractStatusConstants.CHECK_VARIANCE_STATUS;
			unLock = false;
		}
		setStatusCode(statusCode);
		if (unLock) {
			setLockedBy(null);
			setLockedOn(null);
		}
	}

	public void validateProposalDetails(int type, HashMap map) throws DomainException {
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (postCondition == false) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition == false) {
			map.put(UtilityConstants.PROPOSAL_DETAILS_EDITABLE, new Boolean(validateUserAuthorityForChange(map)));
		} else {
			super.validateProposalDetails(type, map);

			validateForPricing(type, map);
			validateForRegistration(type, map);
			validateForAmendSWO(type, map);
			validateDeltaFetch(type, map);

			postConditionResult.put(ButtonConstants.ADDCUSTOMER_BUTTON, ButtonConstants.ADDCUSTOMER_BUTTON);
		}
	}

	/**
		 * To check whether variance check is done or not.
		 * 
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Mar 22, 2004 
		 * 
		 *  
		 * 
		 * </PRE><br> 
		 * 
		 * @return boolean
	 */
	public boolean isVarianceCheckDoneForContract() throws DomainException {

		boolean isVarianceCheckDone = false;

		// To check whether Cap Variance is empty or not.if Cap Variance amount is empty then variance check is not done.   

		if (getVarInd() != null && (getVarInd().equals(UtilityConstants.CREATE_VARIANCE) || getVarInd().equals(UtilityConstants.SIMULATE_VARIANCE)) && getCapVariance() != 0) {
			isVarianceCheckDone = true;
		}

		return isVarianceCheckDone;

	} //end of isVarianceCheckDone
}