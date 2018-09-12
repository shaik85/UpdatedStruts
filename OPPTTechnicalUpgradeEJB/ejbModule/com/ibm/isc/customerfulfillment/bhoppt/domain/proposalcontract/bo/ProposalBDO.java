/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo;

import java.sql.Date;
import java.sql.Time;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.*;
/**
 *  
 * ProposalBDO class represents attribute defined in Proposal Entity 
 * This data can be validated using Proposal/Contract/ProposalContract Business Object class
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A
 */

public class ProposalBDO {
	private int iProposalId;
	private String iProposalType;
	private String iBillingFreqCode;
	private String iCreatedBy;
	private String iApprovedBy;
	private String iStatusCode;
	private String iSalesOrg;
	private String iDistrChannel;
	private String iSalesGroup;
	private String iChannelRole;
	private String iSubmitterRole;
	private String iDivisionCode;
	private String iProposalName;
	private Date iContrStartDate;
	private Date iContrEndDate;
	private Date iContrStartPeriod;
	private Date iContrEndPeriod;
	private double iTvmRate;
	private double iDiscount;
	private double iGrowthFactor;
	private double iSpecialRate;
	private double iAnnvAmount;
	private double iInvoiceAmount;
	private String iAmendInd;
	private Date iAmendEffectiveDate;
	private Date iDatePriced;
	private String iComments;
	private Date iCreatedDate;
	private Date iApprovedDate;
	private String iDeletedInd;
	private String iRegCustomerNo;
	private String iRegCustomerName;
	private String iRegBillToPartyNo;
	private String iRegBillToPartyName;
	private String iRegPayerNo;
	private String iRegPayerName;
	private String iRegShipToPartyNo;
	private String iRegShipToPartyName;
	private String iCurrency;
	private Date iLastUpdatedDate;
	private String iRefetchId;
	private Date iFetchDate;
	private String iDeltaFetchId;
	private String iContrType;
	private String iReportName;
	private double iCapAmount;
	private double iCapPlus;
	private double iCapMinus;
	private double iPreTVM;
	private Date iContrExtDate;
	private Date iContrRetrDate;
	private Date iContrReplDate;
	private Date iContrClsDate;
	private String iContrNo;
	private double iContrAmendNo;
	private double iContrRenewNo;
	private String iRegCustomerLegNo;
	private String iRegBillToPartyLegNo;
	private String iRegPayerLegNo;
	private String iRegShipToPartyLegNo;
	private double iAnnvInvoiceAmount;
	private double iSemiAnnInvoiceAmount;
	private double iQuarterInvoiceAmount;
	private double iMonthlyInvoiceAmount;
	private String iOldContrNo;
	private double iContrReplNo;
	private double iPreTVMInvoiceAmount;
	private String iPropTypeApprover;
	private String iProposalSharing;
	private String iExtContrNo;
	private String iContrCreateFlag;
	private String iPakId;
	private String iAdvanceBilling;
	private String iBillingType;
	private String iPayementTerm;
	private int iAddValueDays;
	private Date iFixedValueDate;
	private String iTpContrNo;
	private String iIneligibleInd;
	private String iInvoiceInd;
	private String iDeviatingDateRule;
	private String iBillingBlock;
	private String iSandSExcluded;
	private String iLockedBy;
	private Date iLockedOn;
	private String iPoNo;
	private Date iPoDate;
	private String iFreeText;
	private String iRegCustomerASNo;
	private String iRegBillToPartASNo;
	private String iRegPayerASNo;
	private String iRegShipToPartyASNo;
	private String iGsaInd;
	private Date iEswFetchDate;
	private Time iEswFetchTime;
	private String iVarInd;
	private String iContrVarNo;
	private String iSupressInvoice;
	private int iContrPeriodVarNo;
	private Date iVarDate;
	private String iOrgVarContrNo;
	private double iCapVariance;
	private double iCumValue;
	private String iReg9DPartnerNo;
	private String iReg9DPartnerName;
	
	// Status, Billing options
	private StatusBDO iStatusBDO;
	private BillingBlockBDO iBillingBlockBDO;
	private BillingTypeBDO iBillingPlanBDO;
	private BillingTypeBDO iBillingDeviationDateRuleBDO;
	private BillingFrequencyBDO iBillingFrequencyBDO;
	private PaymentTermBDO iPaymentTermBDO;	 
	
	private String iIGFNumber;
	private double iSAndsAnniversaryAmount;
	private double iSAndsDiscount;
	private String iProposalContent;
	private String iSubmittedBy;
	private String iGroupName;
	
	/* CR6153  start*/
	private String iExtendPeriod;
	private double iSAndsAnniversaryAmt2;
	private double iSAndsAnniversaryAmt3;
	private double iSAndsAnniversaryAmt4;
	private double iSAndsAnniversaryAmt5;
	
	private double isAndSDiscountAmount1;
	private double isAndSDiscountAmount2;
	private double isAndSDiscountAmount3;
	private double isAndSDiscountAmount4;
	private double isAndSDiscountAmount5;
	/* CR6153  end*/
	
	// Blue Harmony Wave 1 DAD003 - Begin - Bhanu
	private String iCpsId;
	private String iOcpsId;
	//private String iComplexContractAmendment;
	//private String iMasterContractId;
	private String iContractType;
	//private String iMasterContractAmendment;
	private String iBlbIndicator;
	private String iPrebillIndicator;
	private String iPaymentMethod;
	private String iCciInd;	
//	 Blue Harmony Wave 1 DAD003 - End - Bhanu
	//Blue Harmony Wave 1 DAD001 - Start - Anand
	private String iSelectedCustomerName;
	
	private int iProposalCount;
	private String iAutoPopulate;
//	Blue Harmony Wave 1 DAD001 - End - Anand
	/**
	@roseuid 3FBCD26E00C1
	 */
	public ProposalBDO() {

	}

	/**
	 *  
	 * Get the AddValueDays
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AddValueDays
	 */

	public int getAddValueDays() {
		return iAddValueDays;
	}

