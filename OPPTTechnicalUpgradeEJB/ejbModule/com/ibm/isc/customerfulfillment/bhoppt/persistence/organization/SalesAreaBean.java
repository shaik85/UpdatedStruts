/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: SalesArea
 */
public abstract class SalesAreaBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.SalesAreaKey ejbCreate(
		java.lang.String salesOrg,
		java.lang.String divisionCode,
		java.lang.String distributionChannelCode)
		throws javax.ejb.CreateException {
		setSalesOrg(salesOrg);
		setDivisionCode(divisionCode);
		setDistributionChannelCode(distributionChannelCode);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String salesOrg,
		java.lang.String divisionCode,
		java.lang.String distributionChannelCode)
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
	 * Get accessor for persistent attribute: divisionCode
	 */
	public abstract java.lang.String getDivisionCode();
	/**
	 * Set accessor for persistent attribute: divisionCode
	 */
	public abstract void setDivisionCode(java.lang.String newDivisionCode);
	/**
	 * Get accessor for persistent attribute: distributionChannelCode
	 */
	public abstract java.lang.String getDistributionChannelCode();
	/**
	 * Set accessor for persistent attribute: distributionChannelCode
	 */
	public abstract void setDistributionChannelCode(
		java.lang.String newDistributionChannelCode);
}
