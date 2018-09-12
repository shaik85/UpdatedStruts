/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Key class for Entity Bean: BPLegacyNo
 */
public class BPLegacyNoKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: userId
	 */
	public java.lang.String userId;
	/**
	 * Implementation field for persistent attribute: legacyNo
	 */
	public java.lang.String legacyNo;
	/**
	 * Implementation field for persistent attribute: addressSeqNo
	 */
	public java.lang.String addressSeqNo;
	/**
	 * Creates an empty key for Entity Bean: BPLegacyNo
	 */
	public BPLegacyNoKey() {
	}
	/**
	 * Creates a key for Entity Bean: BPLegacyNo
	 */
	public BPLegacyNoKey(
		java.lang.String userId,
		java.lang.String legacyNo,
		java.lang.String addressSeqNo) {
		this.userId = userId;
		this.legacyNo = legacyNo;
		this.addressSeqNo = addressSeqNo;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
					.BPLegacyNoKey) otherKey;
			return (
				(this.userId.equals(o.userId))
					&& (this.legacyNo.equals(o.legacyNo))
					&& (this.addressSeqNo.equals(o.addressSeqNo)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			userId.hashCode() + legacyNo.hashCode() + addressSeqNo.hashCode());
	}
}
