package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementChangeLogBeanInjectorImpl_508109ee
 */
public class BaseAgreementChangeLogBeanInjectorImpl_508109ee implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementChangeLogBeanInjector_508109ee {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee)cb;
		record.set(0,concreteBean.getChangeId());
		record.set(1,concreteBean.getAgreementId());
		record.set(2,concreteBean.getCreatedBy());
		record.set(3,concreteBean.getChangedDate());
		record.set(4,concreteBean.getChangedTime());
		record.set(5,concreteBean.getChangedDetails());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee)cb;
		record.set(0,concreteBean.getChangeId());
		record.set(1,concreteBean.getAgreementId());
		record.set(2,concreteBean.getCreatedBy());
		record.set(3,concreteBean.getChangedDate());
		record.set(4,concreteBean.getChangedTime());
		record.set(5,concreteBean.getChangedDetails());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee)cb;
		record.set(0,concreteBean.getChangeId());
	}
	/**
	 * ejbFindByAgreementId
	 */
	public void ejbFindByAgreementId(java.lang.Integer agreementId, javax.resource.cci.IndexedRecord record) {
		record.set(0,agreementId);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey)pkeyObject;
		record.set(0,pkey.changeId);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee)cb;
		record.set(0,concreteBean.getChangeId());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementChangeLog_508109ee)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getChangeId());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getAgreementId());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getCreatedBy());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getChangedDate());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getChangedTime());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getChangedDetails());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
