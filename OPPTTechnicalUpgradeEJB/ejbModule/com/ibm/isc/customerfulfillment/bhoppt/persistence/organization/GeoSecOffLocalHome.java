/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: GeoSecOff
 */
public interface GeoSecOffLocalHome extends javax.ejb.EJBLocalHome
{
	/**
	 * Creates an instance from a key for Entity Bean: GeoSecOff
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal create(java.lang.String salesOrg)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: GeoSecOff
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal findByPrimaryKey(
		java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	
	public java.util.Collection findAllGeoSecOfficer() throws javax.ejb.FinderException;
	
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal findBySalesOrg(java.lang.String salesOrg)
		throws javax.ejb.FinderException;
	
	public java.util.Collection findByGeoSec(java.lang.String salesOrg) throws javax.ejb.FinderException;
}
