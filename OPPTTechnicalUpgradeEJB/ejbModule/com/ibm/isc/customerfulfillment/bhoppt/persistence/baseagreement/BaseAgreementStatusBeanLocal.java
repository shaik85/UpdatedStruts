/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local interface for Enterprise Bean: BaseAgreementStatusBean
 */
public interface BaseAgreementStatusBeanLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: statusCode
	 * @return String
	 */
	public java.lang.String getStatusCode();
	/**
	 * Set accessor for persistent attribute: statusCode
	 * @param newStatusCode
	 */
	public void setStatusCode(java.lang.String newStatusCode);
	/**
	 * Get accessor for persistent attribute: statusDescription
	 * @return String
	 */
	public java.lang.String getStatusDescription();
	/**
	 * Set accessor for persistent attribute: statusDescription
	 * @param newStatusDescription
	 */
	public void setStatusDescription(java.lang.String newStatusDescription);
}
