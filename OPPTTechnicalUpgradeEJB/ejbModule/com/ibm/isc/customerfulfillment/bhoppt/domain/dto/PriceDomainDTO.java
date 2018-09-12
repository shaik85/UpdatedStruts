/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;


import java.sql.Date;


import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
/** 
 * This Domain DTOS have same attributes like PriceBDO.
 * But this DTOs are mainly used to transfer the data across service layer 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A 
 */


public class PriceDomainDTO extends OPPTDomainDTO {
	private int priceId;
	private int proposalId;
	private int customerId;
	private int dmId;
	private int swoId;
	private int eeId;
	private String salesDocNo;
	private String eeItemNo;
	private Date billPlanStartDate;
	private Date billPlanEndDate;
	private double eswPrice;
	private String currency;
	private String exclusionId;
	private String billingStatus;

	/**
	 *  
	 * Empty Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public PriceDomainDTO() {

	}
	/**
	 *  
	 * Constructor 
	 * Price Domain DTO Constructor takes the PriceBO object 
	 * Getter and setter methods act on the constructor itself 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param priceBO
	 */
	public PriceDomainDTO(PriceBO priceBO) {
		priceId = priceBO.getPriceId();
		proposalId = priceBO.getProposalId();
		customerId = priceBO.getCustomerId();
		dmId = priceBO.getDmId();
		swoId = priceBO.getSwoId();
		eeId = priceBO.getEeId();
		salesDocNo = priceBO.getSalesDocNo();
		eeItemNo = priceBO.getEeItemNo();
		billPlanStartDate = priceBO.getBillPlanStartDate();
		billPlanEndDate = priceBO.getBillPlanEndDate();
		eswPrice = priceBO.getEswPrice();
		currency = priceBO.getCurrency();
		exclusionId = priceBO.getExclusionId();
		billingStatus = priceBO.getBillingStatus();
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
		return billPlanEndDate;
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
		return billPlanStartDate;
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
		return currency;
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
		return customerId;
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
		return dmId;
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
		return eeId;
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
		return eeItemNo;
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
		return eswPrice;
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
		return exclusionId;
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
	 * @return
	 */
	public int getPriceId() {
		return priceId;
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
		return proposalId;
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
		return salesDocNo;
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
		return swoId;
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
	public void setBillPlanEndDate(Date iBillPlanEndDate) {
		billPlanEndDate = iBillPlanEndDate;
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
	public void setBillPlanStartDate(Date iBillPlanStartDate) {
		billPlanStartDate = iBillPlanStartDate;
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
	public void setCurrency(String iCurrency) {
		currency = iCurrency;
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
	public void setCustomerId(int iCustomerId) {
		customerId = iCustomerId;
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
	public void setDmId(int iDmId) {
		dmId = iDmId;
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
	public void setEeId(int iEeId) {
		eeId = iEeId;
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
	public void setEeItemNo(String iEeItemNo) {
		eeItemNo = iEeItemNo;
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
	public void setEswPrice(double iEswPrice) {
		eswPrice = iEswPrice;
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
	public void setExclusionId(String iExclusionId) {
		exclusionId = iExclusionId;
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
	public void setPriceId(int iPriceId) {
		priceId = iPriceId;
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
	public void setProposalId(int iProposalId) {
		proposalId = iProposalId;
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
	public void setSalesDocNo(String iSalesDocNo) {
		salesDocNo = iSalesDocNo;
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
	public void setSwoId(int iSwoId) {
		swoId = iSwoId;
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
		return billingStatus;
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
	 * @param string 
	 */
	public void setBillingStatus(String iBillingStatus) {
		billingStatus = iBillingStatus;
	}
	/**
	 * Added for BatchUpdate
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @author balajiv
	 */
	public String getSQL() {

		StringBuffer bufferSQL = new StringBuffer();
		OPPTCalender cal = new OPPTCalender();

		bufferSQL.append(
			"INSERT INTO BH.PRICE (PRICE_ID,PROPOSAL_ID,SOLD_TO_PARTY_ID,DESG_MACHINE_ID,SWO_ID,SWOEE_ID,SALES_DOC_NO,EE_ITEM_NO,BILL_PLAN_ST_DATE,BILL_PLAN_END_DATE,ESW_PRICE,CURRENCY,EXCLUSION_ID,BILLING_STATUS) VALUES (");
		bufferSQL.append(getPriceId());
		bufferSQL.append(",");
		bufferSQL.append(getProposalId());
		bufferSQL.append(",");
		bufferSQL.append(getCustomerId());
		bufferSQL.append(",");
		bufferSQL.append(getDmId());
		bufferSQL.append(",");
		bufferSQL.append(getSwoId());
		bufferSQL.append(",");
		bufferSQL.append(getEeId());
		bufferSQL.append(",'");
		bufferSQL.append(getSalesDocNo());
		bufferSQL.append("','");
		bufferSQL.append(getEeItemNo());
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getBillPlanStartDate()));
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getBillPlanEndDate()));
		bufferSQL.append("',");
		bufferSQL.append(getEswPrice());
		bufferSQL.append(",'");
		bufferSQL.append(getCurrency());
		bufferSQL.append("','");
		bufferSQL.append(getExclusionId());
		bufferSQL.append("','");
		bufferSQL.append(getBillingStatus());
		bufferSQL.append("' )");

		return formatSQL(bufferSQL.toString());
	}

}
