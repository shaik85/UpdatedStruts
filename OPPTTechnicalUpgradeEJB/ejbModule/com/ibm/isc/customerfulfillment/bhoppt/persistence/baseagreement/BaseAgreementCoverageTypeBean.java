/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: BaseAgreementCoverageType
 */
public abstract class BaseAgreementCoverageTypeBean
	implements
		javax.ejb.EntityBean {
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
	 * @param coverageType
	 * @return BaseAgreementCoverageTypeKey
	 * @throws CreateException
	 * 
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey ejbCreate(
		java.lang.String coverageType) throws javax.ejb.CreateException {
		setCoverageType(coverageType);
		return null;
	}
	/**
	 * ejbPostCreate
	 * @param coverageType
	 */
	public void ejbPostCreate(java.lang.String coverageType)
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
	 * Get accessor for persistent attribute: coverageType
	 * @return String
	 */
	public abstract java.lang.String getCoverageType();
	/**
	 * Set accessor for persistent attribute: coverageType
	 * @param newCoverageType
	 */
	public abstract void setCoverageType(java.lang.String newCoverageType);
	/**
	 * Get accessor for persistent attribute: coverageTypeDescription
	 * @return String
	 */
	public abstract java.lang.String getCoverageTypeDescription();
	/**
	 * Set accessor for persistent attribute: coverageTypeDescription
	 * @param newCoverageTypeDescription
	 */
	public abstract void setCoverageTypeDescription(
		java.lang.String newCoverageTypeDescription);
}
