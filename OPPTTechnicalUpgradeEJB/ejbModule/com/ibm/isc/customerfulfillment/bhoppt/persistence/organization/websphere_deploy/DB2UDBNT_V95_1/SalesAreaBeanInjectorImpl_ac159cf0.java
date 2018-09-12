package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * SalesAreaBeanInjectorImpl_ac159cf0
 */
public class SalesAreaBeanInjectorImpl_ac159cf0 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesAreaBeanInjector_ac159cf0 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0)cb;
		record.set(0,concreteBean.getSalesOrg());
		record.set(1,concreteBean.getDivisionCode());
		record.set(2,concreteBean.getDistributionChannelCode());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0)cb;
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0)cb;
		record.set(0,concreteBean.getSalesOrg());
		record.set(1,concreteBean.getDivisionCode());
		record.set(2,concreteBean.getDistributionChannelCode());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey)pkeyObject;
		record.set(0,pkey.salesOrg);
		record.set(1,pkey.divisionCode);
		record.set(2,pkey.distributionChannelCode);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0)cb;
		record.set(0,concreteBean.getSalesOrg());
		record.set(1,concreteBean.getDivisionCode());
		record.set(2,concreteBean.getDistributionChannelCode());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesArea_ac159cf0)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
