/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local Home interface for Enterprise Bean: AccessHistory
 */
public interface AccessHistoryLocalHome extends javax.ejb.EJBLocalHome
{
	/**
	 * Creates an instance from a key for Entity Bean: AccessHistory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal create(
		int proposalId,
		java.lang.String userId,
		java.sql.Date accessDate,
		java.sql.Time accessTime,
		int sequenceNo)
		throws javax.ejb.CreateException;
	
	/**
	 * Finds an instance using a key for Entity Bean: AccessHistory
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey primaryKey)
		throws javax.ejb.FinderException;

	public java.util.Collection findByProposalIDAndUserID(int proposalId, java.lang.String userId)
		throws javax.ejb.FinderException;

	public java.util.Collection findByProposalID(int proposalID) throws javax.ejb.FinderException;
}