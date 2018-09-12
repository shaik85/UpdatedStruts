/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local interface for Enterprise Bean: BaseAgreementCoverageType
 */
public interface BaseAgreementCoverageTypeLocal
	extends
		javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: coverageType
	 * @return String
	 */
	public java.lang.String getCoverageType();
	/**
	 * Set accessor for persistent attribute: coverageType
	 * @param newCoverageType
	 */
	public void setCoverageType(java.lang.String newCoverageType);
	/**
	 * Get accessor for persistent attribute: coverageTypeDescription
	 * @return String
	 */
	public java.lang.String getCoverageTypeDescription();
	/**
	 * Set accessor for persistent attribute: coverageTypeDescription
	 * @param newCoverageTypeDescription
	 */
	public void setCoverageTypeDescription(
		java.lang.String newCoverageTypeDescription);
}
