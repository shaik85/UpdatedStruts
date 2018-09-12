package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1;

/**
 * HistoryCustomerBeanInjectorImpl_44a753d1
 */
public class HistoryCustomerBeanInjectorImpl_44a753d1 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.HistoryCustomerBeanInjector_44a753d1 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,concreteBean.getCustomerListNo());
		record.set(3,concreteBean.getLegacyCustomerNo());
		record.set(4,concreteBean.getSapCustomerNo());
		record.set(5,concreteBean.getSapCustomerName());
		record.set(6,concreteBean.getBillToPartyNo());
		record.set(7,concreteBean.getBillToPartyName());
		record.set(8,concreteBean.getPayerNo());
		record.set(9,concreteBean.getPayerName());
		record.set(10,concreteBean.getShipToPartyNo());
		record.set(11,concreteBean.getShipToPartyName());
		record.set(12,concreteBean.getPlanStartDate());
		record.set(13,concreteBean.getPlanEndDate());
		record.set(14,concreteBean.getLastUpdatedDate());
		record.set(15,concreteBean.getPayerLNo());
		record.set(16,concreteBean.getBillToPartyLNo());
		record.set(17,concreteBean.getShipToPartyLNo());
		record.set(18,concreteBean.getCustomerASNo());
		record.set(19,concreteBean.getBillToPartyASNo());
		record.set(20,concreteBean.getPayerASNo());
		record.set(21,concreteBean.getShipToPartyASNo());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		record.set(2,concreteBean.getCustomerListNo());
		record.set(3,concreteBean.getLegacyCustomerNo());
		record.set(4,concreteBean.getSapCustomerNo());
		record.set(5,concreteBean.getSapCustomerName());
		record.set(6,concreteBean.getBillToPartyNo());
		record.set(7,concreteBean.getBillToPartyName());
		record.set(8,concreteBean.getPayerNo());
		record.set(9,concreteBean.getPayerName());
		record.set(10,concreteBean.getShipToPartyNo());
		record.set(11,concreteBean.getShipToPartyName());
		record.set(12,concreteBean.getPlanStartDate());
		record.set(13,concreteBean.getPlanEndDate());
		record.set(14,concreteBean.getLastUpdatedDate());
		record.set(15,concreteBean.getPayerLNo());
		record.set(16,concreteBean.getBillToPartyLNo());
		record.set(17,concreteBean.getShipToPartyLNo());
		record.set(18,concreteBean.getCustomerASNo());
		record.set(19,concreteBean.getBillToPartyASNo());
		record.set(20,concreteBean.getPayerASNo());
		record.set(21,concreteBean.getShipToPartyASNo());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey)pkeyObject;
		record.set(0,new Integer(pkey.customerId));
		record.set(1,new Integer(pkey.proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteHistoryCustomer_44a753d1)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getProposalId()));
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getCustomerListNo());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getLegacyCustomerNo());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getSapCustomerNo());
		}
		if(instanceExtension.isDirty(5))
		{
			record.set(5,concreteBean.getSapCustomerName());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getBillToPartyNo());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getBillToPartyName());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getPayerNo());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getPayerName());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getShipToPartyNo());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getShipToPartyName());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getPlanStartDate());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getPlanEndDate());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(14,concreteBean.getLastUpdatedDate());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(15,concreteBean.getPayerLNo());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(16,concreteBean.getBillToPartyLNo());
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(17,concreteBean.getShipToPartyLNo());
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(18,concreteBean.getCustomerASNo());
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(19,concreteBean.getBillToPartyASNo());
		}
		if(instanceExtension.isDirty(21))
		{
			record.set(20,concreteBean.getPayerASNo());
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(21,concreteBean.getShipToPartyASNo());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
