/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local interface for Enterprise Bean: SalesOrg
 */
public interface SalesOrgLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: salesOrgDesc
	 */
	public java.lang.String getSalesOrgDesc();
	/**
	 * Set accessor for persistent attribute: salesOrgDesc
	 */
	public void setSalesOrgDesc(java.lang.String newSalesOrgDesc);
	/**
	 * Get accessor for persistent attribute: defaultCurrency
	 */
	public java.lang.String getDefaultCurrency();
	/**
	 * Set accessor for persistent attribute: defaultCurrency
	 */
	public void setDefaultCurrency(java.lang.String newDefaultCurrency);
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public java.lang.String getSalesOrg();
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg);
}
