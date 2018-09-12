/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;
/**
 * Bean implementation class for Enterprise Bean: DM
 */
public abstract class DMBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey ejbCreate(
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
	 * Get accessor for persistent attribute: dmDesc
	 */
	public abstract java.lang.String getDmDesc();
	/**
	 * Set accessor for persistent attribute: dmDesc
	 */
	public abstract void setDmDesc(java.lang.String newDmDesc);
	/**
	 * Get accessor for persistent attribute: dmNo
	 */
	public abstract java.lang.String getDmNo();
	/**
	 * Set accessor for persistent attribute: dmNo
	 */
	public abstract void setDmNo(java.lang.String newDmNo);
	/**
	 * Get accessor for persistent attribute: planStartDate
	 */
	public abstract java.sql.Date getPlanStartDate();
	/**
	 * Set accessor for persistent attribute: planStartDate
	 */
	public abstract void setPlanStartDate(java.sql.Date newPlanStartDate);
	/**
	 * Get accessor for persistent attribute: planEndDate
	 */
	public abstract java.sql.Date getPlanEndDate();
	/**
	 * Set accessor for persistent attribute: planEndDate
	 */
	public abstract void setPlanEndDate(java.sql.Date newPlanEndDate);
	/**
	 * Get accessor for persistent attribute: plannedInd
	 */
	public abstract java.lang.String getPlannedInd();
	/**
	 * Set accessor for persistent attribute: plannedInd
	 */
	public abstract void setPlannedInd(java.lang.String newPlannedInd);
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
	/**
	 * Get accessor for persistent attribute: dmAddedDate
	 */
	public abstract java.sql.Date getDmAddedDate();
	/**
	 * Set accessor for persistent attribute: dmAddedDate
	 */
	public abstract void setDmAddedDate(java.sql.Date newDmAddedDate);
	/**
	 * Get accessor for persistent attribute: exclusionID
	 */
	public abstract java.lang.String getExclusionID();
	/**
	 * Set accessor for persistent attribute: exclusionID
	 */
	public abstract void setExclusionID(java.lang.String newExclusionID);
	/**
	 * Get accessor for persistent attribute: dmCopyIncrNo
	 */
	public abstract double getDmCopyIncrNo();
	/**
	 * Set accessor for persistent attribute: dmCopyIncrNo
	 */
	public abstract void setDmCopyIncrNo(double newDmCopyIncrNo);
}
