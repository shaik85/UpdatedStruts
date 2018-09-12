/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: SalesOrg
 */
public abstract class SalesOrgBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String salesOrg)
		throws javax.ejb.CreateException {
		setSalesOrg(salesOrg);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String salesOrg)
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
	 * Get accessor for persistent attribute: salesOrg
	 */
	public abstract java.lang.String getSalesOrg();
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public abstract void setSalesOrg(java.lang.String newSalesOrg);
	/**
	 * Get accessor for persistent attribute: salesOrgDesc
	 */
	public abstract java.lang.String getSalesOrgDesc();
	/**
	 * Set accessor for persistent attribute: salesOrgDesc
	 */
	public abstract void setSalesOrgDesc(java.lang.String newSalesOrgDesc);
	/**
	 * Get accessor for persistent attribute: defaultCurrency
	 */
	public abstract java.lang.String getDefaultCurrency();
	/**
	 * Set accessor for persistent attribute: defaultCurrency
	 */
	public abstract void setDefaultCurrency(String newDefaultCurrency);
}
