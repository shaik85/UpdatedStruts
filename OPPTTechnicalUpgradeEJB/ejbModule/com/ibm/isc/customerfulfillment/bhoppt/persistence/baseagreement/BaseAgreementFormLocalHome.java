/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: BaseAgreementForm
 */
public interface BaseAgreementFormLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BaseAgreementForm
	 * @param formNumber
	 * @param salesOrganization
	 * @return BaseAgreementFormLocal
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocal create(
		java.lang.String formNumber,
		java.lang.String salesOrganization) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BaseAgreementForm
	 * @param primaryKey
	 * @return BaseAgreementFormLocal
	 * @throws FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * findAllForm
	 * @param salesOrganization
	 * @return Collection
	 * @throws FinderException
	 */
	public java.util.Collection findAllForm(java.lang.String salesOrganization) throws javax.ejb.FinderException;
}
