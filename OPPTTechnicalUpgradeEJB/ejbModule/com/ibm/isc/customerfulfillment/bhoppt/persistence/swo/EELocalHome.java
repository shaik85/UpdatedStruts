/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: EE
 */
public interface EELocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: EE
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal create(
		int eeId,
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String eeNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: EE
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EELocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.EEKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findBySWO(int swoId, int dmId, int customerId, int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findByProposal(int proposalId)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxEEId() throws javax.ejb.FinderException;
	/* CR6153 start change */
	public java.util.Collection findByEENoSalesDocEEItemSwoItem(
		int proposalId,
		java.lang.String eeNo,
		java.lang.String salesDocNo,
		java.lang.String eeItemNo,
		java.lang.String swoItemNo) throws javax.ejb.FinderException;
	/* CR6153 start change */
}
