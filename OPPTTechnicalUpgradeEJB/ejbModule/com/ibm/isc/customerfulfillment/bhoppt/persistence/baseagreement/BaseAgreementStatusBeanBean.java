/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: BaseAgreementStatusBean
 */
public abstract class BaseAgreementStatusBeanBean
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
	 * @param statusCode
	 * @return BaseAgreementStatusBeanKey
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusBeanKey ejbCreate(
		java.lang.String statusCode) throws javax.ejb.CreateException {
		setStatusCode(statusCode);
		return null;
	}
	/**
	 * ejbPostCreate
	 * @param statusCode
	 */
	public void ejbPostCreate(java.lang.String statusCode)
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
	 * Get accessor for persistent attribute: statusCode
	 * @return String
	 */
	public abstract java.lang.String getStatusCode();
	/**
	 * Set accessor for persistent attribute: statusCode
	 * @param newStatusCode
	 */
	public abstract void setStatusCode(java.lang.String newStatusCode);
	/**
	 * Get accessor for persistent attribute: statusDescription
	 * @return String
	 */
	public abstract java.lang.String getStatusDescription();
	/**
	 * Set accessor for persistent attribute: statusDescription
	 * @param newStatusDescription
	 */
	public abstract void setStatusDescription(
		java.lang.String newStatusDescription);
}
