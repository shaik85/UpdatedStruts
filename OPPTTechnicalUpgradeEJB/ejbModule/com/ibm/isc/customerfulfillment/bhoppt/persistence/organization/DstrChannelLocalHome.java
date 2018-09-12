/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: DstrChannel
 */
public interface DstrChannelLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: DstrChannel
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal create(
		java.lang.String distributionChannel,
		java.lang.String salesGroup,
		java.lang.String channelRole,
		java.lang.String submitterRole) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: DstrChannel
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllDstrChannel() throws javax.ejb.FinderException;
}
