/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreementModificationTypeBean
 */
public class BaseAgreementModificationTypeBeanKey
	implements
		java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: modificationTypeCode
	 */
	public java.lang.String modificationTypeCode;
	/**
	 * Creates an empty key for Entity Bean: BaseAgreementModificationTypeBean
	 */
	public BaseAgreementModificationTypeBeanKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreementModificationTypeBean
	 * @param modificationTypeCode
	 */
	public BaseAgreementModificationTypeBeanKey(
		java.lang.String modificationTypeCode) {
		this.modificationTypeCode = modificationTypeCode;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 * 
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeBeanKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeBeanKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeBeanKey) otherKey;
			return ((this.modificationTypeCode.equals(o.modificationTypeCode)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (modificationTypeCode.hashCode());
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