	/**
	 *  Get the AdvanceBilling
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AdvanceBilling
	 */
	public String getAdvanceBilling() {
		return iAdvanceBilling;
	}

	/**
	 *  Get the AmendEffectiveDate
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AmendEffectiveDate
	 */
	public Date getAmendEffectiveDate() {
		return iAmendEffectiveDate;
	}

	/**
	 * Get the Amendment Indicator 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AmendInd
	 */
	public String getAmendInd() {
		return iAmendInd;
	}

	/**
	 *  Get the Anniversary Amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AnnvAmount
	 */
	public double getAnnvAmount() {
		return iAnnvAmount;
	}

	/**
	 *  Get the Anniversary Invoice Amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AnnvInvoiceAmount
	 */
	public double getAnnvInvoiceAmount() {
		return iAnnvInvoiceAmount;
	}

	/**
	 * Get Approver Name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ApprovedBy
	 */
	public String getApprovedBy() {
		return iApprovedBy;
	}

	/**
	 *  Get Approved Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ApprovedDate
	 */
	public Date getApprovedDate() {
		return iApprovedDate;
	}

	/**
	 *  Get the BillingBlock 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BillingBlock
	 */
	public String getBillingBlock() {
		return iBillingBlock;
	}

	/**
	 *  Get the Billing Frequency Code
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BillingFreqCode
	 */
	public String getBillingFreqCode() {
		return iBillingFreqCode;
	}

	/**
	 *  Get the BillingType
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BillingType
	 */
	public String getBillingType() {
		return iBillingType;
	}

	/**
	 * Get the CapAmount 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CapAmount
	 */
	public double getCapAmount() {
		return iCapAmount;
	}

	/**
	 *  Get the CapMinus
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CapMinus
	 */
	public double getCapMinus() {
		return iCapMinus;
	}

	/**
	 *  Get the CapPlus
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CapPlus
	 */
	public double getCapPlus() {
		return iCapPlus;
	}

	/**
	 *  
	 * Get the CapVariance
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CapVariance
	 */
	public double getCapVariance() {
		return iCapVariance;
	}

	/**
	 *  Get the Comments
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Comments
	 */
	public String getComments() {
		return iComments;
	}

	/**
	 * Get the Contract Amend No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrAmendNo
	 */
	public double getContrAmendNo() {
		return iContrAmendNo;
	}

	/**
	 * Get the Contract Closure Date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrClsDate
	 */
	public Date getContrClsDate() {
		return iContrClsDate;
	}

	/**
	 *  Get the Contract CreateFlag
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrCreateFlag
	 */
	public String getContrCreateFlag() {
		return iContrCreateFlag;
	}

	/**
	 *  Get the Contract End Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrEndDate
	 */
	public Date getContrEndDate() {
		return iContrEndDate;
	}

	/**
	 *  Get the Contract End Period
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrEndPeriod
	 */
	public Date getContrEndPeriod() {
		return iContrEndPeriod;
	}

	/**
	 *  Get the Contract Extended Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrExtDate 
	 */
	public Date getContrExtDate() {
		return iContrExtDate;
	}

	/**
	 *  Get the Contract Number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrNo
	 */
	public String getContrNo() {
		return iContrNo;
	}

	/**
	 *  Get the Contract Period Variance No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrPeriodVarNo
	 */
	public int getContrPeriodVarNo() {
		return iContrPeriodVarNo;
	}

	/**
	 *  Get the Contract Renewal No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrRenewNo
	 */
	public double getContrRenewNo() {
		return iContrRenewNo;
	}

	/**
	 * Get the Contract Replacemnet Date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrReplDate 
	 */
	public Date getContrReplDate() {
		return iContrReplDate;
	}

	/**
	 *  Get the Contract Replacement No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrReplNo
	 */
	public double getContrReplNo() {
		return iContrReplNo;
	}

	/**
	 *  Get the Contract Retarded Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrRetrDate
	 */
	public Date getContrRetrDate() {
		return iContrRetrDate;
	}
	/**
	 *  Get the Contract StartDate
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrStartDate
	 */
	public Date getContrStartDate() {
		return iContrStartDate;
	}

	/**
	 *  Get the Contract StartPeriod
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrStartPeriod
	 */
	public Date getContrStartPeriod() {
		return iContrStartPeriod;
	}

	/**
	 * Get the Contract Type
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrType
	 */
	public String getContrType() {
		return iContrType;
	}

	/**
	 *Get the Contract Variance No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContrVarNo
	 */
	public String getContrVarNo() {
		return iContrVarNo;
	}

	/**
	 * Get the Name of the Proposal Creator 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CreatedBy
	 */
	public String getCreatedBy() {
		return iCreatedBy;
	}

	/**
	 *  Get the Proposal Created Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CreatedDate
	 */
	public Date getCreatedDate() {
		return iCreatedDate;
	}

	/**
	 * Get the Cumulative Value 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CumValue
	 */
	public double getCumValue() {
		return iCumValue;
	}

	/**
	 *  Get the Currency
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Currency
	 */
	public String getCurrency() {
		return iCurrency;
	}

	/**
	 *  Get the Date of Priced
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DatePriced
	 */
	public Date getDatePriced() {
		return iDatePriced;
	}

	/**
	 *  Get the Delta Fetch ID 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DeltaFetchId
	 */
	public String getDeltaFetchId() {
		return iDeltaFetchId;
	}

	/**
	 *  Get the Deviating Date Rule
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DeviatingDate
	 */
	public String getDeviatingDateRule() {
		return iDeviatingDateRule;
	}

	/**
	 *  Get the Name of the Distribution Channel 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DistrChannel
	 */
	public String getDistrChannel() {
		return iDistrChannel;
	}

	/**
	 * @return the iSalesGroup
	 */
	public String getSalesGroup() {
		return iSalesGroup;
	}

	/**
	 * @return the iChannelRole
	 */
	public String getChannelRole() {
		return iChannelRole;
	}

	/**
	 * @return the iSubmitterRole
	 */
	public String getSubmitterRole() {
		return iSubmitterRole;
	}

