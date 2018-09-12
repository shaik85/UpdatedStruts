/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local Home interface for Enterprise Bean: Sharing
 */
public interface SharingLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Sharing
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal create(int proposalId, java.lang.String accessTo) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Sharing
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal findByPrimaryKey(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey primaryKey) throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.String userId) throws javax.ejb.FinderException;
	public java.util.Collection findByProposalId(int proposalId) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal findByProposalAndAccess(int proposalId) throws javax.ejb.FinderException;
}
