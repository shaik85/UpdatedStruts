/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;
/**
 * Key class for Entity Bean: HistoryDM
 */
public class HistoryDMKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: dmId
	 */
	public int dmId;
	/**
	 * Implementation field for persistent attribute: customerId
	 */
	public int customerId;
	/**
	 * Implementation field for persistent attribute: proposalId
	 */
	public int proposalId;
	/**
	 * Creates an empty key for Entity Bean: HistoryDM
	 */
	public HistoryDMKey() {
	}
	/**
	 * Creates a key for Entity Bean: HistoryDM
	 */
	public HistoryDMKey(int dmId, int customerId, int proposalId) {
		this.dmId = dmId;
		this.customerId = customerId;
		this.proposalId = proposalId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey) otherKey;
			return (
				(this.dmId == o.dmId)
					&& (this.customerId == o.customerId)
					&& (this.proposalId == o.proposalId));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(dmId).hashCode())
				+ (new java.lang.Integer(customerId).hashCode())
				+ (new java.lang.Integer(proposalId).hashCode()));
	}
}
