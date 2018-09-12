package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * CCTypeBeanInjectorImpl_d1953ee3
 */
public class CCTypeBeanInjectorImpl_d1953ee3 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CCTypeBeanInjector_d1953ee3 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3)cb;
		record.set(0,concreteBean.getCcDesc());
		record.set(1,concreteBean.getCcType());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3)cb;
		record.set(0,concreteBean.getCcDesc());
		record.set(1,concreteBean.getCcType());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3)cb;
		record.set(1,concreteBean.getCcType());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey)pkeyObject;
		record.set(0,pkey.ccType);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3)cb;
		record.set(0,concreteBean.getCcType());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteCCType_d1953ee3)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		if(instanceExtension.isDirty(1))
		{
			record.set(0,concreteBean.getCcDesc());
		}
		record.set(1,concreteBean.getCcType());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
