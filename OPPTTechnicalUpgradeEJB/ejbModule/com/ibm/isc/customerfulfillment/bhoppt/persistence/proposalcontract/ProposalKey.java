/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Key class for Entity Bean: Proposal
 */
public class ProposalKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: proposalId
	 */
	public int proposalId;
	/**
	 * Creates an empty key for Entity Bean: Proposal
	 */
	public ProposalKey() {
	}
	/**
	 * Creates a key for Entity Bean: Proposal
	 */
	public ProposalKey(int proposalId) {
		this.proposalId = proposalId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract
					.ProposalKey) otherKey;
			return ((this.proposalId == o.proposalId));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(proposalId).hashCode()));
	}
}