	/**
	 * @param salesGroup the iSalesGroup to set
	 */
	public void setSalesGroup(String salesGroup) {
		iSalesGroup = salesGroup;
	}

	/**
	 * @param channelRole the iChannelRole to set
	 */
	public void setChannelRole(String channelRole) {
		iChannelRole = channelRole;
	}

	/**
	 * @param submitterRole the iSubmitterRole to set
	 */
	public void setSubmitterRole(String submitterRole) {
		iSubmitterRole = submitterRole;
	}

	/**
	 *  Get the Name of the Division Code 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DivisionCode
	 */
	public String getDivisionCode() {
		return iDivisionCode;
	}

	/**
	 *  Get the ESW Fetch Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EswFetchDate
	 */
	public Date getEswFetchDate() {
		return iEswFetchDate;
	}

	/**
	 *  Get ESW Fetch Time
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EswFetchTime
	 */
	public Time getEswFetchTime() {
		return iEswFetchTime;
	}

	/**
	 *  Get the External Contract No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ExtContrNo
	 */
	public String getExtContrNo() {
		return iExtContrNo;
	}

	/**
	 *  Get the Fetch Date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return FetchDate
	 */
	public Date getFetchDate() {
		return iFetchDate;
	}

	/**
	 *  Get the fixed value date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return FixedValueDate
	 */
	public Date getFixedValueDate() {
		return iFixedValueDate;
	}

	/**
	 *  Get the Free Text Value
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return FreeText
	 */
	public String getFreeText() {
		return iFreeText;
	}

	/**
	 *  Get the growth factor
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return GrowthFactor
	 */
	public double getGrowthFactor() {
		return iGrowthFactor;
	}

	/**
	 * Get the GSA Indicator 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return GsaInd
	 */
	public String getGsaInd() {
		return iGsaInd;
	}
	/**
	 * Get the SS Contract Extend Indicator 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iExtendContractInd
	 */
	public String getExtendPeriod() {
		return iExtendPeriod;
	}

	/**
	 *  Get the Ineligible Indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *  
	 * @return IneligibleInd
	 */
	public String getIneligibleInd() {
		return iIneligibleInd;
	}

	/**
	 *  Get the Invoice Amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return InvoiceAmount
	 */
	public double getInvoiceAmount() {
		return iInvoiceAmount;
	}

	/**
	 *  Get the Invoice Indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return InvoiceInd
	 */
	public String getInvoiceInd() {
		return iInvoiceInd;
	}

	/**
	 *  Get the last updated date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return LastUpdatedDate
	 */
	public Date getLastUpdatedDate() {
		return iLastUpdatedDate;
	}

	/**
	 *  Get the name of the locked user
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return LockedBy
	 */
	public String getLockedBy() {
		return iLockedBy;
	}

	/**
	 *  Get the Locked On
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return  locked on 
	 */
	public Date getLockedOn() {
		return iLockedOn;
	}

	/**
	 *  Get the monthly Invoice Amount 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return MonthlyInvoiceAmount
	 */
	public double getMonthlyInvoiceAmount() {
		return iMonthlyInvoiceAmount;
	}

	/**
	 *  Get the Old Contract No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return OldContrNo
	 */
	public String getOldContrNo() {
		return iOldContrNo;
	}

	/**
	 * Get the Orgainzation var contract No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public String getOrgVarContrNo() {
		return iOrgVarContrNo;
	}

	/**
	 *  Get the Pak Id
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return pakId
	 */
	public String getPakId() {
		return iPakId;
	}

	/**
	 *  Get the Payement Term 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PayementTerm
	 */
	public String getPayementTerm() {
		return iPayementTerm;
	}

	/**
	 * Get Purchase Order date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PoDate
	 */
	public Date getPoDate() {
		return iPoDate;
	}

	/**
	 *  Get the purchase order no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PoNo
	 */
	public String getPoNo() {
		return iPoNo;
	}
    /**
     * Get the Pre-Time Value Money  
     * <br><b>Known Bugs</b><br> 
     * 
     * <br><PRE> 
     * date Nov 21, 2003 
     * 
     * revision date author reason 
     * 
     * </PRE><br> 
     * 
     * @return PreTVM 
     */

	public double getPreTVM() {
		return iPreTVM;
	}

    /**
     * Get the Pre TVM Invoice Amount  
     * <br><b>Known Bugs</b><br> 
     * 
     * <br><PRE> 
     * date Nov 21, 2003 
     * 
     * revision date author reason 
     * 
     * </PRE><br> 
     * 
     * @return PreTVMInvoiceAmount
     */ 
	public double getPreTVMInvoiceAmount() {
		return iPreTVMInvoiceAmount;
	}
    
    /**
     * Get the Proposal Id 
     * <br><b>Known Bugs</b><br> 
     * 
     * <br><PRE> 
     * date Nov 21, 2003 
     * 
     * revision date author reason 
     * 
     * </PRE><br> 
     * 
     * @return ProposalId
     */
	public int getProposalId() {
		return iProposalId;
	}

	/**
	 * Get the Proposal Name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalName
	 */
	public String getProposalName() {
		return iProposalName;
	}

	/**
	 *  Get the Proposal Sharing
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalSharing
	 */
	public String getProposalSharing() {
		return iProposalSharing;
	}

	/**
	 * Get the Proposal Type 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalType
	 */
	public String getProposalType() {
		return iProposalType;
	}

	/**
	 *  Get the Proposal type Approver
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PropTypeApprover
	 */
	public String getPropTypeApprover() {
		return iPropTypeApprover;
	}

	/**
	 *  Get the Quarter Invoice Amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return QuarterInvoiceAmount
	 */
	public double getQuarterInvoiceAmount() {
		return iQuarterInvoiceAmount;
	}

	/**
	 *  Get the Re-Fetch Id
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RefetchId
	 */
	public String getRefetchId() {
		return iRefetchId;
	}

	/**
	 *  Get the Registered 9D Partner 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Reg9DPartnerName
	 */
	public String getReg9DPartnerName() {
		return iReg9DPartnerName;
	}

