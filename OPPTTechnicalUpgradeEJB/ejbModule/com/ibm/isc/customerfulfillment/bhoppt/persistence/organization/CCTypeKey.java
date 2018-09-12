package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

public class CCTypeKey implements java.io.Serializable {

	/**
	 * Implementation field for persistent attribute: ccType
	 */
	public java.lang.String ccType;
	public CCTypeKey() {
	}

	/**
	 * Creates a key for Entity Bean: CCType
	 */
	public CCTypeKey(java.lang.String ccType) {
		this.ccType = ccType;
	}
	/**
	 * Get accessor for persistent attribute: ccType
	 */
	public java.lang.String getCcType() {
		return ccType;
	}
	/**
	 * Set accessor for persistent attribute: ccType
	 */
	public void setCcType(java.lang.String newCcType) {
		ccType = newCcType;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey) otherKey;
			return ((this.ccType.equals(o.ccType)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (ccType.hashCode());
	}
}
