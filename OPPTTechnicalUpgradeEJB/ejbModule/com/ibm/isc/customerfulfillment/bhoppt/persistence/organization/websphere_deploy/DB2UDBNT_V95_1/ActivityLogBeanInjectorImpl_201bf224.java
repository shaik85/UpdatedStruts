package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ActivityLogBeanInjectorImpl_201bf224
 */
public class ActivityLogBeanInjectorImpl_201bf224 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.ActivityLogBeanInjector_201bf224 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224)cb;
		record.set(0,concreteBean.getActivityDate());
		record.set(1,concreteBean.getActivityTime());
		record.set(2,concreteBean.getMessage());
		record.set(3,concreteBean.getUserId());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224)cb;
		record.set(0,concreteBean.getActivityDate());
		record.set(1,concreteBean.getActivityTime());
		record.set(2,concreteBean.getMessage());
		record.set(3,concreteBean.getUserId());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224)cb;
		record.set(0,concreteBean.getActivityDate());
		record.set(1,concreteBean.getActivityTime());
		record.set(3,concreteBean.getUserId());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey)pkeyObject;
		record.set(0,pkey.activityTime);
		record.set(1,pkey.activityDate);
		record.set(2,pkey.userId);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224)cb;
		record.set(0,concreteBean.getActivityTime());
		record.set(1,concreteBean.getActivityDate());
		record.set(2,concreteBean.getUserId());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteActivityLog_201bf224)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getActivityDate());
		record.set(1,concreteBean.getActivityTime());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getMessage());
		}
		record.set(3,concreteBean.getUserId());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