	/**
	 *  Get the Registered 9D Partner No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Reg9DPartnerNo
	 */
	public String getReg9DPartnerNo() {
		return iReg9DPartnerNo;
	}
	/**
	 * Get the Registered Bill To Party Address Sequence No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegBillToPartASNo
	 */
	public String getRegBillToPartASNo() {
		return iRegBillToPartASNo;
	}

	/**
	 *  Get Registered Bill to Party List No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegBillToPartyListNo
	 */
	public String getRegBillToPartyLegNo() {
		return iRegBillToPartyLegNo;
	}

	/**
	 *  Get the Registered Bill to Party Name
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegBillToPartyName
	 */
	public String getRegBillToPartyName() {
		return iRegBillToPartyName;
	}

	/**
	 * Get Registered Bill to Party Name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegBillToPartyNo
	 */
	public String getRegBillToPartyNo() {
		return iRegBillToPartyNo;
	}

	/**
	 *  Get Registered Customer Address Sequence No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegCustomerASNo
	 */
	public String getRegCustomerASNo() {
		return iRegCustomerASNo;
	}

	/**
	 *  Get the Register Customer List No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegCustomerListNo
	 */
	public String getRegCustomerLegNo() {
		return iRegCustomerLegNo;
	}

	/**
	 *  Get the Registered Customer Name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegCustomerName
	 */
	public String getRegCustomerName() {
		return iRegCustomerName;
	}

	/**
	 *  Get the Registered Customer No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public String getRegCustomerNo() {
		return iRegCustomerNo;
	}

	/**
	 *  Get the Registered Payer Address Sequence No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *  
	 * @return RegPayerASNo
	 */
	public String getRegPayerASNo() {
		return iRegPayerASNo;
	}

	/**
	 *  Get Registered Payer List No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iRegPayerLegNo
	 */
	public String getRegPayerLegNo() {
		return iRegPayerLegNo;
	}

	/**
	 *  Get Registered Payer Name
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegPayerName
	 */
	public String getRegPayerName() {
		return iRegPayerName;
	}

	/**
	 *  Get Registered Payer No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegPayerNo
	 */
	public String getRegPayerNo() {
		return iRegPayerNo;
	}

	/**
	 * Get Registered Ship Party ASNO 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegShipToPartyASNo 
	 */
	public String getRegShipToPartyASNo() {
		return iRegShipToPartyASNo;
	}

	/**
	 *  Get the Registered Ship to Party List No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iRegShipToPartyLegNo
	 */
	public String getRegShipToPartyLegNo() {
		return iRegShipToPartyLegNo;
	}

	/**
	 * Get the Registered Ship To Party Name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegShipToPartyName
	 */ 
	public String getRegShipToPartyName() {
		return iRegShipToPartyName;
	}

	/**
	 *  Get the Registered Ship to Party No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RegShipToPartyNo
	 */
	public String getRegShipToPartyNo() {
		return iRegShipToPartyNo;
	}

	/**
	 * Get the Report Name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ReportName
	 */
	public String getReportName() {
		return iReportName;
	}

	/**
	 *  Get the Sales Org
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SalesOrg
	 */
	public String getSalesOrg() {
		return iSalesOrg;
	}
	/**
	 *  Get the S&S Excluded 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SandSExcluded
	 */
	public String getSandSExcluded() {
		return iSandSExcluded;
	}

	/**
	 *  Get Semi Annual Invoice Amount 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SemiAnnInvoiceAmount
	 */
	public double getSemiAnnInvoiceAmount() {
		return iSemiAnnInvoiceAmount;
	}

	/**
	 *  Get the Special Rate
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SpecialRate
	 */
	public double getSpecialRate() {
		return iSpecialRate;
	}

	/**
	 *  Get the status code
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return StatusCode
	 */
	public String getStatusCode() {
		return iStatusCode;
	}
	/**
	 *  Get the Suppress Invoice
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SupressInvoice
	 */
	public String getSupressInvoice() {
		return iSupressInvoice;
	}

	/**
	 * Get the TPContract No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TpContrNo
	 */
	public String getTpContrNo() {
		return iTpContrNo;
	}

	/**
	 * Get the TVMRate  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *  
	 * @return TvmRate
	 */
	public double getTvmRate() {
		return iTvmRate;
	}
	public double getDiscount() {
		return iDiscount;
	}

	/**
	 *  Get the Variance Date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return VarDate
	 */
	public Date getVarDate() {
		return iVarDate;
	}

	/**
	 *  Get the Variance Ind
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return VarInd
	 */
	public String getVarInd() {
		return iVarInd;
	}

	/**
	 *  set the Add Value Days
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param addValueDays
	 */
	public void setAddValueDays(int addValueDays) {
		iAddValueDays = addValueDays;
	}

	/**
	 *  set Advance Billing
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param advanceBilling
	 */
	public void setAdvanceBilling(String advanceBilling) {
		iAdvanceBilling = advanceBilling;
	}

	/**
	 *  set Amendment Effective date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param amendEffectiveDate
	 */
	public void setAmendEffectiveDate(Date amendEffectiveDate) {
		iAmendEffectiveDate = amendEffectiveDate;
	}

	/**
	 *  set Amendment Indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param amendInd
	 */
	public void setAmendInd(String amendInd) {
		iAmendInd = amendInd;
	}

	/**
	 *  Set the Anniversary amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param annvAmount
	 */
	public void setAnnvAmount(double annvAmount) {
		iAnnvAmount = annvAmount;
	}

	/**
	 * Set the Anniversary Invoice Amount 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param annvInvoiceAmount
	 */
	public void setAnnvInvoiceAmount(double annvInvoiceAmount) {
		iAnnvInvoiceAmount = annvInvoiceAmount;
	}

	/**
	 *  Set the approver name
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param approvedBy
	 */
	public void setApprovedBy(String approvedBy) {
		iApprovedBy = approvedBy;
	}

