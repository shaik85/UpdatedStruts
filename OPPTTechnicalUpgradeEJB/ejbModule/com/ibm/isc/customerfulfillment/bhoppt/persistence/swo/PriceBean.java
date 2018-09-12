/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Bean implementation class for Enterprise Bean: Price
 */
public abstract class PriceBean implements javax.ejb.EntityBean {
	
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey ejbCreate(
		int priceId,
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId)
		throws javax.ejb.CreateException {
		setPriceId(priceId);
		setEeId(eeId);
		setSwoId(swoId);
		setDmId(dmId);
		setCustomerId(customerId);
		setProposalId(proposalId);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		int priceId,
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId)
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
	 * Get accessor for persistent attribute: priceId
	 */
	public abstract int getPriceId();
	/**
	 * Set accessor for persistent attribute: priceId
	 */
	public abstract void setPriceId(int newPriceId);
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
	 * Get accessor for persistent attribute: billPlanStartDate
	 */
	public abstract java.sql.Date getBillPlanStartDate();
	/**
	 * Set accessor for persistent attribute: billPlanStartDate
	 */
	public abstract void setBillPlanStartDate(
		java.sql.Date newBillPlanStartDate);
	/**
	 * Get accessor for persistent attribute: billPlanEndDate
	 */
	public abstract java.sql.Date getBillPlanEndDate();
	/**
	 * Set accessor for persistent attribute: billPlanEndDate
	 */
	public abstract void setBillPlanEndDate(java.sql.Date newBillPlanEndDate);
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public abstract double getEswPrice();
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public abstract void setEswPrice(double newEswPrice);
	/**
	 * Get accessor for persistent attribute: currency
	 */
	public abstract java.lang.String getCurrency();
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public abstract void setCurrency(java.lang.String newCurrency);
	/**
	 * Get accessor for persistent attribute: exclusionId
	 */
	public abstract java.lang.String getExclusionId();
	/**
	 * Set accessor for persistent attribute: exclusionId
	 */
	public abstract void setExclusionId(java.lang.String newExclusionId);
	/**
	 * Get accessor for persistent attribute: billingStatus
	 */
	public abstract java.lang.String getBillingStatus();
	/**
	 * Set accessor for persistent attribute: billingStatus
	 */
	public abstract void setBillingStatus(java.lang.String newBillingStatus);
	/**
	 * Get accessor for persistent attribute: monthId
	 */
	public abstract java.lang.String getMonthId();
	/**
	 * Set accessor for persistent attribute: monthId
	 */
	public abstract void setMonthId(java.lang.String newMonthId);
}
