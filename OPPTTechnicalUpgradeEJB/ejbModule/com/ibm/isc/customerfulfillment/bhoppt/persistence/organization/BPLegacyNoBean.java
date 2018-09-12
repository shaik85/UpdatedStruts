/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Bean implementation class for Enterprise Bean: BPLegacyNo
 */
public abstract class BPLegacyNoBean implements javax.ejb.EntityBean {
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
		.BPLegacyNoKey ejbCreate(
		java.lang.String userId,
		java.lang.String legacyNo,
		java.lang.String addressSeqNo)
		throws javax.ejb.CreateException {
		setUserId(userId);
		setLegacyNo(legacyNo);
		setAddressSeqNo(addressSeqNo);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String userId,
		java.lang.String legacyNo,
		java.lang.String addressSeqNo)
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
	 * Get accessor for persistent attribute: userId
	 */
	public abstract java.lang.String getUserId();
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public abstract void setUserId(java.lang.String newUserId);
	/**
	 * Get accessor for persistent attribute: legacyNo
	 */
	public abstract java.lang.String getLegacyNo();
	/**
	 * Set accessor for persistent attribute: legacyNo
	 */
	public abstract void setLegacyNo(java.lang.String newLegacyNo);
	/**
	 * Get accessor for persistent attribute: addressSeqNo
	 */
	public abstract java.lang.String getAddressSeqNo();
	/**
	 * Set accessor for persistent attribute: addressSeqNo
	 */
	public abstract void setAddressSeqNo(java.lang.String newAddressSeqNo);
	/**
	 * Get accessor for persistent attribute: customerName
	 */
	public abstract java.lang.String getCustomerName();
	/**
	 * Set accessor for persistent attribute: customerName
	 */
	public abstract void setCustomerName(java.lang.String newCustomerName);
}
