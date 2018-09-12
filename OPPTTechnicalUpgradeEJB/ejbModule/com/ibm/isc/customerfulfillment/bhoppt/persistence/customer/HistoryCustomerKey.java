/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;
/**
 * Key class for Entity Bean: HistoryCustomer
 */
public class HistoryCustomerKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: customerId
	 */
	public int customerId;
	/**
	 * Implementation field for persistent attribute: proposalId
	 */
	public int proposalId;
	/**
	 * Creates an empty key for Entity Bean: HistoryCustomer
	 */
	public HistoryCustomerKey() {
	}
	/**
	 * Creates a key for Entity Bean: HistoryCustomer
	 */
	public HistoryCustomerKey(int customerId, int proposalId) {
		this.customerId = customerId;
		this.proposalId = proposalId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer
					.HistoryCustomerKey) otherKey;
			return (
				(this.customerId == o.customerId)
					&& (this.proposalId == o.proposalId));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(customerId).hashCode())
				+ (new java.lang.Integer(proposalId).hashCode()));
	}
}
