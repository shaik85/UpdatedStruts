/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: Status
 */
public interface StatusLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Status
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.StatusLocal create(
		java.lang.String statusCode)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Status
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.StatusLocal findByPrimaryKey(java.lang.String primaryKey)
		throws javax.ejb.FinderException;
}
