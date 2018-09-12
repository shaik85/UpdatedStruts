/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo;

import java.math.BigDecimal;
import java.util.HashMap;

import com.ibm.isc.customerfulfillment.bhoppt.service.helper.PricingComponentHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalStatusCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

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
public class ProposalBO extends ProposalContractBO {

	private static final String MONTHLY = "M";
	private static final String QUARTERLY = "Q";
	private static final String ANNUALLY = "A";
	private static final String SEMIANNUALLY = "S";
	private static final String YES = "Y";

	public void validate() {
	}

	/**
		 * Validates if Proposal can be send for Registration. 
		 * 
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Dec 16, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param svcLicense
		 * @return boolean 
		 * @throws ServiceException
		 * @author Prakash Mall
		 */

	public boolean validateForRegistration(int type, HashMap compareValues) throws DomainException {
		OPPTCalender opptCal = new OPPTCalender();

		boolean registerProposal = false;
		boolean result1 = false;
		boolean result2 = false;
		boolean result3 = false;
		// Added by Balaji for missing Excon in EMEA
		boolean exConForEMEA = true;
		
		
		/* Start change CR6153 */
		BigDecimal[] sAndSExtendedDiscountAmount = new BigDecimal[5];
		sAndSExtendedDiscountAmount[0] = PricingComponentHelper.convertToBigDecimal(getSAndSDiscountAmount1());
		sAndSExtendedDiscountAmount[1] = PricingComponentHelper.convertToBigDecimal(getSAndSDiscountAmount2());
		sAndSExtendedDiscountAmount[2] = PricingComponentHelper.convertToBigDecimal(getSAndSDiscountAmount3());
		sAndSExtendedDiscountAmount[3] = PricingComponentHelper.convertToBigDecimal(getSAndSDiscountAmount4());
		sAndSExtendedDiscountAmount[4] = PricingComponentHelper.convertToBigDecimal(getSAndSDiscountAmount5());
		
		double[]  sAndSAnniversaryAmount = new double[5];
		sAndSAnniversaryAmount[0] = getSAndsAnniversaryAmount();
		sAndSAnniversaryAmount[1] = getSAndsAnniversaryAmt2();
		sAndSAnniversaryAmount[2] = getSAndsAnniversaryAmt3();
		sAndSAnniversaryAmount[3] = getSAndsAnniversaryAmt4();
		sAndSAnniversaryAmount[4] = getSAndsAnniversaryAmt5();
		/* End change CR6153 */

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
				registerProposal = true;
				//postCondition = false;
			}

