/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Key class for Entity Bean: BPCustList
 */
public class BPCustListKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: userId
	 */
	public java.lang.String userId;
	/**
	 * Implementation field for persistent attribute: custListNo
	 */
	public java.lang.String custListNo;
	/**
	 * Creates an empty key for Entity Bean: BPCustList
	 */
	public BPCustListKey() {
	}
	/**
	 * Creates a key for Entity Bean: BPCustList
	 */
	public BPCustListKey(
		java.lang.String userId,
		java.lang.String custListNo) {
		this.userId = userId;
		this.custListNo = custListNo;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
					.BPCustListKey) otherKey;
			return (
				(this.userId.equals(o.userId))
					&& (this.custListNo.equals(o.custListNo)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (userId.hashCode() + custListNo.hashCode());
	}
}
