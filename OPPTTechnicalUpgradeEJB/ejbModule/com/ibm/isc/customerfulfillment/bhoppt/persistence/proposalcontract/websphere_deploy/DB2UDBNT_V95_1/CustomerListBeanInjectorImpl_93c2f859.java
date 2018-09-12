package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * CustomerListBeanInjectorImpl_93c2f859
 */
public class CustomerListBeanInjectorImpl_93c2f859 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.CustomerListBeanInjector_93c2f859 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getCustomerListNo());
		record.set(2,concreteBean.getCustomerListName());
		record.set(3,concreteBean.getLastUpdatedDate());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getCustomerListNo());
		record.set(2,concreteBean.getCustomerListName());
		record.set(3,concreteBean.getLastUpdatedDate());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getCustomerListNo());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey)pkeyObject;
		record.set(0,new Integer(pkey.proposalId));
		record.set(1,pkey.customerListNo);
	}
	/**
	 * ejbFindByProposalId
	 */
	public void ejbFindByProposalId(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getCustomerListNo());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteCustomerList_93c2f859)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getCustomerListNo());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getCustomerListName());
		}
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getLastUpdatedDate());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
