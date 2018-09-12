/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Bean implementation class for Enterprise Bean: BaseAgreementModificationDetails
 */
public abstract class BaseAgreementModificationDetailsBean
	implements
		javax.ejb.EntityBean {
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
	 * @param modificationTypeCode
	 * @return BaseAgreementModificationDetailsKey
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey ejbCreate(
		java.lang.Integer agreementId,
		java.lang.String modificationTypeCode) throws javax.ejb.CreateException {
		setAgreementId(agreementId);
		setModificationTypeCode(modificationTypeCode);
		return null;
	}
	/**
	 * ejbPostCreate
	 * @param agreementId
	 * @param modificationTypeCode
	 * @throws CreateException
	 */
	public void ejbPostCreate(
		java.lang.Integer agreementId,
		java.lang.String modificationTypeCode) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: modificationTypeCode
	 * @return String
	 */
	public abstract java.lang.String getModificationTypeCode();
	/**
	 * Set accessor for persistent attribute: modificationTypeCode
	 * @param newModificationTypeCode
	 */
	public abstract void setModificationTypeCode(
		java.lang.String newModificationTypeCode);
	/**
	 * Get accessor for persistent attribute: legalContract
	 * @return String
	 */
	public abstract java.lang.String getLegalContract();
	/**
	 * Set accessor for persistent attribute: legalContract
	 * @param newLegalContract
	 */
	public abstract void setLegalContract(java.lang.String newLegalContract);
	/**
	 * Get accessor for persistent attribute: accountingContact
	 * @return String
	 */
	public abstract java.lang.String getAccountingContact();
	/**
	 * Set accessor for persistent attribute: accountingContact
	 * @param newAccountingContact
	 */
	public abstract void setAccountingContact(
		java.lang.String newAccountingContact);
	/**
	 * Get accessor for persistent attribute: revenueRecognition
	 * @return String
	 */
	public abstract java.lang.String getRevenueRecognition();
	/**
	 * Set accessor for persistent attribute: revenueRecognition
	 * @param newRevenueRecognition
	 */
	public abstract void setRevenueRecognition(
		java.lang.String newRevenueRecognition);
	/**
	 * Get accessor for persistent attribute: modifiedIBMLetterHead
	 * @return String
	 */
	public abstract java.lang.String getModifiedIBMLetterHead();
	/**
	 * Set accessor for persistent attribute: modifiedIBMLetterHead
	 * @param newModifiedIBMLetterHead
	 */
	public abstract void setModifiedIBMLetterHead(
		java.lang.String newModifiedIBMLetterHead);
	/**
	 * Get accessor for persistent attribute: details
	 * @return String
	 */
	public abstract java.lang.String getDetails();
	/**
	 * Set accessor for persistent attribute: details
	 * @param newDetails
	 */
	public abstract void setDetails(java.lang.String newDetails);
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
	 * Get accessor for persistent attribute: createdDate
	 * @return Date
	 */
	public abstract java.sql.Date getCreatedDate();
	/**
	 * Set accessor for persistent attribute: createdDate
	 * @param newCreatedDate
	 */
	public abstract void setCreatedDate(java.sql.Date newCreatedDate);
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
	 * @param newChangedDate
	 */
	public abstract void setChangedDate(java.sql.Date newChangedDate);
	/**
	 * Get accessor for persistent attribute: modificationOption
	 * @return String
	 * 
	 */
	public abstract java.lang.String getModificationOption();
	/**
	 * Set accessor for persistent attribute: modificationOption
	 * @param newModificationOption
	 */
	public abstract void setModificationOption(
		java.lang.String newModificationOption);
	/**
	 * Get accessor for persistent attribute: rolStartDate
	 * @return Date
	 */
	public abstract java.sql.Date getRolStartDate();
	/**
	 * Set accessor for persistent attribute: rolStartDate
	 * @param newRolStartDate
	 */
	public abstract void setRolStartDate(java.sql.Date newRolStartDate);
	/**
	 * Get accessor for persistent attribute: rolEndDate
	 * @return Date
	 */
	public abstract java.sql.Date getRolEndDate();
	/**
	 * Set accessor for persistent attribute: rolEndDate
	 * @param newRolEndDate
	 */
	public abstract void setRolEndDate(java.sql.Date newRolEndDate);
    /**
     * Get accessor for persistent attribute: status
     * @return String
     */
    public abstract java.lang.String getStatus();
    /**
     * Set accessor for persistent attribute: status
     * @param newStatus
     */
    public abstract void setStatus(java.lang.String newStatus);
}
