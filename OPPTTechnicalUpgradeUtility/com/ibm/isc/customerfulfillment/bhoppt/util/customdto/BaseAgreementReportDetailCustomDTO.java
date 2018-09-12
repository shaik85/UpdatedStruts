/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementReportDetailCustomDTO extends OPPTCustomDTO {

	private String inputStatus = null;
	
	private String SalesOrg = null;

	private String status = null;

	private String inac = null; 

	private String legacyCustomerNumber = null;

	private String enterpriseNumber = null;
	
	private String customerNumber = null;

	private String customerName = null;

	private String formNumber = null;

	private String versionNo = null;

	private String formShortDescription = null;

	private String formLongDescription = null;

	private String agreementNumber = null;

	private Date acceptedDate = null;

	private Date expirationDate =null;

	private Date createdDate =null;

	private Date  changedDate = null;
	
	private String  modificationTypeCode = null;
	
	private String modificationDetails = null;

	private String[] modTypes = null;
	
	private String[] formNumbers = null;
	
	private List modDetails = null;
	
	private String isModifiedAgreement = null;
	
	private int agreementId = 0;

	private String legalContract = null;
	private String accountingContact = null;
	private String modifiedLetterHead = null;
	private String revenueRecognition = null;
	private String details = null;
	private String createdBy = null;
	private Date modCreatedDate = null;
	private String changedBy = null;
	private Date modChangedDate = null;
	
	
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
	 * @return Returns the modChangedDate.
	 */
	public Date getModChangedDate() {
		return modChangedDate;
	}
	/**
	 * @param modChangedDate The modChangedDate to set.
	 */
	public void setModChangedDate(Date modChangedDate) {
		this.modChangedDate = modChangedDate;
	}
	/**
	 * @return Returns the modCreatedDate.
	 */
	public Date getModCreatedDate() {
		return modCreatedDate;
	}
	/**
	 * @param modCreatedDate The modCreatedDate to set.
	 */
	public void setModCreatedDate(Date modCreatedDate) {
		this.modCreatedDate = modCreatedDate;
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
	 * @return Returns the modDetails.
	 */
	public List getModDetails() {
		return modDetails;
	}
	/**
	 * @param modDetails The modDetails to set.
	 */
	public void setModDetails(List modDetails) {
		this.modDetails = modDetails;
	}
	/**
	 * @return Returns the formNumbers.
	 */
	public String[] getFormNumbers() {
		return formNumbers;
	}
	/**
	 * @param formNumbers The formNumbers to set.
	 */
	public void setFormNumbers(String[] formNumbers) {
		this.formNumbers = formNumbers;
	}
	/**
	 * @return Returns the modTypes.
	 */
	public String[] getModTypes() {
		return modTypes;
	}
	/**
	 * @param modTypes The modTypes to set.
	 */
	public void setModTypes(String[] modTypes) {
		this.modTypes = modTypes;
	}
	
	
	/**
	 * @return Returns the isModifiedAgreement.
	 */
	public String getIsModifiedAgreement() {
		return isModifiedAgreement;
	}
	/**
	 * @param isModifiedAgreement The isModifiedAgreement to set.
	 */
	public void setIsModifiedAgreement(String isModifiedAgreement) {
		this.isModifiedAgreement = isModifiedAgreement;
	}
	/**
	 * @return Returns the acceptedDate.
	 */
	public Date getAcceptedDate() {
		return acceptedDate;
	}
	/**
	 * @param acceptedDate The acceptedDate to set.
	 */
	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}
	/**
	 * @return Returns the agreementNumber.
	 */
	public String getAgreementNumber() {
		return agreementNumber;
	}
	/**
	 * @param agreementNumber The agreementNumber to set.
	 */
	public void setAgreementNumber(String agreementNumber) {
		this.agreementNumber = agreementNumber;
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
	 * @return Returns the customerName.
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return Returns the customerNumber.
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber The customerNumber to set.
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	/**
	 * @return Returns the enterpriseNumber.
	 */
	public String getEnterpriseNumber() {
		return enterpriseNumber;
	}
	/**
	 * @param enterpriseNumber The enterpriseNumber to set.
	 */
	public void setEnterpriseNumber(String enterpriseNumber) {
		this.enterpriseNumber = enterpriseNumber;
	}
	/**
	 * @return Returns the expirationDate.
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}
	/**
	 * @param expirationDate The expirationDate to set.
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	/**
	 * @return Returns the formLongDescription.
	 */
	public String getFormLongDescription() {
		return formLongDescription;
	}
	/**
	 * @param formLongDescription The formLongDescription to set.
	 */
	public void setFormLongDescription(String formLongDescription) {
		this.formLongDescription = formLongDescription;
	}
	/**
	 * @return Returns the formNumber.
	 */
	public String getFormNumber() {
		return formNumber;
	}
	/**
	 * @param formNumber The formNumber to set.
	 */
	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}
	
	/**
	 * @return Returns the formShortDescription.
	 */
	public String getFormShortDescription() {
		return formShortDescription;
	}
	/**
	 * @param formShortDescription The formShortDescription to set.
	 */
	public void setFormShortDescription(String formShortDescription) {
		this.formShortDescription = formShortDescription;
	}
	/**
	 * @return Returns the inac.
	 */
	public String getInac() {
		return inac;
	}
	/**
	 * @param inac The inac to set.
	 */
	public void setInac(String inac) {
		this.inac = inac;
	}
	/**
	 * @return Returns the legacyCustomerNumber.
	 */
	public String getLegacyCustomerNumber() {
		return legacyCustomerNumber;
	}
	/**
	 * @param legacyCustomerNumber The legacyCustomerNumber to set.
	 */
	public void setLegacyCustomerNumber(String legacyCustomerNumber) {
		this.legacyCustomerNumber = legacyCustomerNumber;
	}
	/**
	 * @return Returns the modificationDetails.
	 */
	public String getModificationDetails() {
		return modificationDetails;
	}
	/**
	 * @param modificationDetails The modificationDetails to set.
	 */
	public void setModificationDetails(String modificationDetails) {
		this.modificationDetails = modificationDetails;
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
	 * @return Returns the modtypes.
	 */
	public Set getModtypes() {
		return modtypes;
	}
	/**
	 * @param modtypes The modtypes to set.
	 */
	public void setModtypes(Set modtypes) {
		this.modtypes = modtypes;
	}
	/**
	 * @return Returns the salesOrg.
	 */
	public String getSalesOrg() {
		return SalesOrg;
	}
	/**
	 * @param salesOrg The salesOrg to set.
	 */
	public void setSalesOrg(String salesOrg) {
		SalesOrg = salesOrg;
	}
	/**
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return Returns the versionNo.
	 */
	public String getVersionNo() {
		return versionNo;
	}
	/**
	 * @param versionNo The versionNo to set.
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	private Set  modtypes = null;


	/**
	 * @return Returns the inputStatus.
	 */
	public String getInputStatus() {
		return inputStatus;
	}
	/**
	 * @param inputStatus The inputStatus to set.
	 */
	public void setInputStatus(String inputStatus) {
		this.inputStatus = inputStatus;
	}
}
