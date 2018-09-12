/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer;

import java.sql.Date;

/**
 * Local Home interface for Enterprise Bean: Customer
 */
public interface CustomerLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Customer
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal create(
		int proposalId,
		int customerId,
		String sapCustomerNo,
		Date planStartDate,
		Date planEndDate)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Customer
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer
		.CustomerLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByProposal(int proposalId)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxCustomerId()  throws javax.ejb.FinderException;
	public java.util.Collection findByProposalAndCustomerList(int proposalId, java.lang.String customerListNo) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal findBySapCustNo(int proposalId, java.lang.String sapCustomerNo) throws javax.ejb.FinderException;
	/* CR6153 start change */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal findBySapCustNoAndPlanStartEndDate(
		int proposalId,
		java.lang.String sapCustomerNo,
		java.sql.Date planStartDate,
		java.sql.Date planEndDate) throws javax.ejb.FinderException;
	public java.util.Collection findByProposalStartEndDate(
		int proposalId, 
		java.sql.Date planStartDate, 
		java.sql.Date planEndDate) throws javax.ejb.FinderException;
	/* CR6153 end change */
}
