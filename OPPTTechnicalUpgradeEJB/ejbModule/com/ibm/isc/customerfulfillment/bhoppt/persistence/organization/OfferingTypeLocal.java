/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local interface for Enterprise Bean: OfferingType
 */
public interface OfferingTypeLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: offeringDesc
	 */
	public java.lang.String getOfferingDesc();
	/**
	 * Get accessor for persistent attribute: tvmAllowed
	 */
	public java.lang.String getTvmAllowed();
	/**
	 * Set accessor for persistent attribute: tvmAllowed
	 */
	public void setTvmAllowed(java.lang.String newTvmAllowed);
	/**
	 * Get accessor for persistent attribute: specialRateInd
	 */
	public java.lang.String getSpecialRateInd();
	/**
	 * Set accessor for persistent attribute: specialRateInd
	 */
	public void setSpecialRateInd(java.lang.String newSpecialRateInd);
	/**
	 * Get accessor for persistent attribute: annivContractAmtInd
	 */
	public java.lang.String getAnnivContractAmtInd();
	/**
	 * Set accessor for persistent attribute: annivContractAmtInd
	 */
	public void setAnnivContractAmtInd(java.lang.String newAnnivContractAmtInd);
	/**
	 * Get accessor for persistent attribute: duration
	 */
	public int getDuration();
	/**
	 * Set accessor for persistent attribute: duration
	 */
	public void setDuration(int newDuration);
	/**
	 * Get accessor for persistent attribute: offeringType
	 */
	public java.lang.String getOfferingType();
	/**
	 * Set accessor for persistent attribute: offeringType
	 */
	public void setOfferingType(java.lang.String newOfferingType);
}
