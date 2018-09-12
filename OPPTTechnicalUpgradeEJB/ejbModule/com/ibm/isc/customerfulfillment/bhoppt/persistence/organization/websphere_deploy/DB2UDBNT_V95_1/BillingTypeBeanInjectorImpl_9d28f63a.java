package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BillingTypeBeanInjectorImpl_9d28f63a
 */
public class BillingTypeBeanInjectorImpl_9d28f63a implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingTypeBeanInjector_9d28f63a {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a)cb;
		record.set(0,concreteBean.getBillingType());
		record.set(1,concreteBean.getBillingDesc());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a)cb;
		record.set(0,concreteBean.getBillingType());
		record.set(1,concreteBean.getBillingDesc());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a)cb;
		record.set(0,concreteBean.getBillingType());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a)cb;
		record.set(0,concreteBean.getBillingType());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingType_9d28f63a)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getBillingType());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getBillingDesc());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
