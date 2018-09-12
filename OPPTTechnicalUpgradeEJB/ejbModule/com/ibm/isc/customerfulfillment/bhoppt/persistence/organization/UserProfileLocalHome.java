/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: UserProfile
 */
public interface UserProfileLocalHome extends javax.ejb.EJBLocalHome
{
	/**
	 * Creates an instance from a key for Entity Bean: UserProfile
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocal create(
		java.lang.String userId,
		String role)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: UserProfile
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserProfileLocal findByPrimaryKey(
		java.lang.String primaryKey)
		throws javax.ejb.FinderException;
		
	public java.util.Collection findByGroupName(java.lang.String groupName) throws javax.ejb.FinderException;
	public java.util.Collection findBySalesOrg(java.lang.String salesOrg) throws javax.ejb.FinderException;
	public java.util.Collection findAllForSalesOrgAndRole(java.lang.String salesOrg, java.lang.String role)
		throws javax.ejb.FinderException;
	public java.util.Collection findByRole(java.lang.String userid1, java.lang.String userid2)
		throws javax.ejb.FinderException;
}
