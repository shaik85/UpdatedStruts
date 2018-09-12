/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo;

import java.sql.Date;

/**
 *  
 * PriceBDO class represents attribute defined in Price Entity 
 * This data can be validated using Price Business Object class
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * Dec 22 Venkat  To Add the Indicator Field. 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A
 */

public class PriceBDO {
	private int iPriceId;
	private int iProposalId;
	private int iCustomerId;
	private int iDmId;
	private int iSwoId;
	private int iEeId;
	private String iSalesDocNo;
	private String iEeItemNo;
	private Date iBillPlanStartDate;
	private Date iBillPlanEndDate;
	private double iEswPrice;
	private String iCurrency;
	private String iExclusionId;
	private String iBillingStatus;
	private String iMonthId;
	private String iIndicator;
	

	/**
	 *  
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public PriceBDO() {

	}

	/**
	 * Get Bill Plan End Date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BillPlanEndDate
	 */
	public Date getBillPlanEndDate() {
		return iBillPlanEndDate;
	}

	/**
	 * Get Bill Plan start date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BillPlanStartDate
	 */
	public Date getBillPlanStartDate() {
		return iBillPlanStartDate;
	}

	/**
	 * Get Currency  
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
	 * Get Customer Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerId
	 */
	public int getCustomerId() {
		return iCustomerId;
	}

	/**
	 * Get DM Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DmId
	 */
	public int getDmId() {
		return iDmId;
	}

	/**
	 * Get EE Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EeId
	 */
	public int getEeId() {
		return iEeId;
	}

	/**
	 * Get EE Item No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EeItemNo
	 */
	public String getEeItemNo() {
		return iEeItemNo;
	}

	/**
	 * Get ESW Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EswPrice
	 */
	public double getEswPrice() {
		return iEswPrice;
	}

	/**
	 * Get Exclusion Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ExclusionId
	 */
	public String getExclusionId() {
		return iExclusionId;
	}

	/**
	 * Get Price Id 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iPriceId
	 */
	public int getPriceId() {
		return iPriceId;
	}

	/**
	 * Get Proposal Id  
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
	 * Get Sales Document No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SalesDocNo
	 */
	public String getSalesDocNo() {
		return iSalesDocNo;
	}

	/**
	 * Get the SWO Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoId
	 */
	public int getSwoId() {
		return iSwoId;
	}

	/**
	 * set Bill Plan End Date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billPlanEndDate
	 */
	public void setBillPlanEndDate(Date billPlanEndDate) {
		iBillPlanEndDate = billPlanEndDate;
	}

	/**
	 *  set Bill Plan StartDate
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billPlanStartDate
	 */
	public void setBillPlanStartDate(Date billPlanStartDate) {
		iBillPlanStartDate = billPlanStartDate;
	}

	/**
	 * set the Currency  
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
	 * set the Customer Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		iCustomerId = customerId;
	}

	/**
	 * set DM Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmId
	 */
	public void setDmId(int dmId) {
		iDmId = dmId;
	}

	/**
	 * set EE Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeId
	 */
	public void setEeId(int eeId) {
		iEeId = eeId;
	}

	/**
	 * set EE Item No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeItemNo
	 */
	public void setEeItemNo(String eeItemNo) {
		iEeItemNo = eeItemNo;
	}

	/**
	 * set ESW Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eswPrice
	 */
	public void setEswPrice(double eswPrice) {
		iEswPrice = eswPrice;
	}

	/**
	 * set Exclusion Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param exclusionId
	 */
	public void setExclusionId(String exclusionId) {
		iExclusionId = exclusionId;
	}

	/**
	 * set Price Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceId
	 */
	public void setPriceId(int priceId) {
		iPriceId = priceId;
	}

	/**
	 * set Proposal Id  
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
	 * set Sales Doc No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesDocNo
	 */
	public void setSalesDocNo(String salesDocNo) {
		iSalesDocNo = salesDocNo;
	}

	/**
	 * set SWO Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoId
	 */
	public void setSwoId(int swoId) {
		iSwoId = swoId;
	}

	/** 
	 * Set the Billing Status 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getBillingStatus() {
		return iBillingStatus;
	}

	/** 
	 * Get the Billing Status 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingStatus 
	 */
	public void setBillingStatus(String billingStatus) {
		iBillingStatus = billingStatus;
	}

	/** 
	 * Get the Month Id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iMonthId
	 */
	public String getMonthId() {
		return iMonthId;
	}

	/** 
	 * Set the Month Id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param monthId 
	 */
	public void setMonthId(String monthId) {
		iMonthId = monthId;
	}

	/** 
	 * This method sets the indicator
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 * @author Venkat
	 */
	public String getIIndicator() {
		return iIndicator;
	}

	/** 
	 * This methos is used to set the indicator field
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 * @author Venkat
	 */
	public void setIIndicator(String string) {
		iIndicator = string;
	}

}
