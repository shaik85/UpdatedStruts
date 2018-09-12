/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Bean implementation class for Enterprise Bean: Sharing
 */
public abstract class SharingBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract
		.SharingKey ejbCreate(
		int proposalId,
		java.lang.String accessTo)
		throws javax.ejb.CreateException {
		setProposalId(proposalId);
		setAccessTo(accessTo);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId, java.lang.String accessTo)
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
	 * Get accessor for persistent attribute: proposalId
	 */
	public abstract int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public abstract void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: accessTo
	 */
	public abstract java.lang.String getAccessTo();
	/**
	 * Set accessor for persistent attribute: accessTo
	 */
	public abstract void setAccessTo(java.lang.String newAccessTo);
	/**
	 * Get accessor for persistent attribute: accessType
	 */
	public abstract java.lang.String getAccessType();
	/**
	 * Set accessor for persistent attribute: accessType
	 */
	public abstract void setAccessType(java.lang.String newAccessType);
}
