/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;


import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalStatusCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * This class checks the business condition against ProposalBDO attributes.
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Nov 22, 2003
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Balaji Venkatesan
 * @version 5.1A
 */
public class ProposalContractBO extends ProposalBDO implements
		ProposalContractBOPostCondConstants, Serializable {
	protected boolean postCondition = false;

	public HashMap postConditionResult = null;

	protected boolean preCondition = false;

	protected ErrorReport errorReport = new ErrorReport();

	protected static final int HEADER = 100;

	protected static final int INVENTORY = 101;

	private boolean isReplaceNewProposal = false;
	
	private final static String[] VALID_PROPOSAL_STATUS = {
			ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS,
			ProposalContractStatusConstants.DRAFT,
			ProposalContractStatusConstants.PRICED,
			ProposalContractStatusConstants.PENDING_APPROVAL,
			ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS,
			ProposalContractStatusConstants.VARIANCE_REJECTED };

	/**
	 * This method will tell us wether the object is a Proposal or a Contract
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 15, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @return
	 */
	public boolean isProposal() {
		String proposalStatus = getStatusCode();
		boolean isProposal = false;

		if (proposalStatus != null) {
			proposalStatus = proposalStatus.trim();

			for (int i = 0; i < VALID_PROPOSAL_STATUS.length; i++) {
				if (VALID_PROPOSAL_STATUS[i].equals(proposalStatus)) {
					isProposal = true;
					break;
				}
			}
		}

		return isProposal;
	}

	/**
	 * To check the lock status and access mode
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 18, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param aUserID
	 * @return whether the user is locked the proposal/contract or has full
	 *         access to that
	 * @throws ServiceException
	 */
	public boolean checkUserAndAuthority(HashMap compareValues)
			throws DomainException {
		boolean result = false;

		String loggedUser = (String) compareValues
				.get(UtilityConstants.BO_USERID);
		String groupName = (String) compareValues
				.get(UtilityConstants.BO_GROUPNAME);

		if (loggedUser != null) {
			if (groupName != null) {
				result = isLockedByLoggedUser(loggedUser);
			} else if (isLoggedUserCreatorOfProposal(loggedUser)) {
				String propShare = getProposalSharing();

				if (propShare != null) {
					result = UtilityConstants.CREATOR_FULL_MODE
							.equals(propShare);
				}
			}
		}

		return result;
	}

	/**
	 * This method checks inventory is edited Irrespective of Proposal/Contract
	 * 
	 * <br/><b>Known Bugs </b> <br/>
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Dec 22, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @author Ravishankar J
	 * @version 5.1A
	 */
	public void validateEditInventory(int type, HashMap values)
			throws DomainException {
		boolean isEdited = false;
		boolean result = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(values)) {
				//Checking for proposal other than EAS II. Boolean false is
				// sent to say other than EAS II
				if (isValidProposalType(ProposalTypeConstants.EASII,
						PC_EASII_PROPOSAL, false)) {
					if ((ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
									.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(getStatusCode()))
							&& !(isVarianceProposal())) {

						result = true;
					}
				}

			}

			if (result == false) {
				postConditionResult.put(ButtonConstants.EDIT_INVENTORY,
						ButtonConstants.EDIT_INVENTORY);
			}

		} else {

			if (isValidProposalType(ProposalTypeConstants.EASII,
					PC_EASII_PROPOSAL, false)) {
				if ((ProposalContractStatusConstants.DRAFT
						.equals(getStatusCode())
						|| ProposalContractStatusConstants.PRICED
								.equals(getStatusCode())
						|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
								.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(getStatusCode()))
						&& !(isVarianceProposal())) {
					isEdited = true;
				}
			}
		}

		if (!isEdited && !postCondition) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0102, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
	}

	/**
	 * 
	 * This method validates the copy inventory
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 27, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param values
	 * @throws DomainException
	 */
	public void validateCopyInventory(int type, HashMap values)
			throws DomainException {
		boolean isCopied = false;
		boolean result = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(values)) {
				//Checking for proposal other than EAS II. Boolean false is
				// sent to say other than EAS II
				if (isValidProposalType(ProposalTypeConstants.EASII,
						PC_EASII_PROPOSAL, false)) {
					if ((ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
									.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(getStatusCode()))
							&& !(isVarianceProposal())) {
						result = true;
					}
				}
			}

			if (result == false) {
				postConditionResult.put(ButtonConstants.COPY_NEW,
						ButtonConstants.COPY_NEW);
			}
		} else {

			if (isValidProposalType(ProposalTypeConstants.EASII,
					PC_EASII_PROPOSAL, false)) {
				if ((ProposalContractStatusConstants.DRAFT
						.equals(getStatusCode())
						|| ProposalContractStatusConstants.PRICED
								.equals(getStatusCode())
						|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
								.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(getStatusCode()))
						&& !(isVarianceProposal())) {
					isCopied = true;
				}
			}
		}

		if (!isCopied && !postCondition) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0103, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
	}

	/**
	 * Is Proposal/Contract created by the Logged user.
	 * 
	 * <br/><b>Known Bugs </b> <br/>
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Jan 2, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @author prakash
	 * @version 5.1A
	 */

	public boolean isCreatedByLoggedUser(String userId) {
		return (getCreatedBy().trim().equalsIgnoreCase(userId.trim())) ? true
				: false;
	}

	/**
	 * Checks whether the logged user locked the proposal/contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param loggedUser
	 * @return boolean
	 */

	protected boolean isLocked() {
		return (null != getLockedBy()) ? true : false;
	}

	protected boolean isLockedByLoggedUser(String loggedUser) {

		if (null != getLockedBy() && loggedUser.equals(getLockedBy().trim())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the logged user is creator of the proposal/contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param loggedUser
	 * @return boolean
	 */
	protected boolean isLoggedUserCreatorOfProposal(String loggedUser) {
		if (loggedUser.equals(getCreatedBy().trim())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the logged user is submitter of the proposal/contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param loggedUser
	 * @return boolean
	 */
	protected boolean isLoggedUserSubmitterOfProposal(String loggedUser) {
		if (loggedUser.equals(getSubmittedBy())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the logger user is the approver of the proposal/contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param loggedUser
	 * @return boolean
	 */
	public boolean isLoggedUserApproverOfProposal(String loggedUser) {
		if (null != getApprovedBy()
				&& loggedUser.equals(getApprovedBy().trim())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks the type of the proposal/contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param compareValue
	 * @return boolean
	 */
	protected boolean checkProposalType(String compareValue) {
		boolean result = false;
		if (compareValue.equals(getProposalType().trim())) {
			result = true;
		}
		return result;
	}

	/**
	 * Creates an ErrorEntry and adds it to the ErrorReport
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param msgID
	 */
	protected void addErrorEntry(String msgID) {
		ErrorKey errorKey = new ErrorKey(msgID, OPPTMessageCatalog.TYPE_SERVICE);
		errorReport.addErrorEntry(errorKey, null);
	}

	/**
	 * Method needs to be implemented by the sub class. By default returns true;
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param compareValues
	 * @return boolean
	 */
	public boolean validateUserAuthorityForChange(HashMap compareValues) {
		return true;
	}

	/**
	 * Validates the request for proposal type. If the boolean is true, checks
	 * whether the proposal's type is same as that of value of the param
	 * proposalTypeToCheck. If boolean is false, checks whether it is not same
	 * as that of param proposalTypeToCheck
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param proposalTypeToCheck
	 * @param ruleName
	 * @param isAllowedOrNot
	 * @return boolean
	 */
	protected boolean isValidProposalType(String proposalTypeToCheck,
			String ruleName, boolean isAllowedOrNot) {
		boolean result = false;
		boolean tempResult;

		if (postCondition) {
			Boolean resultValue = (Boolean) postConditionResult.get(ruleName);
			if (resultValue != null) {
				return resultValue.booleanValue();
			}
		}
		tempResult = checkProposalType(proposalTypeToCheck);

		// If both the result obtained and requested are same..return true.
		if (!(tempResult ^ isAllowedOrNot)) {
			result = true;
		}
		if (postCondition) {
			postConditionResult.put(ruleName, new Boolean(result));
		}
		return result;
	}

	/**
	 * Checks whether Include/Exclude operation can be performed
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 15, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 */
	public boolean validateForIncludeExclude(int type, HashMap compareValues)
			throws DomainException {
		boolean result = false;

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (ProposalContractStatusConstants.DRAFT
						.equals(getStatusCode())
						|| ProposalContractStatusConstants.PRICED
								.equals(getStatusCode())) {
					if (isValidProposalType(ProposalTypeConstants.EAS,
							PC_EAS_PROPOSAL, true)) {
						result = true;
					}
					if (isValidProposalType(ProposalTypeConstants.PLA,
							PC_EAS_PROPOSAL, true)) {
						result = true;
					}
				}
			}

			if (result == false) {
				postConditionResult.put(ButtonConstants.INCLUDE_EXCLUDE,
						ButtonConstants.INCLUDE_EXCLUDE);
			}

		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = checkStatusForChangeByPropAdmin(INVENTORY);
			boolean thirdResultForEAS = isValidProposalType(
					ProposalTypeConstants.EAS, PC_EAS_PROPOSAL, true);
			boolean thirdResultForPLA = isValidProposalType(
					ProposalTypeConstants.PLA, PC_EAS_PROPOSAL, true);
			if (!(thirdResultForEAS||thirdResultForPLA)) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0605,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			result = firstResult & secondResult & (thirdResultForEAS||thirdResultForPLA);
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return result;
	}

	/**
	 * Method needs to be implemented by the sub class. By default returns true;
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 11, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param typeOfChange
	 * @return boolean
	 */
	protected boolean checkStatusForChangeByPropAdmin(int typeOfChange) {
		return true;
	}

	/**
	 * Checks whether the SWO and EE details can be changed
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 15, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 */
	public boolean validateForChangeSWO(int type, HashMap compareValues)
			throws DomainException {
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
					if (!isVarianceProposalOrContract()) {
						if (isValidProposalType(ProposalTypeConstants.EASII,
								PC_OTHERTHANEASII_PROPOSAL, false)) {
							result = true;
						}
					}
				}

			}
		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = checkStatusForChangeByPropAdmin(INVENTORY);
			boolean thirdResult = isVarianceProposalOrContract();
			if (thirdResult) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0603,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			boolean fourthResult = isValidProposalType(
					ProposalTypeConstants.EASII, PC_OTHERTHANEASII_PROPOSAL,
					false);
			if (!fourthResult) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0604,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			result = firstResult & secondResult & !thirdResult & fourthResult;
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return result;
	}

	/**
	 * Checks whether it is a variance proposal or contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 12, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @return boolean
	 */
	protected boolean isVarianceProposalOrContract() {
		boolean result = false;
		if (ContractTypeConstants.VARIANCE.equals(getContrType().trim())) {
			return true;
		}
		return result;
	}

	/**
	 * Validates the request for removing SVC Licenses from proposal/contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 8, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 */
	public boolean validateRemoveSVC(int type, HashMap compareValues)
			throws DomainException {
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
					//Checking for proposal other than EAS II. Boolean false is
					// sent to say other than EAS II
					if (isValidProposalType(ProposalTypeConstants.EASII,
							PC_OTHERTHANEASII_PROPOSAL, false)) {
						result = true;
					}
				}
			}

			if (result == false) {
				postConditionResult.put(ButtonConstants.REMOVE_SVC_LICENSES,
						ButtonConstants.REMOVE_SVC_LICENSES);
			}
		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = checkStatusForChangeByPropAdmin(INVENTORY);
			boolean thirdResult = isValidProposalType(
					ProposalTypeConstants.EASII, PC_OTHERTHANEASII_PROPOSAL,
					false);
			if (!thirdResult) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0604,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			result = firstResult & secondResult & thirdResult;
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return result;
	}

	/**
	 * This method takes valid status and compares with the status of the
	 * proposal <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 17, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param compareValues
	 * @param validStatus
	 * @return
	 */
	public boolean validateProposalStatus(String validStatus[]) {
		boolean result = false;
		for (int i = 0; i < validStatus.length; i++) {
			if (validStatus[i].equals(getStatusCode().trim())) {
				result = true;
				break;
			}
		}

		return result;
	}

	public boolean validateContractType(String validTypes[]) {
		boolean result = false;
		for (int i = 0, j = validTypes.length; i < j; i++) {
			if (validTypes[i].equals(getContrType().trim())) {
				result = true;
			}
		}
		return result;
	}

	public boolean validateProposalType(String validTypes[]) {
		boolean result = false;
		for (int i = 0, j = validTypes.length; i < j; i++) {
			if (validTypes[i].equals(getProposalType().trim())) {
				result = true;
			}
		}
		return result;
	}

	protected boolean validateRole(int[] validRole, int userRole) {
		boolean result = false;
		for (int i = 0, j = validRole.length; i < j; i++) {
			if (validRole[i] == userRole) {
				result = true;
			}
		}
		return result;
	}

	public void validateForContractDates(boolean isPreCondition)
			throws DomainException {
		preCondition = isPreCondition;

		if (preCondition) {
			errorReport.clear();
		}

		validateContractDates(false);

		if (preCondition) {
			if (errorReport.size() > 0) {
				throw ExceptionGenerator.generateDomainException(errorReport);
			}
		} else if (errorReport.size() > 0) {
			postConditionResult.put(ButtonConstants.REPLACE,
					ButtonConstants.REPLACE);
			postConditionResult.put(ButtonConstants.EXTEND,
					ButtonConstants.EXTEND);
		}

	}

	/**
	 * 
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 19, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param validStatus
	 * @param proposalStatus
	 * @return
	 */
	private boolean validateWith(String[] values, String compareValue) {
		boolean result = false;

		for (int i = 0; i < values.length; i++) {
			if (values[i].equals(compareValue)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public boolean validateProposalType(HashMap compareValues, String types[]) {
		String proposalType = (String) compareValues
				.get(UtilityConstants.PROPOSAL_TYPE);

		return validateWith(types, proposalType);
	}

	public boolean validateContractType(HashMap compareValues, String types[]) {
		String contractType = (String) compareValues
				.get(UtilityConstants.CONTRACT_TYPE);
		return validateWith(types, contractType);
	}

	/**
	 * 
	 * 
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 19, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return
	 * @throws DomainException
	 */
	public boolean validateTP(int type, HashMap compareValues)
			throws DomainException {
		boolean isValid = true;

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (postCondition == false) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		String[] proposalStatus = { ProposalContractStatusConstants.PRICED,
				ProposalContractStatusConstants.DRAFT };

		compareValues.put(UtilityConstants.CONTRACT_TYPE, getContrType());
		compareValues.put(UtilityConstants.PROPOSAL_TYPE, getProposalType());

		if (checkUserAndAuthority(compareValues) == false) {
			isValid = false;
			errorReport = ExceptionGenerator.addErrorEntry(null,
					ErrorCodeConstants.DE0001, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		try {
			if (validateTPType(type, compareValues) == false) {
				isValid = false;
			}
		} catch (DomainException ex) {
			isValid = false;
			// ignore this exception
		}

		if (validateProposalStatus(proposalStatus) == false) {
			isValid = false;
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0300, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		if (postCondition) {
			if (isValid == false) {
				postConditionResult.put(ButtonConstants.VALIDATE_TP,
						ButtonConstants.VALIDATE_TP);
			}
		} else if (isValid == false) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return isValid;
	}

	/**
	 * 
	 * 
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 19, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return
	 * @throws DomainException
	 */
	public boolean validateTPType(int type, HashMap compareValues)
			throws DomainException {
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (postCondition == false) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		boolean isValid = true;

		String[] proposalType = { ProposalTypeConstants.TP };

		if (validateProposalType(compareValues, proposalType) == false) {
			isValid = false;
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0301, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		if (isValid == false && postCondition == false) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return isValid;
	}

	public boolean validateTPOriginal(int type, HashMap compareValues)
			throws DomainException {
		String[] contractTypes = { ContractTypeConstants.ORIGINAL };
		return validateTPOriginalorRenewal(type, contractTypes, compareValues);
	}

	public boolean validateTPRenewal(int type, HashMap compareValues)
			throws DomainException {
		String[] contractTypes = { ContractTypeConstants.RENEWAL };
		return validateTPOriginalorRenewal(type, contractTypes, compareValues);
	}

	private boolean validateTPOriginalorRenewal(int type, String[] types,
			HashMap compareValues) throws DomainException {
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (postCondition == false) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		boolean isValid = true;

		if (validateContractType(compareValues, types) == false) {
			isValid = false;
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0302, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		if (isValid == false && postCondition == false) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return isValid;

	}

	public boolean isUserInGroup(HashMap compareValues) {
		boolean result = false;
		String groupName = (String) compareValues
				.get(UtilityConstants.BO_GROUPNAME);
		if (groupName == null) {
			result = false;
		} else {
			result = true;
		}

		return result;

	}

	public boolean validateForDisplayProposalHeader(int type,
			HashMap compareValues) throws DomainException {
		boolean result = false;
		String[] validDisplayProposalHeaderStatus = {
				ProposalContractStatusConstants.PENDING_APPROVAL,
				ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS };

		boolean validStatus = validateProposalStatus(validDisplayProposalHeaderStatus);
		boolean proposalLockedByUser = isLockedByLoggedUser((String) compareValues
				.get(UtilityConstants.BO_USERID));
		boolean userInGroup = isUserInGroup(compareValues);
		boolean isProposal = isProposal();
		int role = 0;
		String sharing = (String) compareValues
				.get(UtilityConstants.BO_SHARING);
		if (compareValues.get(UtilityConstants.BO_ROLE) != null) {
			role = ((Integer) compareValues.get(UtilityConstants.BO_ROLE))
					.intValue();
		}

		if (isProposal && (userInGroup && proposalLockedByUser)
				|| ((!userInGroup) && proposalLockedByUser && validStatus)
				|| ((!userInGroup) && validStatus)) {
			result = true;
		}
		if (isProposal && userInGroup && (!proposalLockedByUser)) {
			result = true;
		}

		if (role == RoleConstants.BHD
				&& UtilityConstants.SHARED_READ_MODE.equals(sharing)|| role==RoleConstants.OPPT_READ && UtilityConstants.SHARED_READ_MODE.equals(sharing)) {
			result = true;
		}

		if (!isProposal) {
			result = true;
		}

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}

			validateRequestForApproveOrReject(type, compareValues);
			if (isProposal) {
				if (!userInGroup) {
					postConditionResult.put(ButtonConstants.HEADER_DETAILS,
							ButtonConstants.HEADER_DETAILS);
				}

				if (userInGroup && proposalLockedByUser) {
					postConditionResult.put(ButtonConstants.HEADER_DETAILS,
							ButtonConstants.HEADER_DETAILS);
				}
			} else {
				String[] contractChangeStatus = {
						ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT,
						ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT };
				boolean isValidContractChangeState = validateProposalStatus(contractChangeStatus);
				if (isValidContractChangeState) {
					postConditionResult.put(ButtonConstants.HEADER_DETAILS,
							ButtonConstants.HEADER_DETAILS);
				}
			}
		}

		if (!postCondition && !result) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0001, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return true;
	}

	/**
	 * This validation will be called for change proposal or contract <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 22, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return
	 * @throws DomainException
	 */
	public boolean validateForChangeProposalHeader(int type,
			HashMap compareValues) throws DomainException {
		boolean result = false;
		boolean isUserAuthorized = false;
		boolean validProposalStatus = false;

		String[] validDisplayProposalHeaderStatus = {
				ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS,
				ProposalContractStatusConstants.DRAFT,
				ProposalContractStatusConstants.PRICED,
				ProposalContractStatusConstants.VARIANCE_REJECTED,
				ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT,
				ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT };

		validProposalStatus = validateProposalStatus(validDisplayProposalHeaderStatus);
		isUserAuthorized = validateUserAuthorityForChange(compareValues);
		result = validProposalStatus & isUserAuthorized;

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition && (!result)) {
			postConditionResult.put(ButtonConstants.CHANGEPROPOSAL_BUTTON,
					ButtonConstants.CHANGEPROPOSAL_BUTTON);
		} else {
			if (!validProposalStatus) {
				// ADD EXCEPTION
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0002,
						OPPTMessageCatalog.TYPE_DOMAIN);

			}
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return true;
	}

	public boolean isVarianceProposal() {
		boolean result = false;
		if (ProposalTypeConstants.ESSO.equals(getProposalType().trim())
				&& ContractTypeConstants.VARIANCE.equals(getContrType())) {
			result = true;

		}
		return result;
	}

	/**
	 * Checks whether the proposal approver is allowed to approve or reject the
	 * proposal/contract request
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 23, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @return boolean
	 */
	protected boolean checkStatusForApproveOrRejectByPropApprover() {
		boolean result = false;
		String statusCode = null;
		String[] validStatus = {
				ProposalContractStatusConstants.PENDING_APPROVAL,
				ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL,
				ProposalContractStatusConstants.EXTENDED_CONTRACT_PENDING_APPROVAL,
				ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL };

		if (postCondition) {
			Boolean resultValue = (Boolean) postConditionResult
					.get(PC_PROPOSAL_CHANGE_PROPAPPV);
			if (resultValue != null) {
				return resultValue.booleanValue();
			}
		}
		statusCode = getStatusCode();
		for (int i = 0; i < validStatus.length; i++) {
			if (validStatus[i].equals(statusCode)) {
				result = true;
				break;
			}
		}

		if (postCondition) {
			postConditionResult.put(PC_PROPOSAL_CHANGE_PROPAPPV, new Boolean(
					result));
		} else if (!result) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0602, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		return result;
	}

	/**
	 * Validates user authority for approval or rejection
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 23, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param compareValues
	 * @return boolean
	 */
	protected boolean validateUserAuthForApproveOrReject(HashMap compareValues) {
		boolean result = false;
		if (postCondition) {
			Boolean resultValue = (Boolean) postConditionResult
					.get(PC_USER_AUTH_FORAPPORREJ);
			if (resultValue != null) {
				return resultValue.booleanValue();
			}
		}

		String loggedUser = (String) compareValues
				.get(UtilityConstants.BO_USERID);
		String groupName = (String) compareValues
				.get(UtilityConstants.BO_GROUPNAME);
		int role = ((Integer) compareValues.get(UtilityConstants.BO_ROLE))
				.intValue();

		if (loggedUser != null) {
			if (!isLoggedUserCreatorOfProposal(loggedUser) && groupName == null
					&& isLoggedUserApproverOfProposal(loggedUser)
					&& !isLoggedUserSubmitterOfProposal(loggedUser)) {
				result = true;
			}
			if (groupName != null && !isLoggedUserCreatorOfProposal(loggedUser)
					&& !isLoggedUserSubmitterOfProposal(loggedUser)) {
				if (role != RoleConstants.CREATE_APPROVE
						&& isLockedByLoggedUser(loggedUser)) {
					result = true;
				} else if (role == RoleConstants.CREATE_APPROVE
						&& isLoggedUserApproverOfProposal(loggedUser)) {
					result = true;
				}
			}
		}

		if (postCondition) {
			postConditionResult.put(PC_USER_AUTH_FORAPPORREJ, new Boolean(
					result));
		} else if (!result) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0606, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		return result;
	}

	/**
	 * Validates the request for approval or rejection
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 23, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 */
	public boolean validateRequestForApproveOrReject(int type,
			HashMap compareValues) throws DomainException {
		boolean result = false;

		result = validateUserAuthForApproveOrReject(compareValues)
				& checkStatusForApproveOrRejectByPropApprover();

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}

			if (!result) {
				postConditionResult.put(ButtonConstants.APPROVE,
						ButtonConstants.APPROVE);
				postConditionResult.put(ButtonConstants.REJECT,
						ButtonConstants.REJECT);
			}

		}
		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return result;
	}

	/**
	 * Validates the request for Releasing the lock from a Proposal/Contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 23, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 */
	public boolean validateForRelease(HashMap compareValues)
			throws DomainException {
		String groupName = (String) compareValues
				.get(UtilityConstants.BO_GROUPNAME);
		String loggedUser = (String) compareValues
				.get(UtilityConstants.BO_USERID);

		boolean isLockedByUser = false;
		errorReport = new ErrorReport();

		if ((null != groupName && groupName.trim().length() > 0) == false) {
			errorReport = ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0421, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		if (null != getLockedBy() && getLockedBy().trim().length() > 0) {
			if (getLockedBy().trim().equals(loggedUser) == false) {
				errorReport = ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0423,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		} else {
			errorReport = ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0425, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		if (errorReport.size() > 0) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return true;
	}

	/**
	 * Validates the request for Locking a Proposal/Contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 23, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 */

	public boolean validateForLock(HashMap compareValues)
			throws DomainException {

		boolean lockProposalContract = false;

		String groupName = (String) compareValues
				.get(UtilityConstants.BO_GROUPNAME);
		Integer role = (Integer) compareValues.get(UtilityConstants.USER_ROLE);
		String accessToLoggedUser = (String) compareValues
				.get(UtilityConstants.BO_SHARING);
		String loggedUser = (String) compareValues
				.get(UtilityConstants.BO_USERID);

		String[] inValidStatus = {
				ProposalContractStatusConstants.PENDING_APPROVAL, 
				ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL,
				ProposalContractStatusConstants.EXTENDED_CONTRACT_PENDING_APPROVAL,
				ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL 
				};
		int[] inValidRole = { RoleConstants.CSO, RoleConstants.MARKETING_REP,
				RoleConstants.CREATE_APPROVE, RoleConstants.BHD,RoleConstants.OPPT_READ,
				RoleConstants.BUSINESS_PARTNER };

		boolean rule4 = false;

		boolean rule1 = isLocked();
		boolean rule2 = (null != groupName) ? true : false;
		boolean rule3 = false;
		//EF0701056256 Fixed by Balaji, proposal should have full access to the
		// logged user
		if (null != getProposalSharing() && null != accessToLoggedUser) {
			if (UtilityConstants.SHARED_READ_MODE.equals(accessToLoggedUser)) {
				rule3 = true;
			}
		}
		//boolean rule3 =
		// (UtilityConstants.SHARED_FULL_MODE.equals(getProposalSharing()) ||
		// UtilityConstants.SHARED_READ_MODE.equals(accessToLoggedUser)) ? true
		// : false;

		// CSO, NMarketing, Create Approve, BHD, BP < -- these are not valid
		// roles
		// Proposal Approve, Security Officer and Manager <- valid roles

		if (validateRole(inValidRole, role.intValue())) {
			if (validateProposalStatus(inValidStatus)) {
				// below code commented for defect BHALM00075905 related to pending approval(modified by Ramesh)
				//rule4 = true;
				rule4 = false;
			}
		}

		if (rule1) {
			if (isLockedByLoggedUser(loggedUser)) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0420,
						OPPTMessageCatalog.TYPE_DOMAIN);
			} else {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0423,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		}

		if (!rule2) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0421, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (rule3) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0418, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (rule4) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0422, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		if (!rule1 && rule2 && !rule3 && !rule4) {
			lockProposalContract = true;
		}

		if (!lockProposalContract) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return lockProposalContract;
	}

	/**
	 * Method needs to be implemented by the sub-class
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 23, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 *  
	 */
	public void checkAndSetAfterRequestRejection() {
		return;
	}

	/**
	 * 
	 * This method will be used to validate the data given by the user during
	 * proposal creation, and change The method signature is diffrent because of
	 * its purpose.There are no POST OR PRE Conditions and it is a Straight
	 * Validate Method creation
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 13, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @throws ServiceException
	 */

	public void validateProposalHeader(boolean changeProposal)
			throws DomainException {

		validateProposalTypes(changeProposal);
		validateBillingFrequency(changeProposal);
		if (!isVarianceProposal()) {
			validateContractDates(changeProposal);
		}
		validatePricingInformation(changeProposal);
		validateCapVariance(changeProposal);
		validateOtherProposalData(changeProposal);

		if (errorReport.size() > 0) {
			throw ExceptionGenerator.generateDomainException(errorReport);

		}

	}

	/**
	 * This is to validate proposal types business rules <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 13, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 */

	private void validateProposalTypes(boolean changeProposal) {
		/**
		 * EF 7497 Defect 357(SGOs cannot be created for Canada) changed by
		 * Balaji
		 */
		if ((!(SalesOrgConstants.USA.equals(getSalesOrg())
				|| SalesOrgConstants.CANADA.equals(getSalesOrg()) || SalesOrgConstants.BRAZIL
				.equals(getSalesOrg())))
				&& ProposalTypeConstants.SGO.equals(getProposalType())) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0040, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		//		Fixed for EF0615057555 BY Lakshmanan Thirumalaikumar
		/*
		 * if (SalesOrgConstants.JAPAN.equals(getSalesOrg()) &&
		 * (ProposalTypeConstants.AMO.equals(getProposalType()) ||
		 * ProposalTypeConstants.ELITE.equals(getProposalType()) ||
		 * ProposalTypeConstants.EGO.equals(getProposalType()))) {
		 * 
		 * ExceptionGenerator.addErrorEntry(errorReport,
		 * ErrorCodeConstants.DE0041, OPPTMessageCatalog.TYPE_DOMAIN); }
		 */
		if ((SalesOrgConstants.JAPAN.equals(getSalesOrg()) || SalesOrgConstants.USA
				.equals(getSalesOrg()))
				&& ProposalTypeConstants.NUEV.equals(getProposalType())) {

			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0041, OPPTMessageCatalog.TYPE_DOMAIN);
		}
	}

	/**
	 * This method validates the business rules for billing frequency along with
	 * proposal types <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 13, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 */

	private void validateBillingFrequency(boolean changeProposal) {
		if (ProposalTypeConstants.EAS.equals(getProposalType())
				&& UtilityConstants.BILLING_FREQ_SEMIANNUAL
						.equals(getBillingFreqCode())) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0042, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		if (ProposalTypeConstants.AMO.equals(getProposalType())
				&& (!(SalesOrgConstants.JAPAN.equals(getSalesOrg()) || SalesOrgConstants.USA
						.equals(getSalesOrg())))
				&& (!(UtilityConstants.BILLING_FREQ_QUARTERLY
						.equals(getBillingFreqCode()) || UtilityConstants.BILLING_FREQ_MONTHLY
						.equals(getBillingFreqCode())))) {
			// May have quartely
			if (!UtilityConstants.SANDS_ONLY.equals(getProposalContent())) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0042,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		}

		if (ProposalTypeConstants.AMO.equals(getProposalType())
				&& SalesOrgConstants.USA.equals(getSalesOrg())
				&& (!UtilityConstants.BILLING_FREQ_MONTHLY
						.equals(getBillingFreqCode()))
				&& (!UtilityConstants.SANDS_ONLY.equals(getProposalContent()))) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0004, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (ProposalTypeConstants.ELITE.equals(getProposalType())
				&& (!UtilityConstants.BILLING_FREQ_QUARTERLY
						.equals(getBillingFreqCode()))) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0042, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (ProposalTypeConstants.EGO.equals(getProposalType())
				&& (!UtilityConstants.BILLING_FREQ_ANNUAL
						.equals(getBillingFreqCode()))) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0042, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (ProposalTypeConstants.SGO.equals(getProposalType())
				&& (!UtilityConstants.BILLING_FREQ_MONTHLY
						.equals(getBillingFreqCode()))
				&& (!(SalesOrgConstants.CANADA.equals(getSalesOrg()) || SalesOrgConstants.BRAZIL
						.equals(getSalesOrg())))) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0042, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (ProposalTypeConstants.SGO.equals(getProposalType())
				&& (!(UtilityConstants.BILLING_FREQ_MONTHLY
						.equals(getBillingFreqCode()) || UtilityConstants.BILLING_FREQ_QUARTERLY
						.equals(getBillingFreqCode())))
				&& (SalesOrgConstants.CANADA.equals(getSalesOrg()) || SalesOrgConstants.BRAZIL
						.equals(getSalesOrg()))) {

			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0042, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (ProposalTypeConstants.TP.equals(getProposalType())
				&& (!UtilityConstants.BILLING_FREQ_QUARTERLY
						.equals(getBillingFreqCode()))) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0042, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (ProposalTypeConstants.NUEV.equals(getProposalType())
				&& UtilityConstants.BILLING_FREQ_SEMIANNUAL
						.equals(getBillingFreqCode())) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0042, OPPTMessageCatalog.TYPE_DOMAIN);
		}

		// S And S
		if (isSAndSProposal()) {
			if (UtilityConstants.SANDS_ONLY.equals(getProposalContent())) {
				if (!UtilityConstants.BILLING_FREQ_ANNUAL
						.equals(getBillingFreqCode())) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0048,
							OPPTMessageCatalog.TYPE_DOMAIN);
				}
			}
		}
	}

	/**
	 * This method validates the contract dates entered
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 13, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 *  
	 */
	private void validateContractDates(boolean changeProposal) {
		OPPTCalender calPeriodEnd = new OPPTCalender();
		OPPTLogger.debug("getContrEndPeriod() " + getContrEndPeriod(),
				"ProposalContractBO", "validateContractDates");
		OPPTLogger.debug("getContrEndDate() " + getContrEndDate(),
				"ProposalContractBO", "validateContractDates");
		OPPTLogger.debug("getContrStartPeriod() " + getContrStartPeriod(),
				"ProposalContractBO", "validateContractDates");
		OPPTLogger.debug("getContrStartDate() " + getContrStartDate(),
				"ProposalContractBO", "validateContractDates");
		calPeriodEnd.setDate(getContrEndPeriod());
		OPPTCalender calEnd = new OPPTCalender();
		calEnd.setDate(getContrEndDate());

		OPPTCalender cal = new OPPTCalender();

		int maxDaysOfEndMonth = calEnd.getActualMaximum(Calendar.DATE);
		int maxDaysOfPeriodEndMonth = calPeriodEnd
				.getActualMaximum(Calendar.DATE);

		if (!ProposalTypeConstants.TP.equals(getProposalType().trim())) {
			// starting day of the contract should be 01, ending day should have
			// end day that is last day of the month
			if (cal.getDay(getContrStartDate()) != 1) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0027,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			if (cal.getDay(getContrEndDate()) != maxDaysOfEndMonth) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0028,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			if (cal.getDay(getContrStartPeriod()) != 1) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0030,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			if (cal.getDay(getContrEndPeriod()) != maxDaysOfPeriodEndMonth) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0031,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		}

		if (ProposalTypeConstants.TP.equals(getProposalType())) {
			if (!OPPTCalender.validDuration(3, getContrStartPeriod(),
					getContrEndPeriod())) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0043,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		} else if (!OPPTCalender.validDuration(12, getContrStartPeriod(),
				getContrEndPeriod())) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0029, OPPTMessageCatalog.TYPE_DOMAIN);

		}

		if (cal.isDateGreater(getContrStartDate(), getContrStartPeriod())) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0025, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (cal.isDateGreater(getContrEndPeriod(), getContrEndDate())) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0024, OPPTMessageCatalog.TYPE_DOMAIN);

		}
		if (cal.isDateGreater(getContrStartDate(), getContrEndDate())) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0022, OPPTMessageCatalog.TYPE_DOMAIN);

		}
		if (cal.isDateGreater(getContrStartPeriod(), getContrEndPeriod())) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0023, OPPTMessageCatalog.TYPE_DOMAIN);

		}
		// S And S 10 yrs rule
		if (isSAndSProposal()) {
			if (!OPPTCalender.validDuration(120, getContrStartDate(),
					getContrEndDate())) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0049,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		}
		/*CR6153 start changes  */
		if((getExtendPeriod() != null) && (getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
				int startMonth = cal.getMonth(getContrStartDate());
				int endMonth = cal.getMonth(getContrEndDate());
				if(startMonth -1 == 0){
					startMonth = 13;
				}
								
				if(!((getContrType() != null) && ((getContrType().equals("R")) ||(getContrType().equals("N"))))){
					if(isReplaceNewProposal == false){
						if((startMonth - 1) != endMonth){
							ExceptionGenerator.addErrorEntry(errorReport,
									ErrorCodeConstants.DE1014,
									OPPTMessageCatalog.TYPE_DOMAIN);
						}
					}
				}
								
				if (!OPPTCalender.validDuration(60, getContrStartDate(),
							getContrEndDate())) {
						ExceptionGenerator.addErrorEntry(errorReport,
								ErrorCodeConstants.DE1016,
								OPPTMessageCatalog.TYPE_DOMAIN);
					}
							
	
				int contractPeriodMonths = OPPTCalender.calculateContractPeriodDuration( getContrStartPeriod(), getContrEndPeriod());
				if(!((getContrType() != null) && ((getContrType().equals("R")) ||(getContrType().equals("N"))))){
					if(isReplaceNewProposal == false){
						if(contractPeriodMonths < 12){
						ExceptionGenerator.addErrorEntry(errorReport,
								ErrorCodeConstants.DE1015,
								OPPTMessageCatalog.TYPE_DOMAIN);
						  }
					}
				}
		}
		/*CR6153 end changes */
		
		

	}

	/**
	 * This method validates the pricing information based on business rules
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 13, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 *  
	 */
	private void validatePricingInformation(boolean changeProposal) {

		if (getSpecialRate() != 0) {
			if ((ProposalTypeConstants.EGO.equals(getProposalType()) && (!SalesOrgConstants.USA
					.equals(getSalesOrg())))
					|| (ProposalTypeConstants.EAS.equals(getProposalType())
					|| ProposalTypeConstants.PLA.equals(getProposalType()))
					|| ProposalTypeConstants.NUEV.equals(getProposalType())) {
				if (getSpecialRate() < -99.0 || getSpecialRate() > 200) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0007,
							OPPTMessageCatalog.TYPE_DOMAIN);

				}
				if (getGrowthFactor() == 0 && getSpecialRate() != 0) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0062,
							OPPTMessageCatalog.TYPE_DOMAIN);
				}
			} else {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0005,
						OPPTMessageCatalog.TYPE_DOMAIN);

			}
		}

		if (getGrowthFactor() != 0) {
			if ((ProposalTypeConstants.EGO.equals(getProposalType()) && (!SalesOrgConstants.USA
					.equals(getSalesOrg())))
					|| (ProposalTypeConstants.EAS.equals(getProposalType())
					||	ProposalTypeConstants.PLA.equals(getProposalType()))
					|| ProposalTypeConstants.NUEV.equals(getProposalType())) {

				if (getGrowthFactor() < -99.0 || getGrowthFactor() > 200) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0008,
							OPPTMessageCatalog.TYPE_DOMAIN);

				}
				if (getSpecialRate() == 0 && getGrowthFactor() != 0) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0061,
							OPPTMessageCatalog.TYPE_DOMAIN);

				}
			} else {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0006,
						OPPTMessageCatalog.TYPE_DOMAIN);

			}
		}

		// Exact multiple rule
		//<!-- BlueHarmony DAD007 Changed by Anand Sugumaran -->
		int contractPeriodMonths  = OPPTCalender.calculateContractPeriodDuration( getContrStartPeriod(), getContrEndPeriod());
				if (getAnnvAmount() > 0 ) {
					
					if(contractPeriodMonths==12){
						if (getAnnvAmount() % getBillingFreq(getBillingFreqCode()) != 0) {
							ExceptionGenerator.addErrorEntry(errorReport,
									ErrorCodeConstants.DE0010,
									OPPTMessageCatalog.TYPE_DOMAIN);

						}
					
					}
					
			else if(getAnnvAmount() % contractPeriodMonths  != 0) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0010,
						OPPTMessageCatalog.TYPE_DOMAIN);
        //<!-- BlueHarmony DAD007 Changes end by Anand Sugumaran -->
			}

			if (ProposalTypeConstants.SGO.equals(getProposalType())
					|| (ProposalTypeConstants.TP.equals(getProposalType()) && SalesOrgConstants.JAPAN
							.equals(getSalesOrg()))) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0011,
						OPPTMessageCatalog.TYPE_DOMAIN);

			}
		}

		// TVM Rate Validations
		if ((ProposalTypeConstants.EAS.equals(getProposalType()) || ProposalTypeConstants.PLA.equals(getProposalType()))
				&& UtilityConstants.BILLING_FREQ_ANNUAL.equals(getBillingFreqCode()) 
				&& (SalesOrgConstants.USA.equals(getSalesOrg())
					|| SalesOrgConstants.CANADA.equals(getSalesOrg()) 
					|| SalesOrgConstants.BRAZIL.equals(getSalesOrg()))
				|| ((SalesOrgConstants.USA.equals(getSalesOrg())
					 || SalesOrgConstants.CANADA.equals(getSalesOrg()) 
					 || SalesOrgConstants.BRAZIL.equals(getSalesOrg())) 
					 && (ProposalTypeConstants.ESSO.equals(getProposalType()) || ProposalTypeConstants.PLE.equals(getProposalType()) || ProposalTypeConstants.AMO.equals(getProposalType()) || ProposalTypeConstants.EGO.equals(getProposalType())
					 		))) {

			if (getTvmRate() < 0 || getTvmRate() > 50) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0016,
						OPPTMessageCatalog.TYPE_DOMAIN);

			}

		}

		if (getTvmRate() > 0) {
			if (!(SalesOrgConstants.USA.equals(getSalesOrg())
					|| SalesOrgConstants.CANADA.equals(getSalesOrg()) || SalesOrgConstants.BRAZIL
					.equals(getSalesOrg()))) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0015,
						OPPTMessageCatalog.TYPE_DOMAIN);

			}
			if (!UtilityConstants.BILLING_FREQ_ANNUAL
					.equals(getBillingFreqCode())) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0012,
						OPPTMessageCatalog.TYPE_DOMAIN);

			}
			// TVM RATE IS NOT ALLOWED
			if (!(ProposalTypeConstants.ESSO.equals(getProposalType()) ||ProposalTypeConstants.PLE.equals(getProposalType())
					|| ProposalTypeConstants.AMO.equals(getProposalType()) || ProposalTypeConstants.EGO
					.equals(getProposalType()))) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0014,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}

		}
		//		Detailed Invoice
		// EF5557 - Error message on Detailed invoice field - OPPT
		// Fixed by balaji defect 42
		if ((!(SalesOrgConstants.USA.equals(getSalesOrg())
				|| SalesOrgConstants.CANADA.equals(getSalesOrg()) || SalesOrgConstants.BRAZIL
				.equals(getSalesOrg())))
				&& (UtilityConstants.DETAILED_INVOICE_SELECTED
						.equals(getInvoiceInd()))) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0021, OPPTMessageCatalog.TYPE_DOMAIN);

		}

		// GSA
		if ((!SalesOrgConstants.USA.equals(getSalesOrg()))
				&& (UtilityConstants.GSA_SELECTED.equals(getGsaInd()))) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0020, OPPTMessageCatalog.TYPE_DOMAIN);

		}

		if (isSAndSProposal()) {
			if (null != getProposalContent()
					&& UtilityConstants.MLC_ONLY.equals(getProposalContent())
					&& getSAndsAnniversaryAmount() > 0) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0052,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}

			if ((UtilityConstants.SANDS_ONLY.equals(getProposalContent()) || UtilityConstants.MLC_AND_SANDS
					.equals(getProposalContent()))
					&& getSAndsAnniversaryAmount() < 0) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0053,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}

			if (UtilityConstants.SANDS_ONLY.equals(getProposalContent())) {
				if (null != getAdvanceBilling()) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0055,
							OPPTMessageCatalog.TYPE_DOMAIN);
				}

				if (null != getDeviatingDateRule()) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0056,
							OPPTMessageCatalog.TYPE_DOMAIN);
				}

				if (null != getBillingType()) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0057,
							OPPTMessageCatalog.TYPE_DOMAIN);
				}

			}

		} else {
			if (getSAndsAnniversaryAmount() > 0) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0054,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		}
	}

	/**
	 * This method validates Variance input based on Business Rules <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 13, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 *  
	 */
	private void validateCapVariance(boolean changeProposal) {

		if (!(ProposalTypeConstants.EAS.equals(getProposalType())
				|| ProposalTypeConstants.NUEV.equals(getProposalType()) || ProposalTypeConstants.SGO
				.equals(getProposalType()))) {
			if (getCapMinus() > 0 || getCapPlus() > 0) {
				//	ErrorKey key = new
				// ErrorKey("S0021",OPPTMessageCatalog.TYPE_SERVICE);
				//	errorReport.addErrorEntry(key,null);
			}
		}
		if (getCapPlus() > 0
				&& (ProposalTypeConstants.EAS.equals(getProposalType()) || ProposalTypeConstants.SGO
						.equals(getProposalType()))) {
			if (getCapPlus() != 10) {
				//	ErrorKey key = new
				// ErrorKey("S0021",OPPTMessageCatalog.TYPE_SERVICE);
				//	errorReport.addErrorEntry(key,null);
			}
		}
		if (getCapMinus() > 0
				&& ProposalTypeConstants.SGO.equals(getProposalType())
				&& getCapMinus() != 10) {
			//	ErrorKey key = new
			// ErrorKey("S0021",OPPTMessageCatalog.TYPE_SERVICE);
			//	errorReport.addErrorEntry(key,null);
		}

		if (getCapMinus() > 0
				&& ProposalTypeConstants.EAS.equals(getProposalType())
				&& getCapMinus() != 5) {
			//	ErrorKey key = new
			// ErrorKey("S0021",OPPTMessageCatalog.TYPE_SERVICE);
			//	errorReport.addErrorEntry(key,null);
		}

		if (getCapAmount() > 0) {
			if (!(ProposalTypeConstants.ESSO.equals(getProposalType())
					|| ProposalTypeConstants.AMO.equals(getProposalType()) || ProposalTypeConstants.ELITE
					.equals(getProposalType())))
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0058,
						OPPTMessageCatalog.TYPE_DOMAIN);
		}
		if (changeProposal && isVarianceProposal()) {
			if (getCapVariance() <= 0) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0063,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		}
	}

	/**
	 * This method validates ProposalData <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 13, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 *  
	 */
	private void validateOtherProposalData(boolean changeProposal) {

		/*
		 * DAD001 - Blue Harmony Changes starts changed by Anand Sugumaran
		 * if (!(SalesOrgConstants.USA.equals(getSalesOrg())
				|| SalesOrgConstants.CANADA.equals(getSalesOrg()) || SalesOrgConstants.BRAZIL
				.equals(getSalesOrg()))) {
			if (null == getExtContrNo() || getExtContrNo().length() == 0) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0060,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
		}
		
		*
		*
		*DAD001 - Blue Harmony Changes ends changed by Anand Sugumaran
		**/	
		
			if (!(ProposalTypeConstants.EAS.equals(getProposalType()) ||
					  ProposalTypeConstants.PLA.equals(getProposalType()) || 
					  ProposalTypeConstants.AMO.equals(getProposalType()))) {
				
				if (UtilityConstants.YES.equals(getSandSExcluded())) {
					ExceptionGenerator.addErrorEntry(errorReport,ErrorCodeConstants.DE0019,OPPTMessageCatalog.TYPE_DOMAIN);
				}
			}

			if (0 < getAddValueDays() && null != getFixedValueDate()) {
				// Not allowed
				ExceptionGenerator.addErrorEntry(errorReport,ErrorCodeConstants.DE0044,OPPTMessageCatalog.TYPE_DOMAIN);
			}
			
			 if (ProposalTypeConstants.PLA.equals(getProposalType()) || ProposalTypeConstants.PLE.equals(getProposalType())) {
            	if (null != getProposalContent() && (!(UtilityConstants.MLC_ONLY.equals(getProposalContent())))) {
    				// not allowed to other than MLC and/or PLM contract only  proposal content
    				ExceptionGenerator.addErrorEntry(errorReport,ErrorCodeConstants.DE0051,OPPTMessageCatalog.TYPE_DOMAIN);
			    }
            } else { 
            		if (isSAndSProposal()) {
            			if (null == getProposalContent()) {
            				// should have proposal content
            				ExceptionGenerator.addErrorEntry(errorReport,ErrorCodeConstants.DE0050,OPPTMessageCatalog.TYPE_DOMAIN);
            			}
            		} 
            }
	}

	/**
	 * 
	 * This methos used to get the number of billing per year based on the code
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 2, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param code
	 * @return int
	 */

	private int getBillingFreq(String code) {
		int months = 0;
		char codeArray[] = code.toCharArray();

		switch (codeArray[0]) {
		case 'A':
			months = 1;
			break;
		case 'M':
			months = 12;
			break;
		case 'Q':
			months = 4;
			break;
		case 'S':
			months = 2;
			break;
		default:
		}
		return months;
	}

	/**
	 * 
	 * This method validates the configure dm process
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 26, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @throws DomainException
	 */

	public void validateConfigureDMProcess(int type, HashMap compareValues)
			throws DomainException {

		boolean isAllowed = false;
		boolean result = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				//Checking for proposal other than EAS II. Boolean false is
				// sent to say other than EAS II
				if (isValidProposalType(ProposalTypeConstants.EASII,
						PC_EASII_PROPOSAL, false)) {
					if ((ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
									.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(getStatusCode()))
							&& !(isVarianceProposal())) {
						result = true;
					}
				}
			}

			if (result == false) {
				postConditionResult.put(ButtonConstants.CONFIGURE_DM,
						ButtonConstants.CONFIGURE_DM);
			}

		} else {
			if (isValidProposalType(ProposalTypeConstants.EASII,
					PC_EASII_PROPOSAL, false)) {
				if ((ProposalContractStatusConstants.DRAFT
						.equals(getStatusCode())
						|| ProposalContractStatusConstants.PRICED
								.equals(getStatusCode())
						|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
								.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(getStatusCode()))
						&& !(isVarianceProposal())) {
					isAllowed = true;
				}
			}
		}

		if (!isAllowed && !postCondition) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0101, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

	}

	/**
	 * 
	 * This method validates the bump inventory process
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 28, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @throws DomainException
	 */
	public void validateBumpInventory(int type, HashMap compareValues)
			throws DomainException {
		boolean isBumped = false;
		boolean result = false;
		boolean condtn = false;

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				//Checking for proposal other than EAS II. Boolean false is
				// sent to say other than EAS II
				if (isValidProposalType(ProposalTypeConstants.EASII,
						PC_EASII_PROPOSAL, false)) {
					if ((ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
									.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(getStatusCode()))
							&& !(isVarianceProposal())) {
						result = true;
					}
				}
			}

			if (result == false) {
				postConditionResult.put(ButtonConstants.COPY_BUMP,
						ButtonConstants.COPY_BUMP);
			}

		} else {
			if (isValidProposalType(ProposalTypeConstants.EASII,
					PC_EASII_PROPOSAL, false)) {
				if (compareValues.get(ActionNameConstants.COPY_BUMP_DM) != null) {
					condtn = ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode());
				} else {
					condtn = ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
									.equals(getStatusCode());
				}

				if (condtn && !(isVarianceProposal())) {
					isBumped = true;
				}
			}
		}

		if (!isBumped && !postCondition) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0104, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

	}

	/**
	 * 
	 * This method checks whether fetch inevntory is allowed or not
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 4, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @return
	 */
	public void validateFetchInventory(int type, HashMap compareValues)
			throws DomainException {
		boolean isFetchAllowed = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (isValidProposalType(ProposalTypeConstants.EASII, PC_EASII_PROPOSAL,
				false)) {
			if ((ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
					.equals(getStatusCode())
					|| ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
					|| ProposalContractStatusConstants.PRICED
							.equals(getStatusCode())
					|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
							.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
					.equals(getStatusCode()))
					&& !(isVarianceProposal())) {
				isFetchAllowed = true;
			}
		}

		if (postCondition) {
			if (isFetchAllowed == false) {
				postConditionResult.put(ButtonConstants.REFETCH,
						ButtonConstants.REFETCH);
			}
		}

		if (!isFetchAllowed && !postCondition) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0106, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

	}

	/**
	 * 
	 * This method validates the Delete Inventory
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 29, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @throws DomainException
	 */
	public void validateDeleteInventory(int type, HashMap compareValues)
			throws DomainException {
		boolean isAllowed = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				//Checking for proposal other than EAS II. Boolean false is
				// sent to say other than EAS II
				if (isValidProposalType(ProposalTypeConstants.EASII,
						PC_EASII_PROPOSAL, false)) {
					if ((ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
									.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(getStatusCode()))
							&& !(isVarianceProposal())) {
						isAllowed = true;
					}
				}
			}

			if (isAllowed == false) {
				postConditionResult.put(ButtonConstants.DELETE_INVENTORY,
						ButtonConstants.DELETE_INVENTORY);
			}

		} else {

			if (isValidProposalType(ProposalTypeConstants.EASII,
					PC_EASII_PROPOSAL, false)) {
				if ((ProposalContractStatusConstants.DRAFT
						.equals(getStatusCode())
						|| ProposalContractStatusConstants.PRICED
								.equals(getStatusCode())
						|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
								.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(getStatusCode()))
						&& !(isVarianceProposal())) {
					isAllowed = true;
				}
			}
		}

		if (!isAllowed && !postCondition) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0109, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

	}

	/**
	 * 
	 * This method checks fetch plan is allowed or not
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 10, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param proposalBO
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public void validateFetchPlan(int type, HashMap compareValues)
			throws DomainException {
		boolean isFetchAllowed = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				//Checking for proposal other than EAS II. Boolean false is
				// sent to say other than EAS II
				if (isValidProposalType(ProposalTypeConstants.EASII,
						PC_EASII_PROPOSAL, false)) {
					if ((ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
									.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(getStatusCode()))
							&& !(isVarianceProposal())) {
						isFetchAllowed = true;
					}
				}
			}

			if (isFetchAllowed == false) {
				postConditionResult.put(ButtonConstants.FETCH_PLAN,
						ButtonConstants.FETCH_PLAN);
			}
		} else {

			if (isValidProposalType(ProposalTypeConstants.EASII,
					PC_EASII_PROPOSAL, false)) {
				if ((ProposalContractStatusConstants.DRAFT
						.equals(getStatusCode())
						|| ProposalContractStatusConstants.PRICED
								.equals(getStatusCode())
						|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
								.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(getStatusCode()))
						&& !(isVarianceProposal())) {
					isFetchAllowed = true;
				}
			}
		}

		if (!isFetchAllowed && !postCondition) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0107, OPPTMessageCatalog.TYPE_DOMAIN);
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

	}

	/**
	 * 
	 * This method validates the feth ineligible is allowed or not
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Dec 10, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param proposalBO
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public void validateFetchIneligible(int type, HashMap compareValues)
			throws DomainException {
		boolean isFetchAllowed = false;
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				//Checking for proposal other than EAS II. Boolean false is
				// sent to say other than EAS II
				if (isValidProposalType(ProposalTypeConstants.EASII,
						PC_EASII_PROPOSAL, false)) {
					if ((ProposalContractStatusConstants.DRAFT
							.equals(getStatusCode())
							|| ProposalContractStatusConstants.PRICED
									.equals(getStatusCode())
							|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
									.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
							.equals(getStatusCode()))
							&& !(isVarianceProposal())) {
						isFetchAllowed = true;
					}
				}
			}

			if (isFetchAllowed == false) {
				postConditionResult.put(ButtonConstants.FETCH_INELIGIBLE,
						ButtonConstants.FETCH_INELIGIBLE);
			}
		} else {

			if (isValidProposalType(ProposalTypeConstants.EASII,
					PC_EASII_PROPOSAL, false)) {
				if ((ProposalContractStatusConstants.DRAFT
						.equals(getStatusCode())
						|| ProposalContractStatusConstants.PRICED
								.equals(getStatusCode())
						|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
								.equals(getStatusCode()) || ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(getStatusCode()))
						&& !(isVarianceProposal())) {
					isFetchAllowed = true;
				}
			}
		}

		if (!isFetchAllowed && !postCondition) {
			ExceptionGenerator.addErrorEntry(errorReport,
					ErrorCodeConstants.DE0108, OPPTMessageCatalog.TYPE_DOMAIN);
			ExceptionGenerator.generateDomainException(errorReport);
		}
	}

	/**
	 * Method needs to be implemented by the sub-class
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 26, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 *  
	 */
	public void checkAndSetAfterRequestApproval() {
		return;
	}

	/**
	 * Validates the request for Proposal Status Check
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Jan 13, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 */

	public boolean validateCheckProposalStatus(int type, HashMap compareValues)
			throws DomainException {
		boolean result = false;
		HashMap valueMap = null;

		String[] validStatusForCheckProposal = {
				ProposalContractStatusConstants.CHECK_AMENDED_CONTRACT_STATUS,
				ProposalContractStatusConstants.CHECK_CLOSURE_STATUS,
				ProposalContractStatusConstants.CHECK_EXTENSION_STATUS,
				ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS };

		String[] invalidStatusForCheckProposal = {
				ProposalContractStatusConstants.CHECK_RENEW_STATUS,
				ProposalContractStatusConstants.CHECK_REPLACEMENT_STATUS,
				ProposalContractStatusConstants.CHECK_VARIANCE_STATUS };

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (validateProposalStatus(validStatusForCheckProposal)) {
					result = true;
				}
			}
		} else {

			boolean firstResult = validateUserAuthorityForChange(compareValues);

			boolean secondResult = validateProposalStatus(validStatusForCheckProposal);

			boolean thirdResult = validateProposalStatus(invalidStatusForCheckProposal);

			if (thirdResult) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0432,
						OPPTMessageCatalog.TYPE_DOMAIN);
			} else {
				if (!secondResult) {
					ExceptionGenerator.addErrorEntry(errorReport,
							ErrorCodeConstants.DE0426,
							OPPTMessageCatalog.TYPE_DOMAIN);
				}
			}

			result = firstResult & secondResult;
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return result;
	}

	/**
	 * Validates the request for removing Quotes from proposal/contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Feb 14, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 * @author Saravanan Viswanathan
	 */
	public boolean validateForRemoveQuotes(int type, HashMap compareValues)
			throws DomainException {
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
					//Checking for proposal other than EAS II. Boolean false is
					// sent to say other than EAS II
					if (isValidProposalType(ProposalTypeConstants.EASII,
							PC_OTHERTHANEASII_PROPOSAL, false)) {
						result = true;
					}
				}
			}

			if (result == false) {
				postConditionResult.put(ButtonConstants.REMOVE_QUOTES,
						ButtonConstants.REMOVE_QUOTES);
			}
		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = checkStatusForChangeByPropAdmin(INVENTORY);
			boolean thirdResult = isValidProposalType(
					ProposalTypeConstants.EASII, PC_OTHERTHANEASII_PROPOSAL,
					false);
			if (!thirdResult) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0604,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			result = firstResult & secondResult & thirdResult;
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return result;
	}

	public boolean isProposalStatus(String status) {
		return getStatusCode().equalsIgnoreCase(status) ? true : false;
	}

	public boolean isContractType(String contrType) {
		return getContrType().equalsIgnoreCase(contrType) ? true : false;
	}

	public boolean isProposalType(String propType) {
		return getProposalType().equalsIgnoreCase(propType) ? true : false;
	}

	public boolean isSAndSProposal() {
		boolean result = false;
		if (ProposalTypeConstants.AMO.equals(getProposalType())
				|| ProposalTypeConstants.ESSO.equals(getProposalType())) {
			result = true;
		}

		return result;

	}

	/**
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Feb 20, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @return
	 */
	public HashMap getPostConditionResult() {
		return postConditionResult;
	}

	/**
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Feb 20, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param map
	 */
	public void setPostConditionResult(HashMap map) {
		postConditionResult = map;
	}

	public boolean isPriced() {
		boolean result = true;
		if (null == getDatePriced()) {
			result = false;
		}

		return result;
	}

	public boolean isDraft() {
		boolean result = false;
		if (ProposalContractStatusConstants.DRAFT.equals(getStatusCode())
				|| ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
						.equals(getStatusCode())) {
			result = true;
		}

		return result;
	}

	public void validateProposalDetails(int type, HashMap map)
			throws DomainException {
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (postCondition == false) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition == false) {
			map.put(UtilityConstants.PROPOSAL_DETAILS_EDITABLE, new Boolean(
					checkUserAndAuthority(map)));
		} else {
			validateEditInventory(type, map);
			validateForIncludeExclude(type, map);
			validateRemoveSVC(type, map);
			validateTP(type, map);
			validateForDisplayProposalHeader(type, map);
			validateConfigureDMProcess(type, map);
			validateBumpInventory(type, map);
			validateDeleteInventory(type, map);
			validateFetchPlan(type, map);
			validateFetchIneligible(type, map);
			validateForRemoveQuotes(type, map);
			validateFetchInventory(type, map);
			validateCopyInventory(type, map);
			validateCompareTP(type, map);
			validateRequestForApproveOrReject(type, map);
			validateForSAndS(type, map);
			if (!isProposal() && (!validateForSAndS(type, map))) {
				postConditionResult.put(ButtonConstants.SS_PLANNING,
						ButtonConstants.SS_PLANNING);
			}
		}
	}

	public void validateCompareTP(int type, HashMap map) throws DomainException {
		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (postCondition == false) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		boolean result = false;

		String[] types = { getProposalType() };

		if (checkUserAndAuthority(map) == false) {
			if (postCondition == false) {
				if (errorReport != null && errorReport.size() > 0) {
					throw ExceptionGenerator
							.generateDomainException(errorReport);
				}

				throw ExceptionGenerator
						.generateDomainException(ErrorCodeConstants.DE0001);
			}
		} else if (validateWith(types, ProposalTypeConstants.TP) == false) {
			if (postCondition == false) {
				throw ExceptionGenerator
						.generateDomainException(ErrorCodeConstants.DE0301);
			}
		} else if (validateTPRenewal(type, map)) {
			String[] status = { ProposalContractStatusConstants.PRICED,
					ProposalContractStatusConstants.DRAFT };

			if (validateProposalStatus(status)) {
				result = true;
			}
		}

		if (postCondition) {
			if (result == false) {
				postConditionResult.put(ButtonConstants.COMPARE_TP,
						ButtonConstants.COMPARE_TP);
			}
		} else if (result == false) {
			ErrorReport er = new ErrorReport();
			er = ExceptionGenerator.addErrorEntry(er,
					ErrorCodeConstants.SE0332, OPPTMessageCatalog.TYPE_SERVICE);

			throw ExceptionGenerator.generateDomainException(er);
		}
	}

	/**
	 * Validates the request for S&S planning for proposal/contract
	 * 
	 * <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Feb 21, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException
	 * @author Saravanan Viswanathan
	 */
	public boolean validateForSAndS(int type, HashMap compareValues)
			throws DomainException {
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
					//Checking for proposal other than ESSO or AMO. Boolean
					// true is sent if proposal type is ESSO or AMO
					if (isSAndSProposal()) {
						result = true;
					}
				}
			}
		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = checkStatusForChangeByPropAdmin(INVENTORY);
			boolean thirdResult = false;
			if (isSAndSProposal()) {
				thirdResult = true;
			}
			if (!thirdResult) {
				ExceptionGenerator.addErrorEntry(errorReport,
						ErrorCodeConstants.DE0605,
						OPPTMessageCatalog.TYPE_DOMAIN);
			}
			result = firstResult & secondResult & thirdResult;
		}

		if (postCondition && (!result)) {
			if (postConditionResult == null) {
				postConditionResult = new HashMap();
			}
			postConditionResult.put(ButtonConstants.SS_PLANNING,
					ButtonConstants.SS_PLANNING);
		}
		// Added to fix a bug - MLC ONLY should not have s and s planning button
		boolean mlcOnlyContent = UtilityConstants.MLC_ONLY.equals(OPPTHelper
				.trimString(getProposalContent())) ? true : false;
		if (postCondition && result && mlcOnlyContent) {
			postConditionResult.put(ButtonConstants.SS_PLANNING,
					ButtonConstants.SS_PLANNING);
		}

		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return result;
	}

	/**
	 * This method is for checking the validity of the proposals <br>
	 * <b>Known Bugs </b> <br>
	 * 
	 * <br>
	 * 
	 * <PRE>
	 * 
	 * date Feb 23, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br>
	 * 
	 * @return
	 */

	public boolean validateForReport() {
		boolean result = false;

		if (!(ProposalContractStatusConstants.DRAFT.equals(getStatusCode())
				|| ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS
						.equals(getStatusCode()) || ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
				.equals(getStatusCode()))) {
			result = true;
		}

		return result;

	}

	public boolean isContractInAmendment() {
		boolean result = false;
		if (ContractTypeConstants.AMENDMENT.equals(getContrType())) {
			result = true;
		}
		if (ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT
				.equals(getStatusCode())
				|| ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT
						.equals(getStatusCode())
				|| ProposalContractStatusConstants.AMENDED_CONTRACT_PENDING_APPROVAL
						.equals(getStatusCode())
				|| ProposalContractStatusConstants.CHECK_AMENDED_CONTRACT_STATUS
						.equals(getStatusCode())) {
			result = true;
		}

		return result;

	}

	public boolean isContractinClosure() {

		boolean result = false;

		if (ProposalContractStatusConstants.CLOSED.equals(getStatusCode())
				|| ProposalContractStatusConstants.CHECK_CLOSURE_STATUS
						.equals(getStatusCode())
				|| ProposalContractStatusConstants.VARIANCE_CLOSURE_PENDING_APROVAL
						.equals(getStatusCode())) {
			result = true;
		}

		return result;

	}

	public boolean displayContractClosureDate() {
		boolean result = false;
		if (ProposalContractStatusConstants.CONTRACT_CLOSURE_FAILED_RETRY
				.equals(getStatusCode())
				|| isContractinClosure()) {
			result = true;
		}
		return result;
	}

	public boolean isAdvanceSelected() {
		boolean result = false;
		if (null == OPPTHelper.trimStringToNull(getAdvanceBilling())) {
			result = true;
		}

		return result;
	}
	
	/* New method for validations of replacement or renewal.
	 * This is to stop users using 2 browsers and do 2 renewals or replacements
	 * Balaji Defect 91 
	 * 
	 */

	public void validateContractForReplacementRenewal() throws ServiceException {
		if (ProposalContractStatusConstants.REPLACEMENT_IN_PROGRESS.equals(getStatusCode()) || ProposalContractStatusConstants.RENEWAL_IN_PROGRESS.equals(getStatusCode())) {
			ServiceException ex = new ServiceException();
			ErrorEntry entry = new ErrorEntry(new String[] {getContrNo()});
			ErrorReport report = ex.getErrorReport();
			report.addErrorEntry(new ErrorKey(ErrorCodeConstants.SE0039, OPPTMessageCatalog.TYPE_SERVICE), entry);
			throw ex;
		}
	}
	/*CR6153 start change */
	public void isReplaceNew(boolean iSReplaceNewProposal) {
		isReplaceNewProposal = iSReplaceNewProposal;
	}
	/*CR6153 end change */
}