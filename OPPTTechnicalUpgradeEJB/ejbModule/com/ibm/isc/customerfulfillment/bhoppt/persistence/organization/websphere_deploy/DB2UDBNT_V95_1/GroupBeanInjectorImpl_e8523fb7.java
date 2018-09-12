package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * GroupBeanInjectorImpl_e8523fb7
 */
public class GroupBeanInjectorImpl_e8523fb7 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.GroupBeanInjector_e8523fb7 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7)cb;
		record.set(0,concreteBean.getGroupName());
		record.set(1,concreteBean.getSalesOrg());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7)cb;
		record.set(0,concreteBean.getGroupName());
		record.set(1,concreteBean.getSalesOrg());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7)cb;
		record.set(0,concreteBean.getGroupName());
	}
	/**
	 * ejbFindBySalesOrg
	 */
	public void ejbFindBySalesOrg(java.lang.String salesOrg, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrg);
	}
	/**
	 * ejbFindByGroupName
	 */
	public void ejbFindByGroupName(java.lang.String groupName, javax.resource.cci.IndexedRecord record) {
		record.set(0,groupName);
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7)cb;
		record.set(0,concreteBean.getGroupName());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGroup_e8523fb7)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getGroupName());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getSalesOrg());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
