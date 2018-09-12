/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local interface for Enterprise Bean: Currency
 */
public interface CurrencyLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: currencyDesc
	 */
	public java.lang.String getCurrencyDesc();
	/**
	 * Set accessor for persistent attribute: currencyDesc
	 */
	public void setCurrencyDesc(java.lang.String newCurrencyDesc);
	/**
	 * Get accessor for persistent attribute: decimalsAllowed
	 */
	public java.lang.Integer getDecimalsAllowed();
	/**
	 * Set accessor for persistent attribute: decimalsAllowed
	 */
	public void setDecimalsAllowed(java.lang.Integer newDecimalsAllowed);
	/**
	 * Get accessor for persistent attribute: currency
	 */
	public java.lang.String getCurrency();
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public void setCurrency(java.lang.String newCurrency);
}
