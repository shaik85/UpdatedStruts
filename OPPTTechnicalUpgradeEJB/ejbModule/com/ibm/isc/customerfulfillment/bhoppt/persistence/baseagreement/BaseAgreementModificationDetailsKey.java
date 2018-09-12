/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreementModificationDetails
 */
public class BaseAgreementModificationDetailsKey
	implements
		java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: agreementId
	 */
	public java.lang.Integer agreementId;
	/**
	 * Implementation field for persistent attribute: modificationTypeCode
	 */
	public java.lang.String modificationTypeCode;
	/**
	 * Creates an empty key for Entity Bean: BaseAgreementModificationDetails
	 */
	public BaseAgreementModificationDetailsKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreementModificationDetails
	 * @param agreementId
	 * @param modificationTypeCode
	 */
	public BaseAgreementModificationDetailsKey(
		java.lang.Integer agreementId,
		java.lang.String modificationTypeCode) {
		this.agreementId = agreementId;
		this.modificationTypeCode = modificationTypeCode;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey) otherKey;
			return ((this.agreementId.equals(o.agreementId)) && (this.modificationTypeCode
				.equals(o.modificationTypeCode)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (agreementId.hashCode() + modificationTypeCode.hashCode());
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
	/**
	 * Get accessor for persistent attribute: modificationTypeCode
	 * @return String
	 */
	public java.lang.String getModificationTypeCode() {
		return modificationTypeCode;
	}
	/**
	 * Set accessor for persistent attribute: modificationTypeCode
	 * @param newModificationTypeCode
	 */
	public void setModificationTypeCode(java.lang.String newModificationTypeCode) {
		modificationTypeCode = newModificationTypeCode;
	}
}
