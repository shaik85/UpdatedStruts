/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Key class for Entity Bean: SalesArea
 */
public class SalesAreaKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: salesOrg
	 */
	public java.lang.String salesOrg;
	/**
	 * Implementation field for persistent attribute: divisionCode
	 */
	public java.lang.String divisionCode;
	/**
	 * Implementation field for persistent attribute: distributionChannelCode
	 */
	public java.lang.String distributionChannelCode;
	/**
	 * Creates an empty key for Entity Bean: SalesArea
	 */
	public SalesAreaKey() {
	}
	/**
	 * Creates a key for Entity Bean: SalesArea
	 */
	public SalesAreaKey(
		java.lang.String salesOrg,
		java.lang.String divisionCode,
		java.lang.String distributionChannelCode) {
		this.salesOrg = salesOrg;
		this.divisionCode = divisionCode;
		this.distributionChannelCode = distributionChannelCode;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
					.SalesAreaKey) otherKey;
			return (
				(this.salesOrg.equals(o.salesOrg))
					&& (this.divisionCode.equals(o.divisionCode))
					&& (this
						.distributionChannelCode
						.equals(o.distributionChannelCode)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			salesOrg.hashCode()
				+ divisionCode.hashCode()
				+ distributionChannelCode.hashCode());
	}
}
