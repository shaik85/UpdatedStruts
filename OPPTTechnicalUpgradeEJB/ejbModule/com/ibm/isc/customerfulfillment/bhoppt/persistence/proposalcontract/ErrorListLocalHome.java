/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local Home interface for Enterprise Bean: ErrorList
 */
public interface ErrorListLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: ErrorList
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal create(java.lang.Integer messageId, int proposalId)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: ErrorList
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract
		.ErrorListLocal findByPrimaryKey(java.lang.Integer primaryKey)
		throws javax.ejb.FinderException;
		
	public java.util.Collection findByProposalId(int proposalId) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal findMax() throws javax.ejb.FinderException;
}
