/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Key class for Entity Bean: BaseAgreementFormBean
 */
public class BaseAgreementFormBeanKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: formNumber
	 */
	public java.lang.String formNumber;
	/**
	 * Creates an empty key for Entity Bean: BaseAgreementFormBean
	 */
	public BaseAgreementFormBeanKey() {
	}
	/**
	 * Creates a key for Entity Bean: BaseAgreementFormBean
	 * @author Administrator 
	 * @param formNumber
	 */
	public BaseAgreementFormBeanKey(java.lang.String formNumber) {
		this.formNumber = formNumber;
	}
	/**
	 * Returns true if both keys are equal.
	 * @return boolean
	 * @param otherKey
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBeanKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBeanKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBeanKey) otherKey;
			return ((this.formNumber.equals(o.formNumber)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 * @return int
	 */
	public int hashCode() {
		return (formNumber.hashCode());
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
}
