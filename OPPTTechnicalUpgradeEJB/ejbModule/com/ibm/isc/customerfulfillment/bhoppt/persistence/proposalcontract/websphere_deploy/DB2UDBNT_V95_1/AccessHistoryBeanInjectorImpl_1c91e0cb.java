package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * AccessHistoryBeanInjectorImpl_1c91e0cb
 */
public class AccessHistoryBeanInjectorImpl_1c91e0cb implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.AccessHistoryBeanInjector_1c91e0cb {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getOperationPerformed());
		record.set(2,concreteBean.getAccessDate());
		record.set(3,concreteBean.getAccessTime());
		record.set(4,new Integer(concreteBean.getSeqNo()));
		record.set(5,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb)cb;
		record.set(0,concreteBean.getUserId());
		record.set(1,concreteBean.getOperationPerformed());
		record.set(2,concreteBean.getAccessDate());
		record.set(3,concreteBean.getAccessTime());
		record.set(4,new Integer(concreteBean.getSeqNo()));
		record.set(5,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb)cb;
		record.set(0,concreteBean.getUserId());
		record.set(2,concreteBean.getAccessDate());
		record.set(3,concreteBean.getAccessTime());
		record.set(4,new Integer(concreteBean.getSeqNo()));
		record.set(5,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbFindByProposalID
	 */
	public void ejbFindByProposalID(int proposalID, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalID));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey pkey=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey)pkeyObject;
		record.set(0,new Integer(pkey.proposalId));
		record.set(1,pkey.userId);
		record.set(2,pkey.accessDate);
		record.set(3,pkey.accessTime);
		record.set(4,new Integer(pkey.seqNo));
	}
	/**
	 * ejbFindByProposalIDAndUserID
	 */
	public void ejbFindByProposalIDAndUserID(int proposalId, java.lang.String userId, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(proposalId));
		record.set(1,userId);
	}
	/**
	 * readReadChecking
	 */
	public void readReadChecking(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb)cb;
		record.set(0,new Integer(concreteBean.getProposalId()));
		record.set(1,concreteBean.getUserId());
		record.set(2,concreteBean.getAccessDate());
		record.set(3,concreteBean.getAccessTime());
		record.set(4,new Integer(concreteBean.getSeqNo()));
	}
	/**
	 * ejbPartialStore
	 */
	public void ejbPartialStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb concreteBean=(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteAccessHistory_1c91e0cb)cb;
		com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension  instanceExtension = (com.ibm.ws.ejbpersistence.beanextensions.ConcreteBeanInstanceExtension)concreteBean._WSCB_getInstanceInfo();
		 
		record.set(0,concreteBean.getUserId());
		if(instanceExtension.isDirty(2))
		{
			record.set(1,concreteBean.getOperationPerformed());
		}
		record.set(2,concreteBean.getAccessDate());
		record.set(3,concreteBean.getAccessTime());
		record.set(4,new Integer(concreteBean.getSeqNo()));
		record.set(5,new Integer(concreteBean.getProposalId()));
	}
	/**
	 * ejbStoreGetDirtyColumnFields
	 */
	public void ejbStoreGetDirtyColumnFields(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, boolean[] dirtyBitmap) {
		
	}
}
