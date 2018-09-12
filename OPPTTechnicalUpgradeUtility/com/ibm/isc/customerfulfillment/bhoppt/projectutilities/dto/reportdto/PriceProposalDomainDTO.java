/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;
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
public class PriceProposalDomainDTO 
{
   private double tvmFactors[];
   private double amortizationFactor;
   private double specialRateFactor;
   private boolean anniversaryAmountIndicator;
   private int proposalType;
   private int proposalName;
   private int amendEffectiveDate;
   private int excludedLicenseInd;
   private int amendInd;
   private int annivAmount;
   private int billingBock;
   private int billingFrequencyCode;
   private int billingType;
   private int capAmount;
   private int capMinus;
   private int capPlus;
   private int capVariance;
   private int contrAmendNo;
   private int contrClosureDate;
   private int contrEndDate;
   private int contrEndPeriod;
   private int contrStartPeriod;
   private int statusCode;
   private int contrType;
   private int invoiceAmt;
   private int annualInvoiceAmt;
   private int preTVMInvoiceAmt;
   private int monthlyInvoiceAmt;
   private int semiAnnualInvoiceAmt;
   private int qurtInvoiceAmt;
   /**
    * public variale
    */
   public SWODomainDTO theSWODomainDTO;
   
   /**
    * constructor
    *    @roseuid 3FB4745B0312
    */
   public PriceProposalDomainDTO() 
   {
    
   }
   
   /**
    * get the data
    *    @roseuid 3F94C9E40265
    */
   public void getData() 
   {
    
   }
   
