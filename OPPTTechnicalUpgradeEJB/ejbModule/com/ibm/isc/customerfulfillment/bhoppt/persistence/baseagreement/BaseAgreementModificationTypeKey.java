/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreementModificationType
 */
public class BaseAgreementModificationTypeKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: modificationTypeCode
	 */
	public java.lang.String modificationTypeCode;
	/**
	 * Implementation field for persistent attribute: salesOrganization
	 */
	public java.lang.String salesOrganization;
	/**
	 * Creates an empty key for Entity Bean: BaseAgreementModificationType
	 */
	public BaseAgreementModificationTypeKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreementModificationType
	 * @param modificationTypeCode
	 * @param salesOrganization
	 */
	public BaseAgreementModificationTypeKey(
		java.lang.String modificationTypeCode,
		java.lang.String salesOrganization) {
		this.modificationTypeCode = modificationTypeCode;
		this.salesOrganization = salesOrganization;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey) otherKey;
			return ((this.modificationTypeCode.equals(o.modificationTypeCode)) && (this.salesOrganization
				.equals(o.salesOrganization)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (modificationTypeCode.hashCode() + salesOrganization.hashCode());
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
	/**
	 * Get accessor for persistent attribute: salesOrganization
	 * @return String
	 */
	public java.lang.String getSalesOrganization() {
		return salesOrganization;
	}
	/**
	 * Set accessor for persistent attribute: salesOrganization
	 * @param newSalesOrganization
	 */
	public void setSalesOrganization(java.lang.String newSalesOrganization) {
		salesOrganization = newSalesOrganization;
	}
}
