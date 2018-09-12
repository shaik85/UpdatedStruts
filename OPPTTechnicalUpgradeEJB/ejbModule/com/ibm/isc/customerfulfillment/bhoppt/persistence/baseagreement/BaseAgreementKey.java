/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreement
 */
public class BaseAgreementKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: agreementId
	 */
	public java.lang.Integer agreementId;
	/**
	 * Creates an empty key for Entity Bean: BaseAgreement
	 */
	public BaseAgreementKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreement
	 * @param agreementId
	 */
	public BaseAgreementKey(java.lang.Integer agreementId) {
		this.agreementId = agreementId;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey) otherKey;
			return ((this.agreementId.equals(o.agreementId)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (agreementId.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: agreementId
	 * @return Integer
	 */
	public java.lang.Integer getAgreementId() {
		return agreementId;
	}
	/**
	 * Set accessor for persistent attribute: agreementId
	 * @param newAgreementId
	 */
	public void setAgreementId(java.lang.Integer newAgreementId) {
		agreementId = newAgreementId;
	}
}
