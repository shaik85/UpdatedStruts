/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local interface for Enterprise Bean: BaseAgreement
 */
public interface BaseAgreementLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: agreementId
	 */
	public java.lang.Integer getAgreementId();
	/**
	 * Set accessor for persistent attribute: agreementId
	 * @param newAgreementId
	 */
	public void setAgreementId(java.lang.Integer newAgreementId);
	/**
	 * Get accessor for persistent attribute: agreementNumber
	 * @return String
	 */
	public java.lang.String getAgreementNumber();
	/**
	 * Set accessor for persistent attribute: agreementNumber
	 * @param newAgreementNumber
	 */
	public void setAgreementNumber(java.lang.String newAgreementNumber);
	/**
	 * Get accessor for persistent attribute: formNumber
	 * @return String
	 */
	public java.lang.String getFormNumber();
	/**
	 * Set accessor for persistent attribute: formNumber
	 * @param newFormNumber
	 */
	public void setFormNumber(java.lang.String newFormNumber);
	/**
	 * Get accessor for persistent attribute: enterpriseNumber
	 * @return String
	 */
	public java.lang.String getEnterpriseNumber();
	/**
	 * Set accessor for persistent attribute: enterpriseNumber
	 * @param newEnterpriseNumber
	 */
	public void setEnterpriseNumber(java.lang.String newEnterpriseNumber);
	/**
	 * Get accessor for persistent attribute: customerNumber
	 * @return String
	 */
	public java.lang.String getCustomerNumber();
	/**
	 * Set accessor for persistent attribute: customerNumber
	 * @param newCustomerNumber
	 */
	public void setCustomerNumber(java.lang.String newCustomerNumber);
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
	 * Get accessor for persistent attribute: enterpriseName
	 * @return String
	 */
	public java.lang.String getEnterpriseName();
	/**
	 * Set accessor for persistent attribute: enterpriseName
	 * @param newEnterpriseName
	 */
	public void setEnterpriseName(java.lang.String newEnterpriseName);
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
	 * Get accessor for persistent attribute: acceptedDate
	 * @return Date
	 */
	public java.sql.Date getAcceptedDate();
	/**
	 * Set accessor for persistent attribute: acceptedDate
	 * @param newAcceptedDate
	 */
	public void setAcceptedDate(java.sql.Date newAcceptedDate);
	/**
	 * Get accessor for persistent attribute: isElectronicSubmitter
	 * @return String
	 */
	public java.lang.String getIsElectronicSubmitter();
	/**
	 * Set accessor for persistent attribute: isElectronicSubmitter
	 * @param newIsElectronicSubmitter
	 */
	public void setIsElectronicSubmitter(
		java.lang.String newIsElectronicSubmitter);
	/**
	 * Get accessor for persistent attribute: agreementStatus
	 * @return String
	 */
	public java.lang.String getAgreementStatus();
	/**
	 * Set accessor for persistent attribute: agreementStatus
	 * @param newAgreementStatus
	 */
	public void setAgreementStatus(java.lang.String newAgreementStatus);
	/**
	 * Get accessor for persistent attribute: branchOffice
	 * @return String
	 */
	public java.lang.String getBranchOffice();
	/**
	 * Set accessor for persistent attribute: branchOffice
	 * @param newBranchOffice
	 */
	public void setBranchOffice(java.lang.String newBranchOffice);
	/**
	 * Get accessor for persistent attribute: isModifiedAgreement
	 * @return String
	 */
	public java.lang.String getIsModifiedAgreement();
	/**
	 * Set accessor for persistent attribute: isModifiedAgreement
	 * @param newIsModifiedAgreement
	 */
	public void setIsModifiedAgreement(java.lang.String newIsModifiedAgreement);
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
	 * Get accessor for persistent attribute: customerRepresentative
	 * @return String
	 */
	public java.lang.String getCustomerRepresentative();
	/**
	 * Set accessor for persistent attribute: customerRepresentative
	 * @param newCustomerRepresentative
	 */
	public void setCustomerRepresentative(
		java.lang.String newCustomerRepresentative);
	/**
	 * Get accessor for persistent attribute: imageReferenceNumber
	 * @return String
	 */
	public java.lang.String getImageReferenceNumber();
	/**
	 * Set accessor for persistent attribute: imageReferenceNumber
	 * @param newImageReferenceNumber
	 */
	public void setImageReferenceNumber(java.lang.String newImageReferenceNumber);
	/**
	 * Get accessor for persistent attribute: fileNumber
	 * @return String
	 */
	public java.lang.String getFileNumber();
	/**
	 * Set accessor for persistent attribute: fileNumber
	 * @param newFileNumber
	 */
	public void setFileNumber(java.lang.String newFileNumber);
	/**
	 * Get accessor for persistent attribute: oneway
	 * @return String
	 */
	public java.lang.String getOneway();
	/**
	 * Set accessor for persistent attribute: oneway
	 * @param newOneway
	 */
	public void setOneway(java.lang.String newOneway);
	/**
	 * Get accessor for persistent attribute: customerName
	 * @return String
	 */
	public java.lang.String getCustomerName();
	/**
	 * Set accessor for persistent attribute: customerName
	 * @param newCustomerName
	 */
	public void setCustomerName(java.lang.String newCustomerName);
	/**
	 * Get accessor for persistent attribute: previousAgreementId
	 * @return Integer
	 */
	public java.lang.Integer getPreviousAgreementId();
	/**
	 * Set accessor for persistent attribute: previousAgreementId
	 * @param newPreviousAgreementId
	 */
	public void setPreviousAgreementId(java.lang.Integer newPreviousAgreementId);
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
	 * @return String
	 */
	public java.sql.Date getChangedDate();
	/**
	 * Set accessor for persistent attribute: changedDate
	 * @param newChangedDate
	 */
	public void setChangedDate(java.sql.Date newChangedDate);
	/**
	 * Get accessor for persistent attribute: expirationDate
	 * @return Date
	 */
	public java.sql.Date getExpirationDate();
	/**
	 * Set accessor for persistent attribute: expirationDate
	 * @param newExpirationDate
	 */
	public void setExpirationDate(java.sql.Date newExpirationDate);
	/**
	 * Get accessor for persistent attribute: inac
	 * @return String
	 */
	public java.lang.String getInac();
	/**
	 * Set accessor for persistent attribute: inac
	 * @param newInac
	 */
	public void setInac(java.lang.String newInac);
	/**
	 * Get accessor for persistent attribute: legacyCustomerNumber
	 * @param String
	 */
	public java.lang.String getLegacyCustomerNumber();
	/**
	 * Set accessor for persistent attribute: legacyCustomerNumber
	 * @param newLegacyCustomerNumber
	 */
	public void setLegacyCustomerNumber(java.lang.String newLegacyCustomerNumber);
	/**
	 * Get accessor for persistent attribute: legalContactHdr
	 * @return String
	 */
	public java.lang.String getLegalContactHdr();
	/**
	 * Set accessor for persistent attribute: legalContactHdr
	 * @param newLegalContactHdr
	 */
	public void setLegalContactHdr(java.lang.String newLegalContactHdr);
	/**
	 * Get accessor for persistent attribute: accountingContactHdr
	 * @return String
	 */
	public java.lang.String getAccountingContactHdr();
	/**
	 * Set accessor for persistent attribute: accountingContactHdr
	 * @param newAccountingContactHdr
	 */
	public void setAccountingContactHdr(java.lang.String newAccountingContactHdr);
}
