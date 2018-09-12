package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * SharingBeanInjectorImpl_a437b4b5
 */
public class SharingBeanInjectorImpl_a437b4b5 implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.SharingBeanInjector_a437b4b5 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getAccessTo());
		record.set(2,concreteBean.getAccessType());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getAccessTo());
		record.set(2,concreteBean.getAccessType());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getAccessTo());
	}
	/**
	 * ejbFindByProposalId
	 */
	public void ejbFindByProposalId(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindByUser
	 */
	public void ejbFindByUser(java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,userId);
	}
	/**
	 * ejbFindByProposalAndAccess
	 */
	public void ejbFindByProposalAndAccess(int proposalId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey)pkeyObject;
		record.set(0,new Integer(pkey.proposalId));
		record.set(1,pkey.accessTo);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getAccessTo());
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5 concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteSharing_a437b4b5)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getAccessTo());
		if(instanceExtension.isDirty(2))
		{
			record.set(2,concreteBean.getAccessType());
		}
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
