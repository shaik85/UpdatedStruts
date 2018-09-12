/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.helper;

import java.util.Calendar;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractDTOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.SalesOrgConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * 
 * This class is used for renew contract
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
public class RenewContractHelper
{
	private static final String CLASS_NAME = "RenewContractHelper";

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
	public RenewContractHelper()
	{
	}

	/**
	 * To validate and populate for renew contract 
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
	 * @param renewContractCustomDTO
	 * @param proposalContractBO
	 * @throws ServiceException
	 */
	public void validateAndPopulate(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO)
		throws ServiceException
	{
		String methodName = "validateAndPopulate";

		boolean isAnniversary = false; 
		
		isAnniversary = renewContractCustomDTO.isAnniversaryRenewal();
	
		/*
		boolean anniversaryOrNonAnniversary = isValidRenewalType(renewContractCustomDTO, proposalContractBO);
		boolean isAnniversary = isAnniversaryRenewal(renewContractCustomDTO, proposalContractBO); 
		boolean isNonAnniversary = false;
		if (isAnniversary == false)
		{
			isNonAnniversary = isNonAnniversaryRenewal(renewContractCustomDTO, proposalContractBO);

			if (isNonAnniversary == false)
			{
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0329);
			}
		}
		*/
		String proposalType = renewContractCustomDTO.getProposalType();
		ContractCustomDTO contractDTO = renewContractCustomDTO.getContractDTO();
		String salesOrg = contractDTO.getPrimarySalesOrg();

		boolean isAllFailed = true;
		if (isAnniversary)
		{
			boolean isValid = false;

			isValid =
				validateAndUpdateAnniversaryByRuleOne(
					renewContractCustomDTO,
					proposalContractBO,
					orgProposalContractBO);

			if (isValid)
			{
				isAllFailed = false;
			}

			boolean isRuleFiveValid = false;

			isValid =
				validateAndUpdateAnniversaryByRuleFive(
					renewContractCustomDTO,
					proposalContractBO,
					orgProposalContractBO);

			isRuleFiveValid = isValid;

			if (isValid)
			{
				isAllFailed = false;
			}

			isValid =
				validateAndUpdateAnniversaryByRuleSixAndSeven(
					renewContractCustomDTO,
					proposalContractBO,
					orgProposalContractBO,
					false);
					
		
			if (isValid)
			{
				populateForRuleSix(proposalContractBO, orgProposalContractBO);
				isAllFailed = false;
			}

			isValid =
				validateAndUpdateAnniversaryByRuleSixAndSeven(
					renewContractCustomDTO,
					proposalContractBO,
					orgProposalContractBO,
					true);

			if (isValid)
			{
				isAllFailed = false;
			}

			populateForRuleOneFiveSixAndSeven(proposalContractBO, orgProposalContractBO, isRuleFiveValid);
		}
		else
		{
			boolean isThreeValid = false;

			if (validateAndUpdateNonAnniversaryByRuleThree(renewContractCustomDTO,
				proposalContractBO,
				orgProposalContractBO))
			{
				isThreeValid = true;
				isAllFailed = false;
			}

			populateForRuleTwoOrThree(proposalContractBO, orgProposalContractBO, isThreeValid);
		}

		proposalContractBO.setExtContrNo(null);

		if (validateAndUpdateByRuleTwo(renewContractCustomDTO, proposalContractBO, orgProposalContractBO))
		{
			isAllFailed = false;
		}

		if (validateAndUpdateByRuleFour(renewContractCustomDTO, proposalContractBO, orgProposalContractBO))
		{
			isAllFailed = false;
		}

		if (isAllFailed)
		{
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0330);
		}

		OPPTLogger.debug("Contract start date" + proposalContractBO.getContrStartDate(), CLASS_NAME, methodName);
		OPPTLogger.debug(
			"Org Contract start date" + orgProposalContractBO.getContrStartDate(),
			CLASS_NAME,
			methodName);

		OPPTLogger.debug("Contract end date" + proposalContractBO.getContrEndDate(), CLASS_NAME, methodName);
		OPPTLogger.debug(
			"Org Contract end date" + orgProposalContractBO.getContrEndDate(),
			CLASS_NAME,
			methodName);

