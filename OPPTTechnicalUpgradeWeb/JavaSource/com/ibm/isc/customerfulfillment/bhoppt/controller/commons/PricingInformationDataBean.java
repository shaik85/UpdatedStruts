/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.math.BigDecimal;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PricingInformationCustomDTO;

/**
 * Holds pricing deatails of a proposal  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class PricingInformationDataBean extends OPPTDataBean{
	private String plannedGrowthOption = "Nil";  //$NON-NLS-1$
	private String plannedGrowthValue = "";  //$NON-NLS-1$
	private String billingFrequency = "Q";  //$NON-NLS-1$
	private String growthLimitValue = "";  //$NON-NLS-1$
	private String growthLimitOption = "Nil";  //$NON-NLS-1$
	private String tvmRate = "";  //$NON-NLS-1$
	private String discount = "";  //$NON-NLS-1$
	private String additionalGrowthLimit = "";  //$NON-NLS-1$
	private String pakid = null;
	private String anniversaryContractAmount = "";  //$NON-NLS-1$
	private String ssAnninversaryContractAmount = "";  //$NON-NLS-1$
	
	/*CR6153 start changes  */
	private boolean extendPeriod = false;
	private String ssAnninversaryAmountPeriod2 = "";
	private String ssAnninversaryAmountPeriod3 = "";
	private String ssAnninversaryAmountPeriod4 = "";
	private String ssAnninversaryAmountPeriod5 = "";
	/*CR6153 end changes */
	
	private boolean detailedInvoice = false;
	private boolean gsa = false;
	
	private String billingBlock = null;
	private String deviatingDateRule = null;
	private String billingDateRule = null;
	private String freeTextForInvoicePrint = null;
	private boolean advance = false;

	private boolean invoiceSuppression = false;
	private String exceedingAmount = null;
	private Date varianceDate = null;

	// BH Wave-1 DAD003 - Manoj - Begin
	private String prebillIndicator = null;
	// BH Wave-1 DAD003 - Manoj - End
	/**
	 * Returns additional growth limit value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAdditionalGrowthLimit() {
		return additionalGrowthLimit;
	}

	/**
	 * Returns advance flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isAdvance() {
		return advance;
	}

	/**
	 * Returns anniversary contract amount value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAnniversaryContractAmount() {
		return anniversaryContractAmount;
	}

	/**
	 * Returns billing block type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillingBlock() {
		return billingBlock;
	}

	/**
	 * Returns billing date rule 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillingDateRule() {
		if(null != billingDateRule && "null".equalsIgnoreCase(billingDateRule)){  //$NON-NLS-1$
			billingDateRule = null;
		}
		return billingDateRule;
	}

	/**
	 * Returns billing frequency value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillingFrequency() {
		if(null != billingFrequency && "null".equalsIgnoreCase(billingFrequency)){  //$NON-NLS-1$
			billingFrequency = null;
		}
		return billingFrequency;
	}

	/**
	 * Returns detailed invoice flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDetailedInvoice() {
		return detailedInvoice;
	}

	/**
	 * Returns deviating date rule option 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDeviatingDateRule() {
		if(null != deviatingDateRule && "null".equalsIgnoreCase(deviatingDateRule)){  //$NON-NLS-1$
			deviatingDateRule = null;
		}
		return deviatingDateRule;
	}

	/**
	 * Returns free text for invoice print value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getFreeTextForInvoicePrint() {
		return freeTextForInvoicePrint;
	}

	/**
	 * Returns growth limit option value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGrowthLimitOption() {
		if(null != growthLimitOption && "null".equalsIgnoreCase(growthLimitOption)){  //$NON-NLS-1$
			growthLimitOption = null;
		}
		return growthLimitOption;
	}

	/**
	 * Returns growth limit value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGrowthLimitValue() {
		if(null != growthLimitValue && "null".equalsIgnoreCase(growthLimitValue)){  //$NON-NLS-1$
			growthLimitValue = null;
		}
		return growthLimitValue;
	}
	
	/**
	 * Returns gsa flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isGsa() {
		return gsa;
	}

	/**
	 * Returns extendContract flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 28, 2007
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isExtendPeriod() {
		return extendPeriod;
	}
	/**
	 * Returns pakid value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPakid() {
		return pakid;
	}

	/**
	 * Returns planned growth option  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPlannedGrowthOption() {
		if(null != plannedGrowthOption && "null".equalsIgnoreCase(plannedGrowthOption)){  //$NON-NLS-1$
			plannedGrowthOption = null;
		}
		return plannedGrowthOption;
	}

	/**
	 * Returns planned growth value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPlannedGrowthValue() {
		if(null != plannedGrowthValue && "null".equalsIgnoreCase(plannedGrowthValue)){  //$NON-NLS-1$
			plannedGrowthValue = null;
		}
		return plannedGrowthValue;
	}
	

	/**
	 * Returns tvm rate value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getTvmRate() {
		if(null != tvmRate && "null".equalsIgnoreCase(tvmRate)){  //$NON-NLS-1$
			tvmRate = null;
		}
		return tvmRate;
	}

	public String getDiscount() {
		if(null != discount && "null".equalsIgnoreCase(discount)){  //$NON-NLS-1$
			discount = null;
		}
		return discount;
	}
	/**
	 * Sets additional growth limti value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAdditionalGrowthLimit String 
	 */
	public void setAdditionalGrowthLimit(String newAdditionalGrowthLimit) {
		additionalGrowthLimit = newAdditionalGrowthLimit;
	}

	/**
	 * Sets advance flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAdvance boolean 
	 */
	public void setAdvance(boolean newAdvance) {
		advance = newAdvance;
	}

	/**
	 * Sets anniversary contract amount 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAnniversaryContractAmount String 
	 */
	public void setAnniversaryContractAmount(String newAnniversaryContractAmount) {
		anniversaryContractAmount = newAnniversaryContractAmount;
	}

	/**
	 * Sets billing block value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillingBlock String 
	 */
	public void setBillingBlock(String newBillingBlock) {
		billingBlock = newBillingBlock;
	}

	/**
	 * Sets billing date rule value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillingDateRile String 
	 */
	public void setBillingDateRule(String newBillingDateRile) {
		billingDateRule = newBillingDateRile;
	}

	/**
	 * Sets billing frequency value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillingFrequency String 
	 */
	public void setBillingFrequency(String newBillingFrequency) {
		billingFrequency = newBillingFrequency;
	}

	/**
	 * Sets detailed invoice amount flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDetailedInvoice boolean
	 */
	public void setDetailedInvoice(boolean newDetailedInvoice) {
		detailedInvoice = newDetailedInvoice;
	}

	/**
	 * Sets deviating date rule option 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDeviatingDateRule String 
	 */
	public void setDeviatingDateRule(String newDeviatingDateRule) {
		deviatingDateRule = newDeviatingDateRule;
	}

	/**
	 * Sets free text for invoice print value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFreeTextForInvoicePrint String 
	 */
	public void setFreeTextForInvoicePrint(String newFreeTextForInvoicePrint) {
		freeTextForInvoicePrint = newFreeTextForInvoicePrint;
	}

	/**
	 * Sets growth limit option 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGrowthLimitOption String 
	 */
	public void setGrowthLimitOption(String newGrowthLimitOption) {
		growthLimitOption = newGrowthLimitOption;
	}

	/**
	 * Sets growth limit value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGrowthLimitValue String 
	 */
	public void setGrowthLimitValue(String newGrowthLimitValue) {
		growthLimitValue = newGrowthLimitValue;
	}

	/**
	 * Sets gsa flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGsa boolean 
	 */
	public void setGsa(boolean newGsa) {
		gsa = newGsa;
	}

	/**
	 * Sets extendContract flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 28, 2007  
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExtendContract boolean 
	 */
	public void setExtendPeriod(boolean newExtendContract) {
		extendPeriod = newExtendContract;
	}

	/**
	 * Sets pakid value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPakid String 
	 */
	public void setPakid(String newPakid) {
		pakid = newPakid;
	}

	/**
	 * Sets planned growth option value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlannedGrowthOption String 
	 */
	public void setPlannedGrowthOption(String newPlannedGrowthOption) {
		plannedGrowthOption = newPlannedGrowthOption;
	}

	/**
	 * Sets planned growth value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlannedGrowthValue String 
	 */
	public void setPlannedGrowthValue(String newPlannedGrowthValue) {
		plannedGrowthValue = newPlannedGrowthValue;
	}

	/**
	 * Sets tvm rate 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTvmRate String 
	 */
	public void setTvmRate(String newTvmRate) {
		tvmRate = newTvmRate;
	}
	
	public void setDiscount(String newDiscount) {
		discount = newDiscount;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSsAnninversaryContractAmount() {
		return ssAnninversaryContractAmount;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSsAnninversaryContractAmount(String d) {
		ssAnninversaryContractAmount = d;
	}

	/**
     * @param customDTO
     * @author thirumalai
     */
    public void setData(PricingInformationCustomDTO customDTO){
		if(null != customDTO){
			String optionValue = customDTO.getPlannedGrowthOption();
			if(null == optionValue){
				double value = customDTO.getPlannedGrowthValue();
				if(0 == value){
					setPlannedGrowthOption("Nil");
					setGrowthLimitValue("");
				}
				else if(3 == value){
					setPlannedGrowthOption("3");
					setGrowthLimitValue("");
				}
				else if(6 == value){
					setPlannedGrowthOption("6");
					setGrowthLimitValue("");
				}
				else{
					setPlannedGrowthOption("Other");
					setPlannedGrowthValue(String.valueOf(value));
				}
			}
			else{
				setPlannedGrowthOption(optionValue);
				if("Nil".equalsIgnoreCase(optionValue) || "3".equalsIgnoreCase(optionValue) || "6".equalsIgnoreCase(optionValue)){
					setPlannedGrowthValue("");
				}
				else{
					setPlannedGrowthValue(String.valueOf(customDTO.getPlannedGrowthValue()));
				}
			}
			
			optionValue = customDTO.getGrowthLimitOption();
			if(null == optionValue){
				double value = customDTO.getGrowthLimitValue();
				if(0 == value){
					setGrowthLimitOption("Nil");
					setGrowthLimitValue("");
				}
				else if(7 == value){
					setGrowthLimitOption("7");
					setGrowthLimitValue("");
				}
				else if(15 == value){
					setGrowthLimitOption("15");
					setGrowthLimitValue("");
				}
				else{
					setGrowthLimitOption("Other");
					setGrowthLimitValue(String.valueOf(value));
				}
			}
			else{
				setGrowthLimitOption(optionValue);
				if("Nil".equalsIgnoreCase(optionValue) || "7".equalsIgnoreCase(optionValue) || "15".equalsIgnoreCase(optionValue)){
					setPlannedGrowthValue("");
				}
				else{
					setGrowthLimitValue(String.valueOf(customDTO.getGrowthLimitValue()));
				}
			}

			setBillingFrequency(customDTO.getBillingFrequency());
			setTvmRate(String.valueOf(customDTO.getTvmRate()));
			setAdditionalGrowthLimit(String.valueOf(customDTO.getAdditionalGrowthLimit()));
			setPakid(customDTO.getPakid());
			setDiscount(String.valueOf(customDTO.getDiscount()));
			if(-1.0 != customDTO.getAnniversaryContractAmount()){
				setAnniversaryContractAmount(getDoubleValue(customDTO.getAnniversaryContractAmount()));
			}
			else{
				setAnniversaryContractAmount(String.valueOf(0.00));
			}

			if(-1.0 != customDTO.getSAndSAnniversaryContractAmount()){
				setSsAnninversaryContractAmount(getDoubleValue(customDTO.getSAndSAnniversaryContractAmount()));
			}
			else{
				setSsAnninversaryContractAmount(String.valueOf(0.00));
			}
			setDetailedInvoice(customDTO.isDetailedInvoice());
			setGsa(customDTO.isGsa());
			/*CR6153 start changes  */
			setExtendPeriod(customDTO.isExtendPeriod());
			if(-1.0 != customDTO.getSAndSAnniversaryContractAmountPeriod2()){
				setSsAnninversaryAmountPeriod2(getDoubleValue(customDTO.getSAndSAnniversaryContractAmountPeriod2()));
			}
			else{
				setSsAnninversaryAmountPeriod2(String.valueOf(0.00));
			}
			if(-1.0 != customDTO.getSAndSAnniversaryContractAmountPeriod3()){
				setSsAnninversaryAmountPeriod3(getDoubleValue(customDTO.getSAndSAnniversaryContractAmountPeriod3()));
			}
			else{
				setSsAnninversaryAmountPeriod3(String.valueOf(0.00));
			}
			if(-1.0 != customDTO.getSAndSAnniversaryContractAmountPeriod4()){
				setSsAnninversaryAmountPeriod4(getDoubleValue(customDTO.getSAndSAnniversaryContractAmountPeriod4()));
			}
			else{
				setSsAnninversaryAmountPeriod4(String.valueOf(0.00));
			}
			if(-1.0 != customDTO.getSAndSAnniversaryContractAmountPeriod5()){
				setSsAnninversaryAmountPeriod5(getDoubleValue(customDTO.getSAndSAnniversaryContractAmountPeriod5()));
			}
			else{
				setSsAnninversaryAmountPeriod5(String.valueOf(0.00));
			}
			/*CR6153 end changes */
			setBillingBlock(customDTO.getBillingBlock());
			setDeviatingDateRule(customDTO.getDeviatingDateRule());
			setBillingDateRule(customDTO.getBillingDateRule());
			setFreeTextForInvoicePrint(customDTO.getFreeTextForInvoicePrint());
			setAdvance(customDTO.isAdvance());
			setVarianceDate(customDTO.getVarianceDate());
			setExceedingAmount(getDoubleValue(customDTO.getExceedingAmount()));
			setInvoiceSuppression(customDTO.isInvoiceSuppression());
			// BH Wave-1 DAD003 - Manoj - Begin
			setPrebillIndicator(customDTO.isPrebillIndicator());
			// BH Wave-1 DAD003 - Manoj - End
		}
	}
	
	public PricingInformationDataBean(){
	}

	public PricingInformationDataBean(PricingInformationCustomDTO customDTO){
		setData(customDTO);
	}

	public String toString(){
		StringBuffer strValue = new StringBuffer();
		
		strValue.append("\n\n[PricingInformationDataBean] - [toString] - Start...");
		strValue.append("\nPlanned growth option: "+getPlannedGrowthOption());
		strValue.append("\nPlanned growth value: "+getPlannedGrowthValue());
		strValue.append("\nBilling frequency: "+getBillingFrequency());
		strValue.append("\nGrowth limit value: "+getGrowthLimitValue());
		strValue.append("\nGrowth limit option: "+getGrowthLimitOption());
		strValue.append("\nTvm rate: "+getTvmRate());
		strValue.append("\nAdditional growth limit: "+getAdditionalGrowthLimit());
		strValue.append("\nPakid: "+getPakid());
		strValue.append("\nDiscount: "+getDiscount());
		strValue.append("\nAnniversary contract amount: "+getAnniversaryContractAmount());
		strValue.append("\nS and s anniversary contract amount: "+getSsAnninversaryContractAmount());
		/*CR6153 start changes  */
		strValue.append("\nS and s anniversary contract amount for perod2: "+getSsAnninversaryAmountPeriod2());
		strValue.append("\nS and s anniversary contract amount for perod3: "+getSsAnninversaryAmountPeriod3());
		strValue.append("\nS and s anniversary contract amount for perod4: "+getSsAnninversaryAmountPeriod4());
		strValue.append("\nS and s anniversary contract amount for perod5: "+getSsAnninversaryAmountPeriod5());
		strValue.append("\nDetailed invoice: "+isDetailedInvoice());
		strValue.append("\nGsa: "+isGsa());
		strValue.append("\nExtendPeriod: "+isExtendPeriod());
		/*CR6153 end changes */
		strValue.append("\nBilling block: "+getBillingBlock());
		strValue.append("\nDeviating date rule: "+getDeviatingDateRule());
		strValue.append("\nBilling date rule: "+getBillingDateRule());
		strValue.append("\nFree text for invoice print: "+getFreeTextForInvoicePrint());
		strValue.append("\nAdvance: "+isAdvance());		
		strValue.append("[PricingInformationDataBean] - [toString] - End...\n\n");

		return strValue.toString();
	}

	public boolean equals(PricingInformationDataBean dataBean)
	{
		boolean equal = true;

		if(null != dataBean){
			if(isDifferent(getPlannedGrowthOption(), dataBean.getPlannedGrowthOption())){
				equal = false;		
			}
			else if(isDifferent(getBillingFrequency(), dataBean.getBillingFrequency())){
				equal = false;		
			}
			else if(isDifferent(getGrowthLimitOption(), dataBean.getGrowthLimitOption())){
				equal = false;		
			}
			else if(isDifferent(getPakid(), dataBean.getPakid())){
				equal = false;		
			}
			else if(isDifferent(getBillingBlock(), dataBean.getBillingBlock())){
				equal = false;		
			}
			else if(isDifferent(getDeviatingDateRule(), dataBean.getDeviatingDateRule())){
				equal = false;		
			}
			else if(isDifferent(getBillingDateRule(), dataBean.getBillingDateRule())){
				equal = false;		
			}
			else if(isDifferent(getFreeTextForInvoicePrint(), dataBean.getFreeTextForInvoicePrint())){
				equal = false;		
			}
			else if(isDifferent(getPlannedGrowthValue(), dataBean.getPlannedGrowthValue())){
				equal = false;		
			}
			else if(isDifferent(getGrowthLimitValue(), dataBean.getGrowthLimitValue())){
				equal = false;		
			}
			else if(isDifferent(getTvmRate(), dataBean.getTvmRate())){
				equal = false;		
			}
			else if(isDifferent(getDiscount(), dataBean.getDiscount())){
				equal = false;		
			}
//			else if(isDifferent(getAdditionalGrowthLimit(), dataBean.getAdditionalGrowthLimit())){
//				equal = false;		
//			}
			else if(isDifferent(getAnniversaryContractAmount(), dataBean.getAnniversaryContractAmount())){
				equal = false;		
			}
			else if(isDifferent(getSsAnninversaryContractAmount(), dataBean.getSsAnninversaryContractAmount())){
				equal = false;		
			}
			/*CR6153 start changes  */
			else if(isDifferent(getSsAnninversaryAmountPeriod2(), dataBean.getSsAnninversaryAmountPeriod2())){
				equal = false;		
			}
			else if(isDifferent(getSsAnninversaryAmountPeriod3(), dataBean.getSsAnninversaryAmountPeriod3())){
				equal = false;		
			}
			else if(isDifferent(getSsAnninversaryAmountPeriod4(), dataBean.getSsAnninversaryAmountPeriod4())){
				equal = false;		
			}
			else if(isDifferent(getSsAnninversaryAmountPeriod5(), dataBean.getSsAnninversaryAmountPeriod5())){
				equal = false;		
			}
			
           /*CR6153 end changes */
			else if(isDifferent(isDetailedInvoice(), dataBean.isDetailedInvoice())){
				equal = false;		
			}
			else if(isDifferent(isGsa(), dataBean.isGsa())){
				equal = false;		
			}
			
            /*CR6153 start changes  */
			else if(isDifferent(isExtendPeriod(), dataBean.isExtendPeriod())){
				equal = false;		
			}
            /*CR6153 end changes */
			else if(isDifferent(isAdvance(), dataBean.isAdvance())){
				equal = false;		
			}
		}
		else{
			equal = false;
		}
		
		return equal;
	}

	private boolean isDifferent(String oldValue, String newValue){
		boolean different = true;
		
		if(null != oldValue){
			if(null != newValue){
				if(oldValue.equals(newValue)){
					different = false;
				}
			}
		}
		else{
			if(null == newValue){
				different = false;
			}
		}
		
		return different;
	}

	private boolean isDifferent(double oldValue, double newValue){
		boolean different = true;

		if(oldValue == newValue){
			different = false;		
		}
		
		return different;
	}

	private boolean isDifferent(boolean oldValue, boolean newValue){
		boolean different = true;

		if(oldValue == newValue){
			different = false;		
		}
		
		return different;
	}

	/** 
	 * Returns exceeding amount value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getExceedingAmount() {
		return exceedingAmount;
	}

	/**
	 * Returns invoice suppression flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isInvoiceSuppression() {
		return invoiceSuppression;
	}

	/** 
	 * Sets exceeding amount value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExceedingAmount String 
	 */
	public void setExceedingAmount(String newExceedingAmount) {
		exceedingAmount = newExceedingAmount;
	}

	/**
	 * Sets invoice suppression flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInvoiceSuppression boolean
	 */
	public void setInvoiceSuppression(boolean newInvoiceSuppression) {
		invoiceSuppression = newInvoiceSuppression;
	}
	
	/**
	 * Returns variance date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getVarianceDate() {
		return varianceDate;
	}

	/**
	 * Sets variance date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceDate Date 
	 */
	public void setVarianceDate(Date newVarianceDate) {
		varianceDate = newVarianceDate;
	}
	
	private String getDoubleValue(double doubleValue){
		BigDecimal initialDouble = new BigDecimal((new Double(doubleValue)).toString());
		//	BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_DOWN);
		/*
		* This is a fix for display issue of rounding
		* Balaji 
		*/
		BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		return scaledDouble.toString();
	}
		
	/**
	 * @return Returns the ssAnninversaryAmountPeriod2.
	 */
	public String getSsAnninversaryAmountPeriod2() {
		return ssAnninversaryAmountPeriod2;
	}
	/**
	 * @param ssAnninversaryAmountPeriod2 The ssAnninversaryAmountPeriod2 to set.
	 */
	public void setSsAnninversaryAmountPeriod2(
			String ssAnninversaryAmountPeriod2) {
		this.ssAnninversaryAmountPeriod2 = ssAnninversaryAmountPeriod2;
	}
	/**
	 * @return Returns the ssAnninversaryAmountPeriod3.
	 */
	public String getSsAnninversaryAmountPeriod3() {
		return ssAnninversaryAmountPeriod3;
	}
	/**
	 * @param ssAnninversaryAmountPeriod3 The ssAnninversaryAmountPeriod3 to set.
	 */
	public void setSsAnninversaryAmountPeriod3(
			String ssAnninversaryAmountPeriod3) {
		this.ssAnninversaryAmountPeriod3 = ssAnninversaryAmountPeriod3;
	}
	/**
	 * @return Returns the ssAnninversaryAmountPeriod4.
	 */
	public String getSsAnninversaryAmountPeriod4() {
		return ssAnninversaryAmountPeriod4;
	}
	/**
	 * @param ssAnninversaryAmountPeriod4 The ssAnninversaryAmountPeriod4 to set.
	 */
	public void setSsAnninversaryAmountPeriod4(
			String ssAnninversaryAmountPeriod4) {
		this.ssAnninversaryAmountPeriod4 = ssAnninversaryAmountPeriod4;
	}
	/**
	 * @return Returns the ssAnninversaryAmountPeriod5.
	 */
	public String getSsAnninversaryAmountPeriod5() {
		return ssAnninversaryAmountPeriod5;
	}
	/**
	 * @param ssAnninversaryAmountPeriod5 The ssAnninversaryAmountPeriod5 to set.
	 */
	public void setSsAnninversaryAmountPeriod5(
			String ssAnninversaryAmountPeriod5) {
		this.ssAnninversaryAmountPeriod5 = ssAnninversaryAmountPeriod5;
	}
	// BH Wave-1 DAD003 - Manoj - Begin
	/**
	 * @return Returns the prebillIndicator.
	 */
	public String isPrebillIndicator() {
		return prebillIndicator;
	}
	/**
	 * @param prebillIndicator The prebillIndicator to set.
	 */
	public void setPrebillIndicator(String prebillIndicator) {
		this.prebillIndicator = prebillIndicator;
	}
	// BH Wave-1 DAD003 - Manoj - End
}
