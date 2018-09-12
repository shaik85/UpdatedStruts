/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Bean implementation class for Enterprise Bean: HistoryEE
 */
public abstract class HistoryEEBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey ejbCreate(
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String eeNo)
		throws javax.ejb.CreateException {
		setEeId(eeId);
		setSwoId(swoId);
		setDmId(dmId);
		setCustomerId(customerId);
		setProposalId(proposalId);
		setEeNo(eeNo);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String eeNo)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: eeId
	 */
	public abstract int getEeId();
	/**
	 * Set accessor for persistent attribute: eeId
	 */
	public abstract void setEeId(int newEeId);
	/**
	 * Get accessor for persistent attribute: swoId
	 */
	public abstract int getSwoId();
	/**
	 * Set accessor for persistent attribute: swoId
	 */
	public abstract void setSwoId(int newSwoId);
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public abstract int getDmId();
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public abstract void setDmId(int newDmId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public abstract int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public abstract void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public abstract int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public abstract void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: salesDocNo
	 */
	public abstract java.lang.String getSalesDocNo();
	/**
	 * Set accessor for persistent attribute: salesDocNo
	 */
	public abstract void setSalesDocNo(java.lang.String newSalesDocNo);
	/**
	 * Get accessor for persistent attribute: eeItemNo
	 */
	public abstract java.lang.String getEeItemNo();
	/**
	 * Set accessor for persistent attribute: eeItemNo
	 */
	public abstract void setEeItemNo(java.lang.String newEeItemNo);
	/**
	 * Get accessor for persistent attribute: swoItemNo
	 */
	public abstract java.lang.String getSwoItemNo();
	/**
	 * Set accessor for persistent attribute: swoItemNo
	 */
	public abstract void setSwoItemNo(java.lang.String newSwoItemNo);
	/**
	 * Get accessor for persistent attribute: eeNo
	 */
	public abstract java.lang.String getEeNo();
	/**
	 * Set accessor for persistent attribute: eeNo
	 */
	public abstract void setEeNo(java.lang.String newEeNo);
	/**
	 * Get accessor for persistent attribute: eeDesc
	 */
	public abstract java.lang.String getEeDesc();
	/**
	 * Set accessor for persistent attribute: eeDesc
	 */
	public abstract void setEeDesc(java.lang.String newEeDesc);
	/**
	 * Get accessor for persistent attribute: planStartDate
	 */
	public abstract java.sql.Date getPlanStartDate();
	/**
	 * Set accessor for persistent attribute: planStartDate
	 */
	public abstract void setPlanStartDate(java.sql.Date newPlanStartDate);
	/**
	 * Get accessor for persistent attribute: planEndDate
	 */
	public abstract java.sql.Date getPlanEndDate();
	/**
	 * Set accessor for persistent attribute: planEndDate
	 */
	public abstract void setPlanEndDate(java.sql.Date newPlanEndDate);
	/**
	 * Get accessor for persistent attribute: reqstDeliveryDate
	 */
	public abstract java.sql.Date getReqstDeliveryDate();
	/**
	 * Set accessor for persistent attribute: reqstDeliveryDate
	 */
	public abstract void setReqstDeliveryDate(
		java.sql.Date newReqstDeliveryDate);
	/**
	 * Get accessor for persistent attribute: valueMetric
	 */
	public abstract java.lang.String getValueMetric();
	/**
	 * Set accessor for persistent attribute: valueMetric
	 */
	public abstract void setValueMetric(java.lang.String newValueMetric);
	/**
	 * Get accessor for persistent attribute: useLevel
	 */
	public abstract java.lang.String getUseLevel();
	/**
	 * Set accessor for persistent attribute: useLevel
	 */
	public abstract void setUseLevel(java.lang.String newUseLevel);
	/**
	 * Get accessor for persistent attribute: licenseType
	 */
	public abstract java.lang.String getLicenseType();
	/**
	 * Set accessor for persistent attribute: licenseType
	 */
	public abstract void setLicenseType(java.lang.String newLicenseType);
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public abstract double getEswPrice();
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public abstract void setEswPrice(double newEswPrice);
	/**
	 * Get accessor for persistent attribute: calculatedPrice
	 */
	public abstract double getCalculatedPrice();
	/**
	 * Set accessor for persistent attribute: calculatedPrice
	 */
	public abstract void setCalculatedPrice(double newCalculatedPrice);
	/**
	 * Get accessor for persistent attribute: alternatePrice
	 */
	public abstract double getAlternatePrice();
	/**
	 * Set accessor for persistent attribute: alternatePrice
	 */
	public abstract void setAlternatePrice(double newAlternatePrice);
	/**
	 * Get accessor for persistent attribute: billingStartDate
	 */
	public abstract java.sql.Date getBillingStartDate();
	/**
	 * Set accessor for persistent attribute: billingStartDate
	 */
	public abstract void setBillingStartDate(java.sql.Date newBillingStartDate);
	/**
	 * Get accessor for persistent attribute: billingEndDate
	 */
	public abstract java.sql.Date getBillingEndDate();
	/**
	 * Set accessor for persistent attribute: billingEndDate
	 */
	public abstract void setBillingEndDate(java.sql.Date newBillingEndDate);
	/**
	 * Get accessor for persistent attribute: exclusionId
	 */
	public abstract java.lang.String getExclusionId();
	/**
	 * Set accessor for persistent attribute: exclusionId
	 */
	public abstract void setExclusionId(java.lang.String newExclusionId);
	/**
	 * Get accessor for persistent attribute: sequenceNo
	 */
	public abstract int getSequenceNo();
	/**
	 * Set accessor for persistent attribute: sequenceNo
	 */
	public abstract void setSequenceNo(int newSequenceNo);
	/**
	 * Get accessor for persistent attribute: bumpId
	 */
	public abstract java.lang.String getBumpId();
	/**
	 * Set accessor for persistent attribute: bumpId
	 */
	public abstract void setBumpId(java.lang.String newBumpId);
	/**
	 * Get accessor for persistent attribute: chargeOptionDesc
	 */
	public abstract java.lang.String getChargeOptionDesc();
	/**
	 * Set accessor for persistent attribute: chargeOptionDesc
	 */
	public abstract void setChargeOptionDesc(
		java.lang.String newChargeOptionDesc);
	/**
	 * Get accessor for persistent attribute: alternatePriceId
	 */
	public abstract java.lang.String getAlternatePriceId();
	/**
	 * Set accessor for persistent attribute: alternatePriceId
	 */
	public abstract void setAlternatePriceId(
		java.lang.String newAlternatePriceId);
	/**
	 * Get accessor for persistent attribute: priceEffectiveDate
	 */
	public abstract java.sql.Date getPriceEffectiveDate();
	/**
	 * Set accessor for persistent attribute: priceEffectiveDate
	 */
	public abstract void setPriceEffectiveDate(
		java.sql.Date newPriceEffectiveDate);
	/**
	 * Get accessor for persistent attribute: sandsdiscountpercent
	 */
	public abstract double getSandsdiscountpercent();
	/**
	 * Set accessor for persistent attribute: sandsdiscountpercent
	 */
	public abstract void setSandsdiscountpercent(double newSandsdiscountpercent);
}
