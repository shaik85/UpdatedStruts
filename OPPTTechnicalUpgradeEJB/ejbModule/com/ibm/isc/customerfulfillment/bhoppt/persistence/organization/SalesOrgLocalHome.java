/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: SalesOrg
 */
public interface SalesOrgLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: SalesOrg
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal create(
		java.lang.String salesOrg)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: SalesOrg
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.SalesOrgLocal findByPrimaryKey(java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllSalesOrg() throws javax.ejb.FinderException;
}
