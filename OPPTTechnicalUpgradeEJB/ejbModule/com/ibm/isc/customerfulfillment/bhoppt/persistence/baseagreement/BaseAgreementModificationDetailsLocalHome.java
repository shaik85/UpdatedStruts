/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: BaseAgreementModificationDetails
 */
public interface BaseAgreementModificationDetailsLocalHome
	extends
		javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BaseAgreementModificationDetails
	 * @param agreementId
	 * @param modificationTypeCode
	 * @return BaseAgreementModificationDetailsLocal
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocal create(
		java.lang.Integer agreementId,
		java.lang.String modificationTypeCode) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BaseAgreementModificationDetails
	 * @param primaryKey
	 * @return BaseAgreementModificationDetailsLocal
	 * @throws FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findByAgreementId(java.lang.Integer agreementId) throws javax.ejb.FinderException;
}
