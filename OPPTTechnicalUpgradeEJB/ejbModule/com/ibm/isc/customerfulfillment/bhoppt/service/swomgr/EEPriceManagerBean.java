/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.PricingComponentHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 *  
 * This Class is used to calculate the price of a proposal. 
 * It has all the pricing logic
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 2, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A
 */
public class EEPriceManagerBean implements javax.ejb.SessionBean {
	
	public static final String CLASS_NAME = "EEPriceManagerBean"; 
	
	private javax.ejb.SessionContext mySessionCtx;
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
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
	 * This method is used to calculate the diffrence between amount to be distributed and adds this diff to 
	 * the ee which has minimum calculated price. IF there are decimals (possible in Variance Proposal) that decimal
	 * will be added to the calc price of ee which has minimum calc price	 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param invoiceAmount
	 * @param amountToBeDistributed
	 * @param swoList
	 * @param decimalsAllowed
	 * @param licenceType
	 */
	
	private void adjustDiffrence (BigDecimal invoiceAmount, 
								  BigDecimal amountToBeDistributed, 
								  List swoList, int decimalsAllowed, String licenceType) {
		String logMessage = "";
		System.out.println("EEPriceManagerBean.adjustDiffrence()");
		logMessage = OPPTHelper.getLogString(String.valueOf(invoiceAmount));		
		OPPTLogger.log("MESSAGE_004",OPPTLogger.DEBUG,CLASS_NAME,"adjustDiffrence",logMessage);
		logMessage = OPPTHelper.getLogString(String.valueOf(amountToBeDistributed));		
		OPPTLogger.log("MESSAGE_008",OPPTLogger.DEBUG,CLASS_NAME,"adjustDiffrence",logMessage);

		BigDecimal amountWhole = amountToBeDistributed.setScale(0,BigDecimal.ROUND_DOWN);
		BigDecimal amountDecimals = amountToBeDistributed.subtract(amountWhole);
		BigDecimal diffrenceAmount = amountWhole.subtract(invoiceAmount);
		updateEEWithMinCalcPrice(swoList, diffrenceAmount,decimalsAllowed,licenceType);
		if(amountDecimals.doubleValue() > 0) {
			updateEEWithMinCalcPrice(swoList, amountDecimals,decimalsAllowed,licenceType);
		}
	}
	
	
	private void adjustAltpriceDifference(BigDecimal diffrenceAmount,
			SWODomainDTO swoDomainDTO,int decimalsAllowed) {
		System.out.println("EEPriceManagerBean.adjustAltpriceDifference()");
		int eePosition =0;
		double minAltPrice = 0.0;
		String logMessage = "";
		boolean minAltPriceInd = false;
		List eeList = swoDomainDTO.getEEDTOList();
		for (int j = 0; j < eeList.size(); j++) {
			System.out.println("EEPriceManagerBean.adjustAltpriceDifference():0:");
			EEDomainDTO eEDomainDTO = (EEDomainDTO) eeList.get(j);
			if(eEDomainDTO.getAlternatePrice() > 0) {
				if(!minAltPriceInd) {
					minAltPriceInd = true;
					minAltPrice = eEDomainDTO.getAlternatePrice();
					eePosition = j;
					continue;
				 }
				if(eEDomainDTO.getCalculatedPrice() < minAltPrice) {
					minAltPrice = eEDomainDTO.getCalculatedPrice();
					eePosition = j;
				}
			  }
		}
		List eeList1 = swoDomainDTO.getEEDTOList();
		EEDomainDTO eeWithMinAltPrice = (EEDomainDTO) eeList1.get(eePosition);
		BigDecimal minEEAltPrice = PricingComponentHelper.convertToBigDecimal(eeWithMinAltPrice.getAlternatePrice());
		minEEAltPrice = minEEAltPrice.add(diffrenceAmount);
		//BigDecimal minEESWOPrice = PricingComponentHelper.convertToBigDecimal(swoDomainDTO.getAlternatePrice());
		//minEESWOPrice = minEESWOPrice.add(diffrenceAmount);
		double eeAlternatePrice = PricingComponentHelper.round(minEEAltPrice, decimalsAllowed);
		logMessage = OPPTHelper.getLogString(String.valueOf(eeWithMinAltPrice.getEeId()));
		OPPTLogger.log("MESSAGE_020",OPPTLogger.DEBUG,CLASS_NAME,"adjustAltpriceDifference",logMessage);
		eeWithMinAltPrice.setAlternatePrice(eeAlternatePrice);
		//double swoAlternatePrice = PricingComponentHelper.round(minEESWOPrice, decimalsAllowed);
		//swoDomainDTO.setCalcPrice(swoAlternatePrice);
		//System.out.println("EEPriceManagerBean.adjustAltpriceDifference():0+:");
	}
	

	
	/**
	 * This is the method which is used to calculate the esw price, calculated price fo ee
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
	 * @param SWODomainDTO swoDomainDTO
	 * @param PriceProposalDomainDTO priceProposalDomainDTO
	 * @param booleaq swoAltPriceInd
	 * @return void
	 *  
	 */
	
	private void applyPricingLogic(SWODomainDTO swoDomainDTO, PriceProposalDomainDTO priceProposalDomainDTO,boolean swoAltPriceInd) throws ServiceException {
		System.out.println("EEPriceManagerBean.applyPricingLogic()");
		TimeTaken log = new TimeTaken(CLASS_NAME, "applyPricingLogic");
		String logMessage = "";
		boolean isSAndSLicence = UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd()) ? true:false;
		List eeDTOList = swoDomainDTO.getEEDTOList();
		Date contractPeriodStartDate = priceProposalDomainDTO.getContrStartPeriod();
		Date contractPeriodEndDate = priceProposalDomainDTO.getContrEndPeriod();
		Date planStartDateOfLicence = swoDomainDTO.getPlanStartDate();
		Date planEndDateOfLicence = swoDomainDTO.getPlanEndDate();
		BigDecimal swoESWPrice = PricingComponentHelper.convertToBigDecimal(0.0);
		
		// Added for S and S negative swo duration
		boolean negativeSwoDurationForSandS = false;
		/* Temp setup for testing pricing after migration all swo's will have plan start date and end date
		 * currently in dev most of the plan dates are null  
		*/
		if(planStartDateOfLicence == null || planEndDateOfLicence == null) {
			planStartDateOfLicence = contractPeriodStartDate;
			planEndDateOfLicence = contractPeriodEndDate;
		}
			 
