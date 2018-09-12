/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local Home interface for Enterprise Bean: CustomerList
 */
public interface CustomerListLocalHome extends javax.ejb.EJBLocalHome
{
	/**
	 * Creates an instance from a key for Entity Bean: CustomerList
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal create(
		int proposalId,
		java.lang.String customerListNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: CustomerList
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey primaryKey)
		throws javax.ejb.FinderException;
		
	public java.util.Collection findByProposalId(int proposalId)
		throws javax.ejb.FinderException;
}
