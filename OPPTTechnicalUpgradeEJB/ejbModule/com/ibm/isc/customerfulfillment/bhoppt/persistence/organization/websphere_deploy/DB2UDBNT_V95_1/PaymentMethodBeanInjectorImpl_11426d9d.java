package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * PaymentMethodBeanInjectorImpl_11426d9d
 */
public class PaymentMethodBeanInjectorImpl_11426d9d implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentMethodBeanInjector_11426d9d {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d)cb;
		record.set(0,concreteBean.getId());
		record.set(1,concreteBean.getDescription());
		record.set(2,concreteBean.getStatus());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d)cb;
		record.set(0,concreteBean.getId());
		record.set(1,concreteBean.getDescription());
		record.set(2,concreteBean.getStatus());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d)cb;
		record.set(0,concreteBean.getId());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d)cb;
		record.set(0,concreteBean.getId());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentMethod_11426d9d)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getId());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getDescription());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getStatus());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
