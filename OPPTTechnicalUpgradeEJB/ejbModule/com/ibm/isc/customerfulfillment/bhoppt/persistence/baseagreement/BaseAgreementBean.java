/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: BaseAgreement
 */
public abstract class BaseAgreementBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 * @param ctx
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 * @return EntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 * @param agreementId
	 * @param salesOrg
	 * @param agreementNumber
	 * @param agreementStatus
	 * @param coverageType
	 * @param isModified
	 * @param createdBy
	 * @param createdDate
	 * @throws CreateException
	 * @return BaseAgreementKey
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey ejbCreate(
		java.lang.Integer agreementId,
		java.lang.String salesOrg,
		java.lang.String agreementNumber,
		java.lang.String agreementStatus,
		java.lang.String coverageType,
		java.lang.String isModified,
		java.lang.String createdBy,
		java.sql.Date createdDate) throws javax.ejb.CreateException {
		setAgreementId(agreementId);
		setSalesOrganization(salesOrg);
		setAgreementNumber(agreementNumber);
		setAgreementStatus(agreementStatus);
		setCoverageType(coverageType);
		setIsModifiedAgreement(isModified);
		setCreatedBy(createdBy);
		setCreatedDate(createdDate);
		return null;
	}
	/**
	 * ejbPostCreate
	 * @param agreementId
	 * @param salesOrg
	 * @param agreementNumber
	 * @param agreementStatus
	 * @param coverageType
	 * @param isModified
	 * @param createdBy
	 * @param createdDate
	 * @throws CreateException
	 * @return BaseAgreementKey
	 */
	public void ejbPostCreate(java.lang.Integer agreementId,
								java.lang.String salesOrg,
			java.lang.String agreementNumber,
			java.lang.String agreementStatus,
			java.lang.String coverageType,
			java.lang.String isModified,
			java.lang.String createdBy,
			java.sql.Date createdDate)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 * @throws RemoveException
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: agreementId
	 * @return Integer
	 */
	public abstract java.lang.Integer getAgreementId();
	/**
	 * Set accessor for persistent attribute: agreementId
	 * @param newAgreementId
	 */
	public abstract void setAgreementId(java.lang.Integer newAgreementId);
	/**
	 * Get accessor for persistent attribute: agreementNumber
	 * @return String
	 */
	public abstract java.lang.String getAgreementNumber();
	/**
	 * Set accessor for persistent attribute: agreementNumber
	 * @param newAgreementNumber
	 */
	public abstract void setAgreementNumber(java.lang.String newAgreementNumber);
	/**
	 * Get accessor for persistent attribute: formNumber
	 * @return String
	 */
	public abstract java.lang.String getFormNumber();
	/**
	 * Set accessor for persistent attribute: formNumber
	 * @param newFormNumber
	 */
	public abstract void setFormNumber(java.lang.String newFormNumber);
	/**
	 * Get accessor for persistent attribute: enterpriseNumber
	 * @return String
	 */
	public abstract java.lang.String getEnterpriseNumber();
	/**
	 * Set accessor for persistent attribute: enterpriseNumber
	 * @param newEnterpriseNumber
	 */
	public abstract void setEnterpriseNumber(
		java.lang.String newEnterpriseNumber);
	/**
	 * Get accessor for persistent attribute: customerNumber
	 * @return String
	 */
	public abstract java.lang.String getCustomerNumber();
	/**
	 * Set accessor for persistent attribute: customerNumber
	 * @param newCustomerNumber
	 */
	public abstract void setCustomerNumber(java.lang.String newCustomerNumber);
	/**
	 * Get accessor for persistent attribute: createdDate
	 * @return Date
	 * 
	 */
	public abstract java.sql.Date getCreatedDate();
	/**
	 * Set accessor for persistent attribute: createdDate
	 * @param newCreatedDate
	 */
	public abstract void setCreatedDate(java.sql.Date newCreatedDate);
	/**
	 * Get accessor for persistent attribute: enterpriseName
	 * @return String
	 */
	public abstract java.lang.String getEnterpriseName();
	/**
	 * Set accessor for persistent attribute: enterpriseName
	 * @param newEnterpriseName
	 */
	public abstract void setEnterpriseName(java.lang.String newEnterpriseName);
	/**
	 * Get accessor for persistent attribute: createdBy
	 * @return String
	 */
	public abstract java.lang.String getCreatedBy();
	/**
	 * Set accessor for persistent attribute: createdBy
	 * @param newCreatedBy
	 */
	public abstract void setCreatedBy(java.lang.String newCreatedBy);
	/**
	 * Get accessor for persistent attribute: acceptedDate
	 * @return Date
	 */
	public abstract java.sql.Date getAcceptedDate();
	/**
	 * Set accessor for persistent attribute: acceptedDate
	 * @param newAcceptedDate
	 */
	public abstract void setAcceptedDate(java.sql.Date newAcceptedDate);
	/**
	 * Get accessor for persistent attribute: isElectronicSubmitter
	 * @return String
	 */
	public abstract java.lang.String getIsElectronicSubmitter();
	/**
	 * Set accessor for persistent attribute: isElectronicSubmitter
	 * @param newIsElectronicSubmitter
	 */
	public abstract void setIsElectronicSubmitter(
		java.lang.String newIsElectronicSubmitter);
	/**
	 * Get accessor for persistent attribute: agreementStatus
	 * @return String
	 */
	public abstract java.lang.String getAgreementStatus();
	/**
	 * Set accessor for persistent attribute: agreementStatus
	 * @param newAgreementStatus
	 */
	public abstract void setAgreementStatus(java.lang.String newAgreementStatus);
	/**
	 * Get accessor for persistent attribute: branchOffice
	 * @return String
	 */
	public abstract java.lang.String getBranchOffice();
	/**
	 * Set accessor for persistent attribute: branchOffice
	 * @param newBranchOffice
	 */
	public abstract void setBranchOffice(java.lang.String newBranchOffice);
	/**
	 * Get accessor for persistent attribute: isModifiedAgreement
	 * @return String
	 */
	public abstract java.lang.String getIsModifiedAgreement();
	/**
	 * Set accessor for persistent attribute: isModifiedAgreement
	 * @param newIsModifiedAgreement
	 */
	public abstract void setIsModifiedAgreement(
		java.lang.String newIsModifiedAgreement);
	/**
	 * Get accessor for persistent attribute: coverageType
	 * @return String
	 */
	public abstract java.lang.String getCoverageType();
	/**
	 * Set accessor for persistent attribute: coverageType
	 * @param newCoverageType
	 */
	public abstract void setCoverageType(java.lang.String newCoverageType);
	/**
	 * Get accessor for persistent attribute: customerRepresentative
	 * @return String
	 */
	public abstract java.lang.String getCustomerRepresentative();
	/**
	 * Set accessor for persistent attribute: customerRepresentative
	 * @param newCustomerRepresentative
	 */
	public abstract void setCustomerRepresentative(
		java.lang.String newCustomerRepresentative);
	/**
	 * Get accessor for persistent attribute: imageReferenceNumber
	 * @return String
	 */
	public abstract java.lang.String getImageReferenceNumber();
	/**
	 * Set accessor for persistent attribute: imageReferenceNumber
	 * @param newImageReferenceNumber
	 */
	public abstract void setImageReferenceNumber(
		java.lang.String newImageReferenceNumber);
	/**
	 * Get accessor for persistent attribute: fileNumber
	 * @return String
	 */
	public abstract java.lang.String getFileNumber();
	/**
	 * Set accessor for persistent attribute: fileNumber
	 * @param newFileNumber
	 */
	public abstract void setFileNumber(java.lang.String newFileNumber);
	/**
	 * Get accessor for persistent attribute: oneway
	 * @return String
	 */
	public abstract java.lang.String getOneway();
	/**
	 * Set accessor for persistent attribute: oneway
	 * @param newOneway
	 */
	public abstract void setOneway(java.lang.String newOneway);
	/**
	 * Get accessor for persistent attribute: customerName
	 * @return String
	 */ 
	public abstract java.lang.String getCustomerName();
	/**
	 * Set accessor for persistent attribute: customerName
	 * @param newCustomerName
	 */
	public abstract void setCustomerName(java.lang.String newCustomerName);
	/**
	 * Get accessor for persistent attribute: previousAgreementId
	 * @return Integer
	 */
	public abstract java.lang.Integer getPreviousAgreementId();
	/**
	 * Set accessor for persistent attribute: previousAgreementId
	 * @param newPreviousAgreementId
	 */
	public abstract void setPreviousAgreementId(
		java.lang.Integer newPreviousAgreementId);
	/**
	 * Get accessor for persistent attribute: salesOrganization
	 * @return String
	 */
	public abstract java.lang.String getSalesOrganization();
	/**
	 * Set accessor for persistent attribute: salesOrganization
	 * @param newSalesOrganization
	 */
	public abstract void setSalesOrganization(
		java.lang.String newSalesOrganization);
	/**
	 * Get accessor for persistent attribute: changedBy
	 * @return String
	 */
	public abstract java.lang.String getChangedBy();
	/**
	 * Set accessor for persistent attribute: changedBy
	 * @param newChangedBy
	 */
	public abstract void setChangedBy(java.lang.String newChangedBy);
	/**
	 * Get accessor for persistent attribute: changedDate
	 * @return Date
	 */
	public abstract java.sql.Date getChangedDate();
	
	/**
	 * Set accessor for persistent attribute: changedDate
	 * @param  newChangedDate
	 */
	public abstract void setChangedDate(java.sql.Date newChangedDate);
	/**
	 * Get accessor for persistent attribute: expirationDate
	 * @return Date
	 */
	public abstract java.sql.Date getExpirationDate();
	/**
	 * Set accessor for persistent attribute: expirationDate
	 * @param newExpirationDate
	 */
	public abstract void setExpirationDate(java.sql.Date newExpirationDate);
	/**
	 * Get accessor for persistent attribute: inac
	 * @return String
	 */
	public abstract java.lang.String getInac();
	/**
	 * Set accessor for persistent attribute: inac
	 * @param newInac
	 */
	public abstract void setInac(java.lang.String newInac);
	/**
	 * Get accessor for persistent attribute: legacyCustomerNumber
	 * @return String
	 */
	public abstract java.lang.String getLegacyCustomerNumber();
	/**
	 * Set accessor for persistent attribute: legacyCustomerNumber
	 * @param newLegacyCustomerNumber
	 */
	public abstract void setLegacyCustomerNumber(
		java.lang.String newLegacyCustomerNumber);
	/**
	 * Get accessor for persistent attribute: legalContactHdr
	 * @return String
	 */
	public abstract java.lang.String getLegalContactHdr();
	/**
	 * Set accessor for persistent attribute: legalContactHdr
	 * @param newLegalContactHdr
	 */
	public abstract void setLegalContactHdr(java.lang.String newLegalContactHdr);
	/**
	 * Get accessor for persistent attribute: accountingContactHdr
	 * @return String
	 */
	public abstract java.lang.String getAccountingContactHdr();
	/**
	 * Set accessor for persistent attribute: accountingContactHdr
	 * @param newAccountingContactHdr
	 */
	public abstract void setAccountingContactHdr(
		java.lang.String newAccountingContactHdr);
}
