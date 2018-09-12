/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local interface for Enterprise Bean: Status
 */
public interface StatusLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: statusDesc
	 */
	public java.lang.String getStatusDesc();
	/**
	 * Set accessor for persistent attribute: statusDesc
	 */
	public void setStatusDesc(java.lang.String newStatusDesc);
	/**
	 * Get accessor for persistent attribute: statusCode
	 */
	public java.lang.String getStatusCode();
	/**
	 * Set accessor for persistent attribute: statusCode
	 */
	public void setStatusCode(java.lang.String newStatusCode);
}
