/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: UserType
 */
public interface UserTypeLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: UserType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeLocal create(
		java.lang.String userType) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: UserType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeLocal findByPrimaryKey(
		java.lang.String primaryKey) throws javax.ejb.FinderException;
	
	/**
	 * Finds all instance for Entity Bean: UserType
	 */	
	public java.util.Collection findAllUserTypes() throws javax.ejb.FinderException;
}