	/**
	 *  set the Approved date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param approvedDate
	 */
	public void setApprovedDate(Date approvedDate) {
		iApprovedDate = approvedDate;
	}

	/**
	 * set Billing Block 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingBlock
	 */
	public void setBillingBlock(String billingBlock) {
		iBillingBlock = billingBlock;
	}

	/**
	 *  set the Billing Frequency Code
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingFreqCode
	 */
	public void setBillingFreqCode(String billingFreqCode) {
		iBillingFreqCode = billingFreqCode;
	}

	/**
	 *  set the Billing Type
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingType
	 */
	public void setBillingType(String billingType) {
		iBillingType = billingType;
	}

	/**
	 *  set the Cap Amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param capAmount
	 */
	public void setCapAmount(double capAmount) {
		iCapAmount = capAmount;
	}

	/**
	 *  set the Cap Minus
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param capMinus
	 */
	public void setCapMinus(double capMinus) {
		iCapMinus = capMinus;
	}

	/**
	 *  set the Cap Plus
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param capPlus
	 */
	public void setCapPlus(double capPlus) {
		iCapPlus = capPlus;
	}

	/**
	 *  set the cap variance
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param capVariance
	 */
	public void setCapVariance(double capVariance) {
		iCapVariance = capVariance;
	}

	/**
	 *  set the comments
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param comments
	 */
	public void setComments(String comments) {
		iComments = comments;
	}

	/**
	 *  set the contract amend no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrAmendNo
	 */
	public void setContrAmendNo(double contrAmendNo) {
		iContrAmendNo = contrAmendNo;
	}

	/**
	 *  set the contract closure date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrClsDate
	 */
	public void setContrClsDate(Date contrClsDate) {
		iContrClsDate = contrClsDate;
	}

	/**
	 *  set the contract create flag
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrCreateFlag
	 */
	public void setContrCreateFlag(String contrCreateFlag) {
		iContrCreateFlag = contrCreateFlag;
	}

	/**
	 *  set the contract end date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrEndDate
	 */
	public void setContrEndDate(Date contrEndDate) {
		iContrEndDate = contrEndDate;
	}

	/**
	 *  set the contract end period
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrEndPeriod
	 */
	public void setContrEndPeriod(Date contrEndPeriod) {
		iContrEndPeriod = contrEndPeriod;
	}
	/**
	 * set the contract ext date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrExtDate
	 */
	public void setContrExtDate(Date contrExtDate) {
		iContrExtDate = contrExtDate;
	}

	/**
	 *  set the contract no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrNo
	 */
	public void setContrNo(String contrNo) {
		iContrNo = contrNo;
	}

	/**
	 *  set the contract period variance no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrPeriodVarNo
	 */
	public void setContrPeriodVarNo(int contrPeriodVarNo) {
		iContrPeriodVarNo = contrPeriodVarNo;
	}

	/**
	 *  set the contract renew no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrRenewNo
	 */
	public void setContrRenewNo(double contrRenewNo) {
		iContrRenewNo = contrRenewNo;
	}

	/**
	 *  set the contract replacement date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrReplDate
	 */
	public void setContrReplDate(Date contrReplDate) {
		iContrReplDate = contrReplDate;
	}

	/**
	 *  set contract Repl Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrReplNo
	 */
	public void setContrReplNo(double contrReplNo) {
		iContrReplNo = contrReplNo;
	}

	/**
	 *  set the contract retarder date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrRetrDate
	 */
	public void setContrRetrDate(Date contrRetrDate) {
		iContrRetrDate = contrRetrDate;
	}

	/**
	 *  set the contract start date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrStartDate
	 */
	public void setContrStartDate(Date contrStartDate) {
		iContrStartDate = contrStartDate;
	}

	/**
	 *  set the contract start period
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrStartPeriod
	 */
	public void setContrStartPeriod(Date contrStartPeriod) {
		iContrStartPeriod = contrStartPeriod;
	}

	/**
	 *  set the contract type
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrType
	 */
	public void setContrType(String contrType) {
		iContrType = contrType;
	}

	/**
	 *  set the contract variance no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contrVarNo
	 */
	public void setContrVarNo(String contrVarNo) {
		iContrVarNo = contrVarNo;
	}

	/**
	 *  set the created by
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		iCreatedBy = createdBy;
	}

	/**
	 *  set the porposal created date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		iCreatedDate = createdDate;
	}

	/**
	 *  set the cumulative value
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param cumValue
	 */
	public void setCumValue(double cumValue) {
		iCumValue = cumValue;
	}

	/**
	 *  set the currency
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param currency
	 */
	public void setCurrency(String currency) {
		iCurrency = currency;
	}

	/**
	 *  set the date priced
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param datePriced
	 */
	public void setDatePriced(Date datePriced) {
		iDatePriced = datePriced;
	}

	/**
	 * Set the Delata Fetch Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param deltaFetchId
	 */
	public void setDeltaFetchId(String deltaFetchId) {
		iDeltaFetchId = deltaFetchId;
	}
	
	/**
	 * set the deviating date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param deviatingDateRule
	 */
	public void setDeviatingDateRule(String deviatingDateRule) {
		iDeviatingDateRule = deviatingDateRule;
	}

	/**
	 *  set the distribution channel
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param distrChannel
	 */
	public void setDistrChannel(String distrChannel) {
		iDistrChannel = distrChannel;
	}
	/**
	 *  set the division code
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param divisionCode
	 */
	public void setDivisionCode(String divisionCode) {
		iDivisionCode = divisionCode;
	}

	/**
	 *  set the esw fetch date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eswFetchDate
	 */
	public void setEswFetchDate(Date eswFetchDate) {
		iEswFetchDate = eswFetchDate;
	}

	/**
	 *  set the esw fetch time
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eswFetchTime
	 */
	public void setEswFetchTime(Time eswFetchTime) {
		iEswFetchTime = eswFetchTime;
	}

	/**
	 *  set the external contract no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param extContrNo
	 */
	public void setExtContrNo(String extContrNo) {
		iExtContrNo = extContrNo;
	}

