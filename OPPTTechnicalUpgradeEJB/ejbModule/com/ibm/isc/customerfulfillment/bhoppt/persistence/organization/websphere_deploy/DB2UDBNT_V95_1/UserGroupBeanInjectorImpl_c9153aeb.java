package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * UserGroupBeanInjectorImpl_c9153aeb
 */
public class UserGroupBeanInjectorImpl_c9153aeb implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.UserGroupBeanInjector_c9153aeb {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getGroupName());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb)cb;
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getGroupName());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupKey)pkeyObject;
		record.set(0,pkey.userId);
		record.set(1,pkey.groupName);
	}
	/**
	 * ejbFindByUser
	 */
	public void ejbFindByUser(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * ejbFindByGroup
	 */
	public void ejbFindByGroup(java.lang.String groupName, javax.resource.cci.IndexedRecord record) {
		record.set(0,groupName);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getGroupName());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteUserGroup_c9153aeb)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
