/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local interface for Enterprise Bean: BaseAgreementForm
 */
public interface BaseAgreementFormLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: formNumber
	 */
	public java.lang.String getFormNumber();
	/**
	 * Set accessor for persistent attribute: formNumber
	 * @param newFormNumber
	 */
	public void setFormNumber(java.lang.String newFormNumber);
	/**
	 * Get accessor for persistent attribute: formShortDescription
	 * @return String
	 */
	public java.lang.String getFormShortDescription();
	/**
	 * Set accessor for persistent attribute: formShortDescription
	 * @param newFormShortDescription
	 */
	public void setFormShortDescription(java.lang.String newFormShortDescription);
	/**
	 * Get accessor for persistent attribute: formLongDescription
	 * @return String
	 */
	public java.lang.String getFormLongDescription();
	/**
	 * Set accessor for persistent attribute: formLongDescription
	 * @param newFormLongDescription
	 */
	public void setFormLongDescription(java.lang.String newFormLongDescription);
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
