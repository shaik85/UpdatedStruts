package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementFormBeanInjectorImpl_5d3cd1d7
 */
public class BaseAgreementFormBeanInjectorImpl_5d3cd1d7 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementFormBeanInjector_5d3cd1d7 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7)cb;
		record.set(0,concreteBean.getFormNumber());
		record.set(1,concreteBean.getFormShortDescription());
		record.set(2,concreteBean.getFormLongDescription());
		record.set(3,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7)cb;
		record.set(0,concreteBean.getFormNumber());
		record.set(1,concreteBean.getFormShortDescription());
		record.set(2,concreteBean.getFormLongDescription());
		record.set(3,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7)cb;
		record.set(0,concreteBean.getFormNumber());
		record.set(3,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey)pkeyObject;
		record.set(0,pkey.formNumber);
		record.set(1,pkey.salesOrganization);
	}
	/**
	 * ejbFindAllForm
	 */
	public void ejbFindAllForm(java.lang.String salesOrganization, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrganization);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7)cb;
		record.set(0,concreteBean.getFormNumber());
		record.set(1,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementForm_5d3cd1d7)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getFormNumber());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getFormShortDescription());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getFormLongDescription());
		}
		record.set(3,concreteBean.getSalesOrganization());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
