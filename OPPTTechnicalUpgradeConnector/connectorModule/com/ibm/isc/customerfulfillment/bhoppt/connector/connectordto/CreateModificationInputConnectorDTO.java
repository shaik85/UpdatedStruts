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
public class CreateModificationInputConnectorDTO implements ConnectorDTOInterface {

	private String functionModuleName;
	private String sessionID;
	private String agreementId;
	private String modificationType;
	private String modificationOption; // For ROL this will be ROL Specific event
	private String modificationDescription;
	private String modificationActive;
	private Date rolStartDate;
	private Date rolEndDate;
	private String revenueRecognition;
	private String createdBy;
	private Date createdOn;
	private String changedBy;
	private Date changedOn;
	
	
	
	/**
	 * 
	 *Constructor
	 */
	public CreateModificationInputConnectorDTO() {
		
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
	 * @return Returns the createdOn.
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn The createdOn to set.
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * @return Returns the modificationActive.
	 */
	public String getModificationActive() {
		return modificationActive;
	}
	/**
	 * @param modificationActive The modificationActive to set.
	 */
	public void setModificationActive(String modificationActive) {
		this.modificationActive = modificationActive;
	}
	/**
	 * @return Returns the modificationDescription.
	 */
	public String getModificationDescription() {
		return modificationDescription;
	}
	/**
	 * @param modificationDescription The modificationDescription to set.
	 */
	public void setModificationDescription(String modificationDescription) {
		this.modificationDescription = modificationDescription;
	}
	/**
	 * @return Returns the modificationOption.
	 */
	public String getModificationOption() {
		return modificationOption;
	}
	/**
	 * @param modificationOption The modificationOption to set.
	 */
	public void setModificationOption(String modificationOption) {
		this.modificationOption = modificationOption;
	}
	/**
	 * @return Returns the modificationType.
	 */
	public String getModificationType() {
		return modificationType;
	}
	/**
	 * @param modificationType The modificationType to set.
	 */
	public void setModificationType(String modificationType) {
		this.modificationType = modificationType;
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
}