		OPPTCalender calender = new OPPTCalender();
		int contractPeriodStartYear = calender.getYear(contractPeriodStartDate);
		int contractPeriodStartMonth = calender.getMonth(contractPeriodStartDate);
		int contractPeriodEndYear = calender.getYear(contractPeriodEndDate);
		int contractPeriodEndMonth = calender.getMonth(contractPeriodEndDate);
		int contractPeriodDuration = priceProposalDomainDTO.getContractPeriodDuration();
		System.out.println("EEPriceManagerBean.applyPricingLogic():contractPeriodDuration:"+contractPeriodDuration);
		System.out.println("EEPriceManagerBean.applyPricingLogic():Billing Freeq:"+priceProposalDomainDTO.getAmortizationFactorForBillingFreq());
		int swoDuration = OPPTCalender.calculateContractPeriodDuration(planStartDateOfLicence,planEndDateOfLicence);
		if(swoDuration < 0 && !isSAndSLicence) {
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0032);
		}
		if(swoDuration < 0 && isSAndSLicence) {
			OPPTLogger.debug("Negative swo duration",CLASS_NAME,"applyPricingLogic");
			negativeSwoDurationForSandS = true;
		}
		logMessage = OPPTHelper.getLogString(String.valueOf(swoDuration));
		OPPTLogger.log("SWO_DURATION",OPPTLogger.DEBUG,CLASS_NAME,"applyPricingLogic",logMessage);
		BigDecimal [] tvmFactors;
		//System.out.println("EEPriceManagerBean.applyPricingLogic():TVM:"+priceProposalDomainDTO.getTvmRate());
		//System.out.println("EEPriceManagerBean.applyPricingLogic():Discount:"+priceProposalDomainDTO.getDiscount());
		
		/* CR6153 start change */
		if((priceProposalDomainDTO.getExtendPeriod() != null) && (priceProposalDomainDTO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
			if(swoDuration > 0){
				tvmFactors = calculateTVMFactors(priceProposalDomainDTO.getTvmRate(), swoDuration);
			}
			else{
				tvmFactors = priceProposalDomainDTO.getTvmFactors();
			}
		}
		else{
		/* CR6153 end change */
			tvmFactors = priceProposalDomainDTO.getTvmFactors();
		}
			
		
		if(negativeSwoDurationForSandS) {
			for(int i= 0, size = eeDTOList.size(); i < size ; i++) {
				EEDomainDTO eeDomainDTO = (EEDomainDTO) eeDTOList.get(i);
				List priceDTOList = eeDomainDTO.getPriceDTOList();
				if(priceDTOList != null && priceDTOList.size() >0) {
					// EE has normal price 
					for(int j = 0, priceSize =  priceDTOList.size(); j< priceSize; j++) {
						PriceDomainDTO priceDomainDTO = (PriceDomainDTO)priceDTOList.get(j);
						if(j==0) {
							eeDomainDTO.setEswPrice(priceDomainDTO.getEswPrice());
							eeDomainDTO.setCalculatedPrice(0);
							break;
						}
					}
				}
				swoESWPrice = swoESWPrice.add(OPPTHelper.convertToBigDecimal(eeDomainDTO.getEswPrice()));
			}
			double roundedESWPrice = PricingComponentHelper.round(swoESWPrice.doubleValue(),priceProposalDomainDTO.getDecimalsAllowed());
			swoDomainDTO.setEswPrice(roundedESWPrice);
			swoDomainDTO.setCalcPrice(0);
			return;
		}
		
		
		
		BigDecimal [] dayFactors = calculateDayFactors(planStartDateOfLicence,planEndDateOfLicence,swoDuration);
		boolean [] pricingPeriods = priceProposalDomainDTO.getPricingFlags();
		// For rule 4
		boolean monthlyPriceCalcInd = false;
		
		BigDecimal tempSWOAltPrice = PricingComponentHelper.convertToBigDecimal(0.0);
		// this will be true if either swo or ee has alt price
		boolean altPriceInd = false;
		if(swoAltPriceInd) {
			altPriceInd = true;
		}
		
		// rule 4
		if((!altPriceInd) &&
		   priceProposalDomainDTO.getAnnivAmount() > 0 && 
		   (ProposalTypeConstants.EAS.equals(priceProposalDomainDTO.getProposalType()) || ProposalTypeConstants.PLA.equals(priceProposalDomainDTO.getProposalType())) &&
		   PriceConstants.YES.equals(swoDomainDTO.getExclusionId()) &&
		   (!PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())) &&
		   (!isSAndSLicence) 
		   )
		{
			monthlyPriceCalcInd = true;
		}		
		
		for(int i= 0, size = eeDTOList.size(); i < size ; i++) {
			EEDomainDTO eeDomainDTO = (EEDomainDTO) eeDTOList.get(i);
			BigDecimal eeTotalMonthlyPrice = PricingComponentHelper.convertToBigDecimal(0.0);
			BigDecimal localMonthlyPrice = PricingComponentHelper.convertToBigDecimal(0.0);
			Date planComparisionDate = planStartDateOfLicence;
			Set monthsPriced = new HashSet();
			boolean eealtPriceInd = false;
			boolean eeNOCharge = false;
			if(eeDomainDTO.getChargeOptionDesc() != null && 
			   UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc())) {
			   	// License with NO Charge
				eeNOCharge = true;
				eeDomainDTO.setCalculatedPrice(0);
				eeDomainDTO.setEswPrice(0);
				continue;
			}
			
			
			// Rule 7b
			if(UtilityConstants.YES.equals(eeDomainDTO.getAlternatePriceUpdateInd())) {
				altPriceInd = true;
				eealtPriceInd = true;
				applyPricingLogicForEEWithAltPrice(eeDomainDTO, swoDomainDTO, priceProposalDomainDTO,swoAltPriceInd,swoDomainDTO.getExclusionId());										
			}
			List priceDTOList = eeDomainDTO.getPriceDTOList();
			if(priceDTOList != null && priceDTOList.size() >0) {
				// EE has normal price 
				for(int j = 0, priceSize =  priceDTOList.size(); j< priceSize; j++) {
					PriceDomainDTO priceDomainDTO = (PriceDomainDTO)priceDTOList.get(j);
												
					Date billPlanStartDate = priceDomainDTO.getBillPlanStartDate();
					Date billPlanEndDate = priceDomainDTO.getBillPlanEndDate();
					
					//BigDecimal eeMonthlyPrice  = PricingComponentHelper.convertToBigDecimal(0.0);
					BigDecimal eeMonthlyPrice = PricingComponentHelper.convertToBigDecimal(priceDomainDTO.getEswPrice());
					// rule 2,3 
					// first billplan start date is less than contract period start date
					if(0==j) {
						//	ESW price of the first billing plan period should be the esw price of ee
						//  This is due to the order by bill plan start date in price query
						eeDomainDTO.setEswPrice(priceDomainDTO.getEswPrice());
						
						if(calender.isDateLesser(billPlanStartDate,contractPeriodStartDate) ||
						   ((calender.isDateGreater(billPlanStartDate,contractPeriodStartDate) ||
							 calender.isDateEqual(billPlanStartDate,contractPeriodStartDate)) &&
							calender.getYear(billPlanStartDate) == calender.getYear(billPlanEndDate) &&
							calender.getMonth(billPlanStartDate) == calender.getMonth(billPlanEndDate)  
							)
						  ) {  
						
								if(31 == calender.getDay(billPlanStartDate)) {
									// rule 2
									eeMonthlyPrice = PricingComponentHelper.convertToBigDecimal(0.0);
								}else if(31 != calender.getDay(billPlanStartDate)) {
									// rule 3
									eeMonthlyPrice = PricingComponentHelper.convertToBigDecimal(priceDomainDTO.getEswPrice());
								}						
						}
					} else {
						// rule 3
						// Not first bill plan
						eeMonthlyPrice = PricingComponentHelper.convertToBigDecimal(priceDomainDTO.getEswPrice());
					}
									
					
					// S And S change 
					if(isSAndSLicence && 0 != eeMonthlyPrice.doubleValue()) {
						BigDecimal twelve = PricingComponentHelper.convertToBigDecimal(12.0);
						if(eeDomainDTO.getSAndSDiscountPercent() > 0) {
							BigDecimal sAndSDiscountPercent = PricingComponentHelper.convertToBigDecimal((eeDomainDTO.getSAndSDiscountPercent()/100));
							BigDecimal eeMonthlyPriceDiscounted = eeMonthlyPrice.multiply(sAndSDiscountPercent);
							eeMonthlyPrice = eeMonthlyPrice.subtract(eeMonthlyPriceDiscounted);
						}
						
						eeMonthlyPrice = eeMonthlyPrice.divide(twelve,PriceConstants.PRECISION,BigDecimal.ROUND_UP);			
					}
					
					logMessage = OPPTHelper.getLogString(String.valueOf(eeMonthlyPrice));
					OPPTLogger.log("MESSAGE_007",OPPTLogger.DEBUG,CLASS_NAME,"applyPricingLogic",logMessage);
					/*
					 * we should loop thro all the months within the bill plan and calaculate
					 * monthly price for the ee within that particular bill plan,
					 * TODO This should be reviewed again 
					 */
					if(pricingPeriods[0]||pricingPeriods[1]) {
						// amendedLicences
						int [] pricingPeriodDuration = priceProposalDomainDTO.getPricingPeriodDuration();
						Date [] pricingPeriodStartDate = priceProposalDomainDTO.getPricingPeriodStartDate();
						Date [] pricingPeriodEndDate = priceProposalDomainDTO.getPricingPeriodEndDate();
						for(int z=0;z<pricingPeriods.length;z++) {
							if(!pricingPeriods[z]) {
								continue;
							}
							contractPeriodDuration = pricingPeriodDuration[z];
							contractPeriodEndDate = pricingPeriodEndDate[z];
							contractPeriodStartDate = pricingPeriodStartDate[z];
							if(z==0) {
								tvmFactors = priceProposalDomainDTO.getFirstPricingPeriodTVM();
								dayFactors = priceProposalDomainDTO.getFirstPricingPeriodDayFactors();
								
							}else{
								tvmFactors = priceProposalDomainDTO.getSecondPricingPeriodDayFactors();
								dayFactors = priceProposalDomainDTO.getSecondPricingPeriodTVM();
							}
							
							for(int k =0; k< contractPeriodDuration; k++) {
								// Rule 4b
								if(k == 0 && 31 == calender.getDay(contractPeriodStartDate)) {
									// First Billing and start day is 31. we do no add this to the total
									continue;							 
								}
								// Rule 4c
								if((calender.isDateLesser(billPlanEndDate,planEndDateOfLicence) ||
								    calender.isDateEqual(billPlanEndDate,planEndDateOfLicence) ) ||
								   (calender.isDateGreater(billPlanEndDate,planEndDateOfLicence) &&
							   	    calender.getMonth(billPlanEndDate) != calender.getMonth(planEndDateOfLicence) &&
							        calender.getYear(billPlanEndDate) != calender.getYear(planEndDateOfLicence))) {
						  
									localMonthlyPrice = (eeMonthlyPrice.multiply(tvmFactors[k])).multiply(dayFactors[k]);
									eeTotalMonthlyPrice = localMonthlyPrice.add(eeTotalMonthlyPrice);
												  
								} 
								// Rule 4d
								if(calender.isDateGreater(billPlanEndDate,planEndDateOfLicence) &&
							       calender.getMonth(billPlanEndDate) == calender.getMonth(planEndDateOfLicence) &&
							   	   calender.getYear(billPlanEndDate) == calender.getYear(planEndDateOfLicence)) {
						
									localMonthlyPrice = (eeMonthlyPrice.multiply(tvmFactors[k])).multiply(dayFactors[k]);
									eeTotalMonthlyPrice = localMonthlyPrice.add(eeTotalMonthlyPrice);
								}
							}
						}
		
					}else {
						
						int duartionForPricing = 0;
						if(contractPeriodDuration == swoDuration) {
							duartionForPricing = contractPeriodDuration;	
						}else {
							duartionForPricing = swoDuration;
							//tvmFactors = 
						}
						
						for(int k =0; k< duartionForPricing; k++) {
							// Rule 4b
							if(k == 0 && 31 == calender.getDay(contractPeriodStartDate)) {
								// First Billing and start day is 31. we do no add this to the total
								continue;							 
							}
							
							// This is added to fix a bug.When 					
							if(calender.isDateGreaterInMonths(planComparisionDate,billPlanEndDate)) {
								continue;
							}
							if(monthsPriced.contains(new Integer(k))) {
								continue;
							}
							
							// Rule 4c
							if((calender.isDateLesser(billPlanEndDate,planEndDateOfLicence) ||
								calender.isDateEqual(billPlanEndDate,planEndDateOfLicence)) ||
							   (calender.isDateGreater(billPlanEndDate,planEndDateOfLicence) &&
								calender.getMonth(billPlanEndDate) != calender.getMonth(planEndDateOfLicence))) {
								localMonthlyPrice = (eeMonthlyPrice.multiply(tvmFactors[k])).multiply(dayFactors[k]);
								eeTotalMonthlyPrice = localMonthlyPrice.add(eeTotalMonthlyPrice);
												  
							} 
							// Rule 4d
							if(calender.isDateGreater(billPlanEndDate,planEndDateOfLicence) &&
							   calender.getMonth(billPlanEndDate) == calender.getMonth(planEndDateOfLicence) &&
							   calender.getYear(billPlanEndDate) == calender.getYear(planEndDateOfLicence)) {
								
								localMonthlyPrice = (eeMonthlyPrice.multiply(tvmFactors[k])).multiply(dayFactors[k]);
								eeTotalMonthlyPrice = localMonthlyPrice.add(eeTotalMonthlyPrice);
							}
							planComparisionDate = OPPTCalender.rollMonth(planComparisionDate);
							monthsPriced.add(new Integer(k));
							
							
						}
					}
					logMessage = OPPTHelper.getLogString(String.valueOf(eeTotalMonthlyPrice));
					OPPTLogger.log("MESSAGE_012",OPPTLogger.DEBUG,CLASS_NAME,"applyPricingLogic",logMessage);
				}// end of price loop
			} else {
				// No Pricing Information is avaliable setting esw,calc prices of EE to 0.0
				OPPTLogger.log("MESSAGE_013",OPPTLogger.DEBUG,CLASS_NAME,"applyPricingLogic",null);
				eeDomainDTO.setEswPrice(0.0);
				if(!altPriceInd) {
					eeDomainDTO.setCalculatedPrice(0.0);
				}
			}// end of else
			
			// Rule 10, since we are in loop we may get an EE which may have alt price  
			BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
			if(eealtPriceInd) {
				BigDecimal eeAltPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getAlternatePrice());
				tempSWOAltPrice = tempSWOAltPrice.add(eeAltPrice);
			}else {
				tempSWOAltPrice = tempSWOAltPrice.add(eeESWPrice);
			}
			logMessage = OPPTHelper.getLogString(String.valueOf(swoDomainDTO.getExclusionId()));
			OPPTLogger.log("MESSAGE_031",OPPTLogger.DEBUG,CLASS_NAME,"applyPricingLogic",logMessage);
			
			BigDecimal calculatedPrice = PricingComponentHelper.convertToBigDecimal(0.0);
			boolean updateCalcPrice = false;
			// Rule 5 
			if((((!"V".equals(swoDomainDTO.getItemCategory())) && 
				 priceProposalDomainDTO.getAnnivAmount() ==0.0 && 
				 (!altPriceInd) && 
				 PriceConstants.YES.equals(swoDomainDTO.getExclusionId())
				) ||
				((!"V".equals(swoDomainDTO.getItemCategory())) &&
				 priceProposalDomainDTO.getAnnivAmount() > 0.0 &&
				 (ProposalTypeConstants.EAS.equals(priceProposalDomainDTO.getProposalType()) || ProposalTypeConstants.PLA.equals(priceProposalDomainDTO.getProposalType()))&&
				 (PriceConstants.YES.equals(swoDomainDTO.getExclusionId())) &&
				 (!altPriceInd)
				) 
			  ) && (!isSAndSLicence) 
			  )
			{
			  	//System.out.println("EEPriceManagerBean.applyPricingLogic()12");
				calculatedPrice = eeTotalMonthlyPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq());
				updateCalcPrice = true;
				
			}
			
			// Rule 5a
			if(priceProposalDomainDTO.getAnnivAmount() == 0.0 &&
			   (!altPriceInd) &&
			   (!PriceConstants.YES.equals(swoDomainDTO.getExclusionId())) &&
			   (!"V".equals(swoDomainDTO.getItemCategory()) && (!isSAndSLicence) ) 
			  )  
			{   
				//System.out.println("EEPriceManagerBean.applyPricingLogic()13");
				if((priceProposalDomainDTO.getDiscount() > 0) &&( priceProposalDomainDTO.getAnnivAmount()==0)) {
					
				}
				else{
					
				
				calculatedPrice = (eeTotalMonthlyPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq())).multiply(priceProposalDomainDTO.getSpecialRateFactor());
				updateCalcPrice = true;
			}
			}
			
			if(isSAndSLicence && (!altPriceInd) &&(!"V".equals(swoDomainDTO.getItemCategory()))) {
				calculatedPrice = eeTotalMonthlyPrice;
				updateCalcPrice = true;
			}
			if(updateCalcPrice) {
				double roundedCalculatedPrice = PricingComponentHelper.round(calculatedPrice,priceProposalDomainDTO.getDecimalsAllowed());
				eeDomainDTO.setCalculatedPrice(roundedCalculatedPrice);
				logMessage = OPPTHelper.getLogString(String.valueOf(eeDomainDTO.getEeId()),String.valueOf(roundedCalculatedPrice));
				OPPTLogger.log("MESSAGE_016",OPPTLogger.DEBUG,CLASS_NAME,"applyPricingLogic",logMessage);
			}
			
			swoESWPrice = swoESWPrice.add(eeESWPrice);
						
		}// end of EE loop
		if((priceProposalDomainDTO.getDiscount() > 0) &&( priceProposalDomainDTO.getAnnivAmount()==0)) {
			if((priceProposalDomainDTO.getStatusCode().equals("P"))&& (priceProposalDomainDTO.getDiscount() > 0)){
				
			}
			else{
			for(int i= 0, size = eeDTOList.size(); i < size ; i++) {
			EEDomainDTO eeDomainDTO = (EEDomainDTO) eeDTOList.get(i);
			BigDecimal eeESWPrice=PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
			BigDecimal discountPercent = PricingComponentHelper.convertToBigDecimal((priceProposalDomainDTO.getDiscount()/100));
			BigDecimal PriceDiscounted = eeESWPrice.multiply(discountPercent);
			BigDecimal swoAltPrice = eeESWPrice.subtract(PriceDiscounted);			
			//Billing Frequency(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) value is dependent on Contract period duration(contractPeriodDuration)
			System.out.println("EEPriceManagerBean.applyPricingLogic():ContractPeriodDuration:"+contractPeriodDuration);
			System.out.println("EEPriceManagerBean.applyPricingLogic():Billing Freeq:"+priceProposalDomainDTO.getAmortizationFactorForBillingFreq());
			BigDecimal eeTotalMonthlyPrice1 = PricingComponentHelper.convertToBigDecimal(0.0);
			if((contractPeriodDuration==1)&& 
					  ((new BigDecimal(1.00).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)
					||(new BigDecimal(3.0).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)
					||(new BigDecimal(6.00).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0) 
					||(new BigDecimal(12.00).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)))
			{
				System.out.println("EEPriceManagerBean.applyPricingLogic1:()");
				eeTotalMonthlyPrice1=(swoAltPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq())).multiply(BigDecimal.valueOf(1.00));
				eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(eeTotalMonthlyPrice1,2));
			}
			if(contractPeriodDuration==3)
			{
				if ((new BigDecimal(1.0).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)||(new BigDecimal(2.0).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)
						||(new BigDecimal(4.00).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0))
				{       
					    System.out.println("EEPriceManagerBean.applyPricingLogic2:()");
				        eeTotalMonthlyPrice1=(swoAltPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq())).multiply(BigDecimal.valueOf(3.00));
				        eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(eeTotalMonthlyPrice1,2));
				}
					else
				{       
						System.out.println("EEPriceManagerBean.applyPricingLogic-2 else:()");
						eeTotalMonthlyPrice1=(swoAltPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()));
						eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(swoAltPrice,2));
			    }	
			}
			if(contractPeriodDuration==6)
			{
				if ((new BigDecimal(0.5).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)||(new BigDecimal(1.0).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)
						||(new BigDecimal(2.00).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0))
				{
					    System.out.println("EEPriceManagerBean.applyPricingLogic3:()");
				        eeTotalMonthlyPrice1=(swoAltPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq())).multiply(BigDecimal.valueOf(6.00));
				        eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(eeTotalMonthlyPrice1,2));
				}
					else
				{
						System.out.println("EEPriceManagerBean.applyPricingLogic-3 else:()");
						eeTotalMonthlyPrice1=(swoAltPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()));
						eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(swoAltPrice,2));
			    }	
			}
			if((contractPeriodDuration==12)) 
			{
				if ((new BigDecimal(0.25).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)||(new BigDecimal(0.5).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0)
						||(new BigDecimal(1.00).compareTo(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()) == 0))
				{
				System.out.println("EEPriceManagerBean.applyPricingLogic4:()");
				eeTotalMonthlyPrice1=(swoAltPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq())).multiply(BigDecimal.valueOf(12.00));
				eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(eeTotalMonthlyPrice1,2));
				}
				else{
				System.out.println("EEPriceManagerBean.applyPricingLogic-4 else:()");
				eeTotalMonthlyPrice1=(swoAltPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq()));
				eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(swoAltPrice,2));
				}	
			}			
			eeDomainDTO.setAlternatePrice(PricingComponentHelper.round(swoAltPrice,2));
			}
			BigDecimal discountPercent = PricingComponentHelper.convertToBigDecimal((priceProposalDomainDTO.getDiscount()/100));
			//System.out.println("EEPriceManagerBean.applyPricingLogic():swoESWPrice:"+swoESWPrice);
			BigDecimal PriceDiscounted1 = swoESWPrice.multiply(discountPercent);
			BigDecimal swoAltPrice1 = swoESWPrice.subtract(PriceDiscounted1);
			BigDecimal eeTotalMonthlyPrice1 = PricingComponentHelper.convertToBigDecimal(0.0);
			swoDomainDTO.setAlternatePrice(PricingComponentHelper.round(swoAltPrice1,2));
			//swoDomainDTO.setCalcPrice(PricingComponentHelper.round(eeTotalMonthlyPrice1,2));
			}
		}
		swoDomainDTO.setEswPrice(swoESWPrice.doubleValue());
		//System.out.println("EEPriceManagerBean.applyPricingLogic()123:swoESWPrice:"+swoESWPrice);
		// Rule 10
		if((!swoAltPriceInd) && altPriceInd) {
			// swo alt price is null and we have atleast one ee with alt price
			swoDomainDTO.setAlternatePrice(tempSWOAltPrice.doubleValue());
			System.out.println("EEPriceManagerBean.applyPricingLogic():tempSWOAltPrice:"+tempSWOAltPrice);
		}
		//Added by Manoj to test alternate price
		
		//swoDomainDTO.setAlternatePrice(swoESWPrice.doubleValue());
		
		
			log.end();
	}
	
	/**
	 *  
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
	 * @param eeDomainDTO
	 * @param priceProposalDomainDTO
	 * @param swoAltPriceInd
	 * @param excludedLicenceInd
	 */
	private void applyPricingLogicForEEWithAltPrice(EEDomainDTO eeDomainDTO,SWODomainDTO swoDomainDTO,
								                    PriceProposalDomainDTO priceProposalDomainDTO, 
								                    boolean swoAltPriceInd,String excludedLicenceInd ) {
		System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice()");
		
		TimeTaken log = new TimeTaken(CLASS_NAME,"applyPricingLogicForEEWithAltPrice");	
		String logMessage = "";
		// Rule 7b
		// logic for EE with alternate price
		OPPTCalender calender = new OPPTCalender();
		Date planStartDateOfLicence = swoDomainDTO.getPlanStartDate();
		Date planEndDateOfLicence = swoDomainDTO.getPlanEndDate();
		Date contractPeriodStartDate = priceProposalDomainDTO.getContrStartPeriod();
		Date contractPeriodEndDate = priceProposalDomainDTO.getContrEndPeriod();
		boolean isSAndSLicence = UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd()) ? true:false;
		/* Temp setup for testing pricing after migration all swo's will have plan start date and end date
		 * currently in dev most of the plan dates are null  
		*/
		if(planStartDateOfLicence == null || planEndDateOfLicence == null) {
			planStartDateOfLicence = contractPeriodStartDate;
			planEndDateOfLicence = contractPeriodEndDate;
		}
		int swoDuration = OPPTCalender.calculateContractPeriodDuration(planStartDateOfLicence,planEndDateOfLicence);
		boolean negativeSwoDurationForSandS = false;
		if(swoDuration < 0 && isSAndSLicence) {
			OPPTLogger.debug("Negative swo duration",CLASS_NAME,"applyPricingLogicForEEWithAltPrice");
			negativeSwoDurationForSandS = true;
		}
		
		if(negativeSwoDurationForSandS) {
			return;
		}
		
		logMessage = OPPTHelper.getLogString(String.valueOf(swoDuration));
		OPPTLogger.log("SWO_DURATION",OPPTLogger.DEBUG,CLASS_NAME,"applyPricingLogic",logMessage);
				
		BigDecimal [] tvmFactors;
			
		/* CR6153 start change */
		if((priceProposalDomainDTO.getExtendPeriod() != null) && (priceProposalDomainDTO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
			if(swoDuration > 0){
				tvmFactors = calculateTVMFactors(priceProposalDomainDTO.getTvmRate(), swoDuration);
			}
			else{
				tvmFactors = priceProposalDomainDTO.getTvmFactors();
			}
		}
		else{
		/* CR6153 end change */
			tvmFactors = priceProposalDomainDTO.getTvmFactors();
		}
		
		BigDecimal [] dayFactors = calculateDayFactors(planStartDateOfLicence,planEndDateOfLicence,swoDuration);
		BigDecimal eeAltPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getAlternatePrice());
		//System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice()"+eeDomainDTO.getAlternatePrice());
		int contractPeriodDuration = priceProposalDomainDTO.getContractPeriodDuration();
		System.out
				.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice():contractPeriodDuration:"+contractPeriodDuration);
		BigDecimal swoESWPrice = PricingComponentHelper.convertToBigDecimal(0.0);
		boolean [] pricingPeriods = priceProposalDomainDTO.getPricingFlags();
		
		BigDecimal tempSWOAltPrice = PricingComponentHelper.convertToBigDecimal(0.0);
		// this will be true if either swo or ee has alt price
		boolean altPriceInd = true;
		BigDecimal eeTotalMonthlyPrice= PricingComponentHelper.convertToBigDecimal(0.0);
		// S and S Change
		if(UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd()) && eeAltPrice.doubleValue() > 0) {
			BigDecimal twelve = PricingComponentHelper.convertToBigDecimal(12.0);
			if(eeDomainDTO.getSAndSDiscountPercent() > 0) {
				BigDecimal sAndSDiscountPercent = PricingComponentHelper.convertToBigDecimal((eeDomainDTO.getSAndSDiscountPercent()/100));
				BigDecimal eeAltPriceDiscounted = eeAltPrice.multiply(sAndSDiscountPercent);
				eeAltPrice = eeAltPrice.subtract(eeAltPriceDiscounted);
			}			
			eeAltPrice = eeAltPrice.divide(twelve,PriceConstants.PRECISION,BigDecimal.ROUND_UP);			
		}
		
		
		// Rule 8,8A
		if((altPriceInd &&
			 priceProposalDomainDTO.getAnnivAmount() == 0
			 )||
		   (priceProposalDomainDTO.getAnnivAmount() > 0 &&
			(ProposalTypeConstants.EAS.equals(priceProposalDomainDTO.getProposalType())|| ProposalTypeConstants.PLA.equals(priceProposalDomainDTO.getProposalType())) &&
			PriceConstants.YES.equals(excludedLicenceInd)
		   ) ||
		   (isSAndSLicence && altPriceInd) 
		  ) 
		{
			if(pricingPeriods[0]||pricingPeriods[1]) {
				// amendedLicences
				int [] pricingPeriodDuration = priceProposalDomainDTO.getPricingPeriodDuration();
				for(int z=0;z<pricingPeriods.length;z++) {
					if(!pricingPeriods[z]) {
						continue;
					}
					contractPeriodDuration = pricingPeriodDuration[z];
					if(z==0) {
						tvmFactors = priceProposalDomainDTO.getFirstPricingPeriodTVM();
						dayFactors = priceProposalDomainDTO.getFirstPricingPeriodDayFactors();
								
					}else{
						tvmFactors = priceProposalDomainDTO.getSecondPricingPeriodDayFactors();
						dayFactors = priceProposalDomainDTO.getSecondPricingPeriodTVM();
					}

					for(int k =0; k< contractPeriodDuration; k++) {
						if(k==0 && 31 == calender.getDay(contractPeriodStartDate)) {
							//EE Alternate Price is available First month has 31 days	
						}else {
							eeTotalMonthlyPrice = eeTotalMonthlyPrice.add((eeAltPrice.multiply(tvmFactors[k])).multiply(dayFactors[k])) ;
						}
					} 
				}
			}
		 	else 
			{
				int duartionForPricing = 0;
				if(contractPeriodDuration == swoDuration) {
					duartionForPricing = contractPeriodDuration;	
				}else {
					duartionForPricing = swoDuration;
					//tvmFactors = 
				}
				for(int k =0; k< duartionForPricing; k++) {
					if(k==0 && 31 == calender.getDay(contractPeriodStartDate)) {

					}else {
						eeTotalMonthlyPrice = eeTotalMonthlyPrice.add((eeAltPrice.multiply(tvmFactors[k])).multiply(dayFactors[k])) ;
					} 	
				}
			}
		}
			
				
		// Rule 9 
		if(altPriceInd) {
			//swoDomainDTO.setAlternatePriceUpdateInd(eeDomainDTO.getAlternatePriceUpdateInd());
			//System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice():Test:");
			
			// THIS IS FOR EE WITH ALT PRICE
			// Rule 9
			BigDecimal calculatedPrice = PricingComponentHelper.convertToBigDecimal(0.0);
			if((( priceProposalDomainDTO.getAnnivAmount() == 0.0 && 
				 PriceConstants.YES.equals(excludedLicenceInd)
				 ) ||
				 ( priceProposalDomainDTO.getAnnivAmount() > 0.0 &&
				   (ProposalTypeConstants.EAS.equals(priceProposalDomainDTO.getProposalType()) || ProposalTypeConstants.PLA.equals(priceProposalDomainDTO.getProposalType()))&&
				   (PriceConstants.YES.equals(excludedLicenceInd)) 
				 ) 
				) && (!isSAndSLicence)  
			   ) 
			{
				calculatedPrice = eeTotalMonthlyPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq());
				//System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice()1");
			 }
			/*if((priceProposalDomainDTO.getDiscount() > 0) &&( priceProposalDomainDTO.getAnnivAmount()==0)) {
				
				calculatedPrice = eeTotalMonthlyPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq());
				eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(calculatedPrice,priceProposalDomainDTO.getDecimalsAllowed()));
				
			}*/
			
			 // Rule 9a
			 if(priceProposalDomainDTO.getAnnivAmount() == 0.0 &&
				 (!PriceConstants.YES.equals(excludedLicenceInd))&& (!isSAndSLicence))
			 {
				 calculatedPrice = (eeTotalMonthlyPrice.multiply(priceProposalDomainDTO.getAmortizationFactorForBillingFreq())).multiply(priceProposalDomainDTO.getSpecialRateFactor());
				 
				 //System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice()2");
			 }
			 
			 if(isSAndSLicence) {
				calculatedPrice = eeTotalMonthlyPrice;
			 }
			 
			eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(calculatedPrice,priceProposalDomainDTO.getDecimalsAllowed()));
			logMessage = OPPTHelper.getLogString(String.valueOf(eeDomainDTO.getEeId()),String.valueOf(eeDomainDTO.getCalculatedPrice()));
			OPPTLogger.log("MESSAGE_016",OPPTLogger.DEBUG,CLASS_NAME,"applyPricingLogic",logMessage);
			
			
			
	
		}
		/*if((priceProposalDomainDTO.getDiscount() > 0) &&( priceProposalDomainDTO.getAnnivAmount()==0)) {
			eeDomainDTO.setAlternatePrice();
			
		}*/
		/*List eeDTOList = swoDomainDTO.getEEDTOList();
		if(eeDomainDTO.getAlternatePriceUpdateInd()=="Y")  {
			System.out
					.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice():Test1:");
			for(int i= 0, size = eeDTOList.size(); i < size ; i++) 
		{
			EEDomainDTO eeDomainDTO1 = (EEDomainDTO) eeDTOList.get(i);
			BigDecimal eeAltPrice1=PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getAlternatePrice());
			//System.out.println("EEPriceManagerBean.applyPricingLogic():eeESWPrice"+eeESWPrice);
			  double sumAltEEPrice = 0.0;		
			  sumAltEEPrice += eeDomainDTO.getAlternatePrice();
			  swoDomainDTO.setAlternatePrice(PricingComponentHelper.round(sumAltEEPrice,2));
			  swoDomainDTO.setCalcPrice(PricingComponentHelper.round(sumAltEEPrice,2));
		}
		          }*/
		
		//Added by Manoj to test alternate price
		/*System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice()"+priceProposalDomainDTO.getDiscount());
		if(priceProposalDomainDTO.getDiscount() > 0) {
			BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
			System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice():eeESWPrice:"+eeESWPrice);
			BigDecimal discountPercent = PricingComponentHelper.convertToBigDecimal((priceProposalDomainDTO.getDiscount()/100));
			BigDecimal PriceDiscounted = eeESWPrice.multiply(discountPercent);
			BigDecimal swoAltPrice = eeESWPrice.subtract(PriceDiscounted);
			System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice():Manoj:"+swoAltPrice);
			eeDomainDTO.setAlternatePrice(PricingComponentHelper.round(swoAltPrice,2));
			eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(swoAltPrice,2));
					
		}*/
		log.end();
	} // End of method
		
	
	/**
	 * This method is used for calculating price of swo which has alternate price
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @param priceProposalDomainDTO
	 */
	
	private void applyPricingLogicForSWOWithAltPrice(SWODomainDTO swoDomainDTO,PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException{
		TimeTaken log = new TimeTaken(CLASS_NAME,"applyPricingLogicForSWOWithAltPrice");
		System.out.println("EEPriceManagerBean.applyPricingLogicForSWOWithAltPrice():Test1:");
		// calculate the esw price of EE, EE can have alt price.
		applyPricingLogic(swoDomainDTO, priceProposalDomainDTO, true);
		List eeList = swoDomainDTO.getEEDTOList();
		if(eeList == null) {
			return;
		}
		if(eeList.size() == 0) {
			return;
		}
		int intEECount = 0; 
		int chargeIntEECount = 0;
		for (int j=0; j < eeList.size();j++) {
			//System.out.println("EEPriceManagerBean.applyPricingLogicForSWOWithAltPrice():Test2:");
			EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(j);
			intEECount++;
			if(eeDomainDTO.getChargeOptionDesc() != null && 
				UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc().trim())) {
				continue;
			}
			chargeIntEECount++;
		}
		BigDecimal eeCount = PricingComponentHelper.convertToBigDecimal(intEECount);
		BigDecimal chargeEECount = PricingComponentHelper.convertToBigDecimal(chargeIntEECount);
		
		BigDecimal swoAltPrice = PricingComponentHelper.convertToBigDecimal(swoDomainDTO.getAlternatePrice());
		int decimalsAllowed = priceProposalDomainDTO.getDecimalsAllowed();
		if(swoDomainDTO.getEswPrice() == 0) {
			//System.out.println("EEPriceManagerBean.applyPricingLogicForSWOWithAltPrice():Test3:");
			// Rule 7
			double altEEPrice = 0;
			/**
			  * 31/05/2004
			  * MN 19387428
			  * Defect 351
			  * For Alternate Price change added by Balaji
			 */			
			if(0 == swoAltPrice.doubleValue()) {
				altEEPrice = 0; 
			}else {
				altEEPrice = PricingComponentHelper.round(swoAltPrice.divide(chargeEECount,PriceConstants.PRECISION,BigDecimal.ROUND_UP),decimalsAllowed) ;
			}
			OPPTLogger.debug("altEEPrice = "+altEEPrice,CLASS_NAME,"calculatePrice");
			for(int i=0;i<eeCount.doubleValue();i++) {
				EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(i);
				if(eeDomainDTO.getChargeOptionDesc() != null && 
				   UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc().trim())) {
						continue;
				}
				eeDomainDTO.setAlternatePrice(altEEPrice);
				// NOW EE HAS ALTERNATE PRICE SO CALCULATE CALC PRICE OF EE WITH ALT PRICE
				applyPricingLogicForEEWithAltPrice(eeDomainDTO,swoDomainDTO,priceProposalDomainDTO, true,swoDomainDTO.getExclusionId()); 
			}
		} else if(swoDomainDTO.getEswPrice() > 0) {
			// Rule 7A
			
			BigDecimal swoESWPrice = PricingComponentHelper.convertToBigDecimal(swoDomainDTO.getEswPrice());
			double sumAltEEPrice = 0.0;			 			 
			for(int i=0;i<eeCount.doubleValue();i++) {
				//System.out.println("EEPriceManagerBean.applyPricingLogicForSWOWithAltPrice():Test4:");
				EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(i);
				if(eeDomainDTO.getChargeOptionDesc() != null && 
				   UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc().trim())) {
						continue;
				}
				BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
				BigDecimal eeProportion = eeESWPrice.divide(swoESWPrice,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
				BigDecimal altEEPrice = swoAltPrice.multiply(eeProportion);
				eeDomainDTO.setAlternatePrice(PricingComponentHelper.round(altEEPrice,decimalsAllowed));
				sumAltEEPrice += eeDomainDTO.getAlternatePrice();
			}
			/*for(int i=0;i<eeCount.doubleValue();i++) {
				BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
				BigDecimal altEEPrice=
			}*/

			BigDecimal sumEEAltPriceBD  = PricingComponentHelper.convertToBigDecimal(sumAltEEPrice);
			BigDecimal diffrence = swoAltPrice.subtract(sumEEAltPriceBD);
			if(diffrence.doubleValue() != 0 ) {
				//System.out.println("EEPriceManagerBean.applyPricingLogicForSWOWithAltPrice():3");
				adjustAltpriceDifference(diffrence,swoDomainDTO,decimalsAllowed); 		
			}

			for(int i=0;i<eeCount.doubleValue();i++) {
				EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(i);

				// NOW EE HAS ALTERNATE PRICE SO CALCULATE CALC PRICE OF EE WITH ALT PRICE
				applyPricingLogicForEEWithAltPrice(eeDomainDTO,swoDomainDTO,priceProposalDomainDTO, true,swoDomainDTO.getExclusionId());		 
			}
			//Added by Manoj to test alternate price
			/*if(swoDomainDTO.getAlternatePrice() > 0) {
				System.out.println("EEPriceManagerBean.applyPricingLogic():Inside:");
				BigDecimal discountPercent = PricingComponentHelper.convertToBigDecimal((priceProposalDomainDTO.getDiscount()/100));
				BigDecimal PriceDiscounted = swoESWPrice.multiply(discountPercent);
				BigDecimal swoAltPrice = swoESWPrice.subtract(PriceDiscounted);
				swoDomainDTO.setAlternatePrice(swoDomainDTO.getAlternatePrice());
				System.out.println("EEPriceManagerBean.applyPricingLogicForEEWithAltPrice():3+:");
				swoDomainDTO.setCalcPrice(swoDomainDTO.getAlternatePrice());
				for(int i=0;i<eeCount.doubleValue();i++) {
					EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(i);
				eeDomainDTO.setCalculatedPrice(swoDomainDTO.getAlternatePrice());
				}*/
						
				}
		log.end();			
	}
	
	/**
 	* This method is used as an entry point for pricing, except Variance Proposal
 	* <br><b>Known Bugs</b><br> 
 	* 
 	* <br><PRE> 
 	* date Feb 5, 2004 
 	* 
 	* revision date author reason 
 	* 
 	* </PRE><br> 
 	* 
 	* @param PriceProposalDomainDTO
 	* @return PriceProposalDomainDTO
 	* @throws ServiceException
 	*/	
	public PriceProposalDomainDTO calculatePrice(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {
		System.out.println("EEPriceManagerBean.calculatePrice()");
		TimeTaken log = new TimeTaken(CLASS_NAME,"calculatePrice");
		String logMessage = "";
		List swoList = priceProposalDomainDTO.getSWODomainDTOList();
		boolean contractAmendedIndicator = false;
		if(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT.equals(priceProposalDomainDTO.getStatusCode())) {
			contractAmendedIndicator = true;
			OPPTLogger.log("MESSAGE_017",OPPTLogger.DEBUG,CLASS_NAME,"calculatePrice",null);
		}
		// This is the Day Factor calculation
		priceProposalDomainDTO.setDayFactors(calculateDayFactors(priceProposalDomainDTO.getContrStartPeriod(), priceProposalDomainDTO.getContrEndPeriod(),priceProposalDomainDTO.getContractPeriodDuration()));
		
		for(int i = 0; i < swoList.size(); i++ ) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
			boolean swoAmendedInd = false;
			if(PriceConstants.YES.equals(swoDomainDTO.getAmendInd())) {
				swoAmendedInd = true; 
				OPPTLogger.log("MESSAGE_018",OPPTLogger.DEBUG,CLASS_NAME,"calculatePrice",null);
			}
			// Amendement Rule 1
			if(contractAmendedIndicator && swoAmendedInd) {
				// Logic for calculation the pricing periods of Amended Contracts
				// Pricing should be done for 2 periods
				// Here day factor will also play a part
				calculatePricingPeriods(priceProposalDomainDTO,swoDomainDTO);				
					
			}
			if(UtilityConstants.YES.equals(swoDomainDTO.getAlternatePriceUpdateInd()) ) {
				// SWO has Alternate Price
				applyPricingLogicForSWOWithAltPrice(swoDomainDTO, priceProposalDomainDTO);				
			} else {
				// Normal SWO may have ee with alt price 
				
				applyPricingLogic(swoDomainDTO, priceProposalDomainDTO,false);
			}
			// This will reset the pricing periods so that next swodto will have no issiues
			priceProposalDomainDTO.resetPricingPeriods();
			
		}// end of the SWO Loop
		// Rule 11
		BigDecimal sumSWOEswPrice = PricingComponentHelper.sumSWOEswPrice(swoList,PriceConstants.ALL); 
		BigDecimal sumSWOAltPrice = PricingComponentHelper.sumSWOAltPrice(swoList,PriceConstants.ALL);
		BigDecimal sumSWOEswPriceForSWOWithAltPrice = PricingComponentHelper.sumSWOEswPriceForSWOWithAltPrice(swoList,PriceConstants.ALL);
		BigDecimal preTVMInvoiceAmt = ((sumSWOEswPrice.add(sumSWOAltPrice)).subtract(sumSWOEswPriceForSWOWithAltPrice)).multiply(priceProposalDomainDTO.getSpecialRateFactor());
		logMessage = OPPTHelper.getLogString(String.valueOf(preTVMInvoiceAmt));
		OPPTLogger.log("MESSAGE_019",OPPTLogger.DEBUG,CLASS_NAME,"calculatePrice",logMessage);
		priceProposalDomainDTO.setPreTVMInvoiceAmt(PricingComponentHelper.round(preTVMInvoiceAmt,priceProposalDomainDTO.getDecimalsAllowed()));
		log.end();
		return priceProposalDomainDTO;
	}
	
	/**
	 * This method will be called when we do not have any excluded licences and we have anniversary amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param PriceProposalDomainDTO
	 * @return PriceProposalDomainDTO
	 * @throws ServiceException
	 */
	public PriceProposalDomainDTO priceAnnivAmtProposal(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {
		System.out.println("EEPriceManagerBean.priceAnnivAmtProposal()");
		TimeTaken log = new TimeTaken(CLASS_NAME,"priceAnnivAmtProposal");
		// <!-- BlueHarmony DAD007 Changed by Anand Sugumaran -->
		BigDecimal aniversaryAmountForBillingPeriod = PricingComponentHelper.convertToBigDecimal(priceProposalDomainDTO.getAnnivAmount()* priceProposalDomainDTO.getNumberOfMonthsForFrequency()/priceProposalDomainDTO.getContractPeriodDuration());
		//<!-- BlueHarmony DAD007 Changes End by Anand Sugumaran -->
		List swoList = 	priceProposalDomainDTO.getSWODomainDTOList();
		String licenceType = PriceConstants.MLC;
		
		BigDecimal sumOfSWOEswPrice = PricingComponentHelper.sumSWOEswPrice(swoList,licenceType);
		BigDecimal sumOfSWOAltPrice = PricingComponentHelper.sumSWOAltPrice(swoList, licenceType);
		BigDecimal sumOfSWOEswPriceForSWOWithAltPrice = PricingComponentHelper.sumSWOEswPriceForSWOWithAltPrice(swoList, licenceType);
		int decimalsAllowed = priceProposalDomainDTO.getDecimalsAllowed();
		BigDecimal eeCount=  PricingComponentHelper.convertToBigDecimal(PricingComponentHelper.getEECount(swoList, licenceType));
		if(eeCount.doubleValue() == 0) {
			return priceProposalDomainDTO;
		}
		// Rule 13
		BigDecimal monthlyPriceOfProposal = (sumOfSWOEswPrice.add(sumOfSWOAltPrice)).subtract(sumOfSWOEswPriceForSWOWithAltPrice);
		OPPTLogger.debug("monthlyPriceOfProposal = "+monthlyPriceOfProposal,CLASS_NAME,"applyPricingLogic");
		
		// Rule 13 A
		if(sumOfSWOEswPrice.doubleValue() == 0 && eeCount.doubleValue() > 0) {
			BigDecimal eeCalcPrice = aniversaryAmountForBillingPeriod.divide(eeCount,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
			 for(int i = 0, swosize = swoList.size();i<swosize;i++) {
				 SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i); 
				 if(UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd())) {
				 	continue; 
				 }
				 if((!PriceConstants.SVC.equals(swoDomainDTO.getItemCategory()))) 
				 {
					 List eeList = swoDomainDTO.getEEDTOList();
					 for(int j = 0, eeSize = eeList.size(); j < eeSize;j ++)		{	
						 EEDomainDTO eeDomainDTO =(EEDomainDTO) eeList.get(j);
						 if(eeDomainDTO.getChargeOptionDesc() != null && 
						    UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc())) {
							eeDomainDTO.setCalculatedPrice(0);
							continue;
						 }
						 
						 eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(eeCalcPrice,decimalsAllowed));
					 }// end of for  	
			     }// end of if
					
			 }// end of swo loop
			 //	end of 13 A
		 } else if(sumOfSWOEswPrice.doubleValue() > 0 && eeCount.doubleValue() > 0) {
			 //	13 B,C
			 for(int i = 0, swosize = swoList.size();i<swosize;i++) {
				 SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
				 boolean altPriceExists = false;
				 if(UtilityConstants.YES.equals(swoDomainDTO.getAlternatePriceUpdateInd())) {
					altPriceExists = true;
				 }
				 if(UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd())) {
				 	continue; 
				 } 
				 if((!PriceConstants.SVC.equals(swoDomainDTO.getItemCategory()))) {
					 List eeList = swoDomainDTO.getEEDTOList();
					 for(int j = 0, eeSize = eeList.size(); j < eeSize;j ++)		{
						 EEDomainDTO eeDomainDTO =(EEDomainDTO) eeList.get(j);
						if(UtilityConstants.YES.equals(eeDomainDTO.getAlternatePriceUpdateInd())) {
						   altPriceExists = true;
						}
						if(eeDomainDTO.getChargeOptionDesc() != null && 
						   UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc())) {
							eeDomainDTO.setCalculatedPrice(0);
							continue;
						}
						 BigDecimal eePropotionateValue = PricingComponentHelper.convertToBigDecimal(0.0);
						 BigDecimal eeAltPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getAlternatePrice());
						 BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
						/**
						  * 31/05/2004
						  * MN 19387428
						  * Defect 351
						  * For Alternate Price change added by Balaji
						 */
						
						if(altPriceExists) {
						 	if(0 == eeAltPrice.doubleValue()) {
								eePropotionateValue = PricingComponentHelper.convertToBigDecimal(0);
							}else {
								eePropotionateValue = eeAltPrice.divide(monthlyPriceOfProposal,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
						 	}
														
						 }else {
							 eePropotionateValue = eeESWPrice.divide(monthlyPriceOfProposal,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
						 }
						 
						 BigDecimal eeCalcPrice = aniversaryAmountForBillingPeriod.multiply(eePropotionateValue);
						 eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(eeCalcPrice,decimalsAllowed));
					 }// end of for  	
				 }// end of if
			 }// end of swo loop
		}// end of 13 B,C	
		// 13 D
		BigDecimal sumEECalcPrice  = PricingComponentHelper.sumEECalcPrice(swoList, licenceType);
		BigDecimal diffrence = aniversaryAmountForBillingPeriod.subtract(sumEECalcPrice);
		// 13 E,E1,F
		if(diffrence.doubleValue() != 0 ) {
			adjustDiffrence(sumEECalcPrice,aniversaryAmountForBillingPeriod,swoList, decimalsAllowed,licenceType); 		
		}
				
		log.end();
		return priceProposalDomainDTO;
	}


	/**
	 * This method is used for Pricing where we have Anniversary amount and we also have Excluded Licenses
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceProposalDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public PriceProposalDomainDTO priceAnnivEASExcludedProposal(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {
		System.out.println("EEPriceManagerBean.priceAnnivEASExcludedProposal()");
		String logMessage = "";
		TimeTaken log = new TimeTaken(CLASS_NAME,"priceAnnivEASExcludedProposal");
		// Rule 12 series
		BigDecimal anniversaryAmount = PricingComponentHelper.convertToBigDecimal(priceProposalDomainDTO.getAnnivAmount());
		List swoList = priceProposalDomainDTO.getSWODomainDTOList();
		BigDecimal totalCalcPriceOfExcludedLicence = PricingComponentHelper.sumEECalcPrice(swoList, PriceConstants.EXCLUDED);
		OPPTLogger.debug("totalCalcPriceOfExcludedLicence = "+totalCalcPriceOfExcludedLicence,CLASS_NAME,"priceAnnivEASExcludedProposal");
		BigDecimal numberOfBills = PricingComponentHelper.convertToBigDecimal(priceProposalDomainDTO.getNumberOfBills());
		BigDecimal anniversaryAmtForSpecialPricing = (anniversaryAmount.subtract(totalCalcPriceOfExcludedLicence.multiply(numberOfBills))).divide(numberOfBills,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
		logMessage = OPPTHelper.getLogString(String.valueOf(anniversaryAmtForSpecialPricing));
		OPPTLogger.log("MESSAGE_015",OPPTLogger.DEBUG,CLASS_NAME,"priceAnnivEASExcludedProposal",logMessage);	
		if(anniversaryAmtForSpecialPricing.doubleValue() > 0) {
			BigDecimal anniversaryAmtForSpecialPricingWhole = anniversaryAmtForSpecialPricing.setScale(0,BigDecimal.ROUND_UP);
			BigDecimal anniversaryAmtForSpecialPricingFraction = anniversaryAmtForSpecialPricing.subtract(anniversaryAmtForSpecialPricingWhole);
			BigDecimal sumOfSWOEswPrice = PricingComponentHelper.sumSWOEswPrice(swoList, PriceConstants.NOT_EXCLUDED);
			BigDecimal sumOfSWOAltPrice = PricingComponentHelper.sumSWOAltPrice(swoList, PriceConstants.NOT_EXCLUDED);
			BigDecimal sumOfSWOEswPriceForSWOWithAltPrice = PricingComponentHelper.sumSWOEswPriceForSWOWithAltPrice(swoList, PriceConstants.NOT_EXCLUDED);
			BigDecimal eeCountForNotExcludedLic = PricingComponentHelper.convertToBigDecimal(PricingComponentHelper.getEECount(swoList, PriceConstants.NOT_EXCLUDED));
			int decimalsAllowed = priceProposalDomainDTO.getDecimalsAllowed();
			// Rule 12 A
			BigDecimal monthlyPriceOfProposal = (sumOfSWOEswPrice.add(sumOfSWOAltPrice)).subtract(sumOfSWOEswPriceForSWOWithAltPrice);
			// Rule 12 B
			if(sumOfSWOEswPrice.doubleValue() == 0 && eeCountForNotExcludedLic.doubleValue() > 0) {
				BigDecimal eeCalcPrice = anniversaryAmtForSpecialPricingWhole.divide(eeCountForNotExcludedLic,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
				for(int i = 0, swosize = swoList.size();i<swosize;i++) {
					SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i); 
					if((!PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())) &&
					   (!PriceConstants.YES.equals(swoDomainDTO.getExclusionId())) 
					  ) {
						List eeList = swoDomainDTO.getEEDTOList();
						for(int j = 0, eeSize = eeList.size(); j < eeSize;j ++)		{		
							EEDomainDTO eeDomainDTO =(EEDomainDTO) eeList.get(j);
							if(eeDomainDTO.getChargeOptionDesc() != null && 
							   UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc())) {
								eeDomainDTO.setCalculatedPrice(0);
								continue;
							}
							eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(eeCalcPrice,decimalsAllowed));
						}// end of for  	
					  	
					  }// end of if
					
				}// end of swo loop
				//	end of 12 B
			} else if(sumOfSWOEswPrice.doubleValue() > 0 && eeCountForNotExcludedLic.doubleValue() > 0) {
				//	12 C,D
				for(int i = 0, swosize = swoList.size();i<swosize;i++) {
					SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i); 
					boolean altPriceExists = false;
					if(UtilityConstants.YES.equals(swoDomainDTO.getAlternatePriceUpdateInd())) {
					   altPriceExists = true;
					}

					if((!PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())) &&
					   (!PriceConstants.YES.equals(swoDomainDTO.getExclusionId())) 
					  ) {
						List eeList = swoDomainDTO.getEEDTOList();
						for(int j = 0, eeSize = eeList.size(); j < eeSize;j ++)		{
							EEDomainDTO eeDomainDTO =(EEDomainDTO) eeList.get(j);
							if(UtilityConstants.YES.equals(eeDomainDTO.getAlternatePriceUpdateInd())) {
							   altPriceExists = true;
							}
							if(eeDomainDTO.getChargeOptionDesc() != null && 
							   UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc())) {
								eeDomainDTO.setCalculatedPrice(0);
								continue;
							}
							BigDecimal eePropotionateValue = PricingComponentHelper.convertToBigDecimal(0.0);
							BigDecimal eeAltPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getAlternatePrice());
							BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
							if(altPriceExists) {
								/**
								  * 31/05/2004
								  * MN 19387428
								  * Defect 351
								  * For Alternate Price change added by Balaji
								 */
								if(0 == eeAltPrice.doubleValue()) {
									eePropotionateValue = PricingComponentHelper.convertToBigDecimal(0.0);
								}else {
									eePropotionateValue = eeAltPrice.divide(monthlyPriceOfProposal,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
								}
							}else {
								eePropotionateValue = eeESWPrice.divide(monthlyPriceOfProposal,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
							}
							BigDecimal eeCalcPrice = eePropotionateValue.multiply(anniversaryAmtForSpecialPricingWhole);							
							eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(eeCalcPrice,decimalsAllowed));
						}// end of for  	
					}// end of if
				}// end of swo loop
			}// end of 12 C,D
			
			// 12 e
			BigDecimal sumEECalcPrice = PricingComponentHelper.sumEECalcPrice(swoList, PriceConstants.NOT_EXCLUDED);
			BigDecimal diffrence = anniversaryAmtForSpecialPricingWhole.subtract(sumEECalcPrice);
			// 12 f,f1,12g
			if(diffrence.doubleValue() != 0 || anniversaryAmtForSpecialPricingFraction.doubleValue() > 0 ) {
				adjustDiffrence(sumEECalcPrice,anniversaryAmtForSpecialPricing,swoList, decimalsAllowed,PriceConstants.NOT_EXCLUDED); 		
			}
				
		}else {
			OPPTLogger.debug("Anniversary Amount for special pricing is Negative",CLASS_NAME,"priceAnnivEASExcludedProposal");
			ErrorReport report = priceProposalDomainDTO.getMessageReport();
			if(report == null) {
				report = new ErrorReport();
			}
			ExceptionGenerator.addErrorEntry(report,ErrorCodeConstants.SE0010,OPPTMessageCatalog.TYPE_SERVICE);
			priceProposalDomainDTO.setMessageReport(report);
			priceProposalDomainDTO.setAnnvAmtLessThanCalcPriceofExcludedLicence(true);
		}
		
		log.end();	
		return priceProposalDomainDTO;
	}
	/**
	 * This method is used for pricing Variance proposal
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceProposalDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public PriceProposalDomainDTO priceVariance(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {
		System.out.println("EEPriceManagerBean.priceVariance()");
		TimeTaken log = new TimeTaken(CLASS_NAME, "priceVariance");
		String logMessage = "";
		List swoList = priceProposalDomainDTO.getSWODomainDTOList();
		BigDecimal capVarianceAmount = PricingComponentHelper.convertToBigDecimal(priceProposalDomainDTO.getCapVariance());
		BigDecimal invoiceAmount = PricingComponentHelper.convertToBigDecimal(0.0);
		int decimalsAllowed = priceProposalDomainDTO.getDecimalsAllowed();
		BigDecimal capVarianceAmountWhole = capVarianceAmount.setScale(0,BigDecimal.ROUND_DOWN);
		BigDecimal totalEEEswPrice = PricingComponentHelper.sumEEEswPrice(swoList,PriceConstants.ALL);
		for(int i = 0; i < swoList.size(); i++) {
			SWODomainDTO sWODomainDTO = (SWODomainDTO) swoList.get(i);
			List eeList = sWODomainDTO.getEEDTOList();
			BigDecimal swoCalculatedPrice = PricingComponentHelper.convertToBigDecimal(0.0);
			for (int j = 0; j < eeList.size(); j++) {
				EEDomainDTO eEDomainDTO = (EEDomainDTO) eeList.get(j);
				BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(eEDomainDTO.getEswPrice());
				BigDecimal eeProportion = eeESWPrice.divide(totalEEEswPrice,PriceConstants.PRECISION,BigDecimal.ROUND_UP);
				BigDecimal eeCalculatedPrice = capVarianceAmountWhole.multiply(eeProportion);
				double roundedEECalcPrice = PricingComponentHelper.round(eeCalculatedPrice,decimalsAllowed);
				logMessage = OPPTHelper.getLogString(String.valueOf(roundedEECalcPrice));
				OPPTLogger.log("EE_CALC_PRICE",OPPTLogger.DEBUG,CLASS_NAME,"priceVariance",logMessage);
				eEDomainDTO.setCalculatedPrice(roundedEECalcPrice);
				//System.out.println("EEPriceManagerBean.priceVariance():3:");
				swoCalculatedPrice = swoCalculatedPrice.add(PricingComponentHelper.convertToBigDecimal(roundedEECalcPrice));
			}
			double roundedSWOCalcPrice = PricingComponentHelper.round(swoCalculatedPrice,decimalsAllowed);
			logMessage = OPPTHelper.getLogString(String.valueOf(roundedSWOCalcPrice));
			OPPTLogger.log("SWO_CALC_PRICE",OPPTLogger.DEBUG,CLASS_NAME,"priceVariance",logMessage);
			sWODomainDTO.setCalcPrice(roundedSWOCalcPrice);
			invoiceAmount = invoiceAmount.add(PricingComponentHelper.convertToBigDecimal(roundedSWOCalcPrice));
		}
		// This method will take care if the variance is whole or not 
		invoiceAmount = PricingComponentHelper.convertToBigDecimal(PricingComponentHelper.round(invoiceAmount, decimalsAllowed)); 
		adjustDiffrence(invoiceAmount, capVarianceAmount, swoList,decimalsAllowed,PriceConstants.ALL);
		
		invoiceAmount = PricingComponentHelper.sumSWOCalcPrice(swoList, PriceConstants.ALL);
		priceProposalDomainDTO.setInvoiceAmt(PricingComponentHelper.round(invoiceAmount,decimalsAllowed));
		// Update the status
		priceProposalDomainDTO.setStatusCode(ProposalContractStatusConstants.PRICED);
		java.util.Date today = new java.util.Date();
		priceProposalDomainDTO.setDatePriced(new Date(today.getTime()));
		log.end();
		return priceProposalDomainDTO;
	}
		
		
	/**
	 * This method is a utility method which finds the EE which has minimum calc price and updates it with the diffrence
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoList
	 * @param diffrenceAmount
	 * @param decimalsAllowed
	 * @param licenceType
	 */

	private void updateEEWithMinCalcPrice(List swoList, 
										  BigDecimal diffrenceAmount, 
										  int decimalsAllowed, 
										  String licenceType) {
		System.out.println("EEPriceManagerBean.updateEEWithMinCalcPrice()");
		int swoPosition = 0;
		int eePosition =0;
		double minCalcPrice = 0.0;
		String logMessage = "";
		boolean minCalcPriceInd = false;

		for(int i = 0; i < swoList.size(); i++) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
			if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
				continue;
			}
			
			if(PricingComponentHelper.isLicenceEligible(swoDomainDTO,licenceType)) {
				List eeList = swoDomainDTO.getEEDTOList();
				for (int j = 0; j < eeList.size(); j++) {
					EEDomainDTO eEDomainDTO = (EEDomainDTO) eeList.get(j);
					if(eEDomainDTO.getCalculatedPrice() > 0) {
						if(!minCalcPriceInd) {
							minCalcPriceInd = true;
							minCalcPrice = eEDomainDTO.getCalculatedPrice();
							swoPosition = i;
							eePosition = j;
							continue;
						}
						if(eEDomainDTO.getCalculatedPrice() < minCalcPrice) {
							minCalcPrice = eEDomainDTO.getCalculatedPrice();
							swoPosition = i;
							eePosition = j;
						}
					}
				}
			}// end of perform
			
		}
		if(swoList != null && swoList.size() >0 ) {
			SWODomainDTO swoWithMinCalcPrice = (SWODomainDTO) swoList.get(swoPosition);
			List eeList1 = swoWithMinCalcPrice.getEEDTOList();
			EEDomainDTO eeWithMinCalcPrice = (EEDomainDTO) eeList1.get(eePosition);
			BigDecimal minEECalcPrice = PricingComponentHelper.convertToBigDecimal(eeWithMinCalcPrice.getCalculatedPrice());
			minEECalcPrice = minEECalcPrice.add(diffrenceAmount);
			BigDecimal minEESWOPrice = PricingComponentHelper.convertToBigDecimal(swoWithMinCalcPrice.getCalcPrice());
			minEESWOPrice = minEESWOPrice.add(diffrenceAmount);
			double eeCalculatedPrice = PricingComponentHelper.round(minEECalcPrice, decimalsAllowed);
			logMessage = OPPTHelper.getLogString(String.valueOf(eeWithMinCalcPrice.getEeId()));
			OPPTLogger.log("MESSAGE_020",OPPTLogger.DEBUG,CLASS_NAME,"updateEEWithMinCalcPrice",logMessage);
			eeWithMinCalcPrice.setCalculatedPrice(eeCalculatedPrice);
			//System.out.println("EEPriceManagerBean.updateEEWithMinCalcPrice():4:");
			double swoCalculatedPrice = PricingComponentHelper.round(minEESWOPrice, decimalsAllowed);
			logMessage = OPPTHelper.getLogString(String.valueOf(swoWithMinCalcPrice.getSwoId()));
			OPPTLogger.log("MESSAGE_021",OPPTLogger.DEBUG,CLASS_NAME,"updateEEWithMinCalcPrice",logMessage);
			swoWithMinCalcPrice.setCalcPrice(swoCalculatedPrice);
		}

	}
	
	/**
	 * This method is used to update the domain dto with proposal details like invoice amount, status
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param PriceProposalDomainDTO
	 * @return PriceProposalDomainDTO
	 * @throws ServiceException
	 */
	
	public PriceProposalDomainDTO updateProposalPricingDetails(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {
		System.out.println("EEPriceManagerBean.updateProposalPricingDetails()");
		String logMessageString ="";
		BigDecimal invoiceAmount = PricingComponentHelper.convertToBigDecimal(0.0);
		BigDecimal  sAndSDiscountAmount = PricingComponentHelper.convertToBigDecimal(0.0);
		List swoList = priceProposalDomainDTO.getSWODomainDTOList();
		int decimalsAllowed = priceProposalDomainDTO.getDecimalsAllowed();
		BigDecimal amortizationFactorForBillingFreq = priceProposalDomainDTO.getAmortizationFactorForBillingFreq();
		BigDecimal amortizationFactors [] = priceProposalDomainDTO.getAmortizationFactors();
		int sAndSCount = 0;
		/* CR6153 start changes */
		BigDecimal[]  sAndSExtendedDiscountAmount = new BigDecimal[5];
		sAndSExtendedDiscountAmount[0] = PricingComponentHelper.convertToBigDecimal(0.0);
		sAndSExtendedDiscountAmount[1] = PricingComponentHelper.convertToBigDecimal(0.0);
		sAndSExtendedDiscountAmount[2] = PricingComponentHelper.convertToBigDecimal(0.0);
		sAndSExtendedDiscountAmount[3] = PricingComponentHelper.convertToBigDecimal(0.0);
		sAndSExtendedDiscountAmount[4] = PricingComponentHelper.convertToBigDecimal(0.0);
		
		int contractDurationMonths =  OPPTCalender.calculateContractPeriodDuration(priceProposalDomainDTO.getContrStartDate(),priceProposalDomainDTO.getContrEndDate());
		int contractDurationYears = contractDurationMonths/12;
		
		if(contractDurationMonths % 12 > 0){
			++contractDurationYears;
		}
		if((priceProposalDomainDTO.getDiscount() > 0) &&( priceProposalDomainDTO.getAnnivAmount()==0)) {
			
			/*if((priceProposalDomainDTO.getStatusCode().equals("P"))&& (priceProposalDomainDTO.getDiscount() > 0)){
				
				}
			else{	*/	
			SWODomainDTO swoDomainDTO1 = new SWODomainDTO();
			for(int i = 0, swoSize = swoList.size(); i < swoSize; i++) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
			List eeList = swoDomainDTO.getEEDTOList();
			for(int k= 0, size = eeList.size(); k < size ; k++) {
			EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(k);
			BigDecimal eeESWPrice=PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
			//System.out.println("EEPriceManagerBean.applyPricingLogic():eeESWPrice"+eeESWPrice);
			BigDecimal discountPercent = PricingComponentHelper.convertToBigDecimal((priceProposalDomainDTO.getDiscount()/100));
			BigDecimal PriceDiscounted = eeESWPrice.multiply(discountPercent);
			BigDecimal swoAltPrice = eeESWPrice.subtract(PriceDiscounted);
			//eeDomainDTO.setAlternatePrice(PricingComponentHelper.round(swoAltPrice,2));
			//eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(swoAltPrice,2));
			//swoDomainDTO1.setAlternatePrice(PricingComponentHelper.round(swoAltPrice,2));
			//swoDomainDTO1.setCalcPrice(PricingComponentHelper.round(swoAltPrice,2));
			}			
			
			}
						
		//}
		}
		
		/* CR6153 end changes */
		for(int i = 0, swoSize = swoList.size(); i < swoSize; i++) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
			boolean isSAndSLicence = UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd()) ? true:false;
			BigDecimal swoCalcPrice = PricingComponentHelper.convertToBigDecimal(0.0);
			// Rule 4e
			if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
				swoDomainDTO.setCalcPrice(0.0);
				continue;
			}
			
			List eeList = swoDomainDTO.getEEDTOList();
			
			for (int j = 0, eeSize = eeList.size() ; j < eeSize; j++) {
				EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(j);
				BigDecimal eeCalcPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getCalculatedPrice());
				swoCalcPrice = swoCalcPrice.add(eeCalcPrice);
				OPPTLogger.debug(" eeCalcPrice ="+eeCalcPrice, CLASS_NAME,"updateProposalPricingDetails");
			}
			double roundedSWOCalcPrice = PricingComponentHelper.round(swoCalcPrice,decimalsAllowed);
			
			// calculated price for licence
			// Rule 14
			swoDomainDTO.setCalcPrice(roundedSWOCalcPrice);
			
			
			if(isSAndSLicence) {
				sAndSDiscountAmount = sAndSDiscountAmount.add(PricingComponentHelper.convertToBigDecimal(roundedSWOCalcPrice));
				sAndSCount++;
			}else {
				invoiceAmount = invoiceAmount.add(PricingComponentHelper.convertToBigDecimal(roundedSWOCalcPrice));
			}
		/*	if((priceProposalDomainDTO.getDiscount() > 0) &&( priceProposalDomainDTO.getAnnivAmount()==0)) {
				if((priceProposalDomainDTO.getStatusCode().equals("P"))&& (priceProposalDomainDTO.getDiscount() > 0)){
					
					}
				else{
				for(int k= 0, size = eeList.size(); k < size ; k++) {
				EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(k);
				SWODomainDTO swoDomainDTO1 = new SWODomainDTO();
				BigDecimal eeESWPrice=PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
				//System.out.println("EEPriceManagerBean.applyPricingLogic():eeESWPrice"+eeESWPrice);
				BigDecimal discountPercent = PricingComponentHelper.convertToBigDecimal((priceProposalDomainDTO.getDiscount()/100));
				BigDecimal PriceDiscounted = eeESWPrice.multiply(discountPercent);
				BigDecimal swoAltPrice = eeESWPrice.subtract(PriceDiscounted);
				eeDomainDTO.setCalculatedPrice(PricingComponentHelper.round(swoAltPrice,2));
				eeDomainDTO.setAlternatePrice(PricingComponentHelper.round(swoAltPrice,2));
				swoDomainDTO1.setAlternatePrice(PricingComponentHelper.round(swoAltPrice,2));
				swoDomainDTO1.setCalcPrice(PricingComponentHelper.round(swoAltPrice,2));
				}			
				}
				}*/	
							
			
			
			/* CR6153 start changes */
			OPPTCalender calender = new OPPTCalender();
			if((priceProposalDomainDTO.getExtendPeriod() != null) && (priceProposalDomainDTO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
				
				for(int k=0; k < contractDurationYears;k++){
					java.util.Date startPeriod = OPPTCalender.addDate(OPPTCalender.YEAR, k, priceProposalDomainDTO.getContrStartPeriod());
					java.util.Date endPeriod = OPPTCalender.addDate(OPPTCalender.YEAR, k, priceProposalDomainDTO.getContrEndPeriod());
					
					java.sql.Date priceStartPeriod = new java.sql.Date(startPeriod.getTime());
					java.sql.Date priceEndPeriod = new java.sql.Date(endPeriod.getTime());
					
					if(((swoDomainDTO.getPlanStartDate().after(priceStartPeriod) &&(swoDomainDTO.getPlanEndDate().before(priceEndPeriod)))
							|| (calender.isDateEqual(swoDomainDTO.getPlanStartDate(),priceStartPeriod)) 
							|| (calender.isDateEqual(swoDomainDTO.getPlanEndDate(),priceEndPeriod)))){
						sAndSExtendedDiscountAmount[k] = sAndSExtendedDiscountAmount[k].add(PricingComponentHelper.convertToBigDecimal(swoDomainDTO.getCalcPrice()));
						
					}
								
				}
			
				priceProposalDomainDTO.setSAndSDiscountAmount1(PricingComponentHelper.round(sAndSExtendedDiscountAmount[0],decimalsAllowed));
				OPPTLogger.debug(" discount amount1 ="+priceProposalDomainDTO.getSAndSDiscountAmount1(), CLASS_NAME,"updateProposalPricingDetails");
				priceProposalDomainDTO.setSAndSDiscountAmount2(PricingComponentHelper.round(sAndSExtendedDiscountAmount[1],decimalsAllowed));
				OPPTLogger.debug(" discount amount2 ="+priceProposalDomainDTO.getSAndSDiscountAmount2(), CLASS_NAME,"updateProposalPricingDetails");
				priceProposalDomainDTO.setSAndSDiscountAmount3(PricingComponentHelper.round(sAndSExtendedDiscountAmount[2],decimalsAllowed));
				OPPTLogger.debug(" discount amount3 ="+priceProposalDomainDTO.getSAndSDiscountAmount3(), CLASS_NAME,"updateProposalPricingDetails");
				priceProposalDomainDTO.setSAndSDiscountAmount4(PricingComponentHelper.round(sAndSExtendedDiscountAmount[3],decimalsAllowed));
				OPPTLogger.debug(" discount amount4 ="+priceProposalDomainDTO.getSAndSDiscountAmount4(), CLASS_NAME,"updateProposalPricingDetails");
				priceProposalDomainDTO.setSAndSDiscountAmount5(PricingComponentHelper.round(sAndSExtendedDiscountAmount[4],decimalsAllowed));
				OPPTLogger.debug(" discount amount5 ="+priceProposalDomainDTO.getSAndSDiscountAmount5(), CLASS_NAME,"updateProposalPricingDetails");

				
				
				
			}
			/* CR6153 end changes */
			
		}
	
		
		//<!-- BlueHarmony DAD006  changed by Anand Sugumaran  --> 
		/*	 CR6153 start change 
		if((priceProposalDomainDTO.getExtendPeriod() != null) && (priceProposalDomainDTO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
			double[]  sAndSAnniversaryAmount = new double[5];
			sAndSAnniversaryAmount[0] = priceProposalDomainDTO.getSAndsAnniversaryAmount();
			sAndSAnniversaryAmount[1] = priceProposalDomainDTO.getSAndsAnniversaryAmount2();
			sAndSAnniversaryAmount[2] = priceProposalDomainDTO.getSAndsAnniversaryAmount3();
			sAndSAnniversaryAmount[3] = priceProposalDomainDTO.getSAndsAnniversaryAmount4();
			sAndSAnniversaryAmount[4] = priceProposalDomainDTO.getSAndsAnniversaryAmount5();
					
			ErrorReport report1 = new ErrorReport();
			String year[] = new String[5];
			for(int x=0; x < contractDurationYears; x++){
				if (PricingComponentHelper.round(sAndSExtendedDiscountAmount[x].doubleValue(),2) != PricingComponentHelper.round(sAndSAnniversaryAmount[x],2)) {
					ServiceException ex = new ServiceException();
					ErrorEntry entry = new ErrorEntry(new String[] { new Integer((x+1)).toString()});
					ErrorReport report = ex.getErrorReport();
					report.addErrorEntry(new ErrorKey(ErrorCodeConstants.SE0809, OPPTMessageCatalog.TYPE_SERVICE), entry);
					report1.appendErrorReport(report);
				}
			}
			priceProposalDomainDTO.setMessageReport(report1);
		}
		else{
			 CR6153 end change 
		
			if(UtilityConstants.MLC_AND_SANDS.equals(priceProposalDomainDTO.getProposalContent()) ||
			   UtilityConstants.SANDS_ONLY.equals(priceProposalDomainDTO.getProposalContent())) {
				ErrorReport report = new ErrorReport();
				
			    if(PricingComponentHelper.round(sAndSDiscountAmount.doubleValue(),2) != PricingComponentHelper.round(priceProposalDomainDTO.getSAndsAnniversaryAmount(),2)) {
					ExceptionGenerator.addErrorEntry(report,ErrorCodeConstants.SE0005,OPPTMessageCatalog.TYPE_SERVICE);
					priceProposalDomainDTO.setMessageReport(report);
			   	}
			}
		 CR6153 start change 
		}*/
		/* CR6153 end change */
		
		//<!-- BlueHarmony DAD006  changes	End by Anand Sugumaran  --> 
		if(!priceProposalDomainDTO.isAnnvAmtLessThanCalcPriceofExcludedLicence()) {
			if(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT.equals(priceProposalDomainDTO.getStatusCode()) ||
				ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT.equals(priceProposalDomainDTO.getStatusCode())) {
				priceProposalDomainDTO.setStatusCode(ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT);
			}else {
				priceProposalDomainDTO.setStatusCode(ProposalContractStatusConstants.PRICED);
			}
		}
		
		// Rule 15
		if(UtilityConstants.MLC_ONLY.equals(priceProposalDomainDTO.getProposalContent())) {
			priceProposalDomainDTO.setInvoiceAmt( PricingComponentHelper.round(invoiceAmount,decimalsAllowed));
			logMessageString = OPPTHelper.getLogString(String.valueOf(invoiceAmount));
			OPPTLogger.log("MESSAGE_004",OPPTLogger.DEBUG,CLASS_NAME,"updateProposalPricingDetails",logMessageString);
		}else if(UtilityConstants.SANDS_ONLY.equals(priceProposalDomainDTO.getProposalContent())) {
			priceProposalDomainDTO.setSAndsDiscount( PricingComponentHelper.round(sAndSDiscountAmount,decimalsAllowed));
			logMessageString = OPPTHelper.getLogString(String.valueOf(invoiceAmount));
			OPPTLogger.log("MESSAGE_004",OPPTLogger.DEBUG,CLASS_NAME,"updateProposalPricingDetails",logMessageString);
		}else if(UtilityConstants.MLC_AND_SANDS.equals(priceProposalDomainDTO.getProposalContent())) {
			priceProposalDomainDTO.setInvoiceAmt( PricingComponentHelper.round(invoiceAmount,decimalsAllowed));
			logMessageString = OPPTHelper.getLogString(String.valueOf(invoiceAmount));
			OPPTLogger.log("MESSAGE_004",OPPTLogger.DEBUG,CLASS_NAME,"updateProposalPricingDetails",logMessageString);
			priceProposalDomainDTO.setSAndsDiscount( PricingComponentHelper.round(sAndSDiscountAmount,decimalsAllowed));
			logMessageString = OPPTHelper.getLogString(String.valueOf(invoiceAmount));
			OPPTLogger.log("MESSAGE_004",OPPTLogger.DEBUG,CLASS_NAME,"updateProposalPricingDetails",logMessageString);
		}
		if(UtilityConstants.MLC_AND_SANDS.equals(priceProposalDomainDTO.getProposalContent()) ||
		   UtilityConstants.MLC_ONLY.equals(priceProposalDomainDTO.getProposalContent())){
			// Rule 15 A
			BigDecimal invoiceAmtForAnn = invoiceAmount.multiply(amortizationFactors [0].divide(amortizationFactorForBillingFreq,PriceConstants.PRECISION,BigDecimal.ROUND_UP));
			double roundedInvoiceAmtForAnn = PricingComponentHelper.round(invoiceAmtForAnn,decimalsAllowed);
			priceProposalDomainDTO.setAnnualInvoiceAmt(roundedInvoiceAmtForAnn);
			logMessageString = OPPTHelper.getLogString(String.valueOf(roundedInvoiceAmtForAnn));
			OPPTLogger.log("MESSAGE_022",OPPTLogger.DEBUG,CLASS_NAME,"updateProposalPricingDetails",logMessageString);
			// Rule 15 B 
			BigDecimal invoiceAmtForSemiAnn = invoiceAmount.multiply(amortizationFactors [1].divide(amortizationFactorForBillingFreq,PriceConstants.PRECISION,BigDecimal.ROUND_UP));
			double roundedInvoiceAmtForSemiAnn = PricingComponentHelper.round(invoiceAmtForSemiAnn,decimalsAllowed); 
			priceProposalDomainDTO.setSemiAnnualInvoiceAmt(roundedInvoiceAmtForSemiAnn);
			logMessageString = OPPTHelper.getLogString(String.valueOf(roundedInvoiceAmtForSemiAnn));
			OPPTLogger.log("MESSAGE_023",OPPTLogger.DEBUG,CLASS_NAME,"updateProposalPricingDetails",logMessageString);
			// Rule 15 C
			BigDecimal invoiceAmtForQuarterly = invoiceAmount.multiply(amortizationFactors [2].divide(amortizationFactorForBillingFreq,PriceConstants.PRECISION,BigDecimal.ROUND_UP));
			double roundedInvoiceAmtForQuarterly = PricingComponentHelper.round(invoiceAmtForQuarterly,decimalsAllowed);
			priceProposalDomainDTO.setQurtInvoiceAmt(roundedInvoiceAmtForQuarterly);
			logMessageString = OPPTHelper.getLogString(String.valueOf(roundedInvoiceAmtForQuarterly));
			OPPTLogger.log("MESSAGE_025",OPPTLogger.DEBUG,CLASS_NAME,"updateProposalPricingDetails",logMessageString);
			// Rule 15 D
			BigDecimal invoiceAmtForMonthly = invoiceAmount.multiply(amortizationFactors [3].divide(amortizationFactorForBillingFreq,PriceConstants.PRECISION,BigDecimal.ROUND_UP));
			double roundedInvoiceAmtForMonthly = PricingComponentHelper.round(invoiceAmtForMonthly,decimalsAllowed);
			priceProposalDomainDTO.setMonthlyInvoiceAmt(roundedInvoiceAmtForMonthly);
			logMessageString = OPPTHelper.getLogString(String.valueOf(roundedInvoiceAmtForMonthly));
			OPPTLogger.log("MESSAGE_024",OPPTLogger.DEBUG,CLASS_NAME,"updateProposalPricingDetails",logMessageString);
		}
		
	
		java.util.Date today = new java.util.Date();
		priceProposalDomainDTO.setDatePriced(new Date(today.getTime()));
		return priceProposalDomainDTO;
	}
	
		
	/**
	 * Some proposals may not start on 1st of the month and also mey not end on 1st of the month.
	 * This method is used to calculate the day factor for the number of months
	 * In pricing we consider 30 as standard number of days in a month 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param java.util.Date periodStartDate
	 * @param java.util.Date periodEndDate
	 * @param int contractPeriodDuration
	 * @return double
	 */
	
	private static BigDecimal [] calculateDayFactors(Date periodStartDate, Date periodEndDate, int contractPeriodDuration) {
		System.out.println("EEPriceManagerBean.calculateDayFactors()");
		OPPTCalender cal = new OPPTCalender();
		BigDecimal [] dayFactor = new BigDecimal[contractPeriodDuration];
		OPPTLogger.debug(" periodStartDate ="+periodStartDate, CLASS_NAME,"calculateDayFactors");
		OPPTLogger.debug(" periodEndDate ="+periodEndDate, CLASS_NAME,"calculateDayFactors");
		double standardDaysForMonth = 30.0;
		String logMessage = "";
		for (int i=0;i < contractPeriodDuration; i++) {
			if(i == 0) {
				// First Month
				int dayOfTheMonth = cal.getDay(periodStartDate);
				dayFactor [i] = PricingComponentHelper.convertToBigDecimal((30 - dayOfTheMonth+1)/standardDaysForMonth);
				OPPTLogger.debug("Day Factor for month 1 ="+dayFactor [i] ,CLASS_NAME,"calculateDayFactors");
			} else if((i+1) == contractPeriodDuration) {
				// Last Month
				int lastMonthDays = cal.getDay(periodEndDate);
				if(lastMonthDays == 31 || lastMonthDays == 28 || lastMonthDays == 29 ) {
					lastMonthDays = 30;					
				}
				dayFactor [i] = PricingComponentHelper.convertToBigDecimal((lastMonthDays)/standardDaysForMonth);
				OPPTLogger.debug("Day Factor for last month ="+dayFactor [i] ,CLASS_NAME,"calculateDayFactors");
					
			}else{
				dayFactor [i] = PricingComponentHelper.convertToBigDecimal(1.0);
					
			}
			cal.roll(Calendar.MONTH,true);
			if(cal.get(Calendar.MONTH) == 0) {
				cal.roll(Calendar.YEAR,true);
			}
		}
		return dayFactor;
	}
	/**
	 * This method is used for contracts which are amended we use a specific
	 * period to price these ameded licences 
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
	 * @param priceProposalDomainDTO
	 * @param swoDomainDTO
	 */
	private void calculatePricingPeriods(PriceProposalDomainDTO priceProposalDomainDTO,SWODomainDTO swoDomainDTO){
		System.out.println("EEPriceManagerBean.calculatePricingPeriods()");
		TimeTaken log = new TimeTaken(CLASS_NAME,"calculatePricingPeriods");
		String logMessage = "";
		BigDecimal [] firstPricingPeriodDayFactors;
		BigDecimal [] firstPricingPeriodTVM;
		BigDecimal [] secondPricingPeriodDayFactors;
		BigDecimal [] secondPricingPeriodTVM;
		int [] pricingPeriodDuration = new int [2];
		Date [] pricingPeriodStartDate = new Date [2];
		Date [] pricingPeriodEndDate = new Date [2];
		Date ammendmentEffectiveDate = priceProposalDomainDTO.getAmendEffectiveDate();
		Date ammendmentEffectiveDateMinusOne = OPPTCalender.getDayMinusOneSqlDate(ammendmentEffectiveDate);
		Date contractPeriodStartDate = priceProposalDomainDTO.getContrStartPeriod();
		Date contractPeriodEndDate = priceProposalDomainDTO.getContrEndPeriod();
		Date planStartDateOfLicence = swoDomainDTO.getPlanStartDate();;
		Date planEndDateOfLicence = swoDomainDTO.getPlanEndDate();
		/* Temp setup for testing pricing after migration all swo's will have plan start date and end date
		 * currently in dev most of the plan dates are null  
		*/
		if(planStartDateOfLicence == null || planEndDateOfLicence == null) {
			planStartDateOfLicence = contractPeriodStartDate;
			planEndDateOfLicence = contractPeriodEndDate;
		}
		
		Date swoAmendStartDate = swoDomainDTO.getAmendStartDate();
		Date swoAmendEndDate = swoDomainDTO.getAmendEndDate();
		// This is the date on which Inventory was fetched
		Date swoAddedDate = swoDomainDTO.getSwoAddedDate();
		
		
		OPPTCalender cal = new OPPTCalender();
		boolean pricingFlags [] = {false,false};  
		// Amendment Rule 2
		if(cal.isDateGreater(planStartDateOfLicence,ammendmentEffectiveDate)) {
			// Pricing for the first period will never be performed
			pricingFlags [0] = false;
			
		}else{
			// Amendment Rule 3 
			pricingFlags [0] = true;
			if((cal.isDateLesser(planStartDateOfLicence,ammendmentEffectiveDate) ||
				cal.isDateEqual(planStartDateOfLicence,ammendmentEffectiveDate)) &&
				cal.isDateGreater(planEndDateOfLicence,ammendmentEffectiveDate)
			   )  
			{
				 // Pricing for the first period will have plan end date equal to amendement effective date minus one day
				 // and plan start date must remain same
				 pricingPeriodStartDate[0] = planStartDateOfLicence;
				 pricingPeriodEndDate[0] = ammendmentEffectiveDateMinusOne;
			
			}
					 // Amendement Rule 4
			if((cal.isDateLesser(planStartDateOfLicence,ammendmentEffectiveDate) ||
				cal.isDateEqual(planStartDateOfLicence,ammendmentEffectiveDate)) &&
				(cal.isDateLesser(planEndDateOfLicence,ammendmentEffectiveDate) ||
				 cal.isDateEqual(planEndDateOfLicence,ammendmentEffectiveDate)
				 )
			   )  
			{
				 // Plan start date and end date of Licence for the first pricing period remain the same
				pricingPeriodStartDate[0] = planStartDateOfLicence;
				pricingPeriodEndDate[0] = planEndDateOfLicence;
		
			}
		}
			
		// Amendement Rule 5
		if(cal.isDateLesser(swoAmendEndDate,ammendmentEffectiveDate)){ 
			// Pricing for second period never be performed
			pricingFlags [1] = false;
		}else{
			//	Amendement Rule 6
			pricingFlags [1] = true;
			if((cal.isDateGreater(swoAmendEndDate,ammendmentEffectiveDate) ||
				cal.isDateEqual(swoAmendEndDate,ammendmentEffectiveDate)) &&
				cal.isDateLesser(swoAmendStartDate,ammendmentEffectiveDate)
			   ) 
			{
				//Pricing for second period must have the plan start date of the license as 
				//the amendment effective date and plan end date of the license as the amendment end date of 
				//the license 
				pricingPeriodStartDate[1] = ammendmentEffectiveDate;
				pricingPeriodEndDate[1] = swoAmendEndDate;
			}
		}
		
		// Amendment Rule 7
		if(cal.isDateEqual(ammendmentEffectiveDateMinusOne,pricingPeriodEndDate[0]) && 
		   cal.isDateEqual(ammendmentEffectiveDateMinusOne, pricingPeriodStartDate[1])) {
		   	pricingFlags [0] = true;
			pricingFlags [1] = false;	
			pricingPeriodEndDate[0] = pricingPeriodEndDate[1];
		}
		
		// Amendment Rule 8
		// Amendment Rule 9
		if(cal.isDateGreater(swoAddedDate,contractPeriodStartDate)||
		   cal.isDateGreater(ammendmentEffectiveDate,contractPeriodStartDate)) {
		   	planStartDateOfLicence = swoAddedDate;
			swoDomainDTO.setPlanStartDate(planStartDateOfLicence);		   	
		}
		   
		priceProposalDomainDTO.setPricingFlags(pricingFlags);   
		if(pricingFlags[0]) {
			pricingPeriodDuration [0] = OPPTCalender.calculateContractPeriodDuration(pricingPeriodStartDate[0], pricingPeriodEndDate[0]);
			firstPricingPeriodDayFactors = calculateDayFactors(pricingPeriodStartDate[0], pricingPeriodEndDate[0],pricingPeriodDuration [0]);
			priceProposalDomainDTO.setFirstPricingPeriodDayFactors(firstPricingPeriodDayFactors);
			//priceProposalDomainDTO.setFirstPricingPeriodTVM();
		}
		if(pricingFlags[1]) {
			pricingPeriodDuration [1] = OPPTCalender.calculateContractPeriodDuration(pricingPeriodStartDate[1], pricingPeriodEndDate[1]);
			secondPricingPeriodDayFactors = calculateDayFactors(pricingPeriodStartDate[1], pricingPeriodEndDate[1],pricingPeriodDuration [1]);
			priceProposalDomainDTO.setSecondPricingPeriodDayFactors(secondPricingPeriodDayFactors);
			//priceProposalDomainDTO.setSecondPricingPeriodTVM();
		}
		
		priceProposalDomainDTO.setPricingFlags(pricingFlags);
		priceProposalDomainDTO.setPricingPeriodDuration(pricingPeriodDuration);
		logMessage = OPPTHelper.getLogString(String.valueOf(pricingFlags));
		OPPTLogger.log("MESSAGE_029",OPPTLogger.DEBUG,CLASS_NAME,"calculatePricingPeriods",logMessage);
		logMessage = OPPTHelper.getLogString(String.valueOf(pricingPeriodDuration));
		OPPTLogger.log("MESSAGE_030",OPPTLogger.DEBUG,CLASS_NAME,"calculatePricingPeriods",logMessage);
		log.end();
		
	}
	/* CR6153 start change */
	private BigDecimal [] calculateTVMFactors(double tvmRate, int contractPeriodDuration) {
		BigDecimal [] tvmFactors = new BigDecimal[contractPeriodDuration];
		System.out.println("EEPriceManagerBean.calculateTVMFactors()");
		for(int i=0;i<contractPeriodDuration;i++) {
			tvmFactors [i] = PricingComponentHelper.convertToBigDecimal(Math.pow((1+((tvmRate/100)/12)),-i));
			String messageString = OPPTHelper.getLogString(String.valueOf(i),String.valueOf(tvmFactors [i]));
			OPPTLogger.log("TVM_FACTORS",OPPTLogger.DEBUG,CLASS_NAME,"calculateTVMFactors",messageString);
		}
		
		return tvmFactors;
	}
	/* CR6153 end change */
}

