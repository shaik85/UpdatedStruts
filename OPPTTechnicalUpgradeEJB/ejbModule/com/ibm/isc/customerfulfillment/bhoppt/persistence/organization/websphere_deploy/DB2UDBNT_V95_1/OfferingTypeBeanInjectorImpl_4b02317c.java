package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * OfferingTypeBeanInjectorImpl_4b02317c
 */
public class OfferingTypeBeanInjectorImpl_4b02317c implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.OfferingTypeBeanInjector_4b02317c {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c)cb;
		record.set(0,concreteBean.getOfferingType());
		record.set(1,concreteBean.getOfferingDesc());
		record.set(2,concreteBean.getTvmAllowed());
		record.set(3,concreteBean.getSpecialRateInd());
		record.set(4,concreteBean.getAnnivContractAmtInd());
		record.set(5,new Integer(concreteBean.getDuration()));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c)cb;
		record.set(0,concreteBean.getOfferingType());
		record.set(1,concreteBean.getOfferingDesc());
		record.set(2,concreteBean.getTvmAllowed());
		record.set(3,concreteBean.getSpecialRateInd());
		record.set(4,concreteBean.getAnnivContractAmtInd());
		record.set(5,new Integer(concreteBean.getDuration()));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c)cb;
		record.set(0,concreteBean.getOfferingType());
		record.set(1,concreteBean.getOfferingDesc());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey)pkeyObject;
		record.set(0,pkey.offeringDesc);
		record.set(1,pkey.offeringType);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c)cb;
		record.set(0,concreteBean.getOfferingDesc());
		record.set(1,concreteBean.getOfferingType());
		record.set(2,new Integer(concreteBean.getDuration()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ConcreteOfferingType_4b02317c)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getOfferingType());
		record.set(1,concreteBean.getOfferingDesc());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getTvmAllowed());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getSpecialRateInd());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getAnnivContractAmtInd());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,new Integer(concreteBean.getDuration()));
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
