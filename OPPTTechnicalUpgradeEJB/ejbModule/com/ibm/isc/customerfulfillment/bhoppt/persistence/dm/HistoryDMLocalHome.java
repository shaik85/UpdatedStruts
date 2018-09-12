/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;
/**
 * Local Home interface for Enterprise Bean: HistoryDM
 */
public interface HistoryDMLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: HistoryDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocal create(
		int dmId,
		int customerId,
		int proposalId,String dmNo,java.sql.Date lastUpdatedDate)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: HistoryDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.HistoryDMKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxDMId() throws javax.ejb.FinderException;
}
