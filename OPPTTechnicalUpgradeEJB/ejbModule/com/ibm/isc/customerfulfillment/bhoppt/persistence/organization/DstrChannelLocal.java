/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local interface for Enterprise Bean: DstrChannel
 */
public interface DstrChannelLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: distributionChannelDesc
	 */
	public java.lang.String getDistributionChannelDesc();
	/**
	 * Set accessor for persistent attribute: distributionChannelDesc
	 */
	public void setDistributionChannelDesc(
		java.lang.String newDistributionChannelDesc);
	/**
	 * Get accessor for persistent attribute: distributionChannel
	 */
	public java.lang.String getDistributionChannel();
	/**
	 * Set accessor for persistent attribute: distributionChannel
	 */
	public void setDistributionChannel(java.lang.String newDistributionChannel);
	/**
	 * Get accessor for persistent attribute: salesGroup
	 */
	public java.lang.String getSalesGroup();
	/**
	 * Set accessor for persistent attribute: salesGroup
	 */
	public void setSalesGroup(java.lang.String newSalesGroup);
	/**
	 * Get accessor for persistent attribute: channelRole
	 */
	public java.lang.String getChannelRole();
	/**
	 * Set accessor for persistent attribute: channelRole
	 */
	public void setChannelRole(java.lang.String newChannelRole);
	/**
	 * Get accessor for persistent attribute: submitterRole
	 */
	public java.lang.String getSubmitterRole();
	/**
	 * Set accessor for persistent attribute: submitterRole
	 */
	public void setSubmitterRole(java.lang.String newSubmitterRole);
}
