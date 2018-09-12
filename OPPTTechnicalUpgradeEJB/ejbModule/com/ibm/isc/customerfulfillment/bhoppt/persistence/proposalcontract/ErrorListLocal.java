/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local interface for Enterprise Bean: ErrorList
 */
public interface ErrorListLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: messageNO
	 */
	public double getMessageNO();
	/**
	 * Set accessor for persistent attribute: messageNO
	 */
	public void setMessageNO(double newMessageNO);
	/**
	 * Get accessor for persistent attribute: className
	 */
	public java.lang.String getClassName();
	/**
	 * Set accessor for persistent attribute: className
	 */
	public void setClassName(java.lang.String newClassName);
	/**
	 * Get accessor for persistent attribute: methodName
	 */
	public java.lang.String getMethodName();
	/**
	 * Set accessor for persistent attribute: methodName
	 */
	public void setMethodName(java.lang.String newMethodName);
	/**
	 * Get accessor for persistent attribute: messageDesc
	 */
	public java.lang.String getMessageDesc();
	/**
	 * Set accessor for persistent attribute: messageDesc
	 */
	public void setMessageDesc(java.lang.String newMessageDesc);
	/**
	 * Get accessor for persistent attribute: messageDetail
	 */
	public java.lang.String getMessageDetail();
	/**
	 * Set accessor for persistent attribute: messageDetail
	 */
	public void setMessageDetail(java.lang.String newMessageDetail);
	/**
	 * Get accessor for persistent attribute: userId
	 */
	public java.lang.String getUserId();
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public void setUserId(java.lang.String newUserId);
	/**
	 * Get accessor for persistent attribute: date
	 */
	public java.sql.Date getDate();
	/**
	 * Set accessor for persistent attribute: date
	 */
	public void setDate(java.sql.Date newDate);
	/**
	 * Get accessor for persistent attribute: time
	 */
	public java.sql.Time getTime();
	/**
	 * Set accessor for persistent attribute: time
	 */
	public void setTime(java.sql.Time newTime);
	/**
		 * Get accessor for persistent attribute: messageId
		 */
	public java.lang.Integer getMessageId();
	/**
		 * Set accessor for persistent attribute: messageId
		 */
	public void setMessageId(java.lang.Integer newMessageId);
}
