/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local interface for Enterprise Bean: CustomerList
 */
public interface CustomerListLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: customerListName
	 */
	public java.lang.String getCustomerListName();
	/**
	 * Set accessor for persistent attribute: customerListName
	 */
	public void setCustomerListName(java.lang.String newCustomerListName);
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
}
