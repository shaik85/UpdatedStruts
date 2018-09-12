/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local interface for Enterprise Bean: BaseAgreementModificationDetails
 */
public interface BaseAgreementModificationDetailsLocal
	extends
		javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: agreementId
	 * @return Integer
	 */
	public java.lang.Integer getAgreementId();
	/**
	 * Set accessor for persistent attribute: agreementId
	 * @param newAgreementId
	 */
	public void setAgreementId(java.lang.Integer newAgreementId);
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
	 * Get accessor for persistent attribute: legalContract
	 * @return String
	 */
	public java.lang.String getLegalContract();
	/**
	 * Set accessor for persistent attribute: legalContract
	 * @param newLegalContract
	 */
	public void setLegalContract(java.lang.String newLegalContract);
	/**
	 * Get accessor for persistent attribute: accountingContact
	 * @return String
	 */
	public java.lang.String getAccountingContact();
	/**
	 * Set accessor for persistent attribute: accountingContact
	 * @param newAccountingContact
	 */
	public void setAccountingContact(java.lang.String newAccountingContact);
	/**
	 * Get accessor for persistent attribute: revenueRecognition
	 * @return String
	 */
	public java.lang.String getRevenueRecognition();
	/**
	 * Set accessor for persistent attribute: revenueRecognition
	 * @param newRevenueRecognition
	 */
	public void setRevenueRecognition(java.lang.String newRevenueRecognition);
	/**
	 * Get accessor for persistent attribute: modifiedIBMLetterHead
	 * @return String
	 */
	public java.lang.String getModifiedIBMLetterHead();
	/**
	 * Set accessor for persistent attribute: modifiedIBMLetterHead
	 * @param newModifiedIBMLetterHead
	 */
	public void setModifiedIBMLetterHead(
		java.lang.String newModifiedIBMLetterHead);
	/**
	 * Get accessor for persistent attribute: details
	 * @return String
	 */
	public java.lang.String getDetails();
	/**
	 * Set accessor for persistent attribute: details
	 * @param newDetails
	 */
	public void setDetails(java.lang.String newDetails);
	/**
	 * Get accessor for persistent attribute: createdBy
	 * @return String
	 */
	public java.lang.String getCreatedBy();
	/**
	 * Set accessor for persistent attribute: createdBy
	 * @param newCreatedBy
	 */
	public void setCreatedBy(java.lang.String newCreatedBy);
	/**
	 * Get accessor for persistent attribute: createdDate
	 * @return Date
	 */
	public java.sql.Date getCreatedDate();
	/**
	 * Set accessor for persistent attribute: createdDate
	 * @param newCreatedDate
	 */
	public void setCreatedDate(java.sql.Date newCreatedDate);
	/**
	 * Get accessor for persistent attribute: changedBy
	 * @return String
	 */
	public java.lang.String getChangedBy();
	/**
	 * Set accessor for persistent attribute: changedBy
	 * @param newChangedBy
	 */
	public void setChangedBy(java.lang.String newChangedBy);
	/**
	 * Get accessor for persistent attribute: changedDate
	 * @return Date
	 */
	public java.sql.Date getChangedDate();
	/**
	 * Set accessor for persistent attribute: changedDate
	 * @param newChangedDate
	 */
	public void setChangedDate(java.sql.Date newChangedDate);
	/**
	 * Get accessor for persistent attribute: modificationOption
	 * @return String
	 */
	public java.lang.String getModificationOption();
	/**
	 * Set accessor for persistent attribute: modificationOption
	 * @param newModificationOption
	 */
	public void setModificationOption(java.lang.String newModificationOption);
	/**
	 * Get accessor for persistent attribute: rolStartDate
	 * @return Date
	 */
	public java.sql.Date getRolStartDate();
	/**
	 * Set accessor for persistent attribute: rolStartDate
	 * @param newRolStartDate
	 */
	public void setRolStartDate(java.sql.Date newRolStartDate);
	/**
	 * Get accessor for persistent attribute: rolEndDate
	 * @return Date
	 */
	public java.sql.Date getRolEndDate();
	/**
	 * Set accessor for persistent attribute: rolEndDate
	 * @param newRolEndDate
	 */
	public void setRolEndDate(java.sql.Date newRolEndDate);
    /**
     * Get accessor for persistent attribute: status
     * @return String
     */
    public java.lang.String getStatus();
    /**
     * Set accessor for persistent attribute: status
     * @param newStatus
     */
    public void setStatus(java.lang.String newStatus);
}
