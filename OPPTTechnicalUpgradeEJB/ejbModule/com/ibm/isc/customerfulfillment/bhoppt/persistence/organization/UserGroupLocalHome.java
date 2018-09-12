/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: UserGroup
 */
public interface UserGroupLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: UserGroup
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocal create(java.lang.String userId, java.lang.String groupName) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: UserGroup
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.String userId) throws javax.ejb.FinderException;
	public java.util.Collection findByGroup(java.lang.String groupName) throws javax.ejb.FinderException;
}
