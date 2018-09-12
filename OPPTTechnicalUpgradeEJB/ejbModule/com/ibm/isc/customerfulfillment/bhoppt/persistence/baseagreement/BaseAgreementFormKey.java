/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreementForm
 */
public class BaseAgreementFormKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: formNumber
	 */
	public java.lang.String formNumber;
	/**
	 * Implementation field for persistent attribute: salesOrganization
	 */
	public java.lang.String salesOrganization;
	/**
	 * Creates an empty key for Entity Bean: BaseAgreementForm
	 */
	public BaseAgreementFormKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreementForm
	 * @param formNumber
	 * @param salesOrganization
	 */
	public BaseAgreementFormKey(
		java.lang.String formNumber,
		java.lang.String salesOrganization) {
		this.formNumber = formNumber;
		this.salesOrganization = salesOrganization;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey) otherKey;
			return ((this.formNumber.equals(o.formNumber)) && (this.salesOrganization
				.equals(o.salesOrganization)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (formNumber.hashCode() + salesOrganization.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: formNumber
	 * @return String
	 */
	public java.lang.String getFormNumber() {
		return formNumber;
	}
	/**
	 * Set accessor for persistent attribute: formNumber
	 * @param newFormNumber
	 */
	public void setFormNumber(java.lang.String newFormNumber) {
		formNumber = newFormNumber;
	}
	/**
	 * Get accessor for persistent attribute: salesOrganization
	 * @return String
	 */
	public java.lang.String getSalesOrganization() {
		return salesOrganization;
	}
	/**
	 * Set accessor for persistent attribute: salesOrganization
	 * @param newSalesOrganization
	 */
	public void setSalesOrganization(java.lang.String newSalesOrganization) {
		salesOrganization = newSalesOrganization;
	}
}
