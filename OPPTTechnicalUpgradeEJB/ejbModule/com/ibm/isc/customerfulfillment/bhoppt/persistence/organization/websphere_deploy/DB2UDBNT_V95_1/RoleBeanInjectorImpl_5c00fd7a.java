package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * RoleBeanInjectorImpl_5c00fd7a
 */
public class RoleBeanInjectorImpl_5c00fd7a implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.RoleBeanInjector_5c00fd7a {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a)cb;
		record.set(0,concreteBean.getRole());
		record.set(1,concreteBean.getRoleDesc());
		record.set(2,concreteBean.getActive());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a)cb;
		record.set(0,concreteBean.getRole());
		record.set(1,concreteBean.getRoleDesc());
		record.set(2,concreteBean.getActive());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a)cb;
		record.set(0,concreteBean.getRole());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a)cb;
		record.set(0,concreteBean.getRole());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteRole_5c00fd7a)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getRole());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getRoleDesc());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getActive());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
