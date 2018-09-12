/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local interface for Enterprise Bean: BaseAgreementModificationType
 */
public interface BaseAgreementModificationTypeLocal
	extends
		javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: modificationTypeCode
	 * @return String
	 */
	public java.lang.String getModificationTypeCode();
	/**
	 * Set accessor for persistent attribute: modificationTypeCode
	 * @param newModificationTypeCode
	 */
	public void setModificationTypeCode(java.lang.String newModificationTypeCode);
	/**
	 * Get accessor for persistent attribute: modificationTypeDescription
	 * @return String
	 */
	public java.lang.String getModificationTypeDescription();
	/**
	 * Set accessor for persistent attribute: modificationTypeDescription
	 * @param newModificationTypeDescription
	 */
	public void setModificationTypeDescription(
		java.lang.String newModificationTypeDescription);
	/**
	 * Get accessor for persistent attribute: salesOrganization
	 * @return String
	 */
	public java.lang.String getSalesOrganization();
	/**
	 * Set accessor for persistent attribute: salesOrganization
	 * @param newSalesOrganization
	 */
	public void setSalesOrganization(java.lang.String newSalesOrganization);
}
