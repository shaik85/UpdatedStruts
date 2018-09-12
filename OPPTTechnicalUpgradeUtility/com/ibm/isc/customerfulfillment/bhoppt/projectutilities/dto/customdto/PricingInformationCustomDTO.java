/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;

/**
 * Custom dto that holds proposal headers pricing information  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 28, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class PricingInformationCustomDTO extends OPPTCustomDTO 
{
	private String plannedGrowthOption = null;
	private double plannedGrowthValue = 0;
	private String billingFrequency = null;
	private double growthLimitValue = 0;
	private String growthLimitOption = null;
	private double tvmRate = 0;
	private double additionalGrowthLimit = 0;
	private String pakid = null;
	private double discount = 0;
	private double anniversaryContractAmount = 0;
	private double sAndSAnniversaryContractAmount = 0;
	/*CR6153 start changes  */
	private boolean extendPeriod = false; 
	private double sAndSAnniversaryContractAmountPeriod2 = 0;
	private double sAndSAnniversaryContractAmountPeriod3 = 0;
	private double sAndSAnniversaryContractAmountPeriod4 = 0;
	private double sAndSAnniversaryContractAmountPeriod5 = 0;
	/*CR6153 end changes */
	private boolean detailedInvoice = false;
	private boolean gsa = false;
	private String billingBlock = null;
	private String deviatingDateRule = null;
	private String billingDateRule = null;
	private String freeTextForInvoicePrint = null;
	private boolean advance = false;

	// Fields added for variance change proposal
	private boolean invoiceSuppression = false;
	private double exceedingAmount = 0;
	private Date varianceDate = null;
	// BH Wave-1 DAD003 - Bhanu - Begin
	private String prebillIndicator = null;
	// BH Wave-1 DAD003 - Bhanu - End

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
	 * @return double
	 */
	public double getAdditionalGrowthLimit() {
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
	 * @return double
	 */
	public double getAnniversaryContractAmount() {
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
	 * @return double
	 */
	public double getGrowthLimitValue() {
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
	 * @return double
	 */
	public double getPlannedGrowthValue() {
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
	 * @return double
	 */
	public double getTvmRate() {
		//System.out.println("PricingInformationCustomDTO.getTvmRate():TVM Rate:"+tvmRate);
		return tvmRate;
	}
	
	public double getDiscount() {
		//System.out.println("PricingInformationCustomDTO.getDiscount():Discount:"+discount);
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
	 * @param newAdditionalGrowthLimit double 
	 */
	public void setAdditionalGrowthLimit(double newAdditionalGrowthLimit) {
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
	 * @param newAnniversaryContractAmount double 
	 */
	public void setAnniversaryContractAmount(double newAnniversaryContractAmount) {
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
	 * @param newGrowthLimitValue double 
	 */
	public void setGrowthLimitValue(double newGrowthLimitValue) {
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
	 * @param newPlannedGrowthValue double 
	 */
	public void setPlannedGrowthValue(double newPlannedGrowthValue) {
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
	 * @param newTvmRate double 
	 */
	public void setTvmRate(double newTvmRate) {
		tvmRate = newTvmRate;
	}
	
	public void setDiscount(double newDiscount) {
		discount = newDiscount;
	}
	/**
	 * Sets complete data in a single method call  
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
	 * @param aplannedGrowthOption String
	 * @param aplannedGrowthValue double
	 * @param abillingFrequency String
	 * @param agrowthLimitValue double
	 * @param agrowthLimitOption String
	 * @param atvmRate double
	 * @param aadditionalGrowthLimit doublw
	 * @param apakid String
	 * @param aanniversaryContractAmount double
	 * @param adetailedInvoice
	 * @param agsa boolean
	 * @param abillingBlock String
	 * @param adeviatingDateRule String
	 * @param abillingDateRule String
	 * @param afreeTextForInvoicePrint String
	 * @param aadvance boolean
	 * @param aextendContract boolean
	 */
	public void setData(String aplannedGrowthOption, double aplannedGrowthValue, String abillingFrequency, 
						double agrowthLimitValue, String agrowthLimitOption, double atvmRate, 
						double aadditionalGrowthLimit, String apakid,double adiscount, double aanniversaryContractAmount, 
						boolean adetailedInvoice, boolean agsa,boolean aextendContract, String abillingBlock, 	
						String adeviatingDateRule, String abillingDateRule, String afreeTextForInvoicePrint, 
						boolean aadvance){
		setPlannedGrowthOption(aplannedGrowthOption);
		setPlannedGrowthValue(aplannedGrowthValue);
		setBillingFrequency(abillingFrequency);
		setGrowthLimitValue(agrowthLimitValue);
		setGrowthLimitOption(agrowthLimitOption);
		setTvmRate(atvmRate);
		setAdditionalGrowthLimit(aadditionalGrowthLimit);
		setPakid(apakid);
		setDiscount(adiscount);
		setAnniversaryContractAmount(aanniversaryContractAmount);
		setDetailedInvoice(adetailedInvoice);
		setGsa(agsa);
		setExtendPeriod(aextendContract);
		setBillingBlock(abillingBlock);
		setDeviatingDateRule(adeviatingDateRule);
		setBillingDateRule(abillingDateRule);
		setFreeTextForInvoicePrint(afreeTextForInvoicePrint);
		setAdvance(aadvance);
	}
	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getSAndSAnniversaryContractAmount() {
		return sAndSAnniversaryContractAmount;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndSAnniversaryContractAmount(double d) {
		sAndSAnniversaryContractAmount = d;
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
	 * @return double
	 */
	public double getExceedingAmount() {
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
	 * @param newExceedingAmount double
	 */
	public void setExceedingAmount(double newExceedingAmount) {
		exceedingAmount = newExceedingAmount;
	}

	/**
	 * Returns invoice suppression value 
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
	 * @param newVaruanceDate Date 
	 */
	public void setVarianceDate(Date newVaruanceDate) {
		varianceDate = newVaruanceDate;
	}
	/**
	 * @return Returns the sAndSAnniversaryContractAmountPeriod2.
	 */
	public double getSAndSAnniversaryContractAmountPeriod2() {
		return sAndSAnniversaryContractAmountPeriod2;
	}
	/**
	 * @param andSAnniversaryContractAmountPeriod2 The sAndSAnniversaryContractAmountPeriod2 to set.
	 */
	public void setSAndSAnniversaryContractAmountPeriod2(
			double andSAnniversaryContractAmountPeriod2) {
		sAndSAnniversaryContractAmountPeriod2 = andSAnniversaryContractAmountPeriod2;
	}
	/**
	 * @return Returns the sAndSAnniversaryContractAmountPeriod3.
	 */
	public double getSAndSAnniversaryContractAmountPeriod3() {
		return sAndSAnniversaryContractAmountPeriod3;
	}
	/**
	 * @param andSAnniversaryContractAmountPeriod3 The sAndSAnniversaryContractAmountPeriod3 to set.
	 */
	public void setSAndSAnniversaryContractAmountPeriod3(
			double andSAnniversaryContractAmountPeriod3) {
		sAndSAnniversaryContractAmountPeriod3 = andSAnniversaryContractAmountPeriod3;
	}
	/**
	 * @return Returns the sAndSAnniversaryContractAmountPeriod4.
	 */
	public double getSAndSAnniversaryContractAmountPeriod4() {
		return sAndSAnniversaryContractAmountPeriod4;
	}
	/**
	 * @param andSAnniversaryContractAmountPeriod4 The sAndSAnniversaryContractAmountPeriod4 to set.
	 */
	public void setSAndSAnniversaryContractAmountPeriod4(
			double andSAnniversaryContractAmountPeriod4) {
		sAndSAnniversaryContractAmountPeriod4 = andSAnniversaryContractAmountPeriod4;
	}
	/**
	 * @return Returns the sAndSAnniversaryContractAmountPeriod5.
	 */
	public double getSAndSAnniversaryContractAmountPeriod5() {
		return sAndSAnniversaryContractAmountPeriod5;
	}
	/**
	 * @param andSAnniversaryContractAmountPeriod5 The sAndSAnniversaryContractAmountPeriod5 to set.
	 */
	public void setSAndSAnniversaryContractAmountPeriod5(
			double andSAnniversaryContractAmountPeriod5) {
		sAndSAnniversaryContractAmountPeriod5 = andSAnniversaryContractAmountPeriod5;
	}

	// BH Wave-1 DAD003 - Bhanu - Begin
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
	// BH Wave-1 DAD003 - Bhanu - End
}
