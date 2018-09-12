package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BillingFrequencyBeanInjectorImpl_93ae97a7
 */
public class BillingFrequencyBeanInjectorImpl_93ae97a7 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingFrequencyBeanInjector_93ae97a7 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7)cb;
		record.set(0,concreteBean.getBillingFreqCode());
		record.set(1,concreteBean.getBillingFreqDescription());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7)cb;
		record.set(0,concreteBean.getBillingFreqCode());
		record.set(1,concreteBean.getBillingFreqDescription());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7)cb;
		record.set(0,concreteBean.getBillingFreqCode());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		java.lang.String pkey=(java.lang.String)pkeyObject;
		record.set(0,pkey);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7)cb;
		record.set(0,concreteBean.getBillingFreqCode());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingFrequency_93ae97a7)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getBillingFreqCode());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getBillingFreqDescription());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
