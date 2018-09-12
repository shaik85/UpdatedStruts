/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;
/**
 * Local Home interface for Enterprise Bean: DM
 */
public interface DMLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: DM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocal create(
		int dmId,
		int customerId,
		int proposalId,String dmNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: DM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByDMNo(java.lang.String dmNo, int proposalId, int customerId)
		throws javax.ejb.FinderException;
	public java.util.Collection findByCustomer(int customerId, int proposalId)
		throws javax.ejb.FinderException;
	public java.util.Collection findByProposal(int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findMaxDMId() throws javax.ejb.FinderException;
}
