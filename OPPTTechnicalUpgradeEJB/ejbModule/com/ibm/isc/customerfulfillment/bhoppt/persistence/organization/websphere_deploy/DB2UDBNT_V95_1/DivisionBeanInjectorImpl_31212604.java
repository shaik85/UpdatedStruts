package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * DivisionBeanInjectorImpl_31212604
 */
public class DivisionBeanInjectorImpl_31212604 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DivisionBeanInjector_31212604 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604)cb;
		record.set(0,concreteBean.getDivision());
		record.set(1,concreteBean.getDivisionDesc());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604)cb;
		record.set(0,concreteBean.getDivision());
		record.set(1,concreteBean.getDivisionDesc());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604)cb;
		record.set(0,concreteBean.getDivision());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604)cb;
		record.set(0,concreteBean.getDivision());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDivision_31212604)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getDivision());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getDivisionDesc());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
