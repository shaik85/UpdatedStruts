package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Key class for Entity Bean: OfferingType
 */

//THis class was created By Srinivas-DAD001
public class OfferingTypeKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: offeringDesc
	 */
	public java.lang.String offeringDesc;
	/**
	 * Implementation field for persistent attribute: offeringType
	 */
	public java.lang.String offeringType;
	/**
	 * Creates an empty key for Entity Bean: OfferingType
	 */
	public OfferingTypeKey() {
	}
	/**
	 * Creates a key for Entity Bean: OfferingType
	 */
	public OfferingTypeKey(
		java.lang.String offeringType,
		java.lang.String offeringDesc) {
		this.offeringType = offeringType;
		this.offeringDesc = offeringDesc;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey) otherKey;
			return ((this.offeringType.equals(o.offeringType)) && (this.offeringDesc
				.equals(o.offeringDesc)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (offeringType.hashCode() + offeringDesc.hashCode());
	}
}
