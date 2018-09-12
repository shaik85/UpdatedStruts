/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds base agreement modification details data.  
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
public class ModificationCustomDTO extends OPPTCustomDTO {
	
	private int agreementId = 0;
	private String modificationTypeCode = null;
	private String legalContract = null;
	private String accountingContact = null;
	private String modifiedLetterHead = null;
	private String revenueRecognition = null;
	private String details = null;
	private String createdBy = null;
	private Date createdDate = null;
	private String changedBy = null;
	private Date changedDate = null;
	/**
	 * ststus field....added by tapan malhotra
	 */
	private String Status = null;
	
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
	 * @return Returns the modifiedLetterHead.
	 */
	public String getModifiedLetterHead() {
		return modifiedLetterHead;
	}
	/**
	 * @param modifiedLetterHead The modifiedLetterHead to set.
	 */
	public void setModifiedLetterHead(String modifiedLetterHead) {
		this.modifiedLetterHead = modifiedLetterHead;
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
	 * @return Returns the status.
	 */
	public String getStatus() {
		return Status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		Status = status;
	}
}
