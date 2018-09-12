/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Key class for Entity Bean: Sharing
 */
public class SharingKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: proposalId
	 */
	public int proposalId;
	/**
	 * Implementation field for persistent attribute: accessTo
	 */
	public java.lang.String accessTo;
	/**
	 * Creates an empty key for Entity Bean: Sharing
	 */
	public SharingKey() {
	}
	/**
	 * Creates a key for Entity Bean: Sharing
	 */
	public SharingKey(int proposalId, java.lang.String accessTo) {
		this.proposalId = proposalId;
		this.accessTo = accessTo;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract
					.SharingKey) otherKey;
			return (
				(this.proposalId == o.proposalId)
					&& (this.accessTo.equals(o.accessTo)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(proposalId).hashCode())
				+ accessTo.hashCode());
	}
}
