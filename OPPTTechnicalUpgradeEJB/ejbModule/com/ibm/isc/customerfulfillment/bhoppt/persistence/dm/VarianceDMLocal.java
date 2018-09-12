/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;
/**
 * Local interface for Enterprise Bean: VarianceDM
 */
public interface VarianceDMLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: dmNo
	 */
	public java.lang.String getDmNo();
	/**
	 * Set accessor for persistent attribute: dmNo
	 */
	public void setDmNo(java.lang.String newDmNo);
	/**
	 * Get accessor for persistent attribute: dmDesc
	 */
	public java.lang.String getDmDesc();
	/**
	 * Set accessor for persistent attribute: dmDesc
	 */
	public void setDmDesc(java.lang.String newDmDesc);
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public int getDmId();
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public void setDmId(int newDmId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId);
}
