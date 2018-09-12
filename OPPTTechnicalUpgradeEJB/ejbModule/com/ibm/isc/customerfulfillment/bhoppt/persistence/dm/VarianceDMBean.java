/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;
/**
 * Bean implementation class for Enterprise Bean: VarianceDM
 */
public abstract class VarianceDMBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey ejbCreate(
		int dmId,
		int customerId,
		int proposalId,String dmNo)
		throws javax.ejb.CreateException {
		setDmId(dmId);
		setCustomerId(customerId);
		setProposalId(proposalId);
		setDmNo(dmNo);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int dmId, int customerId, int proposalId,String dmNo)
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
	 * Get accessor for persistent attribute: dmId
	 */
	public abstract int getDmId();
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public abstract void setDmId(int newDmId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public abstract int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public abstract void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public abstract int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public abstract void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: dmNo
	 */
	public abstract java.lang.String getDmNo();
	/**
	 * Set accessor for persistent attribute: dmNo
	 */
	public abstract void setDmNo(java.lang.String newDmNo);
	/**
	 * Get accessor for persistent attribute: dmDesc
	 */
	public abstract java.lang.String getDmDesc();
	/**
	 * Set accessor for persistent attribute: dmDesc
	 */
	public abstract void setDmDesc(java.lang.String newDmDesc);
}
