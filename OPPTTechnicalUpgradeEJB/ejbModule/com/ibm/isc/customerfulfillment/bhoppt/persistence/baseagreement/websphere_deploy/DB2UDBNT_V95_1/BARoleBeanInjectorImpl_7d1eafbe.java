package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BARoleBeanInjectorImpl_7d1eafbe
 */
public class BARoleBeanInjectorImpl_7d1eafbe implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BARoleBeanInjector_7d1eafbe {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe)cb;
		record.set(0,concreteBean.getBaseAgreementRole());
		record.set(1,concreteBean.getBaseAgreementRoleDescription());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe)cb;
		record.set(0,concreteBean.getBaseAgreementRole());
		record.set(1,concreteBean.getBaseAgreementRoleDescription());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe)cb;
		record.set(0,concreteBean.getBaseAgreementRole());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe)cb;
		record.set(0,concreteBean.getBaseAgreementRole());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBARole_7d1eafbe)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getBaseAgreementRole());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getBaseAgreementRoleDescription());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
