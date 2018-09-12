/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local interface for Enterprise Bean: BPCustList
 */
public interface BPCustListLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: custListName
	 */
	public java.lang.String getCustListName();
	/**
	 * Set accessor for persistent attribute: custListName
	 */
	public void setCustListName(java.lang.String newCustListName);
	
	public abstract java.lang.String getUserId();
		/**
		 * Set accessor for persistent attribute: userId
		 */
	public abstract void setUserId(java.lang.String newUserId);
		/**
		 * Get accessor for persistent attribute: custListNo
		 */
	public abstract java.lang.String getCustListNo();
		/**
		 * Set accessor for persistent attribute: custListNo
		 */
	public abstract void setCustListNo(java.lang.String newCustListNo);
		/**
		 * Get accessor for persistent attribute: custListName
		 */
}
