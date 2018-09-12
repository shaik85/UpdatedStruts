/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: UserType
 */
public abstract class UserTypeBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String userType)
		throws javax.ejb.CreateException {
		setUserType(userType);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String userType)
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
	 * Get accessor for persistent attribute: userType
	 */
	public abstract java.lang.String getUserType();
	/**
	 * Set accessor for persistent attribute: userType
	 */
	public abstract void setUserType(java.lang.String newUserType);
	/**
	 * Get accessor for persistent attribute: userTypeDescription
	 */
	public abstract java.lang.String getUserTypeDescription();
	/**
	 * Set accessor for persistent attribute: userTypeDescription
	 */
	public abstract void setUserTypeDescription(
		java.lang.String newUserTypeDescription);
}
