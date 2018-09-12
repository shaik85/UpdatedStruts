/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Bean implementation class for Enterprise Bean: AccessHistory
 */
public abstract class AccessHistoryBean implements javax.ejb.EntityBean
{
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx)
	{
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext()
	{
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext()
	{
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey ejbCreate(
		int proposalId,
		java.lang.String userId,
		java.sql.Date accessDate,
		java.sql.Time accessTime,
		int sequenceNo)
		throws javax.ejb.CreateException
	{
		setProposalId(proposalId);
		setUserId(userId);
		setAccessDate(accessDate);
		setAccessTime(accessTime);
		setSeqNo(sequenceNo);
		return null;
	}
	
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		int proposalId,
		java.lang.String userId,
		java.sql.Date accessDate,
		java.sql.Time accessTime,
		int sequenceNo)
		throws javax.ejb.CreateException
	{
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate()
	{
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad()
	{
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate()
	{
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException
	{
	}
	/**
	 * ejbStore
	 */
	public void ejbStore()
	{
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
	 * Get accessor for persistent attribute: userId
	 */
	public abstract java.lang.String getUserId();
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public abstract void setUserId(java.lang.String newUserId);
	/**
	 * Get accessor for persistent attribute: operationPerformed
	 */
	public abstract java.lang.String getOperationPerformed();
	/**
	 * Set accessor for persistent attribute: operationPerformed
	 */
	public abstract void setOperationPerformed(java.lang.String newOperationPerformed);
	/**
	 * Get accessor for persistent attribute: accessDate
	 */
	public abstract java.sql.Date getAccessDate();
	/**
	 * Set accessor for persistent attribute: accessDate
	 */
	public abstract void setAccessDate(java.sql.Date newAccessDate);
	/**
	 * Get accessor for persistent attribute: accessTime
	 */
	public abstract java.sql.Time getAccessTime();
	/**
	 * Set accessor for persistent attribute: accessTime
	 */
	public abstract void setAccessTime(java.sql.Time newAccessTime);
	/**
	 * Get accessor for persistent attribute: seqNo
	 */
	public abstract int getSeqNo();
	/**
	 * Set accessor for persistent attribute: seqNo
	 */
	public abstract void setSeqNo(int newSeqNo);
}