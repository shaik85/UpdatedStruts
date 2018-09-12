package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * PaymentTermBeanInjectorImpl_d86e7748
 */
public class PaymentTermBeanInjectorImpl_d86e7748 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.PaymentTermBeanInjector_d86e7748 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748)cb;
		record.set(0,concreteBean.getPaymentTerm());
		record.set(1,concreteBean.getPaymentTermDesc());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748)cb;
		record.set(0,concreteBean.getPaymentTerm());
		record.set(1,concreteBean.getPaymentTermDesc());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748)cb;
		record.set(0,concreteBean.getPaymentTerm());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748)cb;
		record.set(0,concreteBean.getPaymentTerm());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcretePaymentTerm_d86e7748)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getPaymentTerm());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getPaymentTermDesc());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
