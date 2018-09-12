package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ModificationOptionsBeanInjectorImpl_2c56bd25
 */
public class ModificationOptionsBeanInjectorImpl_2c56bd25 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.ModificationOptionsBeanInjector_2c56bd25 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25)cb;
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(1,concreteBean.getModificationOption());
		record.set(2,concreteBean.getModificationOptionDescription());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25)cb;
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(1,concreteBean.getModificationOption());
		record.set(2,concreteBean.getModificationOptionDescription());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25)cb;
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(1,concreteBean.getModificationOption());
	}
	/**
	 * ejbFindByTypeCode
	 */
	public void ejbFindByTypeCode(java.lang.String modificationTypeCode, javax.resource.cci.IndexedRecord record) {
		record.set(0,modificationTypeCode);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey)pkeyObject;
		record.set(0,pkey.modificationTypeCode);
		record.set(1,pkey.modificationOption);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25)cb;
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(1,concreteBean.getModificationOption());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteModificationOptions_2c56bd25)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getModificationTypeCode());
		record.set(1,concreteBean.getModificationOption());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getModificationOptionDescription());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
