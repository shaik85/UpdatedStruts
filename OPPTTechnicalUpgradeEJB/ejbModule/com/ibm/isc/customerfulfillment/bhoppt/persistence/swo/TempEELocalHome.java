/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: TempEE
 */
public interface TempEELocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: TempEE
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal create(
		int proposalId,
		int customerId,
		int dmId)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: TempEE
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey primaryKey)
		throws javax.ejb.FinderException;
}
