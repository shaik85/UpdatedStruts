/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.Date;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds data to create and modify the base agreement.  
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
public class BaseAgreementDetailsCustomDTO extends OPPTCustomDTO {
	
	private TreeMap modificationDetailsMap = null;
	private int agreementId = 0;
	private String agreementNumber = null;
	private Date entryDate = null;
	private Date acceptedDate = null;
	private String formNumber = null;
	private String fileNumber = null;
	private String customerNumber = null;
	private String enterpriseNumber = null;
	private String coverageType = null;
	private String branchOffice = null;
	private String customerRepresentative = null;
	//private String contractSubmitter = null;
	private String agreementStatus = null;
	private String isElectronicSumbmitter = null;
	private String createdBy = null;
	private String formShortDescription = null;
	private String formLongDescription = null;
	private String imageReferenceNumber = null;
	private String oneWay = null;
	private String customerName = null;
	private String enterpriseName = null;
	private String isModified = null;
	private String salesOrganization = null;
	private String changedBy = null;
	private Date changedDate = null;
	private Date expirationDate = null;
	private boolean showModificationDetails = true;
	private String legalContactHdr = null;
	private String accountingContactHdr=null;
	private String legacyCustomerNumber=null;
	private String inac =null;
	/**
	 * modificationStatus field added by tapan malhotra
	 */
	private String modificationStatus=null;
	
	
	/**
	 * @return Returns the modificationStatus.
	 */
	public String getModificationStatus() {
		return modificationStatus;
	}
	/**
	 * @param modificationStatus The modificationStatus to set.
	 */
	public void setModificationStatus(String modificationStatus) {
		this.modificationStatus = modificationStatus;
	}
	/**
	 * @return Returns the accountingContactHdr.
	 */
	public String getAccountingContactHdr() {
		return accountingContactHdr;
	}
	/**
	 * @param accountingContactHdr The accountingContactHdr to set.
	 */
	public void setAccountingContactHdr(String accountingContactHdr) {
		this.accountingContactHdr = accountingContactHdr;
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
	 * @return Returns the legalContactHdr.
	 */
	public String getLegalContactHdr() {
		return legalContactHdr;
	}
	/**
	 * @param legalContactHdr The legalContactHdr to set.
	 */
	public void setLegalContactHdr(String legalContactHdr) {
		this.legalContactHdr = legalContactHdr;
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
	 * @return Returns the branchOffice.
	 */
	public String getBranchOffice() {
		return branchOffice;
	}
	/**
	 * @param branchOffice The branchOffice to set.
	 */
	public void setBranchOffice(String branchOffice) {
		this.branchOffice = branchOffice;
	}
	
	/**
	 * @return Returns the coverageType.
	 */
	public String getCoverageType() {
		return coverageType;
	}
	/**
	 * @param coverageType The coverageType to set.
	 */
	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
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
	 * @return Returns the customerRepresentative.
	 */
	public String getCustomerRepresentative() {
		return customerRepresentative;
	}
	/**
	 * @param customerRepresentative The customerRepresentative to set.
	 */
	public void setCustomerRepresentative(String customerRepresentative) {
		this.customerRepresentative = customerRepresentative;
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
	 * @return Returns the entryDate.
	 */
	public Date getEntryDate() {
		return entryDate;
	}
	/**
	 * @param entryDate The entryDate to set.
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	/**
	 * @return Returns the fileNumber.
	 */
	public String getFileNumber() {
		return fileNumber;
	}
	/**
	 * @param fileNumber The fileNumber to set.
	 */
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
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
	 * @return Returns the imageReferenceNumber.
	 */
	public String getImageReferenceNumber() {
		return imageReferenceNumber;
	}
	/**
	 * @param imageReferenceNumber The imageReferenceNumber to set.
	 */
	public void setImageReferenceNumber(String imageReferenceNumber) {
		this.imageReferenceNumber = imageReferenceNumber;
	}
	/**
	 * @return Returns the isElectronicSumbmitter.
	 */
	public String getIsElectronicSumbmitter() {
		return isElectronicSumbmitter;
	}
	/**
	 * @param isElectronicSumbmitter The isElectronicSumbmitter to set.
	 */
	public void setIsElectronicSumbmitter(String isElectronicSumbmitter) {
		this.isElectronicSumbmitter = isElectronicSumbmitter;
	}
	/**
	 * @return Returns the modificationDetailsMap.
	 */
	public TreeMap getModificationDetailsMap() {
		return modificationDetailsMap;
	}
	/**
	 * @param modificationDetailsMap The modificationDetailsMap to set.
	 */
	public void setModificationDetailsMap(TreeMap modificationDetailsMap) {
		this.modificationDetailsMap = modificationDetailsMap;
	}
	/**
	 * @return Returns the oneway.
	 */
	public String getOneWay() {
		return oneWay;
	}
	/**
	 * @param oneway The oneway to set.
	 */
	public void setOneWay(String oneWay) {
		this.oneWay = oneWay;
	}
	/**
	 * @return Returns the enterpriseName.
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * @param enterpriseName The enterpriseName to set.
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * @return Returns the agreementStatus.
	 */
	public String getAgreementStatus() {
		return agreementStatus;
	}
	/**
	 * @param agreementStatus The agreementStatus to set.
	 */
	public void setAgreementStatus(String agreementStatus) {
		this.agreementStatus = agreementStatus;
	}
    /**
     * returns the isModified
     *
     * @return Returns the isModified.
     */
    public String getIsModified() {
        return isModified;
    }
    /**
     * sets the isModified
     *
     * @param lIsModified The isModified to set.
     */
    public void setIsModified(String lIsModified) {
        isModified = lIsModified;
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
	 * @return Returns the salesOrganization.
	 */
	public String getSalesOrganization() {
		return salesOrganization;
	}
	/**
	 * @param salesOrganization The salesOrganization to set.
	 */
	public void setSalesOrganization(String salesOrganization) {
		this.salesOrganization = salesOrganization;
	}
	/**
	 * @return Returns the showModificationDetails.
	 */
	public boolean isShowModificationDetails() {
		return showModificationDetails;
	}
	/**
	 * @param showModificationDetails The showModificationDetails to set.
	 */
	public void setShowModificationDetails(boolean showModificationDetails) {
		this.showModificationDetails = showModificationDetails;
	}
}
