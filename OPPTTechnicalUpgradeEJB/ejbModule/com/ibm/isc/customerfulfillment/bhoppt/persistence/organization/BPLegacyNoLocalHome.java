/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
/**
 * Local Home interface for Enterprise Bean: BPLegacyNo
 */
public interface BPLegacyNoLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BPLegacyNo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.BPLegacyNoLocal create(
		java.lang.String userId,
		java.lang.String legacyNo,
		java.lang.String addressSeqNo)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BPLegacyNo
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
		.BPLegacyNoLocal findByPrimaryKey(
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization
				.BPLegacyNoKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByUser(java.lang.String userId) throws javax.ejb.FinderException;
}
