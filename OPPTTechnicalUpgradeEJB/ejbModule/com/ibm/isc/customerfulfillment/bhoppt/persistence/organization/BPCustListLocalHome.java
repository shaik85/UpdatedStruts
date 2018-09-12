/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: BPCustList
 */
public interface BPCustListLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BPCustList
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.BPCustListLocal create(
		java.lang.String userId,
		java.lang.String custListNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BPCustList
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.BPCustListLocal findByPrimaryKey(
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
				.BPCustListKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.String userId) throws javax.ejb.FinderException;
}
