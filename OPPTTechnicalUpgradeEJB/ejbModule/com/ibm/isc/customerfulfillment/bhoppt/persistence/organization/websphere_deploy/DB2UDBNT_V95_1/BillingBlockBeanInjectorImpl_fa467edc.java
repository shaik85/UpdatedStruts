package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BillingBlockBeanInjectorImpl_fa467edc
 */
public class BillingBlockBeanInjectorImpl_fa467edc implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BillingBlockBeanInjector_fa467edc {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc)cb;
		record.set(0,concreteBean.getBillingBlock());
		record.set(1,concreteBean.getBillingBlockDescription());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc)cb;
		record.set(0,concreteBean.getBillingBlock());
		record.set(1,concreteBean.getBillingBlockDescription());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc)cb;
		record.set(0,concreteBean.getBillingBlock());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc)cb;
		record.set(0,concreteBean.getBillingBlock());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBillingBlock_fa467edc)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getBillingBlock());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getBillingBlockDescription());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
