package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * DstrChannelBeanInjectorImpl_fca91a1e
 */
public class DstrChannelBeanInjectorImpl_fca91a1e implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DstrChannelBeanInjector_fca91a1e {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e)cb;
		record.set(0,concreteBean.getDistributionChannel());
		record.set(1,concreteBean.getDistributionChannelDesc());
		record.set(2,concreteBean.getSalesGroup());
		record.set(3,concreteBean.getChannelRole());
		record.set(4,concreteBean.getSubmitterRole());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e)cb;
		record.set(0,concreteBean.getDistributionChannel());
		record.set(1,concreteBean.getDistributionChannelDesc());
		record.set(2,concreteBean.getSalesGroup());
		record.set(3,concreteBean.getChannelRole());
		record.set(4,concreteBean.getSubmitterRole());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e)cb;
		record.set(0,concreteBean.getDistributionChannel());
		record.set(2,concreteBean.getSalesGroup());
		record.set(3,concreteBean.getChannelRole());
		record.set(4,concreteBean.getSubmitterRole());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey)pkeyObject;
		record.set(0,pkey.salesGroup);
		record.set(1,pkey.channelRole);
		record.set(2,pkey.submitterRole);
		record.set(3,pkey.distributionChannel);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e)cb;
		record.set(0,concreteBean.getSalesGroup());
		record.set(1,concreteBean.getChannelRole());
		record.set(2,concreteBean.getSubmitterRole());
		record.set(3,concreteBean.getDistributionChannel());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteDstrChannel_fca91a1e)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getDistributionChannel());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getDistributionChannelDesc());
		}
		record.set(2,concreteBean.getSalesGroup());
		record.set(3,concreteBean.getChannelRole());
		record.set(4,concreteBean.getSubmitterRole());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
