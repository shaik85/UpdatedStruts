/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement;



/**
 * Local Home interface for Enterprise Bean: BaseAgreement
 */
public interface BaseAgreementLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: BaseAgreement
	 * @param agreementId
	 * @param salesOrg
	 * @param agreementNumber
	 * @param agreementStatus
	 * @param coverageType
	 * @param isModified
	 * @param createdBy
	 * @param createdDate
	 * @return BaseAgreementLocal
	 * @throws CreateException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal create(
		java.lang.Integer agreementId,
		java.lang.String salesOrg,
		java.lang.String agreementNumber,
		java.lang.String agreementStatus,
		java.lang.String coverageType,
		java.lang.String isModified,
		java.lang.String createdBy,
		java.sql.Date createdDate) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: BaseAgreement
	 * @param primaryKey
	 * @return BaseAgreementLocal
	 * @throws FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * @param agreementNumber
	 * @param formNumber
	 * @param customerNumber
	 * @param enterpriseNumber
	 * @return Collection
	 * @throws javax.ejb.FinderException
	 */
	public java.util.Collection findBySearch(java.lang.String agreementNumber, java.lang.String formNumber, java.lang.String customerNumber, java.lang.String enterpriseNumber) throws javax.ejb.FinderException;
	/**
	 * findMaxAgreementId
	 * @return BaseAgreementLocal
	 * @throws javax.ejb.FinderException
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal findMaxAgreementId() throws javax.ejb.FinderException;
	/**
	 * findByCustomerNumberandFormNumber
	 * @param customerNumber
	 * @param formNumber
	 * @return Collection
	 * @throws javax.ejb.FinderException
	 */	
	public java.util.Collection findByCustomerNumberandFormNumber(
		java.lang.String customerNumber,
		java.lang.String formNumber) throws javax.ejb.FinderException;
	/**
	 * findBySalesOrgAndFormNumber
	 * @param salesOrganization
	 * @param formNumber
	 * @return Collection
	 * @throws javax.ejb.FinderException
	 */	
	public java.util.Collection findBySalesOrgAndFormNumber(
		java.lang.String salesOrganization,
		java.lang.String formNumber) throws javax.ejb.FinderException;
}
