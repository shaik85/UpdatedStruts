/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: BaseAgreementChangeLog
 */
public interface BaseAgreementChangeLogLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BaseAgreementChangeLog
	 * @param changeId
	 * @param agreementId
	 * @return BaseAgreementChangeLogLocal
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogLocal create(
		java.lang.Integer changeId,java.lang.Integer agreementId) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BaseAgreementChangeLog
	 * @param primaryKey
	 * @return BaseAgreementChangeLogLocal
	 * @throws FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * Finds by agreement id
	 * @param agreementId
	 * @throws FinderException
	 */
	public java.util.Collection findByAgreementId(java.lang.Integer agreementId)
		throws javax.ejb.FinderException;
	/**
	 * Finds maxchange id
	 * @return BaseAgreementChangeLogLocal
	 * @throws FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogLocal findMaxChangeId() throws javax.ejb.FinderException;
}
