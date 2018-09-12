package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

/**
 * VarianceDMBeanInjectorImpl_384e6a37
 */
public class VarianceDMBeanInjectorImpl_384e6a37 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.VarianceDMBeanInjector_384e6a37 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,concreteBean.getDmNo());
		record.set(4,concreteBean.getDmDesc());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		record.set(3,concreteBean.getDmNo());
		record.set(4,concreteBean.getDmDesc());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37)cb;
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbFindByProposal
	 */
	public void ejbFindByProposal(int proposalID, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalID));
	}
	/**
	 * ejbFindByDMNo
	 */
	public void ejbFindByDMNo(java.lang.String dmNo, int proposalId, int customerId, javax.resource.cci.IndexedRecord record) {
		record.set(0,dmNo);
		record.set(1,new Integer(proposalId));
		record.set(2,new Integer(customerId));
	}
	/**
	 * ejbFindByCustomer
	 */
	public void ejbFindByCustomer(int proposalId, int customerId, javax.resource.cci.IndexedRecord record) {
		record.set(1,new Integer(proposalId));
		record.set(0,new Integer(customerId));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey)pkeyObject;
		record.set(0,new Integer(pkey.dmId));
		record.set(1,new Integer(pkey.customerId));
		record.set(2,new Integer(pkey.proposalId));
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37)cb;
		record.set(0,new Integer(concreteBean.getDmId()));
		record.set(1,new Integer(concreteBean.getCustomerId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.ConcreteVarianceDM_384e6a37)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getCustomerId()));
		record.set(1,new Integer(concreteBean.getDmId()));
		record.set(2,new Integer(concreteBean.getProposalId()));
		if(instanceExtension.isDirty(3))
		{
			record.set(3,concreteBean.getDmNo());
		}
		if(instanceExtension.isDirty(4))
		{
			record.set(4,concreteBean.getDmDesc());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
