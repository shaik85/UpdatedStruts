/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: BillingFrequency
 */
public abstract class BillingFrequencyBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String billingFreqCode)
		throws javax.ejb.CreateException {
		setBillingFreqCode(billingFreqCode);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String billingFreqCode)
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
	 * Get accessor for persistent attribute: billingFreqCode
	 */
	public abstract java.lang.String getBillingFreqCode();
	/**
	 * Set accessor for persistent attribute: billingFreqCode
	 */
	public abstract void setBillingFreqCode(
		java.lang.String newBillingFreqCode);
	/**
	 * Get accessor for persistent attribute: billingFreqDesc
	 */
	public abstract java.lang.String getBillingFreqDescription();
	/**
	 * Set accessor for persistent attribute: billingFreqDesc
	 */
	public abstract void setBillingFreqDescription(
		java.lang.String newBillingFreqDesc);
}
