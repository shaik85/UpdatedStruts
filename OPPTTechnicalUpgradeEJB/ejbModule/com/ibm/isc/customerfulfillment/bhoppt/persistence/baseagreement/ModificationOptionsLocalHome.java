/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: ModificationOptions
 */
public interface ModificationOptionsLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: ModificationOptions
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocal create(
		java.lang.String modificationTypeCode,
		java.lang.String modificationOption) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: ModificationOptions
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByTypeCode(java.lang.String modificationTypeCode) throws javax.ejb.FinderException;
}
