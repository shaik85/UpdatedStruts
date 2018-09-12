package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementModificationTypeBeanInjectorImpl_56acdccc
 */
public class BaseAgreementModificationTypeBeanInjectorImpl_56acdccc implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationTypeBeanInjector_56acdccc {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc)cb;
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(1,concreteBean.getModificationTypeDescription());
		record.set(2,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc)cb;
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(1,concreteBean.getModificationTypeDescription());
		record.set(2,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc)cb;
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(2,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbFindExistModificationType
	 */
	public void ejbFindExistModificationType(java.lang.String salesOrganization, java.lang.String modificationTypeCode, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrganization);
		record.set(1,modificationTypeCode);
	}
	/**
	 * ejbFindBySalesOrganisation
	 */
	public void ejbFindBySalesOrganisation(java.lang.String salesOrganization, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrganization);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey)pkeyObject;
		record.set(0,pkey.modificationTypeCode);
		record.set(1,pkey.salesOrganization);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc)cb;
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(1,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationType_56acdccc)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getModificationTypeCode());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getModificationTypeDescription());
		}
		record.set(2,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
