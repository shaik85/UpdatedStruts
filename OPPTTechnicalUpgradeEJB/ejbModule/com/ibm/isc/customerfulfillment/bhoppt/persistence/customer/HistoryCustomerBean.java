/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;
/**
 * Bean implementation class for Enterprise Bean: HistoryCustomer
 */
public abstract class HistoryCustomerBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer
		.HistoryCustomerKey ejbCreate(
		int customerId,
		int proposalId)
		throws javax.ejb.CreateException {
		setCustomerId(customerId);
		setProposalId(proposalId);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int customerId, int proposalId)
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
	 * Get accessor for persistent attribute: customerListNo
	 */
	public abstract java.lang.String getCustomerListNo();
	/**
	 * Set accessor for persistent attribute: customerListNo
	 */
	public abstract void setCustomerListNo(java.lang.String newCustomerListNo);
	/**
	 * Get accessor for persistent attribute: legacyCustomerNo
	 */
	public abstract java.lang.String getLegacyCustomerNo();
	/**
	 * Set accessor for persistent attribute: legacyCustomerNo
	 */
	public abstract void setLegacyCustomerNo(
		java.lang.String newLegacyCustomerNo);
	/**
	 * Get accessor for persistent attribute: sapCustomerNo
	 */
	public abstract java.lang.String getSapCustomerNo();
	/**
	 * Set accessor for persistent attribute: sapCustomerNo
	 */
	public abstract void setSapCustomerNo(java.lang.String newSapCustomerNo);
	/**
	 * Get accessor for persistent attribute: sapCustomerName
	 */
	public abstract java.lang.String getSapCustomerName();
	/**
	 * Set accessor for persistent attribute: sapCustomerName
	 */
	public abstract void setSapCustomerName(
		java.lang.String newSapCustomerName);
	/**
	 * Get accessor for persistent attribute: billToPartyNo
	 */
	public abstract java.lang.String getBillToPartyNo();
	/**
	 * Set accessor for persistent attribute: billToPartyNo
	 */
	public abstract void setBillToPartyNo(java.lang.String newBillToPartyNo);
	/**
	 * Get accessor for persistent attribute: billToPartyName
	 */
	public abstract java.lang.String getBillToPartyName();
	/**
	 * Set accessor for persistent attribute: billToPartyName
	 */
	public abstract void setBillToPartyName(
		java.lang.String newBillToPartyName);
	/**
	 * Get accessor for persistent attribute: payerNo
	 */
	public abstract java.lang.String getPayerNo();
	/**
	 * Set accessor for persistent attribute: payerNo
	 */
	public abstract void setPayerNo(java.lang.String newPayerNo);
	/**
	 * Get accessor for persistent attribute: payerName
	 */
	public abstract java.lang.String getPayerName();
	/**
	 * Set accessor for persistent attribute: payerName
	 */
	public abstract void setPayerName(java.lang.String newPayerName);
	/**
	 * Get accessor for persistent attribute: shipToPartyNo
	 */
	public abstract java.lang.String getShipToPartyNo();
	/**
	 * Set accessor for persistent attribute: shipToPartyNo
	 */
	public abstract void setShipToPartyNo(java.lang.String newShipToPartyNo);
	/**
	 * Get accessor for persistent attribute: shipToPartyName
	 */
	public abstract java.lang.String getShipToPartyName();
	/**
	 * Set accessor for persistent attribute: shipToPartyName
	 */
	public abstract void setShipToPartyName(
		java.lang.String newShipToPartyName);
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
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
	/**
	 * Get accessor for persistent attribute: payerLNo
	 */
	public abstract java.lang.String getPayerLNo();
	/**
	 * Set accessor for persistent attribute: payerLNo
	 */
	public abstract void setPayerLNo(java.lang.String newPayerLNo);
	/**
	 * Get accessor for persistent attribute: billToPartyLNo
	 */
	public abstract java.lang.String getBillToPartyLNo();
	/**
	 * Set accessor for persistent attribute: billToPartyLNo
	 */
	public abstract void setBillToPartyLNo(java.lang.String newBillToPartyLNo);
	/**
	 * Get accessor for persistent attribute: shipToPartyLNo
	 */
	public abstract java.lang.String getShipToPartyLNo();
	/**
	 * Set accessor for persistent attribute: shipToPartyLNo
	 */
	public abstract void setShipToPartyLNo(java.lang.String newShipToPartyLNo);
	/**
	 * Get accessor for persistent attribute: customerASNo
	 */
	public abstract java.lang.String getCustomerASNo();
	/**
	 * Set accessor for persistent attribute: customerASNo
	 */
	public abstract void setCustomerASNo(java.lang.String newCustomerASNo);
	/**
	 * Get accessor for persistent attribute: billToPartyASNo
	 */
	public abstract java.lang.String getBillToPartyASNo();
	/**
	 * Set accessor for persistent attribute: billToPartyASNo
	 */
	public abstract void setBillToPartyASNo(
		java.lang.String newBillToPartyASNo);
	/**
	 * Get accessor for persistent attribute: shipToPartyASNo
	 */
	public abstract java.lang.String getShipToPartyASNo();
	/**
	 * Set accessor for persistent attribute: shipToPartyASNo
	 */
	public abstract void setShipToPartyASNo(
		java.lang.String newShipToPartyASNo);
	/**
	 * Get accessor for persistent attribute: payerASNo
	 */
	public abstract java.lang.String getPayerASNo();
	/**
	 * Set accessor for persistent attribute: payerASNo
	 */
	public abstract void setPayerASNo(java.lang.String newPayerASNo);
}
