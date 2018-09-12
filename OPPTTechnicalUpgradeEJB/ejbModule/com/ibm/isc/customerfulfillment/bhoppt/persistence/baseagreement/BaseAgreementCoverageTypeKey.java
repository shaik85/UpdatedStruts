/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreementCoverageType
 */
public class BaseAgreementCoverageTypeKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: coverageType
	 */
	public java.lang.String coverageType;
	/**
	 * Creates an empty key for Entity Bean: BaseAgreementCoverageType
	 */
	public BaseAgreementCoverageTypeKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreementCoverageType
	 * @param coverageType
	 */
	public BaseAgreementCoverageTypeKey(java.lang.String coverageType) {
		this.coverageType = coverageType;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementCoverageTypeKey) otherKey;
			return ((this.coverageType.equals(o.coverageType)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (coverageType.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: coverageType
	 * @return String
	 */
	public java.lang.String getCoverageType() {
		return coverageType;
	}
	/**
	 * Set accessor for persistent attribute: coverageType
	 * @param newCoverageType
	 */
	public void setCoverageType(java.lang.String newCoverageType) {
		coverageType = newCoverageType;
	}
}
