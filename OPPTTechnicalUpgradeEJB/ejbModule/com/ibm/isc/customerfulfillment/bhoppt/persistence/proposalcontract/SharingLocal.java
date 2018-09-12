/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local interface for Enterprise Bean: Sharing
 */
public interface SharingLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: accessType
	 */
	public java.lang.String getAccessType();
	/**
	 * Set accessor for persistent attribute: accessType
	 */
	public void setAccessType(java.lang.String newAccessType);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: accessTo
	 */
	public java.lang.String getAccessTo();
	/**
	 * Set accessor for persistent attribute: accessTo
	 */
	public void setAccessTo(java.lang.String newAccessTo);
}
