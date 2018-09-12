/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: BARole
 * 
 */
public interface BARoleLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BARole
	 * @param baseAgreementRole
	 * @throws CreateException
	 * @return BARoleLocal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleLocal create(
		java.lang.String baseAgreementRole) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BARole
	 * @param primaryKey
	 * @throws FinderException
	 * @return BARoleLocal
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleLocal findByPrimaryKey(
		java.lang.String primaryKey) throws javax.ejb.FinderException;

	/**
	 * Finds all instances for Entity Bean: BARole
	 * @throws FinderException
	 * @return java.util.Collection 
	 */
	public java.util.Collection findAllBARoles() throws javax.ejb.FinderException;
}
