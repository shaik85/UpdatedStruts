/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: BillingType
 */
public interface BillingTypeLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BillingType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.BillingTypeLocal create(
		java.lang.String billingType)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BillingType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.BillingTypeLocal findByPrimaryKey(java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllBillingType() throws javax.ejb.FinderException;
}
