/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: Price
 */
public interface PriceLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Price
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal create(
		int priceId,
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Price
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByEE(int eeId, int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findMaxPriceId()
		throws javax.ejb.FinderException;
}
