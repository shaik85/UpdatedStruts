/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: Group
 */
public interface GroupLocalHome extends javax.ejb.EJBLocalHome
{
	/**
	 * Creates an instance from a key for Entity Bean: Group
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal create(java.lang.String groupName)	throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Group
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal findByPrimaryKey(java.lang.String primaryKey) throws javax.ejb.FinderException;
	
	
	public java.util.Collection findAllGroup() throws javax.ejb.FinderException;
	public java.util.Collection findBySalesOrg(java.lang.String salesOrg) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal findByGroupName(java.lang.String groupName) throws javax.ejb.FinderException;
}

