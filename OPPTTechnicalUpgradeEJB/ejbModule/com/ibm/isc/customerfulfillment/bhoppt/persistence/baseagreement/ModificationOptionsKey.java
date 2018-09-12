/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: ModificationOptions
 */
public class ModificationOptionsKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: modificationTypeCode
	 */
	public java.lang.String modificationTypeCode;
	/**
	 * Implementation field for persistent attribute: modificationOption
	 */
	public java.lang.String modificationOption;
	/**
	 * Creates an empty key for Entity Bean: ModificationOptions
	 */
	public ModificationOptionsKey() {
	}
	/**
	 * Creates a key for Entity Bean: ModificationOptions
	 */
	public ModificationOptionsKey(
		java.lang.String modificationTypeCode,
		java.lang.String modificationOption) {
		this.modificationTypeCode = modificationTypeCode;
		this.modificationOption = modificationOption;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey) otherKey;
			return ((this.modificationTypeCode.equals(o.modificationTypeCode)) && (this.modificationOption
				.equals(o.modificationOption)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (modificationTypeCode.hashCode() + modificationOption.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: modificationTypeCode
	 */
	public java.lang.String getModificationTypeCode() {
		return modificationTypeCode;
	}
	/**
	 * Set accessor for persistent attribute: modificationTypeCode
	 */
	public void setModificationTypeCode(java.lang.String newModificationTypeCode) {
		modificationTypeCode = newModificationTypeCode;
	}
	/**
	 * Get accessor for persistent attribute: modificationOption
	 */
	public java.lang.String getModificationOption() {
		return modificationOption;
	}
	/**
	 * Set accessor for persistent attribute: modificationOption
	 */
	public void setModificationOption(java.lang.String newModificationOption) {
		modificationOption = newModificationOption;
	}
}
