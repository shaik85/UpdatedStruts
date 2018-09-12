/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;
/**
 * Local Home interface for Enterprise Bean: BaseAgreementFormBean
 */
public interface BaseAgreementFormBeanLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BaseAgreementFormBean
	 * @param formNumber
	 * @return BaseAgreementFormBeanLocal
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBeanLocal create(
		java.lang.String formNumber) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BaseAgreementFormBean
	 * @param primaryKey
	 * @return BaseAgreementFormBeanLocal
	 * @throws FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBeanLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormBeanKey primaryKey)
		throws javax.ejb.FinderException;
}
