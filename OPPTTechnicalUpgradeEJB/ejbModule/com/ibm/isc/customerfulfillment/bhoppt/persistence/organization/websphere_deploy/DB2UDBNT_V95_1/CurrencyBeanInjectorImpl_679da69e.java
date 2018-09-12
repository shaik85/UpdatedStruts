package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * CurrencyBeanInjectorImpl_679da69e
 */
public class CurrencyBeanInjectorImpl_679da69e implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CurrencyBeanInjector_679da69e {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e)cb;
		record.set(0,concreteBean.getCurrency());
		record.set(1,concreteBean.getCurrencyDesc());
		record.set(2,concreteBean.getDecimalsAllowed());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e)cb;
		record.set(0,concreteBean.getCurrency());
		record.set(1,concreteBean.getCurrencyDesc());
		record.set(2,concreteBean.getDecimalsAllowed());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e)cb;
		record.set(0,concreteBean.getCurrency());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e)cb;
		record.set(0,concreteBean.getCurrency());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCurrency_679da69e)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getCurrency());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getCurrencyDesc());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getDecimalsAllowed());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
