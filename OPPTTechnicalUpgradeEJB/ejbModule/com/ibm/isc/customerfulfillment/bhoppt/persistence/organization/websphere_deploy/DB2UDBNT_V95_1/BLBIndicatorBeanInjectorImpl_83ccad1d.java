package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BLBIndicatorBeanInjectorImpl_83ccad1d
 */
public class BLBIndicatorBeanInjectorImpl_83ccad1d implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BLBIndicatorBeanInjector_83ccad1d {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d)cb;
		record.set(0,concreteBean.getBlbType());
		record.set(1,concreteBean.getBlbDesc());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d)cb;
		record.set(0,concreteBean.getBlbType());
		record.set(1,concreteBean.getBlbDesc());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d)cb;
		record.set(0,concreteBean.getBlbType());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey)pkeyObject;
		record.set(0,pkey.blbType);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d)cb;
		record.set(0,concreteBean.getBlbType());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBLBIndicator_83ccad1d)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getBlbType());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getBlbDesc());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
