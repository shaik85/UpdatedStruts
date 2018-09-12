/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;
/**
 * Key class for Entity Bean: Customer
 */
public class CustomerKey implements java.io.Serializable {
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
	 * Creates an empty key for Entity Bean: Customer
	 */
	public CustomerKey() {
	}
	/**
	 * Creates a key for Entity Bean: Customer
	 */
	public CustomerKey(int proposalId, int customerId) {
		this.proposalId = proposalId;
		this.customerId = customerId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer
					.CustomerKey) otherKey;
			return (
				(this.proposalId == o.proposalId)
					&& (this.customerId == o.customerId));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(proposalId).hashCode())
				+ (new java.lang.Integer(customerId).hashCode()));
	}
}
