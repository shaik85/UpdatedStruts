package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementBeanInjectorImpl_2e70ac6a
 */
public class BaseAgreementBeanInjectorImpl_2e70ac6a implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementBeanInjector_2e70ac6a {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a)cb;
		record.set(0,concreteBean.getAgreementId());
		record.set(1,concreteBean.getAgreementNumber());
		record.set(2,concreteBean.getFormNumber());
		record.set(3,concreteBean.getLegacyCustomerNumber());
		record.set(4,concreteBean.getInac());
		record.set(5,concreteBean.getExpirationDate());
		record.set(6,concreteBean.getChangedDate());
		record.set(7,concreteBean.getChangedBy());
		record.set(8,concreteBean.getOneway());
		record.set(9,concreteBean.getIsElectronicSubmitter());
		record.set(10,concreteBean.getImageReferenceNumber());
		record.set(11,concreteBean.getCustomerRepresentative());
		record.set(12,concreteBean.getBranchOffice());
		record.set(13,concreteBean.getCoverageType());
		record.set(14,concreteBean.getFileNumber());
		record.set(15,concreteBean.getLegalContactHdr());
		record.set(16,concreteBean.getAccountingContactHdr());
		record.set(17,concreteBean.getSalesOrganization());
		record.set(18,concreteBean.getAcceptedDate());
		record.set(19,concreteBean.getCreatedBy());
		record.set(20,concreteBean.getCreatedDate());
		record.set(21,concreteBean.getIsModifiedAgreement());
		record.set(22,concreteBean.getCustomerNumber());
		record.set(23,concreteBean.getCustomerName());
		record.set(24,concreteBean.getPreviousAgreementId() == null ? null : concreteBean.getPreviousAgreementId().toString());
		record.set(25,concreteBean.getAgreementStatus());
		record.set(26,concreteBean.getEnterpriseNumber());
		record.set(27,concreteBean.getEnterpriseName());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a)cb;
		record.set(0,concreteBean.getAgreementId());
		record.set(1,concreteBean.getAgreementNumber());
		record.set(2,concreteBean.getFormNumber());
		record.set(3,concreteBean.getLegacyCustomerNumber());
		record.set(4,concreteBean.getInac());
		record.set(5,concreteBean.getExpirationDate());
		record.set(6,concreteBean.getChangedDate());
		record.set(7,concreteBean.getChangedBy());
		record.set(8,concreteBean.getOneway());
		record.set(9,concreteBean.getIsElectronicSubmitter());
		record.set(10,concreteBean.getImageReferenceNumber());
		record.set(11,concreteBean.getCustomerRepresentative());
		record.set(12,concreteBean.getBranchOffice());
		record.set(13,concreteBean.getCoverageType());
		record.set(14,concreteBean.getFileNumber());
		record.set(15,concreteBean.getLegalContactHdr());
		record.set(16,concreteBean.getAccountingContactHdr());
		record.set(17,concreteBean.getSalesOrganization());
		record.set(18,concreteBean.getAcceptedDate());
		record.set(19,concreteBean.getCreatedBy());
		record.set(20,concreteBean.getCreatedDate());
		record.set(21,concreteBean.getIsModifiedAgreement());
		record.set(22,concreteBean.getCustomerNumber());
		record.set(23,concreteBean.getCustomerName());
		record.set(24,concreteBean.getPreviousAgreementId() == null ? null : concreteBean.getPreviousAgreementId().toString());
		record.set(25,concreteBean.getAgreementStatus());
		record.set(26,concreteBean.getEnterpriseNumber());
		record.set(27,concreteBean.getEnterpriseName());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a)cb;
		record.set(0,concreteBean.getAgreementId());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey)pkeyObject;
		record.set(0,pkey.agreementId);
	}
	/**
	 * ejbFindByCustomerNumberandFormNumber
	 */
	public void ejbFindByCustomerNumberandFormNumber(java.lang.String customerNumber, java.lang.String formNumber, javax.resource.cci.IndexedRecord record) {
		record.set(0,customerNumber);
		record.set(1,formNumber);
	}
	/**
	 * ejbFindBySalesOrgAndFormNumber
	 */
	public void ejbFindBySalesOrgAndFormNumber(java.lang.String salesOrganization, java.lang.String formNumber, javax.resource.cci.IndexedRecord record) {
		record.set(0,salesOrganization);
		record.set(1,formNumber);
	}
	/**
	 * ejbFindBySearch
	 */
	public void ejbFindBySearch(java.lang.String agreementNumber, java.lang.String formNumber, java.lang.String customerNumber, java.lang.String enterpriseNumber, javax.resource.cci.IndexedRecord record) {
		record.set(0,agreementNumber);
		record.set(1,formNumber);
		record.set(2,customerNumber);
		record.set(3,enterpriseNumber);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a)cb;
		record.set(0,concreteBean.getAgreementId());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ConcreteBaseAgreement_2e70ac6a)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getAgreementId());
		if(instanceExtension.isDirty(1))
		{
			record.set(1,concreteBean.getAgreementNumber());
		}
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getFormNumber());
		}
		if(instanceExtension.isDirty(25))
		{
			record.set(3,concreteBean.getLegacyCustomerNumber());
		}
		if(instanceExtension.isDirty(24))
		{
			record.set(4,concreteBean.getInac());
		}
		if(instanceExtension.isDirty(23))
		{
			record.set(5,concreteBean.getExpirationDate());
		}
		if(instanceExtension.isDirty(22))
		{
			record.set(6,concreteBean.getChangedDate());
		}
		if(instanceExtension.isDirty(21))
		{
			record.set(7,concreteBean.getChangedBy());
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(8,concreteBean.getOneway());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getIsElectronicSubmitter());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(10,concreteBean.getImageReferenceNumber());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(11,concreteBean.getCustomerRepresentative());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(12,concreteBean.getBranchOffice());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(13,concreteBean.getCoverageType());
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(14,concreteBean.getFileNumber());
		}
		if(instanceExtension.isDirty(26))
		{
			record.set(15,concreteBean.getLegalContactHdr());
		}
		if(instanceExtension.isDirty(27))
		{
			record.set(16,concreteBean.getAccountingContactHdr());
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(17,concreteBean.getSalesOrganization());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(18,concreteBean.getAcceptedDate());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(19,concreteBean.getCreatedBy());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(20,concreteBean.getCreatedDate());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(21,concreteBean.getIsModifiedAgreement());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(22,concreteBean.getCustomerNumber());
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(23,concreteBean.getCustomerName());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(24,concreteBean.getPreviousAgreementId() == null ? null : concreteBean.getPreviousAgreementId().toString());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(25,concreteBean.getAgreementStatus());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(26,concreteBean.getEnterpriseNumber());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(27,concreteBean.getEnterpriseName());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
