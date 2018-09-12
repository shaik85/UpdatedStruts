/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: BaseAgreementStatus
 */
public interface BaseAgreementStatusLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BaseAgreementStatus
	 * @param statusCode
	 * @return BaseAgreementStatusLocal
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusLocal create(
		java.lang.String statusCode) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BaseAgreementStatus
	 * @param primaryKey
	 * @return BaseAgreementStatusLocal
	 * @throws FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey primaryKey)
		throws javax.ejb.FinderException;
}