   /**
    * set the data
    *    @roseuid 3F94C9F10304
    */
   public void setData() 
   {
    
   }
/**
 * return the amendEffectiveDate 
 *
 * @return Returns the amendEffectiveDate.
 */
public int getAmendEffectiveDate() {
    return amendEffectiveDate;
}
/**
 * sets the amendEffectiveDate
 *
 * @param lAmendEffectiveDate The amendEffectiveDate to set.
 */
public void setAmendEffectiveDate(int lAmendEffectiveDate) {
    amendEffectiveDate = lAmendEffectiveDate;
}
/**
 * return the amendInd 
 *
 * @return Returns the amendInd.
 */
public int getAmendInd() {
    return amendInd;
}
/**
 * sets the amendInd
 *
 * @param lAmendInd The amendInd to set.
 */
public void setAmendInd(int lAmendInd) {
    amendInd = lAmendInd;
}
/**
 * return the amortizationFactor 
 *
 * @return Returns the amortizationFactor.
 */
public double getAmortizationFactor() {
    return amortizationFactor;
}
/**
 * sets the amortizationFactor
 *
 * @param lAmortizationFactor The amortizationFactor to set.
 */
public void setAmortizationFactor(double lAmortizationFactor) {
    amortizationFactor = lAmortizationFactor;
}
/**
 * return the annivAmount 
 *
 * @return Returns the annivAmount.
 */
public int getAnnivAmount() {
    return annivAmount;
}
/**
 * sets the annivAmount
 *
 * @param lAnnivAmount The annivAmount to set.
 */
public void setAnnivAmount(int lAnnivAmount) {
    annivAmount = lAnnivAmount;
}
/**
 * return the anniversaryAmountIndicator 
 *
 * @return Returns the anniversaryAmountIndicator.
 */
public boolean isAnniversaryAmountIndicator() {
    return anniversaryAmountIndicator;
}
/**
 * sets the anniversaryAmountIndicator
 *
 * @param lAnniversaryAmountIndicator The anniversaryAmountIndicator to set.
 */
public void setAnniversaryAmountIndicator(boolean lAnniversaryAmountIndicator) {
    anniversaryAmountIndicator = lAnniversaryAmountIndicator;
}
/**
 * return the annualInvoiceAmt 
 *
 * @return Returns the annualInvoiceAmt.
 */
public int getAnnualInvoiceAmt() {
    return annualInvoiceAmt;
}
/**
 * sets the annualInvoiceAmt
 *
 * @param lAnnualInvoiceAmt The annualInvoiceAmt to set.
 */
public void setAnnualInvoiceAmt(int lAnnualInvoiceAmt) {
    annualInvoiceAmt = lAnnualInvoiceAmt;
}
/**
 * return the billingBock 
 *
 * @return Returns the billingBock.
 */
public int getBillingBock() {
    return billingBock;
}
/**
 * sets the billingBock
 *
 * @param lBillingBock The billingBock to set.
 */
public void setBillingBock(int lBillingBock) {
    billingBock = lBillingBock;
}
/**
 * return the billingFrequencyCode 
 *
 * @return Returns the billingFrequencyCode.
 */
public int getBillingFrequencyCode() {
    return billingFrequencyCode;
}
/**
 * sets the billingFrequencyCode
 *
 * @param lBillingFrequencyCode The billingFrequencyCode to set.
 */
public void setBillingFrequencyCode(int lBillingFrequencyCode) {
    billingFrequencyCode = lBillingFrequencyCode;
}
/**
 * return the billingType 
 *
 * @return Returns the billingType.
 */
public int getBillingType() {
    return billingType;
}
/**
 * sets the billingType
 *
 * @param lBillingType The billingType to set.
 */
public void setBillingType(int lBillingType) {
    billingType = lBillingType;
}
/**
 * return the capAmount 
 *
 * @return Returns the capAmount.
 */
public int getCapAmount() {
    return capAmount;
}
/**
 * sets the capAmount
 *
 * @param lCapAmount The capAmount to set.
 */
public void setCapAmount(int lCapAmount) {
    capAmount = lCapAmount;
}
/**
 * return the capMinus 
 *
 * @return Returns the capMinus.
 */
public int getCapMinus() {
    return capMinus;
}
/**
 * sets the capMinus
 *
 * @param lCapMinus The capMinus to set.
 */
public void setCapMinus(int lCapMinus) {
    capMinus = lCapMinus;
}
/**
 * return the capPlus 
 *
 * @return Returns the capPlus.
 */
public int getCapPlus() {
    return capPlus;
}
/**
 * sets the capPlus
 *
 * @param lCapPlus The capPlus to set.
 */
public void setCapPlus(int lCapPlus) {
    capPlus = lCapPlus;
}
/**
 * return the capVariance 
 *
 * @return Returns the capVariance.
 */
public int getCapVariance() {
    return capVariance;
}
/**
 * sets the capVariance
 *
 * @param lCapVariance The capVariance to set.
 */
public void setCapVariance(int lCapVariance) {
    capVariance = lCapVariance;
}
/**
 * return the contrAmendNo 
 *
 * @return Returns the contrAmendNo.
 */
public int getContrAmendNo() {
    return contrAmendNo;
}
/**
 * sets the contrAmendNo
 *
 * @param lContrAmendNo The contrAmendNo to set.
 */
public void setContrAmendNo(int lContrAmendNo) {
    contrAmendNo = lContrAmendNo;
}
/**
 * return the contrClosureDate 
 *
 * @return Returns the contrClosureDate.
 */
public int getContrClosureDate() {
    return contrClosureDate;
}
/**
 * sets the contrClosureDate
 *
 * @param lContrClosureDate The contrClosureDate to set.
 */
public void setContrClosureDate(int lContrClosureDate) {
    contrClosureDate = lContrClosureDate;
}
/**
 * return the contrEndDate 
 *
 * @return Returns the contrEndDate.
 */
public int getContrEndDate() {
    return contrEndDate;
}
/**
 * sets the contrEndDate
 *
 * @param lContrEndDate The contrEndDate to set.
 */
public void setContrEndDate(int lContrEndDate) {
    contrEndDate = lContrEndDate;
}
/**
 * return the contrEndPeriod 
 *
 * @return Returns the contrEndPeriod.
 */
public int getContrEndPeriod() {
    return contrEndPeriod;
}
/**
 * sets the contrEndPeriod
 *
 * @param lContrEndPeriod The contrEndPeriod to set.
 */
public void setContrEndPeriod(int lContrEndPeriod) {
    contrEndPeriod = lContrEndPeriod;
}
/**
 * return the contrStartPeriod 
 *
 * @return Returns the contrStartPeriod.
 */
public int getContrStartPeriod() {
    return contrStartPeriod;
}
/**
 * sets the contrStartPeriod
 *
 * @param lContrStartPeriod The contrStartPeriod to set.
 */
public void setContrStartPeriod(int lContrStartPeriod) {
    contrStartPeriod = lContrStartPeriod;
}
/**
 * return the contrType 
 *
 * @return Returns the contrType.
 */
public int getContrType() {
    return contrType;
}
/**
 * sets the contrType
 *
 * @param lContrType The contrType to set.
 */
public void setContrType(int lContrType) {
    contrType = lContrType;
}
/**
 * return the excludedLicenseInd 
 *
 * @return Returns the excludedLicenseInd.
 */
public int getExcludedLicenseInd() {
    return excludedLicenseInd;
}
/**
 * sets the excludedLicenseInd
 *
 * @param lExcludedLicenseInd The excludedLicenseInd to set.
 */
public void setExcludedLicenseInd(int lExcludedLicenseInd) {
    excludedLicenseInd = lExcludedLicenseInd;
}
/**
 * return the invoiceAmt 
 *
 * @return Returns the invoiceAmt.
 */
public int getInvoiceAmt() {
    return invoiceAmt;
}
/**
 * sets the invoiceAmt
 *
 * @param lInvoiceAmt The invoiceAmt to set.
 */
public void setInvoiceAmt(int lInvoiceAmt) {
    invoiceAmt = lInvoiceAmt;
}
/**
 * return the monthlyInvoiceAmt 
 *
 * @return Returns the monthlyInvoiceAmt.
 */
public int getMonthlyInvoiceAmt() {
    return monthlyInvoiceAmt;
}
/**
 * sets the monthlyInvoiceAmt
 *
 * @param lMonthlyInvoiceAmt The monthlyInvoiceAmt to set.
 */
public void setMonthlyInvoiceAmt(int lMonthlyInvoiceAmt) {
    monthlyInvoiceAmt = lMonthlyInvoiceAmt;
}
/**
 * return the preTVMInvoiceAmt 
 *
 * @return Returns the preTVMInvoiceAmt.
 */
public int getPreTVMInvoiceAmt() {
    return preTVMInvoiceAmt;
}
/**
 * sets the preTVMInvoiceAmt
 *
 * @param lPreTVMInvoiceAmt The preTVMInvoiceAmt to set.
 */
public void setPreTVMInvoiceAmt(int lPreTVMInvoiceAmt) {
    preTVMInvoiceAmt = lPreTVMInvoiceAmt;
}
/**
 * return the proposalName 
 *
 * @return Returns the proposalName.
 */
public int getProposalName() {
    return proposalName;
}
/**
 * sets the proposalName
 *
 * @param lProposalName The proposalName to set.
 */
public void setProposalName(int lProposalName) {
    proposalName = lProposalName;
}
/**
 * return the proposalType 
 *
 * @return Returns the proposalType.
 */
public int getProposalType() {
    return proposalType;
}
/**
 * sets the proposalType
 *
 * @param lProposalType The proposalType to set.
 */
public void setProposalType(int lProposalType) {
    proposalType = lProposalType;
}
/**
 * return the qurtInvoiceAmt 
 *
 * @return Returns the qurtInvoiceAmt.
 */
public int getQurtInvoiceAmt() {
    return qurtInvoiceAmt;
}
/**
 * sets the qurtInvoiceAmt
 *
 * @param lQurtInvoiceAmt The qurtInvoiceAmt to set.
 */
public void setQurtInvoiceAmt(int lQurtInvoiceAmt) {
    qurtInvoiceAmt = lQurtInvoiceAmt;
}
/**
 * return the semiAnnualInvoiceAmt 
 *
 * @return Returns the semiAnnualInvoiceAmt.
 */
public int getSemiAnnualInvoiceAmt() {
    return semiAnnualInvoiceAmt;
}
/**
 * sets the semiAnnualInvoiceAmt
 *
 * @param lSemiAnnualInvoiceAmt The semiAnnualInvoiceAmt to set.
 */
public void setSemiAnnualInvoiceAmt(int lSemiAnnualInvoiceAmt) {
    semiAnnualInvoiceAmt = lSemiAnnualInvoiceAmt;
}
/**
 * return the specialRateFactor 
 *
 * @return Returns the specialRateFactor.
 */
public double getSpecialRateFactor() {
    return specialRateFactor;
}
/**
 * sets the specialRateFactor
 *
 * @param lSpecialRateFactor The specialRateFactor to set.
 */
public void setSpecialRateFactor(double lSpecialRateFactor) {
    specialRateFactor = lSpecialRateFactor;
}
/**
 * return the statusCode 
 *
 * @return Returns the statusCode.
 */
public int getStatusCode() {
    return statusCode;
}
/**
 * sets the statusCode
 *
 * @param lStatusCode The statusCode to set.
 */
public void setStatusCode(int lStatusCode) {
    statusCode = lStatusCode;
}
/**
 * return the theSWODomainDTO 
 *
 * @return Returns the theSWODomainDTO.
 */
public SWODomainDTO getTheSWODomainDTO() {
    return theSWODomainDTO;
}
/**
 * sets the theSWODomainDTO
 *
 * @param lTheSWODomainDTO The theSWODomainDTO to set.
 */
public void setTheSWODomainDTO(SWODomainDTO lTheSWODomainDTO) {
    theSWODomainDTO = lTheSWODomainDTO;
}
/**
 * return the tvmFactors 
 *
 * @return Returns the tvmFactors.
 */
public double[] getTvmFactors() {
    return tvmFactors;
}
/**
 * sets the tvmFactors
 *
 * @param lTvmFactors The tvmFactors to set.
 */
public void setTvmFactors(double[] lTvmFactors) {
    tvmFactors = lTvmFactors;
}
}
