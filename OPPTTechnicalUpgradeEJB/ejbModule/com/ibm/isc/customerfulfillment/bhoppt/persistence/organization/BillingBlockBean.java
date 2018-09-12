/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: BillingBlock
 */
public abstract class BillingBlockBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String billingBlock)
		throws javax.ejb.CreateException {
		setBillingBlock(billingBlock);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String billingBlock)
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
	 * Get accessor for persistent attribute: billingBlock
	 */
	public abstract java.lang.String getBillingBlock();
	/**
	 * Set accessor for persistent attribute: billingBlock
	 */
	public abstract void setBillingBlock(java.lang.String newBillingBlock);
	/**
	 * Get accessor for persistent attribute: billingBlockDesc
	 */
	public abstract java.lang.String getBillingBlockDescription();
	/**
	 * Set accessor for persistent attribute: billingBlockDesc
	 */
	public abstract void setBillingBlockDescription(
		java.lang.String newBillingBlockDesc);
}