	/**
	 *  set the fetch date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param fetchDate
	 */
	public void setFetchDate(Date fetchDate) {
		iFetchDate = fetchDate;
	}

	/**
	 *  set the fixed value date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param fixedValueDate
	 */
	public void setFixedValueDate(Date fixedValueDate) {
		iFixedValueDate = fixedValueDate;
	}

	/**
	 *  set the free text
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param freeText
	 */
	public void setFreeText(String freeText) {
		iFreeText = freeText;
	}

	/**
	 *  set the growth factor
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param growthFactor
	 */
	public void setGrowthFactor(double growthFactor) {
		iGrowthFactor = growthFactor;
	}
	/**
	 *  set the GSA Indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param gsaInd
	 */
	public void setGsaInd(String gsaInd) {
		iGsaInd = gsaInd;
	}
	
	/**
	 *  set the S&S Extend Contract Indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param extendContractInd
	 */
	public void setExtendPeriod(String extendPeriod) {
		iExtendPeriod = extendPeriod;
	}

	/**
	 *  set the Ineligible Indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ineligibleInd
	 */
	public void setIneligibleInd(String ineligibleInd) {
		iIneligibleInd = ineligibleInd;
	}

	/**
	 *  set the Invoice amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param invoiceAmount
	 */
	public void setInvoiceAmount(double invoiceAmount) {
		iInvoiceAmount = invoiceAmount;
	}
	/**
	 *  set the invoice indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param invoiceInd
	 */
	public void setInvoiceInd(String invoiceInd) {
		iInvoiceInd = invoiceInd;
	}

	/**
	 *  set last updated date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lastUpdatedDate
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		iLastUpdatedDate = lastUpdatedDate;
	}
	/**
	 *  set locked user name
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lockedBy
	 */
	public void setLockedBy(String lockedBy) {
		iLockedBy = lockedBy;
	}
	/**
	 *  set the locked on
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lockedOn
	 */
	public void setLockedOn(Date lockedOn) {
		iLockedOn = lockedOn;
	}
	
	/**
	 *  set monthly invoice amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param monthlyInvoiceAmount
	 */
	public void setMonthlyInvoiceAmount(double monthlyInvoiceAmount) {
		iMonthlyInvoiceAmount = monthlyInvoiceAmount;
	}
	
	/**
	 * set the Old Contract No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldContrNo
	 */
	public void setOldContrNo(String oldContrNo) {
		iOldContrNo = oldContrNo;
	}
	
	/**
	 * set the Org Variance Contract No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param orgVarContrNo
	 */
	public void setOrgVarContrNo(String orgVarContrNo) {
		iOrgVarContrNo = orgVarContrNo;
	}
	
	/**
	 * set the Pak ID  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param pakId
	 */

	public void setPakId(String pakId) {
		iPakId = pakId;
	}

	/**
	 *  Set the Payment Term
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param payementTerm
	 */
	public void setPayementTerm(String payementTerm) {
		iPayementTerm = payementTerm;
	}

	/**
	 *  set the Purchase Order Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param poDate
	 */
	public void setPoDate(Date poDate) {
		iPoDate = poDate;
	}
	
	/**
	 * Set the purchase Order No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param poNo
	 */
	public void setPoNo(String poNo) {
		iPoNo = poNo;
	}

	/**
	 *  set the Pre TVM
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param preTVM
	 */
	public void setPreTVM(double preTVM) {
		iPreTVM = preTVM;
	}

	/**
	 *  set the Pre Time Value Money Invoice Amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param preTVMInvoiceAmount
	 */
	public void setPreTVMInvoiceAmount(double preTVMInvoiceAmount) {
		iPreTVMInvoiceAmount = preTVMInvoiceAmount;
	}
	
	/**
	 *  set the Proposal Id
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 */
	public void setProposalId(int proposalId) {
		iProposalId = proposalId;
	}

	/**
	 *  set the Proposal Name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalName
	 */
	public void setProposalName(String proposalName) {
		iProposalName = proposalName;
	}
	/**
	 *  set the Proposal Sharing
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalSharing
	 */
	public void setProposalSharing(String proposalSharing) {
		iProposalSharing = proposalSharing;
	}

	/**
	 *  set the Proposal type
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalType
	 */
	public void setProposalType(String proposalType) {
		iProposalType = proposalType;
	}

	/**
	 *  set the Proposal type approver
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param propTypeApprover
	 */
	public void setPropTypeApprover(String propTypeApprover) {
		iPropTypeApprover = propTypeApprover;
	}

	/**
	 *  set the Qurter Invoice amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param quaterInvoiceAmount
	 */
	public void setQuarterInvoiceAmount(double quarterInvoiceAmount) {
		iQuarterInvoiceAmount = quarterInvoiceAmount;
	}

	/**
	 *  Set Refetch Id
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param refetchId
	 */
	public void setRefetchId(String refetchId) {
		iRefetchId = refetchId;
	}

	/**
	 *  set Registered 9D Partner
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param reg9DPartnerName
	 */
	public void setReg9DPartnerName(String reg9DPartnerName) {
		iReg9DPartnerName = reg9DPartnerName;
	}

	/**
	 * set Registered 9D Partner No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param reg9DPartnerNo
	 */
	public void setReg9DPartnerNo(String reg9DPartnerNo) {
		iReg9DPartnerNo = reg9DPartnerNo;
	}

	/**
	 * set Registered Bill to Party ASNo  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regBillToPartASNo
	 */
	public void setRegBillToPartASNo(String regBillToPartASNo) {
		iRegBillToPartASNo = regBillToPartASNo;
	}

	/**
	 *  set Registered Bill To Party List No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regBillToPartyLegNo
	 */
	public void setRegBillToPartyLegNo(String regBillToPartyLegNo) {
		iRegBillToPartyLegNo = regBillToPartyLegNo;
	}

	/**
	 *  set Registered Bill to Party Name
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regBillToPartyName
	 */
	public void setRegBillToPartyName(String regBillToPartyName) {
		iRegBillToPartyName = regBillToPartyName;
	}

