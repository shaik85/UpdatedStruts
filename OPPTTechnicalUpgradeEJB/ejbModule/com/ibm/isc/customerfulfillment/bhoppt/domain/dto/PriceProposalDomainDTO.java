/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;

/**
 * Enter one sentence as a brief description for your class.
 * You can enter more text here (e.g. describe the purpose of the class here).
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
public class PriceProposalDomainDTO extends OPPTDomainDTO {

	private BigDecimal iTvmFactors [];
	private BigDecimal iAmortizationFactors [];
	private BigDecimal iSpecialRateFactor;
	private String iAnniversaryAmountIndicator;
	private String iProposalType;
	private String iProposalName;
	private int iProposalId;
	private Date iAmendEffectiveDate;
	private String iExcludedLicenseInd;
	private String iAmendInd;
	private double iAnnivAmount;
	private String iBillingBock;
	private String iBillingFrequencyCode;
	private String iBillingType;
	private double iCapVariance;
	private String iContrAmendNo;
	private Date iContrClosureDate;
	private Date iContrStartDate;
	private Date iContrEndDate;
	private Date iContrEndPeriod;
	private Date iContrStartPeriod;
	private String iStatusCode;
	private String iContrType;
	private double iInvoiceAmt;
	private double iAnnualInvoiceAmt;
	private double iMonthlyInvoiceAmt;
	private double iSemiAnnualInvoiceAmt;
	private double iQurtInvoiceAmt;
	private List  iSWODomainDTOList;
	private int iNumberOfBills;
	//<!-- BlueHarmony DAD007 Changed by Anand Sugumaran -->
	private int iNumberOfMonthsForFrequency;
	//<!-- BlueHarmony DAD007 Changes end by Anand Sugumaran -->
	private double iPlannedGrowthRate;
	private double iTVMRate;
	private double iDiscount;
	private BigDecimal iAmortizationFactorForBillingFreq;
	private int iContractPeriodMonths;
	private int iDecimalsAllowed;
	private BigDecimal [] iDayFactors;
	private double iPreTVMInvoiceAmt;
	private Date iDatePriced;

	// For Amended Contracts, will be reset to default values
	private BigDecimal [] iFirstPricingPeriodTVM;
	private BigDecimal [] iSecondPricingPeriodTVM;
	private int iPricingPeriodDuration [];
	private Date iPricingPeriodStartDate [];
	private Date iPricingPeriodEndDate [];
	private BigDecimal [] iFirstPricingPeriodDayFactors;
	private BigDecimal [] iSecondPricingPeriodDayFactors;
	private boolean [] iPricingFlags = {false,false};
	
	private double iSAndsAnniversaryAmount;
	private double iSAndsDiscount;
	private String iProposalContent;
	
	private ErrorReport messageReport;
	private boolean annvAmtLessThanCalcPriceofExcludedLicence;
	
	/* CR6153 Start changes  */
	private String iExtendPeriod;
	
	private double isAndSDiscountAmount1;
	private double isAndSDiscountAmount2;
	private double isAndSDiscountAmount3;
	private double isAndSDiscountAmount4;
	private double isAndSDiscountAmount5;
	
	private double iSAndsAnniversaryAmount2;
	private double iSAndsAnniversaryAmount3;
	private double iSAndsAnniversaryAmount4;
	private double iSAndsAnniversaryAmount5;
	
	/* CR6153 End changes */
	

   /**
    * PriceProposalDomainDTO
    *
    * @param proposalBO
    */
   public PriceProposalDomainDTO(ProposalContractBO proposalBO)
   {
		setProposalId(proposalBO.getProposalId());
		setProposalName(proposalBO.getProposalName());
		setProposalType(proposalBO.getProposalType());
	  	setContrType(proposalBO.getContrType());
	  	setContrClosureDate(proposalBO.getContrClsDate());
	  	setContrStartPeriod(proposalBO.getContrStartPeriod());
	  	setContrEndDate(proposalBO.getContrEndDate());
	  	setContrStartDate(proposalBO.getContrStartDate());
	  	setContrEndPeriod(proposalBO.getContrEndPeriod());
	  	setStatusCode(proposalBO.getStatusCode());
	  	setTvmRate(proposalBO.getTvmRate());
	  	double discountA=proposalBO.getDiscount();
	  	System.out.println("PriceProposalDomainDTO.PriceProposalDomainDTO():Discount:"+proposalBO.getDiscount());
	  	setDiscount(discountA);
	  	//System.out.println("Manoj Discount"+discountA);
	  	setDiscount1(discountA);
	  	//System.out.println("GETTER A>>>"+getDiscount1());
	  	setPlannedGrowthRate(proposalBO.getSpecialRate());
	  	setAnnivAmount(proposalBO.getAnnvAmount());
	  	setCapVariance(proposalBO.getCapVariance());
	  	setAmendEffectiveDate(proposalBO.getAmendEffectiveDate());
	  	setBillingFrequencyCode(proposalBO.getBillingFreqCode());
		setSAndsAnniversaryAmount(proposalBO.getSAndsAnniversaryAmount());
		setProposalContent(proposalBO.getProposalContent());
		/* CR6153 Start changes  */
		if((proposalBO.getExtendPeriod() != null) && (proposalBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
			setExtendPeriod(proposalBO.getExtendPeriod());
			setSAndsAnniversaryAmount2(proposalBO.getSAndsAnniversaryAmt2());
			setSAndsAnniversaryAmount3(proposalBO.getSAndsAnniversaryAmt3());
			setSAndsAnniversaryAmount4(proposalBO.getSAndsAnniversaryAmt4());
			setSAndsAnniversaryAmount5(proposalBO.getSAndsAnniversaryAmt5());
		}
		/* CR6153 End changes  */
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public Date getAmendEffectiveDate() {
		return iAmendEffectiveDate;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getAmendInd() {
		return iAmendInd;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal [] getAmortizationFactors() {
		return iAmortizationFactors;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getAnnivAmount() {
		return iAnnivAmount;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String isAnniversaryAmountIndicator() {
		return iAnniversaryAmountIndicator;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getAnnualInvoiceAmt() {
		return iAnnualInvoiceAmt;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getBillingBock() {
		return iBillingBock;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getBillingFrequencyCode() {
		return iBillingFrequencyCode;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getBillingType() {
		return iBillingType;
	}


	/**
     * getCapVariance
     *
     * @return
     */
    public double getCapVariance() {
		return iCapVariance;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getContrAmendNo() {
		return iContrAmendNo;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public Date getContrClosureDate() {
		return iContrClosureDate;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public Date getContrEndDate() {
		return iContrEndDate;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public Date getContrEndPeriod() {
		return iContrEndPeriod;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public Date getContrStartPeriod() {
		return iContrStartPeriod;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getContrType() {
		return iContrType;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getExcludedLicenseInd() {
		return iExcludedLicenseInd;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getInvoiceAmt() {
		return iInvoiceAmt;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public List getSWODomainDTOList() {
		return iSWODomainDTOList;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getMonthlyInvoiceAmt() {
		return iMonthlyInvoiceAmt;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getProposalName() {
		return iProposalName;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getProposalType() {
		return iProposalType;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getQurtInvoiceAmt() {
		return iQurtInvoiceAmt;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getSemiAnnualInvoiceAmt() {
		return iSemiAnnualInvoiceAmt;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal getSpecialRateFactor() {
		return iSpecialRateFactor;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getStatusCode() {
		return iStatusCode;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal [] getTvmFactors() {
		return iTvmFactors;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setAmendEffectiveDate(Date i) {
		iAmendEffectiveDate = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setAmendInd(String i) {
		iAmendInd = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param ds
	 */
	public void setAmortizationFactors(BigDecimal[] ds) {
		iAmortizationFactors = ds;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setAnnivAmount(double i) {
		iAnnivAmount = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param b
	 */
	public void setAnniversaryAmountIndicator(String b) {
		iAnniversaryAmountIndicator = b;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setAnnualInvoiceAmt(double i) {
		iAnnualInvoiceAmt = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setBillingBock(String i) {
		iBillingBock = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setBillingFrequencyCode(String i) {
		iBillingFrequencyCode = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setBillingType(String i) {
		iBillingType = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */

	public void setCapVariance(double i) {
		iCapVariance = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setContrAmendNo(String i) {
		iContrAmendNo = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setContrClosureDate(Date i) {
		iContrClosureDate = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setContrEndDate(Date i) {
		iContrEndDate = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setContrEndPeriod(Date i) {
		iContrEndPeriod = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setContrStartPeriod(Date i) {
		iContrStartPeriod = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setContrType(String i) {
		iContrType = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setExcludedLicenseInd(String i) {
		iExcludedLicenseInd = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setInvoiceAmt(double i) {
		iInvoiceAmt = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param list
	 */
	public void setSWODomainDTOList(List list) {
		iSWODomainDTOList = list;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setMonthlyInvoiceAmt(double i) {
		iMonthlyInvoiceAmt = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param string
	 */
	public void setProposalName(String string) {
		iProposalName = string;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param string
	 */
	public void setProposalType(String string) {
		iProposalType = string;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setQurtInvoiceAmt(double i) {
		iQurtInvoiceAmt = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setSemiAnnualInvoiceAmt(double i) {
		iSemiAnnualInvoiceAmt = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param d
	 */
	public void setSpecialRateFactor(BigDecimal d) {
		iSpecialRateFactor = d;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setStatusCode(String i) {
		iStatusCode = i;
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
	 * date Dec 15, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param ds
	 */
	public void setTvmFactors(BigDecimal[] ds) {
		iTvmFactors = ds;
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
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public int getProposalId() {
		return iProposalId;
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
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setProposalId(int i) {
		iProposalId = i;
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
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public int getNumberOfBills() {
		return iNumberOfBills;
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
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setNumberOfBills(int i) {
		iNumberOfBills = i;
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
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getPlannedGrowthRate() {
		return iPlannedGrowthRate;
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
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getTvmRate() {
		return iTVMRate;
	}
	public double getDiscount() {
		
		//setDiscount1(iDiscount);
		return iDiscount;
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
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param d
	 */
	public void setPlannedGrowthRate(double d) {
		iPlannedGrowthRate = d;
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
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param d
	 */
	public void setTvmRate(double d) {
		iTVMRate = d;
	}
	public void setDiscount(double d) {
		iDiscount = d;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public Date getContrStartDate() {
		return iContrStartDate;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 16, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param date
	 */
	public void setContrStartDate(Date date) {
		iContrStartDate = date;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal getAmortizationFactorForBillingFreq() {
		return iAmortizationFactorForBillingFreq;
	}

	/**
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param d
	 */
	public void setAmortizationFactorForBillingFreq(BigDecimal d) {
		iAmortizationFactorForBillingFreq = d;
	}

	/**
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public int getContractPeriodDuration() {
		return iContractPeriodMonths;
	}

	/**
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setContractPeriodDuration(int i) {
		iContractPeriodMonths = i;
	}

	/**
	 *
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public int getDecimalsAllowed() {
		return iDecimalsAllowed;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 17, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param i
	 */
	public void setDecimalsAllowed(int i) {
		iDecimalsAllowed = i;
	}

	/**
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 20, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal[] getDayFactors() {
		return iDayFactors;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 20, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param ds
	 */
	public void setDayFactors(BigDecimal[] ds) {
		iDayFactors = ds;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public double getPreTVMInvoiceAmt() {
		return iPreTVMInvoiceAmt;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 22, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param d
	 */
	public void setPreTVMInvoiceAmt(double d) {
		iPreTVMInvoiceAmt = d;
	}

	/**
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 30, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public Date getDatePriced() {
		return iDatePriced;
	}

	/**
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 30, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param date
	 */
	public void setDatePriced(Date date) {
		iDatePriced = date;
	}



	/**
     * resetPricingPeriods
     *
     */
    public void resetPricingPeriods() {
		// resetting for other swo's
		setFirstPricingPeriodDayFactors(null);
		setFirstPricingPeriodTVM(null);
		setSecondPricingPeriodDayFactors(null);
		setSecondPricingPeriodTVM(null);
		setPricingPeriodStartDate(null);
		setPricingPeriodEndDate(null);
		setPricingPeriodDuration(null);
		boolean flags [] = {false,false};
		setPricingFlags(flags);
	}



	/**
	 *
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal[] getFirstPricingPeriodDayFactors() {
		return iFirstPricingPeriodDayFactors;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal[] getFirstPricingPeriodTVM() {
		return iFirstPricingPeriodTVM;
	}

	/**
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal[] getSecondPricingPeriodDayFactors() {
		return iSecondPricingPeriodDayFactors;
	}



	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public BigDecimal[] getSecondPricingPeriodTVM() {
		return iSecondPricingPeriodTVM;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param ds
	 */
	public void setFirstPricingPeriodDayFactors(BigDecimal[] ds) {
		iFirstPricingPeriodDayFactors = ds;
	}


	/** <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param ds
	 */
	public void setFirstPricingPeriodTVM(BigDecimal[] ds) {
		iFirstPricingPeriodTVM = ds;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param ds
	 */
	public void setSecondPricingPeriodDayFactors(BigDecimal[] ds) {
		iSecondPricingPeriodDayFactors = ds;
	}

	/**
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Jan 6, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param ds
	 */
	public void setSecondPricingPeriodTVM(BigDecimal[] ds) {
		iSecondPricingPeriodTVM = ds;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean[] getPricingFlags() {
		return iPricingFlags;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bs 
	 */
	public void setPricingFlags(boolean[] bs) {
		iPricingFlags = bs;
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
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public int[] getPricingPeriodDuration() {
		return iPricingPeriodDuration;
	}

	/** 
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
	 * @return 
	 */
	public Date[] getPricingPeriodEndDate() {
		return iPricingPeriodEndDate;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Date[] getPricingPeriodStartDate() {
		return iPricingPeriodStartDate;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param is 
	 */
	public void setPricingPeriodDuration(int[] is) {
		iPricingPeriodDuration = is;
	}

	/** 
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
	 * @param dates 
	 */
	public void setPricingPeriodEndDate(Date[] dates) {
		iPricingPeriodEndDate = dates;
	}

	/** 
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
	 * @param dates 
	 */
	public void setPricingPeriodStartDate(Date[] dates) {
		iPricingPeriodStartDate = dates;
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
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getProposalContent() {
		return iProposalContent;
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
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getSAndsAnniversaryAmount() {
		return iSAndsAnniversaryAmount;
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
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getSAndsDiscount() {
		return iSAndsDiscount;
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
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setProposalContent(String string) {
		iProposalContent = string;
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
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndsAnniversaryAmount(double d) {
		iSAndsAnniversaryAmount = d;
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
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndsDiscount(double d) {
		iSAndsDiscount = d;
	}


	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ErrorReport getMessageReport() {
		return messageReport;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param report 
	 */
	public void setMessageReport(ErrorReport report) {
		messageReport = report;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isAnnvAmtLessThanCalcPriceofExcludedLicence() {
		return annvAmtLessThanCalcPriceofExcludedLicence;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setAnnvAmtLessThanCalcPriceofExcludedLicence(boolean b) {
		annvAmtLessThanCalcPriceofExcludedLicence = b;
	}

    /**
     * getIAnniversaryAmountIndicator
     *
     * @return Returns the iAnniversaryAmountIndicator.
     */
    public String getIAnniversaryAmountIndicator() {
        return iAnniversaryAmountIndicator;
    }
    /**
     * setIAnniversaryAmountIndicator
     *
     * @param anniversaryAmountIndicator The iAnniversaryAmountIndicator to set.
     */
    public void setIAnniversaryAmountIndicator(String anniversaryAmountIndicator) {
        iAnniversaryAmountIndicator = anniversaryAmountIndicator;
    }
    
    
	/**
	 * @return Returns the isAndSDiscountAmount1.
	 */
	public double getSAndSDiscountAmount1() {
		return isAndSDiscountAmount1;
	}
	/**
	 * @param isAndSDiscountAmount1 The isAndSDiscountAmount1 to set.
	 */
	public void setSAndSDiscountAmount1(
			double isAndSDiscountAmount1) {
		this.isAndSDiscountAmount1 = isAndSDiscountAmount1;
	}
	/**
	 * @return Returns the isAndSDiscountAmount2.
	 */
	public double getSAndSDiscountAmount2() {
		return isAndSDiscountAmount2;
	}
	/**
	 * @param isAndSDiscountAmount2 The isAndSDiscountAmount2 to set.
	 */
	public void setSAndSDiscountAmount2(
			double isAndSDiscountAmount2) {
		this.isAndSDiscountAmount2 = isAndSDiscountAmount2;
	}
	/**
	 * @return Returns the isAndSDiscountAmount3.
	 */
	public double getSAndSDiscountAmount3() {
		return isAndSDiscountAmount3;
	}
	/**
	 * @param isAndSDiscountAmount3 The isAndSDiscountAmount3 to set.
	 */
	public void setSAndSDiscountAmount3(
			double isAndSDiscountAmount3) {
		this.isAndSDiscountAmount3 = isAndSDiscountAmount3;
	}
	/**
	 * @return Returns the isAndSDiscountAmount4.
	 */
	public double getSAndSDiscountAmount4() {
		return isAndSDiscountAmount4;
	}
	/**
	 * @param isAndSDiscountAmount4 The isAndSDiscountAmount4 to set.
	 */
	public void setSAndSDiscountAmount4(
			double isAndSDiscountAmount4) {
		this.isAndSDiscountAmount4 = isAndSDiscountAmount4;
	}
	/**
	 * @return Returns the isAndSDiscountAmount5.
	 */
	public double getSAndSDiscountAmount5() {
		return isAndSDiscountAmount5;
	}
	/**
	 * @param isAndSDiscountAmount5 The isAndSDiscountAmount5 to set.
	 */
	public void setSAndSDiscountAmount5(
			double isAndSDiscountAmount5) {
		this.isAndSDiscountAmount5 = isAndSDiscountAmount5;
	}
	
	
	/**
	 * @return Returns the iSAndsAnniversaryAmount2.
	 */
	public double getSAndsAnniversaryAmount2() {
		return iSAndsAnniversaryAmount2;
	}
	/**
	 * @param andsAnniversaryAmount2 The iSAndsAnniversaryAmount2 to set.
	 */
	public void setSAndsAnniversaryAmount2(double andsAnniversaryAmount2) {
		iSAndsAnniversaryAmount2 = andsAnniversaryAmount2;
	}
	/**
	 * @return Returns the iSAndsAnniversaryAmount3.
	 */
	public double getSAndsAnniversaryAmount3() {
		return iSAndsAnniversaryAmount3;
	}
	/**
	 * @param andsAnniversaryAmount3 The iSAndsAnniversaryAmount3 to set.
	 */
	public void setSAndsAnniversaryAmount3(double andsAnniversaryAmount3) {
		iSAndsAnniversaryAmount3 = andsAnniversaryAmount3;
	}
	/**
	 * @return Returns the iSAndsAnniversaryAmount4.
	 */
	public double getSAndsAnniversaryAmount4() {
		return iSAndsAnniversaryAmount4;
	}
	/**
	 * @param andsAnniversaryAmount4 The iSAndsAnniversaryAmount4 to set.
	 */
	public void setSAndsAnniversaryAmount4(double andsAnniversaryAmount4) {
		iSAndsAnniversaryAmount4 = andsAnniversaryAmount4;
	}
	/**
	 * @return Returns the iSAndsAnniversaryAmount5.
	 */
	public double getSAndsAnniversaryAmount5() {
		return iSAndsAnniversaryAmount5;
	}
	/**
	 * @param andsAnniversaryAmount5 The iSAndsAnniversaryAmount5 to set.
	 */
	public void setSAndsAnniversaryAmount5(double andsAnniversaryAmount5) {
		iSAndsAnniversaryAmount5 = andsAnniversaryAmount5;
	}
	
	/**
	 * @return Returns the iExtendPeriod.
	 */
	public String getExtendPeriod() {
		return iExtendPeriod;
	}
	/**
	 * @param extendPeriod The iExtendPeriod to set.
	 */
	public void setExtendPeriod(String extendPeriod) {
		iExtendPeriod = extendPeriod;
	}
	/**
	 * @return Returns the iNumberOfMonthsForFrequency.
	 * <!-- BlueHarmony DAD007 Changed by Anand Sugumaran -->
	 * 
	 */
	public int getNumberOfMonthsForFrequency() {
		return iNumberOfMonthsForFrequency;
	}
	/**
	 * @param numberOfMonthsForFrequency The iNumberOfMonthsForFrequency to set.
	 */
	public void setNumberOfMonthsForFrequency(int i) {
		iNumberOfMonthsForFrequency = i;
	}
//<!-- BlueHarmony DAD007 Changes End by Anand Sugumaran -->
}
