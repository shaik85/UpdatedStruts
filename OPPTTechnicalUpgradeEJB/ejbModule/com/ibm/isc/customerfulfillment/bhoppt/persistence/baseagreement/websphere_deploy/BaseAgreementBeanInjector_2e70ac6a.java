package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: BaseAgreement
 */
public interface BaseAgreementBeanInjector_2e70ac6a extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindByCustomerNumberandFormNumber
	 */
	public void ejbFindByCustomerNumberandFormNumber(java.lang.String customerNumber, java.lang.String formNumber, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySalesOrgAndFormNumber
	 */
	public void ejbFindBySalesOrgAndFormNumber(java.lang.String salesOrganization, java.lang.String formNumber, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindBySearch
	 */
	public void ejbFindBySearch(java.lang.String agreementNumber, java.lang.String formNumber, java.lang.String customerNumber, java.lang.String enterpriseNumber, javax.resource.cci.IndexedRecord record);
}