	/**
	 *  set the Registerd Bill to Party No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regBillToPartyNo
	 */
	public void setRegBillToPartyNo(String regBillToPartyNo) {
		iRegBillToPartyNo = regBillToPartyNo;
	}

	/**
	 *  set Registered Customer Address sequence no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regCustomerASNo
	 */
	public void setRegCustomerASNo(String regCustomerASNo) {
		iRegCustomerASNo = regCustomerASNo;
	}

	/**
	 *  set Registered Customer List No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regCustomerLegNo
	 */
	public void setRegCustomerLegNo(String regCustomerLegNo) {
		iRegCustomerLegNo = regCustomerLegNo;
	}

	/**
	 *  set Registered Customer Name
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regCustomerName
	 */
	public void setRegCustomerName(String regCustomerName) {
		iRegCustomerName = regCustomerName;
	}
	/**
	 *  set Register Customer No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regCustomerNo
	 */
	public void setRegCustomerNo(String regCustomerNo) {
		iRegCustomerNo = regCustomerNo;
	}

	/**
	 *  set Registered Payer Address Sequence No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regPayerASNo
	 */
	public void setRegPayerASNo(String regPayerASNo) {
		iRegPayerASNo = regPayerASNo;
	}

	/**
	 * set Registered Payer List No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string
	 */
	public void setRegPayerLegNo(String regPayerLegNo) {
		iRegPayerLegNo = regPayerLegNo;
	}

	/**
	 *  set Registered Payer Name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regPayerName
	 */
	public void setRegPayerName(String regPayerName) {
		iRegPayerName = regPayerName;
	}

	/**
	 *  set Registered Payer No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regPayerNo
	 */
	public void setRegPayerNo(String regPayerNo) {
		iRegPayerNo = regPayerNo;
	}

	/**
	 * set Registered ship to Party Address sequence no 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regShipToPartyASNo
	 */
	public void setRegShipToPartyASNo(String regShipToPartyASNo) {
		iRegShipToPartyASNo = regShipToPartyASNo;
	}

	/**
	 *  set Registered ship to party list no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regShipToPartyListNo
	 */
	public void setRegShipToPartyLegNo(String regShipToPartyLegNo) {
		iRegShipToPartyLegNo = regShipToPartyLegNo;
	}

	/**
	 *  set Registered ship to party name
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regShipToPartyName
	 */
	public void setRegShipToPartyName(String regShipToPartyName) {
		iRegShipToPartyName = regShipToPartyName;
	}

	/**
	 *  set Registered ship to party no
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param regShipToPartyNo
	 */
	public void setRegShipToPartyNo(String regShipToPartyNo) {
		iRegShipToPartyNo = regShipToPartyNo;
	}

	/**
	 *  set Report Name
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param reportName
	 */
	public void setReportName(String reportName) {
		iReportName = reportName;
	}

	/**
	 *  set Sales Org
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesOrg
	 */
	public void setSalesOrg(String salesOrg) {
		iSalesOrg = salesOrg;
	}

	/**
	 *  set S&S Excluded
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sAndSExcluded
	 */
	public void setSAndSExcluded(String sAndSExcluded) {
		iSandSExcluded = sAndSExcluded;
	}

	/**
	 *  set Semi Annual Invoice Amount
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param semiAnnInvoiceAmount
	 */
	public void setSemiAnnInvoiceAmount(double semiAnnInvoiceAmount) {
		iSemiAnnInvoiceAmount = semiAnnInvoiceAmount;
	}

	/**
	 *  set Special Rate
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param specialRate
	 */
	public void setSpecialRate(double specialRate) {
		iSpecialRate = specialRate;
	}

	/**
	 *  set Status code
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param statusCode
	 */
	public void setStatusCode(String statusCode) {
		iStatusCode = statusCode;
	}

	/**
	 *  set the Suppress Invoice
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param supressInvoice
	 */
	public void setSupressInvoice(String supressInvoice) {
		iSupressInvoice = supressInvoice;
	}

	/**
	 *  set the Transistion Proposal Contract No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tpContrNo
	 */
	public void setTpContrNo(String tpContrNo) {
		iTpContrNo = tpContrNo;
	}

	/**
	 *  set the TVM Rate
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tvmRate
	 */
	public void setTvmRate(double tvmRate) {
		iTvmRate = tvmRate;
	}
	public void setDiscount(double discount) {
		iDiscount = discount;
	}

	/**
	 *  set the Variance Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param varDate
	 */
	public void setVarDate(Date varDate) {
		iVarDate = varDate;
	}

