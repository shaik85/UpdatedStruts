/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.helper;

import java.math.BigDecimal;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ContractTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PriceConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalContractStatusConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;

/** 
 * This Class is a Helper class for Pricing Module
 * NO BUSINESS RULE IS HANDLED IN THIS CLASS
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 14, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class PricingComponentHelper {
	/**
	 * converts the double to BigDecimal
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param amount
	 * @return BigDecimal
	 */
	public static BigDecimal convertToBigDecimal(double amount) {
		return new BigDecimal((new Double(amount)).toString());
	}
	
	/**
	 * will round the input value based on decimals allowed used for pricing 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param price
	 * @param decimalsAllowed
	 * @return double
	 */
	public static double round(BigDecimal price,int decimalsAllowed) {			
			BigDecimal rounded = price.setScale(decimalsAllowed,BigDecimal.ROUND_HALF_EVEN);
	
			return rounded.doubleValue();
		}
	/**
		 * will round the input value based on decimals allowed used for pricing 
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Feb 6, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param price
		 * @param decimalsAllowed
		 * @return double
		 */
	public static double round(double price,int decimalsAllowed) {
		BigDecimal bigPrice = PricingComponentHelper.convertToBigDecimal(price);	
		BigDecimal rounded = bigPrice.setScale(decimalsAllowed,BigDecimal.ROUND_HALF_EVEN);
						
		return rounded.doubleValue();
	}
	
	/**
	 * sums EEEswprice
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoList
	 * @param type
	 * @return BigDecimal
	 */
	public static BigDecimal sumEEEswPrice(List swoList, String type) {
		BigDecimal totalEEESWPrice = PricingComponentHelper.convertToBigDecimal(0.0);
		for(int i = 0; i < swoList.size(); i++) {
				SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
				if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
					continue;
				}
				List eeList = swoDomainDTO.getEEDTOList();
		
				for (int j = 0; j < eeList.size(); j++) {
					EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(j);
					BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getEswPrice());
					totalEEESWPrice = totalEEESWPrice.add(eeESWPrice);
				}
			}

			return totalEEESWPrice;
		}

	/**
	 * sums EEAltprice
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoList
	 * @param type
	 * @return BigDecimal
	 */
	public static BigDecimal sumEEAltPrice(List swoList, String licenceType) {
		BigDecimal totalEEAltPrice = PricingComponentHelper.convertToBigDecimal(0.0);
		
		for(int i = 0; i < swoList.size(); i++) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
			if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
					continue;
				}
			if(isLicenceEligible(swoDomainDTO,licenceType)) {	
				List eeList = swoDomainDTO.getEEDTOList();
				for (int j = 0; j < eeList.size(); j++) {
					EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(j);
					BigDecimal eeAltPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getAlternatePrice());
					totalEEAltPrice = totalEEAltPrice.add(eeAltPrice);
				}
			}// end of perform
		}
		return totalEEAltPrice;
	}
	/**
	 * sums EECalcprice
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoList
	 * @param type
	 * @return BigDecimal
	 */

		public static BigDecimal sumEECalcPrice(List swoList, String licenceType) {
			BigDecimal totalEECalcPrice = PricingComponentHelper.convertToBigDecimal(0.0);
		
		
			for(int i = 0; i < swoList.size(); i++) {
				SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
				if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
					continue;
				}
				if(isLicenceEligible(swoDomainDTO,licenceType)) {
					List eeList = swoDomainDTO.getEEDTOList();
					for (int j = 0; j < eeList.size(); j++) {
						EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(j);
						BigDecimal eeCalcPrice = PricingComponentHelper.convertToBigDecimal(eeDomainDTO.getCalculatedPrice());
						totalEECalcPrice = totalEECalcPrice.add(eeCalcPrice);
					}
				}
			
			}

			return totalEECalcPrice;
		}
	/**
	 * sums SWOAltprice
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoList
	 * @param type
	 * @return BigDecimal
	 */

		public static BigDecimal sumSWOAltPrice(List swoList, String licenceType) {
			BigDecimal totalSWOAltPrice =  PricingComponentHelper.convertToBigDecimal(0.0);
			for(int i = 0; i < swoList.size(); i++) {
				SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
				BigDecimal swoAltPrice = PricingComponentHelper.convertToBigDecimal(swoDomainDTO.getAlternatePrice());
				if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
					continue;
				}
				if(isLicenceEligible(swoDomainDTO,licenceType)) {
					totalSWOAltPrice = totalSWOAltPrice.add(swoAltPrice);
				}
			}
		
			return totalSWOAltPrice;
		
		}
	
	/**
		 * sums SWOCalcprice
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Feb 6, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param swoList
		 * @param type
		 * @return BigDecimal
		 */	
		public static BigDecimal sumSWOCalcPrice(List swoList, String licenceType) {
			BigDecimal totalSWOCalcPrice =  PricingComponentHelper.convertToBigDecimal(0.0);
			for(int i = 0; i < swoList.size(); i++) {
				SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
				if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
					continue;
				}
				BigDecimal swoCalcPrice = PricingComponentHelper.convertToBigDecimal(swoDomainDTO.getCalcPrice());
				if(isLicenceEligible(swoDomainDTO,licenceType)) {
					totalSWOCalcPrice = totalSWOCalcPrice.add(swoCalcPrice);
				}			
			}
			return totalSWOCalcPrice;
		
		}
	
		/**
		 * sums SWOEswprice
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Feb 6, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param swoList
		 * @param type
		 * @return BigDecimal
		 */	
		public static BigDecimal sumSWOEswPrice(List swoList, String licenceType) {
			BigDecimal totalSWOESWPrice =  PricingComponentHelper.convertToBigDecimal(0.0);
			for(int i = 0; i < swoList.size(); i++) {
				SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
				BigDecimal swoESWPrice =  PricingComponentHelper.convertToBigDecimal(swoDomainDTO.getEswPrice());
				if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
					continue;
				}
				if(isLicenceEligible(swoDomainDTO,licenceType)) {
					totalSWOESWPrice = totalSWOESWPrice.add(swoESWPrice);
				}
			}
		
			return totalSWOESWPrice;
		}
			/**
			 * sums sumSWOEswPriceForSWOWithAltPrice
			 * <br><b>Known Bugs</b><br> 
			 * 
			 * <br><PRE> 
			 * date Feb 6, 2004 
			 * 
			 * revision date author reason 
			 * 
			 * </PRE><br> 
			 * 
			 * @param swoList
			 * @param type
			 * @return BigDecimal
			 */	
		public static BigDecimal sumSWOEswPriceForSWOWithAltPrice(List swoList,String licenceType) {
			BigDecimal totalSWOESWPrice =  PricingComponentHelper.convertToBigDecimal(0.0);
			for(int i = 0; i < swoList.size(); i++) {
				SWODomainDTO swoDomainDTO = (SWODomainDTO) swoList.get(i);
				if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
					continue;
				}
				boolean excludedLic = PriceConstants.YES.equals(swoDomainDTO.getExclusionId()) ? true:false;
				/**
				  * 31/05/2004
				  * MN 19387428- Defect 351
				  * For Alternate Price change added by Balaji
				  */
				boolean altPriceExists = false;
					
				if(UtilityConstants.YES.equals(swoDomainDTO.getAlternatePriceUpdateInd())) {
					altPriceExists = true;
				}
				
				if(!altPriceExists) {
					if(isLicenceEligible(swoDomainDTO,licenceType)) {
						List eeList = swoDomainDTO.getEEDTOList();
						for (int j = 0; j < eeList.size(); j++) {
							EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(j);
							if(UtilityConstants.YES.equals(eeDomainDTO.getAlternatePriceUpdateInd())) {
								altPriceExists = true;
								break;
							}
						}
					}
				}
				
				if(altPriceExists) {
					BigDecimal swoESWPrice =  PricingComponentHelper.convertToBigDecimal(swoDomainDTO.getEswPrice());
					if(isLicenceEligible(swoDomainDTO,licenceType)) {
						totalSWOESWPrice = totalSWOESWPrice.add(swoESWPrice);
					}
				}		
			}
			return totalSWOESWPrice;
		
		}
	/**
	 * sums ee count
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoList
	 * @param licenceType
	 * @return int
	 */	
	public static int getEECount(List swoList, String licenceType) {
		int eeCount = 0;
		for(int i=0,size = swoList.size(); i < size; i++) {
			SWODomainDTO swoDomainDTO = (SWODomainDTO)swoList.get(i);  
			// We do not consider svc licences.
			if(PriceConstants.SVC.equals(swoDomainDTO.getItemCategory())){
				continue;
			}
			if(isLicenceEligible(swoDomainDTO,licenceType)) {
				List eeList = swoDomainDTO.getEEDTOList();
				for (int j=0; j < eeList.size();j++) {
					EEDomainDTO eeDomainDTO = (EEDomainDTO) eeList.get(j);
					if(eeDomainDTO.getChargeOptionDesc() != null && 
					   UtilityConstants.NO_CHARGE.equalsIgnoreCase(eeDomainDTO.getChargeOptionDesc().trim())) {
					   	continue;
					}
					eeCount++;
				}
			}
		}
		return eeCount;
	}
	
	/**
	 * Based on the licence type we will perform the action
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param exclusionId
	 * @param licenceType
	 * @return
	 */
	public static boolean isLicenceEligible(SWODomainDTO swoDomainDTO, String licenceType) {
		
		boolean excludedLic = PriceConstants.YES.equals(swoDomainDTO.getExclusionId()) ? true:false;
		boolean sandsLicence = UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd()) ? true:false;
		boolean perform = false;
		if(PriceConstants.EXCLUDED.equals(licenceType) && excludedLic) {
			perform = true;	
		}else if(PriceConstants.NOT_EXCLUDED.equals(licenceType) &&(!excludedLic)) {
			perform = true;
		}else if(PriceConstants.ALL.equals(licenceType)) {
			perform = true;
		}else if(PriceConstants.S_AND_S.equals(licenceType) && sandsLicence) {
			perform = true;
		}else if(PriceConstants.MLC.equals(licenceType) && (!sandsLicence)) {
			perform = true;
		}
		
		
		return perform;
	}
	

}
