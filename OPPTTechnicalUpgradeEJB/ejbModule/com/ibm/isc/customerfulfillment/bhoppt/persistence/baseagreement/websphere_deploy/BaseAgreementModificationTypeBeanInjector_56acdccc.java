package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: BaseAgreementModificationType
 */
public interface BaseAgreementModificationTypeBeanInjector_56acdccc extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindBySalesOrganisation
	 */
	public void ejbFindBySalesOrganisation(java.lang.String salesOrganization, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindExistModificationType
	 */
	public void ejbFindExistModificationType(java.lang.String salesOrganization, java.lang.String modificationTypeCode, javax.resource.cci.IndexedRecord record);
}
