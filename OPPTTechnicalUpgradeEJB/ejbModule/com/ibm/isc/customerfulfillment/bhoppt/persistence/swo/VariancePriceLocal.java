/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local interface for Enterprise Bean: VariancePrice
 */
public interface VariancePriceLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: salesDocNo
	 */
	public java.lang.String getSalesDocNo();
	/**
	 * Set accessor for persistent attribute: salesDocNo
	 */
	public void setSalesDocNo(java.lang.String newSalesDocNo);
	/**
	 * Get accessor for persistent attribute: eeItemNo
	 */
	public java.lang.String getEeItemNo();
	/**
	 * Set accessor for persistent attribute: eeItemNo
	 */
	public void setEeItemNo(java.lang.String newEeItemNo);
	/**
	 * Get accessor for persistent attribute: billPlanStartDate
	 */
	public java.sql.Date getBillPlanStartDate();
	/**
	 * Set accessor for persistent attribute: billPlanStartDate
	 */
	public void setBillPlanStartDate(java.sql.Date newBillPlanStartDate);
	/**
	 * Get accessor for persistent attribute: billPlanEndDate
	 */
	public java.sql.Date getBillPlanEndDate();
	/**
	 * Set accessor for persistent attribute: billPlanEndDate
	 */
	public void setBillPlanEndDate(java.sql.Date newBillPlanEndDate);
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public double getEswPrice();
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public void setEswPrice(double newEswPrice);
	/**
	 * Get accessor for persistent attribute: currency
	 */
	public java.lang.String getCurrency();
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public void setCurrency(java.lang.String newCurrency);
	/**
	 * Get accessor for persistent attribute: indicator
	 */
	public java.lang.String getIndicator();
	/**
	 * Set accessor for persistent attribute: indicator
	 */
	public void setIndicator(java.lang.String newIndicator);
	/**
	 * Get accessor for persistent attribute: priceId
	 */
	public int getPriceId();
	/**
	 * Set accessor for persistent attribute: priceId
	 */
	public void setPriceId(int newPriceId);
	/**
	 * Get accessor for persistent attribute: eeId
	 */
	public int getEeId();
	/**
	 * Set accessor for persistent attribute: eeId
	 */
	public void setEeId(int newEeId);
	/**
	 * Get accessor for persistent attribute: swoId
	 */
	public int getSwoId();
	/**
	 * Set accessor for persistent attribute: swoId
	 */
	public void setSwoId(int newSwoId);
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public int getDmId();
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public void setDmId(int newDmId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId);
}
