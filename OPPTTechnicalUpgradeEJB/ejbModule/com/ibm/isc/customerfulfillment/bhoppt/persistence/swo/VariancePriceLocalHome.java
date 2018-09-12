/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: VariancePrice
 */
public interface VariancePriceLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: VariancePrice
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceLocal create(
		int priceId,
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: VariancePrice
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo
		.VariancePriceLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxVariancePrice()
		throws javax.ejb.FinderException;
	public java.util.Collection findByEE(int eeId,int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findByEEForVariance(int eeId,int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException;
}
