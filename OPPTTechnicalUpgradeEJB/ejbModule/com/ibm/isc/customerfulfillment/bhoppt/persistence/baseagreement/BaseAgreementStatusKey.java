/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreementStatus
 */
public class BaseAgreementStatusKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: statusCode
	 */
	public java.lang.String statusCode;
	/**
	 * Creates an empty key for Entity Bean: BaseAgreementStatus
	 */
	public BaseAgreementStatusKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreementStatus
	 * @param statusCode
	 */
	public BaseAgreementStatusKey(java.lang.String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey) otherKey;
			return ((this.statusCode.equals(o.statusCode)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (statusCode.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: statusCode
	 * @return String
	 */
	public java.lang.String getStatusCode() {
		return statusCode;
	}
	/**
	 * Set accessor for persistent attribute: statusCode
	 * @param newStatusCode
	 */
	public void setStatusCode(java.lang.String newStatusCode) {
		statusCode = newStatusCode;
	}
}
