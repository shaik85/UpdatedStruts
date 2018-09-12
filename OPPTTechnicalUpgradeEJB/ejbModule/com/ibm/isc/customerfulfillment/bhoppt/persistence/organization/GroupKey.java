/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Key class for Entity Bean: Group
 */
public class GroupKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: groupName
	 */
	public java.lang.String groupName;
	/**
	 * Creates an empty key for Entity Bean: Group
	 */
	public GroupKey() {
	}
	/**
	 * Creates a key for Entity Bean: Group
	 */
	public GroupKey(java.lang.String groupName) {
		this.groupName = groupName;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupKey o =
				(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
					.GroupKey) otherKey;
			return ((this.groupName.equals(o.groupName)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (groupName.hashCode());
	}
}
