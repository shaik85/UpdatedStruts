/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Key class for Entity Bean: UserGroup
 */
public class UserGroupKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: userId
	 */
	public java.lang.String userId;
	/**
	 * Implementation field for persistent attribute: groupName
	 */
	public java.lang.String groupName;
	/**
	 * Creates an empty key for Entity Bean: UserGroup
	 */
	public UserGroupKey() {
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey) otherKey;
			return ((this.userId.equals(o.userId)) && (this.groupName.equals(o.groupName)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (userId.hashCode() + groupName.hashCode());
	}
	/**
	 * Creates a key for Entity Bean: UserGroup
	 */
	public UserGroupKey(java.lang.String userId, java.lang.String groupName) {
		this.userId = userId;
		this.groupName = groupName;
	}
}
