/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local interface for Enterprise Bean: HistoryEE
 */
public interface HistoryEELocal extends javax.ejb.EJBLocalObject {
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
	 * Get accessor for persistent attribute: swoItemNo
	 */
	public java.lang.String getSwoItemNo();
	/**
	 * Set accessor for persistent attribute: swoItemNo
	 */
	public void setSwoItemNo(java.lang.String newSwoItemNo);
	/**
	 * Get accessor for persistent attribute: eeNo
	 */
	public java.lang.String getEeNo();
	/**
	 * Set accessor for persistent attribute: eeNo
	 */
	public void setEeNo(java.lang.String newEeNo);
	/**
	 * Get accessor for persistent attribute: eeDesc
	 */
	public java.lang.String getEeDesc();
	/**
	 * Set accessor for persistent attribute: eeDesc
	 */
	public void setEeDesc(java.lang.String newEeDesc);
	/**
	 * Get accessor for persistent attribute: planStartDate
	 */
	public java.sql.Date getPlanStartDate();
	/**
	 * Set accessor for persistent attribute: planStartDate
	 */
	public void setPlanStartDate(java.sql.Date newPlanStartDate);
	/**
	 * Get accessor for persistent attribute: planEndDate
	 */
	public java.sql.Date getPlanEndDate();
	/**
	 * Set accessor for persistent attribute: planEndDate
	 */
	public void setPlanEndDate(java.sql.Date newPlanEndDate);
	/**
	 * Get accessor for persistent attribute: reqstDeliveryDate
	 */
	public java.sql.Date getReqstDeliveryDate();
	/**
	 * Set accessor for persistent attribute: reqstDeliveryDate
	 */
	public void setReqstDeliveryDate(java.sql.Date newReqstDeliveryDate);
	/**
	 * Get accessor for persistent attribute: valueMetric
	 */
	public java.lang.String getValueMetric();
	/**
	 * Set accessor for persistent attribute: valueMetric
	 */
	public void setValueMetric(java.lang.String newValueMetric);
	/**
	 * Get accessor for persistent attribute: useLevel
	 */
	public java.lang.String getUseLevel();
	/**
	 * Set accessor for persistent attribute: useLevel
	 */
	public void setUseLevel(java.lang.String newUseLevel);
	/**
	 * Get accessor for persistent attribute: licenseType
	 */
	public java.lang.String getLicenseType();
	/**
	 * Set accessor for persistent attribute: licenseType
	 */
	public void setLicenseType(java.lang.String newLicenseType);
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public double getEswPrice();
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public void setEswPrice(double newEswPrice);
	/**
	 * Get accessor for persistent attribute: calculatedPrice
	 */
	public double getCalculatedPrice();
	/**
	 * Set accessor for persistent attribute: calculatedPrice
	 */
	public void setCalculatedPrice(double newCalculatedPrice);
	/**
	 * Get accessor for persistent attribute: alternatePrice
	 */
	public double getAlternatePrice();
	/**
	 * Set accessor for persistent attribute: alternatePrice
	 */
	public void setAlternatePrice(double newAlternatePrice);
	/**
	 * Get accessor for persistent attribute: billingStartDate
	 */
	public java.sql.Date getBillingStartDate();
	/**
	 * Set accessor for persistent attribute: billingStartDate
	 */
	public void setBillingStartDate(java.sql.Date newBillingStartDate);
	/**
	 * Get accessor for persistent attribute: billingEndDate
	 */
	public java.sql.Date getBillingEndDate();
	/**
	 * Set accessor for persistent attribute: billingEndDate
	 */
	public void setBillingEndDate(java.sql.Date newBillingEndDate);
	/**
	 * Get accessor for persistent attribute: exclusionId
	 */
	public java.lang.String getExclusionId();
	/**
	 * Set accessor for persistent attribute: exclusionId
	 */
	public void setExclusionId(java.lang.String newExclusionId);
	/**
	 * Get accessor for persistent attribute: sequenceNo
	 */
	public int getSequenceNo();
	/**
	 * Set accessor for persistent attribute: sequenceNo
	 */
	public void setSequenceNo(int newSequenceNo);
	/**
	 * Get accessor for persistent attribute: bumpId
	 */
	public java.lang.String getBumpId();
	/**
	 * Set accessor for persistent attribute: bumpId
	 */
	public void setBumpId(java.lang.String newBumpId);
	/**
	 * Get accessor for persistent attribute: chargeOptionDesc
	 */
	public java.lang.String getChargeOptionDesc();
	/**
	 * Set accessor for persistent attribute: chargeOptionDesc
	 */
	public void setChargeOptionDesc(java.lang.String newChargeOptionDesc);
	/**
	 * Get accessor for persistent attribute: alternatePriceId
	 */
	public java.lang.String getAlternatePriceId();
	/**
	 * Set accessor for persistent attribute: alternatePriceId
	 */
	public void setAlternatePriceId(java.lang.String newAlternatePriceId);
	/**
	 * Get accessor for persistent attribute: priceEffectiveDate
	 */
	public java.sql.Date getPriceEffectiveDate();
	/**
	 * Set accessor for persistent attribute: priceEffectiveDate
	 */
	public void setPriceEffectiveDate(java.sql.Date newPriceEffectiveDate);
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
	/**
	 * Get accessor for persistent attribute: sandsdiscountpercent
	 */
	public double getSandsdiscountpercent();
	/**
	 * Set accessor for persistent attribute: sandsdiscountpercent
	 */
	public void setSandsdiscountpercent(double newSandsdiscountpercent);
}
