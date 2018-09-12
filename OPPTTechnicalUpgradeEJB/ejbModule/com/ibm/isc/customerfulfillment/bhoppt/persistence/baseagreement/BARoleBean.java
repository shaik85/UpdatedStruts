/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: BARole
 */
public abstract class BARoleBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 * @param ctx
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 * @return EntityContext
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
	 * @param baseAgreementRole
	 * @return String
	 * @throws CreateException
	 */
	public java.lang.String ejbCreate(java.lang.String baseAgreementRole)
		throws javax.ejb.CreateException {
		setBaseAgreementRole(baseAgreementRole);
		return null;
	}
	/**
	 * ejbPostCreate
	 * @param baseAgreementRole
	 * @throws CreateException
	 */
	public void ejbPostCreate(java.lang.String baseAgreementRole)
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
	 * @throws RemoveException
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: baseAgreementRole
	 * @return String
	 */
	public abstract java.lang.String getBaseAgreementRole();
	/**
	 * Set accessor for persistent attribute: baseAgreementRole
	 * @param newBaseAgreementRole
	 */
	public abstract void setBaseAgreementRole(
		java.lang.String newBaseAgreementRole);
	/**
	 * Get accessor for persistent attribute: baseAgreementRoleDescription
	 * @return String
	 */
	public abstract java.lang.String getBaseAgreementRoleDescription();
	/**
	 * Set accessor for persistent attribute: baseAgreementRoleDescription
	 * @param newBaseAgreementRoleDescription
	 */
	public abstract void setBaseAgreementRoleDescription(
		java.lang.String newBaseAgreementRoleDescription);
}
