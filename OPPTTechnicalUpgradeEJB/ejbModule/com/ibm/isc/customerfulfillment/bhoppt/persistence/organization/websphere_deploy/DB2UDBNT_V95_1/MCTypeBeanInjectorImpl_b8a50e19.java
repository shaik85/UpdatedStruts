package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * MCTypeBeanInjectorImpl_b8a50e19
 */
public class MCTypeBeanInjectorImpl_b8a50e19 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.MCTypeBeanInjector_b8a50e19 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19)cb;
		record.set(0,concreteBean.getMcType());
		record.set(1,concreteBean.getMcDesc());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19)cb;
		record.set(0,concreteBean.getMcType());
		record.set(1,concreteBean.getMcDesc());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19)cb;
		record.set(0,concreteBean.getMcType());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey)pkeyObject;
		record.set(0,pkey.mcType);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19)cb;
		record.set(0,concreteBean.getMcType());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteMCType_b8a50e19)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getMcType());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getMcDesc());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
