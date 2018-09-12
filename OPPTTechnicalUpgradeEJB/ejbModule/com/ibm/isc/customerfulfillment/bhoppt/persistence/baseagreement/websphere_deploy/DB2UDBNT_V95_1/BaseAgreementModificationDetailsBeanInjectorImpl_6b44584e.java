package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementModificationDetailsBeanInjectorImpl_6b44584e
 */
public class BaseAgreementModificationDetailsBeanInjectorImpl_6b44584e implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationDetailsBeanInjector_6b44584e {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e)cb;
		record.set(0,concreteBean.getAgreementId());
		record.set(1,concreteBean.getModificationTypeCode());
		record.set(2,concreteBean.getLegalContract());
		record.set(3,concreteBean.getAccountingContact());
		record.set(4,concreteBean.getRevenueRecognition());
		record.set(5,concreteBean.getModifiedIBMLetterHead());
		record.set(6,concreteBean.getModificationOption());
		record.set(7,concreteBean.getDetails());
		record.set(8,concreteBean.getCreatedBy());
		record.set(9,concreteBean.getCreatedDate());
		record.set(10,concreteBean.getChangedBy());
		record.set(11,concreteBean.getChangedDate());
		record.set(12,concreteBean.getRolStartDate());
		record.set(13,concreteBean.getRolEndDate());
		record.set(14,concreteBean.getStatus());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e)cb;
		record.set(0,concreteBean.getAgreementId());
		record.set(1,concreteBean.getModificationTypeCode());
		record.set(2,concreteBean.getLegalContract());
		record.set(3,concreteBean.getAccountingContact());
		record.set(4,concreteBean.getRevenueRecognition());
		record.set(5,concreteBean.getModifiedIBMLetterHead());
		record.set(6,concreteBean.getModificationOption());
		record.set(7,concreteBean.getDetails());
		record.set(8,concreteBean.getCreatedBy());
		record.set(9,concreteBean.getCreatedDate());
		record.set(10,concreteBean.getChangedBy());
		record.set(11,concreteBean.getChangedDate());
		record.set(12,concreteBean.getRolStartDate());
		record.set(13,concreteBean.getRolEndDate());
		record.set(14,concreteBean.getStatus());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e)cb;
		record.set(0,concreteBean.getAgreementId());
		record.set(1,concreteBean.getModificationTypeCode());
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
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey)pkeyObject;
		record.set(0,pkey.agreementId);
		record.set(1,pkey.modificationTypeCode);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e)cb;
		record.set(0,concreteBean.getAgreementId());
		record.set(1,concreteBean.getModificationTypeCode());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreementModificationDetails_6b44584e)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getAgreementId());
		record.set(1,concreteBean.getModificationTypeCode());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getLegalContract());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getAccountingContact());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getRevenueRecognition());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getModifiedIBMLetterHead());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getModificationOption());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getDetails());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getCreatedBy());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getCreatedDate());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getChangedBy());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getChangedDate());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getRolStartDate());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getRolEndDate());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getStatus());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
