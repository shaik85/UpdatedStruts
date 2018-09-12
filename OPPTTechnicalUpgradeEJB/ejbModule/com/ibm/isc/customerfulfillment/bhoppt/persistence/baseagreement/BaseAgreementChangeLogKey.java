/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreementChangeLog
 */
public class BaseAgreementChangeLogKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: changeId
	 */
	public java.lang.Integer changeId;
	/**
	 * 
	 * Creates an empty key for Entity Bean: BaseAgreementChangeLog
	 */
	public BaseAgreementChangeLogKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreementChangeLog
	 * @param changeId
	 */
	public BaseAgreementChangeLogKey(java.lang.Integer changeId) {
		this.changeId = changeId;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey) otherKey;
			return ((this.changeId.equals(o.changeId)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (changeId.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: changeId
	 * @return Integer
	 */
	public java.lang.Integer getChangeId() {
		return changeId;
	}
	/**
	 * Set accessor for persistent attribute: changeId
	 */
	public void setChangeId(java.lang.Integer newChangeId) {
		changeId = newChangeId;
	}
}
