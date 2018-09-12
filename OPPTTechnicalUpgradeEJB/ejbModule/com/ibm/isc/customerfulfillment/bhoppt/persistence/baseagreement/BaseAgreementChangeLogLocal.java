/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local interface for Enterprise Bean: BaseAgreementChangeLog
 */
public interface BaseAgreementChangeLogLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: changeId
	 * @return Integer
	 */
	public java.lang.Integer getChangeId();
	/**
	 * Set accessor for persistent attribute: changeId
	 * @param newChangeId
	 */
	public void setChangeId(java.lang.Integer newChangeId);
	/**
	 * Get accessor for persistent attribute: agreementId
	 * @return Integer
	 */
	public java.lang.Integer getAgreementId();
	/**
	 * Set accessor for persistent attribute: agreementId
	 * @param newAgreementId
	 */
	public void setAgreementId(java.lang.Integer newAgreementId);
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
	 * Get accessor for persistent attribute: changedDate
	 * @return Date
	 */
	public java.sql.Date getChangedDate();
	/**
	 * Set accessor for persistent attribute: changedDate
	 * @param newChangedDate
	 */
	public void setChangedDate(java.sql.Date newChangedDate);
	/**
	 * Get accessor for persistent attribute: changedTime
	 * @return java.sql.Time
	 */
	public java.sql.Time getChangedTime();
	/**
	 * Set accessor for persistent attribute: changedTime
	 * @param newChangedTime
	 */
	public void setChangedTime(java.sql.Time newChangedTime);
	/**
	 * Get accessor for persistent attribute: changedDetails
	 * @return String
	 */
	public java.lang.String getChangedDetails();
	/**
	 * Set accessor for persistent attribute: changedDetails
	 * @param newChangedDetails
	 */
	public void setChangedDetails(java.lang.String newChangedDetails);
}
