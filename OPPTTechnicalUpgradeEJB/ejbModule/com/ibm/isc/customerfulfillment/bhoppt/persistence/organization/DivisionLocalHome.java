/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: Division
 */
public interface DivisionLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Division
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DivisionLocal create(
		java.lang.String division)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Division
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.DivisionLocal findByPrimaryKey(java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllDivision() throws javax.ejb.FinderException;
}
