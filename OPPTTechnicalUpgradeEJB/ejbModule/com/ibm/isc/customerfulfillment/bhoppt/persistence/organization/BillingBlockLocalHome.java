/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: BillingBlock
 */
public interface BillingBlockLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BillingBlock
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.BillingBlockLocal create(
		java.lang.String billingBlock)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BillingBlock
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.BillingBlockLocal findByPrimaryKey(java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllBillingBlock() throws javax.ejb.FinderException;
}
