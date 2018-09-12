/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;
/**
 * Local Home interface for Enterprise Bean: HistoryCustomer
 */
public interface HistoryCustomerLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: HistoryCustomer
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer
		.HistoryCustomerLocal create(
		int customerId,
		int proposalId)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: HistoryCustomer
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer
		.HistoryCustomerLocal findByPrimaryKey(
			com.ibm.isc.customerfulfillment.bhoppt.persistence.customer
				.HistoryCustomerKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxCustomerId() throws javax.ejb.FinderException;
}
