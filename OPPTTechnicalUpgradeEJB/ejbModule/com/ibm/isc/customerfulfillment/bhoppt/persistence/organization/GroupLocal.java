/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local interface for Enterprise Bean: Group
 */
public interface GroupLocal extends javax.ejb.EJBLocalObject
{
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public java.lang.String getSalesOrg();
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg);
	/**
	 * Get accessor for persistent attribute: groupName
	 */
	public java.lang.String getGroupName();
	/**
	 * Set accessor for persistent attribute: groupName
	 */
	public void setGroupName(java.lang.String newGroupName);
}
