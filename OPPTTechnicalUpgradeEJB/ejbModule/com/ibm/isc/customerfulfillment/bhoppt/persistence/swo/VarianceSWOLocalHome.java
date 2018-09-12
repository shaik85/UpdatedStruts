/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local Home interface for Enterprise Bean: VarianceSWO
 */
public interface VarianceSWOLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: VarianceSWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOLocal create(
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String swoNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: VarianceSWO
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo
		.VarianceSWOLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findMaxVarianceSWOId()
		throws javax.ejb.FinderException;
	public java.util.Collection findByEquipmentNo(
		java.lang.String equipmentNo,
		int proposalId)
		throws javax.ejb.FinderException;
	public java.util.Collection findByDM(int dmID, int customerId, int proposalId) throws javax.ejb.FinderException;
}
