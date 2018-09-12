/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm;
/**
 * Local Home interface for Enterprise Bean: VarianceDM
 */
public interface VarianceDMLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: VarianceDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMLocal create(
		int dmId,
		int customerId,
		int proposalId,String dmNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: VarianceDM
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.dm
		.VarianceDMLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxVarianceDMId()
		throws javax.ejb.FinderException;
	public java.util.Collection findByDMNo(java.lang.String dmNo, int proposalId, int customerId)
		throws javax.ejb.FinderException;
	public java.util.Collection findByProposal(int proposalID) throws javax.ejb.FinderException;
	public java.util.Collection findByCustomer(int proposalId, int customerId) throws javax.ejb.FinderException;
}
