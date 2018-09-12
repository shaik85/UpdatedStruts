/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: BaseAgreementModificationType
 */
public interface BaseAgreementModificationTypeLocalHome
	extends
		javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BaseAgreementModificationType
	 * @param modificationTypeCode
	 * @param salesOrganization
	 * @return BaseAgreementModificationTypeLocal
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeLocal create(
		java.lang.String modificationTypeCode,
		java.lang.String salesOrganization) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BaseAgreementModificationType
	 * @param primaryKey
	 * @return BaseAgreementModificationTypeLocal
	 * @throws FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * findBySalesOrganisation
	 * @param salesOrganization
	 * @return Collection
	 * @throws FinderException
	 */
	public java.util.Collection findBySalesOrganisation(java.lang.String salesOrganization) throws javax.ejb.FinderException;
	/**
	 * findExistModificationType
	 * @param salesOrganization
	 * @param modificationTypeCode
	 * @return Collection
	 * @throws FinderException
	 */
	public java.util.Collection findExistModificationType(java.lang.String salesOrganization, java.lang.String modificationTypeCode) throws javax.ejb.FinderException;
}
