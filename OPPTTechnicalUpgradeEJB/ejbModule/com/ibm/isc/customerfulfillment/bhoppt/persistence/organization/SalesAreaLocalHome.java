/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: SalesArea
 */
public interface SalesAreaLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: SalesArea
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocal create(
		java.lang.String salesOrg,
		java.lang.String divisionCode,
		java.lang.String distributionChannelCode)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: SalesArea
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.SalesAreaLocal findByPrimaryKey(
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
				.SalesAreaKey primaryKey)
		throws javax.ejb.FinderException;
}
