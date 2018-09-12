/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: VarianceEE
 */
public interface VarianceEELocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: VarianceEE
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEELocal create(
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String eeNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: VarianceEE
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo
		.VarianceEELocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxEEId() throws javax.ejb.FinderException;
	public java.util.Collection findBySWO(int swoid, int dmid, int custometId, int proposalId) throws javax.ejb.FinderException;
}
