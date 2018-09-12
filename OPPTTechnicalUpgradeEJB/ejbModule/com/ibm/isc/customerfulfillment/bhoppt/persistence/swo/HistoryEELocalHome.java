/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: HistoryEE
 */
public interface HistoryEELocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: HistoryEE
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEELocal create(
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String eeNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: HistoryEE
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo
		.HistoryEELocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxEEId() throws javax.ejb.FinderException;
}
