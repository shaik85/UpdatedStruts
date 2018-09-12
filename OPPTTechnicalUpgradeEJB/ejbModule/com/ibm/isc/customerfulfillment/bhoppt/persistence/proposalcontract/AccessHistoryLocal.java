/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local interface for Enterprise Bean: AccessHistory
 */
public interface AccessHistoryLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: operationPerformed
	 */
	public java.lang.String getOperationPerformed();
	/**
	 * Set accessor for persistent attribute: operationPerformed
	 */
	public void setOperationPerformed(java.lang.String newOperationPerformed);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: userId
	 */
	public java.lang.String getUserId();
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public void setUserId(java.lang.String newUserId);
	/**
	 * Get accessor for persistent attribute: accessDate
	 */
	public java.sql.Date getAccessDate();
	/**
	 * Set accessor for persistent attribute: accessDate
	 */
	public void setAccessDate(java.sql.Date newAccessDate);
	/**
	 * Get accessor for persistent attribute: accessTime
	 */
	public java.sql.Time getAccessTime();
	/**
	 * Set accessor for persistent attribute: accessTime
	 */
	public void setAccessTime(java.sql.Time newAccessTime);
	/**
	 * Get accessor for persistent attribute: seqNo
	 */
	public int getSeqNo();
	/**
	 * Set accessor for persistent attribute: seqNo
	 */
	public void setSeqNo(int newSeqNo);
}
