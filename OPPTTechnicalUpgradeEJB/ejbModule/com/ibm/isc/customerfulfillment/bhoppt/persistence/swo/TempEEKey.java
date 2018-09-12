/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Key class for Entity Bean: TempEE
 */
public class TempEEKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: proposalId
	 */
	public int proposalId;
	/**
	 * Implementation field for persistent attribute: customerId
	 */
	public int customerId;
	/**
	 * Implementation field for persistent attribute: dmId
	 */
	public int dmId;
	/**
	 * Creates an empty key for Entity Bean: TempEE
	 */
	public TempEEKey() {
	}
	/**
	 * Creates a key for Entity Bean: TempEE
	 */
	public TempEEKey(int proposalId, int customerId, int dmId) {
		this.proposalId = proposalId;
		this.customerId = customerId;
		this.dmId = dmId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey) otherKey;
			return (
				(this.proposalId == o.proposalId)
					&& (this.customerId == o.customerId)
					&& (this.dmId == o.dmId));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(proposalId).hashCode())
				+ (new java.lang.Integer(customerId).hashCode())
				+ (new java.lang.Integer(dmId).hashCode()));
	}
}
