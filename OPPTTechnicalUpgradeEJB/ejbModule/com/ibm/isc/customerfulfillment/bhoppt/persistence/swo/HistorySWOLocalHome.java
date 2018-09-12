/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: HistorySWO
 */
public interface HistorySWOLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: HistorySWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOLocal create(
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String swoNo,java.sql.Date lastUpdatedDate)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: HistorySWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo
		.HistorySWOLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxSWOId() throws javax.ejb.FinderException;
}
