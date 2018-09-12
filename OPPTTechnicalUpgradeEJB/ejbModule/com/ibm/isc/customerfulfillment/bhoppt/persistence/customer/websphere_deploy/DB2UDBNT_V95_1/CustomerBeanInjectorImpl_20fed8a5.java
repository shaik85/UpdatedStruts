package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1;

/**
 * CustomerBeanInjectorImpl_20fed8a5
 */
public class CustomerBeanInjectorImpl_20fed8a5 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.CustomerBeanInjector_20fed8a5 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,concreteBean.getCustomerListNo());
		record.set(3,concreteBean.getLegacyCustomerNo());
		record.set(4,concreteBean.getSapCustomerNo());
		record.set(5,concreteBean.getBillToPartyNo());
		record.set(6,concreteBean.getBillToPartyName());
		record.set(7,concreteBean.getPayerNo());
		record.set(8,concreteBean.getPayerName());
		record.set(9,concreteBean.getShipToPartyName());
		record.set(10,concreteBean.getShipToPartyNo());
		record.set(11,concreteBean.getPlanStartDate());
		record.set(12,concreteBean.getPlanEndDate());
		record.set(13,concreteBean.getLastUpdatedDate());
		record.set(14,concreteBean.getBillToPartyLNo());
		record.set(15,concreteBean.getPayerLNo());
		record.set(16,concreteBean.getShipToPartyLNo());
		record.set(17,concreteBean.getCustomerASNo());
		record.set(18,concreteBean.getBillToPartyASNo());
		record.set(19,concreteBean.getShipToPartyASNo());
		record.set(20,concreteBean.getPayerASNo());
		record.set(21,concreteBean.getCountryCode());
		record.set(22,concreteBean.getSapCustomerName());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,concreteBean.getCustomerListNo());
		record.set(3,concreteBean.getLegacyCustomerNo());
		record.set(4,concreteBean.getSapCustomerNo());
		record.set(5,concreteBean.getBillToPartyNo());
		record.set(6,concreteBean.getBillToPartyName());
		record.set(7,concreteBean.getPayerNo());
		record.set(8,concreteBean.getPayerName());
		record.set(9,concreteBean.getShipToPartyName());
		record.set(10,concreteBean.getShipToPartyNo());
		record.set(11,concreteBean.getPlanStartDate());
		record.set(12,concreteBean.getPlanEndDate());
		record.set(13,concreteBean.getLastUpdatedDate());
		record.set(14,concreteBean.getBillToPartyLNo());
		record.set(15,concreteBean.getPayerLNo());
		record.set(16,concreteBean.getShipToPartyLNo());
		record.set(17,concreteBean.getCustomerASNo());
		record.set(18,concreteBean.getBillToPartyASNo());
		record.set(19,concreteBean.getShipToPartyASNo());
		record.set(20,concreteBean.getPayerASNo());
		record.set(21,concreteBean.getCountryCode());
		record.set(22,concreteBean.getSapCustomerName());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
	}
	/**
	 * ejbFindByProposalAndCustomerList
	 */
	public void ejbFindByProposalAndCustomerList(int proposalId, java.lang.String customerListNo, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,customerListNo);
	}
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindBySapCustNoAndPlanStartEndDate
	 */
	public void ejbFindBySapCustNoAndPlanStartEndDate(int proposalId, java.lang.String sapCustomerNo, java.sql.Date planStartDate, java.sql.Date planEndDate, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,sapCustomerNo);
		record.set(2,planStartDate);
		record.set(3,planEndDate);
	}
	/**
	 * ejbFindBySapCustNo
	 */
	public void ejbFindBySapCustNo(int proposalId, java.lang.String sapCustomerNo, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,sapCustomerNo);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey)pkeyObject;
		record.set(0,new Integer(pkey.proposalId));
		record.set(1,new Integer(pkey.customerId));
	}
	/**
	 * ejbFindByProposalStartEndDate
	 */
	public void ejbFindByProposalStartEndDate(int proposalId, java.sql.Date planStartDate, java.sql.Date planEndDate, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,planStartDate);
		record.set(2,planEndDate);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.ConcreteCustomer_20fed8a5)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
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
			record.set(5,concreteBean.getBillToPartyNo());
		}
		if(instanceExtension.isDirty(6))
		{
			record.set(6,concreteBean.getBillToPartyName());
		}
		if(instanceExtension.isDirty(7))
		{
			record.set(7,concreteBean.getPayerNo());
		}
		if(instanceExtension.isDirty(8))
		{
			record.set(8,concreteBean.getPayerName());
		}
		if(instanceExtension.isDirty(9))
		{
			record.set(9,concreteBean.getShipToPartyName());
		}
		if(instanceExtension.isDirty(10))
		{
			record.set(10,concreteBean.getShipToPartyNo());
		}
		if(instanceExtension.isDirty(11))
		{
			record.set(11,concreteBean.getPlanStartDate());
		}
		if(instanceExtension.isDirty(12))
		{
			record.set(12,concreteBean.getPlanEndDate());
		}
		if(instanceExtension.isDirty(13))
		{
			record.set(13,concreteBean.getLastUpdatedDate());
		}
		if(instanceExtension.isDirty(15))
		{
			record.set(14,concreteBean.getBillToPartyLNo());
		}
		if(instanceExtension.isDirty(14))
		{
			record.set(15,concreteBean.getPayerLNo());
		}
		if(instanceExtension.isDirty(16))
		{
			record.set(16,concreteBean.getShipToPartyLNo());
		}
		if(instanceExtension.isDirty(17))
		{
			record.set(17,concreteBean.getCustomerASNo());
		}
		if(instanceExtension.isDirty(18))
		{
			record.set(18,concreteBean.getBillToPartyASNo());
		}
		if(instanceExtension.isDirty(19))
		{
			record.set(19,concreteBean.getShipToPartyASNo());
		}
		if(instanceExtension.isDirty(20))
		{
			record.set(20,concreteBean.getPayerASNo());
		}
		if(instanceExtension.isDirty(22))
		{
			record.set(21,concreteBean.getCountryCode());
		}
		if(instanceExtension.isDirty(21))
		{
			record.set(22,concreteBean.getSapCustomerName());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
