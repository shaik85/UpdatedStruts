/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: Currency
 */
public abstract class CurrencyBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String currency)
		throws javax.ejb.CreateException {
		setCurrency(currency);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String currency)
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
	 * Get accessor for persistent attribute: currency
	 */
	public abstract java.lang.String getCurrency();
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public abstract void setCurrency(java.lang.String newCurrency);
	/**
	 * Get accessor for persistent attribute: currencyDesc
	 */
	public abstract java.lang.String getCurrencyDesc();
	/**
	 * Set accessor for persistent attribute: currencyDesc
	 */
	public abstract void setCurrencyDesc(java.lang.String newCurrencyDesc);
	/**
	 * Get accessor for persistent attribute: decimalsAllowed
	 */
	public abstract java.lang.Integer getDecimalsAllowed();
	/**
	 * Set accessor for persistent attribute: decimalsAllowed
	 */
	public abstract void setDecimalsAllowed(
		java.lang.Integer newDecimalsAllowed);
}
