package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BPLegacyNoBeanInjectorImpl_f2446ac8
 */
public class BPLegacyNoBeanInjectorImpl_f2446ac8 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.BPLegacyNoBeanInjector_f2446ac8 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getLegacyNo());
		record.set(2,concreteBean.getAddressSeqNo());
		record.set(3,concreteBean.getCustomerName());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getLegacyNo());
		record.set(2,concreteBean.getAddressSeqNo());
		record.set(3,concreteBean.getCustomerName());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getLegacyNo());
		record.set(2,concreteBean.getAddressSeqNo());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey)pkeyObject;
		record.set(0,pkey.userId);
		record.set(1,pkey.legacyNo);
		record.set(2,pkey.addressSeqNo);
	}
	/**
	 * ejbFindByUser
	 */
	public void ejbFindByUser(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getLegacyNo());
		record.set(2,concreteBean.getAddressSeqNo());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteBPLegacyNo_f2446ac8)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getLegacyNo());
		record.set(2,concreteBean.getAddressSeqNo());
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getCustomerName());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
