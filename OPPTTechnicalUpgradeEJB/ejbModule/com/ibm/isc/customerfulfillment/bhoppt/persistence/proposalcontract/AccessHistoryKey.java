/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Key class for Entity Bean: AccessHistory
 */
public class AccessHistoryKey implements java.io.Serializable
{
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: proposalId
	 */
	public int proposalId;
	/**
	 * Implementation field for persistent attribute: userId
	 */
	public java.lang.String userId;
	/**
	 * Implementation field for persistent attribute: accessDate
	 */
	public java.sql.Date accessDate;
	/**
	 * Implementation field for persistent attribute: accessTime
	 */
	public java.sql.Time accessTime;
	/**
	 * Implementation field for persistent attribute: seqNo
	 */
	public int seqNo;
	/**
	 * Creates an empty key for Entity Bean: AccessHistory
	 */
	public AccessHistoryKey()
	{
	}
	/**
	 * Creates a key for Entity Bean: AccessHistory
	 */
	public AccessHistoryKey(
		int proposalId,
		java.lang.String userId,
		java.sql.Date accessDate,
		java.sql.Time accessTime,
		int seqNo)
	{
		this.proposalId = proposalId;
		this.userId = userId;
		this.accessDate = accessDate;
		this.accessTime = accessTime;
		this.seqNo = seqNo;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey)
	{
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey)
		{
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey) otherKey;
			return (
				(proposalId == o.proposalId)
					&& (userId.equals(o.userId))
					&& (accessDate.equals(o.accessDate))
					&& (accessTime.equals(o.accessTime))
					&& (seqNo == o.seqNo));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode()
	{
		return (
			(new java.lang.Integer(proposalId).hashCode())
				+ userId.hashCode()
				+ accessDate.hashCode()
				+ accessTime.hashCode()
				+ (new java.lang.Integer(seqNo).hashCode()));
	}
}