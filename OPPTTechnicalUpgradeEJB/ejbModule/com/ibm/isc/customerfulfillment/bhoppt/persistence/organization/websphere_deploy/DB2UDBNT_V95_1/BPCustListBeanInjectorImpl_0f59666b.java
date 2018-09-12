package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BPCustListBeanInjectorImpl_0f59666b
 */
public class BPCustListBeanInjectorImpl_0f59666b implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPCustListBeanInjector_0f59666b {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getCustListNo());
		record.set(2,concreteBean.getCustListName());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getCustListNo());
		record.set(2,concreteBean.getCustListName());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getCustListNo());
	}
	/**
	 * ejbFindByUser
	 */
	public void ejbFindByUser(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPCustListKey)pkeyObject;
		record.set(0,pkey.userId);
		record.set(1,pkey.custListNo);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getCustListNo());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPCustList_0f59666b)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getCustListNo());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getCustListName());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
