/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: PaymentTerm
 */
public abstract class PaymentTermBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String paymentTerm)
		throws javax.ejb.CreateException {
		setPaymentTerm(paymentTerm);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String paymentTerm)
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
	 * Get accessor for persistent attribute: paymentTerm
	 */
	public abstract java.lang.String getPaymentTerm();
	/**
	 * Set accessor for persistent attribute: paymentTerm
	 */
	public abstract void setPaymentTerm(java.lang.String newPaymentTerm);
	/**
	 * Get accessor for persistent attribute: paymentTermDesc
	 */
	public abstract java.lang.String getPaymentTermDesc();
	/**
	 * Set accessor for persistent attribute: paymentTermDesc
	 */
	public abstract void setPaymentTermDesc(
		java.lang.String newPaymentTermDesc);
}