		OPPTLogger.debug(
			"Contract start period" + proposalContractBO.getContrStartPeriod(),
			CLASS_NAME,
			methodName);
		OPPTLogger.debug(
			"Org Contract start period" + orgProposalContractBO.getContrStartPeriod(),
			CLASS_NAME,
			methodName);

		OPPTLogger.debug("Contract end period" + proposalContractBO.getContrEndPeriod(), CLASS_NAME, methodName);
		OPPTLogger.debug(
			"Org Contract end period" + orgProposalContractBO.getContrEndPeriod(),
			CLASS_NAME,
			methodName);

		OPPTLogger.debug("contract no: " + proposalContractBO.getContrNo(), CLASS_NAME, methodName);
		OPPTLogger.debug("Org contract no: " + orgProposalContractBO.getContrNo(), CLASS_NAME, methodName);
		
		OPPTLogger.debug("contract repl no: " + proposalContractBO.getContrRenewNo(), CLASS_NAME, methodName);
		OPPTLogger.debug("Org contract repl no: " + orgProposalContractBO.getContrRenewNo(), CLASS_NAME, methodName);
	}

	private boolean isValidRenewalType(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO)
	{
		ContractCustomDTO contractDTO = renewContractCustomDTO.getContractDTO();

		String proposalType = renewContractCustomDTO.getProposalType();
		String salesOrg = contractDTO.getPrimarySalesOrg();

		Date contractStartDate = renewContractCustomDTO.getContractStartDate();
		Date contractPeriodEndDate = renewContractCustomDTO.getContractPeriodEndDate();

		OPPTCalender calendar = new OPPTCalender();
		int monthsBetween = calendar.getMonthsBetween(contractStartDate, contractPeriodEndDate);

		return (
			(checkProposalTypeForNonSalesOrg(proposalType, salesOrg)
				&& (monthsBetween >= 36 && monthsBetween < 60))
				|| ((ProposalTypeConstants.EGO.equals(proposalType)
					&& SalesOrgConstants.USA.equals(salesOrg) == false)
					&& (monthsBetween >= 24 && monthsBetween < 48)));
	}
	
	/**
	 * isAnniversaryRenewal
	 * To validate and populate for renew contract 
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
	 * @param renewContractCustomDTO
	 * @param proposalContractBO
	 * @return boolean
	 * @throws ServiceException
	 */

	public boolean isAnniversaryRenewal(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO) throws ServiceException
	{
		return isAnniversaryOrNonAnniversaryRenewal(renewContractCustomDTO, proposalContractBO, true);
	}
	
	/**
	 * isShowRadio
	 * To validate and populate for renew contract 
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
	 * @param renewContractCustomDTO
	 * @param proposalContractBO
	 * @return boolean
	 */
	public boolean isShowRadio(
			RenewContractCustomDTO renewContractCustomDTO,
			ProposalContractBO proposalContractBO)
	{
		return isShowRadioForRenewal(renewContractCustomDTO, proposalContractBO);
	}

	/**
	 * isNonAnniversaryRenewal
	 * To validate and populate for renew contract 
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
	 * @param renewContractCustomDTO
	 * @param proposalContractBO
	 * @return boolean
	 */
	private boolean isNonAnniversaryRenewal(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO)
	{
		return isAnniversaryOrNonAnniversaryRenewal(renewContractCustomDTO, proposalContractBO, false);
	}

	/**
	 * isAnniversaryOrNonAnniversaryRenewal
	 * To validate and populate for renew contract 
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
	 * @param renewContractCustomDTO
	 * @param proposalContractBO
	 * @param isAnniversary
	 * @return boolean
	 */
	private boolean isAnniversaryOrNonAnniversaryRenewal(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO,
		boolean isAnniversary)
	{
		String proposalType = renewContractCustomDTO.getProposalType();
		String salesOrg = renewContractCustomDTO.getPrimarySalesOrg();
		Date contractStartDate = renewContractCustomDTO.getContractStartDate();
		Date contractPeriodEndDate = renewContractCustomDTO.getContractPeriodEndDate();
		Date contractEndDate = renewContractCustomDTO.getContractEndDate();

		Date contractPeriodEndDateWithOnePlusYear = OPPTCalender.addDate(Calendar.YEAR, 1, contractPeriodEndDate);

		OPPTCalender calendar = new OPPTCalender();
		int monthsBetween = calendar.getMonthsBetween(contractStartDate, contractPeriodEndDate);

		boolean isDateEquals = calendar.isDateEqual(contractPeriodEndDate, contractEndDate);
		boolean isValidDateRange;
		boolean validMonthsBetweenOne;
		boolean validMonthsBetweenTwo;
		boolean isDateValidationSuccessful;
		monthsBetween++;

		if (isAnniversary)
		{
			isDateEquals = (isDateEquals == false);
			isValidDateRange =
				calendar.isDateGreater(contractEndDate, contractPeriodEndDateWithOnePlusYear)
					|| calendar.isDateEqual(contractEndDate, contractPeriodEndDateWithOnePlusYear);
			validMonthsBetweenOne = (monthsBetween < 36);
			validMonthsBetweenTwo = (monthsBetween < 24);

			isDateValidationSuccessful = isDateEquals && isValidDateRange;
		}
		else
		{
			isValidDateRange = calendar.isDateLesser(contractEndDate, contractPeriodEndDateWithOnePlusYear);
			validMonthsBetweenOne = (monthsBetween >= 60);
			validMonthsBetweenTwo = (monthsBetween >= 48);
			isDateValidationSuccessful = isDateEquals || isValidDateRange;
		}

		boolean isValid = false;

		if (((ProposalTypeConstants.TP.equals(proposalType) || checkProposalType(proposalType, salesOrg))
			&& isDateValidationSuccessful)
			|| (checkProposalTypeForNonSalesOrg(proposalType, salesOrg) && validMonthsBetweenOne)
			|| ((ProposalTypeConstants.EGO.equals(proposalType) && (SalesOrgConstants.USA.equals(salesOrg) == false))
				&& validMonthsBetweenTwo))
		{
			isValid = true;
		}

		return isValid;
	}
	
		private boolean isShowRadioForRenewal(
			RenewContractCustomDTO renewContractCustomDTO,
			ProposalContractBO proposalContractBO)
		{
			String proposalType = renewContractCustomDTO.getProposalType();
			String salesOrg = renewContractCustomDTO.getPrimarySalesOrg();
			
			Date contractStartDate = renewContractCustomDTO.getContractStartDate();
			Date contractPeriodEndDate = renewContractCustomDTO.getContractPeriodEndDate();
			Date contractEndDate = renewContractCustomDTO.getContractEndDate();

			Date contractPeriodEndDateWithOnePlusYear = OPPTCalender.addDate(Calendar.YEAR, 1, contractPeriodEndDate);
		
			OPPTCalender calendar = new OPPTCalender();
			int monthsBetween = calendar.getMonthsBetween(contractStartDate, contractPeriodEndDate);
			
			boolean isValid = false;
			monthsBetween++;
			
			if(proposalType.equals("EA") || proposalType.equals("EN") || ( proposalType.equals("AM") && !salesOrg.equals("0147"))) {
				if(monthsBetween >= 36 && monthsBetween < 60) {
					isValid = true;		
				}
			}
			else if (proposalType.equals("EG") && !salesOrg.equals("0147")) {
				if(monthsBetween >= 24 && monthsBetween < 48) {
					isValid = true;
				}
			}
			
			return isValid;
		}

	/** 
	 * 
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
	 * @param proposalType
	 * @param salesOrg
	 * @return 
	 */
	private boolean checkProposalTypeForNonSalesOrg(String proposalType, String salesOrg)
	{
		return (
			ProposalTypeConstants.EAS.equals(proposalType)
				|| ProposalTypeConstants.NUEV.equals(proposalType)
				|| (ProposalTypeConstants.AMO.equals(proposalType)
					&& (SalesOrgConstants.USA.equals(salesOrg) == false)));
	}

	/** 
	 * To check the proposal type
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
	 * @param proposalType
	 * @return 
	 */
	private boolean checkProposalType(String proposalType, String salesOrg)
	{
		return (
			ProposalTypeConstants.SGO.equals(proposalType)
				|| ProposalTypeConstants.ESSO.equals(proposalType)
				|| ProposalTypeConstants.PLE.equals(proposalType)
				|| ProposalTypeConstants.ELITE.equals(proposalType)
				|| (ProposalTypeConstants.AMO.equals(proposalType) && SalesOrgConstants.USA.equals(salesOrg))
				|| (ProposalTypeConstants.EGO.equals(proposalType) && SalesOrgConstants.USA.equals(salesOrg)));
	}

	private boolean validateAndUpdateAnniversaryByRuleOne(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO)
	{
		String proposalType = renewContractCustomDTO.getProposalType();
		ContractCustomDTO contractDTO = renewContractCustomDTO.getContractDTO();
		String salesOrg = contractDTO.getPrimarySalesOrg();

		boolean isValid = false;
		if (checkProposalType(proposalType, salesOrg))
		{
			populateForRuleOneFiveSixAndSeven(proposalContractBO, orgProposalContractBO, true);

			isValid = true;
		}

		return isValid;
	}

	private boolean validateAndUpdateByRuleTwo(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO)
		throws ServiceException
	{
		String proposalType = renewContractCustomDTO.getProposalType();
		ContractCustomDTO contractDTO = renewContractCustomDTO.getContractDTO();
		String salesOrg = contractDTO.getPrimarySalesOrg();
	
		Date contractPeriodEndDate = renewContractCustomDTO.getContractPeriodEndDate();
		Date contractEndDate = renewContractCustomDTO.getContractEndDate();

		Date contractPeriodEndDateWithOnePlusYear = OPPTCalender.addDate(Calendar.YEAR, 1, contractPeriodEndDate);

		OPPTCalender cal = new OPPTCalender();
		boolean isValid = false;
		
		if ((ProposalTypeConstants.TP.equals(proposalType) || checkProposalType(proposalType, salesOrg))
			&& cal.isDateLesser(contractEndDate, contractPeriodEndDateWithOnePlusYear))
		{
			populateForRuleTwoOrThree(proposalContractBO, orgProposalContractBO, false);

			isValid = true;
		}

		return isValid;
	}

	private boolean validateAndUpdateNonAnniversaryByRuleThree(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO)
		throws ServiceException
	{
		boolean isValid = false;

		String proposalType = renewContractCustomDTO.getProposalType();
		ContractCustomDTO contractDTO = renewContractCustomDTO.getContractDTO();
		String salesOrg = contractDTO.getPrimarySalesOrg();

		Date contractPeriodEndDate = renewContractCustomDTO.getContractPeriodEndDate();
		Date contractEndDate = renewContractCustomDTO.getContractEndDate();

		OPPTCalender calendar = new OPPTCalender();

		boolean isDateEquals = calendar.isDateEqual(contractEndDate, contractPeriodEndDate);

		if ((checkProposalType(proposalType, salesOrg) && isDateEquals )
			|| (checkProposalTypeForNonSalesOrg(proposalType, salesOrg)
				|| (ProposalTypeConstants.EGO.equals(proposalType)
					&& SalesOrgConstants.USA.equals(salesOrg) == false)))
		{
			populateForRuleTwoOrThree(proposalContractBO, orgProposalContractBO, true);

			isValid = true;
		}

		return isValid;
	}

	private boolean validateAndUpdateByRuleFour(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO)
		throws ServiceException
	{
		boolean isValid = false;

		String proposalType = renewContractCustomDTO.getProposalType();
		ProposalContractBOFactory factory = new ProposalContractBOFactory();

		Date contractPeriodEndDate = renewContractCustomDTO.getContractPeriodEndDate();
		Date contractEndDate = renewContractCustomDTO.getContractEndDate();

		OPPTCalender calendar = new OPPTCalender();

		boolean isDateEquals = calendar.isDateEqual(contractEndDate, contractPeriodEndDate);

		if (ProposalTypeConstants.TP.equals(proposalType) && isDateEquals)
		{
			populateContractStartPeriod(orgProposalContractBO, proposalContractBO);
			proposalContractBO.setContrStartDate(proposalContractBO.getContrStartPeriod());
			populateContractEndPeriod(
				orgProposalContractBO.getContrEndDate(),
				proposalContractBO,
				OPPTCalender.MONTH,
				3);
			populateContractEndDate(
				orgProposalContractBO.getContrEndDate(),
				proposalContractBO,
				OPPTCalender.YEAR,
				3);

			try {
				proposalContractBO.setContrNo(factory.getProposalContractBOWithMaxContractNumber("P01").getContrNo());
			} catch (Exception ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateAndUpdateByRuleFour", null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}
			isValid = true;
		}

		return isValid;
	}

	private boolean validateAndUpdateAnniversaryByRuleFive(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO)
		throws ServiceException
	{
		boolean isValid = false;

		String proposalType = renewContractCustomDTO.getProposalType();

		Date contractPeriodEndDate = renewContractCustomDTO.getContractPeriodEndDate();
		Date contractEndDate = renewContractCustomDTO.getContractEndDate();

		OPPTCalender calendar = new OPPTCalender();

		boolean isDateNotEquals = (calendar.isDateEqual(contractEndDate, contractPeriodEndDate) == false);

		if (ProposalTypeConstants.TP.equals(proposalType) && isDateNotEquals)
		{
			populateForRuleOneFiveSixAndSeven(proposalContractBO, orgProposalContractBO, true);

			isValid = true;
		}

		return isValid;
	}

	private boolean validateAndUpdateAnniversaryByRuleSixAndSeven(
		RenewContractCustomDTO renewContractCustomDTO,
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO,
		boolean isSeven)
		throws ServiceException
	{
		boolean isValid = false;

		ContractCustomDTO contractDTO = renewContractCustomDTO.getContractDTO();

		String proposalType = renewContractCustomDTO.getProposalType();
		String salesOrg = contractDTO.getPrimarySalesOrg();

		Date contractPeriodEndDate = renewContractCustomDTO.getContractPeriodEndDate();
		Date contractEndDate = renewContractCustomDTO.getContractEndDate();
		Date contractStartDate = renewContractCustomDTO.getContractStartDate();

		Date contractPeriodEndDateWithOnePlusYear = OPPTCalender.addDate(Calendar.YEAR, 1, contractPeriodEndDate);

		OPPTCalender calendar = new OPPTCalender();
		int monthsBetween = calendar.getMonthsBetween(contractStartDate, contractPeriodEndDate);

		boolean isContractEndDateEqualsToPeriodEndDatePlusOne =
			calendar.isDateEqual(contractEndDate, contractPeriodEndDateWithOnePlusYear);

		boolean isContractEndDateEqualsToPeriodEndDate =
			calendar.isDateEqual(contractEndDate, contractPeriodEndDate);

		boolean isContractEndDateLesserOrNot =
			calendar.isDateLesser(contractEndDate, contractPeriodEndDateWithOnePlusYear);

		if (isSeven)
		{
			isContractEndDateEqualsToPeriodEndDatePlusOne =
				(isContractEndDateEqualsToPeriodEndDatePlusOne == false);

			isContractEndDateEqualsToPeriodEndDate = (isContractEndDateEqualsToPeriodEndDate == false);
			isContractEndDateLesserOrNot =
				calendar.isDateLesser(contractPeriodEndDateWithOnePlusYear, contractEndDate);
		}

		if (checkProposalTypeForNonSalesOrg(proposalType, salesOrg)
			&& (((monthsBetween >= 36 && monthsBetween < 60)
				&& (isContractEndDateEqualsToPeriodEndDatePlusOne || isContractEndDateEqualsToPeriodEndDate))
			|| (monthsBetween < 36 && (isContractEndDateLesserOrNot || isContractEndDateEqualsToPeriodEndDate))))
		{
			isValid = true;
		}

		if (isSeven && (isValid == false))
		{
			isValid = (monthsBetween >= 60);
		}

		if (isValid
			|| (ProposalTypeConstants.EGO.equals(proposalType) && SalesOrgConstants.USA.equals(salesOrg) == false)
			&& (isContractEndDateLesserOrNot || isContractEndDateEqualsToPeriodEndDate))
		{
			populateForRuleOneFiveSixAndSeven(proposalContractBO, orgProposalContractBO, false);

			isValid = true;
		}

		return isValid;
	}

	/** 
	 * 
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
	 * @param proposalContractBO
	 * @param orgProposalContractBO
	 * @param b 
	 */
	private void populateForRuleOneFiveSixAndSeven(
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO,
		boolean isRuleFive)
	{
		populateContractStartPeriod(orgProposalContractBO, proposalContractBO);

		if (isRuleFive)
		{
			populateContractEndPeriod(
				orgProposalContractBO.getContrEndPeriod(),
				proposalContractBO,
				OPPTCalender.MONTH,
				3);
		}
		else
		{
			populateContractEndPeriod(orgProposalContractBO.getContrEndPeriod(), proposalContractBO);
		}

		proposalContractBO.setContrRenewNo(orgProposalContractBO.getContrRenewNo() + 1);
		proposalContractBO.setContrNo(
			getRenewContractNumber(orgProposalContractBO.getContrNo(), proposalContractBO.getContrRenewNo()));
		proposalContractBO.setContrReplNo(orgProposalContractBO.getContrReplNo());
		proposalContractBO.setContrAmendNo(orgProposalContractBO.getContrAmendNo());
	}
	
	/** 
		 * 
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
		 * @param proposalContractBO
		 * @param orgProposalContractBO
		 * @param b 
		 */
		private void populateForRuleSix(
			ProposalContractBO proposalContractBO,
			ProposalContractBO orgProposalContractBO)

		{
			populateContractEndDate(
					orgProposalContractBO.getContrEndDate(),
					proposalContractBO,
					OPPTCalender.YEAR,
					1);
		}
	/** 
	 * 
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
	 * @param proposalContractBO
	 * @param orgProposalContractBO 
	 */
	private void populateForRuleTwoOrThree(
		ProposalContractBO proposalContractBO,
		ProposalContractBO orgProposalContractBO,
		boolean isRuleThree)
		throws ServiceException
	{
		ProposalContractBOFactory factory = new ProposalContractBOFactory();
		/*
		if (isRuleThree)
			populateContractStartPeriodRuleThree(orgProposalContractBO, proposalContractBO);
		else
			populateContractStartPeriod(orgProposalContractBO, proposalContractBO);
		*/
		populateContractStartPeriod(orgProposalContractBO, proposalContractBO);
		proposalContractBO.setContrStartDate(proposalContractBO.getContrStartPeriod());
		
		/*
		if (isRuleThree)
			populateContractEndPeriod(
				orgProposalContractBO.getContrEndDate(),
				proposalContractBO,
				OPPTCalender.YEAR,
				1);
		else
			populateContractEndPeriod(
						orgProposalContractBO.getContrEndPeriod(),
						proposalContractBO,
						OPPTCalender.YEAR,
						1);
		*/
		populateContractEndPeriod(
						orgProposalContractBO.getContrEndPeriod(),
						proposalContractBO,
						OPPTCalender.YEAR,
						1);
		/*
		if (isRuleThree)
			populateContractEndDate(orgProposalContractBO.getContrEndDate(), proposalContractBO);
		else
			populateContractEndDate(orgProposalContractBO.getContrEndPeriod(), proposalContractBO);
		*/
		populateContractEndDate(orgProposalContractBO.getContrEndPeriod(), proposalContractBO);
		proposalContractBO.setContrRenewNo(1);

		try {
			proposalContractBO.setContrNo(
						factory.getProposalContractBOWithMaxContractNumber("P01").getContrNo());
		} catch (Exception ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "populateForRuleTwoOrThree", null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		
	}

	private void populateContractEndDate(Date date, ProposalContractBO proposalContractBO)
	{
		populateContractEndDate(
			date,
			proposalContractBO,
			OPPTCalender.YEAR,
			getPeriodAllowedForProposalType(proposalContractBO.getProposalType()));
	}

	/** 
	 * 
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
	 * @param orgProposalContractBO
	 * @param proposalContractBO 
	 */
	private void populateContractEndDate(Date date, ProposalContractBO proposalContractBO, int field, int amount)
	{
		Date newDate = OPPTCalender.addDate(field, amount, date);

		proposalContractBO.setContrEndDate(new java.sql.Date(newDate.getTime()));
	}

	private void populateContractEndPeriod(Date date, ProposalContractBO proposalContractBO)
	{
		populateContractEndPeriod(date, proposalContractBO, OPPTCalender.YEAR, 1);
	}

	/** 
	 * 
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
	 * @param orgProposalContractBO
	 * @param proposalContractBO 
	 */
	private void populateContractEndPeriod(
		Date date,
		ProposalContractBO proposalContractBO,
		int field,
		int amount)
	{
		Date newDate = OPPTCalender.addDate(field, amount, date);

		proposalContractBO.setContrEndPeriod(new java.sql.Date(newDate.getTime()));
	}

	/** 
	 * 
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
	 * @param orgProposalContractBO
	 * @param proposalContractBO 
	 */
	private void populateContractStartPeriod(
		ProposalContractBO orgProposalContractBO,
		ProposalContractBO proposalContractBO)
	{
		Date date = OPPTCalender.addDate(OPPTCalender.DATE, 1, orgProposalContractBO.getContrEndPeriod());

		proposalContractBO.setContrStartPeriod(new java.sql.Date(date.getTime()));
	}
	
	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 03, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param orgProposalContractBO
	 * @param proposalContractBO 
	 */
	private void populateContractStartPeriodRuleThree(
		ProposalContractBO orgProposalContractBO,
		ProposalContractBO proposalContractBO)
	{
		Date date = OPPTCalender.addDate(OPPTCalender.DATE, 1, orgProposalContractBO.getContrEndDate());

		proposalContractBO.setContrStartPeriod(new java.sql.Date(date.getTime()));
	}

	/** 
	 * To get the renew contract number 
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
	 * @param contractNumber
	 * @param contractRenewNo
	 * @return Renew contract number
	 */
	private String getRenewContractNumber(String contractNumber, double contractRenewNo)
	{
		final String RENEW_CONTRACT = "P";
		final String PADDING_CHAR = "0";

		String renewContractNoStr = Integer.toString((int) contractRenewNo);

		StringBuffer buffer = new StringBuffer();
		buffer.append(contractNumber.substring(0, 7));
		buffer.append(RENEW_CONTRACT);

		if (renewContractNoStr.length() == 1)
		{
			buffer.append(PADDING_CHAR);
		}

		buffer.append(renewContractNoStr);

		return buffer.toString();
	}

//	 Renewal rule for contract end date we allow 5 years for renewal of PLA and PLE
	private int getPeriodAllowedForProposalType(String proposalType)
	{
		int periodAllowed = 0;

		if (ProposalTypeConstants.ABA.equals(proposalType)
			|| ProposalTypeConstants.SGA1.equals(proposalType)
			|| ProposalTypeConstants.NUEV.equals(proposalType))
		{
			periodAllowed = 1;
		}
		else if (
			ProposalTypeConstants.AMO.equals(proposalType) || ProposalTypeConstants.ELITE.equals(proposalType))
		{
			periodAllowed = 5;
		}
		else if (ProposalTypeConstants.PLA.equals(proposalType) || ProposalTypeConstants.PLE.equals(proposalType)) {
			periodAllowed = 5;
		}
		else if (
			ProposalTypeConstants.ESSO.equals(proposalType)
				|| ProposalTypeConstants.EAS.equals(proposalType)
				|| ProposalTypeConstants.EGO.equals(proposalType)
				|| ProposalTypeConstants.SGO.equals(proposalType)
				|| ProposalTypeConstants.SGA3.equals(proposalType)
				|| ProposalTypeConstants.TP.equals(proposalType))
		{
			periodAllowed = 3;
		}

		return periodAllowed;
	}
}