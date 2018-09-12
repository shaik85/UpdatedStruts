/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local interface for Enterprise Bean: ModificationOptions
 */
public interface ModificationOptionsLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: modificationTypeCode
	 */
	public java.lang.String getModificationTypeCode();
	/**
	 * Set accessor for persistent attribute: modificationTypeCode
	 */
	public void setModificationTypeCode(java.lang.String newModificationTypeCode);
	/**
	 * Get accessor for persistent attribute: modificationOption
	 */
	public java.lang.String getModificationOption();
	/**
	 * Set accessor for persistent attribute: modificationOption
	 */
	public void setModificationOption(java.lang.String newModificationOption);
	/**
	 * Get accessor for persistent attribute: modificationOptionDescription
	 */
	public java.lang.String getModificationOptionDescription();
	/**
	 * Set accessor for persistent attribute: modificationOptionDescription
	 */
	public void setModificationOptionDescription(
		java.lang.String newModificationOptionDescription);
}
