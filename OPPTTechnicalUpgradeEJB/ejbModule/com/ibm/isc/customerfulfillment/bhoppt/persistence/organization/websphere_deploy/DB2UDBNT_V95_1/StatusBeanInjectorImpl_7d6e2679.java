package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * StatusBeanInjectorImpl_7d6e2679
 */
public class StatusBeanInjectorImpl_7d6e2679 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.StatusBeanInjector_7d6e2679 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679)cb;
		record.set(0,concreteBean.getStatusCode());
		record.set(1,concreteBean.getStatusDesc());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679)cb;
		record.set(0,concreteBean.getStatusCode());
		record.set(1,concreteBean.getStatusDesc());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679)cb;
		record.set(0,concreteBean.getStatusCode());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679)cb;
		record.set(0,concreteBean.getStatusCode());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteStatus_7d6e2679)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getStatusCode());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getStatusDesc());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
