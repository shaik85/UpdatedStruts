/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: Role
 */
public interface RoleLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Role
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.RoleLocal create(
		java.lang.String role)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Role
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.RoleLocal findByPrimaryKey(
		java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllRoles()
		throws javax.ejb.FinderException;
}
