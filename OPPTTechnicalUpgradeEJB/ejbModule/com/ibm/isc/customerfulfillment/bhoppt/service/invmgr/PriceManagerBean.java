/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.PricingComponentHelper;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.EEPriceManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PriceConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalContractStatusConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/**
 * This class will handle Pricing.
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A
 */
public class PriceManagerBean implements javax.ejb.SessionBean {
	private static final String CLASS_NAME = "PriceManagerBean";
	private javax.ejb.SessionContext mySessionCtx;
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}
	
	/**
	 *  This method will price the proposal. this will also update the 
	 *  esw,calculated prices of the Licence and EE. 
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
	 * @param PriceProposalDomainDTO
	 * @return PriceProposalDomainDTO
	 * @throws ServiceException
	 */
	
	public PriceProposalDomainDTO priceProposal(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {
		TimeTaken log = new TimeTaken(CLASS_NAME,"priceProposal");
		String messageString = "";
		SWOManagerLocalHome swoManagerLocalHome = (SWOManagerLocalHome)ServiceLocator.getEJBHomeFactory().getLocalHome("SWOManagerLocalHome");
		EEPriceManagerLocalHome eePriceManagerLocalHome = (EEPriceManagerLocalHome)ServiceLocator.getEJBHomeFactory().getLocalHome("EEPriceManagerLocalHome");
		SWOManagerLocal swoManagerLocal = null;
		EEPriceManagerLocal eePriceManagerLocal = null;
		// Will be removed asap with value from CustomDTO
		priceProposalDomainDTO.setActionName(ActionNameConstants.PRICE);
		try {
			swoManagerLocal =  swoManagerLocalHome.create();
		} catch (CreateException e) {
			// to be handled
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);			
		}
		
		try {
			eePriceManagerLocal = eePriceManagerLocalHome.create();
		} catch (CreateException e1) {
			// to be handled
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		// The call to the inventory that will return the list
		priceProposalDomainDTO  = swoManagerLocal.retrieveSWODetailsForPricing(priceProposalDomainDTO);
		
		if(ProposalTypeConstants.ESSO.equals(priceProposalDomainDTO.getProposalType().trim()) &&
		   ContractTypeConstants.VARIANCE.equals(priceProposalDomainDTO.getContrType().trim())) {
			// VARIANCE PROPOSAL
			OPPTLogger.log("MESSAGE_002",OPPTLogger.DEBUG,CLASS_NAME,"priceProposal",null);
			priceProposalDomainDTO = eePriceManagerLocal.priceVariance(priceProposalDomainDTO);
			List swoDomainDTOList = priceProposalDomainDTO.getSWODomainDTOList();
			SWODomainDTO swoDomainDTOArray [] = new SWODomainDTO[swoDomainDTOList.size()];
			swoDomainDTOArray =(SWODomainDTO []) swoDomainDTOList.toArray(swoDomainDTOArray);
			swoManagerLocal.updateSWODetails(swoDomainDTOArray);
	
		}else {
			// NOT A VARIANCE PROPOSAL
			if(UtilityConstants.MLC_AND_SANDS.equals(priceProposalDomainDTO.getProposalContent()) &&
			   (!swoManagerLocal.chkSandSLicense(priceProposalDomainDTO.getProposalId(), UtilityConstants.SANDS_IND)) &&
			   priceProposalDomainDTO.getSAndsAnniversaryAmount() > 0 
			   ) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0004);
			}	
			
			if(priceProposalDomainDTO.getSWODomainDTOList() == null || priceProposalDomainDTO.getSWODomainDTOList().size() == 0 ) {
				// Throw an exception 
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0009);
			}
			
			if(ProposalTypeConstants.EAS.equals(priceProposalDomainDTO.getProposalType())|| ProposalTypeConstants.PLA.equals(priceProposalDomainDTO.getProposalType())) {
				if(priceProposalDomainDTO.getSWODomainDTOList().size()  == getExcludedLicenceCount(priceProposalDomainDTO.getSWODomainDTOList())) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0008);				
				}
			}
			
			priceProposalDomainDTO.setSpecialRateFactor(calculateSpecialRateFactor(priceProposalDomainDTO.getPlannedGrowthRate()));
			priceProposalDomainDTO.setContractPeriodDuration(OPPTCalender.calculateContractPeriodDuration(priceProposalDomainDTO.getContrStartPeriod(), priceProposalDomainDTO.getContrEndPeriod()));
			priceProposalDomainDTO.setTvmFactors(calculateTVMFactors(priceProposalDomainDTO.getTvmRate(), priceProposalDomainDTO.getContractPeriodDuration()));
			priceProposalDomainDTO.setNumberOfBills(getNumberOfBills(priceProposalDomainDTO.getBillingFrequencyCode()));
			priceProposalDomainDTO.setAmortizationFactors(calculateAmortizationFactors(priceProposalDomainDTO.getTvmRate(), priceProposalDomainDTO.getContractPeriodDuration()));
			priceProposalDomainDTO.setAmortizationFactorForBillingFreq(calculateAmortizationFactorsForBillingFreq(priceProposalDomainDTO.getTvmRate(), priceProposalDomainDTO.getContractPeriodDuration(),priceProposalDomainDTO.getNumberOfBills()));
		//<!-- BlueHarmony DAD007 Changed by Anand Sugumaran -->
			priceProposalDomainDTO.setNumberOfMonthsForFrequency(getNumberOfMonthsForFrequency(priceProposalDomainDTO.getBillingFrequencyCode()));
       // <!-- BlueHarmony DAD007 Changes End by Anand Sugumaran -->					
			priceProposalDomainDTO = eePriceManagerLocal.calculatePrice(priceProposalDomainDTO);
			boolean anniversaryAmountProposal = isAnniversaryAmountProposal(priceProposalDomainDTO);
	//		<!-- BlueHarmony DAD007 Changes End by Anand Sugumaran -->	
			boolean excludedLicenceInd = isExcludedLicenceAvailableInProposal(priceProposalDomainDTO.getSWODomainDTOList());
			// Rule 12
			List swoDomainDTOList = priceProposalDomainDTO.getSWODomainDTOList();
				
			if(anniversaryAmountProposal && 
					   (ProposalTypeConstants.EAS.equals(priceProposalDomainDTO.getProposalType()) || ProposalTypeConstants.PLA.equals(priceProposalDomainDTO.getProposalType())) &&
					   excludedLicenceInd) {
				
				priceProposalDomainDTO = eePriceManagerLocal.priceAnnivEASExcludedProposal(priceProposalDomainDTO);
					
			}else if(anniversaryAmountProposal &&
					(!(ProposalTypeConstants.EAS.equals(priceProposalDomainDTO.getProposalType())|| ProposalTypeConstants.PLA.equals(priceProposalDomainDTO.getProposalType()))) ||
					 (anniversaryAmountProposal && 
					  (ProposalTypeConstants.EAS.equals(priceProposalDomainDTO.getProposalType()) || ProposalTypeConstants.PLA.equals(priceProposalDomainDTO.getProposalType()))&&
					  (!excludedLicenceInd))	
					) 
			{
				priceProposalDomainDTO = eePriceManagerLocal.priceAnnivAmtProposal(priceProposalDomainDTO);
				
			}
			
			priceProposalDomainDTO = eePriceManagerLocal.updateProposalPricingDetails(priceProposalDomainDTO);
			
			SWODomainDTO swoDomainDTOArray [] = new SWODomainDTO[swoDomainDTOList.size()];
			swoDomainDTOArray =(SWODomainDTO []) swoDomainDTOList.toArray(swoDomainDTOArray);
			swoManagerLocal.updateSWODetails(swoDomainDTOArray);
			
			if(PricingComponentHelper.getEECount(priceProposalDomainDTO.getSWODomainDTOList(),PriceConstants.ALL) == 0 &&
			   priceProposalDomainDTO.getAnnivAmount() > 0 ) {
			   	ErrorReport messages = priceProposalDomainDTO.getMessageReport();
			   	if(messages == null ) {
			   		messages = new ErrorReport();
			   	}
				ExceptionGenerator.addErrorEntry(messages,ErrorCodeConstants.SE0016,OPPTMessageCatalog.TYPE_SERVICE);
				priceProposalDomainDTO.setMessageReport(messages);
			}
			
		}
		//MESSAGE_028 = pricing done for proposal id ?1 status ?2 type ?3 annivamount ?4 invoice amount ?5 billing Freq ?6
		messageString = OPPTHelper.getLogString(String.valueOf(priceProposalDomainDTO.getProposalId()),
		                                        priceProposalDomainDTO.getStatusCode(),
		                                        priceProposalDomainDTO.getProposalType(),
											    String.valueOf(priceProposalDomainDTO.getAnnivAmount()),
												String.valueOf(priceProposalDomainDTO.getInvoiceAmt()),
		                                        priceProposalDomainDTO.getBillingFrequencyCode());
		OPPTLogger.log("MESSAGE_028",OPPTLogger.DEBUG,CLASS_NAME,"priceProposal",messageString);
		log.end();
		return priceProposalDomainDTO;
	}
	
	/**
	 * This method is used to calculate the special rate factor
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param double plannedGrowthRate
	 * @return double
	 */
	
	private BigDecimal calculateSpecialRateFactor(double plannedGrowthRate) {
		double specialRateFactor = (plannedGrowthRate + 100)/100;
		String messageString = OPPTHelper.getLogString(String.valueOf(specialRateFactor));
		OPPTLogger.log("SPECIAL_RATE_FACTOR",OPPTLogger.DEBUG,CLASS_NAME,"calculateSpecialRateFactor",messageString);
		return PricingComponentHelper.convertToBigDecimal(specialRateFactor);
	}
	
	/**
	 * This method is used to calculate the tvm factors based on the tvm rate
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param doublet vmRate
	 * @param int contractPeriodDuration
	 * @return double []
	 */
	private BigDecimal [] calculateTVMFactors(double tvmRate, int contractPeriodDuration) {
		BigDecimal [] tvmFactors = new BigDecimal[contractPeriodDuration];
		
		for(int i=0;i<contractPeriodDuration;i++) {
			tvmFactors [i] = PricingComponentHelper.convertToBigDecimal(Math.pow((1+((tvmRate/100)/12)),-i));
			String messageString = OPPTHelper.getLogString(String.valueOf(i),String.valueOf(tvmFactors [i]));
			OPPTLogger.log("TVM_FACTORS",OPPTLogger.DEBUG,CLASS_NAME,"calculateTVMFactors",messageString);
		}
		
		return tvmFactors;
	}
	
	/**
	 * This method is used to calculate the AmortizationFactor for BillingFrequency
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param double tvmRate
	 * @param int contractPeriodMonths
	 * @param int numberOfBills
	 * @return double
	 */
	private BigDecimal calculateAmortizationFactorsForBillingFreq(double tvmRate, int contractPeriodMonths,int numberOfBills) {
	
		double amortizationFactorsForBillingFreq = 0.0;
		
		if(tvmRate == 0) {
			amortizationFactorsForBillingFreq = 1/(numberOfBills*(contractPeriodMonths/12.0));
		}else {
			amortizationFactorsForBillingFreq = (tvmRate/100)/((1+ tvmRate/100)*(1- Math.pow((1+ tvmRate/100), - ( numberOfBills*(contractPeriodMonths/12.0)))));
		}
		String messageString = OPPTHelper.getLogString(String.valueOf(amortizationFactorsForBillingFreq));
		OPPTLogger.log("AMORT_FACTOR_FOR_BILLING_FREQ",OPPTLogger.DEBUG,CLASS_NAME,"calculateAmortizationFactorsForBillingFreq",messageString);
		return PricingComponentHelper.convertToBigDecimal(amortizationFactorsForBillingFreq);
	}
	
	/**
	 * This method is used to calculate the AmortizationFactors for various billing freq
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param double tvmRate
	 * @param int contractPeriodMonths
	 * @return double
	 */	
	private BigDecimal [] calculateAmortizationFactors(double tvmRate, int contractPeriodMonths) {
		BigDecimal amortizationFactors [] = new BigDecimal [4];
		double months = 12.0;
		String messageString = OPPTHelper.getLogString(String.valueOf(contractPeriodMonths));
		OPPTLogger.log("MESSAGE_006",OPPTLogger.DEBUG,CLASS_NAME,"calculateAmortizationFactors",messageString);
		if(tvmRate == 0) {
			// Annually
			amortizationFactors[0] = PricingComponentHelper.convertToBigDecimal(1/(1*(contractPeriodMonths/months)));
			// Semi Annually
			amortizationFactors[1] = PricingComponentHelper.convertToBigDecimal(1/(2*(contractPeriodMonths/months)));
			// Quarterly 
			amortizationFactors[2] = PricingComponentHelper.convertToBigDecimal(1/(4*(contractPeriodMonths/months)));
			// Monthly
			amortizationFactors[3] = PricingComponentHelper.convertToBigDecimal(1/(12*(contractPeriodMonths/months)));
		}else {
			// Annually
			amortizationFactors[0] = PricingComponentHelper.convertToBigDecimal((tvmRate/100)/((1+ tvmRate/100)*(1- Math.pow((1+ tvmRate/100), - ( 1*(contractPeriodMonths/months))))));
			// Semi Annually
			amortizationFactors[1] = PricingComponentHelper.convertToBigDecimal((tvmRate/100)/((1+ tvmRate/100)*(1- Math.pow((1+ tvmRate/100), - ( 2*(contractPeriodMonths/months))))));
			// Quarterly
			amortizationFactors[2] = PricingComponentHelper.convertToBigDecimal((tvmRate/100)/((1+ tvmRate/100)*(1- Math.pow((1+ tvmRate/100), - ( 4*(contractPeriodMonths/months))))));
			// Monthly
			amortizationFactors[3] = PricingComponentHelper.convertToBigDecimal((tvmRate/100)/((1+ tvmRate/100)*(1- Math.pow((1+ tvmRate/100), - ( 12*(contractPeriodMonths/months))))));
		}
		return amortizationFactors;
	}
	
	/**
	 * This method is used for getting the number of bills based on billing freq code
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param java.lang.String code
	 * @return int 
	 */
	private int getNumberOfBills(String code) {
		
		int bills = 0;
		
		char codeArray[] = code.toCharArray();
	
		switch(codeArray[0]){
		 case 'A': bills = 1;
		 break;
		 case 'M': bills = 12;
		 break;
		 case 'Q': bills = 4;
		 break;
		 case 'S': bills = 2;
		 break;
		 default:
		}
		return bills;
	}
	
	
	
	/**
	 * This method is used for getting the number of months based on billing freq code
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 4,2010
	 * <!-- BlueHarmony DAD007 Changed by Anand Sugumaran -->
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param java.lang.String code
	 * @return int 
	 */
	
	private int getNumberOfMonthsForFrequency(String code) {
		
		int bills = 0;
		
		char codeArray[] = code.toCharArray();
	
		switch(codeArray[0]){
		 case 'A': bills = 12;
		 break;
		 case 'M': bills = 1;
		 break;
		 case 'Q': bills = 3;
		 break;
		 case 'S': bills = 6;
		 break;
		 default:
		}
		return bills;
	}
	
	//<!-- BlueHarmony DAD007 Changed by Anand Sugumaran -->
		
	/**
	 *  
	 * This method find out if the proposal has anniversary amount and if anniversary amount,
	 * is available it also checks if it is exact multiple of billing freq
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param java.util.List swoList
	 * @return boolean
	 */
	
	
	private boolean isAnniversaryAmountProposal(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {
		double anniversaryAmt = priceProposalDomainDTO.getAnnivAmount();
		boolean annivAmtProposal = false;
		if(anniversaryAmt > 0 ) {
			/*int numberOfBills = priceProposalDomainDTO.getNumberOfBills();
			double factor1 = anniversaryAmt/numberOfBills;
			long factor2 = (long)anniversaryAmt/numberOfBills;
		
			if(factor1 -factor2 == 0) {*/
				annivAmtProposal = true;
		//	}
			/*if(!annivAmtProposal) {
				// this means anniversary amount is no a exact multiple of billing freq
				// this should not happen since this should be validated on creating the proposal
			}*/
		}
		
		return annivAmtProposal;
	}
	
	/**
	 *  
	 * This method find out if there are any licences which are excluded from special pricing.
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param java.util.List swoList
	 * @return boolean
	 */
	
	private boolean isExcludedLicenceAvailableInProposal(List swoList) {
		boolean excludedLicenseAvailable = false;
		for(int i=0, size = swoList.size();i< size;i++) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
			if(PriceConstants.YES.equals(swoDomainDTO.getExclusionId())) {
				excludedLicenseAvailable = true;
				break;	 
			}
		}
		return excludedLicenseAvailable;
	}
	
	/**
	 *  
	 * This method find out if there are any licences which are excluded from special pricing.
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param java.util.List swoList
	 * @return boolean
	 */	
	private int getExcludedLicenceCount (List swoList) {
		
		int excludedLicenseCount = 0;
		for(int i=0, size = swoList.size();i< size;i++) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
			if(PriceConstants.YES.equals(swoDomainDTO.getExclusionId())) {
				excludedLicenseCount++; 
			}
		}
		return excludedLicenseCount;
	}
	
	private boolean isAnnvAmtLessThanCalcPriceofExcludedLicence(List swoList, double anniversaryAmount) {
		boolean result = false;
		for(int i=0, size = swoList.size();i< size;i++) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
			if(PriceConstants.YES.equals(swoDomainDTO.getExclusionId())) {
				if(swoDomainDTO.getCalcPrice() > anniversaryAmount) {
					result = true;
					break;
				}	 
			}
		}
		return result;
		
	}
	
}
