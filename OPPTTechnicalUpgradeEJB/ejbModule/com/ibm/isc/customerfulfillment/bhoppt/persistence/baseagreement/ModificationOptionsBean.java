/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: ModificationOptions
 */
public abstract class ModificationOptionsBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey ejbCreate(
		java.lang.String modificationTypeCode,
		java.lang.String modificationOption) throws javax.ejb.CreateException {
		setModificationTypeCode(modificationTypeCode);
		setModificationOption(modificationOption);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String modificationTypeCode,
		java.lang.String modificationOption) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: modificationTypeCode
	 */
	public abstract java.lang.String getModificationTypeCode();
	/**
	 * Set accessor for persistent attribute: modificationTypeCode
	 */
	public abstract void setModificationTypeCode(
		java.lang.String newModificationTypeCode);
	/**
	 * Get accessor for persistent attribute: modificationOption
	 */
	public abstract java.lang.String getModificationOption();
	/**
	 * Set accessor for persistent attribute: modificationOption
	 */
	public abstract void setModificationOption(
		java.lang.String newModificationOption);
	/**
	 * Get accessor for persistent attribute: modificationOptionDescription
	 */
	public abstract java.lang.String getModificationOptionDescription();
	/**
	 * Set accessor for persistent attribute: modificationOptionDescription
	 */
	public abstract void setModificationOptionDescription(
		java.lang.String newModificationOptionDescription);
}
