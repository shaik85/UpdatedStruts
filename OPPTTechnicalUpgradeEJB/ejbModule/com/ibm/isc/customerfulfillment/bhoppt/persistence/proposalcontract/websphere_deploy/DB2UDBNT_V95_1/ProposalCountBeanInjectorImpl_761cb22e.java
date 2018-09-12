package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ProposalCountBeanInjectorImpl_761cb22e
 */
public class ProposalCountBeanInjectorImpl_761cb22e implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ProposalCountBeanInjector_761cb22e {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e)cb;
		record.set(0,new Integer(concreteBean.getProposalCount()));
		record.set(1,concreteBean.getSalesOrg());
		record.set(2,concreteBean.getProposalContent());
		record.set(3,concreteBean.getCustomerName());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e)cb;
		record.set(0,new Integer(concreteBean.getProposalCount()));
		record.set(1,concreteBean.getSalesOrg());
		record.set(2,concreteBean.getProposalContent());
		record.set(3,concreteBean.getCustomerName());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e)cb;
		record.set(1,concreteBean.getSalesOrg());
		record.set(2,concreteBean.getProposalContent());
		record.set(3,concreteBean.getCustomerName());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey)pkeyObject;
		record.set(0,pkey.salesOrg);
		record.set(1,pkey.proposalContent);
		record.set(2,pkey.customerName);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e)cb;
		record.set(0,concreteBean.getSalesOrg());
		record.set(1,concreteBean.getProposalContent());
		record.set(2,concreteBean.getCustomerName());
		record.set(3,new Integer(concreteBean.getProposalCount()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		if(instanceExtension.isDirty(0))
		{
			record.set(0,new Integer(concreteBean.getProposalCount()));
		}
		record.set(1,concreteBean.getSalesOrg());
		record.set(2,concreteBean.getProposalContent());
		record.set(3,concreteBean.getCustomerName());
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
