/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: Currency
 */
public interface CurrencyLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Currency
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CurrencyLocal create(
		java.lang.String currency)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Currency
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.CurrencyLocal findByPrimaryKey(java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllCurrency() throws javax.ejb.FinderException;
}
