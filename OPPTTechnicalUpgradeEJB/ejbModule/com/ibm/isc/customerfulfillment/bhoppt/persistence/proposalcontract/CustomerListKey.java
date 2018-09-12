/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Key class for Entity Bean: CustomerList
 */
public class CustomerListKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: proposalId
	 */
	public int proposalId;
	/**
	 * Implementation field for persistent attribute: customerListNo
	 */
	public java.lang.String customerListNo;
	/**
	 * Creates an empty key for Entity Bean: CustomerList
	 */
	public CustomerListKey() {
	}
	/**
	 * Creates a key for Entity Bean: CustomerList
	 */
	public CustomerListKey(int proposalId, java.lang.String customerListNo) {
		this.proposalId = proposalId;
		this.customerListNo = customerListNo;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract
				.CustomerListKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract
					.CustomerListKey) otherKey;
			return (
				(this.proposalId == o.proposalId)
					&& (this.customerListNo.equals(o.customerListNo)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(proposalId).hashCode())
				+ customerListNo.hashCode());
	}
}
