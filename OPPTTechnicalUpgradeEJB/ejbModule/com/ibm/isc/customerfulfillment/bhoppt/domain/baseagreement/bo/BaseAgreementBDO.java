/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo;

import java.sql.Date;

/**
 * BaseAgreementBDO class represents attribute defined in BaseAgreement Entity
 * This data can be validated using BaseAgreementBO Business Object class
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
public class BaseAgreementBDO {
	
	private int agreementId = 0;
	private String salesOrganization = null;
	private Date createdDate = null;
	private String agreementNumber = null;
	private String formNumber = null;
	private String customerNumber = null;
	private String customerName = null;
	private String enterpriseNumber = null;
	private String createdBy = null;
	private String isElectronicSubmitter = null;
	private Date acceptedDate = null;
	private String agreementStatus = null;
	private String branchOffice = null;
	private String isModifiedAgreement = null;
	private String coverageType = null;
	private String customerRepresentative = null;
	private String imageReferenceNumber = null;
	private int previousAgreementId = 0;
	private String fileNumber = null;
	private String oneWay = null;
	private String enterpriseName = null;
	private String changedBy = null;
	private Date changedDate = null;
	private Date expirationDate = null;
	private String inac = null;
	private String legacyCustomerNumber = null;
	private String legalContactHdr = null; 
	private String accountingContactHdr = null;
	private String language = null;

	
	
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
	 * @return Returns the isElectronicSubmitter.
	 */
	public String getIsElectronicSubmitter() {
		return isElectronicSubmitter;
	}
	/**
	 * @param isElectronicSubmitter The isElectronicSubmitter to set.
	 */
	public void setIsElectronicSubmitter(String isElectronicSubmitter) {
		this.isElectronicSubmitter = isElectronicSubmitter;
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
	 * @return Returns the previousAgreementId.
	 */
	public int getPreviousAgreementId() {
		return previousAgreementId;
	}
	/**
	 * @param previousAgreementId The previousAgreementId to set.
	 */
	public void setPreviousAgreementId(int previousAgreementId) {
		this.previousAgreementId = previousAgreementId;
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
	 * @return Returns the oneWay.
	 */
	public String getOneWay() {
		return oneWay;
	}
	/**
	 * @param oneWay The oneWay to set.
	 */
	public void setOneWay(String oneWay) {
		this.oneWay = oneWay;
	}
	
    /**
     *gets the  accountingContactHdr
     *
     * @return Returns the accountingContactHdr.
     */
    public String getAccountingContactHdr() {
        return accountingContactHdr;
    }
    /**
     * sets the accountingContactHdr
     * @param accountingContactHdr The accountingContactHdr to set.
     */
    public void setAccountingContactHdr(String accountingContactHdr) {
        this.accountingContactHdr = accountingContactHdr;
    }
    /**
     *gets the  inac
     *
     * @return Returns the inac.
     */
    public String getInac() {
        return inac;
    }
    /**
     * sets the inac
     * @param inac The inac to set.
     */
    public void setInac(String inac) {
        this.inac = inac;
    }
    /**
     *gets the  legacyCustomerNumber
     *
     * @return Returns the legacyCustomerNumber.
     */
    public String getLegacyCustomerNumber() {
        return legacyCustomerNumber;
    }
    /**
     * sets the legacyCustomerNumber
     * @param legacyCustomerNumber The legacyCustomerNumber to set.
     */
    public void setLegacyCustomerNumber(String legacyCustomerNumber) {
        this.legacyCustomerNumber = legacyCustomerNumber;
    }
    /**
     *gets the  legalContactHdr
     *
     * @return Returns the legalContactHdr.
     */
    public String getLegalContactHdr() {
        return legalContactHdr;
    }
    /**
     * sets the legalContactHdr
     * @param legalContactHdr The legalContactHdr to set.
     */
    public void setLegalContactHdr(String legalContactHdr) {
        this.legalContactHdr = legalContactHdr;
    }
    
    /**
     *gets the  language
     *
     * @return Returns the language.
     */
    public String getLanguage() {
        return language;
    }
    /**
     * sets the language
     * @param language The language to set.
     */
    public void setLanguage(String language) {
        this.language = language;
    }
}
