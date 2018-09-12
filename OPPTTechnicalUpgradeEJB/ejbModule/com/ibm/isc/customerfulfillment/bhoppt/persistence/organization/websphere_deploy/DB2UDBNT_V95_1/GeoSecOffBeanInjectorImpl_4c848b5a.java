package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * GeoSecOffBeanInjectorImpl_4c848b5a
 */
public class GeoSecOffBeanInjectorImpl_4c848b5a implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.GeoSecOffBeanInjector_4c848b5a {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a)cb;
		record.set(0,concreteBean.getSalesOrg());
		record.set(1,concreteBean.getGeoSecOffSo());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a)cb;
		record.set(0,concreteBean.getSalesOrg());
		record.set(1,concreteBean.getGeoSecOffSo());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a)cb;
		record.set(0,concreteBean.getSalesOrg());
	}
	/**
	 * ejbFindBySalesOrg
	 */
	public void ejbFindBySalesOrg(java.lang.String salesOrg, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrg);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		java.lang.String pkey=(java.lang.String)pkeyObject;
		record.set(0,pkey);
	}
	/**
	 * ejbFindByGeoSec
	 */
	public void ejbFindByGeoSec(java.lang.String salesOrg, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrg);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a)cb;
		record.set(0,concreteBean.getSalesOrg());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteGeoSecOff_4c848b5a)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getSalesOrg());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getGeoSecOffSo());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