			if (registerProposal == false) {
				postConditionResult.put(ButtonConstants.REGISTER, ButtonConstants.REGISTER);
			}
		} else {
			if (preCondition) {
				registerProposal = validateUserAuthorityForChange(compareValues);
				preCondition = false;
			} else {
				Boolean svcLicenseExist = (Boolean) compareValues.get(UtilityConstants.SVCLICENSE_EXIST);
				Boolean quoteExist = (Boolean) compareValues.get(UtilityConstants.QUOTE_EXIST);
				Boolean sandsLicenseExist = (Boolean) compareValues.get(UtilityConstants.SANDS_IND);

				if (isProposalStatus(ProposalContractStatusConstants.PRICED)) {

					// Register a non-ESSO / non-AMO proposal for becoming a contract
					if (!isContractType(ContractTypeConstants.VARIANCE)) {
						if (!isSAndSProposal()) {
							if (opptCal.isDateEqual(getDatePriced())) {
								if (!isProposalType(ProposalTypeConstants.EASII)) {
									if (opptCal.isDateEqual(getFetchDate())) {
										if (null != getIneligibleInd() && UtilityConstants.YES.equals(getIneligibleInd().trim())) {
											if (!svcLicenseExist.booleanValue()) {
												if (!quoteExist.booleanValue()) {
													result1 = true;
												}
											}
										}
									}
								}
							}
						}
					}

					boolean sands = false;

					// Register an ESSO / AMO proposal for becoming a contract

					if (isSAndSProposal() && !isContractType(ContractTypeConstants.VARIANCE)) {
						if (UtilityConstants.MLC_ONLY.equals(getProposalContent())) {
							sands = true;
						}

						if ( UtilityConstants.SANDS_ONLY.equals(getProposalContent())) {
							// If S&S Anniversary amount is equal to S&S discount sum

							if (PricingComponentHelper.round(getSAndsAnniversaryAmount(), 2) == PricingComponentHelper.round(getSAndsDiscount(), 2)) {

								sands = true;
							}

							// If number of S&S licenses in the proposal is zero and S&S Anniversary amount is zero
							if (!sandsLicenseExist.booleanValue() && 0 == getSAndsAnniversaryAmount()) {
								sands = true;
							}
						}
						/* CR6153 start change */
						if((getExtendPeriod() != null) && (getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
							if ((PricingComponentHelper.round(sAndSExtendedDiscountAmount[0].doubleValue(),2) == PricingComponentHelper.round(sAndSAnniversaryAmount[0],2))
								&& (PricingComponentHelper.round(sAndSExtendedDiscountAmount[1].doubleValue(),2) == PricingComponentHelper.round(sAndSAnniversaryAmount[1],2)) 
								&& (PricingComponentHelper.round(sAndSExtendedDiscountAmount[2].doubleValue(),2) == PricingComponentHelper.round(sAndSAnniversaryAmount[2],2))
								&& (PricingComponentHelper.round(sAndSExtendedDiscountAmount[3].doubleValue(),2) == PricingComponentHelper.round(sAndSAnniversaryAmount[3],2)) 
								&& (PricingComponentHelper.round(sAndSExtendedDiscountAmount[4].doubleValue(),2) == PricingComponentHelper.round(sAndSAnniversaryAmount[4],2))){
									sands = true;
						   	}
							
						}
						/* CR6153 end change */
						if (sands) {
							if (opptCal.isDateEqual(getDatePriced())) {
								if (opptCal.isDateEqual(getFetchDate())) {
									if (null != getIneligibleInd() && UtilityConstants.YES.equals(getIneligibleInd().trim())) {
										if (!svcLicenseExist.booleanValue()) {
											if (!quoteExist.booleanValue()) {
												result1 = true;
											}
										}
									}
								}
							}
						}
					}

					if (isContractType(ContractTypeConstants.VARIANCE) && getDatePriced() != null && opptCal.isDateEqual(getDatePriced())) {
						result2 = true;
					}

					if (isProposalType(ProposalTypeConstants.EASII)) {
						result3 = true;
					}
				}
				//	Added by Balaji for missing Excon in EMEA
				/*
				 * DAD001- Blue Harmony Changes by Anand Sugumaran Change starts
				 * if (!(SalesOrgConstants.USA.equals(OPPTHelper.trimString(getSalesOrg())) || SalesOrgConstants.CANADA.equals(OPPTHelper.trimString(getSalesOrg())))) {
					if (null == OPPTHelper.trimStringToNull(getExtContrNo())) {
						exConForEMEA = false;
					}
				}
				
				*
				*DAD001- Blue Harmony Changes by Anand Sugumaran Change ends
				**/

				if ((result1 || result2 || result3) && exConForEMEA) {
					registerProposal = true;
				}

				// Proposal must be priced before it can be registered

				if (!registerProposal) {
					
					// Added by Balaji for missing Excon in EMEA
					
					/*
					 * DAD001- Blue Harmony Changes by Anand Sugumaran Change starts
					 * // Ex Con should be given for EMEA proposals before registration
					if (!exConForEMEA) {
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0639, OPPTMessageCatalog.TYPE_DOMAIN);
					}
					
					*DAD001- Blue Harmony Changes by Anand Sugumaran Change ends
					**/
					
					if (ProposalContractStatusConstants.DRAFT.equals(getStatusCode())) {
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0401, OPPTMessageCatalog.TYPE_DOMAIN);
					}

					//Proposal must be repriced before it can be registered
					if ((null != getDatePriced()) && !opptCal.isDateEqual(getDatePriced()) && !ProposalContractStatusConstants.DRAFT.equals(getStatusCode())) {
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0402, OPPTMessageCatalog.TYPE_DOMAIN);
					}
					// Blue Harmony Wave 1 DAD003 - Begin - Bhanu
					//if("".equalsIgnoreCase(getCpsId())|| getCpsId()== null && ("7240".equals(getSalesOrg())|| "0365".equals(getSalesOrg()))){
					if(("".equalsIgnoreCase(getCpsId())|| getCpsId()== null) && (!"".equals(OPPTStaticDataHolder.getCpsSalesorg(getSalesOrg())) && OPPTStaticDataHolder.getCpsSalesorg(getSalesOrg())!=null)){
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0436, OPPTMessageCatalog.TYPE_DOMAIN);
						registerProposal = false;
					}
					if( null != getCciInd() && getCciInd().equals("N")){
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0436, OPPTMessageCatalog.TYPE_DOMAIN);
						registerProposal = false;
					}
					// Blue Harmony Wave 1 DAD003 - End - Bhanu

					if (!isContractType(ContractTypeConstants.VARIANCE)) {

						//Inventory must be re-fetched before it can be registered
						if (((null == getRefetchId()) || !opptCal.isDateEqual(getFetchDate())) && !isProposalType(ProposalTypeConstants.EASII)) {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0403, OPPTMessageCatalog.TYPE_DOMAIN);
						}

						//Ineligible licenses fetch is required to be done before contract registration
						if (null == getIneligibleInd() || !UtilityConstants.YES.equals(getIneligibleInd().trim()) && !isProposalType(ProposalTypeConstants.EASII)) {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0404, OPPTMessageCatalog.TYPE_DOMAIN);
						}

						//Delete all the SVC license before sending proposal for approval	
						if (svcLicenseExist.booleanValue() && !isProposalType(ProposalTypeConstants.EASII)) {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0405, OPPTMessageCatalog.TYPE_DOMAIN);
						}

						// Delete all Quote before sending the quote for registration
						if (quoteExist.booleanValue() && !isProposalType(ProposalTypeConstants.EASII)) {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0430, OPPTMessageCatalog.TYPE_DOMAIN);
						}

						//Proposal is already sent for registration
						if (isProposalStatus(ProposalContractStatusConstants.PENDING_APPROVAL)) {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0406, OPPTMessageCatalog.TYPE_DOMAIN);
						}

						/*
						 * Changed By Anand Sugumaran DAD 006 Blue Harmony Change Starts
						 * 
						 *  CR6153 start change 
						
						if((getExtendPeriod() != null) && (getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
																					
						   	if (PricingComponentHelper.round(sAndSExtendedDiscountAmount[0].doubleValue(),2) != PricingComponentHelper.round(sAndSAnniversaryAmount[0],2)) {
						   		ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE1017, OPPTMessageCatalog.TYPE_DOMAIN);
						   	 }
						   	if (PricingComponentHelper.round(sAndSExtendedDiscountAmount[1].doubleValue(),2) != PricingComponentHelper.round(sAndSAnniversaryAmount[1],2)) {
						   		ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE1018, OPPTMessageCatalog.TYPE_DOMAIN);
						   	 }
						   	if (PricingComponentHelper.round(sAndSExtendedDiscountAmount[2].doubleValue(),2) != PricingComponentHelper.round(sAndSAnniversaryAmount[2],2)) {
						   		ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE1019, OPPTMessageCatalog.TYPE_DOMAIN);
						   	 }
						   	if (PricingComponentHelper.round(sAndSExtendedDiscountAmount[3].doubleValue(),2) != PricingComponentHelper.round(sAndSAnniversaryAmount[3],2)) {
						   		ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE1020, OPPTMessageCatalog.TYPE_DOMAIN);
						   	}
						   	if (PricingComponentHelper.round(sAndSExtendedDiscountAmount[4].doubleValue(),2) != PricingComponentHelper.round(sAndSAnniversaryAmount[4],2)) {
						   		ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE1021, OPPTMessageCatalog.TYPE_DOMAIN);
						   	}
						 							
						}
						else{
						 CR6153 end change 
							if (UtilityConstants.MLC_AND_SANDS.equals(getProposalContent()) || UtilityConstants.SANDS_ONLY.equals(getProposalContent())) {
								if (PricingComponentHelper.round(getSAndsAnniversaryAmount(), 2) != PricingComponentHelper.round(getSAndsDiscount(), 2)) {
									ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0431, OPPTMessageCatalog.TYPE_DOMAIN);
								}
	
								if (sandsLicenseExist.booleanValue() && 0 == getSAndsAnniversaryAmount()) {
									// check if we need to add any error msg here
								}
							}
						 CR6153 start change 
						}
						 CR6153 end change */
					}
					// Blue Harmony Wave 1 DAD003 - Begin - Bhanu
				} else {
					//if("".equalsIgnoreCase(getCpsId())|| getCpsId()== null && ("7240".equals(getSalesOrg())|| "0365".equals(getSalesOrg()))){
					if(("".equalsIgnoreCase(getCpsId())|| getCpsId()== null) && (!"".equals(OPPTStaticDataHolder.getCpsSalesorg(getSalesOrg())) && OPPTStaticDataHolder.getCpsSalesorg(getSalesOrg())!=null)){
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0436, OPPTMessageCatalog.TYPE_DOMAIN);
						registerProposal = false;
					}
					if( null != getCciInd() && getCciInd().equals("N")){
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0436, OPPTMessageCatalog.TYPE_DOMAIN);
						registerProposal = false;
					}
					// Blue Harmony Wave 1 DAD003 - End - Bhanu
				}

				
					if ((SalesOrgConstants.JAPAN.equals(getSalesOrg())) ||(SalesOrgConstants.KOREA.equals(getSalesOrg())) ) {
						if (!OPPTHelper.validNumberRangeForJapan(getAnnvInvoiceAmount())) {
							registerProposal = false;
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0711, OPPTMessageCatalog.TYPE_SERVICE);
						}
						if (!OPPTHelper.validNumberRangeForJapan(getSAndsDiscount())) {
							registerProposal = false;
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0710, OPPTMessageCatalog.TYPE_SERVICE);
						}
					
					} 
					else if (SalesOrgConstants.VIETNAM.equals(getSalesOrg())) {
						if (!OPPTHelper.validNumberRangeForVietnam(getAnnvInvoiceAmount())) {
							registerProposal = false;
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0716, OPPTMessageCatalog.TYPE_SERVICE);
						}
						if (!OPPTHelper.validNumberRangeForVietnam(getSAndsDiscount())) {
							registerProposal = false;
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0715, OPPTMessageCatalog.TYPE_SERVICE);
						}
					
					} else {
						if (!OPPTHelper.validNumberRange(getAnnvInvoiceAmount())) {
							registerProposal = false;
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0706, OPPTMessageCatalog.TYPE_SERVICE);
						}
						if (!OPPTHelper.validNumberRange(getSAndsDiscount())) {
							registerProposal = false;
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0708, OPPTMessageCatalog.TYPE_SERVICE);
						}
					}
			}
		}

		if (postCondition && registerProposal == false) {
			if (postConditionResult == null) {
				postConditionResult = new HashMap();
			}
			postConditionResult.put(ButtonConstants.REGISTER, ButtonConstants.REGISTER);
		}

		if (!postCondition && !registerProposal) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return registerProposal;
	}

	/**
	 *  
	 * This method validates if the Proposal can be Renamed or not
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 * @author prakash
	 */

	public boolean validateForRename(int type, HashMap compareValues) throws DomainException {
		boolean renameProposal = false;

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (!isProposalShared(compareValues)) {
					renameProposal = true;
				}
			}
		} else {
			boolean result1 = validateUserAuthorityForChange(compareValues);
			boolean result2 = isProposalShared(compareValues);

			if (result2) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0413, OPPTMessageCatalog.TYPE_DOMAIN);
			}

			if (result1 && !result2) {
				renameProposal = true;
			}
		}
		if (!postCondition && !renameProposal) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return renameProposal;
	}

	/**
	 *  
	 * This method validates if the Proposal can be Deleted
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param int
	 * @param HashMap
	 * @return boolean
	 * @throws ServiceException
	 * @author prakash
	 */

	public boolean validateForDeletion(int type, HashMap compareValues) throws DomainException {

		boolean deleteProposal = false;
		String userId = (String) compareValues.get(UtilityConstants.BO_USERID);
		String groupName = (String) compareValues.get(UtilityConstants.BO_GROUPNAME);
		String accessType = (String) compareValues.get(UtilityConstants.BO_SHARING);

		String[] validStatus = { ProposalContractStatusConstants.PENDING_APPROVAL, ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS };
		String[] validTypes = { ContractTypeConstants.VARIANCE, ContractTypeConstants.REPLACEMENT, ContractTypeConstants.RENEWAL };

		// Integer count = (Integer) compareValues.get(UtilityConstants.COUNT_OF_PROPOSALCONTRACT);

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (!validateProposalStatus(validStatus)) {
					if (!isProposalShared(compareValues)) {
						if (!validateContractType(validTypes)) {
							deleteProposal = true;
						}
					}
				}
			}
		} else {
			boolean result1 = validateUserAuthorityForChange(compareValues);
			boolean result2 = validateProposalStatus(validStatus);
			boolean result3 = isProposalShared(compareValues);
			boolean result4 = validateContractType(validTypes);

			if (result2) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0412, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			if (result3) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0413, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			if (result4) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0414, OPPTMessageCatalog.TYPE_DOMAIN);
			}

			if (result1 && !result2 && !result3 && !result4) {
				deleteProposal = true;

			}
		}

		if (!postCondition && !deleteProposal) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return deleteProposal;

	}

	/**
	 * This method is to validate if the propsoal is shared.  
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
	 * @param HashMap	 
	 * @return boolean
	 * @throws 
	 */

	private boolean isProposalShared(HashMap compareValues) {

		String userId = (String) compareValues.get(UtilityConstants.BO_USERID);
		String groupName = (String) compareValues.get(UtilityConstants.BO_GROUPNAME);
		String accessType = (String) compareValues.get(UtilityConstants.BO_SHARING);

		return (null != compareValues.get(UtilityConstants.BO_SHARING)) ? true : false;
	}

	/**
	 * This method is for validating for add customers usecases 
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
	public boolean validateForAddCustomer(int type, HashMap compareValues) throws DomainException {
		boolean result = false;
		String[] validAddCustomersStatus = { ProposalContractStatusConstants.PRICED, ProposalContractStatusConstants.DRAFT, ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS };

		if (type == UtilityConstants.BUSINESSRULE_POST_COND_TYPE) {
			if (!postCondition) {
				postCondition = true;
				postConditionResult = new HashMap();
			}
		}

		if (postCondition) {
			if (validateUserAuthorityForChange(compareValues)) {
				if (validateProposalStatus(validAddCustomersStatus)) {
					if (isValidProposalType(ProposalTypeConstants.EASII, PC_OTHERTHANEASII_PROPOSAL, false)) {
						result = true;
					}
				}
			}
			if (!result) {
				postConditionResult.put(ButtonConstants.ADDCUSTOMER_BUTTON, ButtonConstants.ADDCUSTOMER_BUTTON);
			}
		} else {
			boolean firstResult = validateUserAuthorityForChange(compareValues);
			boolean secondResult = validateProposalStatus(validAddCustomersStatus);
			boolean thirdResult = isValidProposalType(ProposalTypeConstants.EASII, PC_OTHERTHANEASII_PROPOSAL, false);
			if (!secondResult) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0002, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			if (!thirdResult) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0003, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			result = firstResult & secondResult & thirdResult;
		}
		if (!postCondition && !result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}

		return true;

	}

	public boolean validateLoggedUserHasFullSharingAccess(HashMap compareValue) throws DomainException {
		boolean result = false;
		String propShareId = null;
		String loggedUser = (String) compareValue.get(UtilityConstants.BO_USERID);
		String proposalSharedFullyToUser = (String) compareValue.get(UtilityConstants.BO_SHARING_ID);

		if (null != loggedUser) {
			if (!isLoggedUserCreatorOfProposal(loggedUser)) {
				if (isProposalSharedToLoggedUserFully(loggedUser, proposalSharedFullyToUser)) {
					result = true;
				}
			}
		}
		return result;
	}

	private boolean isProposalSharedToLoggedUserFully(String loggedUser, String proposalSharedFullyToUser) {
		if (loggedUser.equalsIgnoreCase(proposalSharedFullyToUser)) {
			return true;
		}
		return false;
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
		 * @return boolean
		 * @throws DomainException
		 */
	public boolean validateForPricing(int type, HashMap compareValues) throws DomainException {
		boolean result = false;

		String[] validPricingStatus = { ProposalContractStatusConstants.DRAFT, ProposalContractStatusConstants.PRICED, ProposalContractStatusConstants.VARIANCE_REJECTED };

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

			if (result == false) {
				postConditionResult.put(ButtonConstants.PRICE, ButtonConstants.PRICE);
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

	public boolean validateForProposalSharing(int type, HashMap compareValues) throws DomainException {
		String loggedUser = (String) compareValues.get(UtilityConstants.BO_USERID);
		boolean isUserInGroup = ((Boolean) compareValues.get(UtilityConstants.USER_IN_GROUP)).booleanValue();

		boolean canShare = isUserInGroup; // && (getLockedBy() == null || getLockedBy().trim().length() == 0));

		if (canShare == false) {
			canShare = isCreatedByLoggedUser(loggedUser) || isUserInGroup;

			if (canShare == false) {
				canShare = (isUserInGroup == false && isCreatedByLoggedUser(loggedUser));
			}
		} else if ((getLockedBy() == null || getLockedBy().trim().length() == 0) == false) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0303);
		}

		if (canShare == false) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0635);
		}

		return canShare;
	}

	/** 
	 * Checks whether the user has authority to change the proposal
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
	 * @return boolean
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
		String propShare = null;

		if (loggedUser != null) {
			if (isLoggedUserCreatorOfProposal(loggedUser)) {
				if (groupName == null) {
					propShare = getProposalSharing();
					if (propShare != null) {
						if (propShare.equals(UtilityConstants.CREATOR_FULL_MODE)) {
							result = true;
						}
					} else {
						result = true;
					}
				}
			} else {
				propShare = (String) compareValues.get(UtilityConstants.BO_SHARING);
				if (propShare != null) {
					if (propShare.equals(UtilityConstants.SHARED_FULL_MODE)) {
						if (groupName == null) {
							result = true;
						}
					}
				}
			}

			if (groupName != null && isLockedByLoggedUser(loggedUser)) {
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
	 * Checks whether the proposal header/inventory can be changed
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
			Boolean resultValue = (Boolean) postConditionResult.get(PC_PROPOSAL_CHANGE_PROPADMIN);
			if (resultValue != null) {
				return resultValue.booleanValue();
			}
		}
		statusCode = getStatusCode();
		if (ProposalContractStatusConstants.DRAFT.equals(statusCode) || ProposalContractStatusConstants.PRICED.equals(statusCode)) {
			result = true;
		}

		if (typeOfChange == HEADER) {
			if (!ProposalContractStatusConstants.DRAFT_TILL_HEADER_DETAILS.equals(statusCode)) {
				result = false;
			}
		}

		if (postCondition) {
			postConditionResult.put(PC_PROPOSAL_CHANGE_PROPADMIN, new Boolean(result));
		} else if (!result) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0602, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		return result;
	}

	/** 
	 * Sets the data of the proposal after the request for approval is rejected
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
		String statusCode = null;

		if (ContractTypeConstants.ORIGINAL.equals(cntrType) || ContractTypeConstants.REPLACEMENT.equals(cntrType) || ContractTypeConstants.RENEWAL.equals(cntrType)) {
			statusCode = ProposalContractStatusConstants.PRICED;
		} else if (ContractTypeConstants.VARIANCE.equals(cntrType)) {
			statusCode = ProposalContractStatusConstants.VARIANCE_REJECTED;
		}
		setStatusCode(statusCode);
		//setLockedBy(null); defect BHALM00076394
		//setLockedOn(null); defect BHALM00076394
	}

	/** 
	 * Sets the data of the proposal after approval
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
		setStatusCode(ProposalContractStatusConstants.CHECK_PROPOSAL_STATUS);
		setLockedBy(null);
		setLockedOn(null);
	}

	/** 
	 * Checks whether proposal is for renewal 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isRenewalProposal() {
		if (ContractTypeConstants.RENEWAL.equals(getContrType())) {
			return true;
		}
		return false;
	}

	/** 
	 * Checks whether proposal is for replacement
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isReplacementProposal() {
		if (ContractTypeConstants.REPLACEMENT.equals(getContrType())) {
			return true;
		}
		return false;
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
			validateForAddCustomer(type, map);
			validateForRegistration(type, map);

			postConditionResult.put(ButtonConstants.AMEND_SWO, ButtonConstants.AMEND_SWO);
			postConditionResult.put(ButtonConstants.DELTA_FETCH, ButtonConstants.DELTA_FETCH);
		}
	}
}