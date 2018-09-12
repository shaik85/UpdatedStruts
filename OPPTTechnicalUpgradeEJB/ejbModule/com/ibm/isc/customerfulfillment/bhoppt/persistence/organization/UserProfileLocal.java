/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local interface for Enterprise Bean: UserProfile
 */
public interface UserProfileLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: role
	 */
	public java.lang.String getRole();
	/**
	 * Set accessor for persistent attribute: role
	 */
	public void setRole(java.lang.String newRole);
	/**
	 * Get accessor for persistent attribute: assoSalesOrg
	 */
	public java.lang.String getAssoSalesOrg();
	/**
	 * Set accessor for persistent attribute: assoSalesOrg
	 */
	public void setAssoSalesOrg(java.lang.String newAssoSalesOrg);
	/**
	 * Get accessor for persistent attribute: authorization
	 */
	public java.lang.String getAuthorization();
	/**
	 * Set accessor for persistent attribute: authorization
	 */
	public void setAuthorization(java.lang.String newAuthorization);
	/**
	 * Get accessor for persistent attribute: approverId
	 */
	public java.lang.String getApproverId();
	/**
	 * Set accessor for persistent attribute: approverId
	 */
	public void setApproverId(java.lang.String newApproverId);
	/**
	 * Get accessor for persistent attribute: groupName
	 */
	public java.lang.String getGroupName();
	/**
	 * Set accessor for persistent attribute: groupName
	 */
	public void setGroupName(java.lang.String newGroupName);
	/**
	 * Get accessor for persistent attribute: bpAccessIndicator
	 */
	public java.lang.String getBpAccessIndicator();
	/**
	 * Set accessor for persistent attribute: bpAccessIndicator
	 */
	public void setBpAccessIndicator(java.lang.String newBpAccessIndicator);
	/**
	 * Get accessor for persistent attribute: userId
	 */
	public java.lang.String getUserId();
	/**
	 * Set accessor for persistent attribute: userId
	 */
	public void setUserId(java.lang.String newUserId);
	/**
	 * Get accessor for persistent attribute: lastLoginDate
	 */
	public java.sql.Date getLastLoginDate();
	/**
	 * Set accessor for persistent attribute: lastLoginDate
	 */
	public void setLastLoginDate(java.sql.Date newLastLoginDate);
	/**
	 * Get accessor for persistent attribute: firstName
	 */
	public java.lang.String getFirstName();
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public void setFirstName(java.lang.String newFirstName);
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public java.lang.String getLastName();
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public void setLastName(java.lang.String newLastName);
	/**
	 * Get accessor for persistent attribute: userType
	 */
	public java.lang.String getUserType();
	/**
	 * Set accessor for persistent attribute: userType
	 */
	public void setUserType(java.lang.String newUserType);
	/**
	 * Get accessor for persistent attribute: BARole
	 */
	public java.lang.String getBaRole();
	/**
	 * Set accessor for persistent attribute: BARole
	 */
	public void setBaRole(java.lang.String newBARole);
	
}
