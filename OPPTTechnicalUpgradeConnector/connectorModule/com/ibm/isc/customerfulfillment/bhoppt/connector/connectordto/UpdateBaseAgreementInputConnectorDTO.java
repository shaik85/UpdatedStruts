/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * @author balajiv
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UpdateBaseAgreementInputConnectorDTO implements ConnectorDTOInterface {
	
	private String functionModuleName;
	private String sessionID;
	private String salesOrganization;
	private String customerNo;
	private String enterpriseNo;
	private String agreementId;
	private String agreementNo;
	private String agreementStatus;
	private String customerName;
	private String enterpriseName;
	private String formNo;
	private String formShortDescription;
	private String coverageType;
	private Date acceptDate;
	private Date expirationDate;
	private String changedBy;
	private Date changedOn;	
	
	/**
	 * Constructor
	 */
	public UpdateBaseAgreementInputConnectorDTO() {
		
	}
	/**
	 * @return Returns the acceptDate.
	 */
	public Date getAcceptDate() {
		return acceptDate;
	}
	/**
	 * @param acceptDate The acceptDate to set.
	 */
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}
	/**
	 * @return Returns the agreementId.
	 */
	public String getAgreementId() {
		return agreementId;
	}
	/**
	 * @param agreementId The agreementId to set.
	 */
	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}
	/**
	 * @return Returns the agreementNo.
	 */
	public String getAgreementNo() {
		return agreementNo;
	}
	/**
	 * @param agreementNo The agreementNo to set.
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
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
	 * @return Returns the changedOn.
	 */
	public Date getChangedOn() {
		return changedOn;
	}
	/**
	 * @param changedOn The changedOn to set.
	 */
	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
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
	 * @return Returns the customerNo.
	 */
	public String getCustomerNo() {
		return customerNo;
	}
	/**
	 * @param customerNo The customerNo to set.
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	/**
	 * @return Returns the enterpriseNo.
	 */
	public String getEnterpriseNo() {
		return enterpriseNo;
	}
	/**
	 * @param enterpriseNo The enterpriseNo to set.
	 */
	public void setEnterpriseNo(String enterpriseNo) {
		this.enterpriseNo = enterpriseNo;
	}
	/**
	 * @return Returns the formNo.
	 */
	public String getFormNo() {
		return formNo;
	}
	/**
	 * @param formNo The formNo to set.
	 */
	public void setFormNo(String formNo) {
		this.formNo = formNo;
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
	 * @return Returns the functionModuleName.
	 */
	public String getFunctionModuleName() {
		return functionModuleName;
	}
	/**
	 * @param functionModuleName The functionModuleName to set.
	 */
	public void setFunctionModuleName(String functionModuleName) {
		this.functionModuleName = functionModuleName;
	}
	/**
	 * @return Returns the sessionID.
	 */
	public String getSessionID() {
		return sessionID;
	}
	/**
	 * @param sessionID The sessionID to set.
	 */
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
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
}
