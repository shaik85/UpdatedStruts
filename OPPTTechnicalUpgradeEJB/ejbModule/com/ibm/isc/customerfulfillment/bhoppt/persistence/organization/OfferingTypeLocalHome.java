/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: OfferingType
 */
public interface OfferingTypeLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: OfferingType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal create(
		java.lang.String offeringType,
		java.lang.String offeringDesc) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: OfferingType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllOfferingType() throws javax.ejb.FinderException;
}
