/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo;

import java.sql.Date;

/**
 * BaseAgreementModificationDetailsBDO class represents attribute defined in BaseAgreementModificationDetails Entity
 * This data can be validated using BaseAgreementModificationDetailsBO Business Object class
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jun 14, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Sasi R Challa
 * @version CBS 2.1
 */
public class BaseAgreementModificationDetailsBDO {
	
	private int agreementId = 0;
	private String modificationTypeCode = null;
	private String legalContract = null;
	private String accountingContact = null;
	private String revenueRecognition = null;
	private String modifiedIBMLetterHead = null;
	private Date rolStartDate = null;
	private Date rolEndDate = null;
	private String modificationOption = null;
	private String details = null;
	private String createdBy = null;
	private String changedBy = null;
	private Date createdDate = null;
	private Date changedDate = null;
	private String modStatus = null;
	
	/**
	 * @return Returns the accountingContact.
	 */
	public String getAccountingContact() {
		return accountingContact;
	}
	/**
	 * @param accountingContact The accountingContact to set.
	 */
	public void setAccountingContact(String accountingContact) {
		this.accountingContact = accountingContact;
	}
	/**
	 * @return Returns the agreementId.
	 */
	public int getAgreementId() {
		return agreementId;
	}
	/**
	 * @param agreementId The agreementId to set.
	 */
	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}
	/**
	 * @return Returns the details.
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details The details to set.
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return Returns the legalContract.
	 */
	public String getLegalContract() {
		return legalContract;
	}
	/**
	 * @param legalContract The legalContract to set.
	 */
	public void setLegalContract(String legalContract) {
		this.legalContract = legalContract;
	}
	/**
	 * @return Returns the modificationTypeCode.
	 */
	public String getModificationTypeCode() {
		return modificationTypeCode;
	}
	/**
	 * @param modificationTypeCode The modificationTypeCode to set.
	 */
	public void setModificationTypeCode(String modificationTypeCode) {
		this.modificationTypeCode = modificationTypeCode;
	}
	
	/**
	 * @return Returns the revenueRecognition.
	 */
	public String getRevenueRecognition() {
		return revenueRecognition;
	}
	/**
	 * @param revenueRecognition The revenueRecognition to set.
	 */
	public void setRevenueRecognition(String revenueRecognition) {
		this.revenueRecognition = revenueRecognition;
	}
	
	
	/**
	 * @return Returns the changedBy.
	 */
	public String getChangedBy() {
		return changedBy;
	}
	/**
	 * @param changedBy The changedBy to set.
	 */
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	/**
	 * @return Returns the changedDate.
	 */
	public Date getChangedDate() {
		return changedDate;
	}
	/**
	 * @param changedDate The changedDate to set.
	 */
	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}
	/**
	 * @return Returns the createdBy.
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy The createdBy to set.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return Returns the createdDate.
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate The createdDate to set.
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return Returns the modifiedIBMLetterHead.
	 */
	public String getModifiedIBMLetterHead() {
		return modifiedIBMLetterHead;
	}
	/**
	 * @param modifiedIBMLetterHead The modifiedIBMLetterHead to set.
	 */
	public void setModifiedIBMLetterHead(String modifiedIBMLetterHead) {
		this.modifiedIBMLetterHead = modifiedIBMLetterHead;
	}
	/**
	 * @return Returns the modificationOptions.
	 */
	public String getModificationOption() {
		return modificationOption;
	}
	/**
	 * @param modificationOptions The modificationOptions to set.
	 */
	public void setModificationOption(String modificationOption) {
		this.modificationOption = modificationOption;
	}
	/**
	 * @return Returns the rolEndDate.
	 */
	public Date getRolEndDate() {
		return rolEndDate;
	}
	/**
	 * @param rolEndDate The rolEndDate to set.
	 */
	public void setRolEndDate(Date rolEndDate) {
		this.rolEndDate = rolEndDate;
	}
	/**
	 * @return Returns the rolStartDate.
	 */
	public Date getRolStartDate() {
		return rolStartDate;
	}
	/**
	 * @param rolStartDate The rolStartDate to set.
	 */
	public void setRolStartDate(Date rolStartDate) {
		this.rolStartDate = rolStartDate;
	}
	
    /**
     *gets the  modStatus
     *
     * @return Returns the modStatus.
     */
    public String getModStatus() {
        return modStatus;
    }
    /**
     * sets the modStatus
     * @param modStatus The modStatus to set.
     */
    public void setModStatus(String modStatus) {
        this.modStatus = modStatus;
    }
}
