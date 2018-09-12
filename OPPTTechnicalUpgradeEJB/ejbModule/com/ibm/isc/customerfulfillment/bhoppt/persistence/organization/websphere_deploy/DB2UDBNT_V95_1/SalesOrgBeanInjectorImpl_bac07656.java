package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * SalesOrgBeanInjectorImpl_bac07656
 */
public class SalesOrgBeanInjectorImpl_bac07656 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.SalesOrgBeanInjector_bac07656 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656)cb;
		record.set(0,concreteBean.getSalesOrg());
		record.set(1,concreteBean.getSalesOrgDesc());
		record.set(2,concreteBean.getDefaultCurrency());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656)cb;
		record.set(0,concreteBean.getSalesOrg());
		record.set(1,concreteBean.getSalesOrgDesc());
		record.set(2,concreteBean.getDefaultCurrency());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656)cb;
		record.set(0,concreteBean.getSalesOrg());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656)cb;
		record.set(0,concreteBean.getSalesOrg());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteSalesOrg_bac07656)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getSalesOrg());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getSalesOrgDesc());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getDefaultCurrency());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
