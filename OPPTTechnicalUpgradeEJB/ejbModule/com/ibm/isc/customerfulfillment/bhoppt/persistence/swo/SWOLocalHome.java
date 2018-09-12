/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: SWO
 */
public interface SWOLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: SWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal create(
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String swoNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: SWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByEquipmentNo(
		java.lang.String equipmentNo,
		int proposalId)
		throws javax.ejb.FinderException;
	public java.util.Collection findByDM(int dmId, int customerId, int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findByProposal(int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findMaxSWOId()
		throws javax.ejb.FinderException;
	public java.util.Collection findSVCLicenseForProposal(int proposalId, java.lang.String itemCategory) throws javax.ejb.FinderException;
	public java.util.Collection findByCustomer(int proposalId, int customerId) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOLocal findMaxSquenceNo(
		java.lang.String salesDocNo,
		java.lang.String swoItemNo,
		int proposalId)
		throws javax.ejb.FinderException;
	public java.util.Collection findBySalesDocNo(java.lang.String salesDocNo, int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findMaxBumpInd(java.lang.String salesDocNo, java.lang.String swoItemNo, int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findBySandSIndicator(int proposalId, java.lang.String indicator) throws javax.ejb.FinderException;
	public java.util.Collection findByExtContrNumber(int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findExcludedLicenses(int proposalId) throws javax.ejb.FinderException;
	public java.util.Collection findByQuotes(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo) throws javax.ejb.FinderException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo
		.SWOLocal findByEquimentAndSalesDocNo(
			java.lang.String equipmentNo,
			java.lang.String salesDocNo,
			int proposalID)
		throws javax.ejb.FinderException;
	public java.util.Collection findBySwoNoSerialNo(int proposalId, java.lang.String swoNo, java.lang.String serialNo) throws javax.ejb.FinderException;
	/* CR6153 start change */
	public java.util.Collection findByEquipSoldToPartyDM(java.lang.String equipmentNo, int proposalId, int customerId, int dmId) throws javax.ejb.FinderException;
	public java.util.Collection findByQuotesSoldToPartyDM(java.lang.String salesDocNo, int proposalId, java.lang.String swoItemNo, int customerId, int dmId) throws javax.ejb.FinderException;
	public java.util.Collection findBySWONoSalesDocSwoItemNo(int proposalId, java.lang.String swoNo, java.lang.String salesDocNo, java.lang.String swoItemNo) throws javax.ejb.FinderException;
	/* CR6153 end change */
}