	/**
	 *  set the Variance Indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param varInd
	 */
	public void setVarInd(String varInd) {
		iVarInd = varInd;
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
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getDeletedInd() {
		return iDeletedInd;
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
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setDeletedInd(String string) {
		iDeletedInd = string;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public BillingBlockBDO getBillingBlockBDO() {
		return iBillingBlockBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public BillingTypeBDO getBillingDeviationDateRuleBDO() {
		return iBillingDeviationDateRuleBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public BillingFrequencyBDO getBillingFrequencyBDO() {
		return iBillingFrequencyBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public BillingTypeBDO getBillingPlanBDO() {
		return iBillingPlanBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public PaymentTermBDO getPaymentTermBDO() {
		return iPaymentTermBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public StatusBDO getStatusBDO() {
		return iStatusBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param blockBDO 
	 */
	public void setBillingBlockBDO(BillingBlockBDO blockBDO) {
		iBillingBlockBDO = blockBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param typeBDO 
	 */
	public void setBillingDeviationDateRuleBDO(BillingTypeBDO typeBDO) {
		iBillingDeviationDateRuleBDO = typeBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param frequencyBDO 
	 */
	public void setBillingFrequencyBDO(BillingFrequencyBDO frequencyBDO) {
		iBillingFrequencyBDO = frequencyBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param typeBDO 
	 */
	public void setBillingPlanBDO(BillingTypeBDO typeBDO) {
		iBillingPlanBDO = typeBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param termBDO 
	 */
	public void setPaymentTermBDO(PaymentTermBDO termBDO) {
		iPaymentTermBDO = termBDO;
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
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param statusBDO 
	 */
	public void setStatusBDO(StatusBDO statusBDO) {
		iStatusBDO = statusBDO;
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
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getIGFNumber() {
		return iIGFNumber;
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
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setIGFNumber(String string) {
		iIGFNumber = string;
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
	 * date Feb 5, 2004 
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
	 * date Feb 5, 2004 
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
	 *date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getSAndsAnniversaryAmt2() {
		return iSAndsAnniversaryAmt2;
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
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getSAndsAnniversaryAmt3() {
		return iSAndsAnniversaryAmt3;
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
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getSAndsAnniversaryAmt4() {
		return iSAndsAnniversaryAmt4;
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
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getSAndsAnniversaryAmt5() {
		return iSAndsAnniversaryAmt5;
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
	 * date Feb 5, 2004 
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
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSubmittedBy() {
		return iSubmittedBy;
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
	 * date Feb 5, 2004 
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
	 * date Feb 5, 2004 
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
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndsAnniversaryAmt2(double d) {
		iSAndsAnniversaryAmt2 = d;
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
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndsAnniversaryAmt3(double d) {
		iSAndsAnniversaryAmt3 = d;
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
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndsAnniversaryAmt4(double d) {
		iSAndsAnniversaryAmt4 = d;
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
	 * date Jun 20, 2007 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndsAnniversaryAmt5(double d) {
		iSAndsAnniversaryAmt5 = d;
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
	 * date Feb 5, 2004 
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
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSubmittedBy(String string) {
		iSubmittedBy = string;
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
	 * date Apr 21, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getGroupName() {
		return iGroupName;
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
	 * date Apr 21, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setGroupName(String string) {
		iGroupName = string;
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
	// Blue Harmony Wave 1 DAD003 - Begin - Bhanu
	/**
	 * @return Returns the iBlbIndicator.
	 */
	public String getBlbIndicator() {
		return iBlbIndicator;
	}
	/**
	 * @param blbIndicator The iBlbIndicator to set.
	 */
	public void setBlbIndicator(String blbIndicator) {
		iBlbIndicator = blbIndicator;
	}
	/**
	 * @return Returns the iComplexContractAmendment.
	 */
	/*public String getComplexContractAmendment() {
		return iComplexContractAmendment;
	}
	*//**
	 * @param complexContractAmendment The iComplexContractAmendment to set.
	 *//*
	public void setComplexContractAmendment(String complexContractAmendment) {
		iComplexContractAmendment = complexContractAmendment;
	}*/
	/**
	 * @return Returns the iComplexContractId.
	 */
	public String getCpsId() {
		return iCpsId;
	}
	/**
	 * @param complexContractId The iComplexContractId to set.
	 */
	public void setCpsId(String cpsId) {
		iCpsId = cpsId;
	}
	/**
	 * @return Returns the iComplexContractType.
	 */
	public String getOcpsId() {
		return iOcpsId;
	}
	/**
	 * @param complexContractType The iComplexContractType to set.
	 */
	public void setOcpsId(String ocpsId) {
		iOcpsId = ocpsId;
	}
	/**
	 * @return Returns the iMasterContractAmendment.
	 */
	/*public String getMasterContractAmendment() {
		return iMasterContractAmendment;
	}
	*//**
	 * @param masterContractAmendment The iMasterContractAmendment to set.
	 *//*
	public void setMasterContractAmendment(String masterContractAmendment) {
		iMasterContractAmendment = masterContractAmendment;
	}*/
	/**
	 * @return Returns the iMasterContractId.
	 */
	/*public String getMasterContractId() {
		return iMasterContractId;
	}
	*//**
	 * @param masterContractId The iMasterContractId to set.
	 *//*
	public void setMasterContractId(String masterContractId) {
		iMasterContractId = masterContractId;
	}*/
	/**
	 * @return Returns the iMasterContractType.
	 */
	public String getContractType() {
		return iContractType;
	}
	/**
	 * @param masterContractType The iMasterContractType to set.
	 */
	public void setContractType(String contractType) {
		iContractType = contractType;
	}
	/**
	 * @return Returns the iPrebillIndicator.
	 */
	public String getPrebillIndicator() {
		return iPrebillIndicator;
	}
	
	/**
	 * @param prebillIndicator The iPrebillIndicator to set.
	 */
	public void setPrebillIndicator(String prebillIndicator) {
		iPrebillIndicator = prebillIndicator;
	}
	
	public String getPaymentMethod() {
			return iPaymentMethod;
		
	}

	public void setPaymentMethod(String paymentMethod) {
	iPaymentMethod = paymentMethod;
	}
	/**
	 * @return Returns the iCciInd.
	 */
	public String getCciInd() {
		return iCciInd;
	}
	/**
	 * @param cciInd The iCciInd to set.
	 */
	public void setCciInd(String cciInd) {
		iCciInd = cciInd;
	}
	// Blue Harmony Wave 1 DAD003 - End - Bhanu

	/**
	 * @return Returns the iSelectedCustomerName.
	 */
	public String getSelectedCustomerName() {
		return iSelectedCustomerName;
	}
	/**
	 * @param selectedCustomerName The iSelectedCustomerName to set.
	 */
	public void setSelectedCustomerName(String selectedCustomerName) {
		iSelectedCustomerName = selectedCustomerName;
	}
	/**
	 * @return Returns the iProposalCount.
	 */
	public int getProposalCount() {
		return iProposalCount;
	}
	/**
	 * @param proposalCount The iProposalCount to set.
	 */
	public void setProposalCount(int proposalCount) {
		iProposalCount = proposalCount;
	}
	/**
	 * @return Returns the iAutoPopulate.
	 */
	public String getAutoPopulate() {
		return iAutoPopulate;
	}
	/**
	 * @param autoPopulate The iAutoPopulate to set.
	 */
	public void setAutoPopulate(String autoPopulate) {
		iAutoPopulate = autoPopulate;
	}
}
